package org.wiktormalyska.letsbeginbook.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.wiktormalyska.letsbeginbook.screen.BeginBookMainScreen;
import org.wiktormalyska.letsbeginbook.utils.sounds.Sounds;
import org.wiktormalyska.letsbeginbook.utils.sounds.SoundsHandler;

public class BeginBookItem extends Item {
    public BeginBookItem() {
        super(new FabricItemSettings().maxCount(16).fireproof().rarity(Rarity.COMMON));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            // Execute the code to open the GUI on the main thread
            MinecraftClient.getInstance().execute(() -> {
                MinecraftClient.getInstance().setScreen(new BeginBookMainScreen());
            });
            user.playSound(SoundsHandler.getSound(Sounds.DING), SoundCategory.BLOCKS, 1f, 1f);
        }
        return super.use(world, user, hand);
    }

}
