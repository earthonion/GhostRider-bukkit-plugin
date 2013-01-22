package com.civilizedgravy.ghostrider;

import net.minecraft.server.v1_4_R1.ItemStack;
import net.minecraft.server.v1_4_R1.NBTTagCompound;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftPig;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftSkeleton;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class GhostRiderSpawnExecutor implements CommandExecutor {

	private GhostRider plugin;

	public GhostRiderSpawnExecutor(GhostRider plugin) {

		this.plugin = plugin;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("spawnghostrider")
				|| cmd.getName().equalsIgnoreCase("gr")) {
			Player p = sender.getServer().getPlayer(sender.getName());
			Block target = sender.getServer().getPlayer(sender.getName())
					.getTargetBlock(null, 200);

			CraftPig pig = (CraftPig) p.getWorld().spawnEntity(
					target.getLocation().add(0, 2, 0), EntityType.PIG);
			
			CraftSkeleton skeleton = (CraftSkeleton) p.getWorld().spawnEntity(
					target.getLocation().add(0, 2, 0), EntityType.SKELETON);
			
			skeleton.setMaxHealth(100000000);
			skeleton.setHealth(skeleton.getMaxHealth());
			skeleton.getHandle().setOnFire(100000000);
			skeleton.getHandle().setSkeletonType(0);
			skeleton.getHandle().setEquipment(0, new ItemStack(net.minecraft.server.v1_4_R1.Item.BOW));
			skeleton.getHandle().a(new NBTTagCompound());
	
			
			pig.setMaxHealth(1000000000);
			pig.getHandle().setHealth(pig.getMaxHealth());
			//pig.getHandle().setPathEntity(pathentity);
			//pig.getHandle().move(sender.getServer().getPlayer(sender.getName()).getLocation().getX(), sender.getServer().getPlayer(sender.getName()).getLocation().getY(),sender.getServer().getPlayer(sender.getName()).getLocation().getZ());
			pig.setPassenger(skeleton);

			skeleton.getHandle().setOnFire(1000000000);

			// return true;

		}

		return false;
	}
}
