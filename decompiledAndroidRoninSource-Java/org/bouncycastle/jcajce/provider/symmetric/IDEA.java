package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.misc.IDEACBCPar;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.IDEAEngine;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class IDEA
{
  public static class AlgParamGen
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[8];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("IDEA");
        localAlgorithmParameters.init(new IvParameterSpec(arrayOfByte));
        return localAlgorithmParameters;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.getMessage());
      }
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
      throws InvalidAlgorithmParameterException
    {
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
    }
  }
  
  public static class AlgParams
    extends BaseAlgorithmParameters
  {
    private byte[] iv;
    
    protected byte[] engineGetEncoded()
      throws IOException
    {
      return engineGetEncoded("ASN.1");
    }
    
    protected byte[] engineGetEncoded(String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString)) {
        return new IDEACBCPar(engineGetEncoded("RAW")).getEncoded();
      }
      if (paramString.equals("RAW"))
      {
        paramString = this.iv;
        byte[] arrayOfByte = new byte[paramString.length];
        System.arraycopy(paramString, 0, arrayOfByte, 0, paramString.length);
        return arrayOfByte;
      }
      return null;
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if ((paramAlgorithmParameterSpec instanceof IvParameterSpec))
      {
        this.iv = ((IvParameterSpec)paramAlgorithmParameterSpec).getIV();
        return;
      }
      throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      this.iv = arrayOfByte;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if (paramString.equals("RAW"))
      {
        engineInit(paramArrayOfByte);
        return;
      }
      if (paramString.equals("ASN.1"))
      {
        engineInit(new IDEACBCPar((ASN1Sequence)new ASN1InputStream(paramArrayOfByte).readObject()).getIV());
        return;
      }
      throw new IOException("Unknown parameters format in IV parameters object");
    }
    
    protected String engineToString()
    {
      return "IDEA Parameters";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if (paramClass == IvParameterSpec.class) {
        return new IvParameterSpec(this.iv);
      }
      throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
    }
  }
  
  public static class CBC
    extends BaseBlockCipher
  {
    public CBC()
    {
      super(64);
    }
  }
  
  public static class CFB8Mac
    extends BaseMac
  {
    public CFB8Mac()
    {
      super();
    }
  }
  
  public static class ECB
    extends BaseBlockCipher
  {
    public ECB()
    {
      super();
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
  
  public static class Mac
    extends BaseMac
  {
    public Mac()
    {
      super();
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = IDEA.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.IDEA", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.IDEA", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.IDEA", ((StringBuilder)localObject).toString());
      localObject = MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAndIDEA");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAANDIDEA-CBC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.IDEA", ((StringBuilder)localObject).toString());
      localObject = MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAndIDEAKeyGen");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Mac");
      paramConfigurableProvider.addAlgorithm("Mac.IDEAMAC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.IDEA", "IDEAMAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CFB8Mac");
      paramConfigurableProvider.addAlgorithm("Mac.IDEAMAC/CFB8", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
    }
  }
  
  public static class PBEWithSHAAndIDEA
    extends BaseBlockCipher
  {
    public PBEWithSHAAndIDEA()
    {
      super();
    }
  }
  
  public static class PBEWithSHAAndIDEAKeyGen
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAndIDEAKeyGen()
    {
      super(null, true, 2, 1, 128, 64);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\IDEA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */