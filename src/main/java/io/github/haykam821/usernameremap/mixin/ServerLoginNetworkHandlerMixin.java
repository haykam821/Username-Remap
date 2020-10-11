package io.github.haykam821.usernameremap.mixin;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.usernameremap.Main;
import net.minecraft.network.packet.c2s.login.LoginHelloC2SPacket;
import net.minecraft.server.network.ServerLoginNetworkHandler;

@Mixin(ServerLoginNetworkHandler.class)
public class ServerLoginNetworkHandlerMixin {
	@Redirect(method = "onHello", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/c2s/login/LoginHelloC2SPacket;getProfile()Lcom/mojang/authlib/GameProfile;"))
	private GameProfile remapGameProfile(LoginHelloC2SPacket packet) {
		GameProfile originalProfile = packet.getProfile();
		return new GameProfile(originalProfile.getId(), Main.getRemappedUsername(originalProfile.getName()));
	}
}