package api.player.forge;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import java.util.Map;

@MCVersion("1.7.10")
@TransformerExclusions({"api.player.forge"})
public class RenderPlayerAPIPlugin implements IFMLLoadingPlugin {

   public static String Version = "1.4";
   public static boolean isObfuscated;


   public String[] getASMTransformerClass() {
      return new String[]{"api.player.forge.RenderPlayerAPITransformer"};
   }

   public String getModContainerClass() {
      return "api.player.forge.RenderPlayerAPIContainer";
   }

   public String getSetupClass() {
      return null;
   }

   public void injectData(Map var1) {
      isObfuscated = ((Boolean)var1.get("runtimeDeobfuscationEnabled")).booleanValue();
   }

   public String getAccessTransformerClass() {
      return null;
   }

}
