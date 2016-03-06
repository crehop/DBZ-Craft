package dbz.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerHandler {

	public List<DBZPlayer> dBZPlayers;
	
	public PlayerHandler() {
		dBZPlayers = new ArrayList<>(); //Notice here about jdk 8, the <> has no arguments!
	}
	
	public void addDBZPlayer(DBZPlayer player) {
		if (!dBZPlayers.contains(player)) 
			dBZPlayers.add(player);
	}
	
	public void addDBZPlayer(Player player) {
		for (DBZPlayer p : dBZPlayers) {
			if (p.getPlayer().equals(player)) {
				return;
			}
		}
		
		dBZPlayers.add(new DBZPlayer(player));
	}
	
	public void removeDBZPlayer(Player player) {
		if (!dBZPlayers.contains(player))
		dBZPlayers.remove(player);
	}
	
}
