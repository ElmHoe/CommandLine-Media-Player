package uk.co.ElmHoe.MediaTools;

import java.io.File;

import uk.co.ElmHoe.MediaPlayerAPI;

public class Back {
	public static void onBack() {
		/*
		 * This section is when the player wants to back a song - it'll load the
		 * last song played if any were played.
		 */
		if (MediaPlayerAPI.filesPlayed.size() > 0) {
			MediaPlayerAPI.mediaPlayer.stop();
			Play.startPlaying(new File(MediaPlayerAPI.filesPlayed.get(0)));
		} else {
			System.out.println("Nothing to go back to? Perhaps skip or shuffle?");
		}
	}

}
