package Akuto2;

import Akuto2.gui.GuiHandler;
import Akuto2.proxies.CommonProxy;
import Akuto2.utils.CreativeTabPEEX;
import Akuto2.utils.ModInfo;
import Akuto2.utils.PEEXConfig;
import lib.utils.UpdateChecker;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.Metadata;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid="PEEX", name="PEEX", version="2.0.1", dependencies="required-after:AkutoLib;required-after:ProjectE")
public class PEEXCore{
	@Instance("PEEX")
	public static PEEXCore instance;
	@Metadata("PEEX")
	public static ModMetadata meta;
	@SidedProxy(serverSide = "Akuto2.proxies.CommonProxy", clientSide = "Akuto2.proxies.ClientProxy")
	public static CommonProxy proxy;
	public static UpdateChecker update = null;

	public static CreativeTabs peexTab = new CreativeTabPEEX("PEEX");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PEEXConfig.init(event);
		ModInfo.registerInfo(meta);
		update = new UpdateChecker("PEEX", meta);
		update.checkUpdate();
		ObjHandlerPEEX.register();
		proxy.registerModels();
		proxy.registerRenderers();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		ObjHandlerPEEX.addRecipes();
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		if((update != null) && (event.getSide() == Side.SERVER)) {
			update.notifyUpdate(event.getServer(), event.getSide());
		}
	}
}
