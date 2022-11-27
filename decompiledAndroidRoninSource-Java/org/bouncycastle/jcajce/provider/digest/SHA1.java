package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class SHA1
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
      localDigest.digest = new SHA1Digest((SHA1Digest)this.digest);
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
      super(160, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = SHA1.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest");
      paramConfigurableProvider.addAlgorithm("MessageDigest.SHA-1", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA1", "SHA-1");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA", "SHA-1");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(OIWObjectIdentifiers.idSHA1);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "SHA-1");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator");
      addHMACAlgorithm(paramConfigurableProvider, "SHA1", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "SHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
      addHMACAlias(paramConfigurableProvider, "SHA1", IANAObjectIdentifiers.hmacSHA1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$SHA1Mac");
      paramConfigurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$SHA1Mac");
      paramConfigurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA1", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.SecretKeyFactory.");
      ((StringBuilder)localObject).append(OIWObjectIdentifiers.idSHA1);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PBEWITHHMACSHA1");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Mac.");
      ((StringBuilder)localObject).append(OIWObjectIdentifiers.idSHA1);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PBEWITHHMACSHA");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMacKeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHHMACSHA1", ((StringBuilder)localObject).toString());
    }
  }
  
  public static class PBEWithMacKeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithMacKeyFactory()
    {
      super(null, false, 2, 1, 160, 0);
    }
  }
  
  public static class SHA1Mac
    extends BaseMac
  {
    public SHA1Mac()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\SHA1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */