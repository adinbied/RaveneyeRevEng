package org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.PKIXCRLStore;
import org.bouncycastle.jcajce.PKIXCRLStoreSelector.Builder;
import org.bouncycastle.jcajce.PKIXCertStore;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXCertStoreSelector.Builder;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509AttributeCertificate;

class CertPathValidatorUtilities
{
  protected static final String ANY_POLICY = "2.5.29.32.0";
  protected static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
  protected static final String BASIC_CONSTRAINTS;
  protected static final String CERTIFICATE_POLICIES;
  protected static final String CRL_DISTRIBUTION_POINTS;
  protected static final String CRL_NUMBER = Extension.cRLNumber.getId();
  protected static final int CRL_SIGN = 6;
  protected static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
  protected static final String DELTA_CRL_INDICATOR;
  protected static final String FRESHEST_CRL;
  protected static final String INHIBIT_ANY_POLICY;
  protected static final String ISSUING_DISTRIBUTION_POINT;
  protected static final int KEY_CERT_SIGN = 5;
  protected static final String KEY_USAGE;
  protected static final String NAME_CONSTRAINTS;
  protected static final String POLICY_CONSTRAINTS;
  protected static final String POLICY_MAPPINGS;
  protected static final String SUBJECT_ALTERNATIVE_NAME;
  protected static final String[] crlReasons = { "unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise" };
  
  static
  {
    CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    POLICY_MAPPINGS = Extension.policyMappings.getId();
    SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    KEY_USAGE = Extension.keyUsage.getId();
    INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    FRESHEST_CRL = Extension.freshestCRL.getId();
    CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
  }
  
  static void checkCRLsNotEmpty(Set paramSet, Object paramObject)
    throws AnnotatedException
  {
    if (paramSet.isEmpty())
    {
      if ((paramObject instanceof X509AttributeCertificate))
      {
        paramSet = (X509AttributeCertificate)paramObject;
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("No CRLs found for issuer \"");
        ((StringBuilder)paramObject).append(paramSet.getIssuer().getPrincipals()[0]);
        ((StringBuilder)paramObject).append("\"");
        throw new AnnotatedException(((StringBuilder)paramObject).toString());
      }
      paramSet = (X509Certificate)paramObject;
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("No CRLs found for issuer \"");
      ((StringBuilder)paramObject).append(RFC4519Style.INSTANCE.toString(PrincipalUtils.getIssuerPrincipal(paramSet)));
      ((StringBuilder)paramObject).append("\"");
      throw new AnnotatedException(((StringBuilder)paramObject).toString());
    }
  }
  
  protected static Collection findCertificates(PKIXCertStoreSelector paramPKIXCertStoreSelector, List paramList)
    throws AnnotatedException
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof Store))
      {
        localObject = (Store)localObject;
        try
        {
          localLinkedHashSet.addAll(((Store)localObject).getMatches(paramPKIXCertStoreSelector));
        }
        catch (StoreException paramPKIXCertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from X.509 store.", paramPKIXCertStoreSelector);
        }
      }
      else
      {
        localObject = (CertStore)localObject;
        try
        {
          localLinkedHashSet.addAll(PKIXCertStoreSelector.getCertificates(paramPKIXCertStoreSelector, (CertStore)localObject));
        }
        catch (CertStoreException paramPKIXCertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from certificate store.", paramPKIXCertStoreSelector);
        }
      }
    }
    return localLinkedHashSet;
  }
  
  static Collection findIssuerCerts(X509Certificate paramX509Certificate, List<CertStore> paramList, List<PKIXCertStore> paramList1)
    throws AnnotatedException
  {
    Object localObject = new X509CertSelector();
    for (;;)
    {
      try
      {
        ((X509CertSelector)localObject).setSubject(PrincipalUtils.getIssuerPrincipal(paramX509Certificate).getEncoded());
      }
      catch (IOException paramX509Certificate)
      {
        ArrayList localArrayList;
        throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", paramX509Certificate);
      }
      try
      {
        paramX509Certificate = paramX509Certificate.getExtensionValue(AUTHORITY_KEY_IDENTIFIER);
        if (paramX509Certificate != null)
        {
          paramX509Certificate = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(paramX509Certificate).getOctets()).getKeyIdentifier();
          if (paramX509Certificate != null) {
            ((X509CertSelector)localObject).setSubjectKeyIdentifier(new DEROctetString(paramX509Certificate).getEncoded());
          }
        }
      }
      catch (Exception paramX509Certificate) {}
    }
    localObject = new PKIXCertStoreSelector.Builder((CertSelector)localObject).build();
    paramX509Certificate = new LinkedHashSet();
    try
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(findCertificates((PKIXCertStoreSelector)localObject, paramList));
      localArrayList.addAll(findCertificates((PKIXCertStoreSelector)localObject, paramList1));
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        paramX509Certificate.add((X509Certificate)paramList.next());
      }
      return paramX509Certificate;
    }
    catch (AnnotatedException paramX509Certificate)
    {
      throw new AnnotatedException("Issuer certificate cannot be searched.", paramX509Certificate);
    }
  }
  
  protected static TrustAnchor findTrustAnchor(X509Certificate paramX509Certificate, Set paramSet)
    throws AnnotatedException
  {
    return findTrustAnchor(paramX509Certificate, paramSet, null);
  }
  
  protected static TrustAnchor findTrustAnchor(X509Certificate paramX509Certificate, Set paramSet, String paramString)
    throws AnnotatedException
  {
    X509CertSelector localX509CertSelector = new X509CertSelector();
    X500Name localX500Name = PrincipalUtils.getEncodedIssuerPrincipal(paramX509Certificate);
    for (;;)
    {
      try
      {
        localX509CertSelector.setSubject(localX500Name.getEncoded());
        Iterator localIterator = paramSet.iterator();
        localTrustAnchor2 = null;
        localTrustAnchor1 = localTrustAnchor2;
        paramSet = localTrustAnchor1;
        TrustAnchor localTrustAnchor3 = localTrustAnchor1;
        localTrustAnchor1 = localTrustAnchor2;
        if ((localIterator.hasNext()) && (localTrustAnchor1 == null))
        {
          localTrustAnchor2 = (TrustAnchor)localIterator.next();
          if (localTrustAnchor2.getTrustedCert() != null)
          {
            if (localX509CertSelector.match(localTrustAnchor2.getTrustedCert()))
            {
              localObject = localTrustAnchor2.getTrustedCert().getPublicKey();
              continue;
            }
          }
          else if ((localTrustAnchor2.getCAName() == null) || (localTrustAnchor2.getCAPublicKey() == null)) {}
        }
      }
      catch (IOException paramX509Certificate)
      {
        TrustAnchor localTrustAnchor2;
        TrustAnchor localTrustAnchor1;
        Object localObject;
        throw new AnnotatedException("Cannot set subject search criteria for trust anchor.", paramX509Certificate);
      }
      try
      {
        if (localX500Name.equals(PrincipalUtils.getCA(localTrustAnchor2))) {
          localObject = localTrustAnchor2.getCAPublicKey();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        continue;
      }
      localTrustAnchor2 = null;
      localObject = paramSet;
      localTrustAnchor1 = localTrustAnchor2;
      paramSet = (Set)localObject;
      if (localObject != null) {
        try
        {
          verifyX509Certificate(paramX509Certificate, (PublicKey)localObject, paramString);
          localTrustAnchor1 = localTrustAnchor2;
          paramSet = (Set)localObject;
        }
        catch (Exception localException)
        {
          localTrustAnchor1 = null;
          paramSet = localTrustAnchor1;
        }
      }
    }
    if (localTrustAnchor1 == null)
    {
      if (localException == null) {
        return localTrustAnchor1;
      }
      throw new AnnotatedException("TrustAnchor found but certificate validation failed.", localException);
    }
    return localTrustAnchor1;
  }
  
  static List<PKIXCertStore> getAdditionalStoresFromAltNames(byte[] paramArrayOfByte, Map<GeneralName, PKIXCertStore> paramMap)
    throws CertificateParsingException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = GeneralNames.getInstance(ASN1OctetString.getInstance(paramArrayOfByte).getOctets()).getNames();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i != paramArrayOfByte.length)
      {
        PKIXCertStore localPKIXCertStore = (PKIXCertStore)paramMap.get(paramArrayOfByte[i]);
        if (localPKIXCertStore != null) {
          localArrayList.add(localPKIXCertStore);
        }
        i += 1;
      }
      return localArrayList;
    }
    return Collections.EMPTY_LIST;
  }
  
  static List<PKIXCRLStore> getAdditionalStoresFromCRLDistributionPoint(CRLDistPoint paramCRLDistPoint, Map<GeneralName, PKIXCRLStore> paramMap)
    throws AnnotatedException
  {
    if (paramCRLDistPoint != null) {
      try
      {
        paramCRLDistPoint = paramCRLDistPoint.getDistributionPoints();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramCRLDistPoint.length)
        {
          Object localObject = paramCRLDistPoint[i].getDistributionPoint();
          if ((localObject != null) && (((DistributionPointName)localObject).getType() == 0))
          {
            localObject = GeneralNames.getInstance(((DistributionPointName)localObject).getName()).getNames();
            int j = 0;
            while (j < localObject.length)
            {
              PKIXCRLStore localPKIXCRLStore = (PKIXCRLStore)paramMap.get(localObject[j]);
              if (localPKIXCRLStore != null) {
                localArrayList.add(localPKIXCRLStore);
              }
              j += 1;
            }
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception paramCRLDistPoint)
      {
        throw new AnnotatedException("Distribution points could not be read.", paramCRLDistPoint);
      }
    }
    return Collections.EMPTY_LIST;
  }
  
  protected static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey paramPublicKey)
    throws CertPathValidatorException
  {
    try
    {
      paramPublicKey = SubjectPublicKeyInfo.getInstance(new ASN1InputStream(paramPublicKey.getEncoded()).readObject()).getAlgorithm();
      return paramPublicKey;
    }
    catch (Exception paramPublicKey)
    {
      throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", paramPublicKey);
    }
  }
  
  protected static void getCRLIssuersFromDistributionPoint(DistributionPoint paramDistributionPoint, Collection paramCollection, X509CRLSelector paramX509CRLSelector)
    throws AnnotatedException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramDistributionPoint.getCRLIssuer() != null)
    {
      paramDistributionPoint = paramDistributionPoint.getCRLIssuer().getNames();
      int i = 0;
      while (i < paramDistributionPoint.length)
      {
        if (paramDistributionPoint[i].getTagNo() == 4) {
          try
          {
            localArrayList.add(X500Name.getInstance(paramDistributionPoint[i].getName().toASN1Primitive().getEncoded()));
          }
          catch (IOException paramDistributionPoint)
          {
            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", paramDistributionPoint);
          }
        }
        i += 1;
      }
    }
    if (paramDistributionPoint.getDistributionPoint() != null)
    {
      paramDistributionPoint = paramCollection.iterator();
      while (paramDistributionPoint.hasNext()) {
        localArrayList.add(paramDistributionPoint.next());
      }
      paramDistributionPoint = localArrayList.iterator();
      while (paramDistributionPoint.hasNext()) {
        try
        {
          paramX509CRLSelector.addIssuerName(((X500Name)paramDistributionPoint.next()).getEncoded());
        }
        catch (IOException paramDistributionPoint)
        {
          throw new AnnotatedException("Cannot decode CRL issuer information.", paramDistributionPoint);
        }
      }
      return;
    }
    throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
  }
  
  protected static void getCertStatus(Date paramDate, X509CRL paramX509CRL, Object paramObject, CertStatus paramCertStatus)
    throws AnnotatedException
  {
    try
    {
      boolean bool = X509CRLObject.isIndirectCRL(paramX509CRL);
      if (bool)
      {
        X509CRLEntry localX509CRLEntry = paramX509CRL.getRevokedCertificate(getSerialNumber(paramObject));
        if (localX509CRLEntry == null) {
          return;
        }
        Object localObject = localX509CRLEntry.getCertificateIssuer();
        if (localObject == null) {
          localObject = PrincipalUtils.getIssuerPrincipal(paramX509CRL);
        } else {
          localObject = X500Name.getInstance(((X500Principal)localObject).getEncoded());
        }
        paramX509CRL = localX509CRLEntry;
        if (PrincipalUtils.getEncodedIssuerPrincipal(paramObject).equals(localObject)) {}
      }
      else
      {
        if (!PrincipalUtils.getEncodedIssuerPrincipal(paramObject).equals(PrincipalUtils.getIssuerPrincipal(paramX509CRL))) {
          return;
        }
        paramObject = paramX509CRL.getRevokedCertificate(getSerialNumber(paramObject));
        paramX509CRL = (X509CRL)paramObject;
        if (paramObject == null) {
          return;
        }
      }
      paramObject = null;
      if (paramX509CRL.hasExtensions()) {
        try
        {
          paramObject = ASN1Enumerated.getInstance(getExtensionValue(paramX509CRL, Extension.reasonCode.getId()));
        }
        catch (Exception paramDate)
        {
          throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", paramDate);
        }
      }
      if ((paramDate.getTime() >= paramX509CRL.getRevocationDate().getTime()) || (paramObject == null) || (((ASN1Enumerated)paramObject).getValue().intValue() == 0) || (((ASN1Enumerated)paramObject).getValue().intValue() == 1) || (((ASN1Enumerated)paramObject).getValue().intValue() == 2) || (((ASN1Enumerated)paramObject).getValue().intValue() == 8))
      {
        int i;
        if (paramObject != null) {
          i = ((ASN1Enumerated)paramObject).getValue().intValue();
        } else {
          i = 0;
        }
        paramCertStatus.setCertStatus(i);
        paramCertStatus.setRevocationDate(paramX509CRL.getRevocationDate());
      }
      return;
    }
    catch (CRLException paramDate)
    {
      throw new AnnotatedException("Failed check for indirect CRL.", paramDate);
    }
  }
  
  protected static Set getCompleteCRLs(DistributionPoint paramDistributionPoint, Object paramObject, Date paramDate, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws AnnotatedException
  {
    X509CRLSelector localX509CRLSelector = new X509CRLSelector();
    try
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add(PrincipalUtils.getEncodedIssuerPrincipal(paramObject));
      getCRLIssuersFromDistributionPoint(paramDistributionPoint, localHashSet, localX509CRLSelector);
      if ((paramObject instanceof X509Certificate)) {
        localX509CRLSelector.setCertificateChecking((X509Certificate)paramObject);
      }
      paramDistributionPoint = new PKIXCRLStoreSelector.Builder(localX509CRLSelector).setCompleteCRLEnabled(true).build();
      if (paramPKIXExtendedParameters.getDate() != null) {
        paramDate = paramPKIXExtendedParameters.getDate();
      }
      paramDistributionPoint = CRL_UTIL.findCRLs(paramDistributionPoint, paramDate, paramPKIXExtendedParameters.getCertStores(), paramPKIXExtendedParameters.getCRLStores());
      checkCRLsNotEmpty(paramDistributionPoint, paramObject);
      return paramDistributionPoint;
    }
    catch (AnnotatedException paramDistributionPoint)
    {
      throw new AnnotatedException("Could not get issuer information from distribution point.", paramDistributionPoint);
    }
  }
  
  /* Error */
  protected static Set getDeltaCRLs(Date paramDate, X509CRL paramX509CRL, List<CertStore> paramList, List<PKIXCRLStore> paramList1)
    throws AnnotatedException
  {
    // Byte code:
    //   0: new 493	java/security/cert/X509CRLSelector
    //   3: dup
    //   4: invokespecial 582	java/security/cert/X509CRLSelector:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokestatic 529	org/bouncycastle/jce/provider/PrincipalUtils:getIssuerPrincipal	(Ljava/security/cert/X509CRL;)Lorg/bouncycastle/asn1/x500/X500Name;
    //   15: invokevirtual 273	org/bouncycastle/asn1/x500/X500Name:getEncoded	()[B
    //   18: invokevirtual 496	java/security/cert/X509CRLSelector:addIssuerName	([B)V
    //   21: aload_1
    //   22: getstatic 119	org/bouncycastle/jce/provider/CertPathValidatorUtilities:CRL_NUMBER	Ljava/lang/String;
    //   25: invokestatic 541	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   28: astore 4
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 4
    //   35: ifnull +16 -> 51
    //   38: aload 4
    //   40: invokestatic 630	org/bouncycastle/asn1/ASN1Integer:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1Integer;
    //   43: invokevirtual 633	org/bouncycastle/asn1/ASN1Integer:getPositiveValue	()Ljava/math/BigInteger;
    //   46: astore 4
    //   48: goto +6 -> 54
    //   51: aconst_null
    //   52: astore 4
    //   54: aload_1
    //   55: getstatic 89	org/bouncycastle/jce/provider/CertPathValidatorUtilities:ISSUING_DISTRIBUTION_POINT	Ljava/lang/String;
    //   58: invokevirtual 634	java/security/cert/X509CRL:getExtensionValue	(Ljava/lang/String;)[B
    //   61: astore 7
    //   63: aload 4
    //   65: ifnonnull +9 -> 74
    //   68: aload 5
    //   70: astore_1
    //   71: goto +13 -> 84
    //   74: aload 4
    //   76: lconst_1
    //   77: invokestatic 638	java/math/BigInteger:valueOf	(J)Ljava/math/BigInteger;
    //   80: invokevirtual 641	java/math/BigInteger:add	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   83: astore_1
    //   84: aload 6
    //   86: aload_1
    //   87: invokevirtual 645	java/security/cert/X509CRLSelector:setMinCRLNumber	(Ljava/math/BigInteger;)V
    //   90: new 593	org/bouncycastle/jcajce/PKIXCRLStoreSelector$Builder
    //   93: dup
    //   94: aload 6
    //   96: invokespecial 596	org/bouncycastle/jcajce/PKIXCRLStoreSelector$Builder:<init>	(Ljava/security/cert/CRLSelector;)V
    //   99: astore_1
    //   100: aload_1
    //   101: aload 7
    //   103: invokevirtual 648	org/bouncycastle/jcajce/PKIXCRLStoreSelector$Builder:setIssuingDistributionPoint	([B)V
    //   106: aload_1
    //   107: iconst_1
    //   108: invokevirtual 652	org/bouncycastle/jcajce/PKIXCRLStoreSelector$Builder:setIssuingDistributionPointEnabled	(Z)V
    //   111: aload_1
    //   112: aload 4
    //   114: invokevirtual 655	org/bouncycastle/jcajce/PKIXCRLStoreSelector$Builder:setMaxBaseCRLNumber	(Ljava/math/BigInteger;)V
    //   117: aload_1
    //   118: invokevirtual 603	org/bouncycastle/jcajce/PKIXCRLStoreSelector$Builder:build	()Lorg/bouncycastle/jcajce/PKIXCRLStoreSelector;
    //   121: astore_1
    //   122: getstatic 40	org/bouncycastle/jce/provider/CertPathValidatorUtilities:CRL_UTIL	Lorg/bouncycastle/jce/provider/PKIXCRLUtil;
    //   125: aload_1
    //   126: aload_0
    //   127: aload_2
    //   128: aload_3
    //   129: invokevirtual 619	org/bouncycastle/jce/provider/PKIXCRLUtil:findCRLs	(Lorg/bouncycastle/jcajce/PKIXCRLStoreSelector;Ljava/util/Date;Ljava/util/List;Ljava/util/List;)Ljava/util/Set;
    //   132: astore_1
    //   133: new 584	java/util/HashSet
    //   136: dup
    //   137: invokespecial 585	java/util/HashSet:<init>	()V
    //   140: astore_0
    //   141: aload_1
    //   142: invokeinterface 343 1 0
    //   147: astore_1
    //   148: aload_1
    //   149: invokeinterface 229 1 0
    //   154: ifeq +31 -> 185
    //   157: aload_1
    //   158: invokeinterface 233 1 0
    //   163: checkcast 516	java/security/cert/X509CRL
    //   166: astore_2
    //   167: aload_2
    //   168: invokestatic 658	org/bouncycastle/jce/provider/CertPathValidatorUtilities:isDeltaCRL	(Ljava/security/cert/X509CRL;)Z
    //   171: ifeq -23 -> 148
    //   174: aload_0
    //   175: aload_2
    //   176: invokeinterface 325 2 0
    //   181: pop
    //   182: goto -34 -> 148
    //   185: aload_0
    //   186: areturn
    //   187: astore_0
    //   188: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   191: dup
    //   192: ldc_w 660
    //   195: aload_0
    //   196: invokespecial 248	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: athrow
    //   200: astore_0
    //   201: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   204: dup
    //   205: ldc_w 662
    //   208: aload_0
    //   209: invokespecial 248	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: athrow
    //   213: astore_0
    //   214: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   217: dup
    //   218: ldc_w 664
    //   221: aload_0
    //   222: invokespecial 248	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramDate	Date
    //   0	226	1	paramX509CRL	X509CRL
    //   0	226	2	paramList	List<CertStore>
    //   0	226	3	paramList1	List<PKIXCRLStore>
    //   28	85	4	localObject1	Object
    //   31	38	5	localObject2	Object
    //   7	88	6	localX509CRLSelector	X509CRLSelector
    //   61	41	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	63	187	java/lang/Exception
    //   21	30	200	java/lang/Exception
    //   38	48	200	java/lang/Exception
    //   9	21	213	java/io/IOException
  }
  
  protected static ASN1Primitive getExtensionValue(X509Extension paramX509Extension, String paramString)
    throws AnnotatedException
  {
    paramX509Extension = paramX509Extension.getExtensionValue(paramString);
    if (paramX509Extension == null) {
      return null;
    }
    return getObject(paramString, paramX509Extension);
  }
  
  protected static PublicKey getNextWorkingKey(List paramList, int paramInt, JcaJceHelper paramJcaJceHelper)
    throws CertPathValidatorException
  {
    Object localObject1 = ((Certificate)paramList.get(paramInt)).getPublicKey();
    if (!(localObject1 instanceof DSAPublicKey)) {
      return (PublicKey)localObject1;
    }
    localObject1 = (DSAPublicKey)localObject1;
    if (((DSAPublicKey)localObject1).getParams() != null) {
      return (PublicKey)localObject1;
    }
    Object localObject2;
    do
    {
      paramInt += 1;
      if (paramInt >= paramList.size()) {
        break label176;
      }
      localObject2 = ((X509Certificate)paramList.get(paramInt)).getPublicKey();
      if (!(localObject2 instanceof DSAPublicKey)) {
        break;
      }
      localObject2 = (DSAPublicKey)localObject2;
    } while (((DSAPublicKey)localObject2).getParams() == null);
    paramList = ((DSAPublicKey)localObject2).getParams();
    paramList = new DSAPublicKeySpec(((DSAPublicKey)localObject1).getY(), paramList.getP(), paramList.getQ(), paramList.getG());
    try
    {
      paramList = paramJcaJceHelper.createKeyFactory("DSA").generatePublic(paramList);
      return paramList;
    }
    catch (Exception paramList)
    {
      throw new RuntimeException(paramList.getMessage());
    }
    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
    label176:
    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
  }
  
  private static ASN1Primitive getObject(String paramString, byte[] paramArrayOfByte)
    throws AnnotatedException
  {
    try
    {
      paramArrayOfByte = new ASN1InputStream(((ASN1OctetString)new ASN1InputStream(paramArrayOfByte).readObject()).getOctets()).readObject();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception processing extension ");
      localStringBuilder.append(paramString);
      throw new AnnotatedException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  protected static final Set getQualifierSet(ASN1Sequence paramASN1Sequence)
    throws CertPathValidatorException
  {
    HashSet localHashSet = new HashSet();
    if (paramASN1Sequence == null) {
      return localHashSet;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ASN1OutputStream localASN1OutputStream = new ASN1OutputStream(localByteArrayOutputStream);
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements()) {
      try
      {
        localASN1OutputStream.writeObject((ASN1Encodable)paramASN1Sequence.nextElement());
        localHashSet.add(new PolicyQualifierInfo(localByteArrayOutputStream.toByteArray()));
        localByteArrayOutputStream.reset();
      }
      catch (IOException paramASN1Sequence)
      {
        throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", paramASN1Sequence);
      }
    }
    return localHashSet;
  }
  
  private static BigInteger getSerialNumber(Object paramObject)
  {
    return ((X509Certificate)paramObject).getSerialNumber();
  }
  
  protected static Date getValidCertDateFromValidityModel(PKIXExtendedParameters paramPKIXExtendedParameters, CertPath paramCertPath, int paramInt)
    throws AnnotatedException
  {
    if (paramPKIXExtendedParameters.getValidityModel() == 1)
    {
      if (paramInt <= 0) {
        return getValidDate(paramPKIXExtendedParameters);
      }
      paramInt -= 1;
      if (paramInt == 0) {
        paramPKIXExtendedParameters = null;
      }
    }
    try
    {
      byte[] arrayOfByte = ((X509Certificate)paramCertPath.getCertificates().get(paramInt)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
      if (arrayOfByte != null) {
        paramPKIXExtendedParameters = ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(arrayOfByte));
      }
      if (paramPKIXExtendedParameters != null) {
        try
        {
          paramPKIXExtendedParameters = paramPKIXExtendedParameters.getDate();
          return paramPKIXExtendedParameters;
        }
        catch (ParseException paramPKIXExtendedParameters)
        {
          throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", paramPKIXExtendedParameters);
        }
      }
      return ((X509Certificate)paramCertPath.getCertificates().get(paramInt)).getNotBefore();
    }
    catch (IOException paramPKIXExtendedParameters)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException paramPKIXExtendedParameters)
    {
      for (;;) {}
    }
    throw new AnnotatedException("Date of cert gen extension could not be read.");
    throw new AnnotatedException("Date of cert gen extension could not be read.");
    return getValidDate(paramPKIXExtendedParameters);
  }
  
  protected static Date getValidDate(PKIXExtendedParameters paramPKIXExtendedParameters)
  {
    Date localDate = paramPKIXExtendedParameters.getDate();
    paramPKIXExtendedParameters = localDate;
    if (localDate == null) {
      paramPKIXExtendedParameters = new Date();
    }
    return paramPKIXExtendedParameters;
  }
  
  protected static boolean isAnyPolicy(Set paramSet)
  {
    return (paramSet == null) || (paramSet.contains("2.5.29.32.0")) || (paramSet.isEmpty());
  }
  
  private static boolean isDeltaCRL(X509CRL paramX509CRL)
  {
    paramX509CRL = paramX509CRL.getCriticalExtensionOIDs();
    if (paramX509CRL == null) {
      return false;
    }
    return paramX509CRL.contains(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
  }
  
  protected static boolean isSelfIssued(X509Certificate paramX509Certificate)
  {
    return paramX509Certificate.getSubjectDN().equals(paramX509Certificate.getIssuerDN());
  }
  
  protected static void prepareNextCertB1(int paramInt, List[] paramArrayOfList, String paramString, Map paramMap, X509Certificate paramX509Certificate)
    throws AnnotatedException, CertPathValidatorException
  {
    Object localObject = paramArrayOfList[paramInt].iterator();
    PKIXPolicyNode localPKIXPolicyNode1;
    while (((Iterator)localObject).hasNext())
    {
      localPKIXPolicyNode1 = (PKIXPolicyNode)((Iterator)localObject).next();
      if (localPKIXPolicyNode1.getValidPolicy().equals(paramString))
      {
        i = 1;
        localPKIXPolicyNode1.expectedPolicies = ((Set)paramMap.get(paramString));
        break label68;
      }
    }
    int i = 0;
    label68:
    if (i == 0)
    {
      localObject = paramArrayOfList[paramInt].iterator();
      while (((Iterator)localObject).hasNext())
      {
        PKIXPolicyNode localPKIXPolicyNode2 = (PKIXPolicyNode)((Iterator)localObject).next();
        if ("2.5.29.32.0".equals(localPKIXPolicyNode2.getValidPolicy()))
        {
          localPKIXPolicyNode1 = null;
          try
          {
            localObject = DERSequence.getInstance(getExtensionValue(paramX509Certificate, CERTIFICATE_POLICIES));
            Enumeration localEnumeration = ((ASN1Sequence)localObject).getObjects();
            for (;;)
            {
              localObject = localPKIXPolicyNode1;
              if (localEnumeration.hasMoreElements()) {
                try
                {
                  localObject = PolicyInformation.getInstance(localEnumeration.nextElement());
                  if ("2.5.29.32.0".equals(((PolicyInformation)localObject).getPolicyIdentifier().getId()))
                  {
                    try
                    {
                      localObject = getQualifierSet(((PolicyInformation)localObject).getPolicyQualifiers());
                    }
                    catch (CertPathValidatorException paramArrayOfList)
                    {
                      throw new ExtCertPathValidatorException("Policy qualifier info set could not be built.", paramArrayOfList);
                    }
                    if (paramX509Certificate.getCriticalExtensionOIDs() == null) {
                      break label248;
                    }
                  }
                }
                catch (Exception paramArrayOfList)
                {
                  throw new AnnotatedException("Policy information cannot be decoded.", paramArrayOfList);
                }
              }
            }
            boolean bool = paramX509Certificate.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES);
            break label251;
            label248:
            bool = false;
            label251:
            paramX509Certificate = (PKIXPolicyNode)localPKIXPolicyNode2.getParent();
            if ("2.5.29.32.0".equals(paramX509Certificate.getValidPolicy()))
            {
              paramString = new PKIXPolicyNode(new ArrayList(), paramInt, (Set)paramMap.get(paramString), paramX509Certificate, (Set)localObject, paramString, bool);
              paramX509Certificate.addChild(paramString);
              paramArrayOfList[paramInt].add(paramString);
              return;
            }
          }
          catch (Exception paramArrayOfList)
          {
            throw new AnnotatedException("Certificate policies cannot be decoded.", paramArrayOfList);
          }
        }
      }
    }
  }
  
  protected static PKIXPolicyNode prepareNextCertB2(int paramInt, List[] paramArrayOfList, String paramString, PKIXPolicyNode paramPKIXPolicyNode)
  {
    Iterator localIterator = paramArrayOfList[paramInt].iterator();
    PKIXPolicyNode localPKIXPolicyNode1 = paramPKIXPolicyNode;
    while (localIterator.hasNext())
    {
      paramPKIXPolicyNode = (PKIXPolicyNode)localIterator.next();
      if (paramPKIXPolicyNode.getValidPolicy().equals(paramString))
      {
        ((PKIXPolicyNode)paramPKIXPolicyNode.getParent()).removeChild(paramPKIXPolicyNode);
        localIterator.remove();
        int i = paramInt - 1;
        for (paramPKIXPolicyNode = localPKIXPolicyNode1;; paramPKIXPolicyNode = localPKIXPolicyNode1)
        {
          localPKIXPolicyNode1 = paramPKIXPolicyNode;
          if (i < 0) {
            break;
          }
          List localList = paramArrayOfList[i];
          int j = 0;
          for (;;)
          {
            localPKIXPolicyNode1 = paramPKIXPolicyNode;
            if (j >= localList.size()) {
              break;
            }
            PKIXPolicyNode localPKIXPolicyNode2 = (PKIXPolicyNode)localList.get(j);
            localPKIXPolicyNode1 = paramPKIXPolicyNode;
            if (!localPKIXPolicyNode2.hasChildren())
            {
              paramPKIXPolicyNode = removePolicyNode(paramPKIXPolicyNode, paramArrayOfList, localPKIXPolicyNode2);
              localPKIXPolicyNode1 = paramPKIXPolicyNode;
              if (paramPKIXPolicyNode == null)
              {
                localPKIXPolicyNode1 = paramPKIXPolicyNode;
                break;
              }
            }
            j += 1;
            paramPKIXPolicyNode = localPKIXPolicyNode1;
          }
          i -= 1;
        }
      }
    }
    return localPKIXPolicyNode1;
  }
  
  protected static boolean processCertD1i(int paramInt, List[] paramArrayOfList, ASN1ObjectIdentifier paramASN1ObjectIdentifier, Set paramSet)
  {
    Object localObject = paramArrayOfList[(paramInt - 1)];
    int i = 0;
    while (i < ((List)localObject).size())
    {
      PKIXPolicyNode localPKIXPolicyNode = (PKIXPolicyNode)((List)localObject).get(i);
      if (localPKIXPolicyNode.getExpectedPolicies().contains(paramASN1ObjectIdentifier.getId()))
      {
        localObject = new HashSet();
        ((Set)localObject).add(paramASN1ObjectIdentifier.getId());
        paramASN1ObjectIdentifier = new PKIXPolicyNode(new ArrayList(), paramInt, (Set)localObject, localPKIXPolicyNode, paramSet, paramASN1ObjectIdentifier.getId(), false);
        localPKIXPolicyNode.addChild(paramASN1ObjectIdentifier);
        paramArrayOfList[paramInt].add(paramASN1ObjectIdentifier);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected static void processCertD1ii(int paramInt, List[] paramArrayOfList, ASN1ObjectIdentifier paramASN1ObjectIdentifier, Set paramSet)
  {
    Object localObject = paramArrayOfList[(paramInt - 1)];
    int i = 0;
    while (i < ((List)localObject).size())
    {
      PKIXPolicyNode localPKIXPolicyNode = (PKIXPolicyNode)((List)localObject).get(i);
      if ("2.5.29.32.0".equals(localPKIXPolicyNode.getValidPolicy()))
      {
        localObject = new HashSet();
        ((Set)localObject).add(paramASN1ObjectIdentifier.getId());
        paramASN1ObjectIdentifier = new PKIXPolicyNode(new ArrayList(), paramInt, (Set)localObject, localPKIXPolicyNode, paramSet, paramASN1ObjectIdentifier.getId(), false);
        localPKIXPolicyNode.addChild(paramASN1ObjectIdentifier);
        paramArrayOfList[paramInt].add(paramASN1ObjectIdentifier);
        return;
      }
      i += 1;
    }
  }
  
  protected static PKIXPolicyNode removePolicyNode(PKIXPolicyNode paramPKIXPolicyNode1, List[] paramArrayOfList, PKIXPolicyNode paramPKIXPolicyNode2)
  {
    PKIXPolicyNode localPKIXPolicyNode = (PKIXPolicyNode)paramPKIXPolicyNode2.getParent();
    if (paramPKIXPolicyNode1 == null) {
      return null;
    }
    if (localPKIXPolicyNode == null)
    {
      int i = 0;
      while (i < paramArrayOfList.length)
      {
        paramArrayOfList[i] = new ArrayList();
        i += 1;
      }
      return null;
    }
    localPKIXPolicyNode.removeChild(paramPKIXPolicyNode2);
    removePolicyNodeRecurse(paramArrayOfList, paramPKIXPolicyNode2);
    return paramPKIXPolicyNode1;
  }
  
  private static void removePolicyNodeRecurse(List[] paramArrayOfList, PKIXPolicyNode paramPKIXPolicyNode)
  {
    paramArrayOfList[paramPKIXPolicyNode.getDepth()].remove(paramPKIXPolicyNode);
    if (paramPKIXPolicyNode.hasChildren())
    {
      paramPKIXPolicyNode = paramPKIXPolicyNode.getChildren();
      while (paramPKIXPolicyNode.hasNext()) {
        removePolicyNodeRecurse(paramArrayOfList, (PKIXPolicyNode)paramPKIXPolicyNode.next());
      }
    }
  }
  
  protected static void verifyX509Certificate(X509Certificate paramX509Certificate, PublicKey paramPublicKey, String paramString)
    throws GeneralSecurityException
  {
    if (paramString == null)
    {
      paramX509Certificate.verify(paramPublicKey);
      return;
    }
    paramX509Certificate.verify(paramPublicKey, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\CertPathValidatorUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */