package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalBalanceAdjust
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataGimbalBalanceAdjust";
  
  public static DataGimbalBalanceAdjust getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void setSendData(GimbalAdjustTypeId arg1, int arg2, byte[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void doPack() {}
  
  public DataGimbalBalanceAdjust setGimbalAdjustRequest(GimbalAdjustRequest paramGimbalAdjustRequest)
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum GimbalAdjustRequest
  {
    private int data;
    
    static
    {
      PITCH_ADJUST = new GimbalAdjustRequest("PITCH_ADJUST", 1, 2);
      ROLL_TEST = new GimbalAdjustRequest("ROLL_TEST", 2, 4);
      ROLL_ADJUST = new GimbalAdjustRequest("ROLL_ADJUST", 3, 8);
      YAW_TEST = new GimbalAdjustRequest("YAW_TEST", 4, 16);
      YAW_ADJUST = new GimbalAdjustRequest("YAW_ADJUST", 5, 32);
      STOP_ADJUST = new GimbalAdjustRequest("STOP_ADJUST", 6, 64);
      GimbalAdjustRequest localGimbalAdjustRequest = new GimbalAdjustRequest("OTHER", 7, 100);
      OTHER = localGimbalAdjustRequest;
      $VALUES = new GimbalAdjustRequest[] { PITCH_TEST, PITCH_ADJUST, ROLL_TEST, ROLL_ADJUST, YAW_TEST, YAW_ADJUST, STOP_ADJUST, localGimbalAdjustRequest };
    }
    
    private GimbalAdjustRequest(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GimbalAdjustRequest find(int paramInt)
    {
      GimbalAdjustRequest localGimbalAdjustRequest = OTHER;
      GimbalAdjustRequest[] arrayOfGimbalAdjustRequest = values();
      int i = 0;
      while (i < arrayOfGimbalAdjustRequest.length)
      {
        if (arrayOfGimbalAdjustRequest[i]._equals(paramInt)) {
          return arrayOfGimbalAdjustRequest[i];
        }
        i += 1;
      }
      return localGimbalAdjustRequest;
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
  
  public static enum GimbalAdjustTypeId
  {
    private int data;
    
    static
    {
      GimbalAdjustTypeId localGimbalAdjustTypeId = new GimbalAdjustTypeId("OTHER", 1, 100);
      OTHER = localGimbalAdjustTypeId;
      $VALUES = new GimbalAdjustTypeId[] { ADJUST_REQUEST, localGimbalAdjustTypeId };
    }
    
    private GimbalAdjustTypeId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GimbalAdjustTypeId find(int paramInt)
    {
      GimbalAdjustTypeId localGimbalAdjustTypeId = OTHER;
      GimbalAdjustTypeId[] arrayOfGimbalAdjustTypeId = values();
      int i = 0;
      while (i < arrayOfGimbalAdjustTypeId.length)
      {
        if (arrayOfGimbalAdjustTypeId[i]._equals(paramInt)) {
          return arrayOfGimbalAdjustTypeId[i];
        }
        i += 1;
      }
      return localGimbalAdjustTypeId;
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
  
  private static final class SingletonHolder
  {
    private static final DataGimbalBalanceAdjust mInstance = new DataGimbalBalanceAdjust();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalBalanceAdjust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */