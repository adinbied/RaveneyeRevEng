package org.bouncycastle.util.encoders;

public class HexTranslator
  implements Translator
{
  private static final byte[] hexTable = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public int decode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = paramInt2 / 2;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int k = paramInt2 * 2 + paramInt1;
      int j = paramArrayOfByte1[k];
      k = paramArrayOfByte1[(k + 1)];
      if (j < 97) {
        paramArrayOfByte2[paramInt3] = ((byte)(j - 48 << 4));
      } else {
        paramArrayOfByte2[paramInt3] = ((byte)(j - 97 + 10 << 4));
      }
      if (k < 97) {
        paramArrayOfByte2[paramInt3] = ((byte)(paramArrayOfByte2[paramInt3] + (byte)(k - 48)));
      } else {
        paramArrayOfByte2[paramInt3] = ((byte)(paramArrayOfByte2[paramInt3] + (byte)(k - 97 + 10)));
      }
      paramInt3 += 1;
      paramInt2 += 1;
    }
    return i;
  }
  
  public int encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = 0;
    int k = 0;
    int j = paramInt1;
    paramInt1 = k;
    while (i < paramInt2)
    {
      k = paramInt3 + paramInt1;
      byte[] arrayOfByte = hexTable;
      paramArrayOfByte2[k] = arrayOfByte[(paramArrayOfByte1[j] >> 4 & 0xF)];
      paramArrayOfByte2[(k + 1)] = arrayOfByte[(paramArrayOfByte1[j] & 0xF)];
      j += 1;
      i += 1;
      paramInt1 += 2;
    }
    return paramInt2 * 2;
  }
  
  public int getDecodedBlockSize()
  {
    return 1;
  }
  
  public int getEncodedBlockSize()
  {
    return 2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\HexTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */