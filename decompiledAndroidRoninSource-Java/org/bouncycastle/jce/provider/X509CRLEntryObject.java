package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.TBSCertList.CRLEntry;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.util.Strings;

public class X509CRLEntryObject
  extends X509CRLEntry
{
  private TBSCertList.CRLEntry c;
  private X500Name certificateIssuer;
  private int hashValue;
  private boolean isHashValueSet;
  
  public X509CRLEntryObject(TBSCertList.CRLEntry paramCRLEntry)
  {
    this.c = paramCRLEntry;
    this.certificateIssuer = null;
  }
  
  public X509CRLEntryObject(TBSCertList.CRLEntry paramCRLEntry, boolean paramBoolean, X500Name paramX500Name)
  {
    this.c = paramCRLEntry;
    this.certificateIssuer = loadCertificateIssuer(paramBoolean, paramX500Name);
  }
  
  private Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Extensions localExtensions = this.c.getExtensions();
    if (localExtensions != null) {
      return localExtensions.getExtension(paramASN1ObjectIdentifier);
    }
    return null;
  }
  
  private Set getExtensionOIDs(boolean paramBoolean)
  {
    Extensions localExtensions = this.c.getExtensions();
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
    return null;
  }
  
  private X500Name loadCertificateIssuer(boolean paramBoolean, X500Name paramX500Name)
  {
    if (!paramBoolean) {
      return null;
    }
    Extension localExtension = getExtension(Extension.certificateIssuer);
    if (localExtension == null) {
      return paramX500Name;
    }
    try
    {
      paramX500Name = GeneralNames.getInstance(localExtension.getParsedValue()).getNames();
      int i = 0;
      while (i < paramX500Name.length)
      {
        if (paramX500Name[i].getTagNo() == 4)
        {
          paramX500Name = X500Name.getInstance(paramX500Name[i].getName());
          return paramX500Name;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramX500Name) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof X509CRLEntryObject))
    {
      paramObject = (X509CRLEntryObject)paramObject;
      return this.c.equals(((X509CRLEntryObject)paramObject).c);
    }
    return super.equals(this);
  }
  
  public X500Principal getCertificateIssuer()
  {
    if (this.certificateIssuer == null) {
      return null;
    }
    try
    {
      X500Principal localX500Principal = new X500Principal(this.certificateIssuer.getEncoded());
      return localX500Principal;
    }
    catch (IOException localIOException) {}
    return null;
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
    paramString = getExtension(new ASN1ObjectIdentifier(paramString));
    if (paramString != null) {
      try
      {
        paramString = paramString.getExtnValue().getEncoded();
        return paramString;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error encoding ");
        localStringBuilder.append(paramString.toString());
        throw new RuntimeException(localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return getExtensionOIDs(false);
  }
  
  public Date getRevocationDate()
  {
    return this.c.getRevocationDate().getDate();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.c.getUserCertificate().getValue();
  }
  
  public boolean hasExtensions()
  {
    return this.c.getExtensions() != null;
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    Set localSet = getCriticalExtensionOIDs();
    return (localSet != null) && (!localSet.isEmpty());
  }
  
  public int hashCode()
  {
    if (!this.isHashValueSet)
    {
      this.hashValue = super.hashCode();
      this.isHashValueSet = true;
    }
    return this.hashValue;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("      userCertificate: ");
    localStringBuffer.append(getSerialNumber());
    localStringBuffer.append(str);
    localStringBuffer.append("       revocationDate: ");
    localStringBuffer.append(getRevocationDate());
    localStringBuffer.append(str);
    localStringBuffer.append("       certificateIssuer: ");
    localStringBuffer.append(getCertificateIssuer());
    localStringBuffer.append(str);
    Extensions localExtensions = this.c.getExtensions();
    if (localExtensions != null)
    {
      Enumeration localEnumeration = localExtensions.oids();
      if (localEnumeration.hasMoreElements()) {
        for (Object localObject = "   crlEntryExtensions:";; localObject = "*****")
        {
          localStringBuffer.append((String)localObject);
          localStringBuffer.append(str);
          for (;;)
          {
            if (!localEnumeration.hasMoreElements()) {
              break label328;
            }
            ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
            localObject = localExtensions.getExtension(localASN1ObjectIdentifier);
            if (((Extension)localObject).getExtnValue() == null) {
              break;
            }
            ASN1InputStream localASN1InputStream = new ASN1InputStream(((Extension)localObject).getExtnValue().getOctets());
            localStringBuffer.append("                       critical(");
            localStringBuffer.append(((Extension)localObject).isCritical());
            localStringBuffer.append(") ");
            try
            {
              if (localASN1ObjectIdentifier.equals(X509Extension.reasonCode))
              {
                localObject = CRLReason.getInstance(ASN1Enumerated.getInstance(localASN1InputStream.readObject()));
                label223:
                localStringBuffer.append(localObject);
              }
              for (;;)
              {
                localStringBuffer.append(str);
                break;
                if (localASN1ObjectIdentifier.equals(X509Extension.certificateIssuer))
                {
                  localStringBuffer.append("Certificate issuer: ");
                  localObject = GeneralNames.getInstance(localASN1InputStream.readObject());
                  break label223;
                }
                localStringBuffer.append(localASN1ObjectIdentifier.getId());
                localStringBuffer.append(" value = ");
                localStringBuffer.append(ASN1Dump.dumpAsString(localASN1InputStream.readObject()));
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
    }
    label328:
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509CRLEntryObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */