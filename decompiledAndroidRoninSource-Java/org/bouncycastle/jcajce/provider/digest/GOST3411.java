package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.GOST3411_2012_256Digest;
import org.bouncycastle.crypto.digests.GOST3411_2012_512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class GOST3411
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
      localDigest.digest = new GOST3411Digest((GOST3411Digest)this.digest);
      return localDigest;
    }
  }
  
  public static class Digest2012_256
    extends BCMessageDigest
    implements Cloneable
  {
    public Digest2012_256()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Digest2012_256 localDigest2012_256 = (Digest2012_256)super.clone();
      localDigest2012_256.digest = new GOST3411_2012_256Digest((GOST3411_2012_256Digest)this.digest);
      return localDigest2012_256;
    }
  }
  
  public static class Digest2012_512
    extends BCMessageDigest
    implements Cloneable
  {
    public Digest2012_512()
    {
      super();
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      Digest2012_512 localDigest2012_512 = (Digest2012_512)super.clone();
      localDigest2012_512.digest = new GOST3411_2012_512Digest((GOST3411_2012_512Digest)this.digest);
      return localDigest2012_512;
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
  
  public static class HashMac2012_256
    extends BaseMac
  {
    public HashMac2012_256()
    {
      super();
    }
  }
  
  public static class HashMac2012_512
    extends BaseMac
  {
    public HashMac2012_512()
    {
      super();
    }
  }
  
  public static class KeyGenerator
    extends BaseKeyGenerator
  {
    public KeyGenerator()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGenerator2012_256
    extends BaseKeyGenerator
  {
    public KeyGenerator2012_256()
    {
      super(256, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGenerator2012_512
    extends BaseKeyGenerator
  {
    public KeyGenerator2012_512()
    {
      super(512, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends DigestAlgorithmProvider
  {
    private static final String PREFIX = GOST3411.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest");
      paramConfigurableProvider.addAlgorithm("MessageDigest.GOST3411", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.GOST", "GOST3411");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(CryptoProObjectIdentifiers.gostR3411);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GOST3411");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator");
      addHMACAlgorithm(paramConfigurableProvider, "GOST3411", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "GOST3411", CryptoProObjectIdentifiers.gostR3411);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest2012_256");
      paramConfigurableProvider.addAlgorithm("MessageDigest.GOST3411-2012-256", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.GOST-2012-256", "GOST3411-2012-256");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.GOST-3411-2012-256", "GOST3411-2012-256");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GOST3411-2012-256");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac2012_256");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator2012_256");
      addHMACAlgorithm(paramConfigurableProvider, "GOST3411-2012-256", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "GOST3411-2012-256", RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_256);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Digest2012_512");
      paramConfigurableProvider.addAlgorithm("MessageDigest.GOST3411-2012-512", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.GOST-2012-512", "GOST3411-2012-512");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.MessageDigest.GOST-3411-2012-512", "GOST3411-2012-512");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.MessageDigest.");
      ((StringBuilder)localObject).append(RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GOST3411-2012-512");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$HashMac2012_512");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator2012_512");
      addHMACAlgorithm(paramConfigurableProvider, "GOST3411-2012-512", (String)localObject, localStringBuilder.toString());
      addHMACAlias(paramConfigurableProvider, "GOST3411-2012-512", RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_512);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMacKeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHHMACGOST3411", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.SecretKeyFactory.");
      ((StringBuilder)localObject).append(CryptoProObjectIdentifiers.gostR3411);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PBEWITHHMACGOST3411");
    }
  }
  
  public static class PBEWithMacKeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithMacKeyFactory()
    {
      super(null, false, 2, 6, 256, 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\GOST3411.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */