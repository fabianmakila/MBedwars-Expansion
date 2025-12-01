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

		final int supportedAPIVersion = 205; // find the correct number in the tab "Table of API Versions"
		final String supportedVersionName = "5.5.5"; // update this accordingly to the number, otherwise the error will be wrong

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
				.globalPlaceholder("arena_authors", new ArenaAuthorsPlaceholder())
				.globalPlaceholder("arena_displayname", new ArenaDisplayNamePlaceholder())
				.globalPlaceholder("arena_maxplayers", new ArenaMaxPlayersPlaceholder())
				.globalPlaceholder("arena_minplayers", new ArenaMinPlayersPlaceholder())
				.globalPlaceholder("arena_playercount", new ArenaPlayerCountPlaceholder())
				.globalPlaceholder("arena_status", new ArenaStatusPlaceholder())
				.globalPlaceholder("arena_teamcount", new ArenaTeamCountPlaceholder())
				.globalPlaceholder("arena_teamsize", new ArenaTeamSizePlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_team_color", new PlayerArenaTeamColorPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_team_displayname", new PlayerArenaTeamDisplayNamePlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_team_initials", new PlayerArenaTeamInitialsPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_team_status", new PlayerArenaTeamStatusPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_authors", new PlayerArenaAuthorsPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_countdown", new PlayerArenaCountdownPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_displayname", new PlayerArenaDisplayNamePlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_maxplayers", new PlayerArenaMaxPlayersPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_minplayers", new PlayerArenaMinPlayersPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_name", new PlayerArenaNamePlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_playercount", new PlayerArenaPlayerCountPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_runningtime", new PlayerArenaRunningTimePlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_status", new PlayerArenaStatusPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_teamcount", new PlayerArenaTeamCountPlaceholder())
				.audiencePlaceholder(Player.class, "playerarena_teamsize", new PlayerArenaTeamSizePlaceholder())
				.build();

		BedwarsAPI.onReady(() -> this.expansion.register());
	}
}
