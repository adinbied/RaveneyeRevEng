package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class DESedeWrapEngine
  implements Wrapper
{
  private static final byte[] IV2 = { 74, -35, -94, 44, 121, -24, 33, 5 };
  byte[] digest = new byte[20];
  private CBCBlockCipher engine;
  private boolean forWrapping;
  private byte[] iv;
  private KeyParameter param;
  private ParametersWithIV paramPlusIV;
  Digest sha1 = DigestFactory.createSHA1();
  
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
  
  private static byte[] reverse(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int j;
    for (int i = 0; i < paramArrayOfByte.length; i = j)
    {
      int k = paramArrayOfByte.length;
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte[(k - j)];
    }
    return arrayOfByte;
  }
  
  public String getAlgorithmName()
  {
    return "DESede";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forWrapping = paramBoolean;
    this.engine = new CBCBlockCipher(new DESedeEngine());
    Object localObject;
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      localObject = (ParametersWithRandom)paramCipherParameters;
      paramCipherParameters = ((ParametersWithRandom)localObject).getParameters();
      localObject = ((ParametersWithRandom)localObject).getRandom();
    }
    else
    {
      localObject = new SecureRandom();
    }
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this.param = ((KeyParameter)paramCipherParameters);
      if (this.forWrapping)
      {
        paramCipherParameters = new byte[8];
        this.iv = paramCipherParameters;
        ((SecureRandom)localObject).nextBytes(paramCipherParameters);
        this.paramPlusIV = new ParametersWithIV(this.param, this.iv);
      }
    }
    else if ((paramCipherParameters instanceof ParametersWithIV))
    {
      paramCipherParameters = (ParametersWithIV)paramCipherParameters;
      this.paramPlusIV = paramCipherParameters;
      this.iv = paramCipherParameters.getIV();
      this.param = ((KeyParameter)this.paramPlusIV.getParameters());
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
  }
  
  public byte[] unwrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (!this.forWrapping)
    {
      if (paramArrayOfByte != null)
      {
        int j = this.engine.getBlockSize();
        if (paramInt2 % j == 0)
        {
          Object localObject = new ParametersWithIV(this.param, IV2);
          this.engine.init(false, (CipherParameters)localObject);
          localObject = new byte[paramInt2];
          int i = 0;
          while (i != paramInt2)
          {
            this.engine.processBlock(paramArrayOfByte, paramInt1 + i, (byte[])localObject, i);
            i += j;
          }
          localObject = reverse((byte[])localObject);
          byte[] arrayOfByte = new byte[8];
          this.iv = arrayOfByte;
          paramInt2 = localObject.length - 8;
          paramArrayOfByte = new byte[paramInt2];
          System.arraycopy(localObject, 0, arrayOfByte, 0, 8);
          System.arraycopy(localObject, 8, paramArrayOfByte, 0, localObject.length - 8);
          localObject = new ParametersWithIV(this.param, this.iv);
          this.paramPlusIV = ((ParametersWithIV)localObject);
          this.engine.init(false, (CipherParameters)localObject);
          localObject = new byte[paramInt2];
          paramInt1 = 0;
          while (paramInt1 != paramInt2)
          {
            this.engine.processBlock(paramArrayOfByte, paramInt1, (byte[])localObject, paramInt1);
            paramInt1 += j;
          }
          paramInt1 = paramInt2 - 8;
          paramArrayOfByte = new byte[paramInt1];
          arrayOfByte = new byte[8];
          System.arraycopy(localObject, 0, paramArrayOfByte, 0, paramInt1);
          System.arraycopy(localObject, paramInt1, arrayOfByte, 0, 8);
          if (checkCMSKeyChecksum(paramArrayOfByte, arrayOfByte)) {
            return paramArrayOfByte;
          }
          throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Ciphertext not multiple of ");
        paramArrayOfByte.append(j);
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
      Object localObject = new byte[paramInt2];
      int i = 0;
      System.arraycopy(paramArrayOfByte, paramInt1, localObject, 0, paramInt2);
      byte[] arrayOfByte = calculateCMSKeyChecksum((byte[])localObject);
      int j = arrayOfByte.length + paramInt2;
      paramArrayOfByte = new byte[j];
      System.arraycopy(localObject, 0, paramArrayOfByte, 0, paramInt2);
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt2, arrayOfByte.length);
      paramInt2 = this.engine.getBlockSize();
      if (j % paramInt2 == 0)
      {
        this.engine.init(true, this.paramPlusIV);
        localObject = new byte[j];
        paramInt1 = 0;
        while (paramInt1 != j)
        {
          this.engine.processBlock(paramArrayOfByte, paramInt1, (byte[])localObject, paramInt1);
          paramInt1 += paramInt2;
        }
        paramArrayOfByte = this.iv;
        arrayOfByte = new byte[paramArrayOfByte.length + j];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        System.arraycopy(localObject, 0, arrayOfByte, this.iv.length, j);
        paramArrayOfByte = reverse(arrayOfByte);
        localObject = new ParametersWithIV(this.param, IV2);
        this.engine.init(true, (CipherParameters)localObject);
        paramInt1 = i;
        while (paramInt1 != paramArrayOfByte.length)
        {
          this.engine.processBlock(paramArrayOfByte, paramInt1, paramArrayOfByte, paramInt1);
          paramInt1 += paramInt2;
        }
        return paramArrayOfByte;
      }
      throw new IllegalStateException("Not multiple of block length");
    }
    throw new IllegalStateException("Not initialized for wrapping");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\DESedeWrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */