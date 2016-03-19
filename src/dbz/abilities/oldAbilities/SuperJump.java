package dbz.abilities.oldAbilities;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import dbz.utils.ParticleEffect;

public class SuperJump {
	public static void Jump(Player player,double d){
		if(player.isFlying() == false){
			String doubleJump = "DOUBLE JUMP!";
	        float hForce = 6F;
	        float vForce = 1.5F;
	        Vector direction = player.getLocation().getDirection();
	        Vector forward = direction.multiply(3.5);
	        Vector v = player.getLocation().toVector().subtract(player.getLocation().add(0,13,0).toVector());
	        //PVPPlayer pvp = PvpHandler.getPvpPlayer(player);
	       // if(pvp.getUsedSpeedSkill() == true || pvp.getSuperMode() == true)
	        //{
	        	//pvp.setIsDoubleJumping(2);
	        	doubleJump = "SPRINTING DOUBLE JUMP!";
	        	forward.multiply(3.5);
	        	v.multiply(2);
	        	vForce = vForce * 2;
	        	hForce = hForce * 2;
	        //}
        	//pvp.setIsDoubleJumping(2);
	        v.add(forward);
	        v.normalize();
	        v.multiply(hForce);
	        v.setY(vForce);
	        player.setVelocity(v);
			List<Player> list = SkillHandler.getPlayers(20, player);
			if(!list.isEmpty())
			{
				for(Player lplayer:list){
					lplayer.playSound(lplayer.getLocation(), Sound.ENTITY_HORSE_JUMP, 3.0F, 0.533F);
				}
			}
			ParticleEffect.SUSPENDED.display(0, 0, 0, 1, 10, player.getLocation(), 200);
			player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + doubleJump);
		}
	}
}
