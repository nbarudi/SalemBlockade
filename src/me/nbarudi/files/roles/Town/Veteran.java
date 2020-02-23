package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Veteran extends Role{

	public Veteran(String name) {
		super(name);
		
		this.attack = 2;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Decide if you will go on alert.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("While on alert you gain Basic Defense.");
		atrib.add("While on alert, you will deliver a Powerful attack to anyone who visits you.");
		atrib.add("You can only go on alert 3 times.");
		atrib.add("You cannot be role blocked.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bKilling§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.unique = true;
		this.rbimmune = true;
		this.ra = RoleAbilities.ALERT;
		// While on alert
		this.priority = 1;
		
	}

}
