package com.dji.video.framing.utils;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Locale;

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
      this.fileWriter = new FileWriter("/sdcard/MediaLogger.log");
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
      Log.d(paramString1, paramString2);
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
      Log.e(paramString, eToStr(paramException));
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (DEBUG) {
      Log.e(paramString1, paramString2);
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
      getInstance().bufferedWriter.write(String.format(Locale.US, "%s [%s]^^^EXCEPTION^^^:%s\n", new Object[] { new Date().toString(), paramString1, paramString2 }));
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
    Log.d(paramString, eToStr(paramException));
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
      Log.i(paramString1, paramString2);
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
        getInstance().bufferedWriter.write(String.format(Locale.US, "%s [%s]:%s\n", new Object[] { new Date().toString(), paramString1, paramString2 }));
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
    Log.e(TAG, paramException);
    if (DEBUG) {
      Log.i(TAG, paramException);
    }
  }
  
  public static void show(String paramString)
  {
    Log.d(TAG, paramString);
    if (DEBUG) {
      Log.i(TAG, paramString);
    }
  }
  
  public static void show(String paramString, Object paramObject)
  {
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = "null";
    }
    Log.d(paramString, (String)paramObject);
    if (DEBUG) {
      Log.i(TAG, (String)paramObject);
    }
  }
  
  public static void show(String paramString1, String paramString2)
  {
    Log.d(TAG, paramString2);
    if (DEBUG) {
      Log.i(paramString1, paramString2);
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
    Log.e(paramString, eToStr(paramException));
  }
  
  public static void toPhoneAndFile(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\MediaLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */