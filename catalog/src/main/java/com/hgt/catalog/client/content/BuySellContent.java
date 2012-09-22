package com.hgt.catalog.client.content;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class BuySellContent extends Content{
	
	public BuySellContent(){
		Button buyButton = new Button("Buy");
		Button sellButton = new Button("Sell");
		
		HorizontalPanel panel = new HorizontalPanel();
		panel.add(buyButton);
		panel.add(sellButton);
		
		initWidget(panel);
	}

}
