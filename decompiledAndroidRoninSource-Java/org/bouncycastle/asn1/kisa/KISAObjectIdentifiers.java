package org.bouncycastle.asn1.kisa;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface KISAObjectIdentifiers
{
  public static final ASN1ObjectIdentifier id_mod_cms_seed = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.0.24");
  public static final ASN1ObjectIdentifier id_npki_app_cmsSeed_wrap;
  public static final ASN1ObjectIdentifier id_seedCBC = new ASN1ObjectIdentifier("1.2.410.200004.1.4");
  public static final ASN1ObjectIdentifier id_seedMAC = new ASN1ObjectIdentifier("1.2.410.200004.1.7");
  public static final ASN1ObjectIdentifier pbeWithSHA1AndSEED_CBC = new ASN1ObjectIdentifier("1.2.410.200004.1.15");
  
  static
  {
    id_npki_app_cmsSeed_wrap = new ASN1ObjectIdentifier("1.2.410.200004.7.1.1.1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\kisa\KISAObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */