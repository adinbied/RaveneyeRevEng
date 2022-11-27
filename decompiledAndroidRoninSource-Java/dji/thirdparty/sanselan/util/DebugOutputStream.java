package dji.thirdparty.sanselan.util;

import java.io.IOException;
import java.io.OutputStream;

public class DebugOutputStream
  extends OutputStream
{
  private long count = 0L;
  private final OutputStream os;
  
  public DebugOutputStream(OutputStream paramOutputStream)
  {
    this.os = paramOutputStream;
  }
  
  public void close()
    throws IOException
  {
    this.os.close();
  }
  
  public long count()
  {
    return this.count;
  }
  
  public void flush()
    throws IOException
  {
    this.os.flush();
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
  
  /* Error */
  public void write(byte[] arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void write(byte[] arg1, int arg2, int arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\DebugOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */