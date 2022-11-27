package org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.misc.NetscapeCertType;
import org.bouncycastle.asn1.misc.NetscapeRevocationURL;
import org.bouncycastle.asn1.misc.VerisignCzagExtension;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class X509CertificateObject
  extends X509Certificate
  implements PKCS12BagAttributeCarrier
{
  private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private BasicConstraints basicConstraints;
  private org.bouncycastle.asn1.x509.Certificate c;
  private int hashValue;
  private boolean hashValueSet;
  private boolean[] keyUsage;
  
  public X509CertificateObject(org.bouncycastle.asn1.x509.Certificate paramCertificate)
    throws CertificateParsingException
  {
    this.c = paramCertificate;
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        paramCertificate = getExtensionBytes("2.5.29.19");
        if (paramCertificate != null) {
          this.basicConstraints = BasicConstraints.getInstance(ASN1Primitive.fromByteArray(paramCertificate));
        }
        int j;
        try
        {
          paramCertificate = getExtensionBytes("2.5.29.15");
          if (paramCertificate != null)
          {
            localObject = DERBitString.getInstance(ASN1Primitive.fromByteArray(paramCertificate));
            paramCertificate = ((ASN1BitString)localObject).getBytes();
            j = paramCertificate.length * 8 - ((ASN1BitString)localObject).getPadBits();
            i = 9;
            if (j >= 9) {
              break label218;
            }
            this.keyUsage = new boolean[i];
            i = 0;
            if (i != j)
            {
              localObject = this.keyUsage;
              if ((paramCertificate[(i / 8)] & 128 >>> i % 8) == 0) {
                break label223;
              }
              k = 1;
              break label226;
            }
          }
          else
          {
            this.keyUsage = null;
          }
          return;
        }
        catch (Exception paramCertificate)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cannot construct KeyUsage: ");
          ((StringBuilder)localObject).append(paramCertificate);
          throw new CertificateParsingException(((StringBuilder)localObject).toString());
        }
        i = j;
      }
      catch (Exception paramCertificate)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cannot construct BasicConstraints: ");
        ((StringBuilder)localObject).append(paramCertificate);
        throw new CertificateParsingException(((StringBuilder)localObject).toString());
      }
      label218:
      continue;
      label223:
      int k = 0;
      label226:
      localObject[i] = k;
      i += 1;
    }
  }
  
  private int calculateHashCode()
  {
    try
    {
      byte[] arrayOfByte = getEncoded();
      int i = 1;
      int j = 0;
      while (i < arrayOfByte.length)
      {
        int k = arrayOfByte[i];
        j += k * i;
        i += 1;
      }
      return j;
    }
    catch (CertificateEncodingException localCertificateEncodingException) {}
    return 0;
  }
  
  private void checkSignature(PublicKey paramPublicKey, Signature paramSignature)
    throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    if (isAlgIdEqual(this.c.getSignatureAlgorithm(), this.c.getTBSCertificate().getSignature()))
    {
      X509SignatureUtil.setSignatureParameters(paramSignature, this.c.getSignatureAlgorithm().getParameters());
      paramSignature.initVerify(paramPublicKey);
      paramSignature.update(getTBSCertificate());
      if (paramSignature.verify(getSignature())) {
        return;
      }
      throw new SignatureException("certificate does not verify with supplied key");
    }
    throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
  }
  
  private static Collection getAlternativeNames(byte[] paramArrayOfByte)
    throws CertificateParsingException
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new ArrayList();
        Enumeration localEnumeration = ASN1Sequence.getInstance(paramArrayOfByte).getObjects();
        if (localEnumeration.hasMoreElements())
        {
          paramArrayOfByte = GeneralName.getInstance(localEnumeration.nextElement());
          localArrayList = new ArrayList();
          localArrayList.add(Integers.valueOf(paramArrayOfByte.getTagNo()));
          switch (paramArrayOfByte.getTagNo())
          {
          case 8: 
            continue;
            paramArrayOfByte = ASN1ObjectIdentifier.getInstance(paramArrayOfByte.getName()).getId();
            localArrayList.add(paramArrayOfByte);
            break;
          case 7: 
            paramArrayOfByte = DEROctetString.getInstance(paramArrayOfByte.getName()).getOctets();
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject;
        ArrayList localArrayList;
        throw new CertificateParsingException(paramArrayOfByte.getMessage());
      }
      try
      {
        paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte).getHostAddress();
      }
      catch (UnknownHostException paramArrayOfByte) {}
      paramArrayOfByte = X500Name.getInstance(RFC4519Style.INSTANCE, paramArrayOfByte.getName()).toString();
      continue;
      paramArrayOfByte = ((ASN1String)paramArrayOfByte.getName()).getString();
      continue;
      localArrayList.add(paramArrayOfByte.getEncoded());
      ((Collection)localObject).add(Collections.unmodifiableList(localArrayList));
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad tag number: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getTagNo());
      throw new IOException(((StringBuilder)localObject).toString());
      if (((Collection)localObject).size() == 0) {
        return null;
      }
      paramArrayOfByte = Collections.unmodifiableCollection((Collection)localObject);
      return paramArrayOfByte;
    }
  }
  
  private byte[] getExtensionBytes(String paramString)
  {
    Extensions localExtensions = this.c.getTBSCertificate().getExtensions();
    if (localExtensions != null)
    {
      paramString = localExtensions.getExtension(new ASN1ObjectIdentifier(paramString));
      if (paramString != null) {
        return paramString.getExtnValue().getOctets();
      }
    }
    return null;
  }
  
  private boolean isAlgIdEqual(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    if (!paramAlgorithmIdentifier1.getAlgorithm().equals(paramAlgorithmIdentifier2.getAlgorithm())) {
      return false;
    }
    if (paramAlgorithmIdentifier1.getParameters() == null) {
      return (paramAlgorithmIdentifier2.getParameters() == null) || (paramAlgorithmIdentifier2.getParameters().equals(DERNull.INSTANCE));
    }
    if (paramAlgorithmIdentifier2.getParameters() == null) {
      return (paramAlgorithmIdentifier1.getParameters() == null) || (paramAlgorithmIdentifier1.getParameters().equals(DERNull.INSTANCE));
    }
    return paramAlgorithmIdentifier1.getParameters().equals(paramAlgorithmIdentifier2.getParameters());
  }
  
  public void checkValidity()
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    checkValidity(new Date());
  }
  
  public void checkValidity(Date paramDate)
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    if (paramDate.getTime() <= getNotAfter().getTime())
    {
      if (paramDate.getTime() >= getNotBefore().getTime()) {
        return;
      }
      paramDate = new StringBuilder();
      paramDate.append("certificate not valid till ");
      paramDate.append(this.c.getStartDate().getTime());
      throw new CertificateNotYetValidException(paramDate.toString());
    }
    paramDate = new StringBuilder();
    paramDate.append("certificate expired on ");
    paramDate.append(this.c.getEndDate().getTime());
    throw new CertificateExpiredException(paramDate.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof java.security.cert.Certificate)) {
      return false;
    }
    paramObject = (java.security.cert.Certificate)paramObject;
    try
    {
      boolean bool = Arrays.areEqual(getEncoded(), ((java.security.cert.Certificate)paramObject).getEncoded());
      return bool;
    }
    catch (CertificateEncodingException paramObject) {}
    return false;
  }
  
  public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return this.attrCarrier.getBagAttribute(paramASN1ObjectIdentifier);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public int getBasicConstraints()
  {
    BasicConstraints localBasicConstraints = this.basicConstraints;
    if ((localBasicConstraints != null) && (localBasicConstraints.isCA()))
    {
      if (this.basicConstraints.getPathLenConstraint() == null) {
        return Integer.MAX_VALUE;
      }
      return this.basicConstraints.getPathLenConstraint().intValue();
    }
    return -1;
  }
  
  public Set getCriticalExtensionOIDs()
  {
    if (getVersion() == 3)
    {
      HashSet localHashSet = new HashSet();
      Extensions localExtensions = this.c.getTBSCertificate().getExtensions();
      if (localExtensions != null)
      {
        Enumeration localEnumeration = localExtensions.oids();
        while (localEnumeration.hasMoreElements())
        {
          ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
          if (localExtensions.getExtension(localASN1ObjectIdentifier).isCritical()) {
            localHashSet.add(localASN1ObjectIdentifier.getId());
          }
        }
        return localHashSet;
      }
    }
    return null;
  }
  
  public byte[] getEncoded()
    throws CertificateEncodingException
  {
    try
    {
      byte[] arrayOfByte = this.c.getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new CertificateEncodingException(localIOException.toString());
    }
  }
  
  public List getExtendedKeyUsage()
    throws CertificateParsingException
  {
    Object localObject = getExtensionBytes("2.5.29.37");
    if (localObject != null) {}
    try
    {
      localObject = (ASN1Sequence)new ASN1InputStream((byte[])localObject).readObject();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i != ((ASN1Sequence)localObject).size())
      {
        localArrayList.add(((ASN1ObjectIdentifier)((ASN1Sequence)localObject).getObjectAt(i)).getId());
        i += 1;
      }
      localObject = Collections.unmodifiableList(localArrayList);
      return (List)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    throw new CertificateParsingException("error processing extended key usage extension");
    return null;
  }
  
  public byte[] getExtensionValue(String paramString)
  {
    Object localObject = this.c.getTBSCertificate().getExtensions();
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
  
  public Collection getIssuerAlternativeNames()
    throws CertificateParsingException
  {
    return getAlternativeNames(getExtensionBytes(Extension.issuerAlternativeName.getId()));
  }
  
  public Principal getIssuerDN()
  {
    try
    {
      X509Principal localX509Principal = new X509Principal(X500Name.getInstance(this.c.getIssuer().getEncoded()));
      return localX509Principal;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public boolean[] getIssuerUniqueID()
  {
    Object localObject = this.c.getTBSCertificate().getIssuerUniqueId();
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
  
  public X500Principal getIssuerX500Principal()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      new ASN1OutputStream((OutputStream)localObject).writeObject(this.c.getIssuer());
      localObject = new X500Principal(((ByteArrayOutputStream)localObject).toByteArray());
      return (X500Principal)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("can't encode issuer DN");
  }
  
  public boolean[] getKeyUsage()
  {
    return this.keyUsage;
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    if (getVersion() == 3)
    {
      HashSet localHashSet = new HashSet();
      Extensions localExtensions = this.c.getTBSCertificate().getExtensions();
      if (localExtensions != null)
      {
        Enumeration localEnumeration = localExtensions.oids();
        while (localEnumeration.hasMoreElements())
        {
          ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
          if (!localExtensions.getExtension(localASN1ObjectIdentifier).isCritical()) {
            localHashSet.add(localASN1ObjectIdentifier.getId());
          }
        }
        return localHashSet;
      }
    }
    return null;
  }
  
  public Date getNotAfter()
  {
    return this.c.getEndDate().getDate();
  }
  
  public Date getNotBefore()
  {
    return this.c.getStartDate().getDate();
  }
  
  public PublicKey getPublicKey()
  {
    try
    {
      PublicKey localPublicKey = BouncyCastleProvider.getPublicKey(this.c.getSubjectPublicKeyInfo());
      return localPublicKey;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.c.getSerialNumber().getValue();
  }
  
  public String getSigAlgName()
  {
    Object localObject1 = Security.getProvider("BC");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject2).append(getSigAlgOID());
      localObject1 = ((Provider)localObject1).getProperty(((StringBuilder)localObject2).toString());
      if (localObject1 != null) {
        return (String)localObject1;
      }
    }
    localObject1 = Security.getProviders();
    int i = 0;
    while (i != localObject1.length)
    {
      localObject2 = localObject1[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.Signature.");
      localStringBuilder.append(getSigAlgOID());
      localObject2 = ((Provider)localObject2).getProperty(localStringBuilder.toString());
      if (localObject2 != null) {
        return (String)localObject2;
      }
      i += 1;
    }
    return getSigAlgOID();
  }
  
  public String getSigAlgOID()
  {
    return this.c.getSignatureAlgorithm().getAlgorithm().getId();
  }
  
  public byte[] getSigAlgParams()
  {
    if (this.c.getSignatureAlgorithm().getParameters() != null) {}
    try
    {
      byte[] arrayOfByte = this.c.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException) {}
    return null;
    return null;
  }
  
  public byte[] getSignature()
  {
    return this.c.getSignature().getOctets();
  }
  
  public Collection getSubjectAlternativeNames()
    throws CertificateParsingException
  {
    return getAlternativeNames(getExtensionBytes(Extension.subjectAlternativeName.getId()));
  }
  
  public Principal getSubjectDN()
  {
    return new X509Principal(X500Name.getInstance(this.c.getSubject().toASN1Primitive()));
  }
  
  public boolean[] getSubjectUniqueID()
  {
    Object localObject = this.c.getTBSCertificate().getSubjectUniqueId();
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
  
  public X500Principal getSubjectX500Principal()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      new ASN1OutputStream((OutputStream)localObject).writeObject(this.c.getSubject());
      localObject = new X500Principal(((ByteArrayOutputStream)localObject).toByteArray());
      return (X500Principal)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("can't encode issuer DN");
  }
  
  public byte[] getTBSCertificate()
    throws CertificateEncodingException
  {
    try
    {
      byte[] arrayOfByte = this.c.getTBSCertificate().getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new CertificateEncodingException(localIOException.toString());
    }
  }
  
  public int getVersion()
  {
    return this.c.getVersionNumber();
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    if (getVersion() == 3)
    {
      Extensions localExtensions = this.c.getTBSCertificate().getExtensions();
      if (localExtensions != null)
      {
        Enumeration localEnumeration = localExtensions.oids();
        while (localEnumeration.hasMoreElements())
        {
          ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
          String str = localASN1ObjectIdentifier.getId();
          if ((!str.equals(RFC3280CertPathUtilities.KEY_USAGE)) && (!str.equals(RFC3280CertPathUtilities.CERTIFICATE_POLICIES)) && (!str.equals(RFC3280CertPathUtilities.POLICY_MAPPINGS)) && (!str.equals(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY)) && (!str.equals(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS)) && (!str.equals(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT)) && (!str.equals(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR)) && (!str.equals(RFC3280CertPathUtilities.POLICY_CONSTRAINTS)) && (!str.equals(RFC3280CertPathUtilities.BASIC_CONSTRAINTS)) && (!str.equals(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME)) && (!str.equals(RFC3280CertPathUtilities.NAME_CONSTRAINTS)) && (localExtensions.getExtension(localASN1ObjectIdentifier).isCritical())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    try
    {
      if (!this.hashValueSet)
      {
        this.hashValue = calculateHashCode();
        this.hashValueSet = true;
      }
      int i = this.hashValue;
      return i;
    }
    finally {}
  }
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("  [0]         Version: ");
    localStringBuffer.append(getVersion());
    localStringBuffer.append(str);
    localStringBuffer.append("         SerialNumber: ");
    localStringBuffer.append(getSerialNumber());
    localStringBuffer.append(str);
    localStringBuffer.append("             IssuerDN: ");
    localStringBuffer.append(getIssuerDN());
    localStringBuffer.append(str);
    localStringBuffer.append("           Start Date: ");
    localStringBuffer.append(getNotBefore());
    localStringBuffer.append(str);
    localStringBuffer.append("           Final Date: ");
    localStringBuffer.append(getNotAfter());
    localStringBuffer.append(str);
    localStringBuffer.append("            SubjectDN: ");
    localStringBuffer.append(getSubjectDN());
    localStringBuffer.append(str);
    localStringBuffer.append("           Public Key: ");
    localStringBuffer.append(getPublicKey());
    localStringBuffer.append(str);
    localStringBuffer.append("  Signature Algorithm: ");
    localStringBuffer.append(getSigAlgName());
    localStringBuffer.append(str);
    Object localObject2 = getSignature();
    localStringBuffer.append("            Signature: ");
    localStringBuffer.append(new String(Hex.encode((byte[])localObject2, 0, 20)));
    localStringBuffer.append(str);
    int i = 20;
    Object localObject1;
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
    localObject2 = this.c.getTBSCertificate().getExtensions();
    if (localObject2 != null)
    {
      Enumeration localEnumeration = ((Extensions)localObject2).oids();
      if (localEnumeration.hasMoreElements()) {
        localStringBuffer.append("       Extensions: \n");
      }
      while (localEnumeration.hasMoreElements())
      {
        ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
        localObject1 = ((Extensions)localObject2).getExtension(localASN1ObjectIdentifier);
        ASN1InputStream localASN1InputStream;
        if (((Extension)localObject1).getExtnValue() != null)
        {
          localASN1InputStream = new ASN1InputStream(((Extension)localObject1).getExtnValue().getOctets());
          localStringBuffer.append("                       critical(");
          localStringBuffer.append(((Extension)localObject1).isCritical());
          localStringBuffer.append(") ");
        }
        try
        {
          if (localASN1ObjectIdentifier.equals(Extension.basicConstraints))
          {
            localObject1 = BasicConstraints.getInstance(localASN1InputStream.readObject());
            label510:
            localStringBuffer.append(localObject1);
          }
          for (;;)
          {
            localStringBuffer.append(str);
            break;
            if (localASN1ObjectIdentifier.equals(Extension.keyUsage))
            {
              localObject1 = KeyUsage.getInstance(localASN1InputStream.readObject());
              break label510;
            }
            if (localASN1ObjectIdentifier.equals(MiscObjectIdentifiers.netscapeCertType))
            {
              localObject1 = new NetscapeCertType((DERBitString)localASN1InputStream.readObject());
              break label510;
            }
            if (localASN1ObjectIdentifier.equals(MiscObjectIdentifiers.netscapeRevocationURL))
            {
              localObject1 = new NetscapeRevocationURL((DERIA5String)localASN1InputStream.readObject());
              break label510;
            }
            if (localASN1ObjectIdentifier.equals(MiscObjectIdentifiers.verisignCzagExtension))
            {
              localObject1 = new VerisignCzagExtension((DERIA5String)localASN1InputStream.readObject());
              break label510;
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
        localStringBuffer.append(localASN1ObjectIdentifier.getId());
        localStringBuffer.append(" value = ");
        localStringBuffer.append("*****");
        localStringBuffer.append(str);
      }
    }
    return localStringBuffer.toString();
  }
  
  public final void verify(PublicKey paramPublicKey)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    String str = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
    try
    {
      localSignature = Signature.getInstance(str, "BC");
    }
    catch (Exception localException)
    {
      Signature localSignature;
      for (;;) {}
    }
    localSignature = Signature.getInstance(str);
    checkSignature(paramPublicKey, localSignature);
  }
  
  public final void verify(PublicKey paramPublicKey, String paramString)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    String str = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
    if (paramString != null) {
      paramString = Signature.getInstance(str, paramString);
    } else {
      paramString = Signature.getInstance(str);
    }
    checkSignature(paramPublicKey, paramString);
  }
  
  public final void verify(PublicKey paramPublicKey, Provider paramProvider)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    String str = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
    if (paramProvider != null) {
      paramProvider = Signature.getInstance(str, paramProvider);
    } else {
      paramProvider = Signature.getInstance(str);
    }
    checkSignature(paramPublicKey, paramProvider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509CertificateObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */