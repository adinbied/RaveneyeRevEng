package org.bouncycastle.operator.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.cms.GenericHybridParameters;
import org.bouncycastle.asn1.cms.RsaKemParameters;
import org.bouncycastle.asn1.iso.ISOIECObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.util.DEROtherInfo;
import org.bouncycastle.crypto.util.DEROtherInfo.Builder;
import org.bouncycastle.jcajce.spec.KTSParameterSpec.Builder;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.util.Arrays;

public class JceKTSKeyWrapper
  extends AsymmetricKeyWrapper
{
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private final int keySizeInBits;
  private final byte[] partyUInfo;
  private final byte[] partyVInfo;
  private PublicKey publicKey;
  private SecureRandom random;
  private final String symmetricWrappingAlg;
  
  public JceKTSKeyWrapper(PublicKey paramPublicKey, String paramString, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_rsa_KEM, new GenericHybridParameters(new AlgorithmIdentifier(ISOIECObjectIdentifiers.id_kem_rsa, new RsaKemParameters(new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256)), (paramInt + 7) / 8)), JceSymmetricKeyWrapper.determineKeyEncAlg(paramString, paramInt))));
    this.publicKey = paramPublicKey;
    this.symmetricWrappingAlg = paramString;
    this.keySizeInBits = paramInt;
    this.partyUInfo = Arrays.clone(paramArrayOfByte1);
    this.partyVInfo = Arrays.clone(paramArrayOfByte2);
  }
  
  public JceKTSKeyWrapper(X509Certificate paramX509Certificate, String paramString, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramX509Certificate.getPublicKey(), paramString, paramInt, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public byte[] generateWrappedKey(GenericKey paramGenericKey)
    throws OperatorException
  {
    Object localObject1 = this.helper.createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm(), new HashMap());
    try
    {
      Object localObject2 = new DEROtherInfo.Builder(JceSymmetricKeyWrapper.determineKeyEncAlg(this.symmetricWrappingAlg, this.keySizeInBits), this.partyUInfo, this.partyVInfo).build();
      localObject2 = new KTSParameterSpec.Builder(this.symmetricWrappingAlg, this.keySizeInBits, ((DEROtherInfo)localObject2).getEncoded()).build();
      ((Cipher)localObject1).init(3, this.publicKey, (AlgorithmParameterSpec)localObject2, this.random);
      paramGenericKey = ((Cipher)localObject1).wrap(OperatorUtils.getJceKey(paramGenericKey));
      return paramGenericKey;
    }
    catch (Exception paramGenericKey)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unable to wrap contents key: ");
      ((StringBuilder)localObject1).append(paramGenericKey.getMessage());
      throw new OperatorException(((StringBuilder)localObject1).toString(), paramGenericKey);
    }
  }
  
  public JceKTSKeyWrapper setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceKTSKeyWrapper setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  public JceKTSKeyWrapper setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceKTSKeyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */