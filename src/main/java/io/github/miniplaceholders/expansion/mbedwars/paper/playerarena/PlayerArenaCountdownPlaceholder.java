package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.ArenaStatus;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

//TODO Display the time in hh:ss format
public final class PlayerArenaCountdownPlaceholder extends PlayerArenaPlaceholder {
	@Override
	protected Tag playerArenaTag(Player player, Arena arena, ArgumentQueue queue, Context context) {
		if (arena.getStatus() == ArenaStatus.LOBBY) {
			return Tag.preProcessParsed(String.valueOf(arena.getLobbyTimeRemaining()));
		}
		return Tag.preProcessParsed(String.valueOf(arena.getIngameTimeRemaining()));
	}
}
