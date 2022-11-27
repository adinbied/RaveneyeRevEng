package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class RFC5649WrapEngine
  implements Wrapper
{
  private BlockCipher engine;
  private byte[] extractedAIV;
  private boolean forWrapping;
  private byte[] highOrderIV;
  private KeyParameter param;
  private byte[] preIV;
  
  public RFC5649WrapEngine(BlockCipher paramBlockCipher)
  {
    byte[] arrayOfByte = new byte[4];
    byte[] tmp9_8 = arrayOfByte;
    tmp9_8[0] = -90;
    byte[] tmp14_9 = tmp9_8;
    tmp14_9[1] = 89;
    byte[] tmp19_14 = tmp14_9;
    tmp19_14[2] = 89;
    byte[] tmp24_19 = tmp19_14;
    tmp24_19[3] = -90;
    tmp24_19;
    this.highOrderIV = arrayOfByte;
    this.preIV = arrayOfByte;
    this.extractedAIV = null;
    this.engine = paramBlockCipher;
  }
  
  private byte[] padPlaintext(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = (8 - i % 8) % 8;
    byte[] arrayOfByte = new byte[i + j];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    if (j != 0) {
      System.arraycopy(new byte[j], 0, arrayOfByte, i, j);
    }
    return arrayOfByte;
  }
  
  private byte[] rfc3394UnwrapNoIvCheck(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - 8;
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[8];
    byte[] arrayOfByte3 = new byte[16];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, 0, 8);
    System.arraycopy(paramArrayOfByte, paramInt1 + 8, arrayOfByte1, 0, i);
    this.engine.init(false, this.param);
    int k = paramInt2 / 8 - 1;
    paramInt1 = 5;
    while (paramInt1 >= 0)
    {
      paramInt2 = k;
      while (paramInt2 >= 1)
      {
        System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, 8);
        int m = (paramInt2 - 1) * 8;
        System.arraycopy(arrayOfByte1, m, arrayOfByte3, 8, 8);
        int j = k * paramInt1 + paramInt2;
        i = 1;
        while (j != 0)
        {
          int n = (byte)j;
          int i1 = 8 - i;
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
    this.extractedAIV = arrayOfByte2;
    return arrayOfByte1;
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
      this.preIV = this.highOrderIV;
      return;
    }
    if ((localCipherParameters instanceof ParametersWithIV))
    {
      paramCipherParameters = (ParametersWithIV)localCipherParameters;
      this.preIV = paramCipherParameters.getIV();
      this.param = ((KeyParameter)paramCipherParameters.getParameters());
      if (this.preIV.length == 4) {
        return;
      }
      throw new IllegalArgumentException("IV length not equal to 4");
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
        if (i != 1)
        {
          byte[] arrayOfByte2 = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, 0, paramInt2);
          byte[] arrayOfByte1 = new byte[paramInt2];
          if (i == 2)
          {
            this.engine.init(false, this.param);
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              this.engine.processBlock(arrayOfByte2, paramInt1, arrayOfByte1, paramInt1);
              paramInt1 += this.engine.getBlockSize();
            }
            paramArrayOfByte = new byte[8];
            this.extractedAIV = paramArrayOfByte;
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
            arrayOfByte2 = this.extractedAIV;
            paramInt1 = paramInt2 - arrayOfByte2.length;
            paramArrayOfByte = new byte[paramInt1];
            System.arraycopy(arrayOfByte1, arrayOfByte2.length, paramArrayOfByte, 0, paramInt1);
          }
          else
          {
            paramArrayOfByte = rfc3394UnwrapNoIvCheck(paramArrayOfByte, paramInt1, paramInt2);
          }
          arrayOfByte1 = new byte[4];
          arrayOfByte2 = new byte[4];
          System.arraycopy(this.extractedAIV, 0, arrayOfByte1, 0, 4);
          System.arraycopy(this.extractedAIV, 4, arrayOfByte2, 0, 4);
          i = Pack.bigEndianToInt(arrayOfByte2, 0);
          boolean bool = Arrays.constantTimeAreEqual(arrayOfByte1, this.preIV);
          paramInt1 = paramArrayOfByte.length;
          if (i <= paramInt1 - 8) {
            bool = false;
          }
          if (i > paramInt1) {
            bool = false;
          }
          paramInt2 = paramInt1 - i;
          paramInt1 = paramInt2;
          if (paramInt2 >= paramArrayOfByte.length)
          {
            paramInt1 = paramArrayOfByte.length;
            bool = false;
          }
          arrayOfByte1 = new byte[paramInt1];
          arrayOfByte2 = new byte[paramInt1];
          System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - paramInt1, arrayOfByte2, 0, paramInt1);
          if (!Arrays.constantTimeAreEqual(arrayOfByte2, arrayOfByte1)) {
            bool = false;
          }
          if (bool)
          {
            arrayOfByte1 = new byte[i];
            System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, i);
            return arrayOfByte1;
          }
          throw new InvalidCipherTextException("checksum failed");
        }
        throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
      }
      throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
    }
    throw new IllegalStateException("not set for unwrapping");
  }
  
  public byte[] wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.forWrapping)
    {
      byte[] arrayOfByte1 = new byte[8];
      Object localObject = Pack.intToBigEndian(paramInt2);
      byte[] arrayOfByte2 = this.preIV;
      int j = arrayOfByte2.length;
      int i = 0;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, j);
      System.arraycopy(localObject, 0, arrayOfByte1, this.preIV.length, localObject.length);
      localObject = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, localObject, 0, paramInt2);
      paramArrayOfByte = padPlaintext((byte[])localObject);
      if (paramArrayOfByte.length == 8)
      {
        paramInt2 = paramArrayOfByte.length + 8;
        localObject = new byte[paramInt2];
        System.arraycopy(arrayOfByte1, 0, localObject, 0, 8);
        System.arraycopy(paramArrayOfByte, 0, localObject, 8, paramArrayOfByte.length);
        this.engine.init(true, this.param);
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          this.engine.processBlock((byte[])localObject, paramInt1, (byte[])localObject, paramInt1);
          paramInt1 += this.engine.getBlockSize();
        }
        return (byte[])localObject;
      }
      localObject = new RFC3394WrapEngine(this.engine);
      ((Wrapper)localObject).init(true, new ParametersWithIV(this.param, arrayOfByte1));
      return ((Wrapper)localObject).wrap(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalStateException("not set for wrapping");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RFC5649WrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */