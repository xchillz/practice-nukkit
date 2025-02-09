package dev.xchillz.practice.item;

import cn.nukkit.item.Item;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public final class ItemRegistry {

    private final Map<String, CustomItem> customItems = new HashMap<>();

    public void registerItem(CustomItem customItem) {
        this.customItems.put(customItem.getId(), customItem);
    }

    public @NonNull Item getItem(String id) {
        if (!this.customItems.containsKey(id)) {
            throw new RuntimeException(String.format("No item with id '%s'", id));
        }

        return this.customItems.get(id).toItem();
    }

}
