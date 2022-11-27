package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.SkipjackEngine;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class Skipjack
{
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Skipjack IV";
    }
  }
  
  public static class ECB
    extends BaseBlockCipher
  {
    public ECB()
    {
      super();
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
  
  public static class Mac
    extends BaseMac
  {
    public Mac()
    {
      super();
    }
  }
  
  public static class MacCFB8
    extends BaseMac
  {
    public MacCFB8()
    {
      super();
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = Skipjack.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.SKIPJACK", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.SKIPJACK", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.SKIPJACK", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Mac");
      paramConfigurableProvider.addAlgorithm("Mac.SKIPJACKMAC", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$MacCFB8");
      paramConfigurableProvider.addAlgorithm("Mac.SKIPJACKMAC/CFB8", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Skipjack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */