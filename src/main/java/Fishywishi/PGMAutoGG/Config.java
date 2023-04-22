package Fishywishi.PGMAutoGG;

import org.apache.logging.log4j.Level;

import Fishywishi.PGMAutoGG.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_GENERAL = "general";	
	
	public static boolean EnabledOrDisabled = true;
	
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
			System.out.println("CONFIG DETECTED" + EnabledOrDisabled);
		} catch (Exception e1) {
			PGMAutoGG.logger.log(Level.ERROR, "Problem loading config file!", e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
				System.out.println("CHANGE DETECTED IN CONFIG");
			}
		}
	}
	
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
		EnabledOrDisabled = cfg.getBoolean("Mode", CATEGORY_GENERAL, EnabledOrDisabled, "Set to false to disable the mod");
	}

}
