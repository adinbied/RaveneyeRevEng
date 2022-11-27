package dji.midware.data.model.P3;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.interfaces.DJIDataAsyncListener;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;

public class DataOldSpecialControl
  extends DataSpecialControl
  implements DJIDataAsyncListener
{
  private static final long DELAY_STOP = 100L;
  private static final int MSG_ID_RESET = 2;
  private static final int MSG_ID_START = 0;
  private static final int MSG_ID_STOP = 1;
  private static DataOldSpecialControl instance;
  private Handler handler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  protected boolean isReset = false;
  protected byte mCameraByte = 0;
  protected final byte[] mData = new byte[2];
  protected DataSpecialControl.FlyGoHomeStaus mFlyGoHomeStatus = DataSpecialControl.FlyGoHomeStaus.INIT;
  protected DataFlycSetJoyStickParams.FlycMode mFlycMode = DataFlycSetJoyStickParams.FlycMode.OTHER;
  protected byte mGimbalByte = 0;
  protected boolean mInit = false;
  protected DataSpecialControl.PlayBrowseType mPlayBackBrowserType = DataSpecialControl.PlayBrowseType.OTHER;
  protected DataSpecialControl.PlayCtrType mPlayBackVideoCtrlType = DataSpecialControl.PlayCtrType.OTHER;
  protected DeviceType mReceiveType = DeviceType.CAMERA;
  protected boolean streamErrorStatus = false;
  
  public static DataOldSpecialControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOldSpecialControl();
      }
      DataOldSpecialControl localDataOldSpecialControl = instance;
      return localDataOldSpecialControl;
    }
    finally {}
  }
  
  /* Error */
  private void sendPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void _reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataOldSpecialControl init()
  {
    _reset();
    this.mInit = true;
    return this;
  }
  
  public boolean isStreamErrorStatus()
  {
    return this.streamErrorStatus;
  }
  
  protected DataOldSpecialControl reset()
  {
    _reset();
    this.isReset = true;
    return this;
  }
  
  public DataOldSpecialControl resetGimbal()
  {
    return null;
  }
  
  public DataOldSpecialControl selfieGimbal()
  {
    return null;
  }
  
  public DataOldSpecialControl setFlyGoHomeStatus(DataSpecialControl.FlyGoHomeStaus paramFlyGoHomeStaus)
  {
    return null;
  }
  
  public DataOldSpecialControl setFlycMode(DataFlycSetJoyStickParams.FlycMode paramFlycMode)
  {
    return null;
  }
  
  public DataOldSpecialControl setGimbalMode(DataGimbalControl.MODE paramMODE)
  {
    return null;
  }
  
  public DataOldSpecialControl setGimbalMode(DataGimbalControl.MODE paramMODE, boolean paramBoolean)
  {
    return null;
  }
  
  public DataOldSpecialControl setPhotoType(DataCameraSetPhoto.TYPE paramTYPE)
  {
    return null;
  }
  
  public DataOldSpecialControl setPhotoType(DataCameraSetPhoto.TYPE paramTYPE, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataOldSpecialControl setPlayBackBrowserScaleType(short paramShort)
  {
    return null;
  }
  
  public DataOldSpecialControl setPlayBackBrowserType(DataSpecialControl.PlayBrowseType paramPlayBrowseType, byte paramByte1, byte paramByte2)
  {
    return null;
  }
  
  public DataOldSpecialControl setPlayBackPlayCtr(DataSpecialControl.PlayCtrType paramPlayCtrType, byte paramByte)
  {
    return null;
  }
  
  public DataOldSpecialControl setPlayBackType(boolean paramBoolean)
  {
    return null;
  }
  
  public DataOldSpecialControl setRecordType(boolean paramBoolean)
  {
    return null;
  }
  
  public DataOldSpecialControl setRecordType(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataOldSpecialControl setStreamErrorStatus(boolean paramBoolean)
  {
    this.streamErrorStatus = paramBoolean;
    return this;
  }
  
  /* Error */
  public void start(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void start(DJIDataCallBack paramDJIDataCallBack)
  {
    start(20L);
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOldSpecialControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */