package org.bouncycastle.jcajce.provider.asymmetric;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class GM
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.ec.";
  private static final Map<String, String> generalSm2Attributes;
  
  static
  {
    HashMap localHashMap = new HashMap();
    generalSm2Attributes = localHashMap;
    localHashMap.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
    generalSm2Attributes.put("SupportedKeyFormats", "PKCS#8|X.509");
  }
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("Signature.SM3WITHSM2", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sm3WithSM2");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.Signature.");
      localStringBuilder.append(GMObjectIdentifiers.sm2sign_with_sm3);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "SM3WITHSM2");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\GM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */