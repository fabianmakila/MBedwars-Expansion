package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ArenaMaxPlayersPlaceholder extends ArenaPlaceholder {
	@Override
	protected Tag arenaTag(Arena arena, ArgumentQueue queue, Context context) {
		return Tag.preProcessParsed(String.valueOf(arena.getMaxPlayers()));
	}
}
