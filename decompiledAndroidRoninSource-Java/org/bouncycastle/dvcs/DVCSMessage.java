package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.ContentInfo;

public abstract class DVCSMessage
{
  private final ContentInfo contentInfo;
  
  protected DVCSMessage(ContentInfo paramContentInfo)
  {
    this.contentInfo = paramContentInfo;
  }
  
  public abstract ASN1Encodable getContent();
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentInfo.getContentType();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */