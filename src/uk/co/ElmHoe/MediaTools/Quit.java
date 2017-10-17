package uk.co.ElmHoe.MediaTools;

import uk.co.ElmHoe.Utilities.ThreadUtility;

public class Quit {

	/*
	 * What needs to be done when closing the application.
	 */
	
	//Lets close the scanner.
	public static void exitApp() {
		ThreadUtility.s.close();
		System.exit(0);
	}
}
