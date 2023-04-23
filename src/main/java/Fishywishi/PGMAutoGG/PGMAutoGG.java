package Fishywishi.PGMAutoGG;

import Fishywishi.PGMAutoGG.GuiConfig.PagConfig;
import Fishywishi.PGMAutoGG.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod(modid = Reference.MODID, name = Reference.Mod_NAME, version = Reference.Version, guiFactory = Reference.GUI_FACTORY)
public class PagConfig {
	
	 public static boolean Enabled;	
	
public static final String CATEGORY_NAME_GENERAL = "category_general";



public static void preInit() {
	    File configFile = new File(Loader.instance().getConfigDir(), "PGMAutoGG.cfg");
	    config = new Configuration(configFile);

	    syncFromFile();
	  }

	public static void clientPreInit() {
		MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
	}
	
	public static Configuration getConfig() {
		return config;
	}
	
	public static void syncFromFile() {
		syncConfig(true, true);
	}
	
	public static void syncFromGUI() {
		syncConfig(false, true);
	}
	
	
	
	private static void syncConfig(boolean loadConfigFromFile, boolean readFieldsFromConfig) {
		if (loadConfigFromFile) {
			config.load();
		}
		
		final boolean MY_BOOL_DEFAULT_VALUE = true;
		Property propMyBool = config.get(CATEGORY_NAME_GENERAL, "Enabled", MY_BOOL_DEFAULT_VALUE);
		propMyBool.comment = "Configuration boolean (Enabled)";
		
		
		
		List<String> propOrderGeneral = new ArrayList<String>();
		propOrderGeneral.add(propMyBool.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_GENERAL, propOrderGeneral);
		
		Enabled = propMyBool.getBoolean(MY_BOOL_DEFAULT_VALUE);
		
		
		
		propMyBool.set(Enabled);
		
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	public static Configuration config = null;
	
	public static class ConfigEventHandler {
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (Reference.MODID.equals(event.modID)){
					syncFromGUI();
				}
			
		}
	}
	
	


}
