package dji.thirdparty.afinal.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;

public class Utils
{
  private static final long INITIALCRC = -1L;
  private static final long POLY64REV = -7661587058870466123L;
  private static final String TAG = "BitmapCommonUtils";
  private static long[] sCrcTable = new long['Ā'];
  
  static
  {
    int i = 0;
    while (i < 256)
    {
      long l1 = i;
      int j = 0;
      while (j < 8)
      {
        long l2;
        if (((int)l1 & 0x1) != 0) {
          l2 = -7661587058870466123L;
        } else {
          l2 = 0L;
        }
        l1 = l1 >> 1 ^ l2;
        j += 1;
      }
      sCrcTable[i] = l1;
      i += 1;
    }
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i >= 0)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
      return arrayOfByte;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(paramInt1);
    paramArrayOfByte.append(" > ");
    paramArrayOfByte.append(paramInt2);
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public static final long crc64Long(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return crc64Long(getBytes(paramString));
    }
    return 0L;
  }
  
  public static final long crc64Long(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    long l = -1L;
    int i = 0;
    while (i < j)
    {
      l = l >> 8 ^ sCrcTable[(((int)l ^ paramArrayOfByte[i]) & 0xFF)];
      i += 1;
    }
    return l;
  }
  
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static byte[] getBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() * 2];
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramString[i];
      int n = j + 1;
      arrayOfByte[j] = ((byte)(m & 0xFF));
      j = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static File getDiskCacheDir(Context paramContext, String paramString)
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      paramContext = getExternalCacheDir(paramContext);
    } else {
      paramContext = paramContext.getCacheDir();
    }
    paramContext = paramContext.getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return new File(localStringBuilder.toString());
  }
  
  public static File getExternalCacheDir(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/Android/data/");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/cache/");
    paramContext = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append(paramContext);
    return new File(localStringBuilder.toString());
  }
  
  public static long getUsableSpace(File paramFile)
  {
    try
    {
      paramFile = new StatFs(paramFile.getPath());
      long l = paramFile.getBlockSize();
      int i = paramFile.getAvailableBlocks();
      return l * i;
    }
    catch (Exception paramFile)
    {
      Log.e("BitmapCommonUtils", "获取 sdcard 缓存大小 出错，请查看AndroidManifest.xml 是否添加了sdcard的访问权限");
      paramFile.printStackTrace();
    }
    return -1L;
  }
  
  public static boolean isSameKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static byte[] makeKey(String paramString)
  {
    return getBytes(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afina\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */