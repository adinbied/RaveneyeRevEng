package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetOpticsZoomMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataCameraSetOpticsZoomMode";
  private int arg1 = -1;
  private int arg2 = -1;
  private OpticsZommMode mMode = OpticsZommMode.OTHER;
  private ZoomSpeed mZoomSpeed = ZoomSpeed.OTHER;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetOpticsZoomMode setOpticsZoomMode(OpticsZommMode paramOpticsZommMode, ZoomSpeed paramZoomSpeed, int paramInt1, int paramInt2)
  {
    this.mMode = paramOpticsZommMode;
    this.mZoomSpeed = paramZoomSpeed;
    this.arg1 = paramInt1;
    this.arg2 = paramInt2;
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
  
  public static enum OpticsZommMode
  {
    private int mCmd;
    
    static
    {
      OpticsZommMode localOpticsZommMode = new OpticsZommMode("OTHER", 3, 100);
      OTHER = localOpticsZommMode;
      $VALUES = new OpticsZommMode[] { CONTINUOUS, SETZOOM, STOPZOOM, localOpticsZommMode };
    }
    
    private OpticsZommMode(int paramInt)
    {
      this.mCmd = paramInt;
    }
    
    public static OpticsZommMode find(int paramInt)
    {
      OpticsZommMode localOpticsZommMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localOpticsZommMode;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mCmd == paramInt;
    }
    
    public int getCmd()
    {
      return this.mCmd;
    }
  }
  
  public static enum ZoomSpeed
  {
    private int mCmd;
    
    static
    {
      SLOW = new ZoomSpeed("SLOW", 1, 73);
      MIDSLOW = new ZoomSpeed("MIDSLOW", 2, 74);
      MID = new ZoomSpeed("MID", 3, 75);
      MIDFAST = new ZoomSpeed("MIDFAST", 4, 76);
      FAST = new ZoomSpeed("FAST", 5, 77);
      FASTEST = new ZoomSpeed("FASTEST", 6, 78);
      ZoomSpeed localZoomSpeed = new ZoomSpeed("OTHER", 7, 100);
      OTHER = localZoomSpeed;
      $VALUES = new ZoomSpeed[] { SLOWEST, SLOW, MIDSLOW, MID, MIDFAST, FAST, FASTEST, localZoomSpeed };
    }
    
    private ZoomSpeed(int paramInt)
    {
      this.mCmd = paramInt;
    }
    
    public static ZoomSpeed find(int paramInt)
    {
      ZoomSpeed localZoomSpeed = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localZoomSpeed;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mCmd == paramInt;
    }
    
    public int getCmd()
    {
      return this.mCmd;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetOpticsZoomMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */