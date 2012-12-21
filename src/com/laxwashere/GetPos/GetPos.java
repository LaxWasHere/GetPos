package com.laxwashere.GetPos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class GetPos extends JavaPlugin {
	public String prefix = "[Headz]";

    @Override
    public void onEnable() {
        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion() + " by LaxWasHere enabled.");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion() + " by LaxWasHere disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return false;
        }
        Player player = (Player) sender;
        if (commandLabel.equalsIgnoreCase("gpos") || commandLabel.equalsIgnoreCase("gp")) {
        	if (player.hasPermission("getpos.pos"))
        		player.sendMessage(ChatColor.RED + "You do not have enough permission to use this command");
        	else;
        	if(args.length == 0){
        		player.sendMessage(ChatColor.RED + "Usage: /gpos <PlayerName>");
        	}else if(args.length == 1){
        		Player targetPlayer = player.getServer ().getPlayer(args[0]);
        		
        		player.sendMessage(ChatColor.GREEN + "Position of " + targetPlayer.getDisplayName());
        		sender.sendMessage(ChatColor.GREEN + "World: " + targetPlayer.getWorld().getName());
        		sender.sendMessage(ChatColor.GREEN + "X: " + targetPlayer.getLocation().getBlockX());
        		sender.sendMessage(ChatColor.GREEN + "Y: " + targetPlayer.getLocation().getBlockY());
        		sender.sendMessage(ChatColor.GREEN + "Z: " + targetPlayer.getLocation().getBlockZ());

        	
        }else { 
    		player.sendMessage(ChatColor.RED + "You do not have enough permission");
    		return true;
    }
    }        	
	return false;
    }
}