package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class PolicyQualifierId
  extends ASN1ObjectIdentifier
{
  private static final String id_qt = "1.3.6.1.5.5.7.2";
  public static final PolicyQualifierId id_qt_cps = new PolicyQualifierId("1.3.6.1.5.5.7.2.1");
  public static final PolicyQualifierId id_qt_unotice = new PolicyQualifierId("1.3.6.1.5.5.7.2.2");
  
  private PolicyQualifierId(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PolicyQualifierId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */