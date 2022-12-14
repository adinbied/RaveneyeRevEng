package org.bouncycastle.cms.bc;

import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import org.bouncycastle.operator.bc.BcAsymmetricKeyWrapper;

public abstract class BcKeyTransRecipientInfoGenerator
  extends KeyTransRecipientInfoGenerator
{
  public BcKeyTransRecipientInfoGenerator(X509CertificateHolder paramX509CertificateHolder, BcAsymmetricKeyWrapper paramBcAsymmetricKeyWrapper)
  {
    super(new IssuerAndSerialNumber(paramX509CertificateHolder.toASN1Structure()), paramBcAsymmetricKeyWrapper);
  }
  
  public BcKeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, BcAsymmetricKeyWrapper paramBcAsymmetricKeyWrapper)
  {
    super(paramArrayOfByte, paramBcAsymmetricKeyWrapper);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcKeyTransRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */