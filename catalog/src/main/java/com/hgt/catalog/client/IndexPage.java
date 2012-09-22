package com.hgt.catalog.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hgt.catalog.client.content.BuySellContent;
import com.hgt.catalog.client.widgets.NavigationBar;
import com.hgt.catalog.client.widgets.NavigationButton;

/**
 * The main entry point for the application
 * 
 * @author Justin Bangerter
 */
public class IndexPage implements EntryPoint {
	

	private static List<NavigationButton> navButtons = Arrays.asList( //
			new NavigationButton(IconData.GrayableIcon.TOMATO, "Fresh Produce",
					new BuySellContent()),//
			new NavigationButton(IconData.GrayableIcon.USERS, "Profile", new BuySellContent()),//
			new NavigationButton(IconData.GrayableIcon.MAP, "See Local Results",
					new BuySellContent()),//
			new NavigationButton(IconData.GrayableIcon.FACEBOOK_BOX_BLUE, "Login with Facebook",
					new BuySellContent()),//
			new NavigationButton(IconData.GrayableIcon.EMAIL, "Subscribe", new BuySellContent()),//
			new NavigationButton(IconData.GrayableIcon.RSS, "Subscribe", new BuySellContent())//
			);

	/**
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {

		// remove Loading-Message from page
		Element loadingMsg = DOM.getElementById("LoadingMessage");
		RootPanel.getBodyElement().removeChild(loadingMsg);

		// Add it to the root panel.
		RootPanel nav = RootPanel.get("navigation");
		nav.clear();
		nav.add(new NavigationBar(new VerticalPanel(), navButtons));

	}
}
