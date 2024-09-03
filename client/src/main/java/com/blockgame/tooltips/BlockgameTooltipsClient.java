package com.blockgame.tooltips;

import com.blockgame.tooltips.config.ModConfig;
import com.blockgame.tooltips.logging.ItemLogger;
import com.blockgame.tooltips.objects.item.ItemRegistry;
import com.blockgame.tooltips.objects.ids.AbilityModifierId;
import com.blockgame.tooltips.objects.ids.StatId;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockgameTooltipsClient implements ClientModInitializer {

	public static final String MOD_ID = "blockgametooltips";
	public static final Logger LOGGER = LoggerFactory.getLogger("BlockgameTooltips");

	public static BlockgameTooltipsClient INSTANCE;

	private static KeyBinding keyBinding;

	@Override
	public void onInitializeClient() {
		INSTANCE = this;

		ModConfig.INSTANCE.load();

		StatId.Companion.getUNKNOWN(); // init StatId V2
		AbilityModifierId.Companion.getRegistry(); // init AbilityModifierId V2
		ItemRegistry.INSTANCE.getItemList(); // init ItemRegistry
		ItemLogger.INSTANCE.getCachedItems(); // init ItemLogger


//		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//			"key.blockgametooltips.debug", // The translation key of the keybinding's name
//			InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
//			GLFW.GLFW_KEY_F4, // The keycode of the key
//			"category.blockgametooltips.debug" // The translation key of the keybinding's category.
//		));
//		ClientTickEvents.END_CLIENT_TICK.register(client -> {
//			while (keyBinding.wasPressed()) {
//				ItemLogger.INSTANCE.logCache();
//			}
//		});
	}

}