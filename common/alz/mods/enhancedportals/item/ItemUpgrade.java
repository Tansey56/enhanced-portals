package alz.mods.enhancedportals.item;

import java.util.List;

import alz.mods.enhancedportals.reference.Localizations;
import alz.mods.enhancedportals.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemUpgrade extends Item
{
	String[] text = new String[] { Reference.Strings.PortalModifierUpgrade_MultiplePortals_Name, Reference.Strings.PortalModifierUpgrade_Dimensional_Name, Reference.Strings.PortalModifierUpgrade_AdvancedDimensional_Name, Reference.Strings.PortalModifierUpgrade_ModifierCamo_Name, Reference.Strings.PortalModifierUpgrade_Computer_Name };
	Icon[] textures;
	
	public ItemUpgrade()
	{
		super(Reference.ItemIDs.PortalModifierUpgrade);
		hasSubtypes = true;
		this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName(Reference.Strings.PortalModifierUpgrade_Name);
        maxStackSize = 1;
	}	
	
	@SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister)
    {
		textures = new Icon[text.length];
			
		for (int i = 0; i < textures.length; i++)
		{
			textures[i] = iconRegister.registerIcon(String.format(Reference.Strings.PortalModifierUpgrade_Icon, i));
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return textures[damage];
	}
		
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.uncommon;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < text.length; var4++)
        {
        	if (var4 == 4 && Reference.ComputercraftComputer == null)
        		continue;
        	
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add(Localizations.getLocalizedString(text[itemStack.getItemDamage()]));
	}
}
