package dev.xchillz.practice.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import dev.xchillz.practice.item.ItemRegistry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class PlayerInteractListener implements Listener {

    private final ItemRegistry itemRegistry;

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerInteract(@NonNull PlayerInteractEvent event) {
        Item item = event.getItem();

        if (item.hasCompoundTag() && item.getNamedTag().exist("custom_item")) {
            this.itemRegistry.getItem(item.getNamedTag().getString("custom_item")).onInteract(event);
        }
    }

}
