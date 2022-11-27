package org.bouncycastle.jcajce.provider.asymmetric;

import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSTU4145
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.dstu.";
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("KeyFactory.DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyFactory.DSTU-4145-2002", "DSTU4145");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyFactory.DSTU4145-3410", "DSTU4145");
      registerOid(paramConfigurableProvider, UAObjectIdentifiers.dstu4145le, "DSTU4145", new KeyFactorySpi());
      registerOidAlgorithmParameters(paramConfigurableProvider, UAObjectIdentifiers.dstu4145le, "DSTU4145");
      registerOid(paramConfigurableProvider, UAObjectIdentifiers.dstu4145be, "DSTU4145", new KeyFactorySpi());
      registerOidAlgorithmParameters(paramConfigurableProvider, UAObjectIdentifiers.dstu4145be, "DSTU4145");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.DSTU-4145", "DSTU4145");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.DSTU-4145-2002", "DSTU4145");
      paramConfigurableProvider.addAlgorithm("Signature.DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.DSTU-4145", "DSTU4145");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.DSTU-4145-2002", "DSTU4145");
      addSignatureAlgorithm(paramConfigurableProvider, "GOST3411", "DSTU4145LE", "org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe", UAObjectIdentifiers.dstu4145le);
      addSignatureAlgorithm(paramConfigurableProvider, "GOST3411", "DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi", UAObjectIdentifiers.dstu4145be);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\DSTU4145.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */