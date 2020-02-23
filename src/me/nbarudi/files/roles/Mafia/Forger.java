package me.nbarudi.files.roles.Mafia;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Forger extends Role {

	public Forger(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("Choose a person and rewrite their Last Will at night.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("If your target dies the night you choose to forge them, their Last Will is replaced with your forgery.");
		atrib.add("You may only perform 3 forgeries.");
		atrib.add("If there are no kill-capable Mafia roles left you will become a Mafioso");
		atrib.add("You may talk to other Mafia at night.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§cMafia");
		wincond.add("§5Witch");
		
		this.teamname = "§cMafia";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.RED;
		this.ra = RoleAbilities.FORGE;
		this.disabled = true;
		this.priority = 3;
	}

}
