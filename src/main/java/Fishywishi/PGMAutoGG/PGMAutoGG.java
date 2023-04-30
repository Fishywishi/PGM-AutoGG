package Fishywishi.PGMAutoGG;


import Fishywishi.PGMAutoGG.Commands.GuiCommand;
import Fishywishi.PGMAutoGG.GuiConfig.PagConfig;
import Fishywishi.PGMAutoGG.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod(modid = Reference.MODID, name = Reference.Mod_NAME, version = Reference.Version, guiFactory = Reference.GUI_FACTORY)
public class PGMAutoGG {
	

	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
//	public static Logger logger;
	
	@Mod.Instance("PGMAutoGG")
	public static PGMAutoGG instance;

	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
//		logger = event.getModLog();
		proxy.preInit(event);
		PagConfig.preInit();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		FMLCommonHandler.instance().bus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
		
		ClientCommandHandler h = ClientCommandHandler.instance;
		h.registerCommand(new GuiCommand());
		
	
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	
		
		@SubscribeEvent
		public void onChst(ClientChatReceivedEvent event) {
			if (PagConfig.Enabled == true) {
				String message = event.message.getUnformattedText();
			if(message.startsWith("Your stats:") && message.contains("Kills") && message.contains("K/D") && message.contains("Damage")) {
				Minecraft.getMinecraft().thePlayer.sendChatMessage(PagConfig.Message);
			}
//			if(message.startsWith("Your team lost") || message.startsWith("Your team won!") || message.startsWith("Game over!")){
//				Minecraft.getMinecraft().thePlayer.sendChatMessage("gg");
//			}
			
			
		}
		
	}
	
	
}
