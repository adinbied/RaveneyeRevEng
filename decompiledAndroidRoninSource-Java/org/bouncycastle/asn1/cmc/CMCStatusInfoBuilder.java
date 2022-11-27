package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfoBuilder
{
  private final ASN1Sequence bodyList;
  private final CMCStatus cMCStatus;
  private CMCStatusInfo.OtherInfo otherInfo;
  private DERUTF8String statusString;
  
  public CMCStatusInfoBuilder(CMCStatus paramCMCStatus, BodyPartID paramBodyPartID)
  {
    this.cMCStatus = paramCMCStatus;
    this.bodyList = new DERSequence(paramBodyPartID);
  }
  
  public CMCStatusInfoBuilder(CMCStatus paramCMCStatus, BodyPartID[] paramArrayOfBodyPartID)
  {
    this.cMCStatus = paramCMCStatus;
    this.bodyList = new DERSequence(paramArrayOfBodyPartID);
  }
  
  public CMCStatusInfo build()
  {
    return new CMCStatusInfo(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
  }
  
  public CMCStatusInfoBuilder setOtherInfo(CMCFailInfo paramCMCFailInfo)
  {
    this.otherInfo = new CMCStatusInfo.OtherInfo(paramCMCFailInfo);
    return this;
  }
  
  public CMCStatusInfoBuilder setOtherInfo(PendInfo paramPendInfo)
  {
    this.otherInfo = new CMCStatusInfo.OtherInfo(paramPendInfo);
    return this;
  }
  
  public CMCStatusInfoBuilder setStatusString(String paramString)
  {
    this.statusString = new DERUTF8String(paramString);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCStatusInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */