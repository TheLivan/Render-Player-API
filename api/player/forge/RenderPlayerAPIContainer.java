package api.player.forge;

import api.player.forge.RenderPlayerAPIPlugin;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import java.util.Arrays;

public class RenderPlayerAPIContainer extends DummyModContainer {

   public RenderPlayerAPIContainer() {
      super(createMetadata());
   }

   public boolean registerBus(EventBus var1, LoadController var2) {
      return true;
   }

   private static ModMetadata createMetadata() {
      ModMetadata var0 = new ModMetadata();
      var0.modId = "RenderPlayerAPI";
      var0.name = "Render Player API";
      var0.version = RenderPlayerAPIPlugin.Version;
      var0.description = "Render Player API for Minecraft Forge";
      var0.url = "http://www.minecraftforum.net/topic/1261354-";
      var0.authorList = Arrays.asList(new String[]{"Divisor"});
      return var0;
   }
}
