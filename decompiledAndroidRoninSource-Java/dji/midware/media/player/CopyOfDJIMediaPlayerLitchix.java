package dji.midware.media.player;

import dji.log.DJILogHelper;
import dji.logic.album.manager.litchis.DJIStreamLoader;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnCacheFileChangeListener;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnCacheRenameListener;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnPreparedListener;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnSeekCompleteListener;
import dji.midware.natives.FPVController;

class CopyOfDJIMediaPlayerLitchix
  extends DJIMediaPlayer
{
  private float cacheTime = this.buffer.length * 1.0F / 262144.0F;
  private byte[] containBuffer = new byte[1228800];
  private volatile int containPos = 0;
  byte[] header = { 68, 74, 65, 86 };
  private boolean isGettedHeader = false;
  boolean isGettedMixType = false;
  boolean isMixStream = false;
  private boolean isNeedRedo = false;
  private volatile boolean isSeeking = false;
  long magic = FPVController.native_getDJIAVPaserHeaderMagic();
  private int myHeaderIndex = 0;
  private int packType = 0;
  private int packVer = 0;
  private volatile int parsePos = 0;
  private byte[] ptsBuffer = new byte[8];
  private volatile int remainSize = 0;
  private DJIStreamLoader streamLoader = new DJIStreamLoader();
  private int tempContainPos = 0;
  private int testnum = 0;
  private byte[] tmpBuffer = new byte[1228800];
  
  public CopyOfDJIMediaPlayerLitchix()
  {
    super(new int[0]);
    this.buffer = new byte[819200];
    DJILogHelper localDJILogHelper = DJILogHelper.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("magic = ");
    localStringBuilder.append(this.magic);
    localDJILogHelper.LOGD("", localStringBuilder.toString());
  }
  
  /* Error */
  private void checkHeader()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void parseData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void resetContailPos()
  {
    this.containPos = this.tempContainPos;
  }
  
  protected void abortStream()
  {
    this.streamLoader.abort();
  }
  
  protected String getStreamCachePath()
  {
    return this.streamLoader.getCachePath();
  }
  
  /* Error */
  protected void myParser(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  protected void onRateUpdate(long arg1, long arg3, long arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  protected void restartFromCurrent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void seekStream(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void setDataResource(dji.logic.album.model.DJIAlbumFileInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void startStream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\CopyOfDJIMediaPlayerLitchix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */