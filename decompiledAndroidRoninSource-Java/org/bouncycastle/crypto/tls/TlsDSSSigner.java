package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.signers.DSASigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;

public class TlsDSSSigner
  extends TlsDSASigner
{
  protected DSA createDSAImpl(short paramShort)
  {
    return new DSASigner(new HMacDSAKCalculator(TlsUtils.createHash(paramShort)));
  }
  
  protected short getSignatureAlgorithm()
  {
    return 2;
  }
  
  public boolean isValidPublicKey(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return paramAsymmetricKeyParameter instanceof DSAPublicKeyParameters;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsDSSSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */