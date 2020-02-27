package me.nbarudi.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.nbarudi.files.gamemodes.Normal.Classic;
import me.nbarudi.gamesystems.AssignRoles;
import me.nbarudi.main.TownOfSalem;

public class ForceStart extends BukkitCommand {

	TownOfSalem pl;
	
	public ForceStart(String name, TownOfSalem pl) {
		super(name);
		this.pl = pl;
		// TODO Auto-generated constructor stub
	}
	public double i = 0;
	int task = 0;

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		AssignRoles.StartGame(new Classic("Classic"));
//			InfoManager.setBossBar("Game Starting!", 0.1);
//			task = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
//				public void run() {
//					if(i >= 1) {
//						InfoManager.setBossBar("Game Started!", 1);
//						i = 0;
//						Bukkit.getScheduler().cancelTask(task);
////						Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
////							public void run() {
////								InfoManager.bb.removeAll();
////							}
////						}, 20);
//						GameTrigger.startGame();
//					}else {
//						InfoManager.setBossBar("Game Starting..", i);
//						i = i + 0.01;
//					}
//				}
//			}, 20, 1);
		return false;
	}

}
