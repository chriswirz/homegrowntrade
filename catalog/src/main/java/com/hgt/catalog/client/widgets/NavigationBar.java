package com.hgt.catalog.client.widgets;

import java.util.List;

import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;

/**
 * A custom navigation bar
 * 
 * @author Justin Bangerter
 */
public class NavigationBar extends Composite {

	private List<NavigationButton> buttons;

	/**
	 * Create a navigation bar in the given panel with the given buttons
	 * 
	 * @param panel
	 * @param buttons
	 */
	public NavigationBar(CellPanel panel, List<NavigationButton> buttons) {
		this.buttons = buttons;
		for (NavigationButton button : buttons) {
			button.setNavigationBar(this);
			panel.add(button);
		}
		initWidget(panel);
	}

	/**
	 * Deactivate all of the buttons in this navbar
	 */
	public void deactivateButtons() {
		for (NavigationButton button : buttons) {
			button.setActive(false);
		}
	}
}
