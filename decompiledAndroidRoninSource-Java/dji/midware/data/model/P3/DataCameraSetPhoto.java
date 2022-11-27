package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataAsyncListener;
import java.util.Timer;
import java.util.TimerTask;

public class DataCameraSetPhoto
  extends DataBase
  implements DJIDataAsyncListener
{
  private static DataCameraSetPhoto instance;
  private Timer timer;
  private TYPE type;
  
  public static DataCameraSetPhoto getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetPhoto();
      }
      DataCameraSetPhoto localDataCameraSetPhoto = instance;
      return localDataCameraSetPhoto;
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
  
  public DataCameraSetPhoto setType(TYPE paramTYPE)
  {
    this.type = paramTYPE;
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
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum TYPE
  {
    private int data;
    
    static
    {
      SINGLE = new TYPE("SINGLE", 1, 1);
      HDR = new TYPE("HDR", 2, 2);
      FULLVIEW = new TYPE("FULLVIEW", 3, 3);
      BURST = new TYPE("BURST", 4, 4);
      AEB = new TYPE("AEB", 5, 5);
      TIME = new TYPE("TIME", 6, 6);
      APP_FULLVIEW = new TYPE("APP_FULLVIEW", 7, 7);
      TRACKING = new TYPE("TRACKING", 8, 8);
      RAWBURST = new TYPE("RAWBURST", 9, 9);
      BOKEH = new TYPE("BOKEH", 10, 98);
      PANORAMA = new TYPE("PANORAMA", 11, 99);
      TYPE localTYPE = new TYPE("OTHER", 12, 11);
      OTHER = localTYPE;
      $VALUES = new TYPE[] { STOP, SINGLE, HDR, FULLVIEW, BURST, AEB, TIME, APP_FULLVIEW, TRACKING, RAWBURST, BOKEH, PANORAMA, localTYPE };
    }
    
    private TYPE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TYPE find(int paramInt)
    {
      TYPE localTYPE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTYPE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */