package dev.joeyfoxo.furzone.entity.custom.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.joeyfoxo.furzone.Furzone;
import dev.joeyfoxo.furzone.entity.custom.ProtogenEntity;
import dev.joeyfoxo.furzone.entity.custom.models.ProtogenModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ProtogenRenderer extends GeoEntityRenderer<ProtogenEntity> {
    public ProtogenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ProtogenModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ProtogenEntity animatable) {
        return new ResourceLocation(Furzone.MOD_ID, "textures/entity/protogen.png");
    }

    @Override
    public void render(ProtogenEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
