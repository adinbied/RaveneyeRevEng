package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.DSAParameter;

public class AlgorithmParametersSpi
  extends java.security.AlgorithmParametersSpi
{
  DSAParameterSpec currentSpec;
  
  protected byte[] engineGetEncoded()
  {
    Object localObject = new DSAParameter(this.currentSpec.getP(), this.currentSpec.getQ(), this.currentSpec.getG());
    try
    {
      localObject = ((DSAParameter)localObject).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new RuntimeException("Error encoding DSAParameters");
  }
  
  protected byte[] engineGetEncoded(String paramString)
  {
    if (isASN1FormatString(paramString)) {
      return engineGetEncoded();
    }
    return null;
  }
  
  protected AlgorithmParameterSpec engineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if (paramClass != null) {
      return localEngineGetParameterSpec(paramClass);
    }
    throw new NullPointerException("argument to getParameterSpec must not be null");
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidParameterSpecException
  {
    if ((paramAlgorithmParameterSpec instanceof DSAParameterSpec))
    {
      this.currentSpec = ((DSAParameterSpec)paramAlgorithmParameterSpec);
      return;
    }
    throw new InvalidParameterSpecException("DSAParameterSpec required to initialise a DSA algorithm parameters object");
  }
  
  protected void engineInit(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = DSAParameter.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      this.currentSpec = new DSAParameterSpec(paramArrayOfByte.getP(), paramArrayOfByte.getQ(), paramArrayOfByte.getG());
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
    throw new IOException("Not a valid DSA Parameter encoding.");
    throw new IOException("Not a valid DSA Parameter encoding.");
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
    return "DSA Parameters";
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
  
  protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if ((paramClass != DSAParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
      throw new InvalidParameterSpecException("unknown parameter spec passed to DSA parameters object.");
    }
    return this.currentSpec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */