package me.nbarudi.files.gameevents;

import org.bukkit.Bukkit;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.InfoManager;

public class Night {
	public static boolean countdown = false;
	public static int task = 0;
	public static double i = 0;
	public static void triggerNextNight() {
		TownOfSalem.isNight = true;
		TownOfSalem.NightNumber++;
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Day.triggerNextDay();
					Bukkit.getScheduler().cancelTask(task);
					countdown = false;
					TownOfSalem.isNight = false;
				}else {
					if(!countdown) {
						InfoManager.setBossBar("Night §b "+ TownOfSalem.NightNumber +"§r.", 1 - i);
					}
					else {
						InfoManager.setBossBar("Night §b "+ TownOfSalem.NightNumber +"§r.", 1 - i);
						i = i + 0.01;
					}
				}
			}
		}, 100, 6);
		
	}

}
