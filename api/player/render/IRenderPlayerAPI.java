package api.player.render;

import api.player.render.IRenderPlayer;
import api.player.render.RenderPlayerAPI;
import net.minecraft.client.renderer.entity.RenderPlayer;

public interface IRenderPlayerAPI extends IRenderPlayer {

   RenderPlayerAPI getRenderPlayerAPI();

   RenderPlayer getRenderPlayer();
}
