package werdna.tutorial.material;

import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.*;
import werdna.tutorial.Tutorial;
import werdna.tutorial.tag.ModTags;

import java.util.Map;

public class ModArmourMaterial{
    public static ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY
            = ResourceKey.createRegistryKey(Identifier.parse("equipment_asset"));
    public static ResourceKey<EquipmentAsset> BISMUTH_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "bismuth"));

    public static final ArmorMaterial Bismuth = new ArmorMaterial(20, makeDefense(2, 5, 6, 2, 5),9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, ModTags.Items.BISMUTH_TOOL_MATERIAL, BISMUTH_KEY);

    static Map<ArmorType, Integer> makeDefense(final int boots, final int legs, final int chest, final int helm, final int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}
