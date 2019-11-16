package api.player.server;

import java.util.HashMap;
import java.util.Map;

public final class ServerPlayerBaseSorting {

   private String[] beforeLocalConstructingSuperiors = null;
   private String[] beforeLocalConstructingInferiors = null;
   private String[] afterLocalConstructingSuperiors = null;
   private String[] afterLocalConstructingInferiors = null;
   private Map dynamicBeforeSuperiors = null;
   private Map dynamicBeforeInferiors = null;
   private Map dynamicOverrideSuperiors = null;
   private Map dynamicOverrideInferiors = null;
   private Map dynamicAfterSuperiors = null;
   private Map dynamicAfterInferiors = null;
   private String[] beforeAddExhaustionSuperiors = null;
   private String[] beforeAddExhaustionInferiors = null;
   private String[] overrideAddExhaustionSuperiors = null;
   private String[] overrideAddExhaustionInferiors = null;
   private String[] afterAddExhaustionSuperiors = null;
   private String[] afterAddExhaustionInferiors = null;
   private String[] beforeAddExperienceSuperiors = null;
   private String[] beforeAddExperienceInferiors = null;
   private String[] overrideAddExperienceSuperiors = null;
   private String[] overrideAddExperienceInferiors = null;
   private String[] afterAddExperienceSuperiors = null;
   private String[] afterAddExperienceInferiors = null;
   private String[] beforeAddExperienceLevelSuperiors = null;
   private String[] beforeAddExperienceLevelInferiors = null;
   private String[] overrideAddExperienceLevelSuperiors = null;
   private String[] overrideAddExperienceLevelInferiors = null;
   private String[] afterAddExperienceLevelSuperiors = null;
   private String[] afterAddExperienceLevelInferiors = null;
   private String[] beforeAddMovementStatSuperiors = null;
   private String[] beforeAddMovementStatInferiors = null;
   private String[] overrideAddMovementStatSuperiors = null;
   private String[] overrideAddMovementStatInferiors = null;
   private String[] afterAddMovementStatSuperiors = null;
   private String[] afterAddMovementStatInferiors = null;
   private String[] beforeAttackEntityFromSuperiors = null;
   private String[] beforeAttackEntityFromInferiors = null;
   private String[] overrideAttackEntityFromSuperiors = null;
   private String[] overrideAttackEntityFromInferiors = null;
   private String[] afterAttackEntityFromSuperiors = null;
   private String[] afterAttackEntityFromInferiors = null;
   private String[] beforeAttackTargetEntityWithCurrentItemSuperiors = null;
   private String[] beforeAttackTargetEntityWithCurrentItemInferiors = null;
   private String[] overrideAttackTargetEntityWithCurrentItemSuperiors = null;
   private String[] overrideAttackTargetEntityWithCurrentItemInferiors = null;
   private String[] afterAttackTargetEntityWithCurrentItemSuperiors = null;
   private String[] afterAttackTargetEntityWithCurrentItemInferiors = null;
   private String[] beforeCanBreatheUnderwaterSuperiors = null;
   private String[] beforeCanBreatheUnderwaterInferiors = null;
   private String[] overrideCanBreatheUnderwaterSuperiors = null;
   private String[] overrideCanBreatheUnderwaterInferiors = null;
   private String[] afterCanBreatheUnderwaterSuperiors = null;
   private String[] afterCanBreatheUnderwaterInferiors = null;
   private String[] beforeCanHarvestBlockSuperiors = null;
   private String[] beforeCanHarvestBlockInferiors = null;
   private String[] overrideCanHarvestBlockSuperiors = null;
   private String[] overrideCanHarvestBlockInferiors = null;
   private String[] afterCanHarvestBlockSuperiors = null;
   private String[] afterCanHarvestBlockInferiors = null;
   private String[] beforeCanPlayerEditSuperiors = null;
   private String[] beforeCanPlayerEditInferiors = null;
   private String[] overrideCanPlayerEditSuperiors = null;
   private String[] overrideCanPlayerEditInferiors = null;
   private String[] afterCanPlayerEditSuperiors = null;
   private String[] afterCanPlayerEditInferiors = null;
   private String[] beforeCanTriggerWalkingSuperiors = null;
   private String[] beforeCanTriggerWalkingInferiors = null;
   private String[] overrideCanTriggerWalkingSuperiors = null;
   private String[] overrideCanTriggerWalkingInferiors = null;
   private String[] afterCanTriggerWalkingSuperiors = null;
   private String[] afterCanTriggerWalkingInferiors = null;
   private String[] beforeClonePlayerSuperiors = null;
   private String[] beforeClonePlayerInferiors = null;
   private String[] overrideClonePlayerSuperiors = null;
   private String[] overrideClonePlayerInferiors = null;
   private String[] afterClonePlayerSuperiors = null;
   private String[] afterClonePlayerInferiors = null;
   private String[] beforeDamageEntitySuperiors = null;
   private String[] beforeDamageEntityInferiors = null;
   private String[] overrideDamageEntitySuperiors = null;
   private String[] overrideDamageEntityInferiors = null;
   private String[] afterDamageEntitySuperiors = null;
   private String[] afterDamageEntityInferiors = null;
   private String[] beforeDisplayGUIChestSuperiors = null;
   private String[] beforeDisplayGUIChestInferiors = null;
   private String[] overrideDisplayGUIChestSuperiors = null;
   private String[] overrideDisplayGUIChestInferiors = null;
   private String[] afterDisplayGUIChestSuperiors = null;
   private String[] afterDisplayGUIChestInferiors = null;
   private String[] beforeDisplayGUIDispenserSuperiors = null;
   private String[] beforeDisplayGUIDispenserInferiors = null;
   private String[] overrideDisplayGUIDispenserSuperiors = null;
   private String[] overrideDisplayGUIDispenserInferiors = null;
   private String[] afterDisplayGUIDispenserSuperiors = null;
   private String[] afterDisplayGUIDispenserInferiors = null;
   private String[] beforeDisplayGUIFurnaceSuperiors = null;
   private String[] beforeDisplayGUIFurnaceInferiors = null;
   private String[] overrideDisplayGUIFurnaceSuperiors = null;
   private String[] overrideDisplayGUIFurnaceInferiors = null;
   private String[] afterDisplayGUIFurnaceSuperiors = null;
   private String[] afterDisplayGUIFurnaceInferiors = null;
   private String[] beforeDisplayGUIWorkbenchSuperiors = null;
   private String[] beforeDisplayGUIWorkbenchInferiors = null;
   private String[] overrideDisplayGUIWorkbenchSuperiors = null;
   private String[] overrideDisplayGUIWorkbenchInferiors = null;
   private String[] afterDisplayGUIWorkbenchSuperiors = null;
   private String[] afterDisplayGUIWorkbenchInferiors = null;
   private String[] beforeDropOneItemSuperiors = null;
   private String[] beforeDropOneItemInferiors = null;
   private String[] overrideDropOneItemSuperiors = null;
   private String[] overrideDropOneItemInferiors = null;
   private String[] afterDropOneItemSuperiors = null;
   private String[] afterDropOneItemInferiors = null;
   private String[] beforeDropPlayerItemSuperiors = null;
   private String[] beforeDropPlayerItemInferiors = null;
   private String[] overrideDropPlayerItemSuperiors = null;
   private String[] overrideDropPlayerItemInferiors = null;
   private String[] afterDropPlayerItemSuperiors = null;
   private String[] afterDropPlayerItemInferiors = null;
   private String[] beforeFallSuperiors = null;
   private String[] beforeFallInferiors = null;
   private String[] overrideFallSuperiors = null;
   private String[] overrideFallInferiors = null;
   private String[] afterFallSuperiors = null;
   private String[] afterFallInferiors = null;
   private String[] beforeGetAIMoveSpeedSuperiors = null;
   private String[] beforeGetAIMoveSpeedInferiors = null;
   private String[] overrideGetAIMoveSpeedSuperiors = null;
   private String[] overrideGetAIMoveSpeedInferiors = null;
   private String[] afterGetAIMoveSpeedSuperiors = null;
   private String[] afterGetAIMoveSpeedInferiors = null;
   private String[] beforeGetCurrentPlayerStrVsBlockSuperiors = null;
   private String[] beforeGetCurrentPlayerStrVsBlockInferiors = null;
   private String[] overrideGetCurrentPlayerStrVsBlockSuperiors = null;
   private String[] overrideGetCurrentPlayerStrVsBlockInferiors = null;
   private String[] afterGetCurrentPlayerStrVsBlockSuperiors = null;
   private String[] afterGetCurrentPlayerStrVsBlockInferiors = null;
   private String[] beforeGetCurrentPlayerStrVsBlockForgeSuperiors = null;
   private String[] beforeGetCurrentPlayerStrVsBlockForgeInferiors = null;
   private String[] overrideGetCurrentPlayerStrVsBlockForgeSuperiors = null;
   private String[] overrideGetCurrentPlayerStrVsBlockForgeInferiors = null;
   private String[] afterGetCurrentPlayerStrVsBlockForgeSuperiors = null;
   private String[] afterGetCurrentPlayerStrVsBlockForgeInferiors = null;
   private String[] beforeGetDistanceSqSuperiors = null;
   private String[] beforeGetDistanceSqInferiors = null;
   private String[] overrideGetDistanceSqSuperiors = null;
   private String[] overrideGetDistanceSqInferiors = null;
   private String[] afterGetDistanceSqSuperiors = null;
   private String[] afterGetDistanceSqInferiors = null;
   private String[] beforeGetBrightnessSuperiors = null;
   private String[] beforeGetBrightnessInferiors = null;
   private String[] overrideGetBrightnessSuperiors = null;
   private String[] overrideGetBrightnessInferiors = null;
   private String[] afterGetBrightnessSuperiors = null;
   private String[] afterGetBrightnessInferiors = null;
   private String[] beforeGetEyeHeightSuperiors = null;
   private String[] beforeGetEyeHeightInferiors = null;
   private String[] overrideGetEyeHeightSuperiors = null;
   private String[] overrideGetEyeHeightInferiors = null;
   private String[] afterGetEyeHeightSuperiors = null;
   private String[] afterGetEyeHeightInferiors = null;
   private String[] beforeHealSuperiors = null;
   private String[] beforeHealInferiors = null;
   private String[] overrideHealSuperiors = null;
   private String[] overrideHealInferiors = null;
   private String[] afterHealSuperiors = null;
   private String[] afterHealInferiors = null;
   private String[] beforeIsEntityInsideOpaqueBlockSuperiors = null;
   private String[] beforeIsEntityInsideOpaqueBlockInferiors = null;
   private String[] overrideIsEntityInsideOpaqueBlockSuperiors = null;
   private String[] overrideIsEntityInsideOpaqueBlockInferiors = null;
   private String[] afterIsEntityInsideOpaqueBlockSuperiors = null;
   private String[] afterIsEntityInsideOpaqueBlockInferiors = null;
   private String[] beforeIsInWaterSuperiors = null;
   private String[] beforeIsInWaterInferiors = null;
   private String[] overrideIsInWaterSuperiors = null;
   private String[] overrideIsInWaterInferiors = null;
   private String[] afterIsInWaterSuperiors = null;
   private String[] afterIsInWaterInferiors = null;
   private String[] beforeIsInsideOfMaterialSuperiors = null;
   private String[] beforeIsInsideOfMaterialInferiors = null;
   private String[] overrideIsInsideOfMaterialSuperiors = null;
   private String[] overrideIsInsideOfMaterialInferiors = null;
   private String[] afterIsInsideOfMaterialSuperiors = null;
   private String[] afterIsInsideOfMaterialInferiors = null;
   private String[] beforeIsOnLadderSuperiors = null;
   private String[] beforeIsOnLadderInferiors = null;
   private String[] overrideIsOnLadderSuperiors = null;
   private String[] overrideIsOnLadderInferiors = null;
   private String[] afterIsOnLadderSuperiors = null;
   private String[] afterIsOnLadderInferiors = null;
   private String[] beforeIsPlayerSleepingSuperiors = null;
   private String[] beforeIsPlayerSleepingInferiors = null;
   private String[] overrideIsPlayerSleepingSuperiors = null;
   private String[] overrideIsPlayerSleepingInferiors = null;
   private String[] afterIsPlayerSleepingSuperiors = null;
   private String[] afterIsPlayerSleepingInferiors = null;
   private String[] beforeIsSneakingSuperiors = null;
   private String[] beforeIsSneakingInferiors = null;
   private String[] overrideIsSneakingSuperiors = null;
   private String[] overrideIsSneakingInferiors = null;
   private String[] afterIsSneakingSuperiors = null;
   private String[] afterIsSneakingInferiors = null;
   private String[] beforeJumpSuperiors = null;
   private String[] beforeJumpInferiors = null;
   private String[] overrideJumpSuperiors = null;
   private String[] overrideJumpInferiors = null;
   private String[] afterJumpSuperiors = null;
   private String[] afterJumpInferiors = null;
   private String[] beforeKnockBackSuperiors = null;
   private String[] beforeKnockBackInferiors = null;
   private String[] overrideKnockBackSuperiors = null;
   private String[] overrideKnockBackInferiors = null;
   private String[] afterKnockBackSuperiors = null;
   private String[] afterKnockBackInferiors = null;
   private String[] beforeMountEntitySuperiors = null;
   private String[] beforeMountEntityInferiors = null;
   private String[] overrideMountEntitySuperiors = null;
   private String[] overrideMountEntityInferiors = null;
   private String[] afterMountEntitySuperiors = null;
   private String[] afterMountEntityInferiors = null;
   private String[] beforeMoveEntitySuperiors = null;
   private String[] beforeMoveEntityInferiors = null;
   private String[] overrideMoveEntitySuperiors = null;
   private String[] overrideMoveEntityInferiors = null;
   private String[] afterMoveEntitySuperiors = null;
   private String[] afterMoveEntityInferiors = null;
   private String[] beforeMoveEntityWithHeadingSuperiors = null;
   private String[] beforeMoveEntityWithHeadingInferiors = null;
   private String[] overrideMoveEntityWithHeadingSuperiors = null;
   private String[] overrideMoveEntityWithHeadingInferiors = null;
   private String[] afterMoveEntityWithHeadingSuperiors = null;
   private String[] afterMoveEntityWithHeadingInferiors = null;
   private String[] beforeMoveFlyingSuperiors = null;
   private String[] beforeMoveFlyingInferiors = null;
   private String[] overrideMoveFlyingSuperiors = null;
   private String[] overrideMoveFlyingInferiors = null;
   private String[] afterMoveFlyingSuperiors = null;
   private String[] afterMoveFlyingInferiors = null;
   private String[] beforeOnDeathSuperiors = null;
   private String[] beforeOnDeathInferiors = null;
   private String[] overrideOnDeathSuperiors = null;
   private String[] overrideOnDeathInferiors = null;
   private String[] afterOnDeathSuperiors = null;
   private String[] afterOnDeathInferiors = null;
   private String[] beforeOnLivingUpdateSuperiors = null;
   private String[] beforeOnLivingUpdateInferiors = null;
   private String[] overrideOnLivingUpdateSuperiors = null;
   private String[] overrideOnLivingUpdateInferiors = null;
   private String[] afterOnLivingUpdateSuperiors = null;
   private String[] afterOnLivingUpdateInferiors = null;
   private String[] beforeOnKillEntitySuperiors = null;
   private String[] beforeOnKillEntityInferiors = null;
   private String[] overrideOnKillEntitySuperiors = null;
   private String[] overrideOnKillEntityInferiors = null;
   private String[] afterOnKillEntitySuperiors = null;
   private String[] afterOnKillEntityInferiors = null;
   private String[] beforeOnStruckByLightningSuperiors = null;
   private String[] beforeOnStruckByLightningInferiors = null;
   private String[] overrideOnStruckByLightningSuperiors = null;
   private String[] overrideOnStruckByLightningInferiors = null;
   private String[] afterOnStruckByLightningSuperiors = null;
   private String[] afterOnStruckByLightningInferiors = null;
   private String[] beforeOnUpdateSuperiors = null;
   private String[] beforeOnUpdateInferiors = null;
   private String[] overrideOnUpdateSuperiors = null;
   private String[] overrideOnUpdateInferiors = null;
   private String[] afterOnUpdateSuperiors = null;
   private String[] afterOnUpdateInferiors = null;
   private String[] beforeOnUpdateEntitySuperiors = null;
   private String[] beforeOnUpdateEntityInferiors = null;
   private String[] overrideOnUpdateEntitySuperiors = null;
   private String[] overrideOnUpdateEntityInferiors = null;
   private String[] afterOnUpdateEntitySuperiors = null;
   private String[] afterOnUpdateEntityInferiors = null;
   private String[] beforeReadEntityFromNBTSuperiors = null;
   private String[] beforeReadEntityFromNBTInferiors = null;
   private String[] overrideReadEntityFromNBTSuperiors = null;
   private String[] overrideReadEntityFromNBTInferiors = null;
   private String[] afterReadEntityFromNBTSuperiors = null;
   private String[] afterReadEntityFromNBTInferiors = null;
   private String[] beforeSetDeadSuperiors = null;
   private String[] beforeSetDeadInferiors = null;
   private String[] overrideSetDeadSuperiors = null;
   private String[] overrideSetDeadInferiors = null;
   private String[] afterSetDeadSuperiors = null;
   private String[] afterSetDeadInferiors = null;
   private String[] beforeSetEntityActionStateSuperiors = null;
   private String[] beforeSetEntityActionStateInferiors = null;
   private String[] overrideSetEntityActionStateSuperiors = null;
   private String[] overrideSetEntityActionStateInferiors = null;
   private String[] afterSetEntityActionStateSuperiors = null;
   private String[] afterSetEntityActionStateInferiors = null;
   private String[] beforeSetPositionSuperiors = null;
   private String[] beforeSetPositionInferiors = null;
   private String[] overrideSetPositionSuperiors = null;
   private String[] overrideSetPositionInferiors = null;
   private String[] afterSetPositionSuperiors = null;
   private String[] afterSetPositionInferiors = null;
   private String[] beforeSetSneakingSuperiors = null;
   private String[] beforeSetSneakingInferiors = null;
   private String[] overrideSetSneakingSuperiors = null;
   private String[] overrideSetSneakingInferiors = null;
   private String[] afterSetSneakingSuperiors = null;
   private String[] afterSetSneakingInferiors = null;
   private String[] beforeSetSprintingSuperiors = null;
   private String[] beforeSetSprintingInferiors = null;
   private String[] overrideSetSprintingSuperiors = null;
   private String[] overrideSetSprintingInferiors = null;
   private String[] afterSetSprintingSuperiors = null;
   private String[] afterSetSprintingInferiors = null;
   private String[] beforeSwingItemSuperiors = null;
   private String[] beforeSwingItemInferiors = null;
   private String[] overrideSwingItemSuperiors = null;
   private String[] overrideSwingItemInferiors = null;
   private String[] afterSwingItemSuperiors = null;
   private String[] afterSwingItemInferiors = null;
   private String[] beforeUpdateEntityActionStateSuperiors = null;
   private String[] beforeUpdateEntityActionStateInferiors = null;
   private String[] overrideUpdateEntityActionStateSuperiors = null;
   private String[] overrideUpdateEntityActionStateInferiors = null;
   private String[] afterUpdateEntityActionStateSuperiors = null;
   private String[] afterUpdateEntityActionStateInferiors = null;
   private String[] beforeUpdatePotionEffectsSuperiors = null;
   private String[] beforeUpdatePotionEffectsInferiors = null;
   private String[] overrideUpdatePotionEffectsSuperiors = null;
   private String[] overrideUpdatePotionEffectsInferiors = null;
   private String[] afterUpdatePotionEffectsSuperiors = null;
   private String[] afterUpdatePotionEffectsInferiors = null;
   private String[] beforeUpdateRiddenSuperiors = null;
   private String[] beforeUpdateRiddenInferiors = null;
   private String[] overrideUpdateRiddenSuperiors = null;
   private String[] overrideUpdateRiddenInferiors = null;
   private String[] afterUpdateRiddenSuperiors = null;
   private String[] afterUpdateRiddenInferiors = null;
   private String[] beforeWakeUpPlayerSuperiors = null;
   private String[] beforeWakeUpPlayerInferiors = null;
   private String[] overrideWakeUpPlayerSuperiors = null;
   private String[] overrideWakeUpPlayerInferiors = null;
   private String[] afterWakeUpPlayerSuperiors = null;
   private String[] afterWakeUpPlayerInferiors = null;
   private String[] beforeWriteEntityToNBTSuperiors = null;
   private String[] beforeWriteEntityToNBTInferiors = null;
   private String[] overrideWriteEntityToNBTSuperiors = null;
   private String[] overrideWriteEntityToNBTInferiors = null;
   private String[] afterWriteEntityToNBTSuperiors = null;
   private String[] afterWriteEntityToNBTInferiors = null;


   public String[] getBeforeLocalConstructingSuperiors() {
      return this.beforeLocalConstructingSuperiors;
   }

   public String[] getBeforeLocalConstructingInferiors() {
      return this.beforeLocalConstructingInferiors;
   }

   public String[] getAfterLocalConstructingSuperiors() {
      return this.afterLocalConstructingSuperiors;
   }

   public String[] getAfterLocalConstructingInferiors() {
      return this.afterLocalConstructingInferiors;
   }

   public void setBeforeLocalConstructingSuperiors(String[] var1) {
      this.beforeLocalConstructingSuperiors = var1;
   }

   public void setBeforeLocalConstructingInferiors(String[] var1) {
      this.beforeLocalConstructingInferiors = var1;
   }

   public void setAfterLocalConstructingSuperiors(String[] var1) {
      this.afterLocalConstructingSuperiors = var1;
   }

   public void setAfterLocalConstructingInferiors(String[] var1) {
      this.afterLocalConstructingInferiors = var1;
   }

   public Map getDynamicBeforeSuperiors() {
      return this.dynamicBeforeSuperiors;
   }

   public Map getDynamicBeforeInferiors() {
      return this.dynamicBeforeInferiors;
   }

   public Map getDynamicOverrideSuperiors() {
      return this.dynamicOverrideSuperiors;
   }

   public Map getDynamicOverrideInferiors() {
      return this.dynamicOverrideInferiors;
   }

   public Map getDynamicAfterSuperiors() {
      return this.dynamicAfterSuperiors;
   }

   public Map getDynamicAfterInferiors() {
      return this.dynamicAfterInferiors;
   }

   public void setDynamicBeforeSuperiors(String var1, String[] var2) {
      this.dynamicBeforeSuperiors = this.setDynamic(var1, var2, this.dynamicBeforeSuperiors);
   }

   public void setDynamicBeforeInferiors(String var1, String[] var2) {
      this.dynamicBeforeInferiors = this.setDynamic(var1, var2, this.dynamicBeforeInferiors);
   }

   public void setDynamicOverrideSuperiors(String var1, String[] var2) {
      this.dynamicOverrideSuperiors = this.setDynamic(var1, var2, this.dynamicOverrideSuperiors);
   }

   public void setDynamicOverrideInferiors(String var1, String[] var2) {
      this.dynamicOverrideInferiors = this.setDynamic(var1, var2, this.dynamicOverrideInferiors);
   }

   public void setDynamicAfterSuperiors(String var1, String[] var2) {
      this.dynamicAfterSuperiors = this.setDynamic(var1, var2, this.dynamicAfterSuperiors);
   }

   public void setDynamicAfterInferiors(String var1, String[] var2) {
      this.dynamicAfterInferiors = this.setDynamic(var1, var2, this.dynamicAfterInferiors);
   }

   private Map setDynamic(String var1, String[] var2, Map var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Parameter \'name\' may not be null");
      } else if(var2 == null) {
         if(var3 != null) {
            ((Map)var3).remove(var1);
         }

         return (Map)var3;
      } else {
         if(var3 == null) {
            var3 = new HashMap();
         }

         ((Map)var3).put(var1, var2);
         return (Map)var3;
      }
   }

   public String[] getBeforeAddExhaustionSuperiors() {
      return this.beforeAddExhaustionSuperiors;
   }

   public String[] getBeforeAddExhaustionInferiors() {
      return this.beforeAddExhaustionInferiors;
   }

   public String[] getOverrideAddExhaustionSuperiors() {
      return this.overrideAddExhaustionSuperiors;
   }

   public String[] getOverrideAddExhaustionInferiors() {
      return this.overrideAddExhaustionInferiors;
   }

   public String[] getAfterAddExhaustionSuperiors() {
      return this.afterAddExhaustionSuperiors;
   }

   public String[] getAfterAddExhaustionInferiors() {
      return this.afterAddExhaustionInferiors;
   }

   public void setBeforeAddExhaustionSuperiors(String[] var1) {
      this.beforeAddExhaustionSuperiors = var1;
   }

   public void setBeforeAddExhaustionInferiors(String[] var1) {
      this.beforeAddExhaustionInferiors = var1;
   }

   public void setOverrideAddExhaustionSuperiors(String[] var1) {
      this.overrideAddExhaustionSuperiors = var1;
   }

   public void setOverrideAddExhaustionInferiors(String[] var1) {
      this.overrideAddExhaustionInferiors = var1;
   }

   public void setAfterAddExhaustionSuperiors(String[] var1) {
      this.afterAddExhaustionSuperiors = var1;
   }

   public void setAfterAddExhaustionInferiors(String[] var1) {
      this.afterAddExhaustionInferiors = var1;
   }

   public String[] getBeforeAddExperienceSuperiors() {
      return this.beforeAddExperienceSuperiors;
   }

   public String[] getBeforeAddExperienceInferiors() {
      return this.beforeAddExperienceInferiors;
   }

   public String[] getOverrideAddExperienceSuperiors() {
      return this.overrideAddExperienceSuperiors;
   }

   public String[] getOverrideAddExperienceInferiors() {
      return this.overrideAddExperienceInferiors;
   }

   public String[] getAfterAddExperienceSuperiors() {
      return this.afterAddExperienceSuperiors;
   }

   public String[] getAfterAddExperienceInferiors() {
      return this.afterAddExperienceInferiors;
   }

   public void setBeforeAddExperienceSuperiors(String[] var1) {
      this.beforeAddExperienceSuperiors = var1;
   }

   public void setBeforeAddExperienceInferiors(String[] var1) {
      this.beforeAddExperienceInferiors = var1;
   }

   public void setOverrideAddExperienceSuperiors(String[] var1) {
      this.overrideAddExperienceSuperiors = var1;
   }

   public void setOverrideAddExperienceInferiors(String[] var1) {
      this.overrideAddExperienceInferiors = var1;
   }

   public void setAfterAddExperienceSuperiors(String[] var1) {
      this.afterAddExperienceSuperiors = var1;
   }

   public void setAfterAddExperienceInferiors(String[] var1) {
      this.afterAddExperienceInferiors = var1;
   }

   public String[] getBeforeAddExperienceLevelSuperiors() {
      return this.beforeAddExperienceLevelSuperiors;
   }

   public String[] getBeforeAddExperienceLevelInferiors() {
      return this.beforeAddExperienceLevelInferiors;
   }

   public String[] getOverrideAddExperienceLevelSuperiors() {
      return this.overrideAddExperienceLevelSuperiors;
   }

   public String[] getOverrideAddExperienceLevelInferiors() {
      return this.overrideAddExperienceLevelInferiors;
   }

   public String[] getAfterAddExperienceLevelSuperiors() {
      return this.afterAddExperienceLevelSuperiors;
   }

   public String[] getAfterAddExperienceLevelInferiors() {
      return this.afterAddExperienceLevelInferiors;
   }

   public void setBeforeAddExperienceLevelSuperiors(String[] var1) {
      this.beforeAddExperienceLevelSuperiors = var1;
   }

   public void setBeforeAddExperienceLevelInferiors(String[] var1) {
      this.beforeAddExperienceLevelInferiors = var1;
   }

   public void setOverrideAddExperienceLevelSuperiors(String[] var1) {
      this.overrideAddExperienceLevelSuperiors = var1;
   }

   public void setOverrideAddExperienceLevelInferiors(String[] var1) {
      this.overrideAddExperienceLevelInferiors = var1;
   }

   public void setAfterAddExperienceLevelSuperiors(String[] var1) {
      this.afterAddExperienceLevelSuperiors = var1;
   }

   public void setAfterAddExperienceLevelInferiors(String[] var1) {
      this.afterAddExperienceLevelInferiors = var1;
   }

   public String[] getBeforeAddMovementStatSuperiors() {
      return this.beforeAddMovementStatSuperiors;
   }

   public String[] getBeforeAddMovementStatInferiors() {
      return this.beforeAddMovementStatInferiors;
   }

   public String[] getOverrideAddMovementStatSuperiors() {
      return this.overrideAddMovementStatSuperiors;
   }

   public String[] getOverrideAddMovementStatInferiors() {
      return this.overrideAddMovementStatInferiors;
   }

   public String[] getAfterAddMovementStatSuperiors() {
      return this.afterAddMovementStatSuperiors;
   }

   public String[] getAfterAddMovementStatInferiors() {
      return this.afterAddMovementStatInferiors;
   }

   public void setBeforeAddMovementStatSuperiors(String[] var1) {
      this.beforeAddMovementStatSuperiors = var1;
   }

   public void setBeforeAddMovementStatInferiors(String[] var1) {
      this.beforeAddMovementStatInferiors = var1;
   }

   public void setOverrideAddMovementStatSuperiors(String[] var1) {
      this.overrideAddMovementStatSuperiors = var1;
   }

   public void setOverrideAddMovementStatInferiors(String[] var1) {
      this.overrideAddMovementStatInferiors = var1;
   }

   public void setAfterAddMovementStatSuperiors(String[] var1) {
      this.afterAddMovementStatSuperiors = var1;
   }

   public void setAfterAddMovementStatInferiors(String[] var1) {
      this.afterAddMovementStatInferiors = var1;
   }

   public String[] getBeforeAttackEntityFromSuperiors() {
      return this.beforeAttackEntityFromSuperiors;
   }

   public String[] getBeforeAttackEntityFromInferiors() {
      return this.beforeAttackEntityFromInferiors;
   }

   public String[] getOverrideAttackEntityFromSuperiors() {
      return this.overrideAttackEntityFromSuperiors;
   }

   public String[] getOverrideAttackEntityFromInferiors() {
      return this.overrideAttackEntityFromInferiors;
   }

   public String[] getAfterAttackEntityFromSuperiors() {
      return this.afterAttackEntityFromSuperiors;
   }

   public String[] getAfterAttackEntityFromInferiors() {
      return this.afterAttackEntityFromInferiors;
   }

   public void setBeforeAttackEntityFromSuperiors(String[] var1) {
      this.beforeAttackEntityFromSuperiors = var1;
   }

   public void setBeforeAttackEntityFromInferiors(String[] var1) {
      this.beforeAttackEntityFromInferiors = var1;
   }

   public void setOverrideAttackEntityFromSuperiors(String[] var1) {
      this.overrideAttackEntityFromSuperiors = var1;
   }

   public void setOverrideAttackEntityFromInferiors(String[] var1) {
      this.overrideAttackEntityFromInferiors = var1;
   }

   public void setAfterAttackEntityFromSuperiors(String[] var1) {
      this.afterAttackEntityFromSuperiors = var1;
   }

   public void setAfterAttackEntityFromInferiors(String[] var1) {
      this.afterAttackEntityFromInferiors = var1;
   }

   public String[] getBeforeAttackTargetEntityWithCurrentItemSuperiors() {
      return this.beforeAttackTargetEntityWithCurrentItemSuperiors;
   }

   public String[] getBeforeAttackTargetEntityWithCurrentItemInferiors() {
      return this.beforeAttackTargetEntityWithCurrentItemInferiors;
   }

   public String[] getOverrideAttackTargetEntityWithCurrentItemSuperiors() {
      return this.overrideAttackTargetEntityWithCurrentItemSuperiors;
   }

   public String[] getOverrideAttackTargetEntityWithCurrentItemInferiors() {
      return this.overrideAttackTargetEntityWithCurrentItemInferiors;
   }

   public String[] getAfterAttackTargetEntityWithCurrentItemSuperiors() {
      return this.afterAttackTargetEntityWithCurrentItemSuperiors;
   }

   public String[] getAfterAttackTargetEntityWithCurrentItemInferiors() {
      return this.afterAttackTargetEntityWithCurrentItemInferiors;
   }

   public void setBeforeAttackTargetEntityWithCurrentItemSuperiors(String[] var1) {
      this.beforeAttackTargetEntityWithCurrentItemSuperiors = var1;
   }

   public void setBeforeAttackTargetEntityWithCurrentItemInferiors(String[] var1) {
      this.beforeAttackTargetEntityWithCurrentItemInferiors = var1;
   }

   public void setOverrideAttackTargetEntityWithCurrentItemSuperiors(String[] var1) {
      this.overrideAttackTargetEntityWithCurrentItemSuperiors = var1;
   }

   public void setOverrideAttackTargetEntityWithCurrentItemInferiors(String[] var1) {
      this.overrideAttackTargetEntityWithCurrentItemInferiors = var1;
   }

   public void setAfterAttackTargetEntityWithCurrentItemSuperiors(String[] var1) {
      this.afterAttackTargetEntityWithCurrentItemSuperiors = var1;
   }

   public void setAfterAttackTargetEntityWithCurrentItemInferiors(String[] var1) {
      this.afterAttackTargetEntityWithCurrentItemInferiors = var1;
   }

   public String[] getBeforeCanBreatheUnderwaterSuperiors() {
      return this.beforeCanBreatheUnderwaterSuperiors;
   }

   public String[] getBeforeCanBreatheUnderwaterInferiors() {
      return this.beforeCanBreatheUnderwaterInferiors;
   }

   public String[] getOverrideCanBreatheUnderwaterSuperiors() {
      return this.overrideCanBreatheUnderwaterSuperiors;
   }

   public String[] getOverrideCanBreatheUnderwaterInferiors() {
      return this.overrideCanBreatheUnderwaterInferiors;
   }

   public String[] getAfterCanBreatheUnderwaterSuperiors() {
      return this.afterCanBreatheUnderwaterSuperiors;
   }

   public String[] getAfterCanBreatheUnderwaterInferiors() {
      return this.afterCanBreatheUnderwaterInferiors;
   }

   public void setBeforeCanBreatheUnderwaterSuperiors(String[] var1) {
      this.beforeCanBreatheUnderwaterSuperiors = var1;
   }

   public void setBeforeCanBreatheUnderwaterInferiors(String[] var1) {
      this.beforeCanBreatheUnderwaterInferiors = var1;
   }

   public void setOverrideCanBreatheUnderwaterSuperiors(String[] var1) {
      this.overrideCanBreatheUnderwaterSuperiors = var1;
   }

   public void setOverrideCanBreatheUnderwaterInferiors(String[] var1) {
      this.overrideCanBreatheUnderwaterInferiors = var1;
   }

   public void setAfterCanBreatheUnderwaterSuperiors(String[] var1) {
      this.afterCanBreatheUnderwaterSuperiors = var1;
   }

   public void setAfterCanBreatheUnderwaterInferiors(String[] var1) {
      this.afterCanBreatheUnderwaterInferiors = var1;
   }

   public String[] getBeforeCanHarvestBlockSuperiors() {
      return this.beforeCanHarvestBlockSuperiors;
   }

   public String[] getBeforeCanHarvestBlockInferiors() {
      return this.beforeCanHarvestBlockInferiors;
   }

   public String[] getOverrideCanHarvestBlockSuperiors() {
      return this.overrideCanHarvestBlockSuperiors;
   }

   public String[] getOverrideCanHarvestBlockInferiors() {
      return this.overrideCanHarvestBlockInferiors;
   }

   public String[] getAfterCanHarvestBlockSuperiors() {
      return this.afterCanHarvestBlockSuperiors;
   }

   public String[] getAfterCanHarvestBlockInferiors() {
      return this.afterCanHarvestBlockInferiors;
   }

   public void setBeforeCanHarvestBlockSuperiors(String[] var1) {
      this.beforeCanHarvestBlockSuperiors = var1;
   }

   public void setBeforeCanHarvestBlockInferiors(String[] var1) {
      this.beforeCanHarvestBlockInferiors = var1;
   }

   public void setOverrideCanHarvestBlockSuperiors(String[] var1) {
      this.overrideCanHarvestBlockSuperiors = var1;
   }

   public void setOverrideCanHarvestBlockInferiors(String[] var1) {
      this.overrideCanHarvestBlockInferiors = var1;
   }

   public void setAfterCanHarvestBlockSuperiors(String[] var1) {
      this.afterCanHarvestBlockSuperiors = var1;
   }

   public void setAfterCanHarvestBlockInferiors(String[] var1) {
      this.afterCanHarvestBlockInferiors = var1;
   }

   public String[] getBeforeCanPlayerEditSuperiors() {
      return this.beforeCanPlayerEditSuperiors;
   }

   public String[] getBeforeCanPlayerEditInferiors() {
      return this.beforeCanPlayerEditInferiors;
   }

   public String[] getOverrideCanPlayerEditSuperiors() {
      return this.overrideCanPlayerEditSuperiors;
   }

   public String[] getOverrideCanPlayerEditInferiors() {
      return this.overrideCanPlayerEditInferiors;
   }

   public String[] getAfterCanPlayerEditSuperiors() {
      return this.afterCanPlayerEditSuperiors;
   }

   public String[] getAfterCanPlayerEditInferiors() {
      return this.afterCanPlayerEditInferiors;
   }

   public void setBeforeCanPlayerEditSuperiors(String[] var1) {
      this.beforeCanPlayerEditSuperiors = var1;
   }

   public void setBeforeCanPlayerEditInferiors(String[] var1) {
      this.beforeCanPlayerEditInferiors = var1;
   }

   public void setOverrideCanPlayerEditSuperiors(String[] var1) {
      this.overrideCanPlayerEditSuperiors = var1;
   }

   public void setOverrideCanPlayerEditInferiors(String[] var1) {
      this.overrideCanPlayerEditInferiors = var1;
   }

   public void setAfterCanPlayerEditSuperiors(String[] var1) {
      this.afterCanPlayerEditSuperiors = var1;
   }

   public void setAfterCanPlayerEditInferiors(String[] var1) {
      this.afterCanPlayerEditInferiors = var1;
   }

   public String[] getBeforeCanTriggerWalkingSuperiors() {
      return this.beforeCanTriggerWalkingSuperiors;
   }

   public String[] getBeforeCanTriggerWalkingInferiors() {
      return this.beforeCanTriggerWalkingInferiors;
   }

   public String[] getOverrideCanTriggerWalkingSuperiors() {
      return this.overrideCanTriggerWalkingSuperiors;
   }

   public String[] getOverrideCanTriggerWalkingInferiors() {
      return this.overrideCanTriggerWalkingInferiors;
   }

   public String[] getAfterCanTriggerWalkingSuperiors() {
      return this.afterCanTriggerWalkingSuperiors;
   }

   public String[] getAfterCanTriggerWalkingInferiors() {
      return this.afterCanTriggerWalkingInferiors;
   }

   public void setBeforeCanTriggerWalkingSuperiors(String[] var1) {
      this.beforeCanTriggerWalkingSuperiors = var1;
   }

   public void setBeforeCanTriggerWalkingInferiors(String[] var1) {
      this.beforeCanTriggerWalkingInferiors = var1;
   }

   public void setOverrideCanTriggerWalkingSuperiors(String[] var1) {
      this.overrideCanTriggerWalkingSuperiors = var1;
   }

   public void setOverrideCanTriggerWalkingInferiors(String[] var1) {
      this.overrideCanTriggerWalkingInferiors = var1;
   }

   public void setAfterCanTriggerWalkingSuperiors(String[] var1) {
      this.afterCanTriggerWalkingSuperiors = var1;
   }

   public void setAfterCanTriggerWalkingInferiors(String[] var1) {
      this.afterCanTriggerWalkingInferiors = var1;
   }

   public String[] getBeforeClonePlayerSuperiors() {
      return this.beforeClonePlayerSuperiors;
   }

   public String[] getBeforeClonePlayerInferiors() {
      return this.beforeClonePlayerInferiors;
   }

   public String[] getOverrideClonePlayerSuperiors() {
      return this.overrideClonePlayerSuperiors;
   }

   public String[] getOverrideClonePlayerInferiors() {
      return this.overrideClonePlayerInferiors;
   }

   public String[] getAfterClonePlayerSuperiors() {
      return this.afterClonePlayerSuperiors;
   }

   public String[] getAfterClonePlayerInferiors() {
      return this.afterClonePlayerInferiors;
   }

   public void setBeforeClonePlayerSuperiors(String[] var1) {
      this.beforeClonePlayerSuperiors = var1;
   }

   public void setBeforeClonePlayerInferiors(String[] var1) {
      this.beforeClonePlayerInferiors = var1;
   }

   public void setOverrideClonePlayerSuperiors(String[] var1) {
      this.overrideClonePlayerSuperiors = var1;
   }

   public void setOverrideClonePlayerInferiors(String[] var1) {
      this.overrideClonePlayerInferiors = var1;
   }

   public void setAfterClonePlayerSuperiors(String[] var1) {
      this.afterClonePlayerSuperiors = var1;
   }

   public void setAfterClonePlayerInferiors(String[] var1) {
      this.afterClonePlayerInferiors = var1;
   }

   public String[] getBeforeDamageEntitySuperiors() {
      return this.beforeDamageEntitySuperiors;
   }

   public String[] getBeforeDamageEntityInferiors() {
      return this.beforeDamageEntityInferiors;
   }

   public String[] getOverrideDamageEntitySuperiors() {
      return this.overrideDamageEntitySuperiors;
   }

   public String[] getOverrideDamageEntityInferiors() {
      return this.overrideDamageEntityInferiors;
   }

   public String[] getAfterDamageEntitySuperiors() {
      return this.afterDamageEntitySuperiors;
   }

   public String[] getAfterDamageEntityInferiors() {
      return this.afterDamageEntityInferiors;
   }

   public void setBeforeDamageEntitySuperiors(String[] var1) {
      this.beforeDamageEntitySuperiors = var1;
   }

   public void setBeforeDamageEntityInferiors(String[] var1) {
      this.beforeDamageEntityInferiors = var1;
   }

   public void setOverrideDamageEntitySuperiors(String[] var1) {
      this.overrideDamageEntitySuperiors = var1;
   }

   public void setOverrideDamageEntityInferiors(String[] var1) {
      this.overrideDamageEntityInferiors = var1;
   }

   public void setAfterDamageEntitySuperiors(String[] var1) {
      this.afterDamageEntitySuperiors = var1;
   }

   public void setAfterDamageEntityInferiors(String[] var1) {
      this.afterDamageEntityInferiors = var1;
   }

   public String[] getBeforeDisplayGUIChestSuperiors() {
      return this.beforeDisplayGUIChestSuperiors;
   }

   public String[] getBeforeDisplayGUIChestInferiors() {
      return this.beforeDisplayGUIChestInferiors;
   }

   public String[] getOverrideDisplayGUIChestSuperiors() {
      return this.overrideDisplayGUIChestSuperiors;
   }

   public String[] getOverrideDisplayGUIChestInferiors() {
      return this.overrideDisplayGUIChestInferiors;
   }

   public String[] getAfterDisplayGUIChestSuperiors() {
      return this.afterDisplayGUIChestSuperiors;
   }

   public String[] getAfterDisplayGUIChestInferiors() {
      return this.afterDisplayGUIChestInferiors;
   }

   public void setBeforeDisplayGUIChestSuperiors(String[] var1) {
      this.beforeDisplayGUIChestSuperiors = var1;
   }

   public void setBeforeDisplayGUIChestInferiors(String[] var1) {
      this.beforeDisplayGUIChestInferiors = var1;
   }

   public void setOverrideDisplayGUIChestSuperiors(String[] var1) {
      this.overrideDisplayGUIChestSuperiors = var1;
   }

   public void setOverrideDisplayGUIChestInferiors(String[] var1) {
      this.overrideDisplayGUIChestInferiors = var1;
   }

   public void setAfterDisplayGUIChestSuperiors(String[] var1) {
      this.afterDisplayGUIChestSuperiors = var1;
   }

   public void setAfterDisplayGUIChestInferiors(String[] var1) {
      this.afterDisplayGUIChestInferiors = var1;
   }

   public String[] getBeforeDisplayGUIDispenserSuperiors() {
      return this.beforeDisplayGUIDispenserSuperiors;
   }

   public String[] getBeforeDisplayGUIDispenserInferiors() {
      return this.beforeDisplayGUIDispenserInferiors;
   }

   public String[] getOverrideDisplayGUIDispenserSuperiors() {
      return this.overrideDisplayGUIDispenserSuperiors;
   }

   public String[] getOverrideDisplayGUIDispenserInferiors() {
      return this.overrideDisplayGUIDispenserInferiors;
   }

   public String[] getAfterDisplayGUIDispenserSuperiors() {
      return this.afterDisplayGUIDispenserSuperiors;
   }

   public String[] getAfterDisplayGUIDispenserInferiors() {
      return this.afterDisplayGUIDispenserInferiors;
   }

   public void setBeforeDisplayGUIDispenserSuperiors(String[] var1) {
      this.beforeDisplayGUIDispenserSuperiors = var1;
   }

   public void setBeforeDisplayGUIDispenserInferiors(String[] var1) {
      this.beforeDisplayGUIDispenserInferiors = var1;
   }

   public void setOverrideDisplayGUIDispenserSuperiors(String[] var1) {
      this.overrideDisplayGUIDispenserSuperiors = var1;
   }

   public void setOverrideDisplayGUIDispenserInferiors(String[] var1) {
      this.overrideDisplayGUIDispenserInferiors = var1;
   }

   public void setAfterDisplayGUIDispenserSuperiors(String[] var1) {
      this.afterDisplayGUIDispenserSuperiors = var1;
   }

   public void setAfterDisplayGUIDispenserInferiors(String[] var1) {
      this.afterDisplayGUIDispenserInferiors = var1;
   }

   public String[] getBeforeDisplayGUIFurnaceSuperiors() {
      return this.beforeDisplayGUIFurnaceSuperiors;
   }

   public String[] getBeforeDisplayGUIFurnaceInferiors() {
      return this.beforeDisplayGUIFurnaceInferiors;
   }

   public String[] getOverrideDisplayGUIFurnaceSuperiors() {
      return this.overrideDisplayGUIFurnaceSuperiors;
   }

   public String[] getOverrideDisplayGUIFurnaceInferiors() {
      return this.overrideDisplayGUIFurnaceInferiors;
   }

   public String[] getAfterDisplayGUIFurnaceSuperiors() {
      return this.afterDisplayGUIFurnaceSuperiors;
   }

   public String[] getAfterDisplayGUIFurnaceInferiors() {
      return this.afterDisplayGUIFurnaceInferiors;
   }

   public void setBeforeDisplayGUIFurnaceSuperiors(String[] var1) {
      this.beforeDisplayGUIFurnaceSuperiors = var1;
   }

   public void setBeforeDisplayGUIFurnaceInferiors(String[] var1) {
      this.beforeDisplayGUIFurnaceInferiors = var1;
   }

   public void setOverrideDisplayGUIFurnaceSuperiors(String[] var1) {
      this.overrideDisplayGUIFurnaceSuperiors = var1;
   }

   public void setOverrideDisplayGUIFurnaceInferiors(String[] var1) {
      this.overrideDisplayGUIFurnaceInferiors = var1;
   }

   public void setAfterDisplayGUIFurnaceSuperiors(String[] var1) {
      this.afterDisplayGUIFurnaceSuperiors = var1;
   }

   public void setAfterDisplayGUIFurnaceInferiors(String[] var1) {
      this.afterDisplayGUIFurnaceInferiors = var1;
   }

   public String[] getBeforeDisplayGUIWorkbenchSuperiors() {
      return this.beforeDisplayGUIWorkbenchSuperiors;
   }

   public String[] getBeforeDisplayGUIWorkbenchInferiors() {
      return this.beforeDisplayGUIWorkbenchInferiors;
   }

   public String[] getOverrideDisplayGUIWorkbenchSuperiors() {
      return this.overrideDisplayGUIWorkbenchSuperiors;
   }

   public String[] getOverrideDisplayGUIWorkbenchInferiors() {
      return this.overrideDisplayGUIWorkbenchInferiors;
   }

   public String[] getAfterDisplayGUIWorkbenchSuperiors() {
      return this.afterDisplayGUIWorkbenchSuperiors;
   }

   public String[] getAfterDisplayGUIWorkbenchInferiors() {
      return this.afterDisplayGUIWorkbenchInferiors;
   }

   public void setBeforeDisplayGUIWorkbenchSuperiors(String[] var1) {
      this.beforeDisplayGUIWorkbenchSuperiors = var1;
   }

   public void setBeforeDisplayGUIWorkbenchInferiors(String[] var1) {
      this.beforeDisplayGUIWorkbenchInferiors = var1;
   }

   public void setOverrideDisplayGUIWorkbenchSuperiors(String[] var1) {
      this.overrideDisplayGUIWorkbenchSuperiors = var1;
   }

   public void setOverrideDisplayGUIWorkbenchInferiors(String[] var1) {
      this.overrideDisplayGUIWorkbenchInferiors = var1;
   }

   public void setAfterDisplayGUIWorkbenchSuperiors(String[] var1) {
      this.afterDisplayGUIWorkbenchSuperiors = var1;
   }

   public void setAfterDisplayGUIWorkbenchInferiors(String[] var1) {
      this.afterDisplayGUIWorkbenchInferiors = var1;
   }

   public String[] getBeforeDropOneItemSuperiors() {
      return this.beforeDropOneItemSuperiors;
   }

   public String[] getBeforeDropOneItemInferiors() {
      return this.beforeDropOneItemInferiors;
   }

   public String[] getOverrideDropOneItemSuperiors() {
      return this.overrideDropOneItemSuperiors;
   }

   public String[] getOverrideDropOneItemInferiors() {
      return this.overrideDropOneItemInferiors;
   }

   public String[] getAfterDropOneItemSuperiors() {
      return this.afterDropOneItemSuperiors;
   }

   public String[] getAfterDropOneItemInferiors() {
      return this.afterDropOneItemInferiors;
   }

   public void setBeforeDropOneItemSuperiors(String[] var1) {
      this.beforeDropOneItemSuperiors = var1;
   }

   public void setBeforeDropOneItemInferiors(String[] var1) {
      this.beforeDropOneItemInferiors = var1;
   }

   public void setOverrideDropOneItemSuperiors(String[] var1) {
      this.overrideDropOneItemSuperiors = var1;
   }

   public void setOverrideDropOneItemInferiors(String[] var1) {
      this.overrideDropOneItemInferiors = var1;
   }

   public void setAfterDropOneItemSuperiors(String[] var1) {
      this.afterDropOneItemSuperiors = var1;
   }

   public void setAfterDropOneItemInferiors(String[] var1) {
      this.afterDropOneItemInferiors = var1;
   }

   public String[] getBeforeDropPlayerItemSuperiors() {
      return this.beforeDropPlayerItemSuperiors;
   }

   public String[] getBeforeDropPlayerItemInferiors() {
      return this.beforeDropPlayerItemInferiors;
   }

   public String[] getOverrideDropPlayerItemSuperiors() {
      return this.overrideDropPlayerItemSuperiors;
   }

   public String[] getOverrideDropPlayerItemInferiors() {
      return this.overrideDropPlayerItemInferiors;
   }

   public String[] getAfterDropPlayerItemSuperiors() {
      return this.afterDropPlayerItemSuperiors;
   }

   public String[] getAfterDropPlayerItemInferiors() {
      return this.afterDropPlayerItemInferiors;
   }

   public void setBeforeDropPlayerItemSuperiors(String[] var1) {
      this.beforeDropPlayerItemSuperiors = var1;
   }

   public void setBeforeDropPlayerItemInferiors(String[] var1) {
      this.beforeDropPlayerItemInferiors = var1;
   }

   public void setOverrideDropPlayerItemSuperiors(String[] var1) {
      this.overrideDropPlayerItemSuperiors = var1;
   }

   public void setOverrideDropPlayerItemInferiors(String[] var1) {
      this.overrideDropPlayerItemInferiors = var1;
   }

   public void setAfterDropPlayerItemSuperiors(String[] var1) {
      this.afterDropPlayerItemSuperiors = var1;
   }

   public void setAfterDropPlayerItemInferiors(String[] var1) {
      this.afterDropPlayerItemInferiors = var1;
   }

   public String[] getBeforeFallSuperiors() {
      return this.beforeFallSuperiors;
   }

   public String[] getBeforeFallInferiors() {
      return this.beforeFallInferiors;
   }

   public String[] getOverrideFallSuperiors() {
      return this.overrideFallSuperiors;
   }

   public String[] getOverrideFallInferiors() {
      return this.overrideFallInferiors;
   }

   public String[] getAfterFallSuperiors() {
      return this.afterFallSuperiors;
   }

   public String[] getAfterFallInferiors() {
      return this.afterFallInferiors;
   }

   public void setBeforeFallSuperiors(String[] var1) {
      this.beforeFallSuperiors = var1;
   }

   public void setBeforeFallInferiors(String[] var1) {
      this.beforeFallInferiors = var1;
   }

   public void setOverrideFallSuperiors(String[] var1) {
      this.overrideFallSuperiors = var1;
   }

   public void setOverrideFallInferiors(String[] var1) {
      this.overrideFallInferiors = var1;
   }

   public void setAfterFallSuperiors(String[] var1) {
      this.afterFallSuperiors = var1;
   }

   public void setAfterFallInferiors(String[] var1) {
      this.afterFallInferiors = var1;
   }

   public String[] getBeforeGetAIMoveSpeedSuperiors() {
      return this.beforeGetAIMoveSpeedSuperiors;
   }

   public String[] getBeforeGetAIMoveSpeedInferiors() {
      return this.beforeGetAIMoveSpeedInferiors;
   }

   public String[] getOverrideGetAIMoveSpeedSuperiors() {
      return this.overrideGetAIMoveSpeedSuperiors;
   }

   public String[] getOverrideGetAIMoveSpeedInferiors() {
      return this.overrideGetAIMoveSpeedInferiors;
   }

   public String[] getAfterGetAIMoveSpeedSuperiors() {
      return this.afterGetAIMoveSpeedSuperiors;
   }

   public String[] getAfterGetAIMoveSpeedInferiors() {
      return this.afterGetAIMoveSpeedInferiors;
   }

   public void setBeforeGetAIMoveSpeedSuperiors(String[] var1) {
      this.beforeGetAIMoveSpeedSuperiors = var1;
   }

   public void setBeforeGetAIMoveSpeedInferiors(String[] var1) {
      this.beforeGetAIMoveSpeedInferiors = var1;
   }

   public void setOverrideGetAIMoveSpeedSuperiors(String[] var1) {
      this.overrideGetAIMoveSpeedSuperiors = var1;
   }

   public void setOverrideGetAIMoveSpeedInferiors(String[] var1) {
      this.overrideGetAIMoveSpeedInferiors = var1;
   }

   public void setAfterGetAIMoveSpeedSuperiors(String[] var1) {
      this.afterGetAIMoveSpeedSuperiors = var1;
   }

   public void setAfterGetAIMoveSpeedInferiors(String[] var1) {
      this.afterGetAIMoveSpeedInferiors = var1;
   }

   public String[] getBeforeGetCurrentPlayerStrVsBlockSuperiors() {
      return this.beforeGetCurrentPlayerStrVsBlockSuperiors;
   }

   public String[] getBeforeGetCurrentPlayerStrVsBlockInferiors() {
      return this.beforeGetCurrentPlayerStrVsBlockInferiors;
   }

   public String[] getOverrideGetCurrentPlayerStrVsBlockSuperiors() {
      return this.overrideGetCurrentPlayerStrVsBlockSuperiors;
   }

   public String[] getOverrideGetCurrentPlayerStrVsBlockInferiors() {
      return this.overrideGetCurrentPlayerStrVsBlockInferiors;
   }

   public String[] getAfterGetCurrentPlayerStrVsBlockSuperiors() {
      return this.afterGetCurrentPlayerStrVsBlockSuperiors;
   }

   public String[] getAfterGetCurrentPlayerStrVsBlockInferiors() {
      return this.afterGetCurrentPlayerStrVsBlockInferiors;
   }

   public void setBeforeGetCurrentPlayerStrVsBlockSuperiors(String[] var1) {
      this.beforeGetCurrentPlayerStrVsBlockSuperiors = var1;
   }

   public void setBeforeGetCurrentPlayerStrVsBlockInferiors(String[] var1) {
      this.beforeGetCurrentPlayerStrVsBlockInferiors = var1;
   }

   public void setOverrideGetCurrentPlayerStrVsBlockSuperiors(String[] var1) {
      this.overrideGetCurrentPlayerStrVsBlockSuperiors = var1;
   }

   public void setOverrideGetCurrentPlayerStrVsBlockInferiors(String[] var1) {
      this.overrideGetCurrentPlayerStrVsBlockInferiors = var1;
   }

   public void setAfterGetCurrentPlayerStrVsBlockSuperiors(String[] var1) {
      this.afterGetCurrentPlayerStrVsBlockSuperiors = var1;
   }

   public void setAfterGetCurrentPlayerStrVsBlockInferiors(String[] var1) {
      this.afterGetCurrentPlayerStrVsBlockInferiors = var1;
   }

   public String[] getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors() {
      return this.beforeGetCurrentPlayerStrVsBlockForgeSuperiors;
   }

   public String[] getBeforeGetCurrentPlayerStrVsBlockForgeInferiors() {
      return this.beforeGetCurrentPlayerStrVsBlockForgeInferiors;
   }

   public String[] getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors() {
      return this.overrideGetCurrentPlayerStrVsBlockForgeSuperiors;
   }

   public String[] getOverrideGetCurrentPlayerStrVsBlockForgeInferiors() {
      return this.overrideGetCurrentPlayerStrVsBlockForgeInferiors;
   }

   public String[] getAfterGetCurrentPlayerStrVsBlockForgeSuperiors() {
      return this.afterGetCurrentPlayerStrVsBlockForgeSuperiors;
   }

   public String[] getAfterGetCurrentPlayerStrVsBlockForgeInferiors() {
      return this.afterGetCurrentPlayerStrVsBlockForgeInferiors;
   }

   public void setBeforeGetCurrentPlayerStrVsBlockForgeSuperiors(String[] var1) {
      this.beforeGetCurrentPlayerStrVsBlockForgeSuperiors = var1;
   }

   public void setBeforeGetCurrentPlayerStrVsBlockForgeInferiors(String[] var1) {
      this.beforeGetCurrentPlayerStrVsBlockForgeInferiors = var1;
   }

   public void setOverrideGetCurrentPlayerStrVsBlockForgeSuperiors(String[] var1) {
      this.overrideGetCurrentPlayerStrVsBlockForgeSuperiors = var1;
   }

   public void setOverrideGetCurrentPlayerStrVsBlockForgeInferiors(String[] var1) {
      this.overrideGetCurrentPlayerStrVsBlockForgeInferiors = var1;
   }

   public void setAfterGetCurrentPlayerStrVsBlockForgeSuperiors(String[] var1) {
      this.afterGetCurrentPlayerStrVsBlockForgeSuperiors = var1;
   }

   public void setAfterGetCurrentPlayerStrVsBlockForgeInferiors(String[] var1) {
      this.afterGetCurrentPlayerStrVsBlockForgeInferiors = var1;
   }

   public String[] getBeforeGetDistanceSqSuperiors() {
      return this.beforeGetDistanceSqSuperiors;
   }

   public String[] getBeforeGetDistanceSqInferiors() {
      return this.beforeGetDistanceSqInferiors;
   }

   public String[] getOverrideGetDistanceSqSuperiors() {
      return this.overrideGetDistanceSqSuperiors;
   }

   public String[] getOverrideGetDistanceSqInferiors() {
      return this.overrideGetDistanceSqInferiors;
   }

   public String[] getAfterGetDistanceSqSuperiors() {
      return this.afterGetDistanceSqSuperiors;
   }

   public String[] getAfterGetDistanceSqInferiors() {
      return this.afterGetDistanceSqInferiors;
   }

   public void setBeforeGetDistanceSqSuperiors(String[] var1) {
      this.beforeGetDistanceSqSuperiors = var1;
   }

   public void setBeforeGetDistanceSqInferiors(String[] var1) {
      this.beforeGetDistanceSqInferiors = var1;
   }

   public void setOverrideGetDistanceSqSuperiors(String[] var1) {
      this.overrideGetDistanceSqSuperiors = var1;
   }

   public void setOverrideGetDistanceSqInferiors(String[] var1) {
      this.overrideGetDistanceSqInferiors = var1;
   }

   public void setAfterGetDistanceSqSuperiors(String[] var1) {
      this.afterGetDistanceSqSuperiors = var1;
   }

   public void setAfterGetDistanceSqInferiors(String[] var1) {
      this.afterGetDistanceSqInferiors = var1;
   }

   public String[] getBeforeGetBrightnessSuperiors() {
      return this.beforeGetBrightnessSuperiors;
   }

   public String[] getBeforeGetBrightnessInferiors() {
      return this.beforeGetBrightnessInferiors;
   }

   public String[] getOverrideGetBrightnessSuperiors() {
      return this.overrideGetBrightnessSuperiors;
   }

   public String[] getOverrideGetBrightnessInferiors() {
      return this.overrideGetBrightnessInferiors;
   }

   public String[] getAfterGetBrightnessSuperiors() {
      return this.afterGetBrightnessSuperiors;
   }

   public String[] getAfterGetBrightnessInferiors() {
      return this.afterGetBrightnessInferiors;
   }

   public void setBeforeGetBrightnessSuperiors(String[] var1) {
      this.beforeGetBrightnessSuperiors = var1;
   }

   public void setBeforeGetBrightnessInferiors(String[] var1) {
      this.beforeGetBrightnessInferiors = var1;
   }

   public void setOverrideGetBrightnessSuperiors(String[] var1) {
      this.overrideGetBrightnessSuperiors = var1;
   }

   public void setOverrideGetBrightnessInferiors(String[] var1) {
      this.overrideGetBrightnessInferiors = var1;
   }

   public void setAfterGetBrightnessSuperiors(String[] var1) {
      this.afterGetBrightnessSuperiors = var1;
   }

   public void setAfterGetBrightnessInferiors(String[] var1) {
      this.afterGetBrightnessInferiors = var1;
   }

   public String[] getBeforeGetEyeHeightSuperiors() {
      return this.beforeGetEyeHeightSuperiors;
   }

   public String[] getBeforeGetEyeHeightInferiors() {
      return this.beforeGetEyeHeightInferiors;
   }

   public String[] getOverrideGetEyeHeightSuperiors() {
      return this.overrideGetEyeHeightSuperiors;
   }

   public String[] getOverrideGetEyeHeightInferiors() {
      return this.overrideGetEyeHeightInferiors;
   }

   public String[] getAfterGetEyeHeightSuperiors() {
      return this.afterGetEyeHeightSuperiors;
   }

   public String[] getAfterGetEyeHeightInferiors() {
      return this.afterGetEyeHeightInferiors;
   }

   public void setBeforeGetEyeHeightSuperiors(String[] var1) {
      this.beforeGetEyeHeightSuperiors = var1;
   }

   public void setBeforeGetEyeHeightInferiors(String[] var1) {
      this.beforeGetEyeHeightInferiors = var1;
   }

   public void setOverrideGetEyeHeightSuperiors(String[] var1) {
      this.overrideGetEyeHeightSuperiors = var1;
   }

   public void setOverrideGetEyeHeightInferiors(String[] var1) {
      this.overrideGetEyeHeightInferiors = var1;
   }

   public void setAfterGetEyeHeightSuperiors(String[] var1) {
      this.afterGetEyeHeightSuperiors = var1;
   }

   public void setAfterGetEyeHeightInferiors(String[] var1) {
      this.afterGetEyeHeightInferiors = var1;
   }

   public String[] getBeforeHealSuperiors() {
      return this.beforeHealSuperiors;
   }

   public String[] getBeforeHealInferiors() {
      return this.beforeHealInferiors;
   }

   public String[] getOverrideHealSuperiors() {
      return this.overrideHealSuperiors;
   }

   public String[] getOverrideHealInferiors() {
      return this.overrideHealInferiors;
   }

   public String[] getAfterHealSuperiors() {
      return this.afterHealSuperiors;
   }

   public String[] getAfterHealInferiors() {
      return this.afterHealInferiors;
   }

   public void setBeforeHealSuperiors(String[] var1) {
      this.beforeHealSuperiors = var1;
   }

   public void setBeforeHealInferiors(String[] var1) {
      this.beforeHealInferiors = var1;
   }

   public void setOverrideHealSuperiors(String[] var1) {
      this.overrideHealSuperiors = var1;
   }

   public void setOverrideHealInferiors(String[] var1) {
      this.overrideHealInferiors = var1;
   }

   public void setAfterHealSuperiors(String[] var1) {
      this.afterHealSuperiors = var1;
   }

   public void setAfterHealInferiors(String[] var1) {
      this.afterHealInferiors = var1;
   }

   public String[] getBeforeIsEntityInsideOpaqueBlockSuperiors() {
      return this.beforeIsEntityInsideOpaqueBlockSuperiors;
   }

   public String[] getBeforeIsEntityInsideOpaqueBlockInferiors() {
      return this.beforeIsEntityInsideOpaqueBlockInferiors;
   }

   public String[] getOverrideIsEntityInsideOpaqueBlockSuperiors() {
      return this.overrideIsEntityInsideOpaqueBlockSuperiors;
   }

   public String[] getOverrideIsEntityInsideOpaqueBlockInferiors() {
      return this.overrideIsEntityInsideOpaqueBlockInferiors;
   }

   public String[] getAfterIsEntityInsideOpaqueBlockSuperiors() {
      return this.afterIsEntityInsideOpaqueBlockSuperiors;
   }

   public String[] getAfterIsEntityInsideOpaqueBlockInferiors() {
      return this.afterIsEntityInsideOpaqueBlockInferiors;
   }

   public void setBeforeIsEntityInsideOpaqueBlockSuperiors(String[] var1) {
      this.beforeIsEntityInsideOpaqueBlockSuperiors = var1;
   }

   public void setBeforeIsEntityInsideOpaqueBlockInferiors(String[] var1) {
      this.beforeIsEntityInsideOpaqueBlockInferiors = var1;
   }

   public void setOverrideIsEntityInsideOpaqueBlockSuperiors(String[] var1) {
      this.overrideIsEntityInsideOpaqueBlockSuperiors = var1;
   }

   public void setOverrideIsEntityInsideOpaqueBlockInferiors(String[] var1) {
      this.overrideIsEntityInsideOpaqueBlockInferiors = var1;
   }

   public void setAfterIsEntityInsideOpaqueBlockSuperiors(String[] var1) {
      this.afterIsEntityInsideOpaqueBlockSuperiors = var1;
   }

   public void setAfterIsEntityInsideOpaqueBlockInferiors(String[] var1) {
      this.afterIsEntityInsideOpaqueBlockInferiors = var1;
   }

   public String[] getBeforeIsInWaterSuperiors() {
      return this.beforeIsInWaterSuperiors;
   }

   public String[] getBeforeIsInWaterInferiors() {
      return this.beforeIsInWaterInferiors;
   }

   public String[] getOverrideIsInWaterSuperiors() {
      return this.overrideIsInWaterSuperiors;
   }

   public String[] getOverrideIsInWaterInferiors() {
      return this.overrideIsInWaterInferiors;
   }

   public String[] getAfterIsInWaterSuperiors() {
      return this.afterIsInWaterSuperiors;
   }

   public String[] getAfterIsInWaterInferiors() {
      return this.afterIsInWaterInferiors;
   }

   public void setBeforeIsInWaterSuperiors(String[] var1) {
      this.beforeIsInWaterSuperiors = var1;
   }

   public void setBeforeIsInWaterInferiors(String[] var1) {
      this.beforeIsInWaterInferiors = var1;
   }

   public void setOverrideIsInWaterSuperiors(String[] var1) {
      this.overrideIsInWaterSuperiors = var1;
   }

   public void setOverrideIsInWaterInferiors(String[] var1) {
      this.overrideIsInWaterInferiors = var1;
   }

   public void setAfterIsInWaterSuperiors(String[] var1) {
      this.afterIsInWaterSuperiors = var1;
   }

   public void setAfterIsInWaterInferiors(String[] var1) {
      this.afterIsInWaterInferiors = var1;
   }

   public String[] getBeforeIsInsideOfMaterialSuperiors() {
      return this.beforeIsInsideOfMaterialSuperiors;
   }

   public String[] getBeforeIsInsideOfMaterialInferiors() {
      return this.beforeIsInsideOfMaterialInferiors;
   }

   public String[] getOverrideIsInsideOfMaterialSuperiors() {
      return this.overrideIsInsideOfMaterialSuperiors;
   }

   public String[] getOverrideIsInsideOfMaterialInferiors() {
      return this.overrideIsInsideOfMaterialInferiors;
   }

   public String[] getAfterIsInsideOfMaterialSuperiors() {
      return this.afterIsInsideOfMaterialSuperiors;
   }

   public String[] getAfterIsInsideOfMaterialInferiors() {
      return this.afterIsInsideOfMaterialInferiors;
   }

   public void setBeforeIsInsideOfMaterialSuperiors(String[] var1) {
      this.beforeIsInsideOfMaterialSuperiors = var1;
   }

   public void setBeforeIsInsideOfMaterialInferiors(String[] var1) {
      this.beforeIsInsideOfMaterialInferiors = var1;
   }

   public void setOverrideIsInsideOfMaterialSuperiors(String[] var1) {
      this.overrideIsInsideOfMaterialSuperiors = var1;
   }

   public void setOverrideIsInsideOfMaterialInferiors(String[] var1) {
      this.overrideIsInsideOfMaterialInferiors = var1;
   }

   public void setAfterIsInsideOfMaterialSuperiors(String[] var1) {
      this.afterIsInsideOfMaterialSuperiors = var1;
   }

   public void setAfterIsInsideOfMaterialInferiors(String[] var1) {
      this.afterIsInsideOfMaterialInferiors = var1;
   }

   public String[] getBeforeIsOnLadderSuperiors() {
      return this.beforeIsOnLadderSuperiors;
   }

   public String[] getBeforeIsOnLadderInferiors() {
      return this.beforeIsOnLadderInferiors;
   }

   public String[] getOverrideIsOnLadderSuperiors() {
      return this.overrideIsOnLadderSuperiors;
   }

   public String[] getOverrideIsOnLadderInferiors() {
      return this.overrideIsOnLadderInferiors;
   }

   public String[] getAfterIsOnLadderSuperiors() {
      return this.afterIsOnLadderSuperiors;
   }

   public String[] getAfterIsOnLadderInferiors() {
      return this.afterIsOnLadderInferiors;
   }

   public void setBeforeIsOnLadderSuperiors(String[] var1) {
      this.beforeIsOnLadderSuperiors = var1;
   }

   public void setBeforeIsOnLadderInferiors(String[] var1) {
      this.beforeIsOnLadderInferiors = var1;
   }

   public void setOverrideIsOnLadderSuperiors(String[] var1) {
      this.overrideIsOnLadderSuperiors = var1;
   }

   public void setOverrideIsOnLadderInferiors(String[] var1) {
      this.overrideIsOnLadderInferiors = var1;
   }

   public void setAfterIsOnLadderSuperiors(String[] var1) {
      this.afterIsOnLadderSuperiors = var1;
   }

   public void setAfterIsOnLadderInferiors(String[] var1) {
      this.afterIsOnLadderInferiors = var1;
   }

   public String[] getBeforeIsPlayerSleepingSuperiors() {
      return this.beforeIsPlayerSleepingSuperiors;
   }

   public String[] getBeforeIsPlayerSleepingInferiors() {
      return this.beforeIsPlayerSleepingInferiors;
   }

   public String[] getOverrideIsPlayerSleepingSuperiors() {
      return this.overrideIsPlayerSleepingSuperiors;
   }

   public String[] getOverrideIsPlayerSleepingInferiors() {
      return this.overrideIsPlayerSleepingInferiors;
   }

   public String[] getAfterIsPlayerSleepingSuperiors() {
      return this.afterIsPlayerSleepingSuperiors;
   }

   public String[] getAfterIsPlayerSleepingInferiors() {
      return this.afterIsPlayerSleepingInferiors;
   }

   public void setBeforeIsPlayerSleepingSuperiors(String[] var1) {
      this.beforeIsPlayerSleepingSuperiors = var1;
   }

   public void setBeforeIsPlayerSleepingInferiors(String[] var1) {
      this.beforeIsPlayerSleepingInferiors = var1;
   }

   public void setOverrideIsPlayerSleepingSuperiors(String[] var1) {
      this.overrideIsPlayerSleepingSuperiors = var1;
   }

   public void setOverrideIsPlayerSleepingInferiors(String[] var1) {
      this.overrideIsPlayerSleepingInferiors = var1;
   }

   public void setAfterIsPlayerSleepingSuperiors(String[] var1) {
      this.afterIsPlayerSleepingSuperiors = var1;
   }

   public void setAfterIsPlayerSleepingInferiors(String[] var1) {
      this.afterIsPlayerSleepingInferiors = var1;
   }

   public String[] getBeforeIsSneakingSuperiors() {
      return this.beforeIsSneakingSuperiors;
   }

   public String[] getBeforeIsSneakingInferiors() {
      return this.beforeIsSneakingInferiors;
   }

   public String[] getOverrideIsSneakingSuperiors() {
      return this.overrideIsSneakingSuperiors;
   }

   public String[] getOverrideIsSneakingInferiors() {
      return this.overrideIsSneakingInferiors;
   }

   public String[] getAfterIsSneakingSuperiors() {
      return this.afterIsSneakingSuperiors;
   }

   public String[] getAfterIsSneakingInferiors() {
      return this.afterIsSneakingInferiors;
   }

   public void setBeforeIsSneakingSuperiors(String[] var1) {
      this.beforeIsSneakingSuperiors = var1;
   }

   public void setBeforeIsSneakingInferiors(String[] var1) {
      this.beforeIsSneakingInferiors = var1;
   }

   public void setOverrideIsSneakingSuperiors(String[] var1) {
      this.overrideIsSneakingSuperiors = var1;
   }

   public void setOverrideIsSneakingInferiors(String[] var1) {
      this.overrideIsSneakingInferiors = var1;
   }

   public void setAfterIsSneakingSuperiors(String[] var1) {
      this.afterIsSneakingSuperiors = var1;
   }

   public void setAfterIsSneakingInferiors(String[] var1) {
      this.afterIsSneakingInferiors = var1;
   }

   public String[] getBeforeJumpSuperiors() {
      return this.beforeJumpSuperiors;
   }

   public String[] getBeforeJumpInferiors() {
      return this.beforeJumpInferiors;
   }

   public String[] getOverrideJumpSuperiors() {
      return this.overrideJumpSuperiors;
   }

   public String[] getOverrideJumpInferiors() {
      return this.overrideJumpInferiors;
   }

   public String[] getAfterJumpSuperiors() {
      return this.afterJumpSuperiors;
   }

   public String[] getAfterJumpInferiors() {
      return this.afterJumpInferiors;
   }

   public void setBeforeJumpSuperiors(String[] var1) {
      this.beforeJumpSuperiors = var1;
   }

   public void setBeforeJumpInferiors(String[] var1) {
      this.beforeJumpInferiors = var1;
   }

   public void setOverrideJumpSuperiors(String[] var1) {
      this.overrideJumpSuperiors = var1;
   }

   public void setOverrideJumpInferiors(String[] var1) {
      this.overrideJumpInferiors = var1;
   }

   public void setAfterJumpSuperiors(String[] var1) {
      this.afterJumpSuperiors = var1;
   }

   public void setAfterJumpInferiors(String[] var1) {
      this.afterJumpInferiors = var1;
   }

   public String[] getBeforeKnockBackSuperiors() {
      return this.beforeKnockBackSuperiors;
   }

   public String[] getBeforeKnockBackInferiors() {
      return this.beforeKnockBackInferiors;
   }

   public String[] getOverrideKnockBackSuperiors() {
      return this.overrideKnockBackSuperiors;
   }

   public String[] getOverrideKnockBackInferiors() {
      return this.overrideKnockBackInferiors;
   }

   public String[] getAfterKnockBackSuperiors() {
      return this.afterKnockBackSuperiors;
   }

   public String[] getAfterKnockBackInferiors() {
      return this.afterKnockBackInferiors;
   }

   public void setBeforeKnockBackSuperiors(String[] var1) {
      this.beforeKnockBackSuperiors = var1;
   }

   public void setBeforeKnockBackInferiors(String[] var1) {
      this.beforeKnockBackInferiors = var1;
   }

   public void setOverrideKnockBackSuperiors(String[] var1) {
      this.overrideKnockBackSuperiors = var1;
   }

   public void setOverrideKnockBackInferiors(String[] var1) {
      this.overrideKnockBackInferiors = var1;
   }

   public void setAfterKnockBackSuperiors(String[] var1) {
      this.afterKnockBackSuperiors = var1;
   }

   public void setAfterKnockBackInferiors(String[] var1) {
      this.afterKnockBackInferiors = var1;
   }

   public String[] getBeforeMountEntitySuperiors() {
      return this.beforeMountEntitySuperiors;
   }

   public String[] getBeforeMountEntityInferiors() {
      return this.beforeMountEntityInferiors;
   }

   public String[] getOverrideMountEntitySuperiors() {
      return this.overrideMountEntitySuperiors;
   }

   public String[] getOverrideMountEntityInferiors() {
      return this.overrideMountEntityInferiors;
   }

   public String[] getAfterMountEntitySuperiors() {
      return this.afterMountEntitySuperiors;
   }

   public String[] getAfterMountEntityInferiors() {
      return this.afterMountEntityInferiors;
   }

   public void setBeforeMountEntitySuperiors(String[] var1) {
      this.beforeMountEntitySuperiors = var1;
   }

   public void setBeforeMountEntityInferiors(String[] var1) {
      this.beforeMountEntityInferiors = var1;
   }

   public void setOverrideMountEntitySuperiors(String[] var1) {
      this.overrideMountEntitySuperiors = var1;
   }

   public void setOverrideMountEntityInferiors(String[] var1) {
      this.overrideMountEntityInferiors = var1;
   }

   public void setAfterMountEntitySuperiors(String[] var1) {
      this.afterMountEntitySuperiors = var1;
   }

   public void setAfterMountEntityInferiors(String[] var1) {
      this.afterMountEntityInferiors = var1;
   }

   public String[] getBeforeMoveEntitySuperiors() {
      return this.beforeMoveEntitySuperiors;
   }

   public String[] getBeforeMoveEntityInferiors() {
      return this.beforeMoveEntityInferiors;
   }

   public String[] getOverrideMoveEntitySuperiors() {
      return this.overrideMoveEntitySuperiors;
   }

   public String[] getOverrideMoveEntityInferiors() {
      return this.overrideMoveEntityInferiors;
   }

   public String[] getAfterMoveEntitySuperiors() {
      return this.afterMoveEntitySuperiors;
   }

   public String[] getAfterMoveEntityInferiors() {
      return this.afterMoveEntityInferiors;
   }

   public void setBeforeMoveEntitySuperiors(String[] var1) {
      this.beforeMoveEntitySuperiors = var1;
   }

   public void setBeforeMoveEntityInferiors(String[] var1) {
      this.beforeMoveEntityInferiors = var1;
   }

   public void setOverrideMoveEntitySuperiors(String[] var1) {
      this.overrideMoveEntitySuperiors = var1;
   }

   public void setOverrideMoveEntityInferiors(String[] var1) {
      this.overrideMoveEntityInferiors = var1;
   }

   public void setAfterMoveEntitySuperiors(String[] var1) {
      this.afterMoveEntitySuperiors = var1;
   }

   public void setAfterMoveEntityInferiors(String[] var1) {
      this.afterMoveEntityInferiors = var1;
   }

   public String[] getBeforeMoveEntityWithHeadingSuperiors() {
      return this.beforeMoveEntityWithHeadingSuperiors;
   }

   public String[] getBeforeMoveEntityWithHeadingInferiors() {
      return this.beforeMoveEntityWithHeadingInferiors;
   }

   public String[] getOverrideMoveEntityWithHeadingSuperiors() {
      return this.overrideMoveEntityWithHeadingSuperiors;
   }

   public String[] getOverrideMoveEntityWithHeadingInferiors() {
      return this.overrideMoveEntityWithHeadingInferiors;
   }

   public String[] getAfterMoveEntityWithHeadingSuperiors() {
      return this.afterMoveEntityWithHeadingSuperiors;
   }

   public String[] getAfterMoveEntityWithHeadingInferiors() {
      return this.afterMoveEntityWithHeadingInferiors;
   }

   public void setBeforeMoveEntityWithHeadingSuperiors(String[] var1) {
      this.beforeMoveEntityWithHeadingSuperiors = var1;
   }

   public void setBeforeMoveEntityWithHeadingInferiors(String[] var1) {
      this.beforeMoveEntityWithHeadingInferiors = var1;
   }

   public void setOverrideMoveEntityWithHeadingSuperiors(String[] var1) {
      this.overrideMoveEntityWithHeadingSuperiors = var1;
   }

   public void setOverrideMoveEntityWithHeadingInferiors(String[] var1) {
      this.overrideMoveEntityWithHeadingInferiors = var1;
   }

   public void setAfterMoveEntityWithHeadingSuperiors(String[] var1) {
      this.afterMoveEntityWithHeadingSuperiors = var1;
   }

   public void setAfterMoveEntityWithHeadingInferiors(String[] var1) {
      this.afterMoveEntityWithHeadingInferiors = var1;
   }

   public String[] getBeforeMoveFlyingSuperiors() {
      return this.beforeMoveFlyingSuperiors;
   }

   public String[] getBeforeMoveFlyingInferiors() {
      return this.beforeMoveFlyingInferiors;
   }

   public String[] getOverrideMoveFlyingSuperiors() {
      return this.overrideMoveFlyingSuperiors;
   }

   public String[] getOverrideMoveFlyingInferiors() {
      return this.overrideMoveFlyingInferiors;
   }

   public String[] getAfterMoveFlyingSuperiors() {
      return this.afterMoveFlyingSuperiors;
   }

   public String[] getAfterMoveFlyingInferiors() {
      return this.afterMoveFlyingInferiors;
   }

   public void setBeforeMoveFlyingSuperiors(String[] var1) {
      this.beforeMoveFlyingSuperiors = var1;
   }

   public void setBeforeMoveFlyingInferiors(String[] var1) {
      this.beforeMoveFlyingInferiors = var1;
   }

   public void setOverrideMoveFlyingSuperiors(String[] var1) {
      this.overrideMoveFlyingSuperiors = var1;
   }

   public void setOverrideMoveFlyingInferiors(String[] var1) {
      this.overrideMoveFlyingInferiors = var1;
   }

   public void setAfterMoveFlyingSuperiors(String[] var1) {
      this.afterMoveFlyingSuperiors = var1;
   }

   public void setAfterMoveFlyingInferiors(String[] var1) {
      this.afterMoveFlyingInferiors = var1;
   }

   public String[] getBeforeOnDeathSuperiors() {
      return this.beforeOnDeathSuperiors;
   }

   public String[] getBeforeOnDeathInferiors() {
      return this.beforeOnDeathInferiors;
   }

   public String[] getOverrideOnDeathSuperiors() {
      return this.overrideOnDeathSuperiors;
   }

   public String[] getOverrideOnDeathInferiors() {
      return this.overrideOnDeathInferiors;
   }

   public String[] getAfterOnDeathSuperiors() {
      return this.afterOnDeathSuperiors;
   }

   public String[] getAfterOnDeathInferiors() {
      return this.afterOnDeathInferiors;
   }

   public void setBeforeOnDeathSuperiors(String[] var1) {
      this.beforeOnDeathSuperiors = var1;
   }

   public void setBeforeOnDeathInferiors(String[] var1) {
      this.beforeOnDeathInferiors = var1;
   }

   public void setOverrideOnDeathSuperiors(String[] var1) {
      this.overrideOnDeathSuperiors = var1;
   }

   public void setOverrideOnDeathInferiors(String[] var1) {
      this.overrideOnDeathInferiors = var1;
   }

   public void setAfterOnDeathSuperiors(String[] var1) {
      this.afterOnDeathSuperiors = var1;
   }

   public void setAfterOnDeathInferiors(String[] var1) {
      this.afterOnDeathInferiors = var1;
   }

   public String[] getBeforeOnLivingUpdateSuperiors() {
      return this.beforeOnLivingUpdateSuperiors;
   }

   public String[] getBeforeOnLivingUpdateInferiors() {
      return this.beforeOnLivingUpdateInferiors;
   }

   public String[] getOverrideOnLivingUpdateSuperiors() {
      return this.overrideOnLivingUpdateSuperiors;
   }

   public String[] getOverrideOnLivingUpdateInferiors() {
      return this.overrideOnLivingUpdateInferiors;
   }

   public String[] getAfterOnLivingUpdateSuperiors() {
      return this.afterOnLivingUpdateSuperiors;
   }

   public String[] getAfterOnLivingUpdateInferiors() {
      return this.afterOnLivingUpdateInferiors;
   }

   public void setBeforeOnLivingUpdateSuperiors(String[] var1) {
      this.beforeOnLivingUpdateSuperiors = var1;
   }

   public void setBeforeOnLivingUpdateInferiors(String[] var1) {
      this.beforeOnLivingUpdateInferiors = var1;
   }

   public void setOverrideOnLivingUpdateSuperiors(String[] var1) {
      this.overrideOnLivingUpdateSuperiors = var1;
   }

   public void setOverrideOnLivingUpdateInferiors(String[] var1) {
      this.overrideOnLivingUpdateInferiors = var1;
   }

   public void setAfterOnLivingUpdateSuperiors(String[] var1) {
      this.afterOnLivingUpdateSuperiors = var1;
   }

   public void setAfterOnLivingUpdateInferiors(String[] var1) {
      this.afterOnLivingUpdateInferiors = var1;
   }

   public String[] getBeforeOnKillEntitySuperiors() {
      return this.beforeOnKillEntitySuperiors;
   }

   public String[] getBeforeOnKillEntityInferiors() {
      return this.beforeOnKillEntityInferiors;
   }

   public String[] getOverrideOnKillEntitySuperiors() {
      return this.overrideOnKillEntitySuperiors;
   }

   public String[] getOverrideOnKillEntityInferiors() {
      return this.overrideOnKillEntityInferiors;
   }

   public String[] getAfterOnKillEntitySuperiors() {
      return this.afterOnKillEntitySuperiors;
   }

   public String[] getAfterOnKillEntityInferiors() {
      return this.afterOnKillEntityInferiors;
   }

   public void setBeforeOnKillEntitySuperiors(String[] var1) {
      this.beforeOnKillEntitySuperiors = var1;
   }

   public void setBeforeOnKillEntityInferiors(String[] var1) {
      this.beforeOnKillEntityInferiors = var1;
   }

   public void setOverrideOnKillEntitySuperiors(String[] var1) {
      this.overrideOnKillEntitySuperiors = var1;
   }

   public void setOverrideOnKillEntityInferiors(String[] var1) {
      this.overrideOnKillEntityInferiors = var1;
   }

   public void setAfterOnKillEntitySuperiors(String[] var1) {
      this.afterOnKillEntitySuperiors = var1;
   }

   public void setAfterOnKillEntityInferiors(String[] var1) {
      this.afterOnKillEntityInferiors = var1;
   }

   public String[] getBeforeOnStruckByLightningSuperiors() {
      return this.beforeOnStruckByLightningSuperiors;
   }

   public String[] getBeforeOnStruckByLightningInferiors() {
      return this.beforeOnStruckByLightningInferiors;
   }

   public String[] getOverrideOnStruckByLightningSuperiors() {
      return this.overrideOnStruckByLightningSuperiors;
   }

   public String[] getOverrideOnStruckByLightningInferiors() {
      return this.overrideOnStruckByLightningInferiors;
   }

   public String[] getAfterOnStruckByLightningSuperiors() {
      return this.afterOnStruckByLightningSuperiors;
   }

   public String[] getAfterOnStruckByLightningInferiors() {
      return this.afterOnStruckByLightningInferiors;
   }

   public void setBeforeOnStruckByLightningSuperiors(String[] var1) {
      this.beforeOnStruckByLightningSuperiors = var1;
   }

   public void setBeforeOnStruckByLightningInferiors(String[] var1) {
      this.beforeOnStruckByLightningInferiors = var1;
   }

   public void setOverrideOnStruckByLightningSuperiors(String[] var1) {
      this.overrideOnStruckByLightningSuperiors = var1;
   }

   public void setOverrideOnStruckByLightningInferiors(String[] var1) {
      this.overrideOnStruckByLightningInferiors = var1;
   }

   public void setAfterOnStruckByLightningSuperiors(String[] var1) {
      this.afterOnStruckByLightningSuperiors = var1;
   }

   public void setAfterOnStruckByLightningInferiors(String[] var1) {
      this.afterOnStruckByLightningInferiors = var1;
   }

   public String[] getBeforeOnUpdateSuperiors() {
      return this.beforeOnUpdateSuperiors;
   }

   public String[] getBeforeOnUpdateInferiors() {
      return this.beforeOnUpdateInferiors;
   }

   public String[] getOverrideOnUpdateSuperiors() {
      return this.overrideOnUpdateSuperiors;
   }

   public String[] getOverrideOnUpdateInferiors() {
      return this.overrideOnUpdateInferiors;
   }

   public String[] getAfterOnUpdateSuperiors() {
      return this.afterOnUpdateSuperiors;
   }

   public String[] getAfterOnUpdateInferiors() {
      return this.afterOnUpdateInferiors;
   }

   public void setBeforeOnUpdateSuperiors(String[] var1) {
      this.beforeOnUpdateSuperiors = var1;
   }

   public void setBeforeOnUpdateInferiors(String[] var1) {
      this.beforeOnUpdateInferiors = var1;
   }

   public void setOverrideOnUpdateSuperiors(String[] var1) {
      this.overrideOnUpdateSuperiors = var1;
   }

   public void setOverrideOnUpdateInferiors(String[] var1) {
      this.overrideOnUpdateInferiors = var1;
   }

   public void setAfterOnUpdateSuperiors(String[] var1) {
      this.afterOnUpdateSuperiors = var1;
   }

   public void setAfterOnUpdateInferiors(String[] var1) {
      this.afterOnUpdateInferiors = var1;
   }

   public String[] getBeforeOnUpdateEntitySuperiors() {
      return this.beforeOnUpdateEntitySuperiors;
   }

   public String[] getBeforeOnUpdateEntityInferiors() {
      return this.beforeOnUpdateEntityInferiors;
   }

   public String[] getOverrideOnUpdateEntitySuperiors() {
      return this.overrideOnUpdateEntitySuperiors;
   }

   public String[] getOverrideOnUpdateEntityInferiors() {
      return this.overrideOnUpdateEntityInferiors;
   }

   public String[] getAfterOnUpdateEntitySuperiors() {
      return this.afterOnUpdateEntitySuperiors;
   }

   public String[] getAfterOnUpdateEntityInferiors() {
      return this.afterOnUpdateEntityInferiors;
   }

   public void setBeforeOnUpdateEntitySuperiors(String[] var1) {
      this.beforeOnUpdateEntitySuperiors = var1;
   }

   public void setBeforeOnUpdateEntityInferiors(String[] var1) {
      this.beforeOnUpdateEntityInferiors = var1;
   }

   public void setOverrideOnUpdateEntitySuperiors(String[] var1) {
      this.overrideOnUpdateEntitySuperiors = var1;
   }

   public void setOverrideOnUpdateEntityInferiors(String[] var1) {
      this.overrideOnUpdateEntityInferiors = var1;
   }

   public void setAfterOnUpdateEntitySuperiors(String[] var1) {
      this.afterOnUpdateEntitySuperiors = var1;
   }

   public void setAfterOnUpdateEntityInferiors(String[] var1) {
      this.afterOnUpdateEntityInferiors = var1;
   }

   public String[] getBeforeReadEntityFromNBTSuperiors() {
      return this.beforeReadEntityFromNBTSuperiors;
   }

   public String[] getBeforeReadEntityFromNBTInferiors() {
      return this.beforeReadEntityFromNBTInferiors;
   }

   public String[] getOverrideReadEntityFromNBTSuperiors() {
      return this.overrideReadEntityFromNBTSuperiors;
   }

   public String[] getOverrideReadEntityFromNBTInferiors() {
      return this.overrideReadEntityFromNBTInferiors;
   }

   public String[] getAfterReadEntityFromNBTSuperiors() {
      return this.afterReadEntityFromNBTSuperiors;
   }

   public String[] getAfterReadEntityFromNBTInferiors() {
      return this.afterReadEntityFromNBTInferiors;
   }

   public void setBeforeReadEntityFromNBTSuperiors(String[] var1) {
      this.beforeReadEntityFromNBTSuperiors = var1;
   }

   public void setBeforeReadEntityFromNBTInferiors(String[] var1) {
      this.beforeReadEntityFromNBTInferiors = var1;
   }

   public void setOverrideReadEntityFromNBTSuperiors(String[] var1) {
      this.overrideReadEntityFromNBTSuperiors = var1;
   }

   public void setOverrideReadEntityFromNBTInferiors(String[] var1) {
      this.overrideReadEntityFromNBTInferiors = var1;
   }

   public void setAfterReadEntityFromNBTSuperiors(String[] var1) {
      this.afterReadEntityFromNBTSuperiors = var1;
   }

   public void setAfterReadEntityFromNBTInferiors(String[] var1) {
      this.afterReadEntityFromNBTInferiors = var1;
   }

   public String[] getBeforeSetDeadSuperiors() {
      return this.beforeSetDeadSuperiors;
   }

   public String[] getBeforeSetDeadInferiors() {
      return this.beforeSetDeadInferiors;
   }

   public String[] getOverrideSetDeadSuperiors() {
      return this.overrideSetDeadSuperiors;
   }

   public String[] getOverrideSetDeadInferiors() {
      return this.overrideSetDeadInferiors;
   }

   public String[] getAfterSetDeadSuperiors() {
      return this.afterSetDeadSuperiors;
   }

   public String[] getAfterSetDeadInferiors() {
      return this.afterSetDeadInferiors;
   }

   public void setBeforeSetDeadSuperiors(String[] var1) {
      this.beforeSetDeadSuperiors = var1;
   }

   public void setBeforeSetDeadInferiors(String[] var1) {
      this.beforeSetDeadInferiors = var1;
   }

   public void setOverrideSetDeadSuperiors(String[] var1) {
      this.overrideSetDeadSuperiors = var1;
   }

   public void setOverrideSetDeadInferiors(String[] var1) {
      this.overrideSetDeadInferiors = var1;
   }

   public void setAfterSetDeadSuperiors(String[] var1) {
      this.afterSetDeadSuperiors = var1;
   }

   public void setAfterSetDeadInferiors(String[] var1) {
      this.afterSetDeadInferiors = var1;
   }

   public String[] getBeforeSetEntityActionStateSuperiors() {
      return this.beforeSetEntityActionStateSuperiors;
   }

   public String[] getBeforeSetEntityActionStateInferiors() {
      return this.beforeSetEntityActionStateInferiors;
   }

   public String[] getOverrideSetEntityActionStateSuperiors() {
      return this.overrideSetEntityActionStateSuperiors;
   }

   public String[] getOverrideSetEntityActionStateInferiors() {
      return this.overrideSetEntityActionStateInferiors;
   }

   public String[] getAfterSetEntityActionStateSuperiors() {
      return this.afterSetEntityActionStateSuperiors;
   }

   public String[] getAfterSetEntityActionStateInferiors() {
      return this.afterSetEntityActionStateInferiors;
   }

   public void setBeforeSetEntityActionStateSuperiors(String[] var1) {
      this.beforeSetEntityActionStateSuperiors = var1;
   }

   public void setBeforeSetEntityActionStateInferiors(String[] var1) {
      this.beforeSetEntityActionStateInferiors = var1;
   }

   public void setOverrideSetEntityActionStateSuperiors(String[] var1) {
      this.overrideSetEntityActionStateSuperiors = var1;
   }

   public void setOverrideSetEntityActionStateInferiors(String[] var1) {
      this.overrideSetEntityActionStateInferiors = var1;
   }

   public void setAfterSetEntityActionStateSuperiors(String[] var1) {
      this.afterSetEntityActionStateSuperiors = var1;
   }

   public void setAfterSetEntityActionStateInferiors(String[] var1) {
      this.afterSetEntityActionStateInferiors = var1;
   }

   public String[] getBeforeSetPositionSuperiors() {
      return this.beforeSetPositionSuperiors;
   }

   public String[] getBeforeSetPositionInferiors() {
      return this.beforeSetPositionInferiors;
   }

   public String[] getOverrideSetPositionSuperiors() {
      return this.overrideSetPositionSuperiors;
   }

   public String[] getOverrideSetPositionInferiors() {
      return this.overrideSetPositionInferiors;
   }

   public String[] getAfterSetPositionSuperiors() {
      return this.afterSetPositionSuperiors;
   }

   public String[] getAfterSetPositionInferiors() {
      return this.afterSetPositionInferiors;
   }

   public void setBeforeSetPositionSuperiors(String[] var1) {
      this.beforeSetPositionSuperiors = var1;
   }

   public void setBeforeSetPositionInferiors(String[] var1) {
      this.beforeSetPositionInferiors = var1;
   }

   public void setOverrideSetPositionSuperiors(String[] var1) {
      this.overrideSetPositionSuperiors = var1;
   }

   public void setOverrideSetPositionInferiors(String[] var1) {
      this.overrideSetPositionInferiors = var1;
   }

   public void setAfterSetPositionSuperiors(String[] var1) {
      this.afterSetPositionSuperiors = var1;
   }

   public void setAfterSetPositionInferiors(String[] var1) {
      this.afterSetPositionInferiors = var1;
   }

   public String[] getBeforeSetSneakingSuperiors() {
      return this.beforeSetSneakingSuperiors;
   }

   public String[] getBeforeSetSneakingInferiors() {
      return this.beforeSetSneakingInferiors;
   }

   public String[] getOverrideSetSneakingSuperiors() {
      return this.overrideSetSneakingSuperiors;
   }

   public String[] getOverrideSetSneakingInferiors() {
      return this.overrideSetSneakingInferiors;
   }

   public String[] getAfterSetSneakingSuperiors() {
      return this.afterSetSneakingSuperiors;
   }

   public String[] getAfterSetSneakingInferiors() {
      return this.afterSetSneakingInferiors;
   }

   public void setBeforeSetSneakingSuperiors(String[] var1) {
      this.beforeSetSneakingSuperiors = var1;
   }

   public void setBeforeSetSneakingInferiors(String[] var1) {
      this.beforeSetSneakingInferiors = var1;
   }

   public void setOverrideSetSneakingSuperiors(String[] var1) {
      this.overrideSetSneakingSuperiors = var1;
   }

   public void setOverrideSetSneakingInferiors(String[] var1) {
      this.overrideSetSneakingInferiors = var1;
   }

   public void setAfterSetSneakingSuperiors(String[] var1) {
      this.afterSetSneakingSuperiors = var1;
   }

   public void setAfterSetSneakingInferiors(String[] var1) {
      this.afterSetSneakingInferiors = var1;
   }

   public String[] getBeforeSetSprintingSuperiors() {
      return this.beforeSetSprintingSuperiors;
   }

   public String[] getBeforeSetSprintingInferiors() {
      return this.beforeSetSprintingInferiors;
   }

   public String[] getOverrideSetSprintingSuperiors() {
      return this.overrideSetSprintingSuperiors;
   }

   public String[] getOverrideSetSprintingInferiors() {
      return this.overrideSetSprintingInferiors;
   }

   public String[] getAfterSetSprintingSuperiors() {
      return this.afterSetSprintingSuperiors;
   }

   public String[] getAfterSetSprintingInferiors() {
      return this.afterSetSprintingInferiors;
   }

   public void setBeforeSetSprintingSuperiors(String[] var1) {
      this.beforeSetSprintingSuperiors = var1;
   }

   public void setBeforeSetSprintingInferiors(String[] var1) {
      this.beforeSetSprintingInferiors = var1;
   }

   public void setOverrideSetSprintingSuperiors(String[] var1) {
      this.overrideSetSprintingSuperiors = var1;
   }

   public void setOverrideSetSprintingInferiors(String[] var1) {
      this.overrideSetSprintingInferiors = var1;
   }

   public void setAfterSetSprintingSuperiors(String[] var1) {
      this.afterSetSprintingSuperiors = var1;
   }

   public void setAfterSetSprintingInferiors(String[] var1) {
      this.afterSetSprintingInferiors = var1;
   }

   public String[] getBeforeSwingItemSuperiors() {
      return this.beforeSwingItemSuperiors;
   }

   public String[] getBeforeSwingItemInferiors() {
      return this.beforeSwingItemInferiors;
   }

   public String[] getOverrideSwingItemSuperiors() {
      return this.overrideSwingItemSuperiors;
   }

   public String[] getOverrideSwingItemInferiors() {
      return this.overrideSwingItemInferiors;
   }

   public String[] getAfterSwingItemSuperiors() {
      return this.afterSwingItemSuperiors;
   }

   public String[] getAfterSwingItemInferiors() {
      return this.afterSwingItemInferiors;
   }

   public void setBeforeSwingItemSuperiors(String[] var1) {
      this.beforeSwingItemSuperiors = var1;
   }

   public void setBeforeSwingItemInferiors(String[] var1) {
      this.beforeSwingItemInferiors = var1;
   }

   public void setOverrideSwingItemSuperiors(String[] var1) {
      this.overrideSwingItemSuperiors = var1;
   }

   public void setOverrideSwingItemInferiors(String[] var1) {
      this.overrideSwingItemInferiors = var1;
   }

   public void setAfterSwingItemSuperiors(String[] var1) {
      this.afterSwingItemSuperiors = var1;
   }

   public void setAfterSwingItemInferiors(String[] var1) {
      this.afterSwingItemInferiors = var1;
   }

   public String[] getBeforeUpdateEntityActionStateSuperiors() {
      return this.beforeUpdateEntityActionStateSuperiors;
   }

   public String[] getBeforeUpdateEntityActionStateInferiors() {
      return this.beforeUpdateEntityActionStateInferiors;
   }

   public String[] getOverrideUpdateEntityActionStateSuperiors() {
      return this.overrideUpdateEntityActionStateSuperiors;
   }

   public String[] getOverrideUpdateEntityActionStateInferiors() {
      return this.overrideUpdateEntityActionStateInferiors;
   }

   public String[] getAfterUpdateEntityActionStateSuperiors() {
      return this.afterUpdateEntityActionStateSuperiors;
   }

   public String[] getAfterUpdateEntityActionStateInferiors() {
      return this.afterUpdateEntityActionStateInferiors;
   }

   public void setBeforeUpdateEntityActionStateSuperiors(String[] var1) {
      this.beforeUpdateEntityActionStateSuperiors = var1;
   }

   public void setBeforeUpdateEntityActionStateInferiors(String[] var1) {
      this.beforeUpdateEntityActionStateInferiors = var1;
   }

   public void setOverrideUpdateEntityActionStateSuperiors(String[] var1) {
      this.overrideUpdateEntityActionStateSuperiors = var1;
   }

   public void setOverrideUpdateEntityActionStateInferiors(String[] var1) {
      this.overrideUpdateEntityActionStateInferiors = var1;
   }

   public void setAfterUpdateEntityActionStateSuperiors(String[] var1) {
      this.afterUpdateEntityActionStateSuperiors = var1;
   }

   public void setAfterUpdateEntityActionStateInferiors(String[] var1) {
      this.afterUpdateEntityActionStateInferiors = var1;
   }

   public String[] getBeforeUpdatePotionEffectsSuperiors() {
      return this.beforeUpdatePotionEffectsSuperiors;
   }

   public String[] getBeforeUpdatePotionEffectsInferiors() {
      return this.beforeUpdatePotionEffectsInferiors;
   }

   public String[] getOverrideUpdatePotionEffectsSuperiors() {
      return this.overrideUpdatePotionEffectsSuperiors;
   }

   public String[] getOverrideUpdatePotionEffectsInferiors() {
      return this.overrideUpdatePotionEffectsInferiors;
   }

   public String[] getAfterUpdatePotionEffectsSuperiors() {
      return this.afterUpdatePotionEffectsSuperiors;
   }

   public String[] getAfterUpdatePotionEffectsInferiors() {
      return this.afterUpdatePotionEffectsInferiors;
   }

   public void setBeforeUpdatePotionEffectsSuperiors(String[] var1) {
      this.beforeUpdatePotionEffectsSuperiors = var1;
   }

   public void setBeforeUpdatePotionEffectsInferiors(String[] var1) {
      this.beforeUpdatePotionEffectsInferiors = var1;
   }

   public void setOverrideUpdatePotionEffectsSuperiors(String[] var1) {
      this.overrideUpdatePotionEffectsSuperiors = var1;
   }

   public void setOverrideUpdatePotionEffectsInferiors(String[] var1) {
      this.overrideUpdatePotionEffectsInferiors = var1;
   }

   public void setAfterUpdatePotionEffectsSuperiors(String[] var1) {
      this.afterUpdatePotionEffectsSuperiors = var1;
   }

   public void setAfterUpdatePotionEffectsInferiors(String[] var1) {
      this.afterUpdatePotionEffectsInferiors = var1;
   }

   public String[] getBeforeUpdateRiddenSuperiors() {
      return this.beforeUpdateRiddenSuperiors;
   }

   public String[] getBeforeUpdateRiddenInferiors() {
      return this.beforeUpdateRiddenInferiors;
   }

   public String[] getOverrideUpdateRiddenSuperiors() {
      return this.overrideUpdateRiddenSuperiors;
   }

   public String[] getOverrideUpdateRiddenInferiors() {
      return this.overrideUpdateRiddenInferiors;
   }

   public String[] getAfterUpdateRiddenSuperiors() {
      return this.afterUpdateRiddenSuperiors;
   }

   public String[] getAfterUpdateRiddenInferiors() {
      return this.afterUpdateRiddenInferiors;
   }

   public void setBeforeUpdateRiddenSuperiors(String[] var1) {
      this.beforeUpdateRiddenSuperiors = var1;
   }

   public void setBeforeUpdateRiddenInferiors(String[] var1) {
      this.beforeUpdateRiddenInferiors = var1;
   }

   public void setOverrideUpdateRiddenSuperiors(String[] var1) {
      this.overrideUpdateRiddenSuperiors = var1;
   }

   public void setOverrideUpdateRiddenInferiors(String[] var1) {
      this.overrideUpdateRiddenInferiors = var1;
   }

   public void setAfterUpdateRiddenSuperiors(String[] var1) {
      this.afterUpdateRiddenSuperiors = var1;
   }

   public void setAfterUpdateRiddenInferiors(String[] var1) {
      this.afterUpdateRiddenInferiors = var1;
   }

   public String[] getBeforeWakeUpPlayerSuperiors() {
      return this.beforeWakeUpPlayerSuperiors;
   }

   public String[] getBeforeWakeUpPlayerInferiors() {
      return this.beforeWakeUpPlayerInferiors;
   }

   public String[] getOverrideWakeUpPlayerSuperiors() {
      return this.overrideWakeUpPlayerSuperiors;
   }

   public String[] getOverrideWakeUpPlayerInferiors() {
      return this.overrideWakeUpPlayerInferiors;
   }

   public String[] getAfterWakeUpPlayerSuperiors() {
      return this.afterWakeUpPlayerSuperiors;
   }

   public String[] getAfterWakeUpPlayerInferiors() {
      return this.afterWakeUpPlayerInferiors;
   }

   public void setBeforeWakeUpPlayerSuperiors(String[] var1) {
      this.beforeWakeUpPlayerSuperiors = var1;
   }

   public void setBeforeWakeUpPlayerInferiors(String[] var1) {
      this.beforeWakeUpPlayerInferiors = var1;
   }

   public void setOverrideWakeUpPlayerSuperiors(String[] var1) {
      this.overrideWakeUpPlayerSuperiors = var1;
   }

   public void setOverrideWakeUpPlayerInferiors(String[] var1) {
      this.overrideWakeUpPlayerInferiors = var1;
   }

   public void setAfterWakeUpPlayerSuperiors(String[] var1) {
      this.afterWakeUpPlayerSuperiors = var1;
   }

   public void setAfterWakeUpPlayerInferiors(String[] var1) {
      this.afterWakeUpPlayerInferiors = var1;
   }

   public String[] getBeforeWriteEntityToNBTSuperiors() {
      return this.beforeWriteEntityToNBTSuperiors;
   }

   public String[] getBeforeWriteEntityToNBTInferiors() {
      return this.beforeWriteEntityToNBTInferiors;
   }

   public String[] getOverrideWriteEntityToNBTSuperiors() {
      return this.overrideWriteEntityToNBTSuperiors;
   }

   public String[] getOverrideWriteEntityToNBTInferiors() {
      return this.overrideWriteEntityToNBTInferiors;
   }

   public String[] getAfterWriteEntityToNBTSuperiors() {
      return this.afterWriteEntityToNBTSuperiors;
   }

   public String[] getAfterWriteEntityToNBTInferiors() {
      return this.afterWriteEntityToNBTInferiors;
   }

   public void setBeforeWriteEntityToNBTSuperiors(String[] var1) {
      this.beforeWriteEntityToNBTSuperiors = var1;
   }

   public void setBeforeWriteEntityToNBTInferiors(String[] var1) {
      this.beforeWriteEntityToNBTInferiors = var1;
   }

   public void setOverrideWriteEntityToNBTSuperiors(String[] var1) {
      this.overrideWriteEntityToNBTSuperiors = var1;
   }

   public void setOverrideWriteEntityToNBTInferiors(String[] var1) {
      this.overrideWriteEntityToNBTInferiors = var1;
   }

   public void setAfterWriteEntityToNBTSuperiors(String[] var1) {
      this.afterWriteEntityToNBTSuperiors = var1;
   }

   public void setAfterWriteEntityToNBTInferiors(String[] var1) {
      this.afterWriteEntityToNBTInferiors = var1;
   }
}
