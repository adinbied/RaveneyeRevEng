package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class AlgorithmParametersSpi
  extends java.security.AlgorithmParametersSpi
{
  GOST3410ParameterSpec currentSpec;
  
  protected byte[] engineGetEncoded()
  {
    Object localObject = new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.currentSpec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.currentSpec.getDigestParamSetOID()), new ASN1ObjectIdentifier(this.currentSpec.getEncryptionParamSetOID()));
    try
    {
      localObject = ((GOST3410PublicKeyAlgParameters)localObject).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new RuntimeException("Error encoding GOST3410Parameters");
  }
  
  protected byte[] engineGetEncoded(String paramString)
  {
    if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509"))) {
      return null;
    }
    return engineGetEncoded();
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
    if ((paramAlgorithmParameterSpec instanceof GOST3410ParameterSpec))
    {
      this.currentSpec = ((GOST3410ParameterSpec)paramAlgorithmParameterSpec);
      return;
    }
    throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
  }
  
  protected void engineInit(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      this.currentSpec = GOST3410ParameterSpec.fromPublicKeyAlg(new GOST3410PublicKeyAlgParameters((ASN1Sequence)ASN1Primitive.fromByteArray(paramArrayOfByte)));
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
    throw new IOException("Not a valid GOST3410 Parameter encoding.");
    throw new IOException("Not a valid GOST3410 Parameter encoding.");
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
    return "GOST3410 Parameters";
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
  
  protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if ((paramClass != GOST3410PublicKeyParameterSetSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
      throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
    }
    return this.currentSpec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */