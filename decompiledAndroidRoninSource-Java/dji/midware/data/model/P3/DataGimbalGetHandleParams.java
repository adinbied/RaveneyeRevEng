package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalGetHandleParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataGimbalGetHandleParams";
  
  protected void doPack() {}
  
  public boolean getCellphoneSensorDisable()
  {
    return false;
  }
  
  public int getDualChannelEnable()
  {
    return 0;
  }
  
  public int getPanDirection()
  {
    return 0;
  }
  
  public int getPitchFree()
  {
    return 0;
  }
  
  public int getProfile()
  {
    return 0;
  }
  
  public boolean getRotationFocusEnable()
  {
    return false;
  }
  
  public int getTiltDirection()
  {
    return 0;
  }
  
  public boolean getZoom2SpeedEnable()
  {
    return false;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetHandleParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */