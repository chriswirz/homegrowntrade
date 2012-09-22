package com.hgt.catalog.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.hgt.catalog.client.IconData.GrayableIcon;
import com.hgt.catalog.client.content.Content;
import com.hgt.catalog.client.content.ContentManager;

/**
 * Provides navigation functionality
 * 
 * @author Justin Bangerter
 */
public class NavigationButton extends Composite {

	private final GrayableIcon icon;
	private final String caption;
	private final Content target;
	private boolean isActive;
	private Image image;
	private NavigationBar navBar;

	/**
	 * Create a navigation button
	 * 
	 * @param icon the grayable icon for this button
	 * @param caption its caption
	 * @param target the content that will be loaded into the content div
	 * @param navBar the parent nav bar for this button
	 */
	public NavigationButton(GrayableIcon icon, String caption, Content target) {

		// initialize fields
		this.icon = icon;
		this.caption = caption;
		this.target = target;
		this.isActive = false;

		// initialize
		Panel panel = getPanel(true);
		this.initWidget(panel);
	}

	/**
	 * Activate or deactivate this button
	 * 
	 * @param isActive
	 */
	public void setActive(boolean isActive) {
		setActive(isActive, false);
	}

	/**
	 * Activate or deactivate the button
	 * 
	 * @param isActive
	 */
	public void setActive(boolean isActive, boolean ignoreContent) {
		// ignore this when there is no change
		if (this.isActive == isActive) {
			return;
		}

		// if we are enabling this nav button, move to the target
		if (isActive && !ignoreContent) {
			ContentManager.get().setContent(this.target);
		}

		updateImage(isActive, false);

		// update the field
		this.isActive = isActive;
	}

	/**
	 * Tell this button who its parent is.
	 * 
	 * @param navBar the parent of this navigation button
	 */
	public void setNavigationBar(NavigationBar navBar) {
		this.navBar = navBar;
	}

	/**
	 * Update the image
	 * 
	 * @param isActive true if trying to activate the image
	 * @param checkState if true, the image can only be deactivated if the link
	 *            is not active
	 */
	private void updateImage(boolean isActive, boolean checkState) {
		// if we need to check the state of the link first,
		if (checkState && this.isActive) {
			// if we care about the link's state
			// and the link is active
			// use the active image
			image.setUrl(icon.getPath(false));
		}
		else {
			image.setUrl(icon.getPath(!isActive));
		}
	}

	/**
	 * Get a panel that will be used to generate the content for the button.
	 * 
	 * @param isGray
	 * @return
	 */
	private Panel getPanel(boolean isGray) {
		FlowPanel panel = new FlowPanel();
		this.image = this.icon.getImage(isGray);
		image.setStyleName("navigation_image");
		panel.add(image);
		panel.add(new Label(this.caption));

		// define handlers
		FocusPanel focusPanel = new FocusPanel(panel);
		focusPanel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (navBar != null) {
					navBar.deactivateButtons();
				}
				setActive(true);
			}
		});
		focusPanel.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				updateImage(true, true);
			}
		});
		focusPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				updateImage(false, true);
			}
		});

		// set styles
		focusPanel.setStyleName("navigation_button");

		return focusPanel;
	}

}
