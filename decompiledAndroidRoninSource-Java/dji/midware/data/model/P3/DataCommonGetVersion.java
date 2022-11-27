package dji.midware.data.model.P3;

import android.util.SparseArray;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataEvent;
import dji.midware.data.model.base.DJICommonDataBase;
import dji.midware.data.packages.P3.RecvPack;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DataCommonGetVersion
  extends DJICommonDataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataCommonGetVersion";
  private static SparseArray<RecvPack> versionList = new SparseArray();
  private DeviceType deviceType;
  private boolean isClearCameraLose = true;
  private int modelId;
  
  private int getKey()
  {
    return 0;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void doPack() {}
  
  public DeviceType getDeviceType()
  {
    return this.deviceType;
  }
  
  public int getFirmByte(int paramInt)
  {
    return 0;
  }
  
  public String getFirmVer(String paramString)
  {
    return getFirmVer(paramString, false);
  }
  
  public String getFirmVer(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public String getFirmVerSimple(String paramString)
  {
    return null;
  }
  
  public String getHardwareVer()
  {
    return null;
  }
  
  public DJIVersionInfo getInfo()
  {
    return null;
  }
  
  public String getLoader(String paramString)
  {
    return getLoader(paramString, false);
  }
  
  public String getLoader(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public int getLoaderByte(int paramInt)
  {
    return 0;
  }
  
  public String getLoaderSimple(String paramString)
  {
    return null;
  }
  
  public int getModelId()
  {
    return this.modelId;
  }
  
  public DeviceType getWhoamI()
  {
    return null;
  }
  
  @Subscribe(priority=100, threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEvent paramDataEvent)
  {
    if (paramDataEvent == DataEvent.ConnectLose) {
      clear();
    }
  }
  
  public void setClearCameraLose(boolean paramBoolean)
  {
    this.isClearCameraLose = paramBoolean;
  }
  
  public DataCommonGetVersion setDeviceModel(int paramInt)
  {
    this.modelId = paramInt;
    return this;
  }
  
  public DataCommonGetVersion setDeviceType(DeviceType paramDeviceType)
  {
    this.deviceType = paramDeviceType;
    return this;
  }
  
  /* Error */
  public void setRecPack(RecvPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void start(DJIDataCallBack paramDJIDataCallBack)
  {
    start(paramDJIDataCallBack, 1000, 1);
  }
  
  /* Error */
  public void start(DJIDataCallBack arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startForce(DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startForce(DJIDataCallBack arg1, int arg2, int arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class DJIVersionInfo
  {
    public boolean isProduction = true;
    public boolean isSupportSafeUpgrade = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */