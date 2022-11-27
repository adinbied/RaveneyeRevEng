package dji.thirdparty.sanselan.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CachingOutputStream
  extends OutputStream
{
  private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
  private final OutputStream os;
  
  public CachingOutputStream(OutputStream paramOutputStream)
  {
    this.os = paramOutputStream;
  }
  
  public void close()
    throws IOException
  {
    this.os.close();
  }
  
  public void flush()
    throws IOException
  {
    this.os.flush();
  }
  
  public byte[] getCache()
  {
    return this.baos.toByteArray();
  }
  
  /* Error */
  public void write(int arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\CachingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */