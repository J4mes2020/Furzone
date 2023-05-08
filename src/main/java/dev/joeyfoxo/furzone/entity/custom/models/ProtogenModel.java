package dev.joeyfoxo.furzone.entity.custom.models;

import dev.joeyfoxo.furzone.Furzone;
import dev.joeyfoxo.furzone.entity.custom.ProtogenEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ProtogenModel extends GeoModel<ProtogenEntity> {
    @Override
    public ResourceLocation getModelResource(ProtogenEntity animatable) {
        return new ResourceLocation(Furzone.MOD_ID, "geo/protogen.json");
    }

    @Override
    public ResourceLocation getTextureResource(ProtogenEntity animatable) {
        return new ResourceLocation(Furzone.MOD_ID, "textures/entity/protogen.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ProtogenEntity animatable) {
        return new ResourceLocation(Furzone.MOD_ID, "animations/protogen.animation.json");
    }

    @Override
    public void setCustomAnimations(ProtogenEntity animatable, long instanceId, AnimationState<ProtogenEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
