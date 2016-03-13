package dbz.abilities;

import java.util.ArrayList;
import java.util.List;

import dbz.abilities.objects.Kamehameha;

public class AbilityObjectManager {

	public static List<Kamehameha> kamehamehas = new ArrayList<Kamehameha>();
	
	public void tick() {
		
		for (Kamehameha k : kamehamehas) {
			if (k == null) continue;
			
			if (k.isDead()) {
				kamehamehas.remove(k);
			} else {
				k.tick();
			}
		}
		
	}
	
}
