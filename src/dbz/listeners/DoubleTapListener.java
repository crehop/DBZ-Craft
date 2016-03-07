package dbz.listeners;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
public class DoubleTapListener implements Listener{
	public Location transit;
	DecimalFormat numberFormat = new DecimalFormat("#.00000000");
	public Location OldTransit = new Location(Bukkit.getWorld("world"),0,0,0);
	double x = 0.0f;
	double y = 0.0f;
	double z = 0.0f;
	double transitVelocity = 0.0f;
	@EventHandler (priority = EventPriority.HIGHEST)
	public void TapListen(PlayerMoveEvent event){
		transit = event.getPlayer().getLocation();
		if((transit.getX() - OldTransit.getX()) > 0){
			x = transit.getX() - OldTransit.getX();
		}
		if((transit.getY() - OldTransit.getY()) > 0){
			y= transit.getY() - OldTransit.getY();
		}
		if((transit.getZ() - OldTransit.getZ()) > 0){
			z = transit.getZ() - OldTransit.getZ();
		}
		transitVelocity = x+y+z;
		OldTransit = transit;
		Bukkit.broadcastMessage("" + numberFormat.format(transitVelocity));
	}
}
