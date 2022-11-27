package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.CRLNumber;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertList.CRLEntry;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class X509CRLObject
  extends X509CRL
{
  private CertificateList c;
  private int hashCodeValue;
  private boolean isHashCodeSet = false;
  private boolean isIndirect;
  private String sigAlgName;
  private byte[] sigAlgParams;
  
  public X509CRLObject(CertificateList paramCertificateList)
    throws CRLException
  {
    this.c = paramCertificateList;
    try
    {
      this.sigAlgName = X509SignatureUtil.getSignatureName(paramCertificateList.getSignatureAlgorithm());
      if (paramCertificateList.getSignatureAlgorithm().getParameters() != null) {
        this.sigAlgParams = paramCertificateList.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded("DER");
      } else {
        this.sigAlgParams = null;
      }
      this.isIndirect = isIndirectCRL(this);
      return;
    }
    catch (Exception paramCertificateList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CRL contents invalid: ");
      localStringBuilder.append(paramCertificateList);
      throw new CRLException(localStringBuilder.toString());
    }
  }
  
  private void doVerify(PublicKey paramPublicKey, Signature paramSignature)
    throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    if (this.c.getSignatureAlgorithm().equals(this.c.getTBSCertList().getSignature()))
    {
      paramSignature.initVerify(paramPublicKey);
      paramSignature.update(getTBSCertList());
      if (paramSignature.verify(getSignature())) {
        return;
      }
      throw new SignatureException("CRL does not verify with supplied public key.");
    }
    throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
  }
  
  private Set getExtensionOIDs(boolean paramBoolean)
  {
    if (getVersion() == 2)
    {
      Extensions localExtensions = this.c.getTBSCertList().getExtensions();
      if (localExtensions != null)
      {
        HashSet localHashSet = new HashSet();
        Enumeration localEnumeration = localExtensions.oids();
        while (localEnumeration.hasMoreElements())
        {
          ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
          if (paramBoolean == localExtensions.getExtension(localASN1ObjectIdentifier).isCritical()) {
            localHashSet.add(localASN1ObjectIdentifier.getId());
          }
        }
        return localHashSet;
      }
    }
    return null;
  }
  
  public static boolean isIndirectCRL(X509CRL paramX509CRL)
    throws CRLException
  {
    try
    {
      paramX509CRL = paramX509CRL.getExtensionValue(Extension.issuingDistributionPoint.getId());
      if (paramX509CRL != null)
      {
        boolean bool = IssuingDistributionPoint.getInstance(ASN1OctetString.getInstance(paramX509CRL).getOctets()).isIndirectCRL();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramX509CRL)
    {
      throw new ExtCRLException("Exception reading IssuingDistributionPoint", paramX509CRL);
    }
  }
  
  private Set loadCRLEntries()
  {
    HashSet localHashSet = new HashSet();
    Enumeration localEnumeration = this.c.getRevokedCertificateEnumeration();
    X500Name localX500Name = null;
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (TBSCertList.CRLEntry)localEnumeration.nextElement();
      localHashSet.add(new X509CRLEntryObject((TBSCertList.CRLEntry)localObject, this.isIndirect, localX500Name));
      if ((this.isIndirect) && (((TBSCertList.CRLEntry)localObject).hasExtensions()))
      {
        localObject = ((TBSCertList.CRLEntry)localObject).getExtensions().getExtension(Extension.certificateIssuer);
        if (localObject != null) {
          localX500Name = X500Name.getInstance(org.bouncycastle.asn1.x509.GeneralNames.getInstance(localObject.getParsedValue()).getNames()[0].getName());
        }
      }
    }
    return localHashSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof X509CRL)) {
      return false;
    }
    if ((paramObject instanceof X509CRLObject))
    {
      paramObject = (X509CRLObject)paramObject;
      if ((this.isHashCodeSet) && (((X509CRLObject)paramObject).isHashCodeSet) && (((X509CRLObject)paramObject).hashCodeValue != this.hashCodeValue)) {
        return false;
      }
      return this.c.equals(((X509CRLObject)paramObject).c);
    }
    return super.equals(paramObject);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return getExtensionOIDs(true);
  }
  
  public byte[] getEncoded()
    throws CRLException
  {
    try
    {
      byte[] arrayOfByte = this.c.getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new CRLException(localIOException.toString());
    }
  }
  
  public byte[] getExtensionValue(String paramString)
  {
    Object localObject = this.c.getTBSCertList().getExtensions();
    if (localObject != null)
    {
      paramString = ((Extensions)localObject).getExtension(new ASN1ObjectIdentifier(paramString));
      if (paramString != null) {
        try
        {
          paramString = paramString.getExtnValue().getEncoded();
          return paramString;
        }
        catch (Exception paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error parsing ");
          ((StringBuilder)localObject).append(paramString.toString());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
    return null;
  }
  
  public Principal getIssuerDN()
  {
    return new X509Principal(X500Name.getInstance(this.c.getIssuer().toASN1Primitive()));
  }
  
  public X500Principal getIssuerX500Principal()
  {
    try
    {
      X500Principal localX500Principal = new X500Principal(this.c.getIssuer().getEncoded());
      return localX500Principal;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("can't encode issuer DN");
  }
  
  public Date getNextUpdate()
  {
    if (this.c.getNextUpdate() != null) {
      return this.c.getNextUpdate().getDate();
    }
    return null;
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return getExtensionOIDs(false);
  }
  
  public X509CRLEntry getRevokedCertificate(BigInteger paramBigInteger)
  {
    Enumeration localEnumeration = this.c.getRevokedCertificateEnumeration();
    X500Name localX500Name = null;
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (TBSCertList.CRLEntry)localEnumeration.nextElement();
      if (paramBigInteger.equals(((TBSCertList.CRLEntry)localObject).getUserCertificate().getValue())) {
        return new X509CRLEntryObject((TBSCertList.CRLEntry)localObject, this.isIndirect, localX500Name);
      }
      if ((this.isIndirect) && (((TBSCertList.CRLEntry)localObject).hasExtensions()))
      {
        localObject = ((TBSCertList.CRLEntry)localObject).getExtensions().getExtension(Extension.certificateIssuer);
        if (localObject != null) {
          localX500Name = X500Name.getInstance(org.bouncycastle.asn1.x509.GeneralNames.getInstance(localObject.getParsedValue()).getNames()[0].getName());
        }
      }
    }
    return null;
  }
  
  public Set getRevokedCertificates()
  {
    Set localSet = loadCRLEntries();
    if (!localSet.isEmpty()) {
      return Collections.unmodifiableSet(localSet);
    }
    return null;
  }
  
  public String getSigAlgName()
  {
    return this.sigAlgName;
  }
  
  public String getSigAlgOID()
  {
    return this.c.getSignatureAlgorithm().getAlgorithm().getId();
  }
  
  public byte[] getSigAlgParams()
  {
    byte[] arrayOfByte1 = this.sigAlgParams;
    if (arrayOfByte1 != null)
    {
      int i = arrayOfByte1.length;
      byte[] arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
      return arrayOfByte2;
    }
    return null;
  }
  
  public byte[] getSignature()
  {
    return this.c.getSignature().getOctets();
  }
  
  public byte[] getTBSCertList()
    throws CRLException
  {
    try
    {
      byte[] arrayOfByte = this.c.getTBSCertList().getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new CRLException(localIOException.toString());
    }
  }
  
  public Date getThisUpdate()
  {
    return this.c.getThisUpdate().getDate();
  }
  
  public int getVersion()
  {
    return this.c.getVersionNumber();
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    Set localSet = getCriticalExtensionOIDs();
    if (localSet == null) {
      return false;
    }
    localSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
    localSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
    return localSet.isEmpty() ^ true;
  }
  
  public int hashCode()
  {
    if (!this.isHashCodeSet)
    {
      this.isHashCodeSet = true;
      this.hashCodeValue = super.hashCode();
    }
    return this.hashCodeValue;
  }
  
  public boolean isRevoked(java.security.cert.Certificate paramCertificate)
  {
    Object localObject1;
    if (paramCertificate.getType().equals("X.509"))
    {
      Enumeration localEnumeration = this.c.getRevokedCertificateEnumeration();
      Object localObject2 = this.c.getIssuer();
      if (localEnumeration != null)
      {
        X509Certificate localX509Certificate = (X509Certificate)paramCertificate;
        BigInteger localBigInteger = localX509Certificate.getSerialNumber();
        for (;;)
        {
          if (localEnumeration.hasMoreElements())
          {
            TBSCertList.CRLEntry localCRLEntry = TBSCertList.CRLEntry.getInstance(localEnumeration.nextElement());
            localObject1 = localObject2;
            if (this.isIndirect)
            {
              localObject1 = localObject2;
              if (localCRLEntry.hasExtensions())
              {
                Extension localExtension = localCRLEntry.getExtensions().getExtension(Extension.certificateIssuer);
                localObject1 = localObject2;
                if (localExtension != null) {
                  localObject1 = X500Name.getInstance(org.bouncycastle.asn1.x509.GeneralNames.getInstance(localExtension.getParsedValue()).getNames()[0].getName());
                }
              }
            }
            localObject2 = localObject1;
            if (localCRLEntry.getUserCertificate().getValue().equals(localBigInteger)) {
              if ((paramCertificate instanceof X509Certificate)) {
                paramCertificate = X500Name.getInstance(localX509Certificate.getIssuerX500Principal().getEncoded());
              }
            }
          }
        }
      }
    }
    try
    {
      paramCertificate = org.bouncycastle.asn1.x509.Certificate.getInstance(paramCertificate.getEncoded()).getIssuer();
      return ((X500Name)localObject1).equals(paramCertificate);
    }
    catch (CertificateEncodingException paramCertificate)
    {
      for (;;) {}
    }
    throw new RuntimeException("Cannot process certificate");
    return false;
    throw new RuntimeException("X.509 CRL used with non X.509 Cert");
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("              Version: ");
    localStringBuffer.append(getVersion());
    localStringBuffer.append(str);
    localStringBuffer.append("             IssuerDN: ");
    localStringBuffer.append(getIssuerDN());
    localStringBuffer.append(str);
    localStringBuffer.append("          This update: ");
    localStringBuffer.append(getThisUpdate());
    localStringBuffer.append(str);
    localStringBuffer.append("          Next update: ");
    localStringBuffer.append(getNextUpdate());
    localStringBuffer.append(str);
    localStringBuffer.append("  Signature Algorithm: ");
    localStringBuffer.append(getSigAlgName());
    localStringBuffer.append(str);
    Object localObject2 = getSignature();
    localStringBuffer.append("            Signature: ");
    localStringBuffer.append(new String(Hex.encode((byte[])localObject2, 0, 20)));
    localStringBuffer.append(str);
    int i = 20;
    while (i < localObject2.length)
    {
      int j = localObject2.length;
      localStringBuffer.append("                       ");
      if (i < j - 20) {
        localObject1 = new String(Hex.encode((byte[])localObject2, i, 20));
      } else {
        localObject1 = new String(Hex.encode((byte[])localObject2, i, localObject2.length - i));
      }
      localStringBuffer.append((String)localObject1);
      localStringBuffer.append(str);
      i += 20;
    }
    localObject2 = this.c.getTBSCertList().getExtensions();
    if (localObject2 != null)
    {
      Enumeration localEnumeration = ((Extensions)localObject2).oids();
      if (localEnumeration.hasMoreElements()) {}
      for (localObject1 = "           Extensions: ";; localObject1 = "*****")
      {
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append(str);
        for (;;)
        {
          if (!localEnumeration.hasMoreElements()) {
            break label661;
          }
          ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
          Object localObject3 = ((Extensions)localObject2).getExtension(localASN1ObjectIdentifier);
          if (((Extension)localObject3).getExtnValue() == null) {
            break;
          }
          localObject1 = new ASN1InputStream(((Extension)localObject3).getExtnValue().getOctets());
          localStringBuffer.append("                       critical(");
          localStringBuffer.append(((Extension)localObject3).isCritical());
          localStringBuffer.append(") ");
          try
          {
            if (localASN1ObjectIdentifier.equals(Extension.cRLNumber))
            {
              localObject1 = new CRLNumber(ASN1Integer.getInstance(((ASN1InputStream)localObject1).readObject()).getPositiveValue());
              localStringBuffer.append(localObject1);
              label458:
              localStringBuffer.append(str);
            }
            else
            {
              if (localASN1ObjectIdentifier.equals(Extension.deltaCRLIndicator))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("Base CRL: ");
                ((StringBuilder)localObject3).append(new CRLNumber(ASN1Integer.getInstance(((ASN1InputStream)localObject1).readObject()).getPositiveValue()));
              }
              for (localObject1 = ((StringBuilder)localObject3).toString();; localObject1 = ASN1Dump.dumpAsString(((ASN1InputStream)localObject1).readObject()))
              {
                localStringBuffer.append((String)localObject1);
                break label458;
                if (localASN1ObjectIdentifier.equals(Extension.issuingDistributionPoint))
                {
                  localObject1 = IssuingDistributionPoint.getInstance(((ASN1InputStream)localObject1).readObject());
                  break;
                }
                if (localASN1ObjectIdentifier.equals(Extension.cRLDistributionPoints))
                {
                  localObject1 = CRLDistPoint.getInstance(((ASN1InputStream)localObject1).readObject());
                  break;
                }
                if (localASN1ObjectIdentifier.equals(Extension.freshestCRL))
                {
                  localObject1 = CRLDistPoint.getInstance(((ASN1InputStream)localObject1).readObject());
                  break;
                }
                localStringBuffer.append(localASN1ObjectIdentifier.getId());
                localStringBuffer.append(" value = ");
              }
            }
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
        localStringBuffer.append(localASN1ObjectIdentifier.getId());
        localStringBuffer.append(" value = ");
      }
    }
    label661:
    Object localObject1 = getRevokedCertificates();
    if (localObject1 != null)
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localStringBuffer.append(((Iterator)localObject1).next());
        localStringBuffer.append(str);
      }
    }
    return localStringBuffer.toString();
  }
  
  public void verify(PublicKey paramPublicKey)
    throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    try
    {
      localSignature = Signature.getInstance(getSigAlgName(), "BC");
    }
    catch (Exception localException)
    {
      Signature localSignature;
      for (;;) {}
    }
    localSignature = Signature.getInstance(getSigAlgName());
    doVerify(paramPublicKey, localSignature);
  }
  
  public void verify(PublicKey paramPublicKey, String paramString)
    throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    if (paramString != null) {
      paramString = Signature.getInstance(getSigAlgName(), paramString);
    } else {
      paramString = Signature.getInstance(getSigAlgName());
    }
    doVerify(paramPublicKey, paramString);
  }
  
  public void verify(PublicKey paramPublicKey, Provider paramProvider)
    throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    if (paramProvider != null) {
      paramProvider = Signature.getInstance(getSigAlgName(), paramProvider);
    } else {
      paramProvider = Signature.getInstance(getSigAlgName());
    }
    doVerify(paramPublicKey, paramProvider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509CRLObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */