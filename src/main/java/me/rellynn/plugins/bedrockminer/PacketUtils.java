package me.rellynn.plugins.bedrockminer;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Material;

/**
 * Created by gwennaelguich on 12/03/2017.
 * Edited by Kaeios on 5/28/2019
 */
public abstract class PacketUtils {

    /**
     * display break animation to everyone
     * @param position position of the block
     * @param stage stage of the animation
     */
    public static void broadcastBlockBreakAnimationPacket(final BlockPosition position, final int stage) {
        final PacketContainer packet = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
        packet.getIntegers()
                .write(0, 0)
                .write(1, stage);
        packet.getBlockPositionModifier().write(0, position);
        ProtocolLibrary.getProtocolManager().broadcastServerPacket(packet);
    }

    /**
     * display break effect to everyone
     * @param position position of the block
     * @param type type of the block
     */
    public static void broadcastBlockBreakEffectPacket(final BlockPosition position, final Material type) {
        final PacketContainer packet = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.WORLD_EVENT);
        packet.getIntegers()
                .write(0, 2001)
                .write(1, type.getId());
        packet.getBlockPositionModifier().write(0, position);
        packet.getBooleans().write(0, false);
        ProtocolLibrary.getProtocolManager().broadcastServerPacket(packet);
    }
}
