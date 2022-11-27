package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SkeinDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.macs.SkeinMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class Skein
{
  public static class DigestSkein1024
    extends BCMessageDigest
    implements Cloneable
  {
    public DigestSkein1024(int paramInt)
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      BCMessageDigest localBCMessageDigest = (BCMessageDigest)super.clone();
      localBCMessageDigest.digest = new SkeinDigest((SkeinDigest)this.digest);
      return localBCMessageDigest;
    }
  }
  
  public static class DigestSkein256
    extends BCMessageDigest
    implements Cloneable
  {
    public DigestSkein256(int paramInt)
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      BCMessageDigest localBCMessageDigest = (BCMessageDigest)super.clone();
      localBCMessageDigest.digest = new SkeinDigest((SkeinDigest)this.digest);
      return localBCMessageDigest;
    }
  }
  
  public static class DigestSkein512
    extends BCMessageDigest
    implements Cloneable
  {
    public DigestSkein512(int paramInt)
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      BCMessageDigest localBCMessageDigest = (BCMessageDigest)super.clone();
      localBCMessageDigest.digest = new SkeinDigest((SkeinDigest)this.digest);
      return localBCMessageDigest;
    }
  }
  
  public static class Digest_1024_1024
    extends Skein.DigestSkein1024
  {
    public Digest_1024_1024()
    {
      super();
    }
  }
  
  public static class Digest_1024_384
    extends Skein.DigestSkein1024
  {
    public Digest_1024_384()
    {
      super();
    }
  }
  
  public static class Digest_1024_512
    extends Skein.DigestSkein1024
  {
    public Digest_1024_512()
    {
      super();
    }
  }
  
  public static class Digest_256_128
    extends Skein.DigestSkein256
  {
    public Digest_256_128()
    {
      super();
    }
  }
  
  public static class Digest_256_160
    extends Skein.DigestSkein256
  {
    public Digest_256_160()
    {
      super();
    }
  }
  
  public static class Digest_256_224
    extends Skein.DigestSkein256
  {
    public Digest_256_224()
    {
      super();
    }
  }
  
  public static class Digest_256_256
    extends Skein.DigestSkein256
  {
    public Digest_256_256()
    {
      super();
    }
  }
  
  public static class Digest_512_128
    extends Skein.DigestSkein512
  {
    public Digest_512_128()
    {
      super();
    }
  }
  
  public static class Digest_512_160
    extends Skein.DigestSkein512
  {
    public Digest_512_160()
    {
      super();
    }
  }
  
  public static class Digest_512_224
    extends Skein.DigestSkein512
  {
    public Digest_512_224()
    {
      super();
    }
  }
  
  public static class Digest_512_256
    extends Skein.DigestSkein512
  {
    public Digest_512_256()
    {
      super();
    }
  }
  
  public static class Digest_512_384
    extends Skein.DigestSkein512
  {
    public Digest_512_384()
    {
      super();
    }
  }
  
  public static class Digest_512_512
    extends Skein.DigestSkein512
  {
    public Digest_512_512()
    {
      super();
    }
  }
  
  public static class HMacKeyGenerator_1024_1024
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_1024_1024()
    {
      super(1024, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_1024_384
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_1024_384()
    {
      super(384, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_1024_512
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_1024_512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_256_128
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_256_128()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_256_160
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_256_160()
    {
      super(160, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_256_224
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_256_224()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_256_256
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_256_256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_512_128
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_512_128()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_512_160
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_512_160()
    {
      super(160, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_512_224
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_512_224()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_512_256
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_512_256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_512_384
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_512_384()
    {
      super(384, new CipherKeyGenerator());
    }
  }
  
  public static class HMacKeyGenerator_512_512
    extends BaseKeyGenerator
  {
    public HMacKeyGenerator_512_512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class HashMac_1024_1024
    extends BaseMac
  {
    public HashMac_1024_1024()
    {
      super();
    }
  }
  
  public static class HashMac_1024_384
    extends BaseMac
  {
    public HashMac_1024_384()
    {
      super();
    }
  }
  
  public static class HashMac_1024_512
    extends BaseMac
  {
    public HashMac_1024_512()
    {
      super();
    }
  }
  
  public static class HashMac_256_128
    extends BaseMac
  {
    public HashMac_256_128()
    {
      super();
    }
  }
  
  public static class HashMac_256_160
    extends BaseMac
  {
    public HashMac_256_160()
    {
      super();
    }
  }
  
  public static class HashMac_256_224
    extends BaseMac
  {
    public HashMac_256_224()
    {
      super();
    }
  }
  
  public static class HashMac_256_256
    extends BaseMac
  {
    public HashMac_256_256()
    {
      super();
    }
  }
  
  public static class HashMac_512_128
    extends BaseMac
  {
    public HashMac_512_128()
    {
      super();
    }
  }
  
  public static class HashMac_512_160
    extends BaseMac
  {
    public HashMac_512_160()
    {
      super();
    }
  }
  
  public static class HashMac_512_224
    extends BaseMac
  {
    public HashMac_512_224()
    {
      super();
    }
  }
  
  public static class HashMac_512_256
    extends BaseMac
  {
    public HashMac_512_256()
    {
      super();
    }
  }
  
  public static class HashMac_512_384
    extends BaseMac
  {
    public HashMac_512_384()
    {
      super();
    }
  }
  
  public static class HashMac_512_512
    extends BaseMac
  {
    public HashMac_512_512()
    {
      super();
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = Skein.class.getName();
    
    private void addSkeinMacAlgorithm(ConfigurableProvider paramConfigurableProvider, int paramInt1, int paramInt2)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Skein-MAC-");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(PREFIX);
      ((StringBuilder)localObject2).append("$SkeinMac_");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt2);
      Object localObject3 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(PREFIX);
      ((StringBuilder)localObject2).append("$SkeinMacKeyGenerator_");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt2);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Mac.");
      localStringBuilder.append((String)localObject1);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), (String)localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Alg.Alias.Mac.Skein-MAC");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("/");
      ((StringBuilder)localObject3).append(paramInt2);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject3).toString(), (String)localObject1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("KeyGenerator.");
      ((StringBuilder)localObject3).append((String)localObject1);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject3).toString(), (String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Alg.Alias.KeyGenerator.Skein-MAC");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramInt2);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject2).toString(), (String)localObject1);
    }
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_256_128");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-256-128", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_256_160");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-256-160", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_256_224");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-256-224", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_256_256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-256-256", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_512_128");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-512-128", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_512_160");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-512-160", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_512_224");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-512-224", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_512_256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-512-256", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_512_384");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-512-384", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_512_512");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-512-512", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_1024_384");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-1024-384", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_1024_512");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-1024-512", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest_1024_1024");
      paramConfigurableProvider.addAlgorithm("MessageDigest.Skein-1024-1024", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_256_128");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_256_128");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-256-128", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_256_160");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_256_160");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-256-160", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_256_224");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_256_224");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-256-224", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_256_256");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_256_256");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-256-256", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_512_128");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_512_128");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-512-128", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_512_160");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_512_160");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-512-160", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_512_224");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_512_224");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-512-224", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_512_256");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_512_256");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-512-256", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_512_384");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_512_384");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-512-384", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_512_512");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_512_512");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-512-512", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_1024_384");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_1024_384");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-1024-384", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_1024_512");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_1024_512");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-1024-512", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac_1024_1024");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$HMacKeyGenerator_1024_1024");
      addHMACAlgorithm(paramConfigurableProvider, "Skein-1024-1024", (String)localObject, localStringBuilder.toString());
      addSkeinMacAlgorithm(paramConfigurableProvider, 256, 128);
      addSkeinMacAlgorithm(paramConfigurableProvider, 256, 160);
      addSkeinMacAlgorithm(paramConfigurableProvider, 256, 224);
      addSkeinMacAlgorithm(paramConfigurableProvider, 256, 256);
      addSkeinMacAlgorithm(paramConfigurableProvider, 512, 128);
      addSkeinMacAlgorithm(paramConfigurableProvider, 512, 160);
      addSkeinMacAlgorithm(paramConfigurableProvider, 512, 224);
      addSkeinMacAlgorithm(paramConfigurableProvider, 512, 256);
      addSkeinMacAlgorithm(paramConfigurableProvider, 512, 384);
      addSkeinMacAlgorithm(paramConfigurableProvider, 512, 512);
      addSkeinMacAlgorithm(paramConfigurableProvider, 1024, 384);
      addSkeinMacAlgorithm(paramConfigurableProvider, 1024, 512);
      addSkeinMacAlgorithm(paramConfigurableProvider, 1024, 1024);
    }
  }
  
  public static class SkeinMacKeyGenerator_1024_1024
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_1024_1024()
    {
      super(1024, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_1024_384
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_1024_384()
    {
      super(384, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_1024_512
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_1024_512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_256_128
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_256_128()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_256_160
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_256_160()
    {
      super(160, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_256_224
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_256_224()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_256_256
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_256_256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_512_128
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_512_128()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_512_160
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_512_160()
    {
      super(160, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_512_224
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_512_224()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_512_256
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_512_256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_512_384
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_512_384()
    {
      super(384, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMacKeyGenerator_512_512
    extends BaseKeyGenerator
  {
    public SkeinMacKeyGenerator_512_512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class SkeinMac_1024_1024
    extends BaseMac
  {
    public SkeinMac_1024_1024()
    {
      super();
    }
  }
  
  public static class SkeinMac_1024_384
    extends BaseMac
  {
    public SkeinMac_1024_384()
    {
      super();
    }
  }
  
  public static class SkeinMac_1024_512
    extends BaseMac
  {
    public SkeinMac_1024_512()
    {
      super();
    }
  }
  
  public static class SkeinMac_256_128
    extends BaseMac
  {
    public SkeinMac_256_128()
    {
      super();
    }
  }
  
  public static class SkeinMac_256_160
    extends BaseMac
  {
    public SkeinMac_256_160()
    {
      super();
    }
  }
  
  public static class SkeinMac_256_224
    extends BaseMac
  {
    public SkeinMac_256_224()
    {
      super();
    }
  }
  
  public static class SkeinMac_256_256
    extends BaseMac
  {
    public SkeinMac_256_256()
    {
      super();
    }
  }
  
  public static class SkeinMac_512_128
    extends BaseMac
  {
    public SkeinMac_512_128()
    {
      super();
    }
  }
  
  public static class SkeinMac_512_160
    extends BaseMac
  {
    public SkeinMac_512_160()
    {
      super();
    }
  }
  
  public static class SkeinMac_512_224
    extends BaseMac
  {
    public SkeinMac_512_224()
    {
      super();
    }
  }
  
  public static class SkeinMac_512_256
    extends BaseMac
  {
    public SkeinMac_512_256()
    {
      super();
    }
  }
  
  public static class SkeinMac_512_384
    extends BaseMac
  {
    public SkeinMac_512_384()
    {
      super();
    }
  }
  
  public static class SkeinMac_512_512
    extends BaseMac
  {
    public SkeinMac_512_512()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\Skein.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */