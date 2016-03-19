package dbz.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import dbz.abilities.KamehamehaAbility;
import dbz.player.PlayerHandler;

/*
 * For now this is a test class but will be used later on.
 */
public class InteractEventListener implements Listener {

	@EventHandler
	public void playerInteractEvent(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if (e.getItem().getType().equals(Material.DIAMOND)) {
				KamehamehaAbility kame = new KamehamehaAbility();
				kame.runAbility(PlayerHandler.getDBZPlayer(e.getPlayer()));
			}
		}
	}
}
