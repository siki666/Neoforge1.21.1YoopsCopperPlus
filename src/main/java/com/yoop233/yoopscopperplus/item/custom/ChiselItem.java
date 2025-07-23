package com.yoop233.yoopscopperplus.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ChiselItem extends Item {
    public ChiselItem(Properties properties) {
        super(properties);
    }

    private static final Map<Block, Block> CHISEL_BLOCKS = Map.ofEntries(
            //stone transformations
            Map.entry(Blocks.STONE, Blocks.NETHERRACK),
            Map.entry(Blocks.NETHERRACK, Blocks.END_STONE),
            Map.entry(Blocks.END_STONE, Blocks.STONE),
            //wood transformations
            Map.entry(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG),
            Map.entry(Blocks.DARK_OAK_LOG, Blocks.ACACIA_LOG),
            Map.entry(Blocks.ACACIA_LOG, Blocks.BIRCH_LOG),
            Map.entry(Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG),
            Map.entry(Blocks.JUNGLE_LOG, Blocks.CHERRY_LOG),
            Map.entry(Blocks.CHERRY_LOG, Blocks.MANGROVE_LOG),
            Map.entry(Blocks.MANGROVE_LOG, Blocks.OAK_LOG),
            //ore block transformations
            Map.entry(Blocks.NETHERITE_BLOCK,Blocks.DIAMOND_BLOCK),
            Map.entry(Blocks.DIAMOND_BLOCK,Blocks.EMERALD_BLOCK),
            Map.entry(Blocks.EMERALD_BLOCK,Blocks.QUARTZ_BLOCK),
            Map.entry(Blocks.QUARTZ_BLOCK,Blocks.REDSTONE_BLOCK),
            Map.entry(Blocks.REDSTONE_BLOCK,Blocks.GOLD_BLOCK),
            Map.entry(Blocks.GOLD_BLOCK,Blocks.IRON_BLOCK),
            Map.entry(Blocks.IRON_BLOCK,Blocks.COPPER_BLOCK),
            Map.entry(Blocks.COPPER_BLOCK,Blocks.LAPIS_BLOCK),
            Map.entry(Blocks.LAPIS_BLOCK,Blocks.COAL_BLOCK),
            //ore transformations
            Map.entry(Blocks.ANCIENT_DEBRIS,Blocks.NETHER_GOLD_ORE),
            Map.entry(Blocks.NETHER_GOLD_ORE,Blocks.NETHER_QUARTZ_ORE),
            Map.entry(Blocks.NETHER_QUARTZ_ORE,Blocks.DIAMOND_ORE),
            Map.entry(Blocks.DIAMOND_ORE,Blocks.EMERALD_ORE),
            Map.entry(Blocks.EMERALD_ORE,Blocks.REDSTONE_ORE),
            Map.entry(Blocks.REDSTONE_ORE,Blocks.GOLD_ORE),
            Map.entry(Blocks.GOLD_ORE,Blocks.IRON_ORE),
            Map.entry(Blocks.IRON_ORE,Blocks.COPPER_ORE),
            Map.entry(Blocks.COPPER_ORE,Blocks.LAPIS_ORE),
            Map.entry(Blocks.LAPIS_ORE,Blocks.COAL_ORE),
            //other transformations
            Map.entry(Blocks.GRASS_BLOCK,Blocks.DIRT),
            Map.entry(Blocks.DIRT,Blocks.GRAVEL),
            Map.entry(Blocks.GRAVEL,Blocks.SAND),
            Map.entry(Blocks.SAND,Blocks.DIRT)
    );
    public static final Map<Block, Item> CHISEL_ITEMS = Map.ofEntries(
            //ore block transformations
            Map.entry(Blocks.NETHERITE_BLOCK, Items.NETHERITE_INGOT),
            Map.entry(Blocks.DIAMOND_BLOCK, Items.DIAMOND),
            Map.entry(Blocks.EMERALD_BLOCK, Items.EMERALD),
            Map.entry(Blocks.QUARTZ_BLOCK, Items.QUARTZ),
            Map.entry(Blocks.REDSTONE_BLOCK, Items.REDSTONE),
            Map.entry(Blocks.GOLD_BLOCK, Items.GOLD_INGOT),
            Map.entry(Blocks.IRON_BLOCK, Items.IRON_INGOT),
            Map.entry(Blocks.COPPER_BLOCK, Items.COPPER_INGOT),
            Map.entry(Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI),
            Map.entry(Blocks.COAL_BLOCK, Items.COAL),
            //ore transformations
            Map.entry(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP),
            Map.entry(Blocks.NETHER_GOLD_ORE, Items.GOLD_NUGGET),
            Map.entry(Blocks.NETHER_QUARTZ_ORE, Items.NETHERRACK),
            Map.entry(Blocks.DIAMOND_ORE, Items.DIAMOND),
            Map.entry(Blocks.EMERALD_ORE, Items.EMERALD),
            Map.entry(Blocks.REDSTONE_ORE, Items.REDSTONE),
            Map.entry(Blocks.GOLD_ORE, Items.RAW_GOLD),
            Map.entry(Blocks.IRON_ORE, Items.RAW_IRON),
            Map.entry(Blocks.COPPER_ORE, Items.RAW_COPPER),
            Map.entry(Blocks.LAPIS_ORE, Items.LAPIS_LAZULI),
            Map.entry(Blocks.COAL_ORE, Items.COAL),
            Map.entry(Blocks.GRAVEL, Items.FLINT)
    );

    private static void dropItem(Level level, BlockPos pos, Block block){
        ItemStack drop = CHISEL_ITEMS.get(block).getDefaultInstance();
        ServerLevel serverLevel = (ServerLevel) level;
        ItemEntity itemEntity = new ItemEntity(serverLevel, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, drop);
        serverLevel.addFreshEntity(itemEntity);
    }


    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(!level.isClientSide() && CHISEL_BLOCKS.containsKey(clickedBlock)){
            level.setBlockAndUpdate(context.getClickedPos(), CHISEL_BLOCKS.get(clickedBlock).defaultBlockState());
            if(CHISEL_ITEMS.containsKey(clickedBlock)){
                dropItem(level, context.getClickedPos(), clickedBlock);
            }

            context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level),context.getPlayer(), item -> {
                assert context.getPlayer() != null;
                context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
            });
            level.playSound(null, context.getClickedPos(), SoundEvents.COPPER_BREAK, SoundSource.BLOCKS);
        }
        return InteractionResult.SUCCESS;
    }
}
