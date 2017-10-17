package uk.co.ElmHoe.MediaTools;

public class Skip {

	public static void onSkip() {
		if (uk.co.ElmHoe.MediaPlayerAPI.mediaPlayer.getStatus().equals(javafx.scene.media.MediaPlayer.Status.PLAYING)) {
			Tools.onSongEnd();
		}else {
			try {
				uk.co.ElmHoe.MediaPlayerAPI.mediaPlayer.stop();
				Play.startPlaying(new java.io.File(uk.co.ElmHoe.MediaPlayerAPI.filesToPlay.get(0)));
			}catch(Exception e) {
			
			}
		}
	}
}
