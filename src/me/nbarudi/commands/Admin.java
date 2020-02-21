package me.nbarudi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import me.nbarudi.utils.CheckPermissions;
import me.nbarudi.utils.ConfigManager;
import net.md_5.bungee.api.ChatColor;

public class Admin extends BukkitCommand {

	public Admin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		if(args.length < 2) {
			sender.sendMessage(ChatColor.RED + "Please do not use this command. It is strictly used by Salem administrators (developer)");
			return false;
		}
		
//		if(!sender.getName().equalsIgnoreCase("nbarudi")) {
//			sender.sendMessage(ChatColor.RED + "Please do not use this command. It is strictly used by nbarudi (developer)");
//			return false;
//		}
		
		Player t = Bukkit.getPlayer(args[0]);
		if(t == null) {
			sender.sendMessage("§4Could not find the player: " + args[0]);
			return false;
		}
		
		//String uuid = t.getUniqueId().toString();
		//String name = t.getName();
		
		if(args[1].equalsIgnoreCase("admin")) {
			if(CheckPermissions.checkPerms((Player)sender, 3)) {
				ConfigManager.getRankData().set("Players." + t.getName() + ".Rank", "Admin");
				ConfigManager.ranksSave();
				Announcements.dmAnnounce("§aSet player §b" + t.getName() + " §ato rank §cAdmin", (Player)sender);
				Announcements.dmAnnounce("§aYou have been set to rank §cAdmin §aby player §b" + sender.getName(), t);
			}else {
				sender.sendMessage("§4Sorry! You do not have permission to make players an admin!");
			}
			return false;
		}
		if(args[1].equalsIgnoreCase("host")) {
			if(CheckPermissions.checkPerms((Player)sender, 2)) {
				ConfigManager.getRankData().set("Players." + t.getName() + ".Rank", "Host");
				ConfigManager.ranksSave();
				Announcements.dmAnnounce("§aSet player §b" + t.getName() + " §ato rank §cHost", (Player)sender);
				Announcements.dmAnnounce("§aYou have been set to rank §cHost §aby player §b" + sender.getName(), t);
			}else {
				sender.sendMessage("§4Sorry! You do not have permission to make players a host!");
			}
			return false;
		}
		if(args[1].equalsIgnoreCase("manager")) {
			if(args.length != 3) {
				sender.sendMessage(ChatColor.RED + "Please do not use this command. It is strictly used by Salem administrators (developer)");
				return true;
			}
			if(args[2].equals(TownOfSalem.key)) {
				ConfigManager.getRankData().set("Players." + t.getName() + ".Rank", "Manager");
				ConfigManager.ranksSave();
				Announcements.dmAnnounce("§aSet player §b" + t.getName() + " §ato rank §cManager", (Player)sender);
				Announcements.dmAnnounce("§aYou have been set to rank §cManager §aby player §b" + sender.getName(), t);
			}else {
				sender.sendMessage("§4Sorry! Invalid Key!");
			}
		}
		
		return false;
	}

}
