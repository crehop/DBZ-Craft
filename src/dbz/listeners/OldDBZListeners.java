package dbz.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.util.Vector;

import dbz.abilities.AbilityObjectManager;
import dbz.utils.ParticleEffect;

public class OldDBZListeners {

	@EventHandler
	public static void blockHitGround(EntityChangeBlockEvent event){
		if(event.getEntity().getType() == EntityType.FALLING_BLOCK){
			event.setCancelled(true);
		}

	}
	@EventHandler
	public static void explosionPrimeEvent(ExplosionPrimeEvent event)
	{
		if(event.getEntity().getType() == EntityType.FIREBALL)
		{
			Fireball ball = (Fireball) event.getEntity();
			if(ball.getShooter() instanceof Player){
				if(AbilityObjectManager.kamehamehas.contains(AbilityObjectManager.getKamehameha((Player)ball.getShooter())))
				{
					Location loc = event.getEntity().getLocation();
					ball.setYield(2);
					TNTPrimed primed = loc.getWorld().spawn(loc, TNTPrimed.class);
					primed.setYield(4);
		        	primed.setFuseTicks(0);
		        	ParticleEffect.EXPLOSION_HUGE.display(0, 0, 0, 1, 1, primed.getLocation());
		        	TNTPrimed primed2 = loc.getWorld().spawn(loc, TNTPrimed.class);
		        	primed2.setYield(6.5f);
		        	primed2.setFuseTicks(3);
		        	primed2.setFallDistance(0f);
					AbilityObjectManager.kamehamehas.remove(ball);
					ball.remove();
				}
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void getExplosion(EntityExplodeEvent event) {
		List<Block> explosionBlocks = new ArrayList<Block>();
        explosionBlocks.addAll(event.blockList());
        double height = .04;
        int every3 = 0;
    	for(Block block:explosionBlocks){
    		every3++;
    		height+= .005;
    		if(height > 1){
    			height = .05;
    		}
    		if(every3 == 3){
    			every3 = 0;
    			continue;
    		}
    		FallingBlock thrown = block.getLocation().getWorld()
                    .spawnFallingBlock(block.getLocation(), block.getType(), (byte) 0);
    		thrown.setVelocity(new Vector(0,height,0));
    		thrown.setDropItem(false);
    		thrown.setTicksLived(100);
    	}
	}
}
