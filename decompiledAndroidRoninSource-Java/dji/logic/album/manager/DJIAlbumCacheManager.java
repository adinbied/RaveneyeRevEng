package dji.logic.album.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.util.LruCache;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DJIAlbumCacheManager
{
  private static final String CACHE_DIR_NAME = "/CACHE_IMAGE/";
  private static DJIAlbumCacheManager instance;
  private RandomAccessFile accessFile;
  private String cachePath = "";
  private LruCache<String, Bitmap> mMemoryCache;
  private BitmapFactory.Options options;
  private String renameTo = null;
  
  public DJIAlbumCacheManager(Context paramContext)
  {
    paramContext = paramContext.getExternalFilesDir("/CACHE_IMAGE/");
    if (paramContext == null) {
      return;
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.cachePath = paramContext.getPath();
    paramContext = new BitmapFactory.Options();
    this.options = paramContext;
    paramContext.inPreferredConfig = Bitmap.Config.RGB_565;
    this.mMemoryCache = new LruCache((int)(Runtime.getRuntime().maxMemory() / 1024L) / 16)
    {
      protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        return paramAnonymousBitmap.getByteCount() / 1024;
      }
    };
  }
  
  public static DJIAlbumCacheManager getInstance()
  {
    try
    {
      DJIAlbumCacheManager localDJIAlbumCacheManager = instance;
      return localDJIAlbumCacheManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static DJIAlbumCacheManager getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new DJIAlbumCacheManager(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void addBitmapToDisk(String arg1, Bitmap arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addBitmapToDiskNoCheck(String arg1, Bitmap arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addBitmapToDiskNoDecorder(String arg1, byte[] arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addBitmapToMemory(String arg1, Bitmap arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addBitmapToMemory(String arg1, byte[] arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearDiskCache()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void clearMemCache()
  {
    this.mMemoryCache.evictAll();
  }
  
  /* Error */
  public void closeStream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void closeStream(long paramLong)
  {
    RandomAccessFile localRandomAccessFile = this.accessFile;
    if (localRandomAccessFile == null) {
      return;
    }
    try
    {
      localRandomAccessFile.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    this.accessFile = null;
  }
  
  public Bitmap getBitmapFromDisk(String paramString)
  {
    return null;
  }
  
  public Bitmap getBitmapFromMemory(String paramString)
  {
    return null;
  }
  
  public long getLenCacheInDisk(String paramString)
  {
    return 211234078L;
  }
  
  public String getPath(String paramString)
  {
    return null;
  }
  
  public String getPath(String paramString1, String paramString2)
  {
    return null;
  }
  
  public boolean isBitmapExistInDisk(String paramString)
  {
    return false;
  }
  
  public boolean isBitmapExistInMemory(String paramString)
  {
    return getBitmapFromMemory(paramString) != null;
  }
  
  /* Error */
  public void openStream(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void openStreamCover(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void seekFile(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  public void setRenameTo(String paramString)
  {
    this.renameTo = paramString;
  }
  
  /* Error */
  public void writeBuffer(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */