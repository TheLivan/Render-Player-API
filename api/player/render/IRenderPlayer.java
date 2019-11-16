package api.player.render;

import api.player.render.RenderPlayerBase;
import java.util.Set;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface IRenderPlayer {

   RenderPlayerBase getRenderPlayerBase(String var1);

   Set getRenderPlayerBaseIds();

   Object dynamic(String var1, Object[] var2);

   boolean realDoRenderLabel(EntityLivingBase var1);

   boolean superDoRenderLabel(EntityLivingBase var1);

   boolean localDoRenderLabel(EntityLivingBase var1);

   void realDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9);

   void superDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9);

   void localDoRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9);

   int realGetColorMultiplier(EntityLivingBase var1, float var2, float var3);

   int superGetColorMultiplier(EntityLivingBase var1, float var2, float var3);

   int localGetColorMultiplier(EntityLivingBase var1, float var2, float var3);

   float realGetDeathMaxRotation(EntityLivingBase var1);

   float superGetDeathMaxRotation(EntityLivingBase var1);

   float localGetDeathMaxRotation(EntityLivingBase var1);

   FontRenderer realGetFontRendererFromRenderManager();

   FontRenderer superGetFontRendererFromRenderManager();

   FontRenderer localGetFontRendererFromRenderManager();

   ResourceLocation realGetResourceLocationFromPlayer(AbstractClientPlayer var1);

   ResourceLocation localGetResourceLocationFromPlayer(AbstractClientPlayer var1);

   float realHandleRotationFloat(EntityLivingBase var1, float var2);

   float superHandleRotationFloat(EntityLivingBase var1, float var2);

   float localHandleRotationFloat(EntityLivingBase var1, float var2);

   int realInheritRenderPass(EntityLivingBase var1, int var2, float var3);

   int superInheritRenderPass(EntityLivingBase var1, int var2, float var3);

   int localInheritRenderPass(EntityLivingBase var1, int var2, float var3);

   void realLoadTexture(ResourceLocation var1);

   void superLoadTexture(ResourceLocation var1);

   void localLoadTexture(ResourceLocation var1);

   void realLoadTextureOfEntity(Entity var1);

   void superLoadTextureOfEntity(Entity var1);

   void localLoadTextureOfEntity(Entity var1);

   void realPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6);

   void superPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6);

   void localPassSpecialRender(EntityLivingBase var1, double var2, double var4, double var6);

   boolean realPerformStaticEntityRebuild();

   boolean superPerformStaticEntityRebuild();

   boolean localPerformStaticEntityRebuild();

   void realRenderArrowsStuckInEntity(EntityLivingBase var1, float var2);

   void superRenderArrowsStuckInEntity(EntityLivingBase var1, float var2);

   void localRenderArrowsStuckInEntity(EntityLivingBase var1, float var2);

   void realRenderFirstPersonArm(EntityPlayer var1);

   void localRenderFirstPersonArm(EntityPlayer var1);

   void realRenderLivingLabel(Entity var1, String var2, double var3, double var5, double var7, int var9);

   void superRenderLivingLabel(Entity var1, String var2, double var3, double var5, double var7, int var9);

   void localRenderLivingLabel(Entity var1, String var2, double var3, double var5, double var7, int var9);

   void realRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void superRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void localRenderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void realRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9);

   void localRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9);

   void realRenderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10);

   void localRenderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10);

   void realRenderPlayerScale(AbstractClientPlayer var1, float var2);

   void localRenderPlayerScale(AbstractClientPlayer var1, float var2);

   void realRenderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6);

   void localRenderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6);

   void realRenderSpecials(AbstractClientPlayer var1, float var2);

   void localRenderSpecials(AbstractClientPlayer var1, float var2);

   float realRenderSwingProgress(EntityLivingBase var1, float var2);

   float superRenderSwingProgress(EntityLivingBase var1, float var2);

   float localRenderSwingProgress(EntityLivingBase var1, float var2);

   void realRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4);

   void localRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4);

   int realSetArmorModel(AbstractClientPlayer var1, int var2, float var3);

   int localSetArmorModel(AbstractClientPlayer var1, int var2, float var3);

   void realSetPassArmorModel(AbstractClientPlayer var1, int var2, float var3);

   void localSetPassArmorModel(AbstractClientPlayer var1, int var2, float var3);

   void realSetRenderManager(RenderManager var1);

   void superSetRenderManager(RenderManager var1);

   void localSetRenderManager(RenderManager var1);

   void realSetRenderPassModel(ModelBase var1);

   void superSetRenderPassModel(ModelBase var1);

   void localSetRenderPassModel(ModelBase var1);

   void realUpdateIcons(IIconRegister var1);

   void superUpdateIcons(IIconRegister var1);

   void localUpdateIcons(IIconRegister var1);

   ModelBase getMainModelField();

   void setMainModelField(ModelBase var1);

   ModelBiped getModelArmorField();

   void setModelArmorField(ModelBiped var1);

   ModelBiped getModelArmorChestplateField();

   void setModelArmorChestplateField(ModelBiped var1);

   ModelBiped getModelBipedMainField();

   void setModelBipedMainField(ModelBiped var1);

   RenderBlocks getRenderBlocksField();

   void setRenderBlocksField(RenderBlocks var1);

   RenderManager getRenderManagerField();

   void setRenderManagerField(RenderManager var1);

   ModelBase getRenderPassModelField();

   void setRenderPassModelField(ModelBase var1);

   float getShadowOpaqueField();

   void setShadowOpaqueField(float var1);

   float getShadowSizeField();

   void setShadowSizeField(float var1);

   ResourceLocation getSteveTexturesField();
}
