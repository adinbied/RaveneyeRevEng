package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertSelector;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.TargetInformation;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jcajce.PKIXCRLStore;
import org.bouncycastle.jcajce.PKIXCertStoreSelector.Builder;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters.Builder;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters.Builder;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.AttributeCertificateHolder;
import org.bouncycastle.x509.PKIXAttrCertChecker;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CertStoreSelector;

class RFC3281CertPathUtilities
{
  private static final String AUTHORITY_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();
  private static final String CRL_DISTRIBUTION_POINTS;
  private static final String NO_REV_AVAIL;
  private static final String TARGET_INFORMATION = X509Extensions.TargetInformation.getId();
  
  static
  {
    NO_REV_AVAIL = X509Extensions.NoRevAvail.getId();
    CRL_DISTRIBUTION_POINTS = X509Extensions.CRLDistributionPoints.getId();
  }
  
  protected static void additionalChecks(X509AttributeCertificate paramX509AttributeCertificate, Set paramSet1, Set paramSet2)
    throws CertPathValidatorException
  {
    Iterator localIterator = paramSet1.iterator();
    while (localIterator.hasNext())
    {
      paramSet1 = (String)localIterator.next();
      if (paramX509AttributeCertificate.getAttributes(paramSet1) != null)
      {
        paramX509AttributeCertificate = new StringBuilder();
        paramX509AttributeCertificate.append("Attribute certificate contains prohibited attribute: ");
        paramX509AttributeCertificate.append(paramSet1);
        paramX509AttributeCertificate.append(".");
        throw new CertPathValidatorException(paramX509AttributeCertificate.toString());
      }
    }
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      paramSet1 = (String)paramSet2.next();
      if (paramX509AttributeCertificate.getAttributes(paramSet1) == null)
      {
        paramX509AttributeCertificate = new StringBuilder();
        paramX509AttributeCertificate.append("Attribute certificate does not contain necessary attribute: ");
        paramX509AttributeCertificate.append(paramSet1);
        paramX509AttributeCertificate.append(".");
        throw new CertPathValidatorException(paramX509AttributeCertificate.toString());
      }
    }
  }
  
  private static void checkCRL(DistributionPoint paramDistributionPoint, X509AttributeCertificate paramX509AttributeCertificate, PKIXExtendedParameters paramPKIXExtendedParameters, Date paramDate, X509Certificate paramX509Certificate, CertStatus paramCertStatus, ReasonsMask paramReasonsMask, List paramList, JcaJceHelper paramJcaJceHelper)
    throws AnnotatedException
  {
    if (paramX509AttributeCertificate.getExtensionValue(X509Extensions.NoRevAvail.getId()) != null) {
      return;
    }
    Date localDate = new Date(System.currentTimeMillis());
    int i;
    if (paramDate.getTime() <= localDate.getTime())
    {
      paramX509Certificate = CertPathValidatorUtilities.getCompleteCRLs(paramDistributionPoint, paramX509AttributeCertificate, localDate, paramPKIXExtendedParameters).iterator();
      Object localObject1 = null;
      i = 0;
      if ((!paramX509Certificate.hasNext()) || (paramCertStatus.getCertStatus() != 11) || (paramReasonsMask.isAllReasons())) {}
    }
    for (;;)
    {
      try
      {
        X509CRL localX509CRL = (X509CRL)paramX509Certificate.next();
        ReasonsMask localReasonsMask = RFC3280CertPathUtilities.processCRLD(localX509CRL, paramDistributionPoint);
        boolean bool = localReasonsMask.hasNewReasons(paramReasonsMask);
        if (!bool) {
          break;
        }
        try
        {
          localObject2 = RFC3280CertPathUtilities.processCRLG(localX509CRL, RFC3280CertPathUtilities.processCRLF(localX509CRL, paramX509AttributeCertificate, null, null, paramPKIXExtendedParameters, paramList, paramJcaJceHelper));
          if (!paramPKIXExtendedParameters.isUseDeltasEnabled()) {
            break label321;
          }
          localObject2 = RFC3280CertPathUtilities.processCRLH(CertPathValidatorUtilities.getDeltaCRLs(localDate, localX509CRL, paramPKIXExtendedParameters.getCertStores(), paramPKIXExtendedParameters.getCRLStores()), (PublicKey)localObject2);
          if ((paramPKIXExtendedParameters.getValidityModel() != 1) && (paramX509AttributeCertificate.getNotAfter().getTime() < localX509CRL.getThisUpdate().getTime())) {
            throw new AnnotatedException("No valid CRL for current time found.");
          }
          RFC3280CertPathUtilities.processCRLB1(paramDistributionPoint, paramX509AttributeCertificate, localX509CRL);
          RFC3280CertPathUtilities.processCRLB2(paramDistributionPoint, paramX509AttributeCertificate, localX509CRL);
          RFC3280CertPathUtilities.processCRLC((X509CRL)localObject2, localX509CRL, paramPKIXExtendedParameters);
          RFC3280CertPathUtilities.processCRLI(paramDate, (X509CRL)localObject2, paramX509AttributeCertificate, paramCertStatus, paramPKIXExtendedParameters);
          RFC3280CertPathUtilities.processCRLJ(paramDate, localX509CRL, paramX509AttributeCertificate, paramCertStatus);
          if (paramCertStatus.getCertStatus() == 8) {
            paramCertStatus.setCertStatus(11);
          }
          paramReasonsMask.addReasons(localReasonsMask);
          i = 1;
        }
        catch (AnnotatedException localAnnotatedException1) {}
      }
      catch (AnnotatedException localAnnotatedException2) {}
      if (i != 0) {
        return;
      }
      throw localAnnotatedException2;
      throw new AnnotatedException("Validation time is in future.");
      label321:
      Object localObject2 = null;
    }
  }
  
  protected static void checkCRLs(X509AttributeCertificate paramX509AttributeCertificate, PKIXExtendedParameters paramPKIXExtendedParameters, X509Certificate paramX509Certificate, Date paramDate, List paramList, JcaJceHelper paramJcaJceHelper)
    throws CertPathValidatorException
  {
    if (paramPKIXExtendedParameters.isRevocationEnabled()) {
      if (paramX509AttributeCertificate.getExtensionValue(NO_REV_AVAIL) != null) {}
    }
    for (;;)
    {
      try
      {
        Object localObject1 = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509AttributeCertificate, CRL_DISTRIBUTION_POINTS));
        Object localObject2 = new ArrayList();
        try
        {
          ((List)localObject2).addAll(CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint((CRLDistPoint)localObject1, paramPKIXExtendedParameters.getNamedCRLStoreMap()));
          paramPKIXExtendedParameters = new PKIXExtendedParameters.Builder(paramPKIXExtendedParameters);
          localObject3 = ((List)localObject2).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramPKIXExtendedParameters.addCRLStore((PKIXCRLStore)localObject2);
            continue;
          }
          localPKIXExtendedParameters = paramPKIXExtendedParameters.build();
          localObject2 = new CertStatus();
          localObject3 = new ReasonsMask();
          if (localObject1 != null) {
            try
            {
              paramPKIXExtendedParameters = ((CRLDistPoint)localObject1).getDistributionPoints();
              j = 0;
              i = 0;
              try
              {
                if ((j < paramPKIXExtendedParameters.length) && (((CertStatus)localObject2).getCertStatus() == 11) && (!((ReasonsMask)localObject3).isAllReasons()))
                {
                  localObject1 = (PKIXExtendedParameters)localPKIXExtendedParameters.clone();
                  DistributionPoint localDistributionPoint = paramPKIXExtendedParameters[j];
                  try
                  {
                    checkCRL(localDistributionPoint, paramX509AttributeCertificate, (PKIXExtendedParameters)localObject1, paramDate, paramX509Certificate, (CertStatus)localObject2, (ReasonsMask)localObject3, paramList, paramJcaJceHelper);
                    j += 1;
                    i = 1;
                  }
                  catch (AnnotatedException paramPKIXExtendedParameters)
                  {
                    continue;
                  }
                }
                paramPKIXExtendedParameters = null;
              }
              catch (AnnotatedException paramPKIXExtendedParameters)
              {
                paramPKIXExtendedParameters = new AnnotatedException("No valid CRL for distribution point found.", paramPKIXExtendedParameters);
              }
              paramPKIXExtendedParameters = null;
            }
            catch (Exception paramX509AttributeCertificate)
            {
              throw new ExtCertPathValidatorException("Distribution points could not be read.", paramX509AttributeCertificate);
            }
          }
          i = 0;
          localObject1 = paramPKIXExtendedParameters;
          j = i;
          if (((CertStatus)localObject2).getCertStatus() == 11)
          {
            localObject1 = paramPKIXExtendedParameters;
            j = i;
            if (((ReasonsMask)localObject3).isAllReasons()) {}
          }
        }
        catch (AnnotatedException paramX509AttributeCertificate)
        {
          Object localObject3;
          PKIXExtendedParameters localPKIXExtendedParameters;
          int j;
          int i;
          throw new CertPathValidatorException("No additional CRL locations could be decoded from CRL distribution point extension.", paramX509AttributeCertificate);
        }
      }
      catch (AnnotatedException paramX509AttributeCertificate)
      {
        throw new CertPathValidatorException("CRL distribution point extension could not be read.", paramX509AttributeCertificate);
      }
      try
      {
        try
        {
          localObject1 = new ASN1InputStream(((X500Principal)paramX509AttributeCertificate.getIssuer().getPrincipals()[0]).getEncoded()).readObject();
          checkCRL(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, (ASN1Encodable)localObject1))), null, null), paramX509AttributeCertificate, (PKIXExtendedParameters)localPKIXExtendedParameters.clone(), paramDate, paramX509Certificate, (CertStatus)localObject2, (ReasonsMask)localObject3, paramList, paramJcaJceHelper);
          j = 1;
          localObject1 = paramPKIXExtendedParameters;
        }
        catch (Exception paramX509AttributeCertificate)
        {
          throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", paramX509AttributeCertificate);
        }
      }
      catch (AnnotatedException paramX509AttributeCertificate) {}
    }
    localObject1 = new AnnotatedException("No valid CRL for distribution point found.", paramX509AttributeCertificate);
    j = i;
    if (j != 0)
    {
      if (((CertStatus)localObject2).getCertStatus() == 11)
      {
        if ((!((ReasonsMask)localObject3).isAllReasons()) && (((CertStatus)localObject2).getCertStatus() == 11)) {
          ((CertStatus)localObject2).setCertStatus(12);
        }
        if (((CertStatus)localObject2).getCertStatus() != 12) {
          return;
        }
        throw new CertPathValidatorException("Attribute certificate status could not be determined.");
      }
      paramX509AttributeCertificate = new StringBuilder();
      paramX509AttributeCertificate.append("Attribute certificate revocation after ");
      paramX509AttributeCertificate.append(((CertStatus)localObject2).getRevocationDate());
      paramX509AttributeCertificate = paramX509AttributeCertificate.toString();
      paramPKIXExtendedParameters = new StringBuilder();
      paramPKIXExtendedParameters.append(paramX509AttributeCertificate);
      paramPKIXExtendedParameters.append(", reason: ");
      paramPKIXExtendedParameters.append(RFC3280CertPathUtilities.crlReasons[localObject2.getCertStatus()]);
      throw new CertPathValidatorException(paramPKIXExtendedParameters.toString());
    }
    throw new ExtCertPathValidatorException("No valid CRL found.", (Throwable)localObject1);
    if ((paramX509AttributeCertificate.getExtensionValue(CRL_DISTRIBUTION_POINTS) == null) && (paramX509AttributeCertificate.getExtensionValue(AUTHORITY_INFO_ACCESS) == null)) {
      return;
    }
    throw new CertPathValidatorException("No rev avail extension is set, but also an AC revocation pointer.");
  }
  
  protected static CertPath processAttrCert1(X509AttributeCertificate paramX509AttributeCertificate, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws CertPathValidatorException
  {
    Object localObject1 = new HashSet();
    Object localObject2 = paramX509AttributeCertificate.getHolder().getIssuer();
    int j = 0;
    int i;
    if (localObject2 != null)
    {
      localObject2 = new X509CertSelector();
      ((X509CertSelector)localObject2).setSerialNumber(paramX509AttributeCertificate.getHolder().getSerialNumber());
      localObject3 = paramX509AttributeCertificate.getHolder().getIssuer();
      i = 0;
      while (i < localObject3.length) {
        try
        {
          if ((localObject3[i] instanceof X500Principal)) {
            ((X509CertSelector)localObject2).setIssuer(((X500Principal)localObject3[i]).getEncoded());
          }
          ((Set)localObject1).addAll(CertPathValidatorUtilities.findCertificates(new PKIXCertStoreSelector.Builder((CertSelector)localObject2).build(), paramPKIXExtendedParameters.getCertStores()));
          i += 1;
        }
        catch (IOException paramX509AttributeCertificate)
        {
          throw new ExtCertPathValidatorException("Unable to encode X500 principal.", paramX509AttributeCertificate);
        }
        catch (AnnotatedException paramX509AttributeCertificate)
        {
          throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", paramX509AttributeCertificate);
        }
      }
      if (((Set)localObject1).isEmpty()) {
        throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
      }
    }
    if (paramX509AttributeCertificate.getHolder().getEntityNames() != null)
    {
      localObject2 = new X509CertStoreSelector();
      paramX509AttributeCertificate = paramX509AttributeCertificate.getHolder().getEntityNames();
      i = j;
      while (i < paramX509AttributeCertificate.length) {
        try
        {
          if ((paramX509AttributeCertificate[i] instanceof X500Principal)) {
            ((X509CertStoreSelector)localObject2).setIssuer(((X500Principal)paramX509AttributeCertificate[i]).getEncoded());
          }
          ((Set)localObject1).addAll(CertPathValidatorUtilities.findCertificates(new PKIXCertStoreSelector.Builder((CertSelector)localObject2).build(), paramPKIXExtendedParameters.getCertStores()));
          i += 1;
        }
        catch (IOException paramX509AttributeCertificate)
        {
          throw new ExtCertPathValidatorException("Unable to encode X500 principal.", paramX509AttributeCertificate);
        }
        catch (AnnotatedException paramX509AttributeCertificate)
        {
          throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", paramX509AttributeCertificate);
        }
      }
      if (((Set)localObject1).isEmpty()) {
        throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
      }
    }
    localObject2 = new PKIXExtendedParameters.Builder(paramPKIXExtendedParameters);
    Object localObject3 = ((Set)localObject1).iterator();
    paramPKIXExtendedParameters = null;
    paramX509AttributeCertificate = null;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = new X509CertStoreSelector();
      ((X509CertStoreSelector)localObject1).setCertificate((X509Certificate)((Iterator)localObject3).next());
      ((PKIXExtendedParameters.Builder)localObject2).setTargetConstraints(new PKIXCertStoreSelector.Builder((CertSelector)localObject1).build());
      try
      {
        localObject1 = CertPathBuilder.getInstance("PKIX", "BC");
        try
        {
          localObject1 = ((CertPathBuilder)localObject1).build(new PKIXExtendedBuilderParameters.Builder(((PKIXExtendedParameters.Builder)localObject2).build()).build());
          paramX509AttributeCertificate = (X509AttributeCertificate)localObject1;
        }
        catch (InvalidAlgorithmParameterException paramX509AttributeCertificate)
        {
          throw new RuntimeException(paramX509AttributeCertificate.getMessage());
        }
        catch (CertPathBuilderException paramPKIXExtendedParameters)
        {
          paramPKIXExtendedParameters = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", paramPKIXExtendedParameters);
        }
      }
      catch (NoSuchAlgorithmException paramX509AttributeCertificate)
      {
        throw new ExtCertPathValidatorException("Support class could not be created.", paramX509AttributeCertificate);
      }
      catch (NoSuchProviderException paramX509AttributeCertificate)
      {
        throw new ExtCertPathValidatorException("Support class could not be created.", paramX509AttributeCertificate);
      }
    }
    if (paramPKIXExtendedParameters == null) {
      return paramX509AttributeCertificate.getCertPath();
    }
    throw paramPKIXExtendedParameters;
  }
  
  /* Error */
  protected static java.security.cert.CertPathValidatorResult processAttrCert2(CertPath paramCertPath, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws CertPathValidatorException
  {
    // Byte code:
    //   0: ldc_w 433
    //   3: ldc_w 435
    //   6: invokestatic 472	java/security/cert/CertPathValidator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/cert/CertPathValidator;
    //   9: astore_2
    //   10: aload_2
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 476	java/security/cert/CertPathValidator:validate	(Ljava/security/cert/CertPath;Ljava/security/cert/CertPathParameters;)Ljava/security/cert/CertPathValidatorResult;
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: astore_0
    //   20: new 451	java/lang/RuntimeException
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual 454	java/security/InvalidAlgorithmParameterException:getMessage	()Ljava/lang/String;
    //   28: invokespecial 455	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   31: athrow
    //   32: astore_0
    //   33: new 280	org/bouncycastle/jce/exception/ExtCertPathValidatorException
    //   36: dup
    //   37: ldc_w 478
    //   40: aload_0
    //   41: invokespecial 283	org/bouncycastle/jce/exception/ExtCertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: athrow
    //   45: astore_0
    //   46: new 280	org/bouncycastle/jce/exception/ExtCertPathValidatorException
    //   49: dup
    //   50: ldc_w 459
    //   53: aload_0
    //   54: invokespecial 283	org/bouncycastle/jce/exception/ExtCertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: athrow
    //   58: astore_0
    //   59: new 280	org/bouncycastle/jce/exception/ExtCertPathValidatorException
    //   62: dup
    //   63: ldc_w 459
    //   66: aload_0
    //   67: invokespecial 283	org/bouncycastle/jce/exception/ExtCertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramCertPath	CertPath
    //   0	71	1	paramPKIXExtendedParameters	PKIXExtendedParameters
    //   9	2	2	localCertPathValidator	java.security.cert.CertPathValidator
    // Exception table:
    //   from	to	target	type
    //   10	17	19	java/security/InvalidAlgorithmParameterException
    //   10	17	32	java/security/cert/CertPathValidatorException
    //   0	10	45	java/security/NoSuchAlgorithmException
    //   0	10	58	java/security/NoSuchProviderException
  }
  
  protected static void processAttrCert3(X509Certificate paramX509Certificate, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws CertPathValidatorException
  {
    if ((paramX509Certificate.getKeyUsage() != null) && (paramX509Certificate.getKeyUsage()[0] == 0) && (paramX509Certificate.getKeyUsage()[1] == 0)) {
      throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
    }
    if (paramX509Certificate.getBasicConstraints() == -1) {
      return;
    }
    throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
  }
  
  protected static void processAttrCert4(X509Certificate paramX509Certificate, Set paramSet)
    throws CertPathValidatorException
  {
    paramSet = paramSet.iterator();
    for (int i = 0; paramSet.hasNext(); i = 1)
    {
      label9:
      TrustAnchor localTrustAnchor = (TrustAnchor)paramSet.next();
      if ((!paramX509Certificate.getSubjectX500Principal().getName("RFC2253").equals(localTrustAnchor.getCAName())) && (!paramX509Certificate.equals(localTrustAnchor.getTrustedCert()))) {
        break label9;
      }
    }
    if (i != 0) {
      return;
    }
    throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
  }
  
  protected static void processAttrCert5(X509AttributeCertificate paramX509AttributeCertificate, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws CertPathValidatorException
  {
    try
    {
      paramX509AttributeCertificate.checkValidity(CertPathValidatorUtilities.getValidDate(paramPKIXExtendedParameters));
      return;
    }
    catch (CertificateNotYetValidException paramX509AttributeCertificate)
    {
      throw new ExtCertPathValidatorException("Attribute certificate is not valid.", paramX509AttributeCertificate);
    }
    catch (CertificateExpiredException paramX509AttributeCertificate)
    {
      throw new ExtCertPathValidatorException("Attribute certificate is not valid.", paramX509AttributeCertificate);
    }
  }
  
  protected static void processAttrCert7(X509AttributeCertificate paramX509AttributeCertificate, CertPath paramCertPath1, CertPath paramCertPath2, PKIXExtendedParameters paramPKIXExtendedParameters, Set paramSet)
    throws CertPathValidatorException
  {
    paramPKIXExtendedParameters = paramX509AttributeCertificate.getCriticalExtensionOIDs();
    if (paramPKIXExtendedParameters.contains(TARGET_INFORMATION)) {
      try
      {
        TargetInformation.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509AttributeCertificate, TARGET_INFORMATION));
      }
      catch (IllegalArgumentException paramX509AttributeCertificate)
      {
        throw new ExtCertPathValidatorException("Target information extension could not be read.", paramX509AttributeCertificate);
      }
      catch (AnnotatedException paramX509AttributeCertificate)
      {
        throw new ExtCertPathValidatorException("Target information extension could not be read.", paramX509AttributeCertificate);
      }
    }
    paramPKIXExtendedParameters.remove(TARGET_INFORMATION);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      ((PKIXAttrCertChecker)paramSet.next()).check(paramX509AttributeCertificate, paramCertPath1, paramCertPath2, paramPKIXExtendedParameters);
    }
    if (paramPKIXExtendedParameters.isEmpty()) {
      return;
    }
    paramX509AttributeCertificate = new StringBuilder();
    paramX509AttributeCertificate.append("Attribute certificate contains unsupported critical extensions: ");
    paramX509AttributeCertificate.append(paramPKIXExtendedParameters);
    throw new CertPathValidatorException(paramX509AttributeCertificate.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\RFC3281CertPathUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */