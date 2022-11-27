package org.bouncycastle.cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertList.CRLEntry;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

public class X509CRLHolder
  implements Encodable
{
  private Extensions extensions;
  private boolean isIndirect;
  private GeneralNames issuerName;
  private CertificateList x509CRL;
  
  public X509CRLHolder(InputStream paramInputStream)
    throws IOException
  {
    this(parseStream(paramInputStream));
  }
  
  public X509CRLHolder(CertificateList paramCertificateList)
  {
    this.x509CRL = paramCertificateList;
    Extensions localExtensions = paramCertificateList.getTBSCertList().getExtensions();
    this.extensions = localExtensions;
    this.isIndirect = isIndirectCRL(localExtensions);
    this.issuerName = new GeneralNames(new GeneralName(paramCertificateList.getIssuer()));
  }
  
  public X509CRLHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseStream(new ByteArrayInputStream(paramArrayOfByte)));
  }
  
  private static boolean isIndirectCRL(Extensions paramExtensions)
  {
    boolean bool2 = false;
    if (paramExtensions == null) {
      return false;
    }
    paramExtensions = paramExtensions.getExtension(Extension.issuingDistributionPoint);
    boolean bool1 = bool2;
    if (paramExtensions != null)
    {
      bool1 = bool2;
      if (IssuingDistributionPoint.getInstance(paramExtensions.getParsedValue()).isIndirectCRL()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static CertificateList parseStream(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      paramInputStream = new ASN1InputStream(paramInputStream, true).readObject();
      if (paramInputStream != null) {
        return CertificateList.getInstance(paramInputStream);
      }
      throw new IOException("no content found");
    }
    catch (IllegalArgumentException paramInputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramInputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramInputStream);
    }
    catch (ClassCastException paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramInputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramInputStream);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof X509CRLHolder)) {
      return false;
    }
    paramObject = (X509CRLHolder)paramObject;
    return this.x509CRL.equals(((X509CRLHolder)paramObject).x509CRL);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return CertUtils.getCriticalExtensionOIDs(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.x509CRL.getEncoded();
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
    return X500Name.getInstance(this.x509CRL.getIssuer());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
  }
  
  public X509CRLEntryHolder getRevokedCertificate(BigInteger paramBigInteger)
  {
    GeneralNames localGeneralNames = this.issuerName;
    Enumeration localEnumeration = this.x509CRL.getRevokedCertificateEnumeration();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (TBSCertList.CRLEntry)localEnumeration.nextElement();
      if (((TBSCertList.CRLEntry)localObject).getUserCertificate().getValue().equals(paramBigInteger)) {
        return new X509CRLEntryHolder((TBSCertList.CRLEntry)localObject, this.isIndirect, localGeneralNames);
      }
      if ((this.isIndirect) && (((TBSCertList.CRLEntry)localObject).hasExtensions()))
      {
        localObject = ((TBSCertList.CRLEntry)localObject).getExtensions().getExtension(Extension.certificateIssuer);
        if (localObject != null) {
          localGeneralNames = GeneralNames.getInstance(((Extension)localObject).getParsedValue());
        }
      }
    }
    return null;
  }
  
  public Collection getRevokedCertificates()
  {
    ArrayList localArrayList = new ArrayList(this.x509CRL.getRevokedCertificates().length);
    Object localObject = this.issuerName;
    Enumeration localEnumeration = this.x509CRL.getRevokedCertificateEnumeration();
    while (localEnumeration.hasMoreElements())
    {
      localObject = new X509CRLEntryHolder((TBSCertList.CRLEntry)localEnumeration.nextElement(), this.isIndirect, (GeneralNames)localObject);
      localArrayList.add(localObject);
      localObject = ((X509CRLEntryHolder)localObject).getCertificateIssuer();
    }
    return localArrayList;
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
  
  public int hashCode()
  {
    return this.x509CRL.hashCode();
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws CertException
  {
    Object localObject = this.x509CRL.getTBSCertList();
    if (CertUtils.isAlgIdEqual(((TBSCertList)localObject).getSignature(), this.x509CRL.getSignatureAlgorithm())) {
      try
      {
        paramContentVerifierProvider = paramContentVerifierProvider.get(((TBSCertList)localObject).getSignature());
        OutputStream localOutputStream = paramContentVerifierProvider.getOutputStream();
        new DEROutputStream(localOutputStream).writeObject((ASN1Encodable)localObject);
        localOutputStream.close();
        return paramContentVerifierProvider.verify(this.x509CRL.getSignature().getOctets());
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
  
  public CertificateList toASN1Structure()
  {
    return this.x509CRL;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509CRLHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */