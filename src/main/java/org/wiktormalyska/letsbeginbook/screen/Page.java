package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.wiktormalyska.letsbeginbook.client.Let_sBeginBookClient;
import org.wiktormalyska.letsbeginbook.utils.buttons.ButtonsHandler;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;
import org.wiktormalyska.letsbeginbook.utils.textures.TexturesHandler;

public class Page extends Screen {
    private final Textures backgroundTexture;
    private final String textLeftPage;
    private final String textRightPage;
    private final String title;
    private ButtonWidget backButton;
    private ButtonWidget nextButton;

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
        initButtons();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        TexturesHandler.renderTextureCentered(backgroundTexture, 0, 0, this);
        //draw Title
        textRenderer.drawWithShadow(matrices, title, ((float) this.width /2)-97, ((float) this.height /2)-70, 0xFFFFFF);
        //draw Text Left Page
        textRenderer.draw(matrices, textLeftPage, ((float) this.width /2)-97, ((float) this.height /2)-60, 0x616161);
        //draw Text Right Page
        textRenderer.draw(matrices, textRightPage, ((float) this.width /2)-57, ((float) this.height /2)-60, 0x616161);
        //draw Buttons
        addDrawableChild(backButton);
        addDrawableChild(nextButton);

        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public boolean shouldPause() {
        return false;
    }

    public void initButtons(){
        nextButton = new ButtonWidget((this.width / 2)+ButtonsHandler.Pagex, (this.height / 2)+ButtonsHandler.Pagey, 20, 20, Text.of(">"), (buttonWidget) -> {
            System.out.println("Next");
            MinecraftClient.getInstance().setScreen(Let_sBeginBookClient.bookHandler.openNextPage());
        });
        backButton = new ButtonWidget((this.width / 2)-ButtonsHandler.Pagex-20, (this.height / 2)+ButtonsHandler.Pagey, 20, 20, Text.of("<"), (buttonWidget) -> {
            System.out.println("Back");
            MinecraftClient.getInstance().setScreen(Let_sBeginBookClient.bookHandler.openPreviousPage());
        });
    }
}
