package uk.co.ElmHoe.Utilities;

import java.io.IOException;
import java.util.Scanner;

import uk.co.ElmHoe.MediaTools.Quit;
import uk.co.ElmHoe.MediaTools.Tools;
import uk.co.ElmHoe.MediaTools.VolumeUpdate;

public class ThreadUtility {
public static Scanner s;


	/*
	 * The listener. 
	 */

	public static void msgUpdate() {
/*		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					checkForNewMsg();
				} catch (IOException e) {
				}
			}
		};
		
		timer.schedule(task, new Date(), 100);
*/
		try {
			checkForNewMsg(s.nextLine());
		} catch (IOException e) {}
	}

	public enum Commands{
		CMD_QUIT("QUIT"),
		CMD_SKIP("SKIP"),
		CMD_PLAY("PLAY"),
		CMD_PAUSE("PAUSE"),
		CMD_STOP("STOP"),
		CMD_SHUFFLE("SHUFFLE"),
		CMD_VOLUME("VOLUME"),
		CMD_REPEAT("REPEAT"),
		CMD_BACK("BACK")
		;
		
		private final String command;
        
        private Commands(String command) {
            this.command = command;
        }

        public  String valueToString() {
            return command;
        }

	}


	
	public static void checkForNewMsg(String line) throws IOException {
    	String[] lineSplit = line.toUpperCase().split(" ");

    	if (lineSplit[0].equals(Commands.CMD_SKIP.command)) {
			System.out.println("Skipping...");
			Tools.onSongEnd();
    	}
    	
    	if (lineSplit[0].equals(Commands.CMD_VOLUME.command)) {
			int level;
			try{
				 level = Integer.valueOf(lineSplit[1]);
				 if (VolumeUpdate.updateVolumeInt(level) == 1) {
					 System.out.println("Volume Updated.");
				 }else {
					 System.out.println(MessageUtility.Responses.INVALID_VOLUME.toString());
				 }
			}catch(Exception e){
				System.out.println(MessageUtility.Responses.INVALID_INT_VOLUME.toString());
			}
    	}
    	
    	if (lineSplit[0].equals(Commands.CMD_QUIT.command)) {
    		Quit.exitApp();
    	}
			
    	else {}
    	
		msgUpdate();

 
    }
	
}
