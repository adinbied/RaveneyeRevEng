package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class RFC3211WrapEngine
  implements Wrapper
{
  private CBCBlockCipher engine;
  private boolean forWrapping;
  private ParametersWithIV param;
  private SecureRandom rand;
  
  public RFC3211WrapEngine(BlockCipher paramBlockCipher)
  {
    this.engine = new CBCBlockCipher(paramBlockCipher);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.engine.getUnderlyingCipher().getAlgorithmName());
    localStringBuilder.append("/RFC3211Wrap");
    return localStringBuilder.toString();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forWrapping = paramBoolean;
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.rand = paramCipherParameters.getRandom();
      this.param = ((ParametersWithIV)paramCipherParameters.getParameters());
      return;
    }
    if (paramBoolean) {
      this.rand = new SecureRandom();
    }
    this.param = ((ParametersWithIV)paramCipherParameters);
  }
  
  public byte[] unwrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (!this.forWrapping)
    {
      int j = this.engine.getBlockSize();
      if (paramInt2 >= j * 2)
      {
        byte[] arrayOfByte1 = new byte[paramInt2];
        byte[] arrayOfByte2 = new byte[j];
        int i = 0;
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte1, 0, paramInt2);
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, 0, j);
        this.engine.init(false, new ParametersWithIV(this.param.getParameters(), arrayOfByte2));
        paramInt1 = j;
        while (paramInt1 < paramInt2)
        {
          this.engine.processBlock(arrayOfByte1, paramInt1, arrayOfByte1, paramInt1);
          paramInt1 += j;
        }
        System.arraycopy(arrayOfByte1, paramInt2 - j, arrayOfByte2, 0, j);
        this.engine.init(false, new ParametersWithIV(this.param.getParameters(), arrayOfByte2));
        this.engine.processBlock(arrayOfByte1, 0, arrayOfByte1, 0);
        this.engine.init(false, this.param);
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          this.engine.processBlock(arrayOfByte1, paramInt1, arrayOfByte1, paramInt1);
          paramInt1 += j;
        }
        if ((arrayOfByte1[0] & 0xFF) <= paramInt2 - 4)
        {
          paramArrayOfByte = new byte[arrayOfByte1[0] & 0xFF];
          System.arraycopy(arrayOfByte1, 4, paramArrayOfByte, 0, arrayOfByte1[0]);
          paramInt2 = 0;
          for (paramInt1 = i; paramInt1 != 3; paramInt1 = i)
          {
            i = paramInt1 + 1;
            paramInt2 |= (byte)arrayOfByte1[i] ^ paramArrayOfByte[paramInt1];
          }
          if (paramInt2 == 0) {
            return paramArrayOfByte;
          }
          throw new InvalidCipherTextException("wrapped key fails checksum");
        }
        throw new InvalidCipherTextException("wrapped key corrupted");
      }
      throw new InvalidCipherTextException("input too short");
    }
    throw new IllegalStateException("not set for unwrapping");
  }
  
  public byte[] wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.forWrapping)
    {
      this.engine.init(true, this.param);
      int m = this.engine.getBlockSize();
      int k = paramInt2 + 4;
      int j = m * 2;
      if (k < j) {}
      byte[] arrayOfByte;
      for (;;)
      {
        arrayOfByte = new byte[j];
        break;
        if (k % m == 0) {
          j = k;
        } else {
          j = (k / m + 1) * m;
        }
      }
      int i = (byte)paramInt2;
      j = 0;
      arrayOfByte[0] = i;
      arrayOfByte[1] = ((byte)paramArrayOfByte[paramInt1]);
      arrayOfByte[2] = ((byte)paramArrayOfByte[(paramInt1 + 1)]);
      arrayOfByte[3] = ((byte)paramArrayOfByte[(paramInt1 + 2)]);
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 4, paramInt2);
      paramInt1 = arrayOfByte.length - k;
      paramArrayOfByte = new byte[paramInt1];
      this.rand.nextBytes(paramArrayOfByte);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, k, paramInt1);
      paramInt1 = 0;
      for (;;)
      {
        paramInt2 = j;
        if (paramInt1 >= arrayOfByte.length) {
          break;
        }
        this.engine.processBlock(arrayOfByte, paramInt1, arrayOfByte, paramInt1);
        paramInt1 += m;
      }
      while (paramInt2 < arrayOfByte.length)
      {
        this.engine.processBlock(arrayOfByte, paramInt2, arrayOfByte, paramInt2);
        paramInt2 += m;
      }
      return arrayOfByte;
    }
    throw new IllegalStateException("not set for wrapping");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RFC3211WrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */