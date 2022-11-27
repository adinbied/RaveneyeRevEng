package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DHBasicAgreement
  implements BasicAgreement
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private DHParameters dhParams;
  private DHPrivateKeyParameters key;
  
  public BigInteger calculateAgreement(CipherParameters paramCipherParameters)
  {
    paramCipherParameters = (DHPublicKeyParameters)paramCipherParameters;
    if (paramCipherParameters.getParameters().equals(this.dhParams))
    {
      paramCipherParameters = paramCipherParameters.getY().modPow(this.key.getX(), this.dhParams.getP());
      if (paramCipherParameters.compareTo(ONE) != 0) {
        return paramCipherParameters;
      }
      throw new IllegalStateException("Shared key can't be 1");
    }
    throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
  }
  
  public int getFieldSize()
  {
    return (this.key.getParameters().getP().bitLength() + 7) / 8;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    CipherParameters localCipherParameters = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localCipherParameters = ((ParametersWithRandom)paramCipherParameters).getParameters();
    }
    paramCipherParameters = (AsymmetricKeyParameter)localCipherParameters;
    if ((paramCipherParameters instanceof DHPrivateKeyParameters))
    {
      paramCipherParameters = (DHPrivateKeyParameters)paramCipherParameters;
      this.key = paramCipherParameters;
      this.dhParams = paramCipherParameters.getParameters();
      return;
    }
    throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\DHBasicAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */