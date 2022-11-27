package dji.thirdparty.sanselan.common;

import dji.thirdparty.sanselan.ImageReadException;
import java.io.IOException;
import java.io.InputStream;

public class BinaryFileParser
  extends BinaryFileFunctions
{
  private int byteOrder = 77;
  
  public BinaryFileParser() {}
  
  public BinaryFileParser(int paramInt)
  {
    this.byteOrder = paramInt;
  }
  
  public static boolean byteArrayHasPrefix(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  protected final int convertByteArrayToInt(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    return convertByteArrayToInt(paramString, paramArrayOfByte, paramInt, this.byteOrder);
  }
  
  protected final int convertByteArrayToInt(String paramString, byte[] paramArrayOfByte)
  {
    return convertByteArrayToInt(paramString, paramArrayOfByte, this.byteOrder);
  }
  
  public final int convertByteArrayToShort(String paramString, int paramInt, byte[] paramArrayOfByte)
    throws ImageReadException
  {
    return convertByteArrayToShort(paramString, paramInt, paramArrayOfByte, this.byteOrder);
  }
  
  public final int convertByteArrayToShort(String paramString, byte[] paramArrayOfByte)
    throws ImageReadException
  {
    return convertByteArrayToShort(paramString, paramArrayOfByte, this.byteOrder);
  }
  
  protected int getByteOrder()
  {
    return this.byteOrder;
  }
  
  protected final byte[] int2ToByteArray(int paramInt)
  {
    return int2ToByteArray(paramInt, this.byteOrder);
  }
  
  public final int read2Bytes(String paramString1, InputStream paramInputStream, String paramString2)
    throws ImageReadException, IOException
  {
    return read2Bytes(paramString1, paramInputStream, paramString2, this.byteOrder);
  }
  
  public final int read3Bytes(String paramString1, InputStream paramInputStream, String paramString2)
    throws ImageReadException, IOException
  {
    return read3Bytes(paramString1, paramInputStream, paramString2, this.byteOrder);
  }
  
  public final int read4Bytes(String paramString1, InputStream paramInputStream, String paramString2)
    throws ImageReadException, IOException
  {
    return read4Bytes(paramString1, paramInputStream, paramString2, this.byteOrder);
  }
  
  protected void setByteOrder(int paramInt)
  {
    this.byteOrder = paramInt;
  }
  
  /* Error */
  protected void setByteOrder(int arg1, int arg2)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\BinaryFileParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */