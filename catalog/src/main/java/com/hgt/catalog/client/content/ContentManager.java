package com.hgt.catalog.client.content;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * This manager replaces content on the #content div.
 * 
 * @author Justin Bangerter
 */
public class ContentManager {

	/** Holds the singleton instance */
	private static ContentManager INSTANCE;

	/**
	 * Singleton accessor
	 * 
	 * @return an instance
	 */
	public static ContentManager get() {
		if (INSTANCE == null) {
			// would use thread safe pattern, but JavaScript doesn't support it
			INSTANCE = new ContentManager();
		}
		return INSTANCE;
	}

	/**
	 * Replace the content in the content div with the given page
	 * 
	 * @param content the page that will be inserted into the content div
	 */
	public void setContent(Content content) {
		RootPanel contentDiv = RootPanel.get("content");
		contentDiv.clear();
		contentDiv.add(content);
	}
}
