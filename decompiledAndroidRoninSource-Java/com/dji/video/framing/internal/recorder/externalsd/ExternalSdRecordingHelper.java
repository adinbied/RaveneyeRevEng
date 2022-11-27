package com.dji.video.framing.internal.recorder.externalsd;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import com.dji.video.framing.internal.recorder.RecorderManager;
import com.dji.video.framing.utils.DJIVideoUtil;
import com.dji.video.framing.utils.DjiSharedPreferencesManager;
import com.dji.video.framing.utils.FileStreamCopyController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.List;

public class ExternalSdRecordingHelper
{
  private static final boolean DEBUG = false;
  private static final String DPAD_EXTERNAL_PATH_0 = "/mnt/external_sd";
  private static final String DPAD_EXTERNAL_PATH_1 = "/mnt/external_sd1";
  private static final String KEY_EXTERNAL_STORAGE_ENABLE = "video_cache_external_storage_enable";
  private static final String KEY_GLOBAL_TREE_URI_SAF = "global_tree_uri_saf";
  private static final String KEY_RECORDING_SRC_FILE_PATH = "external_sd_recording_source_file_path";
  public static String SECONDARY_STORAGE;
  private static final String TAG = "ExSdRecordingHelper";
  private static boolean isInited;
  private FileStreamCopyController copyController;
  private DocumentFile externalFileDf;
  private OutputStream externalFileStream;
  private String filePath;
  private RecorderManager manager;
  private String testOutputFilePath;
  
  private ExternalSdRecordingHelper(RecorderManager paramRecorderManager, String paramString)
  {
    this.manager = paramRecorderManager;
    this.filePath = paramString;
    this.copyController = new FileStreamCopyController(paramString);
  }
  
  public ExternalSdRecordingHelper(RecorderManager paramRecorderManager, String paramString, DocumentFile paramDocumentFile)
  {
    this(paramRecorderManager, paramString);
    this.externalFileDf = paramDocumentFile;
    try
    {
      this.externalFileStream = DJIVideoUtil.getContext().getContentResolver().openOutputStream(paramDocumentFile.getUri());
      return;
    }
    catch (FileNotFoundException paramRecorderManager)
    {
      Log.e("ExSdRecordingHelper", "ExternalSdRecordingHelper: open document file output stream failed", paramRecorderManager);
    }
  }
  
  public ExternalSdRecordingHelper(RecorderManager paramRecorderManager, String paramString1, String paramString2)
  {
    this(paramRecorderManager, paramString1);
    this.testOutputFilePath = paramString2;
    paramRecorderManager = new File(this.testOutputFilePath);
    try
    {
      this.externalFileStream = new FileOutputStream(paramRecorderManager);
      return;
    }
    catch (FileNotFoundException paramRecorderManager)
    {
      paramRecorderManager.printStackTrace();
    }
  }
  
  public static DocumentFile checkAndCreateDir(DocumentFile paramDocumentFile, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDocumentFile != null)
    {
      localObject1 = localObject2;
      if (paramDocumentFile.exists())
      {
        if (!paramDocumentFile.isDirectory()) {
          return null;
        }
        localObject1 = paramDocumentFile.findFile(paramString);
        if ((localObject1 != null) && (((DocumentFile)localObject1).exists())) {
          return (DocumentFile)localObject1;
        }
      }
    }
    try
    {
      localObject1 = paramDocumentFile.createDirectory(paramString);
      return (DocumentFile)localObject1;
    }
    catch (Exception paramDocumentFile) {}
    return null;
  }
  
  public static DocumentFile checkAndCreateFile(DocumentFile paramDocumentFile, String paramString1, String paramString2)
  {
    if ((paramDocumentFile != null) && (paramDocumentFile.exists()) && (paramDocumentFile.isDirectory()))
    {
      DocumentFile localDocumentFile2 = paramDocumentFile.findFile(paramString2);
      DocumentFile localDocumentFile1;
      if (localDocumentFile2 != null)
      {
        localDocumentFile1 = localDocumentFile2;
        if (localDocumentFile2.exists()) {}
      }
      else
      {
        localDocumentFile1 = paramDocumentFile.createFile(paramString1, paramString2);
      }
      return localDocumentFile1;
    }
    return null;
  }
  
  private boolean checkDirSizeAndRelease()
  {
    return false;
  }
  
  public static void checkUnfinishedFile()
  {
    logd("ExSdRecordingHelper", "checkUnfinishedFile: 0");
    Object localObject1 = getSrcFilePathFromSp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkUnfinishedFile: filepath: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    logd("ExSdRecordingHelper", ((StringBuilder)localObject2).toString());
    if (isExteranSDGranted())
    {
      if ("".equals(localObject1)) {
        return;
      }
      localObject2 = new File((String)localObject1);
      if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
      {
        logd("ExSdRecordingHelper", "checkUnfinishedFile: path exist");
        ((File)localObject2).delete();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(".")));
      ((StringBuilder)localObject2).append(".info");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkUnfinishedFile: info path: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      logd("ExSdRecordingHelper", ((StringBuilder)localObject2).toString());
      localObject1 = new File((String)localObject1);
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
      {
        logd("ExSdRecordingHelper", "checkUnfinishedFile: info path exist");
        localObject2 = checkAndCreateFile(getExternalSdRecordingDirDf(), "", ((File)localObject1).getName());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkUnfinishedFile: info df uri: ");
        localStringBuilder.append(((DocumentFile)localObject2).getUri());
        logd("ExSdRecordingHelper", localStringBuilder.toString());
        try
        {
          copyToExternalFile((File)localObject1, (DocumentFile)localObject2, true);
        }
        catch (IOException localIOException)
        {
          Log.e("ExSdRecordingHelper", "checkUnfinishedFile: ", localIOException);
        }
      }
      setSrcFilePathToSp("");
    }
  }
  
  public static void copyToExternalFile(File paramFile, DocumentFile paramDocumentFile, boolean paramBoolean)
    throws IOException
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramDocumentFile != null) && (paramDocumentFile.exists()))
    {
      if (!paramDocumentFile.isFile()) {
        return;
      }
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      paramDocumentFile = DJIVideoUtil.getContext().getContentResolver().openOutputStream(paramDocumentFile.getUri());
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramDocumentFile.write(arrayOfByte, 0, i);
      }
      localFileInputStream.close();
      paramDocumentFile.flush();
      paramDocumentFile.close();
      if (paramBoolean) {
        paramFile.delete();
      }
    }
  }
  
  private static long deleteFile(DocumentFile paramDocumentFile)
  {
    if (paramDocumentFile == null) {
      return -1L;
    }
    if (paramDocumentFile.isDirectory())
    {
      DocumentFile[] arrayOfDocumentFile = paramDocumentFile.listFiles();
      int j = arrayOfDocumentFile.length;
      int i = 0;
      long l2;
      for (l1 = 0L; i < j; l1 = l2)
      {
        long l3 = deleteFile(arrayOfDocumentFile[i]);
        l2 = l1;
        if (l3 > 0L) {
          l2 = l1 + l3;
        }
        i += 1;
      }
      paramDocumentFile.delete();
      return l1;
    }
    long l1 = paramDocumentFile.length();
    paramDocumentFile.delete();
    return l1;
  }
  
  public static long getAvailableSpace(DocumentFile paramDocumentFile)
  {
    if (isExteranSDGranted())
    {
      if (paramDocumentFile == null) {
        return 0L;
      }
      long l1 = new File(SECONDARY_STORAGE).getUsableSpace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAvailableSpace: availGlobal: ");
      localStringBuilder.append(l1 / RecorderManager.MB);
      localStringBuilder.append("MB");
      logd("ExSdRecordingHelper", localStringBuilder.toString());
      long l2 = getDocumentFileSize(paramDocumentFile);
      paramDocumentFile = new StringBuilder();
      paramDocumentFile.append("getAvailableSpace: source dir size: ");
      paramDocumentFile.append(l2 / RecorderManager.MB);
      paramDocumentFile.append("MB");
      logd("ExSdRecordingHelper", paramDocumentFile.toString());
      l2 = RecorderManager.getMaxBufferSpace() - l2;
      paramDocumentFile = new StringBuilder();
      paramDocumentFile.append("getAvailableSpace: available self dir: ");
      paramDocumentFile.append(l2 / RecorderManager.MB);
      paramDocumentFile.append("MB");
      logd("ExSdRecordingHelper", paramDocumentFile.toString());
      l1 = Math.max(0L, Math.min(l1, l2));
      paramDocumentFile = new StringBuilder();
      paramDocumentFile.append("getAvailableSpace: rst: ");
      paramDocumentFile.append(l1);
      logd("ExSdRecordingHelper", paramDocumentFile.toString());
      return l1;
    }
    return 0L;
  }
  
  private List<DocumentFile> getDocumentFileList(DocumentFile paramDocumentFile, String paramString)
  {
    return null;
  }
  
  private static long getDocumentFileSize(DocumentFile paramDocumentFile)
  {
    boolean bool = paramDocumentFile.exists();
    long l1 = 0L;
    if (!bool) {
      return 0L;
    }
    if (paramDocumentFile.isFile()) {
      return paramDocumentFile.length();
    }
    long l2 = l1;
    if (paramDocumentFile.isDirectory())
    {
      paramDocumentFile = paramDocumentFile.listFiles();
      int j = paramDocumentFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 += getDocumentFileSize(paramDocumentFile[i]);
        i += 1;
      }
    }
    return l2;
  }
  
  public static String getExternalCachePath()
  {
    if (!isExteranSDGranted()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SECONDARY_STORAGE);
    localStringBuilder.append("/DJI/");
    localStringBuilder.append(DJIVideoUtil.getContext().getPackageName());
    localStringBuilder.append("/DJI_RECORD/");
    return localStringBuilder.toString();
  }
  
  public static DocumentFile getExternalSdRecordingDirDf()
  {
    Object localObject = getGlobalTreeUriSAF();
    if (localObject == null) {
      return null;
    }
    localObject = DocumentFile.fromTreeUri(DJIVideoUtil.getContext(), (Uri)localObject);
    if (localObject == null) {
      return null;
    }
    return checkAndCreateDir(checkAndCreateDir(checkAndCreateDir((DocumentFile)localObject, "DJI"), DJIVideoUtil.getContext().getPackageName()), "DJI_RECORD");
  }
  
  public static Uri getGlobalTreeUriSAF()
  {
    String str = DjiSharedPreferencesManager.getString(DJIVideoUtil.getContext(), "global_tree_uri_saf", "");
    if ((str != null) && (!"".equals(str))) {
      return Uri.parse(str);
    }
    return null;
  }
  
  private static String getSimpleName(DocumentFile paramDocumentFile)
  {
    if (paramDocumentFile == null) {
      return null;
    }
    if (paramDocumentFile.isDirectory()) {
      return paramDocumentFile.getName();
    }
    String[] arrayOfString = paramDocumentFile.getName().split("\\.");
    int j = arrayOfString.length;
    int i = 0;
    if (j <= 2) {
      return arrayOfString[0];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < arrayOfString.length - 1)
    {
      localStringBuilder.append(arrayOfString[i]);
      if (i == arrayOfString.length - 2) {
        paramDocumentFile = "";
      } else {
        paramDocumentFile = ".";
      }
      localStringBuilder.append(paramDocumentFile);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String getSrcFilePathFromSp()
  {
    logd("ExSdRecordingHelper", "getSrcFilePathFromSp: ");
    return DjiSharedPreferencesManager.getString(DJIVideoUtil.getContext(), "external_sd_recording_source_file_path", "");
  }
  
  private RandomAccessFile getStopCheckRaf()
    throws FileNotFoundException
  {
    return null;
  }
  
  public static boolean getVideoCacheExternalStorageEnable()
  {
    return DjiSharedPreferencesManager.getBoolean(DJIVideoUtil.getContext(), "video_cache_external_storage_enable", false);
  }
  
  public static void init()
  {
    if (isInited) {
      return;
    }
    isInited = true;
    if (isExteranSDGranted())
    {
      DocumentFile localDocumentFile = DocumentFile.fromTreeUri(DJIVideoUtil.getContext(), getGlobalTreeUriSAF());
      if ((localDocumentFile != null) && (localDocumentFile.exists()))
      {
        checkUnfinishedFile();
        return;
      }
      unGrantExternalSd();
    }
  }
  
  public static boolean isExteranSDGranted()
  {
    boolean bool3 = isSupportExternalSD();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Uri localUri = getGlobalTreeUriSAF();
      bool1 = bool2;
      if (localUri != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(SECONDARY_STORAGE))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(localUri.toString())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isSupportExternalSD()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 21) {
      return false;
    }
    Object localObject = DJIVideoUtil.getContext().getExternalCacheDirs();
    if ((localObject.length >= 2) && (localObject[1] != null))
    {
      localObject = localObject[1].getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportExternalSD: ");
      localStringBuilder.append((String)localObject);
      logd("ExSdRecordingHelper", localStringBuilder.toString());
      ((String)localObject).indexOf("/Android");
      SECONDARY_STORAGE = ((String)localObject).substring(0, ((String)localObject).indexOf("/Android"));
    }
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(SECONDARY_STORAGE)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int locateMdatStartOffset()
    throws IOException
  {
    return 0;
  }
  
  private static void logd(String paramString1, String paramString2) {}
  
  public static void putGlobalTreeUriSAF(Uri paramUri)
  {
    Context localContext = DJIVideoUtil.getContext();
    if (paramUri == null) {
      paramUri = "";
    } else {
      paramUri = paramUri.toString();
    }
    DjiSharedPreferencesManager.putString(localContext, "global_tree_uri_saf", paramUri);
  }
  
  private static void setSrcFilePathToSp(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSrcFilePathToSp: path: ");
    localStringBuilder.append(paramString);
    logd("ExSdRecordingHelper", localStringBuilder.toString());
    DjiSharedPreferencesManager.putString(DJIVideoUtil.getContext(), "external_sd_recording_source_file_path", paramString);
  }
  
  public static void setVideoCacheExternalStorageEnable(boolean paramBoolean)
  {
    DjiSharedPreferencesManager.putBoolean(DJIVideoUtil.getContext(), "video_cache_external_storage_enable", paramBoolean);
  }
  
  /* Error */
  private void streamRead(byte[] arg1, RandomAccessFile arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void unGrantExternalSd()
  {
    SECONDARY_STORAGE = null;
    putGlobalTreeUriSAF(null);
    setVideoCacheExternalStorageEnable(false);
  }
  
  public void forceStop()
  {
    this.copyController.forceStop();
  }
  
  public void pause()
  {
    FileStreamCopyController localFileStreamCopyController = this.copyController;
    if (localFileStreamCopyController != null) {
      localFileStreamCopyController.pause();
    }
  }
  
  public void resume()
  {
    FileStreamCopyController localFileStreamCopyController = this.copyController;
    if (localFileStreamCopyController != null) {
      localFileStreamCopyController.resume();
    }
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public static class ExternalStorageInfo
  {
    public Uri uri;
    
    public ExternalStorageInfo(Uri paramUri)
    {
      this.uri = paramUri;
    }
  }
  
  public static enum ExternalStorageUiEvent
  {
    static
    {
      Close = new ExternalStorageUiEvent("Close", 1);
      CreateFileError = new ExternalStorageUiEvent("CreateFileError", 2);
      SdcardMounted = new ExternalStorageUiEvent("SdcardMounted", 3);
      ExternalStorageUiEvent localExternalStorageUiEvent = new ExternalStorageUiEvent("SdcardUnMounted", 4);
      SdcardUnMounted = localExternalStorageUiEvent;
      $VALUES = new ExternalStorageUiEvent[] { Open, Close, CreateFileError, SdcardMounted, localExternalStorageUiEvent };
    }
    
    private ExternalStorageUiEvent() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\externalsd\ExternalSdRecordingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */