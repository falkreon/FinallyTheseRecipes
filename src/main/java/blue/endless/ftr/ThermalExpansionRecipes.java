package blue.endless.ftr;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ThermalExpansionRecipes {
	public static void init() {
		ItemStack signalumLock = GameRegistry.findItemStack("ThermalExpansion", "lock", 1);
		GameRegistry.addRecipe(new ShapelessOreRecipe(signalumLock,
				"ingotBronze", "ingotSignalum"));
		
		//Basic Strongbox -> Reinforced
		upgradeRecipe(
				GameRegistry.findItemStack("ThermalExpansion", "strongboxReinforced", 1),
				GameRegistry.findItemStack("ThermalExpansion", "strongboxBasic", 1),
				"ingotInvar", "blockGlassHardened");
		//Hardened Strongbox -> Resonant
		upgradeRecipe(
				GameRegistry.findItemStack("ThermalExpansion", "strongboxResonant", 1),
				GameRegistry.findItemStack("ThermalExpansion", "strongboxHardened", 1),
				"blockGlassHardened", "ingotEnderium");
		
		//Basic Tank -> Reinforced
		upgradeRecipe(
				GameRegistry.findItemStack("ThermalExpansion", "tankReinforced", 1),
				GameRegistry.findItemStack("ThermalExpansion", "tankBasic", 1),
				"ingotInvar", "blockGlassHardened");
		//Hardened Tank -> Resonant
		upgradeRecipe(
				GameRegistry.findItemStack("ThermalExpansion", "tankResonant", 1),
				GameRegistry.findItemStack("ThermalExpansion", "tankHardened", 1),
				"blockGlassHardened", "ingotEnderium");
		
		//Deal with missing GameRegistry strings
		ItemStack cacheItem = GameRegistry.findItemStack("ThermalExpansion", "Cache", 1);
		ItemStack cacheBasic =		cacheItem.copy();	cacheBasic.setItemDamage(1);
		ItemStack cacheHardened =	cacheItem.copy();	cacheHardened.setItemDamage(2);
		ItemStack cacheReinforced =	cacheItem.copy();	cacheReinforced.setItemDamage(3);
		ItemStack cacheResonant =	cacheItem.copy();	cacheResonant.setItemDamage(4);
		
		//Basic Cache -> Reinforced
		upgradeRecipe(cacheBasic, cacheReinforced, "ingotInvar", "blockGlassHardened");
		//Hardened Cache -> Resonant
		upgradeRecipe(cacheResonant, cacheHardened, "blockGlassHardened", "ingotEnderium");
	}
	
	public static void upgradeRecipe(ItemStack after, ItemStack before, Object material1, Object material2) {
		GameRegistry.addRecipe(new ShapedUpgradeRecipe(
				after,
				"aba", "bMb", "aba",
				'a', material1,
				'b', material2,
				'M', before));
		GameRegistry.addRecipe(new ShapedUpgradeRecipe(
				after,
				"bab", "aMa", "bab",
				'a', material1,
				'b', material2,
				'M', before));
	}
}
