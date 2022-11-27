package dji.thirdparty.afinal.bitmap.core;

import android.graphics.Bitmap;
import dji.thirdparty.afinal.bitmap.download.Downloader;

public class BitmapProcess
{
  private static final int BYTESBUFFER_SIZE = 204800;
  private static final int BYTESBUFFE_POOL_SIZE = 4;
  private static final BytesBufferPool sMicroThumbBufferPool = new BytesBufferPool(4, 204800);
  private BitmapCache mCache;
  private Downloader mDownloader;
  
  public BitmapProcess(Downloader paramDownloader, BitmapCache paramBitmapCache)
  {
    this.mDownloader = paramDownloader;
    this.mCache = paramBitmapCache;
  }
  
  public Bitmap getBitmap(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    return null;
  }
  
  public Bitmap getFromDisk(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\BitmapProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */