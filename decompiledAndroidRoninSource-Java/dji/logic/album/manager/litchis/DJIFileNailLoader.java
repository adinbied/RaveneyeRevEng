package dji.logic.album.manager.litchis;

import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import dji.midware.data.config.litchis.DataConfig.SubType;
import dji.midware.data.model.litchis.DataCameraFileSystemPush;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIFileNailLoader
  extends DJILoader<DJIAlbumFile>
{
  protected DJIAlbumFile alburmFile = new DJIAlbumFile();
  protected byte[] buffer;
  private int cttt = 0;
  protected DJIAlbumFileInfo fileInfo;
  protected String nameKey;
  protected int start;
  protected DataConfig.SubType subType;
  protected int thumbOffset;
  
  public DJIFileNailLoader()
  {
    this.timeOutMax = 1;
    this.checkDelay = 500;
  }
  
  private boolean cacheCheck()
  {
    return false;
  }
  
  /* Error */
  public void abort()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemFileData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraFileSystemPush paramDataCameraFileSystemPush)
  {
    if (!this.isAlive) {}
  }
  
  /* Error */
  protected void reSend()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void recvOver()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIFileNailLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */