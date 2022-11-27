package dji.midware.media.HD;

import dji.midware.media.transcode.offline.TranscoderInterface;
import dji.midware.media.transcode.offline.TranscoderListener;

public class HDConvTest
  implements TranscoderInterface
{
  TranscoderListener listener;
  
  public int getCurProgress()
  {
    return 0;
  }
  
  public String getInputFileName()
  {
    return null;
  }
  
  public boolean isTranscoding()
  {
    return false;
  }
  
  public void onDestroy() {}
  
  public void rebindListener(TranscoderListener paramTranscoderListener) {}
  
  /* Error */
  public void start(String arg1, String arg2, TranscoderListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void stop() {}
  
  public class TestFileExistCallBack
    implements HDConversion.CallBackGetHD
  {
    public int fileID;
    
    public TestFileExistCallBack() {}
    
    public void onFail(Exception paramException) {}
    
    /* Error */
    public void onProgress(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public void onStart() {}
    
    public void onSuccess() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\HD\HDConvTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */