package Akuto2.Gui;

import org.lwjgl.opengl.GL11;

import Akuto2.Container.ContainerCollectorMk6;
import Akuto2.TileEntity.TileEntityCollectorMk6;
import moze_intel.projecte.utils.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCollectorMK6 extends GuiContainer{
	private static final ResourceLocation texture = new ResourceLocation("PEEX".toLowerCase(), "textures/gui/collector3.png");
	private TileEntityCollectorMk6 tile;

	public GuiCollectorMK6(InventoryPlayer invPlayer, TileEntityCollectorMk6 tile)
	{
		super(new ContainerCollectorMk6(invPlayer, tile));
		this.tile = tile;
		this.xSize = 218;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2)
	{
		this.fontRendererObj.drawString(Integer.toString(tile.displayEmc), 91, 32, 4210752);

		double kleinCharge = tile.displayItemCharge;

		if (kleinCharge != -1.0D){
			this.fontRendererObj.drawString(Constants.EMC_FORMATTER.format(kleinCharge), 91, 44, 4210752);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		int progress = tile.getSunLevelScaled(12);
		this.drawTexturedModalRect(x + 160, y + 49 - progress, 220, 13 - progress, 12, progress);

		progress = tile.getEmcScaled(48);
		this.drawTexturedModalRect(x + 98, y + 18, 0, 166, progress, 10);

		progress = tile.getKleinStarChargeScaled(48);
		this.drawTexturedModalRect(x + 98, y + 58, 0, 166, progress, 10);

		progress = tile.getFuelProgressScaled(24);
		this.drawTexturedModalRect(x + 172, y + 55 - progress, 219, 38 - progress, 10, progress + 1);
	}
}
