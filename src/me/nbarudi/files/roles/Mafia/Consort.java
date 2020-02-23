package me.nbarudi.files.roles.Mafia;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Consort extends Role {

	public Consort(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Distract someone each night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Distraction blocks your target from using their role's night ability.");
		atrib.add("If there are no kill capable Mafia roles left, you will become a Mafioso");
		atrib.add("You can talk with the other Mafia at night.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§cMafia");
		wincond.add("§5Witch");
		
		this.teamname = "§cMafia";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.RED;
		this.ra = RoleAbilities.ROLEBLOCK;
		this.priority = 2;
	}

}
