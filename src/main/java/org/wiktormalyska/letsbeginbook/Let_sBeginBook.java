package org.wiktormalyska.letsbeginbook;

import net.fabricmc.api.ModInitializer;
import org.wiktormalyska.letsbeginbook.items.ModItemRegistry;


public class Let_sBeginBook implements ModInitializer{
    public static final String MOD_ID = "letsbeginbook";
    @Override
    public void onInitialize() {
        ModItemRegistry.registerItems();
    }
}
