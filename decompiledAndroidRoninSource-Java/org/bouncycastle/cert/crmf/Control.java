package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface Control
{
  public abstract ASN1ObjectIdentifier getType();
  
  public abstract ASN1Encodable getValue();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\Control.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */