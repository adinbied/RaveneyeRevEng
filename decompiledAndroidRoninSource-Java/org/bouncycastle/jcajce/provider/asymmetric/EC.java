package org.bouncycastle.jcajce.provider.asymmetric;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi.EC;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi.ECMQV;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.util.Properties;

public class EC
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.ec.";
  private static final Map<String, String> generalEcAttributes;
  
  static
  {
    HashMap localHashMap = new HashMap();
    generalEcAttributes = localHashMap;
    localHashMap.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
    generalEcAttributes.put("SupportedKeyFormats", "PKCS#8|X.509");
  }
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.EC", "org.bouncycastle.jcajce.provider.asymmetric.ec.AlgorithmParametersSpi");
      paramConfigurableProvider.addAttributes("KeyAgreement.ECDH", EC.generalEcAttributes);
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH");
      paramConfigurableProvider.addAttributes("KeyAgreement.ECDHC", EC.generalEcAttributes);
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECDHC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC");
      paramConfigurableProvider.addAttributes("KeyAgreement.ECCDH", EC.generalEcAttributes);
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECCDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyAgreement.");
      localStringBuilder.append(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo");
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECDHWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF");
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1CKDF");
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256CKDF");
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384CKDF");
      paramConfigurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512CKDF");
      registerOid(paramConfigurableProvider, X9ObjectIdentifiers.id_ecPublicKey, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme, "ECMQV", new KeyFactorySpi.ECMQV());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOid(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme, "EC", new KeyFactorySpi.EC());
      registerOidAlgorithmParameters(paramConfigurableProvider, X9ObjectIdentifiers.id_ecPublicKey, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme, "EC");
      registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme, "EC");
      if (!Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv"))
      {
        paramConfigurableProvider.addAlgorithm("KeyAgreement.ECMQV", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV");
        paramConfigurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1CKDF");
        paramConfigurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA224CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224CKDF");
        paramConfigurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256CKDF");
        paramConfigurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384CKDF");
        paramConfigurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512CKDF");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("KeyAgreement.");
        localStringBuilder.append(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
        paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDFAndSharedInfo");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("KeyAgreement.");
        localStringBuilder.append(SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme);
        paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224KDFAndSharedInfo");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("KeyAgreement.");
        localStringBuilder.append(SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme);
        paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("KeyAgreement.");
        localStringBuilder.append(SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme);
        paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384KDFAndSharedInfo");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("KeyAgreement.");
        localStringBuilder.append(SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme);
        paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo");
        registerOid(paramConfigurableProvider, X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme, "EC", new KeyFactorySpi.EC());
        registerOidAlgorithmParameters(paramConfigurableProvider, X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme, "EC");
        registerOid(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme, "ECMQV", new KeyFactorySpi.ECMQV());
        registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme, "EC");
        registerOid(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme, "ECMQV", new KeyFactorySpi.ECMQV());
        registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme, "EC");
        registerOid(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme, "ECMQV", new KeyFactorySpi.ECMQV());
        registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme, "EC");
        registerOid(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme, "ECMQV", new KeyFactorySpi.ECMQV());
        registerOidAlgorithmParameters(paramConfigurableProvider, SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme, "EC");
        paramConfigurableProvider.addAlgorithm("KeyFactory.ECMQV", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECMQV");
        paramConfigurableProvider.addAlgorithm("KeyPairGenerator.ECMQV", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV");
      }
      paramConfigurableProvider.addAlgorithm("KeyFactory.EC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$EC");
      paramConfigurableProvider.addAlgorithm("KeyFactory.ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDSA");
      paramConfigurableProvider.addAlgorithm("KeyFactory.ECDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDH");
      paramConfigurableProvider.addAlgorithm("KeyFactory.ECDHC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDHC");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.EC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.ECDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.ECDHWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.ECDHC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.ECIES", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
      paramConfigurableProvider.addAlgorithm("Cipher.ECIES", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES");
      paramConfigurableProvider.addAlgorithm("Cipher.ECIESwithAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC");
      paramConfigurableProvider.addAlgorithm("Cipher.ECIESWITHAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC");
      paramConfigurableProvider.addAlgorithm("Cipher.ECIESwithDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC");
      paramConfigurableProvider.addAlgorithm("Cipher.ECIESWITHDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC");
      paramConfigurableProvider.addAlgorithm("Signature.ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA");
      paramConfigurableProvider.addAlgorithm("Signature.NONEwithECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withECDSA", "ECDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAwithSHA1", "ECDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHECDSA", "ECDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAWITHSHA1", "ECDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithECDSA", "ECDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAWithSHA1", "ECDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.1.2.840.10045.4.1", "ECDSA");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.Signature.");
      localStringBuilder.append(TeleTrusTObjectIdentifiers.ecSignWithSha1);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "ECDSA");
      paramConfigurableProvider.addAlgorithm("Signature.ECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA");
      paramConfigurableProvider.addAlgorithm("Signature.SHA1WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA");
      paramConfigurableProvider.addAlgorithm("Signature.SHA224WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA224");
      paramConfigurableProvider.addAlgorithm("Signature.SHA256WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA256");
      paramConfigurableProvider.addAlgorithm("Signature.SHA384WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA384");
      paramConfigurableProvider.addAlgorithm("Signature.SHA512WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA512");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-224WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_224");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-256WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_256");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-384WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_384");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-512WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_512");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.DETECDSA", "ECDDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHDETECDSA", "SHA1WITHECDDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA224WITHDETECDSA", "SHA224WITHECDDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA256WITHDETECDSA", "SHA256WITHECDDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA384WITHDETECDSA", "SHA384WITHECDDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA512WITHDETECDSA", "SHA512WITHECDDSA");
      addSignatureAlgorithm(paramConfigurableProvider, "SHA224", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224", X9ObjectIdentifiers.ecdsa_with_SHA224);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA256", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256", X9ObjectIdentifiers.ecdsa_with_SHA256);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA384", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384", X9ObjectIdentifiers.ecdsa_with_SHA384);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA512", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512", X9ObjectIdentifiers.ecdsa_with_SHA512);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-224", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_224", NISTObjectIdentifiers.id_ecdsa_with_sha3_224);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-256", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_256", NISTObjectIdentifiers.id_ecdsa_with_sha3_256);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-384", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_384", NISTObjectIdentifiers.id_ecdsa_with_sha3_384);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-512", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_512", NISTObjectIdentifiers.id_ecdsa_with_sha3_512);
      addSignatureAlgorithm(paramConfigurableProvider, "RIPEMD160", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160", TeleTrusTObjectIdentifiers.ecSignWithRipemd160);
      paramConfigurableProvider.addAlgorithm("Signature.SHA1WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR");
      paramConfigurableProvider.addAlgorithm("Signature.SHA224WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224");
      paramConfigurableProvider.addAlgorithm("Signature.SHA256WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256");
      paramConfigurableProvider.addAlgorithm("Signature.SHA384WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384");
      paramConfigurableProvider.addAlgorithm("Signature.SHA512WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512");
      addSignatureAlgorithm(paramConfigurableProvider, "SHA1", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA224", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", EACObjectIdentifiers.id_TA_ECDSA_SHA_224);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA256", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", EACObjectIdentifiers.id_TA_ECDSA_SHA_256);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA384", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384", EACObjectIdentifiers.id_TA_ECDSA_SHA_384);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA512", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512", EACObjectIdentifiers.id_TA_ECDSA_SHA_512);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA1", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", BSIObjectIdentifiers.ecdsa_plain_SHA1);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA224", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", BSIObjectIdentifiers.ecdsa_plain_SHA224);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA256", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", BSIObjectIdentifiers.ecdsa_plain_SHA256);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA384", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384", BSIObjectIdentifiers.ecdsa_plain_SHA384);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA512", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512", BSIObjectIdentifiers.ecdsa_plain_SHA512);
      addSignatureAlgorithm(paramConfigurableProvider, "RIPEMD160", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecPlainDSARP160", BSIObjectIdentifiers.ecdsa_plain_RIPEMD160);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\EC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */