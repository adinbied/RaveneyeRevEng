package dji.thirdparty.sanselan.common.mylzw;

import dji.thirdparty.sanselan.common.BinaryConstants;
import java.io.IOException;
import java.io.OutputStream;

public class MyBitOutputStream
  extends OutputStream
  implements BinaryConstants
{
  private int bitCache = 0;
  private int bitsInCache = 0;
  private final int byteOrder;
  private int bytesWritten = 0;
  private final OutputStream os;
  
  public MyBitOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this.byteOrder = paramInt;
    this.os = paramOutputStream;
  }
  
  /* Error */
  private void actualWrite(int arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void flushCache()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getBytesWritten()
  {
    return 0;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    writeBits(paramInt, 8);
  }
  
  /* Error */
  public void writeBits(int arg1, int arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\mylzw\MyBitOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */