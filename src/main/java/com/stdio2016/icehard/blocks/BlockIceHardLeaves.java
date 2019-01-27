package com.stdio2016.icehard.blocks;

import com.stdio2016.icehard.IceHardMod;
import net.minecraft.block.*;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by User on 2019/1/27.
 */
public class BlockIceHardLeaves extends BlockLeaves {
    public ItemBlock item;
    public BlockIceHardLeaves(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(IceHardMod.ourTab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(DECAYABLE, true).withProperty(CHECK_DECAY, true));
        this.item = new ItemBlock(this);
        this.item.setRegistryName(name).setUnlocalizedName(name);

    }

    @Override
    public BlockPlanks.EnumType getWoodType(int i) {
        return null;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, (meta&4) == 4)
                .withProperty(CHECK_DECAY, (meta&8) == 8);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if (state.getValue(DECAYABLE)) {
            i |= 4;
        }
        if (state.getValue(CHECK_DECAY)) {
            i |= 8;
        }
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, DECAYABLE, CHECK_DECAY);
    }

    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack itemStack, IBlockAccess iBlockAccess, BlockPos blockPos, int i) {
        return NonNullList.withSize(1, new ItemStack(this, 1));
    }
}