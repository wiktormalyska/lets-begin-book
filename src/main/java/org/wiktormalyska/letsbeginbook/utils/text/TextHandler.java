package org.wiktormalyska.letsbeginbook.utils.text;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

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

}
