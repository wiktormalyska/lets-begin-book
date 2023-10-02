package org.wiktormalyska.letsbeginbook.utils.textures;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;

public class TexturesHandler {

    public static void renderTexture(Textures texture, double x, double y, int vOffset, int red, int green, int blue, int alpha) {
        Resolution resolution = texture.getResolution();
        Identifier textureID = texture.getID();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, textureID);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(x, y + resolution.getY(), 0.0).texture(0.0F, (float)resolution.getY() / (float)texture.getResolution().getY() + (float)vOffset).color(red, green, blue, alpha).next();
        bufferBuilder.vertex(x + resolution.getX(), y + resolution.getY(), 0.0).texture((float)resolution.getX() / (float)texture.getResolution().getX(), (float)resolution.getY() / (float)texture.getResolution().getY() + (float)vOffset).color(red, green, blue, alpha).next();
        bufferBuilder.vertex(x + resolution.getX(), y, 0.0).texture((float)resolution.getX() / (float)texture.getResolution().getX(), (float)vOffset).color(red, green, blue, alpha).next();
        bufferBuilder.vertex(x, y, 0.0).texture(0.0F, (float)vOffset).color(red, green, blue, alpha).next();
        tessellator.draw();
    }


    public static void renderTexture(Textures texture, double x, double y, int vOffset) {
        renderTexture(texture, x, y, vOffset, 255, 255, 255, 255);
    }

    public static void renderTexture(Textures texture, double x, double y) {
        renderTexture(texture, x, y, 0, 255, 255, 255, 255);
    }

    public static void renderTextureCentered(Textures texture, double x, double y, Screen screen) {
        int screenCenterX = screen.width / 2;
        int screenCenterY = screen.height / 2;
        Resolution resolution = texture.getResolution();
        TexturesHandler.renderTexture(texture, screenCenterX- (double) resolution.getX() /2, screenCenterY- (double) resolution.getY() /2);
    }



}
