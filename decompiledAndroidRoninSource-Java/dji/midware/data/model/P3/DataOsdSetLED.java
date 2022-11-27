package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetLED
  extends DataBase
  implements DJIDataSyncListener
{
  private LEDCtlUnit mBlueUnit = new LEDCtlUnit(1, 0, 32, 1);
  private LEDCtlUnit mGreenUnit = new LEDCtlUnit(1, 0, 32, 1);
  private LEDCtlUnit mRedUnit = new LEDCtlUnit(1, 0, 32, 1);
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataOsdSetLED reset()
  {
    return null;
  }
  
  public DataOsdSetLED setBlueUnit(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public DataOsdSetLED setGreenUnit(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public DataOsdSetLED setRedUnit(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public class LEDCtlUnit
  {
    char isControl;
    char length;
    char repeatcount;
    int sequence;
    
    public LEDCtlUnit(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.isControl = ((char)paramInt1);
      this.sequence = paramInt2;
      this.length = ((char)paramInt3);
      this.repeatcount = ((char)paramInt4);
    }
    
    /* Error */
    public void reset()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetLED.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */