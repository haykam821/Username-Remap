package io.github.haykam821.usernameremap;

import io.github.haykam821.usernameremap.config.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	private static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();

	@Override
	public void onInitialize() {
		return;
	}
	
	public static ModConfig getConfig() {
		return CONFIG;
	}

	public static String getRemappedUsername(String originalUsername) {
		String remappedUsername = CONFIG.remappedUsernames.get(originalUsername);
		if (remappedUsername != null) return remappedUsername;
		
		if (CONFIG.fallbackUsername != null) return CONFIG.fallbackUsername;
		return originalUsername;
	}
}