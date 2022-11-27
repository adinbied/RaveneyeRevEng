package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class HC256Engine
  implements StreamCipher
{
  private byte[] buf = new byte[4];
  private int cnt = 0;
  private int idx = 0;
  private boolean initialised;
  private byte[] iv;
  private byte[] key;
  private int[] p = new int['Ѐ'];
  private int[] q = new int['Ѐ'];
  
  private byte getByte()
  {
    if (this.idx == 0)
    {
      i = step();
      arrayOfByte = this.buf;
      arrayOfByte[0] = ((byte)(i & 0xFF));
      i >>= 8;
      arrayOfByte[1] = ((byte)(i & 0xFF));
      i >>= 8;
      arrayOfByte[2] = ((byte)(i & 0xFF));
      arrayOfByte[3] = ((byte)(i >> 8 & 0xFF));
    }
    byte[] arrayOfByte = this.buf;
    int i = this.idx;
    byte b = arrayOfByte[i];
    this.idx = (0x3 & i + 1);
    return b;
  }
  
  private void init()
  {
    Object localObject = this.key;
    int i = localObject.length;
    int k = 16;
    if ((i != 32) && (localObject.length != 16)) {
      throw new IllegalArgumentException("The key must be 128/256 bits long");
    }
    if (this.iv.length >= 16)
    {
      byte[] arrayOfByte = this.key;
      if (arrayOfByte.length != 32)
      {
        localObject = new byte[32];
        System.arraycopy(arrayOfByte, 0, localObject, 0, arrayOfByte.length);
        arrayOfByte = this.key;
        System.arraycopy(arrayOfByte, 0, localObject, 16, arrayOfByte.length);
        this.key = ((byte[])localObject);
      }
      arrayOfByte = this.iv;
      if (arrayOfByte.length < 32)
      {
        localObject = new byte[32];
        System.arraycopy(arrayOfByte, 0, localObject, 0, arrayOfByte.length);
        arrayOfByte = this.iv;
        System.arraycopy(arrayOfByte, 0, localObject, arrayOfByte.length, 32 - arrayOfByte.length);
        this.iv = ((byte[])localObject);
      }
      this.idx = 0;
      this.cnt = 0;
      localObject = new int['਀'];
      i = 0;
      while (i < 32)
      {
        j = i >> 2;
        localObject[j] |= (this.key[i] & 0xFF) << (i & 0x3) * 8;
        i += 1;
      }
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= 32) {
          break;
        }
        i = (j >> 2) + 8;
        localObject[i] |= (this.iv[j] & 0xFF) << (j & 0x3) * 8;
        j += 1;
      }
      while (i < 2560)
      {
        j = localObject[(i - 2)];
        k = localObject[(i - 15)];
        localObject[i] = ((j >>> 10 ^ rotateRight(j, 17) ^ rotateRight(j, 19)) + localObject[(i - 7)] + (k >>> 3 ^ rotateRight(k, 7) ^ rotateRight(k, 18)) + localObject[(i - 16)] + i);
        i += 1;
      }
      System.arraycopy(localObject, 512, this.p, 0, 1024);
      System.arraycopy(localObject, 1536, this.q, 0, 1024);
      i = 0;
      while (i < 4096)
      {
        step();
        i += 1;
      }
      this.cnt = 0;
      return;
    }
    throw new IllegalArgumentException("The IV must be at least 128 bits long");
  }
  
  private static int rotateRight(int paramInt1, int paramInt2)
  {
    return paramInt1 << -paramInt2 | paramInt1 >>> paramInt2;
  }
  
  private int step()
  {
    int j = this.cnt;
    int i = j & 0x3FF;
    int[] arrayOfInt2;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int[] arrayOfInt1;
    if (j < 1024)
    {
      arrayOfInt2 = this.p;
      j = arrayOfInt2[(i - 3 & 0x3FF)];
      k = arrayOfInt2[(i - 1023 & 0x3FF)];
      m = arrayOfInt2[i];
      n = arrayOfInt2[(i - 10 & 0x3FF)];
      i1 = rotateRight(j, 10);
      i2 = rotateRight(k, 23);
      arrayOfInt1 = this.q;
      arrayOfInt2[i] = (m + (n + (i2 ^ i1) + arrayOfInt1[((j ^ k) & 0x3FF)]));
      arrayOfInt2 = this.p;
      j = arrayOfInt2[(i - 12 & 0x3FF)];
      j = arrayOfInt1[(j & 0xFF)] + arrayOfInt1[((j >> 8 & 0xFF) + 256)] + arrayOfInt1[((j >> 16 & 0xFF) + 512)] + arrayOfInt1[((j >> 24 & 0xFF) + 768)];
      i = arrayOfInt2[i];
    }
    else
    {
      arrayOfInt2 = this.q;
      j = arrayOfInt2[(i - 3 & 0x3FF)];
      k = arrayOfInt2[(i - 1023 & 0x3FF)];
      m = arrayOfInt2[i];
      n = arrayOfInt2[(i - 10 & 0x3FF)];
      i1 = rotateRight(j, 10);
      i2 = rotateRight(k, 23);
      arrayOfInt1 = this.p;
      arrayOfInt2[i] = (m + (n + (i2 ^ i1) + arrayOfInt1[((j ^ k) & 0x3FF)]));
      arrayOfInt2 = this.q;
      j = arrayOfInt2[(i - 12 & 0x3FF)];
      j = arrayOfInt1[(j & 0xFF)] + arrayOfInt1[((j >> 8 & 0xFF) + 256)] + arrayOfInt1[((j >> 16 & 0xFF) + 512)] + arrayOfInt1[((j >> 24 & 0xFF) + 768)];
      i = arrayOfInt2[i];
    }
    this.cnt = (this.cnt + 1 & 0x7FF);
    return i ^ j;
  }
  
  public String getAlgorithmName()
  {
    return "HC-256";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      localObject = (ParametersWithIV)paramCipherParameters;
      this.iv = ((ParametersWithIV)localObject).getIV();
      localObject = ((ParametersWithIV)localObject).getParameters();
    }
    else
    {
      this.iv = new byte[0];
      localObject = paramCipherParameters;
    }
    if ((localObject instanceof KeyParameter))
    {
      this.key = ((KeyParameter)localObject).getKey();
      init();
      this.initialised = true;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid parameter passed to HC256 init - ");
    ((StringBuilder)localObject).append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    if (this.initialised)
    {
      if (paramInt1 + paramInt2 <= paramArrayOfByte1.length)
      {
        if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
        {
          int i = 0;
          while (i < paramInt2)
          {
            paramArrayOfByte2[(paramInt3 + i)] = ((byte)(paramArrayOfByte1[(paramInt1 + i)] ^ getByte()));
            i += 1;
          }
          return paramInt2;
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
  
  public void reset()
  {
    init();
  }
  
  public byte returnByte(byte paramByte)
  {
    return (byte)(paramByte ^ getByte());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\HC256Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */