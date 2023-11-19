import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { XmlPoem } from './xmlpoem';
import { Xmlnameid } from './xmlnameid';
import { Observable } from 'rxjs';
import { SearchType } from './search-type';
import { TeiHeader } from './tei-header';

@Injectable({
  providedIn: 'root'
})
export class XmlpoemService {

  savepoems_url = "http://localhost:8080/save-poem";
  poems_url = "http://localhost:8080/xmlPoem";
  poemnames_url = "http://localhost:8080/xmlPoemNames";
  poemsearch_url = "http://localhost:8080/getXmlPoemByWord";
  poemssearchtypes_url = "http://localhost:8080/getXmlPoemSearchTypes";
  teiheader_url = "http://localhost:8080/xmlPoemTeiHeader";

  constructor(private httpClient : HttpClient) { }

  getXmlPoem(id: number) : Observable<XmlPoem> {
    return this.httpClient.get<XmlPoem>(this.poems_url + "/" + id);
  }

  deleteXmlPoem(id: number) : Observable<XmlPoem>{
    return this.httpClient.delete<XmlPoem>(this.poems_url + "/" + id);
  }

  getXmlNames() : Observable<Xmlnameid[]> {
    return this.httpClient.get<Xmlnameid[]>(this.poemnames_url);
  }

  saveXmlPoem(file : File) : void {
    const formdata = new FormData();
    formdata.append("file", file);
    formdata.append("fileName", file.name);
    this.httpClient.post<XmlPoem>(this.savepoems_url, formdata).subscribe(); 
  }

  getSearchTypes() : Observable<SearchType[]> {
    return this.httpClient.get<SearchType[]>(this.poemssearchtypes_url);
  }

  getPoemsByWord(searchType : SearchType, searchTerm : String) : Observable<XmlPoem[]> {
    return this.httpClient.get<XmlPoem[]>(this.poemsearch_url + "?searchType=" + searchType + "&lemma="  + searchTerm); 
  }

  getTeiHeader(xmlid : Number) : Observable<TeiHeader> {
    return this.httpClient.get<TeiHeader>(this.teiheader_url + "/" + xmlid);
  }

}
