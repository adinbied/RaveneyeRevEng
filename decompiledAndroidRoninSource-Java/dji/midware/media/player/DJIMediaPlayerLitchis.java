package dji.midware.media.player;

import dji.logic.album.manager.litchis.DJIFileStreamLoader;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnCacheFileChangeListener;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnCacheRenameListener;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnPreparedListener;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnSeekCompleteListener;

class DJIMediaPlayerLitchis
  extends DJIMediaPlayer
{
  private DJIFileStreamLoader streamLoader;
  
  public DJIMediaPlayerLitchis(int... paramVarArgs)
  {
    super(paramVarArgs);
    paramVarArgs = new DJIFileStreamLoader();
    this.streamLoader = paramVarArgs;
    paramVarArgs.setReceiverIdInProtocol(this.receiverIdInProtocol);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayerLitchis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */