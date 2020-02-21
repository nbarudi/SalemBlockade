package me.nbarudi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.files.gameevents.Voting;
import me.nbarudi.files.roles.Other.Dead;
import me.nbarudi.main.TownOfSalem;
import net.md_5.bungee.api.ChatColor;

public class Vote extends BukkitCommand {

	public Vote(String name) {
		super(name);
		this.description = "Vote up a town member";
		this.usageMessage = "/vote <Player> <Key>";
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		if(TownOfSalem.plrs.get(sender.getName()) == new Dead("Dead")) {
			sender.sendMessage("You cannot run this command as a spectator!");
			return false;
		}
		
		if(args.length < 2) {
			sender.sendMessage(ChatColor.RED + "Please do not use this command. It is all handled for you at night.");
			return false;
		}
		
		if(!args[1].equals(TownOfSalem.key)) {
			sender.sendMessage(ChatColor.RED + "Please do not use this command. It is all handled for you at night.");
			return false;
		}
		
		
		Player player = (Player) sender;
		int votePower = 1;
		
		if(player == TownOfSalem.mayor && TownOfSalem.mayorRevealed) {
			votePower = 3;
		}
		
		Voting.votePlayer(Bukkit.getPlayer(args[0]), player, votePower);
		
		return false;
	}

}
