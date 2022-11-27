package org.bouncycastle.dvcs;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.asn1.dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.asn1.dvcs.DVCSTime;
import org.bouncycastle.asn1.dvcs.Data;
import org.bouncycastle.asn1.dvcs.ServiceType;
import org.bouncycastle.cms.CMSSignedData;

public class VSDRequestBuilder
  extends DVCSRequestBuilder
{
  public VSDRequestBuilder()
  {
    super(new DVCSRequestInformationBuilder(ServiceType.VSD));
  }
  
  public DVCSRequest build(CMSSignedData paramCMSSignedData)
    throws DVCSException
  {
    try
    {
      paramCMSSignedData = createDVCRequest(new Data(paramCMSSignedData.getEncoded()));
      return paramCMSSignedData;
    }
    catch (IOException paramCMSSignedData)
    {
      throw new DVCSException("Failed to encode CMS signed data", paramCMSSignedData);
    }
  }
  
  public void setRequestTime(Date paramDate)
  {
    this.requestInformationBuilder.setRequestTime(new DVCSTime(paramDate));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\VSDRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */