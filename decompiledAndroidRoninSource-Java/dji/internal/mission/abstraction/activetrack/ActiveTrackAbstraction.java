package dji.internal.mission.abstraction.activetrack;

import dji.common.error.DJIError;
import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.mission.activetrack.ActiveTrackCannotConfirmReason;
import dji.common.mission.activetrack.ActiveTrackMode;
import dji.common.mission.activetrack.ActiveTrackState;
import dji.common.mission.activetrack.ActiveTrackTargetState;
import dji.common.mission.activetrack.ActiveTrackTargetType;
import dji.common.mission.activetrack.ActiveTrackTrackingState;
import dji.common.product.Model;
import dji.common.util.CallbackUtils;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.internal.mission.abstraction.BaseMissionAbstraction;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.data.model.P3.DataEyeGetPushException;
import dji.midware.data.model.P3.DataEyeGetPushException.TrackExceptionStatus;
import dji.midware.data.model.P3.DataEyeGetPushTrackStatus;
import dji.midware.data.model.P3.DataEyeGetPushTrackStatus.TargetObjType;
import dji.midware.data.model.P3.DataEyeGetPushTrackStatus.TrackException;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.midware.data.model.P3.DataSingleVisualParam.TrackingMode;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.listener.DJISetCallback;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ActiveTrackAbstraction
  extends BaseMissionAbstraction
  implements DJIParamAccessListener
{
  private static final int ACTIVE_TRACK_EVENT_PLACE_HOLDER = -1;
  private static final Model[] AIRCRAFT_WITH_ACTIVE_TRACK_ABILITY = { Model.PHANTOM_4, Model.MAVIC_PRO, Model.PHANTOM_4_PRO, Model.INSPIRE_2 };
  private ActiveTrackState currentState;
  private boolean isGestureModeEnabled;
  private ActiveTrackMode mode;
  private DJIError persistentError;
  private int sequency = 0;
  private int trackingSequency = 0;
  
  public ActiveTrackAbstraction()
  {
    startListen();
    tryRecoverState();
  }
  
  private ActiveTrackMode activeTrackModeForPackCommandType(DataSingleVisualParam.TrackingMode paramTrackingMode)
  {
    return null;
  }
  
  private MissionState computeCurrentState()
  {
    return null;
  }
  
  private DJIError getDJIError(DataEyeGetPushException.TrackExceptionStatus paramTrackExceptionStatus)
  {
    return null;
  }
  
  private DJIError getDJIError(DataEyeGetPushTrackStatus paramDataEyeGetPushTrackStatus)
  {
    return null;
  }
  
  private MissionState getExecutingState(DataEyeGetPushTrackStatus paramDataEyeGetPushTrackStatus)
  {
    return null;
  }
  
  private MissionState getLatestState(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return null;
  }
  
  private MissionState getLatestState(DataEyeGetPushTrackStatus paramDataEyeGetPushTrackStatus)
  {
    return null;
  }
  
  private ActiveTrackCannotConfirmReason getReason(DataEyeGetPushTrackStatus.TrackException paramTrackException)
  {
    return null;
  }
  
  private ActiveTrackTargetState getTargetState(DataEyeGetPushTrackStatus paramDataEyeGetPushTrackStatus)
  {
    return null;
  }
  
  private ActiveTrackTargetType getTargetType(DataEyeGetPushTrackStatus.TargetObjType paramTargetObjType)
  {
    return null;
  }
  
  private ActiveTrackTrackingState getTrackingState(DataEyeGetPushTrackStatus paramDataEyeGetPushTrackStatus)
  {
    return null;
  }
  
  private boolean isActiveTrackSupported()
  {
    return false;
  }
  
  private boolean isCriticalException(DataEyeGetPushTrackStatus.TrackException paramTrackException)
  {
    return false;
  }
  
  private boolean isExitingExceptionConde(DataEyeGetPushException.TrackExceptionStatus paramTrackExceptionStatus)
  {
    return false;
  }
  
  private boolean isInTrackingState(MissionState paramMissionState)
  {
    return false;
  }
  
  private boolean isRectDimissionValid(DataEyeGetPushTrackStatus paramDataEyeGetPushTrackStatus)
  {
    return false;
  }
  
  private boolean isRunningTrackingMission()
  {
    return false;
  }
  
  private boolean isTracking(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return false;
  }
  
  private boolean isTrackingRectDataValid()
  {
    return false;
  }
  
  private boolean isWarningStatusValid()
  {
    return false;
  }
  
  private DataSingleVisualParam.TrackingMode packCommandTypeForActiveTrackMode(ActiveTrackMode paramActiveTrackMode)
  {
    return null;
  }
  
  private void reset() {}
  
  /* Error */
  private void startListen()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopListen()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void tryRecoverState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateGestureModeEnabled()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateMode(MissionState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updatePersistentError(MissionState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void acceptConfirmation(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected FiniteStateMachine buildFSM()
  {
    return null;
  }
  
  protected DataSingleVisualParam.TrackingMode convertModeToTrackingMode(ActiveTrackMode paramActiveTrackMode)
  {
    return null;
  }
  
  public void destroy()
  {
    stopListen();
  }
  
  /* Error */
  public void getCircularSpeed(dji.common.util.CommonCallbacks.CompletionCallbackWith<Float> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getRetreatEnabled(dji.common.util.CommonCallbacks.CompletionCallbackWith<Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ActiveTrackMode getTrackingMode()
  {
    return null;
  }
  
  public boolean isGestureModeEnabled(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return paramDataEyeGetPushException.isMovingObjectDetectEnable();
  }
  
  public boolean isInTrackingState()
  {
    return false;
  }
  
  /* Error */
  protected void notifyListener(dji.internal.mission.abstraction.AbstractionDataHolder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEyeGetPushException arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEyeGetPushTrackStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushCommon paramDataOsdGetPushCommon)
  {
    onEvent3BackgroundThread(DataEyeGetPushException.getInstance());
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if ((paramDJISDKCacheKey != null) && (paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null)) {
      paramDJISDKCacheKey.getParamKey();
    }
  }
  
  /* Error */
  public void rejectConfirmation(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCircularSpeed(float arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setGestureModeEnabled(boolean arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRecommendedConfiguration(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRetreatEnabled(boolean arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startTracking(dji.common.mission.activetrack.ActiveTrackMission arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopAircraftFollowing(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopTracking(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void switchMode(ActiveTrackMode arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean transitToState(MissionState paramMissionState, MissionEvent paramMissionEvent)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\activetrack\ActiveTrackAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */