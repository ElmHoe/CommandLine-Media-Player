package uk.co.ElmHoe.MediaTools;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uk.co.ElmHoe.MediaPlayerAPI;
import uk.co.ElmHoe.Utilities.ThreadUtility.Commands;

public class Play {

	
	public static boolean startPlaying(File file){
		
		
		String filePath = file.getAbsolutePath();
		URI format = new File(filePath).toURI();
		Media hit = new Media(format.toString());
		
		
		MediaPlayerAPI.mediaPlayer = new MediaPlayer(hit);
		MediaPlayerAPI.mediaPlayer.play();
		
		VolumeUpdate.updateVolumeFloat((float)MediaPlayerAPI.vol);

		try {
			Tools.updateTitle(file);
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			e.printStackTrace();
		}
		

		MediaPlayerAPI.mediaPlayer.setOnEndOfMedia(new Runnable() {
		    @Override
		    public void run() {
				Tools.onSongEnd();
				

		    }
		});

		return true;
	}
	
	
	public static int playAndPause(String p) {
		try{
			if (MediaPlayerAPI.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
				if (p.equals(Commands.CMD_PAUSE.valueToString())) {
					uk.co.ElmHoe.MediaPlayerAPI.mediaPlayer.pause();
					return 2;
				}else if (p.equals(Commands.CMD_PLAY.valueToString())) {
					return 0;
				}
				return 0;
			} else {
				if (p.equals(Commands.CMD_PAUSE.valueToString())) {
					return 0;
				} else if (p.equals(Commands.CMD_PLAY.valueToString())) { 
					uk.co.ElmHoe.MediaPlayerAPI.mediaPlayer.play();
					return 1;
				}
				return 0;
			}
		}catch(Exception e) {
			System.out.println(MediaPlayerAPI.mediaPlayer.getStatus().toString());
			return 0;
		}
	}
}
