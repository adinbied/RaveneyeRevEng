package dji.utils.storage;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import dji.utils.FileUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class DJIStorageUtils
{
  private static final String EXTERNAL_DJI_DIR;
  public static final long GB = 1073741824L;
  public static final long KB = 1024L;
  public static final long MB = 1048576L;
  public static final long PB = 1125899906842624L;
  public static final long TB = 1099511627776L;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/DJI/");
    EXTERNAL_DJI_DIR = localStringBuilder.toString();
  }
  
  public static String formatStorageSize(long paramLong)
  {
    String str;
    if (paramLong >= 1125899906842624L)
    {
      paramLong /= 1125899906842624L;
      str = "PB";
    }
    else if (paramLong >= 1099511627776L)
    {
      paramLong /= 1099511627776L;
      str = "TB";
    }
    else if (paramLong >= 1073741824L)
    {
      paramLong /= 1073741824L;
      str = "GB";
    }
    else if (paramLong >= 1048576L)
    {
      paramLong /= 1048576L;
      str = "MB";
    }
    else if (paramLong >= 1024L)
    {
      paramLong /= 1024L;
      str = "KB";
    }
    else
    {
      str = "B";
    }
    StringBuilder localStringBuilder = new StringBuilder(Long.toString(paramLong));
    int i = localStringBuilder.length() - 3;
    while (i > 0)
    {
      localStringBuilder.insert(i, ',');
      i -= 3;
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static long getAvailableExternalMemorySize()
  {
    if (isExternalStorageAvailable())
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSizeLong();
      return localStatFs.getAvailableBlocksLong() * l;
    }
    return 0L;
  }
  
  public static String getAvailableExternalMemorySizeText()
  {
    return formatStorageSize(getAvailableExternalMemorySize());
  }
  
  public static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSizeLong();
    return localStatFs.getAvailableBlocksLong() * l;
  }
  
  public static String getAvailableInternalMemorySizeText()
  {
    return formatStorageSize(getAvailableInternalMemorySize());
  }
  
  public static File getExternalCacheDir(Context paramContext, String paramString)
  {
    return new File(getExternalCacheDirPath(paramContext, paramString));
  }
  
  public static String getExternalCacheDirPath(Context paramContext, String paramString)
  {
    return FileUtils.concatPath(new String[] { EXTERNAL_DJI_DIR, paramContext.getPackageName(), paramString });
  }
  
  public static String getSizeInfo(long paramLong)
  {
    if (paramLong < 1024L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramLong));
      localStringBuilder.append("B");
      return localStringBuilder.toString();
    }
    paramLong /= 1024L;
    if (paramLong < 1024L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramLong));
      localStringBuilder.append("KB");
      return localStringBuilder.toString();
    }
    paramLong /= 1024L;
    if (paramLong < 1024L)
    {
      paramLong *= 100L;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramLong / 100L));
      localStringBuilder.append(".");
      localStringBuilder.append(String.valueOf(paramLong % 100L));
      localStringBuilder.append("MB");
      return localStringBuilder.toString();
    }
    paramLong = paramLong * 100L / 1024L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong / 100L));
    localStringBuilder.append(".");
    localStringBuilder.append(String.valueOf(paramLong % 100L));
    localStringBuilder.append("GB");
    return localStringBuilder.toString();
  }
  
  public static long getTotalExternalMemorySize()
  {
    if (isExternalStorageAvailable())
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSizeLong();
      return localStatFs.getBlockCountLong() * l;
    }
    return 0L;
  }
  
  public static String getTotalExternalMemorySizeText()
  {
    return formatStorageSize(getTotalExternalMemorySize());
  }
  
  public static long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSizeLong();
    return localStatFs.getBlockCountLong() * l;
  }
  
  public static String getTotalInternalMemorySizeText()
  {
    return formatStorageSize(getTotalInternalMemorySize());
  }
  
  public static boolean isExternalStorageAvailable()
  {
    return TextUtils.equals("mounted", Environment.getExternalStorageState());
  }
  
  public static String readableFileSize(long paramLong)
  {
    if (paramLong <= 0L) {
      return "";
    }
    double d = paramLong;
    int i = (int)(Math.log10(d) / Math.log10(1024.0D));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new DecimalFormat("#,##0.#", DecimalFormatSymbols.getInstance(Locale.US)).format(d / Math.pow(1024.0D, i)));
    localStringBuilder.append(new String[] { "B", "KB", "MB", "GB", "TB", "PB" }[i]);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\storage\DJIStorageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */