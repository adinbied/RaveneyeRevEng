package dji.utils.storage;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import dji.utils.AppUtils;
import dji.utils.FileUtils;
import dji.utils.SharedPreferenceUtils;
import dji.utils.thread.DJIExecutor;
import dji.utils.thread.DJIExecutor.Purpose;
import java.io.File;
import java.util.concurrent.Executor;

public enum DJIFolder
{
  private static final String SP_KEY_PLAYBACK_DIR_SCANNED = "playback_dir_scanned";
  public static final String[] STANDARD_DIRECTORIES = { Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_PODCASTS, Environment.DIRECTORY_RINGTONES, Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_DOWNLOADS, Environment.DIRECTORY_DCIM, Environment.DIRECTORY_DOCUMENTS };
  private File mDir;
  private final boolean mHideMedia;
  private final String mParentDir;
  private final String mRelativePath;
  
  static
  {
    FIRMWARE_DOWNLOAD = new DJIFolder("FIRMWARE_DOWNLOAD", 2, "package-name", "/firmware", false);
    CUSTOM_3D_LUT = new DJIFolder("CUSTOM_3D_LUT", 3, "package-name", "/DJI-Ronin-UserLut", false);
    SHARE_TEMP = new DJIFolder("SHARE_TEMP", 4, "package-name", "/DJI-Ronin-Temp-Files", false);
    INNER_CUSTOM_LUT_PNG = new DJIFolder("INNER_CUSTOM_LUT_PNG", 5, "package-name", "/lut-png", false);
    LOG = new DJIFolder("LOG", 6, "package-name", "/LOG", false);
    DJIFolder localDJIFolder = new DJIFolder("BUGLY", 7, "package-name", "/bugly_native", false);
    BUGLY = localDJIFolder;
    $VALUES = new DJIFolder[] { VIDEO_CACHE, VIDEO_CACHE_NEW, FIRMWARE_DOWNLOAD, CUSTOM_3D_LUT, SHARE_TEMP, INNER_CUSTOM_LUT_PNG, LOG, localDJIFolder };
  }
  
  private DJIFolder(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mParentDir = paramString1;
    this.mRelativePath = paramString2;
    this.mHideMedia = paramBoolean;
  }
  
  public static void createNewFolder(DJIFolder paramDJIFolder, File paramFile)
  {
    FileUtils.mkdirs(paramFile);
    if (paramDJIFolder.mHideMedia) {
      createNoMedia(paramFile);
    }
  }
  
  public static void createNoMedia(File paramFile)
  {
    paramFile = new File(paramFile, ".nomedia");
    if (paramFile.exists()) {
      return;
    }
    FileUtils.createFile(paramFile);
  }
  
  public static String getOriginMovePath(Context paramContext, DJIFolder paramDJIFolder)
  {
    if (paramDJIFolder == CUSTOM_3D_LUT)
    {
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStorageDirectory());
      paramContext.append(CUSTOM_3D_LUT.mRelativePath);
      return paramContext.toString();
    }
    if (isStandardDirectory(paramDJIFolder.mParentDir))
    {
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStoragePublicDirectory(paramDJIFolder.mParentDir));
      paramContext.append(paramDJIFolder.mRelativePath);
      return paramContext.toString();
    }
    if (TextUtils.equals("package-name", paramDJIFolder.mParentDir)) {
      return DJIStorageUtils.getExternalCacheDirPath(paramContext, paramDJIFolder.mRelativePath);
    }
    if (!TextUtils.isEmpty(paramDJIFolder.mParentDir))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramDJIFolder.mParentDir);
      paramContext.append(paramDJIFolder.mRelativePath);
      return paramContext.toString();
    }
    paramContext = new StringBuilder();
    paramContext.append(Environment.getExternalStorageDirectory());
    paramContext.append("/DJI");
    paramContext.append(paramDJIFolder.mRelativePath);
    return paramContext.toString();
  }
  
  public static void initAllFolders(Context paramContext)
  {
    DJIFolder[] arrayOfDJIFolder = values();
    int j = arrayOfDJIFolder.length;
    int i = 0;
    while (i < j)
    {
      initFolder(paramContext, arrayOfDJIFolder[i]);
      i += 1;
    }
  }
  
  private static void initFolder(Context paramContext, DJIFolder paramDJIFolder)
  {
    Object localObject;
    if (isStandardDirectory(paramDJIFolder.mParentDir))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStoragePublicDirectory(paramDJIFolder.mParentDir));
      ((StringBuilder)localObject).append(paramDJIFolder.mRelativePath);
      localObject = new File(((StringBuilder)localObject).toString());
    }
    else if (TextUtils.equals("package-name", paramDJIFolder.mParentDir))
    {
      if (paramDJIFolder == VIDEO_CACHE)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Environment.getExternalStoragePublicDirectory(VIDEO_CACHE_NEW.mParentDir));
        ((StringBuilder)localObject).append(VIDEO_CACHE_NEW.mRelativePath);
        localObject = new File(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = paramContext.getExternalFilesDir(paramDJIFolder.mRelativePath);
      }
    }
    else if (!TextUtils.isEmpty(paramDJIFolder.mParentDir))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramDJIFolder.mParentDir);
      ((StringBuilder)localObject).append(paramDJIFolder.mRelativePath);
      localObject = new File(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = paramContext.getExternalFilesDir(paramDJIFolder.mRelativePath);
    }
    if (localObject == null) {
      return;
    }
    if (needTransferToNewDir(paramDJIFolder))
    {
      paramContext = getOriginMovePath(paramContext, paramDJIFolder);
      if ((FileUtils.isDirectory(paramContext)) && (!paramContext.equals(((File)localObject).getAbsolutePath()))) {
        transferToScopedStorage(new File(paramContext), (File)localObject);
      } else {
        createNewFolder(paramDJIFolder, (File)localObject);
      }
      if (paramDJIFolder == VIDEO_CACHE) {
        SharedPreferenceUtils.getInstance(AppUtils.getApp().getApplicationContext()).put("playback_dir_scanned", false);
      }
    }
    else
    {
      createNewFolder(paramDJIFolder, (File)localObject);
    }
    paramDJIFolder.mDir = ((File)localObject);
  }
  
  public static boolean isStandardDirectory(String paramString)
  {
    String[] arrayOfString = STANDARD_DIRECTORIES;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isUnderStandardDirectory(String paramString)
  {
    String[] arrayOfString = STANDARD_DIRECTORIES;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(Environment.getExternalStoragePublicDirectory(arrayOfString[i]).getAbsolutePath())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean needTransferToNewDir(DJIFolder paramDJIFolder)
  {
    return (paramDJIFolder == VIDEO_CACHE) || (paramDJIFolder == CUSTOM_3D_LUT) || (paramDJIFolder == INNER_CUSTOM_LUT_PNG);
  }
  
  public static void transferToScopedStorage(File paramFile1, File paramFile2)
  {
    if ((paramFile1 != null) && (paramFile1.exists()))
    {
      if (paramFile2 == null) {
        return;
      }
      if ((Build.VERSION.SDK_INT > 29) && (!isUnderStandardDirectory(paramFile2.getAbsolutePath())))
      {
        DJIExecutor.getExecutorFor(DJIExecutor.Purpose.DISK_IO).execute(new -..Lambda.DJIFolder.KVksAMBjo74woZqpiZ8jK54mZLU(paramFile1, paramFile2));
        return;
      }
      FileUtils.moveFile(paramFile1, paramFile2);
    }
  }
  
  public final String absolutePath()
  {
    return dir().getAbsolutePath();
  }
  
  public final File dir()
  {
    FileUtils.mkdirs(this.mDir);
    if (this.mHideMedia) {
      createNoMedia(this.mDir);
    }
    return this.mDir;
  }
  
  public String relativePath()
  {
    return this.mRelativePath;
  }
  
  public final File subFile(String paramString)
  {
    return new File(dir(), paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\storage\DJIFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */