package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import net.kyori.adventure.text.minimessage.tag.Tag;
import org.bukkit.entity.Player;

public final class PlayerArenaTeamDisplayNamePlaceholder extends PlayerArenaTeamPlaceholder {
	@Override
	protected Tag playerArenaTeamTag(Player player, Arena arena, Team team) {
		return Tag.preProcessParsed(team.getDisplayName());
	}
}
