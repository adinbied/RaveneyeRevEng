package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetUsbStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetUsbStatus instance;
  
  public static DataCameraGetUsbStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetUsbStatus();
      }
      DataCameraGetUsbStatus localDataCameraGetUsbStatus = instance;
      return localDataCameraGetUsbStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public USBSTATUS getUSBStatus()
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
  
  public static enum USBSTATUS
  {
    private int value;
    
    static
    {
      USBSTATUS localUSBSTATUS = new USBSTATUS("CONNECT", 1, 1);
      CONNECT = localUSBSTATUS;
      $VALUES = new USBSTATUS[] { DISCONNECT, localUSBSTATUS };
    }
    
    private USBSTATUS(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetUsbStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */