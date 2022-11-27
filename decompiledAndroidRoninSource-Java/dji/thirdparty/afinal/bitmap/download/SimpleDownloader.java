package dji.thirdparty.afinal.bitmap.download;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleDownloader
  implements Downloader
{
  private static final int IO_BUFFER_SIZE = 8192;
  private static final String TAG = SimpleDownloader.class.getSimpleName();
  
  private byte[] getFromFile(File paramFile)
  {
    return null;
  }
  
  private byte[] getFromHttp(String paramString)
  {
    return null;
  }
  
  public byte[] download(String paramString)
  {
    return null;
  }
  
  public class FlushedInputStream
    extends FilterInputStream
  {
    public FlushedInputStream(InputStream paramInputStream)
    {
      super();
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      return 277736335L;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\download\SimpleDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */