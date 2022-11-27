package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class ISAACEngine
  implements StreamCipher
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int[] engineState = null;
  private int index = 0;
  private boolean initialised = false;
  private byte[] keyStream = new byte['Ѐ'];
  private int[] results = null;
  private final int sizeL = 8;
  private final int stateArraySize = 256;
  private byte[] workingKey = null;
  
  private void isaac()
  {
    int i = this.b;
    int j = this.c + 1;
    this.c = j;
    this.b = (i + j);
    int k = 0;
    while (k < 256)
    {
      int m = this.engineState[k];
      i = k & 0x3;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              break label122;
            }
            i = this.a;
            j = i >>> 16;
          }
          else
          {
            i = this.a;
            j = i << 2;
          }
        }
        else
        {
          i = this.a;
          j = i >>> 6;
        }
      }
      else
      {
        i = this.a;
        j = i << 13;
      }
      this.a = (i ^ j);
      label122:
      i = this.a;
      int[] arrayOfInt1 = this.engineState;
      i += arrayOfInt1[(k + 128 & 0xFF)];
      this.a = i;
      i = arrayOfInt1[(m >>> 2 & 0xFF)] + i + this.b;
      arrayOfInt1[k] = i;
      int[] arrayOfInt2 = this.results;
      i = arrayOfInt1[(i >>> 10 & 0xFF)] + m;
      this.b = i;
      arrayOfInt2[k] = i;
      k += 1;
    }
  }
  
  private void mix(int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] ^= paramArrayOfInt[1] << 11;
    paramArrayOfInt[3] += paramArrayOfInt[0];
    paramArrayOfInt[1] += paramArrayOfInt[2];
    paramArrayOfInt[1] ^= paramArrayOfInt[2] >>> 2;
    paramArrayOfInt[4] += paramArrayOfInt[1];
    paramArrayOfInt[2] += paramArrayOfInt[3];
    paramArrayOfInt[2] ^= paramArrayOfInt[3] << 8;
    paramArrayOfInt[5] += paramArrayOfInt[2];
    paramArrayOfInt[3] += paramArrayOfInt[4];
    paramArrayOfInt[3] ^= paramArrayOfInt[4] >>> 16;
    paramArrayOfInt[6] += paramArrayOfInt[3];
    paramArrayOfInt[4] += paramArrayOfInt[5];
    paramArrayOfInt[4] ^= paramArrayOfInt[5] << 10;
    paramArrayOfInt[7] += paramArrayOfInt[4];
    paramArrayOfInt[5] += paramArrayOfInt[6];
    int i = paramArrayOfInt[5];
    paramArrayOfInt[5] = (paramArrayOfInt[6] >>> 4 ^ i);
    paramArrayOfInt[0] += paramArrayOfInt[5];
    paramArrayOfInt[6] += paramArrayOfInt[7];
    paramArrayOfInt[6] ^= paramArrayOfInt[7] << 8;
    paramArrayOfInt[1] += paramArrayOfInt[6];
    paramArrayOfInt[7] += paramArrayOfInt[0];
    paramArrayOfInt[7] ^= paramArrayOfInt[0] >>> 9;
    paramArrayOfInt[2] += paramArrayOfInt[7];
    paramArrayOfInt[0] += paramArrayOfInt[1];
  }
  
  private void setKey(byte[] paramArrayOfByte)
  {
    this.workingKey = paramArrayOfByte;
    if (this.engineState == null) {
      this.engineState = new int['Ā'];
    }
    if (this.results == null) {
      this.results = new int['Ā'];
    }
    int i = 0;
    while (i < 256)
    {
      localObject = this.engineState;
      this.results[i] = 0;
      localObject[i] = 0;
      i += 1;
    }
    this.c = 0;
    this.b = 0;
    this.a = 0;
    this.index = 0;
    int j = paramArrayOfByte.length + (paramArrayOfByte.length & 0x3);
    Object localObject = new byte[j];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
    i = 0;
    while (i < j)
    {
      this.results[(i >>> 2)] = Pack.littleEndianToInt((byte[])localObject, i);
      i += 4;
    }
    paramArrayOfByte = new int[8];
    i = 0;
    while (i < 8)
    {
      paramArrayOfByte[i] = -1640531527;
      i += 1;
    }
    i = 0;
    while (i < 4)
    {
      mix(paramArrayOfByte);
      i += 1;
    }
    i = 0;
    while (i < 2)
    {
      j = 0;
      while (j < 256)
      {
        int k = 0;
        while (k < 8)
        {
          int n = paramArrayOfByte[k];
          int m;
          if (i < 1) {
            m = this.results[(j + k)];
          } else {
            m = this.engineState[(j + k)];
          }
          paramArrayOfByte[k] = (n + m);
          k += 1;
        }
        mix(paramArrayOfByte);
        k = 0;
        while (k < 8)
        {
          this.engineState[(j + k)] = paramArrayOfByte[k];
          k += 1;
        }
        j += 8;
      }
      i += 1;
    }
    isaac();
    this.initialised = true;
  }
  
  public String getAlgorithmName()
  {
    return "ISAAC";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      setKey(((KeyParameter)paramCipherParameters).getKey());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to ISAAC init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
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
            if (this.index == 0)
            {
              isaac();
              this.keyStream = Pack.intToBigEndian(this.results);
            }
            byte[] arrayOfByte = this.keyStream;
            int j = this.index;
            paramArrayOfByte2[(i + paramInt3)] = ((byte)(arrayOfByte[j] ^ paramArrayOfByte1[(i + paramInt1)]));
            this.index = (j + 1 & 0x3FF);
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
    setKey(this.workingKey);
  }
  
  public byte returnByte(byte paramByte)
  {
    if (this.index == 0)
    {
      isaac();
      this.keyStream = Pack.intToBigEndian(this.results);
    }
    byte[] arrayOfByte = this.keyStream;
    int i = this.index;
    byte b1 = (byte)(paramByte ^ arrayOfByte[i]);
    this.index = (i + 1 & 0x3FF);
    return b1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\ISAACEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */