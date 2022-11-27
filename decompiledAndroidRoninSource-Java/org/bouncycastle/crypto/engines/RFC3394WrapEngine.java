package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class RFC3394WrapEngine
  implements Wrapper
{
  private BlockCipher engine;
  private boolean forWrapping;
  private byte[] iv = { -90, -90, -90, -90, -90, -90, -90, -90 };
  private KeyParameter param;
  private boolean wrapCipherMode;
  
  public RFC3394WrapEngine(BlockCipher paramBlockCipher)
  {
    this(paramBlockCipher, false);
  }
  
  public RFC3394WrapEngine(BlockCipher paramBlockCipher, boolean paramBoolean)
  {
    this.engine = paramBlockCipher;
    this.wrapCipherMode = (paramBoolean ^ true);
  }
  
  public String getAlgorithmName()
  {
    return this.engine.getAlgorithmName();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forWrapping = paramBoolean;
    CipherParameters localCipherParameters = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localCipherParameters = ((ParametersWithRandom)paramCipherParameters).getParameters();
    }
    if ((localCipherParameters instanceof KeyParameter))
    {
      this.param = ((KeyParameter)localCipherParameters);
      return;
    }
    if ((localCipherParameters instanceof ParametersWithIV))
    {
      paramCipherParameters = (ParametersWithIV)localCipherParameters;
      this.iv = paramCipherParameters.getIV();
      this.param = ((KeyParameter)paramCipherParameters.getParameters());
      if (this.iv.length == 8) {
        return;
      }
      throw new IllegalArgumentException("IV not equal to 8");
    }
  }
  
  public byte[] unwrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (!this.forWrapping)
    {
      int i = paramInt2 / 8;
      if (i * 8 == paramInt2)
      {
        byte[] arrayOfByte4 = this.iv;
        byte[] arrayOfByte1 = new byte[paramInt2 - arrayOfByte4.length];
        byte[] arrayOfByte2 = new byte[arrayOfByte4.length];
        byte[] arrayOfByte3 = new byte[arrayOfByte4.length + 8];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, 0, arrayOfByte4.length);
        arrayOfByte4 = this.iv;
        System.arraycopy(paramArrayOfByte, paramInt1 + arrayOfByte4.length, arrayOfByte1, 0, paramInt2 - arrayOfByte4.length);
        this.engine.init(this.wrapCipherMode ^ true, this.param);
        int k = i - 1;
        paramInt1 = 5;
        while (paramInt1 >= 0)
        {
          paramInt2 = k;
          while (paramInt2 >= 1)
          {
            System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, this.iv.length);
            int m = (paramInt2 - 1) * 8;
            System.arraycopy(arrayOfByte1, m, arrayOfByte3, this.iv.length, 8);
            int j = k * paramInt1 + paramInt2;
            i = 1;
            while (j != 0)
            {
              int n = (byte)j;
              int i1 = this.iv.length - i;
              arrayOfByte3[i1] = ((byte)(n ^ arrayOfByte3[i1]));
              j >>>= 8;
              i += 1;
            }
            this.engine.processBlock(arrayOfByte3, 0, arrayOfByte3, 0);
            System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, 8);
            System.arraycopy(arrayOfByte3, 8, arrayOfByte1, m, 8);
            paramInt2 -= 1;
          }
          paramInt1 -= 1;
        }
        if (Arrays.constantTimeAreEqual(arrayOfByte2, this.iv)) {
          return arrayOfByte1;
        }
        throw new InvalidCipherTextException("checksum failed");
      }
      throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
    }
    throw new IllegalStateException("not set for unwrapping");
  }
  
  public byte[] wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.forWrapping)
    {
      int k = paramInt2 / 8;
      if (k * 8 == paramInt2)
      {
        byte[] arrayOfByte1 = this.iv;
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt2];
        byte[] arrayOfByte3 = new byte[arrayOfByte1.length + 8];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, this.iv.length, paramInt2);
        this.engine.init(this.wrapCipherMode, this.param);
        paramInt1 = 0;
        while (paramInt1 != 6)
        {
          paramInt2 = 1;
          while (paramInt2 <= k)
          {
            System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, this.iv.length);
            int m = paramInt2 * 8;
            System.arraycopy(arrayOfByte2, m, arrayOfByte3, this.iv.length, 8);
            this.engine.processBlock(arrayOfByte3, 0, arrayOfByte3, 0);
            int j = k * paramInt1 + paramInt2;
            int i = 1;
            while (j != 0)
            {
              int n = (byte)j;
              int i1 = this.iv.length - i;
              arrayOfByte3[i1] = ((byte)(n ^ arrayOfByte3[i1]));
              j >>>= 8;
              i += 1;
            }
            System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, 8);
            System.arraycopy(arrayOfByte3, 8, arrayOfByte2, m, 8);
            paramInt2 += 1;
          }
          paramInt1 += 1;
        }
        return arrayOfByte2;
      }
      throw new DataLengthException("wrap data must be a multiple of 8 bytes");
    }
    throw new IllegalStateException("not set for wrapping");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RFC3394WrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */