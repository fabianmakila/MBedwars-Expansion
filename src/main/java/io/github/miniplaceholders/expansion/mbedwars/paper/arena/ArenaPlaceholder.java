package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.function.BiFunction;

public abstract class ArenaPlaceholder implements BiFunction<ArgumentQueue, Context, Tag> {
	protected static final LegacyComponentSerializer LEGACY_COMPONENT_SERIALIZER = LegacyComponentSerializer.legacyAmpersand();

	@Override
	public Tag apply(ArgumentQueue queue, Context context) {
		if (!queue.hasNext()) {
			return Tag.preProcessParsed("You need to provide arena name");
		}

		String arenaName = queue.pop().value();

		Arena arena = BedwarsAPI.getGameAPI().getArenaByName(arenaName);
		if (arena == null) {
			return Tag.preProcessParsed("Unknown arena");
		}

		return arenaTag(arena, queue, context);
	}

	protected abstract Tag arenaTag(Arena arena, ArgumentQueue queue, Context context);
}
