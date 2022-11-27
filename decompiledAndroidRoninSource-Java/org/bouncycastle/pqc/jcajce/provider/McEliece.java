package org.bouncycastle.pqc.jcajce.provider;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

public class McEliece
{
  private static final String PREFIX = "org.bouncycastle.pqc.jcajce.provider.mceliece.";
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.McElieceKobaraImai", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.McEliecePointcheval", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.McElieceFujisaki", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.McEliece", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.McEliece-CCA2", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyFactory.McElieceKobaraImai", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("KeyFactory.McEliecePointcheval", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("KeyFactory.McElieceFujisaki", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("KeyFactory.McEliece", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("KeyFactory.McEliece-CCA2", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyFactory.");
      localStringBuilder.append(PQCObjectIdentifiers.mcElieceCca2);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyFactory.");
      localStringBuilder.append(PQCObjectIdentifiers.mcEliece);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("Cipher.McEliece", "org.bouncycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
      paramConfigurableProvider.addAlgorithm("Cipher.McEliecePointcheval", "org.bouncycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
      paramConfigurableProvider.addAlgorithm("Cipher.McElieceKobaraImai", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
      paramConfigurableProvider.addAlgorithm("Cipher.McElieceFujisaki", "org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\McEliece.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */