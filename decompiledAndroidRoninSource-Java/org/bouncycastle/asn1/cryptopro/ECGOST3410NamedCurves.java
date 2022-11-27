package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.Fp;

public class ECGOST3410NamedCurves
{
  static final Hashtable names;
  static final Hashtable objIds = new Hashtable();
  static final Hashtable params = new Hashtable();
  
  static
  {
    names = new Hashtable();
    Object localObject2 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
    Object localObject1 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
    localObject2 = new ECCurve.Fp((BigInteger)localObject2, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), (BigInteger)localObject1, ECConstants.ONE);
    localObject1 = new ECDomainParameters((ECCurve)localObject2, ((ECCurve.Fp)localObject2).createPoint(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), (BigInteger)localObject1);
    params.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A, localObject1);
    localObject2 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
    localObject1 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
    localObject2 = new ECCurve.Fp((BigInteger)localObject2, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), (BigInteger)localObject1, ECConstants.ONE);
    localObject1 = new ECDomainParameters((ECCurve)localObject2, ((ECCurve.Fp)localObject2).createPoint(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), (BigInteger)localObject1);
    params.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA, localObject1);
    localObject2 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
    localObject1 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
    localObject2 = new ECCurve.Fp((BigInteger)localObject2, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), (BigInteger)localObject1, ECConstants.ONE);
    localObject1 = new ECDomainParameters((ECCurve)localObject2, ((ECCurve.Fp)localObject2).createPoint(new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124")), (BigInteger)localObject1);
    params.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B, localObject1);
    localObject2 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
    localObject1 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
    localObject2 = new ECCurve.Fp((BigInteger)localObject2, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), (BigInteger)localObject1, ECConstants.ONE);
    localObject1 = new ECDomainParameters((ECCurve)localObject2, ((ECCurve.Fp)localObject2).createPoint(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), (BigInteger)localObject1);
    params.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB, localObject1);
    localObject2 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
    localObject1 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
    localObject2 = new ECCurve.Fp((BigInteger)localObject2, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), (BigInteger)localObject1, ECConstants.ONE);
    localObject1 = new ECDomainParameters((ECCurve)localObject2, ((ECCurve.Fp)localObject2).createPoint(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), (BigInteger)localObject1);
    params.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C, localObject1);
    objIds.put("GostR3410-2001-CryptoPro-A", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A);
    objIds.put("GostR3410-2001-CryptoPro-B", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B);
    objIds.put("GostR3410-2001-CryptoPro-C", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C);
    objIds.put("GostR3410-2001-CryptoPro-XchA", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA);
    objIds.put("GostR3410-2001-CryptoPro-XchB", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB);
    names.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A, "GostR3410-2001-CryptoPro-A");
    names.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B, "GostR3410-2001-CryptoPro-B");
    names.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C, "GostR3410-2001-CryptoPro-C");
    names.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA, "GostR3410-2001-CryptoPro-XchA");
    names.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB, "GostR3410-2001-CryptoPro-XchB");
  }
  
  public static ECDomainParameters getByName(String paramString)
  {
    paramString = (ASN1ObjectIdentifier)objIds.get(paramString);
    if (paramString != null) {
      return (ECDomainParameters)params.get(paramString);
    }
    return null;
  }
  
  public static ECDomainParameters getByOID(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (ECDomainParameters)params.get(paramASN1ObjectIdentifier);
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
    return (ASN1ObjectIdentifier)objIds.get(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cryptopro\ECGOST3410NamedCurves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */