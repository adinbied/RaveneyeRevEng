package dji.midware.media.HD;

import dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener;
import dji.logic.album.manager.litchis.DJILoader;
import dji.midware.data.manager.P3.DJIVideoPackManager;

public class DJIClipInfoListLoader
  extends DJILoader<DJIClipInfoList>
{
  private static final String TAG = "DJIClipInfoListLoader";
  private byte[] buffer;
  private DJIClipInfoList dirInfo = new DJIClipInfoList();
  private int groupID;
  
  public DJIClipInfoListLoader()
  {
    this.checkDelay = 1000;
    this.timeOutMax = 10;
  }
  
  /* Error */
  private void recvOver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void sendCommand()
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
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.litchis.DataCameraFileSystemListInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  
  public void setGroupID(int paramInt)
  {
    this.groupID = paramInt;
  }
  
  public void setListener(DJIAlbumInterface.DJIAlbumPullListener<DJIClipInfoList> paramDJIAlbumPullListener)
  {
    this.listener = paramDJIAlbumPullListener;
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
  
  public void testStart()
  {
    DJIVideoPackManager.getInstance().start();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\HD\DJIClipInfoListLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */