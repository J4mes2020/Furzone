package dev.joeyfoxo.furzone.items;

import dev.joeyfoxo.furzone.Furzone;
import dev.joeyfoxo.furzone.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Furzone.MOD_ID);

    public static RegistryObject<Item> TOAST = ITEMS.register("toast", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> BURNT_TOAST = ITEMS.register("burnt_toast", () -> new Item(new Item.Properties()));

    public static RegistryObject<Item> PROTOGEN_SPAWN_EGG =
            ITEMS.register("protogen_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.PROTOGEN, 0x06C7AD
                    , 0x1D0D00, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
