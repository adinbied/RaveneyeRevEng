package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.dvcs.Data;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;

public class VSDRequestData
  extends DVCSRequestData
{
  private CMSSignedData doc;
  
  VSDRequestData(Data paramData)
    throws DVCSConstructionException
  {
    super(paramData);
    initDocument();
  }
  
  private void initDocument()
    throws DVCSConstructionException
  {
    if (this.doc == null)
    {
      if (this.data.getMessage() != null) {
        try
        {
          this.doc = new CMSSignedData(this.data.getMessage().getOctets());
          return;
        }
        catch (CMSException localCMSException)
        {
          throw new DVCSConstructionException("Can't read CMS SignedData from input", localCMSException);
        }
      }
      throw new DVCSConstructionException("DVCSRequest.data.message should be specified for VSD service");
    }
  }
  
  public byte[] getMessage()
  {
    return this.data.getMessage().getOctets();
  }
  
  public CMSSignedData getParsedMessage()
  {
    return this.doc;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\VSDRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */