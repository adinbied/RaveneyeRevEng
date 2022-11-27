package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.dvcs.Data;

public abstract class DVCSRequestData
{
  protected Data data;
  
  protected DVCSRequestData(Data paramData)
  {
    this.data = paramData;
  }
  
  public Data toASN1Structure()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */