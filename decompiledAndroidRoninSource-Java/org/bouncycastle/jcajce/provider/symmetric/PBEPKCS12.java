package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public class PBEPKCS12
{
  public static class AlgParams
    extends BaseAlgorithmParameters
  {
    PKCS12PBEParams params;
    
    protected byte[] engineGetEncoded()
    {
      try
      {
        byte[] arrayOfByte = this.params.getEncoded("DER");
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Oooops! ");
        localStringBuilder.append(localIOException.toString());
        throw new RuntimeException(localStringBuilder.toString());
      }
    }
    
    protected byte[] engineGetEncoded(String paramString)
    {
      if (isASN1FormatString(paramString)) {
        return engineGetEncoded();
      }
      return null;
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec))
      {
        paramAlgorithmParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        this.params = new PKCS12PBEParams(paramAlgorithmParameterSpec.getSalt(), paramAlgorithmParameterSpec.getIterationCount());
        return;
      }
      throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      this.params = PKCS12PBEParams.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString))
      {
        engineInit(paramArrayOfByte);
        return;
      }
      throw new IOException("Unknown parameters format in PKCS12 PBE parameters object");
    }
    
    protected String engineToString()
    {
      return "PKCS12 PBE Parameters";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if (paramClass == PBEParameterSpec.class) {
        return new PBEParameterSpec(this.params.getIV(), this.params.getIterations().intValue());
      }
      throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = PBEPKCS12.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.PKCS12PBE", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\PBEPKCS12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */