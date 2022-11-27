package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetActiveResult
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetActiveResult instance;
  private DJIActivationState activationState;
  private String appCommKey;
  private int appId;
  private int appLevel;
  
  public static DataFlycSetActiveResult getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetActiveResult();
      }
      DataFlycSetActiveResult localDataFlycSetActiveResult = instance;
      return localDataFlycSetActiveResult;
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
  
  public DataFlycSetActiveResult setActivationState(DJIActivationState paramDJIActivationState)
  {
    this.activationState = paramDJIActivationState;
    return this;
  }
  
  public DataFlycSetActiveResult setAppCommKey(String paramString)
  {
    this.appCommKey = paramString;
    return this;
  }
  
  public DataFlycSetActiveResult setAppId(int paramInt)
  {
    this.appId = paramInt;
    return this;
  }
  
  public DataFlycSetActiveResult setAppLevel(int paramInt)
  {
    this.appLevel = paramInt;
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
  
  public static enum DJIActivationState
  {
    private int data;
    
    static
    {
      NoNetwork = new DJIActivationState("NoNetwork", 1, 1);
      InvalidId = new DJIActivationState("InvalidId", 2, 2);
      FailedForNet = new DJIActivationState("FailedForNet", 3, 3);
      DJIActivationState localDJIActivationState = new DJIActivationState("OTHER", 4, 100);
      OTHER = localDJIActivationState;
      $VALUES = new DJIActivationState[] { Success, NoNetwork, InvalidId, FailedForNet, localDJIActivationState };
    }
    
    private DJIActivationState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIActivationState find(int paramInt)
    {
      DJIActivationState localDJIActivationState = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIActivationState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetActiveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */