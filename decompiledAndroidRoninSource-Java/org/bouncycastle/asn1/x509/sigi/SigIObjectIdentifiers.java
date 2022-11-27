package org.bouncycastle.asn1.x509.sigi;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface SigIObjectIdentifiers
{
  public static final ASN1ObjectIdentifier id_sigi = new ASN1ObjectIdentifier("1.3.36.8");
  public static final ASN1ObjectIdentifier id_sigi_cp;
  public static final ASN1ObjectIdentifier id_sigi_cp_sigconform = new ASN1ObjectIdentifier("1.3.36.8.1.1");
  public static final ASN1ObjectIdentifier id_sigi_kp = new ASN1ObjectIdentifier("1.3.36.8.2");
  public static final ASN1ObjectIdentifier id_sigi_kp_directoryService;
  public static final ASN1ObjectIdentifier id_sigi_on;
  public static final ASN1ObjectIdentifier id_sigi_on_personalData;
  
  static
  {
    id_sigi_cp = new ASN1ObjectIdentifier("1.3.36.8.1");
    id_sigi_on = new ASN1ObjectIdentifier("1.3.36.8.4");
    id_sigi_kp_directoryService = new ASN1ObjectIdentifier("1.3.36.8.2.1");
    id_sigi_on_personalData = new ASN1ObjectIdentifier("1.3.36.8.4.1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\sigi\SigIObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */