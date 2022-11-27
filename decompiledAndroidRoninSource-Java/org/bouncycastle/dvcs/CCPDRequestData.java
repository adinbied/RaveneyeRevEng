package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.dvcs.Data;

public class CCPDRequestData
  extends DVCSRequestData
{
  CCPDRequestData(Data paramData)
    throws DVCSConstructionException
  {
    super(paramData);
    initDigest();
  }
  
  private void initDigest()
    throws DVCSConstructionException
  {
    if (this.data.getMessageImprint() != null) {
      return;
    }
    throw new DVCSConstructionException("DVCSRequest.data.messageImprint should be specified for CCPD service");
  }
  
  public MessageImprint getMessageImprint()
  {
    return new MessageImprint(this.data.getMessageImprint());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\CCPDRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */