package org.wiktormalyska.letsbeginbook.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.wiktormalyska.letsbeginbook.Let_sBeginBook;
import org.wiktormalyska.letsbeginbook.utils.textures.Resolution;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;
import org.wiktormalyska.letsbeginbook.utils.textures.TexturesHandler;

public class BeginBookMainScreen extends Screen {
    public BeginBookMainScreen() {
        super(Text.of("Begin Book Screen"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        TexturesHandler.renderTextureCentered(Textures.BACKGROUND, 0, 0, this);
        textRenderer.draw(matrices, Text.of("Let's Begin Book"), (float) this.width /2, (float) this.height /2, 0xFFFFFF);
        //TODO: Add scalable text
        super.render(matrices, mouseX, mouseY, delta);

    }
    @Override
    public boolean shouldPause() {
        return false;
    }
}
