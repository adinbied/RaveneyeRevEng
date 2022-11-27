package dji.midware.component;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.component.rc.DJIRcDetectHelper;
import dji.midware.data.manager.P3.DataCameraEvent;
import dji.midware.data.manager.P3.DataEvent;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataGimbalGetPushType;
import dji.midware.data.model.P3.DataGimbalGetPushType.DJIGimbalType;
import dji.midware.data.model.P3.DataMonitorGetPushType;
import dji.midware.data.model.P3.DataMonitorGetPushType.MonitorType;
import dji.midware.link.DJILinkType;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIComponentManager
{
  private static final int HG701 = 131;
  private static final int MSG_RELOAD_CAMERAS = 0;
  private static final int RONINS = 3;
  private static final String TAG = "DJIComponentManager";
  private static DJIComponentManager instance;
  private static final boolean showLog = false;
  private int count = 0;
  private boolean isReceive = false;
  private CameraComponentType mCameraComponentType = CameraComponentType.None;
  public String mComponentLogStr = "";
  private Context mCtx;
  private GimbalComponentType mGimbalComponentType = GimbalComponentType.None;
  private Handler mHander = null;
  private CameraComponentType mLastCameraComponentType = CameraComponentType.None;
  private GimbalComponentType mLastGimbalComponentType = GimbalComponentType.None;
  private MonitorComponentType mLastMonitorComponentType = MonitorComponentType.NONE;
  private PlatformType mLastPlatformType = PlatformType.None;
  private RcComponentType mLastRcComponentType = RcComponentType.None;
  private CameraComponentType mLastSecondaryCameraComponentType = CameraComponentType.None;
  private MonitorComponentType mMonitorComponentType = MonitorComponentType.NONE;
  private PlatformType mPlaformType = PlatformType.None;
  private RcComponentType mRcComponentType = RcComponentType.None;
  private CameraComponentType mSecondaryCameraComponentType = CameraComponentType.None;
  private boolean startMonitoringCamereChange = false;
  private UpdateTask updateTask = new UpdateTask(null);
  
  private boolean checkGimbalLogic(GimbalComponentType paramGimbalComponentType)
  {
    paramGimbalComponentType = GimbalComponentType.None;
    return true;
  }
  
  private boolean checkPlatformLogic(PlatformType paramPlatformType)
  {
    return false;
  }
  
  private boolean checkRcLogic(RcComponentType paramRcComponentType)
  {
    return false;
  }
  
  public static DJIComponentManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DJIComponentManager();
      }
      DJIComponentManager localDJIComponentManager = instance;
      return localDJIComponentManager;
    }
    finally {}
  }
  
  private CameraComponentType getLocalCameraComponentType()
  {
    return null;
  }
  
  private GimbalComponentType getLocalGimbalComponentType()
  {
    return null;
  }
  
  private PlatformType getLocalPlatformType()
  {
    return null;
  }
  
  private RcComponentType getLocalRcComponentType()
  {
    return null;
  }
  
  private CameraComponentType getLocalSecondartCameraComponentType()
  {
    return null;
  }
  
  private boolean isDebugVersion()
  {
    return false;
  }
  
  private boolean isGimbalRonin()
  {
    return false;
  }
  
  private boolean isPlatformFoldingDrone()
  {
    return false;
  }
  
  private boolean isPlatformHG702()
  {
    return false;
  }
  
  private boolean isPlatformHG710()
  {
    return false;
  }
  
  private boolean isPlatformInspire()
  {
    return false;
  }
  
  private boolean isPlatformInspire2()
  {
    return false;
  }
  
  private boolean isPlatformLB2()
  {
    return false;
  }
  
  private boolean isPlatformM100()
  {
    return false;
  }
  
  private boolean isPlatformM200()
  {
    return false;
  }
  
  private boolean isPlatformM200Series()
  {
    return false;
  }
  
  private boolean isPlatformM210()
  {
    return false;
  }
  
  private boolean isPlatformM210RTK()
  {
    return false;
  }
  
  private boolean isPlatformM600()
  {
    return false;
  }
  
  private boolean isPlatformM600Pro()
  {
    return false;
  }
  
  private boolean isPlatformMammoth()
  {
    return false;
  }
  
  private boolean isPlatformMonitor1()
  {
    return false;
  }
  
  private boolean isPlatformOSMO()
  {
    return false;
  }
  
  private boolean isPlatformOSMOMobile()
  {
    return false;
  }
  
  private boolean isPlatformP3c()
  {
    return false;
  }
  
  private boolean isPlatformP3s()
  {
    return false;
  }
  
  private boolean isPlatformP3w()
  {
    return false;
  }
  
  private boolean isPlatformP3x()
  {
    return false;
  }
  
  private boolean isPlatformP4()
  {
    return false;
  }
  
  private boolean isPlatformP4A()
  {
    return false;
  }
  
  private boolean isPlatformP4P()
  {
    return false;
  }
  
  private boolean isPlatformRonin2()
  {
    return false;
  }
  
  private boolean isPlatformRoninS()
  {
    return false;
  }
  
  private boolean isPlatformRoninSC()
  {
    return false;
  }
  
  private boolean isPlatformUnknow()
  {
    return false;
  }
  
  private boolean isRcFoldingDrone()
  {
    return false;
  }
  
  private boolean isRcInspire()
  {
    return false;
  }
  
  private boolean isRcInspire2()
  {
    return false;
  }
  
  private boolean isRcLB2()
  {
    return false;
  }
  
  private boolean isRcMammoth()
  {
    return false;
  }
  
  private boolean isRcP3P4()
  {
    return false;
  }
  
  private boolean isRcP3c()
  {
    return false;
  }
  
  private boolean isRcP3w()
  {
    return false;
  }
  
  private boolean isRcP4P()
  {
    return false;
  }
  
  private boolean isRcPotato()
  {
    return false;
  }
  
  /* Error */
  private void log(String arg1, String arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveLocalCameraComponentType(CameraComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveLocalGimbalComponentType(GimbalComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveLocalMonitorType(MonitorComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveLocalPlatformType(PlatformType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveLocalRcComponentType(RcComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveLocalSecondartCameraComponentType(CameraComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private CameraComponentType transferCameraType(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return null;
  }
  
  private GimbalComponentType transferGimbalType(DataGimbalGetPushType.DJIGimbalType paramDJIGimbalType)
  {
    return null;
  }
  
  private MonitorComponentType transferGimbalType(DataMonitorGetPushType.MonitorType paramMonitorType)
  {
    return null;
  }
  
  private boolean updateCameraComponentType()
  {
    return false;
  }
  
  private boolean updateGimbalComponentType()
  {
    return false;
  }
  
  private boolean updateMonitorComponentType()
  {
    return false;
  }
  
  private boolean updatePlatformType()
  {
    return false;
  }
  
  private boolean updateRcComponentType()
  {
    return false;
  }
  
  private boolean updateSecondaryCameraComponentType()
  {
    return false;
  }
  
  /* Error */
  private void updateValue()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateValueDelay()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public CameraComponentType getCameraComponentType()
  {
    return getCameraComponentType(0);
  }
  
  public CameraComponentType getCameraComponentType(int paramInt)
  {
    return null;
  }
  
  public GimbalComponentType getGimbalComponentType()
  {
    return this.mGimbalComponentType;
  }
  
  public CameraComponentType getLastCameraComponentType()
  {
    return this.mLastCameraComponentType;
  }
  
  public GimbalComponentType getLastGimbalComponentType()
  {
    return this.mLastGimbalComponentType;
  }
  
  public MonitorComponentType getLastMonitorComponentType()
  {
    return this.mLastMonitorComponentType;
  }
  
  public PlatformType getLastPlatformType()
  {
    return this.mLastPlatformType;
  }
  
  public RcComponentType getLastRcComponentType()
  {
    return this.mLastRcComponentType;
  }
  
  public MonitorComponentType getMonitorComponentType()
  {
    return this.mMonitorComponentType;
  }
  
  public PlatformType getPlatformType()
  {
    return this.mPlaformType;
  }
  
  public RcComponentType getRcComponentType()
  {
    return this.mRcComponentType;
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isAircraftConnected()
  {
    return false;
  }
  
  public boolean isMonitorConnected()
  {
    return false;
  }
  
  public boolean isRcConnected()
  {
    return false;
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.ble2.base.BleState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIRcDetectHelper paramDJIRcDetectHelper)
  {
    updateValueDelay();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent paramDataCameraEvent)
  {
    updateValueDelay();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEvent paramDataEvent)
  {
    updateValueDelay();
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataGimbalGetPushType paramDataGimbalGetPushType)
  {
    updateValue();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataMonitorGetPushType paramDataMonitorGetPushType)
  {
    updateValue();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJILinkType paramDJILinkType)
  {
    updateValueDelay();
  }
  
  /* Error */
  public void reloadCameraAndGimbal()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setGimbalComponentType(GimbalComponentType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPlatformType(PlatformType paramPlatformType)
  {
    this.mPlaformType = paramPlatformType;
  }
  
  public static enum CameraComponentType
  {
    static
    {
      P3x = new CameraComponentType("P3x", 3);
      P3s = new CameraComponentType("P3s", 4);
      P3c = new CameraComponentType("P3c", 5);
      P3w = new CameraComponentType("P3w", 6);
      P4 = new CameraComponentType("P4", 7);
      X3 = new CameraComponentType("X3", 8);
      X5 = new CameraComponentType("X5", 9);
      X5R = new CameraComponentType("X5R", 10);
      TAU336 = new CameraComponentType("TAU336", 11);
      TAU640 = new CameraComponentType("TAU640", 12);
      FoldingDroneX = new CameraComponentType("FoldingDroneX", 13);
      FoldingDroneS = new CameraComponentType("FoldingDroneS", 14);
      Z3 = new CameraComponentType("Z3", 15);
      Mammoth = new CameraComponentType("Mammoth", 16);
      P4P = new CameraComponentType("P4P", 17);
      GD600 = new CameraComponentType("GD600", 18);
      CameraComponentType localCameraComponentType = new CameraComponentType("Unknow", 19);
      Unknow = localCameraComponentType;
      $VALUES = new CameraComponentType[] { None, X4S, X5S, P3x, P3s, P3c, P3w, P4, X3, X5, X5R, TAU336, TAU640, FoldingDroneX, FoldingDroneS, Z3, Mammoth, P4P, GD600, localCameraComponentType };
    }
    
    private CameraComponentType() {}
  }
  
  public static enum GimbalComponentType
  {
    static
    {
      HG701 = new GimbalComponentType("HG701", 4);
      HG702 = new GimbalComponentType("HG702", 5);
      HG710 = new GimbalComponentType("HG710", 6);
      GimbalComponentType localGimbalComponentType = new GimbalComponentType("Unknow", 7);
      Unknow = localGimbalComponentType;
      $VALUES = new GimbalComponentType[] { None, Ronin, Ronin2, Ronins, HG701, HG702, HG710, localGimbalComponentType };
    }
    
    private GimbalComponentType() {}
  }
  
  public static enum MonitorComponentType
  {
    static
    {
      HG702_MONITOR = new MonitorComponentType("HG702_MONITOR", 1);
      MonitorComponentType localMonitorComponentType = new MonitorComponentType("UnKNOWN", 2);
      UnKNOWN = localMonitorComponentType;
      $VALUES = new MonitorComponentType[] { NONE, HG702_MONITOR, localMonitorComponentType };
    }
    
    private MonitorComponentType() {}
  }
  
  public static enum PlatformType
  {
    static
    {
      P3s = new PlatformType("P3s", 2);
      P3c = new PlatformType("P3c", 3);
      P3w = new PlatformType("P3w", 4);
      Inspire = new PlatformType("Inspire", 5);
      M100 = new PlatformType("M100", 6);
      OSMO = new PlatformType("OSMO", 7);
      OSMOMobile = new PlatformType("OSMOMobile", 8);
      P4 = new PlatformType("P4", 9);
      M600 = new PlatformType("M600", 10);
      Inspire2 = new PlatformType("Inspire2", 11);
      M200 = new PlatformType("M200", 12);
      M210 = new PlatformType("M210", 13);
      M210RTK = new PlatformType("M210RTK", 14);
      FoldingDrone = new PlatformType("FoldingDrone", 15);
      Mammoth = new PlatformType("Mammoth", 16);
      P4P = new PlatformType("P4P", 17);
      M600Pro = new PlatformType("M600Pro", 18);
      P4A = new PlatformType("P4A", 19);
      Ronin2 = new PlatformType("Ronin2", 20);
      RoninS = new PlatformType("RoninS", 21);
      RoninSC = new PlatformType("RoninSC", 22);
      HG702 = new PlatformType("HG702", 23);
      HG710 = new PlatformType("HG710", 24);
      Monitor1 = new PlatformType("Monitor1", 25);
      PlatformType localPlatformType = new PlatformType("Unknown", 26);
      Unknown = localPlatformType;
      $VALUES = new PlatformType[] { None, P3x, P3s, P3c, P3w, Inspire, M100, OSMO, OSMOMobile, P4, M600, Inspire2, M200, M210, M210RTK, FoldingDrone, Mammoth, P4P, M600Pro, P4A, Ronin2, RoninS, RoninSC, HG702, HG710, Monitor1, localPlatformType };
    }
    
    private PlatformType() {}
  }
  
  public static enum RcComponentType
  {
    static
    {
      Inspire = new RcComponentType("Inspire", 4);
      LB2 = new RcComponentType("LB2", 5);
      P4P = new RcComponentType("P4P", 6);
      Potato = new RcComponentType("Potato", 7);
      FoldingDrone = new RcComponentType("FoldingDrone", 8);
      Mammoth = new RcComponentType("Mammoth", 9);
      Inspire2 = new RcComponentType("Inspire2", 10);
      RcComponentType localRcComponentType = new RcComponentType("Unknow", 11);
      Unknow = localRcComponentType;
      $VALUES = new RcComponentType[] { None, P3P4, P3c, P3w, Inspire, LB2, P4P, Potato, FoldingDrone, Mammoth, Inspire2, localRcComponentType };
    }
    
    private RcComponentType() {}
  }
  
  private class UpdateTask
    implements Runnable
  {
    private long lastPostTime = 0L;
    private int updateIndex = -1;
    private int[] updateTimeArray = { 1000, 2500, 8000 };
    
    private UpdateTask() {}
    
    public boolean isRunning()
    {
      return this.updateIndex >= 0;
    }
    
    public boolean nextRunTooLong()
    {
      return false;
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
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void start()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\component\DJIComponentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */