package org.bouncycastle.cms.bc;

import java.io.IOException;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.operator.bc.BcRSAAsymmetricKeyWrapper;

public class BcRSAKeyTransRecipientInfoGenerator
  extends BcKeyTransRecipientInfoGenerator
{
  public BcRSAKeyTransRecipientInfoGenerator(X509CertificateHolder paramX509CertificateHolder)
    throws IOException
  {
    super(paramX509CertificateHolder, new BcRSAAsymmetricKeyWrapper(paramX509CertificateHolder.getSubjectPublicKeyInfo().getAlgorithmId(), paramX509CertificateHolder.getSubjectPublicKeyInfo()));
  }
  
  public BcRSAKeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, AlgorithmIdentifier paramAlgorithmIdentifier, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    super(paramArrayOfByte, new BcRSAAsymmetricKeyWrapper(paramAlgorithmIdentifier, paramAsymmetricKeyParameter));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcRSAKeyTransRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */