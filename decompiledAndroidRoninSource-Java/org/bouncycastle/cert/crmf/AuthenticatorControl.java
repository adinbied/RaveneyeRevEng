package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;

public class AuthenticatorControl
  implements Control
{
  private static final ASN1ObjectIdentifier type = CRMFObjectIdentifiers.id_regCtrl_authenticator;
  private final DERUTF8String token;
  
  public AuthenticatorControl(String paramString)
  {
    this.token = new DERUTF8String(paramString);
  }
  
  public AuthenticatorControl(DERUTF8String paramDERUTF8String)
  {
    this.token = paramDERUTF8String;
  }
  
  public ASN1ObjectIdentifier getType()
  {
    return type;
  }
  
  public ASN1Encodable getValue()
  {
    return this.token;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\AuthenticatorControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */