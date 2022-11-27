package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;
import org.bouncycastle.asn1.cms.ecc.ECCCMSSharedInfo;
import org.bouncycastle.asn1.cms.ecc.MQVuserKeyingMaterial;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyAgreeRecipient;
import org.bouncycastle.jcajce.spec.MQVParameterSpec;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.util.Pack;

public abstract class JceKeyAgreeRecipient
  implements KeyAgreeRecipient
{
  private static KeyMaterialGenerator ecc_cms_Generator = new RFC5753KeyMaterialGenerator();
  private static KeyMaterialGenerator old_ecc_cms_Generator;
  private static final Set possibleOldMessages;
  protected EnvelopedDataHelper contentHelper;
  protected EnvelopedDataHelper helper;
  private SecretKeySizeProvider keySizeProvider;
  private PrivateKey recipientKey;
  
  static
  {
    HashSet localHashSet = new HashSet();
    possibleOldMessages = localHashSet;
    localHashSet.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
    possibleOldMessages.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
    old_ecc_cms_Generator = new KeyMaterialGenerator()
    {
      public byte[] generateKDFMaterial(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        paramAnonymousAlgorithmIdentifier = new ECCCMSSharedInfo(new AlgorithmIdentifier(paramAnonymousAlgorithmIdentifier.getAlgorithm(), DERNull.INSTANCE), paramAnonymousArrayOfByte, Pack.intToBigEndian(paramAnonymousInt));
        try
        {
          paramAnonymousAlgorithmIdentifier = paramAnonymousAlgorithmIdentifier.getEncoded("DER");
          return paramAnonymousAlgorithmIdentifier;
        }
        catch (IOException paramAnonymousAlgorithmIdentifier)
        {
          paramAnonymousArrayOfByte = new StringBuilder();
          paramAnonymousArrayOfByte.append("Unable to create KDF material: ");
          paramAnonymousArrayOfByte.append(paramAnonymousAlgorithmIdentifier);
          throw new IllegalStateException(paramAnonymousArrayOfByte.toString());
        }
      }
    };
  }
  
  public JceKeyAgreeRecipient(PrivateKey paramPrivateKey)
  {
    EnvelopedDataHelper localEnvelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    this.helper = localEnvelopedDataHelper;
    this.contentHelper = localEnvelopedDataHelper;
    this.keySizeProvider = new DefaultSecretKeySizeProvider();
    this.recipientKey = paramPrivateKey;
  }
  
  private SecretKey calculateAgreedWrapKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, PublicKey paramPublicKey, ASN1OctetString paramASN1OctetString, PrivateKey paramPrivateKey, KeyMaterialGenerator paramKeyMaterialGenerator)
    throws CMSException, GeneralSecurityException, IOException
  {
    boolean bool = CMSUtils.isMQV(paramAlgorithmIdentifier1.getAlgorithm());
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      paramASN1OctetString = MQVuserKeyingMaterial.getInstance(paramASN1OctetString.getOctets());
      localObject2 = new X509EncodedKeySpec(new SubjectPublicKeyInfo(getPrivateKeyAlgorithmIdentifier(), paramASN1OctetString.getEphemeralPublicKey().getPublicKey().getBytes()).getEncoded());
      localObject2 = this.helper.createKeyFactory(paramAlgorithmIdentifier1.getAlgorithm()).generatePublic((KeySpec)localObject2);
      KeyAgreement localKeyAgreement = this.helper.createKeyAgreement(paramAlgorithmIdentifier1.getAlgorithm());
      paramAlgorithmIdentifier1 = (AlgorithmIdentifier)localObject1;
      if (paramASN1OctetString.getAddedukm() != null) {
        paramAlgorithmIdentifier1 = paramASN1OctetString.getAddedukm().getOctets();
      }
      localObject1 = old_ecc_cms_Generator;
      paramASN1OctetString = paramAlgorithmIdentifier1;
      if (paramKeyMaterialGenerator == localObject1) {
        paramASN1OctetString = ((KeyMaterialGenerator)localObject1).generateKDFMaterial(paramAlgorithmIdentifier2, this.keySizeProvider.getKeySize(paramAlgorithmIdentifier2), paramAlgorithmIdentifier1);
      }
      localKeyAgreement.init(paramPrivateKey, new MQVParameterSpec(paramPrivateKey, (PublicKey)localObject2, paramASN1OctetString));
      localKeyAgreement.doPhase(paramPublicKey, true);
      return localKeyAgreement.generateSecret(paramAlgorithmIdentifier2.getAlgorithm().getId());
    }
    localObject1 = this.helper.createKeyAgreement(paramAlgorithmIdentifier1.getAlgorithm());
    if (CMSUtils.isEC(paramAlgorithmIdentifier1.getAlgorithm()))
    {
      int i = this.keySizeProvider.getKeySize(paramAlgorithmIdentifier2);
      if (paramASN1OctetString != null) {
        paramAlgorithmIdentifier1 = new UserKeyingMaterialSpec(paramKeyMaterialGenerator.generateKDFMaterial(paramAlgorithmIdentifier2, i, paramASN1OctetString.getOctets()));
      } else {
        paramAlgorithmIdentifier1 = new UserKeyingMaterialSpec(paramKeyMaterialGenerator.generateKDFMaterial(paramAlgorithmIdentifier2, i, null));
      }
    }
    else
    {
      if (!CMSUtils.isRFC2631(paramAlgorithmIdentifier1.getAlgorithm())) {
        break label340;
      }
      paramAlgorithmIdentifier1 = (AlgorithmIdentifier)localObject2;
      if (paramASN1OctetString != null) {
        paramAlgorithmIdentifier1 = new UserKeyingMaterialSpec(paramASN1OctetString.getOctets());
      }
    }
    ((KeyAgreement)localObject1).init(paramPrivateKey, paramAlgorithmIdentifier1);
    ((KeyAgreement)localObject1).doPhase(paramPublicKey, true);
    return ((KeyAgreement)localObject1).generateSecret(paramAlgorithmIdentifier2.getAlgorithm().getId());
    label340:
    paramAlgorithmIdentifier2 = new StringBuilder();
    paramAlgorithmIdentifier2.append("Unknown key agreement algorithm: ");
    paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getAlgorithm());
    throw new CMSException(paramAlgorithmIdentifier2.toString());
  }
  
  private Key unwrapSessionKey(ASN1ObjectIdentifier paramASN1ObjectIdentifier1, SecretKey paramSecretKey, ASN1ObjectIdentifier paramASN1ObjectIdentifier2, byte[] paramArrayOfByte)
    throws CMSException, InvalidKeyException, NoSuchAlgorithmException
  {
    paramASN1ObjectIdentifier1 = this.helper.createCipher(paramASN1ObjectIdentifier1);
    paramASN1ObjectIdentifier1.init(4, paramSecretKey);
    return paramASN1ObjectIdentifier1.unwrap(paramArrayOfByte, this.helper.getBaseCipherName(paramASN1ObjectIdentifier2), 3);
  }
  
  /* Error */
  protected Key extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, SubjectPublicKeyInfo paramSubjectPublicKeyInfo, ASN1OctetString paramASN1OctetString, byte[] paramArrayOfByte)
    throws CMSException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 256	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getParameters	()Lorg/bouncycastle/asn1/ASN1Encodable;
    //   4: invokestatic 259	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   7: astore 6
    //   9: new 108	java/security/spec/X509EncodedKeySpec
    //   12: dup
    //   13: aload_3
    //   14: invokevirtual 135	org/bouncycastle/asn1/x509/SubjectPublicKeyInfo:getEncoded	()[B
    //   17: invokespecial 138	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   20: astore 7
    //   22: aload_0
    //   23: getfield 65	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:helper	Lorg/bouncycastle/cms/jcajce/EnvelopedDataHelper;
    //   26: aload_3
    //   27: invokevirtual 261	org/bouncycastle/asn1/x509/SubjectPublicKeyInfo:getAlgorithm	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   30: invokevirtual 88	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   33: invokevirtual 142	org/bouncycastle/cms/jcajce/EnvelopedDataHelper:createKeyFactory	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)Ljava/security/KeyFactory;
    //   36: aload 7
    //   38: invokevirtual 148	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   41: astore_3
    //   42: aload_0
    //   43: aload_1
    //   44: aload 6
    //   46: aload_3
    //   47: aload 4
    //   49: aload_0
    //   50: getfield 74	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:recipientKey	Ljava/security/PrivateKey;
    //   53: getstatic 52	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:ecc_cms_Generator	Lorg/bouncycastle/cms/jcajce/KeyMaterialGenerator;
    //   56: invokespecial 263	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:calculateAgreedWrapKey	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Ljava/security/PublicKey;Lorg/bouncycastle/asn1/ASN1OctetString;Ljava/security/PrivateKey;Lorg/bouncycastle/cms/jcajce/KeyMaterialGenerator;)Ljavax/crypto/SecretKey;
    //   59: astore 7
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 88	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   67: aload 7
    //   69: aload_2
    //   70: invokevirtual 88	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   73: aload 5
    //   75: invokespecial 265	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:unwrapSessionKey	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Ljavax/crypto/SecretKey;Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;[B)Ljava/security/Key;
    //   78: astore 7
    //   80: aload 7
    //   82: areturn
    //   83: astore 7
    //   85: getstatic 29	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:possibleOldMessages	Ljava/util/Set;
    //   88: aload_1
    //   89: invokevirtual 88	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   92: invokeinterface 268 2 0
    //   97: ifeq +38 -> 135
    //   100: aload_0
    //   101: aload_1
    //   102: aload 6
    //   104: aload_3
    //   105: aload 4
    //   107: aload_0
    //   108: getfield 74	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:recipientKey	Ljava/security/PrivateKey;
    //   111: getstatic 47	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:old_ecc_cms_Generator	Lorg/bouncycastle/cms/jcajce/KeyMaterialGenerator;
    //   114: invokespecial 263	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:calculateAgreedWrapKey	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Ljava/security/PublicKey;Lorg/bouncycastle/asn1/ASN1OctetString;Ljava/security/PrivateKey;Lorg/bouncycastle/cms/jcajce/KeyMaterialGenerator;)Ljavax/crypto/SecretKey;
    //   117: astore_1
    //   118: aload_0
    //   119: aload 6
    //   121: invokevirtual 88	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   124: aload_1
    //   125: aload_2
    //   126: invokevirtual 88	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   129: aload 5
    //   131: invokespecial 265	org/bouncycastle/cms/jcajce/JceKeyAgreeRecipient:unwrapSessionKey	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Ljavax/crypto/SecretKey;Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;[B)Ljava/security/Key;
    //   134: areturn
    //   135: aload 7
    //   137: athrow
    //   138: astore_1
    //   139: new 78	org/bouncycastle/cms/CMSException
    //   142: dup
    //   143: ldc_w 270
    //   146: aload_1
    //   147: invokespecial 273	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   150: athrow
    //   151: astore_1
    //   152: new 78	org/bouncycastle/cms/CMSException
    //   155: dup
    //   156: ldc_w 275
    //   159: aload_1
    //   160: invokespecial 273	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   163: athrow
    //   164: astore_1
    //   165: new 78	org/bouncycastle/cms/CMSException
    //   168: dup
    //   169: ldc_w 277
    //   172: aload_1
    //   173: invokespecial 273	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   176: athrow
    //   177: astore_1
    //   178: new 78	org/bouncycastle/cms/CMSException
    //   181: dup
    //   182: ldc_w 279
    //   185: aload_1
    //   186: invokespecial 273	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   189: athrow
    //   190: astore_1
    //   191: new 78	org/bouncycastle/cms/CMSException
    //   194: dup
    //   195: ldc_w 281
    //   198: aload_1
    //   199: invokespecial 273	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	JceKeyAgreeRecipient
    //   0	203	1	paramAlgorithmIdentifier1	AlgorithmIdentifier
    //   0	203	2	paramAlgorithmIdentifier2	AlgorithmIdentifier
    //   0	203	3	paramSubjectPublicKeyInfo	SubjectPublicKeyInfo
    //   0	203	4	paramASN1OctetString	ASN1OctetString
    //   0	203	5	paramArrayOfByte	byte[]
    //   7	113	6	localAlgorithmIdentifier	AlgorithmIdentifier
    //   20	61	7	localObject	Object
    //   83	53	7	localInvalidKeyException	InvalidKeyException
    // Exception table:
    //   from	to	target	type
    //   42	80	83	java/security/InvalidKeyException
    //   0	42	138	java/lang/Exception
    //   42	80	138	java/lang/Exception
    //   85	135	138	java/lang/Exception
    //   135	138	138	java/lang/Exception
    //   0	42	151	javax/crypto/NoSuchPaddingException
    //   42	80	151	javax/crypto/NoSuchPaddingException
    //   85	135	151	javax/crypto/NoSuchPaddingException
    //   135	138	151	javax/crypto/NoSuchPaddingException
    //   0	42	164	java/security/spec/InvalidKeySpecException
    //   42	80	164	java/security/spec/InvalidKeySpecException
    //   85	135	164	java/security/spec/InvalidKeySpecException
    //   135	138	164	java/security/spec/InvalidKeySpecException
    //   0	42	177	java/security/InvalidKeyException
    //   85	135	177	java/security/InvalidKeyException
    //   135	138	177	java/security/InvalidKeyException
    //   0	42	190	java/security/NoSuchAlgorithmException
    //   42	80	190	java/security/NoSuchAlgorithmException
    //   85	135	190	java/security/NoSuchAlgorithmException
    //   135	138	190	java/security/NoSuchAlgorithmException
  }
  
  public AlgorithmIdentifier getPrivateKeyAlgorithmIdentifier()
  {
    return PrivateKeyInfo.getInstance(this.recipientKey.getEncoded()).getPrivateKeyAlgorithm();
  }
  
  public JceKeyAgreeRecipient setContentProvider(String paramString)
  {
    this.contentHelper = CMSUtils.createContentHelper(paramString);
    return this;
  }
  
  public JceKeyAgreeRecipient setContentProvider(Provider paramProvider)
  {
    this.contentHelper = CMSUtils.createContentHelper(paramProvider);
    return this;
  }
  
  public JceKeyAgreeRecipient setProvider(String paramString)
  {
    paramString = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    this.helper = paramString;
    this.contentHelper = paramString;
    return this;
  }
  
  public JceKeyAgreeRecipient setProvider(Provider paramProvider)
  {
    paramProvider = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    this.helper = paramProvider;
    this.contentHelper = paramProvider;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKeyAgreeRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */