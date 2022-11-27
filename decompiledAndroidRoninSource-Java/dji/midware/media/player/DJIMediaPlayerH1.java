package dji.midware.media.player;

import dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener;
import dji.logic.album.manager.h1.DJIMp4StreamLoader;
import dji.logic.album.manager.h1.DJIMp4StreamLoader.Mp4PreReadListener;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnCacheFileChangeListener;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnCacheRenameListener;
import dji.logic.album.manager.litchis.DJIFileStreamLoader.OnPreparedListener;
import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumPullErrorType;
import dji.midware.media.mp4.MP4Info;

public class DJIMediaPlayerH1
  extends DJIMediaPlayer
  implements DJIMp4StreamLoader.Mp4PreReadListener
{
  private int curMp4Index = 0;
  private long curWriteOffset = 0L;
  private long delay = 0L;
  protected DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> listener = new DJIAlbumInterface.DJIAlbumPullListener()
  {
    public void onFailure(DJIAlbumPullErrorType paramAnonymousDJIAlbumPullErrorType) {}
    
    public void onProgress(long paramAnonymousLong1, long paramAnonymousLong2) {}
    
    public void onRateUpdate(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3) {}
    
    public void onStart() {}
    
    public void onSuccess(DJIAlbumFile paramAnonymousDJIAlbumFile) {}
  };
  private MP4Info mp4Info;
  private DJIMp4StreamLoader streamLoader;
  
  public DJIMediaPlayerH1(int... paramVarArgs)
  {
    super(paramVarArgs);
    paramVarArgs = new DJIMp4StreamLoader();
    this.streamLoader = paramVarArgs;
    paramVarArgs.setReceiverIdInProtocol(this.receiverIdInProtocol);
  }
  
  /* Error */
  private void replaceSliceHeader(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void abortStream()
  {
    this.streamLoader.abort();
  }
  
  protected String getStreamCachePath()
  {
    return this.streamLoader.getCachePath();
  }
  
  public byte[] insertSPSPPS()
  {
    return null;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onPreReadComplete()
  {
    this.isPlaying = 1;
    startStream();
  }
  
  protected void onRateUpdate(long paramLong1, long paramLong2, long paramLong3) {}
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void preLoad()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  public void seekTo(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
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
  public void start()
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
  
  private class VideoThread
    extends Thread
  {
    private VideoThread() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayerH1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */