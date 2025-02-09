package dev.xchillz.practice.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import dev.xchillz.practice.profile.ProfileRegistry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class PlayerJoinListener implements Listener {

    private final ProfileRegistry profileRegistry;

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(@NonNull PlayerJoinEvent event) {
        this.profileRegistry.registerProfile(event.getPlayer());
    }
}
