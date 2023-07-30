package com.example.poems_app.services;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.poems_app.BibItem;
import com.example.poems_app.repositories.BibItemRepository;
import com.example.poems_app.xml.Additional;
import com.example.poems_app.xml.BiblPointer;
import com.example.poems_app.xml.FileDesc;
import com.example.poems_app.xml.History;
import com.example.poems_app.xml.Layout;
import com.example.poems_app.xml.LayoutDescription;
import com.example.poems_app.xml.Locus;
import com.example.poems_app.xml.ManuscriptDescription;
import com.example.poems_app.xml.MsIdentifier;
import com.example.poems_app.xml.MsItemStruct;
import com.example.poems_app.xml.ObjectDescription;
import com.example.poems_app.xml.PhysDescription;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.SourceDescription;
import com.example.poems_app.xml.SupportDescription;
import com.example.poems_app.xml.TeiHeader;
import com.example.poems_app.xml.TitleStatement;

@Service
public class TeiHeaderExtractor {

	@Autowired
	BibItemService bibItemService;

	private PhysDescription extractPhysDesc(NodeList nl) {
		PhysDescription physDesc = new PhysDescription();
		for (int i = 0; i < nl.getLength(); i++) {
			Node objectDesc = nl.item(i);
			if (objectDesc.getLocalName().equals("objectDesc")) {
				ObjectDescription objDesc = new ObjectDescription();
				NodeList objectDescChildren = objectDesc.getChildNodes();
				for (int y = 0; y < objectDescChildren.getLength(); y++) {
					Node item = objectDescChildren.item(y);
					if (item.getLocalName().equals("supportDesc")) {
						SupportDescription supportDesc = new SupportDescription();
						NodeList supportDescChildren = item.getChildNodes();
						String support = "";
						String extent = "";
						for (int a = 0; a < supportDescChildren.getLength(); a++) {
							Node supportDescItem = supportDescChildren.item(a);
							if (supportDescItem.getLocalName().equals("support")) {
								support = supportDescItem.getTextContent();
							} else if (supportDescItem.getLocalName().equals("extent")) {
								extent = supportDescItem.getTextContent();
								// TODO ensure that dimensions are handled
							}
						}
						supportDesc.setExtent(extent);
						supportDesc.setSupport(support);
						objDesc.setSupportDescription(supportDesc);

					} else if (item.getLocalName().equals("layoutDesc")) {
						LayoutDescription layoutDesc = new LayoutDescription();
						NodeList nl1 = item.getChildNodes();
						for (int x = 0; x < nl1.getLength(); x++) {
							if (nl1.item(x).getLocalName().equals("layout")) {
								Node layoutItem = nl1.item(x);
								int columns = Integer
										.parseInt(layoutItem.getAttributes().getNamedItem("columns").getTextContent());
								int ruledLines = Integer.parseInt(
										layoutItem.getAttributes().getNamedItem("ruledLines").getTextContent());
								String content = layoutItem.getTextContent();
								Layout layout = new Layout(columns, ruledLines, content);
								layoutDesc.setLayout(layout);
							}
						}
						objDesc.setLayoutDescription(layoutDesc);
					}
				}
				physDesc.setObjectDescription(objDesc);
			}
		}
		return physDesc;
	}

	private Additional extractAdditional(Node addNode) {
		Additional additional = new Additional();
		Node listBibl = addNode.getFirstChild();
		NodeList bibls = listBibl.getChildNodes();
		List<BiblPointer> biblPointers = new ArrayList<BiblPointer>();
		for (int i = 0; i < bibls.getLength(); i++) {
			if (bibls.item(0).getLocalName().equals("bibl")) {
				String target = "";
				String biblScope = "";
				NodeList biblValues = bibls.item(0).getChildNodes();
				for (int y = 0; y < biblValues.getLength(); y++) {
					Node n = biblValues.item(y);
					if (n.getLocalName().equals("ptr")) {
						target = n.getAttributes().getNamedItem("target").getTextContent();
					} else if (n.getLocalName().equals("biblScope")) {
						biblScope = n.getTextContent();
					}
				}
				BibItem bibItem = bibItemService.getByIdentifier(target).orElseThrow();
				BiblPointer biblPointer = new BiblPointer(bibItem, biblScope);
				biblPointers.add(biblPointer);
			}
		}

		additional.setBiblPointers(biblPointers);
		return additional;
	}

	private History extractHistory(NodeList nl) {
		History hist = new History();
		for (int i = 0; i < nl.getLength(); i++) {
			Node item = nl.item(i);
			String localName = item.getLocalName();
			String textContent = item.getTextContent();
			if (localName.equals("origin")) {
				hist.setOrigin(textContent);
			} else if (localName.equals("provenance")) {
				hist.setProvenance(textContent);
			}
		}

		return hist;

	}

	private MsItemStruct extractMsItemStruct(NodeList nl) {
		Locus locus = new Locus();
		String author = "";
		String title = "";
		String note = "";
		String textLang = "";

		for (int i = 0; i < nl.getLength(); i++) {
			Node item = nl.item(i);
			String localName = item.getLocalName();
			String textContent = item.getTextContent();
			if (localName.equals("locus")) {
				String from = item.getAttributes().getNamedItem("from").getTextContent();
				String to = item.getAttributes().getNamedItem("to").getTextContent();
				locus.setContent(textContent);
				locus.setFrom(from);
				locus.setTo(to);
			} else if (localName.equals("author")) {
				author = textContent;
			} else if (localName.equals("title")) {
				title = textContent;
			} else if (localName.equals("note")) {
				note = textContent;
			} else if (localName.equals("textLang")) {
				textLang = textContent;
			}
		}
		return new MsItemStruct(locus, author, title, note, textLang);
	}

	public TeiHeader getTeiHeader(Document doc, NodeList cis) {
		TeiHeader teiHeader = new TeiHeader();
		XPath xPath = XPathFactory.newInstance().newXPath();

		for (int i = 0; i < cis.getLength(); i++) {
			NodeList fileDescription = doc.getElementsByTagName("fileDesc");
			NodeList fileDescriptionChildren = fileDescription.item(0).getChildNodes();
			FileDesc fileDesc = new FileDesc();

			for (int y = 0; y < fileDescriptionChildren.getLength(); y++) {
				Node item = fileDescriptionChildren.item(y);
				String localName = item.getLocalName();

				if ("titleStmt".equals(localName)) {
					TitleStatement titleStmt = new TitleStatement();
					NodeList titleChildNodes = item.getChildNodes();

					for (int x = 0; x < titleChildNodes.getLength(); x++) {
						if (titleChildNodes.item(x).getLocalName().equals("title")) {
							String title = titleChildNodes.item(x).getTextContent();
							titleStmt.setTitle(title);
							break;
						}
					}
					fileDesc.setTitleStatement(titleStmt);
				}

				else if ("publicationStmt".equals(localName)) {
					fileDesc.setPublicationStatement(item.getTextContent());
				}
				else if ("sourceDesc".equals(localName)) {
					SourceDescription sourceDesc = new SourceDescription();
					Node n = item.getFirstChild();
					if (n.getLocalName().equals("msDesc")) {
						NodeList msDescNodes = n.getChildNodes();
						ManuscriptDescription msDesc = new ManuscriptDescription();
						for (int a = 0; a < msDescNodes.getLength(); a++) {
							Node tmpNode = msDescNodes.item(a);
							if (tmpNode.getLocalName().equals("msIdentifier")) {
								NodeList msIdentifierNodes = tmpNode.getChildNodes();
								MsIdentifier ms = new MsIdentifier();
								for (int b = 0; b < msIdentifierNodes.getLength(); b++) {
									Node msIdentifierNode = msIdentifierNodes.item(b);
									String name = msIdentifierNode.getLocalName();
									String textContent = msIdentifierNode.getTextContent();
									if ("country".equals(name)) {
										ms.setCountry(textContent);
									} else if (("settlement").equals(name)) {
										ms.setSettlement(textContent);
									} else if (("repository").equals(name)) {
										ms.setRepository(textContent);
									} else if (("idno").equals(name)) {
										ms.setIdno(textContent);
									}
								}
								msDesc.setMsIdentifier(ms);
							} else if (tmpNode.getLocalName().equals("msContents")) {
								List<MsItemStruct> itemStructs = new ArrayList<MsItemStruct>();
								NodeList msIdentifierNodes = tmpNode.getChildNodes();
								for (int b = 0; b < msIdentifierNodes.getLength(); b++) {
									Node msContentNode = msIdentifierNodes.item(b);
									String name = msContentNode.getLocalName();
									if ("msItemStruct".equals(name)) {
										MsItemStruct itemStruct = extractMsItemStruct(msContentNode.getChildNodes());
										itemStructs.add(itemStruct);
									}
								}
								msDesc.setMsContent(itemStructs);
							} else if (tmpNode.getLocalName().equals("physDesc")) {
								PhysDescription physDesc = extractPhysDesc(tmpNode.getChildNodes());
								msDesc.setPhysicalDescription(physDesc);
							} else if (tmpNode.getLocalName().equals("history")) {
								History history = extractHistory(tmpNode.getChildNodes());
								msDesc.setHistory(history);
							} else if (tmpNode.getLocalName().equals("additional")) {
								Additional additional = extractAdditional(tmpNode);
								msDesc.setAdditional(additional);
							}
						}
						sourceDesc.setManusciptDescription(msDesc);
					}
					fileDesc.setSourceDescription(sourceDesc);
				}
				teiHeader.setFileDescription(fileDesc);
			}
		}
		return teiHeader;
	}
}
