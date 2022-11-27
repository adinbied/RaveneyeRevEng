package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class NoticeReference
  extends ASN1Object
{
  private ASN1Sequence noticeNumbers;
  private DisplayText organization;
  
  public NoticeReference(String paramString, Vector paramVector)
  {
    this(paramString, convertVector(paramVector));
  }
  
  public NoticeReference(String paramString, ASN1EncodableVector paramASN1EncodableVector)
  {
    this(new DisplayText(paramString), paramASN1EncodableVector);
  }
  
  private NoticeReference(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.organization = DisplayText.getInstance(paramASN1Sequence.getObjectAt(0));
      this.noticeNumbers = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public NoticeReference(DisplayText paramDisplayText, ASN1EncodableVector paramASN1EncodableVector)
  {
    this.organization = paramDisplayText;
    this.noticeNumbers = new DERSequence(paramASN1EncodableVector);
  }
  
  private static ASN1EncodableVector convertVector(Vector paramVector)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Enumeration localEnumeration = paramVector.elements();
    while (localEnumeration.hasMoreElements())
    {
      paramVector = localEnumeration.nextElement();
      if ((paramVector instanceof BigInteger))
      {
        paramVector = new ASN1Integer((BigInteger)paramVector);
      }
      else
      {
        if (!(paramVector instanceof Integer)) {
          break label82;
        }
        paramVector = new ASN1Integer(((Integer)paramVector).intValue());
      }
      localASN1EncodableVector.add(paramVector);
      continue;
      label82:
      throw new IllegalArgumentException();
    }
    return localASN1EncodableVector;
  }
  
  public static NoticeReference getInstance(Object paramObject)
  {
    if ((paramObject instanceof NoticeReference)) {
      return (NoticeReference)paramObject;
    }
    if (paramObject != null) {
      return new NoticeReference(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer[] getNoticeNumbers()
  {
    ASN1Integer[] arrayOfASN1Integer = new ASN1Integer[this.noticeNumbers.size()];
    int i = 0;
    while (i != this.noticeNumbers.size())
    {
      arrayOfASN1Integer[i] = ASN1Integer.getInstance(this.noticeNumbers.getObjectAt(i));
      i += 1;
    }
    return arrayOfASN1Integer;
  }
  
  public DisplayText getOrganization()
  {
    return this.organization;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.organization);
    localASN1EncodableVector.add(this.noticeNumbers);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\NoticeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */