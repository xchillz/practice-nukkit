package dev.xchillz.practice;

import cn.nukkit.plugin.PluginBase;
import dev.xchillz.practice.item.ItemRegistry;
import dev.xchillz.practice.listener.PlayerJoinListener;
import dev.xchillz.practice.listener.PlayerQuitListener;
import dev.xchillz.practice.profile.ProfileRegistry;

public final class PracticePlugin extends PluginBase {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        ProfileRegistry profileRegistry = new ProfileRegistry();
        ItemRegistry itemRegistry = new ItemRegistry();

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(profileRegistry), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(profileRegistry), this);
    }
}
