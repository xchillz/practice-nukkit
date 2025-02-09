package dev.xchillz.practice.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import dev.xchillz.practice.profile.ProfileRegistry;
import lombok.NonNull;

public final class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(@NonNull PlayerJoinEvent event) {
        ProfileRegistry.registerProfile(event.getPlayer());
    }
}
