package org.wiktormalyska.letsbeginbook.utils.text;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.gui.DrawableHelper.drawCenteredText;

public class Description {
    private final int color;
    private final List<String> linesOfText;
    public Description(int color, String text){
        this.color = color;
        linesOfText = splitStringIntoLines(text);
    }
    public void draw(MatrixStack matrices, TextRenderer textRenderer, Screen screen){
        for (int i=0; i<linesOfText.size(); i++){
            drawCenteredText(matrices, textRenderer,linesOfText.get(i), screen.width/2, screen.height/2-40+(10*i), color);
        }
    }

    public static List<String> splitStringIntoLines(String input) {
        int maxWordsInLine = 5;
        List<String> lines = new ArrayList<>();
        String[] words = input.split(" ");

        for (int i =0; i<(words.length/maxWordsInLine )+1;i++){
            StringBuilder line = new StringBuilder();
            for (int j=0; j<maxWordsInLine ; j++){
                if (i*maxWordsInLine +j<words.length){
                    line.append(words[i*5+j]).append(" ");
                }
            }
            lines.add(line.toString());
        }

        return lines;
    }

}
