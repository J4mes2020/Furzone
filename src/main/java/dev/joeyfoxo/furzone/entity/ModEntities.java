package dev.joeyfoxo.furzone.entity;

import dev.joeyfoxo.furzone.Furzone;
import dev.joeyfoxo.furzone.entity.custom.ProtogenEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Furzone.MOD_ID);

    public static RegistryObject<EntityType<ProtogenEntity>> PROTOGEN = ENTITY_TYPES.register("protogen",
            () -> EntityType.Builder.of(ProtogenEntity::new, MobCategory.CREATURE)
                    .sized(1f, 2f)
                    .build(new ResourceLocation(Furzone.MOD_ID, "protogen").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
