package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.StringJoiner;

public final class ArenaPlayersPlaceholder extends ArenaPlaceholder {
	@Override
	protected Tag resolve(Arena arena, ArgumentQueue queue, Context context) {
		Collection<Player> players = arena.getPlayers();
		if (players.isEmpty()) {
			return Tag.preProcessParsed("Arena is empty");
		}

		StringJoiner joiner = new StringJoiner(", ");
		players.forEach(player -> joiner.add(player.getName()));

		return Tag.preProcessParsed(joiner.toString());
	}
}
