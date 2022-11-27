package dji.midware.usb.P3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import dji.midware.util.BackgroundLooper;
import java.io.InputStream;
import java.io.OutputStream;

public class DJIUsbAccessoryReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_USB_ACCESSORY_ATTACHED = "com.dji.v4.accessory.USB_ACCESSORY_ATTACHED";
  public static final String ACTION_USB_PERMISSION = "com.dji.v4.accessory.USB";
  public static final String myFacturer = "DJI";
  public static final String myModel = "T600";
  private final String TAG = getClass().getSimpleName();
  private Context context;
  private Handler handler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  private volatile boolean isAccessoryDetached = true;
  private ParcelFileDescriptor mFileDescriptor;
  private InputStream mInputStream;
  private OutputStream mOutputStream;
  private volatile UsbAccessory myAccessory;
  private UsbManager usbManager;
  
  private boolean checkMyDevice(boolean paramBoolean)
  {
    return false;
  }
  
  private boolean checkPremission(UsbAccessory paramUsbAccessory, boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  private void connected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void connectedToAoaBright()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  private void requestPremission(UsbAccessory arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void toConnect(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  protected void clearTimer()
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
  
  /* Error */
  protected void destroySession()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void disconnected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected InputStream getInputStream()
  {
    return this.mInputStream;
  }
  
  protected OutputStream getOutputStream()
  {
    return this.mOutputStream;
  }
  
  public boolean isGetedConnection()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.aoabridge.AoaController.RcEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReceive(Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usb\P3\DJIUsbAccessoryReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */