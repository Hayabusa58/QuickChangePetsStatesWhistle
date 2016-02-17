package me.peregrine.whistlemod;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = "ChangeSTWhistle", name = "QuickChangeStatusWhistle")
public class WhistlemodCore {
	@Instance("ChangeSTWhitle")
	public static WhistlemodCore instance;

	//Logging
	public static Logger logger = LogManager.getLogger("Whistlemod");

	public static ItemChangeSTWhistle Whistle;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Whistle = new ItemChangeSTWhistle();
		GameRegistry.registerItem(Whistle,"itemwhistle");

	//Config
	Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
	try {
		cfg.load();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		cfg.save();
	}

	}

	@EventHandler
	public void postInit(FMLInitializationEvent event) throws IOException {
	//レシピの登録等
		GameRegistry.addRecipe(new ItemStack(WhistlemodCore.Whistle,1),
						"X  ",
						" Y ",
						"  Z",
						'X',Items.stick,
						'Y',Items.iron_ingot,
						'Z',Items.string
		);
		}


}
