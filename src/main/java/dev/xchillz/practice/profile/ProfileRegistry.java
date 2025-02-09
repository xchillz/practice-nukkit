package dev.xchillz.practice.profile;

import cn.nukkit.Player;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ProfileRegistry {

    private static final Map<UUID, Profile> profiles = new HashMap<>();

    public static void registerProfile(@NonNull Player player) {
        UUID uuid = ProfileRegistry.getPlayerUUID(player);

        profiles.put(uuid, Profile
                .builder()
                .uuid(uuid)
                .name(player.getName()).build());
    }

    public static Profile fetchProfile(@NonNull Player player) {
        return profiles.get(ProfileRegistry.getPlayerUUID(player));
    }

    public static void clearProfile(@NonNull Player player) {
        profiles.remove(ProfileRegistry.getPlayerUUID(player));
    }

    private static UUID getPlayerUUID(@NonNull Player player) {
        return UUID.nameUUIDFromBytes(player.getName().toLowerCase().getBytes());
    }
}
