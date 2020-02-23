package me.nbarudi.files.roles.Mafia;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Godfather extends Role {

	public Godfather(String name) {
		super(name);
		this.attack = 1;
		this.defense = 1;
		this.unique = true;
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You may choose to attack a player each night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If there is a Mafioso he will attack the target instead of you.");
		atrib.add("You will appear to be a Town member to the Sheriff.");
		atrib.add("You can talk with the other Mafia at night.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§cMafia");
		wincond.add("§5Witch");
		
		this.teamname = "§cMafia";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.RED;
		this.ra = RoleAbilities.KILL;
		this.priority = 5;
	}

}
