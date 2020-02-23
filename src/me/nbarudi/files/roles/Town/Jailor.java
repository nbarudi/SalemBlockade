package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Jailor extends Role {

	public Jailor(String name) {
		super(name);
		this.attack = 3;
		this.defense = 0;
		ArrayList<String> abil = new ArrayList<String>();
		ArrayList<String> atrib = new ArrayList<String>();
		
		atrib.add("You may choose one person during the day to jail for the night.");
		
		abil.add("You may anonymously talk with your prisoner.");
		abil.add("You can choose to attack your prisoner.");
		abil.add("The jailed target can't perform their night ability.");
		abil.add("While jailed the prisoner is given Powerful defense.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;


		this.teamname = "§aTown\n(§bKilling§a)";
		this.team = ChatColor.GREEN;
		this.unique = true;
		this.ra = RoleAbilities.JAILKILL;
		this.dayra = RoleAbilities.JAIL;
		// 1 while jailing, 5 while executing
		this.priority = 1;
		
	}

}
