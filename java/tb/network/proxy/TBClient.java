package tb.network.proxy;

import DummyCore.Client.GuiCommon;
import tb.client.render.item.NodeFociRenderer;
import tb.client.render.item.NodeManipulatorItemRenderer;
import tb.client.render.tile.RenderEntityDeconstructor;
import tb.client.render.tile.RenderNodeManipulator;
import tb.client.render.tile.RenderOverchanter;
import tb.common.inventory.ContainerOverchanter;
import tb.common.tile.TileEntityDeconstructor;
import tb.common.tile.TileNodeManipulator;
import tb.common.tile.TileOverchanter;
import tb.init.TBBlocks;
import tb.init.TBItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class TBClient extends TBServer {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		
		if(ID == 0x421922)
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			
			if(tile != null)
			{
				if(tile instanceof TileOverchanter)
				{
					return new GuiCommon(new ContainerOverchanter(player.inventory,tile), tile);
				}
			}
		}
		
		return null;
	}
	
	@Override
	public void registerRenderInformation()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDeconstructor.class, new RenderEntityDeconstructor());
		ClientRegistry.bindTileEntitySpecialRenderer(TileOverchanter.class, new RenderOverchanter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileNodeManipulator.class, new RenderNodeManipulator());
	
		MinecraftForgeClient.registerItemRenderer(TBItems.nodeFoci, new NodeFociRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TBBlocks.nodeManipulator), new NodeManipulatorItemRenderer());
	}

}