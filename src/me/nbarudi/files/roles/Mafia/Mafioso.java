package me.nbarudi.files.roles.Mafia;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Mafioso extends Role{

	public Mafioso(String name) {
		super(name);
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("You can attack if the Godfather doesn't give you orders.");
		atrib.add("If the Godfather dies you will become the next Godfather.");
		atrib.add("You can talk with the other Mafia at night.");
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Carry out the Godfather's orders.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§cMafia");
		wincond.add("§5Witch");
		
		
		this.attack = 1;
		this.defense = 0;
		this.abilities = abil;
		this.attributes = atrib;
		this.winconditions = wincond;
		this.team = ChatColor.RED;
		this.teamname = "§cMafia";
		this.unique = true;
		this.ra = RoleAbilities.KILL;
		this.priority = 5;
	}

}
