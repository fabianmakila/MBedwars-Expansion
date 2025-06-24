package io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.Team;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.tag.Tag;
import org.bukkit.entity.Player;

public final class PlayerArenaTeamColorPlaceholder extends PlayerArenaTeamPlaceholder {
	@Override
	protected Tag playerArenaTeamTag(Player player, Arena arena, Team team) {
		return Tag.inserting(Component.text().color(TextColor.color(team.getBukkitColor().asRGB())));
	}
}
