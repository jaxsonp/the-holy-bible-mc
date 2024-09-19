package jaxsonp.theholybible;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.minecraft.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheHolyBible implements ModInitializer {
	public static final String MOD_ID = "the_holy_bible";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Initializing the bible
		Identifier itemID = Identifier.of(TheHolyBible.MOD_ID, "the_bible");

		Item.Settings itemSettings = new Item.Settings();
		itemSettings.maxCount(1);

		Item bibleItem = Registry.register(Registries.ITEM, itemID, new Item(itemSettings));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
				.register((itemGroup) -> itemGroup.add(bibleItem));

		//Text bibleItemText = Text.translatable("the_holy_bible.label").formatted(Formatting.ITALIC);

		LOGGER.info("Initialized the Holy Bible");
	}
}