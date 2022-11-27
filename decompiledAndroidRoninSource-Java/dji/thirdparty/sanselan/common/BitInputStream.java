package dji.thirdparty.sanselan.common;

import java.io.IOException;
import java.io.InputStream;

public class BitInputStream
  extends InputStream
  implements BinaryConstants
{
  private long bytes_read = 0L;
  private int cache;
  private int cacheBitsRemaining = 0;
  private final InputStream is;
  
  public BitInputStream(InputStream paramInputStream)
  {
    this.is = paramInputStream;
  }
  
  public void flushCache()
  {
    this.cacheBitsRemaining = 0;
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
  
  public final int readBits(int paramInt)
    throws IOException
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\BitInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */