package org.bouncycastle.jcajce.provider.keystore;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class BC
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.keystore.bc.";
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("KeyStore.BKS", "org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Std");
      paramConfigurableProvider.addAlgorithm("KeyStore.BKS-V1", "org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Version1");
      paramConfigurableProvider.addAlgorithm("KeyStore.BouncyCastle", "org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$BouncyCastleStore");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyStore.UBER", "BouncyCastle");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyStore.bouncycastle", "BouncyCastle");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\keystore\BC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */