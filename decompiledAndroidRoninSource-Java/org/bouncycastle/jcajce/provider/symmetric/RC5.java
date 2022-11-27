package org.bouncycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.RC532Engine;
import org.bouncycastle.crypto.engines.RC564Engine;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class RC5
{
  public static class AlgParamGen
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[8];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("RC5");
        localAlgorithmParameters.init(new IvParameterSpec(arrayOfByte));
        return localAlgorithmParameters;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.getMessage());
      }
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
      throws InvalidAlgorithmParameterException
    {
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC5 parameter generation.");
    }
  }
  
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "RC5 IV";
    }
  }
  
  public static class CBC32
    extends BaseBlockCipher
  {
    public CBC32()
    {
      super(64);
    }
  }
  
  public static class CFB8Mac32
    extends BaseMac
  {
    public CFB8Mac32()
    {
      super();
    }
  }
  
  public static class ECB32
    extends BaseBlockCipher
  {
    public ECB32()
    {
      super();
    }
  }
  
  public static class ECB64
    extends BaseBlockCipher
  {
    public ECB64()
    {
      super();
    }
  }
  
  public static class KeyGen32
    extends BaseKeyGenerator
  {
    public KeyGen32()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGen64
    extends BaseKeyGenerator
  {
    public KeyGen64()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class Mac32
    extends BaseMac
  {
    public Mac32()
    {
      super();
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = RC5.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB32");
      paramConfigurableProvider.addAlgorithm("Cipher.RC5", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RC5-32", "RC5");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB64");
      paramConfigurableProvider.addAlgorithm("Cipher.RC5-64", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen32");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.RC5", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.RC5-32", "RC5");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen64");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.RC5-64", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.RC5", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.RC5-64", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Mac32");
      paramConfigurableProvider.addAlgorithm("Mac.RC5MAC", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.RC5", "RC5MAC");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB8Mac32");
      paramConfigurableProvider.addAlgorithm("Mac.RC5MAC/CFB8", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.RC5/CFB8", "RC5MAC/CFB8");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\RC5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */