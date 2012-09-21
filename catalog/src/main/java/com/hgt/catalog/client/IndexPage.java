package com.hgt.catalog.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;

public class IndexPage implements EntryPoint {

	private VerticalPanel mainPanel;
	private Button buyButton;
	private Button sellButton;
	
	public IndexPage() {
		mainPanel = new VerticalPanel();
		buyButton = new Button("Buy");
		sellButton = new Button("Sell");
	}

	/**
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		// remove Loading-Message from page
		Element loadingMsg = DOM.getElementById("LoadingMessage");
		RootPanel.getBodyElement().removeChild(loadingMsg);
		
		mainPanel.add(buyButton);
		mainPanel.add(sellButton);
		
		RootPanel.get("content").add(mainPanel);
	}
}
