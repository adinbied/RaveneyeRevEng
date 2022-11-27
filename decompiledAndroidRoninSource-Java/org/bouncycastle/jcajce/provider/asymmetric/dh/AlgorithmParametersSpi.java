package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.pkcs.DHParameter;

public class AlgorithmParametersSpi
  extends java.security.AlgorithmParametersSpi
{
  DHParameterSpec currentSpec;
  
  protected byte[] engineGetEncoded()
  {
    Object localObject = new DHParameter(this.currentSpec.getP(), this.currentSpec.getG(), this.currentSpec.getL());
    try
    {
      localObject = ((DHParameter)localObject).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new RuntimeException("Error encoding DHParameters");
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
    if ((paramAlgorithmParameterSpec instanceof DHParameterSpec))
    {
      this.currentSpec = ((DHParameterSpec)paramAlgorithmParameterSpec);
      return;
    }
    throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
  }
  
  protected void engineInit(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = DHParameter.getInstance(paramArrayOfByte);
      if (paramArrayOfByte.getL() != null) {}
      for (paramArrayOfByte = new DHParameterSpec(paramArrayOfByte.getP(), paramArrayOfByte.getG(), paramArrayOfByte.getL().intValue());; paramArrayOfByte = new DHParameterSpec(paramArrayOfByte.getP(), paramArrayOfByte.getG()))
      {
        this.currentSpec = paramArrayOfByte;
        return;
      }
    }
    catch (ClassCastException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new IOException("Not a valid DH Parameter encoding.");
    throw new IOException("Not a valid DH Parameter encoding.");
  }
  
  protected void engineInit(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    if (isASN1FormatString(paramString))
    {
      engineInit(paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Unknown parameter format ");
    paramArrayOfByte.append(paramString);
    throw new IOException(paramArrayOfByte.toString());
  }
  
  protected String engineToString()
  {
    return "Diffie-Hellman Parameters";
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
  
  protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if ((paramClass != DHParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
      throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
    }
    return this.currentSpec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */