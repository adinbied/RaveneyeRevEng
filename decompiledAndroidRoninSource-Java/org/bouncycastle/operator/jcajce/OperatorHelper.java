package org.bouncycastle.operator.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.jcajce.util.AlgorithmParametersUtils;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.MessageDigestUtils;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Integers;

class OperatorHelper
{
  private static final Map asymmetricWrapperAlgNames;
  private static final Map oids = new HashMap();
  private static final Map symmetricKeyAlgNames;
  private static final Map symmetricWrapperAlgNames;
  private static final Map symmetricWrapperKeySizes;
  private JcaJceHelper helper;
  
  static
  {
    asymmetricWrapperAlgNames = new HashMap();
    symmetricWrapperAlgNames = new HashMap();
    symmetricKeyAlgNames = new HashMap();
    symmetricWrapperKeySizes = new HashMap();
    oids.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
    oids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
    oids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
    oids.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
    oids.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
    oids.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
    oids.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
    oids.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
    oids.put(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
    oids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
    oids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
    oids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
    oids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
    oids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
    oids.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
    oids.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
    oids.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
    oids.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
    oids.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
    oids.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
    oids.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
    oids.put(OIWObjectIdentifiers.idSHA1, "SHA-1");
    oids.put(NISTObjectIdentifiers.id_sha224, "SHA-224");
    oids.put(NISTObjectIdentifiers.id_sha256, "SHA-256");
    oids.put(NISTObjectIdentifiers.id_sha384, "SHA-384");
    oids.put(NISTObjectIdentifiers.id_sha512, "SHA-512");
    oids.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
    oids.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
    oids.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
    asymmetricWrapperAlgNames.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
    symmetricWrapperAlgNames.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, "DESEDEWrap");
    symmetricWrapperAlgNames.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap, "RC2Wrap");
    symmetricWrapperAlgNames.put(NISTObjectIdentifiers.id_aes128_wrap, "AESWrap");
    symmetricWrapperAlgNames.put(NISTObjectIdentifiers.id_aes192_wrap, "AESWrap");
    symmetricWrapperAlgNames.put(NISTObjectIdentifiers.id_aes256_wrap, "AESWrap");
    symmetricWrapperAlgNames.put(NTTObjectIdentifiers.id_camellia128_wrap, "CamelliaWrap");
    symmetricWrapperAlgNames.put(NTTObjectIdentifiers.id_camellia192_wrap, "CamelliaWrap");
    symmetricWrapperAlgNames.put(NTTObjectIdentifiers.id_camellia256_wrap, "CamelliaWrap");
    symmetricWrapperAlgNames.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap, "SEEDWrap");
    symmetricWrapperAlgNames.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESede");
    symmetricWrapperKeySizes.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, Integers.valueOf(192));
    symmetricWrapperKeySizes.put(NISTObjectIdentifiers.id_aes128_wrap, Integers.valueOf(128));
    symmetricWrapperKeySizes.put(NISTObjectIdentifiers.id_aes192_wrap, Integers.valueOf(192));
    symmetricWrapperKeySizes.put(NISTObjectIdentifiers.id_aes256_wrap, Integers.valueOf(256));
    symmetricWrapperKeySizes.put(NTTObjectIdentifiers.id_camellia128_wrap, Integers.valueOf(128));
    symmetricWrapperKeySizes.put(NTTObjectIdentifiers.id_camellia192_wrap, Integers.valueOf(192));
    symmetricWrapperKeySizes.put(NTTObjectIdentifiers.id_camellia256_wrap, Integers.valueOf(256));
    symmetricWrapperKeySizes.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap, Integers.valueOf(128));
    symmetricWrapperKeySizes.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
    symmetricKeyAlgNames.put(NISTObjectIdentifiers.aes, "AES");
    symmetricKeyAlgNames.put(NISTObjectIdentifiers.id_aes128_CBC, "AES");
    symmetricKeyAlgNames.put(NISTObjectIdentifiers.id_aes192_CBC, "AES");
    symmetricKeyAlgNames.put(NISTObjectIdentifiers.id_aes256_CBC, "AES");
    symmetricKeyAlgNames.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESede");
    symmetricKeyAlgNames.put(PKCSObjectIdentifiers.RC2_CBC, "RC2");
  }
  
  OperatorHelper(JcaJceHelper paramJcaJceHelper)
  {
    this.helper = paramJcaJceHelper;
  }
  
  private static String getDigestName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    String str = MessageDigestUtils.getDigestName(paramASN1ObjectIdentifier);
    int i = str.indexOf('-');
    if ((i > 0) && (!str.startsWith("SHA3")))
    {
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append(str.substring(0, i));
      paramASN1ObjectIdentifier.append(str.substring(i + 1));
      return paramASN1ObjectIdentifier.toString();
    }
    return MessageDigestUtils.getDigestName(paramASN1ObjectIdentifier);
  }
  
  private static String getSignatureName(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    Object localObject = paramAlgorithmIdentifier.getParameters();
    if ((localObject != null) && (!DERNull.INSTANCE.equals(localObject)) && (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)))
    {
      paramAlgorithmIdentifier = RSASSAPSSparams.getInstance(localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getDigestName(paramAlgorithmIdentifier.getHashAlgorithm().getAlgorithm()));
      ((StringBuilder)localObject).append("WITHRSAANDMGF1");
      return ((StringBuilder)localObject).toString();
    }
    if (oids.containsKey(paramAlgorithmIdentifier.getAlgorithm())) {
      return (String)oids.get(paramAlgorithmIdentifier.getAlgorithm());
    }
    return paramAlgorithmIdentifier.getAlgorithm().getId();
  }
  
  private boolean notDefaultPSSParams(ASN1Sequence paramASN1Sequence)
    throws GeneralSecurityException
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramASN1Sequence != null)
    {
      if (paramASN1Sequence.size() == 0) {
        return false;
      }
      paramASN1Sequence = RSASSAPSSparams.getInstance(paramASN1Sequence);
      if (!paramASN1Sequence.getMaskGenAlgorithm().getAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1)) {
        return true;
      }
      if (!paramASN1Sequence.getHashAlgorithm().equals(AlgorithmIdentifier.getInstance(paramASN1Sequence.getMaskGenAlgorithm().getParameters()))) {
        return true;
      }
      MessageDigest localMessageDigest = createDigest(paramASN1Sequence.getHashAlgorithm());
      bool1 = bool2;
      if (paramASN1Sequence.getSaltLength().intValue() != localMessageDigest.getDigestLength()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public X509Certificate convertCertificate(X509CertificateHolder paramX509CertificateHolder)
    throws CertificateException
  {
    try
    {
      paramX509CertificateHolder = (X509Certificate)this.helper.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(paramX509CertificateHolder.getEncoded()));
      return paramX509CertificateHolder;
    }
    catch (NoSuchProviderException paramX509CertificateHolder)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find factory provider: ");
      localStringBuilder.append(paramX509CertificateHolder.getMessage());
      throw new OpCertificateException(localStringBuilder.toString(), paramX509CertificateHolder);
    }
    catch (IOException paramX509CertificateHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot get encoded form of certificate: ");
      localStringBuilder.append(paramX509CertificateHolder.getMessage());
      throw new OpCertificateException(localStringBuilder.toString(), paramX509CertificateHolder);
    }
  }
  
  public PublicKey convertPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws OperatorCreationException
  {
    try
    {
      paramSubjectPublicKeyInfo = this.helper.createKeyFactory(paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm().getId()).generatePublic(new X509EncodedKeySpec(paramSubjectPublicKeyInfo.getEncoded()));
      return paramSubjectPublicKeyInfo;
    }
    catch (InvalidKeySpecException paramSubjectPublicKeyInfo)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot create key factory: ");
      localStringBuilder.append(paramSubjectPublicKeyInfo.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramSubjectPublicKeyInfo);
    }
    catch (NoSuchProviderException paramSubjectPublicKeyInfo)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find factory provider: ");
      localStringBuilder.append(paramSubjectPublicKeyInfo.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramSubjectPublicKeyInfo);
    }
    catch (NoSuchAlgorithmException paramSubjectPublicKeyInfo)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot create key factory: ");
      localStringBuilder.append(paramSubjectPublicKeyInfo.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramSubjectPublicKeyInfo);
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot get encoded form of key: ");
      localStringBuilder.append(paramSubjectPublicKeyInfo.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramSubjectPublicKeyInfo);
    }
  }
  
  AlgorithmParameters createAlgorithmParameters(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException
  {
    if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption)) {
      return null;
    }
    try
    {
      Object localObject = this.helper.createAlgorithmParameters(paramAlgorithmIdentifier.getAlgorithm().getId());
      try
      {
        ((AlgorithmParameters)localObject).init(paramAlgorithmIdentifier.getParameters().toASN1Primitive().getEncoded());
        return (AlgorithmParameters)localObject;
      }
      catch (IOException paramAlgorithmIdentifier)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cannot initialise algorithm parameters: ");
        ((StringBuilder)localObject).append(paramAlgorithmIdentifier.getMessage());
        throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramAlgorithmIdentifier);
      }
      return null;
    }
    catch (NoSuchProviderException paramAlgorithmIdentifier)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create algorithm parameters: ");
      ((StringBuilder)localObject).append(paramAlgorithmIdentifier.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramAlgorithmIdentifier);
    }
    catch (NoSuchAlgorithmException paramAlgorithmIdentifier) {}
  }
  
  Cipher createAsymmetricWrapper(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Map paramMap)
    throws OperatorCreationException
  {
    Object localObject = null;
    try
    {
      if (!paramMap.isEmpty()) {
        localObject = (String)paramMap.get(paramASN1ObjectIdentifier);
      }
      paramMap = (Map)localObject;
      if (localObject == null) {
        paramMap = (String)asymmetricWrapperAlgNames.get(paramASN1ObjectIdentifier);
      }
      if (paramMap == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label64:
      boolean bool;
      paramMap = new StringBuilder();
      paramMap.append("cannot create cipher: ");
      paramMap.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramMap.toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createCipher(paramMap);
      return (Cipher)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label64;
    }
    bool = paramMap.equals("RSA/ECB/PKCS1Padding");
    if (bool) {}
    try
    {
      paramMap = this.helper.createCipher("RSA/NONE/PKCS1Padding");
      return paramMap;
    }
    catch (NoSuchAlgorithmException paramMap)
    {
      for (;;) {}
    }
    paramASN1ObjectIdentifier = this.helper.createCipher(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  MessageDigest createDigest(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws GeneralSecurityException
  {
    try
    {
      MessageDigest localMessageDigest = this.helper.createDigest(MessageDigestUtils.getDigestName(paramAlgorithmIdentifier.getAlgorithm()));
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      if (oids.get(paramAlgorithmIdentifier.getAlgorithm()) != null)
      {
        paramAlgorithmIdentifier = (String)oids.get(paramAlgorithmIdentifier.getAlgorithm());
        return this.helper.createDigest(paramAlgorithmIdentifier);
      }
      throw localNoSuchAlgorithmException;
    }
  }
  
  public Signature createRawSignature(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    try
    {
      Object localObject1 = getSignatureName(paramAlgorithmIdentifier);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NONE");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(((String)localObject1).indexOf("WITH")));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = this.helper.createSignature((String)localObject2);
      if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS))
      {
        localObject2 = this.helper.createAlgorithmParameters((String)localObject2);
        AlgorithmParametersUtils.loadParameters((AlgorithmParameters)localObject2, paramAlgorithmIdentifier.getParameters());
        ((Signature)localObject1).setParameter((PSSParameterSpec)((AlgorithmParameters)localObject2).getParameterSpec(PSSParameterSpec.class));
      }
      return (Signature)localObject1;
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      for (;;) {}
    }
    return null;
  }
  
  Signature createSignature(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws GeneralSecurityException
  {
    try
    {
      Signature localSignature = this.helper.createSignature(getSignatureName(paramAlgorithmIdentifier));
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      if (oids.get(paramAlgorithmIdentifier.getAlgorithm()) == null) {
        break label163;
      }
    }
    Object localObject = (String)oids.get(paramAlgorithmIdentifier.getAlgorithm());
    localObject = this.helper.createSignature((String)localObject);
    if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS))
    {
      paramAlgorithmIdentifier = ASN1Sequence.getInstance(paramAlgorithmIdentifier.getParameters());
      if (notDefaultPSSParams(paramAlgorithmIdentifier)) {
        try
        {
          AlgorithmParameters localAlgorithmParameters = this.helper.createAlgorithmParameters("PSS");
          localAlgorithmParameters.init(paramAlgorithmIdentifier.getEncoded());
          ((Signature)localObject).setParameter(localAlgorithmParameters.getParameterSpec(PSSParameterSpec.class));
          return (Signature)localObject;
        }
        catch (IOException paramAlgorithmIdentifier)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unable to process PSS parameters: ");
          ((StringBuilder)localObject).append(paramAlgorithmIdentifier.getMessage());
          throw new GeneralSecurityException(((StringBuilder)localObject).toString());
        }
      }
    }
    return (Signature)localObject;
    label163:
    throw ((Throwable)localObject);
  }
  
  Cipher createSymmetricWrapper(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws OperatorCreationException
  {
    try
    {
      localObject = (String)symmetricWrapperAlgNames.get(paramASN1ObjectIdentifier);
      if (localObject == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label30:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create cipher: ");
      ((StringBuilder)localObject).append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createCipher((String)localObject);
      return (Cipher)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label30;
    }
    paramASN1ObjectIdentifier = this.helper.createCipher(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  String getKeyAlgorithmName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    String str = (String)symmetricKeyAlgNames.get(paramASN1ObjectIdentifier);
    if (str != null) {
      return str;
    }
    return paramASN1ObjectIdentifier.getId();
  }
  
  int getKeySizeInBits(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return ((Integer)symmetricWrapperKeySizes.get(paramASN1ObjectIdentifier)).intValue();
  }
  
  String getWrappingAlgorithmName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (String)symmetricWrapperAlgNames.get(paramASN1ObjectIdentifier);
  }
  
  private static class OpCertificateException
    extends CertificateException
  {
    private Throwable cause;
    
    public OpCertificateException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\OperatorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */