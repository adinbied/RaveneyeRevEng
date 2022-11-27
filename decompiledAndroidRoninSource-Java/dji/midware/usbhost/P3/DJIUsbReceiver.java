package dji.midware.usbhost.P3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;

public class DJIUsbReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_USB_PERMISSION = "com.dji.host.USB";
  private static final int PID = 4098;
  private static final int VID = 1351;
  private final String TAG = getClass().getSimpleName();
  private UsbDeviceConnection conn;
  private Context context;
  private UsbDevice myUsbDevice;
  private UsbEndpoint osdEndpoint;
  private UsbEndpoint outEndpoint;
  private UsbInterface usbInterface;
  private UsbManager usbManager;
  private UsbEndpoint vodEndpoint;
  
  private boolean checkMyDevice()
  {
    return false;
  }
  
  /* Error */
  private void connected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void disconnected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getEndPoints(UsbInterface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void print(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void printUI(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected UsbDeviceConnection getConnection()
  {
    try
    {
      UsbDeviceConnection localUsbDeviceConnection = this.conn;
      return localUsbDeviceConnection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected UsbEndpoint getOsdEndpoint()
  {
    return this.osdEndpoint;
  }
  
  protected UsbEndpoint getOutEndpoint()
  {
    return this.outEndpoint;
  }
  
  protected UsbEndpoint getVodEndpoint()
  {
    return this.vodEndpoint;
  }
  
  protected boolean isGetedConnection()
  {
    return this.conn != null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    printUI(paramContext);
    if (paramContext.equals("com.dji.host.USB"))
    {
      if (!this.usbManager.hasPermission(this.myUsbDevice))
      {
        printUI("no usbhost permission");
        return;
      }
      printUI("has usbhost permission");
      connected();
      return;
    }
    if (paramContext.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED"))
    {
      if (checkMyDevice()) {
        connected();
      }
    }
    else if (paramContext.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
      disconnected();
    }
  }
  
  /* Error */
  public void start(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usbhost\P3\DJIUsbReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */