package org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

public class X509CertificateHolder
  implements Encodable
{
  private Extensions extensions;
  private Certificate x509Certificate;
  
  public X509CertificateHolder(Certificate paramCertificate)
  {
    this.x509Certificate = paramCertificate;
    this.extensions = paramCertificate.getTBSCertificate().getExtensions();
  }
  
  public X509CertificateHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static Certificate parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = Certificate.getInstance(CertUtils.parseNonEmptyASN1(paramArrayOfByte));
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
    if (!(paramObject instanceof X509CertificateHolder)) {
      return false;
    }
    paramObject = (X509CertificateHolder)paramObject;
    return this.x509Certificate.equals(((X509CertificateHolder)paramObject).x509Certificate);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return CertUtils.getCriticalExtensionOIDs(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.x509Certificate.getEncoded();
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
  
  public X500Name getIssuer()
  {
    return X500Name.getInstance(this.x509Certificate.getIssuer());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
  }
  
  public Date getNotAfter()
  {
    return this.x509Certificate.getEndDate().getDate();
  }
  
  public Date getNotBefore()
  {
    return this.x509Certificate.getStartDate().getDate();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.x509Certificate.getSerialNumber().getValue();
  }
  
  public byte[] getSignature()
  {
    return this.x509Certificate.getSignature().getOctets();
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.x509Certificate.getSignatureAlgorithm();
  }
  
  public X500Name getSubject()
  {
    return X500Name.getInstance(this.x509Certificate.getSubject());
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.x509Certificate.getSubjectPublicKeyInfo();
  }
  
  public int getVersion()
  {
    return this.x509Certificate.getVersionNumber();
  }
  
  public int getVersionNumber()
  {
    return this.x509Certificate.getVersionNumber();
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
  
  public int hashCode()
  {
    return this.x509Certificate.hashCode();
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws CertException
  {
    Object localObject = this.x509Certificate.getTBSCertificate();
    if (CertUtils.isAlgIdEqual(((TBSCertificate)localObject).getSignature(), this.x509Certificate.getSignatureAlgorithm())) {
      try
      {
        paramContentVerifierProvider = paramContentVerifierProvider.get(((TBSCertificate)localObject).getSignature());
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
    return (!paramDate.before(this.x509Certificate.getStartDate().getDate())) && (!paramDate.after(this.x509Certificate.getEndDate().getDate()));
  }
  
  public Certificate toASN1Structure()
  {
    return this.x509Certificate;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509CertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */