package org.wiktormalyska.letsbeginbook.utils.textures;

import net.minecraft.util.Identifier;
import org.wiktormalyska.letsbeginbook.Let_sBeginBook;

public enum Textures {
    BACKGROUND("textures/gui/background.png", new Resolution(256,256)),
    ;
    private final Resolution resolution;
    private final Identifier id;
    Textures(String path, Resolution resolution) {
        this.resolution = resolution;
        this.id = new Identifier(Let_sBeginBook.MOD_ID, path);
    }
    public Resolution getResolution() {
        return resolution;
    }

    public Identifier getID() { return id; }
}
