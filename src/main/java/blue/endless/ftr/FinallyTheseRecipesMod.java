package blue.endless.ftr;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@Mod(modid = "finally-these-recipes", name="FinallyTheseRecipes", version="1.0")
public class FinallyTheseRecipesMod {
	public static Logger LOGGER;
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		LOGGER = event.getModLog();
	}
	
	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {
		if (Loader.isModLoaded("BuildCraft|Core")) {
			LOGGER.info("Sorry BuildCraft, but those gear recipes are mine now.");
			for(ItemStack item : OreDictionary.getOres("gearStone")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "SwS", "w w", "SwS",
						'w', "stickWood",
						'S', "cobblestone"));
			}
			
			for(ItemStack item : OreDictionary.getOres("gearIron")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "SiS", "iGi", "SiS",
						'i', "ingotIron",
						'S', "cobblestone",
						'G', "gearWood"));
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "iSi", "SGS", "iSi",
						'i', "ingotIron",
						'S', "cobblestone",
						'G', "gearWood"));
			}
			
			for(ItemStack item : OreDictionary.getOres("gearGold")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "gig", "iGi", "gig",
						'i', "ingotIron",
						'g', "ingotGold",
						'G', "gearStone"));
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "igi", "gGg", "igi",
						'i', "ingotIron",
						'g', "ingotGold",
						'G', "gearStone"));
			}
			
			for(ItemStack item : OreDictionary.getOres("gearDiamond")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "gdg", "dGd", "gdg",
						'd', "gemDiamond",
						'g', "ingotGold",
						'G', "gearIron"));
				GameRegistry.addRecipe(new ShapedOreRecipe(item, "dgd", "gGg", "dgd",
						'i', "gemDiamond",
						'g', "ingotGold",
						'G', "gearIron"));
			}
			
		}
		
		if (Loader.isModLoaded("ThermalExpansion")) {
			ThermalExpansionRecipes.init();
		}
	}
	
	
	
	
}
