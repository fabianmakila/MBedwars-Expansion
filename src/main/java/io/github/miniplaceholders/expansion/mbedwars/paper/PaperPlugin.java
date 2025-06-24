package io.github.miniplaceholders.expansion.mbedwars.paper;

import de.marcely.bedwars.api.BedwarsAPI;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.mbedwars.paper.arena.*;
import io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.*;
import io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team.PlayerArenaTeamColorPlaceholder;
import io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team.PlayerArenaTeamDisplayNamePlaceholder;
import io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team.PlayerArenaTeamInitialsPlaceholder;
import io.github.miniplaceholders.expansion.mbedwars.paper.playerarena.team.PlayerArenaTeamStatusPlaceholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class PaperPlugin extends JavaPlugin {
	private Expansion expansion;

	@Override
	public void onEnable() {
		this.getSLF4JLogger().info("Starting MBedwars Expansion for Paper");

		final int supportedAPIVersion = 203; // find the correct number in the tab "Table of API Versions"
		final String supportedVersionName = "5.5.3"; // update this accordingly to the number, otherwise the error will be wrong

		try {
			Class<?> apiClass = Class.forName("de.marcely.bedwars.api.BedwarsAPI");
			int apiVersion = (int) apiClass.getMethod("getAPIVersion").invoke(null);

			if (apiVersion < supportedAPIVersion)
				throw new IllegalStateException();
		} catch (Exception e) {
			getSLF4JLogger().warn("Sorry, your installed version of MBedwars is not supported. Please install at least v" + supportedVersionName);
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}

		this.expansion = Expansion.builder("mbedwars")
				.filter(Player.class)
				.globalPlaceholder("arena_authors", new ArenaAuthorsPlaceholder())
				.globalPlaceholder("arena_displayname", new ArenaDisplayNamePlaceholder())
				.globalPlaceholder("arena_maxplayers", new ArenaMaxPlayersPlaceholder())
				.globalPlaceholder("arena_minplayers", new ArenaMinPlayersPlaceholder())
				.globalPlaceholder("arena_playercount", new ArenaPlayerCountPlaceholder())
				.globalPlaceholder("arena_status", new ArenaStatusPlaceholder())
				.globalPlaceholder("arena_teamcount", new ArenaTeamCountPlaceholder())
				.globalPlaceholder("arena_teamsize", new ArenaTeamSizePlaceholder())
				.audiencePlaceholder("playerarena_team_color", new PlayerArenaTeamColorPlaceholder())
				.audiencePlaceholder("playerarena_team_displayname", new PlayerArenaTeamDisplayNamePlaceholder())
				.audiencePlaceholder("playerarena_team_initials", new PlayerArenaTeamInitialsPlaceholder())
				.audiencePlaceholder("playerarena_team_status", new PlayerArenaTeamStatusPlaceholder())
				.audiencePlaceholder("playerarena_authors", new PlayerArenaAuthorsPlaceholder())
				.audiencePlaceholder("playerarena_countdown", new PlayerArenaCountdownPlaceholder())
				.audiencePlaceholder("playerarena_displayname", new PlayerArenaDisplayNamePlaceholder())
				.audiencePlaceholder("playerarena_maxplayers", new PlayerArenaMaxPlayersPlaceholder())
				.audiencePlaceholder("playerarena_minplayers", new PlayerArenaMinPlayersPlaceholder())
				.audiencePlaceholder("playerarena_name", new PlayerArenaNamePlaceholder())
				.audiencePlaceholder("playerarena_playercount", new PlayerArenaPlayerCountPlaceholder())
				.audiencePlaceholder("playerarena_runningtime", new PlayerArenaRunningTimePlaceholder())
				.audiencePlaceholder("playerarena_status", new PlayerArenaStatusPlaceholder())
				.audiencePlaceholder("playerarena_teamcount", new PlayerArenaTeamCountPlaceholder())
				.audiencePlaceholder("playerarena_teamsize", new PlayerArenaTeamSizePlaceholder())
				.build();

		BedwarsAPI.onReady(() -> this.expansion.register());
	}
}
