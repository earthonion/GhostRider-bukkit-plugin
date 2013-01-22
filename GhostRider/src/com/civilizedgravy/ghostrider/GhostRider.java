package com.civilizedgravy.ghostrider;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class GhostRider extends JavaPlugin implements Listener {
	public static boolean flamemobs = false;

	@Override
	public void onEnable() {
		getCommand("spawnghostrider").setExecutor(
				new GhostRiderSpawnExecutor(this));
		getCommand("gr").setExecutor(new GhostRiderSpawnExecutor(this));
		getServer().getPluginManager().registerEvents(this, this);
		// super.onEnable();

	}

	@EventHandler
	public void onShoot(ProjectileLaunchEvent event) {
		if (event.getEntity() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getEntity();
			if (arrow.getShooter() instanceof Skeleton && arrow.getShooter().isInsideVehicle()) {
				Skeleton shooter =  (Skeleton) arrow.getShooter();
				
					event.setCancelled(true);
					shooter.launchProjectile(Fireball.class).setVelocity(
							arrow.getVelocity());
				
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GhostRider();
	}

}
