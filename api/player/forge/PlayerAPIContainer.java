package api.player.forge;

import api.player.forge.PlayerAPIPlugin;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import java.util.Arrays;

public class PlayerAPIContainer extends DummyModContainer {

   public PlayerAPIContainer() {
      super(createMetadata());
   }

   public boolean registerBus(EventBus var1, LoadController var2) {
      return true;
   }

   private static ModMetadata createMetadata() {
      ModMetadata var0 = new ModMetadata();
      var0.modId = "PlayerAPI";
      var0.name = "Player API";
      var0.version = PlayerAPIPlugin.Version;
      var0.description = "Player API for Minecraft Forge";
      var0.url = "http://www.minecraftforum.net/topic/738498-";
      var0.authorList = Arrays.asList(new String[]{"Divisor"});
      return var0;
   }
}
