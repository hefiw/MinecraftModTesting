package com.minecraftmod.core.registry;

import com.minecraftmod.MinecraftModTestConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MMCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftModTestConfiguration.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TAB.register("test_tab", () -> CreativeModeTab
        .builder()
        .icon(() -> MMItem.BLACK_HOLE.get().getDefaultInstance())
        .title(Component.translatable("creative_tab.minecrafttestmod.test_tab"))
        .displayItems((parameters, output) -> {
            MMItem.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
        }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
