package dji.internal.mission.abstraction.tapfly;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.common.error.DJIError;
import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.mission.tapfly.TapFlyExecutionState;
import dji.common.mission.tapfly.TapFlyExecutionState.Builder;
import dji.common.mission.tapfly.TapFlyMission;
import dji.common.mission.tapfly.TapFlyMode;
import dji.common.product.Model;
import dji.common.util.CallbackUtils;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.common.util.CommonCallbacks.CompletionCallbackWith;
import dji.internal.mission.abstraction.BaseMissionAbstraction;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataEyeGetPushException;
import dji.midware.data.model.P3.DataEyeGetPushPointState;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;
import dji.midware.data.model.P3.DataSingleSetPointPos.TapMode;
import dji.midware.data.model.P3.DataSingleVisualParam;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.listener.DJISetCallback;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class TapFlyAbstraction
  extends BaseMissionAbstraction
  implements DJIParamAccessListener
{
  private static final int HORIZONTAL_OBSTACLE_AVOIDANCE = 1;
  private static final Model[] MODELS_WITH_TAP_FLY_ABILITY = { Model.PHANTOM_4, Model.MAVIC_PRO, Model.PHANTOM_4_PRO, Model.INSPIRE_2 };
  private static final Model[] MODELS_WITH_TAP_FLY_MODE_ABILITY = { Model.PHANTOM_4_PRO, Model.INSPIRE_2 };
  private static final int START_TAP_FLY = 2;
  private static final String STR_CFG_BRAKE = "g_config.avoid_obstacle_limit_cfg.avoid_obstacle_enable_0";
  private static final String STR_CFG_BRAKE_USER = "g_config.avoid_obstacle_limit_cfg.user_avoid_enable_0";
  private static final int TAP_FLY_SPEED = 0;
  private DataOsdGetPushCommon.RcModeChannel cacheRcModeChannel;
  private TapFlyMission cacheTapFlyMission;
  private Handler handler = new Handler(BackgroundLooper.getLooper(), this.handlerCallback);
  private Handler.Callback handlerCallback = new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  };
  private TapFlyMode mode;
  private DJIError persistentError;
  private int pointSequence = 0;
  private TapFlyExecutionState.Builder progressStateBuilder;
  private int sessionId = -1;
  
  public TapFlyAbstraction()
  {
    resetCacheData();
    this.progressStateBuilder = new TapFlyExecutionState.Builder();
    startListening();
    tryRecoverState();
  }
  
  /* Error */
  private void cloneTapFlyMission(TapFlyMission arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private MissionState computeFSMState()
  {
    return null;
  }
  
  private TapFlyExecutionState createExecuteState(DataEyeGetPushPointState paramDataEyeGetPushPointState)
  {
    return null;
  }
  
  private boolean doesExceptionPackContainError(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return getDJIError(paramDataEyeGetPushException) != null;
  }
  
  private boolean doesPointStatePackContainError()
  {
    return false;
  }
  
  private boolean environmentConditionCheck(CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    return false;
  }
  
  private int generateTapFlySequence(int paramInt)
  {
    return 0;
  }
  
  private DJIError getDJIError(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return null;
  }
  
  private DJIError getError(DataEyeGetPushPointState paramDataEyeGetPushPointState)
  {
    return null;
  }
  
  private TapFlyMode getModeFromProtocolToSDK(DataSingleSetPointPos.TapMode paramTapMode)
  {
    return null;
  }
  
  private MissionState getState(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return null;
  }
  
  private MissionState getState(DataEyeGetPushPointState paramDataEyeGetPushPointState)
  {
    return null;
  }
  
  /* Error */
  private void handleNavigation(boolean arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean isExceptionStateValid()
  {
    return false;
  }
  
  private boolean isInTapFlyingState(MissionState paramMissionState)
  {
    return false;
  }
  
  private boolean isPointStatePackValid()
  {
    return false;
  }
  
  private boolean isTapFlyModeSupported()
  {
    return false;
  }
  
  private boolean isTapFlySupported()
  {
    return false;
  }
  
  private boolean isTapFlying(DataEyeGetPushException paramDataEyeGetPushException)
  {
    return paramDataEyeGetPushException.isInTapFly();
  }
  
  private float normalize(float paramFloat)
  {
    return 0.0F;
  }
  
  private Message obtainMessage(int paramInt, CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    return Message.obtain(this.handler, paramInt, paramCompletionCallback);
  }
  
  private void resetCacheData()
  {
    this.cacheTapFlyMission = null;
    this.cacheRcModeChannel = null;
  }
  
  /* Error */
  private void specialStop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startListening()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopListening()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private float[] switchSpace(float paramFloat1, float paramFloat2)
  {
    return null;
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
  
  protected FiniteStateMachine buildFSM()
  {
    return null;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getAutoFlightSpeed(CommonCallbacks.CompletionCallbackWith<Float> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getHorizontalObstacleBypassEnabled(CommonCallbacks.CompletionCallbackWith<Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isInTapFlyingState()
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
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEyeGetPushException arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEyeGetPushPointState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if ((paramDJISDKCacheKey != null) && (paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null))
    {
      if (paramDJISDKCacheKey.getParamKey() == "ModelName") {
        tryRecoverState();
      }
    }
    else
    {
      transitToState(MissionState.DISCONNECTED, MissionEvent.DISCONNECTED);
      resetCacheData();
    }
  }
  
  /* Error */
  public void resetHeading(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setAutoFlightSpeed(float arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setHorizontalObstacleBypassEnabled(boolean arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setupEnvironment(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startMission(TapFlyMission arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopMission(CommonCallbacks.CompletionCallback arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\tapfly\TapFlyAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */