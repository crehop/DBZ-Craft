package dbz.listeners;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
public class DoubleTapListener implements Listener{
	public Location transit;
	DecimalFormat numberFormat = new DecimalFormat("#.0");
	public Location OldTransit = new Location(Bukkit.getWorld("world"),0,0,0);
	double x = 0.0f;
	double y = 0.0f;
	double z = 0.0f;
	Location lastVelocity;
	Location transitVelocity;
	float newDistance = 0.0f;
	float lastDistance = 0.0f;
	boolean skip = false;;
	int tapcount = 0;
	@EventHandler (priority = EventPriority.HIGHEST)
	public void TapListen(PlayerMoveEvent event){
		if(event.getPlayer().getInventory().get
	}
}
