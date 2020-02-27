package me.nbarudi.gamesystems;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.nbarudi.main.TownOfSalem;
import me.nbarudi.utils.Announcements;

public class ChatManager implements Listener{
	
	@EventHandler
	public void onAsyncChat(AsyncPlayerChatEvent event) {
		
		if(TownOfSalem.gameStarted == false) return;
		
		String message = event.getMessage();
		Player player = event.getPlayer();
		Player jailor = Bukkit.getPlayer(TownOfSalem.rplrs.get("Jailor"));
		ArrayList<Player> mediums = new ArrayList<Player>();
		
		for(Player p : TownOfSalem.alive) {
			if(TownOfSalem.plrs.get(p.getName()).name == "Medium") {
				mediums.add(p);
			}
		}
		
		if(TownOfSalem.isNight) {
			event.setCancelled(true);
			
			if(TownOfSalem.plrs.get(player.getName()).name == "Medium") {
				player.sendMessage("§a(Dead Chat): §3Medium: §b" + message);
				for(Player p : TownOfSalem.dead) {
					p.sendMessage("§a(Dead Chat): §3Medium: §b" + message);
				}
			}
			else if(TownOfSalem.dead.contains(player)) {
				for(Player p : mediums) {
					p.sendMessage("§a(Dead Chat): §c" + player.getName() + ": §b" + message);
				}
			}
			else if(player == TownOfSalem.jailed) {
				player.sendMessage("§a(Jailor Chat): §c" + player.getName() + ": §b" + message);
				jailor.sendMessage("§a(Jailor Chat): §c" + player.getName() + ": §b" + message);
			}
			else if(TownOfSalem.mafia.contains(player)) {
				for(Player p : TownOfSalem.mafia) {
					if(p == TownOfSalem.jailed) continue;
					p.sendMessage("§c(Mafia Chat): §a" + player.getName() + ": §b" + message);
				}
			}else if(player == jailor) {
				Player jailee = TownOfSalem.jailed;
				if(jailee == null) {
					player.sendMessage("§a(Jailor Chat): §c" + player.getName() + ": §b" + message);
				}else {
					player.sendMessage("§a(Jailor Chat): §c" + player.getName() + ": §b" + message);
					jailee.sendMessage("§a(Jailor Chat): §c" + player.getName() + ": §b" + message);
				}
			}
			
		}else {
			event.setCancelled(true);
			
			if(TownOfSalem.blackmailed.contains(player)) {
				player.sendMessage("§cYou are blackmailed!");
			}
			else if(TownOfSalem.dead.contains(player)) {
				player.sendMessage("§a(Dead Chat): §3Medium: §b" + message);
				for(Player p : TownOfSalem.dead) {
					p.sendMessage("§a(Dead Chat): §3Medium: §b" + message);
				}
			}else {
				for(Player p : Bukkit.getOnlinePlayers()) {
					p.sendMessage("§a(" + p.getName() + "): §b" + message);
				}
			}
		}
		
	}
	
	public static void onWhisper(Player whisperer, Player whispered, String message) {
		
		Announcements.globalAnnounce("§5(Whisper): §7" + whisperer.getName() + " §e has whispered to §7" + whispered.getName() + "§e!");
		
		for(Player p : TownOfSalem.alive) {
			if(TownOfSalem.plrs.get(p.getName()).name.equalsIgnoreCase("Blackmailer")) {
				p.sendMessage("§5(§7" + whisperer.getName() + " §5 to §7" + whispered.getName() + "§5): §b" + message);
			}
		}
		
	}



}
