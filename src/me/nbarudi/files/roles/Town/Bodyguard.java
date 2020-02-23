package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Bodyguard extends Role{

	public Bodyguard(String name) {
		super(name);
		this.attack = 2;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Protect a player from direct attacks at night");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If your target is attacked or is the victim of a harmful visit, you and the visitor will fight.");
		atrib.add("If you successfully protect someone you can still be Healed");
		atrib.add("You man only wear a bulletproof vest once");
		
		ArrayList<String> wincond = new ArrayList<String>();
        wincond.add("�aTown");
		
		this.teamname = "�aTown\n(�bProtective�a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.ra = RoleAbilities.GUARD;
		this.priority = 3;
	}

}
