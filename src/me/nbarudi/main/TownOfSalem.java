package me.nbarudi.main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.nbarudi.commands.Admin;
import me.nbarudi.commands.Announce;
import me.nbarudi.commands.ForceStart;
import me.nbarudi.commands.ForceVote;
import me.nbarudi.commands.HostMode;
import me.nbarudi.commands.Menu;
import me.nbarudi.commands.Vote;
import me.nbarudi.events.InventoryInteract;
import me.nbarudi.events.PlayerChat;
import me.nbarudi.events.PlayerJoin;
import me.nbarudi.events.SignBook;
import me.nbarudi.files.gameevents.Judgement;
import me.nbarudi.files.gamemodes.GameMode;
import me.nbarudi.files.gamemodes.Normal.Classic;
import me.nbarudi.files.handlers.KillHandler;
import me.nbarudi.files.roles.Role;
import me.nbarudi.files.roles.Mafia.Blackmailer;
import me.nbarudi.files.roles.Mafia.Consigliere;
import me.nbarudi.files.roles.Mafia.Consort;
import me.nbarudi.files.roles.Mafia.Disguiser;
import me.nbarudi.files.roles.Mafia.Forger;
import me.nbarudi.files.roles.Mafia.Framer;
import me.nbarudi.files.roles.Mafia.Godfather;
import me.nbarudi.files.roles.Mafia.Janitor;
import me.nbarudi.files.roles.Mafia.Mafioso;
import me.nbarudi.files.roles.Neutral.Amnesiac;
import me.nbarudi.files.roles.Neutral.Arsonist;
import me.nbarudi.files.roles.Neutral.Executioner;
import me.nbarudi.files.roles.Neutral.Jester;
import me.nbarudi.files.roles.Neutral.SerialKiller;
import me.nbarudi.files.roles.Neutral.Survivor;
import me.nbarudi.files.roles.Neutral.Witch;
import me.nbarudi.files.roles.Town.Bodyguard;
import me.nbarudi.files.roles.Town.Doctor;
import me.nbarudi.files.roles.Town.Escort;
import me.nbarudi.files.roles.Town.Investigator;
import me.nbarudi.files.roles.Town.Jailor;
import me.nbarudi.files.roles.Town.Lookout;
import me.nbarudi.files.roles.Town.Mayor;
import me.nbarudi.files.roles.Town.Medium;
import me.nbarudi.files.roles.Town.Retributionist;
import me.nbarudi.files.roles.Town.Sheriff;
import me.nbarudi.files.roles.Town.Spy;
import me.nbarudi.files.roles.Town.Transporter;
import me.nbarudi.files.roles.Town.VampireHunter;
import me.nbarudi.files.roles.Town.Veteran;
import me.nbarudi.files.roles.Town.Vigilante;
import me.nbarudi.gamesystems.ChatManager;
import me.nbarudi.gamesystems.host.HostTemplate;
import me.nbarudi.gamesystems.host.ListAbilities;
import me.nbarudi.gamesystems.host.ListVisits;
import me.nbarudi.gamesystems.host.RunAbility;
import me.nbarudi.gamesystems.host.StartCountdown;
import me.nbarudi.gamesystems.host.StartGame;
import me.nbarudi.gamesystems.host.inventory.Manager;
import me.nbarudi.utils.ConfigManager;
import me.nbarudi.utils.GamemodeScore;
import me.nbarudi.utils.KeyGenerator;

public class TownOfSalem extends JavaPlugin {
	
	//Game Stuff
	public static ArrayList<Role> roleinfo = new ArrayList<Role>();
	public static ArrayList<String> tempImmune = new ArrayList<String>();
	public static ArrayList<HostTemplate> hostcommands = new ArrayList<HostTemplate>();
	public static ArrayList<GameMode> gms = new ArrayList<GameMode>();
	
	//Role Stuff
	public static Player mayor;
	public static boolean mayorRevealed = false;
	
	//Player Managment
	public static Map<String, Role> plrs = new HashMap<String, Role>();
	public static Map<String, String> rplrs = new HashMap<String, String>();
	public static ArrayList<Player> alive = new ArrayList<Player>();
	public static ArrayList<Player> spectators = new ArrayList<Player>();
	public static ArrayList<Player> mafia = new ArrayList<Player>();
	public static ArrayList<Player> dead = new ArrayList<Player>();
	public static ArrayList<Player> blackmailed = new ArrayList<Player>();
	public static Player onStand;
	public static Player jailed;
	
	//Global Values
	public static int DayNumber = 0;
	public static int NightNumber = 0;
	public static boolean isDefending = false;
	public static GameMode gm = new Classic("Classic");
	public static boolean gameStarted = false;
	public static boolean isNight = false;
	
	//Instances
	public static Plugin instance;
	public static String key;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		
		GamemodeScore.setupScoreboard(this, gm);
		
		//Register Instances
		instance = this;
		key = KeyGenerator.randomAlphaNumeric(15);
		System.out.print(key);
		
		//Register Required Things (Events, Commands, Etc..)
		registerCommands();
		registerEvents();
		
		//Config Stuffs
		registerConfig();
		
		//Register Game Related Things (Roles, Gamemodes, Etc..)
		registerRoles();
		
		//Register host commands
		registerHostCommands();
		
		//Setup
		if(ConfigManager.getRankData().getConfigurationSection("Players.nbarudi") == null){
			ConfigManager.getRankData().set("Players.nbarudi.Rank", "Manager");
			ConfigManager.getRankData().set("Players.nbarudi.UUID", Bukkit.getOfflinePlayer("nbarudi").getUniqueId().toString());
			ConfigManager.ranksSave();
		}
		
	}
	
	public void registerCommands() {
		Field bukkitCommandMap;
		try {
			bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
			bukkitCommandMap.setAccessible(true);
			CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

			
			commandMap.register("forcestart", new ForceStart("forcestart", this));
			commandMap.register("vote", new Vote("Vote"));
			commandMap.register("forcevote", new ForceVote("forcevote"));
			commandMap.register("admin", new Admin("admin"));
			commandMap.register("menu", new Menu("menu"));
			commandMap.register("hostmode", new HostMode("hostmode"));
			commandMap.register("announce", new Announce("announce"));
		}  catch (NoSuchFieldException | IllegalAccessException e) {
            getLogger().severe(e.getLocalizedMessage());
            e.printStackTrace();
            this.getPluginLoader().disablePlugin(this);
        }
		
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		//Server Related Events
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new InventoryInteract(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new SignBook(), this);
		pm.registerEvents(new ChatManager(), this);
		
		//Game Related Events
		pm.registerEvents(new Judgement(), this);
		
		
		//Ability Events
		pm.registerEvents(new KillHandler(), this);
		
		//Host Events
		pm.registerEvents(new Manager(), this);
		
	}
	
	
	public void registerConfig() {
		ConfigManager.setup();
		ConfigManager.playerDataSave();
		ConfigManager.storageDataSave();
		
		if(ConfigManager.getStorageData().getConfigurationSection("Data") == null) {
			ConfigManager.getStorageData().createSection("Data");
		}
		
	}
	
	
	public void registerRoles() {
		//Town
		roleinfo.add(new Bodyguard("Bodyguard"));
		roleinfo.add(new Doctor("Doctor"));
		roleinfo.add(new Escort("Escort"));
		roleinfo.add(new Investigator("Investigator"));
		roleinfo.add(new Jailor("Jailor"));
		roleinfo.add(new Lookout("Lookout"));
		roleinfo.add(new Mayor("Mayor"));
		roleinfo.add(new Medium("Medium"));
		roleinfo.add(new Retributionist("Retributionist"));
		roleinfo.add(new Sheriff("Sheriff"));
		roleinfo.add(new Spy("Spy"));
		roleinfo.add(new Transporter("Transporter"));
		roleinfo.add(new VampireHunter("VampireHunter"));
		roleinfo.add(new Veteran("Veteran"));
		roleinfo.add(new Vigilante("Vigilante"));
		
		//Mafia
		roleinfo.add(new Blackmailer("Blackmailer"));
		roleinfo.add(new Consigliere("Consigliere"));
		roleinfo.add(new Consort("Consort"));
		roleinfo.add(new Disguiser("Disguiser"));
		roleinfo.add(new Forger("Forger"));
		roleinfo.add(new Framer("Framer"));
		roleinfo.add(new Godfather("Godfather"));
		roleinfo.add(new Janitor("Janitor"));
		roleinfo.add(new Mafioso("Mafioso"));
		
		//Neutral
		roleinfo.add(new Amnesiac("Amnesiac"));
		roleinfo.add(new Arsonist("Arsonist"));
		roleinfo.add(new Executioner("Executioner"));
		roleinfo.add(new Jester("Jester"));
		roleinfo.add(new SerialKiller("SerialKiller"));
		roleinfo.add(new Survivor("Survivor"));
		roleinfo.add(new Witch("Witch"));
	}
	
	public void registerGameModes() {
		gms.add(new Classic("Classic"));
	}
	
	public void registerHostCommands() {
		hostcommands.add(new StartGame("Start Game"));
		hostcommands.add(new ListVisits("List Visits"));
		hostcommands.add(new ListAbilities("List Abilities"));
		hostcommands.add(new RunAbility("Run Abilities"));
		hostcommands.add(new StartCountdown("Start Countdown"));
	}

}
