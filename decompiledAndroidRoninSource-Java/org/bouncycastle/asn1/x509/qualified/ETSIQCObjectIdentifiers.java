package org.bouncycastle.asn1.x509.qualified;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface ETSIQCObjectIdentifiers
{
  public static final ASN1ObjectIdentifier id_etsi_qcs_LimiteValue;
  public static final ASN1ObjectIdentifier id_etsi_qcs_QcCompliance = new ASN1ObjectIdentifier("0.4.0.1862.1.1");
  public static final ASN1ObjectIdentifier id_etsi_qcs_QcPds;
  public static final ASN1ObjectIdentifier id_etsi_qcs_QcSSCD;
  public static final ASN1ObjectIdentifier id_etsi_qcs_QcType;
  public static final ASN1ObjectIdentifier id_etsi_qcs_RetentionPeriod;
  public static final ASN1ObjectIdentifier id_etsi_qct_eseal = id_etsi_qcs_QcType.branch("2");
  public static final ASN1ObjectIdentifier id_etsi_qct_esign;
  public static final ASN1ObjectIdentifier id_etsi_qct_web = id_etsi_qcs_QcType.branch("3");
  
  static
  {
    id_etsi_qcs_LimiteValue = new ASN1ObjectIdentifier("0.4.0.1862.1.2");
    id_etsi_qcs_RetentionPeriod = new ASN1ObjectIdentifier("0.4.0.1862.1.3");
    id_etsi_qcs_QcSSCD = new ASN1ObjectIdentifier("0.4.0.1862.1.4");
    id_etsi_qcs_QcPds = new ASN1ObjectIdentifier("0.4.0.1862.1.5");
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.1862.1.6");
    id_etsi_qcs_QcType = localASN1ObjectIdentifier;
    id_etsi_qct_esign = localASN1ObjectIdentifier.branch("1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\qualified\ETSIQCObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */