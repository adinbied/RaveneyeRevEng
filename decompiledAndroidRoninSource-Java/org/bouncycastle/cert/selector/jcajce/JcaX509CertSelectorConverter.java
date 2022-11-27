package org.bouncycastle.cert.selector.jcajce;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509CertSelector;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;

public class JcaX509CertSelectorConverter
{
  protected X509CertSelector doConversion(X500Name paramX500Name, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    X509CertSelector localX509CertSelector = new X509CertSelector();
    if (paramX500Name != null) {
      try
      {
        localX509CertSelector.setIssuer(paramX500Name.getEncoded());
      }
      catch (IOException paramX500Name)
      {
        paramBigInteger = new StringBuilder();
        paramBigInteger.append("unable to convert issuer: ");
        paramBigInteger.append(paramX500Name.getMessage());
        throw new IllegalArgumentException(paramBigInteger.toString());
      }
    }
    if (paramBigInteger != null) {
      localX509CertSelector.setSerialNumber(paramBigInteger);
    }
    if (paramArrayOfByte != null) {
      try
      {
        localX509CertSelector.setSubjectKeyIdentifier(new DEROctetString(paramArrayOfByte).getEncoded());
        return localX509CertSelector;
      }
      catch (IOException paramX500Name)
      {
        paramBigInteger = new StringBuilder();
        paramBigInteger.append("unable to convert issuer: ");
        paramBigInteger.append(paramX500Name.getMessage());
        throw new IllegalArgumentException(paramBigInteger.toString());
      }
    }
    return localX509CertSelector;
  }
  
  public X509CertSelector getCertSelector(X509CertificateHolderSelector paramX509CertificateHolderSelector)
  {
    return doConversion(paramX509CertificateHolderSelector.getIssuer(), paramX509CertificateHolderSelector.getSerialNumber(), paramX509CertificateHolderSelector.getSubjectKeyIdentifier());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\selector\jcajce\JcaX509CertSelectorConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */