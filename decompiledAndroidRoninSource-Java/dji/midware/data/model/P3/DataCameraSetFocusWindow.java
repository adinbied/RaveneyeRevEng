package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetFocusWindow
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetFocusWindow instance;
  private int mPrecision = 0;
  private int mXAxisWindowNum = 1;
  private int mYAxisWindowNum = 1;
  
  public static DataCameraSetFocusWindow getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetFocusWindow();
      }
      DataCameraSetFocusWindow localDataCameraSetFocusWindow = instance;
      return localDataCameraSetFocusWindow;
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
  
  public DataCameraSetFocusWindow setPrecision(int paramInt)
  {
    this.mPrecision = paramInt;
    return this;
  }
  
  public DataCameraSetFocusWindow setWindowX(int paramInt)
  {
    this.mXAxisWindowNum = paramInt;
    return this;
  }
  
  public DataCameraSetFocusWindow setWindowY(int paramInt)
  {
    this.mYAxisWindowNum = paramInt;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetFocusWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */