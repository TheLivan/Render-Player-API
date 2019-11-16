package api.player.client;

import org.objectweb.asm.MethodVisitor;

public final class ClientPlayerConstructorVisitor extends MethodVisitor {

   private final boolean isObfuscated;


   public ClientPlayerConstructorVisitor(MethodVisitor var1, boolean var2) {
      super(262144, var1);
      this.isObfuscated = var2;
   }

   public void visitMethodInsn(int var1, String var2, String var3, String var4) {
      super.visitMethodInsn(var1, var2, var3, var4);
      if(var3.equals("<init>") && var2.equals(this.isObfuscated?"blg":"net/minecraft/client/entity/AbstractClientPlayer")) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitVarInsn(25, 0);
         this.mv.visitMethodInsn(184, "api/player/client/ClientPlayerAPI", "create", "(Lapi/player/client/IClientPlayerAPI;)Lapi/player/client/ClientPlayerAPI;");
         this.mv.visitFieldInsn(181, this.isObfuscated?"blk":"net/minecraft/client/entity/EntityPlayerSP", "clientPlayerAPI", "Lapi/player/client/ClientPlayerAPI;");
         this.mv.visitVarInsn(25, 0);
         this.mv.visitIntInsn(25, 1);
         this.mv.visitIntInsn(25, 2);
         this.mv.visitIntInsn(25, 3);
         this.mv.visitIntInsn(21, 4);
         this.mv.visitMethodInsn(184, "api/player/client/ClientPlayerAPI", "beforeLocalConstructing", "(Lapi/player/client/IClientPlayerAPI;Lnet/minecraft/client/Minecraft;Lnet/minecraft/world/World;Lnet/minecraft/util/Session;I)V");
      }

   }

   public void visitInsn(int var1) {
      if(var1 == 177) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitIntInsn(25, 1);
         this.mv.visitIntInsn(25, 2);
         this.mv.visitIntInsn(25, 3);
         this.mv.visitIntInsn(21, 4);
         this.mv.visitMethodInsn(184, "api/player/client/ClientPlayerAPI", "afterLocalConstructing", "(Lapi/player/client/IClientPlayerAPI;Lnet/minecraft/client/Minecraft;Lnet/minecraft/world/World;Lnet/minecraft/util/Session;I)V");
      }

      super.visitInsn(var1);
   }
}
