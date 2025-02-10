package dev.xchillz.practice.listener;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.item.Item;
import dev.xchillz.practice.item.ItemRegistry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class EntityDamageByEntityListener implements Listener {

    private final ItemRegistry itemRegistry;

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityDamage(@NonNull EntityDamageEvent event) {
        if (!(event instanceof EntityDamageByEntityEvent)) {
            return;
        }

        Entity attacker = ((EntityDamageByEntityEvent) event).getDamager();
        Entity attacked = event.getEntity();

        if (!(attacker instanceof Player) || !(attacked instanceof Player)) {
            return;
        }

        Item item = ((Player) attacker).getInventory().getItemInHand();

        if (item.hasCompoundTag() && item.getNamedTag().exist("custom_item")) {
            this.itemRegistry.getItem(item.getNamedTag().getString("custom_item")).onAttack((EntityDamageByEntityEvent) event);
        }
    }

}
