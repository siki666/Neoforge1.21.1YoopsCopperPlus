package com.yoop233.yoopscopperplus.item;

import com.yoop233.yoopscopperplus.YoopsCopperPlus;
import com.yoop233.yoopscopperplus.item.custom.ChiselItem;
import com.yoop233.yoopscopperplus.item.custom.ModArmorMaterial;
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
    //EMERALD_TIER
    public static final Tier EMERALD_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            600,
            7F,
            4.5F,
            40,
            () -> Ingredient.of(Tags.Items.GEMS_EMERALD)
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
    //铜凿子
    public static final DeferredItem<Item>  COPPER_CHISEL = ITEMS.register("copper_chisel",
            () -> new ChiselItem(new Item.Properties().durability(120).stacksTo(1).setNoRepair()));
    //铜工具
    public static final DeferredItem<Item>  COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(COPPER_TIER, new Item.Properties().attributes(SwordItem.createAttributes(COPPER_TIER, 3, -2.4f))));
    public static final DeferredItem<Item>  COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(COPPER_TIER, new Item.Properties().attributes(AxeItem.createAttributes(COPPER_TIER, 4.5f, -2.0f))));
    public static final DeferredItem<Item>  COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(COPPER_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(COPPER_TIER, 1.5f, -2.8f))));
    public static final DeferredItem<Item>  COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(COPPER_TIER, new Item.Properties().attributes(HoeItem.createAttributes(COPPER_TIER, 0.5f, -3.0f))));
    public static final DeferredItem<Item>  COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(COPPER_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(COPPER_TIER, 1.5f, -3.0f))));
    //绿宝石工具
    public static final DeferredItem<Item>  EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(EMERALD_TIER, new Item.Properties().attributes(SwordItem.createAttributes(EMERALD_TIER, 3, -2.4f))));
    public static final DeferredItem<Item>  EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(EMERALD_TIER, new Item.Properties().attributes(AxeItem.createAttributes(EMERALD_TIER, 4.5f, -2.0f))));
    public static final DeferredItem<Item>  EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(EMERALD_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(EMERALD_TIER, 1.5f, -2.8f))));
    public static final DeferredItem<Item>  EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(EMERALD_TIER, new Item.Properties().attributes(HoeItem.createAttributes(EMERALD_TIER, 0.5f, -3.0f))));
    public static final DeferredItem<Item>  EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(EMERALD_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(EMERALD_TIER, 1.5f, -3.0f))));

    //铜装备
    public static final DeferredItem<ArmorItem>  COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterial.COPPER_ARMOR_MATERIAL,ArmorItem.Type.HELMET,new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11))));
    public static final DeferredItem<ArmorItem>  COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterial.COPPER_ARMOR_MATERIAL,ArmorItem.Type.CHESTPLATE,new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));
    public static final DeferredItem<ArmorItem>  COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterial.COPPER_ARMOR_MATERIAL,ArmorItem.Type.LEGGINGS,new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final DeferredItem<ArmorItem>  COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterial.COPPER_ARMOR_MATERIAL,ArmorItem.Type.BOOTS,new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(13))));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
