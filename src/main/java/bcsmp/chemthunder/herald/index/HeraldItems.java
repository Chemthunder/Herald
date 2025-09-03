package bcsmp.chemthunder.herald.index;

import bcsmp.chemthunder.herald.Herald;
import bcsmp.chemthunder.herald.item.GraceItem;
import bcsmp.chemthunder.herald.item.SolitudeItem;
import net.acoyt.acornlib.api.item.AcornItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.acoyt.acornlib.api.util.ItemUtils.modifyItemNameColor;

public interface HeraldItems {
    Map<Item, Identifier> ITEMS = new LinkedHashMap<>();


    Item GRACE = create("grace", new GraceItem(ToolMaterials.NETHERITE, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.3f))
    ));

    Item SOLITUDE = create("solitude", new SolitudeItem(HeraldToolMaterial.SILLY, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(HeraldToolMaterial.SILLY, 8, -2.7f))
    ));

  //  Item MACHINE_OIL_BOTTLE = create("machine_oil_bottle", new OilItem(new Item.Settings()
   //         .maxCount(16)
  //  ));

    static void init() {
        ITEMS.keySet().forEach(item -> Registry.register(Registries.ITEM, ITEMS.get(item), item));

        modifyItemNameColor(SOLITUDE, 0x1c1c21);
    }

    private static Item create(String name, Item item) {
        ITEMS.put(item, Herald.id(name));
        return item;
    }
}
