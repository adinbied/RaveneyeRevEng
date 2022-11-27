package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.KeccakDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class Keccak
{
  public static class Digest224
    extends Keccak.DigestKeccak
  {
    public Digest224()
    {
      super();
    }
  }
  
  public static class Digest256
    extends Keccak.DigestKeccak
  {
    public Digest256()
    {
      super();
    }
  }
  
  public static class Digest288
    extends Keccak.DigestKeccak
  {
    public Digest288()
    {
      super();
    }
  }
  
  public static class Digest384
    extends Keccak.DigestKeccak
  {
    public Digest384()
    {
      super();
    }
  }
  
  public static class Digest512
    extends Keccak.DigestKeccak
  {
    public Digest512()
    {
      super();
    }
  }
  
  public static class DigestKeccak
    extends BCMessageDigest
    implements Cloneable
  {
    public DigestKeccak(int paramInt)
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      BCMessageDigest localBCMessageDigest = (BCMessageDigest)super.clone();
      localBCMessageDigest.digest = new KeccakDigest((KeccakDigest)this.digest);
      return localBCMessageDigest;
    }
  }
  
  public static class HashMac224
    extends BaseMac
  {
    public HashMac224()
    {
      super();
    }
  }
  
  public static class HashMac256
    extends BaseMac
  {
    public HashMac256()
    {
      super();
    }
  }
  
  public static class HashMac288
    extends BaseMac
  {
    public HashMac288()
    {
      super();
    }
  }
  
  public static class HashMac384
    extends BaseMac
  {
    public HashMac384()
    {
      super();
    }
  }
  
  public static class HashMac512
    extends BaseMac
  {
    public HashMac512()
    {
      super();
    }
  }
  
  public static class KeyGenerator224
    extends BaseKeyGenerator
  {
    public KeyGenerator224()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGenerator256
    extends BaseKeyGenerator
  {
    public KeyGenerator256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGenerator288
    extends BaseKeyGenerator
  {
    public KeyGenerator288()
    {
      super(288, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGenerator384
    extends BaseKeyGenerator
  {
    public KeyGenerator384()
    {
      super(384, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGenerator512
    extends BaseKeyGenerator
  {
    public KeyGenerator512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = Keccak.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest224");
      paramConfigurableProvider.addAlgorithm("MessageDigest.KECCAK-224", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest288");
      paramConfigurableProvider.addAlgorithm("MessageDigest.KECCAK-288", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.KECCAK-256", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest384");
      paramConfigurableProvider.addAlgorithm("MessageDigest.KECCAK-384", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest512");
      paramConfigurableProvider.addAlgorithm("MessageDigest.KECCAK-512", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac224");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator224");
      addHMACAlgorithm(paramConfigurableProvider, "KECCAK224", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac256");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator256");
      addHMACAlgorithm(paramConfigurableProvider, "KECCAK256", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac288");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator288");
      addHMACAlgorithm(paramConfigurableProvider, "KECCAK288", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac384");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator384");
      addHMACAlgorithm(paramConfigurableProvider, "KECCAK384", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac512");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator512");
      addHMACAlgorithm(paramConfigurableProvider, "KECCAK512", (String)localObject, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\Keccak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */