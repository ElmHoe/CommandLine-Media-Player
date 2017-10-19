package uk.co.ElmHoe.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class UsageUtility {
	public static UsageUtility plugin;

	public UsageUtility get(){
		return plugin;
	}
	
    public static String usageUpdate(){
    	Runtime runtime = Runtime.getRuntime();
    	String memoryUsage = String.valueOf((runtime.totalMemory() - runtime.freeMemory()) / (1024*1024));
    	return memoryUsage;
    }
    
    public static void logUpdate() {
    	new Timer(5000,new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent ae) {

    			System.out.println(TimeUtility.getTime() + " : " + usageUpdate() + "/mb" + " out of maximum of: " + (Runtime.getRuntime().totalMemory() / (1024*1024)) + "/mb");
    		}
    	}).start();
    }
}
