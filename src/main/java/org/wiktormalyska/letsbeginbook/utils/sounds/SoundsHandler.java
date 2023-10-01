package org.wiktormalyska.letsbeginbook.utils.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundsHandler {
    public static SoundEvent getSound(Sounds sound){
        switch (sound){
            case DING:
                return new SoundEvent(new Identifier("minecraft", "ui.toast.in"));
        }
        return null;
    }
}
