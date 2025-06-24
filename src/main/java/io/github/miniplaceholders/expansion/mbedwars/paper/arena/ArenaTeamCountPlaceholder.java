package io.github.miniplaceholders.expansion.mbedwars.paper.arena;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

import java.util.Set;

public final class ArenaTeamCountPlaceholder extends ArenaPlaceholder {
	@Override
	protected Tag arenaTag(Arena arena, ArgumentQueue queue, Context context) {
		Set<Team> teams = arena.getEnabledTeams();
		if (teams == null) {
			return Tag.preProcessParsed("0");
		}

		return Tag.preProcessParsed(String.valueOf(arena.getEnabledTeams()));
	}
}
