package dbz.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerHandler {

	public static List<DBZPlayer> dBZPlayers = new ArrayList<>();
	
	public static void updatePlayers() {
		for (DBZPlayer p : dBZPlayers) {
			p.update();
		}
	}
	
	public static void addDBZPlayer(DBZPlayer player) {
		if (!dBZPlayers.contains(player)) 
			dBZPlayers.add(player);
	}
	
	public static void addDBZPlayer(Player player) {
		for (DBZPlayer p : dBZPlayers) {
			if (p == null) continue;
			if (p.getPlayer().equals(player)) {
				return;
			}
		}
		
		dBZPlayers.add(new DBZPlayer(player));
	}
	
	public static void removeDBZPlayer(Player player) {
		for (DBZPlayer p : dBZPlayers) {
			if (p == null) continue;
			if (p.getPlayer().equals(player)) {
				dBZPlayers.remove(p);
			}
		}
	}
	
	public static void removeDBZPlayer(DBZPlayer player) {
		if (!dBZPlayers.contains(player))
			dBZPlayers.remove(player);
	}
	
	public static DBZPlayer getDBZPlayer(Player player) {
		for (DBZPlayer p : dBZPlayers) {
			if (p == null) continue;
			if (p.getPlayer().equals(player)) return p;
		}
		return null;
	}
	
}
