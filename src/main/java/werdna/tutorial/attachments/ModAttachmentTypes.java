package werdna.tutorial.attachments;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import werdna.tutorial.Tutorial;

public class ModAttachmentTypes {
    public static final AttachmentType<BlockPos> HOME = AttachmentRegistry.create(
                Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "home"),
                blockPosBuilder -> blockPosBuilder.persistent(BlockPos.CODEC).syncWith(BlockPos.STREAM_CODEC,
                        AttachmentSyncPredicate.all())
            );
    public static final AttachmentType<Integer> MANA = AttachmentRegistry.createPersistent(
            Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "mana"),
            Codec.INT
    );
    public static void registerModAttachmentTypes()
    {
        Tutorial.LOGGER.info("Registering attachment types for "+ Tutorial.MOD_ID);
    }
}
