package org.wiktormalyska.letsbeginbook.utils.text;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

public class TextHandler {
    public static void drawCenteredTextWithScale(MatrixStack matrices, TextRenderer textRenderer, String text, int x, int y, int color, float scale) {
        // Push the current matrix and apply the scale
        matrices.push();
        matrices.scale(scale, scale, 1.0f);

        // Calculate the scaled text width
        float scaledTextWidth = (float) textRenderer.getWidth(new LiteralText(text));

        // Calculate the x-coordinate for centered text
        int centeredX = (int) (x - (scaledTextWidth * scale) / 2);

        // Draw the scaled and centered text
        DrawableHelper.drawCenteredText(matrices, textRenderer, text, x, y, color);

        // Pop the matrix to revert the scaling
        matrices.pop();
    }

}
