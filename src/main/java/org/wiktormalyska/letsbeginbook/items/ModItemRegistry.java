package org.wiktormalyska.letsbeginbook.items;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.wiktormalyska.letsbeginbook.Let_sBeginBook;

public class ModItemRegistry {
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Let_sBeginBook.MOD_ID,"beginner_book"), new BeginBookItem());
    }
}
