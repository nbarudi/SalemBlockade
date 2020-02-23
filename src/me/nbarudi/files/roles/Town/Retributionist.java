package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Retributionist extends Role {

	public Retributionist(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		this.unique = true;
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You may revive a dead Town member.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("You may only resurrect one Town member.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bSupport§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.REZ;
		this.priority = 3;
	}

}
