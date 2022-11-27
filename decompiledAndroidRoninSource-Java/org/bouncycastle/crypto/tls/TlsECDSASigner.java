package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;

public class TlsECDSASigner
  extends TlsDSASigner
{
  protected DSA createDSAImpl(short paramShort)
  {
    return new ECDSASigner(new HMacDSAKCalculator(TlsUtils.createHash(paramShort)));
  }
  
  protected short getSignatureAlgorithm()
  {
    return 3;
  }
  
  public boolean isValidPublicKey(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return paramAsymmetricKeyParameter instanceof ECPublicKeyParameters;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsECDSASigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */