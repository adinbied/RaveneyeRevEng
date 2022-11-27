package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfoV2Builder
{
  private final ASN1Sequence bodyList;
  private final CMCStatus cMCStatus;
  private OtherStatusInfo otherInfo;
  private DERUTF8String statusString;
  
  public CMCStatusInfoV2Builder(CMCStatus paramCMCStatus, BodyPartID paramBodyPartID)
  {
    this.cMCStatus = paramCMCStatus;
    this.bodyList = new DERSequence(paramBodyPartID);
  }
  
  public CMCStatusInfoV2Builder(CMCStatus paramCMCStatus, BodyPartID[] paramArrayOfBodyPartID)
  {
    this.cMCStatus = paramCMCStatus;
    this.bodyList = new DERSequence(paramArrayOfBodyPartID);
  }
  
  public CMCStatusInfoV2 build()
  {
    return new CMCStatusInfoV2(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
  }
  
  public CMCStatusInfoV2Builder setOtherInfo(CMCFailInfo paramCMCFailInfo)
  {
    this.otherInfo = new OtherStatusInfo(paramCMCFailInfo);
    return this;
  }
  
  public CMCStatusInfoV2Builder setOtherInfo(ExtendedFailInfo paramExtendedFailInfo)
  {
    this.otherInfo = new OtherStatusInfo(paramExtendedFailInfo);
    return this;
  }
  
  public CMCStatusInfoV2Builder setOtherInfo(PendInfo paramPendInfo)
  {
    this.otherInfo = new OtherStatusInfo(paramPendInfo);
    return this;
  }
  
  public CMCStatusInfoV2Builder setStatusString(String paramString)
  {
    this.statusString = new DERUTF8String(paramString);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCStatusInfoV2Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */