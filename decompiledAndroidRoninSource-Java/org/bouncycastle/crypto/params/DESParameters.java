package org.bouncycastle.crypto.params;

public class DESParameters
  extends KeyParameter
{
  public static final int DES_KEY_LENGTH = 8;
  private static byte[] DES_weak_keys = { 1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, 14, 14, 14, 14, -32, -32, -32, -32, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, -32, 31, -32, 14, -15, 14, -15, 1, -32, 1, -32, 1, -15, 1, -15, 31, -2, 31, -2, 14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 1, 14, -32, -2, -32, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, -32, 31, -32, 31, -15, 14, -15, 14, -32, 1, -32, 1, -15, 1, -15, 1, -2, 31, -2, 31, -2, 14, -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, -2, -32, -2, -32, -2, -15, -2, -15 };
  private static final int N_DES_WEAK_KEYS = 16;
  
  public DESParameters(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    if (!isWeakKey(paramArrayOfByte, 0)) {
      return;
    }
    throw new IllegalArgumentException("attempt to create weak DES key");
  }
  
  public static boolean isWeakKey(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length - paramInt >= 8)
    {
      int i = 0;
      if (i < 16)
      {
        int j = 0;
        for (;;)
        {
          if (j >= 8) {
            break label57;
          }
          if (paramArrayOfByte[(j + paramInt)] != DES_weak_keys[(i * 8 + j)])
          {
            i += 1;
            break;
          }
          j += 1;
        }
        label57:
        return true;
      }
      return false;
    }
    throw new IllegalArgumentException("key material too short.");
  }
  
  public static void setOddParity(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      paramArrayOfByte[i] = ((byte)((j >> 7 ^ j >> 1 ^ j >> 2 ^ j >> 3 ^ j >> 4 ^ j >> 5 ^ j >> 6 ^ 0x1) & 0x1 | j & 0xFE));
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DESParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */