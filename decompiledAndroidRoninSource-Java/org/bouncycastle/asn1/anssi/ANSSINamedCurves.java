package org.bouncycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class ANSSINamedCurves
{
  static X9ECParametersHolder FRP256v1 = new X9ECParametersHolder()
  {
    protected X9ECParameters createParameters()
    {
      Object localObject = ANSSINamedCurves.fromHex("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
      BigInteger localBigInteger3 = ANSSINamedCurves.fromHex("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
      BigInteger localBigInteger4 = ANSSINamedCurves.fromHex("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
      BigInteger localBigInteger1 = ANSSINamedCurves.fromHex("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
      BigInteger localBigInteger2 = BigInteger.valueOf(1L);
      localObject = ANSSINamedCurves.configureCurve(new ECCurve.Fp((BigInteger)localObject, localBigInteger3, localBigInteger4, localBigInteger1, localBigInteger2));
      return new X9ECParameters((ECCurve)localObject, new X9ECPoint((ECCurve)localObject, Hex.decode("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), localBigInteger1, localBigInteger2, null);
    }
  };
  static final Hashtable curves;
  static final Hashtable names;
  static final Hashtable objIds = new Hashtable();
  
  static
  {
    curves = new Hashtable();
    names = new Hashtable();
    defineCurve("FRP256v1", ANSSIObjectIdentifiers.FRP256v1, FRP256v1);
  }
  
  private static ECCurve configureCurve(ECCurve paramECCurve)
  {
    return paramECCurve;
  }
  
  static void defineCurve(String paramString, ASN1ObjectIdentifier paramASN1ObjectIdentifier, X9ECParametersHolder paramX9ECParametersHolder)
  {
    objIds.put(Strings.toLowerCase(paramString), paramASN1ObjectIdentifier);
    names.put(paramASN1ObjectIdentifier, paramString);
    curves.put(paramASN1ObjectIdentifier, paramX9ECParametersHolder);
  }
  
  private static BigInteger fromHex(String paramString)
  {
    return new BigInteger(1, Hex.decode(paramString));
  }
  
  public static X9ECParameters getByName(String paramString)
  {
    paramString = getOID(paramString);
    if (paramString == null) {
      return null;
    }
    return getByOID(paramString);
  }
  
  public static X9ECParameters getByOID(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    paramASN1ObjectIdentifier = (X9ECParametersHolder)curves.get(paramASN1ObjectIdentifier);
    if (paramASN1ObjectIdentifier == null) {
      return null;
    }
    return paramASN1ObjectIdentifier.getParameters();
  }
  
  public static String getName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (String)names.get(paramASN1ObjectIdentifier);
  }
  
  public static Enumeration getNames()
  {
    return names.elements();
  }
  
  public static ASN1ObjectIdentifier getOID(String paramString)
  {
    return (ASN1ObjectIdentifier)objIds.get(Strings.toLowerCase(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\anssi\ANSSINamedCurves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */