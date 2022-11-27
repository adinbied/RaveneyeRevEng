package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttCertValidityPeriod;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.util.Arrays;

public class X509V2AttributeCertificate
  implements X509AttributeCertificate
{
  private AttributeCertificate cert;
  private Date notAfter;
  private Date notBefore;
  
  public X509V2AttributeCertificate(InputStream paramInputStream)
    throws IOException
  {
    this(getObject(paramInputStream));
  }
  
  X509V2AttributeCertificate(AttributeCertificate paramAttributeCertificate)
    throws IOException
  {
    this.cert = paramAttributeCertificate;
    try
    {
      this.notAfter = paramAttributeCertificate.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime().getDate();
      this.notBefore = paramAttributeCertificate.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime().getDate();
      return;
    }
    catch (ParseException paramAttributeCertificate)
    {
      for (;;) {}
    }
    throw new IOException("invalid data structure in certificate!");
  }
  
  public X509V2AttributeCertificate(byte[] paramArrayOfByte)
    throws IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private Set getExtensionOIDs(boolean paramBoolean)
  {
    Extensions localExtensions = this.cert.getAcinfo().getExtensions();
    if (localExtensions != null)
    {
      HashSet localHashSet = new HashSet();
      Enumeration localEnumeration = localExtensions.oids();
      while (localEnumeration.hasMoreElements())
      {
        ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
        if (localExtensions.getExtension(localASN1ObjectIdentifier).isCritical() == paramBoolean) {
          localHashSet.add(localASN1ObjectIdentifier.getId());
        }
      }
      return localHashSet;
    }
    return null;
  }
  
  private static AttributeCertificate getObject(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      paramInputStream = AttributeCertificate.getInstance(new ASN1InputStream(paramInputStream).readObject());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception decoding certificate structure: ");
      localStringBuilder.append(paramInputStream.toString());
      throw new IOException(localStringBuilder.toString());
    }
    catch (IOException paramInputStream)
    {
      throw paramInputStream;
    }
  }
  
  public void checkValidity()
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    checkValidity(new Date());
  }
  
  public void checkValidity(Date paramDate)
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    if (!paramDate.after(getNotAfter()))
    {
      if (!paramDate.before(getNotBefore())) {
        return;
      }
      paramDate = new StringBuilder();
      paramDate.append("certificate not valid till ");
      paramDate.append(getNotBefore());
      throw new CertificateNotYetValidException(paramDate.toString());
    }
    paramDate = new StringBuilder();
    paramDate.append("certificate expired on ");
    paramDate.append(getNotAfter());
    throw new CertificateExpiredException(paramDate.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof X509AttributeCertificate)) {
      return false;
    }
    paramObject = (X509AttributeCertificate)paramObject;
    try
    {
      boolean bool = Arrays.areEqual(getEncoded(), ((X509AttributeCertificate)paramObject).getEncoded());
      return bool;
    }
    catch (IOException paramObject) {}
    return false;
  }
  
  public X509Attribute[] getAttributes()
  {
    ASN1Sequence localASN1Sequence = this.cert.getAcinfo().getAttributes();
    X509Attribute[] arrayOfX509Attribute = new X509Attribute[localASN1Sequence.size()];
    int i = 0;
    while (i != localASN1Sequence.size())
    {
      arrayOfX509Attribute[i] = new X509Attribute(localASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfX509Attribute;
  }
  
  public X509Attribute[] getAttributes(String paramString)
  {
    ASN1Sequence localASN1Sequence = this.cert.getAcinfo().getAttributes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i != localASN1Sequence.size())
    {
      X509Attribute localX509Attribute = new X509Attribute(localASN1Sequence.getObjectAt(i));
      if (localX509Attribute.getOID().equals(paramString)) {
        localArrayList.add(localX509Attribute);
      }
      i += 1;
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return (X509Attribute[])localArrayList.toArray(new X509Attribute[localArrayList.size()]);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return getExtensionOIDs(true);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.cert.getEncoded();
  }
  
  public byte[] getExtensionValue(String paramString)
  {
    Object localObject = this.cert.getAcinfo().getExtensions();
    if (localObject != null)
    {
      paramString = ((Extensions)localObject).getExtension(new ASN1ObjectIdentifier(paramString));
      if (paramString != null) {
        try
        {
          paramString = paramString.getExtnValue().getEncoded("DER");
          return paramString;
        }
        catch (Exception paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error encoding ");
          ((StringBuilder)localObject).append(paramString.toString());
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
      }
    }
    return null;
  }
  
  public AttributeCertificateHolder getHolder()
  {
    return new AttributeCertificateHolder((ASN1Sequence)this.cert.getAcinfo().getHolder().toASN1Primitive());
  }
  
  public AttributeCertificateIssuer getIssuer()
  {
    return new AttributeCertificateIssuer(this.cert.getAcinfo().getIssuer());
  }
  
  public boolean[] getIssuerUniqueID()
  {
    Object localObject = this.cert.getAcinfo().getIssuerUniqueID();
    if (localObject != null)
    {
      byte[] arrayOfByte = ((DERBitString)localObject).getBytes();
      int j = arrayOfByte.length * 8 - ((DERBitString)localObject).getPadBits();
      localObject = new boolean[j];
      int i = 0;
      while (i != j)
      {
        int k;
        if ((arrayOfByte[(i / 8)] & 128 >>> i % 8) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        localObject[i] = k;
        i += 1;
      }
      return (boolean[])localObject;
    }
    return null;
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return getExtensionOIDs(false);
  }
  
  public Date getNotAfter()
  {
    return this.notAfter;
  }
  
  public Date getNotBefore()
  {
    return this.notBefore;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.cert.getAcinfo().getSerialNumber().getValue();
  }
  
  public byte[] getSignature()
  {
    return this.cert.getSignatureValue().getOctets();
  }
  
  public int getVersion()
  {
    return this.cert.getAcinfo().getVersion().getValue().intValue() + 1;
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    Set localSet = getCriticalExtensionOIDs();
    return (localSet != null) && (!localSet.isEmpty());
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(getEncoded());
      return i;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public final void verify(PublicKey paramPublicKey, String paramString)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    if (this.cert.getSignatureAlgorithm().equals(this.cert.getAcinfo().getSignature()))
    {
      paramString = Signature.getInstance(this.cert.getSignatureAlgorithm().getAlgorithm().getId(), paramString);
      paramString.initVerify(paramPublicKey);
    }
    try
    {
      paramString.update(this.cert.getAcinfo().getEncoded());
      if (paramString.verify(getSignature())) {
        return;
      }
      throw new InvalidKeyException("Public key presented not for certificate signature");
    }
    catch (IOException paramPublicKey)
    {
      for (;;) {}
    }
    throw new SignatureException("Exception encoding certificate info object");
    throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509V2AttributeCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */