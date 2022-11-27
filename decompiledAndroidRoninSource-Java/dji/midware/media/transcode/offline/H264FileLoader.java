package dji.midware.media.transcode.offline;

public class H264FileLoader
  implements Runnable
{
  private static final int FILE_READ_CHUNK_LENGTH = 102400;
  private static String TAG = "H264FileLoader";
  private long bytesHasRead;
  private long inputFileLength;
  private String inputFullFileName = "";
  private boolean isPause;
  private boolean isStop;
  private ProgressListener progressListener = null;
  private Thread threadLoadFile = null;
  
  private int getProgress()
  {
    return 0;
  }
  
  /* Error */
  public void LoadFile(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void join()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void pause()
  {
    this.isPause = true;
  }
  
  public void resume()
  {
    this.isPause = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setProgressListener(ProgressListener paramProgressListener)
  {
    this.progressListener = paramProgressListener;
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface ProgressListener
  {
    public abstract void onProgress(int paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\H264FileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */