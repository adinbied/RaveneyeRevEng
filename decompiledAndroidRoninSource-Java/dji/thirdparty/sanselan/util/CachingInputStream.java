package dji.thirdparty.sanselan.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CachingInputStream
  extends InputStream
{
  private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
  private final InputStream is;
  
  public CachingInputStream(InputStream paramInputStream)
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
  
  public byte[] getCache()
  {
    return this.baos.toByteArray();
  }
  
  public int read()
    throws IOException
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\CachingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */