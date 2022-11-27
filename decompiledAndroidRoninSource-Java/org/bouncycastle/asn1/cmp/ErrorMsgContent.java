package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ErrorMsgContent
  extends ASN1Object
{
  private ASN1Integer errorCode;
  private PKIFreeText errorDetails;
  private PKIStatusInfo pkiStatusInfo;
  
  private ErrorMsgContent(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.pkiStatusInfo = PKIStatusInfo.getInstance(paramASN1Sequence.nextElement());
    while (paramASN1Sequence.hasMoreElements())
    {
      Object localObject = paramASN1Sequence.nextElement();
      if ((localObject instanceof ASN1Integer)) {
        this.errorCode = ASN1Integer.getInstance(localObject);
      } else {
        this.errorDetails = PKIFreeText.getInstance(localObject);
      }
    }
  }
  
  public ErrorMsgContent(PKIStatusInfo paramPKIStatusInfo)
  {
    this(paramPKIStatusInfo, null, null);
  }
  
  public ErrorMsgContent(PKIStatusInfo paramPKIStatusInfo, ASN1Integer paramASN1Integer, PKIFreeText paramPKIFreeText)
  {
    if (paramPKIStatusInfo != null)
    {
      this.pkiStatusInfo = paramPKIStatusInfo;
      this.errorCode = paramASN1Integer;
      this.errorDetails = paramPKIFreeText;
      return;
    }
    throw new IllegalArgumentException("'pkiStatusInfo' cannot be null");
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(paramASN1Encodable);
    }
  }
  
  public static ErrorMsgContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof ErrorMsgContent)) {
      return (ErrorMsgContent)paramObject;
    }
    if (paramObject != null) {
      return new ErrorMsgContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getErrorCode()
  {
    return this.errorCode;
  }
  
  public PKIFreeText getErrorDetails()
  {
    return this.errorDetails;
  }
  
  public PKIStatusInfo getPKIStatusInfo()
  {
    return this.pkiStatusInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pkiStatusInfo);
    addOptional(localASN1EncodableVector, this.errorCode);
    addOptional(localASN1EncodableVector, this.errorDetails);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\ErrorMsgContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */