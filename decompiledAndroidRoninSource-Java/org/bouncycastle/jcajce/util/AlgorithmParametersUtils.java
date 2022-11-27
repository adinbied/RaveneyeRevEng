package org.bouncycastle.jcajce.util;

import java.io.IOException;
import java.security.AlgorithmParameters;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

public class AlgorithmParametersUtils
{
  public static ASN1Encodable extractParameters(AlgorithmParameters paramAlgorithmParameters)
    throws IOException
  {
    try
    {
      ASN1Primitive localASN1Primitive = ASN1Primitive.fromByteArray(paramAlgorithmParameters.getEncoded("ASN.1"));
      return localASN1Primitive;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return ASN1Primitive.fromByteArray(paramAlgorithmParameters.getEncoded());
  }
  
  public static void loadParameters(AlgorithmParameters paramAlgorithmParameters, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    try
    {
      paramAlgorithmParameters.init(paramASN1Encodable.toASN1Primitive().getEncoded(), "ASN.1");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    paramAlgorithmParameters.init(paramASN1Encodable.toASN1Primitive().getEncoded());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajc\\util\AlgorithmParametersUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */