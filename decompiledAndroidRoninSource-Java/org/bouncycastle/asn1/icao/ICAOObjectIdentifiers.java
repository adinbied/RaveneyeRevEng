package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface ICAOObjectIdentifiers
{
  public static final ASN1ObjectIdentifier id_icao;
  public static final ASN1ObjectIdentifier id_icao_aaProtocolObject;
  public static final ASN1ObjectIdentifier id_icao_cscaMasterList;
  public static final ASN1ObjectIdentifier id_icao_cscaMasterListSigningKey;
  public static final ASN1ObjectIdentifier id_icao_documentTypeList;
  public static final ASN1ObjectIdentifier id_icao_extensions;
  public static final ASN1ObjectIdentifier id_icao_extensions_namechangekeyrollover;
  public static final ASN1ObjectIdentifier id_icao_ldsSecurityObject;
  public static final ASN1ObjectIdentifier id_icao_mrtd;
  public static final ASN1ObjectIdentifier id_icao_mrtd_security;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("2.23.136");
    id_icao = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    id_icao_mrtd = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    id_icao_mrtd_security = localASN1ObjectIdentifier;
    id_icao_ldsSecurityObject = localASN1ObjectIdentifier.branch("1");
    id_icao_cscaMasterList = id_icao_mrtd_security.branch("2");
    id_icao_cscaMasterListSigningKey = id_icao_mrtd_security.branch("3");
    id_icao_documentTypeList = id_icao_mrtd_security.branch("4");
    id_icao_aaProtocolObject = id_icao_mrtd_security.branch("5");
    localASN1ObjectIdentifier = id_icao_mrtd_security.branch("6");
    id_icao_extensions = localASN1ObjectIdentifier;
    id_icao_extensions_namechangekeyrollover = localASN1ObjectIdentifier.branch("1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\icao\ICAOObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */