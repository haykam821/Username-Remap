package io.github.haykam821.usernameremap.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import io.github.haykam821.usernameremap.Main;
import net.minecraft.server.integrated.IntegratedServer;

@Mixin(IntegratedServer.class)
public class IntegratedServerMixin {
	@ModifyArg(method = "isHost", at = @At(value = "INVOKE", target = "Ljava/lang/String;equalsIgnoreCase(Ljava/lang/String;)Z"), index = 0)
	private String remapHostCheckGameProfile(String originalUsername) {
		return Main.getRemappedUsername(originalUsername);
	}
}