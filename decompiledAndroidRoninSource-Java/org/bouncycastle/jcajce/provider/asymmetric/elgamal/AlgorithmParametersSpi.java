package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;

public class AlgorithmParametersSpi
  extends BaseAlgorithmParameters
{
  ElGamalParameterSpec currentSpec;
  
  protected byte[] engineGetEncoded()
  {
    Object localObject = new ElGamalParameter(this.currentSpec.getP(), this.currentSpec.getG());
    try
    {
      localObject = ((ElGamalParameter)localObject).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new RuntimeException("Error encoding ElGamalParameters");
  }
  
  protected byte[] engineGetEncoded(String paramString)
  {
    if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509"))) {
      return null;
    }
    return engineGetEncoded();
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidParameterSpecException
  {
    boolean bool = paramAlgorithmParameterSpec instanceof ElGamalParameterSpec;
    if ((!bool) && (!(paramAlgorithmParameterSpec instanceof DHParameterSpec))) {
      throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
    }
    if (bool)
    {
      this.currentSpec = ((ElGamalParameterSpec)paramAlgorithmParameterSpec);
      return;
    }
    paramAlgorithmParameterSpec = (DHParameterSpec)paramAlgorithmParameterSpec;
    this.currentSpec = new ElGamalParameterSpec(paramAlgorithmParameterSpec.getP(), paramAlgorithmParameterSpec.getG());
  }
  
  protected void engineInit(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = ElGamalParameter.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      this.currentSpec = new ElGamalParameterSpec(paramArrayOfByte.getP(), paramArrayOfByte.getG());
      return;
    }
    catch (ClassCastException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new IOException("Not a valid ElGamal Parameter encoding.");
    throw new IOException("Not a valid ElGamal Parameter encoding.");
  }
  
  protected void engineInit(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509")))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unknown parameter format ");
      paramArrayOfByte.append(paramString);
      throw new IOException(paramArrayOfByte.toString());
    }
    engineInit(paramArrayOfByte);
  }
  
  protected String engineToString()
  {
    return "ElGamal Parameters";
  }
  
  protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if ((paramClass != ElGamalParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class))
    {
      if (paramClass == DHParameterSpec.class) {
        return new DHParameterSpec(this.currentSpec.getP(), this.currentSpec.getG());
      }
      throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }
    return this.currentSpec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */