package me.nbarudi.files.roles.Neutral;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Survivor extends Role {

	public Survivor(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Put on a bullet proof vest");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Putting on a bulletproof vest gives you Basic defense.");
		atrib.add("You can only use the bulletproof vest 4 times.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§0Everyone");
		
		this.teamname = "§7Neutral\n(§bBenign§7)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GOLD;
		this.ra = RoleAbilities.VEST;
		this.priority = 3;
	}

}
