package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters.Builder;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi
  extends CertPathValidatorSpi
{
  private final JcaJceHelper helper = new BCJcaJceHelper();
  
  public CertPathValidatorResult engineValidate(CertPath paramCertPath, CertPathParameters paramCertPathParameters)
    throws CertPathValidatorException, InvalidAlgorithmParameterException
  {
    Object localObject1;
    if ((paramCertPathParameters instanceof PKIXParameters))
    {
      localObject1 = new PKIXExtendedParameters.Builder((PKIXParameters)paramCertPathParameters);
      if ((paramCertPathParameters instanceof ExtendedPKIXParameters))
      {
        paramCertPathParameters = (ExtendedPKIXParameters)paramCertPathParameters;
        ((PKIXExtendedParameters.Builder)localObject1).setUseDeltasEnabled(paramCertPathParameters.isUseDeltasEnabled());
        ((PKIXExtendedParameters.Builder)localObject1).setValidityModel(paramCertPathParameters.getValidityModel());
      }
      paramCertPathParameters = ((PKIXExtendedParameters.Builder)localObject1).build();
    }
    else if ((paramCertPathParameters instanceof PKIXExtendedBuilderParameters))
    {
      paramCertPathParameters = ((PKIXExtendedBuilderParameters)paramCertPathParameters).getBaseParameters();
    }
    else
    {
      if (!(paramCertPathParameters instanceof PKIXExtendedParameters)) {
        break label1389;
      }
      paramCertPathParameters = (PKIXExtendedParameters)paramCertPathParameters;
    }
    if (paramCertPathParameters.getTrustAnchors() != null)
    {
      Object localObject4 = paramCertPath.getCertificates();
      int i1 = ((List)localObject4).size();
      if (!((List)localObject4).isEmpty())
      {
        Set localSet = paramCertPathParameters.getInitialPolicies();
        try
        {
          Object localObject3 = CertPathValidatorUtilities.findTrustAnchor((X509Certificate)((List)localObject4).get(((List)localObject4).size() - 1), paramCertPathParameters.getTrustAnchors(), paramCertPathParameters.getSigProvider());
          if (localObject3 != null)
          {
            PKIXExtendedParameters localPKIXExtendedParameters = new PKIXExtendedParameters.Builder(paramCertPathParameters).setTrustAnchor((TrustAnchor)localObject3).build();
            int j = i1 + 1;
            Object localObject5 = new ArrayList[j];
            int i = 0;
            while (i < j)
            {
              localObject5[i] = new ArrayList();
              i += 1;
            }
            paramCertPathParameters = new HashSet();
            paramCertPathParameters.add("2.5.29.32.0");
            Object localObject2 = new PKIXPolicyNode(new ArrayList(), 0, paramCertPathParameters, null, new HashSet(), "2.5.29.32.0", false);
            localObject5[0].add(localObject2);
            PKIXNameConstraintValidator localPKIXNameConstraintValidator = new PKIXNameConstraintValidator();
            HashSet localHashSet = new HashSet();
            if (localPKIXExtendedParameters.isExplicitPolicyRequired()) {
              i = 0;
            } else {
              i = j;
            }
            int k;
            if (localPKIXExtendedParameters.isAnyPolicyInhibited()) {
              k = 0;
            } else {
              k = j;
            }
            if (localPKIXExtendedParameters.isPolicyMappingInhibited()) {
              j = 0;
            }
            Object localObject7 = ((TrustAnchor)localObject3).getTrustedCert();
            if (localObject7 != null) {}
            try
            {
              paramCertPathParameters = PrincipalUtils.getSubjectPrincipal((X509Certificate)localObject7);
              localObject1 = ((X509Certificate)localObject7).getPublicKey();
              break label385;
              paramCertPathParameters = PrincipalUtils.getCA((TrustAnchor)localObject3);
              localObject1 = ((TrustAnchor)localObject3).getCAPublicKey();
              try
              {
                label385:
                Object localObject6 = CertPathValidatorUtilities.getAlgorithmIdentifier((PublicKey)localObject1);
                ((AlgorithmIdentifier)localObject6).getAlgorithm();
                ((AlgorithmIdentifier)localObject6).getParameters();
                if ((localPKIXExtendedParameters.getTargetConstraints() != null) && (!localPKIXExtendedParameters.getTargetConstraints().match((X509Certificate)((List)localObject4).get(0)))) {
                  throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, paramCertPath, 0);
                }
                List localList = localPKIXExtendedParameters.getCertPathCheckers();
                localObject6 = localList.iterator();
                while (((Iterator)localObject6).hasNext()) {
                  ((PKIXCertPathChecker)((Iterator)localObject6).next()).init(false);
                }
                int i2 = ((List)localObject4).size();
                int n = i1;
                localObject6 = null;
                int m = j;
                j = k;
                i2 -= 1;
                k = i;
                Object localObject9 = localObject1;
                Object localObject8 = paramCertPathParameters;
                paramCertPathParameters = (CertPathParameters)localObject2;
                localObject2 = localSet;
                localObject1 = localObject3;
                localObject3 = localObject5;
                localObject5 = localPKIXNameConstraintValidator;
                i = m;
                m = i2;
                while (m >= 0)
                {
                  localObject6 = (X509Certificate)((List)localObject4).get(m);
                  boolean bool;
                  if (m == ((List)localObject4).size() - 1) {
                    bool = true;
                  } else {
                    bool = false;
                  }
                  RFC3280CertPathUtilities.processCertA(paramCertPath, localPKIXExtendedParameters, m, (PublicKey)localObject9, bool, (X500Name)localObject8, (X509Certificate)localObject7, this.helper);
                  RFC3280CertPathUtilities.processCertBC(paramCertPath, m, (PKIXNameConstraintValidator)localObject5);
                  paramCertPathParameters = RFC3280CertPathUtilities.processCertE(paramCertPath, m, RFC3280CertPathUtilities.processCertD(paramCertPath, m, localHashSet, paramCertPathParameters, (List[])localObject3, j));
                  RFC3280CertPathUtilities.processCertF(paramCertPath, m, paramCertPathParameters, k);
                  if (i1 - m != i1)
                  {
                    if ((localObject6 != null) && (((X509Certificate)localObject6).getVersion() == 1)) {
                      throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, paramCertPath, m);
                    }
                    RFC3280CertPathUtilities.prepareNextCertA(paramCertPath, m);
                    paramCertPathParameters = RFC3280CertPathUtilities.prepareCertB(paramCertPath, m, (List[])localObject3, paramCertPathParameters, i);
                    RFC3280CertPathUtilities.prepareNextCertG(paramCertPath, m, (PKIXNameConstraintValidator)localObject5);
                    k = RFC3280CertPathUtilities.prepareNextCertH1(paramCertPath, m, k);
                    i = RFC3280CertPathUtilities.prepareNextCertH2(paramCertPath, m, i);
                    j = RFC3280CertPathUtilities.prepareNextCertH3(paramCertPath, m, j);
                    k = RFC3280CertPathUtilities.prepareNextCertI1(paramCertPath, m, k);
                    i = RFC3280CertPathUtilities.prepareNextCertI2(paramCertPath, m, i);
                    j = RFC3280CertPathUtilities.prepareNextCertJ(paramCertPath, m, j);
                    RFC3280CertPathUtilities.prepareNextCertK(paramCertPath, m);
                    n = RFC3280CertPathUtilities.prepareNextCertM(paramCertPath, m, RFC3280CertPathUtilities.prepareNextCertL(paramCertPath, m, n));
                    RFC3280CertPathUtilities.prepareNextCertN(paramCertPath, m);
                    localObject7 = ((X509Certificate)localObject6).getCriticalExtensionOIDs();
                    if (localObject7 != null)
                    {
                      localObject7 = new HashSet((Collection)localObject7);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.KEY_USAGE);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                      ((Set)localObject7).remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                    }
                    else
                    {
                      localObject7 = new HashSet();
                    }
                    RFC3280CertPathUtilities.prepareNextCertO(paramCertPath, m, (Set)localObject7, localList);
                    localObject8 = PrincipalUtils.getSubjectPrincipal((X509Certificate)localObject6);
                    try
                    {
                      localObject9 = CertPathValidatorUtilities.getNextWorkingKey(paramCertPath.getCertificates(), m, this.helper);
                      localObject7 = CertPathValidatorUtilities.getAlgorithmIdentifier((PublicKey)localObject9);
                      ((AlgorithmIdentifier)localObject7).getAlgorithm();
                      ((AlgorithmIdentifier)localObject7).getParameters();
                      localObject7 = localObject6;
                    }
                    catch (CertPathValidatorException paramCertPathParameters)
                    {
                      throw new CertPathValidatorException("Next working key could not be retrieved.", paramCertPathParameters, paramCertPath, m);
                    }
                  }
                  m -= 1;
                }
                j = RFC3280CertPathUtilities.wrapupCertA(k, (X509Certificate)localObject6);
                i = m + 1;
                j = RFC3280CertPathUtilities.wrapupCertB(paramCertPath, i, j);
                localObject4 = ((X509Certificate)localObject6).getCriticalExtensionOIDs();
                if (localObject4 != null)
                {
                  localObject4 = new HashSet((Collection)localObject4);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.KEY_USAGE);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                  ((Set)localObject4).remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                  ((Set)localObject4).remove(Extension.extendedKeyUsage.getId());
                }
                else
                {
                  localObject4 = new HashSet();
                }
                RFC3280CertPathUtilities.wrapupCertF(paramCertPath, i, localList, (Set)localObject4);
                paramCertPathParameters = RFC3280CertPathUtilities.wrapupCertG(paramCertPath, localPKIXExtendedParameters, (Set)localObject2, i, (List[])localObject3, paramCertPathParameters, localHashSet);
                if ((j <= 0) && (paramCertPathParameters == null)) {
                  throw new CertPathValidatorException("Path processing failed on policy.", null, paramCertPath, m);
                }
                return new PKIXCertPathValidatorResult((TrustAnchor)localObject1, paramCertPathParameters, ((X509Certificate)localObject6).getPublicKey());
              }
              catch (CertPathValidatorException paramCertPathParameters)
              {
                throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", paramCertPathParameters, paramCertPath, -1);
              }
              throw new CertPathValidatorException("Trust anchor for certification path not found.", null, paramCertPath, -1);
            }
            catch (IllegalArgumentException paramCertPathParameters)
            {
              throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", paramCertPathParameters, paramCertPath, -1);
            }
          }
          throw new CertPathValidatorException("Certification path is empty.", null, paramCertPath, -1);
        }
        catch (AnnotatedException paramCertPathParameters)
        {
          throw new CertPathValidatorException(paramCertPathParameters.getMessage(), paramCertPathParameters, paramCertPath, ((List)localObject4).size() - 1);
        }
      }
    }
    throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
    label1389:
    paramCertPath = new StringBuilder();
    paramCertPath.append("Parameters must be a ");
    paramCertPath.append(PKIXParameters.class.getName());
    paramCertPath.append(" instance.");
    throw new InvalidAlgorithmParameterException(paramCertPath.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PKIXCertPathValidatorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */