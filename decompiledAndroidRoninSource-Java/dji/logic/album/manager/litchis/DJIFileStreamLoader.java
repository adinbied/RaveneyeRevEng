package dji.logic.album.manager.litchis;

import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;

public class DJIFileStreamLoader
  extends DJILoader<DJIAlbumFile>
{
  public static final int bufferSize = 307200;
  protected DJIAlbumFile alburmFile = new DJIAlbumFile();
  protected byte[] buffer = new byte[307200];
  protected DJIAlbumFileInfo fileInfo;
  protected int foffset = 0;
  public boolean hasSeek = false;
  protected boolean isCached = false;
  protected boolean isPrepared = false;
  protected OnCacheFileChangeListener mOnCacheFileChangeListener;
  protected OnCacheRenameListener mOnCacheRenameListener;
  protected OnPreparedListener mOnPreparedListener;
  protected OnSeekCompleteListener mOnSeekCompleteListener;
  protected String nameKey;
  protected String nameKeyOver;
  protected long seekOffset = 0L;
  protected long tOffset = 0L;
  protected int ttt = 0;
  
  public DJIFileStreamLoader()
  {
    this.timeOutMax = 5;
    this.checkDelay = 1500;
  }
  
  /* Error */
  public void abort()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean copyToFile()
  {
    return false;
  }
  
  /* Error */
  protected void countProgress()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
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
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemFileData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  public void onSeek()
  {
    this.hasSeek = true;
  }
  
  /* Error */
  protected void reSend()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void recvOver()
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
  
  public void start()
  {
    start(0L);
  }
  
  /* Error */
  public void start(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
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
  
  /* Error */
  protected void writeFile()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIFileStreamLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */