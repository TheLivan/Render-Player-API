package api.player.server;

import api.player.forge.PlayerAPIPlugin;
import api.player.server.IServerPlayerAPI;
import api.player.server.ServerPlayerBase;
import api.player.server.ServerPlayerBaseSorter;
import api.player.server.ServerPlayerBaseSorting;
import com.mojang.authlib.GameProfile;
import java.io.File;
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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldServer;

public final class ServerPlayerAPI {

   private static final Class[] Class = new Class[]{ServerPlayerAPI.class};
   private static final Class[] Classes = new Class[]{ServerPlayerAPI.class, String.class};
   private static boolean isCreated;
   private static final Logger logger = Logger.getLogger("ServerPlayerAPI");
   private static final Map EmptySortMap = Collections.unmodifiableMap(new HashMap());
   private static final List beforeAddExhaustionHookTypes = new LinkedList();
   private static final List overrideAddExhaustionHookTypes = new LinkedList();
   private static final List afterAddExhaustionHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeAddExhaustionHooks;
   private ServerPlayerBase[] overrideAddExhaustionHooks;
   private ServerPlayerBase[] afterAddExhaustionHooks;
   public boolean isAddExhaustionModded;
   private static final Map allBaseBeforeAddExhaustionSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeAddExhaustionInferiors = new Hashtable(0);
   private static final Map allBaseOverrideAddExhaustionSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideAddExhaustionInferiors = new Hashtable(0);
   private static final Map allBaseAfterAddExhaustionSuperiors = new Hashtable(0);
   private static final Map allBaseAfterAddExhaustionInferiors = new Hashtable(0);
   private static final List beforeAddExperienceHookTypes = new LinkedList();
   private static final List overrideAddExperienceHookTypes = new LinkedList();
   private static final List afterAddExperienceHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeAddExperienceHooks;
   private ServerPlayerBase[] overrideAddExperienceHooks;
   private ServerPlayerBase[] afterAddExperienceHooks;
   public boolean isAddExperienceModded;
   private static final Map allBaseBeforeAddExperienceSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeAddExperienceInferiors = new Hashtable(0);
   private static final Map allBaseOverrideAddExperienceSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideAddExperienceInferiors = new Hashtable(0);
   private static final Map allBaseAfterAddExperienceSuperiors = new Hashtable(0);
   private static final Map allBaseAfterAddExperienceInferiors = new Hashtable(0);
   private static final List beforeAddExperienceLevelHookTypes = new LinkedList();
   private static final List overrideAddExperienceLevelHookTypes = new LinkedList();
   private static final List afterAddExperienceLevelHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeAddExperienceLevelHooks;
   private ServerPlayerBase[] overrideAddExperienceLevelHooks;
   private ServerPlayerBase[] afterAddExperienceLevelHooks;
   public boolean isAddExperienceLevelModded;
   private static final Map allBaseBeforeAddExperienceLevelSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeAddExperienceLevelInferiors = new Hashtable(0);
   private static final Map allBaseOverrideAddExperienceLevelSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideAddExperienceLevelInferiors = new Hashtable(0);
   private static final Map allBaseAfterAddExperienceLevelSuperiors = new Hashtable(0);
   private static final Map allBaseAfterAddExperienceLevelInferiors = new Hashtable(0);
   private static final List beforeAddMovementStatHookTypes = new LinkedList();
   private static final List overrideAddMovementStatHookTypes = new LinkedList();
   private static final List afterAddMovementStatHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeAddMovementStatHooks;
   private ServerPlayerBase[] overrideAddMovementStatHooks;
   private ServerPlayerBase[] afterAddMovementStatHooks;
   public boolean isAddMovementStatModded;
   private static final Map allBaseBeforeAddMovementStatSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeAddMovementStatInferiors = new Hashtable(0);
   private static final Map allBaseOverrideAddMovementStatSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideAddMovementStatInferiors = new Hashtable(0);
   private static final Map allBaseAfterAddMovementStatSuperiors = new Hashtable(0);
   private static final Map allBaseAfterAddMovementStatInferiors = new Hashtable(0);
   private static final List beforeAttackEntityFromHookTypes = new LinkedList();
   private static final List overrideAttackEntityFromHookTypes = new LinkedList();
   private static final List afterAttackEntityFromHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeAttackEntityFromHooks;
   private ServerPlayerBase[] overrideAttackEntityFromHooks;
   private ServerPlayerBase[] afterAttackEntityFromHooks;
   public boolean isAttackEntityFromModded;
   private static final Map allBaseBeforeAttackEntityFromSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeAttackEntityFromInferiors = new Hashtable(0);
   private static final Map allBaseOverrideAttackEntityFromSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideAttackEntityFromInferiors = new Hashtable(0);
   private static final Map allBaseAfterAttackEntityFromSuperiors = new Hashtable(0);
   private static final Map allBaseAfterAttackEntityFromInferiors = new Hashtable(0);
   private static final List beforeAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
   private static final List overrideAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
   private static final List afterAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeAttackTargetEntityWithCurrentItemHooks;
   private ServerPlayerBase[] overrideAttackTargetEntityWithCurrentItemHooks;
   private ServerPlayerBase[] afterAttackTargetEntityWithCurrentItemHooks;
   public boolean isAttackTargetEntityWithCurrentItemModded;
   private static final Map allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeAttackTargetEntityWithCurrentItemInferiors = new Hashtable(0);
   private static final Map allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideAttackTargetEntityWithCurrentItemInferiors = new Hashtable(0);
   private static final Map allBaseAfterAttackTargetEntityWithCurrentItemSuperiors = new Hashtable(0);
   private static final Map allBaseAfterAttackTargetEntityWithCurrentItemInferiors = new Hashtable(0);
   private static final List beforeCanBreatheUnderwaterHookTypes = new LinkedList();
   private static final List overrideCanBreatheUnderwaterHookTypes = new LinkedList();
   private static final List afterCanBreatheUnderwaterHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeCanBreatheUnderwaterHooks;
   private ServerPlayerBase[] overrideCanBreatheUnderwaterHooks;
   private ServerPlayerBase[] afterCanBreatheUnderwaterHooks;
   public boolean isCanBreatheUnderwaterModded;
   private static final Map allBaseBeforeCanBreatheUnderwaterSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeCanBreatheUnderwaterInferiors = new Hashtable(0);
   private static final Map allBaseOverrideCanBreatheUnderwaterSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideCanBreatheUnderwaterInferiors = new Hashtable(0);
   private static final Map allBaseAfterCanBreatheUnderwaterSuperiors = new Hashtable(0);
   private static final Map allBaseAfterCanBreatheUnderwaterInferiors = new Hashtable(0);
   private static final List beforeCanHarvestBlockHookTypes = new LinkedList();
   private static final List overrideCanHarvestBlockHookTypes = new LinkedList();
   private static final List afterCanHarvestBlockHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeCanHarvestBlockHooks;
   private ServerPlayerBase[] overrideCanHarvestBlockHooks;
   private ServerPlayerBase[] afterCanHarvestBlockHooks;
   public boolean isCanHarvestBlockModded;
   private static final Map allBaseBeforeCanHarvestBlockSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeCanHarvestBlockInferiors = new Hashtable(0);
   private static final Map allBaseOverrideCanHarvestBlockSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideCanHarvestBlockInferiors = new Hashtable(0);
   private static final Map allBaseAfterCanHarvestBlockSuperiors = new Hashtable(0);
   private static final Map allBaseAfterCanHarvestBlockInferiors = new Hashtable(0);
   private static final List beforeCanPlayerEditHookTypes = new LinkedList();
   private static final List overrideCanPlayerEditHookTypes = new LinkedList();
   private static final List afterCanPlayerEditHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeCanPlayerEditHooks;
   private ServerPlayerBase[] overrideCanPlayerEditHooks;
   private ServerPlayerBase[] afterCanPlayerEditHooks;
   public boolean isCanPlayerEditModded;
   private static final Map allBaseBeforeCanPlayerEditSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeCanPlayerEditInferiors = new Hashtable(0);
   private static final Map allBaseOverrideCanPlayerEditSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideCanPlayerEditInferiors = new Hashtable(0);
   private static final Map allBaseAfterCanPlayerEditSuperiors = new Hashtable(0);
   private static final Map allBaseAfterCanPlayerEditInferiors = new Hashtable(0);
   private static final List beforeCanTriggerWalkingHookTypes = new LinkedList();
   private static final List overrideCanTriggerWalkingHookTypes = new LinkedList();
   private static final List afterCanTriggerWalkingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeCanTriggerWalkingHooks;
   private ServerPlayerBase[] overrideCanTriggerWalkingHooks;
   private ServerPlayerBase[] afterCanTriggerWalkingHooks;
   public boolean isCanTriggerWalkingModded;
   private static final Map allBaseBeforeCanTriggerWalkingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeCanTriggerWalkingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideCanTriggerWalkingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideCanTriggerWalkingInferiors = new Hashtable(0);
   private static final Map allBaseAfterCanTriggerWalkingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterCanTriggerWalkingInferiors = new Hashtable(0);
   private static final List beforeClonePlayerHookTypes = new LinkedList();
   private static final List overrideClonePlayerHookTypes = new LinkedList();
   private static final List afterClonePlayerHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeClonePlayerHooks;
   private ServerPlayerBase[] overrideClonePlayerHooks;
   private ServerPlayerBase[] afterClonePlayerHooks;
   public boolean isClonePlayerModded;
   private static final Map allBaseBeforeClonePlayerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeClonePlayerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideClonePlayerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideClonePlayerInferiors = new Hashtable(0);
   private static final Map allBaseAfterClonePlayerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterClonePlayerInferiors = new Hashtable(0);
   private static final List beforeDamageEntityHookTypes = new LinkedList();
   private static final List overrideDamageEntityHookTypes = new LinkedList();
   private static final List afterDamageEntityHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDamageEntityHooks;
   private ServerPlayerBase[] overrideDamageEntityHooks;
   private ServerPlayerBase[] afterDamageEntityHooks;
   public boolean isDamageEntityModded;
   private static final Map allBaseBeforeDamageEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDamageEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDamageEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDamageEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterDamageEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterDamageEntityInferiors = new Hashtable(0);
   private static final List beforeDisplayGUIChestHookTypes = new LinkedList();
   private static final List overrideDisplayGUIChestHookTypes = new LinkedList();
   private static final List afterDisplayGUIChestHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDisplayGUIChestHooks;
   private ServerPlayerBase[] overrideDisplayGUIChestHooks;
   private ServerPlayerBase[] afterDisplayGUIChestHooks;
   public boolean isDisplayGUIChestModded;
   private static final Map allBaseBeforeDisplayGUIChestSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDisplayGUIChestInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIChestSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIChestInferiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIChestSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIChestInferiors = new Hashtable(0);
   private static final List beforeDisplayGUIDispenserHookTypes = new LinkedList();
   private static final List overrideDisplayGUIDispenserHookTypes = new LinkedList();
   private static final List afterDisplayGUIDispenserHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDisplayGUIDispenserHooks;
   private ServerPlayerBase[] overrideDisplayGUIDispenserHooks;
   private ServerPlayerBase[] afterDisplayGUIDispenserHooks;
   public boolean isDisplayGUIDispenserModded;
   private static final Map allBaseBeforeDisplayGUIDispenserSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDisplayGUIDispenserInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIDispenserSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIDispenserInferiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIDispenserSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIDispenserInferiors = new Hashtable(0);
   private static final List beforeDisplayGUIFurnaceHookTypes = new LinkedList();
   private static final List overrideDisplayGUIFurnaceHookTypes = new LinkedList();
   private static final List afterDisplayGUIFurnaceHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDisplayGUIFurnaceHooks;
   private ServerPlayerBase[] overrideDisplayGUIFurnaceHooks;
   private ServerPlayerBase[] afterDisplayGUIFurnaceHooks;
   public boolean isDisplayGUIFurnaceModded;
   private static final Map allBaseBeforeDisplayGUIFurnaceSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDisplayGUIFurnaceInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIFurnaceSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIFurnaceInferiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIFurnaceSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIFurnaceInferiors = new Hashtable(0);
   private static final List beforeDisplayGUIWorkbenchHookTypes = new LinkedList();
   private static final List overrideDisplayGUIWorkbenchHookTypes = new LinkedList();
   private static final List afterDisplayGUIWorkbenchHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDisplayGUIWorkbenchHooks;
   private ServerPlayerBase[] overrideDisplayGUIWorkbenchHooks;
   private ServerPlayerBase[] afterDisplayGUIWorkbenchHooks;
   public boolean isDisplayGUIWorkbenchModded;
   private static final Map allBaseBeforeDisplayGUIWorkbenchSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDisplayGUIWorkbenchInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIWorkbenchSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDisplayGUIWorkbenchInferiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIWorkbenchSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDisplayGUIWorkbenchInferiors = new Hashtable(0);
   private static final List beforeDropOneItemHookTypes = new LinkedList();
   private static final List overrideDropOneItemHookTypes = new LinkedList();
   private static final List afterDropOneItemHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDropOneItemHooks;
   private ServerPlayerBase[] overrideDropOneItemHooks;
   private ServerPlayerBase[] afterDropOneItemHooks;
   public boolean isDropOneItemModded;
   private static final Map allBaseBeforeDropOneItemSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDropOneItemInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDropOneItemSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDropOneItemInferiors = new Hashtable(0);
   private static final Map allBaseAfterDropOneItemSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDropOneItemInferiors = new Hashtable(0);
   private static final List beforeDropPlayerItemHookTypes = new LinkedList();
   private static final List overrideDropPlayerItemHookTypes = new LinkedList();
   private static final List afterDropPlayerItemHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeDropPlayerItemHooks;
   private ServerPlayerBase[] overrideDropPlayerItemHooks;
   private ServerPlayerBase[] afterDropPlayerItemHooks;
   public boolean isDropPlayerItemModded;
   private static final Map allBaseBeforeDropPlayerItemSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeDropPlayerItemInferiors = new Hashtable(0);
   private static final Map allBaseOverrideDropPlayerItemSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideDropPlayerItemInferiors = new Hashtable(0);
   private static final Map allBaseAfterDropPlayerItemSuperiors = new Hashtable(0);
   private static final Map allBaseAfterDropPlayerItemInferiors = new Hashtable(0);
   private static final List beforeFallHookTypes = new LinkedList();
   private static final List overrideFallHookTypes = new LinkedList();
   private static final List afterFallHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeFallHooks;
   private ServerPlayerBase[] overrideFallHooks;
   private ServerPlayerBase[] afterFallHooks;
   public boolean isFallModded;
   private static final Map allBaseBeforeFallSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeFallInferiors = new Hashtable(0);
   private static final Map allBaseOverrideFallSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideFallInferiors = new Hashtable(0);
   private static final Map allBaseAfterFallSuperiors = new Hashtable(0);
   private static final Map allBaseAfterFallInferiors = new Hashtable(0);
   private static final List beforeGetAIMoveSpeedHookTypes = new LinkedList();
   private static final List overrideGetAIMoveSpeedHookTypes = new LinkedList();
   private static final List afterGetAIMoveSpeedHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeGetAIMoveSpeedHooks;
   private ServerPlayerBase[] overrideGetAIMoveSpeedHooks;
   private ServerPlayerBase[] afterGetAIMoveSpeedHooks;
   public boolean isGetAIMoveSpeedModded;
   private static final Map allBaseBeforeGetAIMoveSpeedSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetAIMoveSpeedInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetAIMoveSpeedSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetAIMoveSpeedInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetAIMoveSpeedSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetAIMoveSpeedInferiors = new Hashtable(0);
   private static final List beforeGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
   private static final List overrideGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
   private static final List afterGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeGetCurrentPlayerStrVsBlockHooks;
   private ServerPlayerBase[] overrideGetCurrentPlayerStrVsBlockHooks;
   private ServerPlayerBase[] afterGetCurrentPlayerStrVsBlockHooks;
   public boolean isGetCurrentPlayerStrVsBlockModded;
   private static final Map allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetCurrentPlayerStrVsBlockInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetCurrentPlayerStrVsBlockInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetCurrentPlayerStrVsBlockSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetCurrentPlayerStrVsBlockInferiors = new Hashtable(0);
   private static final List beforeGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList();
   private static final List overrideGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList();
   private static final List afterGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeGetCurrentPlayerStrVsBlockForgeHooks;
   private ServerPlayerBase[] overrideGetCurrentPlayerStrVsBlockForgeHooks;
   private ServerPlayerBase[] afterGetCurrentPlayerStrVsBlockForgeHooks;
   public boolean isGetCurrentPlayerStrVsBlockForgeModded;
   private static final Map allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable(0);
   private static final List beforeGetDistanceSqHookTypes = new LinkedList();
   private static final List overrideGetDistanceSqHookTypes = new LinkedList();
   private static final List afterGetDistanceSqHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeGetDistanceSqHooks;
   private ServerPlayerBase[] overrideGetDistanceSqHooks;
   private ServerPlayerBase[] afterGetDistanceSqHooks;
   public boolean isGetDistanceSqModded;
   private static final Map allBaseBeforeGetDistanceSqSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetDistanceSqInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetDistanceSqSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetDistanceSqInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetDistanceSqSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetDistanceSqInferiors = new Hashtable(0);
   private static final List beforeGetBrightnessHookTypes = new LinkedList();
   private static final List overrideGetBrightnessHookTypes = new LinkedList();
   private static final List afterGetBrightnessHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeGetBrightnessHooks;
   private ServerPlayerBase[] overrideGetBrightnessHooks;
   private ServerPlayerBase[] afterGetBrightnessHooks;
   public boolean isGetBrightnessModded;
   private static final Map allBaseBeforeGetBrightnessSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetBrightnessInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetBrightnessSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetBrightnessInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetBrightnessSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetBrightnessInferiors = new Hashtable(0);
   private static final List beforeGetEyeHeightHookTypes = new LinkedList();
   private static final List overrideGetEyeHeightHookTypes = new LinkedList();
   private static final List afterGetEyeHeightHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeGetEyeHeightHooks;
   private ServerPlayerBase[] overrideGetEyeHeightHooks;
   private ServerPlayerBase[] afterGetEyeHeightHooks;
   public boolean isGetEyeHeightModded;
   private static final Map allBaseBeforeGetEyeHeightSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeGetEyeHeightInferiors = new Hashtable(0);
   private static final Map allBaseOverrideGetEyeHeightSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideGetEyeHeightInferiors = new Hashtable(0);
   private static final Map allBaseAfterGetEyeHeightSuperiors = new Hashtable(0);
   private static final Map allBaseAfterGetEyeHeightInferiors = new Hashtable(0);
   private static final List beforeHealHookTypes = new LinkedList();
   private static final List overrideHealHookTypes = new LinkedList();
   private static final List afterHealHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeHealHooks;
   private ServerPlayerBase[] overrideHealHooks;
   private ServerPlayerBase[] afterHealHooks;
   public boolean isHealModded;
   private static final Map allBaseBeforeHealSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeHealInferiors = new Hashtable(0);
   private static final Map allBaseOverrideHealSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideHealInferiors = new Hashtable(0);
   private static final Map allBaseAfterHealSuperiors = new Hashtable(0);
   private static final Map allBaseAfterHealInferiors = new Hashtable(0);
   private static final List beforeIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
   private static final List overrideIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
   private static final List afterIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeIsEntityInsideOpaqueBlockHooks;
   private ServerPlayerBase[] overrideIsEntityInsideOpaqueBlockHooks;
   private ServerPlayerBase[] afterIsEntityInsideOpaqueBlockHooks;
   public boolean isIsEntityInsideOpaqueBlockModded;
   private static final Map allBaseBeforeIsEntityInsideOpaqueBlockSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeIsEntityInsideOpaqueBlockInferiors = new Hashtable(0);
   private static final Map allBaseOverrideIsEntityInsideOpaqueBlockSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideIsEntityInsideOpaqueBlockInferiors = new Hashtable(0);
   private static final Map allBaseAfterIsEntityInsideOpaqueBlockSuperiors = new Hashtable(0);
   private static final Map allBaseAfterIsEntityInsideOpaqueBlockInferiors = new Hashtable(0);
   private static final List beforeIsInWaterHookTypes = new LinkedList();
   private static final List overrideIsInWaterHookTypes = new LinkedList();
   private static final List afterIsInWaterHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeIsInWaterHooks;
   private ServerPlayerBase[] overrideIsInWaterHooks;
   private ServerPlayerBase[] afterIsInWaterHooks;
   public boolean isIsInWaterModded;
   private static final Map allBaseBeforeIsInWaterSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeIsInWaterInferiors = new Hashtable(0);
   private static final Map allBaseOverrideIsInWaterSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideIsInWaterInferiors = new Hashtable(0);
   private static final Map allBaseAfterIsInWaterSuperiors = new Hashtable(0);
   private static final Map allBaseAfterIsInWaterInferiors = new Hashtable(0);
   private static final List beforeIsInsideOfMaterialHookTypes = new LinkedList();
   private static final List overrideIsInsideOfMaterialHookTypes = new LinkedList();
   private static final List afterIsInsideOfMaterialHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeIsInsideOfMaterialHooks;
   private ServerPlayerBase[] overrideIsInsideOfMaterialHooks;
   private ServerPlayerBase[] afterIsInsideOfMaterialHooks;
   public boolean isIsInsideOfMaterialModded;
   private static final Map allBaseBeforeIsInsideOfMaterialSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeIsInsideOfMaterialInferiors = new Hashtable(0);
   private static final Map allBaseOverrideIsInsideOfMaterialSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideIsInsideOfMaterialInferiors = new Hashtable(0);
   private static final Map allBaseAfterIsInsideOfMaterialSuperiors = new Hashtable(0);
   private static final Map allBaseAfterIsInsideOfMaterialInferiors = new Hashtable(0);
   private static final List beforeIsOnLadderHookTypes = new LinkedList();
   private static final List overrideIsOnLadderHookTypes = new LinkedList();
   private static final List afterIsOnLadderHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeIsOnLadderHooks;
   private ServerPlayerBase[] overrideIsOnLadderHooks;
   private ServerPlayerBase[] afterIsOnLadderHooks;
   public boolean isIsOnLadderModded;
   private static final Map allBaseBeforeIsOnLadderSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeIsOnLadderInferiors = new Hashtable(0);
   private static final Map allBaseOverrideIsOnLadderSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideIsOnLadderInferiors = new Hashtable(0);
   private static final Map allBaseAfterIsOnLadderSuperiors = new Hashtable(0);
   private static final Map allBaseAfterIsOnLadderInferiors = new Hashtable(0);
   private static final List beforeIsPlayerSleepingHookTypes = new LinkedList();
   private static final List overrideIsPlayerSleepingHookTypes = new LinkedList();
   private static final List afterIsPlayerSleepingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeIsPlayerSleepingHooks;
   private ServerPlayerBase[] overrideIsPlayerSleepingHooks;
   private ServerPlayerBase[] afterIsPlayerSleepingHooks;
   public boolean isIsPlayerSleepingModded;
   private static final Map allBaseBeforeIsPlayerSleepingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeIsPlayerSleepingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideIsPlayerSleepingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideIsPlayerSleepingInferiors = new Hashtable(0);
   private static final Map allBaseAfterIsPlayerSleepingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterIsPlayerSleepingInferiors = new Hashtable(0);
   private static final List beforeIsSneakingHookTypes = new LinkedList();
   private static final List overrideIsSneakingHookTypes = new LinkedList();
   private static final List afterIsSneakingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeIsSneakingHooks;
   private ServerPlayerBase[] overrideIsSneakingHooks;
   private ServerPlayerBase[] afterIsSneakingHooks;
   public boolean isIsSneakingModded;
   private static final Map allBaseBeforeIsSneakingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeIsSneakingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideIsSneakingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideIsSneakingInferiors = new Hashtable(0);
   private static final Map allBaseAfterIsSneakingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterIsSneakingInferiors = new Hashtable(0);
   private static final List beforeJumpHookTypes = new LinkedList();
   private static final List overrideJumpHookTypes = new LinkedList();
   private static final List afterJumpHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeJumpHooks;
   private ServerPlayerBase[] overrideJumpHooks;
   private ServerPlayerBase[] afterJumpHooks;
   public boolean isJumpModded;
   private static final Map allBaseBeforeJumpSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeJumpInferiors = new Hashtable(0);
   private static final Map allBaseOverrideJumpSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideJumpInferiors = new Hashtable(0);
   private static final Map allBaseAfterJumpSuperiors = new Hashtable(0);
   private static final Map allBaseAfterJumpInferiors = new Hashtable(0);
   private static final List beforeKnockBackHookTypes = new LinkedList();
   private static final List overrideKnockBackHookTypes = new LinkedList();
   private static final List afterKnockBackHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeKnockBackHooks;
   private ServerPlayerBase[] overrideKnockBackHooks;
   private ServerPlayerBase[] afterKnockBackHooks;
   public boolean isKnockBackModded;
   private static final Map allBaseBeforeKnockBackSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeKnockBackInferiors = new Hashtable(0);
   private static final Map allBaseOverrideKnockBackSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideKnockBackInferiors = new Hashtable(0);
   private static final Map allBaseAfterKnockBackSuperiors = new Hashtable(0);
   private static final Map allBaseAfterKnockBackInferiors = new Hashtable(0);
   private static final List beforeMountEntityHookTypes = new LinkedList();
   private static final List overrideMountEntityHookTypes = new LinkedList();
   private static final List afterMountEntityHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeMountEntityHooks;
   private ServerPlayerBase[] overrideMountEntityHooks;
   private ServerPlayerBase[] afterMountEntityHooks;
   public boolean isMountEntityModded;
   private static final Map allBaseBeforeMountEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeMountEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideMountEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideMountEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterMountEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterMountEntityInferiors = new Hashtable(0);
   private static final List beforeMoveEntityHookTypes = new LinkedList();
   private static final List overrideMoveEntityHookTypes = new LinkedList();
   private static final List afterMoveEntityHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeMoveEntityHooks;
   private ServerPlayerBase[] overrideMoveEntityHooks;
   private ServerPlayerBase[] afterMoveEntityHooks;
   public boolean isMoveEntityModded;
   private static final Map allBaseBeforeMoveEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeMoveEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideMoveEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideMoveEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterMoveEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterMoveEntityInferiors = new Hashtable(0);
   private static final List beforeMoveEntityWithHeadingHookTypes = new LinkedList();
   private static final List overrideMoveEntityWithHeadingHookTypes = new LinkedList();
   private static final List afterMoveEntityWithHeadingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeMoveEntityWithHeadingHooks;
   private ServerPlayerBase[] overrideMoveEntityWithHeadingHooks;
   private ServerPlayerBase[] afterMoveEntityWithHeadingHooks;
   public boolean isMoveEntityWithHeadingModded;
   private static final Map allBaseBeforeMoveEntityWithHeadingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeMoveEntityWithHeadingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideMoveEntityWithHeadingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideMoveEntityWithHeadingInferiors = new Hashtable(0);
   private static final Map allBaseAfterMoveEntityWithHeadingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterMoveEntityWithHeadingInferiors = new Hashtable(0);
   private static final List beforeMoveFlyingHookTypes = new LinkedList();
   private static final List overrideMoveFlyingHookTypes = new LinkedList();
   private static final List afterMoveFlyingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeMoveFlyingHooks;
   private ServerPlayerBase[] overrideMoveFlyingHooks;
   private ServerPlayerBase[] afterMoveFlyingHooks;
   public boolean isMoveFlyingModded;
   private static final Map allBaseBeforeMoveFlyingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeMoveFlyingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideMoveFlyingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideMoveFlyingInferiors = new Hashtable(0);
   private static final Map allBaseAfterMoveFlyingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterMoveFlyingInferiors = new Hashtable(0);
   private static final List beforeOnDeathHookTypes = new LinkedList();
   private static final List overrideOnDeathHookTypes = new LinkedList();
   private static final List afterOnDeathHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeOnDeathHooks;
   private ServerPlayerBase[] overrideOnDeathHooks;
   private ServerPlayerBase[] afterOnDeathHooks;
   public boolean isOnDeathModded;
   private static final Map allBaseBeforeOnDeathSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeOnDeathInferiors = new Hashtable(0);
   private static final Map allBaseOverrideOnDeathSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideOnDeathInferiors = new Hashtable(0);
   private static final Map allBaseAfterOnDeathSuperiors = new Hashtable(0);
   private static final Map allBaseAfterOnDeathInferiors = new Hashtable(0);
   private static final List beforeOnLivingUpdateHookTypes = new LinkedList();
   private static final List overrideOnLivingUpdateHookTypes = new LinkedList();
   private static final List afterOnLivingUpdateHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeOnLivingUpdateHooks;
   private ServerPlayerBase[] overrideOnLivingUpdateHooks;
   private ServerPlayerBase[] afterOnLivingUpdateHooks;
   public boolean isOnLivingUpdateModded;
   private static final Map allBaseBeforeOnLivingUpdateSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeOnLivingUpdateInferiors = new Hashtable(0);
   private static final Map allBaseOverrideOnLivingUpdateSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideOnLivingUpdateInferiors = new Hashtable(0);
   private static final Map allBaseAfterOnLivingUpdateSuperiors = new Hashtable(0);
   private static final Map allBaseAfterOnLivingUpdateInferiors = new Hashtable(0);
   private static final List beforeOnKillEntityHookTypes = new LinkedList();
   private static final List overrideOnKillEntityHookTypes = new LinkedList();
   private static final List afterOnKillEntityHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeOnKillEntityHooks;
   private ServerPlayerBase[] overrideOnKillEntityHooks;
   private ServerPlayerBase[] afterOnKillEntityHooks;
   public boolean isOnKillEntityModded;
   private static final Map allBaseBeforeOnKillEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeOnKillEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideOnKillEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideOnKillEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterOnKillEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterOnKillEntityInferiors = new Hashtable(0);
   private static final List beforeOnStruckByLightningHookTypes = new LinkedList();
   private static final List overrideOnStruckByLightningHookTypes = new LinkedList();
   private static final List afterOnStruckByLightningHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeOnStruckByLightningHooks;
   private ServerPlayerBase[] overrideOnStruckByLightningHooks;
   private ServerPlayerBase[] afterOnStruckByLightningHooks;
   public boolean isOnStruckByLightningModded;
   private static final Map allBaseBeforeOnStruckByLightningSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeOnStruckByLightningInferiors = new Hashtable(0);
   private static final Map allBaseOverrideOnStruckByLightningSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideOnStruckByLightningInferiors = new Hashtable(0);
   private static final Map allBaseAfterOnStruckByLightningSuperiors = new Hashtable(0);
   private static final Map allBaseAfterOnStruckByLightningInferiors = new Hashtable(0);
   private static final List beforeOnUpdateHookTypes = new LinkedList();
   private static final List overrideOnUpdateHookTypes = new LinkedList();
   private static final List afterOnUpdateHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeOnUpdateHooks;
   private ServerPlayerBase[] overrideOnUpdateHooks;
   private ServerPlayerBase[] afterOnUpdateHooks;
   public boolean isOnUpdateModded;
   private static final Map allBaseBeforeOnUpdateSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeOnUpdateInferiors = new Hashtable(0);
   private static final Map allBaseOverrideOnUpdateSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideOnUpdateInferiors = new Hashtable(0);
   private static final Map allBaseAfterOnUpdateSuperiors = new Hashtable(0);
   private static final Map allBaseAfterOnUpdateInferiors = new Hashtable(0);
   private static final List beforeOnUpdateEntityHookTypes = new LinkedList();
   private static final List overrideOnUpdateEntityHookTypes = new LinkedList();
   private static final List afterOnUpdateEntityHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeOnUpdateEntityHooks;
   private ServerPlayerBase[] overrideOnUpdateEntityHooks;
   private ServerPlayerBase[] afterOnUpdateEntityHooks;
   public boolean isOnUpdateEntityModded;
   private static final Map allBaseBeforeOnUpdateEntitySuperiors = new Hashtable(0);
   private static final Map allBaseBeforeOnUpdateEntityInferiors = new Hashtable(0);
   private static final Map allBaseOverrideOnUpdateEntitySuperiors = new Hashtable(0);
   private static final Map allBaseOverrideOnUpdateEntityInferiors = new Hashtable(0);
   private static final Map allBaseAfterOnUpdateEntitySuperiors = new Hashtable(0);
   private static final Map allBaseAfterOnUpdateEntityInferiors = new Hashtable(0);
   private static final List beforeReadEntityFromNBTHookTypes = new LinkedList();
   private static final List overrideReadEntityFromNBTHookTypes = new LinkedList();
   private static final List afterReadEntityFromNBTHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeReadEntityFromNBTHooks;
   private ServerPlayerBase[] overrideReadEntityFromNBTHooks;
   private ServerPlayerBase[] afterReadEntityFromNBTHooks;
   public boolean isReadEntityFromNBTModded;
   private static final Map allBaseBeforeReadEntityFromNBTSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeReadEntityFromNBTInferiors = new Hashtable(0);
   private static final Map allBaseOverrideReadEntityFromNBTSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideReadEntityFromNBTInferiors = new Hashtable(0);
   private static final Map allBaseAfterReadEntityFromNBTSuperiors = new Hashtable(0);
   private static final Map allBaseAfterReadEntityFromNBTInferiors = new Hashtable(0);
   private static final List beforeSetDeadHookTypes = new LinkedList();
   private static final List overrideSetDeadHookTypes = new LinkedList();
   private static final List afterSetDeadHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeSetDeadHooks;
   private ServerPlayerBase[] overrideSetDeadHooks;
   private ServerPlayerBase[] afterSetDeadHooks;
   public boolean isSetDeadModded;
   private static final Map allBaseBeforeSetDeadSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetDeadInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetDeadSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetDeadInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetDeadSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetDeadInferiors = new Hashtable(0);
   private static final List beforeSetEntityActionStateHookTypes = new LinkedList();
   private static final List overrideSetEntityActionStateHookTypes = new LinkedList();
   private static final List afterSetEntityActionStateHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeSetEntityActionStateHooks;
   private ServerPlayerBase[] overrideSetEntityActionStateHooks;
   private ServerPlayerBase[] afterSetEntityActionStateHooks;
   public boolean isSetEntityActionStateModded;
   private static final Map allBaseBeforeSetEntityActionStateSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetEntityActionStateInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetEntityActionStateSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetEntityActionStateInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetEntityActionStateSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetEntityActionStateInferiors = new Hashtable(0);
   private static final List beforeSetPositionHookTypes = new LinkedList();
   private static final List overrideSetPositionHookTypes = new LinkedList();
   private static final List afterSetPositionHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeSetPositionHooks;
   private ServerPlayerBase[] overrideSetPositionHooks;
   private ServerPlayerBase[] afterSetPositionHooks;
   public boolean isSetPositionModded;
   private static final Map allBaseBeforeSetPositionSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetPositionInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetPositionSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetPositionInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetPositionSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetPositionInferiors = new Hashtable(0);
   private static final List beforeSetSneakingHookTypes = new LinkedList();
   private static final List overrideSetSneakingHookTypes = new LinkedList();
   private static final List afterSetSneakingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeSetSneakingHooks;
   private ServerPlayerBase[] overrideSetSneakingHooks;
   private ServerPlayerBase[] afterSetSneakingHooks;
   public boolean isSetSneakingModded;
   private static final Map allBaseBeforeSetSneakingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetSneakingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetSneakingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetSneakingInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetSneakingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetSneakingInferiors = new Hashtable(0);
   private static final List beforeSetSprintingHookTypes = new LinkedList();
   private static final List overrideSetSprintingHookTypes = new LinkedList();
   private static final List afterSetSprintingHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeSetSprintingHooks;
   private ServerPlayerBase[] overrideSetSprintingHooks;
   private ServerPlayerBase[] afterSetSprintingHooks;
   public boolean isSetSprintingModded;
   private static final Map allBaseBeforeSetSprintingSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSetSprintingInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSetSprintingSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSetSprintingInferiors = new Hashtable(0);
   private static final Map allBaseAfterSetSprintingSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSetSprintingInferiors = new Hashtable(0);
   private static final List beforeSwingItemHookTypes = new LinkedList();
   private static final List overrideSwingItemHookTypes = new LinkedList();
   private static final List afterSwingItemHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeSwingItemHooks;
   private ServerPlayerBase[] overrideSwingItemHooks;
   private ServerPlayerBase[] afterSwingItemHooks;
   public boolean isSwingItemModded;
   private static final Map allBaseBeforeSwingItemSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeSwingItemInferiors = new Hashtable(0);
   private static final Map allBaseOverrideSwingItemSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideSwingItemInferiors = new Hashtable(0);
   private static final Map allBaseAfterSwingItemSuperiors = new Hashtable(0);
   private static final Map allBaseAfterSwingItemInferiors = new Hashtable(0);
   private static final List beforeUpdateEntityActionStateHookTypes = new LinkedList();
   private static final List overrideUpdateEntityActionStateHookTypes = new LinkedList();
   private static final List afterUpdateEntityActionStateHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeUpdateEntityActionStateHooks;
   private ServerPlayerBase[] overrideUpdateEntityActionStateHooks;
   private ServerPlayerBase[] afterUpdateEntityActionStateHooks;
   public boolean isUpdateEntityActionStateModded;
   private static final Map allBaseBeforeUpdateEntityActionStateSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeUpdateEntityActionStateInferiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdateEntityActionStateSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdateEntityActionStateInferiors = new Hashtable(0);
   private static final Map allBaseAfterUpdateEntityActionStateSuperiors = new Hashtable(0);
   private static final Map allBaseAfterUpdateEntityActionStateInferiors = new Hashtable(0);
   private static final List beforeUpdatePotionEffectsHookTypes = new LinkedList();
   private static final List overrideUpdatePotionEffectsHookTypes = new LinkedList();
   private static final List afterUpdatePotionEffectsHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeUpdatePotionEffectsHooks;
   private ServerPlayerBase[] overrideUpdatePotionEffectsHooks;
   private ServerPlayerBase[] afterUpdatePotionEffectsHooks;
   public boolean isUpdatePotionEffectsModded;
   private static final Map allBaseBeforeUpdatePotionEffectsSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeUpdatePotionEffectsInferiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdatePotionEffectsSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdatePotionEffectsInferiors = new Hashtable(0);
   private static final Map allBaseAfterUpdatePotionEffectsSuperiors = new Hashtable(0);
   private static final Map allBaseAfterUpdatePotionEffectsInferiors = new Hashtable(0);
   private static final List beforeUpdateRiddenHookTypes = new LinkedList();
   private static final List overrideUpdateRiddenHookTypes = new LinkedList();
   private static final List afterUpdateRiddenHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeUpdateRiddenHooks;
   private ServerPlayerBase[] overrideUpdateRiddenHooks;
   private ServerPlayerBase[] afterUpdateRiddenHooks;
   public boolean isUpdateRiddenModded;
   private static final Map allBaseBeforeUpdateRiddenSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeUpdateRiddenInferiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdateRiddenSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideUpdateRiddenInferiors = new Hashtable(0);
   private static final Map allBaseAfterUpdateRiddenSuperiors = new Hashtable(0);
   private static final Map allBaseAfterUpdateRiddenInferiors = new Hashtable(0);
   private static final List beforeWakeUpPlayerHookTypes = new LinkedList();
   private static final List overrideWakeUpPlayerHookTypes = new LinkedList();
   private static final List afterWakeUpPlayerHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeWakeUpPlayerHooks;
   private ServerPlayerBase[] overrideWakeUpPlayerHooks;
   private ServerPlayerBase[] afterWakeUpPlayerHooks;
   public boolean isWakeUpPlayerModded;
   private static final Map allBaseBeforeWakeUpPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeWakeUpPlayerInferiors = new Hashtable(0);
   private static final Map allBaseOverrideWakeUpPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideWakeUpPlayerInferiors = new Hashtable(0);
   private static final Map allBaseAfterWakeUpPlayerSuperiors = new Hashtable(0);
   private static final Map allBaseAfterWakeUpPlayerInferiors = new Hashtable(0);
   private static final List beforeWriteEntityToNBTHookTypes = new LinkedList();
   private static final List overrideWriteEntityToNBTHookTypes = new LinkedList();
   private static final List afterWriteEntityToNBTHookTypes = new LinkedList();
   private ServerPlayerBase[] beforeWriteEntityToNBTHooks;
   private ServerPlayerBase[] overrideWriteEntityToNBTHooks;
   private ServerPlayerBase[] afterWriteEntityToNBTHooks;
   public boolean isWriteEntityToNBTModded;
   private static final Map allBaseBeforeWriteEntityToNBTSuperiors = new Hashtable(0);
   private static final Map allBaseBeforeWriteEntityToNBTInferiors = new Hashtable(0);
   private static final Map allBaseOverrideWriteEntityToNBTSuperiors = new Hashtable(0);
   private static final Map allBaseOverrideWriteEntityToNBTInferiors = new Hashtable(0);
   private static final Map allBaseAfterWriteEntityToNBTSuperiors = new Hashtable(0);
   private static final Map allBaseAfterWriteEntityToNBTInferiors = new Hashtable(0);
   protected final IServerPlayerAPI player;
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
   private ServerPlayerBase[] beforeLocalConstructingHooks;
   private ServerPlayerBase[] afterLocalConstructingHooks;
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
      register(var0, var1, (ServerPlayerBaseSorting)null);
   }

   public static void register(String var0, Class var1, ServerPlayerBaseSorting var2) {
      try {
         register(var1, var0, var2);
      } catch (RuntimeException var4) {
         if(var0 != null) {
            log("Server Player: failed to register id \'" + var0 + "\'");
         } else {
            log("Server Player: failed to register ServerPlayerBase");
         }

         throw var4;
      }
   }

   private static void register(Class var0, String var1, ServerPlayerBaseSorting var2) {
      if(!isCreated) {
         try {
            Method var3 = EntityPlayerMP.class.getMethod("getServerPlayerBase", new Class[]{String.class});
            if(var3.getReturnType() != ServerPlayerBase.class) {
               throw new NoSuchMethodException(ServerPlayerBase.class.getName() + " " + EntityPlayerMP.class.getName() + ".getServerPlayerBase(" + String.class.getName() + ")");
            }
         } catch (NoSuchMethodException var16) {
            String[] var4 = new String[]{"========================================", "The API \"Server Player\" version " + PlayerAPIPlugin.Version + " of the mod \"Player API Core " + PlayerAPIPlugin.Version + "\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getServerPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Player API Core which Minecraft version matches its own.", "  Download and install the latest Player API Core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Player API Core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Player API Core has not been installed correctly.", "  Deinstall Player API Core and install it again following the installation instructions in the readme file.", "========================================"};
            String var5 = ServerPlayerBase.class.getName();
            String var6 = EntityPlayerMP.class.getName();
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

         log("Server Player " + PlayerAPIPlugin.Version + " Created");
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
                  throw new IllegalArgumentException("Can not find necessary constructor with one argument of type \'" + ServerPlayerAPI.class.getName() + "\' and eventually a second argument of type \'String\' in the class \'" + var0.getName() + "\'", var15);
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
               addSorting(var1, allBaseBeforeAddExhaustionSuperiors, var2.getBeforeAddExhaustionSuperiors());
               addSorting(var1, allBaseBeforeAddExhaustionInferiors, var2.getBeforeAddExhaustionInferiors());
               addSorting(var1, allBaseOverrideAddExhaustionSuperiors, var2.getOverrideAddExhaustionSuperiors());
               addSorting(var1, allBaseOverrideAddExhaustionInferiors, var2.getOverrideAddExhaustionInferiors());
               addSorting(var1, allBaseAfterAddExhaustionSuperiors, var2.getAfterAddExhaustionSuperiors());
               addSorting(var1, allBaseAfterAddExhaustionInferiors, var2.getAfterAddExhaustionInferiors());
               addSorting(var1, allBaseBeforeAddExperienceSuperiors, var2.getBeforeAddExperienceSuperiors());
               addSorting(var1, allBaseBeforeAddExperienceInferiors, var2.getBeforeAddExperienceInferiors());
               addSorting(var1, allBaseOverrideAddExperienceSuperiors, var2.getOverrideAddExperienceSuperiors());
               addSorting(var1, allBaseOverrideAddExperienceInferiors, var2.getOverrideAddExperienceInferiors());
               addSorting(var1, allBaseAfterAddExperienceSuperiors, var2.getAfterAddExperienceSuperiors());
               addSorting(var1, allBaseAfterAddExperienceInferiors, var2.getAfterAddExperienceInferiors());
               addSorting(var1, allBaseBeforeAddExperienceLevelSuperiors, var2.getBeforeAddExperienceLevelSuperiors());
               addSorting(var1, allBaseBeforeAddExperienceLevelInferiors, var2.getBeforeAddExperienceLevelInferiors());
               addSorting(var1, allBaseOverrideAddExperienceLevelSuperiors, var2.getOverrideAddExperienceLevelSuperiors());
               addSorting(var1, allBaseOverrideAddExperienceLevelInferiors, var2.getOverrideAddExperienceLevelInferiors());
               addSorting(var1, allBaseAfterAddExperienceLevelSuperiors, var2.getAfterAddExperienceLevelSuperiors());
               addSorting(var1, allBaseAfterAddExperienceLevelInferiors, var2.getAfterAddExperienceLevelInferiors());
               addSorting(var1, allBaseBeforeAddMovementStatSuperiors, var2.getBeforeAddMovementStatSuperiors());
               addSorting(var1, allBaseBeforeAddMovementStatInferiors, var2.getBeforeAddMovementStatInferiors());
               addSorting(var1, allBaseOverrideAddMovementStatSuperiors, var2.getOverrideAddMovementStatSuperiors());
               addSorting(var1, allBaseOverrideAddMovementStatInferiors, var2.getOverrideAddMovementStatInferiors());
               addSorting(var1, allBaseAfterAddMovementStatSuperiors, var2.getAfterAddMovementStatSuperiors());
               addSorting(var1, allBaseAfterAddMovementStatInferiors, var2.getAfterAddMovementStatInferiors());
               addSorting(var1, allBaseBeforeAttackEntityFromSuperiors, var2.getBeforeAttackEntityFromSuperiors());
               addSorting(var1, allBaseBeforeAttackEntityFromInferiors, var2.getBeforeAttackEntityFromInferiors());
               addSorting(var1, allBaseOverrideAttackEntityFromSuperiors, var2.getOverrideAttackEntityFromSuperiors());
               addSorting(var1, allBaseOverrideAttackEntityFromInferiors, var2.getOverrideAttackEntityFromInferiors());
               addSorting(var1, allBaseAfterAttackEntityFromSuperiors, var2.getAfterAttackEntityFromSuperiors());
               addSorting(var1, allBaseAfterAttackEntityFromInferiors, var2.getAfterAttackEntityFromInferiors());
               addSorting(var1, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, var2.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
               addSorting(var1, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, var2.getBeforeAttackTargetEntityWithCurrentItemInferiors());
               addSorting(var1, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, var2.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
               addSorting(var1, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, var2.getOverrideAttackTargetEntityWithCurrentItemInferiors());
               addSorting(var1, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, var2.getAfterAttackTargetEntityWithCurrentItemSuperiors());
               addSorting(var1, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, var2.getAfterAttackTargetEntityWithCurrentItemInferiors());
               addSorting(var1, allBaseBeforeCanBreatheUnderwaterSuperiors, var2.getBeforeCanBreatheUnderwaterSuperiors());
               addSorting(var1, allBaseBeforeCanBreatheUnderwaterInferiors, var2.getBeforeCanBreatheUnderwaterInferiors());
               addSorting(var1, allBaseOverrideCanBreatheUnderwaterSuperiors, var2.getOverrideCanBreatheUnderwaterSuperiors());
               addSorting(var1, allBaseOverrideCanBreatheUnderwaterInferiors, var2.getOverrideCanBreatheUnderwaterInferiors());
               addSorting(var1, allBaseAfterCanBreatheUnderwaterSuperiors, var2.getAfterCanBreatheUnderwaterSuperiors());
               addSorting(var1, allBaseAfterCanBreatheUnderwaterInferiors, var2.getAfterCanBreatheUnderwaterInferiors());
               addSorting(var1, allBaseBeforeCanHarvestBlockSuperiors, var2.getBeforeCanHarvestBlockSuperiors());
               addSorting(var1, allBaseBeforeCanHarvestBlockInferiors, var2.getBeforeCanHarvestBlockInferiors());
               addSorting(var1, allBaseOverrideCanHarvestBlockSuperiors, var2.getOverrideCanHarvestBlockSuperiors());
               addSorting(var1, allBaseOverrideCanHarvestBlockInferiors, var2.getOverrideCanHarvestBlockInferiors());
               addSorting(var1, allBaseAfterCanHarvestBlockSuperiors, var2.getAfterCanHarvestBlockSuperiors());
               addSorting(var1, allBaseAfterCanHarvestBlockInferiors, var2.getAfterCanHarvestBlockInferiors());
               addSorting(var1, allBaseBeforeCanPlayerEditSuperiors, var2.getBeforeCanPlayerEditSuperiors());
               addSorting(var1, allBaseBeforeCanPlayerEditInferiors, var2.getBeforeCanPlayerEditInferiors());
               addSorting(var1, allBaseOverrideCanPlayerEditSuperiors, var2.getOverrideCanPlayerEditSuperiors());
               addSorting(var1, allBaseOverrideCanPlayerEditInferiors, var2.getOverrideCanPlayerEditInferiors());
               addSorting(var1, allBaseAfterCanPlayerEditSuperiors, var2.getAfterCanPlayerEditSuperiors());
               addSorting(var1, allBaseAfterCanPlayerEditInferiors, var2.getAfterCanPlayerEditInferiors());
               addSorting(var1, allBaseBeforeCanTriggerWalkingSuperiors, var2.getBeforeCanTriggerWalkingSuperiors());
               addSorting(var1, allBaseBeforeCanTriggerWalkingInferiors, var2.getBeforeCanTriggerWalkingInferiors());
               addSorting(var1, allBaseOverrideCanTriggerWalkingSuperiors, var2.getOverrideCanTriggerWalkingSuperiors());
               addSorting(var1, allBaseOverrideCanTriggerWalkingInferiors, var2.getOverrideCanTriggerWalkingInferiors());
               addSorting(var1, allBaseAfterCanTriggerWalkingSuperiors, var2.getAfterCanTriggerWalkingSuperiors());
               addSorting(var1, allBaseAfterCanTriggerWalkingInferiors, var2.getAfterCanTriggerWalkingInferiors());
               addSorting(var1, allBaseBeforeClonePlayerSuperiors, var2.getBeforeClonePlayerSuperiors());
               addSorting(var1, allBaseBeforeClonePlayerInferiors, var2.getBeforeClonePlayerInferiors());
               addSorting(var1, allBaseOverrideClonePlayerSuperiors, var2.getOverrideClonePlayerSuperiors());
               addSorting(var1, allBaseOverrideClonePlayerInferiors, var2.getOverrideClonePlayerInferiors());
               addSorting(var1, allBaseAfterClonePlayerSuperiors, var2.getAfterClonePlayerSuperiors());
               addSorting(var1, allBaseAfterClonePlayerInferiors, var2.getAfterClonePlayerInferiors());
               addSorting(var1, allBaseBeforeDamageEntitySuperiors, var2.getBeforeDamageEntitySuperiors());
               addSorting(var1, allBaseBeforeDamageEntityInferiors, var2.getBeforeDamageEntityInferiors());
               addSorting(var1, allBaseOverrideDamageEntitySuperiors, var2.getOverrideDamageEntitySuperiors());
               addSorting(var1, allBaseOverrideDamageEntityInferiors, var2.getOverrideDamageEntityInferiors());
               addSorting(var1, allBaseAfterDamageEntitySuperiors, var2.getAfterDamageEntitySuperiors());
               addSorting(var1, allBaseAfterDamageEntityInferiors, var2.getAfterDamageEntityInferiors());
               addSorting(var1, allBaseBeforeDisplayGUIChestSuperiors, var2.getBeforeDisplayGUIChestSuperiors());
               addSorting(var1, allBaseBeforeDisplayGUIChestInferiors, var2.getBeforeDisplayGUIChestInferiors());
               addSorting(var1, allBaseOverrideDisplayGUIChestSuperiors, var2.getOverrideDisplayGUIChestSuperiors());
               addSorting(var1, allBaseOverrideDisplayGUIChestInferiors, var2.getOverrideDisplayGUIChestInferiors());
               addSorting(var1, allBaseAfterDisplayGUIChestSuperiors, var2.getAfterDisplayGUIChestSuperiors());
               addSorting(var1, allBaseAfterDisplayGUIChestInferiors, var2.getAfterDisplayGUIChestInferiors());
               addSorting(var1, allBaseBeforeDisplayGUIDispenserSuperiors, var2.getBeforeDisplayGUIDispenserSuperiors());
               addSorting(var1, allBaseBeforeDisplayGUIDispenserInferiors, var2.getBeforeDisplayGUIDispenserInferiors());
               addSorting(var1, allBaseOverrideDisplayGUIDispenserSuperiors, var2.getOverrideDisplayGUIDispenserSuperiors());
               addSorting(var1, allBaseOverrideDisplayGUIDispenserInferiors, var2.getOverrideDisplayGUIDispenserInferiors());
               addSorting(var1, allBaseAfterDisplayGUIDispenserSuperiors, var2.getAfterDisplayGUIDispenserSuperiors());
               addSorting(var1, allBaseAfterDisplayGUIDispenserInferiors, var2.getAfterDisplayGUIDispenserInferiors());
               addSorting(var1, allBaseBeforeDisplayGUIFurnaceSuperiors, var2.getBeforeDisplayGUIFurnaceSuperiors());
               addSorting(var1, allBaseBeforeDisplayGUIFurnaceInferiors, var2.getBeforeDisplayGUIFurnaceInferiors());
               addSorting(var1, allBaseOverrideDisplayGUIFurnaceSuperiors, var2.getOverrideDisplayGUIFurnaceSuperiors());
               addSorting(var1, allBaseOverrideDisplayGUIFurnaceInferiors, var2.getOverrideDisplayGUIFurnaceInferiors());
               addSorting(var1, allBaseAfterDisplayGUIFurnaceSuperiors, var2.getAfterDisplayGUIFurnaceSuperiors());
               addSorting(var1, allBaseAfterDisplayGUIFurnaceInferiors, var2.getAfterDisplayGUIFurnaceInferiors());
               addSorting(var1, allBaseBeforeDisplayGUIWorkbenchSuperiors, var2.getBeforeDisplayGUIWorkbenchSuperiors());
               addSorting(var1, allBaseBeforeDisplayGUIWorkbenchInferiors, var2.getBeforeDisplayGUIWorkbenchInferiors());
               addSorting(var1, allBaseOverrideDisplayGUIWorkbenchSuperiors, var2.getOverrideDisplayGUIWorkbenchSuperiors());
               addSorting(var1, allBaseOverrideDisplayGUIWorkbenchInferiors, var2.getOverrideDisplayGUIWorkbenchInferiors());
               addSorting(var1, allBaseAfterDisplayGUIWorkbenchSuperiors, var2.getAfterDisplayGUIWorkbenchSuperiors());
               addSorting(var1, allBaseAfterDisplayGUIWorkbenchInferiors, var2.getAfterDisplayGUIWorkbenchInferiors());
               addSorting(var1, allBaseBeforeDropOneItemSuperiors, var2.getBeforeDropOneItemSuperiors());
               addSorting(var1, allBaseBeforeDropOneItemInferiors, var2.getBeforeDropOneItemInferiors());
               addSorting(var1, allBaseOverrideDropOneItemSuperiors, var2.getOverrideDropOneItemSuperiors());
               addSorting(var1, allBaseOverrideDropOneItemInferiors, var2.getOverrideDropOneItemInferiors());
               addSorting(var1, allBaseAfterDropOneItemSuperiors, var2.getAfterDropOneItemSuperiors());
               addSorting(var1, allBaseAfterDropOneItemInferiors, var2.getAfterDropOneItemInferiors());
               addSorting(var1, allBaseBeforeDropPlayerItemSuperiors, var2.getBeforeDropPlayerItemSuperiors());
               addSorting(var1, allBaseBeforeDropPlayerItemInferiors, var2.getBeforeDropPlayerItemInferiors());
               addSorting(var1, allBaseOverrideDropPlayerItemSuperiors, var2.getOverrideDropPlayerItemSuperiors());
               addSorting(var1, allBaseOverrideDropPlayerItemInferiors, var2.getOverrideDropPlayerItemInferiors());
               addSorting(var1, allBaseAfterDropPlayerItemSuperiors, var2.getAfterDropPlayerItemSuperiors());
               addSorting(var1, allBaseAfterDropPlayerItemInferiors, var2.getAfterDropPlayerItemInferiors());
               addSorting(var1, allBaseBeforeFallSuperiors, var2.getBeforeFallSuperiors());
               addSorting(var1, allBaseBeforeFallInferiors, var2.getBeforeFallInferiors());
               addSorting(var1, allBaseOverrideFallSuperiors, var2.getOverrideFallSuperiors());
               addSorting(var1, allBaseOverrideFallInferiors, var2.getOverrideFallInferiors());
               addSorting(var1, allBaseAfterFallSuperiors, var2.getAfterFallSuperiors());
               addSorting(var1, allBaseAfterFallInferiors, var2.getAfterFallInferiors());
               addSorting(var1, allBaseBeforeGetAIMoveSpeedSuperiors, var2.getBeforeGetAIMoveSpeedSuperiors());
               addSorting(var1, allBaseBeforeGetAIMoveSpeedInferiors, var2.getBeforeGetAIMoveSpeedInferiors());
               addSorting(var1, allBaseOverrideGetAIMoveSpeedSuperiors, var2.getOverrideGetAIMoveSpeedSuperiors());
               addSorting(var1, allBaseOverrideGetAIMoveSpeedInferiors, var2.getOverrideGetAIMoveSpeedInferiors());
               addSorting(var1, allBaseAfterGetAIMoveSpeedSuperiors, var2.getAfterGetAIMoveSpeedSuperiors());
               addSorting(var1, allBaseAfterGetAIMoveSpeedInferiors, var2.getAfterGetAIMoveSpeedInferiors());
               addSorting(var1, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, var2.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
               addSorting(var1, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, var2.getBeforeGetCurrentPlayerStrVsBlockInferiors());
               addSorting(var1, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, var2.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
               addSorting(var1, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, var2.getOverrideGetCurrentPlayerStrVsBlockInferiors());
               addSorting(var1, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, var2.getAfterGetCurrentPlayerStrVsBlockSuperiors());
               addSorting(var1, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, var2.getAfterGetCurrentPlayerStrVsBlockInferiors());
               addSorting(var1, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, var2.getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors());
               addSorting(var1, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, var2.getBeforeGetCurrentPlayerStrVsBlockForgeInferiors());
               addSorting(var1, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, var2.getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors());
               addSorting(var1, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, var2.getOverrideGetCurrentPlayerStrVsBlockForgeInferiors());
               addSorting(var1, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, var2.getAfterGetCurrentPlayerStrVsBlockForgeSuperiors());
               addSorting(var1, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, var2.getAfterGetCurrentPlayerStrVsBlockForgeInferiors());
               addSorting(var1, allBaseBeforeGetDistanceSqSuperiors, var2.getBeforeGetDistanceSqSuperiors());
               addSorting(var1, allBaseBeforeGetDistanceSqInferiors, var2.getBeforeGetDistanceSqInferiors());
               addSorting(var1, allBaseOverrideGetDistanceSqSuperiors, var2.getOverrideGetDistanceSqSuperiors());
               addSorting(var1, allBaseOverrideGetDistanceSqInferiors, var2.getOverrideGetDistanceSqInferiors());
               addSorting(var1, allBaseAfterGetDistanceSqSuperiors, var2.getAfterGetDistanceSqSuperiors());
               addSorting(var1, allBaseAfterGetDistanceSqInferiors, var2.getAfterGetDistanceSqInferiors());
               addSorting(var1, allBaseBeforeGetBrightnessSuperiors, var2.getBeforeGetBrightnessSuperiors());
               addSorting(var1, allBaseBeforeGetBrightnessInferiors, var2.getBeforeGetBrightnessInferiors());
               addSorting(var1, allBaseOverrideGetBrightnessSuperiors, var2.getOverrideGetBrightnessSuperiors());
               addSorting(var1, allBaseOverrideGetBrightnessInferiors, var2.getOverrideGetBrightnessInferiors());
               addSorting(var1, allBaseAfterGetBrightnessSuperiors, var2.getAfterGetBrightnessSuperiors());
               addSorting(var1, allBaseAfterGetBrightnessInferiors, var2.getAfterGetBrightnessInferiors());
               addSorting(var1, allBaseBeforeGetEyeHeightSuperiors, var2.getBeforeGetEyeHeightSuperiors());
               addSorting(var1, allBaseBeforeGetEyeHeightInferiors, var2.getBeforeGetEyeHeightInferiors());
               addSorting(var1, allBaseOverrideGetEyeHeightSuperiors, var2.getOverrideGetEyeHeightSuperiors());
               addSorting(var1, allBaseOverrideGetEyeHeightInferiors, var2.getOverrideGetEyeHeightInferiors());
               addSorting(var1, allBaseAfterGetEyeHeightSuperiors, var2.getAfterGetEyeHeightSuperiors());
               addSorting(var1, allBaseAfterGetEyeHeightInferiors, var2.getAfterGetEyeHeightInferiors());
               addSorting(var1, allBaseBeforeHealSuperiors, var2.getBeforeHealSuperiors());
               addSorting(var1, allBaseBeforeHealInferiors, var2.getBeforeHealInferiors());
               addSorting(var1, allBaseOverrideHealSuperiors, var2.getOverrideHealSuperiors());
               addSorting(var1, allBaseOverrideHealInferiors, var2.getOverrideHealInferiors());
               addSorting(var1, allBaseAfterHealSuperiors, var2.getAfterHealSuperiors());
               addSorting(var1, allBaseAfterHealInferiors, var2.getAfterHealInferiors());
               addSorting(var1, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, var2.getBeforeIsEntityInsideOpaqueBlockSuperiors());
               addSorting(var1, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, var2.getBeforeIsEntityInsideOpaqueBlockInferiors());
               addSorting(var1, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, var2.getOverrideIsEntityInsideOpaqueBlockSuperiors());
               addSorting(var1, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, var2.getOverrideIsEntityInsideOpaqueBlockInferiors());
               addSorting(var1, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, var2.getAfterIsEntityInsideOpaqueBlockSuperiors());
               addSorting(var1, allBaseAfterIsEntityInsideOpaqueBlockInferiors, var2.getAfterIsEntityInsideOpaqueBlockInferiors());
               addSorting(var1, allBaseBeforeIsInWaterSuperiors, var2.getBeforeIsInWaterSuperiors());
               addSorting(var1, allBaseBeforeIsInWaterInferiors, var2.getBeforeIsInWaterInferiors());
               addSorting(var1, allBaseOverrideIsInWaterSuperiors, var2.getOverrideIsInWaterSuperiors());
               addSorting(var1, allBaseOverrideIsInWaterInferiors, var2.getOverrideIsInWaterInferiors());
               addSorting(var1, allBaseAfterIsInWaterSuperiors, var2.getAfterIsInWaterSuperiors());
               addSorting(var1, allBaseAfterIsInWaterInferiors, var2.getAfterIsInWaterInferiors());
               addSorting(var1, allBaseBeforeIsInsideOfMaterialSuperiors, var2.getBeforeIsInsideOfMaterialSuperiors());
               addSorting(var1, allBaseBeforeIsInsideOfMaterialInferiors, var2.getBeforeIsInsideOfMaterialInferiors());
               addSorting(var1, allBaseOverrideIsInsideOfMaterialSuperiors, var2.getOverrideIsInsideOfMaterialSuperiors());
               addSorting(var1, allBaseOverrideIsInsideOfMaterialInferiors, var2.getOverrideIsInsideOfMaterialInferiors());
               addSorting(var1, allBaseAfterIsInsideOfMaterialSuperiors, var2.getAfterIsInsideOfMaterialSuperiors());
               addSorting(var1, allBaseAfterIsInsideOfMaterialInferiors, var2.getAfterIsInsideOfMaterialInferiors());
               addSorting(var1, allBaseBeforeIsOnLadderSuperiors, var2.getBeforeIsOnLadderSuperiors());
               addSorting(var1, allBaseBeforeIsOnLadderInferiors, var2.getBeforeIsOnLadderInferiors());
               addSorting(var1, allBaseOverrideIsOnLadderSuperiors, var2.getOverrideIsOnLadderSuperiors());
               addSorting(var1, allBaseOverrideIsOnLadderInferiors, var2.getOverrideIsOnLadderInferiors());
               addSorting(var1, allBaseAfterIsOnLadderSuperiors, var2.getAfterIsOnLadderSuperiors());
               addSorting(var1, allBaseAfterIsOnLadderInferiors, var2.getAfterIsOnLadderInferiors());
               addSorting(var1, allBaseBeforeIsPlayerSleepingSuperiors, var2.getBeforeIsPlayerSleepingSuperiors());
               addSorting(var1, allBaseBeforeIsPlayerSleepingInferiors, var2.getBeforeIsPlayerSleepingInferiors());
               addSorting(var1, allBaseOverrideIsPlayerSleepingSuperiors, var2.getOverrideIsPlayerSleepingSuperiors());
               addSorting(var1, allBaseOverrideIsPlayerSleepingInferiors, var2.getOverrideIsPlayerSleepingInferiors());
               addSorting(var1, allBaseAfterIsPlayerSleepingSuperiors, var2.getAfterIsPlayerSleepingSuperiors());
               addSorting(var1, allBaseAfterIsPlayerSleepingInferiors, var2.getAfterIsPlayerSleepingInferiors());
               addSorting(var1, allBaseBeforeIsSneakingSuperiors, var2.getBeforeIsSneakingSuperiors());
               addSorting(var1, allBaseBeforeIsSneakingInferiors, var2.getBeforeIsSneakingInferiors());
               addSorting(var1, allBaseOverrideIsSneakingSuperiors, var2.getOverrideIsSneakingSuperiors());
               addSorting(var1, allBaseOverrideIsSneakingInferiors, var2.getOverrideIsSneakingInferiors());
               addSorting(var1, allBaseAfterIsSneakingSuperiors, var2.getAfterIsSneakingSuperiors());
               addSorting(var1, allBaseAfterIsSneakingInferiors, var2.getAfterIsSneakingInferiors());
               addSorting(var1, allBaseBeforeJumpSuperiors, var2.getBeforeJumpSuperiors());
               addSorting(var1, allBaseBeforeJumpInferiors, var2.getBeforeJumpInferiors());
               addSorting(var1, allBaseOverrideJumpSuperiors, var2.getOverrideJumpSuperiors());
               addSorting(var1, allBaseOverrideJumpInferiors, var2.getOverrideJumpInferiors());
               addSorting(var1, allBaseAfterJumpSuperiors, var2.getAfterJumpSuperiors());
               addSorting(var1, allBaseAfterJumpInferiors, var2.getAfterJumpInferiors());
               addSorting(var1, allBaseBeforeKnockBackSuperiors, var2.getBeforeKnockBackSuperiors());
               addSorting(var1, allBaseBeforeKnockBackInferiors, var2.getBeforeKnockBackInferiors());
               addSorting(var1, allBaseOverrideKnockBackSuperiors, var2.getOverrideKnockBackSuperiors());
               addSorting(var1, allBaseOverrideKnockBackInferiors, var2.getOverrideKnockBackInferiors());
               addSorting(var1, allBaseAfterKnockBackSuperiors, var2.getAfterKnockBackSuperiors());
               addSorting(var1, allBaseAfterKnockBackInferiors, var2.getAfterKnockBackInferiors());
               addSorting(var1, allBaseBeforeMountEntitySuperiors, var2.getBeforeMountEntitySuperiors());
               addSorting(var1, allBaseBeforeMountEntityInferiors, var2.getBeforeMountEntityInferiors());
               addSorting(var1, allBaseOverrideMountEntitySuperiors, var2.getOverrideMountEntitySuperiors());
               addSorting(var1, allBaseOverrideMountEntityInferiors, var2.getOverrideMountEntityInferiors());
               addSorting(var1, allBaseAfterMountEntitySuperiors, var2.getAfterMountEntitySuperiors());
               addSorting(var1, allBaseAfterMountEntityInferiors, var2.getAfterMountEntityInferiors());
               addSorting(var1, allBaseBeforeMoveEntitySuperiors, var2.getBeforeMoveEntitySuperiors());
               addSorting(var1, allBaseBeforeMoveEntityInferiors, var2.getBeforeMoveEntityInferiors());
               addSorting(var1, allBaseOverrideMoveEntitySuperiors, var2.getOverrideMoveEntitySuperiors());
               addSorting(var1, allBaseOverrideMoveEntityInferiors, var2.getOverrideMoveEntityInferiors());
               addSorting(var1, allBaseAfterMoveEntitySuperiors, var2.getAfterMoveEntitySuperiors());
               addSorting(var1, allBaseAfterMoveEntityInferiors, var2.getAfterMoveEntityInferiors());
               addSorting(var1, allBaseBeforeMoveEntityWithHeadingSuperiors, var2.getBeforeMoveEntityWithHeadingSuperiors());
               addSorting(var1, allBaseBeforeMoveEntityWithHeadingInferiors, var2.getBeforeMoveEntityWithHeadingInferiors());
               addSorting(var1, allBaseOverrideMoveEntityWithHeadingSuperiors, var2.getOverrideMoveEntityWithHeadingSuperiors());
               addSorting(var1, allBaseOverrideMoveEntityWithHeadingInferiors, var2.getOverrideMoveEntityWithHeadingInferiors());
               addSorting(var1, allBaseAfterMoveEntityWithHeadingSuperiors, var2.getAfterMoveEntityWithHeadingSuperiors());
               addSorting(var1, allBaseAfterMoveEntityWithHeadingInferiors, var2.getAfterMoveEntityWithHeadingInferiors());
               addSorting(var1, allBaseBeforeMoveFlyingSuperiors, var2.getBeforeMoveFlyingSuperiors());
               addSorting(var1, allBaseBeforeMoveFlyingInferiors, var2.getBeforeMoveFlyingInferiors());
               addSorting(var1, allBaseOverrideMoveFlyingSuperiors, var2.getOverrideMoveFlyingSuperiors());
               addSorting(var1, allBaseOverrideMoveFlyingInferiors, var2.getOverrideMoveFlyingInferiors());
               addSorting(var1, allBaseAfterMoveFlyingSuperiors, var2.getAfterMoveFlyingSuperiors());
               addSorting(var1, allBaseAfterMoveFlyingInferiors, var2.getAfterMoveFlyingInferiors());
               addSorting(var1, allBaseBeforeOnDeathSuperiors, var2.getBeforeOnDeathSuperiors());
               addSorting(var1, allBaseBeforeOnDeathInferiors, var2.getBeforeOnDeathInferiors());
               addSorting(var1, allBaseOverrideOnDeathSuperiors, var2.getOverrideOnDeathSuperiors());
               addSorting(var1, allBaseOverrideOnDeathInferiors, var2.getOverrideOnDeathInferiors());
               addSorting(var1, allBaseAfterOnDeathSuperiors, var2.getAfterOnDeathSuperiors());
               addSorting(var1, allBaseAfterOnDeathInferiors, var2.getAfterOnDeathInferiors());
               addSorting(var1, allBaseBeforeOnLivingUpdateSuperiors, var2.getBeforeOnLivingUpdateSuperiors());
               addSorting(var1, allBaseBeforeOnLivingUpdateInferiors, var2.getBeforeOnLivingUpdateInferiors());
               addSorting(var1, allBaseOverrideOnLivingUpdateSuperiors, var2.getOverrideOnLivingUpdateSuperiors());
               addSorting(var1, allBaseOverrideOnLivingUpdateInferiors, var2.getOverrideOnLivingUpdateInferiors());
               addSorting(var1, allBaseAfterOnLivingUpdateSuperiors, var2.getAfterOnLivingUpdateSuperiors());
               addSorting(var1, allBaseAfterOnLivingUpdateInferiors, var2.getAfterOnLivingUpdateInferiors());
               addSorting(var1, allBaseBeforeOnKillEntitySuperiors, var2.getBeforeOnKillEntitySuperiors());
               addSorting(var1, allBaseBeforeOnKillEntityInferiors, var2.getBeforeOnKillEntityInferiors());
               addSorting(var1, allBaseOverrideOnKillEntitySuperiors, var2.getOverrideOnKillEntitySuperiors());
               addSorting(var1, allBaseOverrideOnKillEntityInferiors, var2.getOverrideOnKillEntityInferiors());
               addSorting(var1, allBaseAfterOnKillEntitySuperiors, var2.getAfterOnKillEntitySuperiors());
               addSorting(var1, allBaseAfterOnKillEntityInferiors, var2.getAfterOnKillEntityInferiors());
               addSorting(var1, allBaseBeforeOnStruckByLightningSuperiors, var2.getBeforeOnStruckByLightningSuperiors());
               addSorting(var1, allBaseBeforeOnStruckByLightningInferiors, var2.getBeforeOnStruckByLightningInferiors());
               addSorting(var1, allBaseOverrideOnStruckByLightningSuperiors, var2.getOverrideOnStruckByLightningSuperiors());
               addSorting(var1, allBaseOverrideOnStruckByLightningInferiors, var2.getOverrideOnStruckByLightningInferiors());
               addSorting(var1, allBaseAfterOnStruckByLightningSuperiors, var2.getAfterOnStruckByLightningSuperiors());
               addSorting(var1, allBaseAfterOnStruckByLightningInferiors, var2.getAfterOnStruckByLightningInferiors());
               addSorting(var1, allBaseBeforeOnUpdateSuperiors, var2.getBeforeOnUpdateSuperiors());
               addSorting(var1, allBaseBeforeOnUpdateInferiors, var2.getBeforeOnUpdateInferiors());
               addSorting(var1, allBaseOverrideOnUpdateSuperiors, var2.getOverrideOnUpdateSuperiors());
               addSorting(var1, allBaseOverrideOnUpdateInferiors, var2.getOverrideOnUpdateInferiors());
               addSorting(var1, allBaseAfterOnUpdateSuperiors, var2.getAfterOnUpdateSuperiors());
               addSorting(var1, allBaseAfterOnUpdateInferiors, var2.getAfterOnUpdateInferiors());
               addSorting(var1, allBaseBeforeOnUpdateEntitySuperiors, var2.getBeforeOnUpdateEntitySuperiors());
               addSorting(var1, allBaseBeforeOnUpdateEntityInferiors, var2.getBeforeOnUpdateEntityInferiors());
               addSorting(var1, allBaseOverrideOnUpdateEntitySuperiors, var2.getOverrideOnUpdateEntitySuperiors());
               addSorting(var1, allBaseOverrideOnUpdateEntityInferiors, var2.getOverrideOnUpdateEntityInferiors());
               addSorting(var1, allBaseAfterOnUpdateEntitySuperiors, var2.getAfterOnUpdateEntitySuperiors());
               addSorting(var1, allBaseAfterOnUpdateEntityInferiors, var2.getAfterOnUpdateEntityInferiors());
               addSorting(var1, allBaseBeforeReadEntityFromNBTSuperiors, var2.getBeforeReadEntityFromNBTSuperiors());
               addSorting(var1, allBaseBeforeReadEntityFromNBTInferiors, var2.getBeforeReadEntityFromNBTInferiors());
               addSorting(var1, allBaseOverrideReadEntityFromNBTSuperiors, var2.getOverrideReadEntityFromNBTSuperiors());
               addSorting(var1, allBaseOverrideReadEntityFromNBTInferiors, var2.getOverrideReadEntityFromNBTInferiors());
               addSorting(var1, allBaseAfterReadEntityFromNBTSuperiors, var2.getAfterReadEntityFromNBTSuperiors());
               addSorting(var1, allBaseAfterReadEntityFromNBTInferiors, var2.getAfterReadEntityFromNBTInferiors());
               addSorting(var1, allBaseBeforeSetDeadSuperiors, var2.getBeforeSetDeadSuperiors());
               addSorting(var1, allBaseBeforeSetDeadInferiors, var2.getBeforeSetDeadInferiors());
               addSorting(var1, allBaseOverrideSetDeadSuperiors, var2.getOverrideSetDeadSuperiors());
               addSorting(var1, allBaseOverrideSetDeadInferiors, var2.getOverrideSetDeadInferiors());
               addSorting(var1, allBaseAfterSetDeadSuperiors, var2.getAfterSetDeadSuperiors());
               addSorting(var1, allBaseAfterSetDeadInferiors, var2.getAfterSetDeadInferiors());
               addSorting(var1, allBaseBeforeSetEntityActionStateSuperiors, var2.getBeforeSetEntityActionStateSuperiors());
               addSorting(var1, allBaseBeforeSetEntityActionStateInferiors, var2.getBeforeSetEntityActionStateInferiors());
               addSorting(var1, allBaseOverrideSetEntityActionStateSuperiors, var2.getOverrideSetEntityActionStateSuperiors());
               addSorting(var1, allBaseOverrideSetEntityActionStateInferiors, var2.getOverrideSetEntityActionStateInferiors());
               addSorting(var1, allBaseAfterSetEntityActionStateSuperiors, var2.getAfterSetEntityActionStateSuperiors());
               addSorting(var1, allBaseAfterSetEntityActionStateInferiors, var2.getAfterSetEntityActionStateInferiors());
               addSorting(var1, allBaseBeforeSetPositionSuperiors, var2.getBeforeSetPositionSuperiors());
               addSorting(var1, allBaseBeforeSetPositionInferiors, var2.getBeforeSetPositionInferiors());
               addSorting(var1, allBaseOverrideSetPositionSuperiors, var2.getOverrideSetPositionSuperiors());
               addSorting(var1, allBaseOverrideSetPositionInferiors, var2.getOverrideSetPositionInferiors());
               addSorting(var1, allBaseAfterSetPositionSuperiors, var2.getAfterSetPositionSuperiors());
               addSorting(var1, allBaseAfterSetPositionInferiors, var2.getAfterSetPositionInferiors());
               addSorting(var1, allBaseBeforeSetSneakingSuperiors, var2.getBeforeSetSneakingSuperiors());
               addSorting(var1, allBaseBeforeSetSneakingInferiors, var2.getBeforeSetSneakingInferiors());
               addSorting(var1, allBaseOverrideSetSneakingSuperiors, var2.getOverrideSetSneakingSuperiors());
               addSorting(var1, allBaseOverrideSetSneakingInferiors, var2.getOverrideSetSneakingInferiors());
               addSorting(var1, allBaseAfterSetSneakingSuperiors, var2.getAfterSetSneakingSuperiors());
               addSorting(var1, allBaseAfterSetSneakingInferiors, var2.getAfterSetSneakingInferiors());
               addSorting(var1, allBaseBeforeSetSprintingSuperiors, var2.getBeforeSetSprintingSuperiors());
               addSorting(var1, allBaseBeforeSetSprintingInferiors, var2.getBeforeSetSprintingInferiors());
               addSorting(var1, allBaseOverrideSetSprintingSuperiors, var2.getOverrideSetSprintingSuperiors());
               addSorting(var1, allBaseOverrideSetSprintingInferiors, var2.getOverrideSetSprintingInferiors());
               addSorting(var1, allBaseAfterSetSprintingSuperiors, var2.getAfterSetSprintingSuperiors());
               addSorting(var1, allBaseAfterSetSprintingInferiors, var2.getAfterSetSprintingInferiors());
               addSorting(var1, allBaseBeforeSwingItemSuperiors, var2.getBeforeSwingItemSuperiors());
               addSorting(var1, allBaseBeforeSwingItemInferiors, var2.getBeforeSwingItemInferiors());
               addSorting(var1, allBaseOverrideSwingItemSuperiors, var2.getOverrideSwingItemSuperiors());
               addSorting(var1, allBaseOverrideSwingItemInferiors, var2.getOverrideSwingItemInferiors());
               addSorting(var1, allBaseAfterSwingItemSuperiors, var2.getAfterSwingItemSuperiors());
               addSorting(var1, allBaseAfterSwingItemInferiors, var2.getAfterSwingItemInferiors());
               addSorting(var1, allBaseBeforeUpdateEntityActionStateSuperiors, var2.getBeforeUpdateEntityActionStateSuperiors());
               addSorting(var1, allBaseBeforeUpdateEntityActionStateInferiors, var2.getBeforeUpdateEntityActionStateInferiors());
               addSorting(var1, allBaseOverrideUpdateEntityActionStateSuperiors, var2.getOverrideUpdateEntityActionStateSuperiors());
               addSorting(var1, allBaseOverrideUpdateEntityActionStateInferiors, var2.getOverrideUpdateEntityActionStateInferiors());
               addSorting(var1, allBaseAfterUpdateEntityActionStateSuperiors, var2.getAfterUpdateEntityActionStateSuperiors());
               addSorting(var1, allBaseAfterUpdateEntityActionStateInferiors, var2.getAfterUpdateEntityActionStateInferiors());
               addSorting(var1, allBaseBeforeUpdatePotionEffectsSuperiors, var2.getBeforeUpdatePotionEffectsSuperiors());
               addSorting(var1, allBaseBeforeUpdatePotionEffectsInferiors, var2.getBeforeUpdatePotionEffectsInferiors());
               addSorting(var1, allBaseOverrideUpdatePotionEffectsSuperiors, var2.getOverrideUpdatePotionEffectsSuperiors());
               addSorting(var1, allBaseOverrideUpdatePotionEffectsInferiors, var2.getOverrideUpdatePotionEffectsInferiors());
               addSorting(var1, allBaseAfterUpdatePotionEffectsSuperiors, var2.getAfterUpdatePotionEffectsSuperiors());
               addSorting(var1, allBaseAfterUpdatePotionEffectsInferiors, var2.getAfterUpdatePotionEffectsInferiors());
               addSorting(var1, allBaseBeforeUpdateRiddenSuperiors, var2.getBeforeUpdateRiddenSuperiors());
               addSorting(var1, allBaseBeforeUpdateRiddenInferiors, var2.getBeforeUpdateRiddenInferiors());
               addSorting(var1, allBaseOverrideUpdateRiddenSuperiors, var2.getOverrideUpdateRiddenSuperiors());
               addSorting(var1, allBaseOverrideUpdateRiddenInferiors, var2.getOverrideUpdateRiddenInferiors());
               addSorting(var1, allBaseAfterUpdateRiddenSuperiors, var2.getAfterUpdateRiddenSuperiors());
               addSorting(var1, allBaseAfterUpdateRiddenInferiors, var2.getAfterUpdateRiddenInferiors());
               addSorting(var1, allBaseBeforeWakeUpPlayerSuperiors, var2.getBeforeWakeUpPlayerSuperiors());
               addSorting(var1, allBaseBeforeWakeUpPlayerInferiors, var2.getBeforeWakeUpPlayerInferiors());
               addSorting(var1, allBaseOverrideWakeUpPlayerSuperiors, var2.getOverrideWakeUpPlayerSuperiors());
               addSorting(var1, allBaseOverrideWakeUpPlayerInferiors, var2.getOverrideWakeUpPlayerInferiors());
               addSorting(var1, allBaseAfterWakeUpPlayerSuperiors, var2.getAfterWakeUpPlayerSuperiors());
               addSorting(var1, allBaseAfterWakeUpPlayerInferiors, var2.getAfterWakeUpPlayerInferiors());
               addSorting(var1, allBaseBeforeWriteEntityToNBTSuperiors, var2.getBeforeWriteEntityToNBTSuperiors());
               addSorting(var1, allBaseBeforeWriteEntityToNBTInferiors, var2.getBeforeWriteEntityToNBTInferiors());
               addSorting(var1, allBaseOverrideWriteEntityToNBTSuperiors, var2.getOverrideWriteEntityToNBTSuperiors());
               addSorting(var1, allBaseOverrideWriteEntityToNBTInferiors, var2.getOverrideWriteEntityToNBTInferiors());
               addSorting(var1, allBaseAfterWriteEntityToNBTSuperiors, var2.getAfterWriteEntityToNBTSuperiors());
               addSorting(var1, allBaseAfterWriteEntityToNBTInferiors, var2.getAfterWriteEntityToNBTInferiors());
            }

            addMethod(var1, var0, beforeLocalConstructingHookTypes, "beforeLocalConstructing", new Class[]{MinecraftServer.class, WorldServer.class, GameProfile.class, ItemInWorldManager.class});
            addMethod(var1, var0, afterLocalConstructingHookTypes, "afterLocalConstructing", new Class[]{MinecraftServer.class, WorldServer.class, GameProfile.class, ItemInWorldManager.class});
            addMethod(var1, var0, beforeAddExhaustionHookTypes, "beforeAddExhaustion", new Class[]{Float.TYPE});
            addMethod(var1, var0, overrideAddExhaustionHookTypes, "addExhaustion", new Class[]{Float.TYPE});
            addMethod(var1, var0, afterAddExhaustionHookTypes, "afterAddExhaustion", new Class[]{Float.TYPE});
            addMethod(var1, var0, beforeAddExperienceHookTypes, "beforeAddExperience", new Class[]{Integer.TYPE});
            addMethod(var1, var0, overrideAddExperienceHookTypes, "addExperience", new Class[]{Integer.TYPE});
            addMethod(var1, var0, afterAddExperienceHookTypes, "afterAddExperience", new Class[]{Integer.TYPE});
            addMethod(var1, var0, beforeAddExperienceLevelHookTypes, "beforeAddExperienceLevel", new Class[]{Integer.TYPE});
            addMethod(var1, var0, overrideAddExperienceLevelHookTypes, "addExperienceLevel", new Class[]{Integer.TYPE});
            addMethod(var1, var0, afterAddExperienceLevelHookTypes, "afterAddExperienceLevel", new Class[]{Integer.TYPE});
            addMethod(var1, var0, beforeAddMovementStatHookTypes, "beforeAddMovementStat", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideAddMovementStatHookTypes, "addMovementStat", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterAddMovementStatHookTypes, "afterAddMovementStat", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeAttackEntityFromHookTypes, "beforeAttackEntityFrom", new Class[]{DamageSource.class, Float.TYPE});
            addMethod(var1, var0, overrideAttackEntityFromHookTypes, "attackEntityFrom", new Class[]{DamageSource.class, Float.TYPE});
            addMethod(var1, var0, afterAttackEntityFromHookTypes, "afterAttackEntityFrom", new Class[]{DamageSource.class, Float.TYPE});
            addMethod(var1, var0, beforeAttackTargetEntityWithCurrentItemHookTypes, "beforeAttackTargetEntityWithCurrentItem", new Class[]{Entity.class});
            addMethod(var1, var0, overrideAttackTargetEntityWithCurrentItemHookTypes, "attackTargetEntityWithCurrentItem", new Class[]{Entity.class});
            addMethod(var1, var0, afterAttackTargetEntityWithCurrentItemHookTypes, "afterAttackTargetEntityWithCurrentItem", new Class[]{Entity.class});
            addMethod(var1, var0, beforeCanBreatheUnderwaterHookTypes, "beforeCanBreatheUnderwater", new Class[0]);
            addMethod(var1, var0, overrideCanBreatheUnderwaterHookTypes, "canBreatheUnderwater", new Class[0]);
            addMethod(var1, var0, afterCanBreatheUnderwaterHookTypes, "afterCanBreatheUnderwater", new Class[0]);
            addMethod(var1, var0, beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", new Class[]{Block.class});
            addMethod(var1, var0, overrideCanHarvestBlockHookTypes, "canHarvestBlock", new Class[]{Block.class});
            addMethod(var1, var0, afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", new Class[]{Block.class});
            addMethod(var1, var0, beforeCanPlayerEditHookTypes, "beforeCanPlayerEdit", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, ItemStack.class});
            addMethod(var1, var0, overrideCanPlayerEditHookTypes, "canPlayerEdit", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, ItemStack.class});
            addMethod(var1, var0, afterCanPlayerEditHookTypes, "afterCanPlayerEdit", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, ItemStack.class});
            addMethod(var1, var0, beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking", new Class[0]);
            addMethod(var1, var0, overrideCanTriggerWalkingHookTypes, "canTriggerWalking", new Class[0]);
            addMethod(var1, var0, afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking", new Class[0]);
            addMethod(var1, var0, beforeClonePlayerHookTypes, "beforeClonePlayer", new Class[]{EntityPlayer.class, Boolean.TYPE});
            addMethod(var1, var0, overrideClonePlayerHookTypes, "clonePlayer", new Class[]{EntityPlayer.class, Boolean.TYPE});
            addMethod(var1, var0, afterClonePlayerHookTypes, "afterClonePlayer", new Class[]{EntityPlayer.class, Boolean.TYPE});
            addMethod(var1, var0, beforeDamageEntityHookTypes, "beforeDamageEntity", new Class[]{DamageSource.class, Float.TYPE});
            addMethod(var1, var0, overrideDamageEntityHookTypes, "damageEntity", new Class[]{DamageSource.class, Float.TYPE});
            addMethod(var1, var0, afterDamageEntityHookTypes, "afterDamageEntity", new Class[]{DamageSource.class, Float.TYPE});
            addMethod(var1, var0, beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", new Class[]{IInventory.class});
            addMethod(var1, var0, overrideDisplayGUIChestHookTypes, "displayGUIChest", new Class[]{IInventory.class});
            addMethod(var1, var0, afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", new Class[]{IInventory.class});
            addMethod(var1, var0, beforeDisplayGUIDispenserHookTypes, "beforeDisplayGUIDispenser", new Class[]{TileEntityDispenser.class});
            addMethod(var1, var0, overrideDisplayGUIDispenserHookTypes, "displayGUIDispenser", new Class[]{TileEntityDispenser.class});
            addMethod(var1, var0, afterDisplayGUIDispenserHookTypes, "afterDisplayGUIDispenser", new Class[]{TileEntityDispenser.class});
            addMethod(var1, var0, beforeDisplayGUIFurnaceHookTypes, "beforeDisplayGUIFurnace", new Class[]{TileEntityFurnace.class});
            addMethod(var1, var0, overrideDisplayGUIFurnaceHookTypes, "displayGUIFurnace", new Class[]{TileEntityFurnace.class});
            addMethod(var1, var0, afterDisplayGUIFurnaceHookTypes, "afterDisplayGUIFurnace", new Class[]{TileEntityFurnace.class});
            addMethod(var1, var0, beforeDisplayGUIWorkbenchHookTypes, "beforeDisplayGUIWorkbench", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            addMethod(var1, var0, overrideDisplayGUIWorkbenchHookTypes, "displayGUIWorkbench", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            addMethod(var1, var0, afterDisplayGUIWorkbenchHookTypes, "afterDisplayGUIWorkbench", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            addMethod(var1, var0, beforeDropOneItemHookTypes, "beforeDropOneItem", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, overrideDropOneItemHookTypes, "dropOneItem", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, afterDropOneItemHookTypes, "afterDropOneItem", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, beforeDropPlayerItemHookTypes, "beforeDropPlayerItem", new Class[]{ItemStack.class, Boolean.TYPE});
            addMethod(var1, var0, overrideDropPlayerItemHookTypes, "dropPlayerItem", new Class[]{ItemStack.class, Boolean.TYPE});
            addMethod(var1, var0, afterDropPlayerItemHookTypes, "afterDropPlayerItem", new Class[]{ItemStack.class, Boolean.TYPE});
            addMethod(var1, var0, beforeFallHookTypes, "beforeFall", new Class[]{Float.TYPE});
            addMethod(var1, var0, overrideFallHookTypes, "fall", new Class[]{Float.TYPE});
            addMethod(var1, var0, afterFallHookTypes, "afterFall", new Class[]{Float.TYPE});
            addMethod(var1, var0, beforeGetAIMoveSpeedHookTypes, "beforeGetAIMoveSpeed", new Class[0]);
            addMethod(var1, var0, overrideGetAIMoveSpeedHookTypes, "getAIMoveSpeed", new Class[0]);
            addMethod(var1, var0, afterGetAIMoveSpeedHookTypes, "afterGetAIMoveSpeed", new Class[0]);
            addMethod(var1, var0, beforeGetCurrentPlayerStrVsBlockHookTypes, "beforeGetCurrentPlayerStrVsBlock", new Class[]{Block.class, Boolean.TYPE});
            addMethod(var1, var0, overrideGetCurrentPlayerStrVsBlockHookTypes, "getCurrentPlayerStrVsBlock", new Class[]{Block.class, Boolean.TYPE});
            addMethod(var1, var0, afterGetCurrentPlayerStrVsBlockHookTypes, "afterGetCurrentPlayerStrVsBlock", new Class[]{Block.class, Boolean.TYPE});
            addMethod(var1, var0, beforeGetCurrentPlayerStrVsBlockForgeHookTypes, "beforeGetCurrentPlayerStrVsBlockForge", new Class[]{Block.class, Boolean.TYPE, Integer.TYPE});
            addMethod(var1, var0, overrideGetCurrentPlayerStrVsBlockForgeHookTypes, "getCurrentPlayerStrVsBlockForge", new Class[]{Block.class, Boolean.TYPE, Integer.TYPE});
            addMethod(var1, var0, afterGetCurrentPlayerStrVsBlockForgeHookTypes, "afterGetCurrentPlayerStrVsBlockForge", new Class[]{Block.class, Boolean.TYPE, Integer.TYPE});
            addMethod(var1, var0, beforeGetDistanceSqHookTypes, "beforeGetDistanceSq", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideGetDistanceSqHookTypes, "getDistanceSq", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterGetDistanceSqHookTypes, "afterGetDistanceSq", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeGetBrightnessHookTypes, "beforeGetBrightness", new Class[]{Float.TYPE});
            addMethod(var1, var0, overrideGetBrightnessHookTypes, "getBrightness", new Class[]{Float.TYPE});
            addMethod(var1, var0, afterGetBrightnessHookTypes, "afterGetBrightness", new Class[]{Float.TYPE});
            addMethod(var1, var0, beforeGetEyeHeightHookTypes, "beforeGetEyeHeight", new Class[0]);
            addMethod(var1, var0, overrideGetEyeHeightHookTypes, "getEyeHeight", new Class[0]);
            addMethod(var1, var0, afterGetEyeHeightHookTypes, "afterGetEyeHeight", new Class[0]);
            addMethod(var1, var0, beforeHealHookTypes, "beforeHeal", new Class[]{Float.TYPE});
            addMethod(var1, var0, overrideHealHookTypes, "heal", new Class[]{Float.TYPE});
            addMethod(var1, var0, afterHealHookTypes, "afterHeal", new Class[]{Float.TYPE});
            addMethod(var1, var0, beforeIsEntityInsideOpaqueBlockHookTypes, "beforeIsEntityInsideOpaqueBlock", new Class[0]);
            addMethod(var1, var0, overrideIsEntityInsideOpaqueBlockHookTypes, "isEntityInsideOpaqueBlock", new Class[0]);
            addMethod(var1, var0, afterIsEntityInsideOpaqueBlockHookTypes, "afterIsEntityInsideOpaqueBlock", new Class[0]);
            addMethod(var1, var0, beforeIsInWaterHookTypes, "beforeIsInWater", new Class[0]);
            addMethod(var1, var0, overrideIsInWaterHookTypes, "isInWater", new Class[0]);
            addMethod(var1, var0, afterIsInWaterHookTypes, "afterIsInWater", new Class[0]);
            addMethod(var1, var0, beforeIsInsideOfMaterialHookTypes, "beforeIsInsideOfMaterial", new Class[]{Material.class});
            addMethod(var1, var0, overrideIsInsideOfMaterialHookTypes, "isInsideOfMaterial", new Class[]{Material.class});
            addMethod(var1, var0, afterIsInsideOfMaterialHookTypes, "afterIsInsideOfMaterial", new Class[]{Material.class});
            addMethod(var1, var0, beforeIsOnLadderHookTypes, "beforeIsOnLadder", new Class[0]);
            addMethod(var1, var0, overrideIsOnLadderHookTypes, "isOnLadder", new Class[0]);
            addMethod(var1, var0, afterIsOnLadderHookTypes, "afterIsOnLadder", new Class[0]);
            addMethod(var1, var0, beforeIsPlayerSleepingHookTypes, "beforeIsPlayerSleeping", new Class[0]);
            addMethod(var1, var0, overrideIsPlayerSleepingHookTypes, "isPlayerSleeping", new Class[0]);
            addMethod(var1, var0, afterIsPlayerSleepingHookTypes, "afterIsPlayerSleeping", new Class[0]);
            addMethod(var1, var0, beforeIsSneakingHookTypes, "beforeIsSneaking", new Class[0]);
            addMethod(var1, var0, overrideIsSneakingHookTypes, "isSneaking", new Class[0]);
            addMethod(var1, var0, afterIsSneakingHookTypes, "afterIsSneaking", new Class[0]);
            addMethod(var1, var0, beforeJumpHookTypes, "beforeJump", new Class[0]);
            addMethod(var1, var0, overrideJumpHookTypes, "jump", new Class[0]);
            addMethod(var1, var0, afterJumpHookTypes, "afterJump", new Class[0]);
            addMethod(var1, var0, beforeKnockBackHookTypes, "beforeKnockBack", new Class[]{Entity.class, Float.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideKnockBackHookTypes, "knockBack", new Class[]{Entity.class, Float.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterKnockBackHookTypes, "afterKnockBack", new Class[]{Entity.class, Float.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeMountEntityHookTypes, "beforeMountEntity", new Class[]{Entity.class});
            addMethod(var1, var0, overrideMountEntityHookTypes, "mountEntity", new Class[]{Entity.class});
            addMethod(var1, var0, afterMountEntityHookTypes, "afterMountEntity", new Class[]{Entity.class});
            addMethod(var1, var0, beforeMoveEntityHookTypes, "beforeMoveEntity", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideMoveEntityHookTypes, "moveEntity", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterMoveEntityHookTypes, "afterMoveEntity", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeMoveEntityWithHeadingHookTypes, "beforeMoveEntityWithHeading", new Class[]{Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideMoveEntityWithHeadingHookTypes, "moveEntityWithHeading", new Class[]{Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterMoveEntityWithHeadingHookTypes, "afterMoveEntityWithHeading", new Class[]{Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeMoveFlyingHookTypes, "beforeMoveFlying", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, overrideMoveFlyingHookTypes, "moveFlying", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, afterMoveFlyingHookTypes, "afterMoveFlying", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE});
            addMethod(var1, var0, beforeOnDeathHookTypes, "beforeOnDeath", new Class[]{DamageSource.class});
            addMethod(var1, var0, overrideOnDeathHookTypes, "onDeath", new Class[]{DamageSource.class});
            addMethod(var1, var0, afterOnDeathHookTypes, "afterOnDeath", new Class[]{DamageSource.class});
            addMethod(var1, var0, beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate", new Class[0]);
            addMethod(var1, var0, overrideOnLivingUpdateHookTypes, "onLivingUpdate", new Class[0]);
            addMethod(var1, var0, afterOnLivingUpdateHookTypes, "afterOnLivingUpdate", new Class[0]);
            addMethod(var1, var0, beforeOnKillEntityHookTypes, "beforeOnKillEntity", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, overrideOnKillEntityHookTypes, "onKillEntity", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, afterOnKillEntityHookTypes, "afterOnKillEntity", new Class[]{EntityLivingBase.class});
            addMethod(var1, var0, beforeOnStruckByLightningHookTypes, "beforeOnStruckByLightning", new Class[]{EntityLightningBolt.class});
            addMethod(var1, var0, overrideOnStruckByLightningHookTypes, "onStruckByLightning", new Class[]{EntityLightningBolt.class});
            addMethod(var1, var0, afterOnStruckByLightningHookTypes, "afterOnStruckByLightning", new Class[]{EntityLightningBolt.class});
            addMethod(var1, var0, beforeOnUpdateHookTypes, "beforeOnUpdate", new Class[0]);
            addMethod(var1, var0, overrideOnUpdateHookTypes, "onUpdate", new Class[0]);
            addMethod(var1, var0, afterOnUpdateHookTypes, "afterOnUpdate", new Class[0]);
            addMethod(var1, var0, beforeOnUpdateEntityHookTypes, "beforeOnUpdateEntity", new Class[0]);
            addMethod(var1, var0, overrideOnUpdateEntityHookTypes, "onUpdateEntity", new Class[0]);
            addMethod(var1, var0, afterOnUpdateEntityHookTypes, "afterOnUpdateEntity", new Class[0]);
            addMethod(var1, var0, beforeReadEntityFromNBTHookTypes, "beforeReadEntityFromNBT", new Class[]{NBTTagCompound.class});
            addMethod(var1, var0, overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", new Class[]{NBTTagCompound.class});
            addMethod(var1, var0, afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", new Class[]{NBTTagCompound.class});
            addMethod(var1, var0, beforeSetDeadHookTypes, "beforeSetDead", new Class[0]);
            addMethod(var1, var0, overrideSetDeadHookTypes, "setDead", new Class[0]);
            addMethod(var1, var0, afterSetDeadHookTypes, "afterSetDead", new Class[0]);
            addMethod(var1, var0, beforeSetEntityActionStateHookTypes, "beforeSetEntityActionState", new Class[]{Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE});
            addMethod(var1, var0, overrideSetEntityActionStateHookTypes, "setEntityActionState", new Class[]{Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE});
            addMethod(var1, var0, afterSetEntityActionStateHookTypes, "afterSetEntityActionState", new Class[]{Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE});
            addMethod(var1, var0, beforeSetPositionHookTypes, "beforeSetPosition", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, overrideSetPositionHookTypes, "setPosition", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, afterSetPositionHookTypes, "afterSetPosition", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
            addMethod(var1, var0, beforeSetSneakingHookTypes, "beforeSetSneaking", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, overrideSetSneakingHookTypes, "setSneaking", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, afterSetSneakingHookTypes, "afterSetSneaking", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, beforeSetSprintingHookTypes, "beforeSetSprinting", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, overrideSetSprintingHookTypes, "setSprinting", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, afterSetSprintingHookTypes, "afterSetSprinting", new Class[]{Boolean.TYPE});
            addMethod(var1, var0, beforeSwingItemHookTypes, "beforeSwingItem", new Class[0]);
            addMethod(var1, var0, overrideSwingItemHookTypes, "swingItem", new Class[0]);
            addMethod(var1, var0, afterSwingItemHookTypes, "afterSwingItem", new Class[0]);
            addMethod(var1, var0, beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState", new Class[0]);
            addMethod(var1, var0, overrideUpdateEntityActionStateHookTypes, "updateEntityActionState", new Class[0]);
            addMethod(var1, var0, afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState", new Class[0]);
            addMethod(var1, var0, beforeUpdatePotionEffectsHookTypes, "beforeUpdatePotionEffects", new Class[0]);
            addMethod(var1, var0, overrideUpdatePotionEffectsHookTypes, "updatePotionEffects", new Class[0]);
            addMethod(var1, var0, afterUpdatePotionEffectsHookTypes, "afterUpdatePotionEffects", new Class[0]);
            addMethod(var1, var0, beforeUpdateRiddenHookTypes, "beforeUpdateRidden", new Class[0]);
            addMethod(var1, var0, overrideUpdateRiddenHookTypes, "updateRidden", new Class[0]);
            addMethod(var1, var0, afterUpdateRiddenHookTypes, "afterUpdateRidden", new Class[0]);
            addMethod(var1, var0, beforeWakeUpPlayerHookTypes, "beforeWakeUpPlayer", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE});
            addMethod(var1, var0, overrideWakeUpPlayerHookTypes, "wakeUpPlayer", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE});
            addMethod(var1, var0, afterWakeUpPlayerHookTypes, "afterWakeUpPlayer", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE});
            addMethod(var1, var0, beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", new Class[]{NBTTagCompound.class});
            addMethod(var1, var0, overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", new Class[]{NBTTagCompound.class});
            addMethod(var1, var0, afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", new Class[]{NBTTagCompound.class});
            addDynamicMethods(var1, var0);
            addDynamicKeys(var1, var0, beforeDynamicHookMethods, beforeDynamicHookTypes);
            addDynamicKeys(var1, var0, overrideDynamicHookMethods, overrideDynamicHookTypes);
            addDynamicKeys(var1, var0, afterDynamicHookMethods, afterDynamicHookTypes);
            initialize();
            Iterator var19 = getAllInstancesList().iterator();

            while(var19.hasNext()) {
               IServerPlayerAPI var20 = (IServerPlayerAPI)var19.next();
               var20.getServerPlayerAPI().attachServerPlayerBase(var1);
            }

            System.out.println("Server Player: registered " + var1);
            logger.fine("Server Player: registered class \'" + var0.getName() + "\' with id \'" + var1 + "\'");
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

            IServerPlayerAPI var3;
            while(var2.hasNext()) {
               var3 = (IServerPlayerAPI)var2.next();
               var3.getServerPlayerAPI().detachServerPlayerBase(var0);
            }

            beforeLocalConstructingHookTypes.remove(var0);
            afterLocalConstructingHookTypes.remove(var0);
            allBaseBeforeAddExhaustionSuperiors.remove(var0);
            allBaseBeforeAddExhaustionInferiors.remove(var0);
            allBaseOverrideAddExhaustionSuperiors.remove(var0);
            allBaseOverrideAddExhaustionInferiors.remove(var0);
            allBaseAfterAddExhaustionSuperiors.remove(var0);
            allBaseAfterAddExhaustionInferiors.remove(var0);
            beforeAddExhaustionHookTypes.remove(var0);
            overrideAddExhaustionHookTypes.remove(var0);
            afterAddExhaustionHookTypes.remove(var0);
            allBaseBeforeAddExperienceSuperiors.remove(var0);
            allBaseBeforeAddExperienceInferiors.remove(var0);
            allBaseOverrideAddExperienceSuperiors.remove(var0);
            allBaseOverrideAddExperienceInferiors.remove(var0);
            allBaseAfterAddExperienceSuperiors.remove(var0);
            allBaseAfterAddExperienceInferiors.remove(var0);
            beforeAddExperienceHookTypes.remove(var0);
            overrideAddExperienceHookTypes.remove(var0);
            afterAddExperienceHookTypes.remove(var0);
            allBaseBeforeAddExperienceLevelSuperiors.remove(var0);
            allBaseBeforeAddExperienceLevelInferiors.remove(var0);
            allBaseOverrideAddExperienceLevelSuperiors.remove(var0);
            allBaseOverrideAddExperienceLevelInferiors.remove(var0);
            allBaseAfterAddExperienceLevelSuperiors.remove(var0);
            allBaseAfterAddExperienceLevelInferiors.remove(var0);
            beforeAddExperienceLevelHookTypes.remove(var0);
            overrideAddExperienceLevelHookTypes.remove(var0);
            afterAddExperienceLevelHookTypes.remove(var0);
            allBaseBeforeAddMovementStatSuperiors.remove(var0);
            allBaseBeforeAddMovementStatInferiors.remove(var0);
            allBaseOverrideAddMovementStatSuperiors.remove(var0);
            allBaseOverrideAddMovementStatInferiors.remove(var0);
            allBaseAfterAddMovementStatSuperiors.remove(var0);
            allBaseAfterAddMovementStatInferiors.remove(var0);
            beforeAddMovementStatHookTypes.remove(var0);
            overrideAddMovementStatHookTypes.remove(var0);
            afterAddMovementStatHookTypes.remove(var0);
            allBaseBeforeAttackEntityFromSuperiors.remove(var0);
            allBaseBeforeAttackEntityFromInferiors.remove(var0);
            allBaseOverrideAttackEntityFromSuperiors.remove(var0);
            allBaseOverrideAttackEntityFromInferiors.remove(var0);
            allBaseAfterAttackEntityFromSuperiors.remove(var0);
            allBaseAfterAttackEntityFromInferiors.remove(var0);
            beforeAttackEntityFromHookTypes.remove(var0);
            overrideAttackEntityFromHookTypes.remove(var0);
            afterAttackEntityFromHookTypes.remove(var0);
            allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors.remove(var0);
            allBaseBeforeAttackTargetEntityWithCurrentItemInferiors.remove(var0);
            allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors.remove(var0);
            allBaseOverrideAttackTargetEntityWithCurrentItemInferiors.remove(var0);
            allBaseAfterAttackTargetEntityWithCurrentItemSuperiors.remove(var0);
            allBaseAfterAttackTargetEntityWithCurrentItemInferiors.remove(var0);
            beforeAttackTargetEntityWithCurrentItemHookTypes.remove(var0);
            overrideAttackTargetEntityWithCurrentItemHookTypes.remove(var0);
            afterAttackTargetEntityWithCurrentItemHookTypes.remove(var0);
            allBaseBeforeCanBreatheUnderwaterSuperiors.remove(var0);
            allBaseBeforeCanBreatheUnderwaterInferiors.remove(var0);
            allBaseOverrideCanBreatheUnderwaterSuperiors.remove(var0);
            allBaseOverrideCanBreatheUnderwaterInferiors.remove(var0);
            allBaseAfterCanBreatheUnderwaterSuperiors.remove(var0);
            allBaseAfterCanBreatheUnderwaterInferiors.remove(var0);
            beforeCanBreatheUnderwaterHookTypes.remove(var0);
            overrideCanBreatheUnderwaterHookTypes.remove(var0);
            afterCanBreatheUnderwaterHookTypes.remove(var0);
            allBaseBeforeCanHarvestBlockSuperiors.remove(var0);
            allBaseBeforeCanHarvestBlockInferiors.remove(var0);
            allBaseOverrideCanHarvestBlockSuperiors.remove(var0);
            allBaseOverrideCanHarvestBlockInferiors.remove(var0);
            allBaseAfterCanHarvestBlockSuperiors.remove(var0);
            allBaseAfterCanHarvestBlockInferiors.remove(var0);
            beforeCanHarvestBlockHookTypes.remove(var0);
            overrideCanHarvestBlockHookTypes.remove(var0);
            afterCanHarvestBlockHookTypes.remove(var0);
            allBaseBeforeCanPlayerEditSuperiors.remove(var0);
            allBaseBeforeCanPlayerEditInferiors.remove(var0);
            allBaseOverrideCanPlayerEditSuperiors.remove(var0);
            allBaseOverrideCanPlayerEditInferiors.remove(var0);
            allBaseAfterCanPlayerEditSuperiors.remove(var0);
            allBaseAfterCanPlayerEditInferiors.remove(var0);
            beforeCanPlayerEditHookTypes.remove(var0);
            overrideCanPlayerEditHookTypes.remove(var0);
            afterCanPlayerEditHookTypes.remove(var0);
            allBaseBeforeCanTriggerWalkingSuperiors.remove(var0);
            allBaseBeforeCanTriggerWalkingInferiors.remove(var0);
            allBaseOverrideCanTriggerWalkingSuperiors.remove(var0);
            allBaseOverrideCanTriggerWalkingInferiors.remove(var0);
            allBaseAfterCanTriggerWalkingSuperiors.remove(var0);
            allBaseAfterCanTriggerWalkingInferiors.remove(var0);
            beforeCanTriggerWalkingHookTypes.remove(var0);
            overrideCanTriggerWalkingHookTypes.remove(var0);
            afterCanTriggerWalkingHookTypes.remove(var0);
            allBaseBeforeClonePlayerSuperiors.remove(var0);
            allBaseBeforeClonePlayerInferiors.remove(var0);
            allBaseOverrideClonePlayerSuperiors.remove(var0);
            allBaseOverrideClonePlayerInferiors.remove(var0);
            allBaseAfterClonePlayerSuperiors.remove(var0);
            allBaseAfterClonePlayerInferiors.remove(var0);
            beforeClonePlayerHookTypes.remove(var0);
            overrideClonePlayerHookTypes.remove(var0);
            afterClonePlayerHookTypes.remove(var0);
            allBaseBeforeDamageEntitySuperiors.remove(var0);
            allBaseBeforeDamageEntityInferiors.remove(var0);
            allBaseOverrideDamageEntitySuperiors.remove(var0);
            allBaseOverrideDamageEntityInferiors.remove(var0);
            allBaseAfterDamageEntitySuperiors.remove(var0);
            allBaseAfterDamageEntityInferiors.remove(var0);
            beforeDamageEntityHookTypes.remove(var0);
            overrideDamageEntityHookTypes.remove(var0);
            afterDamageEntityHookTypes.remove(var0);
            allBaseBeforeDisplayGUIChestSuperiors.remove(var0);
            allBaseBeforeDisplayGUIChestInferiors.remove(var0);
            allBaseOverrideDisplayGUIChestSuperiors.remove(var0);
            allBaseOverrideDisplayGUIChestInferiors.remove(var0);
            allBaseAfterDisplayGUIChestSuperiors.remove(var0);
            allBaseAfterDisplayGUIChestInferiors.remove(var0);
            beforeDisplayGUIChestHookTypes.remove(var0);
            overrideDisplayGUIChestHookTypes.remove(var0);
            afterDisplayGUIChestHookTypes.remove(var0);
            allBaseBeforeDisplayGUIDispenserSuperiors.remove(var0);
            allBaseBeforeDisplayGUIDispenserInferiors.remove(var0);
            allBaseOverrideDisplayGUIDispenserSuperiors.remove(var0);
            allBaseOverrideDisplayGUIDispenserInferiors.remove(var0);
            allBaseAfterDisplayGUIDispenserSuperiors.remove(var0);
            allBaseAfterDisplayGUIDispenserInferiors.remove(var0);
            beforeDisplayGUIDispenserHookTypes.remove(var0);
            overrideDisplayGUIDispenserHookTypes.remove(var0);
            afterDisplayGUIDispenserHookTypes.remove(var0);
            allBaseBeforeDisplayGUIFurnaceSuperiors.remove(var0);
            allBaseBeforeDisplayGUIFurnaceInferiors.remove(var0);
            allBaseOverrideDisplayGUIFurnaceSuperiors.remove(var0);
            allBaseOverrideDisplayGUIFurnaceInferiors.remove(var0);
            allBaseAfterDisplayGUIFurnaceSuperiors.remove(var0);
            allBaseAfterDisplayGUIFurnaceInferiors.remove(var0);
            beforeDisplayGUIFurnaceHookTypes.remove(var0);
            overrideDisplayGUIFurnaceHookTypes.remove(var0);
            afterDisplayGUIFurnaceHookTypes.remove(var0);
            allBaseBeforeDisplayGUIWorkbenchSuperiors.remove(var0);
            allBaseBeforeDisplayGUIWorkbenchInferiors.remove(var0);
            allBaseOverrideDisplayGUIWorkbenchSuperiors.remove(var0);
            allBaseOverrideDisplayGUIWorkbenchInferiors.remove(var0);
            allBaseAfterDisplayGUIWorkbenchSuperiors.remove(var0);
            allBaseAfterDisplayGUIWorkbenchInferiors.remove(var0);
            beforeDisplayGUIWorkbenchHookTypes.remove(var0);
            overrideDisplayGUIWorkbenchHookTypes.remove(var0);
            afterDisplayGUIWorkbenchHookTypes.remove(var0);
            allBaseBeforeDropOneItemSuperiors.remove(var0);
            allBaseBeforeDropOneItemInferiors.remove(var0);
            allBaseOverrideDropOneItemSuperiors.remove(var0);
            allBaseOverrideDropOneItemInferiors.remove(var0);
            allBaseAfterDropOneItemSuperiors.remove(var0);
            allBaseAfterDropOneItemInferiors.remove(var0);
            beforeDropOneItemHookTypes.remove(var0);
            overrideDropOneItemHookTypes.remove(var0);
            afterDropOneItemHookTypes.remove(var0);
            allBaseBeforeDropPlayerItemSuperiors.remove(var0);
            allBaseBeforeDropPlayerItemInferiors.remove(var0);
            allBaseOverrideDropPlayerItemSuperiors.remove(var0);
            allBaseOverrideDropPlayerItemInferiors.remove(var0);
            allBaseAfterDropPlayerItemSuperiors.remove(var0);
            allBaseAfterDropPlayerItemInferiors.remove(var0);
            beforeDropPlayerItemHookTypes.remove(var0);
            overrideDropPlayerItemHookTypes.remove(var0);
            afterDropPlayerItemHookTypes.remove(var0);
            allBaseBeforeFallSuperiors.remove(var0);
            allBaseBeforeFallInferiors.remove(var0);
            allBaseOverrideFallSuperiors.remove(var0);
            allBaseOverrideFallInferiors.remove(var0);
            allBaseAfterFallSuperiors.remove(var0);
            allBaseAfterFallInferiors.remove(var0);
            beforeFallHookTypes.remove(var0);
            overrideFallHookTypes.remove(var0);
            afterFallHookTypes.remove(var0);
            allBaseBeforeGetAIMoveSpeedSuperiors.remove(var0);
            allBaseBeforeGetAIMoveSpeedInferiors.remove(var0);
            allBaseOverrideGetAIMoveSpeedSuperiors.remove(var0);
            allBaseOverrideGetAIMoveSpeedInferiors.remove(var0);
            allBaseAfterGetAIMoveSpeedSuperiors.remove(var0);
            allBaseAfterGetAIMoveSpeedInferiors.remove(var0);
            beforeGetAIMoveSpeedHookTypes.remove(var0);
            overrideGetAIMoveSpeedHookTypes.remove(var0);
            afterGetAIMoveSpeedHookTypes.remove(var0);
            allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors.remove(var0);
            allBaseBeforeGetCurrentPlayerStrVsBlockInferiors.remove(var0);
            allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors.remove(var0);
            allBaseOverrideGetCurrentPlayerStrVsBlockInferiors.remove(var0);
            allBaseAfterGetCurrentPlayerStrVsBlockSuperiors.remove(var0);
            allBaseAfterGetCurrentPlayerStrVsBlockInferiors.remove(var0);
            beforeGetCurrentPlayerStrVsBlockHookTypes.remove(var0);
            overrideGetCurrentPlayerStrVsBlockHookTypes.remove(var0);
            afterGetCurrentPlayerStrVsBlockHookTypes.remove(var0);
            allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors.remove(var0);
            allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors.remove(var0);
            allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors.remove(var0);
            allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors.remove(var0);
            allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors.remove(var0);
            allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors.remove(var0);
            beforeGetCurrentPlayerStrVsBlockForgeHookTypes.remove(var0);
            overrideGetCurrentPlayerStrVsBlockForgeHookTypes.remove(var0);
            afterGetCurrentPlayerStrVsBlockForgeHookTypes.remove(var0);
            allBaseBeforeGetDistanceSqSuperiors.remove(var0);
            allBaseBeforeGetDistanceSqInferiors.remove(var0);
            allBaseOverrideGetDistanceSqSuperiors.remove(var0);
            allBaseOverrideGetDistanceSqInferiors.remove(var0);
            allBaseAfterGetDistanceSqSuperiors.remove(var0);
            allBaseAfterGetDistanceSqInferiors.remove(var0);
            beforeGetDistanceSqHookTypes.remove(var0);
            overrideGetDistanceSqHookTypes.remove(var0);
            afterGetDistanceSqHookTypes.remove(var0);
            allBaseBeforeGetBrightnessSuperiors.remove(var0);
            allBaseBeforeGetBrightnessInferiors.remove(var0);
            allBaseOverrideGetBrightnessSuperiors.remove(var0);
            allBaseOverrideGetBrightnessInferiors.remove(var0);
            allBaseAfterGetBrightnessSuperiors.remove(var0);
            allBaseAfterGetBrightnessInferiors.remove(var0);
            beforeGetBrightnessHookTypes.remove(var0);
            overrideGetBrightnessHookTypes.remove(var0);
            afterGetBrightnessHookTypes.remove(var0);
            allBaseBeforeGetEyeHeightSuperiors.remove(var0);
            allBaseBeforeGetEyeHeightInferiors.remove(var0);
            allBaseOverrideGetEyeHeightSuperiors.remove(var0);
            allBaseOverrideGetEyeHeightInferiors.remove(var0);
            allBaseAfterGetEyeHeightSuperiors.remove(var0);
            allBaseAfterGetEyeHeightInferiors.remove(var0);
            beforeGetEyeHeightHookTypes.remove(var0);
            overrideGetEyeHeightHookTypes.remove(var0);
            afterGetEyeHeightHookTypes.remove(var0);
            allBaseBeforeHealSuperiors.remove(var0);
            allBaseBeforeHealInferiors.remove(var0);
            allBaseOverrideHealSuperiors.remove(var0);
            allBaseOverrideHealInferiors.remove(var0);
            allBaseAfterHealSuperiors.remove(var0);
            allBaseAfterHealInferiors.remove(var0);
            beforeHealHookTypes.remove(var0);
            overrideHealHookTypes.remove(var0);
            afterHealHookTypes.remove(var0);
            allBaseBeforeIsEntityInsideOpaqueBlockSuperiors.remove(var0);
            allBaseBeforeIsEntityInsideOpaqueBlockInferiors.remove(var0);
            allBaseOverrideIsEntityInsideOpaqueBlockSuperiors.remove(var0);
            allBaseOverrideIsEntityInsideOpaqueBlockInferiors.remove(var0);
            allBaseAfterIsEntityInsideOpaqueBlockSuperiors.remove(var0);
            allBaseAfterIsEntityInsideOpaqueBlockInferiors.remove(var0);
            beforeIsEntityInsideOpaqueBlockHookTypes.remove(var0);
            overrideIsEntityInsideOpaqueBlockHookTypes.remove(var0);
            afterIsEntityInsideOpaqueBlockHookTypes.remove(var0);
            allBaseBeforeIsInWaterSuperiors.remove(var0);
            allBaseBeforeIsInWaterInferiors.remove(var0);
            allBaseOverrideIsInWaterSuperiors.remove(var0);
            allBaseOverrideIsInWaterInferiors.remove(var0);
            allBaseAfterIsInWaterSuperiors.remove(var0);
            allBaseAfterIsInWaterInferiors.remove(var0);
            beforeIsInWaterHookTypes.remove(var0);
            overrideIsInWaterHookTypes.remove(var0);
            afterIsInWaterHookTypes.remove(var0);
            allBaseBeforeIsInsideOfMaterialSuperiors.remove(var0);
            allBaseBeforeIsInsideOfMaterialInferiors.remove(var0);
            allBaseOverrideIsInsideOfMaterialSuperiors.remove(var0);
            allBaseOverrideIsInsideOfMaterialInferiors.remove(var0);
            allBaseAfterIsInsideOfMaterialSuperiors.remove(var0);
            allBaseAfterIsInsideOfMaterialInferiors.remove(var0);
            beforeIsInsideOfMaterialHookTypes.remove(var0);
            overrideIsInsideOfMaterialHookTypes.remove(var0);
            afterIsInsideOfMaterialHookTypes.remove(var0);
            allBaseBeforeIsOnLadderSuperiors.remove(var0);
            allBaseBeforeIsOnLadderInferiors.remove(var0);
            allBaseOverrideIsOnLadderSuperiors.remove(var0);
            allBaseOverrideIsOnLadderInferiors.remove(var0);
            allBaseAfterIsOnLadderSuperiors.remove(var0);
            allBaseAfterIsOnLadderInferiors.remove(var0);
            beforeIsOnLadderHookTypes.remove(var0);
            overrideIsOnLadderHookTypes.remove(var0);
            afterIsOnLadderHookTypes.remove(var0);
            allBaseBeforeIsPlayerSleepingSuperiors.remove(var0);
            allBaseBeforeIsPlayerSleepingInferiors.remove(var0);
            allBaseOverrideIsPlayerSleepingSuperiors.remove(var0);
            allBaseOverrideIsPlayerSleepingInferiors.remove(var0);
            allBaseAfterIsPlayerSleepingSuperiors.remove(var0);
            allBaseAfterIsPlayerSleepingInferiors.remove(var0);
            beforeIsPlayerSleepingHookTypes.remove(var0);
            overrideIsPlayerSleepingHookTypes.remove(var0);
            afterIsPlayerSleepingHookTypes.remove(var0);
            allBaseBeforeIsSneakingSuperiors.remove(var0);
            allBaseBeforeIsSneakingInferiors.remove(var0);
            allBaseOverrideIsSneakingSuperiors.remove(var0);
            allBaseOverrideIsSneakingInferiors.remove(var0);
            allBaseAfterIsSneakingSuperiors.remove(var0);
            allBaseAfterIsSneakingInferiors.remove(var0);
            beforeIsSneakingHookTypes.remove(var0);
            overrideIsSneakingHookTypes.remove(var0);
            afterIsSneakingHookTypes.remove(var0);
            allBaseBeforeJumpSuperiors.remove(var0);
            allBaseBeforeJumpInferiors.remove(var0);
            allBaseOverrideJumpSuperiors.remove(var0);
            allBaseOverrideJumpInferiors.remove(var0);
            allBaseAfterJumpSuperiors.remove(var0);
            allBaseAfterJumpInferiors.remove(var0);
            beforeJumpHookTypes.remove(var0);
            overrideJumpHookTypes.remove(var0);
            afterJumpHookTypes.remove(var0);
            allBaseBeforeKnockBackSuperiors.remove(var0);
            allBaseBeforeKnockBackInferiors.remove(var0);
            allBaseOverrideKnockBackSuperiors.remove(var0);
            allBaseOverrideKnockBackInferiors.remove(var0);
            allBaseAfterKnockBackSuperiors.remove(var0);
            allBaseAfterKnockBackInferiors.remove(var0);
            beforeKnockBackHookTypes.remove(var0);
            overrideKnockBackHookTypes.remove(var0);
            afterKnockBackHookTypes.remove(var0);
            allBaseBeforeMountEntitySuperiors.remove(var0);
            allBaseBeforeMountEntityInferiors.remove(var0);
            allBaseOverrideMountEntitySuperiors.remove(var0);
            allBaseOverrideMountEntityInferiors.remove(var0);
            allBaseAfterMountEntitySuperiors.remove(var0);
            allBaseAfterMountEntityInferiors.remove(var0);
            beforeMountEntityHookTypes.remove(var0);
            overrideMountEntityHookTypes.remove(var0);
            afterMountEntityHookTypes.remove(var0);
            allBaseBeforeMoveEntitySuperiors.remove(var0);
            allBaseBeforeMoveEntityInferiors.remove(var0);
            allBaseOverrideMoveEntitySuperiors.remove(var0);
            allBaseOverrideMoveEntityInferiors.remove(var0);
            allBaseAfterMoveEntitySuperiors.remove(var0);
            allBaseAfterMoveEntityInferiors.remove(var0);
            beforeMoveEntityHookTypes.remove(var0);
            overrideMoveEntityHookTypes.remove(var0);
            afterMoveEntityHookTypes.remove(var0);
            allBaseBeforeMoveEntityWithHeadingSuperiors.remove(var0);
            allBaseBeforeMoveEntityWithHeadingInferiors.remove(var0);
            allBaseOverrideMoveEntityWithHeadingSuperiors.remove(var0);
            allBaseOverrideMoveEntityWithHeadingInferiors.remove(var0);
            allBaseAfterMoveEntityWithHeadingSuperiors.remove(var0);
            allBaseAfterMoveEntityWithHeadingInferiors.remove(var0);
            beforeMoveEntityWithHeadingHookTypes.remove(var0);
            overrideMoveEntityWithHeadingHookTypes.remove(var0);
            afterMoveEntityWithHeadingHookTypes.remove(var0);
            allBaseBeforeMoveFlyingSuperiors.remove(var0);
            allBaseBeforeMoveFlyingInferiors.remove(var0);
            allBaseOverrideMoveFlyingSuperiors.remove(var0);
            allBaseOverrideMoveFlyingInferiors.remove(var0);
            allBaseAfterMoveFlyingSuperiors.remove(var0);
            allBaseAfterMoveFlyingInferiors.remove(var0);
            beforeMoveFlyingHookTypes.remove(var0);
            overrideMoveFlyingHookTypes.remove(var0);
            afterMoveFlyingHookTypes.remove(var0);
            allBaseBeforeOnDeathSuperiors.remove(var0);
            allBaseBeforeOnDeathInferiors.remove(var0);
            allBaseOverrideOnDeathSuperiors.remove(var0);
            allBaseOverrideOnDeathInferiors.remove(var0);
            allBaseAfterOnDeathSuperiors.remove(var0);
            allBaseAfterOnDeathInferiors.remove(var0);
            beforeOnDeathHookTypes.remove(var0);
            overrideOnDeathHookTypes.remove(var0);
            afterOnDeathHookTypes.remove(var0);
            allBaseBeforeOnLivingUpdateSuperiors.remove(var0);
            allBaseBeforeOnLivingUpdateInferiors.remove(var0);
            allBaseOverrideOnLivingUpdateSuperiors.remove(var0);
            allBaseOverrideOnLivingUpdateInferiors.remove(var0);
            allBaseAfterOnLivingUpdateSuperiors.remove(var0);
            allBaseAfterOnLivingUpdateInferiors.remove(var0);
            beforeOnLivingUpdateHookTypes.remove(var0);
            overrideOnLivingUpdateHookTypes.remove(var0);
            afterOnLivingUpdateHookTypes.remove(var0);
            allBaseBeforeOnKillEntitySuperiors.remove(var0);
            allBaseBeforeOnKillEntityInferiors.remove(var0);
            allBaseOverrideOnKillEntitySuperiors.remove(var0);
            allBaseOverrideOnKillEntityInferiors.remove(var0);
            allBaseAfterOnKillEntitySuperiors.remove(var0);
            allBaseAfterOnKillEntityInferiors.remove(var0);
            beforeOnKillEntityHookTypes.remove(var0);
            overrideOnKillEntityHookTypes.remove(var0);
            afterOnKillEntityHookTypes.remove(var0);
            allBaseBeforeOnStruckByLightningSuperiors.remove(var0);
            allBaseBeforeOnStruckByLightningInferiors.remove(var0);
            allBaseOverrideOnStruckByLightningSuperiors.remove(var0);
            allBaseOverrideOnStruckByLightningInferiors.remove(var0);
            allBaseAfterOnStruckByLightningSuperiors.remove(var0);
            allBaseAfterOnStruckByLightningInferiors.remove(var0);
            beforeOnStruckByLightningHookTypes.remove(var0);
            overrideOnStruckByLightningHookTypes.remove(var0);
            afterOnStruckByLightningHookTypes.remove(var0);
            allBaseBeforeOnUpdateSuperiors.remove(var0);
            allBaseBeforeOnUpdateInferiors.remove(var0);
            allBaseOverrideOnUpdateSuperiors.remove(var0);
            allBaseOverrideOnUpdateInferiors.remove(var0);
            allBaseAfterOnUpdateSuperiors.remove(var0);
            allBaseAfterOnUpdateInferiors.remove(var0);
            beforeOnUpdateHookTypes.remove(var0);
            overrideOnUpdateHookTypes.remove(var0);
            afterOnUpdateHookTypes.remove(var0);
            allBaseBeforeOnUpdateEntitySuperiors.remove(var0);
            allBaseBeforeOnUpdateEntityInferiors.remove(var0);
            allBaseOverrideOnUpdateEntitySuperiors.remove(var0);
            allBaseOverrideOnUpdateEntityInferiors.remove(var0);
            allBaseAfterOnUpdateEntitySuperiors.remove(var0);
            allBaseAfterOnUpdateEntityInferiors.remove(var0);
            beforeOnUpdateEntityHookTypes.remove(var0);
            overrideOnUpdateEntityHookTypes.remove(var0);
            afterOnUpdateEntityHookTypes.remove(var0);
            allBaseBeforeReadEntityFromNBTSuperiors.remove(var0);
            allBaseBeforeReadEntityFromNBTInferiors.remove(var0);
            allBaseOverrideReadEntityFromNBTSuperiors.remove(var0);
            allBaseOverrideReadEntityFromNBTInferiors.remove(var0);
            allBaseAfterReadEntityFromNBTSuperiors.remove(var0);
            allBaseAfterReadEntityFromNBTInferiors.remove(var0);
            beforeReadEntityFromNBTHookTypes.remove(var0);
            overrideReadEntityFromNBTHookTypes.remove(var0);
            afterReadEntityFromNBTHookTypes.remove(var0);
            allBaseBeforeSetDeadSuperiors.remove(var0);
            allBaseBeforeSetDeadInferiors.remove(var0);
            allBaseOverrideSetDeadSuperiors.remove(var0);
            allBaseOverrideSetDeadInferiors.remove(var0);
            allBaseAfterSetDeadSuperiors.remove(var0);
            allBaseAfterSetDeadInferiors.remove(var0);
            beforeSetDeadHookTypes.remove(var0);
            overrideSetDeadHookTypes.remove(var0);
            afterSetDeadHookTypes.remove(var0);
            allBaseBeforeSetEntityActionStateSuperiors.remove(var0);
            allBaseBeforeSetEntityActionStateInferiors.remove(var0);
            allBaseOverrideSetEntityActionStateSuperiors.remove(var0);
            allBaseOverrideSetEntityActionStateInferiors.remove(var0);
            allBaseAfterSetEntityActionStateSuperiors.remove(var0);
            allBaseAfterSetEntityActionStateInferiors.remove(var0);
            beforeSetEntityActionStateHookTypes.remove(var0);
            overrideSetEntityActionStateHookTypes.remove(var0);
            afterSetEntityActionStateHookTypes.remove(var0);
            allBaseBeforeSetPositionSuperiors.remove(var0);
            allBaseBeforeSetPositionInferiors.remove(var0);
            allBaseOverrideSetPositionSuperiors.remove(var0);
            allBaseOverrideSetPositionInferiors.remove(var0);
            allBaseAfterSetPositionSuperiors.remove(var0);
            allBaseAfterSetPositionInferiors.remove(var0);
            beforeSetPositionHookTypes.remove(var0);
            overrideSetPositionHookTypes.remove(var0);
            afterSetPositionHookTypes.remove(var0);
            allBaseBeforeSetSneakingSuperiors.remove(var0);
            allBaseBeforeSetSneakingInferiors.remove(var0);
            allBaseOverrideSetSneakingSuperiors.remove(var0);
            allBaseOverrideSetSneakingInferiors.remove(var0);
            allBaseAfterSetSneakingSuperiors.remove(var0);
            allBaseAfterSetSneakingInferiors.remove(var0);
            beforeSetSneakingHookTypes.remove(var0);
            overrideSetSneakingHookTypes.remove(var0);
            afterSetSneakingHookTypes.remove(var0);
            allBaseBeforeSetSprintingSuperiors.remove(var0);
            allBaseBeforeSetSprintingInferiors.remove(var0);
            allBaseOverrideSetSprintingSuperiors.remove(var0);
            allBaseOverrideSetSprintingInferiors.remove(var0);
            allBaseAfterSetSprintingSuperiors.remove(var0);
            allBaseAfterSetSprintingInferiors.remove(var0);
            beforeSetSprintingHookTypes.remove(var0);
            overrideSetSprintingHookTypes.remove(var0);
            afterSetSprintingHookTypes.remove(var0);
            allBaseBeforeSwingItemSuperiors.remove(var0);
            allBaseBeforeSwingItemInferiors.remove(var0);
            allBaseOverrideSwingItemSuperiors.remove(var0);
            allBaseOverrideSwingItemInferiors.remove(var0);
            allBaseAfterSwingItemSuperiors.remove(var0);
            allBaseAfterSwingItemInferiors.remove(var0);
            beforeSwingItemHookTypes.remove(var0);
            overrideSwingItemHookTypes.remove(var0);
            afterSwingItemHookTypes.remove(var0);
            allBaseBeforeUpdateEntityActionStateSuperiors.remove(var0);
            allBaseBeforeUpdateEntityActionStateInferiors.remove(var0);
            allBaseOverrideUpdateEntityActionStateSuperiors.remove(var0);
            allBaseOverrideUpdateEntityActionStateInferiors.remove(var0);
            allBaseAfterUpdateEntityActionStateSuperiors.remove(var0);
            allBaseAfterUpdateEntityActionStateInferiors.remove(var0);
            beforeUpdateEntityActionStateHookTypes.remove(var0);
            overrideUpdateEntityActionStateHookTypes.remove(var0);
            afterUpdateEntityActionStateHookTypes.remove(var0);
            allBaseBeforeUpdatePotionEffectsSuperiors.remove(var0);
            allBaseBeforeUpdatePotionEffectsInferiors.remove(var0);
            allBaseOverrideUpdatePotionEffectsSuperiors.remove(var0);
            allBaseOverrideUpdatePotionEffectsInferiors.remove(var0);
            allBaseAfterUpdatePotionEffectsSuperiors.remove(var0);
            allBaseAfterUpdatePotionEffectsInferiors.remove(var0);
            beforeUpdatePotionEffectsHookTypes.remove(var0);
            overrideUpdatePotionEffectsHookTypes.remove(var0);
            afterUpdatePotionEffectsHookTypes.remove(var0);
            allBaseBeforeUpdateRiddenSuperiors.remove(var0);
            allBaseBeforeUpdateRiddenInferiors.remove(var0);
            allBaseOverrideUpdateRiddenSuperiors.remove(var0);
            allBaseOverrideUpdateRiddenInferiors.remove(var0);
            allBaseAfterUpdateRiddenSuperiors.remove(var0);
            allBaseAfterUpdateRiddenInferiors.remove(var0);
            beforeUpdateRiddenHookTypes.remove(var0);
            overrideUpdateRiddenHookTypes.remove(var0);
            afterUpdateRiddenHookTypes.remove(var0);
            allBaseBeforeWakeUpPlayerSuperiors.remove(var0);
            allBaseBeforeWakeUpPlayerInferiors.remove(var0);
            allBaseOverrideWakeUpPlayerSuperiors.remove(var0);
            allBaseOverrideWakeUpPlayerInferiors.remove(var0);
            allBaseAfterWakeUpPlayerSuperiors.remove(var0);
            allBaseAfterWakeUpPlayerInferiors.remove(var0);
            beforeWakeUpPlayerHookTypes.remove(var0);
            overrideWakeUpPlayerHookTypes.remove(var0);
            afterWakeUpPlayerHookTypes.remove(var0);
            allBaseBeforeWriteEntityToNBTSuperiors.remove(var0);
            allBaseBeforeWriteEntityToNBTInferiors.remove(var0);
            allBaseOverrideWriteEntityToNBTSuperiors.remove(var0);
            allBaseOverrideWriteEntityToNBTInferiors.remove(var0);
            allBaseAfterWriteEntityToNBTSuperiors.remove(var0);
            allBaseAfterWriteEntityToNBTInferiors.remove(var0);
            beforeWriteEntityToNBTHookTypes.remove(var0);
            overrideWriteEntityToNBTHookTypes.remove(var0);
            afterWriteEntityToNBTHookTypes.remove(var0);
            var2 = getAllInstancesList().iterator();

            while(var2.hasNext()) {
               var3 = (IServerPlayerAPI)var2.next();
               var3.getServerPlayerAPI().updateServerPlayerBases();
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
            log("ServerPlayerAPI: unregistered id \'" + var0 + "\'");
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
         boolean var6 = var5.getDeclaringClass() != ServerPlayerBase.class;
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

   public static ServerPlayerAPI create(IServerPlayerAPI var0) {
      if(allBaseConstructors.size() > 0 && !initialized) {
         initialize();
      }

      return new ServerPlayerAPI(var0);
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

      sortBases(beforeAddExhaustionHookTypes, allBaseBeforeAddExhaustionSuperiors, allBaseBeforeAddExhaustionInferiors, "beforeAddExhaustion");
      sortBases(overrideAddExhaustionHookTypes, allBaseOverrideAddExhaustionSuperiors, allBaseOverrideAddExhaustionInferiors, "overrideAddExhaustion");
      sortBases(afterAddExhaustionHookTypes, allBaseAfterAddExhaustionSuperiors, allBaseAfterAddExhaustionInferiors, "afterAddExhaustion");
      sortBases(beforeAddExperienceHookTypes, allBaseBeforeAddExperienceSuperiors, allBaseBeforeAddExperienceInferiors, "beforeAddExperience");
      sortBases(overrideAddExperienceHookTypes, allBaseOverrideAddExperienceSuperiors, allBaseOverrideAddExperienceInferiors, "overrideAddExperience");
      sortBases(afterAddExperienceHookTypes, allBaseAfterAddExperienceSuperiors, allBaseAfterAddExperienceInferiors, "afterAddExperience");
      sortBases(beforeAddExperienceLevelHookTypes, allBaseBeforeAddExperienceLevelSuperiors, allBaseBeforeAddExperienceLevelInferiors, "beforeAddExperienceLevel");
      sortBases(overrideAddExperienceLevelHookTypes, allBaseOverrideAddExperienceLevelSuperiors, allBaseOverrideAddExperienceLevelInferiors, "overrideAddExperienceLevel");
      sortBases(afterAddExperienceLevelHookTypes, allBaseAfterAddExperienceLevelSuperiors, allBaseAfterAddExperienceLevelInferiors, "afterAddExperienceLevel");
      sortBases(beforeAddMovementStatHookTypes, allBaseBeforeAddMovementStatSuperiors, allBaseBeforeAddMovementStatInferiors, "beforeAddMovementStat");
      sortBases(overrideAddMovementStatHookTypes, allBaseOverrideAddMovementStatSuperiors, allBaseOverrideAddMovementStatInferiors, "overrideAddMovementStat");
      sortBases(afterAddMovementStatHookTypes, allBaseAfterAddMovementStatSuperiors, allBaseAfterAddMovementStatInferiors, "afterAddMovementStat");
      sortBases(beforeAttackEntityFromHookTypes, allBaseBeforeAttackEntityFromSuperiors, allBaseBeforeAttackEntityFromInferiors, "beforeAttackEntityFrom");
      sortBases(overrideAttackEntityFromHookTypes, allBaseOverrideAttackEntityFromSuperiors, allBaseOverrideAttackEntityFromInferiors, "overrideAttackEntityFrom");
      sortBases(afterAttackEntityFromHookTypes, allBaseAfterAttackEntityFromSuperiors, allBaseAfterAttackEntityFromInferiors, "afterAttackEntityFrom");
      sortBases(beforeAttackTargetEntityWithCurrentItemHookTypes, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, "beforeAttackTargetEntityWithCurrentItem");
      sortBases(overrideAttackTargetEntityWithCurrentItemHookTypes, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, "overrideAttackTargetEntityWithCurrentItem");
      sortBases(afterAttackTargetEntityWithCurrentItemHookTypes, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, "afterAttackTargetEntityWithCurrentItem");
      sortBases(beforeCanBreatheUnderwaterHookTypes, allBaseBeforeCanBreatheUnderwaterSuperiors, allBaseBeforeCanBreatheUnderwaterInferiors, "beforeCanBreatheUnderwater");
      sortBases(overrideCanBreatheUnderwaterHookTypes, allBaseOverrideCanBreatheUnderwaterSuperiors, allBaseOverrideCanBreatheUnderwaterInferiors, "overrideCanBreatheUnderwater");
      sortBases(afterCanBreatheUnderwaterHookTypes, allBaseAfterCanBreatheUnderwaterSuperiors, allBaseAfterCanBreatheUnderwaterInferiors, "afterCanBreatheUnderwater");
      sortBases(beforeCanHarvestBlockHookTypes, allBaseBeforeCanHarvestBlockSuperiors, allBaseBeforeCanHarvestBlockInferiors, "beforeCanHarvestBlock");
      sortBases(overrideCanHarvestBlockHookTypes, allBaseOverrideCanHarvestBlockSuperiors, allBaseOverrideCanHarvestBlockInferiors, "overrideCanHarvestBlock");
      sortBases(afterCanHarvestBlockHookTypes, allBaseAfterCanHarvestBlockSuperiors, allBaseAfterCanHarvestBlockInferiors, "afterCanHarvestBlock");
      sortBases(beforeCanPlayerEditHookTypes, allBaseBeforeCanPlayerEditSuperiors, allBaseBeforeCanPlayerEditInferiors, "beforeCanPlayerEdit");
      sortBases(overrideCanPlayerEditHookTypes, allBaseOverrideCanPlayerEditSuperiors, allBaseOverrideCanPlayerEditInferiors, "overrideCanPlayerEdit");
      sortBases(afterCanPlayerEditHookTypes, allBaseAfterCanPlayerEditSuperiors, allBaseAfterCanPlayerEditInferiors, "afterCanPlayerEdit");
      sortBases(beforeCanTriggerWalkingHookTypes, allBaseBeforeCanTriggerWalkingSuperiors, allBaseBeforeCanTriggerWalkingInferiors, "beforeCanTriggerWalking");
      sortBases(overrideCanTriggerWalkingHookTypes, allBaseOverrideCanTriggerWalkingSuperiors, allBaseOverrideCanTriggerWalkingInferiors, "overrideCanTriggerWalking");
      sortBases(afterCanTriggerWalkingHookTypes, allBaseAfterCanTriggerWalkingSuperiors, allBaseAfterCanTriggerWalkingInferiors, "afterCanTriggerWalking");
      sortBases(beforeClonePlayerHookTypes, allBaseBeforeClonePlayerSuperiors, allBaseBeforeClonePlayerInferiors, "beforeClonePlayer");
      sortBases(overrideClonePlayerHookTypes, allBaseOverrideClonePlayerSuperiors, allBaseOverrideClonePlayerInferiors, "overrideClonePlayer");
      sortBases(afterClonePlayerHookTypes, allBaseAfterClonePlayerSuperiors, allBaseAfterClonePlayerInferiors, "afterClonePlayer");
      sortBases(beforeDamageEntityHookTypes, allBaseBeforeDamageEntitySuperiors, allBaseBeforeDamageEntityInferiors, "beforeDamageEntity");
      sortBases(overrideDamageEntityHookTypes, allBaseOverrideDamageEntitySuperiors, allBaseOverrideDamageEntityInferiors, "overrideDamageEntity");
      sortBases(afterDamageEntityHookTypes, allBaseAfterDamageEntitySuperiors, allBaseAfterDamageEntityInferiors, "afterDamageEntity");
      sortBases(beforeDisplayGUIChestHookTypes, allBaseBeforeDisplayGUIChestSuperiors, allBaseBeforeDisplayGUIChestInferiors, "beforeDisplayGUIChest");
      sortBases(overrideDisplayGUIChestHookTypes, allBaseOverrideDisplayGUIChestSuperiors, allBaseOverrideDisplayGUIChestInferiors, "overrideDisplayGUIChest");
      sortBases(afterDisplayGUIChestHookTypes, allBaseAfterDisplayGUIChestSuperiors, allBaseAfterDisplayGUIChestInferiors, "afterDisplayGUIChest");
      sortBases(beforeDisplayGUIDispenserHookTypes, allBaseBeforeDisplayGUIDispenserSuperiors, allBaseBeforeDisplayGUIDispenserInferiors, "beforeDisplayGUIDispenser");
      sortBases(overrideDisplayGUIDispenserHookTypes, allBaseOverrideDisplayGUIDispenserSuperiors, allBaseOverrideDisplayGUIDispenserInferiors, "overrideDisplayGUIDispenser");
      sortBases(afterDisplayGUIDispenserHookTypes, allBaseAfterDisplayGUIDispenserSuperiors, allBaseAfterDisplayGUIDispenserInferiors, "afterDisplayGUIDispenser");
      sortBases(beforeDisplayGUIFurnaceHookTypes, allBaseBeforeDisplayGUIFurnaceSuperiors, allBaseBeforeDisplayGUIFurnaceInferiors, "beforeDisplayGUIFurnace");
      sortBases(overrideDisplayGUIFurnaceHookTypes, allBaseOverrideDisplayGUIFurnaceSuperiors, allBaseOverrideDisplayGUIFurnaceInferiors, "overrideDisplayGUIFurnace");
      sortBases(afterDisplayGUIFurnaceHookTypes, allBaseAfterDisplayGUIFurnaceSuperiors, allBaseAfterDisplayGUIFurnaceInferiors, "afterDisplayGUIFurnace");
      sortBases(beforeDisplayGUIWorkbenchHookTypes, allBaseBeforeDisplayGUIWorkbenchSuperiors, allBaseBeforeDisplayGUIWorkbenchInferiors, "beforeDisplayGUIWorkbench");
      sortBases(overrideDisplayGUIWorkbenchHookTypes, allBaseOverrideDisplayGUIWorkbenchSuperiors, allBaseOverrideDisplayGUIWorkbenchInferiors, "overrideDisplayGUIWorkbench");
      sortBases(afterDisplayGUIWorkbenchHookTypes, allBaseAfterDisplayGUIWorkbenchSuperiors, allBaseAfterDisplayGUIWorkbenchInferiors, "afterDisplayGUIWorkbench");
      sortBases(beforeDropOneItemHookTypes, allBaseBeforeDropOneItemSuperiors, allBaseBeforeDropOneItemInferiors, "beforeDropOneItem");
      sortBases(overrideDropOneItemHookTypes, allBaseOverrideDropOneItemSuperiors, allBaseOverrideDropOneItemInferiors, "overrideDropOneItem");
      sortBases(afterDropOneItemHookTypes, allBaseAfterDropOneItemSuperiors, allBaseAfterDropOneItemInferiors, "afterDropOneItem");
      sortBases(beforeDropPlayerItemHookTypes, allBaseBeforeDropPlayerItemSuperiors, allBaseBeforeDropPlayerItemInferiors, "beforeDropPlayerItem");
      sortBases(overrideDropPlayerItemHookTypes, allBaseOverrideDropPlayerItemSuperiors, allBaseOverrideDropPlayerItemInferiors, "overrideDropPlayerItem");
      sortBases(afterDropPlayerItemHookTypes, allBaseAfterDropPlayerItemSuperiors, allBaseAfterDropPlayerItemInferiors, "afterDropPlayerItem");
      sortBases(beforeFallHookTypes, allBaseBeforeFallSuperiors, allBaseBeforeFallInferiors, "beforeFall");
      sortBases(overrideFallHookTypes, allBaseOverrideFallSuperiors, allBaseOverrideFallInferiors, "overrideFall");
      sortBases(afterFallHookTypes, allBaseAfterFallSuperiors, allBaseAfterFallInferiors, "afterFall");
      sortBases(beforeGetAIMoveSpeedHookTypes, allBaseBeforeGetAIMoveSpeedSuperiors, allBaseBeforeGetAIMoveSpeedInferiors, "beforeGetAIMoveSpeed");
      sortBases(overrideGetAIMoveSpeedHookTypes, allBaseOverrideGetAIMoveSpeedSuperiors, allBaseOverrideGetAIMoveSpeedInferiors, "overrideGetAIMoveSpeed");
      sortBases(afterGetAIMoveSpeedHookTypes, allBaseAfterGetAIMoveSpeedSuperiors, allBaseAfterGetAIMoveSpeedInferiors, "afterGetAIMoveSpeed");
      sortBases(beforeGetCurrentPlayerStrVsBlockHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, "beforeGetCurrentPlayerStrVsBlock");
      sortBases(overrideGetCurrentPlayerStrVsBlockHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, "overrideGetCurrentPlayerStrVsBlock");
      sortBases(afterGetCurrentPlayerStrVsBlockHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, "afterGetCurrentPlayerStrVsBlock");
      sortBases(beforeGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, "beforeGetCurrentPlayerStrVsBlockForge");
      sortBases(overrideGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, "overrideGetCurrentPlayerStrVsBlockForge");
      sortBases(afterGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, "afterGetCurrentPlayerStrVsBlockForge");
      sortBases(beforeGetDistanceSqHookTypes, allBaseBeforeGetDistanceSqSuperiors, allBaseBeforeGetDistanceSqInferiors, "beforeGetDistanceSq");
      sortBases(overrideGetDistanceSqHookTypes, allBaseOverrideGetDistanceSqSuperiors, allBaseOverrideGetDistanceSqInferiors, "overrideGetDistanceSq");
      sortBases(afterGetDistanceSqHookTypes, allBaseAfterGetDistanceSqSuperiors, allBaseAfterGetDistanceSqInferiors, "afterGetDistanceSq");
      sortBases(beforeGetBrightnessHookTypes, allBaseBeforeGetBrightnessSuperiors, allBaseBeforeGetBrightnessInferiors, "beforeGetBrightness");
      sortBases(overrideGetBrightnessHookTypes, allBaseOverrideGetBrightnessSuperiors, allBaseOverrideGetBrightnessInferiors, "overrideGetBrightness");
      sortBases(afterGetBrightnessHookTypes, allBaseAfterGetBrightnessSuperiors, allBaseAfterGetBrightnessInferiors, "afterGetBrightness");
      sortBases(beforeGetEyeHeightHookTypes, allBaseBeforeGetEyeHeightSuperiors, allBaseBeforeGetEyeHeightInferiors, "beforeGetEyeHeight");
      sortBases(overrideGetEyeHeightHookTypes, allBaseOverrideGetEyeHeightSuperiors, allBaseOverrideGetEyeHeightInferiors, "overrideGetEyeHeight");
      sortBases(afterGetEyeHeightHookTypes, allBaseAfterGetEyeHeightSuperiors, allBaseAfterGetEyeHeightInferiors, "afterGetEyeHeight");
      sortBases(beforeHealHookTypes, allBaseBeforeHealSuperiors, allBaseBeforeHealInferiors, "beforeHeal");
      sortBases(overrideHealHookTypes, allBaseOverrideHealSuperiors, allBaseOverrideHealInferiors, "overrideHeal");
      sortBases(afterHealHookTypes, allBaseAfterHealSuperiors, allBaseAfterHealInferiors, "afterHeal");
      sortBases(beforeIsEntityInsideOpaqueBlockHookTypes, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, "beforeIsEntityInsideOpaqueBlock");
      sortBases(overrideIsEntityInsideOpaqueBlockHookTypes, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, "overrideIsEntityInsideOpaqueBlock");
      sortBases(afterIsEntityInsideOpaqueBlockHookTypes, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, allBaseAfterIsEntityInsideOpaqueBlockInferiors, "afterIsEntityInsideOpaqueBlock");
      sortBases(beforeIsInWaterHookTypes, allBaseBeforeIsInWaterSuperiors, allBaseBeforeIsInWaterInferiors, "beforeIsInWater");
      sortBases(overrideIsInWaterHookTypes, allBaseOverrideIsInWaterSuperiors, allBaseOverrideIsInWaterInferiors, "overrideIsInWater");
      sortBases(afterIsInWaterHookTypes, allBaseAfterIsInWaterSuperiors, allBaseAfterIsInWaterInferiors, "afterIsInWater");
      sortBases(beforeIsInsideOfMaterialHookTypes, allBaseBeforeIsInsideOfMaterialSuperiors, allBaseBeforeIsInsideOfMaterialInferiors, "beforeIsInsideOfMaterial");
      sortBases(overrideIsInsideOfMaterialHookTypes, allBaseOverrideIsInsideOfMaterialSuperiors, allBaseOverrideIsInsideOfMaterialInferiors, "overrideIsInsideOfMaterial");
      sortBases(afterIsInsideOfMaterialHookTypes, allBaseAfterIsInsideOfMaterialSuperiors, allBaseAfterIsInsideOfMaterialInferiors, "afterIsInsideOfMaterial");
      sortBases(beforeIsOnLadderHookTypes, allBaseBeforeIsOnLadderSuperiors, allBaseBeforeIsOnLadderInferiors, "beforeIsOnLadder");
      sortBases(overrideIsOnLadderHookTypes, allBaseOverrideIsOnLadderSuperiors, allBaseOverrideIsOnLadderInferiors, "overrideIsOnLadder");
      sortBases(afterIsOnLadderHookTypes, allBaseAfterIsOnLadderSuperiors, allBaseAfterIsOnLadderInferiors, "afterIsOnLadder");
      sortBases(beforeIsPlayerSleepingHookTypes, allBaseBeforeIsPlayerSleepingSuperiors, allBaseBeforeIsPlayerSleepingInferiors, "beforeIsPlayerSleeping");
      sortBases(overrideIsPlayerSleepingHookTypes, allBaseOverrideIsPlayerSleepingSuperiors, allBaseOverrideIsPlayerSleepingInferiors, "overrideIsPlayerSleeping");
      sortBases(afterIsPlayerSleepingHookTypes, allBaseAfterIsPlayerSleepingSuperiors, allBaseAfterIsPlayerSleepingInferiors, "afterIsPlayerSleeping");
      sortBases(beforeIsSneakingHookTypes, allBaseBeforeIsSneakingSuperiors, allBaseBeforeIsSneakingInferiors, "beforeIsSneaking");
      sortBases(overrideIsSneakingHookTypes, allBaseOverrideIsSneakingSuperiors, allBaseOverrideIsSneakingInferiors, "overrideIsSneaking");
      sortBases(afterIsSneakingHookTypes, allBaseAfterIsSneakingSuperiors, allBaseAfterIsSneakingInferiors, "afterIsSneaking");
      sortBases(beforeJumpHookTypes, allBaseBeforeJumpSuperiors, allBaseBeforeJumpInferiors, "beforeJump");
      sortBases(overrideJumpHookTypes, allBaseOverrideJumpSuperiors, allBaseOverrideJumpInferiors, "overrideJump");
      sortBases(afterJumpHookTypes, allBaseAfterJumpSuperiors, allBaseAfterJumpInferiors, "afterJump");
      sortBases(beforeKnockBackHookTypes, allBaseBeforeKnockBackSuperiors, allBaseBeforeKnockBackInferiors, "beforeKnockBack");
      sortBases(overrideKnockBackHookTypes, allBaseOverrideKnockBackSuperiors, allBaseOverrideKnockBackInferiors, "overrideKnockBack");
      sortBases(afterKnockBackHookTypes, allBaseAfterKnockBackSuperiors, allBaseAfterKnockBackInferiors, "afterKnockBack");
      sortBases(beforeMountEntityHookTypes, allBaseBeforeMountEntitySuperiors, allBaseBeforeMountEntityInferiors, "beforeMountEntity");
      sortBases(overrideMountEntityHookTypes, allBaseOverrideMountEntitySuperiors, allBaseOverrideMountEntityInferiors, "overrideMountEntity");
      sortBases(afterMountEntityHookTypes, allBaseAfterMountEntitySuperiors, allBaseAfterMountEntityInferiors, "afterMountEntity");
      sortBases(beforeMoveEntityHookTypes, allBaseBeforeMoveEntitySuperiors, allBaseBeforeMoveEntityInferiors, "beforeMoveEntity");
      sortBases(overrideMoveEntityHookTypes, allBaseOverrideMoveEntitySuperiors, allBaseOverrideMoveEntityInferiors, "overrideMoveEntity");
      sortBases(afterMoveEntityHookTypes, allBaseAfterMoveEntitySuperiors, allBaseAfterMoveEntityInferiors, "afterMoveEntity");
      sortBases(beforeMoveEntityWithHeadingHookTypes, allBaseBeforeMoveEntityWithHeadingSuperiors, allBaseBeforeMoveEntityWithHeadingInferiors, "beforeMoveEntityWithHeading");
      sortBases(overrideMoveEntityWithHeadingHookTypes, allBaseOverrideMoveEntityWithHeadingSuperiors, allBaseOverrideMoveEntityWithHeadingInferiors, "overrideMoveEntityWithHeading");
      sortBases(afterMoveEntityWithHeadingHookTypes, allBaseAfterMoveEntityWithHeadingSuperiors, allBaseAfterMoveEntityWithHeadingInferiors, "afterMoveEntityWithHeading");
      sortBases(beforeMoveFlyingHookTypes, allBaseBeforeMoveFlyingSuperiors, allBaseBeforeMoveFlyingInferiors, "beforeMoveFlying");
      sortBases(overrideMoveFlyingHookTypes, allBaseOverrideMoveFlyingSuperiors, allBaseOverrideMoveFlyingInferiors, "overrideMoveFlying");
      sortBases(afterMoveFlyingHookTypes, allBaseAfterMoveFlyingSuperiors, allBaseAfterMoveFlyingInferiors, "afterMoveFlying");
      sortBases(beforeOnDeathHookTypes, allBaseBeforeOnDeathSuperiors, allBaseBeforeOnDeathInferiors, "beforeOnDeath");
      sortBases(overrideOnDeathHookTypes, allBaseOverrideOnDeathSuperiors, allBaseOverrideOnDeathInferiors, "overrideOnDeath");
      sortBases(afterOnDeathHookTypes, allBaseAfterOnDeathSuperiors, allBaseAfterOnDeathInferiors, "afterOnDeath");
      sortBases(beforeOnLivingUpdateHookTypes, allBaseBeforeOnLivingUpdateSuperiors, allBaseBeforeOnLivingUpdateInferiors, "beforeOnLivingUpdate");
      sortBases(overrideOnLivingUpdateHookTypes, allBaseOverrideOnLivingUpdateSuperiors, allBaseOverrideOnLivingUpdateInferiors, "overrideOnLivingUpdate");
      sortBases(afterOnLivingUpdateHookTypes, allBaseAfterOnLivingUpdateSuperiors, allBaseAfterOnLivingUpdateInferiors, "afterOnLivingUpdate");
      sortBases(beforeOnKillEntityHookTypes, allBaseBeforeOnKillEntitySuperiors, allBaseBeforeOnKillEntityInferiors, "beforeOnKillEntity");
      sortBases(overrideOnKillEntityHookTypes, allBaseOverrideOnKillEntitySuperiors, allBaseOverrideOnKillEntityInferiors, "overrideOnKillEntity");
      sortBases(afterOnKillEntityHookTypes, allBaseAfterOnKillEntitySuperiors, allBaseAfterOnKillEntityInferiors, "afterOnKillEntity");
      sortBases(beforeOnStruckByLightningHookTypes, allBaseBeforeOnStruckByLightningSuperiors, allBaseBeforeOnStruckByLightningInferiors, "beforeOnStruckByLightning");
      sortBases(overrideOnStruckByLightningHookTypes, allBaseOverrideOnStruckByLightningSuperiors, allBaseOverrideOnStruckByLightningInferiors, "overrideOnStruckByLightning");
      sortBases(afterOnStruckByLightningHookTypes, allBaseAfterOnStruckByLightningSuperiors, allBaseAfterOnStruckByLightningInferiors, "afterOnStruckByLightning");
      sortBases(beforeOnUpdateHookTypes, allBaseBeforeOnUpdateSuperiors, allBaseBeforeOnUpdateInferiors, "beforeOnUpdate");
      sortBases(overrideOnUpdateHookTypes, allBaseOverrideOnUpdateSuperiors, allBaseOverrideOnUpdateInferiors, "overrideOnUpdate");
      sortBases(afterOnUpdateHookTypes, allBaseAfterOnUpdateSuperiors, allBaseAfterOnUpdateInferiors, "afterOnUpdate");
      sortBases(beforeOnUpdateEntityHookTypes, allBaseBeforeOnUpdateEntitySuperiors, allBaseBeforeOnUpdateEntityInferiors, "beforeOnUpdateEntity");
      sortBases(overrideOnUpdateEntityHookTypes, allBaseOverrideOnUpdateEntitySuperiors, allBaseOverrideOnUpdateEntityInferiors, "overrideOnUpdateEntity");
      sortBases(afterOnUpdateEntityHookTypes, allBaseAfterOnUpdateEntitySuperiors, allBaseAfterOnUpdateEntityInferiors, "afterOnUpdateEntity");
      sortBases(beforeReadEntityFromNBTHookTypes, allBaseBeforeReadEntityFromNBTSuperiors, allBaseBeforeReadEntityFromNBTInferiors, "beforeReadEntityFromNBT");
      sortBases(overrideReadEntityFromNBTHookTypes, allBaseOverrideReadEntityFromNBTSuperiors, allBaseOverrideReadEntityFromNBTInferiors, "overrideReadEntityFromNBT");
      sortBases(afterReadEntityFromNBTHookTypes, allBaseAfterReadEntityFromNBTSuperiors, allBaseAfterReadEntityFromNBTInferiors, "afterReadEntityFromNBT");
      sortBases(beforeSetDeadHookTypes, allBaseBeforeSetDeadSuperiors, allBaseBeforeSetDeadInferiors, "beforeSetDead");
      sortBases(overrideSetDeadHookTypes, allBaseOverrideSetDeadSuperiors, allBaseOverrideSetDeadInferiors, "overrideSetDead");
      sortBases(afterSetDeadHookTypes, allBaseAfterSetDeadSuperiors, allBaseAfterSetDeadInferiors, "afterSetDead");
      sortBases(beforeSetEntityActionStateHookTypes, allBaseBeforeSetEntityActionStateSuperiors, allBaseBeforeSetEntityActionStateInferiors, "beforeSetEntityActionState");
      sortBases(overrideSetEntityActionStateHookTypes, allBaseOverrideSetEntityActionStateSuperiors, allBaseOverrideSetEntityActionStateInferiors, "overrideSetEntityActionState");
      sortBases(afterSetEntityActionStateHookTypes, allBaseAfterSetEntityActionStateSuperiors, allBaseAfterSetEntityActionStateInferiors, "afterSetEntityActionState");
      sortBases(beforeSetPositionHookTypes, allBaseBeforeSetPositionSuperiors, allBaseBeforeSetPositionInferiors, "beforeSetPosition");
      sortBases(overrideSetPositionHookTypes, allBaseOverrideSetPositionSuperiors, allBaseOverrideSetPositionInferiors, "overrideSetPosition");
      sortBases(afterSetPositionHookTypes, allBaseAfterSetPositionSuperiors, allBaseAfterSetPositionInferiors, "afterSetPosition");
      sortBases(beforeSetSneakingHookTypes, allBaseBeforeSetSneakingSuperiors, allBaseBeforeSetSneakingInferiors, "beforeSetSneaking");
      sortBases(overrideSetSneakingHookTypes, allBaseOverrideSetSneakingSuperiors, allBaseOverrideSetSneakingInferiors, "overrideSetSneaking");
      sortBases(afterSetSneakingHookTypes, allBaseAfterSetSneakingSuperiors, allBaseAfterSetSneakingInferiors, "afterSetSneaking");
      sortBases(beforeSetSprintingHookTypes, allBaseBeforeSetSprintingSuperiors, allBaseBeforeSetSprintingInferiors, "beforeSetSprinting");
      sortBases(overrideSetSprintingHookTypes, allBaseOverrideSetSprintingSuperiors, allBaseOverrideSetSprintingInferiors, "overrideSetSprinting");
      sortBases(afterSetSprintingHookTypes, allBaseAfterSetSprintingSuperiors, allBaseAfterSetSprintingInferiors, "afterSetSprinting");
      sortBases(beforeSwingItemHookTypes, allBaseBeforeSwingItemSuperiors, allBaseBeforeSwingItemInferiors, "beforeSwingItem");
      sortBases(overrideSwingItemHookTypes, allBaseOverrideSwingItemSuperiors, allBaseOverrideSwingItemInferiors, "overrideSwingItem");
      sortBases(afterSwingItemHookTypes, allBaseAfterSwingItemSuperiors, allBaseAfterSwingItemInferiors, "afterSwingItem");
      sortBases(beforeUpdateEntityActionStateHookTypes, allBaseBeforeUpdateEntityActionStateSuperiors, allBaseBeforeUpdateEntityActionStateInferiors, "beforeUpdateEntityActionState");
      sortBases(overrideUpdateEntityActionStateHookTypes, allBaseOverrideUpdateEntityActionStateSuperiors, allBaseOverrideUpdateEntityActionStateInferiors, "overrideUpdateEntityActionState");
      sortBases(afterUpdateEntityActionStateHookTypes, allBaseAfterUpdateEntityActionStateSuperiors, allBaseAfterUpdateEntityActionStateInferiors, "afterUpdateEntityActionState");
      sortBases(beforeUpdatePotionEffectsHookTypes, allBaseBeforeUpdatePotionEffectsSuperiors, allBaseBeforeUpdatePotionEffectsInferiors, "beforeUpdatePotionEffects");
      sortBases(overrideUpdatePotionEffectsHookTypes, allBaseOverrideUpdatePotionEffectsSuperiors, allBaseOverrideUpdatePotionEffectsInferiors, "overrideUpdatePotionEffects");
      sortBases(afterUpdatePotionEffectsHookTypes, allBaseAfterUpdatePotionEffectsSuperiors, allBaseAfterUpdatePotionEffectsInferiors, "afterUpdatePotionEffects");
      sortBases(beforeUpdateRiddenHookTypes, allBaseBeforeUpdateRiddenSuperiors, allBaseBeforeUpdateRiddenInferiors, "beforeUpdateRidden");
      sortBases(overrideUpdateRiddenHookTypes, allBaseOverrideUpdateRiddenSuperiors, allBaseOverrideUpdateRiddenInferiors, "overrideUpdateRidden");
      sortBases(afterUpdateRiddenHookTypes, allBaseAfterUpdateRiddenSuperiors, allBaseAfterUpdateRiddenInferiors, "afterUpdateRidden");
      sortBases(beforeWakeUpPlayerHookTypes, allBaseBeforeWakeUpPlayerSuperiors, allBaseBeforeWakeUpPlayerInferiors, "beforeWakeUpPlayer");
      sortBases(overrideWakeUpPlayerHookTypes, allBaseOverrideWakeUpPlayerSuperiors, allBaseOverrideWakeUpPlayerInferiors, "overrideWakeUpPlayer");
      sortBases(afterWakeUpPlayerHookTypes, allBaseAfterWakeUpPlayerSuperiors, allBaseAfterWakeUpPlayerInferiors, "afterWakeUpPlayer");
      sortBases(beforeWriteEntityToNBTHookTypes, allBaseBeforeWriteEntityToNBTSuperiors, allBaseBeforeWriteEntityToNBTInferiors, "beforeWriteEntityToNBT");
      sortBases(overrideWriteEntityToNBTHookTypes, allBaseOverrideWriteEntityToNBTSuperiors, allBaseOverrideWriteEntityToNBTInferiors, "overrideWriteEntityToNBT");
      sortBases(afterWriteEntityToNBTHookTypes, allBaseAfterWriteEntityToNBTSuperiors, allBaseAfterWriteEntityToNBTInferiors, "afterWriteEntityToNBT");
      initialized = true;
   }

   private static List getAllInstancesList() {
      ArrayList var0 = new ArrayList();

      Object var1;
      Object var3;
      try {
         Object var2 = MinecraftServer.class.getMethod("func_71276_C", new Class[0]).invoke((Object)null, new Object[0]);
         var3 = var2 != null?MinecraftServer.class.getMethod("func_71203_ab", new Class[0]).invoke(var2, new Object[0]):null;
         var1 = var3 != null?var3.getClass().getField("field_72404_b").get(var3):null;
      } catch (Exception var6) {
         try {
            var3 = MinecraftServer.class.getMethod("getServer", new Class[0]).invoke((Object)null, new Object[0]);
            Object var4 = var3 != null?MinecraftServer.class.getMethod("getConfigurationManager", new Class[0]).invoke(var3, new Object[0]):null;
            var1 = var4 != null?var4.getClass().getField("playerEntityList").get(var4):null;
         } catch (Exception var5) {
            throw new RuntimeException("Unable to aquire list of current server players.", var6);
         }
      }

      if(var1 != null) {
         Iterator var7 = ((List)var1).iterator();

         while(var7.hasNext()) {
            var3 = var7.next();
            var0.add((IServerPlayerAPI)var3);
         }
      }

      return var0;
   }

   public static EntityPlayerMP[] getAllInstances() {
      List var0 = getAllInstancesList();
      return (EntityPlayerMP[])var0.toArray(new EntityPlayerMP[var0.size()]);
   }

   public static void beforeLocalConstructing(IServerPlayerAPI var0, MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
      ServerPlayerAPI var5 = var0.getServerPlayerAPI();
      if(var5 != null) {
         var5.load();
      }

      if(var5 != null) {
         var5.beforeLocalConstructing(var1, var2, var3, var4);
      }

   }

   public static void afterLocalConstructing(IServerPlayerAPI var0, MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
      ServerPlayerAPI var5 = var0.getServerPlayerAPI();
      if(var5 != null) {
         var5.afterLocalConstructing(var1, var2, var3, var4);
      }

   }

   public static ServerPlayerBase getServerPlayerBase(IServerPlayerAPI var0, String var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      return var2 != null?var2.getServerPlayerBase(var1):null;
   }

   public static Set getServerPlayerBaseIds(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      Set var2 = null;
      if(var1 != null) {
         var2 = var1.getServerPlayerBaseIds();
      } else {
         var2 = Collections.emptySet();
      }

      return var2;
   }

   public static Object dynamic(IServerPlayerAPI var0, String var1, Object[] var2) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      return var3 != null?var3.dynamic(var1, var2):null;
   }

   private static void sortBases(List var0, Map var1, Map var2, String var3) {
      (new ServerPlayerBaseSorter(var0, var1, var2, var3)).Sort();
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

   private ServerPlayerAPI(IServerPlayerAPI var1) {
      this.unmodifiableAllBaseIds = Collections.unmodifiableSet(this.allBaseObjects.keySet());
      this.player = var1;
   }

   private void load() {
      Iterator var1 = allBaseConstructors.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         ServerPlayerBase var3 = this.createServerPlayerBase(var2);
         var3.beforeBaseAttach(false);
         this.allBaseObjects.put(var2, var3);
         this.baseObjectsToId.put(var3, var2);
      }

      this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
      this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
      this.updateServerPlayerBases();
      var1 = this.allBaseObjects.keySet().iterator();

      while(var1.hasNext()) {
         ((ServerPlayerBase)this.allBaseObjects.get(var1.next())).afterBaseAttach(false);
      }

   }

   private ServerPlayerBase createServerPlayerBase(String var1) {
      Constructor var2 = (Constructor)allBaseConstructors.get(var1);

      try {
         ServerPlayerBase var3;
         if(var2.getParameterTypes().length == 1) {
            var3 = (ServerPlayerBase)var2.newInstance(new Object[]{this});
         } else {
            var3 = (ServerPlayerBase)var2.newInstance(new Object[]{this, var1});
         }

         return var3;
      } catch (Exception var5) {
         throw new RuntimeException("Exception while creating a ServerPlayerBase of type \'" + var2.getDeclaringClass() + "\'", var5);
      }
   }

   private void updateServerPlayerBases() {
      this.beforeAddExhaustionHooks = this.create(beforeAddExhaustionHookTypes);
      this.overrideAddExhaustionHooks = this.create(overrideAddExhaustionHookTypes);
      this.afterAddExhaustionHooks = this.create(afterAddExhaustionHookTypes);
      this.isAddExhaustionModded = this.beforeAddExhaustionHooks != null || this.overrideAddExhaustionHooks != null || this.afterAddExhaustionHooks != null;
      this.beforeAddExperienceHooks = this.create(beforeAddExperienceHookTypes);
      this.overrideAddExperienceHooks = this.create(overrideAddExperienceHookTypes);
      this.afterAddExperienceHooks = this.create(afterAddExperienceHookTypes);
      this.isAddExperienceModded = this.beforeAddExperienceHooks != null || this.overrideAddExperienceHooks != null || this.afterAddExperienceHooks != null;
      this.beforeAddExperienceLevelHooks = this.create(beforeAddExperienceLevelHookTypes);
      this.overrideAddExperienceLevelHooks = this.create(overrideAddExperienceLevelHookTypes);
      this.afterAddExperienceLevelHooks = this.create(afterAddExperienceLevelHookTypes);
      this.isAddExperienceLevelModded = this.beforeAddExperienceLevelHooks != null || this.overrideAddExperienceLevelHooks != null || this.afterAddExperienceLevelHooks != null;
      this.beforeAddMovementStatHooks = this.create(beforeAddMovementStatHookTypes);
      this.overrideAddMovementStatHooks = this.create(overrideAddMovementStatHookTypes);
      this.afterAddMovementStatHooks = this.create(afterAddMovementStatHookTypes);
      this.isAddMovementStatModded = this.beforeAddMovementStatHooks != null || this.overrideAddMovementStatHooks != null || this.afterAddMovementStatHooks != null;
      this.beforeAttackEntityFromHooks = this.create(beforeAttackEntityFromHookTypes);
      this.overrideAttackEntityFromHooks = this.create(overrideAttackEntityFromHookTypes);
      this.afterAttackEntityFromHooks = this.create(afterAttackEntityFromHookTypes);
      this.isAttackEntityFromModded = this.beforeAttackEntityFromHooks != null || this.overrideAttackEntityFromHooks != null || this.afterAttackEntityFromHooks != null;
      this.beforeAttackTargetEntityWithCurrentItemHooks = this.create(beforeAttackTargetEntityWithCurrentItemHookTypes);
      this.overrideAttackTargetEntityWithCurrentItemHooks = this.create(overrideAttackTargetEntityWithCurrentItemHookTypes);
      this.afterAttackTargetEntityWithCurrentItemHooks = this.create(afterAttackTargetEntityWithCurrentItemHookTypes);
      this.isAttackTargetEntityWithCurrentItemModded = this.beforeAttackTargetEntityWithCurrentItemHooks != null || this.overrideAttackTargetEntityWithCurrentItemHooks != null || this.afterAttackTargetEntityWithCurrentItemHooks != null;
      this.beforeCanBreatheUnderwaterHooks = this.create(beforeCanBreatheUnderwaterHookTypes);
      this.overrideCanBreatheUnderwaterHooks = this.create(overrideCanBreatheUnderwaterHookTypes);
      this.afterCanBreatheUnderwaterHooks = this.create(afterCanBreatheUnderwaterHookTypes);
      this.isCanBreatheUnderwaterModded = this.beforeCanBreatheUnderwaterHooks != null || this.overrideCanBreatheUnderwaterHooks != null || this.afterCanBreatheUnderwaterHooks != null;
      this.beforeCanHarvestBlockHooks = this.create(beforeCanHarvestBlockHookTypes);
      this.overrideCanHarvestBlockHooks = this.create(overrideCanHarvestBlockHookTypes);
      this.afterCanHarvestBlockHooks = this.create(afterCanHarvestBlockHookTypes);
      this.isCanHarvestBlockModded = this.beforeCanHarvestBlockHooks != null || this.overrideCanHarvestBlockHooks != null || this.afterCanHarvestBlockHooks != null;
      this.beforeCanPlayerEditHooks = this.create(beforeCanPlayerEditHookTypes);
      this.overrideCanPlayerEditHooks = this.create(overrideCanPlayerEditHookTypes);
      this.afterCanPlayerEditHooks = this.create(afterCanPlayerEditHookTypes);
      this.isCanPlayerEditModded = this.beforeCanPlayerEditHooks != null || this.overrideCanPlayerEditHooks != null || this.afterCanPlayerEditHooks != null;
      this.beforeCanTriggerWalkingHooks = this.create(beforeCanTriggerWalkingHookTypes);
      this.overrideCanTriggerWalkingHooks = this.create(overrideCanTriggerWalkingHookTypes);
      this.afterCanTriggerWalkingHooks = this.create(afterCanTriggerWalkingHookTypes);
      this.isCanTriggerWalkingModded = this.beforeCanTriggerWalkingHooks != null || this.overrideCanTriggerWalkingHooks != null || this.afterCanTriggerWalkingHooks != null;
      this.beforeClonePlayerHooks = this.create(beforeClonePlayerHookTypes);
      this.overrideClonePlayerHooks = this.create(overrideClonePlayerHookTypes);
      this.afterClonePlayerHooks = this.create(afterClonePlayerHookTypes);
      this.isClonePlayerModded = this.beforeClonePlayerHooks != null || this.overrideClonePlayerHooks != null || this.afterClonePlayerHooks != null;
      this.beforeDamageEntityHooks = this.create(beforeDamageEntityHookTypes);
      this.overrideDamageEntityHooks = this.create(overrideDamageEntityHookTypes);
      this.afterDamageEntityHooks = this.create(afterDamageEntityHookTypes);
      this.isDamageEntityModded = this.beforeDamageEntityHooks != null || this.overrideDamageEntityHooks != null || this.afterDamageEntityHooks != null;
      this.beforeDisplayGUIChestHooks = this.create(beforeDisplayGUIChestHookTypes);
      this.overrideDisplayGUIChestHooks = this.create(overrideDisplayGUIChestHookTypes);
      this.afterDisplayGUIChestHooks = this.create(afterDisplayGUIChestHookTypes);
      this.isDisplayGUIChestModded = this.beforeDisplayGUIChestHooks != null || this.overrideDisplayGUIChestHooks != null || this.afterDisplayGUIChestHooks != null;
      this.beforeDisplayGUIDispenserHooks = this.create(beforeDisplayGUIDispenserHookTypes);
      this.overrideDisplayGUIDispenserHooks = this.create(overrideDisplayGUIDispenserHookTypes);
      this.afterDisplayGUIDispenserHooks = this.create(afterDisplayGUIDispenserHookTypes);
      this.isDisplayGUIDispenserModded = this.beforeDisplayGUIDispenserHooks != null || this.overrideDisplayGUIDispenserHooks != null || this.afterDisplayGUIDispenserHooks != null;
      this.beforeDisplayGUIFurnaceHooks = this.create(beforeDisplayGUIFurnaceHookTypes);
      this.overrideDisplayGUIFurnaceHooks = this.create(overrideDisplayGUIFurnaceHookTypes);
      this.afterDisplayGUIFurnaceHooks = this.create(afterDisplayGUIFurnaceHookTypes);
      this.isDisplayGUIFurnaceModded = this.beforeDisplayGUIFurnaceHooks != null || this.overrideDisplayGUIFurnaceHooks != null || this.afterDisplayGUIFurnaceHooks != null;
      this.beforeDisplayGUIWorkbenchHooks = this.create(beforeDisplayGUIWorkbenchHookTypes);
      this.overrideDisplayGUIWorkbenchHooks = this.create(overrideDisplayGUIWorkbenchHookTypes);
      this.afterDisplayGUIWorkbenchHooks = this.create(afterDisplayGUIWorkbenchHookTypes);
      this.isDisplayGUIWorkbenchModded = this.beforeDisplayGUIWorkbenchHooks != null || this.overrideDisplayGUIWorkbenchHooks != null || this.afterDisplayGUIWorkbenchHooks != null;
      this.beforeDropOneItemHooks = this.create(beforeDropOneItemHookTypes);
      this.overrideDropOneItemHooks = this.create(overrideDropOneItemHookTypes);
      this.afterDropOneItemHooks = this.create(afterDropOneItemHookTypes);
      this.isDropOneItemModded = this.beforeDropOneItemHooks != null || this.overrideDropOneItemHooks != null || this.afterDropOneItemHooks != null;
      this.beforeDropPlayerItemHooks = this.create(beforeDropPlayerItemHookTypes);
      this.overrideDropPlayerItemHooks = this.create(overrideDropPlayerItemHookTypes);
      this.afterDropPlayerItemHooks = this.create(afterDropPlayerItemHookTypes);
      this.isDropPlayerItemModded = this.beforeDropPlayerItemHooks != null || this.overrideDropPlayerItemHooks != null || this.afterDropPlayerItemHooks != null;
      this.beforeFallHooks = this.create(beforeFallHookTypes);
      this.overrideFallHooks = this.create(overrideFallHookTypes);
      this.afterFallHooks = this.create(afterFallHookTypes);
      this.isFallModded = this.beforeFallHooks != null || this.overrideFallHooks != null || this.afterFallHooks != null;
      this.beforeGetAIMoveSpeedHooks = this.create(beforeGetAIMoveSpeedHookTypes);
      this.overrideGetAIMoveSpeedHooks = this.create(overrideGetAIMoveSpeedHookTypes);
      this.afterGetAIMoveSpeedHooks = this.create(afterGetAIMoveSpeedHookTypes);
      this.isGetAIMoveSpeedModded = this.beforeGetAIMoveSpeedHooks != null || this.overrideGetAIMoveSpeedHooks != null || this.afterGetAIMoveSpeedHooks != null;
      this.beforeGetCurrentPlayerStrVsBlockHooks = this.create(beforeGetCurrentPlayerStrVsBlockHookTypes);
      this.overrideGetCurrentPlayerStrVsBlockHooks = this.create(overrideGetCurrentPlayerStrVsBlockHookTypes);
      this.afterGetCurrentPlayerStrVsBlockHooks = this.create(afterGetCurrentPlayerStrVsBlockHookTypes);
      this.isGetCurrentPlayerStrVsBlockModded = this.beforeGetCurrentPlayerStrVsBlockHooks != null || this.overrideGetCurrentPlayerStrVsBlockHooks != null || this.afterGetCurrentPlayerStrVsBlockHooks != null;
      this.beforeGetCurrentPlayerStrVsBlockForgeHooks = this.create(beforeGetCurrentPlayerStrVsBlockForgeHookTypes);
      this.overrideGetCurrentPlayerStrVsBlockForgeHooks = this.create(overrideGetCurrentPlayerStrVsBlockForgeHookTypes);
      this.afterGetCurrentPlayerStrVsBlockForgeHooks = this.create(afterGetCurrentPlayerStrVsBlockForgeHookTypes);
      this.isGetCurrentPlayerStrVsBlockForgeModded = this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null || this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null || this.afterGetCurrentPlayerStrVsBlockForgeHooks != null;
      this.beforeGetDistanceSqHooks = this.create(beforeGetDistanceSqHookTypes);
      this.overrideGetDistanceSqHooks = this.create(overrideGetDistanceSqHookTypes);
      this.afterGetDistanceSqHooks = this.create(afterGetDistanceSqHookTypes);
      this.isGetDistanceSqModded = this.beforeGetDistanceSqHooks != null || this.overrideGetDistanceSqHooks != null || this.afterGetDistanceSqHooks != null;
      this.beforeGetBrightnessHooks = this.create(beforeGetBrightnessHookTypes);
      this.overrideGetBrightnessHooks = this.create(overrideGetBrightnessHookTypes);
      this.afterGetBrightnessHooks = this.create(afterGetBrightnessHookTypes);
      this.isGetBrightnessModded = this.beforeGetBrightnessHooks != null || this.overrideGetBrightnessHooks != null || this.afterGetBrightnessHooks != null;
      this.beforeGetEyeHeightHooks = this.create(beforeGetEyeHeightHookTypes);
      this.overrideGetEyeHeightHooks = this.create(overrideGetEyeHeightHookTypes);
      this.afterGetEyeHeightHooks = this.create(afterGetEyeHeightHookTypes);
      this.isGetEyeHeightModded = this.beforeGetEyeHeightHooks != null || this.overrideGetEyeHeightHooks != null || this.afterGetEyeHeightHooks != null;
      this.beforeHealHooks = this.create(beforeHealHookTypes);
      this.overrideHealHooks = this.create(overrideHealHookTypes);
      this.afterHealHooks = this.create(afterHealHookTypes);
      this.isHealModded = this.beforeHealHooks != null || this.overrideHealHooks != null || this.afterHealHooks != null;
      this.beforeIsEntityInsideOpaqueBlockHooks = this.create(beforeIsEntityInsideOpaqueBlockHookTypes);
      this.overrideIsEntityInsideOpaqueBlockHooks = this.create(overrideIsEntityInsideOpaqueBlockHookTypes);
      this.afterIsEntityInsideOpaqueBlockHooks = this.create(afterIsEntityInsideOpaqueBlockHookTypes);
      this.isIsEntityInsideOpaqueBlockModded = this.beforeIsEntityInsideOpaqueBlockHooks != null || this.overrideIsEntityInsideOpaqueBlockHooks != null || this.afterIsEntityInsideOpaqueBlockHooks != null;
      this.beforeIsInWaterHooks = this.create(beforeIsInWaterHookTypes);
      this.overrideIsInWaterHooks = this.create(overrideIsInWaterHookTypes);
      this.afterIsInWaterHooks = this.create(afterIsInWaterHookTypes);
      this.isIsInWaterModded = this.beforeIsInWaterHooks != null || this.overrideIsInWaterHooks != null || this.afterIsInWaterHooks != null;
      this.beforeIsInsideOfMaterialHooks = this.create(beforeIsInsideOfMaterialHookTypes);
      this.overrideIsInsideOfMaterialHooks = this.create(overrideIsInsideOfMaterialHookTypes);
      this.afterIsInsideOfMaterialHooks = this.create(afterIsInsideOfMaterialHookTypes);
      this.isIsInsideOfMaterialModded = this.beforeIsInsideOfMaterialHooks != null || this.overrideIsInsideOfMaterialHooks != null || this.afterIsInsideOfMaterialHooks != null;
      this.beforeIsOnLadderHooks = this.create(beforeIsOnLadderHookTypes);
      this.overrideIsOnLadderHooks = this.create(overrideIsOnLadderHookTypes);
      this.afterIsOnLadderHooks = this.create(afterIsOnLadderHookTypes);
      this.isIsOnLadderModded = this.beforeIsOnLadderHooks != null || this.overrideIsOnLadderHooks != null || this.afterIsOnLadderHooks != null;
      this.beforeIsPlayerSleepingHooks = this.create(beforeIsPlayerSleepingHookTypes);
      this.overrideIsPlayerSleepingHooks = this.create(overrideIsPlayerSleepingHookTypes);
      this.afterIsPlayerSleepingHooks = this.create(afterIsPlayerSleepingHookTypes);
      this.isIsPlayerSleepingModded = this.beforeIsPlayerSleepingHooks != null || this.overrideIsPlayerSleepingHooks != null || this.afterIsPlayerSleepingHooks != null;
      this.beforeIsSneakingHooks = this.create(beforeIsSneakingHookTypes);
      this.overrideIsSneakingHooks = this.create(overrideIsSneakingHookTypes);
      this.afterIsSneakingHooks = this.create(afterIsSneakingHookTypes);
      this.isIsSneakingModded = this.beforeIsSneakingHooks != null || this.overrideIsSneakingHooks != null || this.afterIsSneakingHooks != null;
      this.beforeJumpHooks = this.create(beforeJumpHookTypes);
      this.overrideJumpHooks = this.create(overrideJumpHookTypes);
      this.afterJumpHooks = this.create(afterJumpHookTypes);
      this.isJumpModded = this.beforeJumpHooks != null || this.overrideJumpHooks != null || this.afterJumpHooks != null;
      this.beforeKnockBackHooks = this.create(beforeKnockBackHookTypes);
      this.overrideKnockBackHooks = this.create(overrideKnockBackHookTypes);
      this.afterKnockBackHooks = this.create(afterKnockBackHookTypes);
      this.isKnockBackModded = this.beforeKnockBackHooks != null || this.overrideKnockBackHooks != null || this.afterKnockBackHooks != null;
      this.beforeMountEntityHooks = this.create(beforeMountEntityHookTypes);
      this.overrideMountEntityHooks = this.create(overrideMountEntityHookTypes);
      this.afterMountEntityHooks = this.create(afterMountEntityHookTypes);
      this.isMountEntityModded = this.beforeMountEntityHooks != null || this.overrideMountEntityHooks != null || this.afterMountEntityHooks != null;
      this.beforeMoveEntityHooks = this.create(beforeMoveEntityHookTypes);
      this.overrideMoveEntityHooks = this.create(overrideMoveEntityHookTypes);
      this.afterMoveEntityHooks = this.create(afterMoveEntityHookTypes);
      this.isMoveEntityModded = this.beforeMoveEntityHooks != null || this.overrideMoveEntityHooks != null || this.afterMoveEntityHooks != null;
      this.beforeMoveEntityWithHeadingHooks = this.create(beforeMoveEntityWithHeadingHookTypes);
      this.overrideMoveEntityWithHeadingHooks = this.create(overrideMoveEntityWithHeadingHookTypes);
      this.afterMoveEntityWithHeadingHooks = this.create(afterMoveEntityWithHeadingHookTypes);
      this.isMoveEntityWithHeadingModded = this.beforeMoveEntityWithHeadingHooks != null || this.overrideMoveEntityWithHeadingHooks != null || this.afterMoveEntityWithHeadingHooks != null;
      this.beforeMoveFlyingHooks = this.create(beforeMoveFlyingHookTypes);
      this.overrideMoveFlyingHooks = this.create(overrideMoveFlyingHookTypes);
      this.afterMoveFlyingHooks = this.create(afterMoveFlyingHookTypes);
      this.isMoveFlyingModded = this.beforeMoveFlyingHooks != null || this.overrideMoveFlyingHooks != null || this.afterMoveFlyingHooks != null;
      this.beforeOnDeathHooks = this.create(beforeOnDeathHookTypes);
      this.overrideOnDeathHooks = this.create(overrideOnDeathHookTypes);
      this.afterOnDeathHooks = this.create(afterOnDeathHookTypes);
      this.isOnDeathModded = this.beforeOnDeathHooks != null || this.overrideOnDeathHooks != null || this.afterOnDeathHooks != null;
      this.beforeOnLivingUpdateHooks = this.create(beforeOnLivingUpdateHookTypes);
      this.overrideOnLivingUpdateHooks = this.create(overrideOnLivingUpdateHookTypes);
      this.afterOnLivingUpdateHooks = this.create(afterOnLivingUpdateHookTypes);
      this.isOnLivingUpdateModded = this.beforeOnLivingUpdateHooks != null || this.overrideOnLivingUpdateHooks != null || this.afterOnLivingUpdateHooks != null;
      this.beforeOnKillEntityHooks = this.create(beforeOnKillEntityHookTypes);
      this.overrideOnKillEntityHooks = this.create(overrideOnKillEntityHookTypes);
      this.afterOnKillEntityHooks = this.create(afterOnKillEntityHookTypes);
      this.isOnKillEntityModded = this.beforeOnKillEntityHooks != null || this.overrideOnKillEntityHooks != null || this.afterOnKillEntityHooks != null;
      this.beforeOnStruckByLightningHooks = this.create(beforeOnStruckByLightningHookTypes);
      this.overrideOnStruckByLightningHooks = this.create(overrideOnStruckByLightningHookTypes);
      this.afterOnStruckByLightningHooks = this.create(afterOnStruckByLightningHookTypes);
      this.isOnStruckByLightningModded = this.beforeOnStruckByLightningHooks != null || this.overrideOnStruckByLightningHooks != null || this.afterOnStruckByLightningHooks != null;
      this.beforeOnUpdateHooks = this.create(beforeOnUpdateHookTypes);
      this.overrideOnUpdateHooks = this.create(overrideOnUpdateHookTypes);
      this.afterOnUpdateHooks = this.create(afterOnUpdateHookTypes);
      this.isOnUpdateModded = this.beforeOnUpdateHooks != null || this.overrideOnUpdateHooks != null || this.afterOnUpdateHooks != null;
      this.beforeOnUpdateEntityHooks = this.create(beforeOnUpdateEntityHookTypes);
      this.overrideOnUpdateEntityHooks = this.create(overrideOnUpdateEntityHookTypes);
      this.afterOnUpdateEntityHooks = this.create(afterOnUpdateEntityHookTypes);
      this.isOnUpdateEntityModded = this.beforeOnUpdateEntityHooks != null || this.overrideOnUpdateEntityHooks != null || this.afterOnUpdateEntityHooks != null;
      this.beforeReadEntityFromNBTHooks = this.create(beforeReadEntityFromNBTHookTypes);
      this.overrideReadEntityFromNBTHooks = this.create(overrideReadEntityFromNBTHookTypes);
      this.afterReadEntityFromNBTHooks = this.create(afterReadEntityFromNBTHookTypes);
      this.isReadEntityFromNBTModded = this.beforeReadEntityFromNBTHooks != null || this.overrideReadEntityFromNBTHooks != null || this.afterReadEntityFromNBTHooks != null;
      this.beforeSetDeadHooks = this.create(beforeSetDeadHookTypes);
      this.overrideSetDeadHooks = this.create(overrideSetDeadHookTypes);
      this.afterSetDeadHooks = this.create(afterSetDeadHookTypes);
      this.isSetDeadModded = this.beforeSetDeadHooks != null || this.overrideSetDeadHooks != null || this.afterSetDeadHooks != null;
      this.beforeSetEntityActionStateHooks = this.create(beforeSetEntityActionStateHookTypes);
      this.overrideSetEntityActionStateHooks = this.create(overrideSetEntityActionStateHookTypes);
      this.afterSetEntityActionStateHooks = this.create(afterSetEntityActionStateHookTypes);
      this.isSetEntityActionStateModded = this.beforeSetEntityActionStateHooks != null || this.overrideSetEntityActionStateHooks != null || this.afterSetEntityActionStateHooks != null;
      this.beforeSetPositionHooks = this.create(beforeSetPositionHookTypes);
      this.overrideSetPositionHooks = this.create(overrideSetPositionHookTypes);
      this.afterSetPositionHooks = this.create(afterSetPositionHookTypes);
      this.isSetPositionModded = this.beforeSetPositionHooks != null || this.overrideSetPositionHooks != null || this.afterSetPositionHooks != null;
      this.beforeSetSneakingHooks = this.create(beforeSetSneakingHookTypes);
      this.overrideSetSneakingHooks = this.create(overrideSetSneakingHookTypes);
      this.afterSetSneakingHooks = this.create(afterSetSneakingHookTypes);
      this.isSetSneakingModded = this.beforeSetSneakingHooks != null || this.overrideSetSneakingHooks != null || this.afterSetSneakingHooks != null;
      this.beforeSetSprintingHooks = this.create(beforeSetSprintingHookTypes);
      this.overrideSetSprintingHooks = this.create(overrideSetSprintingHookTypes);
      this.afterSetSprintingHooks = this.create(afterSetSprintingHookTypes);
      this.isSetSprintingModded = this.beforeSetSprintingHooks != null || this.overrideSetSprintingHooks != null || this.afterSetSprintingHooks != null;
      this.beforeSwingItemHooks = this.create(beforeSwingItemHookTypes);
      this.overrideSwingItemHooks = this.create(overrideSwingItemHookTypes);
      this.afterSwingItemHooks = this.create(afterSwingItemHookTypes);
      this.isSwingItemModded = this.beforeSwingItemHooks != null || this.overrideSwingItemHooks != null || this.afterSwingItemHooks != null;
      this.beforeUpdateEntityActionStateHooks = this.create(beforeUpdateEntityActionStateHookTypes);
      this.overrideUpdateEntityActionStateHooks = this.create(overrideUpdateEntityActionStateHookTypes);
      this.afterUpdateEntityActionStateHooks = this.create(afterUpdateEntityActionStateHookTypes);
      this.isUpdateEntityActionStateModded = this.beforeUpdateEntityActionStateHooks != null || this.overrideUpdateEntityActionStateHooks != null || this.afterUpdateEntityActionStateHooks != null;
      this.beforeUpdatePotionEffectsHooks = this.create(beforeUpdatePotionEffectsHookTypes);
      this.overrideUpdatePotionEffectsHooks = this.create(overrideUpdatePotionEffectsHookTypes);
      this.afterUpdatePotionEffectsHooks = this.create(afterUpdatePotionEffectsHookTypes);
      this.isUpdatePotionEffectsModded = this.beforeUpdatePotionEffectsHooks != null || this.overrideUpdatePotionEffectsHooks != null || this.afterUpdatePotionEffectsHooks != null;
      this.beforeUpdateRiddenHooks = this.create(beforeUpdateRiddenHookTypes);
      this.overrideUpdateRiddenHooks = this.create(overrideUpdateRiddenHookTypes);
      this.afterUpdateRiddenHooks = this.create(afterUpdateRiddenHookTypes);
      this.isUpdateRiddenModded = this.beforeUpdateRiddenHooks != null || this.overrideUpdateRiddenHooks != null || this.afterUpdateRiddenHooks != null;
      this.beforeWakeUpPlayerHooks = this.create(beforeWakeUpPlayerHookTypes);
      this.overrideWakeUpPlayerHooks = this.create(overrideWakeUpPlayerHookTypes);
      this.afterWakeUpPlayerHooks = this.create(afterWakeUpPlayerHookTypes);
      this.isWakeUpPlayerModded = this.beforeWakeUpPlayerHooks != null || this.overrideWakeUpPlayerHooks != null || this.afterWakeUpPlayerHooks != null;
      this.beforeWriteEntityToNBTHooks = this.create(beforeWriteEntityToNBTHookTypes);
      this.overrideWriteEntityToNBTHooks = this.create(overrideWriteEntityToNBTHookTypes);
      this.afterWriteEntityToNBTHooks = this.create(afterWriteEntityToNBTHookTypes);
      this.isWriteEntityToNBTModded = this.beforeWriteEntityToNBTHooks != null || this.overrideWriteEntityToNBTHooks != null || this.afterWriteEntityToNBTHooks != null;
   }

   private void attachServerPlayerBase(String var1) {
      ServerPlayerBase var2 = this.createServerPlayerBase(var1);
      var2.beforeBaseAttach(true);
      this.allBaseObjects.put(var1, var2);
      this.updateServerPlayerBases();
      var2.afterBaseAttach(true);
   }

   private void detachServerPlayerBase(String var1) {
      ServerPlayerBase var2 = (ServerPlayerBase)this.allBaseObjects.get(var1);
      var2.beforeBaseDetach(true);
      this.allBaseObjects.remove(var1);
      var2.afterBaseDetach(true);
   }

   private ServerPlayerBase[] create(List var1) {
      if(var1.isEmpty()) {
         return null;
      } else {
         ServerPlayerBase[] var2 = new ServerPlayerBase[var1.size()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = this.getServerPlayerBase((String)var1.get(var3));
         }

         return var2;
      }
   }

   private void beforeLocalConstructing(MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
      if(this.beforeLocalConstructingHooks != null) {
         for(int var5 = this.beforeLocalConstructingHooks.length - 1; var5 >= 0; --var5) {
            this.beforeLocalConstructingHooks[var5].beforeLocalConstructing(var1, var2, var3, var4);
         }
      }

      this.beforeLocalConstructingHooks = null;
   }

   private void afterLocalConstructing(MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
      if(this.afterLocalConstructingHooks != null) {
         for(int var5 = 0; var5 < this.afterLocalConstructingHooks.length; ++var5) {
            this.afterLocalConstructingHooks[var5].afterLocalConstructing(var1, var2, var3, var4);
         }
      }

      this.afterLocalConstructingHooks = null;
   }

   public ServerPlayerBase getServerPlayerBase(String var1) {
      return (ServerPlayerBase)this.allBaseObjects.get(var1);
   }

   public Set getServerPlayerBaseIds() {
      return this.unmodifiableAllBaseIds;
   }

   public Object dynamic(String var1, Object[] var2) {
      var1 = var1.replace('.', '_').replace(' ', '_');
      this.executeAll(var1, var2, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
      Object var3 = this.dynamicOverwritten(var1, var2, (ServerPlayerBase)null);
      this.executeAll(var1, var2, afterDynamicHookTypes, afterDynamicHookMethods, false);
      return var3;
   }

   public Object dynamicOverwritten(String var1, Object[] var2, ServerPlayerBase var3) {
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
         return var8 == null?null:this.execute(this.getServerPlayerBase(var5), var8, var2);
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
            ServerPlayerBase var9 = this.getServerPlayerBase(var8);
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

   private Object execute(ServerPlayerBase var1, Method var2, Object[] var3) {
      try {
         return var2.invoke(var1, var3);
      } catch (Exception var5) {
         throw new RuntimeException("Exception while invoking dynamic method", var5);
      }
   }

   public static void addExhaustion(IServerPlayerAPI var0, float var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isAddExhaustionModded) {
         var2.addExhaustion(var1);
      } else {
         var0.localAddExhaustion(var1);
      }

   }

   private void addExhaustion(float var1) {
      int var2;
      if(this.beforeAddExhaustionHooks != null) {
         for(var2 = this.beforeAddExhaustionHooks.length - 1; var2 >= 0; --var2) {
            this.beforeAddExhaustionHooks[var2].beforeAddExhaustion(var1);
         }
      }

      if(this.overrideAddExhaustionHooks != null) {
         this.overrideAddExhaustionHooks[this.overrideAddExhaustionHooks.length - 1].addExhaustion(var1);
      } else {
         this.player.localAddExhaustion(var1);
      }

      if(this.afterAddExhaustionHooks != null) {
         for(var2 = 0; var2 < this.afterAddExhaustionHooks.length; ++var2) {
            this.afterAddExhaustionHooks[var2].afterAddExhaustion(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenAddExhaustion(ServerPlayerBase var1) {
      if(this.overrideAddExhaustionHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideAddExhaustionHooks.length; ++var2) {
            if(this.overrideAddExhaustionHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideAddExhaustionHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void addExperience(IServerPlayerAPI var0, int var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isAddExperienceModded) {
         var2.addExperience(var1);
      } else {
         var0.localAddExperience(var1);
      }

   }

   private void addExperience(int var1) {
      int var2;
      if(this.beforeAddExperienceHooks != null) {
         for(var2 = this.beforeAddExperienceHooks.length - 1; var2 >= 0; --var2) {
            this.beforeAddExperienceHooks[var2].beforeAddExperience(var1);
         }
      }

      if(this.overrideAddExperienceHooks != null) {
         this.overrideAddExperienceHooks[this.overrideAddExperienceHooks.length - 1].addExperience(var1);
      } else {
         this.player.localAddExperience(var1);
      }

      if(this.afterAddExperienceHooks != null) {
         for(var2 = 0; var2 < this.afterAddExperienceHooks.length; ++var2) {
            this.afterAddExperienceHooks[var2].afterAddExperience(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenAddExperience(ServerPlayerBase var1) {
      if(this.overrideAddExperienceHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideAddExperienceHooks.length; ++var2) {
            if(this.overrideAddExperienceHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideAddExperienceHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void addExperienceLevel(IServerPlayerAPI var0, int var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isAddExperienceLevelModded) {
         var2.addExperienceLevel(var1);
      } else {
         var0.localAddExperienceLevel(var1);
      }

   }

   private void addExperienceLevel(int var1) {
      int var2;
      if(this.beforeAddExperienceLevelHooks != null) {
         for(var2 = this.beforeAddExperienceLevelHooks.length - 1; var2 >= 0; --var2) {
            this.beforeAddExperienceLevelHooks[var2].beforeAddExperienceLevel(var1);
         }
      }

      if(this.overrideAddExperienceLevelHooks != null) {
         this.overrideAddExperienceLevelHooks[this.overrideAddExperienceLevelHooks.length - 1].addExperienceLevel(var1);
      } else {
         this.player.localAddExperienceLevel(var1);
      }

      if(this.afterAddExperienceLevelHooks != null) {
         for(var2 = 0; var2 < this.afterAddExperienceLevelHooks.length; ++var2) {
            this.afterAddExperienceLevelHooks[var2].afterAddExperienceLevel(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenAddExperienceLevel(ServerPlayerBase var1) {
      if(this.overrideAddExperienceLevelHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideAddExperienceLevelHooks.length; ++var2) {
            if(this.overrideAddExperienceLevelHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideAddExperienceLevelHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void addMovementStat(IServerPlayerAPI var0, double var1, double var3, double var5) {
      ServerPlayerAPI var7 = var0.getServerPlayerAPI();
      if(var7 != null && var7.isAddMovementStatModded) {
         var7.addMovementStat(var1, var3, var5);
      } else {
         var0.localAddMovementStat(var1, var3, var5);
      }

   }

   private void addMovementStat(double var1, double var3, double var5) {
      int var7;
      if(this.beforeAddMovementStatHooks != null) {
         for(var7 = this.beforeAddMovementStatHooks.length - 1; var7 >= 0; --var7) {
            this.beforeAddMovementStatHooks[var7].beforeAddMovementStat(var1, var3, var5);
         }
      }

      if(this.overrideAddMovementStatHooks != null) {
         this.overrideAddMovementStatHooks[this.overrideAddMovementStatHooks.length - 1].addMovementStat(var1, var3, var5);
      } else {
         this.player.localAddMovementStat(var1, var3, var5);
      }

      if(this.afterAddMovementStatHooks != null) {
         for(var7 = 0; var7 < this.afterAddMovementStatHooks.length; ++var7) {
            this.afterAddMovementStatHooks[var7].afterAddMovementStat(var1, var3, var5);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenAddMovementStat(ServerPlayerBase var1) {
      if(this.overrideAddMovementStatHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideAddMovementStatHooks.length; ++var2) {
            if(this.overrideAddMovementStatHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideAddMovementStatHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean attackEntityFrom(IServerPlayerAPI var0, DamageSource var1, float var2) {
      ServerPlayerAPI var4 = var0.getServerPlayerAPI();
      boolean var3;
      if(var4 != null && var4.isAttackEntityFromModded) {
         var3 = var4.attackEntityFrom(var1, var2);
      } else {
         var3 = var0.localAttackEntityFrom(var1, var2);
      }

      return var3;
   }

   private boolean attackEntityFrom(DamageSource var1, float var2) {
      if(this.beforeAttackEntityFromHooks != null) {
         for(int var3 = this.beforeAttackEntityFromHooks.length - 1; var3 >= 0; --var3) {
            this.beforeAttackEntityFromHooks[var3].beforeAttackEntityFrom(var1, var2);
         }
      }

      boolean var5;
      if(this.overrideAttackEntityFromHooks != null) {
         var5 = this.overrideAttackEntityFromHooks[this.overrideAttackEntityFromHooks.length - 1].attackEntityFrom(var1, var2);
      } else {
         var5 = this.player.localAttackEntityFrom(var1, var2);
      }

      if(this.afterAttackEntityFromHooks != null) {
         for(int var4 = 0; var4 < this.afterAttackEntityFromHooks.length; ++var4) {
            this.afterAttackEntityFromHooks[var4].afterAttackEntityFrom(var1, var2);
         }
      }

      return var5;
   }

   protected ServerPlayerBase GetOverwrittenAttackEntityFrom(ServerPlayerBase var1) {
      if(this.overrideAttackEntityFromHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideAttackEntityFromHooks.length; ++var2) {
            if(this.overrideAttackEntityFromHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideAttackEntityFromHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void attackTargetEntityWithCurrentItem(IServerPlayerAPI var0, Entity var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isAttackTargetEntityWithCurrentItemModded) {
         var2.attackTargetEntityWithCurrentItem(var1);
      } else {
         var0.localAttackTargetEntityWithCurrentItem(var1);
      }

   }

   private void attackTargetEntityWithCurrentItem(Entity var1) {
      int var2;
      if(this.beforeAttackTargetEntityWithCurrentItemHooks != null) {
         for(var2 = this.beforeAttackTargetEntityWithCurrentItemHooks.length - 1; var2 >= 0; --var2) {
            this.beforeAttackTargetEntityWithCurrentItemHooks[var2].beforeAttackTargetEntityWithCurrentItem(var1);
         }
      }

      if(this.overrideAttackTargetEntityWithCurrentItemHooks != null) {
         this.overrideAttackTargetEntityWithCurrentItemHooks[this.overrideAttackTargetEntityWithCurrentItemHooks.length - 1].attackTargetEntityWithCurrentItem(var1);
      } else {
         this.player.localAttackTargetEntityWithCurrentItem(var1);
      }

      if(this.afterAttackTargetEntityWithCurrentItemHooks != null) {
         for(var2 = 0; var2 < this.afterAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
            this.afterAttackTargetEntityWithCurrentItemHooks[var2].afterAttackTargetEntityWithCurrentItem(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(ServerPlayerBase var1) {
      if(this.overrideAttackTargetEntityWithCurrentItemHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
            if(this.overrideAttackTargetEntityWithCurrentItemHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideAttackTargetEntityWithCurrentItemHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean canBreatheUnderwater(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isCanBreatheUnderwaterModded) {
         var1 = var2.canBreatheUnderwater();
      } else {
         var1 = var0.localCanBreatheUnderwater();
      }

      return var1;
   }

   private boolean canBreatheUnderwater() {
      if(this.beforeCanBreatheUnderwaterHooks != null) {
         for(int var1 = this.beforeCanBreatheUnderwaterHooks.length - 1; var1 >= 0; --var1) {
            this.beforeCanBreatheUnderwaterHooks[var1].beforeCanBreatheUnderwater();
         }
      }

      boolean var3;
      if(this.overrideCanBreatheUnderwaterHooks != null) {
         var3 = this.overrideCanBreatheUnderwaterHooks[this.overrideCanBreatheUnderwaterHooks.length - 1].canBreatheUnderwater();
      } else {
         var3 = this.player.localCanBreatheUnderwater();
      }

      if(this.afterCanBreatheUnderwaterHooks != null) {
         for(int var2 = 0; var2 < this.afterCanBreatheUnderwaterHooks.length; ++var2) {
            this.afterCanBreatheUnderwaterHooks[var2].afterCanBreatheUnderwater();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenCanBreatheUnderwater(ServerPlayerBase var1) {
      if(this.overrideCanBreatheUnderwaterHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideCanBreatheUnderwaterHooks.length; ++var2) {
            if(this.overrideCanBreatheUnderwaterHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideCanBreatheUnderwaterHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean canHarvestBlock(IServerPlayerAPI var0, Block var1) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      boolean var2;
      if(var3 != null && var3.isCanHarvestBlockModded) {
         var2 = var3.canHarvestBlock(var1);
      } else {
         var2 = var0.localCanHarvestBlock(var1);
      }

      return var2;
   }

   private boolean canHarvestBlock(Block var1) {
      if(this.beforeCanHarvestBlockHooks != null) {
         for(int var2 = this.beforeCanHarvestBlockHooks.length - 1; var2 >= 0; --var2) {
            this.beforeCanHarvestBlockHooks[var2].beforeCanHarvestBlock(var1);
         }
      }

      boolean var4;
      if(this.overrideCanHarvestBlockHooks != null) {
         var4 = this.overrideCanHarvestBlockHooks[this.overrideCanHarvestBlockHooks.length - 1].canHarvestBlock(var1);
      } else {
         var4 = this.player.localCanHarvestBlock(var1);
      }

      if(this.afterCanHarvestBlockHooks != null) {
         for(int var3 = 0; var3 < this.afterCanHarvestBlockHooks.length; ++var3) {
            this.afterCanHarvestBlockHooks[var3].afterCanHarvestBlock(var1);
         }
      }

      return var4;
   }

   protected ServerPlayerBase GetOverwrittenCanHarvestBlock(ServerPlayerBase var1) {
      if(this.overrideCanHarvestBlockHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideCanHarvestBlockHooks.length; ++var2) {
            if(this.overrideCanHarvestBlockHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideCanHarvestBlockHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean canPlayerEdit(IServerPlayerAPI var0, int var1, int var2, int var3, int var4, ItemStack var5) {
      ServerPlayerAPI var7 = var0.getServerPlayerAPI();
      boolean var6;
      if(var7 != null && var7.isCanPlayerEditModded) {
         var6 = var7.canPlayerEdit(var1, var2, var3, var4, var5);
      } else {
         var6 = var0.localCanPlayerEdit(var1, var2, var3, var4, var5);
      }

      return var6;
   }

   private boolean canPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {
      if(this.beforeCanPlayerEditHooks != null) {
         for(int var6 = this.beforeCanPlayerEditHooks.length - 1; var6 >= 0; --var6) {
            this.beforeCanPlayerEditHooks[var6].beforeCanPlayerEdit(var1, var2, var3, var4, var5);
         }
      }

      boolean var8;
      if(this.overrideCanPlayerEditHooks != null) {
         var8 = this.overrideCanPlayerEditHooks[this.overrideCanPlayerEditHooks.length - 1].canPlayerEdit(var1, var2, var3, var4, var5);
      } else {
         var8 = this.player.localCanPlayerEdit(var1, var2, var3, var4, var5);
      }

      if(this.afterCanPlayerEditHooks != null) {
         for(int var7 = 0; var7 < this.afterCanPlayerEditHooks.length; ++var7) {
            this.afterCanPlayerEditHooks[var7].afterCanPlayerEdit(var1, var2, var3, var4, var5);
         }
      }

      return var8;
   }

   protected ServerPlayerBase GetOverwrittenCanPlayerEdit(ServerPlayerBase var1) {
      if(this.overrideCanPlayerEditHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideCanPlayerEditHooks.length; ++var2) {
            if(this.overrideCanPlayerEditHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideCanPlayerEditHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean canTriggerWalking(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isCanTriggerWalkingModded) {
         var1 = var2.canTriggerWalking();
      } else {
         var1 = var0.localCanTriggerWalking();
      }

      return var1;
   }

   private boolean canTriggerWalking() {
      if(this.beforeCanTriggerWalkingHooks != null) {
         for(int var1 = this.beforeCanTriggerWalkingHooks.length - 1; var1 >= 0; --var1) {
            this.beforeCanTriggerWalkingHooks[var1].beforeCanTriggerWalking();
         }
      }

      boolean var3;
      if(this.overrideCanTriggerWalkingHooks != null) {
         var3 = this.overrideCanTriggerWalkingHooks[this.overrideCanTriggerWalkingHooks.length - 1].canTriggerWalking();
      } else {
         var3 = this.player.localCanTriggerWalking();
      }

      if(this.afterCanTriggerWalkingHooks != null) {
         for(int var2 = 0; var2 < this.afterCanTriggerWalkingHooks.length; ++var2) {
            this.afterCanTriggerWalkingHooks[var2].afterCanTriggerWalking();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenCanTriggerWalking(ServerPlayerBase var1) {
      if(this.overrideCanTriggerWalkingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideCanTriggerWalkingHooks.length; ++var2) {
            if(this.overrideCanTriggerWalkingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideCanTriggerWalkingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void clonePlayer(IServerPlayerAPI var0, EntityPlayer var1, boolean var2) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      if(var3 != null && var3.isClonePlayerModded) {
         var3.clonePlayer(var1, var2);
      } else {
         var0.localClonePlayer(var1, var2);
      }

   }

   private void clonePlayer(EntityPlayer var1, boolean var2) {
      int var3;
      if(this.beforeClonePlayerHooks != null) {
         for(var3 = this.beforeClonePlayerHooks.length - 1; var3 >= 0; --var3) {
            this.beforeClonePlayerHooks[var3].beforeClonePlayer(var1, var2);
         }
      }

      if(this.overrideClonePlayerHooks != null) {
         this.overrideClonePlayerHooks[this.overrideClonePlayerHooks.length - 1].clonePlayer(var1, var2);
      } else {
         this.player.localClonePlayer(var1, var2);
      }

      if(this.afterClonePlayerHooks != null) {
         for(var3 = 0; var3 < this.afterClonePlayerHooks.length; ++var3) {
            this.afterClonePlayerHooks[var3].afterClonePlayer(var1, var2);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenClonePlayer(ServerPlayerBase var1) {
      if(this.overrideClonePlayerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideClonePlayerHooks.length; ++var2) {
            if(this.overrideClonePlayerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideClonePlayerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void damageEntity(IServerPlayerAPI var0, DamageSource var1, float var2) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      if(var3 != null && var3.isDamageEntityModded) {
         var3.damageEntity(var1, var2);
      } else {
         var0.localDamageEntity(var1, var2);
      }

   }

   private void damageEntity(DamageSource var1, float var2) {
      int var3;
      if(this.beforeDamageEntityHooks != null) {
         for(var3 = this.beforeDamageEntityHooks.length - 1; var3 >= 0; --var3) {
            this.beforeDamageEntityHooks[var3].beforeDamageEntity(var1, var2);
         }
      }

      if(this.overrideDamageEntityHooks != null) {
         this.overrideDamageEntityHooks[this.overrideDamageEntityHooks.length - 1].damageEntity(var1, var2);
      } else {
         this.player.localDamageEntity(var1, var2);
      }

      if(this.afterDamageEntityHooks != null) {
         for(var3 = 0; var3 < this.afterDamageEntityHooks.length; ++var3) {
            this.afterDamageEntityHooks[var3].afterDamageEntity(var1, var2);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenDamageEntity(ServerPlayerBase var1) {
      if(this.overrideDamageEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDamageEntityHooks.length; ++var2) {
            if(this.overrideDamageEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDamageEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void displayGUIChest(IServerPlayerAPI var0, IInventory var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isDisplayGUIChestModded) {
         var2.displayGUIChest(var1);
      } else {
         var0.localDisplayGUIChest(var1);
      }

   }

   private void displayGUIChest(IInventory var1) {
      int var2;
      if(this.beforeDisplayGUIChestHooks != null) {
         for(var2 = this.beforeDisplayGUIChestHooks.length - 1; var2 >= 0; --var2) {
            this.beforeDisplayGUIChestHooks[var2].beforeDisplayGUIChest(var1);
         }
      }

      if(this.overrideDisplayGUIChestHooks != null) {
         this.overrideDisplayGUIChestHooks[this.overrideDisplayGUIChestHooks.length - 1].displayGUIChest(var1);
      } else {
         this.player.localDisplayGUIChest(var1);
      }

      if(this.afterDisplayGUIChestHooks != null) {
         for(var2 = 0; var2 < this.afterDisplayGUIChestHooks.length; ++var2) {
            this.afterDisplayGUIChestHooks[var2].afterDisplayGUIChest(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenDisplayGUIChest(ServerPlayerBase var1) {
      if(this.overrideDisplayGUIChestHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDisplayGUIChestHooks.length; ++var2) {
            if(this.overrideDisplayGUIChestHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDisplayGUIChestHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void displayGUIDispenser(IServerPlayerAPI var0, TileEntityDispenser var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isDisplayGUIDispenserModded) {
         var2.displayGUIDispenser(var1);
      } else {
         var0.localDisplayGUIDispenser(var1);
      }

   }

   private void displayGUIDispenser(TileEntityDispenser var1) {
      int var2;
      if(this.beforeDisplayGUIDispenserHooks != null) {
         for(var2 = this.beforeDisplayGUIDispenserHooks.length - 1; var2 >= 0; --var2) {
            this.beforeDisplayGUIDispenserHooks[var2].beforeDisplayGUIDispenser(var1);
         }
      }

      if(this.overrideDisplayGUIDispenserHooks != null) {
         this.overrideDisplayGUIDispenserHooks[this.overrideDisplayGUIDispenserHooks.length - 1].displayGUIDispenser(var1);
      } else {
         this.player.localDisplayGUIDispenser(var1);
      }

      if(this.afterDisplayGUIDispenserHooks != null) {
         for(var2 = 0; var2 < this.afterDisplayGUIDispenserHooks.length; ++var2) {
            this.afterDisplayGUIDispenserHooks[var2].afterDisplayGUIDispenser(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenDisplayGUIDispenser(ServerPlayerBase var1) {
      if(this.overrideDisplayGUIDispenserHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDisplayGUIDispenserHooks.length; ++var2) {
            if(this.overrideDisplayGUIDispenserHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDisplayGUIDispenserHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void displayGUIFurnace(IServerPlayerAPI var0, TileEntityFurnace var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isDisplayGUIFurnaceModded) {
         var2.displayGUIFurnace(var1);
      } else {
         var0.localDisplayGUIFurnace(var1);
      }

   }

   private void displayGUIFurnace(TileEntityFurnace var1) {
      int var2;
      if(this.beforeDisplayGUIFurnaceHooks != null) {
         for(var2 = this.beforeDisplayGUIFurnaceHooks.length - 1; var2 >= 0; --var2) {
            this.beforeDisplayGUIFurnaceHooks[var2].beforeDisplayGUIFurnace(var1);
         }
      }

      if(this.overrideDisplayGUIFurnaceHooks != null) {
         this.overrideDisplayGUIFurnaceHooks[this.overrideDisplayGUIFurnaceHooks.length - 1].displayGUIFurnace(var1);
      } else {
         this.player.localDisplayGUIFurnace(var1);
      }

      if(this.afterDisplayGUIFurnaceHooks != null) {
         for(var2 = 0; var2 < this.afterDisplayGUIFurnaceHooks.length; ++var2) {
            this.afterDisplayGUIFurnaceHooks[var2].afterDisplayGUIFurnace(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenDisplayGUIFurnace(ServerPlayerBase var1) {
      if(this.overrideDisplayGUIFurnaceHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDisplayGUIFurnaceHooks.length; ++var2) {
            if(this.overrideDisplayGUIFurnaceHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDisplayGUIFurnaceHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void displayGUIWorkbench(IServerPlayerAPI var0, int var1, int var2, int var3) {
      ServerPlayerAPI var4 = var0.getServerPlayerAPI();
      if(var4 != null && var4.isDisplayGUIWorkbenchModded) {
         var4.displayGUIWorkbench(var1, var2, var3);
      } else {
         var0.localDisplayGUIWorkbench(var1, var2, var3);
      }

   }

   private void displayGUIWorkbench(int var1, int var2, int var3) {
      int var4;
      if(this.beforeDisplayGUIWorkbenchHooks != null) {
         for(var4 = this.beforeDisplayGUIWorkbenchHooks.length - 1; var4 >= 0; --var4) {
            this.beforeDisplayGUIWorkbenchHooks[var4].beforeDisplayGUIWorkbench(var1, var2, var3);
         }
      }

      if(this.overrideDisplayGUIWorkbenchHooks != null) {
         this.overrideDisplayGUIWorkbenchHooks[this.overrideDisplayGUIWorkbenchHooks.length - 1].displayGUIWorkbench(var1, var2, var3);
      } else {
         this.player.localDisplayGUIWorkbench(var1, var2, var3);
      }

      if(this.afterDisplayGUIWorkbenchHooks != null) {
         for(var4 = 0; var4 < this.afterDisplayGUIWorkbenchHooks.length; ++var4) {
            this.afterDisplayGUIWorkbenchHooks[var4].afterDisplayGUIWorkbench(var1, var2, var3);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenDisplayGUIWorkbench(ServerPlayerBase var1) {
      if(this.overrideDisplayGUIWorkbenchHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDisplayGUIWorkbenchHooks.length; ++var2) {
            if(this.overrideDisplayGUIWorkbenchHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDisplayGUIWorkbenchHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static EntityItem dropOneItem(IServerPlayerAPI var0, boolean var1) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      EntityItem var2;
      if(var3 != null && var3.isDropOneItemModded) {
         var2 = var3.dropOneItem(var1);
      } else {
         var2 = var0.localDropOneItem(var1);
      }

      return var2;
   }

   private EntityItem dropOneItem(boolean var1) {
      if(this.beforeDropOneItemHooks != null) {
         for(int var2 = this.beforeDropOneItemHooks.length - 1; var2 >= 0; --var2) {
            this.beforeDropOneItemHooks[var2].beforeDropOneItem(var1);
         }
      }

      EntityItem var4;
      if(this.overrideDropOneItemHooks != null) {
         var4 = this.overrideDropOneItemHooks[this.overrideDropOneItemHooks.length - 1].dropOneItem(var1);
      } else {
         var4 = this.player.localDropOneItem(var1);
      }

      if(this.afterDropOneItemHooks != null) {
         for(int var3 = 0; var3 < this.afterDropOneItemHooks.length; ++var3) {
            this.afterDropOneItemHooks[var3].afterDropOneItem(var1);
         }
      }

      return var4;
   }

   protected ServerPlayerBase GetOverwrittenDropOneItem(ServerPlayerBase var1) {
      if(this.overrideDropOneItemHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDropOneItemHooks.length; ++var2) {
            if(this.overrideDropOneItemHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDropOneItemHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static EntityItem dropPlayerItem(IServerPlayerAPI var0, ItemStack var1, boolean var2) {
      ServerPlayerAPI var4 = var0.getServerPlayerAPI();
      EntityItem var3;
      if(var4 != null && var4.isDropPlayerItemModded) {
         var3 = var4.dropPlayerItem(var1, var2);
      } else {
         var3 = var0.localDropPlayerItem(var1, var2);
      }

      return var3;
   }

   private EntityItem dropPlayerItem(ItemStack var1, boolean var2) {
      if(this.beforeDropPlayerItemHooks != null) {
         for(int var3 = this.beforeDropPlayerItemHooks.length - 1; var3 >= 0; --var3) {
            this.beforeDropPlayerItemHooks[var3].beforeDropPlayerItem(var1, var2);
         }
      }

      EntityItem var5;
      if(this.overrideDropPlayerItemHooks != null) {
         var5 = this.overrideDropPlayerItemHooks[this.overrideDropPlayerItemHooks.length - 1].dropPlayerItem(var1, var2);
      } else {
         var5 = this.player.localDropPlayerItem(var1, var2);
      }

      if(this.afterDropPlayerItemHooks != null) {
         for(int var4 = 0; var4 < this.afterDropPlayerItemHooks.length; ++var4) {
            this.afterDropPlayerItemHooks[var4].afterDropPlayerItem(var1, var2);
         }
      }

      return var5;
   }

   protected ServerPlayerBase GetOverwrittenDropPlayerItem(ServerPlayerBase var1) {
      if(this.overrideDropPlayerItemHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideDropPlayerItemHooks.length; ++var2) {
            if(this.overrideDropPlayerItemHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideDropPlayerItemHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void fall(IServerPlayerAPI var0, float var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isFallModded) {
         var2.fall(var1);
      } else {
         var0.localFall(var1);
      }

   }

   private void fall(float var1) {
      int var2;
      if(this.beforeFallHooks != null) {
         for(var2 = this.beforeFallHooks.length - 1; var2 >= 0; --var2) {
            this.beforeFallHooks[var2].beforeFall(var1);
         }
      }

      if(this.overrideFallHooks != null) {
         this.overrideFallHooks[this.overrideFallHooks.length - 1].fall(var1);
      } else {
         this.player.localFall(var1);
      }

      if(this.afterFallHooks != null) {
         for(var2 = 0; var2 < this.afterFallHooks.length; ++var2) {
            this.afterFallHooks[var2].afterFall(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenFall(ServerPlayerBase var1) {
      if(this.overrideFallHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideFallHooks.length; ++var2) {
            if(this.overrideFallHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideFallHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float getAIMoveSpeed(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      float var1;
      if(var2 != null && var2.isGetAIMoveSpeedModded) {
         var1 = var2.getAIMoveSpeed();
      } else {
         var1 = var0.localGetAIMoveSpeed();
      }

      return var1;
   }

   private float getAIMoveSpeed() {
      if(this.beforeGetAIMoveSpeedHooks != null) {
         for(int var1 = this.beforeGetAIMoveSpeedHooks.length - 1; var1 >= 0; --var1) {
            this.beforeGetAIMoveSpeedHooks[var1].beforeGetAIMoveSpeed();
         }
      }

      float var3;
      if(this.overrideGetAIMoveSpeedHooks != null) {
         var3 = this.overrideGetAIMoveSpeedHooks[this.overrideGetAIMoveSpeedHooks.length - 1].getAIMoveSpeed();
      } else {
         var3 = this.player.localGetAIMoveSpeed();
      }

      if(this.afterGetAIMoveSpeedHooks != null) {
         for(int var2 = 0; var2 < this.afterGetAIMoveSpeedHooks.length; ++var2) {
            this.afterGetAIMoveSpeedHooks[var2].afterGetAIMoveSpeed();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenGetAIMoveSpeed(ServerPlayerBase var1) {
      if(this.overrideGetAIMoveSpeedHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetAIMoveSpeedHooks.length; ++var2) {
            if(this.overrideGetAIMoveSpeedHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetAIMoveSpeedHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float getCurrentPlayerStrVsBlock(IServerPlayerAPI var0, Block var1, boolean var2) {
      ServerPlayerAPI var4 = var0.getServerPlayerAPI();
      float var3;
      if(var4 != null && var4.isGetCurrentPlayerStrVsBlockModded) {
         var3 = var4.getCurrentPlayerStrVsBlock(var1, var2);
      } else {
         var3 = var0.localGetCurrentPlayerStrVsBlock(var1, var2);
      }

      return var3;
   }

   private float getCurrentPlayerStrVsBlock(Block var1, boolean var2) {
      if(this.beforeGetCurrentPlayerStrVsBlockHooks != null) {
         for(int var3 = this.beforeGetCurrentPlayerStrVsBlockHooks.length - 1; var3 >= 0; --var3) {
            this.beforeGetCurrentPlayerStrVsBlockHooks[var3].beforeGetCurrentPlayerStrVsBlock(var1, var2);
         }
      }

      float var5;
      if(this.overrideGetCurrentPlayerStrVsBlockHooks != null) {
         var5 = this.overrideGetCurrentPlayerStrVsBlockHooks[this.overrideGetCurrentPlayerStrVsBlockHooks.length - 1].getCurrentPlayerStrVsBlock(var1, var2);
      } else {
         var5 = this.player.localGetCurrentPlayerStrVsBlock(var1, var2);
      }

      if(this.afterGetCurrentPlayerStrVsBlockHooks != null) {
         for(int var4 = 0; var4 < this.afterGetCurrentPlayerStrVsBlockHooks.length; ++var4) {
            this.afterGetCurrentPlayerStrVsBlockHooks[var4].afterGetCurrentPlayerStrVsBlock(var1, var2);
         }
      }

      return var5;
   }

   protected ServerPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(ServerPlayerBase var1) {
      if(this.overrideGetCurrentPlayerStrVsBlockHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetCurrentPlayerStrVsBlockHooks.length; ++var2) {
            if(this.overrideGetCurrentPlayerStrVsBlockHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetCurrentPlayerStrVsBlockHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float getCurrentPlayerStrVsBlockForge(IServerPlayerAPI var0, Block var1, boolean var2, int var3) {
      ServerPlayerAPI var5 = var0.getServerPlayerAPI();
      float var4;
      if(var5 != null && var5.isGetCurrentPlayerStrVsBlockForgeModded) {
         var4 = var5.getCurrentPlayerStrVsBlockForge(var1, var2, var3);
      } else {
         var4 = var0.localGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
      }

      return var4;
   }

   private float getCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {
      if(this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null) {
         for(int var4 = this.beforeGetCurrentPlayerStrVsBlockForgeHooks.length - 1; var4 >= 0; --var4) {
            this.beforeGetCurrentPlayerStrVsBlockForgeHooks[var4].beforeGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
         }
      }

      float var6;
      if(this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null) {
         var6 = this.overrideGetCurrentPlayerStrVsBlockForgeHooks[this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length - 1].getCurrentPlayerStrVsBlockForge(var1, var2, var3);
      } else {
         var6 = this.player.localGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
      }

      if(this.afterGetCurrentPlayerStrVsBlockForgeHooks != null) {
         for(int var5 = 0; var5 < this.afterGetCurrentPlayerStrVsBlockForgeHooks.length; ++var5) {
            this.afterGetCurrentPlayerStrVsBlockForgeHooks[var5].afterGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
         }
      }

      return var6;
   }

   protected ServerPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlockForge(ServerPlayerBase var1) {
      if(this.overrideGetCurrentPlayerStrVsBlockForgeHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length; ++var2) {
            if(this.overrideGetCurrentPlayerStrVsBlockForgeHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetCurrentPlayerStrVsBlockForgeHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static double getDistanceSq(IServerPlayerAPI var0, double var1, double var3, double var5) {
      ServerPlayerAPI var9 = var0.getServerPlayerAPI();
      double var7;
      if(var9 != null && var9.isGetDistanceSqModded) {
         var7 = var9.getDistanceSq(var1, var3, var5);
      } else {
         var7 = var0.localGetDistanceSq(var1, var3, var5);
      }

      return var7;
   }

   private double getDistanceSq(double var1, double var3, double var5) {
      if(this.beforeGetDistanceSqHooks != null) {
         for(int var7 = this.beforeGetDistanceSqHooks.length - 1; var7 >= 0; --var7) {
            this.beforeGetDistanceSqHooks[var7].beforeGetDistanceSq(var1, var3, var5);
         }
      }

      double var10;
      if(this.overrideGetDistanceSqHooks != null) {
         var10 = this.overrideGetDistanceSqHooks[this.overrideGetDistanceSqHooks.length - 1].getDistanceSq(var1, var3, var5);
      } else {
         var10 = this.player.localGetDistanceSq(var1, var3, var5);
      }

      if(this.afterGetDistanceSqHooks != null) {
         for(int var9 = 0; var9 < this.afterGetDistanceSqHooks.length; ++var9) {
            this.afterGetDistanceSqHooks[var9].afterGetDistanceSq(var1, var3, var5);
         }
      }

      return var10;
   }

   protected ServerPlayerBase GetOverwrittenGetDistanceSq(ServerPlayerBase var1) {
      if(this.overrideGetDistanceSqHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetDistanceSqHooks.length; ++var2) {
            if(this.overrideGetDistanceSqHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetDistanceSqHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float getBrightness(IServerPlayerAPI var0, float var1) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      float var2;
      if(var3 != null && var3.isGetBrightnessModded) {
         var2 = var3.getBrightness(var1);
      } else {
         var2 = var0.localGetBrightness(var1);
      }

      return var2;
   }

   private float getBrightness(float var1) {
      if(this.beforeGetBrightnessHooks != null) {
         for(int var2 = this.beforeGetBrightnessHooks.length - 1; var2 >= 0; --var2) {
            this.beforeGetBrightnessHooks[var2].beforeGetBrightness(var1);
         }
      }

      float var4;
      if(this.overrideGetBrightnessHooks != null) {
         var4 = this.overrideGetBrightnessHooks[this.overrideGetBrightnessHooks.length - 1].getBrightness(var1);
      } else {
         var4 = this.player.localGetBrightness(var1);
      }

      if(this.afterGetBrightnessHooks != null) {
         for(int var3 = 0; var3 < this.afterGetBrightnessHooks.length; ++var3) {
            this.afterGetBrightnessHooks[var3].afterGetBrightness(var1);
         }
      }

      return var4;
   }

   protected ServerPlayerBase GetOverwrittenGetBrightness(ServerPlayerBase var1) {
      if(this.overrideGetBrightnessHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetBrightnessHooks.length; ++var2) {
            if(this.overrideGetBrightnessHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetBrightnessHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static float getEyeHeight(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      float var1;
      if(var2 != null && var2.isGetEyeHeightModded) {
         var1 = var2.getEyeHeight();
      } else {
         var1 = var0.localGetEyeHeight();
      }

      return var1;
   }

   private float getEyeHeight() {
      if(this.beforeGetEyeHeightHooks != null) {
         for(int var1 = this.beforeGetEyeHeightHooks.length - 1; var1 >= 0; --var1) {
            this.beforeGetEyeHeightHooks[var1].beforeGetEyeHeight();
         }
      }

      float var3;
      if(this.overrideGetEyeHeightHooks != null) {
         var3 = this.overrideGetEyeHeightHooks[this.overrideGetEyeHeightHooks.length - 1].getEyeHeight();
      } else {
         var3 = this.player.localGetEyeHeight();
      }

      if(this.afterGetEyeHeightHooks != null) {
         for(int var2 = 0; var2 < this.afterGetEyeHeightHooks.length; ++var2) {
            this.afterGetEyeHeightHooks[var2].afterGetEyeHeight();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenGetEyeHeight(ServerPlayerBase var1) {
      if(this.overrideGetEyeHeightHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideGetEyeHeightHooks.length; ++var2) {
            if(this.overrideGetEyeHeightHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideGetEyeHeightHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void heal(IServerPlayerAPI var0, float var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isHealModded) {
         var2.heal(var1);
      } else {
         var0.localHeal(var1);
      }

   }

   private void heal(float var1) {
      int var2;
      if(this.beforeHealHooks != null) {
         for(var2 = this.beforeHealHooks.length - 1; var2 >= 0; --var2) {
            this.beforeHealHooks[var2].beforeHeal(var1);
         }
      }

      if(this.overrideHealHooks != null) {
         this.overrideHealHooks[this.overrideHealHooks.length - 1].heal(var1);
      } else {
         this.player.localHeal(var1);
      }

      if(this.afterHealHooks != null) {
         for(var2 = 0; var2 < this.afterHealHooks.length; ++var2) {
            this.afterHealHooks[var2].afterHeal(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenHeal(ServerPlayerBase var1) {
      if(this.overrideHealHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideHealHooks.length; ++var2) {
            if(this.overrideHealHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideHealHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean isEntityInsideOpaqueBlock(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isIsEntityInsideOpaqueBlockModded) {
         var1 = var2.isEntityInsideOpaqueBlock();
      } else {
         var1 = var0.localIsEntityInsideOpaqueBlock();
      }

      return var1;
   }

   private boolean isEntityInsideOpaqueBlock() {
      if(this.beforeIsEntityInsideOpaqueBlockHooks != null) {
         for(int var1 = this.beforeIsEntityInsideOpaqueBlockHooks.length - 1; var1 >= 0; --var1) {
            this.beforeIsEntityInsideOpaqueBlockHooks[var1].beforeIsEntityInsideOpaqueBlock();
         }
      }

      boolean var3;
      if(this.overrideIsEntityInsideOpaqueBlockHooks != null) {
         var3 = this.overrideIsEntityInsideOpaqueBlockHooks[this.overrideIsEntityInsideOpaqueBlockHooks.length - 1].isEntityInsideOpaqueBlock();
      } else {
         var3 = this.player.localIsEntityInsideOpaqueBlock();
      }

      if(this.afterIsEntityInsideOpaqueBlockHooks != null) {
         for(int var2 = 0; var2 < this.afterIsEntityInsideOpaqueBlockHooks.length; ++var2) {
            this.afterIsEntityInsideOpaqueBlockHooks[var2].afterIsEntityInsideOpaqueBlock();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(ServerPlayerBase var1) {
      if(this.overrideIsEntityInsideOpaqueBlockHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideIsEntityInsideOpaqueBlockHooks.length; ++var2) {
            if(this.overrideIsEntityInsideOpaqueBlockHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideIsEntityInsideOpaqueBlockHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean isInWater(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isIsInWaterModded) {
         var1 = var2.isInWater();
      } else {
         var1 = var0.localIsInWater();
      }

      return var1;
   }

   private boolean isInWater() {
      if(this.beforeIsInWaterHooks != null) {
         for(int var1 = this.beforeIsInWaterHooks.length - 1; var1 >= 0; --var1) {
            this.beforeIsInWaterHooks[var1].beforeIsInWater();
         }
      }

      boolean var3;
      if(this.overrideIsInWaterHooks != null) {
         var3 = this.overrideIsInWaterHooks[this.overrideIsInWaterHooks.length - 1].isInWater();
      } else {
         var3 = this.player.localIsInWater();
      }

      if(this.afterIsInWaterHooks != null) {
         for(int var2 = 0; var2 < this.afterIsInWaterHooks.length; ++var2) {
            this.afterIsInWaterHooks[var2].afterIsInWater();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenIsInWater(ServerPlayerBase var1) {
      if(this.overrideIsInWaterHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideIsInWaterHooks.length; ++var2) {
            if(this.overrideIsInWaterHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideIsInWaterHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean isInsideOfMaterial(IServerPlayerAPI var0, Material var1) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      boolean var2;
      if(var3 != null && var3.isIsInsideOfMaterialModded) {
         var2 = var3.isInsideOfMaterial(var1);
      } else {
         var2 = var0.localIsInsideOfMaterial(var1);
      }

      return var2;
   }

   private boolean isInsideOfMaterial(Material var1) {
      if(this.beforeIsInsideOfMaterialHooks != null) {
         for(int var2 = this.beforeIsInsideOfMaterialHooks.length - 1; var2 >= 0; --var2) {
            this.beforeIsInsideOfMaterialHooks[var2].beforeIsInsideOfMaterial(var1);
         }
      }

      boolean var4;
      if(this.overrideIsInsideOfMaterialHooks != null) {
         var4 = this.overrideIsInsideOfMaterialHooks[this.overrideIsInsideOfMaterialHooks.length - 1].isInsideOfMaterial(var1);
      } else {
         var4 = this.player.localIsInsideOfMaterial(var1);
      }

      if(this.afterIsInsideOfMaterialHooks != null) {
         for(int var3 = 0; var3 < this.afterIsInsideOfMaterialHooks.length; ++var3) {
            this.afterIsInsideOfMaterialHooks[var3].afterIsInsideOfMaterial(var1);
         }
      }

      return var4;
   }

   protected ServerPlayerBase GetOverwrittenIsInsideOfMaterial(ServerPlayerBase var1) {
      if(this.overrideIsInsideOfMaterialHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideIsInsideOfMaterialHooks.length; ++var2) {
            if(this.overrideIsInsideOfMaterialHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideIsInsideOfMaterialHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean isOnLadder(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isIsOnLadderModded) {
         var1 = var2.isOnLadder();
      } else {
         var1 = var0.localIsOnLadder();
      }

      return var1;
   }

   private boolean isOnLadder() {
      if(this.beforeIsOnLadderHooks != null) {
         for(int var1 = this.beforeIsOnLadderHooks.length - 1; var1 >= 0; --var1) {
            this.beforeIsOnLadderHooks[var1].beforeIsOnLadder();
         }
      }

      boolean var3;
      if(this.overrideIsOnLadderHooks != null) {
         var3 = this.overrideIsOnLadderHooks[this.overrideIsOnLadderHooks.length - 1].isOnLadder();
      } else {
         var3 = this.player.localIsOnLadder();
      }

      if(this.afterIsOnLadderHooks != null) {
         for(int var2 = 0; var2 < this.afterIsOnLadderHooks.length; ++var2) {
            this.afterIsOnLadderHooks[var2].afterIsOnLadder();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenIsOnLadder(ServerPlayerBase var1) {
      if(this.overrideIsOnLadderHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideIsOnLadderHooks.length; ++var2) {
            if(this.overrideIsOnLadderHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideIsOnLadderHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean isPlayerSleeping(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isIsPlayerSleepingModded) {
         var1 = var2.isPlayerSleeping();
      } else {
         var1 = var0.localIsPlayerSleeping();
      }

      return var1;
   }

   private boolean isPlayerSleeping() {
      if(this.beforeIsPlayerSleepingHooks != null) {
         for(int var1 = this.beforeIsPlayerSleepingHooks.length - 1; var1 >= 0; --var1) {
            this.beforeIsPlayerSleepingHooks[var1].beforeIsPlayerSleeping();
         }
      }

      boolean var3;
      if(this.overrideIsPlayerSleepingHooks != null) {
         var3 = this.overrideIsPlayerSleepingHooks[this.overrideIsPlayerSleepingHooks.length - 1].isPlayerSleeping();
      } else {
         var3 = this.player.localIsPlayerSleeping();
      }

      if(this.afterIsPlayerSleepingHooks != null) {
         for(int var2 = 0; var2 < this.afterIsPlayerSleepingHooks.length; ++var2) {
            this.afterIsPlayerSleepingHooks[var2].afterIsPlayerSleeping();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenIsPlayerSleeping(ServerPlayerBase var1) {
      if(this.overrideIsPlayerSleepingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideIsPlayerSleepingHooks.length; ++var2) {
            if(this.overrideIsPlayerSleepingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideIsPlayerSleepingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static boolean isSneaking(IServerPlayerAPI var0) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      boolean var1;
      if(var2 != null && var2.isIsSneakingModded) {
         var1 = var2.isSneaking();
      } else {
         var1 = var0.localIsSneaking();
      }

      return var1;
   }

   private boolean isSneaking() {
      if(this.beforeIsSneakingHooks != null) {
         for(int var1 = this.beforeIsSneakingHooks.length - 1; var1 >= 0; --var1) {
            this.beforeIsSneakingHooks[var1].beforeIsSneaking();
         }
      }

      boolean var3;
      if(this.overrideIsSneakingHooks != null) {
         var3 = this.overrideIsSneakingHooks[this.overrideIsSneakingHooks.length - 1].isSneaking();
      } else {
         var3 = this.player.localIsSneaking();
      }

      if(this.afterIsSneakingHooks != null) {
         for(int var2 = 0; var2 < this.afterIsSneakingHooks.length; ++var2) {
            this.afterIsSneakingHooks[var2].afterIsSneaking();
         }
      }

      return var3;
   }

   protected ServerPlayerBase GetOverwrittenIsSneaking(ServerPlayerBase var1) {
      if(this.overrideIsSneakingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideIsSneakingHooks.length; ++var2) {
            if(this.overrideIsSneakingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideIsSneakingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void jump(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isJumpModded) {
         var1.jump();
      } else {
         var0.localJump();
      }

   }

   private void jump() {
      int var1;
      if(this.beforeJumpHooks != null) {
         for(var1 = this.beforeJumpHooks.length - 1; var1 >= 0; --var1) {
            this.beforeJumpHooks[var1].beforeJump();
         }
      }

      if(this.overrideJumpHooks != null) {
         this.overrideJumpHooks[this.overrideJumpHooks.length - 1].jump();
      } else {
         this.player.localJump();
      }

      if(this.afterJumpHooks != null) {
         for(var1 = 0; var1 < this.afterJumpHooks.length; ++var1) {
            this.afterJumpHooks[var1].afterJump();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenJump(ServerPlayerBase var1) {
      if(this.overrideJumpHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideJumpHooks.length; ++var2) {
            if(this.overrideJumpHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideJumpHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void knockBack(IServerPlayerAPI var0, Entity var1, float var2, double var3, double var5) {
      ServerPlayerAPI var7 = var0.getServerPlayerAPI();
      if(var7 != null && var7.isKnockBackModded) {
         var7.knockBack(var1, var2, var3, var5);
      } else {
         var0.localKnockBack(var1, var2, var3, var5);
      }

   }

   private void knockBack(Entity var1, float var2, double var3, double var5) {
      int var7;
      if(this.beforeKnockBackHooks != null) {
         for(var7 = this.beforeKnockBackHooks.length - 1; var7 >= 0; --var7) {
            this.beforeKnockBackHooks[var7].beforeKnockBack(var1, var2, var3, var5);
         }
      }

      if(this.overrideKnockBackHooks != null) {
         this.overrideKnockBackHooks[this.overrideKnockBackHooks.length - 1].knockBack(var1, var2, var3, var5);
      } else {
         this.player.localKnockBack(var1, var2, var3, var5);
      }

      if(this.afterKnockBackHooks != null) {
         for(var7 = 0; var7 < this.afterKnockBackHooks.length; ++var7) {
            this.afterKnockBackHooks[var7].afterKnockBack(var1, var2, var3, var5);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenKnockBack(ServerPlayerBase var1) {
      if(this.overrideKnockBackHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideKnockBackHooks.length; ++var2) {
            if(this.overrideKnockBackHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideKnockBackHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void mountEntity(IServerPlayerAPI var0, Entity var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isMountEntityModded) {
         var2.mountEntity(var1);
      } else {
         var0.localMountEntity(var1);
      }

   }

   private void mountEntity(Entity var1) {
      int var2;
      if(this.beforeMountEntityHooks != null) {
         for(var2 = this.beforeMountEntityHooks.length - 1; var2 >= 0; --var2) {
            this.beforeMountEntityHooks[var2].beforeMountEntity(var1);
         }
      }

      if(this.overrideMountEntityHooks != null) {
         this.overrideMountEntityHooks[this.overrideMountEntityHooks.length - 1].mountEntity(var1);
      } else {
         this.player.localMountEntity(var1);
      }

      if(this.afterMountEntityHooks != null) {
         for(var2 = 0; var2 < this.afterMountEntityHooks.length; ++var2) {
            this.afterMountEntityHooks[var2].afterMountEntity(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenMountEntity(ServerPlayerBase var1) {
      if(this.overrideMountEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideMountEntityHooks.length; ++var2) {
            if(this.overrideMountEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideMountEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void moveEntity(IServerPlayerAPI var0, double var1, double var3, double var5) {
      ServerPlayerAPI var7 = var0.getServerPlayerAPI();
      if(var7 != null && var7.isMoveEntityModded) {
         var7.moveEntity(var1, var3, var5);
      } else {
         var0.localMoveEntity(var1, var3, var5);
      }

   }

   private void moveEntity(double var1, double var3, double var5) {
      int var7;
      if(this.beforeMoveEntityHooks != null) {
         for(var7 = this.beforeMoveEntityHooks.length - 1; var7 >= 0; --var7) {
            this.beforeMoveEntityHooks[var7].beforeMoveEntity(var1, var3, var5);
         }
      }

      if(this.overrideMoveEntityHooks != null) {
         this.overrideMoveEntityHooks[this.overrideMoveEntityHooks.length - 1].moveEntity(var1, var3, var5);
      } else {
         this.player.localMoveEntity(var1, var3, var5);
      }

      if(this.afterMoveEntityHooks != null) {
         for(var7 = 0; var7 < this.afterMoveEntityHooks.length; ++var7) {
            this.afterMoveEntityHooks[var7].afterMoveEntity(var1, var3, var5);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenMoveEntity(ServerPlayerBase var1) {
      if(this.overrideMoveEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideMoveEntityHooks.length; ++var2) {
            if(this.overrideMoveEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideMoveEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void moveEntityWithHeading(IServerPlayerAPI var0, float var1, float var2) {
      ServerPlayerAPI var3 = var0.getServerPlayerAPI();
      if(var3 != null && var3.isMoveEntityWithHeadingModded) {
         var3.moveEntityWithHeading(var1, var2);
      } else {
         var0.localMoveEntityWithHeading(var1, var2);
      }

   }

   private void moveEntityWithHeading(float var1, float var2) {
      int var3;
      if(this.beforeMoveEntityWithHeadingHooks != null) {
         for(var3 = this.beforeMoveEntityWithHeadingHooks.length - 1; var3 >= 0; --var3) {
            this.beforeMoveEntityWithHeadingHooks[var3].beforeMoveEntityWithHeading(var1, var2);
         }
      }

      if(this.overrideMoveEntityWithHeadingHooks != null) {
         this.overrideMoveEntityWithHeadingHooks[this.overrideMoveEntityWithHeadingHooks.length - 1].moveEntityWithHeading(var1, var2);
      } else {
         this.player.localMoveEntityWithHeading(var1, var2);
      }

      if(this.afterMoveEntityWithHeadingHooks != null) {
         for(var3 = 0; var3 < this.afterMoveEntityWithHeadingHooks.length; ++var3) {
            this.afterMoveEntityWithHeadingHooks[var3].afterMoveEntityWithHeading(var1, var2);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenMoveEntityWithHeading(ServerPlayerBase var1) {
      if(this.overrideMoveEntityWithHeadingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideMoveEntityWithHeadingHooks.length; ++var2) {
            if(this.overrideMoveEntityWithHeadingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideMoveEntityWithHeadingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void moveFlying(IServerPlayerAPI var0, float var1, float var2, float var3) {
      ServerPlayerAPI var4 = var0.getServerPlayerAPI();
      if(var4 != null && var4.isMoveFlyingModded) {
         var4.moveFlying(var1, var2, var3);
      } else {
         var0.localMoveFlying(var1, var2, var3);
      }

   }

   private void moveFlying(float var1, float var2, float var3) {
      int var4;
      if(this.beforeMoveFlyingHooks != null) {
         for(var4 = this.beforeMoveFlyingHooks.length - 1; var4 >= 0; --var4) {
            this.beforeMoveFlyingHooks[var4].beforeMoveFlying(var1, var2, var3);
         }
      }

      if(this.overrideMoveFlyingHooks != null) {
         this.overrideMoveFlyingHooks[this.overrideMoveFlyingHooks.length - 1].moveFlying(var1, var2, var3);
      } else {
         this.player.localMoveFlying(var1, var2, var3);
      }

      if(this.afterMoveFlyingHooks != null) {
         for(var4 = 0; var4 < this.afterMoveFlyingHooks.length; ++var4) {
            this.afterMoveFlyingHooks[var4].afterMoveFlying(var1, var2, var3);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenMoveFlying(ServerPlayerBase var1) {
      if(this.overrideMoveFlyingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideMoveFlyingHooks.length; ++var2) {
            if(this.overrideMoveFlyingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideMoveFlyingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void onDeath(IServerPlayerAPI var0, DamageSource var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isOnDeathModded) {
         var2.onDeath(var1);
      } else {
         var0.localOnDeath(var1);
      }

   }

   private void onDeath(DamageSource var1) {
      int var2;
      if(this.beforeOnDeathHooks != null) {
         for(var2 = this.beforeOnDeathHooks.length - 1; var2 >= 0; --var2) {
            this.beforeOnDeathHooks[var2].beforeOnDeath(var1);
         }
      }

      if(this.overrideOnDeathHooks != null) {
         this.overrideOnDeathHooks[this.overrideOnDeathHooks.length - 1].onDeath(var1);
      } else {
         this.player.localOnDeath(var1);
      }

      if(this.afterOnDeathHooks != null) {
         for(var2 = 0; var2 < this.afterOnDeathHooks.length; ++var2) {
            this.afterOnDeathHooks[var2].afterOnDeath(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenOnDeath(ServerPlayerBase var1) {
      if(this.overrideOnDeathHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideOnDeathHooks.length; ++var2) {
            if(this.overrideOnDeathHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideOnDeathHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void onLivingUpdate(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isOnLivingUpdateModded) {
         var1.onLivingUpdate();
      } else {
         var0.localOnLivingUpdate();
      }

   }

   private void onLivingUpdate() {
      int var1;
      if(this.beforeOnLivingUpdateHooks != null) {
         for(var1 = this.beforeOnLivingUpdateHooks.length - 1; var1 >= 0; --var1) {
            this.beforeOnLivingUpdateHooks[var1].beforeOnLivingUpdate();
         }
      }

      if(this.overrideOnLivingUpdateHooks != null) {
         this.overrideOnLivingUpdateHooks[this.overrideOnLivingUpdateHooks.length - 1].onLivingUpdate();
      } else {
         this.player.localOnLivingUpdate();
      }

      if(this.afterOnLivingUpdateHooks != null) {
         for(var1 = 0; var1 < this.afterOnLivingUpdateHooks.length; ++var1) {
            this.afterOnLivingUpdateHooks[var1].afterOnLivingUpdate();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenOnLivingUpdate(ServerPlayerBase var1) {
      if(this.overrideOnLivingUpdateHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideOnLivingUpdateHooks.length; ++var2) {
            if(this.overrideOnLivingUpdateHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideOnLivingUpdateHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void onKillEntity(IServerPlayerAPI var0, EntityLivingBase var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isOnKillEntityModded) {
         var2.onKillEntity(var1);
      } else {
         var0.localOnKillEntity(var1);
      }

   }

   private void onKillEntity(EntityLivingBase var1) {
      int var2;
      if(this.beforeOnKillEntityHooks != null) {
         for(var2 = this.beforeOnKillEntityHooks.length - 1; var2 >= 0; --var2) {
            this.beforeOnKillEntityHooks[var2].beforeOnKillEntity(var1);
         }
      }

      if(this.overrideOnKillEntityHooks != null) {
         this.overrideOnKillEntityHooks[this.overrideOnKillEntityHooks.length - 1].onKillEntity(var1);
      } else {
         this.player.localOnKillEntity(var1);
      }

      if(this.afterOnKillEntityHooks != null) {
         for(var2 = 0; var2 < this.afterOnKillEntityHooks.length; ++var2) {
            this.afterOnKillEntityHooks[var2].afterOnKillEntity(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenOnKillEntity(ServerPlayerBase var1) {
      if(this.overrideOnKillEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideOnKillEntityHooks.length; ++var2) {
            if(this.overrideOnKillEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideOnKillEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void onStruckByLightning(IServerPlayerAPI var0, EntityLightningBolt var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isOnStruckByLightningModded) {
         var2.onStruckByLightning(var1);
      } else {
         var0.localOnStruckByLightning(var1);
      }

   }

   private void onStruckByLightning(EntityLightningBolt var1) {
      int var2;
      if(this.beforeOnStruckByLightningHooks != null) {
         for(var2 = this.beforeOnStruckByLightningHooks.length - 1; var2 >= 0; --var2) {
            this.beforeOnStruckByLightningHooks[var2].beforeOnStruckByLightning(var1);
         }
      }

      if(this.overrideOnStruckByLightningHooks != null) {
         this.overrideOnStruckByLightningHooks[this.overrideOnStruckByLightningHooks.length - 1].onStruckByLightning(var1);
      } else {
         this.player.localOnStruckByLightning(var1);
      }

      if(this.afterOnStruckByLightningHooks != null) {
         for(var2 = 0; var2 < this.afterOnStruckByLightningHooks.length; ++var2) {
            this.afterOnStruckByLightningHooks[var2].afterOnStruckByLightning(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenOnStruckByLightning(ServerPlayerBase var1) {
      if(this.overrideOnStruckByLightningHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideOnStruckByLightningHooks.length; ++var2) {
            if(this.overrideOnStruckByLightningHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideOnStruckByLightningHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void onUpdate(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isOnUpdateModded) {
         var1.onUpdate();
      } else {
         var0.localOnUpdate();
      }

   }

   private void onUpdate() {
      int var1;
      if(this.beforeOnUpdateHooks != null) {
         for(var1 = this.beforeOnUpdateHooks.length - 1; var1 >= 0; --var1) {
            this.beforeOnUpdateHooks[var1].beforeOnUpdate();
         }
      }

      if(this.overrideOnUpdateHooks != null) {
         this.overrideOnUpdateHooks[this.overrideOnUpdateHooks.length - 1].onUpdate();
      } else {
         this.player.localOnUpdate();
      }

      if(this.afterOnUpdateHooks != null) {
         for(var1 = 0; var1 < this.afterOnUpdateHooks.length; ++var1) {
            this.afterOnUpdateHooks[var1].afterOnUpdate();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenOnUpdate(ServerPlayerBase var1) {
      if(this.overrideOnUpdateHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideOnUpdateHooks.length; ++var2) {
            if(this.overrideOnUpdateHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideOnUpdateHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void onUpdateEntity(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isOnUpdateEntityModded) {
         var1.onUpdateEntity();
      } else {
         var0.localOnUpdateEntity();
      }

   }

   private void onUpdateEntity() {
      int var1;
      if(this.beforeOnUpdateEntityHooks != null) {
         for(var1 = this.beforeOnUpdateEntityHooks.length - 1; var1 >= 0; --var1) {
            this.beforeOnUpdateEntityHooks[var1].beforeOnUpdateEntity();
         }
      }

      if(this.overrideOnUpdateEntityHooks != null) {
         this.overrideOnUpdateEntityHooks[this.overrideOnUpdateEntityHooks.length - 1].onUpdateEntity();
      } else {
         this.player.localOnUpdateEntity();
      }

      if(this.afterOnUpdateEntityHooks != null) {
         for(var1 = 0; var1 < this.afterOnUpdateEntityHooks.length; ++var1) {
            this.afterOnUpdateEntityHooks[var1].afterOnUpdateEntity();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenOnUpdateEntity(ServerPlayerBase var1) {
      if(this.overrideOnUpdateEntityHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideOnUpdateEntityHooks.length; ++var2) {
            if(this.overrideOnUpdateEntityHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideOnUpdateEntityHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void readEntityFromNBT(IServerPlayerAPI var0, NBTTagCompound var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isReadEntityFromNBTModded) {
         var2.readEntityFromNBT(var1);
      } else {
         var0.localReadEntityFromNBT(var1);
      }

   }

   private void readEntityFromNBT(NBTTagCompound var1) {
      int var2;
      if(this.beforeReadEntityFromNBTHooks != null) {
         for(var2 = this.beforeReadEntityFromNBTHooks.length - 1; var2 >= 0; --var2) {
            this.beforeReadEntityFromNBTHooks[var2].beforeReadEntityFromNBT(var1);
         }
      }

      if(this.overrideReadEntityFromNBTHooks != null) {
         this.overrideReadEntityFromNBTHooks[this.overrideReadEntityFromNBTHooks.length - 1].readEntityFromNBT(var1);
      } else {
         this.player.localReadEntityFromNBT(var1);
      }

      if(this.afterReadEntityFromNBTHooks != null) {
         for(var2 = 0; var2 < this.afterReadEntityFromNBTHooks.length; ++var2) {
            this.afterReadEntityFromNBTHooks[var2].afterReadEntityFromNBT(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenReadEntityFromNBT(ServerPlayerBase var1) {
      if(this.overrideReadEntityFromNBTHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideReadEntityFromNBTHooks.length; ++var2) {
            if(this.overrideReadEntityFromNBTHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideReadEntityFromNBTHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setDead(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isSetDeadModded) {
         var1.setDead();
      } else {
         var0.localSetDead();
      }

   }

   private void setDead() {
      int var1;
      if(this.beforeSetDeadHooks != null) {
         for(var1 = this.beforeSetDeadHooks.length - 1; var1 >= 0; --var1) {
            this.beforeSetDeadHooks[var1].beforeSetDead();
         }
      }

      if(this.overrideSetDeadHooks != null) {
         this.overrideSetDeadHooks[this.overrideSetDeadHooks.length - 1].setDead();
      } else {
         this.player.localSetDead();
      }

      if(this.afterSetDeadHooks != null) {
         for(var1 = 0; var1 < this.afterSetDeadHooks.length; ++var1) {
            this.afterSetDeadHooks[var1].afterSetDead();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenSetDead(ServerPlayerBase var1) {
      if(this.overrideSetDeadHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetDeadHooks.length; ++var2) {
            if(this.overrideSetDeadHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetDeadHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setEntityActionState(IServerPlayerAPI var0, float var1, float var2, boolean var3, boolean var4) {
      ServerPlayerAPI var5 = var0.getServerPlayerAPI();
      if(var5 != null && var5.isSetEntityActionStateModded) {
         var5.setEntityActionState(var1, var2, var3, var4);
      } else {
         var0.localSetEntityActionState(var1, var2, var3, var4);
      }

   }

   private void setEntityActionState(float var1, float var2, boolean var3, boolean var4) {
      int var5;
      if(this.beforeSetEntityActionStateHooks != null) {
         for(var5 = this.beforeSetEntityActionStateHooks.length - 1; var5 >= 0; --var5) {
            this.beforeSetEntityActionStateHooks[var5].beforeSetEntityActionState(var1, var2, var3, var4);
         }
      }

      if(this.overrideSetEntityActionStateHooks != null) {
         this.overrideSetEntityActionStateHooks[this.overrideSetEntityActionStateHooks.length - 1].setEntityActionState(var1, var2, var3, var4);
      } else {
         this.player.localSetEntityActionState(var1, var2, var3, var4);
      }

      if(this.afterSetEntityActionStateHooks != null) {
         for(var5 = 0; var5 < this.afterSetEntityActionStateHooks.length; ++var5) {
            this.afterSetEntityActionStateHooks[var5].afterSetEntityActionState(var1, var2, var3, var4);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenSetEntityActionState(ServerPlayerBase var1) {
      if(this.overrideSetEntityActionStateHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetEntityActionStateHooks.length; ++var2) {
            if(this.overrideSetEntityActionStateHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetEntityActionStateHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setPosition(IServerPlayerAPI var0, double var1, double var3, double var5) {
      ServerPlayerAPI var7 = var0.getServerPlayerAPI();
      if(var7 != null && var7.isSetPositionModded) {
         var7.setPosition(var1, var3, var5);
      } else {
         var0.localSetPosition(var1, var3, var5);
      }

   }

   private void setPosition(double var1, double var3, double var5) {
      int var7;
      if(this.beforeSetPositionHooks != null) {
         for(var7 = this.beforeSetPositionHooks.length - 1; var7 >= 0; --var7) {
            this.beforeSetPositionHooks[var7].beforeSetPosition(var1, var3, var5);
         }
      }

      if(this.overrideSetPositionHooks != null) {
         this.overrideSetPositionHooks[this.overrideSetPositionHooks.length - 1].setPosition(var1, var3, var5);
      } else {
         this.player.localSetPosition(var1, var3, var5);
      }

      if(this.afterSetPositionHooks != null) {
         for(var7 = 0; var7 < this.afterSetPositionHooks.length; ++var7) {
            this.afterSetPositionHooks[var7].afterSetPosition(var1, var3, var5);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenSetPosition(ServerPlayerBase var1) {
      if(this.overrideSetPositionHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetPositionHooks.length; ++var2) {
            if(this.overrideSetPositionHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetPositionHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setSneaking(IServerPlayerAPI var0, boolean var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isSetSneakingModded) {
         var2.setSneaking(var1);
      } else {
         var0.localSetSneaking(var1);
      }

   }

   private void setSneaking(boolean var1) {
      int var2;
      if(this.beforeSetSneakingHooks != null) {
         for(var2 = this.beforeSetSneakingHooks.length - 1; var2 >= 0; --var2) {
            this.beforeSetSneakingHooks[var2].beforeSetSneaking(var1);
         }
      }

      if(this.overrideSetSneakingHooks != null) {
         this.overrideSetSneakingHooks[this.overrideSetSneakingHooks.length - 1].setSneaking(var1);
      } else {
         this.player.localSetSneaking(var1);
      }

      if(this.afterSetSneakingHooks != null) {
         for(var2 = 0; var2 < this.afterSetSneakingHooks.length; ++var2) {
            this.afterSetSneakingHooks[var2].afterSetSneaking(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenSetSneaking(ServerPlayerBase var1) {
      if(this.overrideSetSneakingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetSneakingHooks.length; ++var2) {
            if(this.overrideSetSneakingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetSneakingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void setSprinting(IServerPlayerAPI var0, boolean var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isSetSprintingModded) {
         var2.setSprinting(var1);
      } else {
         var0.localSetSprinting(var1);
      }

   }

   private void setSprinting(boolean var1) {
      int var2;
      if(this.beforeSetSprintingHooks != null) {
         for(var2 = this.beforeSetSprintingHooks.length - 1; var2 >= 0; --var2) {
            this.beforeSetSprintingHooks[var2].beforeSetSprinting(var1);
         }
      }

      if(this.overrideSetSprintingHooks != null) {
         this.overrideSetSprintingHooks[this.overrideSetSprintingHooks.length - 1].setSprinting(var1);
      } else {
         this.player.localSetSprinting(var1);
      }

      if(this.afterSetSprintingHooks != null) {
         for(var2 = 0; var2 < this.afterSetSprintingHooks.length; ++var2) {
            this.afterSetSprintingHooks[var2].afterSetSprinting(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenSetSprinting(ServerPlayerBase var1) {
      if(this.overrideSetSprintingHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSetSprintingHooks.length; ++var2) {
            if(this.overrideSetSprintingHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSetSprintingHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void swingItem(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isSwingItemModded) {
         var1.swingItem();
      } else {
         var0.localSwingItem();
      }

   }

   private void swingItem() {
      int var1;
      if(this.beforeSwingItemHooks != null) {
         for(var1 = this.beforeSwingItemHooks.length - 1; var1 >= 0; --var1) {
            this.beforeSwingItemHooks[var1].beforeSwingItem();
         }
      }

      if(this.overrideSwingItemHooks != null) {
         this.overrideSwingItemHooks[this.overrideSwingItemHooks.length - 1].swingItem();
      } else {
         this.player.localSwingItem();
      }

      if(this.afterSwingItemHooks != null) {
         for(var1 = 0; var1 < this.afterSwingItemHooks.length; ++var1) {
            this.afterSwingItemHooks[var1].afterSwingItem();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenSwingItem(ServerPlayerBase var1) {
      if(this.overrideSwingItemHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideSwingItemHooks.length; ++var2) {
            if(this.overrideSwingItemHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideSwingItemHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void updateEntityActionState(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isUpdateEntityActionStateModded) {
         var1.updateEntityActionState();
      } else {
         var0.localUpdateEntityActionState();
      }

   }

   private void updateEntityActionState() {
      int var1;
      if(this.beforeUpdateEntityActionStateHooks != null) {
         for(var1 = this.beforeUpdateEntityActionStateHooks.length - 1; var1 >= 0; --var1) {
            this.beforeUpdateEntityActionStateHooks[var1].beforeUpdateEntityActionState();
         }
      }

      if(this.overrideUpdateEntityActionStateHooks != null) {
         this.overrideUpdateEntityActionStateHooks[this.overrideUpdateEntityActionStateHooks.length - 1].updateEntityActionState();
      } else {
         this.player.localUpdateEntityActionState();
      }

      if(this.afterUpdateEntityActionStateHooks != null) {
         for(var1 = 0; var1 < this.afterUpdateEntityActionStateHooks.length; ++var1) {
            this.afterUpdateEntityActionStateHooks[var1].afterUpdateEntityActionState();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenUpdateEntityActionState(ServerPlayerBase var1) {
      if(this.overrideUpdateEntityActionStateHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideUpdateEntityActionStateHooks.length; ++var2) {
            if(this.overrideUpdateEntityActionStateHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideUpdateEntityActionStateHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void updatePotionEffects(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isUpdatePotionEffectsModded) {
         var1.updatePotionEffects();
      } else {
         var0.localUpdatePotionEffects();
      }

   }

   private void updatePotionEffects() {
      int var1;
      if(this.beforeUpdatePotionEffectsHooks != null) {
         for(var1 = this.beforeUpdatePotionEffectsHooks.length - 1; var1 >= 0; --var1) {
            this.beforeUpdatePotionEffectsHooks[var1].beforeUpdatePotionEffects();
         }
      }

      if(this.overrideUpdatePotionEffectsHooks != null) {
         this.overrideUpdatePotionEffectsHooks[this.overrideUpdatePotionEffectsHooks.length - 1].updatePotionEffects();
      } else {
         this.player.localUpdatePotionEffects();
      }

      if(this.afterUpdatePotionEffectsHooks != null) {
         for(var1 = 0; var1 < this.afterUpdatePotionEffectsHooks.length; ++var1) {
            this.afterUpdatePotionEffectsHooks[var1].afterUpdatePotionEffects();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenUpdatePotionEffects(ServerPlayerBase var1) {
      if(this.overrideUpdatePotionEffectsHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideUpdatePotionEffectsHooks.length; ++var2) {
            if(this.overrideUpdatePotionEffectsHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideUpdatePotionEffectsHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void updateRidden(IServerPlayerAPI var0) {
      ServerPlayerAPI var1 = var0.getServerPlayerAPI();
      if(var1 != null && var1.isUpdateRiddenModded) {
         var1.updateRidden();
      } else {
         var0.localUpdateRidden();
      }

   }

   private void updateRidden() {
      int var1;
      if(this.beforeUpdateRiddenHooks != null) {
         for(var1 = this.beforeUpdateRiddenHooks.length - 1; var1 >= 0; --var1) {
            this.beforeUpdateRiddenHooks[var1].beforeUpdateRidden();
         }
      }

      if(this.overrideUpdateRiddenHooks != null) {
         this.overrideUpdateRiddenHooks[this.overrideUpdateRiddenHooks.length - 1].updateRidden();
      } else {
         this.player.localUpdateRidden();
      }

      if(this.afterUpdateRiddenHooks != null) {
         for(var1 = 0; var1 < this.afterUpdateRiddenHooks.length; ++var1) {
            this.afterUpdateRiddenHooks[var1].afterUpdateRidden();
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenUpdateRidden(ServerPlayerBase var1) {
      if(this.overrideUpdateRiddenHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideUpdateRiddenHooks.length; ++var2) {
            if(this.overrideUpdateRiddenHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideUpdateRiddenHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void wakeUpPlayer(IServerPlayerAPI var0, boolean var1, boolean var2, boolean var3) {
      ServerPlayerAPI var4 = var0.getServerPlayerAPI();
      if(var4 != null && var4.isWakeUpPlayerModded) {
         var4.wakeUpPlayer(var1, var2, var3);
      } else {
         var0.localWakeUpPlayer(var1, var2, var3);
      }

   }

   private void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
      int var4;
      if(this.beforeWakeUpPlayerHooks != null) {
         for(var4 = this.beforeWakeUpPlayerHooks.length - 1; var4 >= 0; --var4) {
            this.beforeWakeUpPlayerHooks[var4].beforeWakeUpPlayer(var1, var2, var3);
         }
      }

      if(this.overrideWakeUpPlayerHooks != null) {
         this.overrideWakeUpPlayerHooks[this.overrideWakeUpPlayerHooks.length - 1].wakeUpPlayer(var1, var2, var3);
      } else {
         this.player.localWakeUpPlayer(var1, var2, var3);
      }

      if(this.afterWakeUpPlayerHooks != null) {
         for(var4 = 0; var4 < this.afterWakeUpPlayerHooks.length; ++var4) {
            this.afterWakeUpPlayerHooks[var4].afterWakeUpPlayer(var1, var2, var3);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenWakeUpPlayer(ServerPlayerBase var1) {
      if(this.overrideWakeUpPlayerHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideWakeUpPlayerHooks.length; ++var2) {
            if(this.overrideWakeUpPlayerHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideWakeUpPlayerHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

   public static void writeEntityToNBT(IServerPlayerAPI var0, NBTTagCompound var1) {
      ServerPlayerAPI var2 = var0.getServerPlayerAPI();
      if(var2 != null && var2.isWriteEntityToNBTModded) {
         var2.writeEntityToNBT(var1);
      } else {
         var0.localWriteEntityToNBT(var1);
      }

   }

   private void writeEntityToNBT(NBTTagCompound var1) {
      int var2;
      if(this.beforeWriteEntityToNBTHooks != null) {
         for(var2 = this.beforeWriteEntityToNBTHooks.length - 1; var2 >= 0; --var2) {
            this.beforeWriteEntityToNBTHooks[var2].beforeWriteEntityToNBT(var1);
         }
      }

      if(this.overrideWriteEntityToNBTHooks != null) {
         this.overrideWriteEntityToNBTHooks[this.overrideWriteEntityToNBTHooks.length - 1].writeEntityToNBT(var1);
      } else {
         this.player.localWriteEntityToNBT(var1);
      }

      if(this.afterWriteEntityToNBTHooks != null) {
         for(var2 = 0; var2 < this.afterWriteEntityToNBTHooks.length; ++var2) {
            this.afterWriteEntityToNBTHooks[var2].afterWriteEntityToNBT(var1);
         }
      }

   }

   protected ServerPlayerBase GetOverwrittenWriteEntityToNBT(ServerPlayerBase var1) {
      if(this.overrideWriteEntityToNBTHooks == null) {
         return var1;
      } else {
         for(int var2 = 0; var2 < this.overrideWriteEntityToNBTHooks.length; ++var2) {
            if(this.overrideWriteEntityToNBTHooks[var2] == var1) {
               if(var2 == 0) {
                  return null;
               }

               return this.overrideWriteEntityToNBTHooks[var2 - 1];
            }
         }

         return var1;
      }
   }

}
