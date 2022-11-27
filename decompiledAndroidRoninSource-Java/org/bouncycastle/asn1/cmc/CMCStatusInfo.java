package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfo
  extends ASN1Object
{
  private final ASN1Sequence bodyList;
  private final CMCStatus cMCStatus;
  private final OtherInfo otherInfo;
  private final DERUTF8String statusString;
  
  private CMCStatusInfo(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 2) && (paramASN1Sequence.size() <= 4))
    {
      this.cMCStatus = CMCStatus.getInstance(paramASN1Sequence.getObjectAt(0));
      this.bodyList = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      if (paramASN1Sequence.size() > 3) {
        this.statusString = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(2));
      }
      for (paramASN1Sequence = paramASN1Sequence.getObjectAt(3);; paramASN1Sequence = paramASN1Sequence.getObjectAt(2))
      {
        this.otherInfo = OtherInfo.getInstance(paramASN1Sequence);
        return;
        if (paramASN1Sequence.size() <= 2) {
          break;
        }
        if ((paramASN1Sequence.getObjectAt(2) instanceof DERUTF8String))
        {
          this.statusString = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(2));
          break label132;
        }
        this.statusString = null;
      }
      this.statusString = null;
      label132:
      this.otherInfo = null;
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  CMCStatusInfo(CMCStatus paramCMCStatus, ASN1Sequence paramASN1Sequence, DERUTF8String paramDERUTF8String, OtherInfo paramOtherInfo)
  {
    this.cMCStatus = paramCMCStatus;
    this.bodyList = paramASN1Sequence;
    this.statusString = paramDERUTF8String;
    this.otherInfo = paramOtherInfo;
  }
  
  public static CMCStatusInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMCStatusInfo)) {
      return (CMCStatusInfo)paramObject;
    }
    if (paramObject != null) {
      return new CMCStatusInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartID[] getBodyList()
  {
    return Utils.toBodyPartIDArray(this.bodyList);
  }
  
  public CMCStatus getCMCStatus()
  {
    return this.cMCStatus;
  }
  
  public OtherInfo getOtherInfo()
  {
    return this.otherInfo;
  }
  
  public DERUTF8String getStatusString()
  {
    return this.statusString;
  }
  
  public boolean hasOtherInfo()
  {
    return this.otherInfo != null;
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
    localObject = this.otherInfo;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public static class OtherInfo
    extends ASN1Object
    implements ASN1Choice
  {
    private final CMCFailInfo failInfo;
    private final PendInfo pendInfo;
    
    OtherInfo(CMCFailInfo paramCMCFailInfo)
    {
      this(paramCMCFailInfo, null);
    }
    
    private OtherInfo(CMCFailInfo paramCMCFailInfo, PendInfo paramPendInfo)
    {
      this.failInfo = paramCMCFailInfo;
      this.pendInfo = paramPendInfo;
    }
    
    OtherInfo(PendInfo paramPendInfo)
    {
      this(null, paramPendInfo);
    }
    
    private static OtherInfo getInstance(Object paramObject)
    {
      if ((paramObject instanceof OtherInfo)) {
        return (OtherInfo)paramObject;
      }
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
        if ((localObject instanceof ASN1Integer)) {
          return new OtherInfo(CMCFailInfo.getInstance(localObject));
        }
        if ((localObject instanceof ASN1Sequence)) {
          return new OtherInfo(PendInfo.getInstance(localObject));
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance(): ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public boolean isFailInfo()
    {
      return this.failInfo != null;
    }
    
    public ASN1Primitive toASN1Primitive()
    {
      PendInfo localPendInfo = this.pendInfo;
      if (localPendInfo != null) {
        return localPendInfo.toASN1Primitive();
      }
      return this.failInfo.toASN1Primitive();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */