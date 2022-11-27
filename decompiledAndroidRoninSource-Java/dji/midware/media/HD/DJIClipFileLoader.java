package dji.midware.media.HD;

import dji.logic.album.manager.litchis.DJILoader;

public class DJIClipFileLoader
  extends DJILoader<DJIClipFile>
{
  protected byte[] buffer = new byte[5242880];
  protected DJIClipFile clipFile = new DJIClipFile();
  protected DJIClipInfo clipInfo;
  private int cttt = 0;
  private boolean isOpenSliceMode = false;
  protected String nameKey;
  private int sliseIndex = 1;
  private int sliseLen = 41943040;
  private int sliseNum = 0;
  protected long tOffset = 0L;
  
  public DJIClipFileLoader()
  {
    this.timeOutMax = 3;
    this.checkDelay = 1500;
  }
  
  private long getSliceSize()
  {
    return 277703599L;
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
  private void sendCommand()
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
  public void setListener(DJIClipInfo arg1, dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener<DJIClipFile> arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\HD\DJIClipFileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */