package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class SerialKiller extends Role {

	public SerialKiller(String name) {
		super(name);
		this.attack = 1;
		this.defense = 1;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You may choose to attack a player each night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If you are roleblocked you will attack the role blocker instead of your target.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§1Serial Killer");
		
		this.teamname = "§7Neutral\n(§bKilling§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.DARK_BLUE;
		this.ra = RoleAbilities.KILL;
		this.priority = 5;
	}

}
