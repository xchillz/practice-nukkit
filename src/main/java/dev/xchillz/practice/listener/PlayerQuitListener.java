package dev.xchillz.practice.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import dev.xchillz.practice.profile.ProfileRegistry;
import lombok.NonNull;

public final class PlayerQuitListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(@NonNull PlayerQuitEvent event) {
        ProfileRegistry.clearProfile(event.getPlayer());
    }
}
