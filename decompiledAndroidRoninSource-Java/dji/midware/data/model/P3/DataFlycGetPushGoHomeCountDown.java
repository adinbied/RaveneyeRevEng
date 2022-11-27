package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycGetPushGoHomeCountDown
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetPushGoHomeCountDown instance;
  private int mCmdType;
  private int mSendAction;
  
  public static DataFlycGetPushGoHomeCountDown getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushGoHomeCountDown();
      }
      DataFlycGetPushGoHomeCountDown localDataFlycGetPushGoHomeCountDown = instance;
      return localDataFlycGetPushGoHomeCountDown;
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
  
  public GoHomePushActionType getActionType()
  {
    return null;
  }
  
  public int getCmdType()
  {
    return 0;
  }
  
  public int getCountDownSec()
  {
    return 0;
  }
  
  public DataFlycGetPushGoHomeCountDown setCmdType(int paramInt)
  {
    this.mCmdType = paramInt;
    return this;
  }
  
  public DataFlycGetPushGoHomeCountDown setSendAction(int paramInt)
  {
    this.mSendAction = paramInt;
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
  
  public static enum GoHomePushActionType
  {
    private final int data;
    
    static
    {
      GoHomePushActionType localGoHomePushActionType = new GoHomePushActionType("OTHER", 1, 100);
      OTHER = localGoHomePushActionType;
      $VALUES = new GoHomePushActionType[] { LOSE_SATELLITE_RESTORE, localGoHomePushActionType };
    }
    
    private GoHomePushActionType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GoHomePushActionType find(int paramInt)
    {
      GoHomePushActionType localGoHomePushActionType1 = OTHER;
      GoHomePushActionType[] arrayOfGoHomePushActionType = values();
      int j = arrayOfGoHomePushActionType.length;
      int i = 0;
      while (i < j)
      {
        GoHomePushActionType localGoHomePushActionType2 = arrayOfGoHomePushActionType[i];
        if (localGoHomePushActionType2._equals(paramInt)) {
          return localGoHomePushActionType2;
        }
        i += 1;
      }
      return localGoHomePushActionType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushGoHomeCountDown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */