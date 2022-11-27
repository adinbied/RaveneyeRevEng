package org.bouncycastle.cert.ocsp;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.Extensions;

public class RespData
{
  private ResponseData data;
  
  public RespData(ResponseData paramResponseData)
  {
    this.data = paramResponseData;
  }
  
  public Date getProducedAt()
  {
    return OCSPUtils.extractDate(this.data.getProducedAt());
  }
  
  public RespID getResponderId()
  {
    return new RespID(this.data.getResponderID());
  }
  
  public Extensions getResponseExtensions()
  {
    return this.data.getResponseExtensions();
  }
  
  public SingleResp[] getResponses()
  {
    ASN1Sequence localASN1Sequence = this.data.getResponses();
    int j = localASN1Sequence.size();
    SingleResp[] arrayOfSingleResp = new SingleResp[j];
    int i = 0;
    while (i != j)
    {
      arrayOfSingleResp[i] = new SingleResp(SingleResponse.getInstance(localASN1Sequence.getObjectAt(i)));
      i += 1;
    }
    return arrayOfSingleResp;
  }
  
  public int getVersion()
  {
    return this.data.getVersion().getValue().intValue() + 1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\RespData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */