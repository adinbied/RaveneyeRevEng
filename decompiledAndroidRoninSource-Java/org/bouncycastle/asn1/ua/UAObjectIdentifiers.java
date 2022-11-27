package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface UAObjectIdentifiers
{
  public static final ASN1ObjectIdentifier UaOid;
  public static final ASN1ObjectIdentifier dstu4145be = UaOid.branch("1.3.1.1.1.1");
  public static final ASN1ObjectIdentifier dstu4145le;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.804.2.1.1.1");
    UaOid = localASN1ObjectIdentifier;
    dstu4145le = localASN1ObjectIdentifier.branch("1.3.1.1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\ua\UAObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */