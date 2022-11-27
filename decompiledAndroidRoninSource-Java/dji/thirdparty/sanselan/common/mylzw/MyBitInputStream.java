package dji.thirdparty.sanselan.common.mylzw;

import dji.thirdparty.sanselan.common.BinaryConstants;
import java.io.IOException;
import java.io.InputStream;

public class MyBitInputStream
  extends InputStream
  implements BinaryConstants
{
  private int bitCache = 0;
  private int bitsInCache = 0;
  private final int byteOrder;
  private long bytesRead = 0L;
  private final InputStream is;
  private boolean tiffLZWMode = false;
  
  public MyBitInputStream(InputStream paramInputStream, int paramInt)
  {
    this.byteOrder = paramInt;
    this.is = paramInputStream;
  }
  
  public void flushCache()
  {
    this.bitsInCache = 0;
    this.bitCache = 0;
  }
  
  public long getBytesRead()
  {
    return this.bytesRead;
  }
  
  public int read()
    throws IOException
  {
    return readBits(8);
  }
  
  public int readBits(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public void setTiffLZWMode()
  {
    this.tiffLZWMode = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\mylzw\MyBitInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */