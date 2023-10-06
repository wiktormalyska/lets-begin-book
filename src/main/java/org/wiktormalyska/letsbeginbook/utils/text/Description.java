package org.wiktormalyska.letsbeginbook.utils.text;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Description {
    private final int color;
    private final List<String> linesOfText;
    private final float scale;
    private final int y;
    public Description(int color, String text, float scale){
        this.color = color;
        linesOfText = splitStringIntoLines(text);
        this.scale = scale;
        this.y = 0;
    }

    public Description(String text){
        this.color = 0x828282;
        linesOfText = splitStringIntoLines(text);
        this.scale = 0.75f;
        this.y = 0;
    }
    public Description(String text, int y){
        this.color = 0x828282;
        linesOfText = splitStringIntoLines(text);
        this.scale = 0.75f;
        this.y = y;
    }
    public void draw(MatrixStack matrices, TextRenderer textRenderer, Screen screen){
        for (int i=0; i<linesOfText.size(); i++){
            TextHandler.drawCenteredTextWithScale(matrices, textRenderer, linesOfText.get(i), 0, y+(i*10) , color, scale, screen);
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
                    line.append(words[i*maxWordsInLine+j]).append(" ");
                }
            }
            lines.add(line.toString());
        }

        return lines;
    }

}
