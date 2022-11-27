package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class ARC4
{
  public static class Base
    extends BaseStreamCipher
  {
    public Base()
    {
      super(0);
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = ARC4.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Base");
      paramConfigurableProvider.addAlgorithm("Cipher.ARC4", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.rc4, "ARC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.ARCFOUR", "ARC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.RC4", "ARC4");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.ARC4", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.RC4", "ARC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBEWithSHAAnd128BitKeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND128BITRC4", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBEWithSHAAnd40BitKeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND40BITRC4", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.AlgorithmParameters.");
      localStringBuilder.append(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "PKCS12PBE");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.AlgorithmParameters.");
      localStringBuilder.append(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBEWithSHAAnd128Bit");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND128BITRC4", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBEWithSHAAnd40Bit");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND40BITRC4", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, "PBEWITHSHAAND128BITRC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, "PBEWITHSHAAND40BITRC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, "PBEWITHSHAAND128BITRC4");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, "PBEWITHSHAAND40BITRC4");
    }
  }
  
  public static class PBEWithSHAAnd128Bit
    extends BaseStreamCipher
  {
    public PBEWithSHAAnd128Bit()
    {
      super(0, 128, 1);
    }
  }
  
  public static class PBEWithSHAAnd128BitKeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd128BitKeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, true, 2, 1, 128, 0);
    }
  }
  
  public static class PBEWithSHAAnd40Bit
    extends BaseStreamCipher
  {
    public PBEWithSHAAnd40Bit()
    {
      super(0, 40, 1);
    }
  }
  
  public static class PBEWithSHAAnd40BitKeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd40BitKeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, true, 2, 1, 40, 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\ARC4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */