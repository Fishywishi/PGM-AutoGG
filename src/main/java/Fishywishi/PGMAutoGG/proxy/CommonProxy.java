package Fishywishi.PGMAutoGG.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		Fishywishi.PGMAutoGG.GuiConfig.StartupCommon.preInitCommon();
	}
	public void init(FMLInitializationEvent event) {
		Fishywishi.PGMAutoGG.GuiConfig.StartupCommon.initCommon();
	}

	
	public void postInit(FMLPostInitializationEvent event) {
		
		Fishywishi.PGMAutoGG.GuiConfig.StartupCommon.postInitCommon();
	}

}
