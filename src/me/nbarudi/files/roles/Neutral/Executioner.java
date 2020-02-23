package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;

public class Executioner extends Role {

	public Executioner(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("None.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If your target dies at night you will become a Jester.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("If you get your target lynched.");
		
		this.teamname = "§7Neutral\n(§bEvil§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GRAY;
		// Does not visit, hence no priority
		this.priority = 0;
	}

}
