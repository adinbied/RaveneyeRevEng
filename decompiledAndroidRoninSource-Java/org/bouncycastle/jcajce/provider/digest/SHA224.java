package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA224
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
      localDigest.digest = new SHA224Digest((SHA224Digest)this.digest);
      return localDigest;
    }
  }
  
  public static class HashMac
    extends BaseMac
  {
    public HashMac()
    {
      super();
    }
  }
  
  public static class KeyGenerator
    extends BaseKeyGenerator
  {
    public KeyGenerator()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = SHA224.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA-224", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA224", "SHA-224");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_sha224);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA-224");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac");
      paramConfigurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA224", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator");
      addHMACAlgorithm(paramConfigurableProvider, "SHA224", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA224", PKCSObjectIdentifiers.id_hmacWithSHA224);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\SHA224.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */