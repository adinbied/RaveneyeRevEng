package org.bouncycastle.pkix;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.KeyTransRecipientId;
import org.bouncycastle.cms.RecipientId;

public class PKIXIdentity
{
  private final X509CertificateHolder[] certificateHolders;
  private final PrivateKeyInfo privateKeyInfo;
  
  public PKIXIdentity(PrivateKeyInfo paramPrivateKeyInfo, X509CertificateHolder[] paramArrayOfX509CertificateHolder)
  {
    this.privateKeyInfo = paramPrivateKeyInfo;
    paramPrivateKeyInfo = new X509CertificateHolder[paramArrayOfX509CertificateHolder.length];
    this.certificateHolders = paramPrivateKeyInfo;
    System.arraycopy(paramArrayOfX509CertificateHolder, 0, paramPrivateKeyInfo, 0, paramArrayOfX509CertificateHolder.length);
  }
  
  private byte[] getSubjectKeyIdentifier()
  {
    SubjectKeyIdentifier localSubjectKeyIdentifier = SubjectKeyIdentifier.fromExtensions(this.certificateHolders[0].getExtensions());
    if (localSubjectKeyIdentifier == null) {
      return null;
    }
    return localSubjectKeyIdentifier.getKeyIdentifier();
  }
  
  public X509CertificateHolder getCertificate()
  {
    return this.certificateHolders[0];
  }
  
  public PrivateKeyInfo getPrivateKeyInfo()
  {
    return this.privateKeyInfo;
  }
  
  public RecipientId getRecipientId()
  {
    return new KeyTransRecipientId(this.certificateHolders[0].getIssuer(), this.certificateHolders[0].getSerialNumber(), getSubjectKeyIdentifier());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkix\PKIXIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */