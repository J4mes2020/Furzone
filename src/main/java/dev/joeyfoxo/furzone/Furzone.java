package dev.joeyfoxo.furzone;

import com.mojang.logging.LogUtils;
import dev.joeyfoxo.furzone.block.ModBlocks;
import dev.joeyfoxo.furzone.entity.ModEntities;
import dev.joeyfoxo.furzone.entity.custom.renderers.ProtogenRenderer;
import dev.joeyfoxo.furzone.items.CustomCreativeModeTabs;
import dev.joeyfoxo.furzone.items.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Furzone.MOD_ID)
public class Furzone {

    public static final String MOD_ID = "furzone";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Furzone() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {


    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.TOAST);
            event.accept(ModItems.BURNT_TOAST);
        }
        if (event.getTab() == CustomCreativeModeTabs.FURZONE_TAB) {
            event.accept(ModItems.TOAST);
            event.accept(ModItems.BURNT_TOAST);
            event.accept(ModBlocks.misc_block);
            event.accept(ModItems.PROTOGEN_SPAWN_EGG);
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.PROTOGEN.get(), ProtogenRenderer::new);
        }
    }
}
