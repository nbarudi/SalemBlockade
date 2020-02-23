package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Escort extends Role{

	public Escort(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Distract someone each night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Distraction blocks your target from using their role's night abilities.");
		atrib.add("You cannot be role blocked.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bSupport§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.ROLEBLOCK;
		this.priority = 2;
	}

}
