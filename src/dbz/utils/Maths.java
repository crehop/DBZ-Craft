package dbz.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.util.Vector;


/*
 *  All math things that math utilities does not provide!
 */
public class Maths {

	 public static List<Location> circle (Location loc, Integer r, Integer h, Boolean hollow, Boolean sphere, int plus_y) {
	        List<Location> circleblocks = new ArrayList<Location>();
	        int cx = (int) loc.getX();
	        int cy = (int) loc.getY();
	        int cz = (int) loc.getZ();
	        for (int x = cx - r; x <= cx +r; x++)
	            for (int z = cz - r; z <= cz +r; z++)
	                for (int y = (sphere ? cy - r : cy); y < (sphere ? cy + r : cy + h); y++) {
	                    double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
	                    if (dist < r*r && !(hollow && dist < (r-1)*(r-1))) {
	                        Location l = new Location(loc.getWorld(), x, y + plus_y, z);
	                        circleblocks.add(l);
	                        }
	                    }
	 
	        return circleblocks;
	    }
	
	 public static Vector distanceToFrom(Location to, Location from) {
		 Vector f = from.toVector();
		 Vector t = to.toVector();
		 Vector vector = t.subtract(f);
		 return vector;
	 }
	 
}
