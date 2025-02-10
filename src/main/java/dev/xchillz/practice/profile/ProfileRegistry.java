package dev.xchillz.practice.profile;

import cn.nukkit.Player;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ProfileRegistry {

    private final Map<UUID, Profile> profiles = new HashMap<>();

    public void registerProfile(@NonNull Player player) {
        UUID uuid = this.getPlayerUUID(player);

        this.profiles.put(uuid, new Profile(uuid, player.getName()));
    }

    public Profile fetchProfile(@NonNull Player player) {
        return this.profiles.get(this.getPlayerUUID(player));
    }

    public void clearProfile(@NonNull Player player) {
        this.profiles.remove(this.getPlayerUUID(player));
    }

    private UUID getPlayerUUID(@NonNull Player player) {
        return UUID.nameUUIDFromBytes(player.getName().toLowerCase().getBytes());
    }
}
