package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.ThreefishEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Threefish
{
  public static class AlgParams_1024
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Threefish-1024 IV";
    }
  }
  
  public static class AlgParams_256
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Threefish-256 IV";
    }
  }
  
  public static class AlgParams_512
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Threefish-512 IV";
    }
  }
  
  public static class CMAC_1024
    extends BaseMac
  {
    public CMAC_1024()
    {
      super();
    }
  }
  
  public static class CMAC_256
    extends BaseMac
  {
    public CMAC_256()
    {
      super();
    }
  }
  
  public static class CMAC_512
    extends BaseMac
  {
    public CMAC_512()
    {
      super();
    }
  }
  
  public static class ECB_1024
    extends BaseBlockCipher
  {
    public ECB_1024()
    {
      super();
    }
  }
  
  public static class ECB_256
    extends BaseBlockCipher
  {
    public ECB_256()
    {
      super();
    }
  }
  
  public static class ECB_512
    extends BaseBlockCipher
  {
    public ECB_512()
    {
      super();
    }
  }
  
  public static class KeyGen_1024
    extends BaseKeyGenerator
  {
    public KeyGen_1024()
    {
      super(1024, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGen_256
    extends BaseKeyGenerator
  {
    public KeyGen_256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGen_512
    extends BaseKeyGenerator
  {
    public KeyGen_512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = Threefish.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CMAC_256");
      paramConfigurableProvider.addAlgorithm("Mac.Threefish-256CMAC", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CMAC_512");
      paramConfigurableProvider.addAlgorithm("Mac.Threefish-512CMAC", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CMAC_1024");
      paramConfigurableProvider.addAlgorithm("Mac.Threefish-1024CMAC", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB_256");
      paramConfigurableProvider.addAlgorithm("Cipher.Threefish-256", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB_512");
      paramConfigurableProvider.addAlgorithm("Cipher.Threefish-512", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB_1024");
      paramConfigurableProvider.addAlgorithm("Cipher.Threefish-1024", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen_256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Threefish-256", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen_512");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Threefish-512", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen_1024");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Threefish-1024", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams_256");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.Threefish-256", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams_512");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.Threefish-512", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams_1024");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.Threefish-1024", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Threefish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */