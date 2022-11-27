package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

public class ContentIdentifier
  extends ASN1Object
{
  ASN1OctetString value;
  
  private ContentIdentifier(ASN1OctetString paramASN1OctetString)
  {
    this.value = paramASN1OctetString;
  }
  
  public ContentIdentifier(byte[] paramArrayOfByte)
  {
    this(new DEROctetString(paramArrayOfByte));
  }
  
  public static ContentIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof ContentIdentifier)) {
      return (ContentIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new ContentIdentifier(ASN1OctetString.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1OctetString getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\ContentIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */