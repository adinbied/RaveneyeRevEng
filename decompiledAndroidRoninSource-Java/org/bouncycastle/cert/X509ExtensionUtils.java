package org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.DigestCalculator;

public class X509ExtensionUtils
{
  private DigestCalculator calculator;
  
  public X509ExtensionUtils(DigestCalculator paramDigestCalculator)
  {
    this.calculator = paramDigestCalculator;
  }
  
  private byte[] calculateIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getPublicKeyData().getBytes();
    Object localObject = this.calculator.getOutputStream();
    try
    {
      ((OutputStream)localObject).write(paramSubjectPublicKeyInfo);
      ((OutputStream)localObject).close();
      return this.calculator.getDigest();
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to calculate identifier: ");
      ((StringBuilder)localObject).append(paramSubjectPublicKeyInfo.getMessage());
      throw new CertRuntimeException(((StringBuilder)localObject).toString(), paramSubjectPublicKeyInfo);
    }
  }
  
  private byte[] getSubjectKeyIdentifier(X509CertificateHolder paramX509CertificateHolder)
  {
    if (paramX509CertificateHolder.getVersionNumber() != 3) {
      return calculateIdentifier(paramX509CertificateHolder.getSubjectPublicKeyInfo());
    }
    Extension localExtension = paramX509CertificateHolder.getExtension(Extension.subjectKeyIdentifier);
    if (localExtension != null) {
      return ASN1OctetString.getInstance(localExtension.getParsedValue()).getOctets();
    }
    return calculateIdentifier(paramX509CertificateHolder.getSubjectPublicKeyInfo());
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    return new AuthorityKeyIdentifier(calculateIdentifier(paramSubjectPublicKeyInfo));
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo, GeneralNames paramGeneralNames, BigInteger paramBigInteger)
  {
    return new AuthorityKeyIdentifier(calculateIdentifier(paramSubjectPublicKeyInfo), paramGeneralNames, paramBigInteger);
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(X509CertificateHolder paramX509CertificateHolder)
  {
    GeneralName localGeneralName = new GeneralName(paramX509CertificateHolder.getIssuer());
    return new AuthorityKeyIdentifier(getSubjectKeyIdentifier(paramX509CertificateHolder), new GeneralNames(localGeneralName), paramX509CertificateHolder.getSerialNumber());
  }
  
  public SubjectKeyIdentifier createSubjectKeyIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    return new SubjectKeyIdentifier(calculateIdentifier(paramSubjectPublicKeyInfo));
  }
  
  public SubjectKeyIdentifier createTruncatedSubjectKeyIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    paramSubjectPublicKeyInfo = calculateIdentifier(paramSubjectPublicKeyInfo);
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramSubjectPublicKeyInfo, paramSubjectPublicKeyInfo.length - 8, arrayOfByte, 0, 8);
    arrayOfByte[0] = ((byte)(arrayOfByte[0] & 0xF));
    arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x40));
    return new SubjectKeyIdentifier(arrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509ExtensionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */