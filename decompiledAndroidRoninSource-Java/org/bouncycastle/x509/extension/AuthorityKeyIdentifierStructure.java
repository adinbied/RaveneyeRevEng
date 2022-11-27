package org.bouncycastle.x509.extension;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.jce.PrincipalUtil;

public class AuthorityKeyIdentifierStructure
  extends AuthorityKeyIdentifier
{
  public AuthorityKeyIdentifierStructure(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    super(fromKey(paramPublicKey));
  }
  
  public AuthorityKeyIdentifierStructure(X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    super(fromCertificate(paramX509Certificate));
  }
  
  public AuthorityKeyIdentifierStructure(Extension paramExtension)
  {
    super((ASN1Sequence)paramExtension.getParsedValue());
  }
  
  public AuthorityKeyIdentifierStructure(X509Extension paramX509Extension)
  {
    super((ASN1Sequence)paramX509Extension.getParsedValue());
  }
  
  public AuthorityKeyIdentifierStructure(byte[] paramArrayOfByte)
    throws IOException
  {
    super((ASN1Sequence)X509ExtensionUtil.fromExtensionValue(paramArrayOfByte));
  }
  
  private static ASN1Sequence fromCertificate(X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    try
    {
      if (paramX509Certificate.getVersion() != 3)
      {
        localObject = new GeneralName(PrincipalUtil.getIssuerX509Principal(paramX509Certificate));
        return (ASN1Sequence)new AuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramX509Certificate.getPublicKey().getEncoded()), new GeneralNames((GeneralName)localObject), paramX509Certificate.getSerialNumber()).toASN1Primitive();
      }
      localObject = new GeneralName(PrincipalUtil.getIssuerX509Principal(paramX509Certificate));
      byte[] arrayOfByte = paramX509Certificate.getExtensionValue(Extension.subjectKeyIdentifier.getId());
      if (arrayOfByte != null) {
        return (ASN1Sequence)new AuthorityKeyIdentifier(((ASN1OctetString)X509ExtensionUtil.fromExtensionValue(arrayOfByte)).getOctets(), new GeneralNames((GeneralName)localObject), paramX509Certificate.getSerialNumber()).toASN1Primitive();
      }
      paramX509Certificate = (ASN1Sequence)new AuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramX509Certificate.getPublicKey().getEncoded()), new GeneralNames((GeneralName)localObject), paramX509Certificate.getSerialNumber()).toASN1Primitive();
      return paramX509Certificate;
    }
    catch (Exception paramX509Certificate)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Exception extracting certificate details: ");
      ((StringBuilder)localObject).append(paramX509Certificate.toString());
      throw new CertificateParsingException(((StringBuilder)localObject).toString());
    }
  }
  
  private static ASN1Sequence fromKey(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    try
    {
      paramPublicKey = (ASN1Sequence)new AuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded())).toASN1Primitive();
      return paramPublicKey;
    }
    catch (Exception paramPublicKey)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can't process key: ");
      localStringBuilder.append(paramPublicKey);
      throw new InvalidKeyException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\extension\AuthorityKeyIdentifierStructure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */