package api.player.model;

import api.player.model.ModelPlayerBase;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public interface IModelPlayer {

   ModelPlayerBase getModelPlayerBase(String var1);

   Set getModelPlayerBaseIds();

   float getExpandParameter();

   float getYOffsetParameter();

   int getTextureWidthParameter();

   int getTextureHeightParameter();

   String getModelPlayerType();

   Object dynamic(String var1, Object[] var2);

   ModelRenderer realGetRandomModelBox(Random var1);

   ModelRenderer superGetRandomModelBox(Random var1);

   ModelRenderer localGetRandomModelBox(Random var1);

   TextureOffset realGetTextureOffset(String var1);

   TextureOffset superGetTextureOffset(String var1);

   TextureOffset localGetTextureOffset(String var1);

   void realRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void superRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void localRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

   void realRenderCloak(float var1);

   void superRenderCloak(float var1);

   void localRenderCloak(float var1);

   void realRenderEars(float var1);

   void superRenderEars(float var1);

   void localRenderEars(float var1);

   void realSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4);

   void superSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4);

   void localSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4);

   void realSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

   void superSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

   void localSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

   void realSetTextureOffset(String var1, int var2, int var3);

   void superSetTextureOffset(String var1, int var2, int var3);

   void localSetTextureOffset(String var1, int var2, int var3);

   boolean getAimedBowField();

   void setAimedBowField(boolean var1);

   ModelRenderer getBipedBodyField();

   void setBipedBodyField(ModelRenderer var1);

   ModelRenderer getBipedCloakField();

   void setBipedCloakField(ModelRenderer var1);

   ModelRenderer getBipedEarsField();

   void setBipedEarsField(ModelRenderer var1);

   ModelRenderer getBipedHeadField();

   void setBipedHeadField(ModelRenderer var1);

   ModelRenderer getBipedHeadwearField();

   void setBipedHeadwearField(ModelRenderer var1);

   ModelRenderer getBipedLeftArmField();

   void setBipedLeftArmField(ModelRenderer var1);

   ModelRenderer getBipedLeftLegField();

   void setBipedLeftLegField(ModelRenderer var1);

   ModelRenderer getBipedRightArmField();

   void setBipedRightArmField(ModelRenderer var1);

   ModelRenderer getBipedRightLegField();

   void setBipedRightLegField(ModelRenderer var1);

   List getBoxListField();

   void setBoxListField(List var1);

   int getHeldItemLeftField();

   void setHeldItemLeftField(int var1);

   int getHeldItemRightField();

   void setHeldItemRightField(int var1);

   boolean getIsChildField();

   void setIsChildField(boolean var1);

   boolean getIsRidingField();

   void setIsRidingField(boolean var1);

   boolean getIsSneakField();

   void setIsSneakField(boolean var1);

   float getOnGroundField();

   void setOnGroundField(float var1);

   int getTextureHeightField();

   void setTextureHeightField(int var1);

   int getTextureWidthField();

   void setTextureWidthField(int var1);
}
