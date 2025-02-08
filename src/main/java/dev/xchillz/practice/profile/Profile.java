package dev.xchillz.practice.profile;

import cn.nukkit.Player;
import cn.nukkit.Server;
import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public final class Profile {

  private final UUID uuid;
  private final String name;

  private ProfileState state;

  public @NonNull Optional<Player> toPlayer() {
    return Optional.ofNullable(Server.getInstance().getPlayerExact(this.name));
  }
}
