package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.ArenaStatus;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ArenaStatusPlaceholder extends ArenaPlaceholder {
	@Override
	protected Tag resolve(Arena arena, ArgumentQueue queue, Context context) {
		ArenaStatus status = arena.getStatus();
		if (status == null) {
			return Tag.preProcessParsed("Unknown status");
		}

		String signName = status.getSignName();
		if (signName == null) {
			return Tag.preProcessParsed(status.toString());
		}

		return Tag.preProcessParsed(signName);
	}
}
