package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetSDRImageTransmMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetSDRImageTransmMode instance;
  private SDRImageTransmMode mImageTransmMode = SDRImageTransmMode.SMOOTH;
  
  public static DataOsdSetSDRImageTransmMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetSDRImageTransmMode();
      }
      DataOsdSetSDRImageTransmMode localDataOsdSetSDRImageTransmMode = instance;
      return localDataOsdSetSDRImageTransmMode;
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
  
  public DataOsdSetSDRImageTransmMode setMode(SDRImageTransmMode paramSDRImageTransmMode)
  {
    this.mImageTransmMode = paramSDRImageTransmMode;
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
  
  public static enum SDRImageTransmMode
  {
    private int data;
    
    static
    {
      HD = new SDRImageTransmMode("HD", 1, 1);
      SDRImageTransmMode localSDRImageTransmMode = new SDRImageTransmMode("NONE", 2, 10);
      NONE = localSDRImageTransmMode;
      $VALUES = new SDRImageTransmMode[] { SMOOTH, HD, localSDRImageTransmMode };
    }
    
    private SDRImageTransmMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SDRImageTransmMode find(int paramInt)
    {
      SDRImageTransmMode[] arrayOfSDRImageTransmMode = values();
      int j = arrayOfSDRImageTransmMode.length;
      int i = 0;
      while (i != j)
      {
        if (paramInt == arrayOfSDRImageTransmMode[i].value()) {
          return arrayOfSDRImageTransmMode[i];
        }
        i += 1;
      }
      return NONE;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetSDRImageTransmMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */