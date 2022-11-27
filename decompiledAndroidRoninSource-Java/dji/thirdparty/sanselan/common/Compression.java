package dji.thirdparty.sanselan.common;

import dji.thirdparty.sanselan.ImageReadException;
import java.io.IOException;

public class Compression
{
  public byte[] compressLZW(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  public byte[] decompressLZW(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    return null;
  }
  
  public byte[] decompressPackBits(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ImageReadException, IOException
  {
    return new PackBits().decompress(paramArrayOfByte, paramInt1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\Compression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */