package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class PKIFreeText
  extends ASN1Object
{
  ASN1Sequence strings;
  
  public PKIFreeText(String paramString)
  {
    this(new DERUTF8String(paramString));
  }
  
  private PKIFreeText(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    while (localEnumeration.hasMoreElements()) {
      if (!(localEnumeration.nextElement() instanceof DERUTF8String)) {
        throw new IllegalArgumentException("attempt to insert non UTF8 STRING into PKIFreeText");
      }
    }
    this.strings = paramASN1Sequence;
  }
  
  public PKIFreeText(DERUTF8String paramDERUTF8String)
  {
    this.strings = new DERSequence(paramDERUTF8String);
  }
  
  public PKIFreeText(String[] paramArrayOfString)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localASN1EncodableVector.add(new DERUTF8String(paramArrayOfString[i]));
      i += 1;
    }
    this.strings = new DERSequence(localASN1EncodableVector);
  }
  
  public PKIFreeText(DERUTF8String[] paramArrayOfDERUTF8String)
  {
    this.strings = new DERSequence(paramArrayOfDERUTF8String);
  }
  
  public static PKIFreeText getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIFreeText)) {
      return (PKIFreeText)paramObject;
    }
    if (paramObject != null) {
      return new PKIFreeText(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static PKIFreeText getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public DERUTF8String getStringAt(int paramInt)
  {
    return (DERUTF8String)this.strings.getObjectAt(paramInt);
  }
  
  public int size()
  {
    return this.strings.size();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.strings;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIFreeText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */