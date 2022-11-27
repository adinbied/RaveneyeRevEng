package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public class ECDHCBasicAgreement
  implements BasicAgreement
{
  ECPrivateKeyParameters key;
  
  public BigInteger calculateAgreement(CipherParameters paramCipherParameters)
  {
    paramCipherParameters = (ECPublicKeyParameters)paramCipherParameters;
    Object localObject = paramCipherParameters.getParameters();
    if (((ECDomainParameters)localObject).equals(this.key.getParameters()))
    {
      localObject = ((ECDomainParameters)localObject).getH().multiply(this.key.getD()).mod(((ECDomainParameters)localObject).getN());
      paramCipherParameters = paramCipherParameters.getQ().multiply((BigInteger)localObject).normalize();
      if (!paramCipherParameters.isInfinity()) {
        return paramCipherParameters.getAffineXCoord().toBigInteger();
      }
      throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
    }
    throw new IllegalStateException("ECDHC public key has wrong domain parameters");
  }
  
  public int getFieldSize()
  {
    return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    this.key = ((ECPrivateKeyParameters)paramCipherParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\ECDHCBasicAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */