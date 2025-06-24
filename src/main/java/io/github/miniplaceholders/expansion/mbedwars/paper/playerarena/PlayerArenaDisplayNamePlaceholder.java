package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena;

import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

public final class PlayerArenaDisplayNamePlaceholder extends PlayerArenaPlaceholder {
	@Override
	protected Tag playerArenaTag(Player player, Arena arena, ArgumentQueue queue, Context context) {
		return Tag.preProcessParsed(arena.getDisplayName());
	}
}
