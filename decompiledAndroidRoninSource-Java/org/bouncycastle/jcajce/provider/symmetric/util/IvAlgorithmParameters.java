package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

public class IvAlgorithmParameters
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
      return new DEROctetString(engineGetEncoded("RAW")).getEncoded();
    }
    if (paramString.equals("RAW")) {
      return Arrays.clone(this.iv);
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
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length % 8 != 0)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte[0] == 4)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte[1] == paramArrayOfByte.length - 2) {
          arrayOfByte = ((ASN1OctetString)ASN1Primitive.fromByteArray(paramArrayOfByte)).getOctets();
        }
      }
    }
    this.iv = Arrays.clone(arrayOfByte);
  }
  
  protected void engineInit(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    if (isASN1FormatString(paramString)) {
      try
      {
        engineInit(((ASN1OctetString)ASN1Primitive.fromByteArray(paramArrayOfByte)).getOctets());
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramString = new StringBuilder();
        paramString.append("Exception decoding: ");
        paramString.append(paramArrayOfByte);
        throw new IOException(paramString.toString());
      }
    }
    if (paramString.equals("RAW"))
    {
      engineInit(paramArrayOfByte);
      return;
    }
    throw new IOException("Unknown parameters format in IV parameters object");
  }
  
  protected String engineToString()
  {
    return "IV Parameters";
  }
  
  protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if ((paramClass != IvParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
      throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
    }
    return new IvParameterSpec(this.iv);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\IvAlgorithmParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */