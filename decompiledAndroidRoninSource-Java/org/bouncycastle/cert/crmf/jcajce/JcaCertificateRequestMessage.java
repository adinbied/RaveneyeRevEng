package org.bouncycastle.cert.crmf.jcajce;

import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.crmf.CertReqMsg;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cert.crmf.CertificateRequestMessage;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;

public class JcaCertificateRequestMessage
  extends CertificateRequestMessage
{
  private CRMFHelper helper = new CRMFHelper(new DefaultJcaJceHelper());
  
  public JcaCertificateRequestMessage(CertReqMsg paramCertReqMsg)
  {
    super(paramCertReqMsg);
  }
  
  public JcaCertificateRequestMessage(CertificateRequestMessage paramCertificateRequestMessage)
  {
    this(paramCertificateRequestMessage.toASN1Structure());
  }
  
  public JcaCertificateRequestMessage(byte[] paramArrayOfByte)
  {
    this(CertReqMsg.getInstance(paramArrayOfByte));
  }
  
  public PublicKey getPublicKey()
    throws CRMFException
  {
    SubjectPublicKeyInfo localSubjectPublicKeyInfo = getCertTemplate().getPublicKey();
    if (localSubjectPublicKeyInfo != null) {
      return this.helper.toPublicKey(localSubjectPublicKeyInfo);
    }
    return null;
  }
  
  public X500Principal getSubjectX500Principal()
  {
    Object localObject = getCertTemplate().getSubject();
    if (localObject != null) {
      try
      {
        localObject = new X500Principal(((X500Name)localObject).getEncoded("DER"));
        return (X500Principal)localObject;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unable to construct DER encoding of name: ");
        localStringBuilder.append(localIOException.getMessage());
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public JcaCertificateRequestMessage setProvider(String paramString)
  {
    this.helper = new CRMFHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JcaCertificateRequestMessage setProvider(Provider paramProvider)
  {
    this.helper = new CRMFHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\jcajce\JcaCertificateRequestMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */