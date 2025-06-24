package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import de.marcely.bedwars.api.message.Message;
import net.kyori.adventure.text.minimessage.tag.Tag;
import org.bukkit.entity.Player;

public final class PlayerArenaTeamStatusPlaceholder extends PlayerArenaTeamPlaceholder {
	@Override
	protected Tag playerArenaTeamTag(Player player, Arena arena, Team team) {
		Message message;
		if (arena.getAliveTeams().contains(team)) {
			message = Message.buildByKey("Scoreboard_BedState_Alive");
		} else {
			message = Message.buildByKey("Scoreboard_BedState_Destroyed");
		}

		String serialized = message.getRawMessage(player.locale().toString());
		return Tag.selfClosingInserting(LEGACY_COMPONENT_SERIALIZER.deserialize(serialized));
	}
}
