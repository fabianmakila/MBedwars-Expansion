package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.PlayerArenaPlaceholder;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;

public abstract class PlayerArenaTeamPlaceholder extends PlayerArenaPlaceholder {
	@Override
	protected Tag playerArenaTag(Player player, Arena arena, ArgumentQueue queue, Context context) {
		Team team;
		if (queue.hasNext()) {
			team = Team.getByName(queue.pop().value());
			if (team == null) {
				return Tag.preProcessParsed("Unknown team");
			}
		} else {
			team = arena.getPlayerTeam(player);
			if (team == null) {
				return Tag.preProcessParsed("");
			}
		}

		return playerArenaTeamTag(player, arena, team);
	}

	protected abstract Tag playerArenaTeamTag(Player player, Arena arena, Team team);
}
