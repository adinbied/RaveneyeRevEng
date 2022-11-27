package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeEasySelfCalibration
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeEasySelfCalibration instance;
  private SelfRequest mSelfRequest = SelfRequest.ByUser;
  
  public static DataEyeEasySelfCalibration getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeEasySelfCalibration();
      }
      DataEyeEasySelfCalibration localDataEyeEasySelfCalibration = instance;
      return localDataEyeEasySelfCalibration;
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
  
  public DataEyeEasySelfCalibration setRequest(SelfRequest paramSelfRequest)
  {
    this.mSelfRequest = paramSelfRequest;
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
  
  public static enum SelfRequest
  {
    private final int data;
    
    static
    {
      ByUser = new SelfRequest("ByUser", 1, 1);
      Cancel = new SelfRequest("Cancel", 2, -1);
      SelfRequest localSelfRequest = new SelfRequest("OTHER", 3, 100);
      OTHER = localSelfRequest;
      $VALUES = new SelfRequest[] { None, ByUser, Cancel, localSelfRequest };
    }
    
    private SelfRequest(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SelfRequest find(int paramInt)
    {
      SelfRequest localSelfRequest1 = None;
      SelfRequest[] arrayOfSelfRequest = values();
      int j = arrayOfSelfRequest.length;
      int i = 0;
      while (i < j)
      {
        SelfRequest localSelfRequest2 = arrayOfSelfRequest[i];
        if (localSelfRequest2._equals(paramInt)) {
          return localSelfRequest2;
        }
        i += 1;
      }
      return localSelfRequest1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeEasySelfCalibration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */