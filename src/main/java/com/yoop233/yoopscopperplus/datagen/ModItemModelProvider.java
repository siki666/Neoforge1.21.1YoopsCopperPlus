package com.yoop233.yoopscopperplus.datagen;

import com.yoop233.yoopscopperplus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "yoopscopperplus", existingFileHelper);
    }

    @Override
    protected  void registerModels() {
        basicItem(ModItems.COAL_CRUMB.get());
        basicItem(ModItems.COPPER_NUGGET.get());
        basicItem(ModItems.DIAMOND_NUGGET.get());
        basicItem(ModItems.EMERALD_NUGGET.get());
        basicItem(ModItems.COPPER_CHISEL.get());
        basicItem(ModItems.COPPER_SWORD.get());
        basicItem(ModItems.COPPER_AXE.get());
        basicItem(ModItems.COPPER_PICKAXE.get());
        basicItem(ModItems.COPPER_HOE.get());
        basicItem(ModItems.COPPER_SHOVEL.get());
        basicItem(ModItems.COPPER_HELMET.get());
        basicItem(ModItems.COPPER_CHESTPLATE.get());
        basicItem(ModItems.COPPER_LEGGINGS.get());
        basicItem(ModItems.COPPER_BOOTS.get());
    }
}
