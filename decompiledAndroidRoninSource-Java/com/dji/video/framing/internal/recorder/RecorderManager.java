package com.dji.video.framing.internal.recorder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.dji.video.framing.VideoLog;
import com.dji.video.framing.utils.DJIVideoUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class RecorderManager
{
  private static boolean DEBUG = false;
  public static final int ERROR_FILE_CREATE_FAILED = 1;
  public static final int ERROR_MEDIA_CODEC_START_FAILED = 4;
  public static final int ERROR_NOT_ENOUGH_SPACE = 0;
  public static long GB = 1073741824L;
  public static final String KEY_NEED_CACHE_AUDIO = "video_cache_need_audio";
  public static long MB = 1048576L;
  private static final long SIZE_LOW_STORAGE_WARNING;
  private static String TAG = "RecorderManager";
  public static final int WARNING_CACHE_SIZE_REACH_LIMIT_SOON = 2;
  public static final int WARNING_PHONE_STORAGE_LOW = 3;
  private static long maxBufferSpace = 1073741824L * 2L;
  public static int storageSpaceCheckDuration = 10000;
  public static final long targetReleaseSpace = 50L * 1048576L;
  public BufferMode bufferMode = null;
  private RecorderManagerCallback callback;
  private boolean mVideoCacheAutoClean = true;
  private String recordDir;
  private RecorderBase recorder = null;
  
  static
  {
    SIZE_LOW_STORAGE_WARNING = 1048576L * 200L;
    if (DJIVideoUtil.isDebug(false))
    {
      storageSpaceCheckDuration = 5000;
      VideoLog.d("Buffer space test is started", new Object[0]);
    }
  }
  
  private boolean _checkAndReleaseBuffer()
  {
    return false;
  }
  
  private static long deleteFile(String paramString, HashSet<String> paramHashSet)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = paramHashSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(";");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (DEBUG)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("try to delete: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" filter: ");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      VideoLog.d(((StringBuilder)localObject).toString(), new Object[0]);
    }
    if ((paramHashSet != null) && (paramHashSet.contains(paramString)))
    {
      if (DEBUG) {
        VideoLog.d("REJECT", new Object[0]);
      }
      return 0L;
    }
    paramString = new File(paramString);
    long l = paramString.length();
    if (paramString.delete())
    {
      if (DEBUG) {
        VideoLog.d("SUCCESS", new Object[0]);
      }
      return l;
    }
    if (DEBUG) {
      VideoLog.d("NOT EXIST", new Object[0]);
    }
    return 0L;
  }
  
  private static void deleteFolder(String paramString, HashSet<String> paramHashSet)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramString[i];
      if (((File)localObject1).isDirectory())
      {
        if (paramHashSet.contains(((File)localObject1).getAbsolutePath())) {
          break label367;
        }
        deleteFolder(((File)localObject1).getAbsolutePath(), paramHashSet);
      }
      try
      {
        if (DEBUG)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delete directory:");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          VideoLog.d(((StringBuilder)localObject2).toString(), new Object[0]);
        }
        ((File)localObject1).delete();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleted ");
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        Log.i((String)localObject2, localStringBuilder.toString());
      }
      catch (Exception localException1)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localObject2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to delete ");
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      Log.i((String)localObject2, localStringBuilder.toString());
      break label367;
      if (!paramHashSet.contains(((File)localObject1).getAbsolutePath())) {}
      try
      {
        if (DEBUG)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delete a file:");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          VideoLog.d(((StringBuilder)localObject2).toString(), new Object[0]);
        }
        ((File)localObject1).delete();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleted ");
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        Log.i((String)localObject2, localStringBuilder.toString());
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localObject2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to delete ");
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      Log.i((String)localObject2, localStringBuilder.toString());
      label367:
      i += 1;
    }
  }
  
  private static long getDirectorySize(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return 0L;
      }
      if (!paramFile.isDirectory()) {
        return paramFile.length();
      }
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return 0L;
      }
      int j = paramFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        File localFile = paramFile[i];
        if ((localFile != null) && (localFile.isFile())) {
          l2 = localFile.length();
        } else {
          l2 = getDirectorySize(localFile);
        }
        l1 += l2;
        i += 1;
      }
    }
    return l2;
  }
  
  public static long getMaxBufferSpace()
  {
    return maxBufferSpace;
  }
  
  private HashSet<String> makeProtectorForOpenedFile()
  {
    return null;
  }
  
  public static void setBitmap(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return;
    }
    Log.i(TAG, "is now saving a bitmap to a file");
    paramString = new File(paramString);
    try
    {
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (IOException paramBitmap)
    {
      Log.e(TAG, "error in saving thumb 2");
      paramBitmap.printStackTrace();
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      Log.e(TAG, "error in saving thumb 1");
      paramBitmap.printStackTrace();
    }
  }
  
  public static void setMaxBufferSpace(long paramLong)
  {
    maxBufferSpace = paramLong;
  }
  
  public boolean checkAndReleaseBuffer()
  {
    return false;
  }
  
  public boolean checkLimitWarning()
  {
    return false;
  }
  
  public boolean checkPhoneStorage()
  {
    return false;
  }
  
  /* Error */
  public void clearBuffer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long getAvailableSpace()
  {
    return 211064754L;
  }
  
  public boolean getBufferAutoClean()
  {
    return this.mVideoCacheAutoClean;
  }
  
  public RecorderManagerCallback getCallback()
  {
    return this.callback;
  }
  
  public String getRecordDir()
  {
    return this.recordDir;
  }
  
  public String getRecordingFileName()
  {
    return null;
  }
  
  public String getRecordingFilePath()
  {
    return null;
  }
  
  boolean isCurrentRecorder(RecorderBase paramRecorderBase)
  {
    return this.recorder == paramRecorderBase;
  }
  
  public boolean isRecording()
  {
    return false;
  }
  
  public boolean isRecordingToExternalSD()
  {
    return false;
  }
  
  public void setBufferAutoClean(boolean paramBoolean)
  {
    this.mVideoCacheAutoClean = paramBoolean;
  }
  
  public void setCallback(RecorderManagerCallback paramRecorderManagerCallback)
  {
    this.callback = paramRecorderManagerCallback;
  }
  
  public void setRecordDir(String paramString)
  {
    this.recordDir = paramString;
  }
  
  /* Error */
  public void start(BufferMode arg1, com.dji.video.framing.internal.decoder.DJIVideoDecoder arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stop()
  {
    RecorderBase localRecorderBase = this.recorder;
    if (localRecorderBase != null) {
      localRecorderBase.stopRecord();
    }
  }
  
  public static enum BufferMode
  {
    static
    {
      AudioDirect = new BufferMode("AudioDirect", 1);
      Transcode = new BufferMode("Transcode", 2);
      BufferMode localBufferMode = new BufferMode("AudioTranscode", 3);
      AudioTranscode = localBufferMode;
      $VALUES = new BufferMode[] { Direct, AudioDirect, Transcode, localBufferMode };
    }
    
    private BufferMode() {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.PARAMETER})
  public static @interface RecordeErrorCode {}
  
  public static abstract interface RecorderManagerCallback
  {
    public abstract void onError(int paramInt);
    
    public abstract void onFileCompleted(String paramString, double paramDouble);
    
    public abstract void onFileCreated();
    
    public abstract void onMuxerStarted();
    
    public abstract void onMuxerStoped();
    
    public abstract void onSpaceReleaseFinish();
  }
  
  public static enum VIDEO_CACHE_EVENT
  {
    static
    {
      VIDEO_CACHE_EVENT localVIDEO_CACHE_EVENT = new VIDEO_CACHE_EVENT("RELEASE_CACHE_DONE", 0);
      RELEASE_CACHE_DONE = localVIDEO_CACHE_EVENT;
      $VALUES = new VIDEO_CACHE_EVENT[] { localVIDEO_CACHE_EVENT };
    }
    
    private VIDEO_CACHE_EVENT() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\RecorderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */