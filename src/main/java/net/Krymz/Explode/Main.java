package net.Krymz.Explode;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public void onEnable(){
		Listeners();
	}
	
	public void onDisable(){
	}
	
	public void Listeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Explode(this), this);
		pm.registerEvents(new Util(this), this);
		pm.registerEvents(new packets(this), this);
		pm.registerEvents(new hashMapStorage(this), this);
	}
	
}
