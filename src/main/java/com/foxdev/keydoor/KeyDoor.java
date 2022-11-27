package com.foxdev.keydoor;

import com.foxdev.keydoor.Commands.GetKey;
import com.foxdev.keydoor.Interaction.GetDoor;
import org.bukkit.plugin.java.JavaPlugin;

public final class KeyDoor extends JavaPlugin {

    public static KeyDoor Instance;

    @Override
    public void onEnable() {
Instance = this;
        getCommand("getkey").setExecutor(new GetKey());
        getServer().getPluginManager().registerEvents(new GetDoor(this), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
