package com.yoop233.yoopscopperplus;

import com.yoop233.yoopscopperplus.block.ModBlocks;
import com.yoop233.yoopscopperplus.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(YoopsCopperPlus.MOD_ID)
public class YoopsCopperPlus {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "yoopscopperplus";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public YoopsCopperPlus(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.COPPER_NUGGET);
            event.accept(ModItems.DIAMOND_NUGGET);
            event.accept(ModItems.EMERALD_NUGGET);
            event.accept(ModItems.COAL_CRUMB);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.COPPER_AXE);
            event.accept(ModItems.COPPER_PICKAXE);
            event.accept(ModItems.COPPER_HOE);
            event.accept(ModItems.COPPER_SHOVEL);
            event.accept(ModItems.COPPER_CHISEL);
            event.accept(ModItems.EMERALD_AXE);
            event.accept(ModItems.EMERALD_PICKAXE);
            event.accept(ModItems.EMERALD_HOE);
            event.accept(ModItems.EMERALD_SHOVEL);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(ModItems.COPPER_SWORD);
            event.accept(ModItems.COPPER_HELMET);
            event.accept(ModItems.COPPER_CHESTPLATE);
            event.accept(ModItems.COPPER_LEGGINGS);
            event.accept(ModItems.COPPER_BOOTS);
        }
        if(event.getTabKey() == CreativeModeTabs.OP_BLOCKS){
            event.accept(ModBlocks.UNKNOWN);
        }
        LOGGER.info("creative tab contents finished");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
