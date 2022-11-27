package dji.midware.media.player;

import dji.log.RoninLog;
import dji.logic.album.manager.litchis.DJIStreamLoader;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnCacheFileChangeListener;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnCacheRenameListener;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnPreparedListener;
import dji.logic.album.manager.litchis.DJIStreamLoader.OnSeekCompleteListener;
import dji.midware.natives.FPVController;
import dji.midware.parser.plugins.DJIPlaybackChanneParser;

class DJIMediaPlayerLitchix
  extends DJIMediaPlayer
{
  private float cacheTime = this.buffer.length * 1.0F / 262144.0F;
  boolean isGettedMixType = false;
  boolean isMixStream = false;
  private volatile boolean isSeeking = false;
  long magic = FPVController.native_getDJIAVPaserHeaderMagic();
  private long myFileLen;
  private DJIPlaybackChanneParser playbackChanneParser;
  private DJIStreamLoader streamLoader = new DJIStreamLoader();
  
  public DJIMediaPlayerLitchix()
  {
    super(new int[0]);
    this.buffer = new byte[819200];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("magic = ");
    localStringBuilder.append(this.magic);
    RoninLog.d("", localStringBuilder.toString(), new Object[0]);
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
    //   2: goto -2 -> 0
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
  protected void restartFromCurrent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resume()
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
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayerLitchix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */