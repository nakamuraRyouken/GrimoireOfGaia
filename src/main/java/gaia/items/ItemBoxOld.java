package gaia.items;

import gaia.Gaia;
import gaia.init.GaiaItems;
import gaia.init.Sounds;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBoxOld extends GaiaLootable {

	public ItemBoxOld(String name) {
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("text.GrimoireOfGaia.RightClickUse"));
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		player.playSound(Sounds.box_open2, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		Random random = new Random();
		int i = random.nextInt(4);
		switch(i) {
		case 0:
			return loot(GaiaItems.MiscGigaGear);
		case 1:
			return loot(GaiaItems.BookWither);
		case 2:
			return loot(GaiaItems.Spawn);
		case 3:
			return loot(GaiaItems.BagBook);
		default:
			return new ActionResult(EnumActionResult.SUCCESS, stack);
		}		
	}
}
