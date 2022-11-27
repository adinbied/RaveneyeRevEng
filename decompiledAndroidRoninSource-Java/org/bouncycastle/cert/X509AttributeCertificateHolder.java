package org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttCertValidityPeriod;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

public class X509AttributeCertificateHolder
  implements Encodable
{
  private static Attribute[] EMPTY_ARRAY = new Attribute[0];
  private AttributeCertificate attrCert;
  private Extensions extensions;
  
  public X509AttributeCertificateHolder(AttributeCertificate paramAttributeCertificate)
  {
    this.attrCert = paramAttributeCertificate;
    this.extensions = paramAttributeCertificate.getAcinfo().getExtensions();
  }
  
  public X509AttributeCertificateHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static AttributeCertificate parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = AttributeCertificate.getInstance(CertUtils.parseNonEmptyASN1(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof X509AttributeCertificateHolder)) {
      return false;
    }
    paramObject = (X509AttributeCertificateHolder)paramObject;
    return this.attrCert.equals(((X509AttributeCertificateHolder)paramObject).attrCert);
  }
  
  public Attribute[] getAttributes()
  {
    ASN1Sequence localASN1Sequence = this.attrCert.getAcinfo().getAttributes();
    Attribute[] arrayOfAttribute = new Attribute[localASN1Sequence.size()];
    int i = 0;
    while (i != localASN1Sequence.size())
    {
      arrayOfAttribute[i] = Attribute.getInstance(localASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfAttribute;
  }
  
  public Attribute[] getAttributes(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    ASN1Sequence localASN1Sequence = this.attrCert.getAcinfo().getAttributes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i != localASN1Sequence.size())
    {
      Attribute localAttribute = Attribute.getInstance(localASN1Sequence.getObjectAt(i));
      if (localAttribute.getAttrType().equals(paramASN1ObjectIdentifier)) {
        localArrayList.add(localAttribute);
      }
      i += 1;
    }
    if (localArrayList.size() == 0) {
      return EMPTY_ARRAY;
    }
    return (Attribute[])localArrayList.toArray(new Attribute[localArrayList.size()]);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return CertUtils.getCriticalExtensionOIDs(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.attrCert.getEncoded();
  }
  
  public Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Extensions localExtensions = this.extensions;
    if (localExtensions != null) {
      return localExtensions.getExtension(paramASN1ObjectIdentifier);
    }
    return null;
  }
  
  public List getExtensionOIDs()
  {
    return CertUtils.getExtensionOIDs(this.extensions);
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public AttributeCertificateHolder getHolder()
  {
    return new AttributeCertificateHolder((ASN1Sequence)this.attrCert.getAcinfo().getHolder().toASN1Primitive());
  }
  
  public AttributeCertificateIssuer getIssuer()
  {
    return new AttributeCertificateIssuer(this.attrCert.getAcinfo().getIssuer());
  }
  
  public boolean[] getIssuerUniqueID()
  {
    return CertUtils.bitStringToBoolean(this.attrCert.getAcinfo().getIssuerUniqueID());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
  }
  
  public Date getNotAfter()
  {
    return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime());
  }
  
  public Date getNotBefore()
  {
    return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime());
  }
  
  public BigInteger getSerialNumber()
  {
    return this.attrCert.getAcinfo().getSerialNumber().getValue();
  }
  
  public byte[] getSignature()
  {
    return this.attrCert.getSignatureValue().getOctets();
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.attrCert.getSignatureAlgorithm();
  }
  
  public int getVersion()
  {
    return this.attrCert.getAcinfo().getVersion().getValue().intValue() + 1;
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
  
  public int hashCode()
  {
    return this.attrCert.hashCode();
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws CertException
  {
    Object localObject = this.attrCert.getAcinfo();
    if (CertUtils.isAlgIdEqual(((AttributeCertificateInfo)localObject).getSignature(), this.attrCert.getSignatureAlgorithm())) {
      try
      {
        paramContentVerifierProvider = paramContentVerifierProvider.get(((AttributeCertificateInfo)localObject).getSignature());
        OutputStream localOutputStream = paramContentVerifierProvider.getOutputStream();
        new DEROutputStream(localOutputStream).writeObject((ASN1Encodable)localObject);
        localOutputStream.close();
        return paramContentVerifierProvider.verify(getSignature());
      }
      catch (Exception paramContentVerifierProvider)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unable to process signature: ");
        ((StringBuilder)localObject).append(paramContentVerifierProvider.getMessage());
        throw new CertException(((StringBuilder)localObject).toString(), paramContentVerifierProvider);
      }
    }
    throw new CertException("signature invalid - algorithm identifier mismatch");
  }
  
  public boolean isValidOn(Date paramDate)
  {
    AttCertValidityPeriod localAttCertValidityPeriod = this.attrCert.getAcinfo().getAttrCertValidityPeriod();
    return (!paramDate.before(CertUtils.recoverDate(localAttCertValidityPeriod.getNotBeforeTime()))) && (!paramDate.after(CertUtils.recoverDate(localAttCertValidityPeriod.getNotAfterTime())));
  }
  
  public AttributeCertificate toASN1Structure()
  {
    return this.attrCert;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509AttributeCertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */