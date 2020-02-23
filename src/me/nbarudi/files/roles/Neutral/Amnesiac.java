package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Amnesiac extends Role {

	public Amnesiac(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Remember who you were by selecting a graveyard role.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("When you choose a role it will be rebealed to all players in the game.");
		atrib.add("You cannot choose a unique town role.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("The Team You Remember");
		
		this.teamname = "§7Neutral\n(§bBenign§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.AQUA;
		this.ra = RoleAbilities.REMEMBER;
		this.disabled = true;
		this.priority = 6;
	}

}
