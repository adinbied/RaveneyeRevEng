package it.sauronsoftware.ftp4j.connectors;

import java.io.IOException;
import java.io.InputStream;

class Base64InputStream
  extends InputStream
{
  private int[] buffer;
  private int bufferCounter = 0;
  private boolean eof = false;
  private InputStream inputStream;
  
  public Base64InputStream(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
  }
  
  /* Error */
  private void acquire()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void close()
    throws IOException
  {
    this.inputStream.close();
  }
  
  public int read()
    throws IOException
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\Base64InputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */