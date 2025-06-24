package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena;

import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

import java.util.Collection;

public final class PlayerArenaPlayerCountPlaceholder extends PlayerArenaPlaceholder {
	@Override
	protected Tag playerArenaTag(Player player, Arena arena, ArgumentQueue queue, Context context) {
		Collection<Player> players = arena.getPlayers();
		if (players == null) {
			return Tag.preProcessParsed("0");
		}

		return Tag.preProcessParsed(String.valueOf(players.size()));
	}
}
