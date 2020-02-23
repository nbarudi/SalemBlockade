package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Investigator extends Role {

	public Investigator(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		ArrayList<String> abil = new ArrayList<String>();
		ArrayList<String> atrib = new ArrayList<String>();
		ArrayList<String> wincond = new ArrayList<String>();
		
		atrib.add("None");
		
		abil.add("Investigate one person each night for a clue to their role.");
		
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bInvestigative§a)";
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.INVEST;
		this.priority = 4;
	}

}
