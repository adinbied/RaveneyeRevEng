package dji.sdksharedlib.hardware.abstractions.flightcontroller.flightassistant;

import dji.common.mission.activetrack.ActiveTrackMode;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.DJISubComponentHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.merge.MergeGetFlycParamInfo;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.merge.MergeGetNewFlyParamInfo;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public abstract class IntelligentFlightAssistantAbstraction
  extends DJISubComponentHWAbstraction
{
  protected MergeGetFlycParamInfo mergeGetFlycParamInfo;
  protected MergeGetNewFlyParamInfo newMergeGetFlycParamInfo;
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("ActiveBackwardFlyingEnabled")
  public abstract void getActiveTrackBackwardFlyingEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("ActiveTrackGPSAssistantEnabled")
  public abstract void getActiveTrackGPSAssistantEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("ActiveTrackGestureModeEnabled")
  public abstract void getActiveTrackGestureModeEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("ActiveTrackMode")
  public abstract void getActiveTrackMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("ActiveTrackCircularSpeed")
  public abstract void getCircularSpeed(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("CollisionAvoidanceEnabled")
  public abstract void getCollisionAvoidanceEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("RoofAvoidance")
  public abstract void getRoofAvoidanceEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("VisionPositioningEnabled")
  public abstract void getVisionPositioningEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  public void init(String paramString1, int paramInt1, String paramString2, int paramInt2, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString1, paramInt1, paramString2, paramInt2, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    this.mergeGetFlycParamInfo = MergeGetFlycParamInfo.getInstance();
    this.newMergeGetFlycParamInfo = MergeGetNewFlyParamInfo.getInstance();
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("ActiveBackwardFlyingEnabled")
  public abstract void setActiveTrackBackwardFlyingEnabled(Boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("ActiveTrackGPSAssistantEnabled")
  public abstract void setActiveTrackGPSAssistantEnabled(Boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("ActiveTrackGestureModeEnabled")
  public abstract void setActiveTrackGestureModeEnabled(Boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("ActiveTrackMode")
  public abstract void setActiveTrackMode(ActiveTrackMode paramActiveTrackMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("ActiveTrackCircularSpeed")
  public abstract void setCircularSpeed(Float paramFloat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("CollisionAvoidanceEnabled")
  public abstract void setCollisionAdvanceEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("RoofAvoidance")
  public abstract void setRoofAvoidanceEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("VisionPositioningEnabled")
  public abstract void setVisionPositioningEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\flightassistant\IntelligentFlightAssistantAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */