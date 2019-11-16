package api.player.server;

import org.objectweb.asm.MethodVisitor;

public final class ServerPlayerConstructorVisitor extends MethodVisitor {

   private final boolean isObfuscated;


   public ServerPlayerConstructorVisitor(MethodVisitor var1, boolean var2) {
      super(262144, var1);
      this.isObfuscated = var2;
   }

   public void visitMethodInsn(int var1, String var2, String var3, String var4) {
      super.visitMethodInsn(var1, var2, var3, var4);
      if(var3.equals("<init>") && var2.equals(this.isObfuscated?"yz":"net/minecraft/entity/player/EntityPlayer")) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitVarInsn(25, 0);
         this.mv.visitMethodInsn(184, "api/player/server/ServerPlayerAPI", "create", "(Lapi/player/server/IServerPlayerAPI;)Lapi/player/server/ServerPlayerAPI;");
         this.mv.visitFieldInsn(181, this.isObfuscated?"mw":"net/minecraft/entity/player/EntityPlayerMP", "serverPlayerAPI", "Lapi/player/server/ServerPlayerAPI;");
         this.mv.visitVarInsn(25, 0);
         this.mv.visitIntInsn(25, 1);
         this.mv.visitIntInsn(25, 2);
         this.mv.visitIntInsn(25, 3);
         this.mv.visitIntInsn(25, 4);
         this.mv.visitMethodInsn(184, "api/player/server/ServerPlayerAPI", "beforeLocalConstructing", "(Lapi/player/server/IServerPlayerAPI;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/WorldServer;Lcom/mojang/authlib/GameProfile;Lnet/minecraft/server/management/ItemInWorldManager;)V");
      }

   }

   public void visitInsn(int var1) {
      if(var1 == 177) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitIntInsn(25, 1);
         this.mv.visitIntInsn(25, 2);
         this.mv.visitIntInsn(25, 3);
         this.mv.visitIntInsn(25, 4);
         this.mv.visitMethodInsn(184, "api/player/server/ServerPlayerAPI", "afterLocalConstructing", "(Lapi/player/server/IServerPlayerAPI;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/WorldServer;Lcom/mojang/authlib/GameProfile;Lnet/minecraft/server/management/ItemInWorldManager;)V");
      }

      super.visitInsn(var1);
   }
}
