package org.bouncycastle.jcajce.provider.asymmetric;

import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class GOST
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.gost.";
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.GOST-3410", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.GOST-3410-94", "GOST3410");
      paramConfigurableProvider.addAlgorithm("KeyFactory.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyFactory.GOST-3410", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyFactory.GOST-3410-94", "GOST3410");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi");
      registerOid(paramConfigurableProvider, CryptoProObjectIdentifiers.gostR3410_94, "GOST3410", new KeyFactorySpi());
      registerOidAlgorithmParameterGenerator(paramConfigurableProvider, CryptoProObjectIdentifiers.gostR3410_94, "GOST3410");
      paramConfigurableProvider.addAlgorithm("Signature.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.SignatureSpi");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.GOST-3410", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.GOST-3410-94", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.GOST3411withGOST3410", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.GOST3411WITHGOST3410", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.GOST3411WithGOST3410", "GOST3410");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.Signature.");
      localStringBuilder.append(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.GOST-3410", "GOST3410");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.GOST-3410", "GOST3410");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\GOST.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */