package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.asn1.dvcs.Data;
import org.bouncycastle.asn1.dvcs.ServiceType;

public class CPDRequestBuilder
  extends DVCSRequestBuilder
{
  public CPDRequestBuilder()
  {
    super(new DVCSRequestInformationBuilder(ServiceType.CPD));
  }
  
  public DVCSRequest build(byte[] paramArrayOfByte)
    throws DVCSException
  {
    return createDVCRequest(new Data(paramArrayOfByte));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\CPDRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */