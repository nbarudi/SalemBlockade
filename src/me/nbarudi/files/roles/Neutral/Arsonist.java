package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Arsonist extends Role {

	public Arsonist(String name) {
		super(name);
		this.attack = 3;
		this.defense = 1;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You may Douse someone in gasoline or ignite Doused targets.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Select yourself to ignite doused people.");
		atrib.add("If you take no action, you will attempt to clean gasoline off yourself.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§6§lArsonist");
		
		this.teamname = "§7Neutral\n(§bKilling§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GOLD;
		this.ra = RoleAbilities.DOUSEIGNITE;
		/* Priority is a 3 when dousing, 5 while igniting */
		this.priority = 3;
	}

}
