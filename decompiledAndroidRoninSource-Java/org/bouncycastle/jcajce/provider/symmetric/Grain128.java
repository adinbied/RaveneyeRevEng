package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.Grain128Engine;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Grain128
{
  public static class Base
    extends BaseStreamCipher
  {
    public Base()
    {
      super(12);
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
    private static final String PREFIX = Grain128.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Base");
      paramConfigurableProvider.addAlgorithm("Cipher.Grain128", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Grain128", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Grain128.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */