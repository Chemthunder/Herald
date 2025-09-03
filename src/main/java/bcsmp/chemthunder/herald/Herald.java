package bcsmp.chemthunder.herald;

import bcsmp.chemthunder.herald.index.HeraldItemGroup;
import bcsmp.chemthunder.herald.index.HeraldItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Herald implements ModInitializer {
	public static final String MOD_ID = "herald";

    public static Identifier id (String path){
        return Identifier.of(MOD_ID, path);
    }

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        HeraldItems.init();
        HeraldItemGroup.init();


		LOGGER.info("herald.runmessage");
	}
}