package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Jester extends Role {

	public Jester(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("None");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If you are lynched you will attack one if your guilty or abstaining voters the following night with an Unstoppable attack.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("Anyone if you get lynched");
		
		this.teamname = "§7Neutral\n(§bEvil§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.LIGHT_PURPLE;
		this.ra = RoleAbilities.PUNISH;
		this.priority = 1;
	}

}
