package org.bouncycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.spec.TLSKeyMaterialSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class TLSKDF
{
  private static byte[] PRF_legacy(TLSKeyMaterialSpec paramTLSKeyMaterialSpec)
  {
    HMac localHMac1 = new HMac(DigestFactory.createMD5());
    HMac localHMac2 = new HMac(DigestFactory.createSHA1());
    byte[] arrayOfByte1 = Arrays.concatenate(Strings.toByteArray(paramTLSKeyMaterialSpec.getLabel()), paramTLSKeyMaterialSpec.getSeed());
    byte[] arrayOfByte4 = paramTLSKeyMaterialSpec.getSecret();
    int j = (arrayOfByte4.length + 1) / 2;
    byte[] arrayOfByte2 = new byte[j];
    byte[] arrayOfByte3 = new byte[j];
    int i = 0;
    System.arraycopy(arrayOfByte4, 0, arrayOfByte2, 0, j);
    System.arraycopy(arrayOfByte4, arrayOfByte4.length - j, arrayOfByte3, 0, j);
    j = paramTLSKeyMaterialSpec.getLength();
    paramTLSKeyMaterialSpec = new byte[j];
    arrayOfByte4 = new byte[j];
    hmac_hash(localHMac1, arrayOfByte2, arrayOfByte1, paramTLSKeyMaterialSpec);
    hmac_hash(localHMac2, arrayOfByte3, arrayOfByte1, arrayOfByte4);
    while (i < j)
    {
      paramTLSKeyMaterialSpec[i] = ((byte)(paramTLSKeyMaterialSpec[i] ^ arrayOfByte4[i]));
      i += 1;
    }
    return paramTLSKeyMaterialSpec;
  }
  
  private static void hmac_hash(Mac paramMac, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramMac.init(new KeyParameter(paramArrayOfByte1));
    int j = paramMac.getMacSize();
    int k = (paramArrayOfByte3.length + j - 1) / j;
    int m = paramMac.getMacSize();
    byte[] arrayOfByte1 = new byte[m];
    byte[] arrayOfByte2 = new byte[paramMac.getMacSize()];
    paramArrayOfByte1 = paramArrayOfByte2;
    int i = 0;
    while (i < k)
    {
      paramMac.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      paramMac.doFinal(arrayOfByte1, 0);
      paramMac.update(arrayOfByte1, 0, m);
      paramMac.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      paramMac.doFinal(arrayOfByte2, 0);
      int n = j * i;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, n, Math.min(j, paramArrayOfByte3.length - n));
      i += 1;
      paramArrayOfByte1 = arrayOfByte1;
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = TLSKDF.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$TLS10");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.TLS10KDF", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$TLS11");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.TLS11KDF", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$TLS12withSHA256");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.TLS12WITHSHA256KDF", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$TLS12withSHA384");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.TLS12WITHSHA384KDF", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$TLS12withSHA512");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.TLS12WITHSHA512KDF", localStringBuilder.toString());
    }
  }
  
  public static final class TLS10
    extends TLSKDF.TLSKeyMaterialFactory
  {
    public TLS10()
    {
      super();
    }
    
    protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
      throws InvalidKeySpecException
    {
      if ((paramKeySpec instanceof TLSKeyMaterialSpec)) {
        return new SecretKeySpec(TLSKDF.PRF_legacy((TLSKeyMaterialSpec)paramKeySpec), this.algName);
      }
      throw new InvalidKeySpecException("Invalid KeySpec");
    }
  }
  
  public static final class TLS11
    extends TLSKDF.TLSKeyMaterialFactory
  {
    public TLS11()
    {
      super();
    }
    
    protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
      throws InvalidKeySpecException
    {
      if ((paramKeySpec instanceof TLSKeyMaterialSpec)) {
        return new SecretKeySpec(TLSKDF.PRF_legacy((TLSKeyMaterialSpec)paramKeySpec), this.algName);
      }
      throw new InvalidKeySpecException("Invalid KeySpec");
    }
  }
  
  public static class TLS12
    extends TLSKDF.TLSKeyMaterialFactory
  {
    private final Mac prf;
    
    protected TLS12(String paramString, Mac paramMac)
    {
      super();
      this.prf = paramMac;
    }
    
    private byte[] PRF(TLSKeyMaterialSpec paramTLSKeyMaterialSpec, Mac paramMac)
    {
      byte[] arrayOfByte1 = Arrays.concatenate(Strings.toByteArray(paramTLSKeyMaterialSpec.getLabel()), paramTLSKeyMaterialSpec.getSeed());
      byte[] arrayOfByte2 = paramTLSKeyMaterialSpec.getSecret();
      paramTLSKeyMaterialSpec = new byte[paramTLSKeyMaterialSpec.getLength()];
      TLSKDF.hmac_hash(paramMac, arrayOfByte2, arrayOfByte1, paramTLSKeyMaterialSpec);
      return paramTLSKeyMaterialSpec;
    }
    
    protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
      throws InvalidKeySpecException
    {
      if ((paramKeySpec instanceof TLSKeyMaterialSpec)) {
        return new SecretKeySpec(PRF((TLSKeyMaterialSpec)paramKeySpec, this.prf), this.algName);
      }
      throw new InvalidKeySpecException("Invalid KeySpec");
    }
  }
  
  public static final class TLS12withSHA256
    extends TLSKDF.TLS12
  {
    public TLS12withSHA256()
    {
      super(new HMac(new SHA256Digest()));
    }
  }
  
  public static final class TLS12withSHA384
    extends TLSKDF.TLS12
  {
    public TLS12withSHA384()
    {
      super(new HMac(new SHA384Digest()));
    }
  }
  
  public static final class TLS12withSHA512
    extends TLSKDF.TLS12
  {
    public TLS12withSHA512()
    {
      super(new HMac(new SHA512Digest()));
    }
  }
  
  public static class TLSKeyMaterialFactory
    extends BaseSecretKeyFactory
  {
    protected TLSKeyMaterialFactory(String paramString)
    {
      super(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\TLSKDF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */