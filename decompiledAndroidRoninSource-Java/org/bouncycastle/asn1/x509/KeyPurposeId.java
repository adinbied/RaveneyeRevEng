package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

public class KeyPurposeId
  extends ASN1Object
{
  public static final KeyPurposeId anyExtendedKeyUsage;
  private static final ASN1ObjectIdentifier id_kp = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.3");
  public static final KeyPurposeId id_kp_OCSPSigning;
  public static final KeyPurposeId id_kp_capwapAC;
  public static final KeyPurposeId id_kp_capwapWTP;
  public static final KeyPurposeId id_kp_clientAuth;
  public static final KeyPurposeId id_kp_codeSigning;
  public static final KeyPurposeId id_kp_dvcs;
  public static final KeyPurposeId id_kp_eapOverLAN;
  public static final KeyPurposeId id_kp_eapOverPPP;
  public static final KeyPurposeId id_kp_emailProtection;
  public static final KeyPurposeId id_kp_ipsecEndSystem;
  public static final KeyPurposeId id_kp_ipsecIKE;
  public static final KeyPurposeId id_kp_ipsecTunnel;
  public static final KeyPurposeId id_kp_ipsecUser;
  public static final KeyPurposeId id_kp_macAddress = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.1.1.1.22"));
  public static final KeyPurposeId id_kp_msSGC = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.10.3.3"));
  public static final KeyPurposeId id_kp_nsSGC = new KeyPurposeId(new ASN1ObjectIdentifier("2.16.840.1.113730.4.1"));
  public static final KeyPurposeId id_kp_sbgpCertAAServerAuth;
  public static final KeyPurposeId id_kp_scvpClient;
  public static final KeyPurposeId id_kp_scvpServer;
  public static final KeyPurposeId id_kp_scvp_responder;
  public static final KeyPurposeId id_kp_serverAuth;
  public static final KeyPurposeId id_kp_smartcardlogon;
  public static final KeyPurposeId id_kp_timeStamping;
  private ASN1ObjectIdentifier id;
  
  static
  {
    anyExtendedKeyUsage = new KeyPurposeId(Extension.extendedKeyUsage.branch("0"));
    id_kp_serverAuth = new KeyPurposeId(id_kp.branch("1"));
    id_kp_clientAuth = new KeyPurposeId(id_kp.branch("2"));
    id_kp_codeSigning = new KeyPurposeId(id_kp.branch("3"));
    id_kp_emailProtection = new KeyPurposeId(id_kp.branch("4"));
    id_kp_ipsecEndSystem = new KeyPurposeId(id_kp.branch("5"));
    id_kp_ipsecTunnel = new KeyPurposeId(id_kp.branch("6"));
    id_kp_ipsecUser = new KeyPurposeId(id_kp.branch("7"));
    id_kp_timeStamping = new KeyPurposeId(id_kp.branch("8"));
    id_kp_OCSPSigning = new KeyPurposeId(id_kp.branch("9"));
    id_kp_dvcs = new KeyPurposeId(id_kp.branch("10"));
    id_kp_sbgpCertAAServerAuth = new KeyPurposeId(id_kp.branch("11"));
    id_kp_scvp_responder = new KeyPurposeId(id_kp.branch("12"));
    id_kp_eapOverPPP = new KeyPurposeId(id_kp.branch("13"));
    id_kp_eapOverLAN = new KeyPurposeId(id_kp.branch("14"));
    id_kp_scvpServer = new KeyPurposeId(id_kp.branch("15"));
    id_kp_scvpClient = new KeyPurposeId(id_kp.branch("16"));
    id_kp_ipsecIKE = new KeyPurposeId(id_kp.branch("17"));
    id_kp_capwapAC = new KeyPurposeId(id_kp.branch("18"));
    id_kp_capwapWTP = new KeyPurposeId(id_kp.branch("19"));
    id_kp_smartcardlogon = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.20.2.2"));
  }
  
  public KeyPurposeId(String paramString)
  {
    this(new ASN1ObjectIdentifier(paramString));
  }
  
  private KeyPurposeId(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.id = paramASN1ObjectIdentifier;
  }
  
  public static KeyPurposeId getInstance(Object paramObject)
  {
    if ((paramObject instanceof KeyPurposeId)) {
      return (KeyPurposeId)paramObject;
    }
    if (paramObject != null) {
      return new KeyPurposeId(ASN1ObjectIdentifier.getInstance(paramObject));
    }
    return null;
  }
  
  public String getId()
  {
    return this.id.getId();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.id;
  }
  
  public ASN1ObjectIdentifier toOID()
  {
    return this.id;
  }
  
  public String toString()
  {
    return this.id.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\KeyPurposeId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */