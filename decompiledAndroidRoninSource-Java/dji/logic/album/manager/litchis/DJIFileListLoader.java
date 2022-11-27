package dji.logic.album.manager.litchis;

import dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener;
import dji.logic.album.model.DJIAlbumDirInfo;
import dji.midware.data.manager.P3.DJIVideoPackManager;
import dji.midware.data.model.litchis.DataCameraFileSystemPush;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIFileListLoader
  extends DJILoader<DJIAlbumDirInfo>
{
  private byte[] buffer;
  private DJIAlbumDirInfo dirInfo = new DJIAlbumDirInfo();
  
  public DJIFileListLoader()
  {
    this.timeOutMax = 2;
    this.checkDelay = 5000;
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
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemListInfo arg1)
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
  protected void resendMe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setListener(DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumDirInfo> paramDJIAlbumPullListener)
  {
    this.listener = paramDJIAlbumPullListener;
  }
  
  public void start()
  {
    start(1);
  }
  
  /* Error */
  public void start(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  
  public void testStart()
  {
    DJIVideoPackManager.getInstance().start();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIFileListLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */