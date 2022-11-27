package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class RSAKeyEncapsulation
  implements KeyEncapsulation
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private DerivationFunction kdf;
  private RSAKeyParameters key;
  private SecureRandom rnd;
  
  public RSAKeyEncapsulation(DerivationFunction paramDerivationFunction, SecureRandom paramSecureRandom)
  {
    this.kdf = paramDerivationFunction;
    this.rnd = paramSecureRandom;
  }
  
  public CipherParameters decrypt(byte[] paramArrayOfByte, int paramInt)
  {
    return decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public CipherParameters decrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IllegalArgumentException
  {
    if (this.key.isPrivate())
    {
      BigInteger localBigInteger1 = this.key.getModulus();
      BigInteger localBigInteger2 = this.key.getExponent();
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return generateKey(localBigInteger1, new BigInteger(1, arrayOfByte).modPow(localBigInteger2, localBigInteger1), paramInt3);
    }
    throw new IllegalArgumentException("Private key required for decryption");
  }
  
  public CipherParameters encrypt(byte[] paramArrayOfByte, int paramInt)
  {
    return encrypt(paramArrayOfByte, 0, paramInt);
  }
  
  public CipherParameters encrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    if (!this.key.isPrivate())
    {
      BigInteger localBigInteger1 = this.key.getModulus();
      Object localObject = this.key.getExponent();
      BigInteger localBigInteger2 = BigIntegers.createRandomInRange(ZERO, localBigInteger1.subtract(ONE), this.rnd);
      localObject = localBigInteger2.modPow((BigInteger)localObject, localBigInteger1);
      localObject = BigIntegers.asUnsignedByteArray((localBigInteger1.bitLength() + 7) / 8, (BigInteger)localObject);
      System.arraycopy(localObject, 0, paramArrayOfByte, paramInt1, localObject.length);
      return generateKey(localBigInteger1, localBigInteger2, paramInt2);
    }
    throw new IllegalArgumentException("Public key required for encryption");
  }
  
  protected KeyParameter generateKey(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    paramBigInteger1 = BigIntegers.asUnsignedByteArray((paramBigInteger1.bitLength() + 7) / 8, paramBigInteger2);
    this.kdf.init(new KDFParameters(paramBigInteger1, null));
    paramBigInteger1 = new byte[paramInt];
    this.kdf.generateBytes(paramBigInteger1, 0, paramInt);
    return new KeyParameter(paramBigInteger1);
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof RSAKeyParameters))
    {
      this.key = ((RSAKeyParameters)paramCipherParameters);
      return;
    }
    throw new IllegalArgumentException("RSA key required");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\kems\RSAKeyEncapsulation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */