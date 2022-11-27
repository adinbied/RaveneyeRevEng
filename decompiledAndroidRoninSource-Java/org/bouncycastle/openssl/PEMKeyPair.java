package org.bouncycastle.openssl;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class PEMKeyPair
{
  private final PrivateKeyInfo privateKeyInfo;
  private final SubjectPublicKeyInfo publicKeyInfo;
  
  public PEMKeyPair(SubjectPublicKeyInfo paramSubjectPublicKeyInfo, PrivateKeyInfo paramPrivateKeyInfo)
  {
    this.publicKeyInfo = paramSubjectPublicKeyInfo;
    this.privateKeyInfo = paramPrivateKeyInfo;
  }
  
  public PrivateKeyInfo getPrivateKeyInfo()
  {
    return this.privateKeyInfo;
  }
  
  public SubjectPublicKeyInfo getPublicKeyInfo()
  {
    return this.publicKeyInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMKeyPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */