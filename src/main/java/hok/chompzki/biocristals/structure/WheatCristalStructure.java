package hok.chompzki.biocristals.structure;

import hok.chompzki.biocristals.api.BioHelper;
import hok.chompzki.biocristals.api.IStructure;
import hok.chompzki.biocristals.registrys.BlockRegistry;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WheatCristalStructure implements IStructure {

	@Override
	public boolean hasResources(ItemStack stack, EntityPlayer player) {
		return true;
	}

	@Override
	public boolean canPlaceAt(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z) {// AxisAlignedBB
		
		return BioHelper.getFirstEntityItemWithinAABB(world, player, Items.wheat, 10, 10, 10) != null;
	}
	
	@Override
	public void pay(ItemStack stack, EntityPlayer player) {
		
	}
	
	@Override
	public void construct(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z) {
		EntityItem item = BioHelper.getFirstEntityItemWithinAABB(world, player, Items.wheat, 10, 10, 10);
		if(item != null && item.getEntityItem().getItem() == Items.wheat){
			world.setBlock(x, y, z, BlockRegistry.wheatCristal);
			
			item.getEntityItem().stackSize--;
			if(item.getEntityItem().stackSize <= 0)
				item.setDead();
		}
	}

}