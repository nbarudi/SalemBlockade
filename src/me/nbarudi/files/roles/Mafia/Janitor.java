package me.nbarudi.files.roles.Mafia;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Janitor extends Role {

	public Janitor(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Choose a person to clean at night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If your target dies their role and Last Will won't be revealed to the Town");
		atrib.add("Only you will see the Cleaned targets role and Last Will.");
		atrib.add("You may only perform 3 cleanings.");
		atrib.add("If there are no kill capable Mafia roles left you will become a Mafioso.");
		atrib.add("You can talk with the other Mafia at night.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§cMafia");
		wincond.add("§5Witch");
		
		this.teamname = "§cMafia";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.RED;
		this.ra = RoleAbilities.CLEAN;
		this.priority = 3;
	}

}
