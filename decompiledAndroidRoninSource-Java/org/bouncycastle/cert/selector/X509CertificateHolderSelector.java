package org.bouncycastle.cert.selector;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class X509CertificateHolderSelector
  implements Selector
{
  private X500Name issuer;
  private BigInteger serialNumber;
  private byte[] subjectKeyId;
  
  public X509CertificateHolderSelector(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this(paramX500Name, paramBigInteger, null);
  }
  
  public X509CertificateHolderSelector(X500Name paramX500Name, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    this.issuer = paramX500Name;
    this.serialNumber = paramBigInteger;
    this.subjectKeyId = paramArrayOfByte;
  }
  
  public X509CertificateHolderSelector(byte[] paramArrayOfByte)
  {
    this(null, null, paramArrayOfByte);
  }
  
  private boolean equalsObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1.equals(paramObject2);
    }
    return paramObject2 == null;
  }
  
  public Object clone()
  {
    return new X509CertificateHolderSelector(this.issuer, this.serialNumber, this.subjectKeyId);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof X509CertificateHolderSelector;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (X509CertificateHolderSelector)paramObject;
    bool1 = bool2;
    if (Arrays.areEqual(this.subjectKeyId, ((X509CertificateHolderSelector)paramObject).subjectKeyId))
    {
      bool1 = bool2;
      if (equalsObj(this.serialNumber, ((X509CertificateHolderSelector)paramObject).serialNumber))
      {
        bool1 = bool2;
        if (equalsObj(this.issuer, ((X509CertificateHolderSelector)paramObject).issuer)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public X500Name getIssuer()
  {
    return this.issuer;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public byte[] getSubjectKeyIdentifier()
  {
    return Arrays.clone(this.subjectKeyId);
  }
  
  public int hashCode()
  {
    int j = Arrays.hashCode(this.subjectKeyId);
    Object localObject = this.serialNumber;
    int i = j;
    if (localObject != null) {
      i = j ^ ((BigInteger)localObject).hashCode();
    }
    localObject = this.issuer;
    j = i;
    if (localObject != null) {
      j = i ^ ((X500Name)localObject).hashCode();
    }
    return j;
  }
  
  public boolean match(Object paramObject)
  {
    boolean bool1 = paramObject instanceof X509CertificateHolder;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (X509CertificateHolder)paramObject;
      if (getSerialNumber() != null)
      {
        paramObject = new IssuerAndSerialNumber(((X509CertificateHolder)paramObject).toASN1Structure());
        bool1 = bool2;
        if (((IssuerAndSerialNumber)paramObject).getName().equals(this.issuer))
        {
          bool1 = bool2;
          if (((IssuerAndSerialNumber)paramObject).getSerialNumber().getValue().equals(this.serialNumber)) {
            bool1 = true;
          }
        }
        return bool1;
      }
      if (this.subjectKeyId != null)
      {
        Extension localExtension = ((X509CertificateHolder)paramObject).getExtension(Extension.subjectKeyIdentifier);
        if (localExtension == null) {
          return Arrays.areEqual(this.subjectKeyId, MSOutlookKeyIdCalculator.calculateKeyId(((X509CertificateHolder)paramObject).getSubjectPublicKeyInfo()));
        }
        paramObject = ASN1OctetString.getInstance(localExtension.getParsedValue()).getOctets();
        return Arrays.areEqual(this.subjectKeyId, (byte[])paramObject);
      }
    }
    else if ((paramObject instanceof byte[]))
    {
      return Arrays.areEqual(this.subjectKeyId, (byte[])paramObject);
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\selector\X509CertificateHolderSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */