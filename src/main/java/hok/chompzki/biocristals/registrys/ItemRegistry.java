package hok.chompzki.biocristals.registrys;

import cpw.mods.fml.common.registry.GameRegistry;
import hok.chompzki.biocristals.BioCristalsMod;
import hok.chompzki.biocristals.items.ItemAttuner;
import hok.chompzki.biocristals.items.ItemBioReagent;
import hok.chompzki.biocristals.items.ItemCatalystInjector;
import hok.chompzki.biocristals.items.ItemCollector;
import net.minecraft.item.Item;


/**
 * 
 * @author Jonathan
 *	- REMEMBER LINKS -
 * Making mode use other mods ore and so on: https://github.com/MinecraftForge/MinecraftForge/pull/1926#issuecomment-110486973
 * DON'T YOU FUCKING DARE INVENTING THE FUCKING WHEEL AGAIN!!!!
 * 
 * 
 */

public class ItemRegistry {
	
	public static Item attuner = null;
	public static Item bioReagent = null;
	public static Item collector = null;
	public static Item catalystInjector = null;
	
	public void registerItems(){
		attuner = new ItemAttuner();
		bioReagent = new ItemBioReagent();
		collector = new ItemCollector();
		catalystInjector = new ItemCatalystInjector();
		
		GameRegistry.registerItem(attuner, ItemAttuner.NAME, BioCristalsMod.MODID);
		GameRegistry.registerItem(bioReagent, ItemBioReagent.NAME, BioCristalsMod.MODID);
		GameRegistry.registerItem(collector, ItemCollector.NAME, BioCristalsMod.MODID);
		GameRegistry.registerItem(catalystInjector, ItemCatalystInjector.NAME, BioCristalsMod.MODID);
	}
	
}
