package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Grain128Engine
  implements StreamCipher
{
  private static final int STATE_SIZE = 4;
  private int index = 4;
  private boolean initialised = false;
  private int[] lfsr;
  private int[] nfsr;
  private byte[] out;
  private int output;
  private byte[] workingIV;
  private byte[] workingKey;
  
  private byte getKeyStream()
  {
    if (this.index > 3)
    {
      oneRound();
      this.index = 0;
    }
    byte[] arrayOfByte = this.out;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfByte[i];
  }
  
  private int getOutput()
  {
    int[] arrayOfInt = this.nfsr;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[0] >>> 12 | arrayOfInt[1] << 20;
    int m = arrayOfInt[0];
    int n = arrayOfInt[1];
    int i1 = arrayOfInt[1];
    int i2 = arrayOfInt[2];
    int i3 = arrayOfInt[1];
    int i4 = arrayOfInt[2];
    int i5 = arrayOfInt[2];
    int i6 = arrayOfInt[2];
    int i7 = arrayOfInt[3];
    int i8 = arrayOfInt[2];
    int i9 = arrayOfInt[3];
    int i10 = arrayOfInt[2];
    i10 = arrayOfInt[3] << 1 | i10 >>> 31;
    arrayOfInt = this.lfsr;
    int i11 = arrayOfInt[0];
    int i12 = arrayOfInt[1];
    int i13 = arrayOfInt[0];
    int i14 = arrayOfInt[1];
    int i15 = arrayOfInt[0];
    int i16 = arrayOfInt[1];
    int i17 = arrayOfInt[1];
    int i18 = arrayOfInt[2];
    int i19 = arrayOfInt[1];
    int i20 = arrayOfInt[2];
    int i21 = arrayOfInt[2];
    int i22 = arrayOfInt[3];
    int i23 = arrayOfInt[2];
    int i24 = arrayOfInt[3];
    return i10 & k & (arrayOfInt[2] >>> 31 | arrayOfInt[3] << 1) ^ (i13 >>> 13 | i14 << 19) & (i15 >>> 20 | i16 << 12) ^ k & (i11 >>> 8 | i12 << 24) ^ i10 & (i17 >>> 10 | i18 << 22) ^ (i19 >>> 28 | i20 << 4) & (i21 >>> 15 | i22 << 17) ^ (i23 >>> 29 | i24 << 3) ^ (i >>> 2 | j << 30) ^ (m >>> 15 | n << 17) ^ (i1 >>> 4 | i2 << 28) ^ (i3 >>> 13 | i4 << 19) ^ i5 ^ (i6 >>> 9 | i7 << 23) ^ (i8 >>> 25 | i9 << 7);
  }
  
  private int getOutputLFSR()
  {
    int[] arrayOfInt = this.lfsr;
    int i = arrayOfInt[0];
    int j = arrayOfInt[0];
    int k = arrayOfInt[1];
    int m = arrayOfInt[1];
    int n = arrayOfInt[2];
    int i1 = arrayOfInt[2];
    int i2 = arrayOfInt[3];
    int i3 = arrayOfInt[2];
    int i4 = arrayOfInt[3];
    return arrayOfInt[3] ^ (j >>> 7 | k << 25) ^ i ^ (m >>> 6 | n << 26) ^ (i1 >>> 6 | i2 << 26) ^ (i3 >>> 17 | i4 << 15);
  }
  
  private int getOutputNFSR()
  {
    int[] arrayOfInt = this.nfsr;
    int i = arrayOfInt[0];
    int j = arrayOfInt[0];
    int k = arrayOfInt[1];
    int m = arrayOfInt[0];
    int n = arrayOfInt[1];
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int i3 = arrayOfInt[0];
    int i4 = arrayOfInt[1];
    int i5 = arrayOfInt[0];
    int i6 = arrayOfInt[1];
    int i7 = arrayOfInt[0];
    int i8 = arrayOfInt[1];
    int i9 = arrayOfInt[0];
    int i10 = arrayOfInt[1];
    int i11 = arrayOfInt[1];
    int i12 = arrayOfInt[2];
    int i13 = arrayOfInt[1];
    int i14 = arrayOfInt[2];
    int i15 = arrayOfInt[1];
    int i16 = arrayOfInt[2];
    int i17 = arrayOfInt[1];
    int i18 = arrayOfInt[2];
    int i19 = arrayOfInt[1];
    int i20 = arrayOfInt[2];
    int i21 = arrayOfInt[2];
    int i22 = arrayOfInt[3];
    int i23 = arrayOfInt[2];
    int i24 = arrayOfInt[3];
    int i25 = arrayOfInt[2];
    int i26 = arrayOfInt[3];
    int i27 = arrayOfInt[2];
    int i28 = arrayOfInt[3];
    int i29 = arrayOfInt[2];
    int i30 = arrayOfInt[3];
    return arrayOfInt[3] ^ i ^ (i7 >>> 26 | i8 << 6) ^ (i15 >>> 24 | i16 << 8) ^ (i29 >>> 27 | i30 << 5) ^ (j >>> 3 | k << 29) & (i23 >>> 3 | i24 << 29) ^ (m >>> 11 | n << 21) & (i1 >>> 13 | i2 << 19) ^ (i3 >>> 17 | i4 << 15) & (i5 >>> 18 | i6 << 14) ^ (i9 >>> 27 | i10 << 5) & (i17 >>> 27 | i18 << 5) ^ (i11 >>> 8 | i12 << 24) & (i13 >>> 16 | i14 << 16) ^ (i19 >>> 29 | i20 << 3) & (i21 >>> 1 | i22 << 31) ^ (i25 >>> 4 | i26 << 28) & (i27 >>> 20 | i28 << 12);
  }
  
  private void initGrain()
  {
    int i = 0;
    while (i < 8)
    {
      this.output = getOutput();
      this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0] ^ this.output);
      this.lfsr = shift(this.lfsr, getOutputLFSR() ^ this.output);
      i += 1;
    }
    this.initialised = true;
  }
  
  private void oneRound()
  {
    int i = getOutput();
    this.output = i;
    byte[] arrayOfByte = this.out;
    arrayOfByte[0] = ((byte)i);
    arrayOfByte[1] = ((byte)(i >> 8));
    arrayOfByte[2] = ((byte)(i >> 16));
    arrayOfByte[3] = ((byte)(i >> 24));
    this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
    this.lfsr = shift(this.lfsr, getOutputLFSR());
  }
  
  private void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2[12] = -1;
    paramArrayOfByte2[13] = -1;
    paramArrayOfByte2[14] = -1;
    paramArrayOfByte2[15] = -1;
    this.workingKey = paramArrayOfByte1;
    this.workingIV = paramArrayOfByte2;
    int i = 0;
    int j = 0;
    for (;;)
    {
      paramArrayOfByte1 = this.nfsr;
      if (i >= paramArrayOfByte1.length) {
        break;
      }
      paramArrayOfByte2 = this.workingKey;
      int n = j + 3;
      int i1 = paramArrayOfByte2[n];
      int m = j + 2;
      int i2 = paramArrayOfByte2[m];
      int k = j + 1;
      int i3 = paramArrayOfByte2[k];
      paramArrayOfByte1[i] = (paramArrayOfByte2[j] & 0xFF | i1 << 24 | i2 << 16 & 0xFF0000 | i3 << 8 & 0xFF00);
      paramArrayOfByte1 = this.lfsr;
      paramArrayOfByte2 = this.workingIV;
      n = paramArrayOfByte2[n];
      m = paramArrayOfByte2[m];
      k = paramArrayOfByte2[k];
      paramArrayOfByte1[i] = (paramArrayOfByte2[j] & 0xFF | n << 24 | m << 16 & 0xFF0000 | k << 8 & 0xFF00);
      j += 4;
      i += 1;
    }
  }
  
  private int[] shift(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt[0] = paramArrayOfInt[1];
    paramArrayOfInt[1] = paramArrayOfInt[2];
    paramArrayOfInt[2] = paramArrayOfInt[3];
    paramArrayOfInt[3] = paramInt;
    return paramArrayOfInt;
  }
  
  public String getAlgorithmName()
  {
    return "Grain-128";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      Object localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      if ((paramCipherParameters != null) && (paramCipherParameters.length == 12))
      {
        if ((((ParametersWithIV)localObject).getParameters() instanceof KeyParameter))
        {
          localObject = (KeyParameter)((ParametersWithIV)localObject).getParameters();
          this.workingIV = new byte[((KeyParameter)localObject).getKey().length];
          this.workingKey = new byte[((KeyParameter)localObject).getKey().length];
          this.lfsr = new int[4];
          this.nfsr = new int[4];
          this.out = new byte[4];
          System.arraycopy(paramCipherParameters, 0, this.workingIV, 0, paramCipherParameters.length);
          System.arraycopy(((KeyParameter)localObject).getKey(), 0, this.workingKey, 0, ((KeyParameter)localObject).getKey().length);
          reset();
          return;
        }
        throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
      }
      throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
    }
    throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
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
            paramArrayOfByte2[(paramInt3 + i)] = ((byte)(paramArrayOfByte1[(paramInt1 + i)] ^ getKeyStream()));
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
    this.index = 4;
    setKey(this.workingKey, this.workingIV);
    initGrain();
  }
  
  public byte returnByte(byte paramByte)
  {
    if (this.initialised) {
      return (byte)(paramByte ^ getKeyStream());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAlgorithmName());
    localStringBuilder.append(" not initialised");
    throw new IllegalStateException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\Grain128Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */