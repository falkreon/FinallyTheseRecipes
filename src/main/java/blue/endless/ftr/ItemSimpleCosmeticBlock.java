package blue.endless.ftr;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemSimpleCosmeticBlock extends ItemBlock {
	private SimpleCosmeticBlock block = null;
	
	public ItemSimpleCosmeticBlock(Block block) {
		super(block);
		if (block instanceof SimpleCosmeticBlock) this.block = (SimpleCosmeticBlock)block;
	}
	
	public int getItemStackLimit() {
		return (block==null) ? 64 : block.getStackSize();
	}
}
