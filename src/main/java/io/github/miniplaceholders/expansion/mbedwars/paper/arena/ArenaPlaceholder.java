package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import io.github.miniplaceholders.api.resolver.GlobalTagResolver;
import io.github.miniplaceholders.expansion.mbedwars.paper.Placeholder;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public abstract class ArenaPlaceholder extends Placeholder implements GlobalTagResolver {
	@Override
	public Tag tag(ArgumentQueue queue, @NotNull Context context) {
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
