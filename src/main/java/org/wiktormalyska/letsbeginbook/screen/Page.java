package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;
import org.wiktormalyska.letsbeginbook.utils.textures.TexturesHandler;

public class Page extends Screen {
    private final Textures backgroundTexture;
    private final String textLeftPage;
    private final String textRightPage;
    private final String title;
    public Page(Textures backgroundTexture, String title, String textLeftPage, String textRightPage) {
        super(Text.of(""));
        this.backgroundTexture = backgroundTexture;
        this.textLeftPage = textLeftPage;
        this.textRightPage = textRightPage;
        this.title = title;
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
        textRenderer.drawWithShadow(matrices, title, ((float) this.width /2)-97, ((float) this.height /2)-60, 0xFFFFFF);
        //draw Text Left Page
        textRenderer.drawWithShadow(matrices, textLeftPage, ((float) this.width /2)-97, ((float) this.height /2)-50, 0x616161);
        //draw Text Right Page
        textRenderer.drawWithShadow(matrices, textRightPage, ((float) this.width /2)-57, ((float) this.height /2)-50, 0x616161);
        super.render(matrices, mouseX, mouseY, delta);

    }
    @Override
    public boolean shouldPause() {
        return false;
    }
}
