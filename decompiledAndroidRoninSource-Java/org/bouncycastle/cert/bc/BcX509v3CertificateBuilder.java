package org.bouncycastle.cert.bc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;

public class BcX509v3CertificateBuilder
  extends X509v3CertificateBuilder
{
  public BcX509v3CertificateBuilder(X500Name paramX500Name1, BigInteger paramBigInteger, Date paramDate1, Date paramDate2, X500Name paramX500Name2, AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException
  {
    super(paramX500Name1, paramBigInteger, paramDate1, paramDate2, paramX500Name2, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(paramAsymmetricKeyParameter));
  }
  
  public BcX509v3CertificateBuilder(X509CertificateHolder paramX509CertificateHolder, BigInteger paramBigInteger, Date paramDate1, Date paramDate2, X500Name paramX500Name, AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException
  {
    super(paramX509CertificateHolder.getSubject(), paramBigInteger, paramDate1, paramDate2, paramX500Name, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(paramAsymmetricKeyParameter));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\bc\BcX509v3CertificateBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */