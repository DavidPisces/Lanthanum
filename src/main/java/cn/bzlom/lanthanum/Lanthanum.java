package cn.bzlom.lanthanum;

import cn.bzlom.lanthanum.event.PlayerTickHandler;
import cn.bzlom.lanthanum.networking.ModMessage;
import cn.bzlom.lanthanum.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lanthanum implements ModInitializer {
    public static final String MOD_ID = "lanthanum";
    public static final Logger LOGGER = LoggerFactory.getLogger("Lanthanum");


    @Override
    public void onInitialize() {
        ModItemGroup.registerModItemGroup();
        ModItems.registerItems();
        ModBlocks.registerModBlocks();
        ModOreGen.generateOres();
        ModPortal.portalBuilder();
        ModMessage.registerS2CPackets();
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
    }
}