package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetVOutParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetVOutParams instance;
  private boolean isSettingHDMI = false;
  private boolean isSettingLCD = false;
  private boolean isSettingStream = false;
  private LCDFormat mLCDParam = LCDFormat.AUTO_NO_GLASS_CONNECTED;
  private int mStream = 1;
  
  public static DataCameraSetVOutParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetVOutParams();
      }
      DataCameraSetVOutParams localDataCameraSetVOutParams = instance;
      return localDataCameraSetVOutParams;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetVOutParams setIsSettingLCD(boolean paramBoolean)
  {
    this.isSettingLCD = paramBoolean;
    return this;
  }
  
  public DataCameraSetVOutParams setLCDFormat(LCDFormat paramLCDFormat)
  {
    this.mLCDParam = paramLCDFormat;
    return this;
  }
  
  public DataCameraSetVOutParams setStream(int paramInt)
  {
    this.isSettingStream = true;
    this.mStream = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum LCDFormat
  {
    private final int data;
    
    static
    {
      AUTO_GLASS_CONNECTED = new LCDFormat("AUTO_GLASS_CONNECTED", 5, 5);
      AUTO_NO_GLASS_CONNECTED = new LCDFormat("AUTO_NO_GLASS_CONNECTED", 6, 6);
      HD_FORMAT = new LCDFormat("HD_FORMAT", 7, 7);
      LCDFormat localLCDFormat = new LCDFormat("OTHER", 8, 100);
      OTHER = localLCDFormat;
      $VALUES = new LCDFormat[] { AUTO, R1280x720_FPS30, R1280x720_FPS60, R1920x1080_FPS30, R1920x1080_FPS60, AUTO_GLASS_CONNECTED, AUTO_NO_GLASS_CONNECTED, HD_FORMAT, localLCDFormat };
    }
    
    private LCDFormat(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static LCDFormat find(int paramInt)
    {
      LCDFormat localLCDFormat1 = AUTO_NO_GLASS_CONNECTED;
      LCDFormat[] arrayOfLCDFormat = values();
      int j = arrayOfLCDFormat.length;
      int i = 0;
      while (i < j)
      {
        LCDFormat localLCDFormat2 = arrayOfLCDFormat[i];
        if (localLCDFormat2._equals(paramInt)) {
          return localLCDFormat2;
        }
        i += 1;
      }
      return localLCDFormat1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetVOutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */