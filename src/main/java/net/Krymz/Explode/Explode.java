package net.Krymz.Explode;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Explode implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public Explode(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Egg && e.getEntity().getShooter() instanceof Player) {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 4.0f, false);
                return;
            }
            return;
    }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Egg(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.EGG) {
					e.getPlayer().getInventory().addItem(new ItemStack(Material.EGG, 1));
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Tnt(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.TNT) {
					final Entity tnt = e.getPlayer().getWorld().spawnEntity(e.getPlayer().getEyeLocation(), EntityType.PRIMED_TNT);
					tnt.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.5));
				}
				}
			}
		}
	
	public static HashMap<Block, Location> blocklist = new HashMap<Block, Location>();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockEvent(EntityExplodeEvent e){
		for(Block block : e.blockList()){
			FallingBlock falling = block.getLocation().getWorld().spawnFallingBlock(block.getLocation(), block.getType(), block.getData());
			float x = (float) (Math.random() * randomNum(-2,2));
            float y = (float) (Math.random() * randomNum(1,2));
            float z = (float) (Math.random() * randomNum(-2,2));
			falling.setVelocity(block.getLocation().getDirection().setX(x).setY(y).setZ(z));
		}
	} 

	
	public static int randomNum(int Low, int High){
		Random r = new Random();
		int R = r.nextInt(High-Low) + Low;
		return R;
	}
}
