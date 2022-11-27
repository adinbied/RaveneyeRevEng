package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class HC128Engine
  implements StreamCipher
{
  private byte[] buf = new byte[4];
  private int cnt = 0;
  private int idx = 0;
  private boolean initialised;
  private byte[] iv;
  private byte[] key;
  private int[] p = new int['Ȁ'];
  private int[] q = new int['Ȁ'];
  
  private static int dim(int paramInt1, int paramInt2)
  {
    return mod512(paramInt1 - paramInt2);
  }
  
  private static int f1(int paramInt)
  {
    return paramInt >>> 3 ^ rotateRight(paramInt, 7) ^ rotateRight(paramInt, 18);
  }
  
  private static int f2(int paramInt)
  {
    return paramInt >>> 10 ^ rotateRight(paramInt, 17) ^ rotateRight(paramInt, 19);
  }
  
  private int g1(int paramInt1, int paramInt2, int paramInt3)
  {
    return (rotateRight(paramInt1, 10) ^ rotateRight(paramInt3, 23)) + rotateRight(paramInt2, 8);
  }
  
  private int g2(int paramInt1, int paramInt2, int paramInt3)
  {
    return (rotateLeft(paramInt1, 10) ^ rotateLeft(paramInt3, 23)) + rotateLeft(paramInt2, 8);
  }
  
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
  
  private int h1(int paramInt)
  {
    int[] arrayOfInt = this.q;
    return arrayOfInt[(paramInt & 0xFF)] + arrayOfInt[((paramInt >> 16 & 0xFF) + 256)];
  }
  
  private int h2(int paramInt)
  {
    int[] arrayOfInt = this.p;
    return arrayOfInt[(paramInt & 0xFF)] + arrayOfInt[((paramInt >> 16 & 0xFF) + 256)];
  }
  
  private void init()
  {
    int i = this.key.length;
    int j = 16;
    if (i == 16)
    {
      this.idx = 0;
      this.cnt = 0;
      int[] arrayOfInt = new int['Ԁ'];
      i = 0;
      int k;
      int m;
      while (i < 16)
      {
        k = i >> 2;
        m = arrayOfInt[k];
        arrayOfInt[k] = ((this.key[i] & 0xFF) << (i & 0x3) * 8 | m);
        i += 1;
      }
      System.arraycopy(arrayOfInt, 0, arrayOfInt, 4, 4);
      i = 0;
      for (;;)
      {
        byte[] arrayOfByte = this.iv;
        if ((i >= arrayOfByte.length) || (i >= 16)) {
          break;
        }
        k = (i >> 2) + 8;
        m = arrayOfInt[k];
        arrayOfInt[k] = ((arrayOfByte[i] & 0xFF) << (i & 0x3) * 8 | m);
        i += 1;
      }
      System.arraycopy(arrayOfInt, 8, arrayOfInt, 12, 4);
      i = j;
      while (i < 1280)
      {
        arrayOfInt[i] = (f2(arrayOfInt[(i - 2)]) + arrayOfInt[(i - 7)] + f1(arrayOfInt[(i - 15)]) + arrayOfInt[(i - 16)] + i);
        i += 1;
      }
      System.arraycopy(arrayOfInt, 256, this.p, 0, 512);
      System.arraycopy(arrayOfInt, 768, this.q, 0, 512);
      i = 0;
      while (i < 512)
      {
        this.p[i] = step();
        i += 1;
      }
      i = 0;
      while (i < 512)
      {
        this.q[i] = step();
        i += 1;
      }
      this.cnt = 0;
      return;
    }
    throw new IllegalArgumentException("The key must be 128 bits long");
  }
  
  private static int mod1024(int paramInt)
  {
    return paramInt & 0x3FF;
  }
  
  private static int mod512(int paramInt)
  {
    return paramInt & 0x1FF;
  }
  
  private static int rotateLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  private static int rotateRight(int paramInt1, int paramInt2)
  {
    return paramInt1 << -paramInt2 | paramInt1 >>> paramInt2;
  }
  
  private int step()
  {
    int i = mod512(this.cnt);
    int[] arrayOfInt;
    int j;
    if (this.cnt < 512)
    {
      arrayOfInt = this.p;
      arrayOfInt[i] += g1(arrayOfInt[dim(i, 3)], this.p[dim(i, 10)], this.p[dim(i, 511)]);
      j = h1(this.p[dim(i, 12)]);
      i = this.p[i];
    }
    else
    {
      arrayOfInt = this.q;
      arrayOfInt[i] += g2(arrayOfInt[dim(i, 3)], this.q[dim(i, 10)], this.q[dim(i, 511)]);
      j = h2(this.q[dim(i, 12)]);
      i = this.q[i];
    }
    this.cnt = mod1024(this.cnt + 1);
    return i ^ j;
  }
  
  public String getAlgorithmName()
  {
    return "HC-128";
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
    ((StringBuilder)localObject).append("Invalid parameter passed to HC128 init - ");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\HC128Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */