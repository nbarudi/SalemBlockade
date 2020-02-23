package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Lookout extends Role {

	public Lookout(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Watch one person at night to see who visits them.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("None");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bInvestigative§a)";
		this.team = ChatColor.GREEN;
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.ra = RoleAbilities.WATCH;
		this.priority = 4;
		
	}

}
