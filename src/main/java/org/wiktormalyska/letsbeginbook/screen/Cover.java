package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import org.wiktormalyska.letsbeginbook.client.Let_sBeginBookClient;
import org.wiktormalyska.letsbeginbook.utils.buttons.ButtonsHandler;
import org.wiktormalyska.letsbeginbook.utils.text.Description;
import org.wiktormalyska.letsbeginbook.utils.text.TextHandler;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;
import org.wiktormalyska.letsbeginbook.utils.textures.TexturesHandler;

public class Cover extends Screen {
    private final Textures backgroundTexture;
    private final String title;
    private final Description description;
    private boolean isBackCover;
    private ButtonWidget backButton;
    private ButtonWidget nextButton;
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
        initButtons();
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
        if (isBackCover) {

            TextHandler.drawCenteredTextWithScale(matrices, this.textRenderer, "Mod created by Wiktor Małyska", 0, 110, 0x676767, 0.5f, this);
            addDrawableChild(backButton);
        } else {
            addDrawableChild(nextButton);
        }

        super.render(matrices, mouseX, mouseY, delta);
    }
    public void isBackCover(){
        this.isBackCover = true;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    public void initButtons(){
        nextButton = new ButtonWidget((this.width / 2)+ButtonsHandler.Coverx, (this.height / 2)+ButtonsHandler.Covery, 20, 20, Text.of(">"), (buttonWidget) -> {
            System.out.println("Next");
            MinecraftClient.getInstance().setScreen(Let_sBeginBookClient.bookHandler.openNextPage());
        });
        backButton = new ButtonWidget((this.width / 2)-ButtonsHandler.Coverx-20, (this.height / 2)+ButtonsHandler.Covery, 20, 20, Text.of("<"), (buttonWidget) -> {
            System.out.println("Back");
            MinecraftClient.getInstance().setScreen(Let_sBeginBookClient.bookHandler.openPreviousPage());
        });
    }
}