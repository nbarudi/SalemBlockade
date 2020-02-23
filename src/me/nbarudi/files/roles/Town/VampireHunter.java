package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class VampireHunter extends Role{

	public VampireHunter(String name) {
		super(name);
		this.attack = 1;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Check for Vampires each night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If you find a Vampire you will attack them.");
		atrib.add("If a Vampire visits you, you will attack them.");
		atrib.add("You can hear Vampires at night.");
		atrib.add("If all the Vampires are dead you will become a Vigilante");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bKilling§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.VAMPCHECK;
		this.priority = 5;
	}

}
