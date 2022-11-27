package org.bouncycastle.asn1.rosstandart;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface RosstandartObjectIdentifiers
{
  public static final ASN1ObjectIdentifier id_tc26;
  public static final ASN1ObjectIdentifier id_tc26_gost_28147_param_Z = id_tc26.branch("2.5.1.1");
  public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSetA;
  public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetA;
  public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetB;
  public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetC;
  public static final ASN1ObjectIdentifier id_tc26_gost_3411_12_256;
  public static final ASN1ObjectIdentifier id_tc26_gost_3411_12_512;
  public static final ASN1ObjectIdentifier id_tc26_hmac_gost_3411_12_256;
  public static final ASN1ObjectIdentifier id_tc26_hmac_gost_3411_12_512;
  public static final ASN1ObjectIdentifier rosstandart;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.643.7");
    rosstandart = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    id_tc26 = localASN1ObjectIdentifier;
    id_tc26_gost_3411_12_256 = localASN1ObjectIdentifier.branch("1.2.2");
    id_tc26_gost_3411_12_512 = id_tc26.branch("1.2.3");
    id_tc26_hmac_gost_3411_12_256 = id_tc26.branch("1.4.1");
    id_tc26_hmac_gost_3411_12_512 = id_tc26.branch("1.4.2");
    id_tc26_gost_3410_12_256_paramSetA = id_tc26.branch("2.1.1.1");
    id_tc26_gost_3410_12_512_paramSetA = id_tc26.branch("2.1.2.1");
    id_tc26_gost_3410_12_512_paramSetB = id_tc26.branch("2.1.2.2");
    id_tc26_gost_3410_12_512_paramSetC = id_tc26.branch("2.1.2.3");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\rosstandart\RosstandartObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */