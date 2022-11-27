package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class RC2WrapEngine
  implements Wrapper
{
  private static final byte[] IV2 = { 74, -35, -94, 44, 121, -24, 33, 5 };
  byte[] digest = new byte[20];
  private CBCBlockCipher engine;
  private boolean forWrapping;
  private byte[] iv;
  private CipherParameters param;
  private ParametersWithIV paramPlusIV;
  Digest sha1 = DigestFactory.createSHA1();
  private SecureRandom sr;
  
  private byte[] calculateCMSKeyChecksum(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    this.sha1.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    this.sha1.doFinal(this.digest, 0);
    System.arraycopy(this.digest, 0, arrayOfByte, 0, 8);
    return arrayOfByte;
  }
  
  private boolean checkCMSKeyChecksum(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return Arrays.constantTimeAreEqual(calculateCMSKeyChecksum(paramArrayOfByte1), paramArrayOfByte2);
  }
  
  public String getAlgorithmName()
  {
    return "RC2";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forWrapping = paramBoolean;
    this.engine = new CBCBlockCipher(new RC2Engine());
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.sr = paramCipherParameters.getRandom();
      paramCipherParameters = paramCipherParameters.getParameters();
    }
    else
    {
      this.sr = new SecureRandom();
    }
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      paramCipherParameters = (ParametersWithIV)paramCipherParameters;
      this.paramPlusIV = paramCipherParameters;
      this.iv = paramCipherParameters.getIV();
      this.param = this.paramPlusIV.getParameters();
      if (this.forWrapping)
      {
        paramCipherParameters = this.iv;
        if ((paramCipherParameters != null) && (paramCipherParameters.length == 8)) {
          return;
        }
        throw new IllegalArgumentException("IV is not 8 octets");
      }
      throw new IllegalArgumentException("You should not supply an IV for unwrapping");
    }
    this.param = paramCipherParameters;
    if (this.forWrapping)
    {
      paramCipherParameters = new byte[8];
      this.iv = paramCipherParameters;
      this.sr.nextBytes(paramCipherParameters);
      this.paramPlusIV = new ParametersWithIV(this.param, this.iv);
    }
  }
  
  public byte[] unwrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (!this.forWrapping)
    {
      if (paramArrayOfByte != null)
      {
        if (paramInt2 % this.engine.getBlockSize() == 0)
        {
          Object localObject = new ParametersWithIV(this.param, IV2);
          this.engine.init(false, (CipherParameters)localObject);
          byte[] arrayOfByte = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
          paramInt1 = 0;
          int i;
          while (paramInt1 < paramInt2 / this.engine.getBlockSize())
          {
            i = this.engine.getBlockSize() * paramInt1;
            this.engine.processBlock(arrayOfByte, i, arrayOfByte, i);
            paramInt1 += 1;
          }
          localObject = new byte[paramInt2];
          for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1 = i)
          {
            i = paramInt1 + 1;
            localObject[paramInt1] = arrayOfByte[(paramInt2 - i)];
          }
          arrayOfByte = new byte[8];
          this.iv = arrayOfByte;
          paramInt2 -= 8;
          paramArrayOfByte = new byte[paramInt2];
          System.arraycopy(localObject, 0, arrayOfByte, 0, 8);
          System.arraycopy(localObject, 8, paramArrayOfByte, 0, paramInt2);
          localObject = new ParametersWithIV(this.param, this.iv);
          this.paramPlusIV = ((ParametersWithIV)localObject);
          this.engine.init(false, (CipherParameters)localObject);
          localObject = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramInt2);
          paramInt1 = 0;
          while (paramInt1 < paramInt2 / this.engine.getBlockSize())
          {
            i = this.engine.getBlockSize() * paramInt1;
            this.engine.processBlock((byte[])localObject, i, (byte[])localObject, i);
            paramInt1 += 1;
          }
          paramInt1 = paramInt2 - 8;
          paramArrayOfByte = new byte[paramInt1];
          arrayOfByte = new byte[8];
          System.arraycopy(localObject, 0, paramArrayOfByte, 0, paramInt1);
          System.arraycopy(localObject, paramInt1, arrayOfByte, 0, 8);
          if (checkCMSKeyChecksum(paramArrayOfByte, arrayOfByte))
          {
            if (paramInt1 - ((paramArrayOfByte[0] & 0xFF) + 1) <= 7)
            {
              paramInt1 = paramArrayOfByte[0];
              localObject = new byte[paramInt1];
              System.arraycopy(paramArrayOfByte, 1, localObject, 0, paramInt1);
              return (byte[])localObject;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("too many pad bytes (");
            ((StringBuilder)localObject).append(paramInt1 - ((paramArrayOfByte[0] & 0xFF) + 1));
            ((StringBuilder)localObject).append(")");
            throw new InvalidCipherTextException(((StringBuilder)localObject).toString());
          }
          throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Ciphertext not multiple of ");
        paramArrayOfByte.append(this.engine.getBlockSize());
        throw new InvalidCipherTextException(paramArrayOfByte.toString());
      }
      throw new InvalidCipherTextException("Null pointer as ciphertext");
    }
    throw new IllegalStateException("Not set for unwrapping");
  }
  
  public byte[] wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.forWrapping)
    {
      int m = paramInt2 + 1;
      int j = m % 8;
      if (j != 0) {
        j = 8 - j + m;
      } else {
        j = m;
      }
      byte[] arrayOfByte1 = new byte[j];
      int i = (byte)paramInt2;
      int k = 0;
      arrayOfByte1[0] = i;
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte1, 1, paramInt2);
      paramInt1 = j - paramInt2 - 1;
      paramArrayOfByte = new byte[paramInt1];
      if (paramInt1 > 0)
      {
        this.sr.nextBytes(paramArrayOfByte);
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, m, paramInt1);
      }
      byte[] arrayOfByte2 = calculateCMSKeyChecksum(arrayOfByte1);
      paramInt2 = arrayOfByte2.length + j;
      paramArrayOfByte = new byte[paramInt2];
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, j);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, j, arrayOfByte2.length);
      arrayOfByte1 = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramInt2);
      j = paramInt2 / this.engine.getBlockSize();
      if (paramInt2 % this.engine.getBlockSize() == 0)
      {
        this.engine.init(true, this.paramPlusIV);
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          m = this.engine.getBlockSize() * paramInt1;
          this.engine.processBlock(arrayOfByte1, m, arrayOfByte1, m);
          paramInt1 += 1;
        }
        arrayOfByte2 = this.iv;
        m = arrayOfByte2.length + paramInt2;
        paramArrayOfByte = new byte[m];
        System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, 0, arrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, this.iv.length, paramInt2);
        arrayOfByte1 = new byte[m];
        for (paramInt1 = 0; paramInt1 < m; paramInt1 = paramInt2)
        {
          paramInt2 = paramInt1 + 1;
          arrayOfByte1[paramInt1] = paramArrayOfByte[(m - paramInt2)];
        }
        paramArrayOfByte = new ParametersWithIV(this.param, IV2);
        this.engine.init(true, paramArrayOfByte);
        paramInt1 = k;
        while (paramInt1 < j + 1)
        {
          paramInt2 = this.engine.getBlockSize() * paramInt1;
          this.engine.processBlock(arrayOfByte1, paramInt2, arrayOfByte1, paramInt2);
          paramInt1 += 1;
        }
        return arrayOfByte1;
      }
      throw new IllegalStateException("Not multiple of block length");
    }
    throw new IllegalStateException("Not initialized for wrapping");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RC2WrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */