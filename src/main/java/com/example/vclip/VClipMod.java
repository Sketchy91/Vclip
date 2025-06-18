package com.example.vclip;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;

import com.mojang.brigadier.arguments.DoubleArgumentType;

public class VClipMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandManager.DISPATCHER.register(
            literal(".vclip")
            .then(argument("distance", DoubleArgumentType.doubleArg())
                .executes(ctx -> {
                    double dist = DoubleArgumentType.getDouble(ctx, "distance");
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc.player != null) {
                        mc.player.requestTeleport(
                            mc.player.getX(),
                            mc.player.getY() + dist,
                            mc.player.getZ()
                        );
                        mc.player.sendMessage(Text.of("✅ VClipped by " + dist + " blocks."), false);
                    }
                    return 1;
                })
            )
        );
    }
}