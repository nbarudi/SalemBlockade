package me.nbarudi.files.gameevents;

import org.bukkit.Bukkit;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.InfoManager;

public class Day {
	public static int task = 0;
	public static double i = 0;
	public static void triggerDay1() {
		TownOfSalem.DayNumber = 1;
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
			public void run() {
				if(i >= 1) {
					i = 0;
					Bukkit.getScheduler().cancelTask(task);
					Night.triggerNextNight();
				}else {
					InfoManager.setBossBar("Day 1: Your Hellos.", i);
					i = i + 0.01;
				}
			}
		}, 20, 3);
	}
	
	public static void triggerNextDay() {
		TownOfSalem.DayNumber++;
		if (!checkForWin())
		{
			task = Bukkit.getScheduler().scheduleSyncRepeatingTask(TownOfSalem.instance, new Runnable() {
				public void run() {
					if(i >= 1) {
						i = 0;
						Bukkit.getScheduler().cancelTask(task);
						//Trigger Voting
						Voting.triggerVoting(task);
					} else {
							InfoManager.setBossBar("Day §b" + TownOfSalem.DayNumber+ "§r: Discussion.", i);
							i = i + 0.01;
					}
				}
			}, 20, 9);
		} else {
			//To-do: Add code to end game
		}
	}

	public static boolean checkForWin(){

		

		return false;
	}

}
