package org.bouncycastle.dvcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.asn1.dvcs.Data;

public class VPKCRequestData
  extends DVCSRequestData
{
  private List chains;
  
  VPKCRequestData(Data paramData)
    throws DVCSConstructionException
  {
    super(paramData);
    paramData = paramData.getCerts();
    if (paramData != null)
    {
      this.chains = new ArrayList(paramData.length);
      int i = 0;
      while (i != paramData.length)
      {
        this.chains.add(new TargetChain(paramData[i]));
        i += 1;
      }
      return;
    }
    throw new DVCSConstructionException("DVCSRequest.data.certs should be specified for VPKC service");
  }
  
  public List getCerts()
  {
    return Collections.unmodifiableList(this.chains);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\VPKCRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */