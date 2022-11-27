package org.bouncycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.crypto.macs.GOST28147Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class GOST28147
{
  public static class AlgParamGen
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[16];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("GOST28147");
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
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST28147 parameter generation.");
    }
  }
  
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "GOST IV";
    }
  }
  
  public static class CBC
    extends BaseBlockCipher
  {
    public CBC()
    {
      super(64);
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
  
  public static class GCFB
    extends BaseBlockCipher
  {
    public GCFB()
    {
      super(64);
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      this(256);
    }
    
    public KeyGen(int paramInt)
    {
      super(paramInt, new CipherKeyGenerator());
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
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = GOST28147.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.GOST28147", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.GOST", "GOST28147");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.GOST-28147", "GOST28147");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cipher.");
      ((StringBuilder)localObject).append(CryptoProObjectIdentifiers.gostR28147_gcfb);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$GCFB");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.GOST28147", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.GOST", "GOST28147");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.KeyGenerator.");
      ((StringBuilder)localObject).append(CryptoProObjectIdentifiers.gostR28147_gcfb);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GOST28147");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Mac");
      paramConfigurableProvider.addAlgorithm("Mac.GOST28147MAC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\GOST28147.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */