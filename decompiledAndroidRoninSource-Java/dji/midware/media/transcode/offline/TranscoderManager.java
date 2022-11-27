package dji.midware.media.transcode.offline;

import android.os.Build.VERSION;
import dji.midware.media.DJIVideoUtil;

public class TranscoderManager
{
  public static String TAG = "TranscoderManager";
  public static FFMpegTools ffmpegTools;
  private static TranscoderInterface instance;
  public static byte[] pps;
  public static byte[] sps;
  
  public static void destroy()
  {
    try
    {
      if (instance != null)
      {
        instance.onDestroy();
        instance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getCurProgress(String paramString)
  {
    if (isTranscoding(paramString)) {
      return instance.getCurProgress();
    }
    return 0;
  }
  
  private static TranscoderInterface getInstance()
  {
    try
    {
      if (instance == null)
      {
        if (DJIVideoUtil.test)
        {
          localObject1 = new TranscoderFFmpeg();
          instance = (TranscoderInterface)localObject1;
          return (TranscoderInterface)localObject1;
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          localObject1 = new TranscoderAndroid();
          instance = (TranscoderInterface)localObject1;
          return (TranscoderInterface)localObject1;
        }
        if (DJIVideoUtil.useFFMpegForLowSDK)
        {
          localObject1 = new TranscoderFFmpeg();
          instance = (TranscoderInterface)localObject1;
          return (TranscoderInterface)localObject1;
        }
        localObject1 = new TranscoderAndroid();
        instance = (TranscoderInterface)localObject1;
        return (TranscoderInterface)localObject1;
      }
      Object localObject1 = instance;
      return (TranscoderInterface)localObject1;
    }
    finally {}
  }
  
  public static boolean isTranscoding()
  {
    TranscoderInterface localTranscoderInterface = instance;
    return (localTranscoderInterface != null) && (localTranscoderInterface.isTranscoding());
  }
  
  public static boolean isTranscoding(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    TranscoderInterface localTranscoderInterface = instance;
    return (localTranscoderInterface != null) && (paramString.equals(localTranscoderInterface.getInputFileName())) && (instance.isTranscoding());
  }
  
  public static void onUIDeactive()
  {
    TranscoderInterface localTranscoderInterface = instance;
    if (localTranscoderInterface != null) {
      localTranscoderInterface.rebindListener(null);
    }
  }
  
  public static void rebindListener(TranscoderListener paramTranscoderListener)
  {
    TranscoderInterface localTranscoderInterface = instance;
    if (localTranscoderInterface != null) {
      localTranscoderInterface.rebindListener(paramTranscoderListener);
    }
  }
  
  public static void setFFMpegTools(FFMpegTools paramFFMpegTools)
  {
    ffmpegTools = paramFFMpegTools;
  }
  
  public static void start(String paramString1, String paramString2, TranscoderListener paramTranscoderListener)
  {
    getInstance().start(paramString1, paramString2, paramTranscoderListener);
  }
  
  public static void stop()
  {
    if (instance == null) {
      return;
    }
    getInstance().stop();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\TranscoderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */