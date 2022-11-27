package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

public class Blake2b
{
  public static class Blake2b160
    extends BCMessageDigest
    implements Cloneable
  {
    public Blake2b160()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Blake2b160 localBlake2b160 = (Blake2b160)super.clone();
      localBlake2b160.digest = new Blake2bDigest((Blake2bDigest)this.digest);
      return localBlake2b160;
    }
  }
  
  public static class Blake2b256
    extends BCMessageDigest
    implements Cloneable
  {
    public Blake2b256()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Blake2b256 localBlake2b256 = (Blake2b256)super.clone();
      localBlake2b256.digest = new Blake2bDigest((Blake2bDigest)this.digest);
      return localBlake2b256;
    }
  }
  
  public static class Blake2b384
    extends BCMessageDigest
    implements Cloneable
  {
    public Blake2b384()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Blake2b384 localBlake2b384 = (Blake2b384)super.clone();
      localBlake2b384.digest = new Blake2bDigest((Blake2bDigest)this.digest);
      return localBlake2b384;
    }
  }
  
  public static class Blake2b512
    extends BCMessageDigest
    implements Cloneable
  {
    public Blake2b512()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Blake2b512 localBlake2b512 = (Blake2b512)super.clone();
      localBlake2b512.digest = new Blake2bDigest((Blake2bDigest)this.digest);
      return localBlake2b512;
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = Blake2b.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Blake2b512");
      paramConfigurableProvider.addAlgorithm("MessageDigest.BLAKE2B-512", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.MessageDigest.");
      localStringBuilder.append(MiscObjectIdentifiers.id_blake2b512);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "BLAKE2B-512");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Blake2b384");
      paramConfigurableProvider.addAlgorithm("MessageDigest.BLAKE2B-384", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.MessageDigest.");
      localStringBuilder.append(MiscObjectIdentifiers.id_blake2b384);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "BLAKE2B-384");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Blake2b256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.BLAKE2B-256", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.MessageDigest.");
      localStringBuilder.append(MiscObjectIdentifiers.id_blake2b256);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "BLAKE2B-256");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Blake2b160");
      paramConfigurableProvider.addAlgorithm("MessageDigest.BLAKE2B-160", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.MessageDigest.");
      localStringBuilder.append(MiscObjectIdentifiers.id_blake2b160);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "BLAKE2B-160");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\Blake2b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */