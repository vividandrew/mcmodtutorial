package werdna.tutorial.data;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import werdna.tutorial.Tutorial;

import java.util.function.UnaryOperator;

public class ModDataComponent {

    public static final DataComponentType<BlockPos> COORDINATES = register("coordinates", blockPosBuilder ->
        blockPosBuilder.persistent(BlockPos.CODEC).networkSynchronized(BlockPos.STREAM_CODEC).cacheEncoding()
    );

    public static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOp)
    {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name),
                builderOp.apply(DataComponentType.builder()).build());
    }

    public static void registerDataComponent()
    {
        Tutorial.LOGGER.info("Register data components for " + Tutorial.MOD_ID);
    }
}
