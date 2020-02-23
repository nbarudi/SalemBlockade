package me.nbarudi.files.roles.Town;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.RoleAbilities;

public class Mayor extends Role {

	public Mayor(String name) {
		super(name);
		this.attack = 0;
		this.defense = 0;
		this.unique = true;
		
		ArrayList<String> abil = new ArrayList<String>();
		abil.add("You may reveal yourself as the Mayor of the Town.");
		
		ArrayList<String> atrib = new ArrayList<String>();
		atrib.add("Once you have revealed your self as Mayor your vote counts as 3 votes.");
		atrib.add("You may not be healed once you have revealed your self.");
		atrib.add("Once revealed, you can't whisper or be whispered to.");
		
		ArrayList<String> wincond = new ArrayList<String>();
		wincond.add("§aTown");
		
		this.teamname = "§aTown\n(§bSupport§a)";
		
		this.attributes = atrib;
		this.abilities = abil;
		this.winconditions = wincond;
		this.team = ChatColor.GREEN;
		this.dayra = RoleAbilities.REVEAL;
		this.disabled = true;
		// Does not visit
		this.priority = 0;
	}

}
