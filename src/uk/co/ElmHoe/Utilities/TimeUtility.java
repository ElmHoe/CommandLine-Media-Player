package uk.co.ElmHoe.Utilities;

import java.time.LocalDateTime;

public class TimeUtility {
	
	public static String getTime(){
		  LocalDateTime now = LocalDateTime.now();
		  int secs1 = now.getSecond();
		  int hours1 = now.getHour();
		  int mins1 = now.getMinute();
		  String sec1 = String.valueOf(secs1);
		  String hour1 = String.valueOf(hours1);
		  String min1 = String.valueOf(mins1);

		  if (secs1 <= 9){
			  sec1 = "0" + sec1;
		  }
		  if (hours1 <= 9){
			  hour1 = "0" + hour1;
		  }
		  if (mins1 <= 9){
			  min1 = "0" + min1;
		  }
		  return hour1 + ":" + min1 + ":" + sec1;

	}

}
