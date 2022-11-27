package dji.logic.album.manager.litchis;

import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import dji.midware.data.model.litchis.DataRequestAbort.AbortReason;
import java.util.Timer;
import java.util.TimerTask;

public class DJIStreamLoader
  extends DJILoader<DJIAlbumFile>
{
  public static final int bufferSize = 819200;
  protected DJIAlbumFile alburmFile = new DJIAlbumFile();
  protected byte[] buffer = new byte[819200];
  protected DJIAlbumFileInfo fileInfo;
  private int foffset = 0;
  private boolean isCached = false;
  private boolean isPrepared = false;
  private boolean isSeekd = false;
  private boolean isresend = false;
  private OnCacheFileChangeListener mOnCacheFileChangeListener;
  private OnCacheRenameListener mOnCacheRenameListener;
  private OnPreparedListener mOnPreparedListener;
  private OnSeekCompleteListener mOnSeekCompleteListener;
  private Timer mTimer;
  protected String nameKey;
  protected String nameKeyOver;
  int persize = 262144;
  private long seekOffset = 0L;
  protected long tOffset = 0L;
  private int tmpSeq = 0;
  private long tmpTime = 0L;
  private int ttt = 0;
  
  public DJIStreamLoader()
  {
    this.timeOutMax = 3;
    this.checkDelay = 4000;
  }
  
  private boolean copyToFile()
  {
    return false;
  }
  
  /* Error */
  private void doStart(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void recvOver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void abort()
  {
    abort(DataRequestAbort.AbortReason.Force);
  }
  
  /* Error */
  public void abort(DataRequestAbort.AbortReason arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void countProgress() {}
  
  /* Error */
  protected void countRate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void destroy()
  {
    this.buffer = null;
    destroyMe();
  }
  
  public String getCachePath()
  {
    return this.alburmFile.cachPath;
  }
  
  public boolean isCached()
  {
    return this.isCached;
  }
  
  public boolean isPrepared()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemPush arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemStreamData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void reSend()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void restart()
  {
    start(this.seekOffset);
  }
  
  public void seek(long paramLong)
  {
    this.isSeekd = true;
    doStart(paramLong);
  }
  
  /* Error */
  public void setListener(DJIAlbumFileInfo arg1, dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnCacheFileChangeListener(OnCacheFileChangeListener paramOnCacheFileChangeListener)
  {
    this.mOnCacheFileChangeListener = paramOnCacheFileChangeListener;
  }
  
  public void setOnCacheRenameListener(OnCacheRenameListener paramOnCacheRenameListener)
  {
    this.mOnCacheRenameListener = paramOnCacheRenameListener;
  }
  
  public void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setPreparedListener(OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void start(long paramLong)
  {
    doStart(paramLong);
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface OnCacheFileChangeListener
  {
    public abstract void onChange(long paramLong);
  }
  
  public static abstract interface OnCacheRenameListener
  {
    public abstract void onChange();
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(DJIAlbumFile paramDJIAlbumFile);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(DJIAlbumFile paramDJIAlbumFile);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIStreamLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */