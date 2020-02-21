package me.nbarudi.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.nbarudi.files.customevents.KillEvent;
import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.ConfigManager;
import net.md_5.bungee.api.ChatColor;

public class Ability extends BukkitCommand {

	
	
	protected Ability(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(!(sender instanceof Player)) {
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
		
		ArrayList<String> touse = new ArrayList<String>();
		if(args.length == 3) {
			touse.add(args[0]);
			touse.add(args[2]);
		}else {
			touse.add(args[0]);
		}
		
		ConfigManager.getPlayerData().set("PlayerData." + sender.getName() + ".PlannedVisit", touse);
		ConfigManager.playerDataSave();
		
		return false;
	}
	
	public void sortAbilities(Player p, Player t, Role pr) {
		if(pr.ra == RoleAbilities.KILL) {
			KillEvent event = new KillEvent(p, t);
			Bukkit.getServer().getPluginManager().callEvent(event);
		}else if(pr.ra == RoleAbilities.BM) {
			//Bm.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.ALERT) {
			//Alert.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.BUG) {
			//Bug.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.CLEAN) {
			//Clean.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.CONTROL) {
			//To Do, Set up Control Ability
		}else if(pr.ra == RoleAbilities.DISGUISE) {
			//Disguise.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.DOUSEIGNITE) {
			//DouseIgnite.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.FORGE) {
			//To Do: Set up forge ability
		}else if(pr.ra == RoleAbilities.FRAME) {
			//Frame.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.GETROLE) {
			//GetRole.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.GUARD) {
			//Guard.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.HEAL) {
			//Heal.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.INVEST) {
			//Invest.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.JAILKILL) {
			//JailKill.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.PUNISH) {
			//Punish.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.RAMPAGE) {
			//Rampage.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.REMEMBER) {
			//Remember.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.REZ) {
			//Rez.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.ROLEBLOCK) {
			//RoleBlock.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.SUSCHECK) {
			//SusCheck.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.SWAP) {
			// To Do: Set up Swap Ability
		}else if(pr.ra == RoleAbilities.VAMPCHECK) {
			//VampCheck.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.VEST) {
			//Vest.runAbility(p, t, pr, tr);
		}else if(pr.ra == RoleAbilities.WATCH) {
			//Watch.runAbility(p, t, pr, tr);
		}else if(pr.dayra == RoleAbilities.JAIL) {
			//Jail.runAbility(p, t, pr, tr);
		}else if(pr.dayra == RoleAbilities.REVEAL) {
			// To Do: set up reveal ability
		}else {
			Bukkit.getPlayer(t.getName()).sendMessage("Sorry, it seems that we do not have your roles ability registered yet! Please contact nbarudi#5837 if you got this error.");
		}
	}

}
