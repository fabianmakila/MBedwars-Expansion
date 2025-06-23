package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.arena.Arena;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ArenaAuthorsPlaceholder extends ArenaPlaceholder {
	@Override
	protected Tag resolve(Arena arena, ArgumentQueue queue, Context context) {
		String[] authors = arena.getAuthors();
		if (authors == null || authors.length < 1) {
			return Tag.preProcessParsed("Unknown author");
		}

		return Tag.preProcessParsed(String.join(", ", authors));
	}
}
