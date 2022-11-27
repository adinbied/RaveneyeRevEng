package dji.internal.logics;

import android.content.Context;
import android.os.Handler;
import dji.common.util.HistoryInfo;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.data.model.P3.Data2100GetPushCheckStatus;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCenterGetPushBatteryCommon;
import dji.midware.data.model.P3.DataFlycGetParams;
import dji.midware.data.model.P3.DataGimbalGetPushCheckStatus;
import dji.midware.data.model.P3.DataGimbalGetPushParams;
import dji.midware.data.model.P3.DataOsdGetPushChannalStatus;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.midware.data.model.P3.DataOsdGetPushHome;
import dji.midware.data.model.P3.DataOsdGetPushSignalQuality;
import dji.midware.data.model.P3.DataRcGetPushBatteryInfo;
import dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData;
import dji.midware.data.model.P3.DataWifiGetPushSignal;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import dji.thirdparty.rx.Subscription;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FPVTipLogic
{
  private static int ARG_UPDATE_2100_CHECKSTATUS = 1;
  private static int ARG_UPDATE_ALL = 16383;
  private static int ARG_UPDATE_BATTERY_COMMON = 4;
  private static int ARG_UPDATE_BATTERY_DYNAMIC_DATA = 1024;
  private static int ARG_UPDATE_CAMERA_STATEINFO = 2;
  private static int ARG_UPDATE_FLYC_CHECKSTATUS = 8;
  private static int ARG_UPDATE_GIMBAL_CHECKSTATUS = 16384;
  private static int ARG_UPDATE_GIMBAL_PARAM = 32;
  private static int ARG_UPDATE_NONE = 0;
  private static int ARG_UPDATE_OSD_CHLSTATUS = 64;
  private static int ARG_UPDATE_OSD_COMMON = 128;
  private static int ARG_UPDATE_OSD_HOME = 8192;
  private static int ARG_UPDATE_OSD_SIGNAL = 256;
  private static int ARG_UPDATE_RC_BATTERYINFO = 512;
  private static int ARG_UPDATE_SMART_BATTERY = 16;
  private static int ARG_UPDATE_WIFI_ELEC_SIGNAL = 2048;
  private static int ARG_UPDATE_WIFI_SIGNAL = 4096;
  private static final long DELAY_UPDATE = 100L;
  private static final long DELAY_UPDATE_PARAMS = 2000L;
  private static long FLAG_ATTI_STATE = 288230376151711744L;
  private static long FLAG_ATTI_STATE_IN_THE_AIR = 144115188075855872L;
  private static long FLAG_BACK_VISION_CALI = 16384L;
  private static long FLAG_BAROMETER_DEAD = 2048L;
  private static long FLAG_BATTERY_BROKEN = 262144L;
  private static long FLAG_BATTERY_CONN_EXCEPTION = 65536L;
  private static long FLAG_BATTERY_EXCEPTION = 131072L;
  private static long FLAG_BATTERY_LOW_TEMP = 2097152L;
  private static long FLAG_BATTERY_OVER_CURRENT = 524288L;
  private static long FLAG_BATTERY_OVER_TEMP = 1048576L;
  private static long FLAG_BATTERY_SELF_RELEASE = 4194304L;
  private static long FLAG_CAMERA_ENCRYPT_ERROR = 64L;
  private static long FLAG_CANT_TAKEOFF = 1073741824L;
  private static long FLAG_CANT_TAKEOFF_NOVICE = 536870912L;
  private static long FLAG_CHLSTATUS_POOR = 576460752303423488L;
  private static long FLAG_COMPASS_DISTURB = 1024L;
  private static long FLAG_COMPASS_ERROR = 128L;
  private static long FLAG_DEVICE_LOCK = 268435456L;
  private static long FLAG_DISCONNECT = 1L;
  private static long FLAG_DOWN_VISION_CALI = 8192L;
  private static long FLAG_ESC_ERROR = 512L;
  private static long FLAG_ESC_ERROR_SKY = 256L;
  private static long FLAG_FAILSAFE = 4398046511104L;
  private static long FLAG_FAILSAFE_GOHOME = 2199023255552L;
  private static long FLAG_FRONT_VISION_CALI = 4096L;
  private static long FLAG_GALE_WARNING = 1125899906842624L;
  private static long FLAG_GIMBAL_END_POINT_OVERLOAD = 9007199254740992L;
  private static long FLAG_GIMBAL_END_POINT_STUCK = 4503599627370496L;
  private static long FLAG_GIMBAL_STUCK = 2251799813685248L;
  private static long FLAG_GIMBAL_VIBRATION = 18014398509481984L;
  private static long FLAG_GOHOME = 1152921504606846976L;
  private static long FLAG_GOHOME_FAILED = 1099511627776L;
  private static long FLAG_HD_ERROR = 4L;
  private static long FLAG_IMU_CALI = 32L;
  private static long FLAG_IMU_COMPASS_ERROR = 67108864L;
  private static long FLAG_IMU_ERROR = 33554432L;
  private static long FLAG_IMU_HEATING = 134217728L;
  private static long FLAG_IMU_INITIALIZING = 8388608L;
  private static long FLAG_LOW_POWER = 17592186044416L;
  private static long FLAG_LOW_POWER_GOHOME = 8796093022208L;
  private static long FLAG_LOW_RADIO_SIGNAL = 281474976710656L;
  private static long FLAG_LOW_RC_POWER = 35184372088832L;
  private static long FLAG_LOW_RC_SIGNAL = 70368744177664L;
  private static long FLAG_LOW_VOLTAGE = 137438953472L;
  private static long FLAG_MC_DATA_ERROR = 16L;
  private static long FLAG_NEED_UPDATE = 549755813888L;
  private static long FLAG_NON_GPS = 72057594037927936L;
  private static long FLAG_NON_GPS_IN_THE_AIR = 36028797018963968L;
  private static long FLAG_NORMAL = 0L;
  private static long FLAG_NORMAL_IN_THE_AIR = 2305843009213693952L;
  private static long FLAG_NOT_ENOUGH_FORCE = 274877906944L;
  private static long FLAG_NO_VIDEO_SIGNAL = 8L;
  private static long FLAG_RADIO_SIGNAL_DISTURB = 562949953421312L;
  private static long FLAG_RC_SIGNAL_DISTURB = 140737488355328L;
  private static long FLAG_SENSOR_ERROR = 16777216L;
  private static long FLAG_SERIOUS_LOW_POWER = 17179869184L;
  private static long FLAG_SERIOUS_LOW_POWER_LANDING = 8589934592L;
  private static long FLAG_SERIOUS_LOW_VOLTAGE = 4294967296L;
  private static long FLAG_SERIOUS_LOW_VOLTAGE_LANDING = 2147483648L;
  private static long FLAG_SMART_LOW_POWER = 68719476736L;
  private static long FLAG_SMART_LOW_POWER_LANDING = 34359738368L;
  private static long FLAG_USB_MODE = 2L;
  private static long FLAG_VISION_ERROR = 32768L;
  private static long INIT_STATUS = 1L | 0x8;
  private static final int INVALID = -1;
  static final int MSG_ID_COMPASS_DISTURB = 4096;
  static final int MSG_ID_COMPASS_ERROR = 4097;
  static final int MSG_ID_LOWPOWER_GOHOME = 4098;
  static final int MSG_ID_POWER_ENOUGH = 4099;
  static final int MSG_ID_UPDATE = 256;
  static final int MSG_ID_UPDATE_PARAMS = 4100;
  static final int MSG_ID_UPDATE_STATUS = 4101;
  private static final int SIGNAL_NORMAL = 100;
  private static final int SIGNAL_WEAK = 0;
  String[] SENSORS_PARAMS = { "g_status.topology_verify.user_interface.imu_status_0", "g_status.topology_verify.user_interface.mag_status_0" };
  private HistoryInfo batteryHistory = new HistoryInfo();
  private Context curContext;
  private long flagStatus = INIT_STATUS;
  private boolean isNormalInAir = false;
  private long lastCompassDisturbTime = 0L;
  final DataFlycGetParams paramGetter = new DataFlycGetParams();
  private Message previousMessage;
  private Message[] resDatas;
  private volatile Subscription subscriptionData2100CheckStatus;
  private TipHandler tipHandler = null;
  private volatile int updateFlag = ARG_UPDATE_NONE;
  private int videoSignalDiagnose = 0;
  
  /* Error */
  private void cameraConnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void cameraDisconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkIsLandingMode(DataOsdGetPushCommon.FLYC_STATE paramFLYC_STATE)
  {
    return false;
  }
  
  private long checkPos(long paramLong)
  {
    return 211221459L;
  }
  
  public static FPVTipLogic getInstance()
  {
    return HOLDER.instance;
  }
  
  /* Error */
  private void handleCompassError()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleDataPush(int arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handlePowerEnough()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean hasFlag(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  /* Error */
  private void initRes()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isFlying()
  {
    return false;
  }
  
  private void resetStatus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (ServiceManager.getInstance().isConnected()) {
        connect();
      } else {
        disconnect();
      }
      if (ServiceManager.getInstance().isRemoteOK())
      {
        cameraConnect();
        return;
      }
      cameraDisconnect();
      return;
    }
    cameraDisconnect();
    disconnect();
  }
  
  /* Error */
  private void update(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void update2100CheckStatus(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateBatteryCommon(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateBatteryDynamicData(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraStateInfo(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private long updateESCStatus(DataOsdGetPushCommon paramDataOsdGetPushCommon, long paramLong)
  {
    return 211221661L;
  }
  
  /* Error */
  private void updateFlycCheckStatus(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateFlycSmartBattery(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateGimbalCheckStatus(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateGimbalParam(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateMessage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateOsdCommon(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateOsdHome(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateOsdSignal(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateOsdSignalChlStatus(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateParamStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateParams()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateRcBattery(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private long updateSdrRadioSignal(long paramLong, int paramInt)
  {
    return 211222042L;
  }
  
  private long updateSdrRcSignal(long paramLong, int paramInt)
  {
    return 211222055L;
  }
  
  private long updateVisionSensorStatus(Data2100GetPushCheckStatus paramData2100GetPushCheckStatus, long paramLong)
  {
    return 211222068L;
  }
  
  /* Error */
  private void updateWifiSignal(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void connect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void disconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getPos(long paramLong)
  {
    return 0;
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void needUptate(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DJIVideoEvent arg1)
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
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushStateInfo paramDataCameraGetPushStateInfo)
  {
    handleDataPush(ARG_UPDATE_CAMERA_STATEINFO, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCenterGetPushBatteryCommon paramDataCenterGetPushBatteryCommon)
  {
    handleDataPush(ARG_UPDATE_BATTERY_COMMON, false);
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushCheckStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushSmartBattery arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataGimbalGetPushCheckStatus paramDataGimbalGetPushCheckStatus)
  {
    handleDataPush(ARG_UPDATE_GIMBAL_CHECKSTATUS, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataGimbalGetPushParams paramDataGimbalGetPushParams)
  {
    handleDataPush(ARG_UPDATE_GIMBAL_PARAM, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushChannalStatus paramDataOsdGetPushChannalStatus) {}
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushHome paramDataOsdGetPushHome)
  {
    handleDataPush(ARG_UPDATE_OSD_HOME, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushSignalQuality paramDataOsdGetPushSignalQuality)
  {
    handleDataPush(ARG_UPDATE_OSD_SIGNAL, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataRcGetPushBatteryInfo paramDataRcGetPushBatteryInfo)
  {
    handleDataPush(ARG_UPDATE_RC_BATTERYINFO, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataSmartBatteryGetPushDynamicData paramDataSmartBatteryGetPushDynamicData)
  {
    handleDataPush(ARG_UPDATE_BATTERY_DYNAMIC_DATA, false);
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataWifiGetPushSignal paramDataWifiGetPushSignal)
  {
    handleDataPush(ARG_UPDATE_WIFI_SIGNAL, false);
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onEvent3MainThread(dji.midware.data.manager.P3.DataCameraEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoSignalDiagnose(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static final class FPVTipEvent
  {
    private final Message message;
    
    FPVTipEvent(Message paramMessage)
    {
      this.message = paramMessage;
    }
    
    public Message getMessage()
    {
      return this.message;
    }
  }
  
  private static final class HOLDER
  {
    private static FPVTipLogic instance = new FPVTipLogic(null);
  }
  
  private static final class TipHandler
    extends Handler
  {
    private final WeakReference<FPVTipLogic> weakRef;
    
    public TipHandler(FPVTipLogic paramFPVTipLogic)
    {
      super();
      this.weakRef = new WeakReference(paramFPVTipLogic);
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\FPVTipLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */