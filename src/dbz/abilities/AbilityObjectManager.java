package dbz.abilities;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import dbz.abilities.objects.Kamehameha;

public class AbilityObjectManager {

	public static List<Kamehameha> kamehamehas = new ArrayList<Kamehameha>();
	
	public void tick() {
		try {
		if (kamehamehas.isEmpty()) return;
		
		Iterator<Kamehameha> kamIt = kamehamehas.iterator();
		
			while(kamIt.hasNext()) {
				Kamehameha k = kamIt.next();
				if (k == null) continue;
			
				if (k.isDead()) {
					kamehamehas.remove(k);
				} else {
					k.tick();
				}
			}
			
		} catch (ConcurrentModificationException ex) {
			return;
		}
	}
	
}
