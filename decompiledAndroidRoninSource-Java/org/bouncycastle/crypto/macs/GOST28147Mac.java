package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;

public class GOST28147Mac
  implements Mac
{
  private byte[] S = { 9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4 };
  private int blockSize = 8;
  private byte[] buf = new byte[8];
  private int bufOff = 0;
  private boolean firstStep = true;
  private byte[] mac = new byte[8];
  private int macSize = 4;
  private int[] workingKey = null;
  
  private byte[] CM5func(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length - paramInt];
    int j = paramArrayOfByte2.length;
    int i = 0;
    System.arraycopy(paramArrayOfByte1, paramInt, arrayOfByte, 0, j);
    paramInt = i;
    while (paramInt != paramArrayOfByte2.length)
    {
      arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] ^ paramArrayOfByte2[paramInt]));
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  private int bytesToint(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00) + (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  private int[] generateWorkingKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 32)
    {
      int[] arrayOfInt = new int[8];
      int i = 0;
      while (i != 8)
      {
        arrayOfInt[i] = bytesToint(paramArrayOfByte, i * 4);
        i += 1;
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
  }
  
  private void gost28147MacFunc(int[] paramArrayOfInt, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int k = bytesToint(paramArrayOfByte1, paramInt1);
    int j = bytesToint(paramArrayOfByte1, paramInt1 + 4);
    int i = 0;
    paramInt1 = k;
    while (i < 2)
    {
      k = 0;
      while (k < 8)
      {
        int m = gost28147_mainStep(paramInt1, paramArrayOfInt[k]);
        k += 1;
        m = j ^ m;
        j = paramInt1;
        paramInt1 = m;
      }
      i += 1;
    }
    intTobytes(paramInt1, paramArrayOfByte2, paramInt2);
    intTobytes(j, paramArrayOfByte2, paramInt2 + 4);
  }
  
  private int gost28147_mainStep(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 + paramInt1;
    byte[] arrayOfByte = this.S;
    paramInt1 = (arrayOfByte[((paramInt1 >> 0 & 0xF) + 0)] << 0) + (arrayOfByte[((paramInt1 >> 4 & 0xF) + 16)] << 4) + (arrayOfByte[((paramInt1 >> 8 & 0xF) + 32)] << 8) + (arrayOfByte[((paramInt1 >> 12 & 0xF) + 48)] << 12) + (arrayOfByte[((paramInt1 >> 16 & 0xF) + 64)] << 16) + (arrayOfByte[((paramInt1 >> 20 & 0xF) + 80)] << 20) + (arrayOfByte[((paramInt1 >> 24 & 0xF) + 96)] << 24) + (arrayOfByte[((paramInt1 >> 28 & 0xF) + 112)] << 28);
    return paramInt1 << 11 | paramInt1 >>> 21;
  }
  
  private void intTobytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >>> 24));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    for (;;)
    {
      i = this.bufOff;
      if (i >= this.blockSize) {
        break;
      }
      this.buf[i] = 0;
      this.bufOff = (i + 1);
    }
    byte[] arrayOfByte2 = this.buf;
    byte[] arrayOfByte1 = new byte[arrayOfByte2.length];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, this.mac.length);
    if (this.firstStep) {
      this.firstStep = false;
    } else {
      arrayOfByte1 = CM5func(this.buf, 0, this.mac);
    }
    gost28147MacFunc(this.workingKey, arrayOfByte1, 0, this.mac, 0);
    arrayOfByte1 = this.mac;
    int i = arrayOfByte1.length / 2;
    int j = this.macSize;
    System.arraycopy(arrayOfByte1, i - j, paramArrayOfByte, paramInt, j);
    reset();
    return this.macSize;
  }
  
  public String getAlgorithmName()
  {
    return "GOST28147Mac";
  }
  
  public int getMacSize()
  {
    return this.macSize;
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    reset();
    this.buf = new byte[this.blockSize];
    if ((paramCipherParameters instanceof ParametersWithSBox))
    {
      paramCipherParameters = (ParametersWithSBox)paramCipherParameters;
      System.arraycopy(paramCipherParameters.getSBox(), 0, this.S, 0, paramCipherParameters.getSBox().length);
      if (paramCipherParameters.getParameters() != null) {
        this.workingKey = generateWorkingKey(((KeyParameter)paramCipherParameters.getParameters()).getKey());
      }
    }
    else
    {
      if (!(paramCipherParameters instanceof KeyParameter)) {
        break label93;
      }
      this.workingKey = generateWorkingKey(((KeyParameter)paramCipherParameters).getKey());
    }
    return;
    label93:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to GOST28147 init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void reset()
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.buf;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
    this.bufOff = 0;
    this.firstStep = true;
  }
  
  public void update(byte paramByte)
    throws IllegalStateException
  {
    int i = this.bufOff;
    byte[] arrayOfByte2 = this.buf;
    if (i == arrayOfByte2.length)
    {
      arrayOfByte1 = new byte[arrayOfByte2.length];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, this.mac.length);
      if (this.firstStep) {
        this.firstStep = false;
      } else {
        arrayOfByte1 = CM5func(this.buf, 0, this.mac);
      }
      gost28147MacFunc(this.workingKey, arrayOfByte1, 0, this.mac, 0);
      this.bufOff = 0;
    }
    byte[] arrayOfByte1 = this.buf;
    i = this.bufOff;
    this.bufOff = (i + 1);
    arrayOfByte1[i] = paramByte;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (paramInt2 >= 0)
    {
      int i = this.blockSize;
      int m = this.bufOff;
      int k = i - m;
      i = paramInt1;
      int j = paramInt2;
      if (paramInt2 > k)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buf, m, k);
        byte[] arrayOfByte2 = this.buf;
        byte[] arrayOfByte1 = new byte[arrayOfByte2.length];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, this.mac.length);
        if (this.firstStep) {
          this.firstStep = false;
        } else {
          arrayOfByte1 = CM5func(this.buf, 0, this.mac);
        }
        gost28147MacFunc(this.workingKey, arrayOfByte1, 0, this.mac, 0);
        this.bufOff = 0;
        j = paramInt2;
        paramInt2 = paramInt1;
        i = k;
        for (;;)
        {
          paramInt1 = j - i;
          paramInt2 += i;
          i = paramInt2;
          j = paramInt1;
          if (paramInt1 <= this.blockSize) {
            break;
          }
          arrayOfByte1 = CM5func(paramArrayOfByte, paramInt2, this.mac);
          gost28147MacFunc(this.workingKey, arrayOfByte1, 0, this.mac, 0);
          i = this.blockSize;
          j = paramInt1;
        }
      }
      System.arraycopy(paramArrayOfByte, i, this.buf, this.bufOff, j);
      this.bufOff += j;
      return;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\GOST28147Mac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */