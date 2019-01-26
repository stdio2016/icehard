package com.stdio2016.icehard.worldgen;

import com.stdio2016.icehard.blocks.BlockIceHard;
import com.stdio2016.icehard.blocks.RegisterBlock;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class IceHardPlainsBiome extends Biome {
    public static IceHardPlainsBiome INSTANCE, INSTANCE2;

    public static BiomeProperties getThisBiomeProperties(String name) {
        BiomeProperties props = new BiomeProperties(name);
        props.setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(-0.05f).setRainfall(0.5f).setSnowEnabled();
        return props;
    }

    public IceHardPlainsBiome(String name) {
        super(getThisBiomeProperties(name));
        topBlock = RegisterBlock.GRASS_BLOCK.getDefaultState();
        fillerBlock = RegisterBlock.SAND.getDefaultState();
    }

    public static void register() {
        IceHardPlainsBiome biome = new IceHardPlainsBiome("Ice Hard Plains");
        INSTANCE = biome;
        biome.setRegistryName("icehard_plains");
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SNOWY);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);

        IceHardPlainsBiome biome2 = new IceHardPlainsBiome("Ice Hard Plains 2");;
        INSTANCE2 = biome2;
        biome2.setRegistryName("icehard_plains2");
        ForgeRegistries.BIOMES.register(biome2);
        BiomeDictionary.addTypes(biome2, BiomeDictionary.Type.COLD, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SNOWY);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome2, 10));
        BiomeManager.addSpawnBiome(biome2);
    }
}