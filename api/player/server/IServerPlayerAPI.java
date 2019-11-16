package api.player.server;

import api.player.server.IServerPlayer;
import api.player.server.ServerPlayerAPI;
import net.minecraft.entity.player.EntityPlayerMP;

public interface IServerPlayerAPI extends IServerPlayer {

   ServerPlayerAPI getServerPlayerAPI();

   EntityPlayerMP getEntityPlayerMP();
}
