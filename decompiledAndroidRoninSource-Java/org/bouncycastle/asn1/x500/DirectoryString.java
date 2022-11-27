package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERUniversalString;

public class DirectoryString
  extends ASN1Object
  implements ASN1Choice, ASN1String
{
  private ASN1String string;
  
  public DirectoryString(String paramString)
  {
    this.string = new DERUTF8String(paramString);
  }
  
  private DirectoryString(DERBMPString paramDERBMPString)
  {
    this.string = paramDERBMPString;
  }
  
  private DirectoryString(DERPrintableString paramDERPrintableString)
  {
    this.string = paramDERPrintableString;
  }
  
  private DirectoryString(DERT61String paramDERT61String)
  {
    this.string = paramDERT61String;
  }
  
  private DirectoryString(DERUTF8String paramDERUTF8String)
  {
    this.string = paramDERUTF8String;
  }
  
  private DirectoryString(DERUniversalString paramDERUniversalString)
  {
    this.string = paramDERUniversalString;
  }
  
  public static DirectoryString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DirectoryString)))
    {
      if ((paramObject instanceof DERT61String)) {
        return new DirectoryString((DERT61String)paramObject);
      }
      if ((paramObject instanceof DERPrintableString)) {
        return new DirectoryString((DERPrintableString)paramObject);
      }
      if ((paramObject instanceof DERUniversalString)) {
        return new DirectoryString((DERUniversalString)paramObject);
      }
      if ((paramObject instanceof DERUTF8String)) {
        return new DirectoryString((DERUTF8String)paramObject);
      }
      if ((paramObject instanceof DERBMPString)) {
        return new DirectoryString((DERBMPString)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DirectoryString)paramObject;
  }
  
  public static DirectoryString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getInstance(paramASN1TaggedObject.getObject());
    }
    throw new IllegalArgumentException("choice item must be explicitly tagged");
  }
  
  public String getString()
  {
    return this.string.getString();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return ((ASN1Encodable)this.string).toASN1Primitive();
  }
  
  public String toString()
  {
    return this.string.getString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\DirectoryString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */