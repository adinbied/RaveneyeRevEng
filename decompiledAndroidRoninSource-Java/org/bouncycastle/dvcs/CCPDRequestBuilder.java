package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.asn1.dvcs.Data;
import org.bouncycastle.asn1.dvcs.ServiceType;

public class CCPDRequestBuilder
  extends DVCSRequestBuilder
{
  public CCPDRequestBuilder()
  {
    super(new DVCSRequestInformationBuilder(ServiceType.CCPD));
  }
  
  public DVCSRequest build(MessageImprint paramMessageImprint)
    throws DVCSException
  {
    return createDVCRequest(new Data(paramMessageImprint.toASN1Structure()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\CCPDRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */