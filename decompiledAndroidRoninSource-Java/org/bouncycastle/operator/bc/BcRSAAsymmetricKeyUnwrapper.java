package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class BcRSAAsymmetricKeyUnwrapper
  extends BcAsymmetricKeyUnwrapper
{
  public BcRSAAsymmetricKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    super(paramAlgorithmIdentifier, paramAsymmetricKeyParameter);
  }
  
  protected AsymmetricBlockCipher createAsymmetricUnwrapper(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return new PKCS1Encoding(new RSAEngine());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcRSAAsymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */