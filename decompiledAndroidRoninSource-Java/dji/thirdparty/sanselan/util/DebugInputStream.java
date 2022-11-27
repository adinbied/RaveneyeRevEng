package dji.thirdparty.sanselan.util;

import java.io.IOException;
import java.io.InputStream;

public class DebugInputStream
  extends InputStream
{
  private long bytes_read = 0L;
  private final InputStream is;
  
  public DebugInputStream(InputStream paramInputStream)
  {
    this.is = paramInputStream;
  }
  
  public int available()
    throws IOException
  {
    return this.is.available();
  }
  
  public void close()
    throws IOException
  {
    this.is.close();
  }
  
  public long getBytesRead()
  {
    return this.bytes_read;
  }
  
  public int read()
    throws IOException
  {
    return 0;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return 277766162L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\DebugInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */