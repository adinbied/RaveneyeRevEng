package org.bouncycastle.cert.dane;

import org.bouncycastle.util.Selector;

public class DANEEntrySelector
  implements Selector
{
  private final String domainName;
  
  DANEEntrySelector(String paramString)
  {
    this.domainName = paramString;
  }
  
  public Object clone()
  {
    return this;
  }
  
  public String getDomainName()
  {
    return this.domainName;
  }
  
  public boolean match(Object paramObject)
  {
    return ((DANEEntry)paramObject).getDomainName().equals(this.domainName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntrySelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */