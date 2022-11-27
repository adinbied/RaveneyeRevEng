package dji.midware.media.player;

import android.content.Context;
import dji.midware.data.model.P3.DataCameraGetPushPlayBackParams.MODE;
import dji.midware.data.model.P3.DataCameraVideoControl;
import dji.midware.interfaces.DJIDataCallBack;
import org.greenrobot.eventbus.EventBus;

public class DJIMediaPlayerKumquat
  implements DJIMediaPlayerInterface
{
  private static final String TAG = "DJIMediaPlayerWM";
  private DataCameraGetPushPlayBackParams.MODE curMode = DataCameraGetPushPlayBackParams.MODE.OTHER;
  private int currentPos = -1;
  private int duration = -1;
  private int index;
  private boolean isOver = false;
  private boolean isPaused = false;
  private boolean isPlaying = true;
  private Context mContext;
  private DataCameraVideoControl mDataCameraVideoControl = DataCameraVideoControl.getInstance();
  private DJIMediaPlayKumquatListener mPlayWMListener;
  
  public DJIMediaPlayerKumquat()
  {
    EventBus.getDefault().register(this);
  }
  
  public void destroy()
  {
    EventBus.getDefault().unregister(this);
  }
  
  public int getCurrentPosition()
  {
    return this.currentPos;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public boolean isOver()
  {
    return this.isOver;
  }
  
  public boolean isPaused()
  {
    return this.isPaused;
  }
  
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  
  /* Error */
  public void logErrorStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushPlayBackParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void prepare() {}
  
  public void release() {}
  
  public void reset() {}
  
  /* Error */
  public void restart(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void seekTo(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setAudioStreamType(int paramInt) {}
  
  public void setDataSource(String paramString) {}
  
  public void setDisplay(Object paramObject) {}
  
  public void setMediaPlayerListener(DJIMediaPlayKumquatListener paramDJIMediaPlayKumquatListener)
  {
    this.mPlayWMListener = paramDJIMediaPlayKumquatListener;
  }
  
  public void setOnCompletionListener(DJIMediaPlayerInterface.OnCompletionListener paramOnCompletionListener) {}
  
  public void setOnSeekCompleteListener(DJIMediaPlayerInterface.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void setVideoFileIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface DJIMediaPlayKumquatListener
  {
    public abstract void onOver();
    
    public abstract void onPause();
    
    public abstract void onProgress(int paramInt1, int paramInt2);
    
    public abstract void onStart();
    
    public abstract void onStop();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayerKumquat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */