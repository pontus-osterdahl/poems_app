package com.example.poems_app.xml;

public class ObjectDescription {

	private SupportDescription supportDescription;
	private LayoutDescription layoutDescription;
	
	public void setSupportDescription(SupportDescription supportDescription) {
		this.supportDescription = supportDescription;
	}
	
	public SupportDescription getSupportDescription() {
		return this.supportDescription;
	}

	public LayoutDescription getLayoutDescription() {
		return layoutDescription;
	}

	public void setLayoutDescription(LayoutDescription layoutDescription) {
		this.layoutDescription = layoutDescription;
	}
	
	/**
	 *     <supportDesc>
        <support>Paper</support>
        <extent>II + 108 (+ 6a, 95a)
            <dimensions>
                <height>200</height>
                <width>135</width>
            </dimensions>
        </extent>
    </supportDesc>
	 */
	
}
