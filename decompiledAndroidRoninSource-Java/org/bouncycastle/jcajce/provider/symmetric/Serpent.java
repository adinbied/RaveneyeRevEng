package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.SerpentEngine;
import org.bouncycastle.crypto.engines.TnepresEngine;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.crypto.macs.GMac;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class Serpent
{
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Serpent IV";
    }
  }
  
  public static class CBC
    extends BaseBlockCipher
  {
    public CBC()
    {
      super(128);
    }
  }
  
  public static class CFB
    extends BaseBlockCipher
  {
    public CFB()
    {
      super(128);
    }
  }
  
  public static class ECB
    extends BaseBlockCipher
  {
    public ECB()
    {
      super()
      {
        public BlockCipher get()
        {
          return new SerpentEngine();
        }
      };
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      super(192, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends SymmetricAlgorithmProvider
  {
    private static final String PREFIX = Serpent.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.Serpent", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Serpent", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.Serpent", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$TECB");
      paramConfigurableProvider.addAlgorithm("Cipher.Tnepres", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$TKeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.Tnepres", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$TAlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.Tnepres", ((StringBuilder)localObject).toString());
      localObject = GNUObjectIdentifiers.Serpent_128_ECB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_192_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_256_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_128_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_192_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_256_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_128_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_192_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_256_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_128_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_192_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = GNUObjectIdentifiers.Serpent_256_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$SerpentGMAC");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      addGMacAlgorithm(paramConfigurableProvider, "SERPENT", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$TSerpentGMAC");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$TKeyGen");
      addGMacAlgorithm(paramConfigurableProvider, "TNEPRES", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Poly1305");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Poly1305KeyGen");
      addPoly1305Algorithm(paramConfigurableProvider, "SERPENT", (String)localObject, localStringBuilder.toString());
    }
  }
  
  public static class OFB
    extends BaseBlockCipher
  {
    public OFB()
    {
      super(128);
    }
  }
  
  public static class Poly1305
    extends BaseMac
  {
    public Poly1305()
    {
      super();
    }
  }
  
  public static class Poly1305KeyGen
    extends BaseKeyGenerator
  {
    public Poly1305KeyGen()
    {
      super(256, new Poly1305KeyGenerator());
    }
  }
  
  public static class SerpentGMAC
    extends BaseMac
  {
    public SerpentGMAC()
    {
      super();
    }
  }
  
  public static class TAlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "Tnepres IV";
    }
  }
  
  public static class TECB
    extends BaseBlockCipher
  {
    public TECB()
    {
      super()
      {
        public BlockCipher get()
        {
          return new TnepresEngine();
        }
      };
    }
  }
  
  public static class TKeyGen
    extends BaseKeyGenerator
  {
    public TKeyGen()
    {
      super(192, new CipherKeyGenerator());
    }
  }
  
  public static class TSerpentGMAC
    extends BaseMac
  {
    public TSerpentGMAC()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\Serpent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */