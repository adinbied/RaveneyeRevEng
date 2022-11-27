package org.bouncycastle.cert;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;

public abstract interface X509ContentVerifierProviderBuilder
{
  public abstract ContentVerifierProvider build(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws OperatorCreationException;
  
  public abstract ContentVerifierProvider build(X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509ContentVerifierProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */