package org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyWrapper;

public class JceKeyTransRecipientInfoGenerator
  extends KeyTransRecipientInfoGenerator
{
  public JceKeyTransRecipientInfoGenerator(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(paramX509Certificate).toASN1Structure()), new JceAsymmetricKeyWrapper(paramX509Certificate));
  }
  
  public JceKeyTransRecipientInfoGenerator(X509Certificate paramX509Certificate, AlgorithmIdentifier paramAlgorithmIdentifier)
    throws CertificateEncodingException
  {
    super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(paramX509Certificate).toASN1Structure()), new JceAsymmetricKeyWrapper(paramAlgorithmIdentifier, paramX509Certificate.getPublicKey()));
  }
  
  public JceKeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    super(paramArrayOfByte, new JceAsymmetricKeyWrapper(paramPublicKey));
  }
  
  public JceKeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, AlgorithmIdentifier paramAlgorithmIdentifier, PublicKey paramPublicKey)
  {
    super(paramArrayOfByte, new JceAsymmetricKeyWrapper(paramAlgorithmIdentifier, paramPublicKey));
  }
  
  public JceKeyTransRecipientInfoGenerator setAlgorithmMapping(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    ((JceAsymmetricKeyWrapper)this.wrapper).setAlgorithmMapping(paramASN1ObjectIdentifier, paramString);
    return this;
  }
  
  public JceKeyTransRecipientInfoGenerator setProvider(String paramString)
  {
    ((JceAsymmetricKeyWrapper)this.wrapper).setProvider(paramString);
    return this;
  }
  
  public JceKeyTransRecipientInfoGenerator setProvider(Provider paramProvider)
  {
    ((JceAsymmetricKeyWrapper)this.wrapper).setProvider(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKeyTransRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */