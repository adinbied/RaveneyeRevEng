package org.bouncycastle.operator.jcajce;

import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.PSource.PSpecified;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAESOAEPparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

public class JceAsymmetricKeyWrapper
  extends AsymmetricKeyWrapper
{
  private static final Map digests;
  private Map extraMappings = new HashMap();
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private PublicKey publicKey;
  private SecureRandom random;
  
  static
  {
    HashMap localHashMap = new HashMap();
    digests = localHashMap;
    localHashMap.put("SHA-1", new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE));
    digests.put("SHA-1", new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE));
    digests.put("SHA224", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE));
    digests.put("SHA-224", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE));
    digests.put("SHA256", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE));
    digests.put("SHA-256", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE));
    digests.put("SHA384", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE));
    digests.put("SHA-384", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE));
    digests.put("SHA512", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE));
    digests.put("SHA-512", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE));
    digests.put("SHA512/224", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_224, DERNull.INSTANCE));
    digests.put("SHA-512/224", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_224, DERNull.INSTANCE));
    digests.put("SHA-512(224)", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_224, DERNull.INSTANCE));
    digests.put("SHA512/256", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256, DERNull.INSTANCE));
    digests.put("SHA-512/256", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256, DERNull.INSTANCE));
    digests.put("SHA-512(256)", new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256, DERNull.INSTANCE));
  }
  
  public JceAsymmetricKeyWrapper(PublicKey paramPublicKey)
  {
    super(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()).getAlgorithm());
    this.publicKey = paramPublicKey;
  }
  
  public JceAsymmetricKeyWrapper(X509Certificate paramX509Certificate)
  {
    this(paramX509Certificate.getPublicKey());
  }
  
  public JceAsymmetricKeyWrapper(AlgorithmParameterSpec paramAlgorithmParameterSpec, PublicKey paramPublicKey)
  {
    super(extractFromSpec(paramAlgorithmParameterSpec));
    this.publicKey = paramPublicKey;
  }
  
  public JceAsymmetricKeyWrapper(AlgorithmIdentifier paramAlgorithmIdentifier, PublicKey paramPublicKey)
  {
    super(paramAlgorithmIdentifier);
    this.publicKey = paramPublicKey;
  }
  
  private static AlgorithmIdentifier extractFromSpec(AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    if ((paramAlgorithmParameterSpec instanceof OAEPParameterSpec))
    {
      paramAlgorithmParameterSpec = (OAEPParameterSpec)paramAlgorithmParameterSpec;
      if (paramAlgorithmParameterSpec.getMGFAlgorithm().equals(OAEPParameterSpec.DEFAULT.getMGFAlgorithm()))
      {
        if ((paramAlgorithmParameterSpec.getPSource() instanceof PSource.PSpecified)) {
          return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_RSAES_OAEP, new RSAESOAEPparams(getDigest(paramAlgorithmParameterSpec.getDigestAlgorithm()), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, getDigest(((MGF1ParameterSpec)paramAlgorithmParameterSpec.getMGFParameters()).getDigestAlgorithm())), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(((PSource.PSpecified)paramAlgorithmParameterSpec.getPSource()).getValue()))));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unknown PSource: ");
        localStringBuilder.append(paramAlgorithmParameterSpec.getPSource().getAlgorithm());
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown MGF: ");
      localStringBuilder.append(paramAlgorithmParameterSpec.getMGFAlgorithm());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown spec: ");
    localStringBuilder.append(paramAlgorithmParameterSpec.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static AlgorithmIdentifier getDigest(String paramString)
  {
    Object localObject = (AlgorithmIdentifier)digests.get(paramString);
    if (localObject != null) {
      return (AlgorithmIdentifier)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown digest name: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public byte[] generateWrappedKey(GenericKey paramGenericKey)
    throws OperatorException
  {
    Cipher localCipher = this.helper.createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm(), this.extraMappings);
    Object localObject = this.helper.createAlgorithmParameters(getAlgorithmIdentifier());
    if (localObject != null) {}
    try
    {
      localCipher.init(3, this.publicKey, (AlgorithmParameters)localObject, this.random);
      break label65;
      localCipher.init(3, this.publicKey, this.random);
      label65:
      localObject = localCipher.wrap(OperatorUtils.getJceKey(paramGenericKey));
    }
    catch (InvalidKeyException|GeneralSecurityException|IllegalStateException|UnsupportedOperationException|ProviderException localInvalidKeyException)
    {
      for (;;) {}
    }
    localObject = null;
    if (localObject == null) {
      try
      {
        localCipher.init(1, this.publicKey, this.random);
        paramGenericKey = localCipher.doFinal(OperatorUtils.getJceKey(paramGenericKey).getEncoded());
        return paramGenericKey;
      }
      catch (GeneralSecurityException paramGenericKey)
      {
        throw new OperatorException("unable to encrypt contents key", paramGenericKey);
      }
      catch (InvalidKeyException paramGenericKey)
      {
        throw new OperatorException("unable to encrypt contents key", paramGenericKey);
      }
    }
    return (byte[])localObject;
  }
  
  public JceAsymmetricKeyWrapper setAlgorithmMapping(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    this.extraMappings.put(paramASN1ObjectIdentifier, paramString);
    return this;
  }
  
  public JceAsymmetricKeyWrapper setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceAsymmetricKeyWrapper setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  public JceAsymmetricKeyWrapper setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceAsymmetricKeyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */