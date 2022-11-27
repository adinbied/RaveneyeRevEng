package org.bouncycastle.asn1.microsoft;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface MicrosoftObjectIdentifiers
{
  public static final ASN1ObjectIdentifier microsoft;
  public static final ASN1ObjectIdentifier microsoftAppPolicies = microsoft.branch("21.10");
  public static final ASN1ObjectIdentifier microsoftCaVersion;
  public static final ASN1ObjectIdentifier microsoftCertTemplateV1;
  public static final ASN1ObjectIdentifier microsoftCertTemplateV2;
  public static final ASN1ObjectIdentifier microsoftCrlNextPublish;
  public static final ASN1ObjectIdentifier microsoftPrevCaCertHash;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.311");
    microsoft = localASN1ObjectIdentifier;
    microsoftCertTemplateV1 = localASN1ObjectIdentifier.branch("20.2");
    microsoftCaVersion = microsoft.branch("21.1");
    microsoftPrevCaCertHash = microsoft.branch("21.2");
    microsoftCrlNextPublish = microsoft.branch("21.4");
    microsoftCertTemplateV2 = microsoft.branch("21.7");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\microsoft\MicrosoftObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */