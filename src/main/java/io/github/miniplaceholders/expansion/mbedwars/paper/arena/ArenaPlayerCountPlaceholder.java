package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

import java.util.Collection;

public final class ArenaPlayerCountPlaceholder extends ArenaPlaceholder {
	@Override
	protected Tag resolve(Arena arena, ArgumentQueue queue, Context context) {
		int playerCount = 0;
		Collection<Player> players = arena.getPlayers();
		if (players != null) {
			playerCount = players.size();
		}

		return Tag.preProcessParsed(String.valueOf(playerCount));
	}
}
