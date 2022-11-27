package dji.midware.media.transcode.offline;

import dji.midware.media.metadata.VideoRecordInfo;

public abstract class TranscoderBase
  implements TranscoderInterface
{
  protected static boolean deleteH264AfterTranscode = true;
  protected int curProgress;
  protected VideoRecordInfo info = null;
  protected String inputFileName = "";
  protected TranscoderListener listener = null;
  protected Object listenerChangeSync = new Object();
  protected String outputFileName = "";
  protected TranscoderStatus status = TranscoderStatus.STANDBY;
  protected Object transcoderStatusSync = new Object();
  
  /* Error */
  protected void addToMediaLibrary()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void deinitVideoInfo()
  {
    this.info = null;
  }
  
  public int getCurProgress()
  {
    return this.curProgress;
  }
  
  public String getInputFileName()
  {
    return this.inputFileName;
  }
  
  abstract String getTAG();
  
  /* Error */
  protected void initVideoInfo(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isTranscoding()
  {
    return false;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void onStart();
  
  protected abstract void onStopByForce();
  
  /* Error */
  public void rebindListener(TranscoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void saveInfoFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(String arg1, String arg2, TranscoderListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void tryDeleteH264File()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void tryDeleteThumbFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected static enum TranscoderStatus
  {
    static
    {
      TranscoderStatus localTranscoderStatus = new TranscoderStatus("TRANSCODING", 1);
      TRANSCODING = localTranscoderStatus;
      $VALUES = new TranscoderStatus[] { STANDBY, localTranscoderStatus };
    }
    
    private TranscoderStatus() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\TranscoderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */