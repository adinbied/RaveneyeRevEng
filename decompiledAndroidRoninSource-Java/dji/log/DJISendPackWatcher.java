package dji.log;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import dji.midware.data.packages.P3.SendPack;
import org.greenrobot.eventbus.EventBus;

public class DJISendPackWatcher
{
  private static final int MSG_DUMPINFO = 1;
  private static final int MSG_DUMPPACK = 0;
  private static final String TAG = "PackWatcher";
  private volatile int mBeforeDisplayCodec = 0;
  private volatile int mBeforeQueneOutCodec = 0;
  private volatile int mBeforeQueneToCodec = 0;
  private volatile long mBeforeRecvLength = 0L;
  private volatile long mBeforeSendLength = 0L;
  private Handler mHandler = null;
  private volatile int mTotalDisplayCodec = 0;
  private volatile int mTotalQueneOutCodec = 0;
  private volatile int mTotalQueneToCodec = 0;
  private volatile long mTotalReceviceLength = 0L;
  private volatile long mTotalSendLength = 0L;
  
  private DJISendPackWatcher()
  {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    Object localObject = new HandlerThread("PackWatcher");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        return false;
      }
    });
    this.mHandler = ((Handler)localObject);
    ((Handler)localObject).sendEmptyMessageDelayed(0, 1000L);
  }
  
  public static DJISendPackWatcher getInstance()
  {
    return SingletonHolder.mInstance;
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
  
  public void printfFrame(int paramInt, long paramLong) {}
  
  public void watchCmd(SendPack paramSendPack) {}
  
  /* Error */
  public void watchCodecIn(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void watchCodecOut(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void watchDisplay(int paramInt)
  {
    this.mTotalDisplayCodec += paramInt;
  }
  
  /* Error */
  public void watchPack(dji.midware.data.packages.P3.Pack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void watchPack(boolean arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private static final class SingletonHolder
  {
    private static final DJISendPackWatcher mInstance = new DJISendPackWatcher(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJISendPackWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */