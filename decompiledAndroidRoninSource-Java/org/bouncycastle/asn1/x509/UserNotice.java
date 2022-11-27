package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class UserNotice
  extends ASN1Object
{
  private final DisplayText explicitText;
  private final NoticeReference noticeRef;
  
  private UserNotice(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2) {
      this.noticeRef = NoticeReference.getInstance(paramASN1Sequence.getObjectAt(0));
    }
    for (paramASN1Sequence = paramASN1Sequence.getObjectAt(1);; paramASN1Sequence = paramASN1Sequence.getObjectAt(0))
    {
      this.explicitText = DisplayText.getInstance(paramASN1Sequence);
      return;
      if (paramASN1Sequence.size() != 1) {
        break;
      }
      if ((paramASN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence))
      {
        this.noticeRef = NoticeReference.getInstance(paramASN1Sequence.getObjectAt(0));
        break label104;
      }
      this.noticeRef = null;
    }
    if (paramASN1Sequence.size() == 0)
    {
      this.noticeRef = null;
      label104:
      this.explicitText = null;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public UserNotice(NoticeReference paramNoticeReference, String paramString)
  {
    this(paramNoticeReference, new DisplayText(paramString));
  }
  
  public UserNotice(NoticeReference paramNoticeReference, DisplayText paramDisplayText)
  {
    this.noticeRef = paramNoticeReference;
    this.explicitText = paramDisplayText;
  }
  
  public static UserNotice getInstance(Object paramObject)
  {
    if ((paramObject instanceof UserNotice)) {
      return (UserNotice)paramObject;
    }
    if (paramObject != null) {
      return new UserNotice(ASN1Sequence.getInstance(paramObject));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\UserNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */