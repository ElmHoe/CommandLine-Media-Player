package uk.co.ElmHoe.MediaTools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import uk.co.ElmHoe.MediaPlayerAPI;

public class Tools {
	
	
	public static String songTitle() {
		
		
		return null;
		
	}
	
	public float getVolume(){
		return MediaPlayerAPI.vol;
	}
	
	public static void onSongEnd() {
		/*
		 * This section is when anything that the media player is playing -
		 * ends. It'll run this section trying to clean up as much as possible
		 * and remain stable.
		 */

		MediaPlayerAPI.filesPlayed.add(MediaPlayerAPI.filesToPlay.get(0));
		MediaPlayerAPI.filesToPlay.remove(0);

		MediaPlayerAPI.mediaPlayer.stop();
		try{
			Play.startPlaying(new File(MediaPlayerAPI.filesToPlay.get(0)));
		}catch(Exception e) {
			try{
				loadDirectories();
				Play.startPlaying(new File(MediaPlayerAPI.filesToPlay.get(0)));
			}catch(Exception e1) {
				System.out.println("No songs are loaded...");
			}
		}

	}

	
	public static void updateTitle(File file) throws UnsupportedTagException, InvalidDataException, IOException {
		/*
		 * This section just changes and updates Titles when a song finishes and
		 * a new song starts.
		 */

		String tempTitle = "";
		try {
			Mp3File song = new Mp3File(file);
			if (song.hasId3v2Tag()) {
				if (!(song.getId3v2Tag().getTitle() == null)) {
					tempTitle = song.getId3v2Tag().getTitle();
				} else {
					//
				}

				if (!(song.getId3v2Tag().getArtist() == null)) {
					tempTitle = tempTitle + "\n" + song.getId3v2Tag().getArtist();
				} else {
					// Do Nothing, if the song doesn't have an artist at this
					// moment, it won't do anything.
				}
			}
		} catch (Exception e) {

		}
		if (tempTitle == "") {
			tempTitle = file.getName().replaceAll(".mp3", "").replaceAll(" - ", "\n");
		}
		// title = tempTitle;
		
		System.out.println("Now Playing: " + tempTitle);
		
		
		/*
		 * This next section is for the up-next section below.
		 */

		String upNext = "";
		for (int i = 1; i < 7; i++) {
			try {
				String songFile = uk.co.ElmHoe.MediaPlayerAPI.filesToPlay.get(i);
				File f = new File(songFile);
				upNext = upNext + f.getName().replaceAll(".mp3", "") + "\n";
			} catch (Exception e) {
			}
		}
		System.out.println("Next in queue: " + upNext);
	}

	
	public static void loadDirectories() {
		/*
		 * This section contains the default directories to check and/or load
		 * songs from. Also includes duplicate checking - if a song has the same
		 * value and size, it'll not load.
		 */

		ArrayList<String> Directories = new ArrayList<String>();
		Directories.add(System.getProperty("user.dir") + "\\resources\\");
		Directories.add("D:\\Music\\");
		Directories.add("C:\\Users\\" + System.getProperty("user.name") + "\\Music\\");
		Directories.add("D:\\Music\\Pandora\\");
		for (int i = 0; i < Directories.size(); i++) {
			try {
				checkDir(Directories.get(i));
			} catch (Exception e) {

			}
		}
	}

	
	
	public static void checkDir(String dir) throws IOException {
		File folder = new File(dir);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().endsWith(".mp3")) {
					MediaPlayerAPI.filesToPlay.add(dir + listOfFiles[i].getName());
					System.out.println("Loading song... " + dir + listOfFiles[i].getName());
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}


}
