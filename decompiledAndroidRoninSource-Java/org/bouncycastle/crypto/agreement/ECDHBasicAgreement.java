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

public class ECDHBasicAgreement
  implements BasicAgreement
{
  private ECPrivateKeyParameters key;
  
  public BigInteger calculateAgreement(CipherParameters paramCipherParameters)
  {
    paramCipherParameters = (ECPublicKeyParameters)paramCipherParameters;
    if (paramCipherParameters.getParameters().equals(this.key.getParameters()))
    {
      paramCipherParameters = paramCipherParameters.getQ().multiply(this.key.getD()).normalize();
      if (!paramCipherParameters.isInfinity()) {
        return paramCipherParameters.getAffineXCoord().toBigInteger();
      }
      throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
    }
    throw new IllegalStateException("ECDH public key has wrong domain parameters");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\ECDHBasicAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */