package me.nbarudi.gamesystems;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.nbarudi.files.gameevents.Day;
import me.nbarudi.files.gamemodes.GameMode;
import me.nbarudi.files.randomized.Randomized;
import me.nbarudi.files.roles.Role;
import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;
import net.md_5.bungee.api.ChatColor;

public class AssignRoles {

	public static void StartGame(GameMode gm) {
		ArrayList<Role> roles = gm.roles;
		ArrayList<Randomized> random = gm.random;
		
		ArrayList<Player> unassigned = new ArrayList<Player>();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(TownOfSalem.spectators.contains(p)) continue;
			unassigned.add(p);
		}
		
		
		for(Role r : roles) {
			if(unassigned.toArray().length == 0) { Bukkit.broadcastMessage("Not enough players to fill role: " + r.name); continue; }
			if(r.disabled) { Bukkit.broadcastMessage(r.name + " is disabled!"); continue;}
			int rnd = new Random().nextInt(unassigned.toArray().length);
			System.out.print(rnd - 1);
			Player player = (Player) unassigned.get(rnd);
			
			while(player == null) {
				rnd = new Random().nextInt(unassigned.toArray().length);
				player = (Player) unassigned.get(rnd);
			}
			
			if(r.unique && TownOfSalem.rplrs.containsKey(r)) continue;
			
			TownOfSalem.plrs.put(player.getName(), r);
			TownOfSalem.rplrs.put(r.name, player.getName());
			unassigned.remove(player);
			player.sendMessage(ChatColor.GREEN + "You are the " + r.team + r.name + "§a!");
			Announcements.giveRoleInfo(r, player);
			TownOfSalem.alive.add(player);
			if(r.teamname == "§cMafia") {
				TownOfSalem.mafia.add(player);
			}
			continue;
		}
		for(Randomized rand : random) {
			if(unassigned.toArray().length == 0) { /*Bukkit.broadcastMessage("Not enough players to fill role: " + rand.name); */continue; }
//			for(Role r : rand.roles) {
//				int rnd = new Random().nextInt(unassigned.toArray().length);
//				Player player = (Player) unassigned.get(rnd);
//				
//				while(player == null) {
//					rnd = new Random().nextInt(unassigned.toArray().length);
//					player = (Player) unassigned.get(rnd);
//				}
//				
//				if(r.unique && TownOfSalem.roleplrs.containsKey(r)) continue;
//				
//				TownOfSalem.plrs.put(player.getName(), r);
//				TownOfSalem.roleplrs.put(r, player.getName());
//				unassigned.remove(player);
//				player.sendMessage(ChatColor.GREEN + "You are the " + r.team + r.name + "§a!");
//				Announcements.giveRoleInfo(r, player);
//				continue;
//			}
			for(Player player : unassigned) {
				int rnd = new Random().nextInt(rand.roles.toArray().length);
				Role r = rand.roles.get(rnd);
				if(r.disabled) { Bukkit.broadcastMessage(r.name + " is disabled!"); continue;}
				
				if(r.unique && TownOfSalem.plrs.containsKey(r)) continue;
				
				TownOfSalem.plrs.put(player.getName(), r);
				TownOfSalem.rplrs.put(r.name, player.getName());
				unassigned.remove(player);
				player.sendMessage(ChatColor.GREEN + "You are the " + r.team + r.name + "§a!");
				Announcements.giveRoleInfo(r, player);
				TownOfSalem.alive.add(player);
				if(r.teamname == "§cMafia") {
					TownOfSalem.mafia.add(player);
				}
				continue;
			}
			continue;
		}
		Wills.setUpWills();
		TownOfSalem.gameStarted = true;
		Day.triggerDay1();
		
//		if(TownOfSalem.spectators.contains(p)) continue;
//		if(roles.size() > 0) {
//			Random rnd = new Random();
//			int rand = rnd.nextInt(roles.toArray().length);
//			Role rl = roles.get(rand);
//			
//			roles.remove(rl);
//			TownOfSalem.plrs.put(p.getName(), rl);
//			
//		}else {
//			
//		}
		
	}

}
