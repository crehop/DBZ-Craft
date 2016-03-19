package dbz.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dbz.player.PlayerHandler;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		PlayerHandler.addDBZPlayer(e.getPlayer());
		Bukkit.broadcastMessage("ADDED");
	}
}
