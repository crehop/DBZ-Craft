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
	double transitVelocity = 0.0f;
	Vector stop = new Vector(0,0,0);
	@EventHandler (priority = EventPriority.HIGHEST)
	public void TapListen(PlayerMoveEvent event){
		Bukkit.broadcastMessage(event.getPlayer().getVelocity() + " : VELOCITY");
		if(event.getPlayer().getVelocity().getX() != 0 || event.getPlayer().getVelocity().getY() != 0 || event.getPlayer().getVelocity().getZ() != 0){
			event.getPlayer().teleport(event.getPlayer());
		}
		transit = event.getPlayer().getLocation();
		if((transit.getX() - OldTransit.getX()) != 0){
			x = transit.getX() - OldTransit.getX();
		}
		if((transit.getY() - OldTransit.getY()) != 0){
			y= transit.getY() - OldTransit.getY();
		}
		if((transit.getZ() - OldTransit.getZ()) != 0){
			z = transit.getZ() - OldTransit.getZ();
		}
		transitVelocity = x + y + z;
		if(transitVelocity < 0){
			transitVelocity *= -1;
		}
		//Bukkit.broadcastMessage("" + x + "," + y + "," + z);
		//Bukkit.broadcastMessage(numberFormat.format(transitVelocity));
		OldTransit = transit;
	}
}
