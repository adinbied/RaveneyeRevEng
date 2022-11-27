package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.anssi.ANSSINamedCurves;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;

public class ECNamedCurveTable
{
  private static void addEnumeration(Vector paramVector, Enumeration paramEnumeration)
  {
    while (paramEnumeration.hasMoreElements()) {
      paramVector.addElement(paramEnumeration.nextElement());
    }
  }
  
  public static X9ECParameters getByName(String paramString)
  {
    Object localObject2 = X962NamedCurves.getByName(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = SECNamedCurves.getByName(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = NISTNamedCurves.getByName(paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = TeleTrusTNamedCurves.getByName(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ANSSINamedCurves.getByName(paramString);
    }
    return (X9ECParameters)localObject2;
  }
  
  public static X9ECParameters getByOID(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject2 = X962NamedCurves.getByOID(paramASN1ObjectIdentifier);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = SECNamedCurves.getByOID(paramASN1ObjectIdentifier);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = TeleTrusTNamedCurves.getByOID(paramASN1ObjectIdentifier);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ANSSINamedCurves.getByOID(paramASN1ObjectIdentifier);
    }
    return (X9ECParameters)localObject1;
  }
  
  public static String getName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject2 = NISTNamedCurves.getName(paramASN1ObjectIdentifier);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = SECNamedCurves.getName(paramASN1ObjectIdentifier);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = TeleTrusTNamedCurves.getName(paramASN1ObjectIdentifier);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = X962NamedCurves.getName(paramASN1ObjectIdentifier);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ECGOST3410NamedCurves.getName(paramASN1ObjectIdentifier);
    }
    return (String)localObject2;
  }
  
  public static Enumeration getNames()
  {
    Vector localVector = new Vector();
    addEnumeration(localVector, X962NamedCurves.getNames());
    addEnumeration(localVector, SECNamedCurves.getNames());
    addEnumeration(localVector, NISTNamedCurves.getNames());
    addEnumeration(localVector, TeleTrusTNamedCurves.getNames());
    addEnumeration(localVector, ANSSINamedCurves.getNames());
    return localVector.elements();
  }
  
  public static ASN1ObjectIdentifier getOID(String paramString)
  {
    Object localObject2 = X962NamedCurves.getOID(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = SECNamedCurves.getOID(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = NISTNamedCurves.getOID(paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = TeleTrusTNamedCurves.getOID(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ANSSINamedCurves.getOID(paramString);
    }
    return (ASN1ObjectIdentifier)localObject2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\ECNamedCurveTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */