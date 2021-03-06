package alz.mods.enhancedportals.block;

import alz.mods.enhancedportals.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDialDevice extends Block
{
	public BlockDialDevice()
	{
		super(Reference.BlockIDs.DialDevice, Material.rock);
		setHardness(50.0F);
		setResistance(2000.0F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(Reference.Strings.DialDevice_Name);
		setCreativeTab(CreativeTabs.tabBlock);
	}
}
