package dji.internal.mission.abstraction.followme;

import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.mission.followme.FollowMeMission;
import dji.internal.mission.abstraction.BaseMissionAbstraction;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.listener.DJIParamAccessListener;

public class FollowMeMissionAbstraction
  extends BaseMissionAbstraction
{
  private static final int FOLLOWME_TYPE = 3;
  private static final int NO_MISSION = 0;
  private static final String TAG = "FollowMeMission";
  private FollowMeAbstractionCacheData cacheData = new FollowMeAbstractionCacheData();
  private DJIParamAccessListener connectionListener = new -..Lambda.FollowMeMissionAbstraction.F1ngL3LGbv3SsdxmAaCuHk9woVU(this);
  private int previousMission = 0;
  
  public FollowMeMissionAbstraction()
  {
    reset();
    tryRecoverMissionState();
    startListen();
    refreshEventBusInformation();
  }
  
  private MissionState computeCurrentState()
  {
    return null;
  }
  
  private boolean isValidParameters(FollowMeMission paramFollowMeMission)
  {
    return false;
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
  private void specialStopFollowMeMission()
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
  
  private void triggerTimerIfNecessary() {}
  
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
  
  public boolean isMissionCanUpdate()
  {
    return false;
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
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo arg1)
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
  public void pauseMission(dji.common.util.CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void reset()
  {
    this.cacheData.reset();
  }
  
  /* Error */
  public void resumeMission(dji.common.util.CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startMission(FollowMeMission arg1, dji.common.util.CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopMission(dji.common.util.CommonCallbacks.CompletionCallback arg1)
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
  public void updateCoordinate(dji.common.model.LocationCoordinate2D arg1, float arg2, dji.common.util.CommonCallbacks.CompletionCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateCoordinate(dji.common.model.LocationCoordinate2D arg1, dji.common.util.CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\followme\FollowMeMissionAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */