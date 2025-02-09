package dev.xchillz.practice.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import dev.xchillz.practice.profile.ProfileRegistry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class PlayerQuitListener implements Listener {

    private final ProfileRegistry profileRegistry;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(@NonNull PlayerQuitEvent event) {
        this.profileRegistry.clearProfile(event.getPlayer());
    }
}
