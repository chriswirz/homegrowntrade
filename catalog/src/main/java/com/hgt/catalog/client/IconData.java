package com.hgt.catalog.client;

import com.google.gwt.user.client.ui.Image;

/**
 * To keep the icon references in once place
 * 
 * @author Justin Bangerter
 */
public interface IconData {

	public String LOCATION = "img/";
	public String APP_ICON = "AppIcon.png";
	public String GLYPHS = "glyphicons-halflings.png";
	public String GLYPHS_WHITE = "glyphicons-halflings-white.png";
	public String LOGO = "Homegrown-trade-logo.png";
	public String VEGETABLES = "vegetables.jpg";
	public String VEGETABLES2 = "vegetables2.jpg";
	public String WAITING = "waiting.gif";

	/**
	 * All of the icons that have gray counterparts are defined here.
	 * 
	 * @author Justin Bangerter
	 */
	public enum GrayableIcon {
		APP_SHARE_MANAGER("App-share-manager-icon", ".png"), //
		EMAIL("e-mail-2-icon", ".png"), //
		MAP("Map-icon", ".png"), //
		RSS("RSS-icon", ".png"), //
		FACEBOOK_BOX_BLUE("social-facebook-box-blue-icon", ".png"), //
		TOMATO("Tomato-icon", ".png"), //
		USERS("Users-icon", ".png"), //
		;

		private static String GRAY = "_gray";
		private String title;
		private String suffix;

		GrayableIcon(String title, String suffix) {
			this.title = title;
			this.suffix = suffix;
		}

		/**
		 * Get the path to this image
		 * 
		 * @param gray true if the icon should be gray
		 * @return
		 */
		public String getPath(boolean gray) {
			StringBuilder s = new StringBuilder();
			s.append(LOCATION);
			s.append(title);
			s.append((gray ? GRAY : ""));
			s.append(suffix);
			return s.toString();
		}
		
		/**
		 * Get the image for this icon
		 * 
		 * @param gray
		 * @return
		 */
		public Image getImage(boolean gray){
			return new Image(getPath(gray));
		}
	}

}