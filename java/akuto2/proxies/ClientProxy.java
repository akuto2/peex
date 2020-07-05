package akuto2.proxies;

import akuto2.ObjHandlerPEEX;
import akuto2.rendering.RendererCondenserGrade0;
import akuto2.rendering.RendererCondenserMk3;
import akuto2.tiles.TileEntityCondenserGrade0;
import akuto2.tiles.TileEntityCondenserMk3;
import moze_intel.projecte.api.state.PEStateProps;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = "peex")
public class ClientProxy extends CommonProxy{
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerBlock(ObjHandlerPEEX.aeguMk1_off);
		registerBlock(ObjHandlerPEEX.aeguMk1_on);
		registerBlock(ObjHandlerPEEX.aeguMk2_off);
		registerBlock(ObjHandlerPEEX.aeguMk2_on);
		registerBlock(ObjHandlerPEEX.aeguMk3_off);
		registerBlock(ObjHandlerPEEX.aeguMk3_on);
		registerBlock(ObjHandlerPEEX.collectorMk4);
		registerBlock(ObjHandlerPEEX.collectorMk5);

		ModelLoader.setCustomStateMapper(ObjHandlerPEEX.condenserMk3, (new StateMap.Builder()).ignore(PEStateProps.FACING).build());
		ModelLoader.setCustomStateMapper(ObjHandlerPEEX.condenserGrade0, (new StateMap.Builder()).ignore(PEStateProps.FACING).build());

		registerBlock(ObjHandlerPEEX.aeguEXMk1_off);
		registerBlock(ObjHandlerPEEX.aeguEXMk1_on);
		registerBlock(ObjHandlerPEEX.aeguEXMk2_off);
		registerBlock(ObjHandlerPEEX.aeguEXMk2_on);
		registerBlock(ObjHandlerPEEX.aeguEXMk3_off);
		registerBlock(ObjHandlerPEEX.aeguEXMk3_on);
		registerBlock(ObjHandlerPEEX.aeguEXFinal_off);
		registerBlock(ObjHandlerPEEX.aeguEXFinal_on);
		registerBlock(ObjHandlerPEEX.condenserMk3);
		registerBlock(ObjHandlerPEEX.condenserGrade0);
		registerBlock(ObjHandlerPEEX.collectorMk6);
		registerBlock(ObjHandlerPEEX.collectorMk7);
		registerBlock(ObjHandlerPEEX.collectorMk8);
		registerBlock(ObjHandlerPEEX.collectorMk9);
		registerBlock(ObjHandlerPEEX.collectorMk10);
		registerBlock(ObjHandlerPEEX.collectorFinal);
		registerBlock(ObjHandlerPEEX.relayMk4);
		registerBlock(ObjHandlerPEEX.relayMk5);
		registerBlock(ObjHandlerPEEX.relayFinal);
	}

	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCondenserMk3.class, new RendererCondenserMk3());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCondenserGrade0.class, new RendererCondenserGrade0());
	}

	private static void registerBlock(Block block) {
		String name = ForgeRegistries.BLOCKS.getKey(block).toString();
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(name, "inventory"));
	}

	private static void registerItem(Item item) {
		registerItem(item);
	}

	private static void registerItem(Item item, int meta) {
		String name = ForgeRegistries.ITEMS.getKey(item).toString();
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, "inventory"));
	}

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getWorldClient();
	}
}
