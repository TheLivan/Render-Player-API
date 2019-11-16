package api.player.render;

import java.util.Map;
import java.util.Stack;
import org.objectweb.asm.MethodVisitor;

public final class RenderPlayerConstructorVisitor extends MethodVisitor {

   private final boolean isObfuscated;
   private final Map constructorReplacements;


   public RenderPlayerConstructorVisitor(MethodVisitor var1, boolean var2, Map var3) {
      super(262144, var1);
      this.isObfuscated = var2;
      this.constructorReplacements = var3;
   }

   public void visitTypeInsn(int var1, String var2) {
      if(var1 == 187 && this.constructorReplacements != null && this.constructorReplacements.containsKey(var2)) {
         Stack var3 = (Stack)this.constructorReplacements.get(var2);
         if(!var3.isEmpty()) {
            var2 = (String)var3.peek();
         }

         int var4 = var2.indexOf(":");
         if(var4 > 0) {
            var2 = var2.substring(0, var4);
         }
      }

      super.visitTypeInsn(var1, var2);
   }

   public void visitMethodInsn(int var1, String var2, String var3, String var4) {
      if(var3.equals("<init>") && this.constructorReplacements != null && this.constructorReplacements.containsKey(var2)) {
         Stack var5 = (Stack)this.constructorReplacements.get(var2);
         if(!var5.isEmpty()) {
            var2 = (String)var5.pop();
         }

         int var6 = var2.indexOf(":");
         if(var6 > 0) {
            this.mv.visitLdcInsn(var2.substring(var6 + 1));
            var2 = var2.substring(0, var6);
            int var7 = var4.indexOf(")");
            var4 = var4.substring(0, var7) + "Ljava/lang/String;" + var4.substring(var7);
         }
      }

      super.visitMethodInsn(var1, var2, var3, var4);
      if(var3.equals("<init>") && var2.equals(this.isObfuscated?"boh":"net/minecraft/client/renderer/entity/RendererLivingEntity")) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitVarInsn(25, 0);
         this.mv.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "create", "(Lapi/player/render/IRenderPlayerAPI;)Lapi/player/render/RenderPlayerAPI;");
         this.mv.visitFieldInsn(181, this.isObfuscated?"bop":"net/minecraft/client/renderer/entity/RenderPlayer", "renderPlayerAPI", "Lapi/player/render/RenderPlayerAPI;");
         this.mv.visitVarInsn(25, 0);
         this.mv.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "beforeLocalConstructing", "(Lapi/player/render/IRenderPlayerAPI;)V");
      }

   }

   public void visitInsn(int var1) {
      if(var1 == 177) {
         this.mv.visitVarInsn(25, 0);
         this.mv.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "afterLocalConstructing", "(Lapi/player/render/IRenderPlayerAPI;)V");
      }

      super.visitInsn(var1);
   }
}
