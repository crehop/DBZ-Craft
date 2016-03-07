package dbz.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class DoubleTapListener implements Listener{
	@EventHandler (priority = EventPriority.HIGHEST)
	public void TapListen(PlayerMoveEvent event){
		Bukkit.broadcastMessage("" + event.getPlayer().getVelocity());
	}
}
