package hok.chompzki.biocristals.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hok.chompzki.biocristals.BioCristalsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWheatCristal extends Block {
	
	@SideOnly(Side.CLIENT)
    private IIcon[] field_149867_a;
	public static final String NAME = "blockWheatCristal";
	
	private final int maxMeta = 3;
	
	public BlockWheatCristal() {
		super(Material.iron);
		setBlockName(BioCristalsMod.MODID + "_" + NAME);
		setCreativeTab(CreativeTabs.tabMisc);
		setBlockTextureName(BioCristalsMod.MODID + ":" + NAME);
		
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		
	}
	
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

        
        int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

        if (l < maxMeta)
        {
            if (p_149674_5_.nextInt(5) == 0)
            {
                ++l;
                p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l, 2);
            }
        }
        
    }
	
	public void func_149863_m(World p_149863_1_, int p_149863_2_, int p_149863_3_, int p_149863_4_)
    {
        int l = p_149863_1_.getBlockMetadata(p_149863_2_, p_149863_3_, p_149863_4_) + MathHelper.getRandomIntegerInRange(p_149863_1_.rand, 2, 5);

        if (l > maxMeta)
        {
            l = maxMeta;
        }

        p_149863_1_.setBlockMetadataWithNotify(p_149863_2_, p_149863_3_, p_149863_4_, l, 2);
    }
	
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ < 0 || p_149691_2_ > maxMeta)
        {
            p_149691_2_ = maxMeta;
        }

        return this.field_149867_a[p_149691_2_];
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_149867_a = new IIcon[maxMeta+1];
        
        for (int i = 0; i < this.field_149867_a.length; ++i)
        {
            this.field_149867_a[i] = p_149651_1_.registerIcon(this.getTextureName() + "_" + i);
            
        }
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		
		int l = world.getBlockMetadata(x, y, z);

        if (l < maxMeta)
        {
            float f = 1.0f;
            ++l;
            world.setBlockMetadataWithNotify(x, y, z, l, 2);
            
        }else if(l == maxMeta){
        	
        	player.inventory.addItemStackToInventory(new ItemStack(Items.wheat, 2));
        	
        	l = 0;
        	world.setBlockMetadataWithNotify(x, y, z, l, 2);
        	
        }
		
        return true;
    }
	
}













