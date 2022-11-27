package dji.thirdparty.sanselan.common.mylzw;

import java.io.IOException;
import java.io.InputStream;

public class BitsToByteInputStream
  extends InputStream
{
  private final int desiredDepth;
  private final MyBitInputStream is;
  
  public BitsToByteInputStream(MyBitInputStream paramMyBitInputStream, int paramInt)
  {
    this.is = paramMyBitInputStream;
    this.desiredDepth = paramInt;
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
  
  public int[] readBitsArray(int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\mylzw\BitsToByteInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */