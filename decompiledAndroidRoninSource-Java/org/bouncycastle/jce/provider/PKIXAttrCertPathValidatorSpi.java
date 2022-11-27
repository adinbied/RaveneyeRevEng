package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters.Builder;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;

public class PKIXAttrCertPathValidatorSpi
  extends CertPathValidatorSpi
{
  private final JcaJceHelper helper = new BCJcaJceHelper();
  
  public CertPathValidatorResult engineValidate(CertPath paramCertPath, CertPathParameters paramCertPathParameters)
    throws CertPathValidatorException, InvalidAlgorithmParameterException
  {
    boolean bool = paramCertPathParameters instanceof ExtendedPKIXParameters;
    if ((!bool) && (!(paramCertPathParameters instanceof PKIXExtendedParameters)))
    {
      paramCertPath = new StringBuilder();
      paramCertPath.append("Parameters must be a ");
      paramCertPath.append(ExtendedPKIXParameters.class.getName());
      paramCertPath.append(" instance.");
      throw new InvalidAlgorithmParameterException(paramCertPath.toString());
    }
    Object localObject3 = new HashSet();
    Object localObject2 = new HashSet();
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    if ((paramCertPathParameters instanceof PKIXParameters))
    {
      localObject4 = new PKIXExtendedParameters.Builder((PKIXParameters)paramCertPathParameters);
      if (bool)
      {
        paramCertPathParameters = (ExtendedPKIXParameters)paramCertPathParameters;
        ((PKIXExtendedParameters.Builder)localObject4).setUseDeltasEnabled(paramCertPathParameters.isUseDeltasEnabled());
        ((PKIXExtendedParameters.Builder)localObject4).setValidityModel(paramCertPathParameters.getValidityModel());
        localObject3 = paramCertPathParameters.getAttrCertCheckers();
        localObject2 = paramCertPathParameters.getProhibitedACAttributes();
        localObject1 = paramCertPathParameters.getNecessaryACAttributes();
      }
      paramCertPathParameters = ((PKIXExtendedParameters.Builder)localObject4).build();
    }
    else
    {
      paramCertPathParameters = (PKIXExtendedParameters)paramCertPathParameters;
    }
    Object localObject4 = paramCertPathParameters.getTargetConstraints();
    if ((localObject4 instanceof X509AttributeCertStoreSelector))
    {
      localObject4 = ((X509AttributeCertStoreSelector)localObject4).getAttributeCert();
      CertPath localCertPath = RFC3281CertPathUtilities.processAttrCert1((X509AttributeCertificate)localObject4, paramCertPathParameters);
      CertPathValidatorResult localCertPathValidatorResult = RFC3281CertPathUtilities.processAttrCert2(paramCertPath, paramCertPathParameters);
      X509Certificate localX509Certificate = (X509Certificate)paramCertPath.getCertificates().get(0);
      RFC3281CertPathUtilities.processAttrCert3(localX509Certificate, paramCertPathParameters);
      RFC3281CertPathUtilities.processAttrCert4(localX509Certificate, localHashSet);
      RFC3281CertPathUtilities.processAttrCert5((X509AttributeCertificate)localObject4, paramCertPathParameters);
      RFC3281CertPathUtilities.processAttrCert7((X509AttributeCertificate)localObject4, paramCertPath, localCertPath, paramCertPathParameters, (Set)localObject3);
      RFC3281CertPathUtilities.additionalChecks((X509AttributeCertificate)localObject4, (Set)localObject2, (Set)localObject1);
      try
      {
        localObject1 = CertPathValidatorUtilities.getValidCertDateFromValidityModel(paramCertPathParameters, null, -1);
        RFC3281CertPathUtilities.checkCRLs((X509AttributeCertificate)localObject4, paramCertPathParameters, localX509Certificate, (Date)localObject1, paramCertPath.getCertificates(), this.helper);
        return localCertPathValidatorResult;
      }
      catch (AnnotatedException paramCertPath)
      {
        throw new ExtCertPathValidatorException("Could not get validity date from attribute certificate.", paramCertPath);
      }
    }
    paramCertPath = new StringBuilder();
    paramCertPath.append("TargetConstraints must be an instance of ");
    paramCertPath.append(X509AttributeCertStoreSelector.class.getName());
    paramCertPath.append(" for ");
    paramCertPath.append(getClass().getName());
    paramCertPath.append(" class.");
    throw new InvalidAlgorithmParameterException(paramCertPath.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PKIXAttrCertPathValidatorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */