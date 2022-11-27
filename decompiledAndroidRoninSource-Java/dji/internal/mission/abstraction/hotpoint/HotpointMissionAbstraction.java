package dji.internal.mission.abstraction.hotpoint;

import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.mission.hotpoint.HotpointMission;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.internal.mission.abstraction.BaseMissionAbstraction;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;
import dji.midware.data.model.P3.DataFlycHotPointMissionDownload;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.listener.DJIParamAccessListener;

public class HotpointMissionAbstraction
  extends BaseMissionAbstraction
{
  private static final int HOTPOINT_TYPE = 2;
  private static final int INITIALIZING = 0;
  private static final int MOVING = 1;
  private static final int NO_MISSION = 0;
  private static final int PAUSED = 2;
  private HotpointAbstractionCacheData cacheData = new HotpointAbstractionCacheData();
  private MissionState candidateState;
  private DJIParamAccessListener connectionListener = new -..Lambda.HotpointMissionAbstraction.PhwcnrZb-EylXZ9vUhj3u3Y-EeU(this);
  private boolean isDownloading;
  private boolean isRecovering;
  private boolean isSpeedUpdating;
  private int previousMission = 0;
  
  public HotpointMissionAbstraction()
  {
    reset();
    tryRecoverMissionState();
    startListen();
    refreshEventBusInformation();
  }
  
  private boolean canDownloadMission()
  {
    return false;
  }
  
  private MissionState computeCurrentState()
  {
    return null;
  }
  
  private MissionState getStateFromMissionStatus(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    return null;
  }
  
  private boolean isValidParameters(HotpointMission paramHotpointMission)
  {
    return false;
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
  private void triggerDownloadEvent(HotpointMission arg1, dji.common.error.DJIError arg2)
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
  
  public boolean canDownloadMission(MissionState paramMissionState)
  {
    return false;
  }
  
  public boolean canUpdateMissionParameters()
  {
    return false;
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
  public void downloadMission(HotpointMission arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hotPointMissionDownloader(HotpointMission arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void resumeMission(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startMission(HotpointMission arg1, CommonCallbacks.CompletionCallback arg2)
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
  public void tryRecoverMissionState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateRadius(float arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateVelocity(float arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\hotpoint\HotpointMissionAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */