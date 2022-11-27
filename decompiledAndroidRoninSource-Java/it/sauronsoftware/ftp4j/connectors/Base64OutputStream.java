package it.sauronsoftware.ftp4j.connectors;

import java.io.OutputStream;

class Base64OutputStream
  extends OutputStream
{
  private int buffer = 0;
  private int bytecounter = 0;
  private int linecounter = 0;
  private int linelength = 0;
  private OutputStream outputStream = null;
  
  public Base64OutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 76);
  }
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this.outputStream = paramOutputStream;
    this.linelength = paramInt;
  }
  
  /* Error */
  public void close()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void commit()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void write(int arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\Base64OutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */