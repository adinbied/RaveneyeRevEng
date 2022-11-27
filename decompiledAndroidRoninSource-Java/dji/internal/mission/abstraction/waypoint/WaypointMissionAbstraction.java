package dji.internal.mission.abstraction.waypoint;

import dji.common.error.DJIError;
import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.mission.waypoint.WaypointEvent;
import dji.common.mission.waypoint.WaypointExecutionProgress;
import dji.common.mission.waypoint.WaypointMission.Builder;
import dji.common.util.CallbackUtils;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.internal.mission.abstraction.BaseMissionAbstraction;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataFlycDownloadWayPointMissionMsg;
import dji.midware.data.model.P3.DataFlycDownloadWayPointMsgByIndex;
import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;
import dji.midware.data.model.P3.DataFlycUploadWayPointMsgByIndex;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import java.util.concurrent.atomic.AtomicBoolean;

public class WaypointMissionAbstraction
  extends BaseMissionAbstraction
{
  private static final boolean DEBUG = true;
  private static final int EXECUTE_FINISHED = 1;
  private static final int NONE_MISSION_TYPE = 0;
  private static final int REACHED = 2;
  private static final String TAG = "WaypointMission";
  private static final int UPLOADED = 0;
  private static final String WAYPOINT_EVENT = "WaypointEvent";
  private static final String WAYPOINT_INFO = "WaypointInfo";
  private static final int WAYPOINT_TYPE = 1;
  private WaypointAbstractionCacheData cacheData = new WaypointAbstractionCacheData();
  private boolean canSetupEnvironementParams;
  private MissionState candidateState;
  private DJIParamAccessListener connectionListener = new DJIParamAccessListener()
  {
    public void onValueChange(DJISDKCacheKey paramAnonymousDJISDKCacheKey, DJISDKCacheParamValue paramAnonymousDJISDKCacheParamValue1, DJISDKCacheParamValue paramAnonymousDJISDKCacheParamValue2)
    {
      if ((paramAnonymousDJISDKCacheKey != null) && (paramAnonymousDJISDKCacheKey.getParamKey().equals("ModelName")))
      {
        if ((paramAnonymousDJISDKCacheParamValue2 != null) && (paramAnonymousDJISDKCacheParamValue2.getData() != null))
        {
          WaypointMissionAbstraction.this.tryResumeFSMIfNecessary();
          return;
        }
        WaypointMissionAbstraction.this.reset();
        WaypointMissionAbstraction.this.transitToState(MissionState.DISCONNECTED, WaypointEvent.DISCONNECTED);
      }
    }
  };
  private AtomicBoolean isDownloading = new AtomicBoolean();
  private AtomicBoolean isRecovering = new AtomicBoolean();
  
  public WaypointMissionAbstraction()
  {
    reset();
    tryResumeFSMIfNecessary();
    startListen();
    refreshEventBusInformation();
  }
  
  private DJIError canDownloadMission()
  {
    return null;
  }
  
  private MissionState computeCurrentState()
  {
    return null;
  }
  
  private DJIError getCurrentError()
  {
    return null;
  }
  
  private MissionEvent getEventFromMissionStatus(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    return null;
  }
  
  private MissionState getStateFromMissionStatus(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    return null;
  }
  
  private boolean isInCorrectRCMode()
  {
    return false;
  }
  
  /* Error */
  private void printEventLog(dji.midware.data.model.P3.DataFlycGetPushWayPointMissionCurrentEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void printInfoLog(DataFlycGetPushWayPointMissionInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void recoverMission()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void recursiveDownloadSingleWaypoint(WaypointMission.Builder arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void refreshEventBusInformation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startListen()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void triggerDownloadEvent(WaypointMission.Builder arg1, DJIError arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean tryTransitToUploadState(int paramInt, DJIError paramDJIError, WaypointMission.Builder paramBuilder, boolean paramBoolean)
  {
    return false;
  }
  
  protected FiniteStateMachine buildFSM()
  {
    return null;
  }
  
  public DJIError canDownloadMission(MissionState paramMissionState)
  {
    return null;
  }
  
  public boolean canSetupEnvironementParams()
  {
    return this.canSetupEnvironementParams;
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
  public void downloadMission(WaypointMission.Builder arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void downloadMissionSummary(WaypointMission.Builder arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void downloadNextWaypoint(WaypointMission.Builder arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public WaypointAbstractionCacheData getCacheData()
  {
    return this.cacheData;
  }
  
  public WaypointExecutionProgress getExecutionProgress(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    return null;
  }
  
  /* Error */
  public void notifyListener(dji.internal.mission.abstraction.AbstractionDataHolder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushWayPointMissionCurrentEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataFlycGetPushWayPointMissionInfo arg1)
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
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushHome arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void pauseMission(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void recursiveUploadSingleWaypoint(WaypointMission.Builder arg1, int arg2, CommonCallbacks.CompletionCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resumeMission(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void retryUpload(CommonCallbacks.CompletionCallback arg1)
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
  public void setupEnvironment(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startMission(CommonCallbacks.CompletionCallback arg1)
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
  
  /* Error */
  public void tryResumeFSMIfNecessary()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateSetupEnvironmentParams()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void upload(WaypointMission.Builder arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void uploadWaypoint(WaypointMission.Builder arg1, int arg2, CommonCallbacks.CompletionCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void uploadWaypointSummary(WaypointMission.Builder arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\waypoint\WaypointMissionAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */