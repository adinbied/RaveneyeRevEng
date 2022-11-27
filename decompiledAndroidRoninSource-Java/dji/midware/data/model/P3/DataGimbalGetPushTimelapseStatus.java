package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushTimelapseStatus
  extends DataBase
{
  private static final String TAG = "DataGimbalGetPushTimelapseStatus";
  private static final DataGimbalGetPushTimelapseStatus mInstance = new DataGimbalGetPushTimelapseStatus();
  
  public static DataGimbalGetPushTimelapseStatus getInstance()
  {
    return mInstance;
  }
  
  protected void doPack() {}
  
  public int getCurRoadPercent()
  {
    return 0;
  }
  
  public int getFinishedPoints()
  {
    return 0;
  }
  
  public int getTakingOrPreview()
  {
    return 0;
  }
  
  public int getTimelapseStatus()
  {
    return 0;
  }
  
  public int getTotalRoadPercent()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    start();
    return super.isChanged(paramArrayOfByte);
  }
  
  /* Error */
  protected void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum TimeLaps
  {
    private int data;
    
    static
    {
      END = new TimeLaps("END", 3, 3);
      TimeLaps localTimeLaps = new TimeLaps("ERROR", 4, 4);
      ERROR = localTimeLaps;
      $VALUES = new TimeLaps[] { NONE, PREPARE, PROGRESS, END, localTimeLaps };
    }
    
    private TimeLaps(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TimeLaps find(int paramInt)
    {
      TimeLaps localTimeLaps1 = NONE;
      TimeLaps[] arrayOfTimeLaps = values();
      int j = arrayOfTimeLaps.length;
      int i = 0;
      while (i < j)
      {
        TimeLaps localTimeLaps2 = arrayOfTimeLaps[i];
        if (localTimeLaps2._equals(paramInt)) {
          return localTimeLaps2;
        }
        i += 1;
      }
      return localTimeLaps1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushTimelapseStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */