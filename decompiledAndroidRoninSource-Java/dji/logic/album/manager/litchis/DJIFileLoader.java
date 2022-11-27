package dji.logic.album.manager.litchis;

import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import dji.midware.data.config.litchis.DataConfig.SubType;

public class DJIFileLoader
  extends DJILoader<DJIAlbumFile>
{
  protected DJIAlbumFile alburmFile = new DJIAlbumFile();
  protected byte[] buffer = new byte[2097152];
  private int cttt = 0;
  protected DJIAlbumFileInfo fileInfo;
  private boolean isDebug = false;
  private boolean isOpenSliceMode = false;
  private boolean isPanoSubimageDownload;
  protected String nameKey;
  private int sliseIndex = 1;
  private int sliseLen = 41943040;
  private int sliseNum = 0;
  protected DataConfig.SubType subType;
  protected long tOffset = 0L;
  private long tmpTime;
  
  public DJIFileLoader()
  {
    this.timeOutMax = 3;
    this.checkDelay = 1500;
    if (this.isDebug) {
      this.checkDelay = 150000000;
    }
  }
  
  private long getSliceSize()
  {
    return 211343069L;
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
  private void restart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void writeFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void abort()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean cacheCheck()
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
    destroyMe();
  }
  
  /* Error */
  protected void getCacheKey()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  /* Error */
  protected void reSend()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setListener(DJIAlbumFileInfo arg1, dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setType(DataConfig.SubType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIFileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */