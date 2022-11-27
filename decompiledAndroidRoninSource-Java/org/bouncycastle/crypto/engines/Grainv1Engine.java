package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Grainv1Engine
  implements StreamCipher
{
  private static final int STATE_SIZE = 5;
  private int index = 2;
  private boolean initialised = false;
  private int[] lfsr;
  private int[] nfsr;
  private byte[] out;
  private int output;
  private byte[] workingIV;
  private byte[] workingKey;
  
  private byte getKeyStream()
  {
    if (this.index > 1)
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
    int k = arrayOfInt[0];
    int m = arrayOfInt[1];
    int n = arrayOfInt[0];
    int i1 = arrayOfInt[1];
    int i2 = arrayOfInt[0];
    int i3 = arrayOfInt[1];
    int i4 = arrayOfInt[1];
    int i5 = arrayOfInt[2];
    int i6 = arrayOfInt[2];
    int i7 = arrayOfInt[3];
    int i8 = arrayOfInt[3];
    int i9 = arrayOfInt[4];
    int i10 = arrayOfInt[3];
    i10 = arrayOfInt[4] << 1 | i10 >>> 15;
    arrayOfInt = this.lfsr;
    int i11 = arrayOfInt[0] >>> 3 | arrayOfInt[1] << 13;
    int i12 = arrayOfInt[1] >>> 9 | arrayOfInt[2] << 7;
    int i13 = arrayOfInt[2];
    i13 = arrayOfInt[3] << 2 | i13 >>> 14;
    int i14 = arrayOfInt[4];
    int i15 = i13 & i14;
    int i16 = i11 & i13;
    return (i10 & i15 ^ i16 & i10 ^ i14 & i16 ^ i12 ^ i10 ^ i11 & i14 ^ i15 ^ i14 & i10 ^ i11 & i12 & i13 ^ i12 & i13 & i10 ^ (i >>> 1 | j << 15) ^ (k >>> 2 | m << 14) ^ (n >>> 4 | i1 << 12) ^ (i2 >>> 10 | i3 << 6) ^ (i4 >>> 15 | i5 << 1) ^ (i6 >>> 11 | i7 << 5) ^ (i8 >>> 8 | i9 << 8)) & 0xFFFF;
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
    int i3 = arrayOfInt[3];
    int i4 = arrayOfInt[4];
    int i5 = arrayOfInt[3];
    return ((arrayOfInt[4] << 2 | i5 >>> 14) ^ (j >>> 13 | k << 3) ^ i ^ (m >>> 7 | n << 9) ^ (i1 >>> 6 | i2 << 10) ^ (i3 >>> 3 | i4 << 13)) & 0xFFFF;
  }
  
  private int getOutputNFSR()
  {
    int[] arrayOfInt = this.nfsr;
    int i = arrayOfInt[0];
    int j = arrayOfInt[0] >>> 9 | arrayOfInt[1] << 7;
    int k = arrayOfInt[0];
    int m = arrayOfInt[1];
    int n = arrayOfInt[0] >>> 15 | arrayOfInt[1] << 1;
    int i1 = arrayOfInt[1] >>> 5 | arrayOfInt[2] << 11;
    int i2 = arrayOfInt[1] >>> 12 | arrayOfInt[2] << 4;
    int i3 = arrayOfInt[2] >>> 1 | arrayOfInt[3] << 15;
    int i4 = arrayOfInt[2] >>> 5 | arrayOfInt[3] << 11;
    int i5 = arrayOfInt[2] >>> 13 | arrayOfInt[3] << 3;
    int i6 = arrayOfInt[3] >>> 4 | arrayOfInt[4] << 12;
    int i7 = arrayOfInt[3] >>> 12 | arrayOfInt[4] << 4;
    int i8 = arrayOfInt[3];
    int i9 = arrayOfInt[4];
    int i10 = arrayOfInt[3];
    i10 = arrayOfInt[4] << 1 | i10 >>> 15;
    int i11 = i10 & i7;
    int i12 = i7 & i6;
    int i13 = i3 & i2 & i1;
    return (i10 & i5 & i2 & j ^ i ^ (i8 >>> 14 | i9 << 2) ^ i7 ^ i6 ^ i5 ^ i4 ^ i3 ^ i2 ^ i1 ^ (k >>> 14 | m << 2) ^ j ^ i11 ^ i4 & i3 ^ n & j ^ i12 & i5 ^ i13 ^ i12 & i4 & i3 ^ i11 & i1 & n ^ i11 & i6 & i5 & i4 ^ n & i13 & j ^ i6 & i5 & i4 & i3 & i2 & i1) & 0xFFFF;
  }
  
  private void initGrain()
  {
    int i = 0;
    while (i < 10)
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
    this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
    this.lfsr = shift(this.lfsr, getOutputLFSR());
  }
  
  private void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2[8] = -1;
    paramArrayOfByte2[9] = -1;
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
      int k = j + 1;
      int m = paramArrayOfByte2[k];
      paramArrayOfByte1[i] = ((paramArrayOfByte2[j] & 0xFF | m << 8) & 0xFFFF);
      paramArrayOfByte1 = this.lfsr;
      paramArrayOfByte2 = this.workingIV;
      k = paramArrayOfByte2[k];
      paramArrayOfByte1[i] = ((paramArrayOfByte2[j] & 0xFF | k << 8) & 0xFFFF);
      j += 2;
      i += 1;
    }
  }
  
  private int[] shift(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt[0] = paramArrayOfInt[1];
    paramArrayOfInt[1] = paramArrayOfInt[2];
    paramArrayOfInt[2] = paramArrayOfInt[3];
    paramArrayOfInt[3] = paramArrayOfInt[4];
    paramArrayOfInt[4] = paramInt;
    return paramArrayOfInt;
  }
  
  public String getAlgorithmName()
  {
    return "Grain v1";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      Object localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      if ((paramCipherParameters != null) && (paramCipherParameters.length == 8))
      {
        if ((((ParametersWithIV)localObject).getParameters() instanceof KeyParameter))
        {
          localObject = (KeyParameter)((ParametersWithIV)localObject).getParameters();
          this.workingIV = new byte[((KeyParameter)localObject).getKey().length];
          this.workingKey = new byte[((KeyParameter)localObject).getKey().length];
          this.lfsr = new int[5];
          this.nfsr = new int[5];
          this.out = new byte[2];
          System.arraycopy(paramCipherParameters, 0, this.workingIV, 0, paramCipherParameters.length);
          System.arraycopy(((KeyParameter)localObject).getKey(), 0, this.workingKey, 0, ((KeyParameter)localObject).getKey().length);
          reset();
          return;
        }
        throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
      }
      throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
    }
    throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
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
    this.index = 2;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\Grainv1Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */