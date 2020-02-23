package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Witch extends Role {

	public Witch(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Control someone each night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("You can force people to target anyone.");
		atrib.add("Your victim will know they are being controlled.");
		atrib.add("You have Basic defense until you are attacked.");
		atrib.add("You will know the role of the player you control.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aAnyone but Town");
		
		this.teamname = "§7Neutral\n(§bEvil§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.DARK_PURPLE;
		this.ra = RoleAbilities.CONTROL;
		this.disabled = true;
		this.priority = 2;
	}

}
