package me.nbarudi.files.roles.Mafia;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Blackmailer extends Role {

	public Blackmailer(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Choose one person each night to blackmail.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Blackmailed targets can not talk durring the day.");
		atrib.add("You can hear private messages.");
		atrib.add("If there are no kill-capable Mafia roles left you will become the Mafioso");
		atrib.add("You can talk to other Mafia at night.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§cMafia");
		wincond.add("§5Witch");
		
		this.teamname = "§cMafia";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.RED;
		this.ra = RoleAbilities.BM;
		this.priority = 3;
	}

}
