package Fishywishi.PGMAutoGG.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
	
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
