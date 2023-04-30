package Fishywishi.PGMAutoGG.GuiConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Fishywishi.PGMAutoGG.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;


public class GuiFactory implements IModGuiFactory 
{
    @Override
    public void initialize(Minecraft minecraftInstance) 
    {
 
    }
 
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() 
    {
        return PagGuiConfig.class;
    }
 
    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() 
    {
    	return null;
    }
 
    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) 
    {
        return null;
    }
    
    
    public static class PagGuiConfig extends GuiConfig {
    	
    	
    	public PagGuiConfig(GuiScreen parentScreen) {
    		super(parentScreen, getConfigElements(), Reference.MODID, false, false, "Test");
    	}
    	
    	private static List<IConfigElement> getConfigElements() {
    		List<IConfigElement> list = new ArrayList<IConfigElement>();
    		list.add(new DummyCategoryElement("General", "gui.GuiConfig.category.category_general", CategoryEntryGeneral.class));
    		return list;
    	}
    	
    	public static class CategoryEntryGeneral extends CategoryEntry {
    		
    		public CategoryEntryGeneral(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
    			super(owningScreen, owningEntryList, prop);
    		}
    		
    		@Override
    		protected GuiScreen buildChildScreen()
    		{
    			Configuration configuration = PagConfig.getConfig();
    			ConfigElement cat_general = new ConfigElement(configuration.getCategory(PagConfig.CATEGORY_NAME_GENERAL));
    			List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
    			String windowTitle = configuration.toString();
    			

    			
    			 return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                         this.owningScreen.modID,
                         PagConfig.CATEGORY_NAME_GENERAL,
                         this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                         this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                         windowTitle);
			
    			}
    		
				    		@Override
				    		public void onGuiClosed() {
				    			try{
				    				PagConfig.syncFromGUI();
				    		    } catch (Exception ignored) {}
				    		}
    		}
    	
    }
    
  
}
