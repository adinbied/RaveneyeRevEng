package dji.midware.media;

import dji.log.RoninLog;
import dji.midware.media.metadata.VideoMetadataManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class MediaLogger
{
  private static boolean DEBUG = false;
  private static String TAG = "MediaLogger";
  private static MediaLogger instance;
  private BufferedWriter bufferedWriter = null;
  private FileWriter fileWriter = null;
  
  private MediaLogger()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoMetadataManager.getSourceVideoDirectory());
      localStringBuilder.append("MediaLogger.log");
      this.fileWriter = new FileWriter(localStringBuilder.toString());
      this.bufferedWriter = new BufferedWriter(this.fileWriter);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((DEBUG) && (DJIVideoUtil.isDebug(true))) {
      RoninLog.d(paramString1, paramString2, new Object[0]);
    }
  }
  
  public static void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((DEBUG) && (DJIVideoUtil.isDebug(paramBoolean))) {
      d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString, Exception paramException)
  {
    if (DEBUG) {
      RoninLog.e(paramString, eToStr(paramException), new Object[0]);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (DEBUG) {
      RoninLog.e(paramString1, paramString2, new Object[0]);
    }
  }
  
  public static void e(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((DEBUG) && (DJIVideoUtil.isDebug(paramBoolean))) {
      e(paramString1, paramString2);
    }
  }
  
  public static void eToFile(String paramString, Exception paramException)
  {
    eToFile(paramString, eToStr(paramException));
  }
  
  public static void eToFile(String paramString1, String paramString2)
  {
    try
    {
      getInstance().bufferedWriter.write(String.format("%s [%s]^^^EXCEPTION^^^:%s\n", new Object[] { new Date().toString(), paramString1, paramString2 }));
      getInstance().bufferedWriter.flush();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String eToStr(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void eToView(String paramString, Exception paramException)
  {
    RoninLog.logWriteD(paramString, eToStr(paramException), new Object[0]);
  }
  
  private static MediaLogger getInstance()
  {
    if (instance == null) {
      instance = new MediaLogger();
    }
    return instance;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if ((DEBUG) && (DJIVideoUtil.isDebug(true))) {
      RoninLog.i(paramString1, paramString2, new Object[0]);
    }
  }
  
  public static void i(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((DEBUG) && (DJIVideoUtil.isDebug(paramBoolean))) {
      i(paramString1, paramString2);
    }
  }
  
  public static void iToFile(String paramString1, String paramString2)
  {
    if (DEBUG) {
      try
      {
        getInstance().bufferedWriter.write(String.format("%s [%s]:%s\n", new Object[] { new Date().toString(), paramString1, paramString2 }));
        getInstance().bufferedWriter.flush();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void show(Exception paramException)
  {
    paramException = eToStr(paramException);
    RoninLog.logWriteD(TAG, paramException, new Object[0]);
    if (DEBUG) {
      RoninLog.i(TAG, paramException, new Object[0]);
    }
  }
  
  public static void show(String paramString)
  {
    RoninLog.d(TAG, paramString, new Object[0]);
    if (DEBUG) {
      RoninLog.i(TAG, paramString, new Object[0]);
    }
  }
  
  public static void show(String paramString, Object paramObject)
  {
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = "null";
    }
    RoninLog.d(paramString, (String)paramObject, new Object[0]);
    if (DEBUG) {
      RoninLog.i(TAG, (String)paramObject, new Object[0]);
    }
  }
  
  public static void show(String paramString1, String paramString2)
  {
    RoninLog.d(TAG, paramString2, new Object[0]);
    if (DEBUG) {
      RoninLog.i(paramString1, paramString2, new Object[0]);
    }
  }
  
  public static void show(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((DEBUG) && (DJIVideoUtil.isDebug(paramBoolean))) {
      show(paramString1, paramString2);
    }
  }
  
  public static void toPhone(String paramString, Exception paramException)
  {
    RoninLog.d(paramString, eToStr(paramException), new Object[0]);
  }
  
  public static void toPhoneAndFile(String paramString1, String paramString2)
  {
    RoninLog.logWriteD(paramString1, paramString2, new Object[0]);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\MediaLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */