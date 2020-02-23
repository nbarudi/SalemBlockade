package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Vigilante extends Role{

	public Vigilante(String name) {
		super(name);
		this.attack = 1;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Choose to take justice into your own hands and shoot someone.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If you shoot another Town member you will commit suicide over the guilt.");
		atrib.add("You can only shoot your gun 3 times.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		wincond.add("§6Survivor");
		
		this.teamname = "§aTown\n(§bKilling§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.KILL;
		this.priority = 5;
	}

}
