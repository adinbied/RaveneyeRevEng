package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.GOST3410KeyParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class GOST3410Signer
  implements DSA
{
  GOST3410KeyParameters key;
  SecureRandom random;
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    Object localObject = new byte[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = paramArrayOfByte[(j - 1 - i)];
      i += 1;
    }
    paramArrayOfByte = new BigInteger(1, (byte[])localObject);
    localObject = this.key.getParameters();
    BigInteger localBigInteger1;
    do
    {
      localBigInteger1 = new BigInteger(((GOST3410Parameters)localObject).getQ().bitLength(), this.random);
    } while (localBigInteger1.compareTo(((GOST3410Parameters)localObject).getQ()) >= 0);
    BigInteger localBigInteger2 = ((GOST3410Parameters)localObject).getA().modPow(localBigInteger1, ((GOST3410Parameters)localObject).getP()).mod(((GOST3410Parameters)localObject).getQ());
    return new BigInteger[] { localBigInteger2, localBigInteger1.multiply(paramArrayOfByte).add(((GOST3410PrivateKeyParameters)this.key).getX().multiply(localBigInteger2)).mod(((GOST3410Parameters)localObject).getQ()) };
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.random = paramCipherParameters.getRandom();
        this.key = ((GOST3410PrivateKeyParameters)paramCipherParameters.getParameters());
        return;
      }
      this.random = new SecureRandom();
      paramCipherParameters = (GOST3410PrivateKeyParameters)paramCipherParameters;
    }
    else
    {
      paramCipherParameters = (GOST3410PublicKeyParameters)paramCipherParameters;
    }
    this.key = paramCipherParameters;
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    int j = paramArrayOfByte.length;
    Object localObject = new byte[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = paramArrayOfByte[(j - 1 - i)];
      i += 1;
    }
    localObject = new BigInteger(1, (byte[])localObject);
    paramArrayOfByte = this.key.getParameters();
    BigInteger localBigInteger = BigInteger.valueOf(0L);
    if (localBigInteger.compareTo(paramBigInteger1) < 0)
    {
      if (paramArrayOfByte.getQ().compareTo(paramBigInteger1) <= 0) {
        return false;
      }
      if (localBigInteger.compareTo(paramBigInteger2) < 0)
      {
        if (paramArrayOfByte.getQ().compareTo(paramBigInteger2) <= 0) {
          return false;
        }
        localObject = ((BigInteger)localObject).modPow(paramArrayOfByte.getQ().subtract(new BigInteger("2")), paramArrayOfByte.getQ());
        paramBigInteger2 = paramBigInteger2.multiply((BigInteger)localObject).mod(paramArrayOfByte.getQ());
        localObject = paramArrayOfByte.getQ().subtract(paramBigInteger1).multiply((BigInteger)localObject).mod(paramArrayOfByte.getQ());
        return paramArrayOfByte.getA().modPow(paramBigInteger2, paramArrayOfByte.getP()).multiply(((GOST3410PublicKeyParameters)this.key).getY().modPow((BigInteger)localObject, paramArrayOfByte.getP())).mod(paramArrayOfByte.getP()).mod(paramArrayOfByte.getQ()).equals(paramBigInteger1);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\GOST3410Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */