package dev.xchillz.practice.item;


import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CustomItem {

    @Getter
    private final String id;

    private final int itemId;
    private final int count;

    private final Integer meta;

    private final String customName;

    public Item toItem() {
        Item item = Item.get(this.itemId, this.meta, this.count);

        item.setCustomName(this.customName);

        item.setNamedTag(item.getNamedTag().putString("custom_item", this.id));

        return item;
    }

    public abstract void onDamage(EntityDamageEvent event);

    public abstract void onInteract(PlayerInteractEvent event);

}
