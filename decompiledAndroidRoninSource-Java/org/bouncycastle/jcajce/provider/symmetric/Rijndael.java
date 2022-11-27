package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Rijndael
{
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Rijndael IV";
    }
  }
  
  public static class ECB
    extends BaseBlockCipher
  {
    public ECB()
    {
      super()
      {
        public BlockCipher get()
        {
          return new RijndaelEngine();
        }
      };
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      super(192, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = Rijndael.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.RIJNDAEL", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.RIJNDAEL", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.RIJNDAEL", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Rijndael.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */