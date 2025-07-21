package com.yoop233.yoopscopperplus.item;

import com.yoop233.yoopscopperplus.YoopsCopperPlus;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YoopsCopperPlus.MOD_ID);

    public static final DeferredItem<Item>  COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));//铜粒
    public static final DeferredItem<Item>  DIAMOND_NUGGET = ITEMS.register("diamond_nugget",
            () -> new Item(new Item.Properties()));//钻石粒
    public static final DeferredItem<Item>  EMERALD_NUGGET = ITEMS.register("emerald_nugget",
            () -> new Item(new Item.Properties()));//绿宝石粒
    public static final DeferredItem<Item>  COAL_CRUMB = ITEMS.register("coal_crumb",
            () -> new Item(new Item.Properties()));//煤屑

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
