package com.google.android.gms.common.util;

public class MurmurHash3
{
  public static int murmurhash3_x86_32(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = (paramInt2 & 0xFFFFFFFC) + paramInt1;
    while (paramInt1 < j)
    {
      i = (paramArrayOfByte[paramInt1] & 0xFF | (paramArrayOfByte[(paramInt1 + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt1 + 2)] & 0xFF) << 16 | paramArrayOfByte[(paramInt1 + 3)] << 24) * -862048943;
      paramInt3 ^= (i << 15 | i >>> 17) * 461845907;
      paramInt3 = (paramInt3 >>> 19 | paramInt3 << 13) * 5 - 430675100;
      paramInt1 += 4;
    }
    paramInt1 = 0;
    int i = 0;
    int k = paramInt2 & 0x3;
    if (k != 1)
    {
      paramInt1 = i;
      if (k != 2)
      {
        if (k == 3) {
          paramInt1 = (paramArrayOfByte[(j + 2)] & 0xFF) << 16;
        }
      }
      else {
        paramInt1 |= (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
      }
    }
    else
    {
      paramInt1 = (paramArrayOfByte[j] & 0xFF | paramInt1) * -862048943;
      paramInt3 ^= (paramInt1 >>> 17 | paramInt1 << 15) * 461845907;
    }
    paramInt1 = paramInt3 ^ paramInt2;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
    return paramInt1 ^ paramInt1 >>> 16;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\MurmurHash3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */