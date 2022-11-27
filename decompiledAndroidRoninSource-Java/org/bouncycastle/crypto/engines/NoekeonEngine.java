package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class NoekeonEngine
  implements BlockCipher
{
  private static final int genericSize = 16;
  private static final int[] nullVector = { 0, 0, 0, 0 };
  private static final int[] roundConstants = { 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212 };
  private boolean _forEncryption;
  private boolean _initialised = false;
  private int[] decryptKeys = new int[4];
  private int[] state = new int[4];
  private int[] subKeys = new int[4];
  
  private int bytesToIntBig(byte[] paramArrayOfByte, int paramInt)
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
    this.state[0] = bytesToIntBig(paramArrayOfByte1, paramInt1);
    this.state[1] = bytesToIntBig(paramArrayOfByte1, paramInt1 + 4);
    this.state[2] = bytesToIntBig(paramArrayOfByte1, paramInt1 + 8);
    this.state[3] = bytesToIntBig(paramArrayOfByte1, paramInt1 + 12);
    paramArrayOfByte1 = this.subKeys;
    System.arraycopy(paramArrayOfByte1, 0, this.decryptKeys, 0, paramArrayOfByte1.length);
    theta(this.decryptKeys, nullVector);
    paramInt1 = 16;
    int[] arrayOfInt;
    for (;;)
    {
      paramArrayOfByte1 = this.state;
      arrayOfInt = this.decryptKeys;
      if (paramInt1 <= 0) {
        break;
      }
      theta(paramArrayOfByte1, arrayOfInt);
      paramArrayOfByte1 = this.state;
      paramArrayOfByte1[0] ^= roundConstants[paramInt1];
      pi1(paramArrayOfByte1);
      gamma(this.state);
      pi2(this.state);
      paramInt1 -= 1;
    }
    theta(paramArrayOfByte1, arrayOfInt);
    paramArrayOfByte1 = this.state;
    int i = paramArrayOfByte1[0];
    paramArrayOfByte1[0] = (roundConstants[paramInt1] ^ i);
    intToBytesBig(paramArrayOfByte1[0], paramArrayOfByte2, paramInt2);
    intToBytesBig(this.state[1], paramArrayOfByte2, paramInt2 + 4);
    intToBytesBig(this.state[2], paramArrayOfByte2, paramInt2 + 8);
    intToBytesBig(this.state[3], paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.state[0] = bytesToIntBig(paramArrayOfByte1, paramInt1);
    this.state[1] = bytesToIntBig(paramArrayOfByte1, paramInt1 + 4);
    this.state[2] = bytesToIntBig(paramArrayOfByte1, paramInt1 + 8);
    this.state[3] = bytesToIntBig(paramArrayOfByte1, paramInt1 + 12);
    paramInt1 = 0;
    while (paramInt1 < 16)
    {
      paramArrayOfByte1 = this.state;
      paramArrayOfByte1[0] ^= roundConstants[paramInt1];
      theta(paramArrayOfByte1, this.subKeys);
      pi1(this.state);
      gamma(this.state);
      pi2(this.state);
      paramInt1 += 1;
    }
    paramArrayOfByte1 = this.state;
    int i = paramArrayOfByte1[0];
    paramArrayOfByte1[0] = (roundConstants[paramInt1] ^ i);
    theta(paramArrayOfByte1, this.subKeys);
    intToBytesBig(this.state[0], paramArrayOfByte2, paramInt2);
    intToBytesBig(this.state[1], paramArrayOfByte2, paramInt2 + 4);
    intToBytesBig(this.state[2], paramArrayOfByte2, paramInt2 + 8);
    intToBytesBig(this.state[3], paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  private void gamma(int[] paramArrayOfInt)
  {
    paramArrayOfInt[1] ^= paramArrayOfInt[3] & paramArrayOfInt[2];
    paramArrayOfInt[0] ^= paramArrayOfInt[2] & paramArrayOfInt[1];
    int i = paramArrayOfInt[3];
    paramArrayOfInt[3] = paramArrayOfInt[0];
    paramArrayOfInt[0] = i;
    paramArrayOfInt[2] ^= paramArrayOfInt[0] ^ paramArrayOfInt[1] ^ paramArrayOfInt[3];
    i = paramArrayOfInt[1];
    paramArrayOfInt[1] = (paramArrayOfInt[3] & paramArrayOfInt[2] ^ i);
    i = paramArrayOfInt[0];
    int j = paramArrayOfInt[2];
    paramArrayOfInt[0] = (paramArrayOfInt[1] & j ^ i);
  }
  
  private void intToBytesBig(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 24));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  private void pi1(int[] paramArrayOfInt)
  {
    paramArrayOfInt[1] = rotl(paramArrayOfInt[1], 1);
    paramArrayOfInt[2] = rotl(paramArrayOfInt[2], 5);
    paramArrayOfInt[3] = rotl(paramArrayOfInt[3], 2);
  }
  
  private void pi2(int[] paramArrayOfInt)
  {
    paramArrayOfInt[1] = rotl(paramArrayOfInt[1], 31);
    paramArrayOfInt[2] = rotl(paramArrayOfInt[2], 27);
    paramArrayOfInt[3] = rotl(paramArrayOfInt[3], 30);
  }
  
  private int rotl(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  private void setKey(byte[] paramArrayOfByte)
  {
    this.subKeys[0] = bytesToIntBig(paramArrayOfByte, 0);
    this.subKeys[1] = bytesToIntBig(paramArrayOfByte, 4);
    this.subKeys[2] = bytesToIntBig(paramArrayOfByte, 8);
    this.subKeys[3] = bytesToIntBig(paramArrayOfByte, 12);
  }
  
  private void theta(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[0] ^ paramArrayOfInt1[2];
    i ^= rotl(i, 8) ^ rotl(i, 24);
    paramArrayOfInt1[1] ^= i;
    paramArrayOfInt1[3] = (i ^ paramArrayOfInt1[3]);
    i = 0;
    while (i < 4)
    {
      paramArrayOfInt1[i] ^= paramArrayOfInt2[i];
      i += 1;
    }
    i = paramArrayOfInt1[1] ^ paramArrayOfInt1[3];
    i ^= rotl(i, 8) ^ rotl(i, 24);
    paramArrayOfInt1[0] ^= i;
    paramArrayOfInt1[2] = (i ^ paramArrayOfInt1[2]);
  }
  
  public String getAlgorithmName()
  {
    return "Noekeon";
  }
  
  public int getBlockSize()
  {
    return 16;
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
    localStringBuilder.append("invalid parameter passed to Noekeon init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this._initialised)
    {
      if (paramInt1 + 16 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 16 <= paramArrayOfByte2.length)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\NoekeonEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */