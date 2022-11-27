package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.dvcs.Data;

public class CPDRequestData
  extends DVCSRequestData
{
  CPDRequestData(Data paramData)
    throws DVCSConstructionException
  {
    super(paramData);
    initMessage();
  }
  
  private void initMessage()
    throws DVCSConstructionException
  {
    if (this.data.getMessage() != null) {
      return;
    }
    throw new DVCSConstructionException("DVCSRequest.data.message should be specified for CPD service");
  }
  
  public byte[] getMessage()
  {
    return this.data.getMessage().getOctets();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\CPDRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */