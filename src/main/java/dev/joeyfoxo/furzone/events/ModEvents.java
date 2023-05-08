package dev.joeyfoxo.furzone.events;

import dev.joeyfoxo.furzone.Furzone;
import dev.joeyfoxo.furzone.entity.ModEntities;
import dev.joeyfoxo.furzone.entity.custom.ProtogenEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Furzone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.PROTOGEN.get(), ProtogenEntity.setAttributes());

    }

}
