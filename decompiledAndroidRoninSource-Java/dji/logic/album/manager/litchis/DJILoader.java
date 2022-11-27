package dji.logic.album.manager.litchis;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import dji.logic.album.manager.DJIAlbumCacheManager;
import dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

public abstract class DJILoader<E>
{
  protected final int MSG_CHECK = 4;
  protected final int MSG_FAILURE = 1;
  protected final int MSG_PROGRESS = 2;
  protected final int MSG_RATE = 5;
  protected final int MSG_START = 3;
  protected final int MSG_SUCCESS = 0;
  protected final String TAG = getClass().getSimpleName();
  protected DJIAlbumCacheManager cacheManager = DJIAlbumCacheManager.getInstance();
  protected int checkDelay = 1000;
  protected int curSeq = 0;
  protected Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  protected boolean isAlive = false;
  protected boolean isRecvOver = false;
  protected DJIAlbumInterface.DJIAlbumPullListener<E> listener;
  protected int nextSeq = 0;
  protected int offset = 0;
  protected long offsetTmp = 0L;
  protected Timer progTimer;
  protected int receiverIdInProtocol = -1;
  protected boolean resending = false;
  protected int timeOutMax = 0;
  protected int timeoutNum = 0;
  
  public DJILoader()
  {
    EventBus.getDefault().register(this);
  }
  
  public abstract void abort();
  
  protected void checkPushStatus()
  {
    this.timeoutNum = 0;
    freshPushStatus();
  }
  
  protected void clearTimeout()
  {
    this.timeoutNum = 0;
  }
  
  protected abstract void countProgress();
  
  protected abstract void countRate();
  
  public abstract void destroy();
  
  protected void destroyMe()
  {
    EventBus.getDefault().unregister(this);
  }
  
  /* Error */
  protected void freshPushStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getReceiverIdInProtocol()
  {
    return this.receiverIdInProtocol;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemAbort arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void reSend();
  
  /* Error */
  protected void resendMe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setReceiverIdInProtocol(int paramInt)
  {
    this.receiverIdInProtocol = paramInt;
  }
  
  public void start()
  {
    this.handler.sendEmptyMessage(3);
  }
  
  /* Error */
  protected void startMe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public abstract void stop();
  
  /* Error */
  protected void stopMe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJILoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */