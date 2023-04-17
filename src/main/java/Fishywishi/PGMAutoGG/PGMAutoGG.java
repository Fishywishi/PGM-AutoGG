package Fishywishi.PGMAutoGG;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.Mod_NAME, version = Reference.Version)
public class PGMAutoGG {
	
//	@EventHandler
//	public void preInit(FMLPreInitializationEvent event)
//	{
//		
//	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
//	@EventHandler
//	public void postInit(FMLPostInitializationEvent event)
//	{
//		
//	}
//	@EventHandler
//	public void serverLoad(FMLServerStartingEvent event) {
//		//command
//	}
	
	@SubscribeEvent
	public void onChst(ClientChatReceivedEvent event) {
		String message = event.message.getUnformattedText();
			if(message.startsWith("Your stats:") && message.contains("Kills") && message.contains("K/D") && message.contains("Damage")) {
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Pear is old");
			}
	}
}
