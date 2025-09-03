package bcsmp.chemthunder.herald.index;

import bcsmp.chemthunder.herald.Herald;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public interface HeraldItemGroup {
    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Herald.id("herald"));
    ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(HeraldItems.SOLITUDE))
            .displayName(Text.translatable("itemGroup.herald").styled(style -> style.withColor(0x08080a)))
            .build();

    static void init() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(HeraldItemGroup::addEntries);
    }

    private static void addEntries(FabricItemGroupEntries itemGroup) {
    itemGroup.add(HeraldItems.GRACE);
    itemGroup.add(HeraldItems.SOLITUDE);
    itemGroup.add(HeraldItems.CRIMSON_OBITUARY);
    }
}
