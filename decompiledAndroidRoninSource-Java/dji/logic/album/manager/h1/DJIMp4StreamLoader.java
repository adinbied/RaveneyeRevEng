package dji.logic.album.manager.h1;

import dji.logic.album.manager.litchis.DJIFileStreamLoader;
import dji.midware.interfaces.DJIDataCallBack;

public class DJIMp4StreamLoader
  extends DJIFileStreamLoader
{
  private Mp4PreReadListener preReadListener;
  private boolean requestHeader = false;
  private boolean requestTail = false;
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemFileData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setListener(dji.logic.album.model.DJIAlbumFileInfo arg1, dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener<dji.logic.album.model.DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPreReadListener(Mp4PreReadListener paramMp4PreReadListener)
  {
    this.preReadListener = paramMp4PreReadListener;
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
  public void startLoadHeader()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startLoadTail(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static abstract interface Mp4PreReadListener
  {
    public abstract void onPreReadComplete();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\h1\DJIMp4StreamLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */