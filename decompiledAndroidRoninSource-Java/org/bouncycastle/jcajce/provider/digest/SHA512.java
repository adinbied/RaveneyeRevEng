package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.macs.OldHMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA512
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
      localDigest.digest = new SHA512Digest((SHA512Digest)this.digest);
      return localDigest;
    }
  }
  
  public static class DigestT
    extends BCMessageDigest
    implements Cloneable
  {
    public DigestT(int paramInt)
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      DigestT localDigestT = (DigestT)super.clone();
      localDigestT.digest = new SHA512tDigest((SHA512tDigest)this.digest);
      return localDigestT;
    }
  }
  
  public static class DigestT224
    extends SHA512.DigestT
  {
    public DigestT224()
    {
      super();
    }
  }
  
  public static class DigestT256
    extends SHA512.DigestT
  {
    public DigestT256()
    {
      super();
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
  
  public static class HashMacT224
    extends BaseMac
  {
    public HashMacT224()
    {
      super();
    }
  }
  
  public static class HashMacT256
    extends BaseMac
  {
    public HashMacT256()
    {
      super();
    }
  }
  
  public static class KeyGenerator
    extends BaseKeyGenerator
  {
    public KeyGenerator()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGeneratorT224
    extends BaseKeyGenerator
  {
    public KeyGeneratorT224()
    {
      super(224, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGeneratorT256
    extends BaseKeyGenerator
  {
    public KeyGeneratorT256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = SHA512.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA-512", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512", "SHA-512");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_sha512);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA-512");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DigestT224");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA-512/224", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_sha512_224);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA-512/224");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DigestT256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA-512/256", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512256", "SHA-512/256");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_sha512_256);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA-512/256");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$OldSHA512");
      paramConfigurableProvider.addAlgorithm("Mac.OLDHMACSHA512", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac");
      paramConfigurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA512", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator");
      addHMACAlgorithm(paramConfigurableProvider, "SHA512", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA512", PKCSObjectIdentifiers.id_hmacWithSHA512);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMacT224");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGeneratorT224");
      addHMACAlgorithm(paramConfigurableProvider, "SHA512/224", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMacT256");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGeneratorT256");
      addHMACAlgorithm(paramConfigurableProvider, "SHA512/256", (String)localObject, localStringBuilder.toString());
    }
  }
  
  public static class OldSHA512
    extends BaseMac
  {
    public OldSHA512()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\SHA512.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */