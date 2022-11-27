package dji.internal.mission.abstraction.panorama;

import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.error.DJIError;
import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;
import dji.common.mission.panorama.PanoramaMode;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.internal.mission.abstraction.BaseMissionAbstraction;
import dji.internal.mission.fsm.FiniteStateMachine;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class PanoramaMissionAbstraction
  extends BaseMissionAbstraction
{
  private static final int INVALID_FILE_INDEX = -1;
  private static final String TAG = "Pano";
  private int curFileIndex;
  private SettingsDefinitions.CameraMode currentCameraMode = SettingsDefinitions.CameraMode.UNKNOWN;
  private SettingsDefinitions.ShootPhotoMode currentShootPhotoMode = SettingsDefinitions.ShootPhotoMode.UNKNOWN;
  private PanoramaAbstractionDataHolder.PanoramaBuilder holder = new PanoramaAbstractionDataHolder.PanoramaBuilder();
  private AtomicBoolean isSettingUp = new AtomicBoolean(false);
  private AtomicBoolean isStopping = new AtomicBoolean(false);
  private long lastUpdateTime = 0L;
  private DJIParamAccessListener listener = new DJIParamAccessListener()
  {
    /* Error */
    public void onValueChange(dji.sdksharedlib.keycatalog.DJISDKCacheKey arg1, dji.sdksharedlib.store.DJISDKCacheParamValue arg2, dji.sdksharedlib.store.DJISDKCacheParamValue arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private DJIError returnError;
  private CountDownLatch startMissionCDL = null;
  
  public PanoramaMissionAbstraction()
  {
    if (DJIProductManager.getInstance().getType() != ProductType.Longan)
    {
      if (this.fsm.getState() == null) {
        this.fsm.forceTransitTo(MissionState.DISCONNECTED);
      }
      forceTransitToState(MissionState.DISCONNECTED, new PanoramaAbstractionDataHolder.PanoramaBuilder().event(MissionEvent.DISCONNECTED));
    }
    else
    {
      if (this.fsm.getState() == null) {
        this.fsm.forceTransitTo(MissionState.READY_TO_SETUP);
      }
      forceTransitToState(MissionState.READY_TO_SETUP, new PanoramaAbstractionDataHolder.PanoramaBuilder().event(MissionEvent.CONNECTED));
    }
    reset();
    startListen();
    refreshEventBusInformation();
  }
  
  /* Error */
  private void cdlAwait(CountDownLatch arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void cdlCountDown(CountDownLatch paramCountDownLatch)
  {
    paramCountDownLatch.countDown();
  }
  
  /* Error */
  private void performSetupError(DJIError arg1)
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
  private void settingUp(PanoramaMode arg1, CommonCallbacks.CompletionCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  private void stopping(CommonCallbacks.CompletionCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  
  public int getCurFileIndex()
  {
    return this.curFileIndex;
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
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushCurPanoFileName arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void reset()
  {
    this.currentCameraMode = SettingsDefinitions.CameraMode.UNKNOWN;
    this.curFileIndex = -1;
  }
  
  /* Error */
  public void setupMission(PanoramaMode arg1, CommonCallbacks.CompletionCallback arg2)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\panorama\PanoramaMissionAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */