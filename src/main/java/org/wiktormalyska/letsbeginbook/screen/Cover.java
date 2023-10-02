package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import org.wiktormalyska.letsbeginbook.utils.text.Description;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;
import org.wiktormalyska.letsbeginbook.utils.textures.TexturesHandler;

public class Cover extends Screen {
    private final Textures backgroundTexture;
    private final String title;
    private final Description description;
    private boolean isBackCover;
    public Cover(Textures backgroundTexture, String title, Description description) {
        super(Text.of(""));
        this.backgroundTexture = backgroundTexture;
        this.title = title;
        this.description = description;
        this.isBackCover = false;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        TexturesHandler.renderTextureCentered(backgroundTexture, 0, 0, this);
        //draw Title
        drawCenteredText(matrices, this.textRenderer,title, this.width/2,this.height/2-55, 0xFFFFFF);
        //draw Text
        description.draw(matrices, this.textRenderer, this);
        //draw credits
        if (isBackCover){
            drawCenteredText(matrices, this.textRenderer,"Mod created by Wiktor Malyska", this.width/2,this.height-80, 0x676767);
        }
        super.render(matrices, mouseX, mouseY, delta);
    }
    public void isBackCover(){
        this.isBackCover = true;
    }
}