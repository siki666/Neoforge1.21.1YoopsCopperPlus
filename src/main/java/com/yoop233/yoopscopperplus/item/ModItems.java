package com.yoop233.yoopscopperplus.item;

import com.yoop233.yoopscopperplus.YoopsCopperPlus;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YoopsCopperPlus.MOD_ID);
    //COPPER_TIER
    public static final Tier COPPER_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            200,
            5F,
            1.5F,
            20,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );

    //更多矿物粒
    public static final DeferredItem<Item>  COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));//铜粒
    public static final DeferredItem<Item>  DIAMOND_NUGGET = ITEMS.register("diamond_nugget",
            () -> new Item(new Item.Properties()));//钻石粒
    public static final DeferredItem<Item>  EMERALD_NUGGET = ITEMS.register("emerald_nugget",
            () -> new Item(new Item.Properties()));//绿宝石粒
    public static final DeferredItem<Item>  COAL_CRUMB = ITEMS.register("coal_crumb",
            () -> new Item(new Item.Properties()));//煤屑

    //铜工具
    public static final DeferredItem<Item>  COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(
            COPPER_TIER,
            new Item.Properties().attributes(
                    SwordItem.createAttributes(
                            COPPER_TIER,
                            3,
                            -2.4f
                    )
            )
    ));
    public static final DeferredItem<Item>  COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(
            COPPER_TIER,
            new Item.Properties().attributes(
                    AxeItem.createAttributes(
                            COPPER_TIER,
                            4.5f,
                            -2.0f
                    )
            )
    ));
    public static final DeferredItem<Item>  COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(
            COPPER_TIER,
            new Item.Properties().attributes(
                    PickaxeItem.createAttributes(
                            COPPER_TIER,
                            1.5f,
                            -2.8f
                    )
            )
    ));
    public static final DeferredItem<Item>  COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(
            COPPER_TIER,
            new Item.Properties().attributes(
                    HoeItem.createAttributes(
                            COPPER_TIER,
                            0.5f,
                            -3.0f
                    ))
    ));
    public static final DeferredItem<Item>  COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(
            COPPER_TIER,
            new Item.Properties().attributes(
                    ShovelItem.createAttributes(
                            COPPER_TIER,
                            1.5f,
                            -3.0f
                    ))
    ));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
