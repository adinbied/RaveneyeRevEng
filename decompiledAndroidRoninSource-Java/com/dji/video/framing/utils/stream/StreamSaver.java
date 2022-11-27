package com.dji.video.framing.utils.stream;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class StreamSaver
{
  private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal() {};
  public static final String SAVE_PHONE_TIME_STAMP_NAME = "dji_phone_image_stream_time_stamp";
  public static boolean SAVE_WM230VideoDebug_Open = false;
  public static boolean SAVE_usbHybridDataStream_Open = false;
  public static boolean SAVE_usbHybridDataType_Open = false;
  public static final String SAVE_videoCodecQueueIn_Name = "dji_video_codecqueuein";
  public static boolean SAVE_videoCodecQueueIn_Open = false;
  public static final String SAVE_videoDataEncode_Name = "dji_video_datareceiver_encode";
  public static boolean SAVE_videoDataEncode_Open = false;
  public static final String SAVE_videoDataReceiver_Name = "dji_video_datareceiver";
  public static boolean SAVE_videoDataReceiver_Open = false;
  public static final String SAVE_videoUsb_Name = "dji_video_usbaccessary";
  public static boolean SAVE_videoUsb_Open = false;
  public static final String SAVE_videoWifi_Name = "dji_video_wifi";
  public static final String Save_usbHybridDataStream_Name = "dji_usbHybridDataStream";
  public static final String Save_usbHybridDataType_Name = "dji_usbHybridDataType";
  public static String Save_wm230VideoDebug_Name;
  private static final String TAG = "StreamSaver";
  public static String VIDEO_LOG_TAG = "DJIVideo";
  private static HashMap<String, StreamSaver> instanceSet = new HashMap();
  public static boolean sSavePhoneImageStreamTimeStamp;
  public static boolean videoDebugEnabledUsedInSDK;
  private final String name;
  private int saveToFileFrameIndex = 0;
  private final String saveVideoPath;
  private int sizeToFileSizeSum = 0;
  private FileOutputStream videoStreamFrameFile = null;
  private FileOutputStream videoStreamIndexFile = null;
  
  public StreamSaver(String paramString)
  {
    this.name = paramString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject).append("/dji_video_test");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject).append("/dji_video_test/");
    ((StringBuilder)localObject).append(paramString);
    this.saveVideoPath = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("creating StreamSaver[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]: ");
    ((StringBuilder)localObject).append(this.saveVideoPath);
    Log.e("StreamSaver", ((StringBuilder)localObject).toString());
  }
  
  public static StreamSaver getInstance(String paramString)
  {
    StreamSaver localStreamSaver2 = (StreamSaver)instanceSet.get(paramString);
    StreamSaver localStreamSaver1 = localStreamSaver2;
    if (localStreamSaver2 == null)
    {
      localStreamSaver1 = new StreamSaver(paramString);
      instanceSet.put(paramString, localStreamSaver1);
    }
    return localStreamSaver1;
  }
  
  private String getTAG()
  {
    return null;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void finalize()
  {
    destroy();
  }
  
  /* Error */
  public void resetSavedFileState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void write(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void write(byte[] arg1, int arg2, int arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void write(byte[] arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\StreamSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */