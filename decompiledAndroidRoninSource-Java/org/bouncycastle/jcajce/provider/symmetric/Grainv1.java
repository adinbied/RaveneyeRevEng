package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.Grainv1Engine;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Grainv1
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
      super(80, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = Grainv1.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Base");
      paramConfigurableProvider.addAlgorithm("Cipher.Grainv1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Grainv1", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Grainv1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */