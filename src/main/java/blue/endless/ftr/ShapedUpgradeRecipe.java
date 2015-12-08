package blue.endless.ftr;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ShapedUpgradeRecipe extends ShapedOreRecipe {
	private ItemStack result;
	
    public ShapedUpgradeRecipe(ItemStack result, Object... recipe) {
    	super(result, recipe);
    	this.result = result;
    }

	@Override
    public ItemStack getCraftingResult(InventoryCrafting inv){
		NBTTagCompound dest = new NBTTagCompound();
		
		for(int i=0; i<9; i++) {
			ItemStack cur = inv.getStackInSlot(i);
			if (cur!=null && cur.getItem().equals(result.getItem())) {
				NBTTagCompound curTag = cur.getTagCompound();
				if (curTag!=null) {
					for(Object o : curTag.func_150296_c()) {
						dest.setTag((String)o, curTag.getTag((String)o));
					}
				}
			}
		}
		
		ItemStack newResult = result.copy();
		newResult.setTagCompound(dest);
		
		return newResult;
	}

}
