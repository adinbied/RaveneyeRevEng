package org.bouncycastle.est.jcajce;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CRL;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.X509CertificateHolder;

public class JcaJceUtils
{
  public static KeyManagerFactory createKeyManagerFactory(String paramString1, String paramString2, KeyStore paramKeyStore, char[] paramArrayOfChar)
    throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      paramString1 = KeyManagerFactory.getDefaultAlgorithm();
    } else {
      if (paramString2 != null) {
        break label27;
      }
    }
    paramString1 = KeyManagerFactory.getInstance(paramString1);
    break label33;
    label27:
    paramString1 = KeyManagerFactory.getInstance(paramString1, paramString2);
    label33:
    paramString1.init(paramKeyStore, paramArrayOfChar);
    return paramString1;
  }
  
  public static X509TrustManager[] getCertPathTrustManager(Set<TrustAnchor> paramSet, final CRL[] paramArrayOfCRL)
  {
    final X509Certificate[] arrayOfX509Certificate = new X509Certificate[paramSet.size()];
    Iterator localIterator = paramSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate[i] = ((TrustAnchor)localIterator.next()).getTrustedCert();
      i += 1;
    }
    new X509TrustManager[] { new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {
        try
        {
          paramAnonymousString = CertStore.getInstance("Collection", new CollectionCertStoreParameters(Arrays.asList(paramAnonymousArrayOfX509Certificate)), "BC");
          CertPathBuilder localCertPathBuilder = CertPathBuilder.getInstance("PKIX", "BC");
          Object localObject = new X509CertSelector();
          ((X509CertSelector)localObject).setCertificate(paramAnonymousArrayOfX509Certificate[0]);
          localObject = new PKIXBuilderParameters(this.val$anchors, (CertSelector)localObject);
          ((PKIXBuilderParameters)localObject).addCertStore(paramAnonymousString);
          if (paramArrayOfCRL != null)
          {
            ((PKIXBuilderParameters)localObject).setRevocationEnabled(true);
            ((PKIXBuilderParameters)localObject).addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(Arrays.asList(paramArrayOfCRL))));
          }
          else
          {
            ((PKIXBuilderParameters)localObject).setRevocationEnabled(false);
          }
          paramAnonymousString = (PKIXCertPathValidatorResult)localCertPathBuilder.build((CertPathParameters)localObject);
          JcaJceUtils.validateServerCertUsage(paramAnonymousArrayOfX509Certificate[0]);
          return;
        }
        catch (GeneralSecurityException paramAnonymousArrayOfX509Certificate) {}catch (CertificateException paramAnonymousArrayOfX509Certificate) {}
        paramAnonymousString = new StringBuilder();
        paramAnonymousString.append("unable to process certificates: ");
        paramAnonymousString.append(paramAnonymousArrayOfX509Certificate.getMessage());
        throw new CertificateException(paramAnonymousString.toString(), paramAnonymousArrayOfX509Certificate);
        throw paramAnonymousArrayOfX509Certificate;
      }
      
      public X509Certificate[] getAcceptedIssuers()
      {
        X509Certificate[] arrayOfX509Certificate1 = arrayOfX509Certificate;
        int i = arrayOfX509Certificate1.length;
        X509Certificate[] arrayOfX509Certificate2 = new X509Certificate[i];
        System.arraycopy(arrayOfX509Certificate1, 0, arrayOfX509Certificate2, 0, i);
        return arrayOfX509Certificate2;
      }
    } };
  }
  
  public static X509TrustManager getTrustAllTrustManager()
  {
    new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public X509Certificate[] getAcceptedIssuers()
      {
        return new X509Certificate[0];
      }
    };
  }
  
  public static void validateServerCertUsage(X509Certificate paramX509Certificate)
    throws CertificateException
  {
    try
    {
      paramX509Certificate = new X509CertificateHolder(paramX509Certificate.getEncoded());
      KeyUsage localKeyUsage = KeyUsage.fromExtensions(paramX509Certificate.getExtensions());
      if (localKeyUsage != null) {
        if (!localKeyUsage.hasUsages(4))
        {
          if ((!localKeyUsage.hasUsages(128)) && (!localKeyUsage.hasUsages(32))) {
            throw new CertificateException("Key usage must be none, digitalSignature or keyEncipherment");
          }
        }
        else {
          throw new CertificateException("Key usage must not contain keyCertSign");
        }
      }
      paramX509Certificate = ExtendedKeyUsage.fromExtensions(paramX509Certificate.getExtensions());
      if ((paramX509Certificate != null) && (!paramX509Certificate.hasKeyPurposeId(KeyPurposeId.id_kp_serverAuth)) && (!paramX509Certificate.hasKeyPurposeId(KeyPurposeId.id_kp_msSGC)))
      {
        if (paramX509Certificate.hasKeyPurposeId(KeyPurposeId.id_kp_nsSGC)) {
          return;
        }
        throw new CertificateException("Certificate extended key usage must include serverAuth, msSGC or nsSGC");
      }
      return;
    }
    catch (Exception paramX509Certificate)
    {
      throw new CertificateException(paramX509Certificate.getMessage(), paramX509Certificate);
    }
    catch (CertificateException paramX509Certificate)
    {
      throw paramX509Certificate;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\JcaJceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */