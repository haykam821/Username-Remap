package io.github.haykam821.usernameremap.config;

import java.util.HashMap;
import java.util.Map;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "usernameremap")
@Config.Gui.Background("minecraft:textures/block/yellow_wool.png")
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip(count = 2)
	public Map<String, String> remappedUsernames = new HashMap<>();

	@ConfigEntry.Gui.Tooltip(count = 3)
	public String fallbackUsername = null;
}
