package dev.xchillz.practice;

import cn.nukkit.plugin.PluginBase;
import dev.xchillz.practice.listener.PlayerJoinListener;
import dev.xchillz.practice.listener.PlayerQuitListener;

public final class PracticePlugin extends PluginBase {

  @Override
  public void onEnable() {
    this.saveDefaultConfig();

    this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
  }
}
