package Fishywishi.PGMAutoGG.proxy;

import java.io.File;

//import Fishywishi.PGMAutoGG.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void init(FMLInitializationEvent event) {
		
	}

	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent event) {
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "PGMAutoGG.cfg"));
//		Config.readConfig();
	}
	
	
	public void postInit(FMLPostInitializationEvent event) {
		if (config.hasChanged()) {
			config.save();
		}
	}

}
