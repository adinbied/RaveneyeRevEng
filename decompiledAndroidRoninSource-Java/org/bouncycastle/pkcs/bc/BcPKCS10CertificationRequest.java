package org.bouncycastle.pkcs.bc;

import java.io.IOException;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCSException;

public class BcPKCS10CertificationRequest
  extends PKCS10CertificationRequest
{
  public BcPKCS10CertificationRequest(CertificationRequest paramCertificationRequest)
  {
    super(paramCertificationRequest);
  }
  
  public BcPKCS10CertificationRequest(PKCS10CertificationRequest paramPKCS10CertificationRequest)
  {
    super(paramPKCS10CertificationRequest.toASN1Structure());
  }
  
  public BcPKCS10CertificationRequest(byte[] paramArrayOfByte)
    throws IOException
  {
    super(paramArrayOfByte);
  }
  
  public AsymmetricKeyParameter getPublicKey()
    throws PKCSException
  {
    try
    {
      AsymmetricKeyParameter localAsymmetricKeyParameter = PublicKeyFactory.createKey(getSubjectPublicKeyInfo());
      return localAsymmetricKeyParameter;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error extracting key encoding: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new PKCSException(localStringBuilder.toString(), localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\bc\BcPKCS10CertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */