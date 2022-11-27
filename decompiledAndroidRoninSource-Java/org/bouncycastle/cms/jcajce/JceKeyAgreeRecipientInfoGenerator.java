package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import org.bouncycastle.asn1.cms.RecipientEncryptedKey;
import org.bouncycastle.asn1.cms.RecipientKeyIdentifier;
import org.bouncycastle.asn1.cms.ecc.MQVuserKeyingMaterial;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyAgreeRecipientInfoGenerator;
import org.bouncycastle.jcajce.spec.MQVParameterSpec;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.util.Arrays;

public class JceKeyAgreeRecipientInfoGenerator
  extends KeyAgreeRecipientInfoGenerator
{
  private static KeyMaterialGenerator ecc_cms_Generator = new RFC5753KeyMaterialGenerator();
  private KeyPair ephemeralKP;
  private EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  private SecretKeySizeProvider keySizeProvider = new DefaultSecretKeySizeProvider();
  private SecureRandom random;
  private List recipientIDs = new ArrayList();
  private List recipientKeys = new ArrayList();
  private PrivateKey senderPrivateKey;
  private PublicKey senderPublicKey;
  private byte[] userKeyingMaterial;
  
  public JceKeyAgreeRecipientInfoGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier1, PrivateKey paramPrivateKey, PublicKey paramPublicKey, ASN1ObjectIdentifier paramASN1ObjectIdentifier2)
  {
    super(paramASN1ObjectIdentifier1, SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()), paramASN1ObjectIdentifier2);
    this.senderPublicKey = paramPublicKey;
    this.senderPrivateKey = paramPrivateKey;
  }
  
  private void init(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CMSException
  {
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    if ((CMSUtils.isMQV(paramASN1ObjectIdentifier)) && (this.ephemeralKP == null)) {
      try
      {
        SubjectPublicKeyInfo localSubjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(this.senderPublicKey.getEncoded());
        localObject = this.helper.createAlgorithmParameters(paramASN1ObjectIdentifier);
        ((AlgorithmParameters)localObject).init(localSubjectPublicKeyInfo.getAlgorithm().getParameters().toASN1Primitive().getEncoded());
        paramASN1ObjectIdentifier = this.helper.createKeyPairGenerator(paramASN1ObjectIdentifier);
        paramASN1ObjectIdentifier.initialize(((AlgorithmParameters)localObject).getParameterSpec(AlgorithmParameterSpec.class), this.random);
        this.ephemeralKP = paramASN1ObjectIdentifier.generateKeyPair();
        return;
      }
      catch (Exception paramASN1ObjectIdentifier)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cannot determine MQV ephemeral key pair parameters from public key: ");
        ((StringBuilder)localObject).append(paramASN1ObjectIdentifier);
        throw new CMSException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
      }
    }
  }
  
  public JceKeyAgreeRecipientInfoGenerator addRecipient(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    this.recipientIDs.add(new KeyAgreeRecipientIdentifier(CMSUtils.getIssuerAndSerialNumber(paramX509Certificate)));
    this.recipientKeys.add(paramX509Certificate.getPublicKey());
    return this;
  }
  
  public JceKeyAgreeRecipientInfoGenerator addRecipient(byte[] paramArrayOfByte, PublicKey paramPublicKey)
    throws CertificateEncodingException
  {
    this.recipientIDs.add(new KeyAgreeRecipientIdentifier(new RecipientKeyIdentifier(paramArrayOfByte)));
    this.recipientKeys.add(paramPublicKey);
    return this;
  }
  
  public ASN1Sequence generateRecipientEncryptedKeys(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, GenericKey paramGenericKey)
    throws CMSException
  {
    if (!this.recipientIDs.isEmpty())
    {
      init(paramAlgorithmIdentifier1.getAlgorithm());
      PrivateKey localPrivateKey = this.senderPrivateKey;
      ASN1ObjectIdentifier localASN1ObjectIdentifier = paramAlgorithmIdentifier1.getAlgorithm();
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      int i = 0;
      while (i != this.recipientIDs.size())
      {
        Object localObject = (PublicKey)this.recipientKeys.get(i);
        KeyAgreeRecipientIdentifier localKeyAgreeRecipientIdentifier = (KeyAgreeRecipientIdentifier)this.recipientIDs.get(i);
        try
        {
          if (CMSUtils.isMQV(localASN1ObjectIdentifier))
          {
            paramAlgorithmIdentifier1 = new MQVParameterSpec(this.ephemeralKP, (PublicKey)localObject, this.userKeyingMaterial);
          }
          else if (CMSUtils.isEC(localASN1ObjectIdentifier))
          {
            paramAlgorithmIdentifier1 = new UserKeyingMaterialSpec(ecc_cms_Generator.generateKDFMaterial(paramAlgorithmIdentifier2, this.keySizeProvider.getKeySize(paramAlgorithmIdentifier2.getAlgorithm()), this.userKeyingMaterial));
          }
          else
          {
            if (!CMSUtils.isRFC2631(localASN1ObjectIdentifier)) {
              break label330;
            }
            if (this.userKeyingMaterial != null)
            {
              paramAlgorithmIdentifier1 = new UserKeyingMaterialSpec(this.userKeyingMaterial);
            }
            else
            {
              if (localASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_alg_SSDH)) {
                break label319;
              }
              paramAlgorithmIdentifier1 = null;
            }
          }
          KeyAgreement localKeyAgreement = this.helper.createKeyAgreement(localASN1ObjectIdentifier);
          localKeyAgreement.init(localPrivateKey, paramAlgorithmIdentifier1, this.random);
          localKeyAgreement.doPhase((Key)localObject, true);
          paramAlgorithmIdentifier1 = localKeyAgreement.generateSecret(paramAlgorithmIdentifier2.getAlgorithm().getId());
          localObject = this.helper.createCipher(paramAlgorithmIdentifier2.getAlgorithm());
          ((Cipher)localObject).init(3, paramAlgorithmIdentifier1, this.random);
          localASN1EncodableVector.add(new RecipientEncryptedKey(localKeyAgreeRecipientIdentifier, new DEROctetString(((Cipher)localObject).wrap(this.helper.getJceKey(paramGenericKey)))));
          i += 1;
          continue;
          label319:
          throw new CMSException("User keying material must be set for static keys.");
          label330:
          paramAlgorithmIdentifier1 = new StringBuilder();
          paramAlgorithmIdentifier1.append("Unknown key agreement algorithm: ");
          paramAlgorithmIdentifier1.append(localASN1ObjectIdentifier);
          throw new CMSException(paramAlgorithmIdentifier1.toString());
        }
        catch (GeneralSecurityException paramAlgorithmIdentifier1)
        {
          paramAlgorithmIdentifier2 = new StringBuilder();
          paramAlgorithmIdentifier2.append("Cannot perform agreement step: ");
          paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
          throw new CMSException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
        }
      }
      return new DERSequence(localASN1EncodableVector);
    }
    throw new CMSException("No recipients associated with generator - use addRecipient()");
  }
  
  protected byte[] getUserKeyingMaterial(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws CMSException
  {
    init(paramAlgorithmIdentifier.getAlgorithm());
    paramAlgorithmIdentifier = this.ephemeralKP;
    if (paramAlgorithmIdentifier != null)
    {
      paramAlgorithmIdentifier = createOriginatorPublicKey(SubjectPublicKeyInfo.getInstance(paramAlgorithmIdentifier.getPublic().getEncoded()));
      try
      {
        if (this.userKeyingMaterial != null) {
          return new MQVuserKeyingMaterial(paramAlgorithmIdentifier, new DEROctetString(this.userKeyingMaterial)).getEncoded();
        }
        paramAlgorithmIdentifier = new MQVuserKeyingMaterial(paramAlgorithmIdentifier, null).getEncoded();
        return paramAlgorithmIdentifier;
      }
      catch (IOException paramAlgorithmIdentifier)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unable to encode user keying material: ");
        localStringBuilder.append(paramAlgorithmIdentifier.getMessage());
        throw new CMSException(localStringBuilder.toString(), paramAlgorithmIdentifier);
      }
    }
    return this.userKeyingMaterial;
  }
  
  public JceKeyAgreeRecipientInfoGenerator setProvider(String paramString)
  {
    this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JceKeyAgreeRecipientInfoGenerator setProvider(Provider paramProvider)
  {
    this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
  
  public JceKeyAgreeRecipientInfoGenerator setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  public JceKeyAgreeRecipientInfoGenerator setUserKeyingMaterial(byte[] paramArrayOfByte)
  {
    this.userKeyingMaterial = Arrays.clone(paramArrayOfByte);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKeyAgreeRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */