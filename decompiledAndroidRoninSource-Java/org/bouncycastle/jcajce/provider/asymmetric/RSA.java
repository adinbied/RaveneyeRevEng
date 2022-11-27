package org.bouncycastle.jcajce.provider.asymmetric;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class RSA
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.rsa.";
  private static final Map<String, String> generalRsaAttributes;
  
  static
  {
    HashMap localHashMap = new HashMap();
    generalRsaAttributes = localHashMap;
    localHashMap.put("SupportedKeyClasses", "javax.crypto.interfaces.RSAPublicKey|javax.crypto.interfaces.RSAPrivateKey");
    generalRsaAttributes.put("SupportedKeyFormats", "PKCS#8|X.509");
  }
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    private void addDigestSignature(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("WITHRSA");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("withRSA");
      String str1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("WithRSA");
      String str2 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append("RSA");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append("WITHRSAENCRYPTION");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramString1);
      ((StringBuilder)localObject4).append("withRSAEncryption");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WithRSAEncryption");
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Signature.");
      localStringBuilder.append((String)localObject1);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString2);
      paramString2 = new StringBuilder();
      paramString2.append("Alg.Alias.Signature.");
      paramString2.append(str1);
      paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
      paramString2 = new StringBuilder();
      paramString2.append("Alg.Alias.Signature.");
      paramString2.append(str2);
      paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
      paramString2 = new StringBuilder();
      paramString2.append("Alg.Alias.Signature.");
      paramString2.append((String)localObject3);
      paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
      paramString2 = new StringBuilder();
      paramString2.append("Alg.Alias.Signature.");
      paramString2.append((String)localObject4);
      paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
      paramString2 = new StringBuilder();
      paramString2.append("Alg.Alias.Signature.");
      paramString2.append(paramString1);
      paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
      paramString1 = new StringBuilder();
      paramString1.append("Alg.Alias.Signature.");
      paramString1.append((String)localObject2);
      paramConfigurableProvider.addAlgorithm(paramString1.toString(), (String)localObject1);
      if (paramASN1ObjectIdentifier != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("Alg.Alias.Signature.");
        paramString1.append(paramASN1ObjectIdentifier);
        paramConfigurableProvider.addAlgorithm(paramString1.toString(), (String)localObject1);
        paramString1 = new StringBuilder();
        paramString1.append("Alg.Alias.Signature.OID.");
        paramString1.append(paramASN1ObjectIdentifier);
        paramConfigurableProvider.addAlgorithm(paramString1.toString(), (String)localObject1);
      }
    }
    
    private void addISO9796Signature(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("withRSA/ISO9796-2");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSA/ISO9796-2");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WithRSA/ISO9796-2");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSA/ISO9796-2");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WITHRSA/ISO9796-2");
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), paramString2);
    }
    
    private void addPSSSignature(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("withRSA/PSS");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSAANDMGF1");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WithRSA/PSS");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSAANDMGF1");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("withRSAandMGF1");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSAANDMGF1");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WithRSAAndMGF1");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSAANDMGF1");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WITHRSAANDMGF1");
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), paramString2);
    }
    
    private void addX931Signature(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("withRSA/X9.31");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSA/X9.31");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WithRSA/X9.31");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("WITHRSA/X9.31");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Signature.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("WITHRSA/X9.31");
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), paramString2);
    }
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-224WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-256WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-384WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA3-512WITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
      paramConfigurableProvider.addAttributes("Cipher.RSA", RSA.generalRsaAttributes);
      paramConfigurableProvider.addAlgorithm("Cipher.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
      paramConfigurableProvider.addAlgorithm("Cipher.RSA/RAW", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
      paramConfigurableProvider.addAlgorithm("Cipher.RSA/PKCS1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
      paramConfigurableProvider.addAlgorithm("Cipher", PKCSObjectIdentifiers.rsaEncryption, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
      paramConfigurableProvider.addAlgorithm("Cipher", X509ObjectIdentifiers.id_ea_rsa, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
      paramConfigurableProvider.addAlgorithm("Cipher.RSA/1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
      paramConfigurableProvider.addAlgorithm("Cipher.RSA/2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
      paramConfigurableProvider.addAlgorithm("Cipher.RSA/OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
      paramConfigurableProvider.addAlgorithm("Cipher", PKCSObjectIdentifiers.id_RSAES_OAEP, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
      paramConfigurableProvider.addAlgorithm("Cipher.RSA/ISO9796-1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//RAW", "RSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
      paramConfigurableProvider.addAlgorithm("KeyFactory.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
      Object localObject = new KeyFactorySpi();
      registerOid(paramConfigurableProvider, PKCSObjectIdentifiers.rsaEncryption, "RSA", (AsymmetricKeyInfoConverter)localObject);
      registerOid(paramConfigurableProvider, X509ObjectIdentifiers.id_ea_rsa, "RSA", (AsymmetricKeyInfoConverter)localObject);
      registerOid(paramConfigurableProvider, PKCSObjectIdentifiers.id_RSAES_OAEP, "RSA", (AsymmetricKeyInfoConverter)localObject);
      registerOid(paramConfigurableProvider, PKCSObjectIdentifiers.id_RSASSA_PSS, "RSA", (AsymmetricKeyInfoConverter)localObject);
      registerOidAlgorithmParameters(paramConfigurableProvider, PKCSObjectIdentifiers.rsaEncryption, "RSA");
      registerOidAlgorithmParameters(paramConfigurableProvider, X509ObjectIdentifiers.id_ea_rsa, "RSA");
      registerOidAlgorithmParameters(paramConfigurableProvider, PKCSObjectIdentifiers.id_RSAES_OAEP, "OAEP");
      registerOidAlgorithmParameters(paramConfigurableProvider, PKCSObjectIdentifiers.id_RSASSA_PSS, "PSS");
      paramConfigurableProvider.addAlgorithm("Signature.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Signature.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.id_RSASSA_PSS);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Signature.OID.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.id_RSASSA_PSS);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
      paramConfigurableProvider.addAlgorithm("Signature.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
      paramConfigurableProvider.addAlgorithm("Signature.RAWRSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.RAWRSA", "RSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSA", "RSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
      addPSSSignature(paramConfigurableProvider, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA3-224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA3-256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA3-384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSA");
      addPSSSignature(paramConfigurableProvider, "SHA3-512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSA");
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "MD2")) {
        addDigestSignature(paramConfigurableProvider, "MD2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", PKCSObjectIdentifiers.md2WithRSAEncryption);
      }
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "MD4")) {
        addDigestSignature(paramConfigurableProvider, "MD4", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", PKCSObjectIdentifiers.md4WithRSAEncryption);
      }
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "MD5"))
      {
        addDigestSignature(paramConfigurableProvider, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", PKCSObjectIdentifiers.md5WithRSAEncryption);
        addISO9796Signature(paramConfigurableProvider, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
      }
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "SHA1"))
      {
        paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
        addPSSSignature(paramConfigurableProvider, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
        addDigestSignature(paramConfigurableProvider, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", PKCSObjectIdentifiers.sha1WithRSAEncryption);
        addISO9796Signature(paramConfigurableProvider, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Alg.Alias.Signature.");
        ((StringBuilder)localObject).append(OIWObjectIdentifiers.sha1WithRSA);
        paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA1WITHRSA");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Alg.Alias.Signature.OID.");
        ((StringBuilder)localObject).append(OIWObjectIdentifiers.sha1WithRSA);
        paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA1WITHRSA");
        addX931Signature(paramConfigurableProvider, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption");
      }
      addDigestSignature(paramConfigurableProvider, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", PKCSObjectIdentifiers.sha224WithRSAEncryption);
      addDigestSignature(paramConfigurableProvider, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", PKCSObjectIdentifiers.sha256WithRSAEncryption);
      addDigestSignature(paramConfigurableProvider, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", PKCSObjectIdentifiers.sha384WithRSAEncryption);
      addDigestSignature(paramConfigurableProvider, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", PKCSObjectIdentifiers.sha512WithRSAEncryption);
      addDigestSignature(paramConfigurableProvider, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224", PKCSObjectIdentifiers.sha512_224WithRSAEncryption);
      addDigestSignature(paramConfigurableProvider, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256", PKCSObjectIdentifiers.sha512_256WithRSAEncryption);
      addDigestSignature(paramConfigurableProvider, "SHA3-224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_224", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_224);
      addDigestSignature(paramConfigurableProvider, "SHA3-256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_256", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_256);
      addDigestSignature(paramConfigurableProvider, "SHA3-384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_384);
      addDigestSignature(paramConfigurableProvider, "SHA3-512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_512", NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512);
      addISO9796Signature(paramConfigurableProvider, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption");
      addISO9796Signature(paramConfigurableProvider, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption");
      addISO9796Signature(paramConfigurableProvider, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption");
      addISO9796Signature(paramConfigurableProvider, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption");
      addISO9796Signature(paramConfigurableProvider, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption");
      addISO9796Signature(paramConfigurableProvider, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption");
      addX931Signature(paramConfigurableProvider, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption");
      addX931Signature(paramConfigurableProvider, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption");
      addX931Signature(paramConfigurableProvider, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption");
      addX931Signature(paramConfigurableProvider, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption");
      addX931Signature(paramConfigurableProvider, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption");
      addX931Signature(paramConfigurableProvider, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption");
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "RIPEMD128"))
      {
        addDigestSignature(paramConfigurableProvider, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
        addDigestSignature(paramConfigurableProvider, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", null);
        addX931Signature(paramConfigurableProvider, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
        addX931Signature(paramConfigurableProvider, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
      }
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "RIPEMD160"))
      {
        addDigestSignature(paramConfigurableProvider, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
        addDigestSignature(paramConfigurableProvider, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", null);
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
        paramConfigurableProvider.addAlgorithm("Signature.RIPEMD160withRSA/ISO9796-2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
        addX931Signature(paramConfigurableProvider, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
        addX931Signature(paramConfigurableProvider, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
      }
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "RIPEMD256"))
      {
        addDigestSignature(paramConfigurableProvider, "RIPEMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
        addDigestSignature(paramConfigurableProvider, "RMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", null);
      }
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "WHIRLPOOL"))
      {
        addISO9796Signature(paramConfigurableProvider, "Whirlpool", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
        addISO9796Signature(paramConfigurableProvider, "WHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
        addX931Signature(paramConfigurableProvider, "Whirlpool", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
        addX931Signature(paramConfigurableProvider, "WHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\RSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */