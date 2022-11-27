package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface CMSTypedData
  extends CMSProcessable
{
  public abstract ASN1ObjectIdentifier getContentType();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSTypedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */