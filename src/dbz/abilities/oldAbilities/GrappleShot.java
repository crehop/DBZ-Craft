package dbz.abilities.oldAbilities;

public class GrappleShot {
	
	/*private final FireworkEffect pulled = FireworkEffect.builder().with(Type.CREEPER).withColor(Color.RED).withFade(Color.GRAY).build();
	
		public static void grappleShotPlayerHit(Player damagee, Player damager,PVPPlayer pvp)
		{
			pvp.setStamina((int) (pvp.getStamina() - 25));
			pvp.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "YOU FIRE A GRAPPLE SHOT AND PULL " + damagee.getDisplayName() + " TO YOU!");
			Vector direction = damager.getLocation().add(0, 6, 0).toVector().subtract(damagee.getLocation().toVector()).normalize();
			direction.multiply(3);
			damagee.setVelocity(direction);
			
			try {
				player.playFirework(damagee.getWorld(), damagee.getLocation().add(0, 1, 0), pulled);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ParticleEffect.SPELL_WITCH.display(0, 0, 0, 1, 1, damager.getLocation(), 100);
			pvp.setGrappleEnd(null);
			pvp.setGrappleStart(null);
			pvp.setGrapplePlayer(null);
			pvp.setGrappleArrow(null);
	        pvp.setCanUseGrappleShot(false);
	        pvp.setIsUsingGrappleShot(false);
		}
		
		public static void grappleShotBlockHit(Player shooter, Block hit,PVPPlayer pvp)
		{
			pvp.setStamina((int) (pvp.getStamina() - 25));
			pvp.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "YOU FIRE A GRAPPLE SHOT AND PULL YOURSELF TO THE BLOCK!");
			Location delta = shooter.getLocation().add(hit.getLocation().add(0, 5, 0));
		    Vector direction = delta.getDirection();
		    direction.multiply(3);
	        shooter.setVelocity(direction);
	        ParticleEffect.SPELL_WITCH.display(0, 0, 0, 1, 1, shooter.getLocation(), 100);
			pvp.setGrappleEnd(null);
			pvp.setGrappleStart(null);
			pvp.setGrapplePlayer(null);
			pvp.setGrappleArrow(null);
	        pvp.setCanUseGrappleShot(false);
	        pvp.setIsUsingGrappleShot(false);
		}
		*/
}
