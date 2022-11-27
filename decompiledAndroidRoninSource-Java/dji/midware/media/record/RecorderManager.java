package dji.midware.media.record;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import dji.log.RoninLog;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.DJIVideoUtil;
import dji.midware.media.MediaLogger;
import dji.midware.media.metadata.VideoMetadataManager;
import dji.midware.util.DjiSharedPreferencesManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;

public class RecorderManager
{
  private static boolean DEBUG = false;
  public static long GB = 1073741824L;
  public static final String KEY_NEED_CACHE_AUDIO = "video_cache_need_audio";
  public static long MB = 1048576L;
  private static String TAG = "RecorderManager";
  public static BufferMode bufferMode = null;
  public static int keyFrameInterfal = 5;
  private static boolean mVideoCacheAutoClean = false;
  private static long maxBufferSpace = 1073741824L * 2L;
  private static RecorderInterface recorder = null;
  public static int storageSpaceCheckDuration = 10000;
  private static long targetReleaseSpace = 1048576L * 50L;
  
  static
  {
    if (DJIVideoUtil.isDebug(false))
    {
      storageSpaceCheckDuration = 5000;
      MediaLogger.show("Buffer space test is started");
    }
  }
  
  private static boolean _checkAndReleaseBuffer()
  {
    for (;;)
    {
      int i;
      try
      {
        long l1 = getAvailableSpace();
        if (l1 >= targetReleaseSpace) {
          return true;
        }
        if (!mVideoCacheAutoClean) {
          return false;
        }
        String str = VideoMetadataManager.getSourceVideoDirectory();
        if (str == null) {
          return false;
        }
        File[] arrayOfFile = new File(str).listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.endsWith(".mp4");
          }
        });
        if (arrayOfFile != null)
        {
          if (arrayOfFile.length == 0) {
            return false;
          }
          Arrays.sort(arrayOfFile, new Comparator()
          {
            public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
            {
              return 0;
            }
          });
          HashSet localHashSet = makeProtectorForOpenedFile();
          int j = arrayOfFile.length;
          i = 0;
          long l2;
          if (i < j)
          {
            Object localObject = arrayOfFile[i].getAbsolutePath();
            boolean bool = ((String)localObject).endsWith(".mp4");
            if (bool) {
              str = ".mp4";
            } else {
              str = ".h264";
            }
            str = ((String)localObject).substring(0, ((String)localObject).length() - str.length());
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(".mp4");
            l2 = deleteFile(((StringBuilder)localObject).toString(), localHashSet);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(".h264");
            long l3 = deleteFile(((StringBuilder)localObject).toString(), localHashSet);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(".jpg");
            long l4 = deleteFile(((StringBuilder)localObject).toString(), localHashSet);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(".info");
            long l5 = deleteFile(((StringBuilder)localObject).toString(), localHashSet);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(".m4a");
            l1 = l1 + l2 + l3 + l4 + l5 + deleteFile(((StringBuilder)localObject).toString(), localHashSet);
            if (l1 > targetReleaseSpace)
            {
              EventBus.getDefault().post(VIDEO_CACHE_EVENT.RELEASE_CACHE_DONE);
              return true;
            }
          }
          else
          {
            l1 = getAvailableSpace();
            l2 = targetReleaseSpace;
            return l1 >= l2;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception localException)
      {
        MediaLogger.show(localException);
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean checkAndReleaseBuffer()
  {
    long l = System.currentTimeMillis();
    boolean bool = _checkAndReleaseBuffer();
    if (DEBUG)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndReleaseBuffer consumes time (ms): ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      MediaLogger.show(localStringBuilder.toString());
    }
    return bool;
  }
  
  public static void clearBuffer()
  {
    if (DEBUG) {
      MediaLogger.show("clearBuffer()");
    }
    String str = VideoMetadataManager.getSourceVideoDirectory();
    if (str == null) {
      return;
    }
    deleteFolder(str, makeProtectorForOpenedFile());
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
      MediaLogger.show(((StringBuilder)localObject).toString());
    }
    if ((paramHashSet != null) && (paramHashSet.contains(paramString)))
    {
      if (DEBUG) {
        MediaLogger.show("REJECT");
      }
      return 0L;
    }
    paramString = new File(paramString);
    long l = paramString.length();
    if (paramString.delete())
    {
      if (DEBUG) {
        MediaLogger.show("SUCCESS");
      }
      return l;
    }
    if (DEBUG) {
      MediaLogger.show("NOT EXIST");
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
          break label376;
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
          MediaLogger.show(((StringBuilder)localObject2).toString());
        }
        ((File)localObject1).delete();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleted ");
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        RoninLog.i((String)localObject2, localStringBuilder.toString(), new Object[0]);
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
      RoninLog.i((String)localObject2, localStringBuilder.toString(), new Object[0]);
      break label376;
      if (!paramHashSet.contains(((File)localObject1).getAbsolutePath())) {}
      try
      {
        if (DEBUG)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delete a file:");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          MediaLogger.show(((StringBuilder)localObject2).toString());
        }
        ((File)localObject1).delete();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleted ");
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        RoninLog.i((String)localObject2, localStringBuilder.toString(), new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localObject2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to delete ");
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      RoninLog.i((String)localObject2, localStringBuilder.toString(), new Object[0]);
      label376:
      i += 1;
    }
  }
  
  public static void destroy()
  {
    RecorderMp4.destroy();
    RecorderAudioMp4.destroy();
    RecorderH264.destroy();
    RecorderGop.destroy();
    RecorderFullFrame.destroy();
    RecorderQuickMovie.destroy();
    recorder = null;
  }
  
  public static long getAvailableSpace()
  {
    long l1 = new File(VideoMetadataManager.getSourceVideoDirectory()).getUsableSpace();
    long l2 = getDirectorySize(new File(VideoMetadataManager.getSourceVideoDirectory()));
    l2 = maxBufferSpace - l2;
    if (l1 >= l2) {
      l1 = l2;
    }
    l2 = l1;
    if (l1 < 0L) {
      l2 = 0L;
    }
    if (DEBUG)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Available space: ");
      localStringBuilder.append(l2);
      MediaLogger.show(localStringBuilder.toString());
    }
    return l2;
  }
  
  public static boolean getBufferAutoClean()
  {
    return mVideoCacheAutoClean;
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
      int j = paramFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        File localFile = paramFile[i];
        if (localFile.isFile()) {
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
  
  public static String getRecordingFileName()
  {
    RecorderInterface localRecorderInterface = recorder;
    if (localRecorderInterface == null) {
      return null;
    }
    return localRecorderInterface.getRecordingFileName();
  }
  
  public static boolean isRecording()
  {
    RecorderInterface localRecorderInterface = recorder;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localRecorderInterface != null)
    {
      bool1 = bool2;
      if ((localRecorderInterface instanceof RecorderBase))
      {
        bool1 = bool2;
        if (((RecorderBase)localRecorderInterface).getCurrentStatus() == RecorderBase.RecorderStatus.RECORDING) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static HashSet<String> makeProtectorForOpenedFile()
  {
    String str1 = VideoMetadataManager.getSourceVideoDirectory();
    if (str1 == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    String str2 = getRecordingFileName();
    if (str2 != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".h264");
      localHashSet.add(((StringBuilder)localObject).toString());
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(".h264");
      RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".mp4");
      localHashSet.add(((StringBuilder)localObject).toString());
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(".mp4");
      RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".info");
      localHashSet.add(((StringBuilder)localObject).toString());
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(".info");
      RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".jpg");
      localHashSet.add(((StringBuilder)localObject).toString());
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(".jpg");
      RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".aac");
      localHashSet.add(((StringBuilder)localObject).toString());
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(".aac");
      RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".m4a");
      localHashSet.add(((StringBuilder)localObject).toString());
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filter: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(".m4a");
      RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
    }
    return localHashSet;
  }
  
  public static boolean needCacheAudio()
  {
    return DjiSharedPreferencesManager.getBoolean(ServiceManager.getContext(), "video_cache_need_audio", true);
  }
  
  public static void setBitmap(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return;
    }
    RoninLog.i(TAG, "is now saving a bitmap to a file", new Object[0]);
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
      RoninLog.e(TAG, "error in saving thumb 2", new Object[0]);
      paramBitmap.printStackTrace();
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      RoninLog.e(TAG, "error in saving thumb 1", new Object[0]);
      paramBitmap.printStackTrace();
    }
  }
  
  public static void setBufferAutoClean(boolean paramBoolean)
  {
    mVideoCacheAutoClean = paramBoolean;
  }
  
  public static void setMaxBufferSpace(long paramLong)
  {
    maxBufferSpace = paramLong;
  }
  
  public static void setNeedCacheAudio(boolean paramBoolean)
  {
    DjiSharedPreferencesManager.putBoolean(ServiceManager.getContext(), "video_cache_need_audio", paramBoolean);
  }
  
  public static void start(BufferMode paramBufferMode)
  {
    destroy();
    bufferMode = paramBufferMode;
    int i = 3.$SwitchMap$dji$midware$media$record$RecorderManager$BufferMode[paramBufferMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            recorder = RecorderQuickMovie.getInstance();
            return;
          }
          recorder = RecorderFullFrame.getInstance();
          return;
        }
        recorder = RecorderGop.getInstance();
        return;
      }
      recorder = RecorderH264.getInstance();
      return;
    }
    if (needCacheAudio())
    {
      RecorderMp4.destroy();
      recorder = RecorderAudioMp4.getInstance();
      return;
    }
    RecorderAudioMp4.destroy();
    recorder = RecorderMp4.getInstance();
  }
  
  public static enum BufferMode
  {
    static
    {
      FULL_FRAME_ENCODE = new BufferMode("FULL_FRAME_ENCODE", 3);
      BufferMode localBufferMode = new BufferMode("QUICK_MOVIE", 4);
      QUICK_MOVIE = localBufferMode;
      $VALUES = new BufferMode[] { GDR_OFFLINE, GDR_ONLINE, GOP, FULL_FRAME_ENCODE, localBufferMode };
    }
    
    private BufferMode() {}
  }
  
  public static enum Service_Action
  {
    static
    {
      END_RECORD = new Service_Action("END_RECORD", 1);
      Service_Action localService_Action = new Service_Action("START_RECORD_BY_PHONE", 2);
      START_RECORD_BY_PHONE = localService_Action;
      $VALUES = new Service_Action[] { START_RECORD, END_RECORD, localService_Action };
    }
    
    private Service_Action() {}
  }
  
  public static class SurfaceSaveEvent
  {
    private String filePath;
    
    public SurfaceSaveEvent(String paramString)
    {
      this.filePath = paramString;
    }
    
    public String getFilePath()
    {
      return this.filePath;
    }
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
  
  public static enum Video_Buffer_Notify
  {
    static
    {
      Video_Buffer_Notify localVideo_Buffer_Notify = new Video_Buffer_Notify("NO_SPACE", 0);
      NO_SPACE = localVideo_Buffer_Notify;
      $VALUES = new Video_Buffer_Notify[] { localVideo_Buffer_Notify };
    }
    
    private Video_Buffer_Notify() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */