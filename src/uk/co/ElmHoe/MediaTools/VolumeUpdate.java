package uk.co.ElmHoe.MediaTools;

import javafx.scene.media.MediaPlayer;
import uk.co.ElmHoe.MediaPlayerAPI;

public class VolumeUpdate {
	
	
	public static int updateVolumeInt(int vol){
		try{
			if (vol > 100 || vol < 0) {
				return 0;
			}else {
				float newVol = (float)vol / 100;
				MediaPlayerAPI.vol = newVol;
				if (MediaPlayerAPI.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING) == true){
					MediaPlayerAPI.mediaPlayer.setVolume(newVol);
					return 1;
				}else {
					MediaPlayerAPI.mediaPlayer.setVolume(newVol);
					return 1;
				}
			}
		}catch(NullPointerException e){
			System.out.println("Null Pointer Thrown at VolumeUpdate.updateVolume");
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static int updateVolumeFloat(Float vol){
		System.out.println("VOLUME = " + (int)MediaPlayerAPI.vol);
		try{
			MediaPlayerAPI.vol = vol;
			if (MediaPlayerAPI.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING) == true){
				MediaPlayerAPI.mediaPlayer.setVolume(vol);
			}else {
				MediaPlayerAPI.mediaPlayer.setVolume(vol);
				return 1;
			}
			return 1;
		}catch(NullPointerException e){
			System.out.println("Null Pointer Thrown at VolumeUpdate.updateVolume");
			e.printStackTrace();
			return 0;
		}
		
	}

	
	public int getVolume(){
		Float vol = MediaPlayerAPI.vol;
		int volume = Math.round((vol * 100));
		
		return volume;
	}
	
}
