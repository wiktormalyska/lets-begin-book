package org.wiktormalyska.letsbeginbook.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.wiktormalyska.letsbeginbook.screen.BookPagesHandler;

public class Let_sBeginBookClient implements ClientModInitializer {
    public static final BookPagesHandler bookHandler = new BookPagesHandler(1);
    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {

        });
    }
}
