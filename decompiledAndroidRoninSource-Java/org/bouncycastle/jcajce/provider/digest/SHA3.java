package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA3
{
  public static class Digest224
    extends SHA3.DigestSHA3
  {
    public Digest224()
    {
      super();
    }
  }
  
  public static class Digest256
    extends SHA3.DigestSHA3
  {
    public Digest256()
    {
      super();
    }
  }
  
  public static class Digest384
    extends SHA3.DigestSHA3
  {
    public Digest384()
    {
      super();
    }
  }
  
  public static class Digest512
    extends SHA3.DigestSHA3
  {
    public Digest512()
    {
      super();
    }
  }
  
  public static class DigestSHA3
    extends BCMessageDigest
    implements Cloneable
  {
    public DigestSHA3(int paramInt)
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      BCMessageDigest localBCMessageDigest = (BCMessageDigest)super.clone();
      localBCMessageDigest.digest = new SHA3Digest((SHA3Digest)this.digest);
      return localBCMessageDigest;
    }
  }
  
  public static class HashMac224
    extends SHA3.HashMacSHA3
  {
    public HashMac224()
    {
      super();
    }
  }
  
  public static class HashMac256
    extends SHA3.HashMacSHA3
  {
    public HashMac256()
    {
      super();
    }
  }
  
  public static class HashMac384
    extends SHA3.HashMacSHA3
  {
    public HashMac384()
    {
      super();
    }
  }
  
  public static class HashMac512
    extends SHA3.HashMacSHA3
  {
    public HashMac512()
    {
      super();
    }
  }
  
  public static class HashMacSHA3
    extends BaseMac
  {
    public HashMacSHA3(int paramInt)
    {
      super();
    }
  }
  
  public static class KeyGenerator224
    extends SHA3.KeyGeneratorSHA3
  {
    public KeyGenerator224()
    {
      super();
    }
  }
  
  public static class KeyGenerator256
    extends SHA3.KeyGeneratorSHA3
  {
    public KeyGenerator256()
    {
      super();
    }
  }
  
  public static class KeyGenerator384
    extends SHA3.KeyGeneratorSHA3
  {
    public KeyGenerator384()
    {
      super();
    }
  }
  
  public static class KeyGenerator512
    extends SHA3.KeyGeneratorSHA3
  {
    public KeyGenerator512()
    {
      super();
    }
  }
  
  public static class KeyGeneratorSHA3
    extends BaseKeyGenerator
  {
    public KeyGeneratorSHA3(int paramInt)
    {
      super(paramInt, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = SHA3.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest224");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA3-224", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA3-256", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest384");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA3-384", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest512");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA3-512", ((StringBuilder)localObject).toString());
      localObject = NISTObjectIdentifiers.id_sha3_224;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Digest224");
      paramConfigurableProvider.addAlgorithm("MessageDigest", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_sha3_256;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Digest256");
      paramConfigurableProvider.addAlgorithm("MessageDigest", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_sha3_384;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Digest384");
      paramConfigurableProvider.addAlgorithm("MessageDigest", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_sha3_512;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Digest512");
      paramConfigurableProvider.addAlgorithm("MessageDigest", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac224");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator224");
      addHMACAlgorithm(paramConfigurableProvider, "SHA3-224", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA3-224", NISTObjectIdentifiers.id_hmacWithSHA3_224);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac256");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator256");
      addHMACAlgorithm(paramConfigurableProvider, "SHA3-256", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA3-256", NISTObjectIdentifiers.id_hmacWithSHA3_256);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac384");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator384");
      addHMACAlgorithm(paramConfigurableProvider, "SHA3-384", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA3-384", NISTObjectIdentifiers.id_hmacWithSHA3_384);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac512");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator512");
      addHMACAlgorithm(paramConfigurableProvider, "SHA3-512", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA3-512", NISTObjectIdentifiers.id_hmacWithSHA3_512);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\SHA3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */