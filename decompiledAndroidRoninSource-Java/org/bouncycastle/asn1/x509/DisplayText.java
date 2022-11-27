package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVisibleString;

public class DisplayText
  extends ASN1Object
  implements ASN1Choice
{
  public static final int CONTENT_TYPE_BMPSTRING = 1;
  public static final int CONTENT_TYPE_IA5STRING = 0;
  public static final int CONTENT_TYPE_UTF8STRING = 2;
  public static final int CONTENT_TYPE_VISIBLESTRING = 3;
  public static final int DISPLAY_TEXT_MAXIMUM_SIZE = 200;
  int contentType;
  ASN1String contents;
  
  public DisplayText(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString.length() > 200) {
      str = paramString.substring(0, 200);
    }
    this.contentType = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            paramString = new DERUTF8String(str);
          } else {
            paramString = new DERVisibleString(str);
          }
        }
        else {
          paramString = new DERUTF8String(str);
        }
      }
      else {
        paramString = new DERBMPString(str);
      }
    }
    else {
      paramString = new DERIA5String(str);
    }
    this.contents = paramString;
  }
  
  public DisplayText(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 200) {
      str = paramString.substring(0, 200);
    }
    this.contentType = 2;
    this.contents = new DERUTF8String(str);
  }
  
  private DisplayText(ASN1String paramASN1String)
  {
    this.contents = paramASN1String;
    int i;
    if ((paramASN1String instanceof DERUTF8String)) {
      i = 2;
    }
    for (;;)
    {
      this.contentType = i;
      return;
      if ((paramASN1String instanceof DERBMPString))
      {
        i = 1;
      }
      else if ((paramASN1String instanceof DERIA5String))
      {
        i = 0;
      }
      else
      {
        if (!(paramASN1String instanceof DERVisibleString)) {
          break;
        }
        i = 3;
      }
    }
    throw new IllegalArgumentException("unknown STRING type in DisplayText");
  }
  
  public static DisplayText getInstance(Object paramObject)
  {
    if ((paramObject instanceof ASN1String)) {
      return new DisplayText((ASN1String)paramObject);
    }
    if ((paramObject != null) && (!(paramObject instanceof DisplayText)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DisplayText)paramObject;
  }
  
  public static DisplayText getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public String getString()
  {
    return this.contents.getString();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return (ASN1Primitive)this.contents;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\DisplayText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */