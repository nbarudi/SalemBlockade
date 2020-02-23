package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;

public class Medium extends Role{

	public Medium(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("When dead speak to a living person at night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("You will speak to the dead anonymously each night you are alive.");
		atrib.add("You may only speak to a living person once.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bSupport§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.priority = 1;
	}

}
