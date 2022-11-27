package org.bouncycastle.asn1.gm;

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

public class GMNamedCurves
{
  static final Hashtable curves;
  static final Hashtable names;
  static final Hashtable objIds;
  static X9ECParametersHolder sm2p256v1 = new X9ECParametersHolder()
  {
    protected X9ECParameters createParameters()
    {
      Object localObject = GMNamedCurves.fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
      BigInteger localBigInteger3 = GMNamedCurves.fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
      BigInteger localBigInteger4 = GMNamedCurves.fromHex("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
      BigInteger localBigInteger1 = GMNamedCurves.fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
      BigInteger localBigInteger2 = BigInteger.valueOf(1L);
      localObject = GMNamedCurves.configureCurve(new ECCurve.Fp((BigInteger)localObject, localBigInteger3, localBigInteger4, localBigInteger1, localBigInteger2));
      return new X9ECParameters((ECCurve)localObject, new X9ECPoint((ECCurve)localObject, Hex.decode("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), localBigInteger1, localBigInteger2, null);
    }
  };
  static X9ECParametersHolder wapip192v1 = new X9ECParametersHolder()
  {
    protected X9ECParameters createParameters()
    {
      Object localObject = GMNamedCurves.fromHex("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
      BigInteger localBigInteger3 = GMNamedCurves.fromHex("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
      BigInteger localBigInteger4 = GMNamedCurves.fromHex("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
      BigInteger localBigInteger1 = GMNamedCurves.fromHex("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
      BigInteger localBigInteger2 = BigInteger.valueOf(1L);
      localObject = GMNamedCurves.configureCurve(new ECCurve.Fp((BigInteger)localObject, localBigInteger3, localBigInteger4, localBigInteger1, localBigInteger2));
      return new X9ECParameters((ECCurve)localObject, new X9ECPoint((ECCurve)localObject, Hex.decode("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), localBigInteger1, localBigInteger2, null);
    }
  };
  
  static
  {
    objIds = new Hashtable();
    curves = new Hashtable();
    names = new Hashtable();
    defineCurve("wapip192v1", GMObjectIdentifiers.wapip192v1, wapip192v1);
    defineCurve("sm2p256v1", GMObjectIdentifiers.sm2p256v1, sm2p256v1);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\gm\GMNamedCurves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */