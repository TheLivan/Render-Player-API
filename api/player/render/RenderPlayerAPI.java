package api.player.render;

import api.player.forge.RenderPlayerAPIPlugin;
import api.player.render.IRenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import api.player.render.RenderPlayerBaseSorter;
import api.player.render.RenderPlayerBaseSorting;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public final class RenderPlayerAPI {

   private static final Class[] Class = new Class[]{RenderPlayerAPI.class};
   private static final Class[] Classes = new Class[]{RenderPlayerAPI.class, String.class};
   private static boolean isCreated;
   private static final Logger logger = Logger.getLogger("RenderPlayerAPI");
   private static List allInstances = new ArrayList();
   private static final Map EmptySortMap = Collections.unmodifiableMap(new HashMap());
   private static final List beforeDoRenderLabelHookTypes = new LinkedList();
   private static final List overrideDoRenderLabelHookTypes = new LinkedList();
   private static final List afterDoRenderLabelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeDoRenderLabelHooks;
   private RenderPlayerBase[] overrideDoRenderLabelHooks;
   private RenderPlayerBase[] afterDoRenderLabelHooks;
   public boolean isDoRenderLabelModded;
   private static final Map allBaseBeforeDoRenderLabelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDoRenderLabelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDoRenderLabelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDoRenderLabelInferiors = new Hashtable(0);
   private static final Map allBaseAfterDoRenderLabelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDoRenderLabelInferiors = new Hashtable(0);
   private static final List beforeDoRenderShadowAndFireHookTypes = new LinkedList();
   private static final List overrideDoRenderShadowAndFireHookTypes = new LinkedList();
   private static final List afterDoRenderShadowAndFireHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeDoRenderShadowAndFireHooks;
   private RenderPlayerBase[] overrideDoRenderShadowAndFireHooks;
   private RenderPlayerBase[] afterDoRenderShadowAndFireHooks;
   public boolean isDoRenderShadowAndFireModded;
   private static final Map allBaseBeforeDoRenderShadowAndFireSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDoRenderShadowAndFireInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDoRenderShadowAndFireSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDoRenderShadowAndFireInferiors = new Hashtable(0);
   private static final Map allBaseAfterDoRenderShadowAndFireSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDoRenderShadowAndFireInferiors = new Hashtable(0);
   private static final List beforeGetColorMultiplierHookTypes = new LinkedList();
   private static final List overrideGetColorMultiplierHookTypes = new LinkedList();
   private static final List afterGetColorMultiplierHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeGetColorMultiplierHooks;
   private RenderPlayerBase[] overrideGetColorMultiplierHooks;
   private RenderPlayerBase[] afterGetColorMultiplierHooks;
   public boolean isGetColorMultiplierModded;
   private static final Map allBaseBeforeGetColorMultiplierSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetColorMultiplierInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetColorMultiplierSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetColorMultiplierInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetColorMultiplierSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetColorMultiplierInferiors = new Hashtable(0);
   private static final List beforeGetDeathMaxRotationHookTypes = new LinkedList();
   private static final List overrideGetDeathMaxRotationHookTypes = new LinkedList();
   private static final List afterGetDeathMaxRotationHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeGetDeathMaxRotationHooks;
   private RenderPlayerBase[] overrideGetDeathMaxRotationHooks;
   private RenderPlayerBase[] afterGetDeathMaxRotationHooks;
   public boolean isGetDeathMaxRotationModded;
   private static final Map allBaseBeforeGetDeathMaxRotationSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetDeathMaxRotationInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetDeathMaxRotationSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetDeathMaxRotationInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetDeathMaxRotationSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetDeathMaxRotationInferiors = new Hashtable(0);
   private static final List beforeGetFontRendererFromRenderManagerHookTypes = new LinkedList();
   private static final List overrideGetFontRendererFromRenderManagerHookTypes = new LinkedList();
   private static final List afterGetFontRendererFromRenderManagerHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeGetFontRendererFromRenderManagerHooks;
   private RenderPlayerBase[] overrideGetFontRendererFromRenderManagerHooks;
   private RenderPlayerBase[] afterGetFontRendererFromRenderManagerHooks;
   public boolean isGetFontRendererFromRenderManagerModded;
   private static final Map allBaseBeforeGetFontRendererFromRenderManagerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetFontRendererFromRenderManagerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetFontRendererFromRenderManagerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetFontRendererFromRenderManagerInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetFontRendererFromRenderManagerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetFontRendererFromRenderManagerInferiors = new Hashtable(0);
   private static final List beforeGetResourceLocationFromPlayerHookTypes = new LinkedList();
   private static final List overrideGetResourceLocationFromPlayerHookTypes = new LinkedList();
   private static final List afterGetResourceLocationFromPlayerHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeGetResourceLocationFromPlayerHooks;
   private RenderPlayerBase[] overrideGetResourceLocationFromPlayerHooks;
   private RenderPlayerBase[] afterGetResourceLocationFromPlayerHooks;
   public boolean isGetResourceLocationFromPlayerModded;
   private static final Map allBaseBeforeGetResourceLocationFromPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetResourceLocationFromPlayerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetResourceLocationFromPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetResourceLocationFromPlayerInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetResourceLocationFromPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetResourceLocationFromPlayerInferiors = new Hashtable(0);
   private static final List beforeHandleRotationFloatHookTypes = new LinkedList();
   private static final List overrideHandleRotationFloatHookTypes = new LinkedList();
   private static final List afterHandleRotationFloatHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeHandleRotationFloatHooks;
   private RenderPlayerBase[] overrideHandleRotationFloatHooks;
   private RenderPlayerBase[] afterHandleRotationFloatHooks;
   public boolean isHandleRotationFloatModded;
   private static final Map allBaseBeforeHandleRotationFloatSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeHandleRotationFloatInferiors = new Hashtable(0);
   private static final Map allBaseOverrideHandleRotationFloatSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideHandleRotationFloatInferiors = new Hashtable(0);
   private static final Map allBaseAfterHandleRotationFloatSuperiors = new Hashtable(0);
   private static final Map allBaseAfterHandleRotationFloatInferiors = new Hashtable(0);
   private static final List beforeInheritRenderPassHookTypes = new LinkedList();
   private static final List overrideInheritRenderPassHookTypes = new LinkedList();
   private static final List afterInheritRenderPassHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeInheritRenderPassHooks;
   private RenderPlayerBase[] overrideInheritRenderPassHooks;
   private RenderPlayerBase[] afterInheritRenderPassHooks;
   public boolean isInheritRenderPassModded;
   private static final Map allBaseBeforeInheritRenderPassSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeInheritRenderPassInferiors = new Hashtable(0);
   private static final Map allBaseOverrideInheritRenderPassSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideInheritRenderPassInferiors = new Hashtable(0);
   private static final Map allBaseAfterInheritRenderPassSuperiors = new Hashtable(0);
   private static final Map allBaseAfterInheritRenderPassInferiors = new Hashtable(0);
   private static final List beforeLoadTextureHookTypes = new LinkedList();
   private static final List overrideLoadTextureHookTypes = new LinkedList();
   private static final List afterLoadTextureHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeLoadTextureHooks;
   private RenderPlayerBase[] overrideLoadTextureHooks;
   private RenderPlayerBase[] afterLoadTextureHooks;
   public boolean isLoadTextureModded;
   private static final Map allBaseBeforeLoadTextureSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeLoadTextureInferiors = new Hashtable(0);
   private static final Map allBaseOverrideLoadTextureSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideLoadTextureInferiors = new Hashtable(0);
   private static final Map allBaseAfterLoadTextureSuperiors = new Hashtable(0);
   private static final Map allBaseAfterLoadTextureInferiors = new Hashtable(0);
   private static final List beforeLoadTextureOfEntityHookTypes = new LinkedList();
   private static final List overrideLoadTextureOfEntityHookTypes = new LinkedList();
   private static final List afterLoadTextureOfEntityHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeLoadTextureOfEntityHooks;
   private RenderPlayerBase[] overrideLoadTextureOfEntityHooks;
   private RenderPlayerBase[] afterLoadTextureOfEntityHooks;
   public boolean isLoadTextureOfEntityModded;
   private static final Map allBaseBeforeLoadTextureOfEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeLoadTextureOfEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideLoadTextureOfEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideLoadTextureOfEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterLoadTextureOfEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterLoadTextureOfEntityInferiors = new Hashtable(0);
   private static final List beforePassSpecialRenderHookTypes = new LinkedList();
   private static final List overridePassSpecialRenderHookTypes = new LinkedList();
   private static final List afterPassSpecialRenderHookTypes = new LinkedList();
   private RenderPlayerBase[] beforePassSpecialRenderHooks;
   private RenderPlayerBase[] overridePassSpecialRenderHooks;
   private RenderPlayerBase[] afterPassSpecialRenderHooks;
   public boolean isPassSpecialRenderModded;
   private static final Map allBaseBeforePassSpecialRenderSuperiors = new Hashtable(0);
   private static final Map allBaseBeforePassSpecialRenderInferiors = new Hashtable(0);
   private static final Map allBaseOverridePassSpecialRenderSuperiors = new Hashtable(0);
   private static final Map allBaseOverridePassSpecialRenderInferiors = new Hashtable(0);
   private static final Map allBaseAfterPassSpecialRenderSuperiors = new Hashtable(0);
   private static final Map allBaseAfterPassSpecialRenderInferiors = new Hashtable(0);
   private static final List beforePerformStaticEntityRebuildHookTypes = new LinkedList();
   private static final List overridePerformStaticEntityRebuildHookTypes = new LinkedList();
   private static final List afterPerformStaticEntityRebuildHookTypes = new LinkedList();
   private RenderPlayerBase[] beforePerformStaticEntityRebuildHooks;
   private RenderPlayerBase[] overridePerformStaticEntityRebuildHooks;
   private RenderPlayerBase[] afterPerformStaticEntityRebuildHooks;
   public boolean isPerformStaticEntityRebuildModded;
   private static final Map allBaseBeforePerformStaticEntityRebuildSuperiors = new Hashtable(0);
   private static final Map allBaseBeforePerformStaticEntityRebuildInferiors = new Hashtable(0);
   private static final Map allBaseOverridePerformStaticEntityRebuildSuperiors = new Hashtable(0);
   private static final Map allBaseOverridePerformStaticEntityRebuildInferiors = new Hashtable(0);
   private static final Map allBaseAfterPerformStaticEntityRebuildSuperiors = new Hashtable(0);
   private static final Map allBaseAfterPerformStaticEntityRebuildInferiors = new Hashtable(0);
   private static final List beforeRenderArrowsStuckInEntityHookTypes = new LinkedList();
   private static final List overrideRenderArrowsStuckInEntityHookTypes = new LinkedList();
   private static final List afterRenderArrowsStuckInEntityHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderArrowsStuckInEntityHooks;
   private RenderPlayerBase[] overrideRenderArrowsStuckInEntityHooks;
   private RenderPlayerBase[] afterRenderArrowsStuckInEntityHooks;
   public boolean isRenderArrowsStuckInEntityModded;
   private static final Map allBaseBeforeRenderArrowsStuckInEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderArrowsStuckInEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderArrowsStuckInEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderArrowsStuckInEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderArrowsStuckInEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderArrowsStuckInEntityInferiors = new Hashtable(0);
   private static final List beforeRenderFirstPersonArmHookTypes = new LinkedList();
   private static final List overrideRenderFirstPersonArmHookTypes = new LinkedList();
   private static final List afterRenderFirstPersonArmHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderFirstPersonArmHooks;
   private RenderPlayerBase[] overrideRenderFirstPersonArmHooks;
   private RenderPlayerBase[] afterRenderFirstPersonArmHooks;
   public boolean isRenderFirstPersonArmModded;
   private static final Map allBaseBeforeRenderFirstPersonArmSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderFirstPersonArmInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderFirstPersonArmSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderFirstPersonArmInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderFirstPersonArmSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderFirstPersonArmInferiors = new Hashtable(0);
   private static final List beforeRenderLivingLabelHookTypes = new LinkedList();
   private static final List overrideRenderLivingLabelHookTypes = new LinkedList();
   private static final List afterRenderLivingLabelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderLivingLabelHooks;
   private RenderPlayerBase[] overrideRenderLivingLabelHooks;
   private RenderPlayerBase[] afterRenderLivingLabelHooks;
   public boolean isRenderLivingLabelModded;
   private static final Map allBaseBeforeRenderLivingLabelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderLivingLabelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderLivingLabelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderLivingLabelInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderLivingLabelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderLivingLabelInferiors = new Hashtable(0);
   private static final List beforeRenderModelHookTypes = new LinkedList();
   private static final List overrideRenderModelHookTypes = new LinkedList();
   private static final List afterRenderModelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderModelHooks;
   private RenderPlayerBase[] overrideRenderModelHooks;
   private RenderPlayerBase[] afterRenderModelHooks;
   public boolean isRenderModelModded;
   private static final Map allBaseBeforeRenderModelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderModelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderModelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderModelInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderModelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderModelInferiors = new Hashtable(0);
   private static final List beforeRenderPlayerHookTypes = new LinkedList();
   private static final List overrideRenderPlayerHookTypes = new LinkedList();
   private static final List afterRenderPlayerHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderPlayerHooks;
   private RenderPlayerBase[] overrideRenderPlayerHooks;
   private RenderPlayerBase[] afterRenderPlayerHooks;
   public boolean isRenderPlayerModded;
   private static final Map allBaseBeforeRenderPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderPlayerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerInferiors = new Hashtable(0);
   private static final List beforeRenderPlayerNameAndScoreLabelHookTypes = new LinkedList();
   private static final List overrideRenderPlayerNameAndScoreLabelHookTypes = new LinkedList();
   private static final List afterRenderPlayerNameAndScoreLabelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderPlayerNameAndScoreLabelHooks;
   private RenderPlayerBase[] overrideRenderPlayerNameAndScoreLabelHooks;
   private RenderPlayerBase[] afterRenderPlayerNameAndScoreLabelHooks;
   public boolean isRenderPlayerNameAndScoreLabelModded;
   private static final Map allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderPlayerNameAndScoreLabelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerNameAndScoreLabelInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerNameAndScoreLabelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerNameAndScoreLabelInferiors = new Hashtable(0);
   private static final List beforeRenderPlayerScaleHookTypes = new LinkedList();
   private static final List overrideRenderPlayerScaleHookTypes = new LinkedList();
   private static final List afterRenderPlayerScaleHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderPlayerScaleHooks;
   private RenderPlayerBase[] overrideRenderPlayerScaleHooks;
   private RenderPlayerBase[] afterRenderPlayerScaleHooks;
   public boolean isRenderPlayerScaleModded;
   private static final Map allBaseBeforeRenderPlayerScaleSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderPlayerScaleInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerScaleSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerScaleInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerScaleSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerScaleInferiors = new Hashtable(0);
   private static final List beforeRenderPlayerSleepHookTypes = new LinkedList();
   private static final List overrideRenderPlayerSleepHookTypes = new LinkedList();
   private static final List afterRenderPlayerSleepHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderPlayerSleepHooks;
   private RenderPlayerBase[] overrideRenderPlayerSleepHooks;
   private RenderPlayerBase[] afterRenderPlayerSleepHooks;
   public boolean isRenderPlayerSleepModded;
   private static final Map allBaseBeforeRenderPlayerSleepSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderPlayerSleepInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerSleepSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderPlayerSleepInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerSleepSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderPlayerSleepInferiors = new Hashtable(0);
   private static final List beforeRenderSpecialsHookTypes = new LinkedList();
   private static final List overrideRenderSpecialsHookTypes = new LinkedList();
   private static final List afterRenderSpecialsHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderSpecialsHooks;
   private RenderPlayerBase[] overrideRenderSpecialsHooks;
   private RenderPlayerBase[] afterRenderSpecialsHooks;
   public boolean isRenderSpecialsModded;
   private static final Map allBaseBeforeRenderSpecialsSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderSpecialsInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderSpecialsSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderSpecialsInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderSpecialsSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderSpecialsInferiors = new Hashtable(0);
   private static final List beforeRenderSwingProgressHookTypes = new LinkedList();
   private static final List overrideRenderSwingProgressHookTypes = new LinkedList();
   private static final List afterRenderSwingProgressHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRenderSwingProgressHooks;
   private RenderPlayerBase[] overrideRenderSwingProgressHooks;
   private RenderPlayerBase[] afterRenderSwingProgressHooks;
   public boolean isRenderSwingProgressModded;
   private static final Map allBaseBeforeRenderSwingProgressSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRenderSwingProgressInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderSwingProgressSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRenderSwingProgressInferiors = new Hashtable(0);
   private static final Map allBaseAfterRenderSwingProgressSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRenderSwingProgressInferiors = new Hashtable(0);
   private static final List beforeRotatePlayerHookTypes = new LinkedList();
   private static final List overrideRotatePlayerHookTypes = new LinkedList();
   private static final List afterRotatePlayerHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeRotatePlayerHooks;
   private RenderPlayerBase[] overrideRotatePlayerHooks;
   private RenderPlayerBase[] afterRotatePlayerHooks;
   public boolean isRotatePlayerModded;
   private static final Map allBaseBeforeRotatePlayerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeRotatePlayerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideRotatePlayerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideRotatePlayerInferiors = new Hashtable(0);
   private static final Map allBaseAfterRotatePlayerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterRotatePlayerInferiors = new Hashtable(0);
   private static final List beforeSetArmorModelHookTypes = new LinkedList();
   private static final List overrideSetArmorModelHookTypes = new LinkedList();
   private static final List afterSetArmorModelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeSetArmorModelHooks;
   private RenderPlayerBase[] overrideSetArmorModelHooks;
   private RenderPlayerBase[] afterSetArmorModelHooks;
   public boolean isSetArmorModelModded;
   private static final Map allBaseBeforeSetArmorModelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetArmorModelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetArmorModelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetArmorModelInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetArmorModelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetArmorModelInferiors = new Hashtable(0);
   private static final List beforeSetPassArmorModelHookTypes = new LinkedList();
   private static final List overrideSetPassArmorModelHookTypes = new LinkedList();
   private static final List afterSetPassArmorModelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeSetPassArmorModelHooks;
   private RenderPlayerBase[] overrideSetPassArmorModelHooks;
   private RenderPlayerBase[] afterSetPassArmorModelHooks;
   public boolean isSetPassArmorModelModded;
   private static final Map allBaseBeforeSetPassArmorModelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetPassArmorModelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetPassArmorModelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetPassArmorModelInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetPassArmorModelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetPassArmorModelInferiors = new Hashtable(0);
   private static final List beforeSetRenderManagerHookTypes = new LinkedList();
   private static final List overrideSetRenderManagerHookTypes = new LinkedList();
   private static final List afterSetRenderManagerHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeSetRenderManagerHooks;
   private RenderPlayerBase[] overrideSetRenderManagerHooks;
   private RenderPlayerBase[] afterSetRenderManagerHooks;
   public boolean isSetRenderManagerModded;
   private static final Map allBaseBeforeSetRenderManagerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetRenderManagerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetRenderManagerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetRenderManagerInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetRenderManagerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetRenderManagerInferiors = new Hashtable(0);
   private static final List beforeSetRenderPassModelHookTypes = new LinkedList();
   private static final List overrideSetRenderPassModelHookTypes = new LinkedList();
   private static final List afterSetRenderPassModelHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeSetRenderPassModelHooks;
   private RenderPlayerBase[] overrideSetRenderPassModelHooks;
   private RenderPlayerBase[] afterSetRenderPassModelHooks;
   public boolean isSetRenderPassModelModded;
   private static final Map allBaseBeforeSetRenderPassModelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetRenderPassModelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetRenderPassModelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetRenderPassModelInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetRenderPassModelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetRenderPassModelInferiors = new Hashtable(0);
   private static final List beforeUpdateIconsHookTypes = new LinkedList();
   private static final List overrideUpdateIconsHookTypes = new LinkedList();
   private static final List afterUpdateIconsHookTypes = new LinkedList();
   private RenderPlayerBase[] beforeUpdateIconsHooks;
   private RenderPlayerBase[] overrideUpdateIconsHooks;
   private RenderPlayerBase[] afterUpdateIconsHooks;
   public boolean isUpdateIconsModded;
   private static final Map allBaseBeforeUpdateIconsSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeUpdateIconsInferiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdateIconsSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdateIconsInferiors = new Hashtable(0);
   private static final Map allBaseAfterUpdateIconsSuperiors = new Hashtable(0);
   private static final Map allBaseAfterUpdateIconsInferiors = new Hashtable(0);
   protected final IRenderPlayerAPI renderPlayer;
   private static final Set keys = new HashSet();
   private static final Map keysToVirtualIds = new HashMap();
   private static final Set dynamicTypes = new HashSet();
   private static final Map virtualDynamicHookMethods = new HashMap();
   private static final Map beforeDynamicHookMethods = new HashMap();
   private static final Map overrideDynamicHookMethods = new HashMap();
   private static final Map afterDynamicHookMethods = new HashMap();
   private static final List beforeLocalConstructingHookTypes = new LinkedList();
   private static final List afterLocalConstructingHookTypes = new LinkedList();
   private static final Map beforeDynamicHookTypes = new Hashtable(0);
   private static final Map overrideDynamicHookTypes = new Hashtable(0);
   private static final Map afterDynamicHookTypes = new Hashtable(0);
   private RenderPlayerBase[] beforeLocalConstructingHooks;
   private RenderPlayerBase[] afterLocalConstructingHooks;
   private final Map baseObjectsToId = new Hashtable();
   private final Map allBaseObjects = new Hashtable();
   private final Set unmodifiableAllBaseIds;
   private static final Map allBaseConstructors = new Hashtable();
   private static final Set unmodifiableAllIds = Collections.unmodifiableSet(allBaseConstructors.keySet());
   private static final Map allBaseBeforeLocalConstructingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeLocalConstructingInferiors = new Hashtable(0);
   private static final Map allBaseAfterLocalConstructingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterLocalConstructingInferiors = new Hashtable(0);
   private static final Map allBaseBeforeDynamicSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDynamicInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDynamicSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDynamicInferiors = new Hashtable(0);
   private static final Map allBaseAfterDynamicSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDynamicInferiors = new Hashtable(0);
   private static boolean initialized = false;


   private static void log(String var0) {
      System.out.println(var0);
      logger.fine(var0);
   }

   public static void register(String var0, Class var1) {
      register(var0, var1, (RenderPlayerBaseSorting)null);
   }

   public static void register(String var0, Class var1, RenderPlayerBaseSorting var2) {
      try {
         register(var1, var0, var2);
      } catch (RuntimeException var4) {
         if(var0 != null) {
            log("Render Player: failed to register id \'" + var0 + "\'");
         } else {
            log("Render Player: failed to register RenderPlayerBase");
         }

         throw var4;
      }
   }

   private static void register(Class var0, String var1, RenderPlayerBaseSorting var2) {
      if(!isCreated) {
         try {
            Method var3 = RenderPlayer.class.getMethod("getRenderPlayerBase", new Class[]{String.class});
            if(var3.getReturnType() != RenderPlayerBase.class) {
               throw new NoSuchMethodException(RenderPlayerBase.class.getName() + " " + RenderPlayer.class.getName() + ".getRenderPlayerBase(" + String.class.getName() + ")");
            }
         } catch (NoSuchMethodException var16) {
            String[] var4 = new String[]{"========================================", "The API \"Render Player\" version " + RenderPlayerAPIPlugin.Version + " of the mod \"Render Player API Core " + RenderPlayerAPIPlugin.Version + "\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getRenderPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Render Player API Core which Minecraft version matches its own.", "  Download and install the latest Render Player API Core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Render Player API Core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Render Player API Core has not been installed correctly.", "  Deinstall Render Player API Core and install it again following the installation instructions in the readme file.", "========================================"};
            String var5 = RenderPlayerBase.class.getName();
            String var6 = RenderPlayer.class.getName();
            String var7 = var6.replace(".", File.separator);
            String var8 = String.class.getName();

            for(int var9 = 0; var9 < var4.length; ++var9) {
               var4[var9] = MessageFormat.format(var4[var9], new Object[]{var5, var6, var7, var8});
            }

            String[] var21 = var4;
            int var10 = var4.length;

            int var11;
            String var12;
            for(var11 = 0; var11 < var10; ++var11) {
               var12 = var21[var11];
               logger.severe(var12);
            }

            var21 = var4;
            var10 = var4.length;

            for(var11 = 0; var11 < var10; ++var11) {
               var12 = var21[var11];
               System.err.println(var12);
            }

            String var22 = "\n\n";
            String[] var23 = var4;
            var11 = var4.length;

            for(int var24 = 0; var24 < var11; ++var24) {
               String var13 = var23[var24];
               var22 = var22 + "\t" + var13 + "\n";
            }

            throw new RuntimeException(var22, var16);
         }

         log("Render Player " + RenderPlayerAPIPlugin.Version + " Created");
         isCreated = true;
      }

      if(var1 == null) {
         throw new NullPointerException("Argument \'id\' can not be null");
      } else if(var0 == null) {
         throw new NullPointerException("Argument \'baseClass\' can not be null");
      } else {
         Constructor var17 = (Constructor)allBaseConstructors.get(var1);
         if(var17 != null) {
            throw new IllegalArgumentException("The class \'" + var0.getName() + "\' can not be registered with the id \'" + var1 + "\' because the class \'" + var17.getDeclaringClass().getName() + "\' has allready been registered with the same id");
         } else {
            Constructor var18;
            try {
               var18 = var0.getDeclaredConstructor(Classes);
            } catch (Throwable var15) {
               try {
                  var18 = var0.getDeclaredConstructor(Class);
               } catch (Throwable var14) {
                  throw new IllegalArgumentException("Can not find necessary constructor with one argument of type \'" + RenderPlayerAPI.class.getName() + "\' and eventually a second argument of type \'String\' in the class \'" + var0.getName() + "\'", var15);
               }
            }

            allBaseConstructors.put(var1, var18);
            if(var2 != null) {
               addSorting(var1, allBaseBeforeLocalConstructingSuperiors, var2.getBeforeLocalConstructingSuperiors());
               addSorting(var1, allBaseBeforeLocalConstructingInferiors, var2.getBeforeLocalConstructingInferiors());
               addSorting(var1, allBaseAfterLocalConstructingSuperiors, var2.getAfterLocalConstructingSuperiors());
               addSorting(var1, allBaseAfterLocalConstructingInferiors, var2.getAfterLocalConstructingInferiors());
               addDynamicSorting(var1, allBaseBeforeDynamicSuperiors, var2.getDynamicBeforeSuperiors());
               addDynamicSorting(var1, allBaseBeforeDynamicInferiors, var2.getDynamicBeforeInferiors());
               addDynamicSorting(var1, allBaseOverrideDynamicSuperiors, var2.getDynamicOverrideSuperiors());
               addDynamicSorting(var1, allBaseOverrideDynamicInferiors, var2.getDynamicOverrideInferiors());
               addDynamicSorting(var1, allBaseAfterDynamicSuperiors, var2.getDynamicAfterSuperiors());
               addDynamicSorting(var1, allBaseAfterDynamicInferiors, var2.getDynamicAfterInferiors());
               addSorting(var1, allBaseBeforeDoRenderLabelSuperiors, var2.getBeforeDoRenderLabelSuperiors());
               addSorting(var1, allBaseBeforeDoRenderLabelInferiors, var2.getBeforeDoRenderLabelInferiors());
               addSorting(var1, allBaseOverrideDoRenderLabelSuperiors, var2.getOverrideDoRenderLabelSuperiors());
               addSorting(var1, allBaseOverrideDoRenderLabelInferiors, var2.getOverrideDoRenderLabelInferiors());
               addSorting(var1, allBaseAfterDoRenderLabelSuperiors, var2.getAfterDoRenderLabelSuperiors());
               addSorting(var1, allBaseAfterDoRenderLabelInferiors, var2.getAfterDoRenderLabelInferiors());
               addSorting(var1, allBaseBeforeDoRenderShadowAndFireSuperiors, var2.getBeforeDoRenderShadowAndFireSuperiors());
               addSorting(var1, allBaseBeforeDoRenderShadowAndFireInferiors, var2.getBeforeDoRenderShadowAndFireInferiors());
               addSorting(var1, allBaseOverrideDoRenderShadowAndFireSuperiors, var2.getOverrideDoRenderShadowAndFireSuperiors());
               addSorting(var1, allBaseOverrideDoRenderShadowAndFireInferiors, var2.getOverrideDoRenderShadowAndFireInferiors());
               addSorting(var1, allBaseAfterDoRenderShadowAndFireSuperiors, var2.getAfterDoRenderShadowAndFireSuperiors());
               addSorting(var1, allBaseAfterDoRenderShadowAndFireInferiors, var2.getAfterDoRenderShadowAndFireInferiors());
               addSorting(var1, allBaseBeforeGetColorMultiplierSuperiors, var2.getBeforeGetColorMultiplierSuperiors());
               addSorting(var1, allBaseBeforeGetColorMultiplierInferiors, var2.getBeforeGetColorMultiplierInferiors());
               addSorting(var1, allBaseOverrideGetColorMultiplierSuperiors, var2.getOverrideGetColorMultiplierSuperiors());
               addSorting(var1, allBaseOverrideGetColorMultiplierInferiors, var2.getOverrideGetColorMultiplierInferiors());
               addSorting(var1, allBaseAfterGetColorMultiplierSuperiors, var2.getAfterGetColorMultiplierSuperiors());
               addSorting(var1, allBaseAfterGetColorMultiplierInferiors, var2.getAfterGetColorMultiplierInferiors());
               addSorting(var1, allBaseBeforeGetDeathMaxRotationSuperiors, var2.getBeforeGetDeathMaxRotationSuperiors());
               addSorting(var1, allBaseBeforeGetDeathMaxRotationInferiors, var2.getBeforeGetDeathMaxRotationInferiors());
               addSorting(var1, allBaseOverrideGetDeathMaxRotationSuperiors, var2.getOverrideGetDeathMaxRotationSuperiors());
               addSorting(var1, allBaseOverrideGetDeathMaxRotationInferiors, var2.getOverrideGetDeathMaxRotationInferiors());
               addSorting(var1, allBaseAfterGetDeathMaxRotationSuperiors, var2.getAfterGetDeathMaxRotationSuperiors());
               addSorting(var1, allBaseAfterGetDeathMaxRotationInferiors, var2.getAfterGetDeathMaxRotationInferiors());
               addSorting(var1, allBaseBeforeGetFontRendererFromRenderManagerSuperiors, var2.getBeforeGetFontRendererFromRenderManagerSuperiors());
               addSorting(var1, allBaseBeforeGetFontRendererFromRenderManagerInferiors, var2.getBeforeGetFontRendererFromRenderManagerInferiors());
               addSorting(var1, allBaseOverrideGetFontRendererFromRenderManagerSuperiors, var2.getOverrideGetFontRendererFromRenderManagerSuperiors());
               addSorting(var1, allBaseOverrideGetFontRendererFromRenderManagerInferiors, var2.getOverrideGetFontRendererFromRenderManagerInferiors());
               addSorting(var1, allBaseAfterGetFontRendererFromRenderManagerSuperiors, var2.getAfterGetFontRendererFromRenderManagerSuperiors());
               addSorting(var1, allBaseAfterGetFontRendererFromRenderManagerInferiors, var2.getAfterGetFontRendererFromRenderManagerInferiors());
               addSorting(var1, allBaseBeforeGetResourceLocationFromPlayerSuperiors, var2.getBeforeGetResourceLocationFromPlayerSuperiors());
               addSorting(var1, allBaseBeforeGetResourceLocationFromPlayerInferiors, var2.getBeforeGetResourceLocationFromPlayerInferiors());
               addSorting(var1, allBaseOverrideGetResourceLocationFromPlayerSuperiors, var2.getOverrideGetResourceLocationFromPlayerSuperiors());
               addSorting(var1, allBaseOverrideGetResourceLocationFromPlayerInferiors, var2.getOverrideGetResourceLocationFromPlayerInferiors());
               addSorting(var1, allBaseAfterGetResourceLocationFromPlayerSuperiors, var2.getAfterGetResourceLocationFromPlayerSuperiors());
               addSorting(var1, allBaseAfterGetResourceLocationFromPlayerInferiors, var2.getAfterGetResourceLocationFromPlayerInferiors());
               addSorting(var1, allBaseBeforeHandleRotationFloatSuperiors, var2.getBeforeHandleRotationFloatSuperiors());
               addSorting(var1, allBaseBeforeHandleRotationFloatInferiors, var2.getBeforeHandleRotationFloatInferiors());
               addSorting(var1, allBaseOverrideHandleRotationFloatSuperiors, var2.getOverrideHandleRotationFloatSuperiors());
               addSorting(var1, allBaseOverrideHandleRotationFloatInferiors, var2.getOverrideHandleRotationFloatInferiors());
               addSorting(var1, allBaseAfterHandleRotationFloatSuperiors, var2.getAfterHandleRotationFloatSuperiors());
               addSorting(var1, allBaseAfterHandleRotationFloatInferiors, var2.getAfterHandleRotationFloatInferiors());
               addSorting(var1, allBaseBeforeInheritRenderPassSuperiors, var2.getBeforeInheritRenderPassSuperiors());
               addSorting(var1, allBaseBeforeInheritRenderPassInferiors, var2.getBeforeInheritRenderPassInferiors());
               addSorting(var1, allBaseOverrideInheritRenderPassSuperiors, var2.getOverrideInheritRenderPassSuperiors());
               addSorting(var1, allBaseOverrideInheritRenderPassInferiors, var2.getOverrideInheritRenderPassInferiors());
               addSorting(var1, allBaseAfterInheritRenderPassSuperiors, var2.getAfterInheritRenderPassSuperiors());
               addSorting(var1, allBaseAfterInheritRenderPassInferiors, var2.getAfterInheritRenderPassInferiors());
               addSorting(var1, allBaseBeforeLoadTextureSuperiors, var2.getBeforeLoadTextureSuperiors());
               addSorting(var1, allBaseBeforeLoadTextureInferiors, var2.getBeforeLoadTextureInferiors());
               addSorting(var1, allBaseOverrideLoadTextureSuperiors, var2.getOverrideLoadTextureSuperiors());
               addSorting(var1, allBaseOverrideLoadTextureInferiors, var2.getOverrideLoadTextureInferiors());
               addSorting(var1, allBaseAfterLoadTextureSuperiors, var2.getAfterLoadTextureSuperiors());
               addSorting(var1, allBaseAfterLoadTextureInferiors, var2.getAfterLoadTextureInferiors());
               addSorting(var1, allBaseBeforeLoadTextureOfEntitySuperiors, var2.getBeforeLoadTextureOfEntitySuperiors());
               addSorting(var1, allBaseBeforeLoadTextureOfEntityInferiors, var2.getBeforeLoadTextureOfEntityInferiors());
               addSorting(var1, allBaseOverrideLoadTextureOfEntitySuperiors, var2.getOverrideLoadTextureOfEntitySuperiors());
               addSorting(var1, allBaseOverrideLoadTextureOfEntityInferiors, var2.getOverrideLoadTextureOfEntityInferiors());
               addSorting(var1, allBaseAfterLoadTextureOfEntitySuperiors, var2.getAfterLoadTextureOfEntitySuperiors());
               addSorting(var1, allBaseAfterLoadTextureOfEntityInferiors, var2.getAfterLoadTextureOfEntityInferiors());
               addSorting(var1, allBaseBeforePassSpecialRenderSuperiors, var2.getBeforePassSpecialRenderSuperiors());
               addSorting(var1, allBaseBeforePassSpecialRenderInferiors, var2.getBeforePassSpecialRenderInferiors());
               addSorting(var1, allBaseOverridePassSpecialRenderSuperiors, var2.getOverridePassSpecialRenderSuperiors());
               addSorting(var1, allBaseOverridePassSpecialRenderInferiors, var2.getOverridePassSpecialRenderInferiors());
               addSorting(var1, allBaseAfterPassSpecialRenderSuperiors, var2.getAfterPassSpecialRenderSuperiors());
               addSorting(var1, allBaseAfterPassSpecialRenderInferiors, var2.getAfterPassSpecialRenderInferiors());
               addSorting(var1, allBaseBeforePerformStaticEntityRebuildSuperiors, var2.getBeforePerformStaticEntityRebuildSuperiors());
               addSorting(var1, allBaseBeforePerformStaticEntityRebuildInferiors, var2.getBeforePerformStaticEntityRebuildInferiors());
               addSorting(var1, allBaseOverridePerformStaticEntityRebuildSuperiors, var2.getOverridePerformStaticEntityRebuildSuperiors());
               addSorting(var1, allBaseOverridePerformStaticEntityRebuildInferiors, var2.getOverridePerformStaticEntityRebuildInferiors());
               addSorting(var1, allBaseAfterPerformStaticEntityRebuildSuperiors, var2.getAfterPerformStaticEntityRebuildSuperiors());
               addSorting(var1, allBaseAfterPerformStaticEntityRebuildInferiors, var2.getAfterPerformStaticEntityRebuildInferiors());
               addSorting(var1, allBaseBeforeRenderArrowsStuckInEntitySuperiors, var2.getBeforeRenderArrowsStuckInEntitySuperiors());
               addSorting(var1, allBaseBeforeRenderArrowsStuckInEntityInferiors, var2.getBeforeRenderArrowsStuckInEntityInferiors());
               addSorting(var1, allBaseOverrideRenderArrowsStuckInEntitySuperiors, var2.getOverrideRenderArrowsStuckInEntitySuperiors());
               addSorting(var1, allBaseOverrideRenderArrowsStuckInEntityInferiors, var2.getOverrideRenderArrowsStuckInEntityInferiors());
               addSorting(var1, allBaseAfterRenderArrowsStuckInEntitySuperiors, var2.getAfterRenderArrowsStuckInEntitySuperiors());
               addSorting(var1, allBaseAfterRenderArrowsStuckInEntityInferiors, var2.getAfterRenderArrowsStuckInEntityInferiors());
               addSorting(var1, allBaseBeforeRenderFirstPersonArmSuperiors, var2.getBeforeRenderFirstPersonArmSuperiors());
               addSorting(var1, allBaseBeforeRenderFirstPersonArmInferiors, var2.getBeforeRenderFirstPersonArmInferiors());
               addSorting(var1, allBaseOverrideRenderFirstPersonArmSuperiors, var2.getOverrideRenderFirstPersonArmSuperiors());
               addSorting(var1, allBaseOverrideRenderFirstPersonArmInferiors, var2.getOverrideRenderFirstPersonArmInferiors());
               addSorting(var1, allBaseAfterRenderFirstPersonArmSuperiors, var2.getAfterRenderFirstPersonArmSuperiors());
               addSorting(var1, allBaseAfterRenderFirstPersonArmInferiors, var2.getAfterRenderFirstPersonArmInferiors());
               addSorting(var1, allBaseBeforeRenderLivingLabelSuperiors, var2.getBeforeRenderLivingLabelSuperiors());
               addSorting(var1, allBaseBeforeRenderLivingLabelInferiors, var2.getBeforeRenderLivingLabelInferiors());
               addSorting(var1, allBaseOverrideRenderLivingLabelSuperiors, var2.getOverrideRenderLivingLabelSuperiors());
               addSorting(var1, allBaseOverrideRenderLivingLabelInferiors, var2.getOverrideRenderLivingLabelInferiors());
               addSorting(var1, allBaseAfterRenderLivingLabelSuperiors, var2.getAfterRenderLivingLabelSuperiors());
               addSorting(var1, allBaseAfterRenderLivingLabelInferiors, var2.getAfterRenderLivingLabelInferiors());
               addSorting(var1, allBaseBeforeRenderModelSuperiors, var2.getBeforeRenderModelSuperiors());
               addSorting(var1, allBaseBeforeRenderModelInferiors, var2.getBeforeRenderModelInferiors());
               addSorting(var1, allBaseOverrideRenderModelSuperiors, var2.getOverrideRenderModelSuperiors());
               addSorting(var1, allBaseOverrideRenderModelInferiors, var2.getOverrideRenderModelInferiors());
               addSorting(var1, allBaseAfterRenderModelSuperiors, var2.getAfterRenderModelSuperiors());
               addSorting(var1, allBaseAfterRenderModelInferiors, var2.getAfterRenderModelInferiors());
               addSorting(var1, allBaseBeforeRenderPlayerSuperiors, var2.getBeforeRenderPlayerSuperiors());
               addSorting(var1, allBaseBeforeRenderPlayerInferiors, var2.getBeforeRenderPlayerInferiors());
               addSorting(var1, allBaseOverrideRenderPlayerSuperiors, var2.getOverrideRenderPlayerSuperiors());
               addSorting(var1, allBaseOverrideRenderPlayerInferiors, var2.getOverrideRenderPlayerInferiors());
               addSorting(var1, allBaseAfterRenderPlayerSuperiors, var2.getAfterRenderPlayerSuperiors());
               addSorting(var1, allBaseAfterRenderPlayerInferiors, var2.getAfterRenderPlayerInferiors());
               addSorting(var1, allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors, var2.getBeforeRenderPlayerNameAndScoreLabelSuperiors());
               addSorting(var1, allBaseBeforeRenderPlayerNameAndScoreLabelInferiors, var2.getBeforeRenderPlayerNameAndScoreLabelInferiors());
               addSorting(var1, allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors, var2.getOverrideRenderPlayerNameAndScoreLabelSuperiors());
               addSorting(var1, allBaseOverrideRenderPlayerNameAndScoreLabelInferiors, var2.getOverrideRenderPlayerNameAndScoreLabelInferiors());
               addSorting(var1, allBaseAfterRenderPlayerNameAndScoreLabelSuperiors, var2.getAfterRenderPlayerNameAndScoreLabelSuperiors());
               addSorting(var1, allBaseAfterRenderPlayerNameAndScoreLabelInferiors, var2.getAfterRenderPlayerNameAndScoreLabelInferiors());
               addSorting(var1, allBaseBeforeRenderPlayerScaleSuperiors, var2.getBeforeRenderPlayerScaleSuperiors());
               addSorting(var1, allBaseBeforeRenderPlayerScaleInferiors, var2.getBeforeRenderPlayerScaleInferiors());
               addSorting(var1, allBaseOverrideRenderPlayerScaleSuperiors, var2.getOverrideRenderPlayerScaleSuperiors());
               addSorting(var1, allBaseOverrideRenderPlayerScaleInferiors, var2.getOverrideRenderPlayerScaleInferiors());
               addSorting(var1, allBaseAfterRenderPlayerScaleSuperiors, var2.getAfterRenderPlayerScaleSuperiors());
               addSorting(var1, allBaseAfterRenderPlayerScaleInferiors, var2.getAfterRenderPlayerScaleInferiors());
               addSorting(var1, allBaseBeforeRenderPlayerSleepSuperiors, var2.getBeforeRenderPlayerSleepSuperiors());
               addSorting(var1, allBaseBeforeRenderPlayerSleepInferiors, var2.getBeforeRenderPlayerSleepInferiors());
               addSorting(var1, allBaseOverrideRenderPlayerSleepSuperiors, var2.getOverrideRenderPlayerSleepSuperiors());
               addSorting(var1, allBaseOverrideRenderPlayerSleepInferiors, var2.getOverrideRenderPlayerSleepInferiors());
               addSorting(var1, allBaseAfterRenderPlayerSleepSuperiors, var2.getAfterRenderPlayerSleepSuperiors());
               addSorting(var1, allBaseAfterRenderPlayerSleepInferiors, var2.getAfterRenderPlayerSleepInferiors());
               addSorting(var1, allBaseBeforeRenderSpecialsSuperiors, var2.getBeforeRenderSpecialsSuperiors());
               addSorting(var1, allBaseBeforeRenderSpecialsInferiors, var2.getBeforeRenderSpecialsInferiors());
               addSorting(var1, allBaseOverrideRenderSpecialsSuperiors, var2.getOverrideRenderSpecialsSuperiors());
               addSorting(var1, allBaseOverrideRenderSpecialsInferiors, var2.getOverrideRenderSpecialsInferiors());
               addSorting(var1, allBaseAfterRenderSpecialsSuperiors, var2.getAfterRenderSpecialsSuperiors());
               addSorting(var1, allBaseAfterRenderSpecialsInferiors, var2.getAfterRenderSpecialsInferiors());
               addSorting(var1, allBaseBeforeRenderSwingProgressSuperiors, var2.getBeforeRenderSwingProgressSuperiors());
               addSorting(var1, allBaseBeforeRenderSwingProgressInferiors, var2.getBeforeRenderSwingProgressInferiors());
               addSorting(var1, allBaseOverrideRenderSwingProgressSuperiors, var2.getOverrideRenderSwingProgressSuperiors());
               addSorting(var1, allBaseOverrideRenderSwingProgressInferiors, var2.getOverrideRenderSwingProgressInferiors());
               addSorting(var1, allBaseAfterRenderSwingProgressSuperiors, var2.getAfterRenderSwingProgressSuperiors());
               addSorting(var1, allBaseAfterRenderSwingProgressInferiors, var2.getAfterRenderSwingProgressInferiors());
               addSorting(var1, allBaseBeforeRotatePlayerSuperiors, var2.getBeforeRotatePlayerSuperiors());
               addSorting(var1, allBaseBeforeRotatePlayerInferiors, var2.getBeforeRotatePlayerInferiors());
               addSorting(var1, allBaseOverrideRotatePlayerSuperiors, var2.getOverrideRotatePlayerSuperiors());
               addSorting(var1, allBaseOverrideRotatePlayerInferiors, var2.getOverrideRotatePlayerInferiors());
               addSorting(var1, allBaseAfterRotatePlayerSuperiors, var2.getAfterRotatePlayerSuperiors());
               addSorting(var1, allBaseAfterRotatePlayerInferiors, var2.getAfterRotatePlayerInferiors());
               addSorting(var1, allBaseBeforeSetArmorModelSuperiors, var2.getBeforeSetArmorModelSuperiors());
               addSorting(var1, allBaseBeforeSetArmorModelInferiors, var2.getBeforeSetArmorModelInferiors());
               addSorting(var1, allBaseOverrideSetArmorModelSuperiors, var2.getOverrideSetArmorModelSuperiors());
               addSorting(var1, allBaseOverrideSetArmorModelInferiors, var2.getOverrideSetArmorModelInferiors());
               addSorting(var1, allBaseAfterSetArmorModelSuperiors, var2.getAfterSetArmorModelSuperiors());
               addSorting(var1, allBaseAfterSetArmorModelInferiors, var2.getAfterSetArmorModelInferiors());
               addSorting(var1, allBaseBeforeSetPassArmorModelSuperiors, var2.getBeforeSetPassArmorModelSuperiors());
               addSorting(var1, allBaseBeforeSetPassArmorModelInferiors, var2.getBeforeSetPassArmorModelInferiors());
               addSorting(var1, allBaseOverrideSetPassArmorModelSuperiors, var2.getOverrideSetPassArmorModelSuperiors());
               addSorting(var1, allBaseOverrideSetPassArmorModelInferiors, var2.getOverrideSetPassArmorModelInferiors());
               addSorting(var1, allBaseAfterSetPassArmorModelSuperiors, var2.getAfterSetPassArmorModelSuperiors());
               addSorting(var1, allBaseAfterSetPassArmorModelInferiors, var2.getAfterSetPassArmorModelInferiors());
               addSorting(var1, allBaseBeforeSetRenderManagerSuperiors, var2.getBeforeSetRenderManagerSuperiors());
               addSorting(var1, allBaseBeforeSetRenderManagerInferiors, var2.getBeforeSetRenderManagerInferiors());
               addSorting(var1, allBaseOverrideSetRenderManagerSuperiors, var2.getOverrideSetRenderManagerSuperiors());
               addSorting(var1, allBaseOverrideSetRenderManagerInferiors, var2.getOverrideSetRenderManagerInferiors());
               addSorting(var1, allBaseAfterSetRenderManagerSuperiors, var2.getAfterSetRenderManagerSuperiors());
               addSorting(var1, allBaseAfterSetRenderManagerInferiors, var2.getAfterSetRenderManagerInferiors());
               addSorting(var1, allBaseBeforeSetRenderPassModelSuperiors, var2.getBeforeSetRenderPassModelSuperiors());
               addSorting(var1, allBaseBeforeSetRenderPassModelInferiors, var2.getBeforeSetRenderPassModelInferiors());
               addSorting(var1, allBaseOverrideSetRenderPassModelSuperiors, var2.getOverrideSetRenderPassModelSuperiors());
               addSorting(var1, allBaseOverrideSetRenderPassModelInferiors, var2.getOverrideSetRenderPassModelInferiors());
               addSorting(var1, allBaseAfterSetRenderPassModelSuperiors, var2.getAfterSetRenderPassModelSuperiors());
               addSorting(var1, allBaseAfterSetRenderPassModelInferiors, var2.getAfterSetRenderPassModelInferiors());
               addSorting(var1, allBaseBeforeUpdateIconsSuperiors, var2.getBeforeUpdateIconsSuperiors());
               addSorting(var1, allBaseBeforeUpdateIconsInferiors, var2.getBeforeUpdateIconsInferiors());
               addSorting(var1, allBaseOverrideUpdateIconsSuperiors, var2.getOverrideUpdateIconsSuperiors());
               addSorting(var1, allBaseOverrideUpdateIconsInferiors, var2.getOverrideUpdateIconsInferiors());
               addSorting(var1, allBaseAfterUpdateIconsSuperiors, var2.getAfterUpdateIconsSuperiors());
               addSorting(var1, allBaseAfterUpdateIconsInferiors, var2.getAfterUpdateIconsInferiors());
            }

            addMethod(var1, var0, beforeLocalConstructingHookTypes, "beforeLocalConstructing", new Class[0]);
            addMethod(var1, var0, afterLocalConstructingHookTypes, "afterLocalConstructing", new Class[0]);
            addMethod(var1, var0, beforeDoRenderLabelHookTypes, "beforeDoRenderLabel", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, overrideDoRenderLabelHookTypes, "doRenderLabel", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, afterDoRenderLabelHookTypes, "afterDoRenderLabel", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, beforeDoRenderShadowAndFireHookTypes, "beforeDoRenderShadowAndFire", new Class[]{Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideDoRenderShadowAndFireHookTypes, "doRenderShadowAndFire", new Class[]{Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterDoRenderShadowAndFireHookTypes, "afterDoRenderShadowAndFire", new Class[]{Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeGetColorMultiplierHookTypes, "beforeGetColorMultiplier", new Class[]{EntityLivingBase.class, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideGetColorMultiplierHookTypes, "getColorMultiplier", new Class[]{EntityLivingBase.class, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterGetColorMultiplierHookTypes, "afterGetColorMultiplier", new Class[]{EntityLivingBase.class, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeGetDeathMaxRotationHookTypes, "beforeGetDeathMaxRotation", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, overrideGetDeathMaxRotationHookTypes, "getDeathMaxRotation", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, afterGetDeathMaxRotationHookTypes, "afterGetDeathMaxRotation", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, beforeGetFontRendererFromRenderManagerHookTypes, "beforeGetFontRendererFromRenderManager", new Class[0]);
            addMethod(var1, var0, overrideGetFontRendererFromRenderManagerHookTypes, "getFontRendererFromRenderManager", new Class[0]);
            addMethod(var1, var0, afterGetFontRendererFromRenderManagerHookTypes, "afterGetFontRendererFromRenderManager", new Class[0]);
            addMethod(var1, var0, beforeGetResourceLocationFromPlayerHookTypes, "beforeGetResourceLocationFromPlayer", new Class[]{AbstractClientPlayer.class});
            addMethod(var1, var0, overrideGetResourceLocationFromPlayerHookTypes, "getResourceLocationFromPlayer", new Class[]{AbstractClientPlayer.class});
            addMethod(var1, var0, afterGetResourceLocationFromPlayerHookTypes, "afterGetResourceLocationFromPlayer", new Class[]{AbstractClientPlayer.class});
            addMethod(var1, var0, beforeHandleRotationFloatHookTypes, "beforeHandleRotationFloat", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, overrideHandleRotationFloatHookTypes, "handleRotationFloat", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, afterHandleRotationFloatHookTypes, "afterHandleRotationFloat", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, beforeInheritRenderPassHookTypes, "beforeInheritRenderPass", new Class[]{EntityLivingBase.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideInheritRenderPassHookTypes, "inheritRenderPass", new Class[]{EntityLivingBase.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, afterInheritRenderPassHookTypes, "afterInheritRenderPass", new Class[]{EntityLivingBase.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeLoadTextureHookTypes, "beforeLoadTexture", new Class[]{ResourceLocation.class});
            addMethod(var1, var0, overrideLoadTextureHookTypes, "loadTexture", new Class[]{ResourceLocation.class});
            addMethod(var1, var0, afterLoadTextureHookTypes, "afterLoadTexture", new Class[]{ResourceLocation.class});
            addMethod(var1, var0, beforeLoadTextureOfEntityHookTypes, "beforeLoadTextureOfEntity", new Class[]{Entity.class});
            addMethod(var1, var0, overrideLoadTextureOfEntityHookTypes, "loadTextureOfEntity", new Class[]{Entity.class});
            addMethod(var1, var0, afterLoadTextureOfEntityHookTypes, "afterLoadTextureOfEntity", new Class[]{Entity.class});
            addMethod(var1, var0, beforePassSpecialRenderHookTypes, "beforePassSpecialRender", new Class[]{EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overridePassSpecialRenderHookTypes, "passSpecialRender", new Class[]{EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterPassSpecialRenderHookTypes, "afterPassSpecialRender", new Class[]{EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforePerformStaticEntityRebuildHookTypes, "beforePerformStaticEntityRebuild", new Class[0]);
            addMethod(var1, var0, overridePerformStaticEntityRebuildHookTypes, "performStaticEntityRebuild", new Class[0]);
            addMethod(var1, var0, afterPerformStaticEntityRebuildHookTypes, "afterPerformStaticEntityRebuild", new Class[0]);
            addMethod(var1, var0, beforeRenderArrowsStuckInEntityHookTypes, "beforeRenderArrowsStuckInEntity", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, overrideRenderArrowsStuckInEntityHookTypes, "renderArrowsStuckInEntity", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, afterRenderArrowsStuckInEntityHookTypes, "afterRenderArrowsStuckInEntity", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, beforeRenderFirstPersonArmHookTypes, "beforeRenderFirstPersonArm", new Class[]{EntityPlayer.class});
            addMethod(var1, var0, overrideRenderFirstPersonArmHookTypes, "renderFirstPersonArm", new Class[]{EntityPlayer.class});
            addMethod(var1, var0, afterRenderFirstPersonArmHookTypes, "afterRenderFirstPersonArm", new Class[]{EntityPlayer.class});
            addMethod(var1, var0, beforeRenderLivingLabelHookTypes, "beforeRenderLivingLabel", new Class[]{Entity.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE});
            addMethod(var1, var0, overrideRenderLivingLabelHookTypes, "renderLivingLabel", new Class[]{Entity.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE});
            addMethod(var1, var0, afterRenderLivingLabelHookTypes, "afterRenderLivingLabel", new Class[]{Entity.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE});
            addMethod(var1, var0, beforeRenderModelHookTypes, "beforeRenderModel", new Class[]{EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideRenderModelHookTypes, "renderModel", new Class[]{EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterRenderModelHookTypes, "afterRenderModel", new Class[]{EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeRenderPlayerHookTypes, "beforeRenderPlayer", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideRenderPlayerHookTypes, "renderPlayer", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterRenderPlayerHookTypes, "afterRenderPlayer", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeRenderPlayerNameAndScoreLabelHookTypes, "beforeRenderPlayerNameAndScoreLabel", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideRenderPlayerNameAndScoreLabelHookTypes, "renderPlayerNameAndScoreLabel", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE});
            addMethod(var1, var0, afterRenderPlayerNameAndScoreLabelHookTypes, "afterRenderPlayerNameAndScoreLabel", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeRenderPlayerScaleHookTypes, "beforeRenderPlayerScale", new Class[]{AbstractClientPlayer.class, Float.TYPE});
            addMethod(var1, var0, overrideRenderPlayerScaleHookTypes, "renderPlayerScale", new Class[]{AbstractClientPlayer.class, Float.TYPE});
            addMethod(var1, var0, afterRenderPlayerScaleHookTypes, "afterRenderPlayerScale", new Class[]{AbstractClientPlayer.class, Float.TYPE});
            addMethod(var1, var0, beforeRenderPlayerSleepHookTypes, "beforeRenderPlayerSleep", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideRenderPlayerSleepHookTypes, "renderPlayerSleep", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterRenderPlayerSleepHookTypes, "afterRenderPlayerSleep", new Class[]{AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeRenderSpecialsHookTypes, "beforeRenderSpecials", new Class[]{AbstractClientPlayer.class, Float.TYPE});
            addMethod(var1, var0, overrideRenderSpecialsHookTypes, "renderSpecials", new Class[]{AbstractClientPlayer.class, Float.TYPE});
            addMethod(var1, var0, afterRenderSpecialsHookTypes, "afterRenderSpecials", new Class[]{AbstractClientPlayer.class, Float.TYPE});
            addMethod(var1, var0, beforeRenderSwingProgressHookTypes, "beforeRenderSwingProgress", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, overrideRenderSwingProgressHookTypes, "renderSwingProgress", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, afterRenderSwingProgressHookTypes, "afterRenderSwingProgress", new Class[]{EntityLivingBase.class, Float.TYPE});
            addMethod(var1, var0, beforeRotatePlayerHookTypes, "beforeRotatePlayer", new Class[]{AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideRotatePlayerHookTypes, "rotatePlayer", new Class[]{AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterRotatePlayerHookTypes, "afterRotatePlayer", new Class[]{AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeSetArmorModelHookTypes, "beforeSetArmorModel", new Class[]{AbstractClientPlayer.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideSetArmorModelHookTypes, "setArmorModel", new Class[]{AbstractClientPlayer.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, afterSetArmorModelHookTypes, "afterSetArmorModel", new Class[]{AbstractClientPlayer.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeSetPassArmorModelHookTypes, "beforeSetPassArmorModel", new Class[]{AbstractClientPlayer.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideSetPassArmorModelHookTypes, "setPassArmorModel", new Class[]{AbstractClientPlayer.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, afterSetPassArmorModelHookTypes, "afterSetPassArmorModel", new Class[]{AbstractClientPlayer.class, Integer.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeSetRenderManagerHookTypes, "beforeSetRenderManager", new Class[]{RenderManager.class});
            addMethod(var1, var0, overrideSetRenderManagerHookTypes, "setRenderManager", new Class[]{RenderManager.class});
            addMethod(var1, var0, afterSetRenderManagerHookTypes, "afterSetRenderManager", new Class[]{RenderManager.class});
            addMethod(var1, var0, beforeSetRenderPassModelHookTypes, "beforeSetRenderPassModel", new Class[]{ModelBase.class});
            addMethod(var1, var0, overrideSetRenderPassModelHookTypes, "setRenderPassModel", new Class[]{ModelBase.class});
            addMethod(var1, var0, afterSetRenderPassModelHookTypes, "afterSetRenderPassModel", new Class[]{ModelBase.class});
            addMethod(var1, var0, beforeUpdateIconsHookTypes, "beforeUpdateIcons", new Class[]{IIconRegister.class});
            addMethod(var1, var0, overrideUpdateIconsHookTypes, "updateIcons", new Class[]{IIconRegister.class});
            addMethod(var1, var0, afterUpdateIconsHookTypes, "afterUpdateIcons", new Class[]{IIconRegister.class});
            addDynamicMethods(var1, var0);
            addDynamicKeys(var1, var0, beforeDynamicHookMethods, beforeDynamicHookTypes);
            addDynamicKeys(var1, var0, overrideDynamicHookMethods, overrideDynamicHookTypes);
            addDynamicKeys(var1, var0, afterDynamicHookMethods, afterDynamicHookTypes);
            initialize();
            Iterator var19 = getAllInstancesList().iterator();

            while(var19.hasNext()) {
               IRenderPlayerAPI var20 = (IRenderPlayerAPI)var19.next();
               var20.getRenderPlayerAPI().attachRenderPlayerBase(var1);
            }

            System.out.println("Render Player: registered " + var1);
            logger.fine("Render Player: registered class \'" + var0.getName() + "\' with id \'" + var1 + "\'");
            initialized = false;
         }
      }
   }

   public static boolean unregister(String var0) {
      if(var0 == null) {
         return false;
      } else {
         Constructor var1 = (Constructor)allBaseConstructors.remove(var0);
         if(var1 == null) {
            return false;
         } else {
            Iterator var2 = getAllInstancesList().iterator();

            IRenderPlayerAPI var3;
            while(var2.hasNext()) {
               var3 = (IRenderPlayerAPI)var2.next();
               var3.getRenderPlayerAPI().detachRenderPlayerBase(var0);
            }

            beforeLocalConstructingHookTypes.remove(var0);
            afterLocalConstructingHookTypes.remove(var0);
            allBaseBeforeDoRenderLabelSuperiors.remove(var0);
            allBaseBeforeDoRenderLabelInferiors.remove(var0);
            allBaseOverrideDoRenderLabelSuperiors.remove(var0);
            allBaseOverrideDoRenderLabelInferiors.remove(var0);
            allBaseAfterDoRenderLabelSuperiors.remove(var0);
            allBaseAfterDoRenderLabelInferiors.remove(var0);
            beforeDoRenderLabelHookTypes.remove(var0);
            overrideDoRenderLabelHookTypes.remove(var0);
            afterDoRenderLabelHookTypes.remove(var0);
            allBaseBeforeDoRenderShadowAndFireSuperiors.remove(var0);
            allBaseBeforeDoRenderShadowAndFireInferiors.remove(var0);
            allBaseOverrideDoRenderShadowAndFireSuperiors.remove(var0);
            allBaseOverrideDoRenderShadowAndFireInferiors.remove(var0);
            allBaseAfterDoRenderShadowAndFireSuperiors.remove(var0);
            allBaseAfterDoRenderShadowAndFireInferiors.remove(var0);
            beforeDoRenderShadowAndFireHookTypes.remove(var0);
            overrideDoRenderShadowAndFireHookTypes.remove(var0);
            afterDoRenderShadowAndFireHookTypes.remove(var0);
            allBaseBeforeGetColorMultiplierSuperiors.remove(var0);
            allBaseBeforeGetColorMultiplierInferiors.remove(var0);
            allBaseOverrideGetColorMultiplierSuperiors.remove(var0);
            allBaseOverrideGetColorMultiplierInferiors.remove(var0);
            allBaseAfterGetColorMultiplierSuperiors.remove(var0);
            allBaseAfterGetColorMultiplierInferiors.remove(var0);
            beforeGetColorMultiplierHookTypes.remove(var0);
            overrideGetColorMultiplierHookTypes.remove(var0);
            afterGetColorMultiplierHookTypes.remove(var0);
            allBaseBeforeGetDeathMaxRotationSuperiors.remove(var0);
            allBaseBeforeGetDeathMaxRotationInferiors.remove(var0);
            allBaseOverrideGetDeathMaxRotationSuperiors.remove(var0);
            allBaseOverrideGetDeathMaxRotationInferiors.remove(var0);
            allBaseAfterGetDeathMaxRotationSuperiors.remove(var0);
            allBaseAfterGetDeathMaxRotationInferiors.remove(var0);
            beforeGetDeathMaxRotationHookTypes.remove(var0);
            overrideGetDeathMaxRotationHookTypes.remove(var0);
            afterGetDeathMaxRotationHookTypes.remove(var0);
            allBaseBeforeGetFontRendererFromRenderManagerSuperiors.remove(var0);
            allBaseBeforeGetFontRendererFromRenderManagerInferiors.remove(var0);
            allBaseOverrideGetFontRendererFromRenderManagerSuperiors.remove(var0);
            allBaseOverrideGetFontRendererFromRenderManagerInferiors.remove(var0);
            allBaseAfterGetFontRendererFromRenderManagerSuperiors.remove(var0);
            allBaseAfterGetFontRendererFromRenderManagerInferiors.remove(var0);
            beforeGetFontRendererFromRenderManagerHookTypes.remove(var0);
            overrideGetFontRendererFromRenderManagerHookTypes.remove(var0);
            afterGetFontRendererFromRenderManagerHookTypes.remove(var0);
            allBaseBeforeGetResourceLocationFromPlayerSuperiors.remove(var0);
            allBaseBeforeGetResourceLocationFromPlayerInferiors.remove(var0);
            allBaseOverrideGetResourceLocationFromPlayerSuperiors.remove(var0);
            allBaseOverrideGetResourceLocationFromPlayerInferiors.remove(var0);
            allBaseAfterGetResourceLocationFromPlayerSuperiors.remove(var0);
            allBaseAfterGetResourceLocationFromPlayerInferiors.remove(var0);
            beforeGetResourceLocationFromPlayerHookTypes.remove(var0);
            overrideGetResourceLocationFromPlayerHookTypes.remove(var0);
            afterGetResourceLocationFromPlayerHookTypes.remove(var0);
            allBaseBeforeHandleRotationFloatSuperiors.remove(var0);
            allBaseBeforeHandleRotationFloatInferiors.remove(var0);
            allBaseOverrideHandleRotationFloatSuperiors.remove(var0);
            allBaseOverrideHandleRotationFloatInferiors.remove(var0);
            allBaseAfterHandleRotationFloatSuperiors.remove(var0);
            allBaseAfterHandleRotationFloatInferiors.remove(var0);
            beforeHandleRotationFloatHookTypes.remove(var0);
            overrideHandleRotationFloatHookTypes.remove(var0);
            afterHandleRotationFloatHookTypes.remove(var0);
            allBaseBeforeInheritRenderPassSuperiors.remove(var0);
            allBaseBeforeInheritRenderPassInferiors.remove(var0);
            allBaseOverrideInheritRenderPassSuperiors.remove(var0);
            allBaseOverrideInheritRenderPassInferiors.remove(var0);
            allBaseAfterInheritRenderPassSuperiors.remove(var0);
            allBaseAfterInheritRenderPassInferiors.remove(var0);
            beforeInheritRenderPassHookTypes.remove(var0);
            overrideInheritRenderPassHookTypes.remove(var0);
            afterInheritRenderPassHookTypes.remove(var0);
            allBaseBeforeLoadTextureSuperiors.remove(var0);
            allBaseBeforeLoadTextureInferiors.remove(var0);
            allBaseOverrideLoadTextureSuperiors.remove(var0);
            allBaseOverrideLoadTextureInferiors.remove(var0);
            allBaseAfterLoadTextureSuperiors.remove(var0);
            allBaseAfterLoadTextureInferiors.remove(var0);
            beforeLoadTextureHookTypes.remove(var0);
            overrideLoadTextureHookTypes.remove(var0);
            afterLoadTextureHookTypes.remove(var0);
            allBaseBeforeLoadTextureOfEntitySuperiors.remove(var0);
            allBaseBeforeLoadTextureOfEntityInferiors.remove(var0);
            allBaseOverrideLoadTextureOfEntitySuperiors.remove(var0);
            allBaseOverrideLoadTextureOfEntityInferiors.remove(var0);
            allBaseAfterLoadTextureOfEntitySuperiors.remove(var0);
            allBaseAfterLoadTextureOfEntityInferiors.remove(var0);
            beforeLoadTextureOfEntityHookTypes.remove(var0);
            overrideLoadTextureOfEntityHookTypes.remove(var0);
            afterLoadTextureOfEntityHookTypes.remove(var0);
            allBaseBeforePassSpecialRenderSuperiors.remove(var0);
            allBaseBeforePassSpecialRenderInferiors.remove(var0);
            allBaseOverridePassSpecialRenderSuperiors.remove(var0);
            allBaseOverridePassSpecialRenderInferiors.remove(var0);
            allBaseAfterPassSpecialRenderSuperiors.remove(var0);
            allBaseAfterPassSpecialRenderInferiors.remove(var0);
            beforePassSpecialRenderHookTypes.remove(var0);
            overridePassSpecialRenderHookTypes.remove(var0);
            afterPassSpecialRenderHookTypes.remove(var0);
            allBaseBeforePerformStaticEntityRebuildSuperiors.remove(var0);
            allBaseBeforePerformStaticEntityRebuildInferiors.remove(var0);
            allBaseOverridePerformStaticEntityRebuildSuperiors.remove(var0);
            allBaseOverridePerformStaticEntityRebuildInferiors.remove(var0);
            allBaseAfterPerformStaticEntityRebuildSuperiors.remove(var0);
            allBaseAfterPerformStaticEntityRebuildInferiors.remove(var0);
            beforePerformStaticEntityRebuildHookTypes.remove(var0);
            overridePerformStaticEntityRebuildHookTypes.remove(var0);
            afterPerformStaticEntityRebuildHookTypes.remove(var0);
            allBaseBeforeRenderArrowsStuckInEntitySuperiors.remove(var0);
            allBaseBeforeRenderArrowsStuckInEntityInferiors.remove(var0);
            allBaseOverrideRenderArrowsStuckInEntitySuperiors.remove(var0);
            allBaseOverrideRenderArrowsStuckInEntityInferiors.remove(var0);
            allBaseAfterRenderArrowsStuckInEntitySuperiors.remove(var0);
            allBaseAfterRenderArrowsStuckInEntityInferiors.remove(var0);
            beforeRenderArrowsStuckInEntityHookTypes.remove(var0);
            overrideRenderArrowsStuckInEntityHookTypes.remove(var0);
            afterRenderArrowsStuckInEntityHookTypes.remove(var0);
            allBaseBeforeRenderFirstPersonArmSuperiors.remove(var0);
            allBaseBeforeRenderFirstPersonArmInferiors.remove(var0);
            allBaseOverrideRenderFirstPersonArmSuperiors.remove(var0);
            allBaseOverrideRenderFirstPersonArmInferiors.remove(var0);
            allBaseAfterRenderFirstPersonArmSuperiors.remove(var0);
            allBaseAfterRenderFirstPersonArmInferiors.remove(var0);
            beforeRenderFirstPersonArmHookTypes.remove(var0);
            overrideRenderFirstPersonArmHookTypes.remove(var0);
            afterRenderFirstPersonArmHookTypes.remove(var0);
            allBaseBeforeRenderLivingLabelSuperiors.remove(var0);
            allBaseBeforeRenderLivingLabelInferiors.remove(var0);
            allBaseOverrideRenderLivingLabelSuperiors.remove(var0);
            allBaseOverrideRenderLivingLabelInferiors.remove(var0);
            allBaseAfterRenderLivingLabelSuperiors.remove(var0);
            allBaseAfterRenderLivingLabelInferiors.remove(var0);
            beforeRenderLivingLabelHookTypes.remove(var0);
            overrideRenderLivingLabelHookTypes.remove(var0);
            afterRenderLivingLabelHookTypes.remove(var0);
            allBaseBeforeRenderModelSuperiors.remove(var0);
            allBaseBeforeRenderModelInferiors.remove(var0);
            allBaseOverrideRenderModelSuperiors.remove(var0);
            allBaseOverrideRenderModelInferiors.remove(var0);
            allBaseAfterRenderModelSuperiors.remove(var0);
            allBaseAfterRenderModelInferiors.remove(var0);
            beforeRenderModelHookTypes.remove(var0);
            overrideRenderModelHookTypes.remove(var0);
            afterRenderModelHookTypes.remove(var0);
            allBaseBeforeRenderPlayerSuperiors.remove(var0);
            allBaseBeforeRenderPlayerInferiors.remove(var0);
            allBaseOverrideRenderPlayerSuperiors.remove(var0);
            allBaseOverrideRenderPlayerInferiors.remove(var0);
            allBaseAfterRenderPlayerSuperiors.remove(var0);
            allBaseAfterRenderPlayerInferiors.remove(var0);
            beforeRenderPlayerHookTypes.remove(var0);
            overrideRenderPlayerHookTypes.remove(var0);
            afterRenderPlayerHookTypes.remove(var0);
            allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors.remove(var0);
            allBaseBeforeRenderPlayerNameAndScoreLabelInferiors.remove(var0);
            allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors.remove(var0);
            allBaseOverrideRenderPlayerNameAndScoreLabelInferiors.remove(var0);
            allBaseAfterRenderPlayerNameAndScoreLabelSuperiors.remove(var0);
            allBaseAfterRenderPlayerNameAndScoreLabelInferiors.remove(var0);
            beforeRenderPlayerNameAndScoreLabelHookTypes.remove(var0);
            overrideRenderPlayerNameAndScoreLabelHookTypes.remove(var0);
            afterRenderPlayerNameAndScoreLabelHookTypes.remove(var0);
            allBaseBeforeRenderPlayerScaleSuperiors.remove(var0);
            allBaseBeforeRenderPlayerScaleInferiors.remove(var0);
            allBaseOverrideRenderPlayerScaleSuperiors.remove(var0);
            allBaseOverrideRenderPlayerScaleInferiors.remove(var0);
            allBaseAfterRenderPlayerScaleSuperiors.remove(var0);
            allBaseAfterRenderPlayerScaleInferiors.remove(var0);
            beforeRenderPlayerScaleHookTypes.remove(var0);
            overrideRenderPlayerScaleHookTypes.remove(var0);
            afterRenderPlayerScaleHookTypes.remove(var0);
            allBaseBeforeRenderPlayerSleepSuperiors.remove(var0);
            allBaseBeforeRenderPlayerSleepInferiors.remove(var0);
            allBaseOverrideRenderPlayerSleepSuperiors.remove(var0);
            allBaseOverrideRenderPlayerSleepInferiors.remove(var0);
            allBaseAfterRenderPlayerSleepSuperiors.remove(var0);
            allBaseAfterRenderPlayerSleepInferiors.remove(var0);
            beforeRenderPlayerSleepHookTypes.remove(var0);
            overrideRenderPlayerSleepHookTypes.remove(var0);
            afterRenderPlayerSleepHookTypes.remove(var0);
            allBaseBeforeRenderSpecialsSuperiors.remove(var0);
            allBaseBeforeRenderSpecialsInferiors.remove(var0);
            allBaseOverrideRenderSpecialsSuperiors.remove(var0);
            allBaseOverrideRenderSpecialsInferiors.remove(var0);
            allBaseAfterRenderSpecialsSuperiors.remove(var0);
            allBaseAfterRenderSpecialsInferiors.remove(var0);
            beforeRenderSpecialsHookTypes.remove(var0);
            overrideRenderSpecialsHookTypes.remove(var0);
            afterRenderSpecialsHookTypes.remove(var0);
            allBaseBeforeRenderSwingProgressSuperiors.remove(var0);
            allBaseBeforeRenderSwingProgressInferiors.remove(var0);
            allBaseOverrideRenderSwingProgressSuperiors.remove(var0);
            allBaseOverrideRenderSwingProgressInferiors.remove(var0);
            allBaseAfterRenderSwingProgressSuperiors.remove(var0);
            allBaseAfterRenderSwingProgressInferiors.remove(var0);
            beforeRenderSwingProgressHookTypes.remove(var0);
            overrideRenderSwingProgressHookTypes.remove(var0);
            afterRenderSwingProgressHookTypes.remove(var0);
            allBaseBeforeRotatePlayerSuperiors.remove(var0);
            allBaseBeforeRotatePlayerInferiors.remove(var0);
            allBaseOverrideRotatePlayerSuperiors.remove(var0);
            allBaseOverrideRotatePlayerInferiors.remove(var0);
            allBaseAfterRotatePlayerSuperiors.remove(var0);
            allBaseAfterRotatePlayerInferiors.remove(var0);
            beforeRotatePlayerHookTypes.remove(var0);
            overrideRotatePlayerHookTypes.remove(var0);
            afterRotatePlayerHookTypes.remove(var0);
            allBaseBeforeSetArmorModelSuperiors.remove(var0);
            allBaseBeforeSetArmorModelInferiors.remove(var0);
            allBaseOverrideSetArmorModelSuperiors.remove(var0);
            allBaseOverrideSetArmorModelInferiors.remove(var0);
            allBaseAfterSetArmorModelSuperiors.remove(var0);
            allBaseAfterSetArmorModelInferiors.remove(var0);
            beforeSetArmorModelHookTypes.remove(var0);
            overrideSetArmorModelHookTypes.remove(var0);
            afterSetArmorModelHookTypes.remove(var0);
            allBaseBeforeSetPassArmorModelSuperiors.remove(var0);
            allBaseBeforeSetPassArmorModelInferiors.remove(var0);
            allBaseOverrideSetPassArmorModelSuperiors.remove(var0);
            allBaseOverrideSetPassArmorModelInferiors.remove(var0);
            allBaseAfterSetPassArmorModelSuperiors.remove(var0);
            allBaseAfterSetPassArmorModelInferiors.remove(var0);
            beforeSetPassArmorModelHookTypes.remove(var0);
            overrideSetPassArmorModelHookTypes.remove(var0);
            afterSetPassArmorModelHookTypes.remove(var0);
            allBaseBeforeSetRenderManagerSuperiors.remove(var0);
            allBaseBeforeSetRenderManagerInferiors.remove(var0);
            allBaseOverrideSetRenderManagerSuperiors.remove(var0);
            allBaseOverrideSetRenderManagerInferiors.remove(var0);
            allBaseAfterSetRenderManagerSuperiors.remove(var0);
            allBaseAfterSetRenderManagerInferiors.remove(var0);
            beforeSetRenderManagerHookTypes.remove(var0);
            overrideSetRenderManagerHookTypes.remove(var0);
            afterSetRenderManagerHookTypes.remove(var0);
            allBaseBeforeSetRenderPassModelSuperiors.remove(var0);
            allBaseBeforeSetRenderPassModelInferiors.remove(var0);
            allBaseOverrideSetRenderPassModelSuperiors.remove(var0);
            allBaseOverrideSetRenderPassModelInferiors.remove(var0);
            allBaseAfterSetRenderPassModelSuperiors.remove(var0);
            allBaseAfterSetRenderPassModelInferiors.remove(var0);
            beforeSetRenderPassModelHookTypes.remove(var0);
            overrideSetRenderPassModelHookTypes.remove(var0);
            afterSetRenderPassModelHookTypes.remove(var0);
            allBaseBeforeUpdateIconsSuperiors.remove(var0);
            allBaseBeforeUpdateIconsInferiors.remove(var0);
            allBaseOverrideUpdateIconsSuperiors.remove(var0);
            allBaseOverrideUpdateIconsInferiors.remove(var0);
            allBaseAfterUpdateIconsSuperiors.remove(var0);
            allBaseAfterUpdateIconsInferiors.remove(var0);
            beforeUpdateIconsHookTypes.remove(var0);
            overrideUpdateIconsHookTypes.remove(var0);
            afterUpdateIconsHookTypes.remove(var0);
            var2 = getAllInstancesList().iterator();

            while(var2.hasNext()) {
               var3 = (IRenderPlayerAPI)var2.next();
               var3.getRenderPlayerAPI().updateRenderPlayerBases();
            }

            var2 = keysToVirtualIds.keySet().iterator();

            while(var2.hasNext()) {
               String var7 = (String)var2.next();
               if(((String)keysToVirtualIds.get(var7)).equals(var0)) {
                  keysToVirtualIds.remove(var7);
               }
            }

            boolean var8 = false;
            Class var4 = var1.getDeclaringClass();
            var2 = allBaseConstructors.keySet().iterator();

            while(var2.hasNext()) {
               String var5 = (String)var2.next();
               Class var6 = ((Constructor)allBaseConstructors.get(var5)).getDeclaringClass();
               if(!var5.equals(var0) && var6.equals(var4)) {
                  var8 = true;
                  break;
               }
            }

            if(!var8) {
               dynamicTypes.remove(var4);
               virtualDynamicHookMethods.remove(var4);
               beforeDynamicHookMethods.remove(var4);
               overrideDynamicHookMethods.remove(var4);
               afterDynamicHookMethods.remove(var4);
            }

            removeDynamicHookTypes(var0, beforeDynamicHookTypes);
            removeDynamicHookTypes(var0, overrideDynamicHookTypes);
            removeDynamicHookTypes(var0, afterDynamicHookTypes);
            allBaseBeforeDynamicSuperiors.remove(var0);
            allBaseBeforeDynamicInferiors.remove(var0);
            allBaseOverrideDynamicSuperiors.remove(var0);
            allBaseOverrideDynamicInferiors.remove(var0);
            allBaseAfterDynamicSuperiors.remove(var0);
            allBaseAfterDynamicInferiors.remove(var0);
            log("RenderPlayerAPI: unregistered id \'" + var0 + "\'");
            return true;
         }
      }
   }

   public static void removeDynamicHookTypes(String var0, Map var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         ((List)var1.get(var2.next())).remove(var0);
      }

   }

   public static Set getRegisteredIds() {
      return unmodifiableAllIds;
   }

   private static void addSorting(String var0, Map var1, String[] var2) {
      if(var2 != null && var2.length > 0) {
         var1.put(var0, var2);
      }

   }

   private static void addDynamicSorting(String var0, Map var1, Map var2) {
      if(var2 != null && var2.size() > 0) {
         var1.put(var0, var2);
      }

   }

   private static boolean addMethod(String var0, Class var1, List var2, String var3, Class ... var4) {
      try {
         Method var5 = var1.getMethod(var3, var4);
         boolean var6 = var5.getDeclaringClass() != RenderPlayerBase.class;
         if(var6) {
            var2.add(var0);
         }

         return var6;
      } catch (Exception var7) {
         throw new RuntimeException("Can not reflect method \'" + var3 + "\' of class \'" + var1.getName() + "\'", var7);
      }
   }

   private static void addDynamicMethods(String var0, Class var1) {
      if(dynamicTypes.add(var1)) {
         Map var2 = null;
         Map var3 = null;
         Map var4 = null;
         Map var5 = null;
         Method[] var6 = var1.getDeclaredMethods();

         for(int var7 = 0; var7 < var6.length; ++var7) {
            Method var8 = var6[var7];
            if(var8.getDeclaringClass() == var1) {
               int var9 = var8.getModifiers();
               if(!Modifier.isAbstract(var9) && !Modifier.isStatic(var9)) {
                  String var10 = var8.getName();
                  if(var10.length() >= 7 && var10.substring(0, 7).equalsIgnoreCase("dynamic")) {
                     for(var10 = var10.substring(7); var10.charAt(0) == 95; var10 = var10.substring(1)) {
                        ;
                     }

                     boolean var11 = false;
                     boolean var12 = false;
                     boolean var13 = false;
                     boolean var14 = false;
                     if(var10.substring(0, 7).equalsIgnoreCase("virtual")) {
                        var12 = true;
                        var10 = var10.substring(7);
                     } else if(var10.length() >= 8 && var10.substring(0, 8).equalsIgnoreCase("override")) {
                        var10 = var10.substring(8);
                        var13 = true;
                     } else if(var10.length() >= 6 && var10.substring(0, 6).equalsIgnoreCase("before")) {
                        var11 = true;
                        var10 = var10.substring(6);
                     } else if(var10.length() >= 5 && var10.substring(0, 5).equalsIgnoreCase("after")) {
                        var14 = true;
                        var10 = var10.substring(5);
                     }

                     if(var10.length() >= 1 && (var11 || var12 || var13 || var14)) {
                        var10 = var10.substring(0, 1).toLowerCase() + var10.substring(1);
                     }

                     while(var10.charAt(0) == 95) {
                        var10 = var10.substring(1);
                     }

                     if(var10.length() == 0) {
                        throw new RuntimeException("Can not process dynamic hook method with no key");
                     }

                     keys.add(var10);
                     if(var12) {
                        if(keysToVirtualIds.containsKey(var10)) {
                           throw new RuntimeException("Can not process more than one dynamic virtual method");
                        }

                        keysToVirtualIds.put(var10, var0);
                        var2 = addDynamicMethod(var10, var8, var2);
                     } else if(var11) {
                        var3 = addDynamicMethod(var10, var8, var3);
                     } else if(var14) {
                        var5 = addDynamicMethod(var10, var8, var5);
                     } else {
                        var4 = addDynamicMethod(var10, var8, var4);
                     }
                  }
               }
            }
         }

         if(var2 != null) {
            virtualDynamicHookMethods.put(var1, var2);
         }

         if(var3 != null) {
            beforeDynamicHookMethods.put(var1, var3);
         }

         if(var4 != null) {
            overrideDynamicHookMethods.put(var1, var4);
         }

         if(var5 != null) {
            afterDynamicHookMethods.put(var1, var5);
         }

      }
   }

   private static void addDynamicKeys(String var0, Class var1, Map var2, Map var3) {
      Map var4 = (Map)var2.get(var1);
      if(var4 != null && var4.size() != 0) {
         String var6;
         for(Iterator var5 = var4.keySet().iterator(); var5.hasNext(); ((List)var3.get(var6)).add(var0)) {
            var6 = (String)var5.next();
            if(!var3.containsKey(var6)) {
               var3.put(var6, new ArrayList(1));
            }
         }

      }
   }

   private static Map addDynamicMethod(String var0, Method var1, Map var2) {
      if(var2 == null) {
         var2 = new HashMap();
      }

      if(((Map)var2).containsKey(var0)) {
         throw new RuntimeException("method with key \'" + var0 + "\' allready exists");
      } else {
         ((Map)var2).put(var0, var1);
         return (Map)var2;
      }
   }

   public static RenderPlayerAPI create(IRenderPlayerAPI var0) {
      if(allBaseConstructors.size() > 0 && !initialized) {
         initialize();
      }

      return new RenderPlayerAPI(var0);
   }

   private static void initialize() {
      sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
      sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
      Iterator var0 = keys.iterator();

      while(var0.hasNext()) {
         String var1 = (String)var0.next();
         sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, var1);
         sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, var1);
         sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, var1);
      }

      sortBases(beforeDoRenderLabelHookTypes, allBaseBeforeDoRenderLabelSuperiors, allBaseBeforeDoRenderLabelInferiors, "beforeDoRenderLabel");
      sortBases(overrideDoRenderLabelHookTypes, allBaseOverrideDoRenderLabelSuperiors, allBaseOverrideDoRenderLabelInferiors, "overrideDoRenderLabel");
      sortBases(afterDoRenderLabelHookTypes, allBaseAfterDoRenderLabelSuperiors, allBaseAfterDoRenderLabelInferiors, "afterDoRenderLabel");
      sortBases(beforeDoRenderShadowAndFireHookTypes, allBaseBeforeDoRenderShadowAndFireSuperiors, allBaseBeforeDoRenderShadowAndFireInferiors, "beforeDoRenderShadowAndFire");
      sortBases(overrideDoRenderShadowAndFireHookTypes, allBaseOverrideDoRenderShadowAndFireSuperiors, allBaseOverrideDoRenderShadowAndFireInferiors, "overrideDoRenderShadowAndFire");
      sortBases(afterDoRenderShadowAndFireHookTypes, allBaseAfterDoRenderShadowAndFireSuperiors, allBaseAfterDoRenderShadowAndFireInferiors, "afterDoRenderShadowAndFire");
      sortBases(beforeGetColorMultiplierHookTypes, allBaseBeforeGetColorMultiplierSuperiors, allBaseBeforeGetColorMultiplierInferiors, "beforeGetColorMultiplier");
      sortBases(overrideGetColorMultiplierHookTypes, allBaseOverrideGetColorMultiplierSuperiors, allBaseOverrideGetColorMultiplierInferiors, "overrideGetColorMultiplier");
      sortBases(afterGetColorMultiplierHookTypes, allBaseAfterGetColorMultiplierSuperiors, allBaseAfterGetColorMultiplierInferiors, "afterGetColorMultiplier");
      sortBases(beforeGetDeathMaxRotationHookTypes, allBaseBeforeGetDeathMaxRotationSuperiors, allBaseBeforeGetDeathMaxRotationInferiors, "beforeGetDeathMaxRotation");
      sortBases(overrideGetDeathMaxRotationHookTypes, allBaseOverrideGetDeathMaxRotationSuperiors, allBaseOverrideGetDeathMaxRotationInferiors, "overrideGetDeathMaxRotation");
      sortBases(afterGetDeathMaxRotationHookTypes, allBaseAfterGetDeathMaxRotationSuperiors, allBaseAfterGetDeathMaxRotationInferiors, "afterGetDeathMaxRotation");
      sortBases(beforeGetFontRendererFromRenderManagerHookTypes, allBaseBeforeGetFontRendererFromRenderManagerSuperiors, allBaseBeforeGetFontRendererFromRenderManagerInferiors, "beforeGetFontRendererFromRenderManager");
      sortBases(overrideGetFontRendererFromRenderManagerHookTypes, allBaseOverrideGetFontRendererFromRenderManagerSuperiors, allBaseOverrideGetFontRendererFromRenderManagerInferiors, "overrideGetFontRendererFromRenderManager");
      sortBases(afterGetFontRendererFromRenderManagerHookTypes, allBaseAfterGetFontRendererFromRenderManagerSuperiors, allBaseAfterGetFontRendererFromRenderManagerInferiors, "afterGetFontRendererFromRenderManager");
      sortBases(beforeGetResourceLocationFromPlayerHookTypes, allBaseBeforeGetResourceLocationFromPlayerSuperiors, allBaseBeforeGetResourceLocationFromPlayerInferiors, "beforeGetResourceLocationFromPlayer");
      sortBases(overrideGetResourceLocationFromPlayerHookTypes, allBaseOverrideGetResourceLocationFromPlayerSuperiors, allBaseOverrideGetResourceLocationFromPlayerInferiors, "overrideGetResourceLocationFromPlayer");
      sortBases(afterGetResourceLocationFromPlayerHookTypes, allBaseAfterGetResourceLocationFromPlayerSuperiors, allBaseAfterGetResourceLocationFromPlayerInferiors, "afterGetResourceLocationFromPlayer");
      sortBases(beforeHandleRotationFloatHookTypes, allBaseBeforeHandleRotationFloatSuperiors, allBaseBeforeHandleRotationFloatInferiors, "beforeHandleRotationFloat");
      sortBases(overrideHandleRotationFloatHookTypes, allBaseOverrideHandleRotationFloatSuperiors, allBaseOverrideHandleRotationFloatInferiors, "overrideHandleRotationFloat");
      sortBases(afterHandleRotationFloatHookTypes, allBaseAfterHandleRotationFloatSuperiors, allBaseAfterHandleRotationFloatInferiors, "afterHandleRotationFloat");
      sortBases(beforeInheritRenderPassHookTypes, allBaseBeforeInheritRenderPassSuperiors, allBaseBeforeInheritRenderPassInferiors, "beforeInheritRenderPass");
      sortBases(overrideInheritRenderPassHookTypes, allBaseOverrideInheritRenderPassSuperiors, allBaseOverrideInheritRenderPassInferiors, "overrideInheritRenderPass");
      sortBases(afterInheritRenderPassHookTypes, allBaseAfterInheritRenderPassSuperiors, allBaseAfterInheritRenderPassInferiors, "afterInheritRenderPass");
      sortBases(beforeLoadTextureHookTypes, allBaseBeforeLoadTextureSuperiors, allBaseBeforeLoadTextureInferiors, "beforeLoadTexture");
      sortBases(overrideLoadTextureHookTypes, allBaseOverrideLoadTextureSuperiors, allBaseOverrideLoadTextureInferiors, "overrideLoadTexture");
      sortBases(afterLoadTextureHookTypes, allBaseAfterLoadTextureSuperiors, allBaseAfterLoadTextureInferiors, "afterLoadTexture");
      sortBases(beforeLoadTextureOfEntityHookTypes, allBaseBeforeLoadTextureOfEntitySuperiors, allBaseBeforeLoadTextureOfEntityInferiors, "beforeLoadTextureOfEntity");
      sortBases(overrideLoadTextureOfEntityHookTypes, allBaseOverrideLoadTextureOfEntitySuperiors, allBaseOverrideLoadTextureOfEntityInferiors, "overrideLoadTextureOfEntity");
      sortBases(afterLoadTextureOfEntityHookTypes, allBaseAfterLoadTextureOfEntitySuperiors, allBaseAfterLoadTextureOfEntityInferiors, "afterLoadTextureOfEntity");
      sortBases(beforePassSpecialRenderHookTypes, allBaseBeforePassSpecialRenderSuperiors, allBaseBeforePassSpecialRenderInferiors, "beforePassSpecialRender");
      sortBases(overridePassSpecialRenderHookTypes, allBaseOverridePassSpecialRenderSuperiors, allBaseOverridePassSpecialRenderInferiors, "overridePassSpecialRender");
      sortBases(afterPassSpecialRenderHookTypes, allBaseAfterPassSpecialRenderSuperiors, allBaseAfterPassSpecialRenderInferiors, "afterPassSpecialRender");
      sortBases(beforePerformStaticEntityRebuildHookTypes, allBaseBeforePerformStaticEntityRebuildSuperiors, allBaseBeforePerformStaticEntityRebuildInferiors, "beforePerformStaticEntityRebuild");
      sortBases(overridePerformStaticEntityRebuildHookTypes, allBaseOverridePerformStaticEntityRebuildSuperiors, allBaseOverridePerformStaticEntityRebuildInferiors, "overridePerformStaticEntityRebuild");
      sortBases(afterPerformStaticEntityRebuildHookTypes, allBaseAfterPerformStaticEntityRebuildSuperiors, allBaseAfterPerformStaticEntityRebuildInferiors, "afterPerformStaticEntityRebuild");
      sortBases(beforeRenderArrowsStuckInEntityHookTypes, allBaseBeforeRenderArrowsStuckInEntitySuperiors, allBaseBeforeRenderArrowsStuckInEntityInferiors, "beforeRenderArrowsStuckInEntity");
      sortBases(overrideRenderArrowsStuckInEntityHookTypes, allBaseOverrideRenderArrowsStuckInEntitySuperiors, allBaseOverrideRenderArrowsStuckInEntityInferiors, "overrideRenderArrowsStuckInEntity");
      sortBases(afterRenderArrowsStuckInEntityHookTypes, allBaseAfterRenderArrowsStuckInEntitySuperiors, allBaseAfterRenderArrowsStuckInEntityInferiors, "afterRenderArrowsStuckInEntity");
      sortBases(beforeRenderFirstPersonArmHookTypes, allBaseBeforeRenderFirstPersonArmSuperiors, allBaseBeforeRenderFirstPersonArmInferiors, "beforeRenderFirstPersonArm");
      sortBases(overrideRenderFirstPersonArmHookTypes, allBaseOverrideRenderFirstPersonArmSuperiors, allBaseOverrideRenderFirstPersonArmInferiors, "overrideRenderFirstPersonArm");
      sortBases(afterRenderFirstPersonArmHookTypes, allBaseAfterRenderFirstPersonArmSuperiors, allBaseAfterRenderFirstPersonArmInferiors, "afterRenderFirstPersonArm");
      sortBases(beforeRenderLivingLabelHookTypes, allBaseBeforeRenderLivingLabelSuperiors, allBaseBeforeRenderLivingLabelInferiors, "beforeRenderLivingLabel");
      sortBases(overrideRenderLivingLabelHookTypes, allBaseOverrideRenderLivingLabelSuperiors, allBaseOverrideRenderLivingLabelInferiors, "overrideRenderLivingLabel");
      sortBases(afterRenderLivingLabelHookTypes, allBaseAfterRenderLivingLabelSuperiors, allBaseAfterRenderLivingLabelInferiors, "afterRenderLivingLabel");
      sortBases(beforeRenderModelHookTypes, allBaseBeforeRenderModelSuperiors, allBaseBeforeRenderModelInferiors, "beforeRenderModel");
      sortBases(overrideRenderModelHookTypes, allBaseOverrideRenderModelSuperiors, allBaseOverrideRenderModelInferiors, "overrideRenderModel");
      sortBases(afterRenderModelHookTypes, allBaseAfterRenderModelSuperiors, allBaseAfterRenderModelInferiors, "afterRenderModel");
      sortBases(beforeRenderPlayerHookTypes, allBaseBeforeRenderPlayerSuperiors, allBaseBeforeRenderPlayerInferiors, "beforeRenderPlayer");
      sortBases(overrideRenderPlayerHookTypes, allBaseOverrideRenderPlayerSuperiors, allBaseOverrideRenderPlayerInferiors, "overrideRenderPlayer");
      sortBases(afterRenderPlayerHookTypes, allBaseAfterRenderPlayerSuperiors, allBaseAfterRenderPlayerInferiors, "afterRenderPlayer");
      sortBases(beforeRenderPlayerNameAndScoreLabelHookTypes, allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors, allBaseBeforeRenderPlayerNameAndScoreLabelInferiors, "beforeRenderPlayerNameAndScoreLabel");
      sortBases(overrideRenderPlayerNameAndScoreLabelHookTypes, allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors, allBaseOverrideRenderPlayerNameAndScoreLabelInferiors, "overrideRenderPlayerNameAndScoreLabel");
      sortBases(afterRenderPlayerNameAndScoreLabelHookTypes, allBaseAfterRenderPlayerNameAndScoreLabelSuperiors, allBaseAfterRenderPlayerNameAndScoreLabelInferiors, "afterRenderPlayerNameAndScoreLabel");
      sortBases(beforeRenderPlayerScaleHookTypes, allBaseBeforeRenderPlayerScaleSuperiors, allBaseBeforeRenderPlayerScaleInferiors, "beforeRenderPlayerScale");
      sortBases(overrideRenderPlayerScaleHookTypes, allBaseOverrideRenderPlayerScaleSuperiors, allBaseOverrideRenderPlayerScaleInferiors, "overrideRenderPlayerScale");
      sortBases(afterRenderPlayerScaleHookTypes, allBaseAfterRenderPlayerScaleSuperiors, allBaseAfterRenderPlayerScaleInferiors, "afterRenderPlayerScale");
      sortBases(beforeRenderPlayerSleepHookTypes, allBaseBeforeRenderPlayerSleepSuperiors, allBaseBeforeRenderPlayerSleepInferiors, "beforeRenderPlayerSleep");
      sortBases(overrideRenderPlayerSleepHookTypes, allBaseOverrideRenderPlayerSleepSuperiors, allBaseOverrideRenderPlayerSleepInferiors, "overrideRenderPlayerSleep");
      sortBases(afterRenderPlayerSleepHookTypes, allBaseAfterRenderPlayerSleepSuperiors, allBaseAfterRenderPlayerSleepInferiors, "afterRenderPlayerSleep");
      sortBases(beforeRenderSpecialsHookTypes, allBaseBeforeRenderSpecialsSuperiors, allBaseBeforeRenderSpecialsInferiors, "beforeRenderSpecials");
      sortBases(overrideRenderSpecialsHookTypes, allBaseOverrideRenderSpecialsSuperiors, allBaseOverrideRenderSpecialsInferiors, "overrideRenderSpecials");
      sortBases(afterRenderSpecialsHookTypes, allBaseAfterRenderSpecialsSuperiors, allBaseAfterRenderSpecialsInferiors, "afterRenderSpecials");
      sortBases(beforeRenderSwingProgressHookTypes, allBaseBeforeRenderSwingProgressSuperiors, allBaseBeforeRenderSwingProgressInferiors, "beforeRenderSwingProgress");
      sortBases(overrideRenderSwingProgressHookTypes, allBaseOverrideRenderSwingProgressSuperiors, allBaseOverrideRenderSwingProgressInferiors, "overrideRenderSwingProgress");
      sortBases(afterRenderSwingProgressHookTypes, allBaseAfterRenderSwingProgressSuperiors, allBaseAfterRenderSwingProgressInferiors, "afterRenderSwingProgress");
      sortBases(beforeRotatePlayerHookTypes, allBaseBeforeRotatePlayerSuperiors, allBaseBeforeRotatePlayerInferiors, "beforeRotatePlayer");
      sortBases(overrideRotatePlayerHookTypes, allBaseOverrideRotatePlayerSuperiors, allBaseOverrideRotatePlayerInferiors, "overrideRotatePlayer");
      sortBases(afterRotatePlayerHookTypes, allBaseAfterRotatePlayerSuperiors, allBaseAfterRotatePlayerInferiors, "afterRotatePlayer");
      sortBases(beforeSetArmorModelHookTypes, allBaseBeforeSetArmorModelSuperiors, allBaseBeforeSetArmorModelInferiors, "beforeSetArmorModel");
      sortBases(overrideSetArmorModelHookTypes, allBaseOverrideSetArmorModelSuperiors, allBaseOverrideSetArmorModelInferiors, "overrideSetArmorModel");
      sortBases(afterSetArmorModelHookTypes, allBaseAfterSetArmorModelSuperiors, allBaseAfterSetArmorModelInferiors, "afterSetArmorModel");
      sortBases(beforeSetPassArmorModelHookTypes, allBaseBeforeSetPassArmorModelSuperiors, allBaseBeforeSetPassArmorModelInferiors, "beforeSetPassArmorModel");
      sortBases(overrideSetPassArmorModelHookTypes, allBaseOverrideSetPassArmorModelSuperiors, allBaseOverrideSetPassArmorModelInferiors, "overrideSetPassArmorModel");
      sortBases(afterSetPassArmorModelHookTypes, allBaseAfterSetPassArmorModelSuperiors, allBaseAfterSetPassArmorModelInferiors, "afterSetPassArmorModel");
      sortBases(beforeSetRenderManagerHookTypes, allBaseBeforeSetRenderManagerSuperiors, allBaseBeforeSetRenderManagerInferiors, "beforeSetRenderManager");
      sortBases(overrideSetRenderManagerHookTypes, allBaseOverrideSetRenderManagerSuperiors, allBaseOverrideSetRenderManagerInferiors, "overrideSetRenderManager");
      sortBases(afterSetRenderManagerHookTypes, allBaseAfterSetRenderManagerSuperiors, allBaseAfterSetRenderManagerInferiors, "afterSetRenderManager");
      sortBases(beforeSetRenderPassModelHookTypes, allBaseBeforeSetRenderPassModelSuperiors, allBaseBeforeSetRenderPassModelInferiors, "beforeSetRenderPassModel");
      sortBases(overrideSetRenderPassModelHookTypes, allBaseOverrideSetRenderPassModelSuperiors, allBaseOverrideSetRenderPassModelInferiors, "overrideSetRenderPassModel");
      sortBases(afterSetRenderPassModelHookTypes, allBaseAfterSetRenderPassModelSuperiors, allBaseAfterSetRenderPassModelInferiors, "afterSetRenderPassModel");
      sortBases(beforeUpdateIconsHookTypes, allBaseBeforeUpdateIconsSuperiors, allBaseBeforeUpdateIconsInferiors, "beforeUpdateIcons");
      sortBases(overrideUpdateIconsHookTypes, allBaseOverrideUpdateIconsSuperiors, allBaseOverrideUpdateIconsInferiors, "overrideUpdateIcons");
      sortBases(afterUpdateIconsHookTypes, allBaseAfterUpdateIconsSuperiors, allBaseAfterUpdateIconsInferiors, "afterUpdateIcons");
      initialized = true;
   }

   private static List getAllInstancesList() {
      ArrayList var0 = new ArrayList();
      Iterator var1 = allInstances.iterator();

      while(var1.hasNext()) {
         IRenderPlayerAPI var2 = (IRenderPlayerAPI)((WeakReference)var1.next()).get();
         if(var2 != null) {
            var0.add(var2);
         } else {
            var1.remove();
         }
      }

      return var0;
   }

   public static RenderPlayer[] getAllInstances() {
      List var0 = getAllInstancesList();
      return (RenderPlayer[])var0.toArray(new RenderPlayer[var0.size()]);
   }

   public static void beforeLocalConstructing(IRenderPlayerAPI var0) {
      RenderPlayerAPI var1 = var0.getRenderPlayerAPI();
      if(var1 != null) {
         var1.load();
      }

      allInstances.add(new WeakReference(var0));
      if(var1 != null) {
         var1.beforeLocalConstructing();
      }

   }

   public static void afterLocalConstructing(IRenderPlayerAPI var0) {
      RenderPlayerAPI var1 = var0.getRenderPlayerAPI();
      if(var1 != null) {
         var1.afterLocalConstructing();
      }

   }

   public static RenderPlayerBase getRenderPlayerBase(IRenderPlayerAPI var0, String var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      return var2 != null?var2.getRenderPlayerBase(var1):null;
   }

   public static Set getRenderPlayerBaseIds(IRenderPlayerAPI var0) {
      RenderPlayerAPI var1 = var0.getRenderPlayerAPI();
      Set var2 = null;
      if(var1 != null) {
         var2 = var1.getRenderPlayerBaseIds();
      } else {
         var2 = Collections.emptySet();
      }

      return var2;
   }

   public static Object dynamic(IRenderPlayerAPI var0, String var1, Object[] var2) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      return var3 != null?var3.dynamic(var1, var2):null;
   }

   private static void sortBases(List var0, Map var1, Map var2, String var3) {
      (new RenderPlayerBaseSorter(var0, var1, var2, var3)).Sort();
   }

   private static void sortDynamicBases(Map var0, Map var1, Map var2, String var3) {
      List var4 = (List)var0.get(var3);
      if(var4 != null && var4.size() > 1) {
         sortBases(var4, getDynamicSorters(var3, var4, var1), getDynamicSorters(var3, var4, var2), var3);
      }

   }

   private static Map getDynamicSorters(String var0, List var1, Map var2) {
      HashMap var3 = null;
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         Map var6 = (Map)var2.get(var5);
         if(var6 != null) {
            String[] var7 = (String[])var6.get(var0);
            if(var7 != null && var7.length > 0) {
               if(var3 == null) {
                  var3 = new HashMap(1);
               }

               var3.put(var5, var7);
            }
         }
      }

      return (Map)(var3 != null?var3:EmptySortMap);
   }

   private RenderPlayerAPI(IRenderPlayerAPI var1) {
      this.unmodifiableAllBaseIds = Collections.unmodifiableSet(this.allBaseObjects.keySet());
      this.renderPlayer = var1;
   }

   private void load() {
      Iterator var1 = allBaseConstructors.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         RenderPlayerBase var3 = this.createRenderPlayerBase(var2);
         var3.beforeBaseAttach(false);
         this.allBaseObjects.put(var2, var3);
         this.baseObjectsToId.put(var3, var2);
      }

      this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
      this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
      this.updateRenderPlayerBases();
      var1 = this.allBaseObjects.keySet().iterator();

      while(var1.hasNext()) {
         ((RenderPlayerBase)this.allBaseObjects.get(var1.next())).afterBaseAttach(false);
      }

   }

   private RenderPlayerBase createRenderPlayerBase(String var1) {
      Constructor var2 = (Constructor)allBaseConstructors.get(var1);

      try {
         RenderPlayerBase var3;
         if(var2.getParameterTypes().length == 1) {
            var3 = (RenderPlayerBase)var2.newInstance(new Object[]{this});
         } else {
            var3 = (RenderPlayerBase)var2.newInstance(new Object[]{this, var1});
         }

         return var3;
      } catch (Exception var5) {
         throw new RuntimeException("Exception while creating a RenderPlayerBase of type \'" + var2.getDeclaringClass() + "\'", var5);
      }
   }

   private void updateRenderPlayerBases() {
      this.beforeDoRenderLabelHooks = this.create(beforeDoRenderLabelHookTypes);
      this.overrideDoRenderLabelHooks = this.create(overrideDoRenderLabelHookTypes);
      this.afterDoRenderLabelHooks = this.create(afterDoRenderLabelHookTypes);
      this.isDoRenderLabelModded = this.beforeDoRenderLabelHooks != null || this.overrideDoRenderLabelHooks != null || this.afterDoRenderLabelHooks != null;
      this.beforeDoRenderShadowAndFireHooks = this.create(beforeDoRenderShadowAndFireHookTypes);
      this.overrideDoRenderShadowAndFireHooks = this.create(overrideDoRenderShadowAndFireHookTypes);
      this.afterDoRenderShadowAndFireHooks = this.create(afterDoRenderShadowAndFireHookTypes);
      this.isDoRenderShadowAndFireModded = this.beforeDoRenderShadowAndFireHooks != null || this.overrideDoRenderShadowAndFireHooks != null || this.afterDoRenderShadowAndFireHooks != null;
      this.beforeGetColorMultiplierHooks = this.create(beforeGetColorMultiplierHookTypes);
      this.overrideGetColorMultiplierHooks = this.create(overrideGetColorMultiplierHookTypes);
      this.afterGetColorMultiplierHooks = this.create(afterGetColorMultiplierHookTypes);
      this.isGetColorMultiplierModded = this.beforeGetColorMultiplierHooks != null || this.overrideGetColorMultiplierHooks != null || this.afterGetColorMultiplierHooks != null;
      this.beforeGetDeathMaxRotationHooks = this.create(beforeGetDeathMaxRotationHookTypes);
      this.overrideGetDeathMaxRotationHooks = this.create(overrideGetDeathMaxRotationHookTypes);
      this.afterGetDeathMaxRotationHooks = this.create(afterGetDeathMaxRotationHookTypes);
      this.isGetDeathMaxRotationModded = this.beforeGetDeathMaxRotationHooks != null || this.overrideGetDeathMaxRotationHooks != null || this.afterGetDeathMaxRotationHooks != null;
      this.beforeGetFontRendererFromRenderManagerHooks = this.create(beforeGetFontRendererFromRenderManagerHookTypes);
      this.overrideGetFontRendererFromRenderManagerHooks = this.create(overrideGetFontRendererFromRenderManagerHookTypes);
      this.afterGetFontRendererFromRenderManagerHooks = this.create(afterGetFontRendererFromRenderManagerHookTypes);
      this.isGetFontRendererFromRenderManagerModded = this.beforeGetFontRendererFromRenderManagerHooks != null || this.overrideGetFontRendererFromRenderManagerHooks != null || this.afterGetFontRendererFromRenderManagerHooks != null;
      this.beforeGetResourceLocationFromPlayerHooks = this.create(beforeGetResourceLocationFromPlayerHookTypes);
      this.overrideGetResourceLocationFromPlayerHooks = this.create(overrideGetResourceLocationFromPlayerHookTypes);
      this.afterGetResourceLocationFromPlayerHooks = this.create(afterGetResourceLocationFromPlayerHookTypes);
      this.isGetResourceLocationFromPlayerModded = this.beforeGetResourceLocationFromPlayerHooks != null || this.overrideGetResourceLocationFromPlayerHooks != null || this.afterGetResourceLocationFromPlayerHooks != null;
      this.beforeHandleRotationFloatHooks = this.create(beforeHandleRotationFloatHookTypes);
      this.overrideHandleRotationFloatHooks = this.create(overrideHandleRotationFloatHookTypes);
      this.afterHandleRotationFloatHooks = this.create(afterHandleRotationFloatHookTypes);
      this.isHandleRotationFloatModded = this.beforeHandleRotationFloatHooks != null || this.overrideHandleRotationFloatHooks != null || this.afterHandleRotationFloatHooks != null;
      this.beforeInheritRenderPassHooks = this.create(beforeInheritRenderPassHookTypes);
      this.overrideInheritRenderPassHooks = this.create(overrideInheritRenderPassHookTypes);
      this.afterInheritRenderPassHooks = this.create(afterInheritRenderPassHookTypes);
      this.isInheritRenderPassModded = this.beforeInheritRenderPassHooks != null || this.overrideInheritRenderPassHooks != null || this.afterInheritRenderPassHooks != null;
      this.beforeLoadTextureHooks = this.create(beforeLoadTextureHookTypes);
      this.overrideLoadTextureHooks = this.create(overrideLoadTextureHookTypes);
      this.afterLoadTextureHooks = this.create(afterLoadTextureHookTypes);
      this.isLoadTextureModded = this.beforeLoadTextureHooks != null || this.overrideLoadTextureHooks != null || this.afterLoadTextureHooks != null;
      this.beforeLoadTextureOfEntityHooks = this.create(beforeLoadTextureOfEntityHookTypes);
      this.overrideLoadTextureOfEntityHooks = this.create(overrideLoadTextureOfEntityHookTypes);
      this.afterLoadTextureOfEntityHooks = this.create(afterLoadTextureOfEntityHookTypes);
      this.isLoadTextureOfEntityModded = this.beforeLoadTextureOfEntityHooks != null || this.overrideLoadTextureOfEntityHooks != null || this.afterLoadTextureOfEntityHooks != null;
      this.beforePassSpecialRenderHooks = this.create(beforePassSpecialRenderHookTypes);
      this.overridePassSpecialRenderHooks = this.create(overridePassSpecialRenderHookTypes);
      this.afterPassSpecialRenderHooks = this.create(afterPassSpecialRenderHookTypes);
      this.isPassSpecialRenderModded = this.beforePassSpecialRenderHooks != null || this.overridePassSpecialRenderHooks != null || this.afterPassSpecialRenderHooks != null;
      this.beforePerformStaticEntityRebuildHooks = this.create(beforePerformStaticEntityRebuildHookTypes);
      this.overridePerformStaticEntityRebuildHooks = this.create(overridePerformStaticEntityRebuildHookTypes);
      this.afterPerformStaticEntityRebuildHooks = this.create(afterPerformStaticEntityRebuildHookTypes);
      this.isPerformStaticEntityRebuildModded = this.beforePerformStaticEntityRebuildHooks != null || this.overridePerformStaticEntityRebuildHooks != null || this.afterPerformStaticEntityRebuildHooks != null;
      this.beforeRenderArrowsStuckInEntityHooks = this.create(beforeRenderArrowsStuckInEntityHookTypes);
      this.overrideRenderArrowsStuckInEntityHooks = this.create(overrideRenderArrowsStuckInEntityHookTypes);
      this.afterRenderArrowsStuckInEntityHooks = this.create(afterRenderArrowsStuckInEntityHookTypes);
      this.isRenderArrowsStuckInEntityModded = this.beforeRenderArrowsStuckInEntityHooks != null || this.overrideRenderArrowsStuckInEntityHooks != null || this.afterRenderArrowsStuckInEntityHooks != null;
      this.beforeRenderFirstPersonArmHooks = this.create(beforeRenderFirstPersonArmHookTypes);
      this.overrideRenderFirstPersonArmHooks = this.create(overrideRenderFirstPersonArmHookTypes);
      this.afterRenderFirstPersonArmHooks = this.create(afterRenderFirstPersonArmHookTypes);
      this.isRenderFirstPersonArmModded = this.beforeRenderFirstPersonArmHooks != null || this.overrideRenderFirstPersonArmHooks != null || this.afterRenderFirstPersonArmHooks != null;
      this.beforeRenderLivingLabelHooks = this.create(beforeRenderLivingLabelHookTypes);
      this.overrideRenderLivingLabelHooks = this.create(overrideRenderLivingLabelHookTypes);
      this.afterRenderLivingLabelHooks = this.create(afterRenderLivingLabelHookTypes);
      this.isRenderLivingLabelModded = this.beforeRenderLivingLabelHooks != null || this.overrideRenderLivingLabelHooks != null || this.afterRenderLivingLabelHooks != null;
      this.beforeRenderModelHooks = this.create(beforeRenderModelHookTypes);
      this.overrideRenderModelHooks = this.create(overrideRenderModelHookTypes);
      this.afterRenderModelHooks = this.create(afterRenderModelHookTypes);
      this.isRenderModelModded = this.beforeRenderModelHooks != null || this.overrideRenderModelHooks != null || this.afterRenderModelHooks != null;
      this.beforeRenderPlayerHooks = this.create(beforeRenderPlayerHookTypes);
      this.overrideRenderPlayerHooks = this.create(overrideRenderPlayerHookTypes);
      this.afterRenderPlayerHooks = this.create(afterRenderPlayerHookTypes);
      this.isRenderPlayerModded = this.beforeRenderPlayerHooks != null || this.overrideRenderPlayerHooks != null || this.afterRenderPlayerHooks != null;
      this.beforeRenderPlayerNameAndScoreLabelHooks = this.create(beforeRenderPlayerNameAndScoreLabelHookTypes);
      this.overrideRenderPlayerNameAndScoreLabelHooks = this.create(overrideRenderPlayerNameAndScoreLabelHookTypes);
      this.afterRenderPlayerNameAndScoreLabelHooks = this.create(afterRenderPlayerNameAndScoreLabelHookTypes);
      this.isRenderPlayerNameAndScoreLabelModded = this.beforeRenderPlayerNameAndScoreLabelHooks != null || this.overrideRenderPlayerNameAndScoreLabelHooks != null || this.afterRenderPlayerNameAndScoreLabelHooks != null;
      this.beforeRenderPlayerScaleHooks = this.create(beforeRenderPlayerScaleHookTypes);
      this.overrideRenderPlayerScaleHooks = this.create(overrideRenderPlayerScaleHookTypes);
      this.afterRenderPlayerScaleHooks = this.create(afterRenderPlayerScaleHookTypes);
      this.isRenderPlayerScaleModded = this.beforeRenderPlayerScaleHooks != null || this.overrideRenderPlayerScaleHooks != null || this.afterRenderPlayerScaleHooks != null;
      this.beforeRenderPlayerSleepHooks = this.create(beforeRenderPlayerSleepHookTypes);
      this.overrideRenderPlayerSleepHooks = this.create(overrideRenderPlayerSleepHookTypes);
      this.afterRenderPlayerSleepHooks = this.create(afterRenderPlayerSleepHookTypes);
      this.isRenderPlayerSleepModded = this.beforeRenderPlayerSleepHooks != null || this.overrideRenderPlayerSleepHooks != null || this.afterRenderPlayerSleepHooks != null;
      this.beforeRenderSpecialsHooks = this.create(beforeRenderSpecialsHookTypes);
      this.overrideRenderSpecialsHooks = this.create(overrideRenderSpecialsHookTypes);
      this.afterRenderSpecialsHooks = this.create(afterRenderSpecialsHookTypes);
      this.isRenderSpecialsModded = this.beforeRenderSpecialsHooks != null || this.overrideRenderSpecialsHooks != null || this.afterRenderSpecialsHooks != null;
      this.beforeRenderSwingProgressHooks = this.create(beforeRenderSwingProgressHookTypes);
      this.overrideRenderSwingProgressHooks = this.create(overrideRenderSwingProgressHookTypes);
      this.afterRenderSwingProgressHooks = this.create(afterRenderSwingProgressHookTypes);
      this.isRenderSwingProgressModded = this.beforeRenderSwingProgressHooks != null || this.overrideRenderSwingProgressHooks != null || this.afterRenderSwingProgressHooks != null;
      this.beforeRotatePlayerHooks = this.create(beforeRotatePlayerHookTypes);
      this.overrideRotatePlayerHooks = this.create(overrideRotatePlayerHookTypes);
      this.afterRotatePlayerHooks = this.create(afterRotatePlayerHookTypes);
      this.isRotatePlayerModded = this.beforeRotatePlayerHooks != null || this.overrideRotatePlayerHooks != null || this.afterRotatePlayerHooks != null;
      this.beforeSetArmorModelHooks = this.create(beforeSetArmorModelHookTypes);
      this.overrideSetArmorModelHooks = this.create(overrideSetArmorModelHookTypes);
      this.afterSetArmorModelHooks = this.create(afterSetArmorModelHookTypes);
      this.isSetArmorModelModded = this.beforeSetArmorModelHooks != null || this.overrideSetArmorModelHooks != null || this.afterSetArmorModelHooks != null;
      this.beforeSetPassArmorModelHooks = this.create(beforeSetPassArmorModelHookTypes);
      this.overrideSetPassArmorModelHooks = this.create(overrideSetPassArmorModelHookTypes);
      this.afterSetPassArmorModelHooks = this.create(afterSetPassArmorModelHookTypes);
      this.isSetPassArmorModelModded = this.beforeSetPassArmorModelHooks != null || this.overrideSetPassArmorModelHooks != null || this.afterSetPassArmorModelHooks != null;
      this.beforeSetRenderManagerHooks = this.create(beforeSetRenderManagerHookTypes);
      this.overrideSetRenderManagerHooks = this.create(overrideSetRenderManagerHookTypes);
      this.afterSetRenderManagerHooks = this.create(afterSetRenderManagerHookTypes);
      this.isSetRenderManagerModded = this.beforeSetRenderManagerHooks != null || this.overrideSetRenderManagerHooks != null || this.afterSetRenderManagerHooks != null;
      this.beforeSetRenderPassModelHooks = this.create(beforeSetRenderPassModelHookTypes);
      this.overrideSetRenderPassModelHooks = this.create(overrideSetRenderPassModelHookTypes);
      this.afterSetRenderPassModelHooks = this.create(afterSetRenderPassModelHookTypes);
      this.isSetRenderPassModelModded = this.beforeSetRenderPassModelHooks != null || this.overrideSetRenderPassModelHooks != null || this.afterSetRenderPassModelHooks != null;
      this.beforeUpdateIconsHooks = this.create(beforeUpdateIconsHookTypes);
      this.overrideUpdateIconsHooks = this.create(overrideUpdateIconsHookTypes);
      this.afterUpdateIconsHooks = this.create(afterUpdateIconsHookTypes);
      this.isUpdateIconsModded = this.beforeUpdateIconsHooks != null || this.overrideUpdateIconsHooks != null || this.afterUpdateIconsHooks != null;
   }

   private void attachRenderPlayerBase(String var1) {
      RenderPlayerBase var2 = this.createRenderPlayerBase(var1);
      var2.beforeBaseAttach(true);
      this.allBaseObjects.put(var1, var2);
      this.updateRenderPlayerBases();
      var2.afterBaseAttach(true);
   }

   private void detachRenderPlayerBase(String var1) {
      RenderPlayerBase var2 = (RenderPlayerBase)this.allBaseObjects.get(var1);
      var2.beforeBaseDetach(true);
      this.allBaseObjects.remove(var1);
      var2.afterBaseDetach(true);
   }

   private RenderPlayerBase[] create(List var1) {
      if(var1.isEmpty()) {
         return null;
      } else {
         RenderPlayerBase[] var2 = new RenderPlayerBase[var1.size()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = this.getRenderPlayerBase((String)var1.get(var3));
         }

         return var2;
      }
   }

   private void beforeLocalConstructing() {
      if(this.beforeLocalConstructingHooks != null) {
         for(int var1 = this.beforeLocalConstructingHooks.length - 1; var1 >= 0; --var1) {
            this.beforeLocalConstructingHooks[var1].beforeLocalConstructing();
         }
      }

      this.beforeLocalConstructingHooks = null;
   }

   private void afterLocalConstructing() {
      if(this.afterLocalConstructingHooks != null) {
         for(int var1 = 0; var1 < this.afterLocalConstructingHooks.length; ++var1) {
            this.afterLocalConstructingHooks[var1].afterLocalConstructing();
         }
      }

      this.afterLocalConstructingHooks = null;
   }

   public RenderPlayerBase getRenderPlayerBase(String var1) {
      return (RenderPlayerBase)this.allBaseObjects.get(var1);
   }

   public Set getRenderPlayerBaseIds() {
      return this.unmodifiableAllBaseIds;
   }

   public Object dynamic(String var1, Object[] var2) {
      var1 = var1.replace('.', '_').replace(' ', '_');
      this.executeAll(var1, var2, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
      Object var3 = this.dynamicOverwritten(var1, var2, (RenderPlayerBase)null);
      this.executeAll(var1, var2, afterDynamicHookTypes, afterDynamicHookMethods, false);
      return var3;
   }

   public Object dynamicOverwritten(String var1, Object[] var2, RenderPlayerBase var3) {
      List var4 = (List)overrideDynamicHookTypes.get(var1);
      String var5 = null;
      if(var4 != null) {
         if(var3 != null) {
            var5 = (String)this.baseObjectsToId.get(var3);
            int var6 = var4.indexOf(var5);
            if(var6 > 0) {
               var5 = (String)var4.get(var6 - 1);
            } else {
               var5 = null;
            }
         } else if(var4.size() > 0) {
            var5 = (String)var4.get(var4.size() - 1);
         }
      }

      Map var9;
      if(var5 == null) {
         var5 = (String)keysToVirtualIds.get(var1);
         if(var5 == null) {
            return null;
         }

         var9 = virtualDynamicHookMethods;
      } else {
         var9 = overrideDynamicHookMethods;
      }

      Map var7 = (Map)var9.get(((Constructor)allBaseConstructors.get(var5)).getDeclaringClass());
      if(var7 == null) {
         return null;
      } else {
         Method var8 = (Method)var7.get(var1);
         return var8 == null?null:this.execute(this.getRenderPlayerBase(var5), var8, var2);
      }
   }

   private void executeAll(String var1, Object[] var2, Map var3, Map var4, boolean var5) {
      List var6 = (List)var3.get(var1);
      if(var6 != null) {
         int var7 = var5?var6.size() - 1:0;

         while(true) {
            if(var5) {
               if(var7 < 0) {
                  break;
               }
            } else if(var7 >= var6.size()) {
               break;
            }

            String var8 = (String)var6.get(var7);
            RenderPlayerBase var9 = this.getRenderPlayerBase(var8);
            Class var10 = var9.getClass();
            Map var11 = (Map)var4.get(var10);
            if(var11 != null) {
               Method var12 = (Method)var11.get(var1);
               if(var12 != null) {
                  this.execute(var9, var12, var2);
               }
            }

            var7 += var5?-1:1;
         }

      }
   }

   private Object execute(RenderPlayerBase var1, Method var2, Object[] var3) {
      try {
         return var2.invoke(var1, var3);
      } catch (Exception var5) {
         throw new RuntimeException("Exception while invoking dynamic method", var5);
      }
   }

   public static boolean doRenderLabel(IRenderPlayerAPI var0, EntityLivingBase var1) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      boolean var2;
      if(var3 != null && var3.isDoRenderLabelModded) {
         var2 = var3.doRenderLabel(var1);
      } else {
         var2 = var0.localDoRenderLabel(var1);
      }

      return var2;
   }

   private boolean doRenderLabel(EntityLivingBase var1) {
      if(this.beforeDoRenderLabelHooks != null) {
         for(int var2 = this.beforeDoRenderLabelHooks.length - 1; var2 >= 0; --var2) {
            this.beforeDoRenderLabelHooks[var2].beforeDoRenderLabel(var1);
         }
      }

      boolean var4;
      if(this.overrideDoRenderLabelHooks != null) {
         var4 = this.overrideDoRenderLabelHooks[this.overrideDoRenderLabelHooks.length - 1].doRenderLabel(var1);
      } else {
         var4 = this.renderPlayer.localDoRenderLabel(var1);
      }

      if(this.afterDoRenderLabelHooks != null) {
         for(int var3 = 0; var3 < this.afterDoRenderLabelHooks.length; ++var3) {
            this.afterDoRenderLabelHooks[var3].afterDoRenderLabel(var1);
         }
      }

      return var4;
   }

   protected RenderPlayerBase GetOverwrittenDoRenderLabel(RenderPlayerBase var1) {
      if(this.overrideDoRenderLabelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDoRenderLabelHooks.length; ++var2) {
            if(this.overrideDoRenderLabelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDoRenderLabelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void doRenderShadowAndFire(IRenderPlayerAPI var0, Entity var1, double var2, double var4, double var6, float var8, float var9) {
      RenderPlayerAPI var10 = var0.getRenderPlayerAPI();
      if(var10 != null && var10.isDoRenderShadowAndFireModded) {
         var10.doRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
      } else {
         var0.localDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
      }

   }

   private void doRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      int var10;
      if(this.beforeDoRenderShadowAndFireHooks != null) {
         for(var10 = this.beforeDoRenderShadowAndFireHooks.length - 1; var10 >= 0; --var10) {
            this.beforeDoRenderShadowAndFireHooks[var10].beforeDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
         }
      }

      if(this.overrideDoRenderShadowAndFireHooks != null) {
         this.overrideDoRenderShadowAndFireHooks[this.overrideDoRenderShadowAndFireHooks.length - 1].doRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
      } else {
         this.renderPlayer.localDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
      }

      if(this.afterDoRenderShadowAndFireHooks != null) {
         for(var10 = 0; var10 < this.afterDoRenderShadowAndFireHooks.length; ++var10) {
            this.afterDoRenderShadowAndFireHooks[var10].afterDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenDoRenderShadowAndFire(RenderPlayerBase var1) {
      if(this.overrideDoRenderShadowAndFireHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDoRenderShadowAndFireHooks.length; ++var2) {
            if(this.overrideDoRenderShadowAndFireHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDoRenderShadowAndFireHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static int getColorMultiplier(IRenderPlayerAPI var0, EntityLivingBase var1, float var2, float var3) {
      RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
      int var4;
      if(var5 != null && var5.isGetColorMultiplierModded) {
         var4 = var5.getColorMultiplier(var1, var2, var3);
      } else {
         var4 = var0.localGetColorMultiplier(var1, var2, var3);
      }

      return var4;
   }

   private int getColorMultiplier(EntityLivingBase var1, float var2, float var3) {
      int var4;
      if(this.beforeGetColorMultiplierHooks != null) {
         for(var4 = this.beforeGetColorMultiplierHooks.length - 1; var4 >= 0; --var4) {
            this.beforeGetColorMultiplierHooks[var4].beforeGetColorMultiplier(var1, var2, var3);
         }
      }

      if(this.overrideGetColorMultiplierHooks != null) {
         var4 = this.overrideGetColorMultiplierHooks[this.overrideGetColorMultiplierHooks.length - 1].getColorMultiplier(var1, var2, var3);
      } else {
         var4 = this.renderPlayer.localGetColorMultiplier(var1, var2, var3);
      }

      if(this.afterGetColorMultiplierHooks != null) {
         for(int var5 = 0; var5 < this.afterGetColorMultiplierHooks.length; ++var5) {
            this.afterGetColorMultiplierHooks[var5].afterGetColorMultiplier(var1, var2, var3);
         }
      }

      return var4;
   }

   protected RenderPlayerBase GetOverwrittenGetColorMultiplier(RenderPlayerBase var1) {
      if(this.overrideGetColorMultiplierHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetColorMultiplierHooks.length; ++var2) {
            if(this.overrideGetColorMultiplierHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetColorMultiplierHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float getDeathMaxRotation(IRenderPlayerAPI var0, EntityLivingBase var1) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      float var2;
      if(var3 != null && var3.isGetDeathMaxRotationModded) {
         var2 = var3.getDeathMaxRotation(var1);
      } else {
         var2 = var0.localGetDeathMaxRotation(var1);
      }

      return var2;
   }

   private float getDeathMaxRotation(EntityLivingBase var1) {
      if(this.beforeGetDeathMaxRotationHooks != null) {
         for(int var2 = this.beforeGetDeathMaxRotationHooks.length - 1; var2 >= 0; --var2) {
            this.beforeGetDeathMaxRotationHooks[var2].beforeGetDeathMaxRotation(var1);
         }
      }

      float var4;
      if(this.overrideGetDeathMaxRotationHooks != null) {
         var4 = this.overrideGetDeathMaxRotationHooks[this.overrideGetDeathMaxRotationHooks.length - 1].getDeathMaxRotation(var1);
      } else {
         var4 = this.renderPlayer.localGetDeathMaxRotation(var1);
      }

      if(this.afterGetDeathMaxRotationHooks != null) {
         for(int var3 = 0; var3 < this.afterGetDeathMaxRotationHooks.length; ++var3) {
            this.afterGetDeathMaxRotationHooks[var3].afterGetDeathMaxRotation(var1);
         }
      }

      return var4;
   }

   protected RenderPlayerBase GetOverwrittenGetDeathMaxRotation(RenderPlayerBase var1) {
      if(this.overrideGetDeathMaxRotationHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetDeathMaxRotationHooks.length; ++var2) {
            if(this.overrideGetDeathMaxRotationHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetDeathMaxRotationHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static FontRenderer getFontRendererFromRenderManager(IRenderPlayerAPI var0) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      FontRenderer var1;
      if(var2 != null && var2.isGetFontRendererFromRenderManagerModded) {
         var1 = var2.getFontRendererFromRenderManager();
      } else {
         var1 = var0.localGetFontRendererFromRenderManager();
      }

      return var1;
   }

   private FontRenderer getFontRendererFromRenderManager() {
      if(this.beforeGetFontRendererFromRenderManagerHooks != null) {
         for(int var1 = this.beforeGetFontRendererFromRenderManagerHooks.length - 1; var1 >= 0; --var1) {
            this.beforeGetFontRendererFromRenderManagerHooks[var1].beforeGetFontRendererFromRenderManager();
         }
      }

      FontRenderer var3;
      if(this.overrideGetFontRendererFromRenderManagerHooks != null) {
         var3 = this.overrideGetFontRendererFromRenderManagerHooks[this.overrideGetFontRendererFromRenderManagerHooks.length - 1].getFontRendererFromRenderManager();
      } else {
         var3 = this.renderPlayer.localGetFontRendererFromRenderManager();
      }

      if(this.afterGetFontRendererFromRenderManagerHooks != null) {
         for(int var2 = 0; var2 < this.afterGetFontRendererFromRenderManagerHooks.length; ++var2) {
            this.afterGetFontRendererFromRenderManagerHooks[var2].afterGetFontRendererFromRenderManager();
         }
      }

      return var3;
   }

   protected RenderPlayerBase GetOverwrittenGetFontRendererFromRenderManager(RenderPlayerBase var1) {
      if(this.overrideGetFontRendererFromRenderManagerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetFontRendererFromRenderManagerHooks.length; ++var2) {
            if(this.overrideGetFontRendererFromRenderManagerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetFontRendererFromRenderManagerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static ResourceLocation getResourceLocationFromPlayer(IRenderPlayerAPI var0, AbstractClientPlayer var1) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      ResourceLocation var2;
      if(var3 != null && var3.isGetResourceLocationFromPlayerModded) {
         var2 = var3.getResourceLocationFromPlayer(var1);
      } else {
         var2 = var0.localGetResourceLocationFromPlayer(var1);
      }

      return var2;
   }

   private ResourceLocation getResourceLocationFromPlayer(AbstractClientPlayer var1) {
      if(this.beforeGetResourceLocationFromPlayerHooks != null) {
         for(int var2 = this.beforeGetResourceLocationFromPlayerHooks.length - 1; var2 >= 0; --var2) {
            this.beforeGetResourceLocationFromPlayerHooks[var2].beforeGetResourceLocationFromPlayer(var1);
         }
      }

      ResourceLocation var4;
      if(this.overrideGetResourceLocationFromPlayerHooks != null) {
         var4 = this.overrideGetResourceLocationFromPlayerHooks[this.overrideGetResourceLocationFromPlayerHooks.length - 1].getResourceLocationFromPlayer(var1);
      } else {
         var4 = this.renderPlayer.localGetResourceLocationFromPlayer(var1);
      }

      if(this.afterGetResourceLocationFromPlayerHooks != null) {
         for(int var3 = 0; var3 < this.afterGetResourceLocationFromPlayerHooks.length; ++var3) {
            this.afterGetResourceLocationFromPlayerHooks[var3].afterGetResourceLocationFromPlayer(var1);
         }
      }

      return var4;
   }

   protected RenderPlayerBase GetOverwrittenGetResourceLocationFromPlayer(RenderPlayerBase var1) {
      if(this.overrideGetResourceLocationFromPlayerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetResourceLocationFromPlayerHooks.length; ++var2) {
            if(this.overrideGetResourceLocationFromPlayerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetResourceLocationFromPlayerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float handleRotationFloat(IRenderPlayerAPI var0, EntityLivingBase var1, float var2) {
      RenderPlayerAPI var4 = var0.getRenderPlayerAPI();
      float var3;
      if(var4 != null && var4.isHandleRotationFloatModded) {
         var3 = var4.handleRotationFloat(var1, var2);
      } else {
         var3 = var0.localHandleRotationFloat(var1, var2);
      }

      return var3;
   }

   private float handleRotationFloat(EntityLivingBase var1, float var2) {
      if(this.beforeHandleRotationFloatHooks != null) {
         for(int var3 = this.beforeHandleRotationFloatHooks.length - 1; var3 >= 0; --var3) {
            this.beforeHandleRotationFloatHooks[var3].beforeHandleRotationFloat(var1, var2);
         }
      }

      float var5;
      if(this.overrideHandleRotationFloatHooks != null) {
         var5 = this.overrideHandleRotationFloatHooks[this.overrideHandleRotationFloatHooks.length - 1].handleRotationFloat(var1, var2);
      } else {
         var5 = this.renderPlayer.localHandleRotationFloat(var1, var2);
      }

      if(this.afterHandleRotationFloatHooks != null) {
         for(int var4 = 0; var4 < this.afterHandleRotationFloatHooks.length; ++var4) {
            this.afterHandleRotationFloatHooks[var4].afterHandleRotationFloat(var1, var2);
         }
      }

      return var5;
   }

   protected RenderPlayerBase GetOverwrittenHandleRotationFloat(RenderPlayerBase var1) {
      if(this.overrideHandleRotationFloatHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideHandleRotationFloatHooks.length; ++var2) {
            if(this.overrideHandleRotationFloatHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideHandleRotationFloatHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static int inheritRenderPass(IRenderPlayerAPI var0, EntityLivingBase var1, int var2, float var3) {
      RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
      int var4;
      if(var5 != null && var5.isInheritRenderPassModded) {
         var4 = var5.inheritRenderPass(var1, var2, var3);
      } else {
         var4 = var0.localInheritRenderPass(var1, var2, var3);
      }

      return var4;
   }

   private int inheritRenderPass(EntityLivingBase var1, int var2, float var3) {
      int var4;
      if(this.beforeInheritRenderPassHooks != null) {
         for(var4 = this.beforeInheritRenderPassHooks.length - 1; var4 >= 0; --var4) {
            this.beforeInheritRenderPassHooks[var4].beforeInheritRenderPass(var1, var2, var3);
         }
      }

      if(this.overrideInheritRenderPassHooks != null) {
         var4 = this.overrideInheritRenderPassHooks[this.overrideInheritRenderPassHooks.length - 1].inheritRenderPass(var1, var2, var3);
      } else {
         var4 = this.renderPlayer.localInheritRenderPass(var1, var2, var3);
      }

      if(this.afterInheritRenderPassHooks != null) {
         for(int var5 = 0; var5 < this.afterInheritRenderPassHooks.length; ++var5) {
            this.afterInheritRenderPassHooks[var5].afterInheritRenderPass(var1, var2, var3);
         }
      }

      return var4;
   }

   protected RenderPlayerBase GetOverwrittenInheritRenderPass(RenderPlayerBase var1) {
      if(this.overrideInheritRenderPassHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideInheritRenderPassHooks.length; ++var2) {
            if(this.overrideInheritRenderPassHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideInheritRenderPassHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void loadTexture(IRenderPlayerAPI var0, ResourceLocation var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      if(var2 != null && var2.isLoadTextureModded) {
         var2.loadTexture(var1);
      } else {
         var0.localLoadTexture(var1);
      }

   }

   private void loadTexture(ResourceLocation var1) {
      int var2;
      if(this.beforeLoadTextureHooks != null) {
         for(var2 = this.beforeLoadTextureHooks.length - 1; var2 >= 0; --var2) {
            this.beforeLoadTextureHooks[var2].beforeLoadTexture(var1);
         }
      }

      if(this.overrideLoadTextureHooks != null) {
         this.overrideLoadTextureHooks[this.overrideLoadTextureHooks.length - 1].loadTexture(var1);
      } else {
         this.renderPlayer.localLoadTexture(var1);
      }

      if(this.afterLoadTextureHooks != null) {
         for(var2 = 0; var2 < this.afterLoadTextureHooks.length; ++var2) {
            this.afterLoadTextureHooks[var2].afterLoadTexture(var1);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenLoadTexture(RenderPlayerBase var1) {
      if(this.overrideLoadTextureHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideLoadTextureHooks.length; ++var2) {
            if(this.overrideLoadTextureHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideLoadTextureHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void loadTextureOfEntity(IRenderPlayerAPI var0, Entity var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      if(var2 != null && var2.isLoadTextureOfEntityModded) {
         var2.loadTextureOfEntity(var1);
      } else {
         var0.localLoadTextureOfEntity(var1);
      }

   }

   private void loadTextureOfEntity(Entity var1) {
      int var2;
      if(this.beforeLoadTextureOfEntityHooks != null) {
         for(var2 = this.beforeLoadTextureOfEntityHooks.length - 1; var2 >= 0; --var2) {
            this.beforeLoadTextureOfEntityHooks[var2].beforeLoadTextureOfEntity(var1);
         }
      }

      if(this.overrideLoadTextureOfEntityHooks != null) {
         this.overrideLoadTextureOfEntityHooks[this.overrideLoadTextureOfEntityHooks.length - 1].loadTextureOfEntity(var1);
      } else {
         this.renderPlayer.localLoadTextureOfEntity(var1);
      }

      if(this.afterLoadTextureOfEntityHooks != null) {
         for(var2 = 0; var2 < this.afterLoadTextureOfEntityHooks.length; ++var2) {
            this.afterLoadTextureOfEntityHooks[var2].afterLoadTextureOfEntity(var1);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenLoadTextureOfEntity(RenderPlayerBase var1) {
      if(this.overrideLoadTextureOfEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideLoadTextureOfEntityHooks.length; ++var2) {
            if(this.overrideLoadTextureOfEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideLoadTextureOfEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void passSpecialRender(IRenderPlayerAPI var0, EntityLivingBase var1, double var2, double var4, double var6) {
      RenderPlayerAPI var8 = var0.getRenderPlayerAPI();
      if(var8 != null && var8.isPassSpecialRenderModded) {
         var8.passSpecialRender(var1, var2, var4, var6);
      } else {
         var0.localPassSpecialRender(var1, var2, var4, var6);
      }

   }

   private void passSpecialRender(EntityLivingBase var1, double var2, double var4, double var6) {
      int var8;
      if(this.beforePassSpecialRenderHooks != null) {
         for(var8 = this.beforePassSpecialRenderHooks.length - 1; var8 >= 0; --var8) {
            this.beforePassSpecialRenderHooks[var8].beforePassSpecialRender(var1, var2, var4, var6);
         }
      }

      if(this.overridePassSpecialRenderHooks != null) {
         this.overridePassSpecialRenderHooks[this.overridePassSpecialRenderHooks.length - 1].passSpecialRender(var1, var2, var4, var6);
      } else {
         this.renderPlayer.localPassSpecialRender(var1, var2, var4, var6);
      }

      if(this.afterPassSpecialRenderHooks != null) {
         for(var8 = 0; var8 < this.afterPassSpecialRenderHooks.length; ++var8) {
            this.afterPassSpecialRenderHooks[var8].afterPassSpecialRender(var1, var2, var4, var6);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenPassSpecialRender(RenderPlayerBase var1) {
      if(this.overridePassSpecialRenderHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overridePassSpecialRenderHooks.length; ++var2) {
            if(this.overridePassSpecialRenderHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overridePassSpecialRenderHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean performStaticEntityRebuild(IRenderPlayerAPI var0) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isPerformStaticEntityRebuildModded) {
         var1 = var2.performStaticEntityRebuild();
      } else {
         var1 = var0.localPerformStaticEntityRebuild();
      }

      return var1;
   }

   private boolean performStaticEntityRebuild() {
      if(this.beforePerformStaticEntityRebuildHooks != null) {
         for(int var1 = this.beforePerformStaticEntityRebuildHooks.length - 1; var1 >= 0; --var1) {
            this.beforePerformStaticEntityRebuildHooks[var1].beforePerformStaticEntityRebuild();
         }
      }

      boolean var3;
      if(this.overridePerformStaticEntityRebuildHooks != null) {
         var3 = this.overridePerformStaticEntityRebuildHooks[this.overridePerformStaticEntityRebuildHooks.length - 1].performStaticEntityRebuild();
      } else {
         var3 = this.renderPlayer.localPerformStaticEntityRebuild();
      }

      if(this.afterPerformStaticEntityRebuildHooks != null) {
         for(int var2 = 0; var2 < this.afterPerformStaticEntityRebuildHooks.length; ++var2) {
            this.afterPerformStaticEntityRebuildHooks[var2].afterPerformStaticEntityRebuild();
         }
      }

      return var3;
   }

   protected RenderPlayerBase GetOverwrittenPerformStaticEntityRebuild(RenderPlayerBase var1) {
      if(this.overridePerformStaticEntityRebuildHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overridePerformStaticEntityRebuildHooks.length; ++var2) {
            if(this.overridePerformStaticEntityRebuildHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overridePerformStaticEntityRebuildHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderArrowsStuckInEntity(IRenderPlayerAPI var0, EntityLivingBase var1, float var2) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      if(var3 != null && var3.isRenderArrowsStuckInEntityModded) {
         var3.renderArrowsStuckInEntity(var1, var2);
      } else {
         var0.localRenderArrowsStuckInEntity(var1, var2);
      }

   }

   private void renderArrowsStuckInEntity(EntityLivingBase var1, float var2) {
      int var3;
      if(this.beforeRenderArrowsStuckInEntityHooks != null) {
         for(var3 = this.beforeRenderArrowsStuckInEntityHooks.length - 1; var3 >= 0; --var3) {
            this.beforeRenderArrowsStuckInEntityHooks[var3].beforeRenderArrowsStuckInEntity(var1, var2);
         }
      }

      if(this.overrideRenderArrowsStuckInEntityHooks != null) {
         this.overrideRenderArrowsStuckInEntityHooks[this.overrideRenderArrowsStuckInEntityHooks.length - 1].renderArrowsStuckInEntity(var1, var2);
      } else {
         this.renderPlayer.localRenderArrowsStuckInEntity(var1, var2);
      }

      if(this.afterRenderArrowsStuckInEntityHooks != null) {
         for(var3 = 0; var3 < this.afterRenderArrowsStuckInEntityHooks.length; ++var3) {
            this.afterRenderArrowsStuckInEntityHooks[var3].afterRenderArrowsStuckInEntity(var1, var2);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderArrowsStuckInEntity(RenderPlayerBase var1) {
      if(this.overrideRenderArrowsStuckInEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderArrowsStuckInEntityHooks.length; ++var2) {
            if(this.overrideRenderArrowsStuckInEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderArrowsStuckInEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderFirstPersonArm(IRenderPlayerAPI var0, EntityPlayer var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      if(var2 != null && var2.isRenderFirstPersonArmModded) {
         var2.renderFirstPersonArm(var1);
      } else {
         var0.localRenderFirstPersonArm(var1);
      }

   }

   private void renderFirstPersonArm(EntityPlayer var1) {
      int var2;
      if(this.beforeRenderFirstPersonArmHooks != null) {
         for(var2 = this.beforeRenderFirstPersonArmHooks.length - 1; var2 >= 0; --var2) {
            this.beforeRenderFirstPersonArmHooks[var2].beforeRenderFirstPersonArm(var1);
         }
      }

      if(this.overrideRenderFirstPersonArmHooks != null) {
         this.overrideRenderFirstPersonArmHooks[this.overrideRenderFirstPersonArmHooks.length - 1].renderFirstPersonArm(var1);
      } else {
         this.renderPlayer.localRenderFirstPersonArm(var1);
      }

      if(this.afterRenderFirstPersonArmHooks != null) {
         for(var2 = 0; var2 < this.afterRenderFirstPersonArmHooks.length; ++var2) {
            this.afterRenderFirstPersonArmHooks[var2].afterRenderFirstPersonArm(var1);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderFirstPersonArm(RenderPlayerBase var1) {
      if(this.overrideRenderFirstPersonArmHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderFirstPersonArmHooks.length; ++var2) {
            if(this.overrideRenderFirstPersonArmHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderFirstPersonArmHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderLivingLabel(IRenderPlayerAPI var0, Entity var1, String var2, double var3, double var5, double var7, int var9) {
      RenderPlayerAPI var10 = var0.getRenderPlayerAPI();
      if(var10 != null && var10.isRenderLivingLabelModded) {
         var10.renderLivingLabel(var1, var2, var3, var5, var7, var9);
      } else {
         var0.localRenderLivingLabel(var1, var2, var3, var5, var7, var9);
      }

   }

   private void renderLivingLabel(Entity var1, String var2, double var3, double var5, double var7, int var9) {
      int var10;
      if(this.beforeRenderLivingLabelHooks != null) {
         for(var10 = this.beforeRenderLivingLabelHooks.length - 1; var10 >= 0; --var10) {
            this.beforeRenderLivingLabelHooks[var10].beforeRenderLivingLabel(var1, var2, var3, var5, var7, var9);
         }
      }

      if(this.overrideRenderLivingLabelHooks != null) {
         this.overrideRenderLivingLabelHooks[this.overrideRenderLivingLabelHooks.length - 1].renderLivingLabel(var1, var2, var3, var5, var7, var9);
      } else {
         this.renderPlayer.localRenderLivingLabel(var1, var2, var3, var5, var7, var9);
      }

      if(this.afterRenderLivingLabelHooks != null) {
         for(var10 = 0; var10 < this.afterRenderLivingLabelHooks.length; ++var10) {
            this.afterRenderLivingLabelHooks[var10].afterRenderLivingLabel(var1, var2, var3, var5, var7, var9);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderLivingLabel(RenderPlayerBase var1) {
      if(this.overrideRenderLivingLabelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderLivingLabelHooks.length; ++var2) {
            if(this.overrideRenderLivingLabelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderLivingLabelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderModel(IRenderPlayerAPI var0, EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      RenderPlayerAPI var8 = var0.getRenderPlayerAPI();
      if(var8 != null && var8.isRenderModelModded) {
         var8.renderModel(var1, var2, var3, var4, var5, var6, var7);
      } else {
         var0.localRenderModel(var1, var2, var3, var4, var5, var6, var7);
      }

   }

   private void renderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      int var8;
      if(this.beforeRenderModelHooks != null) {
         for(var8 = this.beforeRenderModelHooks.length - 1; var8 >= 0; --var8) {
            this.beforeRenderModelHooks[var8].beforeRenderModel(var1, var2, var3, var4, var5, var6, var7);
         }
      }

      if(this.overrideRenderModelHooks != null) {
         this.overrideRenderModelHooks[this.overrideRenderModelHooks.length - 1].renderModel(var1, var2, var3, var4, var5, var6, var7);
      } else {
         this.renderPlayer.localRenderModel(var1, var2, var3, var4, var5, var6, var7);
      }

      if(this.afterRenderModelHooks != null) {
         for(var8 = 0; var8 < this.afterRenderModelHooks.length; ++var8) {
            this.afterRenderModelHooks[var8].afterRenderModel(var1, var2, var3, var4, var5, var6, var7);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderModel(RenderPlayerBase var1) {
      if(this.overrideRenderModelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderModelHooks.length; ++var2) {
            if(this.overrideRenderModelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderModelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderPlayer(IRenderPlayerAPI var0, AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
      RenderPlayerAPI var10 = var0.getRenderPlayerAPI();
      if(var10 != null && var10.isRenderPlayerModded) {
         var10.renderPlayer(var1, var2, var4, var6, var8, var9);
      } else {
         var0.localRenderPlayer(var1, var2, var4, var6, var8, var9);
      }

   }

   private void renderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
      int var10;
      if(this.beforeRenderPlayerHooks != null) {
         for(var10 = this.beforeRenderPlayerHooks.length - 1; var10 >= 0; --var10) {
            this.beforeRenderPlayerHooks[var10].beforeRenderPlayer(var1, var2, var4, var6, var8, var9);
         }
      }

      if(this.overrideRenderPlayerHooks != null) {
         this.overrideRenderPlayerHooks[this.overrideRenderPlayerHooks.length - 1].renderPlayer(var1, var2, var4, var6, var8, var9);
      } else {
         this.renderPlayer.localRenderPlayer(var1, var2, var4, var6, var8, var9);
      }

      if(this.afterRenderPlayerHooks != null) {
         for(var10 = 0; var10 < this.afterRenderPlayerHooks.length; ++var10) {
            this.afterRenderPlayerHooks[var10].afterRenderPlayer(var1, var2, var4, var6, var8, var9);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderPlayer(RenderPlayerBase var1) {
      if(this.overrideRenderPlayerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderPlayerHooks.length; ++var2) {
            if(this.overrideRenderPlayerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderPlayerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderPlayerNameAndScoreLabel(IRenderPlayerAPI var0, AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
      RenderPlayerAPI var12 = var0.getRenderPlayerAPI();
      if(var12 != null && var12.isRenderPlayerNameAndScoreLabelModded) {
         var12.renderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
      } else {
         var0.localRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
      }

   }

   private void renderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
      int var12;
      if(this.beforeRenderPlayerNameAndScoreLabelHooks != null) {
         for(var12 = this.beforeRenderPlayerNameAndScoreLabelHooks.length - 1; var12 >= 0; --var12) {
            this.beforeRenderPlayerNameAndScoreLabelHooks[var12].beforeRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
         }
      }

      if(this.overrideRenderPlayerNameAndScoreLabelHooks != null) {
         this.overrideRenderPlayerNameAndScoreLabelHooks[this.overrideRenderPlayerNameAndScoreLabelHooks.length - 1].renderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
      } else {
         this.renderPlayer.localRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
      }

      if(this.afterRenderPlayerNameAndScoreLabelHooks != null) {
         for(var12 = 0; var12 < this.afterRenderPlayerNameAndScoreLabelHooks.length; ++var12) {
            this.afterRenderPlayerNameAndScoreLabelHooks[var12].afterRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderPlayerNameAndScoreLabel(RenderPlayerBase var1) {
      if(this.overrideRenderPlayerNameAndScoreLabelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderPlayerNameAndScoreLabelHooks.length; ++var2) {
            if(this.overrideRenderPlayerNameAndScoreLabelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderPlayerNameAndScoreLabelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderPlayerScale(IRenderPlayerAPI var0, AbstractClientPlayer var1, float var2) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      if(var3 != null && var3.isRenderPlayerScaleModded) {
         var3.renderPlayerScale(var1, var2);
      } else {
         var0.localRenderPlayerScale(var1, var2);
      }

   }

   private void renderPlayerScale(AbstractClientPlayer var1, float var2) {
      int var3;
      if(this.beforeRenderPlayerScaleHooks != null) {
         for(var3 = this.beforeRenderPlayerScaleHooks.length - 1; var3 >= 0; --var3) {
            this.beforeRenderPlayerScaleHooks[var3].beforeRenderPlayerScale(var1, var2);
         }
      }

      if(this.overrideRenderPlayerScaleHooks != null) {
         this.overrideRenderPlayerScaleHooks[this.overrideRenderPlayerScaleHooks.length - 1].renderPlayerScale(var1, var2);
      } else {
         this.renderPlayer.localRenderPlayerScale(var1, var2);
      }

      if(this.afterRenderPlayerScaleHooks != null) {
         for(var3 = 0; var3 < this.afterRenderPlayerScaleHooks.length; ++var3) {
            this.afterRenderPlayerScaleHooks[var3].afterRenderPlayerScale(var1, var2);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderPlayerScale(RenderPlayerBase var1) {
      if(this.overrideRenderPlayerScaleHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderPlayerScaleHooks.length; ++var2) {
            if(this.overrideRenderPlayerScaleHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderPlayerScaleHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderPlayerSleep(IRenderPlayerAPI var0, AbstractClientPlayer var1, double var2, double var4, double var6) {
      RenderPlayerAPI var8 = var0.getRenderPlayerAPI();
      if(var8 != null && var8.isRenderPlayerSleepModded) {
         var8.renderPlayerSleep(var1, var2, var4, var6);
      } else {
         var0.localRenderPlayerSleep(var1, var2, var4, var6);
      }

   }

   private void renderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6) {
      int var8;
      if(this.beforeRenderPlayerSleepHooks != null) {
         for(var8 = this.beforeRenderPlayerSleepHooks.length - 1; var8 >= 0; --var8) {
            this.beforeRenderPlayerSleepHooks[var8].beforeRenderPlayerSleep(var1, var2, var4, var6);
         }
      }

      if(this.overrideRenderPlayerSleepHooks != null) {
         this.overrideRenderPlayerSleepHooks[this.overrideRenderPlayerSleepHooks.length - 1].renderPlayerSleep(var1, var2, var4, var6);
      } else {
         this.renderPlayer.localRenderPlayerSleep(var1, var2, var4, var6);
      }

      if(this.afterRenderPlayerSleepHooks != null) {
         for(var8 = 0; var8 < this.afterRenderPlayerSleepHooks.length; ++var8) {
            this.afterRenderPlayerSleepHooks[var8].afterRenderPlayerSleep(var1, var2, var4, var6);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderPlayerSleep(RenderPlayerBase var1) {
      if(this.overrideRenderPlayerSleepHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderPlayerSleepHooks.length; ++var2) {
            if(this.overrideRenderPlayerSleepHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderPlayerSleepHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void renderSpecials(IRenderPlayerAPI var0, AbstractClientPlayer var1, float var2) {
      RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
      if(var3 != null && var3.isRenderSpecialsModded) {
         var3.renderSpecials(var1, var2);
      } else {
         var0.localRenderSpecials(var1, var2);
      }

   }

   private void renderSpecials(AbstractClientPlayer var1, float var2) {
      int var3;
      if(this.beforeRenderSpecialsHooks != null) {
         for(var3 = this.beforeRenderSpecialsHooks.length - 1; var3 >= 0; --var3) {
            this.beforeRenderSpecialsHooks[var3].beforeRenderSpecials(var1, var2);
         }
      }

      if(this.overrideRenderSpecialsHooks != null) {
         this.overrideRenderSpecialsHooks[this.overrideRenderSpecialsHooks.length - 1].renderSpecials(var1, var2);
      } else {
         this.renderPlayer.localRenderSpecials(var1, var2);
      }

      if(this.afterRenderSpecialsHooks != null) {
         for(var3 = 0; var3 < this.afterRenderSpecialsHooks.length; ++var3) {
            this.afterRenderSpecialsHooks[var3].afterRenderSpecials(var1, var2);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRenderSpecials(RenderPlayerBase var1) {
      if(this.overrideRenderSpecialsHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderSpecialsHooks.length; ++var2) {
            if(this.overrideRenderSpecialsHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderSpecialsHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float renderSwingProgress(IRenderPlayerAPI var0, EntityLivingBase var1, float var2) {
      RenderPlayerAPI var4 = var0.getRenderPlayerAPI();
      float var3;
      if(var4 != null && var4.isRenderSwingProgressModded) {
         var3 = var4.renderSwingProgress(var1, var2);
      } else {
         var3 = var0.localRenderSwingProgress(var1, var2);
      }

      return var3;
   }

   private float renderSwingProgress(EntityLivingBase var1, float var2) {
      if(this.beforeRenderSwingProgressHooks != null) {
         for(int var3 = this.beforeRenderSwingProgressHooks.length - 1; var3 >= 0; --var3) {
            this.beforeRenderSwingProgressHooks[var3].beforeRenderSwingProgress(var1, var2);
         }
      }

      float var5;
      if(this.overrideRenderSwingProgressHooks != null) {
         var5 = this.overrideRenderSwingProgressHooks[this.overrideRenderSwingProgressHooks.length - 1].renderSwingProgress(var1, var2);
      } else {
         var5 = this.renderPlayer.localRenderSwingProgress(var1, var2);
      }

      if(this.afterRenderSwingProgressHooks != null) {
         for(int var4 = 0; var4 < this.afterRenderSwingProgressHooks.length; ++var4) {
            this.afterRenderSwingProgressHooks[var4].afterRenderSwingProgress(var1, var2);
         }
      }

      return var5;
   }

   protected RenderPlayerBase GetOverwrittenRenderSwingProgress(RenderPlayerBase var1) {
      if(this.overrideRenderSwingProgressHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRenderSwingProgressHooks.length; ++var2) {
            if(this.overrideRenderSwingProgressHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRenderSwingProgressHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void rotatePlayer(IRenderPlayerAPI var0, AbstractClientPlayer var1, float var2, float var3, float var4) {
      RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
      if(var5 != null && var5.isRotatePlayerModded) {
         var5.rotatePlayer(var1, var2, var3, var4);
      } else {
         var0.localRotatePlayer(var1, var2, var3, var4);
      }

   }

   private void rotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4) {
      int var5;
      if(this.beforeRotatePlayerHooks != null) {
         for(var5 = this.beforeRotatePlayerHooks.length - 1; var5 >= 0; --var5) {
            this.beforeRotatePlayerHooks[var5].beforeRotatePlayer(var1, var2, var3, var4);
         }
      }

      if(this.overrideRotatePlayerHooks != null) {
         this.overrideRotatePlayerHooks[this.overrideRotatePlayerHooks.length - 1].rotatePlayer(var1, var2, var3, var4);
      } else {
         this.renderPlayer.localRotatePlayer(var1, var2, var3, var4);
      }

      if(this.afterRotatePlayerHooks != null) {
         for(var5 = 0; var5 < this.afterRotatePlayerHooks.length; ++var5) {
            this.afterRotatePlayerHooks[var5].afterRotatePlayer(var1, var2, var3, var4);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenRotatePlayer(RenderPlayerBase var1) {
      if(this.overrideRotatePlayerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideRotatePlayerHooks.length; ++var2) {
            if(this.overrideRotatePlayerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideRotatePlayerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static int setArmorModel(IRenderPlayerAPI var0, AbstractClientPlayer var1, int var2, float var3) {
      RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
      int var4;
      if(var5 != null && var5.isSetArmorModelModded) {
         var4 = var5.setArmorModel(var1, var2, var3);
      } else {
         var4 = var0.localSetArmorModel(var1, var2, var3);
      }

      return var4;
   }

   private int setArmorModel(AbstractClientPlayer var1, int var2, float var3) {
      int var4;
      if(this.beforeSetArmorModelHooks != null) {
         for(var4 = this.beforeSetArmorModelHooks.length - 1; var4 >= 0; --var4) {
            this.beforeSetArmorModelHooks[var4].beforeSetArmorModel(var1, var2, var3);
         }
      }

      if(this.overrideSetArmorModelHooks != null) {
         var4 = this.overrideSetArmorModelHooks[this.overrideSetArmorModelHooks.length - 1].setArmorModel(var1, var2, var3);
      } else {
         var4 = this.renderPlayer.localSetArmorModel(var1, var2, var3);
      }

      if(this.afterSetArmorModelHooks != null) {
         for(int var5 = 0; var5 < this.afterSetArmorModelHooks.length; ++var5) {
            this.afterSetArmorModelHooks[var5].afterSetArmorModel(var1, var2, var3);
         }
      }

      return var4;
   }

   protected RenderPlayerBase GetOverwrittenSetArmorModel(RenderPlayerBase var1) {
      if(this.overrideSetArmorModelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetArmorModelHooks.length; ++var2) {
            if(this.overrideSetArmorModelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetArmorModelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setPassArmorModel(IRenderPlayerAPI var0, AbstractClientPlayer var1, int var2, float var3) {
      RenderPlayerAPI var4 = var0.getRenderPlayerAPI();
      if(var4 != null && var4.isSetPassArmorModelModded) {
         var4.setPassArmorModel(var1, var2, var3);
      } else {
         var0.localSetPassArmorModel(var1, var2, var3);
      }

   }

   private void setPassArmorModel(AbstractClientPlayer var1, int var2, float var3) {
      int var4;
      if(this.beforeSetPassArmorModelHooks != null) {
         for(var4 = this.beforeSetPassArmorModelHooks.length - 1; var4 >= 0; --var4) {
            this.beforeSetPassArmorModelHooks[var4].beforeSetPassArmorModel(var1, var2, var3);
         }
      }

      if(this.overrideSetPassArmorModelHooks != null) {
         this.overrideSetPassArmorModelHooks[this.overrideSetPassArmorModelHooks.length - 1].setPassArmorModel(var1, var2, var3);
      } else {
         this.renderPlayer.localSetPassArmorModel(var1, var2, var3);
      }

      if(this.afterSetPassArmorModelHooks != null) {
         for(var4 = 0; var4 < this.afterSetPassArmorModelHooks.length; ++var4) {
            this.afterSetPassArmorModelHooks[var4].afterSetPassArmorModel(var1, var2, var3);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenSetPassArmorModel(RenderPlayerBase var1) {
      if(this.overrideSetPassArmorModelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetPassArmorModelHooks.length; ++var2) {
            if(this.overrideSetPassArmorModelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetPassArmorModelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setRenderManager(IRenderPlayerAPI var0, RenderManager var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      if(var2 != null && var2.isSetRenderManagerModded) {
         var2.setRenderManager(var1);
      } else {
         var0.localSetRenderManager(var1);
      }

   }

   private void setRenderManager(RenderManager var1) {
      int var2;
      if(this.beforeSetRenderManagerHooks != null) {
         for(var2 = this.beforeSetRenderManagerHooks.length - 1; var2 >= 0; --var2) {
            this.beforeSetRenderManagerHooks[var2].beforeSetRenderManager(var1);
         }
      }

      if(this.overrideSetRenderManagerHooks != null) {
         this.overrideSetRenderManagerHooks[this.overrideSetRenderManagerHooks.length - 1].setRenderManager(var1);
      } else {
         this.renderPlayer.localSetRenderManager(var1);
      }

      if(this.afterSetRenderManagerHooks != null) {
         for(var2 = 0; var2 < this.afterSetRenderManagerHooks.length; ++var2) {
            this.afterSetRenderManagerHooks[var2].afterSetRenderManager(var1);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenSetRenderManager(RenderPlayerBase var1) {
      if(this.overrideSetRenderManagerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetRenderManagerHooks.length; ++var2) {
            if(this.overrideSetRenderManagerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetRenderManagerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setRenderPassModel(IRenderPlayerAPI var0, ModelBase var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      if(var2 != null && var2.isSetRenderPassModelModded) {
         var2.setRenderPassModel(var1);
      } else {
         var0.localSetRenderPassModel(var1);
      }

   }

   private void setRenderPassModel(ModelBase var1) {
      int var2;
      if(this.beforeSetRenderPassModelHooks != null) {
         for(var2 = this.beforeSetRenderPassModelHooks.length - 1; var2 >= 0; --var2) {
            this.beforeSetRenderPassModelHooks[var2].beforeSetRenderPassModel(var1);
         }
      }

      if(this.overrideSetRenderPassModelHooks != null) {
         this.overrideSetRenderPassModelHooks[this.overrideSetRenderPassModelHooks.length - 1].setRenderPassModel(var1);
      } else {
         this.renderPlayer.localSetRenderPassModel(var1);
      }

      if(this.afterSetRenderPassModelHooks != null) {
         for(var2 = 0; var2 < this.afterSetRenderPassModelHooks.length; ++var2) {
            this.afterSetRenderPassModelHooks[var2].afterSetRenderPassModel(var1);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenSetRenderPassModel(RenderPlayerBase var1) {
      if(this.overrideSetRenderPassModelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetRenderPassModelHooks.length; ++var2) {
            if(this.overrideSetRenderPassModelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetRenderPassModelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void updateIcons(IRenderPlayerAPI var0, IIconRegister var1) {
      RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
      if(var2 != null && var2.isUpdateIconsModded) {
         var2.updateIcons(var1);
      } else {
         var0.localUpdateIcons(var1);
      }

   }

   private void updateIcons(IIconRegister var1) {
      int var2;
      if(this.beforeUpdateIconsHooks != null) {
         for(var2 = this.beforeUpdateIconsHooks.length - 1; var2 >= 0; --var2) {
            this.beforeUpdateIconsHooks[var2].beforeUpdateIcons(var1);
         }
      }

      if(this.overrideUpdateIconsHooks != null) {
         this.overrideUpdateIconsHooks[this.overrideUpdateIconsHooks.length - 1].updateIcons(var1);
      } else {
         this.renderPlayer.localUpdateIcons(var1);
      }

      if(this.afterUpdateIconsHooks != null) {
         for(var2 = 0; var2 < this.afterUpdateIconsHooks.length; ++var2) {
            this.afterUpdateIconsHooks[var2].afterUpdateIcons(var1);
         }
      }

   }

   protected RenderPlayerBase GetOverwrittenUpdateIcons(RenderPlayerBase var1) {
      if(this.overrideUpdateIconsHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideUpdateIconsHooks.length; ++var2) {
            if(this.overrideUpdateIconsHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideUpdateIconsHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

}
