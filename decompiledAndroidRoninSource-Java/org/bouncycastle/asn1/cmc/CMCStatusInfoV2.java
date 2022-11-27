package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfoV2
  extends ASN1Object
{
  private final ASN1Sequence bodyList;
  private final CMCStatus cMCStatus;
  private final OtherStatusInfo otherStatusInfo;
  private final DERUTF8String statusString;
  
  private CMCStatusInfoV2(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 2) && (paramASN1Sequence.size() <= 4))
    {
      this.cMCStatus = CMCStatus.getInstance(paramASN1Sequence.getObjectAt(0));
      this.bodyList = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      if (paramASN1Sequence.size() > 2)
      {
        if (paramASN1Sequence.size() == 4) {
          this.statusString = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(2));
        }
        for (paramASN1Sequence = paramASN1Sequence.getObjectAt(3);; paramASN1Sequence = paramASN1Sequence.getObjectAt(2))
        {
          this.otherStatusInfo = OtherStatusInfo.getInstance(paramASN1Sequence);
          return;
          if ((paramASN1Sequence.getObjectAt(2) instanceof DERUTF8String))
          {
            this.statusString = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(2));
            break;
          }
          this.statusString = null;
        }
      }
      this.statusString = null;
      this.otherStatusInfo = null;
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  CMCStatusInfoV2(CMCStatus paramCMCStatus, ASN1Sequence paramASN1Sequence, DERUTF8String paramDERUTF8String, OtherStatusInfo paramOtherStatusInfo)
  {
    this.cMCStatus = paramCMCStatus;
    this.bodyList = paramASN1Sequence;
    this.statusString = paramDERUTF8String;
    this.otherStatusInfo = paramOtherStatusInfo;
  }
  
  public static CMCStatusInfoV2 getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMCStatusInfoV2)) {
      return (CMCStatusInfoV2)paramObject;
    }
    if (paramObject != null) {
      return new CMCStatusInfoV2(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartID[] getBodyList()
  {
    return Utils.toBodyPartIDArray(this.bodyList);
  }
  
  public OtherStatusInfo getOtherStatusInfo()
  {
    return this.otherStatusInfo;
  }
  
  public DERUTF8String getStatusString()
  {
    return this.statusString;
  }
  
  public CMCStatus getcMCStatus()
  {
    return this.cMCStatus;
  }
  
  public boolean hasOtherInfo()
  {
    return this.otherStatusInfo != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.cMCStatus);
    localASN1EncodableVector.add(this.bodyList);
    Object localObject = this.statusString;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.otherStatusInfo;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCStatusInfoV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */