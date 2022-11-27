package dji.midware.media.transcode.offline;

public class TranscoderAndroid
  extends TranscoderBase
  implements TranscoderInterface, Runnable
{
  public static String TAG = "TranscoderAndroid";
  private EncoderMuxer encoderMuxer = null;
  private H264FileLoader h264FileLoader = null;
  public OfflineDecoder offlineDecoder = null;
  
  private boolean changeFileName()
  {
    return false;
  }
  
  /* Error */
  private void deleteTmpOutputFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initComponents()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean prepareFile()
  {
    return false;
  }
  
  /* Error */
  private void releaseComponents()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopLiveView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  String getTAG()
  {
    return TAG;
  }
  
  /* Error */
  protected void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStopByForce()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\TranscoderAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */