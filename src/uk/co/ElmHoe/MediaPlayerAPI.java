package uk.co.ElmHoe;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.media.MediaPlayer;
import uk.co.ElmHoe.MediaTools.*;

public class MediaPlayerAPI {

	static boolean toolkit = false;
	public static MediaPlayer mediaPlayer;
	public static float vol = (float) 0.50;
	public static ArrayList<String> filesToPlay = new ArrayList<String>();
	public static ArrayList<String> filesPlayed = new ArrayList<String>();
	public static String titleOfSong = "";
	
	
	
	public static void main(String[] args) throws IOException {
		Load.onLoad();
	}

	/*
	 * This plays a new song. Checks if anything else was playing, cancels them,
	 * continues to play this.
	 */


	public void onNextSong() {

	}

	public static void onShuffle() {
		/*
		 * This is when the player presses shuffle - it'll shuffle their
		 * playlist for them. Only for this session though, after end of the
		 * session, playlist will be reverted.
		 */
	}

	public static void onSavePlaylist() {
		/*
		 * This section would be when a user creates a playlist - to be setup
		 * and changed with the GUI down the line.
		 */
	}

	public static void onLoadPlaylist() {
		/*
		 * This checks the SQL database for any playlists the user has - all
		 * song will need to be on the PC Still. but if they save a playlist and
		 * keep the song in the same directory, it'll load playlists.
		 */
	}




}
