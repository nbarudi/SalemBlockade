package me.nbarudi.files.roles;

import java.util.ArrayList;

import org.bukkit.ChatColor;

public class Role {
	
	public String name;
	public ChatColor team;
	public int attack;
	public int defense;
	public int priority;
	public ArrayList<String> attributes;
	public ArrayList<String> abilities;
	public ArrayList<String> winconditions;
	public String teamname;
	public boolean unique;
	public boolean disabled;
	public boolean rbimmune;
	public RoleAbilities ra;
	public RoleAbilities dayra;
	
	public Role(String name) {
		this.name = name;
		this.unique = false;
		this.disabled = false;
		this.ra = RoleAbilities.NONE;
		this.dayra = RoleAbilities.NONE;
		this.rbimmune = false;
//		this.attack = 0;
//		this.defense = 0;
//		
//		
//		ArrayList<String> abil = new ArrayList<String>();
//		
//		
//		ArrayList<String> atrib = new ArrayList<String>();
//		
//		
//		ArrayList<String> wincond = new ArrayList<String>();
//		
//		
//		this.teamname = "";
//		
//		this.attributes = atrib;
//		this.abilities = abil;
//		this.winconditions = wincond;
//		this.team = ChatColor.GREEN;
	}

}
