package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Transporter extends Role {

	public Transporter(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Choose two people to transport at night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Transporting two people swaps all targets against them.");
		atrib.add("You may transport yourself.");
		atrib.add("Your targets will know they were transported.");
		atrib.add("You may not transport someone with themselves.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bSupport§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.SWAP;
		this.disabled = true;
		this.rbimmune = true;
		this.priority = 1;
	}

}
