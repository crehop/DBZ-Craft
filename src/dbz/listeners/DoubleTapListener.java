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
	boolean eventCancelled;
	int tapcount = 0;
	@EventHandler (priority = EventPriority.HIGHEST)
	public void TapListen(PlayerMoveEvent event){
		if(event.getTo().getY() == event.getFrom().getY()){
			lastVelocity = event.getFrom();
			transitVelocity = event.getTo();
			newDistance = (float) lastVelocity.distance(transitVelocity);
			if(newDistance < 0){
				newDistance *= -1.0f;
			}
			//Bukkit.broadcastMessage("DELTA = " + lastDistance + " DELTA(A) = " + newDistance);
			if(newDistance < ((float)(lastDistance - 0.0145f)) && newDistance > 0.0f && event.getFrom().getDirection().distance(event.getTo().getDirection()) < 0.0043f ){
				event.getPlayer().teleport(event.getPlayer());
				Bukkit.broadcastMessage("TAP:" + tapcount);
				tapcount++;
				lastDistance = (float) lastVelocity.distance(transitVelocity);
				if(lastDistance < 0){
					lastDistance *= -1.0f;
				}
			}
			lastDistance = (float) lastVelocity.distance(transitVelocity);
		}else{
			//need to work on double tap during climb/decent
			//lastVelocity = event.getFrom();
			//transitVelocity = event.getTo();
			//newDistance = (float) lastVelocity.distance(transitVelocity);
			//if(newDistance < 0){
			//	newDistance *= -1.0f;
			//}
			//Bukkit.broadcastMessage("DELTA = " + lastDistance + " DELTA(A) = " + newDistance);
			//if(newDistance < ((float)(lastDistance - 0.0145f)) && newDistance > 0.0f && event.getFrom().getDirection().distance(event.getTo().getDirection()) < 0.0043f ){
			//	event.getPlayer().teleport(event.getPlayer());
			//	Bukkit.broadcastMessage("TAP:" + tapcount);
			//	tapcount++;
			//	lastDistance = (float) lastVelocity.distance(transitVelocity);
			//	if(lastDistance < 0){
			//		lastDistance *= -1.0f;
			//	}
			//}
			//lastDistance = (float) lastVelocity.distance(transitVelocity);
		}
	}
}
