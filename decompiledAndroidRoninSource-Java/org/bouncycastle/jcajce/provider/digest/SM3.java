package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

public class SM3
{
  public static class Digest
    extends BCMessageDigest
    implements Cloneable
  {
    public Digest()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Digest localDigest = (Digest)super.clone();
      localDigest.digest = new SM3Digest((SM3Digest)this.digest);
      return localDigest;
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = SM3.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Digest");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SM3", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SM3", "SM3");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\SM3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */