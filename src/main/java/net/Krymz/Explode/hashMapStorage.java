package net.Krymz.Explode;

import java.util.HashMap;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;

public class hashMapStorage implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public hashMapStorage(Main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<String, Block> tnt = new HashMap<String, Block>();
	
}
