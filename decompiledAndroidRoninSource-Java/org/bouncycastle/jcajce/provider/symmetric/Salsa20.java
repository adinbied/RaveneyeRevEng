package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Salsa20
{
  public static class Base
    extends BaseStreamCipher
  {
    public Base()
    {
      super(8);
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = Salsa20.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Base");
      paramConfigurableProvider.addAlgorithm("Cipher.SALSA20", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.SALSA20", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Salsa20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */