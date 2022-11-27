package org.bouncycastle.jce;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECNamedCurveTable
{
  public static Enumeration getNames()
  {
    return org.bouncycastle.asn1.x9.ECNamedCurveTable.getNames();
  }
  
  public static ECNamedCurveParameterSpec getParameterSpec(String paramString)
  {
    localObject3 = CustomNamedCurves.getByName(paramString);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = CustomNamedCurves.getByOID(new ASN1ObjectIdentifier(paramString));
      localObject3 = localObject1;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      for (;;) {}
    }
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject3 = org.bouncycastle.asn1.x9.ECNamedCurveTable.getByName(paramString);
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    try
    {
      localObject1 = org.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(paramString));
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 == null) {
      return null;
    }
    return new ECNamedCurveParameterSpec(paramString, ((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getG(), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH(), ((X9ECParameters)localObject1).getSeed());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\ECNamedCurveTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */