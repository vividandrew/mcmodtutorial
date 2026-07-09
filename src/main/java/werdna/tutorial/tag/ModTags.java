package werdna.tutorial.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import werdna.tutorial.Tutorial;

public class ModTags {

    public static class Blocks{
        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "needs_bismuth_tool"));
        public static final TagKey<Block> INCORRENT_FOR_BISMUTH_TOOL = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("incorrect_for_bismuth_tool"));
        public static final TagKey<Block> PAXEL_MINABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "paxel_minable"));

        private static TagKey<Block> createTag(String name)
        {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name));
        }
    }
    public static class Items{

        public static final TagKey<Item> BISMUTH_TOOL_MATERIAL = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "bismuth_tool_material"));

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        private static TagKey<Item> createTag(String name)
        {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name));
        }
    }
}
