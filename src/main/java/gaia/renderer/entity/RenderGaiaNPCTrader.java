package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCHolstaurus;
import gaia.model.ModelGaiaNPCTrader;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCTrader extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Trader.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaNPCTrader(float shadowSize) {
        super(rend, new ModelGaiaNPCTrader(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCTrader.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCTrader.leftarm));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
