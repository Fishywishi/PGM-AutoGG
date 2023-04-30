package Fishywishi.PGMAutoGG.Commands;

import java.util.ArrayList;
import java.util.List;

import Fishywishi.PGMAutoGG.GuiConfig.GuiFactory.PagGuiConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class GuiCommand implements ICommand {
	
	
    private final List aliases;

	
	public GuiCommand() 
    { 
        aliases = new ArrayList(); 
        aliases.add("pag"); 
        aliases.add("pagconfig"); 
    } 

	@Override
	public int compareTo(ICommand o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "PGMAutoGG";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		new DelayedTask((() -> Minecraft.getMinecraft().displayGuiScreen(new PagGuiConfig(null))), 1);

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public class DelayedTask {
	    private int counter;
	    private Runnable runnable;

	    public DelayedTask(Runnable run, int ticks){
	        counter = ticks;
	        this.runnable = run;
	        MinecraftForge.EVENT_BUS.register(this);
	    }

	    @SubscribeEvent
	    public void onTick(TickEvent.ClientTickEvent event){
	        if (event.phase != Phase.START) return;

	        if(counter <= 0){
	            MinecraftForge.EVENT_BUS.unregister(this);
	            runnable.run();
	        }

	        counter--;
	    }
	}

}