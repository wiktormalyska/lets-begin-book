package org.wiktormalyska.letsbeginbook.utils.text;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.Matrix4f;

public class TextHandler {
    public static void drawCenteredTextWithScale(MatrixStack matrices, TextRenderer textRenderer, String text, int x, int y, int color, float scale, Screen screen){
        // Push the current matrix and apply the scale
        matrices.push();
        matrices.scale(scale, scale, 1.0f);

        // Calculate the scaled text width

        // Calculate the x-coordinate for centered text
        double scaledX = (screen.width/2)/scale;
        double scaledY = ((screen.height/2)/scale);
        // Draw the scaled and centered text
        DrawableHelper.drawCenteredText(matrices, textRenderer, text, (int) scaledX+x, (int) scaledY+y, color);

        // Pop the matrix to revert the scaling
        matrices.pop();
    }
    public static void drawWithOutline(MatrixStack matrices, TextRenderer textRenderer, String text, int x, int y, int color, int outlineColor) {
        // Save the current transformation matrix
        matrices.push();

        // Define the outline width (adjust as needed)
        int outlineWidth = 1;

        for (int dx = -outlineWidth; dx <= outlineWidth; dx++) {
            for (int dy = -outlineWidth; dy <= outlineWidth; dy++) {
                // Only render the outline where there's a difference
                if (dx != 0 || dy != 0) {
                    // Calculate the adjusted position
                    int adjustedX = x + dx;
                    int adjustedY = y + dy;

                    // Draw the outline text with the outlineColor
                    textRenderer.draw(matrices, text, adjustedX, adjustedY, outlineColor);
                }
            }
        }

        // Draw the main text in the center with the desired color
        textRenderer.draw(matrices, text, x, y, color);

        // Restore the original transformation matrix
        matrices.pop();
    }


}
