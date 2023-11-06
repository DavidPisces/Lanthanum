package cn.bzlom.lanthanum.client;

import cn.bzlom.lanthanum.Lanthanum;
import cn.bzlom.lanthanum.utils.IEntityDataSaver;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ThirstHudOverlay implements HudRenderCallback {
    private static final Identifier FILLED_THIRST = new Identifier(Lanthanum.MOD_ID, "textures/thirst/filled_thirst.png");
    private static final Identifier EMPTY_THIRST = new Identifier(Lanthanum.MOD_ID, "textures/thirst/empty_thirst.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null && client.player != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            int x = width / 2;

            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, EMPTY_THIRST);
            for (int i = 0; i < 10; i++) {
                DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), height - 54, 0, 0, 12, 12);
            }

            RenderSystem.setShaderTexture(0, FILLED_THIRST);
            for (int i = 0; i < 10; i++) {
                if (((IEntityDataSaver) client.player).getPersistentData().getInt("thirst") > i) {
                    DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), height - 54, 0, 0, 12, 12);
                } else {
                    break;
                }
            }
        }
    }
}