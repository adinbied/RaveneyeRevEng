package org.bouncycastle.jce;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECGOST3410NamedCurveTable
{
  public static Enumeration getNames()
  {
    return ECGOST3410NamedCurves.getNames();
  }
  
  public static ECNamedCurveParameterSpec getParameterSpec(String paramString)
  {
    ECDomainParameters localECDomainParameters2 = ECGOST3410NamedCurves.getByName(paramString);
    ECDomainParameters localECDomainParameters1 = localECDomainParameters2;
    if (localECDomainParameters2 == null) {}
    try
    {
      localECDomainParameters1 = ECGOST3410NamedCurves.getByOID(new ASN1ObjectIdentifier(paramString));
      if (localECDomainParameters1 == null) {
        return null;
      }
      return new ECNamedCurveParameterSpec(paramString, localECDomainParameters1.getCurve(), localECDomainParameters1.getG(), localECDomainParameters1.getN(), localECDomainParameters1.getH(), localECDomainParameters1.getSeed());
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\ECGOST3410NamedCurveTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */