package dji.midware.media.transcode.offline;

public class TranscoderFFmpeg
  extends TranscoderBase
  implements TranscoderInterface
{
  public static String TAG = "TranscoderFFmpeg";
  private Exception error = null;
  ThreadFFMpegMonitor ffMpegMonitor = null;
  boolean monitorRunning = false;
  TranscodeThread transcodeThread = null;
  
  String getTAG()
  {
    return TAG;
  }
  
  /* Error */
  public void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onStopByForce()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class ThreadFFMpegMonitor
    extends Thread
  {
    private ThreadFFMpegMonitor() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class TranscodeThread
    extends Thread
  {
    private TranscodeThread() {}
    
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\TranscoderFFmpeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */