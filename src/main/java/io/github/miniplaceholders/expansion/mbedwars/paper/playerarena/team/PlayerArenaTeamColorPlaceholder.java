package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team;

import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import io.github.miniplaceholders.expansion.mbedwars.paper.Placeholder;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class PlayerArenaTeamColorPlaceholder extends Placeholder implements AudienceTagResolver<@NotNull Player> {
	@Override
	public @NotNull Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context context) {
		Arena arena = BedwarsAPI.getGameAPI().getArenaByPlayer(player);
		if (arena == null) {
			return Tag.styling();
		}

		Team team;
		if (queue.hasNext()) {
			team = Team.getByName(queue.pop().value());
		} else {
			team = arena.getPlayerTeam(player);
		}

		if (team == null) {
			return Tag.styling();
		}

		return Tag.styling(builder -> builder.color(TextColor.color(team.getBungeeChatColor().getColor().getRGB())));
	}
}
