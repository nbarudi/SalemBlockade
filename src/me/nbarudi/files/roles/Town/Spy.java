package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Spy extends Role {

	public Spy(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You may bug a player's house to see what happens to them at night");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("You will know who the Mafi and Coven visit each night");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bInvestigative§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.BUG;
		this.priority = 6;
	}

}
