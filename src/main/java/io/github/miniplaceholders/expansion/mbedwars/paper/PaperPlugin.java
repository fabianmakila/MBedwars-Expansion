package io.github.miniplaceholders.expansion.mbedwars.paper;

import de.marcely.bedwars.api.BedwarsAPI;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.mbedwars.paper.arena.*;
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
			Class apiClass = Class.forName("de.marcely.bedwars.api.BedwarsAPI");
			int apiVersion = (int) apiClass.getMethod("getAPIVersion").invoke(null);

			if (apiVersion < supportedAPIVersion)
				throw new IllegalStateException();
		} catch (Exception e) {
			getLogger().warning("Sorry, your installed version of MBedwars is not supported. Please install at least v" + supportedVersionName);
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
				.globalPlaceholder("arena_players", new ArenaPlayersPlaceholder())
				.build();

		BedwarsAPI.onReady(() -> this.expansion.register());
	}
}
