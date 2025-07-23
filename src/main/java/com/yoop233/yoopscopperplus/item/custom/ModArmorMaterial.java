package com.yoop233.yoopscopperplus.item.custom;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterial {
    public static final Holder<ArmorMaterial> COPPER_ARMOR_MATERIAL = register("copper",
            Util.make(new EnumMap<>(ArmorItem.Type.class),attributes -> {
                attributes.put(ArmorItem.Type.HELMET, 2);
                attributes.put(ArmorItem.Type.CHESTPLATE, 6);
                attributes.put(ArmorItem.Type.LEGGINGS, 4);
                attributes.put(ArmorItem.Type.BOOTS, 2);
                attributes.put(ArmorItem.Type.BODY, 4);
            }),20,0,SoundEvents.ARMOR_EQUIP_IRON,0, () -> Items.COPPER_INGOT);





    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type,Integer> typeProtections,
                                                  int enchantability, float toughness,Holder<SoundEvent> equipSound,
                                                  float knockbackResistance, Supplier<Item> ingredientItem){
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath("yoopscopperplus",name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type,Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for(ArmorItem.Type type : ArmorItem.Type.values()){
            typeMap.put(type, typeProtections.get(type));
        }
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtections, enchantability, equipSound,
                ingredient,layers, toughness, knockbackResistance));
    }




}
