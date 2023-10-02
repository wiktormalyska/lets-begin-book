package org.wiktormalyska.letsbeginbook.client;

import net.fabricmc.api.ClientModInitializer;
import org.wiktormalyska.letsbeginbook.screen.BookHandler;

public class Let_sBeginBookClient implements ClientModInitializer {
    public static final BookHandler bookHandler = new BookHandler(2);
    @Override
    public void onInitializeClient() {
    }
}
