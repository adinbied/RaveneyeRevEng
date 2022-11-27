package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.DisplayText;
import org.bouncycastle.asn1.x509.NoticeReference;

public class SPUserNotice
  extends ASN1Object
{
  private DisplayText explicitText;
  private NoticeReference noticeRef;
  
  private SPUserNotice(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = (ASN1Encodable)((Enumeration)localObject).nextElement();
      if ((!(paramASN1Sequence instanceof DisplayText)) && (!(paramASN1Sequence instanceof ASN1String)))
      {
        if ((!(paramASN1Sequence instanceof NoticeReference)) && (!(paramASN1Sequence instanceof ASN1Sequence)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid element in 'SPUserNotice': ");
          ((StringBuilder)localObject).append(paramASN1Sequence.getClass().getName());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        this.noticeRef = NoticeReference.getInstance(paramASN1Sequence);
      }
      else
      {
        this.explicitText = DisplayText.getInstance(paramASN1Sequence);
      }
    }
  }
  
  public SPUserNotice(NoticeReference paramNoticeReference, DisplayText paramDisplayText)
  {
    this.noticeRef = paramNoticeReference;
    this.explicitText = paramDisplayText;
  }
  
  public static SPUserNotice getInstance(Object paramObject)
  {
    if ((paramObject instanceof SPUserNotice)) {
      return (SPUserNotice)paramObject;
    }
    if (paramObject != null) {
      return new SPUserNotice(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DisplayText getExplicitText()
  {
    return this.explicitText;
  }
  
  public NoticeReference getNoticeRef()
  {
    return this.noticeRef;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.noticeRef;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.explicitText;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SPUserNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */