package com.yoop233.yoopscopperplus.datagen;

import com.yoop233.yoopscopperplus.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected  void buildRecipes(RecipeOutput recipeOutput){
        //-------------------------------------------------//
        //NUGGETS LISTS                                    //
        //-------------------------------------------------//
        List<ItemLike> DIAMOND_SMELTABLES = List.of(
                Items.DIAMOND,
                Items.DIAMOND_AXE,
                Items.DIAMOND_HOE,
                Items.DIAMOND_PICKAXE,
                Items.DIAMOND_SHOVEL,
                Items.DIAMOND_SWORD,
                Items.DIAMOND_HELMET,
                Items.DIAMOND_CHESTPLATE,
                Items.DIAMOND_LEGGINGS,
                Items.DIAMOND_BOOTS
        );

        List<ItemLike> COPPER_SMELTABLES = List.of(
                Items.COPPER_INGOT,
                ModItems.COPPER_CHISEL.get(),
                ModItems.COPPER_SWORD.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_HOE.get(),
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_HELMET.get(),
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COPPER_BOOTS.get()
        );

        List<ItemLike> EMERALD_SMELTABLES = List.of(
                Items.EMERALD,
                ModItems.EMERALD_AXE.get(),
                ModItems.EMERALD_HOE.get(),
                ModItems.EMERALD_PICKAXE.get(),
                ModItems.EMERALD_SHOVEL.get()
        );

        //-------------------------------------------------//
        //COPPER RECIPES                                   //
        //-------------------------------------------------//
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.COPPER_CHISEL.get(), 1)
                .requires(Items.COPPER_INGOT, 1)
                .requires(Items.STICK, 1)
                .unlockedBy("has_copper_chisel",has(ModItems.COPPER_CHISEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD.get(), 1)
                .pattern("B")
                .pattern("B")
                .pattern("A")
                .define('B', Items.COPPER_INGOT)
                .define('A', Items.STICK)
                .unlockedBy("has_copper_sword",has(ModItems.COPPER_SWORD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get(), 1)
                .pattern("AA")
                .pattern("BA")
                .pattern("B ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper_axe",has(ModItems.COPPER_AXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get(), 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper_pickaxe",has(ModItems.COPPER_PICKAXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get(), 1)
                .pattern("AA")
                .pattern("B ")
                .pattern("B ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper_hoe",has(ModItems.COPPER_HOE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL.get(), 1)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper_shovel",has(ModItems.COPPER_SHOVEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_HELMET.get(), 1)
                .pattern("BBB")
                .pattern("B B")
                .define('B', Items.COPPER_INGOT)
                .unlockedBy("has_copper_helmet",has(ModItems.COPPER_HELMET)).save(recipeOutput, "copper_helmet");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE.get(), 1)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.COPPER_INGOT)
                .unlockedBy("has_copper_chestplate",has(ModItems.COPPER_CHESTPLATE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS.get(), 1)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .define('B', Items.COPPER_INGOT)
                .unlockedBy("has_copper_leggings",has(ModItems.COPPER_LEGGINGS)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS.get(), 1)
                .pattern("B B")
                .pattern("B B")
                .define('B', Items.COPPER_INGOT)
                .unlockedBy("has_copper_boots",has(ModItems.COPPER_BOOTS)).save(recipeOutput, "copper_boots");
        //-------------------------------------------------//
        //EMERALD RECIPES                                  //
        //-------------------------------------------------//
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_AXE.get(), 1)
                .pattern("AA")
                .pattern("BA")
                .pattern("B ")
                .define('A', Items.EMERALD)
                .define('B', Items.STICK)
                .unlockedBy("has_emerald_axe",has(ModItems.EMERALD_AXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_PICKAXE.get(), 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD)
                .define('B', Items.STICK)
                .unlockedBy("has_emerald_pickaxe",has(ModItems.EMERALD_PICKAXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_HOE.get(), 1)
                .pattern("AA")
                .pattern("B ")
                .pattern("B ")
                .define('A', Items.EMERALD)
                .define('B', Items.STICK)
                .unlockedBy("has_emerald_hoe",has(ModItems.EMERALD_HOE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL.get(), 1)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', Items.EMERALD)
                .define('B', Items.STICK)
                .unlockedBy("has_emerald_shovel",has(ModItems.EMERALD_SHOVEL)).save(recipeOutput);
        //-------------------------------------------------//
        //NUGGETS RECIPES                                  //
        //-------------------------------------------------//
        oreSmelting(recipeOutput, DIAMOND_SMELTABLES, RecipeCategory.MISC, ModItems.DIAMOND_NUGGET.get(), 0.2f, 200 , "diamond_nugget_blasting");
        oreSmelting(recipeOutput, COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 0.2f, 200 , "copper_nugget_blasting");
        oreSmelting(recipeOutput, EMERALD_SMELTABLES, RecipeCategory.MISC, ModItems.EMERALD_NUGGET.get(), 0.2f, 200 , "emerald_nugget_blasting");

    }
}
