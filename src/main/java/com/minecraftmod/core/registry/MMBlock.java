package com.minecraftmod.core.registry;

import com.minecraftmod.MinecraftModTestConfiguration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MMBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftModTestConfiguration.MOD_ID);

    public static final RegistryObject<Block> CASTLE_WALL_BLOCK = registryBlock("castle_wall_block",
        () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.CLAY)
            .sound(SoundType.DRIPSTONE_BLOCK)
            .requiresCorrectToolForDrops()
            .strength(4.0f,5.0f)
            .lightLevel(state -> 6)));

    public static final void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    public static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = BLOCKS.register(name, block);
        registerBlockItem(name, registryObject);
        return registryObject;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        MMItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
