package blue.endless.ftr;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SimpleCosmeticBlock extends Block {
	private int renderPass = 0;
	private boolean isSolidInside = true;
	private int stackSize = 64;
	private String name;
	
	protected SimpleCosmeticBlock(String name) {
		super(Material.rock); 
		this.name = name;
		this.setBlockName(name);
		this.setBlockTextureName("finally-these-recipes:"+name);
		
		//Sensible defaults
		this.setHardness(1.5f);
		this.setResistance(8.0f);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	/**
	 * Make this block clear like stained glass, respecting
	 * alpha in its texture.
	 */
	public SimpleCosmeticBlock withTranslucency() {
		this.useNeighborBrightness = true;
		this.lightOpacity = 0;
		this.isSolidInside = false;
		this.renderPass = 1;
		
		return this;
	}
	
	/**
	 * Make this block clear like glass, but only
	 * respecting 1-bit alpha in its texture.
	 */
	public SimpleCosmeticBlock withTransparency() {
		this.useNeighborBrightness = true;
		this.lightOpacity = 0;
		this.isSolidInside = false;
		
		return this;
	}
	
	public SimpleCosmeticBlock withStackSize(int stackSize) {
		this.stackSize = stackSize;
		return this;
	}
	
	/**
	 * Mis-deobfuscated. Should actually be "isSolidInside", e.g.
	 * whether suffocation conditions should occur if your head
	 * is inside the block. Also causes the inside-block overlay
	 * to block your view on the client.
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return isSolidInside;
	}
	
	/**
	 * More like cullFacesBehindThisBlock. Generally a good idea
	 * until you can see through it, then it causes huge problems
	 */
	@Override
	public boolean isOpaqueCube() {
        return isSolidInside;
    }
	
	@Override
	public int getRenderBlockPass() {
		return renderPass;
	}
	
	public int getStackSize() {
		return stackSize;
	}
	
	public SimpleCosmeticBlock register() {
		GameRegistry.registerBlock(this, ItemSimpleCosmeticBlock.class, name);
		return this;
	}
}
