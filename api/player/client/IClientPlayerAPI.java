package api.player.client;

import api.player.client.ClientPlayerAPI;
import api.player.client.IClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;

public interface IClientPlayerAPI extends IClientPlayer {

   ClientPlayerAPI getClientPlayerAPI();

   EntityPlayerSP getEntityPlayerSP();
}
