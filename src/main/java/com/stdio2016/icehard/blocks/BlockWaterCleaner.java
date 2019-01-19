package com.stdio2016.icehard.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by User on 2018/8/7.
 */
public class BlockWaterCleaner extends BlockCleaner {

    public BlockWaterCleaner(String name, Material mat, MapColor color) {
        super(name, mat, color);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityWaterCleaner();
    }
}