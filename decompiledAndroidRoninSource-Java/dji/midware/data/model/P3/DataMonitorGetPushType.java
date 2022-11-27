package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataMonitorGetPushType
  extends DataBase
{
  private static final String TAG = "DataMonitorGetPushType";
  private int mTypeValue;
  
  public static DataMonitorGetPushType getInstance()
  {
    return InstanceHolder.sINSTANCE;
  }
  
  protected void doPack() {}
  
  public MonitorType getMonitorType()
  {
    return MonitorType.find(this.mTypeValue);
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static class InstanceHolder
  {
    private static final DataMonitorGetPushType sINSTANCE = new DataMonitorGetPushType(null);
  }
  
  public static enum MonitorType
  {
    private int data;
    
    static
    {
      MonitorType localMonitorType = new MonitorType("UnKnown", 1, 255);
      UnKnown = localMonitorType;
      $VALUES = new MonitorType[] { Ronin1, localMonitorType };
    }
    
    private MonitorType(int paramInt)
    {
      this.data = paramInt;
    }
    
    static MonitorType find(int paramInt)
    {
      MonitorType localMonitorType = UnKnown;
      MonitorType[] arrayOfMonitorType = values();
      int i = 0;
      while (i < arrayOfMonitorType.length)
      {
        if (arrayOfMonitorType[i].data == paramInt) {
          return arrayOfMonitorType[i];
        }
        i += 1;
      }
      return localMonitorType;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataMonitorGetPushType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */