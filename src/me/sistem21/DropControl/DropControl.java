package me.sistem21.DropControl;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DropControl extends JavaPlugin implements Listener{
	
	static DropControl plugin;
	static FileConfiguration config;
	
	public void onEnable(){
		plugin = this;
		saveDefaultConfig();
		config = getConfig();
	}
	
	@EventHandler
	public void on(EntityDeathEvent e){
		Entity en = e.getEntity();
		
		if(config.getBoolean("DropControl")){
		
		
			if(en instanceof PigZombie){
			
			
				Random r = new Random();
			
				double chance = config.getDouble("dropChancePigZombie")/100;
			
				int amount = r.nextInt(2);
			
				int amount1 = r.nextInt(4);
			
				for(int i = 0; i < e.getDrops().size(); i++){
				
				
					if(chance < 50){
					e.getDrops().set(i, new ItemStack(Material.GOLD_INGOT, amount));
				
					}else{
					
						e.getDrops().set(i, new ItemStack(Material.GOLD_INGOT, amount1));
				
					}
				
				}
			
			}else if(en instanceof IronGolem){
			
				Random r = new Random();
				double chance = config.getDouble("dropChanceIronGolem")/100;
				int amount = r.nextInt(2);
				int amount1 = r.nextInt(4);
				for(int i = 0; i < e.getDrops().size(); i++){
					if(chance < 50){
						e.getDrops().set(i, new ItemStack(Material.IRON_INGOT, amount));
					}else{
						e.getDrops().set(i, new ItemStack(Material.IRON_INGOT, amount1));
					}
			
				}
		
			}
		}else{
			return;
		}
		
		
	}
	
	

}
