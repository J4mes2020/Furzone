package dev.joeyfoxo.furzone.items;

import dev.joeyfoxo.furzone.Furzone;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Furzone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CustomCreativeModeTabs {

    public static CreativeModeTab FURZONE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {

        FURZONE_TAB = event.registerCreativeModeTab(new ResourceLocation(Furzone.MOD_ID, "furzone_tab"),
                builder -> builder.icon(() -> new ItemStack(
                        ModItems.TOAST.get())).title(Component.translatable("creativemodetab.furzone_tab")));

    }

}
