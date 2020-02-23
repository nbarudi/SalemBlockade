package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Werewolf extends Role {

	public Werewolf(String name) {
		super(name);
		this.attack = 1;
		this.defense = 1;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add(".");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add(".");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("�7�lWeerewolf");
		
		this.teamname = "�7Neutral\n(�bKilling�7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.DARK_BLUE;
		this.ra = RoleAbilities.KILL;
		this.priority = 5;
	}

}
