package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Sheriff extends Role {

	public Sheriff(String name) {
		super(name);
		this.name = name;
		this.attack = 0;
		this.defense = 0;
		ArrayList<String> abil = new ArrayList<String>();
		ArrayList<String> atrib = new ArrayList<String>();
		ArrayList<String> wincond = new ArrayList<String>();
		
		atrib.add("Interrogate one person each night for suspicious activity.");
		
		abil.add("You will know if your target is suspicious.");
		
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bInvestigative§a)";
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.SUSCHECK;
		this.priority = 4;
	}

}
