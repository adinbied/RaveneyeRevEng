package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public final class BouncyCastleProvider
  extends Provider
  implements ConfigurableProvider
{
  private static final String[] ASYMMETRIC_CIPHERS = { "DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM" };
  private static final String[] ASYMMETRIC_GENERIC;
  private static final String ASYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.asymmetric.";
  public static final ProviderConfiguration CONFIGURATION = new BouncyCastleProviderConfiguration();
  private static final String[] DIGESTS = { "GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b" };
  private static final String DIGEST_PACKAGE = "org.bouncycastle.jcajce.provider.digest.";
  private static final String[] KEYSTORES = { "BC", "BCFKS", "PKCS12" };
  private static final String KEYSTORE_PACKAGE = "org.bouncycastle.jcajce.provider.keystore.";
  public static final String PROVIDER_NAME = "BC";
  private static final String[] SECURE_RANDOMS = { "DRBG" };
  private static final String SECURE_RANDOM_PACKAGE = "org.bouncycastle.jcajce.provider.drbg.";
  private static final String[] SYMMETRIC_CIPHERS;
  private static final String[] SYMMETRIC_GENERIC;
  private static final String[] SYMMETRIC_MACS;
  private static final String SYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.symmetric.";
  private static String info = "BouncyCastle Security Provider v1.57";
  private static final Map keyInfoConverters = new HashMap();
  
  static
  {
    SYMMETRIC_GENERIC = new String[] { "PBEPBKDF2", "PBEPKCS12", "TLSKDF" };
    SYMMETRIC_MACS = new String[] { "SipHash", "Poly1305" };
    SYMMETRIC_CIPHERS = new String[] { "AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF" };
    ASYMMETRIC_GENERIC = new String[] { "X509", "IES" };
  }
  
  public BouncyCastleProvider()
  {
    super("BC", 1.57D, info);
    AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        BouncyCastleProvider.this.setup();
        return null;
      }
    });
  }
  
  private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    synchronized (keyInfoConverters)
    {
      paramASN1ObjectIdentifier = (AsymmetricKeyInfoConverter)keyInfoConverters.get(paramASN1ObjectIdentifier);
      return paramASN1ObjectIdentifier;
    }
  }
  
  public static PrivateKey getPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    AsymmetricKeyInfoConverter localAsymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm());
    if (localAsymmetricKeyInfoConverter == null) {
      return null;
    }
    return localAsymmetricKeyInfoConverter.generatePrivate(paramPrivateKeyInfo);
  }
  
  public static PublicKey getPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    AsymmetricKeyInfoConverter localAsymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm());
    if (localAsymmetricKeyInfoConverter == null) {
      return null;
    }
    return localAsymmetricKeyInfoConverter.generatePublic(paramSubjectPublicKeyInfo);
  }
  
  private void loadAlgorithms(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    while (i != paramArrayOfString.length)
    {
      Object localObject1 = null;
      try
      {
        localObject2 = getClass().getClassLoader();
        if (localObject2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramArrayOfString[i]);
          localStringBuilder.append("$Mappings");
          localObject2 = ((ClassLoader)localObject2).loadClass(localStringBuilder.toString());
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(paramArrayOfString[i]);
          ((StringBuilder)localObject2).append("$Mappings");
          localObject2 = Class.forName(((StringBuilder)localObject2).toString());
          localObject1 = localObject2;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject2;
        for (;;) {}
      }
      if (localObject1 != null) {
        try
        {
          ((AlgorithmProvider)((Class)localObject1).newInstance()).configure(this);
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cannot create instance of ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(paramArrayOfString[i]);
          ((StringBuilder)localObject2).append("$Mappings : ");
          ((StringBuilder)localObject2).append(localException);
          throw new InternalError(((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
  }
  
  private void setup()
  {
    loadAlgorithms("org.bouncycastle.jcajce.provider.digest.", DIGESTS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_GENERIC);
    loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_MACS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_CIPHERS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", ASYMMETRIC_GENERIC);
    loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", ASYMMETRIC_CIPHERS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.keystore.", KEYSTORES);
    loadAlgorithms("org.bouncycastle.jcajce.provider.drbg.", SECURE_RANDOMS);
    put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
    put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
    put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
    put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
    put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
    put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
    put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
    put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
    put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
    put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
    put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
    put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
    put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
    put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
    put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
    put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
    put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
    put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
    put("CertPathBuilder.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
    put("CertPathValidator.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
    put("CertPathBuilder.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
    put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
    put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
    put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
    put("Alg.Alias.CertStore.X509LDAP", "LDAP");
  }
  
  public void addAlgorithm(String paramString1, String paramString2)
  {
    if (!containsKey(paramString1))
    {
      put(paramString1, paramString2);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("duplicate provider key (");
    paramString2.append(paramString1);
    paramString2.append(") found");
    throw new IllegalStateException(paramString2.toString());
  }
  
  public void addAlgorithm(String paramString1, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    addAlgorithm(localStringBuilder.toString(), paramString2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".OID.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    addAlgorithm(localStringBuilder.toString(), paramString2);
  }
  
  public void addAttributes(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (!containsKey(localObject))
      {
        put(localObject, paramMap.get(str));
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("duplicate provider attribute key (");
        paramString.append((String)localObject);
        paramString.append(") found");
        throw new IllegalStateException(paramString.toString());
      }
    }
  }
  
  public void addKeyInfoConverter(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AsymmetricKeyInfoConverter paramAsymmetricKeyInfoConverter)
  {
    synchronized (keyInfoConverters)
    {
      keyInfoConverters.put(paramASN1ObjectIdentifier, paramAsymmetricKeyInfoConverter);
      return;
    }
  }
  
  public boolean hasAlgorithm(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (!containsKey(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (!containsKey(localStringBuilder.toString())) {
        return false;
      }
    }
    return true;
  }
  
  public void setParameter(String paramString, Object paramObject)
  {
    synchronized (CONFIGURATION)
    {
      ((BouncyCastleProviderConfiguration)CONFIGURATION).setParameter(paramString, paramObject);
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\BouncyCastleProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */