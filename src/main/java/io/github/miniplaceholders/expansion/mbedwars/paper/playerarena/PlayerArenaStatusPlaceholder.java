package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.ArenaStatus;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

public final class PlayerArenaStatusPlaceholder extends PlayerArenaPlaceholder {
	@Override
	protected Tag resolve(Player player, Arena arena, ArgumentQueue queue, Context context) {
		ArenaStatus status = arena.getStatus();
		if (status == null) {
			return Tag.preProcessParsed("Unknown status");
		}

		String signName = status.getSignName();
		if (signName == null) {
			return Tag.preProcessParsed(status.toString());
		}

		Component deserialized = LEGACY_COMPONENT_SERIALIZER.deserialize(signName);
		return Tag.selfClosingInserting(deserialized);
	}
}
