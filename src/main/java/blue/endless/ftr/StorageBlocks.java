package blue.endless.ftr;

public class StorageBlocks {
	public static SimpleCosmeticBlock ENDER_PEARL;
	public static SimpleCosmeticBlock REEDS;
	public static SimpleCosmeticBlock SUGAR;
	public static SimpleCosmeticBlock GLASS;
	
	public static void init() {
		ENDER_PEARL		= new SimpleCosmeticBlock("enderPearlBlock").withTranslucency().withStackSize(16).register();
		REEDS			= new SimpleCosmeticBlock("reedsBlock").register();
		SUGAR			= new SimpleCosmeticBlock("sugarBlock").register();
		GLASS			= new SimpleCosmeticBlock("glassBlock").withTranslucency().register();
	}
}
