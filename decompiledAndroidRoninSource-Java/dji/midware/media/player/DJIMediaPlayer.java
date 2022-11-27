package dji.midware.media.player;

import android.content.Context;
import dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener;
import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import dji.logic.album.model.DJIAlbumPullErrorType;
import dji.midware.natives.FPVController;
import java.io.RandomAccessFile;
import java.util.Timer;
import java.util.TimerTask;

public abstract class DJIMediaPlayer
{
  protected static boolean isDebug = false;
  protected static final int persize = 262144;
  protected String TAG = getClass().getSimpleName();
  protected RandomAccessFile accessFile;
  protected byte[] buffer = new byte[1048576];
  protected int cachedPos;
  protected Context context;
  protected Timer durTimer;
  protected int duration;
  protected DJIAlbumFileInfo fileInfo;
  protected long fileLen;
  protected boolean isBuffered = false;
  protected boolean isBuffering = false;
  protected volatile int isPlaying = 0;
  protected DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> listener = new DJIAlbumInterface.DJIAlbumPullListener()
  {
    /* Error */
    public void onFailure(DJIAlbumPullErrorType arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onProgress(long paramAnonymousLong1, long paramAnonymousLong2) {}
    
    /* Error */
    public void onRateUpdate(long arg1, long arg3, long arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore 7
      //   3: goto -3 -> 0
    }
    
    public void onStart()
    {
      DJIMediaPlayer.this.isBuffered = false;
    }
    
    /* Error */
    public void onSuccess(DJIAlbumFile arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  protected OnBufferingUpdateListener mOnBufferingUpdateListener;
  private OnCompletionListener mOnCompletionListener;
  private OnErrorListener mOnErrorListener;
  protected OnIframeRecvListener mOnIframeRecvListener;
  protected OnPreparedListener mOnPreparedListener;
  protected OnSeekCompleteListener mOnSeekCompleteListener;
  private OnTimeUpdateListener mOnTimeUpdateListener;
  protected boolean needRebuffer = false;
  protected long playedOffset = 0L;
  protected int position;
  protected int qsize = 0;
  protected int receiverIdInProtocol = -1;
  protected long seekToOffset;
  protected long toBufferLen;
  protected long toBufferPosition;
  
  public DJIMediaPlayer(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.receiverIdInProtocol = paramVarArgs[0];
    }
  }
  
  protected abstract void abortStream();
  
  public boolean canSeek()
  {
    return this.duration != 0;
  }
  
  public int getCurrentPosition()
  {
    return this.position;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  protected abstract String getStreamCachePath();
  
  public boolean isBuffering()
  {
    return this.isBuffering;
  }
  
  public int isPlaying()
  {
    return this.isPlaying;
  }
  
  protected void myParser(byte[] paramArrayOfByte, int paramInt)
  {
    FPVController.native_transferVideoData(paramArrayOfByte, paramInt);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPlayOver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void onRateUpdate(long paramLong1, long paramLong2, long paramLong3);
  
  /* Error */
  protected void openCacheFileStream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void readFileToPlay()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void restartFromCurrent() {}
  
  /* Error */
  public void resume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void seekStream(int paramInt);
  
  /* Error */
  public void seekTo(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void setDataResource(DJIAlbumFileInfo paramDJIAlbumFileInfo)
  {
    this.fileInfo = DJIAlbumFileInfo.copy(paramDJIAlbumFileInfo);
  }
  
  public void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
  }
  
  public void setOnCompletionListener(OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnIframeRecvListener(OnIframeRecvListener paramOnIframeRecvListener)
  {
    this.mOnIframeRecvListener = paramOnIframeRecvListener;
  }
  
  public void setOnPreparedListener(OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnTimeUpdateListener(OnTimeUpdateListener paramOnTimeUpdateListener)
  {
    this.mOnTimeUpdateListener = paramOnTimeUpdateListener;
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
  protected void startDurTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void startStream();
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(DJIMediaPlayer paramDJIMediaPlayer, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(DJIMediaPlayer paramDJIMediaPlayer);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(DJIMediaPlayer paramDJIMediaPlayer, DJIAlbumPullErrorType paramDJIAlbumPullErrorType);
  }
  
  public static abstract interface OnIframeRecvListener
  {
    public abstract void onIFrameReceive();
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(DJIMediaPlayer paramDJIMediaPlayer);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(DJIMediaPlayer paramDJIMediaPlayer);
  }
  
  public static abstract interface OnTimeUpdateListener
  {
    public abstract void onUpdate(DJIMediaPlayer paramDJIMediaPlayer, int paramInt1, int paramInt2);
  }
  
  private class PlayThread
    extends Thread
  {
    private PlayThread() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */