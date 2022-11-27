package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
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
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
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
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jce.X509LDAPCertStoreParameters.Builder;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.PKIXPolicyNode;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

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
  
  protected static void addAdditionalStoreFromLocation(String paramString, ExtendedPKIXParameters paramExtendedPKIXParameters)
  {
    if (paramExtendedPKIXParameters.isAdditionalLocationsEnabled()) {}
    try
    {
      if (!paramString.startsWith("ldap://")) {
        break label183;
      }
      String str = paramString.substring(7);
      paramString = null;
      StringBuilder localStringBuilder;
      if (str.indexOf("/") != -1)
      {
        paramString = str.substring(str.indexOf("/"));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ldap://");
        localStringBuilder.append(str.substring(0, str.indexOf("/")));
        str = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ldap://");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
      }
      paramString = new X509LDAPCertStoreParameters.Builder(str, paramString).build();
      paramExtendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CERTIFICATE/LDAP", paramString, "BC"));
      paramExtendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CRL/LDAP", paramString, "BC"));
      paramExtendedPKIXParameters.addAdditionalStore(X509Store.getInstance("ATTRIBUTECERTIFICATE/LDAP", paramString, "BC"));
      paramExtendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CERTIFICATEPAIR/LDAP", paramString, "BC"));
      return;
    }
    catch (Exception paramString)
    {
      label183:
      for (;;) {}
    }
    throw new RuntimeException("Exception adding X.509 stores.");
  }
  
  protected static void addAdditionalStoresFromAltNames(X509Certificate paramX509Certificate, ExtendedPKIXParameters paramExtendedPKIXParameters)
    throws CertificateParsingException
  {
    if (paramX509Certificate.getIssuerAlternativeNames() != null)
    {
      paramX509Certificate = paramX509Certificate.getIssuerAlternativeNames().iterator();
      while (paramX509Certificate.hasNext())
      {
        List localList = (List)paramX509Certificate.next();
        if (localList.get(0).equals(Integers.valueOf(6))) {
          addAdditionalStoreFromLocation((String)localList.get(1), paramExtendedPKIXParameters);
        }
      }
    }
  }
  
  protected static void addAdditionalStoresFromCRLDistributionPoint(CRLDistPoint paramCRLDistPoint, ExtendedPKIXParameters paramExtendedPKIXParameters)
    throws AnnotatedException
  {
    if (paramCRLDistPoint != null) {
      try
      {
        paramCRLDistPoint = paramCRLDistPoint.getDistributionPoints();
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
              if (localObject[j].getTagNo() == 6) {
                addAdditionalStoreFromLocation(DERIA5String.getInstance(localObject[j].getName()).getString(), paramExtendedPKIXParameters);
              }
              j += 1;
            }
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramCRLDistPoint)
      {
        throw new AnnotatedException("Distribution points could not be read.", paramCRLDistPoint);
      }
    }
  }
  
  protected static Collection findCertificates(PKIXCertStoreSelector paramPKIXCertStoreSelector, List paramList)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof Store))
      {
        localObject = (Store)localObject;
        try
        {
          localHashSet.addAll(((Store)localObject).getMatches(paramPKIXCertStoreSelector));
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
          localHashSet.addAll(PKIXCertStoreSelector.getCertificates(paramPKIXCertStoreSelector, (CertStore)localObject));
        }
        catch (CertStoreException paramPKIXCertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from certificate store.", paramPKIXCertStoreSelector);
        }
      }
    }
    return localHashSet;
  }
  
  protected static Collection findCertificates(X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector, List paramList)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof X509Store))
      {
        localObject = (X509Store)localObject;
        try
        {
          localHashSet.addAll(((X509Store)localObject).getMatches(paramX509AttributeCertStoreSelector));
        }
        catch (StoreException paramX509AttributeCertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from X.509 store.", paramX509AttributeCertStoreSelector);
        }
      }
    }
    return localHashSet;
  }
  
  protected static Collection findCertificates(X509CertStoreSelector paramX509CertStoreSelector, List paramList)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramList.iterator();
    CertificateFactory localCertificateFactory = new CertificateFactory();
    while (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if ((paramList instanceof Store))
      {
        paramList = (Store)paramList;
        try
        {
          Iterator localIterator2 = paramList.getMatches(paramX509CertStoreSelector).iterator();
          if (!localIterator2.hasNext()) {
            continue;
          }
          paramList = localIterator2.next();
          if ((paramList instanceof Encodable)) {
            paramList = localCertificateFactory.engineGenerateCertificate(new ByteArrayInputStream(((Encodable)paramList).getEncoded()));
          }
          while ((paramList instanceof Certificate))
          {
            localHashSet.add(paramList);
            break;
          }
          throw new AnnotatedException("Unknown object found in certificate store.");
        }
        catch (CertificateException paramX509CertStoreSelector)
        {
          throw new AnnotatedException("Problem while extracting certificates from X.509 store.", paramX509CertStoreSelector);
        }
        catch (IOException paramX509CertStoreSelector)
        {
          throw new AnnotatedException("Problem while extracting certificates from X.509 store.", paramX509CertStoreSelector);
        }
        catch (StoreException paramX509CertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from X.509 store.", paramX509CertStoreSelector);
        }
      }
      else
      {
        paramList = (CertStore)paramList;
        try
        {
          localHashSet.addAll(paramList.getCertificates(paramX509CertStoreSelector));
        }
        catch (CertStoreException paramX509CertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from certificate store.", paramX509CertStoreSelector);
        }
      }
    }
    return localHashSet;
  }
  
  /* Error */
  static Collection findIssuerCerts(X509Certificate paramX509Certificate, List paramList1, List paramList2)
    throws AnnotatedException
  {
    // Byte code:
    //   0: new 396	java/security/cert/X509CertSelector
    //   3: dup
    //   4: invokespecial 397	java/security/cert/X509CertSelector:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokevirtual 401	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   13: invokevirtual 404	javax/security/auth/x500/X500Principal:getEncoded	()[B
    //   16: invokevirtual 407	java/security/cert/X509CertSelector:setSubject	([B)V
    //   19: new 409	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 412	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder:<init>	(Ljava/security/cert/CertSelector;)V
    //   27: invokevirtual 415	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder:build	()Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;
    //   30: astore_3
    //   31: new 328	java/util/HashSet
    //   34: dup
    //   35: invokespecial 329	java/util/HashSet:<init>	()V
    //   38: astore_0
    //   39: new 417	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 418	java/util/ArrayList:<init>	()V
    //   46: astore 4
    //   48: aload 4
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 420	org/bouncycastle/x509/CertPathValidatorUtilities:findCertificates	(Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;Ljava/util/List;)Ljava/util/Collection;
    //   55: invokeinterface 421 2 0
    //   60: pop
    //   61: aload 4
    //   63: aload_3
    //   64: aload_2
    //   65: invokestatic 420	org/bouncycastle/x509/CertPathValidatorUtilities:findCertificates	(Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;Ljava/util/List;)Ljava/util/Collection;
    //   68: invokeinterface 421 2 0
    //   73: pop
    //   74: aload 4
    //   76: invokeinterface 330 1 0
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 243 1 0
    //   88: ifeq +22 -> 110
    //   91: aload_0
    //   92: aload_1
    //   93: invokeinterface 247 1 0
    //   98: checkcast 228	java/security/cert/X509Certificate
    //   101: invokeinterface 382 2 0
    //   106: pop
    //   107: goto -25 -> 82
    //   110: aload_0
    //   111: areturn
    //   112: astore_0
    //   113: new 270	org/bouncycastle/jce/provider/AnnotatedException
    //   116: dup
    //   117: ldc_w 423
    //   120: aload_0
    //   121: invokespecial 320	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: astore_0
    //   126: new 270	org/bouncycastle/jce/provider/AnnotatedException
    //   129: dup
    //   130: ldc_w 425
    //   133: aload_0
    //   134: invokespecial 320	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramX509Certificate	X509Certificate
    //   0	138	1	paramList1	List
    //   0	138	2	paramList2	List
    //   7	57	3	localObject	Object
    //   46	29	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   39	82	112	org/bouncycastle/jce/provider/AnnotatedException
    //   8	19	125	java/io/IOException
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
    X500Principal localX500Principal = getEncodedIssuerPrincipal(paramX509Certificate);
    for (;;)
    {
      try
      {
        localX509CertSelector.setSubject(localX500Principal.getEncoded());
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
        if (localX500Principal.equals(new X500Principal(localTrustAnchor2.getCAName()))) {
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
  
  protected static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey paramPublicKey)
    throws CertPathValidatorException
  {
    try
    {
      paramPublicKey = SubjectPublicKeyInfo.getInstance(new ASN1InputStream(paramPublicKey.getEncoded()).readObject()).getAlgorithmId();
      return paramPublicKey;
    }
    catch (Exception paramPublicKey)
    {
      throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", paramPublicKey);
    }
  }
  
  protected static void getCRLIssuersFromDistributionPoint(DistributionPoint paramDistributionPoint, Collection paramCollection, X509CRLSelector paramX509CRLSelector, ExtendedPKIXParameters paramExtendedPKIXParameters)
    throws AnnotatedException
  {
    paramExtendedPKIXParameters = new ArrayList();
    if (paramDistributionPoint.getCRLIssuer() != null)
    {
      paramDistributionPoint = paramDistributionPoint.getCRLIssuer().getNames();
      int i = 0;
      while (i < paramDistributionPoint.length)
      {
        if (paramDistributionPoint[i].getTagNo() == 4) {
          try
          {
            paramExtendedPKIXParameters.add(new X500Principal(paramDistributionPoint[i].getName().toASN1Primitive().getEncoded()));
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
        paramExtendedPKIXParameters.add((X500Principal)paramDistributionPoint.next());
      }
      paramDistributionPoint = paramExtendedPKIXParameters.iterator();
      while (paramDistributionPoint.hasNext()) {
        try
        {
          paramX509CRLSelector.addIssuerName(((X500Principal)paramDistributionPoint.next()).getEncoded());
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
      boolean bool = isIndirectCRL(paramX509CRL);
      if (bool)
      {
        X509CRLEntry localX509CRLEntry = paramX509CRL.getRevokedCertificate(getSerialNumber(paramObject));
        if (localX509CRLEntry == null) {
          return;
        }
        X500Principal localX500Principal2 = localX509CRLEntry.getCertificateIssuer();
        X500Principal localX500Principal1 = localX500Principal2;
        if (localX500Principal2 == null) {
          localX500Principal1 = getIssuerPrincipal(paramX509CRL);
        }
        paramX509CRL = localX509CRLEntry;
        if (getEncodedIssuerPrincipal(paramObject).equals(localX500Principal1)) {}
      }
      else
      {
        if (!getEncodedIssuerPrincipal(paramObject).equals(getIssuerPrincipal(paramX509CRL))) {
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
          paramObject = ASN1Enumerated.getInstance(getExtensionValue(paramX509CRL, org.bouncycastle.asn1.x509.X509Extension.reasonCode.getId()));
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
  
  protected static Set getCompleteCRLs(DistributionPoint paramDistributionPoint, Object paramObject, Date paramDate, ExtendedPKIXParameters paramExtendedPKIXParameters)
    throws AnnotatedException
  {
    X509CRLStoreSelector localX509CRLStoreSelector = new X509CRLStoreSelector();
    try
    {
      HashSet localHashSet = new HashSet();
      if ((paramObject instanceof X509AttributeCertificate)) {}
      for (Object localObject = ((X509AttributeCertificate)paramObject).getIssuer().getPrincipals()[0];; localObject = getEncodedIssuerPrincipal(paramObject))
      {
        localHashSet.add(localObject);
        break;
      }
      getCRLIssuersFromDistributionPoint(paramDistributionPoint, localHashSet, localX509CRLStoreSelector, paramExtendedPKIXParameters);
      if ((paramObject instanceof X509Certificate)) {
        localX509CRLStoreSelector.setCertificateChecking((X509Certificate)paramObject);
      } else if ((paramObject instanceof X509AttributeCertificate)) {
        localX509CRLStoreSelector.setAttrCertificateChecking((X509AttributeCertificate)paramObject);
      }
      localX509CRLStoreSelector.setCompleteCRLEnabled(true);
      paramDistributionPoint = CRL_UTIL.findCRLs(localX509CRLStoreSelector, paramExtendedPKIXParameters, paramDate);
      if (paramDistributionPoint.isEmpty())
      {
        if ((paramObject instanceof X509AttributeCertificate))
        {
          paramDistributionPoint = (X509AttributeCertificate)paramObject;
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("No CRLs found for issuer \"");
          ((StringBuilder)paramObject).append(paramDistributionPoint.getIssuer().getPrincipals()[0]);
          ((StringBuilder)paramObject).append("\"");
          throw new AnnotatedException(((StringBuilder)paramObject).toString());
        }
        paramDistributionPoint = (X509Certificate)paramObject;
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("No CRLs found for issuer \"");
        ((StringBuilder)paramObject).append(paramDistributionPoint.getIssuerX500Principal());
        ((StringBuilder)paramObject).append("\"");
        throw new AnnotatedException(((StringBuilder)paramObject).toString());
      }
      return paramDistributionPoint;
    }
    catch (AnnotatedException paramDistributionPoint)
    {
      throw new AnnotatedException("Could not get issuer information from distribution point.", paramDistributionPoint);
    }
  }
  
  /* Error */
  protected static Set getDeltaCRLs(Date paramDate, ExtendedPKIXParameters paramExtendedPKIXParameters, X509CRL paramX509CRL)
    throws AnnotatedException
  {
    // Byte code:
    //   0: new 603	org/bouncycastle/x509/X509CRLStoreSelector
    //   3: dup
    //   4: invokespecial 604	org/bouncycastle/x509/X509CRLStoreSelector:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_2
    //   12: invokestatic 549	org/bouncycastle/x509/CertPathValidatorUtilities:getIssuerPrincipal	(Ljava/security/cert/X509CRL;)Ljavax/security/auth/x500/X500Principal;
    //   15: invokevirtual 404	javax/security/auth/x500/X500Principal:getEncoded	()[B
    //   18: invokevirtual 649	org/bouncycastle/x509/X509CRLStoreSelector:addIssuerName	([B)V
    //   21: aload_2
    //   22: getstatic 119	org/bouncycastle/x509/CertPathValidatorUtilities:CRL_NUMBER	Ljava/lang/String;
    //   25: invokestatic 561	org/bouncycastle/x509/CertPathValidatorUtilities:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   28: astore_3
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_3
    //   33: ifnull +14 -> 47
    //   36: aload_3
    //   37: invokestatic 654	org/bouncycastle/asn1/ASN1Integer:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1Integer;
    //   40: invokevirtual 657	org/bouncycastle/asn1/ASN1Integer:getPositiveValue	()Ljava/math/BigInteger;
    //   43: astore_3
    //   44: goto +5 -> 49
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_2
    //   50: getstatic 89	org/bouncycastle/x509/CertPathValidatorUtilities:ISSUING_DISTRIBUTION_POINT	Ljava/lang/String;
    //   53: invokevirtual 660	java/security/cert/X509CRL:getExtensionValue	(Ljava/lang/String;)[B
    //   56: astore 6
    //   58: aload_3
    //   59: ifnonnull +9 -> 68
    //   62: aload 4
    //   64: astore_2
    //   65: goto +12 -> 77
    //   68: aload_3
    //   69: lconst_1
    //   70: invokestatic 663	java/math/BigInteger:valueOf	(J)Ljava/math/BigInteger;
    //   73: invokevirtual 666	java/math/BigInteger:add	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   76: astore_2
    //   77: aload 5
    //   79: aload_2
    //   80: invokevirtual 670	org/bouncycastle/x509/X509CRLStoreSelector:setMinCRLNumber	(Ljava/math/BigInteger;)V
    //   83: aload 5
    //   85: aload 6
    //   87: invokevirtual 673	org/bouncycastle/x509/X509CRLStoreSelector:setIssuingDistributionPoint	([B)V
    //   90: aload 5
    //   92: iconst_1
    //   93: invokevirtual 676	org/bouncycastle/x509/X509CRLStoreSelector:setIssuingDistributionPointEnabled	(Z)V
    //   96: aload 5
    //   98: aload_3
    //   99: invokevirtual 679	org/bouncycastle/x509/X509CRLStoreSelector:setMaxBaseCRLNumber	(Ljava/math/BigInteger;)V
    //   102: getstatic 40	org/bouncycastle/x509/CertPathValidatorUtilities:CRL_UTIL	Lorg/bouncycastle/x509/PKIXCRLUtil;
    //   105: aload 5
    //   107: aload_1
    //   108: aload_0
    //   109: invokevirtual 634	org/bouncycastle/x509/PKIXCRLUtil:findCRLs	(Lorg/bouncycastle/x509/X509CRLStoreSelector;Lorg/bouncycastle/x509/ExtendedPKIXParameters;Ljava/util/Date;)Ljava/util/Set;
    //   112: astore_1
    //   113: new 328	java/util/HashSet
    //   116: dup
    //   117: invokespecial 329	java/util/HashSet:<init>	()V
    //   120: astore_0
    //   121: aload_1
    //   122: invokeinterface 437 1 0
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 243 1 0
    //   134: ifeq +31 -> 165
    //   137: aload_1
    //   138: invokeinterface 247 1 0
    //   143: checkcast 536	java/security/cert/X509CRL
    //   146: astore_2
    //   147: aload_2
    //   148: invokestatic 682	org/bouncycastle/x509/CertPathValidatorUtilities:isDeltaCRL	(Ljava/security/cert/X509CRL;)Z
    //   151: ifeq -23 -> 128
    //   154: aload_0
    //   155: aload_2
    //   156: invokeinterface 382 2 0
    //   161: pop
    //   162: goto -34 -> 128
    //   165: aload_0
    //   166: areturn
    //   167: astore_0
    //   168: new 270	org/bouncycastle/jce/provider/AnnotatedException
    //   171: dup
    //   172: ldc_w 684
    //   175: aload_0
    //   176: invokespecial 320	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: athrow
    //   180: astore_0
    //   181: new 270	org/bouncycastle/jce/provider/AnnotatedException
    //   184: dup
    //   185: ldc_w 686
    //   188: aload_0
    //   189: invokespecial 320	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: athrow
    //   193: astore_0
    //   194: new 270	org/bouncycastle/jce/provider/AnnotatedException
    //   197: dup
    //   198: ldc_w 688
    //   201: aload_0
    //   202: invokespecial 320	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramDate	Date
    //   0	206	1	paramExtendedPKIXParameters	ExtendedPKIXParameters
    //   0	206	2	paramX509CRL	X509CRL
    //   28	71	3	localObject1	Object
    //   30	33	4	localObject2	Object
    //   7	99	5	localX509CRLStoreSelector	X509CRLStoreSelector
    //   56	30	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   49	58	167	java/lang/Exception
    //   21	29	180	java/lang/Exception
    //   36	44	180	java/lang/Exception
    //   9	21	193	java/io/IOException
  }
  
  protected static X500Principal getEncodedIssuerPrincipal(Object paramObject)
  {
    if ((paramObject instanceof X509Certificate)) {
      return ((X509Certificate)paramObject).getIssuerX500Principal();
    }
    return (X500Principal)((X509AttributeCertificate)paramObject).getIssuer().getPrincipals()[0];
  }
  
  protected static ASN1Primitive getExtensionValue(java.security.cert.X509Extension paramX509Extension, String paramString)
    throws AnnotatedException
  {
    paramX509Extension = paramX509Extension.getExtensionValue(paramString);
    if (paramX509Extension == null) {
      return null;
    }
    return getObject(paramString, paramX509Extension);
  }
  
  protected static X500Principal getIssuerPrincipal(X509CRL paramX509CRL)
  {
    return paramX509CRL.getIssuerX500Principal();
  }
  
  protected static PublicKey getNextWorkingKey(List paramList, int paramInt)
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
        break label169;
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
      paramList = KeyFactory.getInstance("DSA", "BC").generatePublic(paramList);
      return paramList;
    }
    catch (Exception paramList)
    {
      throw new RuntimeException(paramList.getMessage());
    }
    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
    label169:
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
    if ((paramObject instanceof X509Certificate)) {
      return ((X509Certificate)paramObject).getSerialNumber();
    }
    return ((X509AttributeCertificate)paramObject).getSerialNumber();
  }
  
  protected static X500Principal getSubjectPrincipal(X509Certificate paramX509Certificate)
  {
    return paramX509Certificate.getSubjectX500Principal();
  }
  
  protected static Date getValidCertDateFromValidityModel(ExtendedPKIXParameters paramExtendedPKIXParameters, CertPath paramCertPath, int paramInt)
    throws AnnotatedException
  {
    if (paramExtendedPKIXParameters.getValidityModel() == 1)
    {
      if (paramInt <= 0) {
        return getValidDate(paramExtendedPKIXParameters);
      }
      paramInt -= 1;
      if (paramInt == 0) {
        paramExtendedPKIXParameters = null;
      }
    }
    try
    {
      byte[] arrayOfByte = ((X509Certificate)paramCertPath.getCertificates().get(paramInt)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
      if (arrayOfByte != null) {
        paramExtendedPKIXParameters = ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(arrayOfByte));
      }
      if (paramExtendedPKIXParameters != null) {
        try
        {
          paramExtendedPKIXParameters = paramExtendedPKIXParameters.getDate();
          return paramExtendedPKIXParameters;
        }
        catch (ParseException paramExtendedPKIXParameters)
        {
          throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", paramExtendedPKIXParameters);
        }
      }
      return ((X509Certificate)paramCertPath.getCertificates().get(paramInt)).getNotBefore();
    }
    catch (IOException paramExtendedPKIXParameters)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException paramExtendedPKIXParameters)
    {
      for (;;) {}
    }
    throw new AnnotatedException("Date of cert gen extension could not be read.");
    throw new AnnotatedException("Date of cert gen extension could not be read.");
    return getValidDate(paramExtendedPKIXParameters);
  }
  
  protected static Date getValidDate(PKIXParameters paramPKIXParameters)
  {
    Date localDate = paramPKIXParameters.getDate();
    paramPKIXParameters = localDate;
    if (localDate == null) {
      paramPKIXParameters = new Date();
    }
    return paramPKIXParameters;
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
    return paramX509CRL.contains(Extension.deltaCRLIndicator.getId());
  }
  
  static boolean isIndirectCRL(X509CRL paramX509CRL)
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception reading IssuingDistributionPoint: ");
      localStringBuilder.append(paramX509CRL);
      throw new CRLException(localStringBuilder.toString());
    }
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
        localPKIXPolicyNode1.setExpectedPolicies((Set)paramMap.get(paramString));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\CertPathValidatorUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */