package api.player.model;

import api.player.model.IModelPlayer;
import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerAPI;

public interface IModelPlayerAPI extends IModelPlayer {

   ModelPlayerAPI getModelPlayerAPI();

   ModelPlayer getModelPlayer();
}
