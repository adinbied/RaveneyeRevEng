package org.bouncycastle.asn1.iso;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface ISOIECObjectIdentifiers
{
  public static final ASN1ObjectIdentifier hash_algorithms;
  public static final ASN1ObjectIdentifier id_ac_generic_hybrid;
  public static final ASN1ObjectIdentifier id_kem_rsa = is18033_2.branch("2.4");
  public static final ASN1ObjectIdentifier is18033_2;
  public static final ASN1ObjectIdentifier iso_encryption_algorithms;
  public static final ASN1ObjectIdentifier ripemd128;
  public static final ASN1ObjectIdentifier ripemd160;
  public static final ASN1ObjectIdentifier whirlpool;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.0.10118");
    iso_encryption_algorithms = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("3.0");
    hash_algorithms = localASN1ObjectIdentifier;
    ripemd160 = localASN1ObjectIdentifier.branch("49");
    ripemd128 = hash_algorithms.branch("50");
    whirlpool = hash_algorithms.branch("55");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.0.18033.2");
    is18033_2 = localASN1ObjectIdentifier;
    id_ac_generic_hybrid = localASN1ObjectIdentifier.branch("1.2");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\iso\ISOIECObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */