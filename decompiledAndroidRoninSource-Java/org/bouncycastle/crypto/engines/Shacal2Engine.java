package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class Shacal2Engine
  implements BlockCipher
{
  private static final int BLOCK_SIZE = 32;
  private static final int[] K = { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
  private static final int ROUNDS = 64;
  private boolean forEncryption = false;
  private int[] workingKey = null;
  
  private void byteBlockToInts(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    while (paramInt2 < 8)
    {
      int j = paramInt1 + 1;
      paramInt1 = paramArrayOfByte[paramInt1];
      int i = j + 1;
      int k = paramArrayOfByte[j];
      j = i + 1;
      paramArrayOfInt[paramInt2] = ((paramInt1 & 0xFF) << 24 | (k & 0xFF) << 16 | (paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF);
      paramInt2 += 1;
      paramInt1 = j + 1;
    }
  }
  
  private void bytes2ints(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    while (paramInt2 < paramArrayOfByte.length / 4)
    {
      int j = paramInt1 + 1;
      paramInt1 = paramArrayOfByte[paramInt1];
      int i = j + 1;
      int k = paramArrayOfByte[j];
      j = i + 1;
      paramArrayOfInt[paramInt2] = ((paramInt1 & 0xFF) << 24 | (k & 0xFF) << 16 | (paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF);
      paramInt2 += 1;
      paramInt1 = j + 1;
    }
  }
  
  private void decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = new int[8];
    byteBlockToInts(paramArrayOfByte1, arrayOfInt, paramInt1, 0);
    paramInt1 = 63;
    while (paramInt1 > -1)
    {
      int i = arrayOfInt[0] - ((arrayOfInt[1] >>> 2 | arrayOfInt[1] << -2) ^ (arrayOfInt[1] >>> 13 | arrayOfInt[1] << -13) ^ (arrayOfInt[1] >>> 22 | arrayOfInt[1] << -22)) - (arrayOfInt[1] & arrayOfInt[2] ^ arrayOfInt[1] & arrayOfInt[3] ^ arrayOfInt[2] & arrayOfInt[3]);
      arrayOfInt[0] = arrayOfInt[1];
      arrayOfInt[1] = arrayOfInt[2];
      arrayOfInt[2] = arrayOfInt[3];
      arrayOfInt[3] = (arrayOfInt[4] - i);
      arrayOfInt[4] = arrayOfInt[5];
      arrayOfInt[5] = arrayOfInt[6];
      arrayOfInt[6] = arrayOfInt[7];
      int j = K[paramInt1];
      int k = this.workingKey[paramInt1];
      int m = arrayOfInt[4];
      int n = arrayOfInt[4];
      int i1 = arrayOfInt[4];
      int i2 = arrayOfInt[4];
      int i3 = arrayOfInt[4];
      int i4 = arrayOfInt[4];
      int i5 = arrayOfInt[4];
      int i6 = arrayOfInt[5];
      arrayOfInt[7] = (i - j - k - ((m >>> 6 | n << -6) ^ (i1 >>> 11 | i2 << -11) ^ (i3 >>> 25 | i4 << -25)) - (arrayOfInt[4] & arrayOfInt[6] ^ i6 & i5));
      paramInt1 -= 1;
    }
    ints2bytes(arrayOfInt, paramArrayOfByte2, paramInt2);
  }
  
  private void encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = new int[8];
    byteBlockToInts(paramArrayOfByte1, arrayOfInt, paramInt1, 0);
    paramInt1 = 0;
    while (paramInt1 < 64)
    {
      int i = ((arrayOfInt[4] >>> 6 | arrayOfInt[4] << -6) ^ (arrayOfInt[4] >>> 11 | arrayOfInt[4] << -11) ^ (arrayOfInt[4] >>> 25 | arrayOfInt[4] << -25)) + (arrayOfInt[4] & arrayOfInt[5] ^ arrayOfInt[4] & arrayOfInt[6]) + arrayOfInt[7] + K[paramInt1] + this.workingKey[paramInt1];
      arrayOfInt[7] = arrayOfInt[6];
      arrayOfInt[6] = arrayOfInt[5];
      arrayOfInt[5] = arrayOfInt[4];
      arrayOfInt[4] = (arrayOfInt[3] + i);
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = arrayOfInt[1];
      arrayOfInt[1] = arrayOfInt[0];
      int j = arrayOfInt[0];
      int k = arrayOfInt[0];
      int m = arrayOfInt[0];
      int n = arrayOfInt[0];
      int i1 = arrayOfInt[0];
      int i2 = arrayOfInt[0];
      int i3 = arrayOfInt[0];
      int i4 = arrayOfInt[2];
      int i5 = arrayOfInt[0];
      int i6 = arrayOfInt[3];
      arrayOfInt[0] = (i + ((j >>> 2 | k << -2) ^ (m >>> 13 | n << -13) ^ (i1 >>> 22 | i2 << -22)) + (arrayOfInt[2] & arrayOfInt[3] ^ i3 & i4 ^ i5 & i6));
      paramInt1 += 1;
    }
    ints2bytes(arrayOfInt, paramArrayOfByte2, paramInt2);
  }
  
  private void ints2bytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfInt.length)
    {
      j = i + 1;
      paramArrayOfByte[i] = ((byte)(paramArrayOfInt[paramInt] >>> 24));
      i = j + 1;
      paramArrayOfByte[j] = ((byte)(paramArrayOfInt[paramInt] >>> 16));
      j = i + 1;
      paramArrayOfByte[i] = ((byte)(paramArrayOfInt[paramInt] >>> 8));
      i = j + 1;
      paramArrayOfByte[j] = ((byte)paramArrayOfInt[paramInt]);
      paramInt += 1;
    }
  }
  
  public String getAlgorithmName()
  {
    return "Shacal2";
  }
  
  public int getBlockSize()
  {
    return 32;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this.forEncryption = paramBoolean;
      this.workingKey = new int[64];
      setKey(((KeyParameter)paramCipherParameters).getKey());
      return;
    }
    throw new IllegalArgumentException("only simple KeyParameter expected.");
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.workingKey != null)
    {
      if (paramInt1 + 32 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 32 <= paramArrayOfByte2.length)
        {
          if (this.forEncryption) {
            encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          } else {
            decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          }
          return 32;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("Shacal2 not initialised");
  }
  
  public void reset() {}
  
  public void setKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length != 0) && (paramArrayOfByte.length <= 64))
    {
      int j = paramArrayOfByte.length;
      int i = 16;
      if ((j >= 16) && (paramArrayOfByte.length % 8 == 0))
      {
        bytes2ints(paramArrayOfByte, this.workingKey, 0, 0);
        while (i < 64)
        {
          paramArrayOfByte = this.workingKey;
          int i1 = i - 2;
          j = paramArrayOfByte[i1];
          int k = paramArrayOfByte[i1];
          int m = paramArrayOfByte[i1];
          int n = paramArrayOfByte[i1];
          i1 = paramArrayOfByte[i1];
          int i2 = paramArrayOfByte[(i - 7)];
          int i3 = i - 15;
          int i4 = paramArrayOfByte[i3];
          int i5 = paramArrayOfByte[i3];
          int i6 = paramArrayOfByte[i3];
          int i7 = paramArrayOfByte[i3];
          paramArrayOfByte[i] = ((i1 >>> 10 ^ (j >>> 17 | k << -17) ^ (m >>> 19 | n << -19)) + i2 + (paramArrayOfByte[i3] >>> 3 ^ (i4 >>> 7 | i5 << -7) ^ (i6 >>> 18 | i7 << -18)) + paramArrayOfByte[(i - 16)]);
          i += 1;
        }
        return;
      }
    }
    throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\Shacal2Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */