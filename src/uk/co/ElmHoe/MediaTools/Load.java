package uk.co.ElmHoe.MediaTools;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

import javafx.embed.swing.JFXPanel;
import uk.co.ElmHoe.MediaPlayerAPI;
import uk.co.ElmHoe.Utilities.ThreadUtility;
import uk.co.ElmHoe.Utilities.UsageUtility;

/*
 * This class, is the class used for everything needed when the application starts.
 */
public class Load {
	
public static Load plugin;
public static JFXPanel fxPanel;


	public static Load get(){
		return plugin;
	}
	
	public static void onLoad(){
		//These two MUST come first onLoad.
		if (!startThread())
		{
			System.out.println("Unable to start a thread - note this is required for the music player.");
			System.exit(0);
		}
		onFirstRun();
		
		//UsageLogging
		UsageUtility.logUpdate();

	
		//Listen for messages (MUST COME LAST!)
		ThreadUtility.s = new Scanner(new InputStreamReader(System.in));
		ThreadUtility.msgUpdate();
		

	}
	
	private static boolean startThread(){
		try{
			fxPanel = new JFXPanel();
			return true;
		}catch(NullPointerException e){
			return false;
		}
	}
	
	
	public static void onFirstRun() {
		Tools.loadDirectories();
		Collections.shuffle(MediaPlayerAPI.filesToPlay);
		Play.startPlaying(new File(MediaPlayerAPI.filesToPlay.get(0)));
	}
}
