package org.wiktormalyska.letsbeginbook;

import net.fabricmc.api.ModInitializer;
import org.wiktormalyska.letsbeginbook.items.ModItemRegistry;
import org.wiktormalyska.letsbeginbook.utils.buttons.ButtonsHandler;


public class Let_sBeginBook implements ModInitializer{
    public static final String MOD_ID = "letsbeginbook";
    @Override
    public void onInitialize() {
        ModItemRegistry.registerItems();
    }

    //TODO: setup cloth config https://shedaniel.gitbook.io/cloth-config/setup-cloth-config/cloth-config-fabric
}
