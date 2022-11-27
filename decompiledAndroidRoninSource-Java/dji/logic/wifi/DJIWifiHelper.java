package dji.logic.wifi;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import org.greenrobot.eventbus.EventBus;

public class DJIWifiHelper
{
  private static final long DELAY_REQUEST_PUSHSNR = 100L;
  private static final int MSG_ID_REQUEST_G_PUSHSNR = 4096;
  private static final int MSG_ID_REQUEST_PUSHSNR = 4097;
  private static final boolean REQUEST_SNRPUSH = true;
  private static final String TAG = DJIWifiHelper.class.getSimpleName();
  private final Handler mHandler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  private volatile boolean mMultipleChannel = false;
  private ProductType mProductType = ProductType.OTHER;
  
  private DJIWifiHelper()
  {
    EventBus.getDefault().register(this);
    onEvent3BackgroundThread(DJIProductManager.getInstance().getType());
  }
  
  public static DJIWifiHelper getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void handleRequestGSnrPush()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleRequestSnrPush()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(ProductType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataCameraEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setmMultipleChannelOpen(boolean paramBoolean)
  {
    this.mMultipleChannel = paramBoolean;
    if (paramBoolean)
    {
      handleRequestGSnrPush();
      handleRequestSnrPush();
    }
  }
  
  private static final class SingletonHolder
  {
    private static final DJIWifiHelper mInstance = new DJIWifiHelper(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\wifi\DJIWifiHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */