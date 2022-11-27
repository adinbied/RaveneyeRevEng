package dji.thirdparty.sanselan.common;

import java.io.OutputStream;

public class MyByteArrayOutputStream
  extends OutputStream
{
  private final byte[] bytes;
  private int count = 0;
  
  public MyByteArrayOutputStream(int paramInt)
  {
    this.bytes = new byte[paramInt];
  }
  
  public int getBytesWritten()
  {
    return this.count;
  }
  
  public byte[] toByteArray()
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\MyByteArrayOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */