package api.player.model;

import org.objectweb.asm.MethodVisitor;

public final class ModelPlayerConstructorVisitor extends MethodVisitor {

   private final boolean isObfuscated;
   private final boolean createApi;
   private final int parameterOffset;


   public ModelPlayerConstructorVisitor(MethodVisitor var1, boolean var2, boolean var3, int var4) {
      super(262144, var1);
      this.isObfuscated = var2;
      this.createApi = var3;
      this.parameterOffset = var4;
   }

   public void visitMethodInsn(int var1, String var2, String var3, String var4) {
      if(this.isObfuscated && var3.equals("<init>") && var2.equals("net/minecraft/client/model/ModelBiped")) {
         var2 = "bhm";
      }

      if(var3.equals("<init>") && var2.equals("api/player/model/ModelPlayer")) {
         var4 = var4.substring(0, var4.indexOf(")")) + "Ljava/lang/String;)V";
         this.mv.visitVarInsn(25, this.parameterOffset);
      }

      super.visitMethodInsn(var1, var2, var3, var4);
      if(this.createApi && var3.equals("<init>") && var2.equals(this.isObfuscated?"bhm":"net/minecraft/client/model/ModelBiped")) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitVarInsn(25, 0);
         this.mv.visitVarInsn(23, 1);
         this.mv.visitVarInsn(23, 2);
         this.mv.visitVarInsn(21, 3);
         this.mv.visitVarInsn(21, 4);
         this.mv.visitVarInsn(25, 5);
         this.mv.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "create", "(Lapi/player/model/IModelPlayerAPI;FFIILjava/lang/String;)Lapi/player/model/ModelPlayerAPI;");
         this.mv.visitFieldInsn(181, "api/player/model/ModelPlayer", "modelPlayerAPI", "Lapi/player/model/ModelPlayerAPI;");
         this.mv.visitVarInsn(25, 0);
         this.mv.visitIntInsn(23, 1);
         this.mv.visitIntInsn(23, 2);
         this.mv.visitIntInsn(21, 3);
         this.mv.visitIntInsn(21, 4);
         this.mv.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "beforeLocalConstructing", "(Lapi/player/model/IModelPlayerAPI;FFII)V");
      }

   }

   public void visitInsn(int var1) {
      if(this.createApi && var1 == 177) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitIntInsn(23, 1);
         this.mv.visitIntInsn(23, 2);
         this.mv.visitIntInsn(21, 3);
         this.mv.visitIntInsn(21, 4);
         this.mv.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "afterLocalConstructing", "(Lapi/player/model/IModelPlayerAPI;FFII)V");
      }

      super.visitInsn(var1);
   }
}
