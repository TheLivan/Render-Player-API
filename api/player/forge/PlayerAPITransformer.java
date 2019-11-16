package api.player.forge;

import api.player.client.ClientPlayerClassVisitor;
import api.player.forge.PlayerAPIPlugin;
import api.player.server.ServerPlayerClassVisitor;
import net.minecraft.launchwrapper.IClassTransformer;

public class PlayerAPITransformer implements IClassTransformer {

   public byte[] transform(String var1, String var2, byte[] var3) {
      return var2.equals("net.minecraft.client.entity.EntityPlayerSP")?ClientPlayerClassVisitor.transform(var3, PlayerAPIPlugin.isObfuscated):(var2.equals("net.minecraft.entity.player.EntityPlayerMP")?ServerPlayerClassVisitor.transform(var3, PlayerAPIPlugin.isObfuscated):var3);
   }
}
