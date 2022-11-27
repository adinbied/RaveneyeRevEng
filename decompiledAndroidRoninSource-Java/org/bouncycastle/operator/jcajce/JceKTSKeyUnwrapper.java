package org.bouncycastle.operator.jcajce;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.cms.GenericHybridParameters;
import org.bouncycastle.asn1.cms.RsaKemParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.util.DEROtherInfo;
import org.bouncycastle.crypto.util.DEROtherInfo.Builder;
import org.bouncycastle.jcajce.spec.KTSParameterSpec.Builder;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.util.Arrays;

public class JceKTSKeyUnwrapper
  extends AsymmetricKeyUnwrapper
{
  private Map extraMappings = new HashMap();
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private byte[] partyUInfo;
  private byte[] partyVInfo;
  private PrivateKey privKey;
  
  public JceKTSKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, PrivateKey paramPrivateKey, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramAlgorithmIdentifier);
    this.privKey = paramPrivateKey;
    this.partyUInfo = Arrays.clone(paramArrayOfByte1);
    this.partyVInfo = Arrays.clone(paramArrayOfByte2);
  }
  
  public GenericKey generateUnwrappedKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
    throws OperatorException
  {
    Object localObject = GenericHybridParameters.getInstance(getAlgorithmIdentifier().getParameters());
    Cipher localCipher = this.helper.createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm(), this.extraMappings);
    String str = this.helper.getWrappingAlgorithmName(((GenericHybridParameters)localObject).getDem().getAlgorithm());
    RsaKemParameters localRsaKemParameters = RsaKemParameters.getInstance(((GenericHybridParameters)localObject).getKem().getParameters());
    int i = localRsaKemParameters.getKeyLength().intValue();
    try
    {
      localObject = new KTSParameterSpec.Builder(str, i * 8, new DEROtherInfo.Builder(((GenericHybridParameters)localObject).getDem(), this.partyUInfo, this.partyVInfo).build().getEncoded()).withKdfAlgorithm(localRsaKemParameters.getKeyDerivationFunction()).build();
      localCipher.init(4, this.privKey, (AlgorithmParameterSpec)localObject);
      paramArrayOfByte = localCipher.unwrap(paramArrayOfByte, this.helper.getKeyAlgorithmName(paramAlgorithmIdentifier.getAlgorithm()), 3);
      return new JceGenericKey(paramAlgorithmIdentifier, paramArrayOfByte);
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unable to unwrap contents key: ");
      paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
      throw new OperatorException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
    }
  }
  
  public JceKTSKeyUnwrapper setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceKTSKeyUnwrapper setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceKTSKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */