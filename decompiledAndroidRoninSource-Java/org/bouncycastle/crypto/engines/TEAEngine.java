package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class TEAEngine
  implements BlockCipher
{
  private static final int block_size = 8;
  private static final int d_sum = -957401312;
  private static final int delta = -1640531527;
  private static final int rounds = 32;
  private int _a;
  private int _b;
  private int _c;
  private int _d;
  private boolean _forEncryption;
  private boolean _initialised = false;
  
  private int bytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = paramArrayOfByte[i];
    return paramArrayOfByte[(i + 1)] & 0xFF | paramInt << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int j = bytesToInt(paramArrayOfByte1, paramInt1);
    int k = bytesToInt(paramArrayOfByte1, paramInt1 + 4);
    paramInt1 = -957401312;
    int i = 0;
    while (i != 32)
    {
      k -= ((j << 4) + this._c ^ j + paramInt1 ^ (j >>> 5) + this._d);
      j -= ((k << 4) + this._a ^ k + paramInt1 ^ (k >>> 5) + this._b);
      paramInt1 += 1640531527;
      i += 1;
    }
    unpackInt(j, paramArrayOfByte2, paramInt2);
    unpackInt(k, paramArrayOfByte2, paramInt2 + 4);
    return 8;
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int j = bytesToInt(paramArrayOfByte1, paramInt1);
    int i = bytesToInt(paramArrayOfByte1, paramInt1 + 4);
    paramInt1 = 0;
    int k = 0;
    while (paramInt1 != 32)
    {
      k -= 1640531527;
      j += ((i << 4) + this._a ^ i + k ^ (i >>> 5) + this._b);
      i += ((j << 4) + this._c ^ j + k ^ (j >>> 5) + this._d);
      paramInt1 += 1;
    }
    unpackInt(j, paramArrayOfByte2, paramInt2);
    unpackInt(i, paramArrayOfByte2, paramInt2 + 4);
    return 8;
  }
  
  private void setKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 16)
    {
      this._a = bytesToInt(paramArrayOfByte, 0);
      this._b = bytesToInt(paramArrayOfByte, 4);
      this._c = bytesToInt(paramArrayOfByte, 8);
      this._d = bytesToInt(paramArrayOfByte, 12);
      return;
    }
    throw new IllegalArgumentException("Key size must be 128 bits.");
  }
  
  private void unpackInt(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 24));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  public String getAlgorithmName()
  {
    return "TEA";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this._forEncryption = paramBoolean;
      this._initialised = true;
      setKey(((KeyParameter)paramCipherParameters).getKey());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to TEA init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this._initialised)
    {
      if (paramInt1 + 8 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 8 <= paramArrayOfByte2.length)
        {
          if (this._forEncryption) {
            return encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          }
          return decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append(getAlgorithmName());
    paramArrayOfByte1.append(" not initialised");
    throw new IllegalStateException(paramArrayOfByte1.toString());
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\TEAEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */