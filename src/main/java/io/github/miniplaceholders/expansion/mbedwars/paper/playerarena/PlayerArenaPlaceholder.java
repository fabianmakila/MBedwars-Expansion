package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena;

import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import io.github.miniplaceholders.expansion.mbedwars.paper.Placeholder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PlayerArenaPlaceholder extends Placeholder implements AudienceTagResolver<@NotNull Player> {
	@Override
	public @Nullable Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context context) {
		Arena arena = BedwarsAPI.getGameAPI().getArenaByPlayer(player);
		if (arena == null) {
			String serialized = BedwarsAPI.getConfigurationAPI().getValue("placeholderapi-not-inside-arena").toString();

			Component deserialized = LEGACY_COMPONENT_SERIALIZER.deserialize(serialized);
			return Tag.selfClosingInserting(deserialized);
		}

		return playerArenaTag(player, arena, queue, context);
	}

	protected abstract Tag playerArenaTag(Player player, Arena arena, ArgumentQueue queue, Context context);
}
