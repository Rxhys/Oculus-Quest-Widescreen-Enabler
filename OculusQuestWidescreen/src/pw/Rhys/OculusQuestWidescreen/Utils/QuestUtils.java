package pw.Rhys.OculusQuestWidescreen.Utils;

import java.io.IOException;

import pw.Rhys.OculusQuestWidescreen.ADB.Devices;
import pw.Rhys.OculusQuestWidescreen.Device.Device;

public class QuestUtils {
	public static int questCount = 0;
	public static boolean multipleQuest = false; 
	
	private static QuestUtils instance;
	
	public QuestUtils() {
		instance = this;
	}
	
	public static QuestUtils getInstance() { 
		return instance;
	}
	
	public void checkForQuest() { 
		try {
			for (Device devices : Devices.getDevices()) {
				if (devices.getIsQuest()) {
					questCount++;
					System.out.println("Quest found (" + questCount + ")");
					if (questCount > 1) {
						multipleQuest = true;
					}
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
