package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface X509AttributeIdentifiers
{
  public static final ASN1ObjectIdentifier RoleSyntax = new ASN1ObjectIdentifier("2.5.4.72");
  public static final ASN1ObjectIdentifier id_aca;
  public static final ASN1ObjectIdentifier id_aca_accessIdentity;
  public static final ASN1ObjectIdentifier id_aca_authenticationInfo;
  public static final ASN1ObjectIdentifier id_aca_chargingIdentity;
  public static final ASN1ObjectIdentifier id_aca_encAttrs;
  public static final ASN1ObjectIdentifier id_aca_group;
  public static final ASN1ObjectIdentifier id_at_clearance = new ASN1ObjectIdentifier("2.5.1.5.55");
  public static final ASN1ObjectIdentifier id_at_role;
  public static final ASN1ObjectIdentifier id_ce_targetInformation;
  public static final ASN1ObjectIdentifier id_pe_aaControls;
  public static final ASN1ObjectIdentifier id_pe_ac_auditIdentity = X509ObjectIdentifiers.id_pe.branch("4");
  public static final ASN1ObjectIdentifier id_pe_ac_proxying;
  
  static
  {
    id_pe_aaControls = X509ObjectIdentifiers.id_pe.branch("6");
    id_pe_ac_proxying = X509ObjectIdentifiers.id_pe.branch("10");
    id_ce_targetInformation = X509ObjectIdentifiers.id_ce.branch("55");
    ASN1ObjectIdentifier localASN1ObjectIdentifier = X509ObjectIdentifiers.id_pkix.branch("10");
    id_aca = localASN1ObjectIdentifier;
    id_aca_authenticationInfo = localASN1ObjectIdentifier.branch("1");
    id_aca_accessIdentity = id_aca.branch("2");
    id_aca_chargingIdentity = id_aca.branch("3");
    id_aca_group = id_aca.branch("4");
    id_aca_encAttrs = id_aca.branch("6");
    id_at_role = new ASN1ObjectIdentifier("2.5.4.72");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509AttributeIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */