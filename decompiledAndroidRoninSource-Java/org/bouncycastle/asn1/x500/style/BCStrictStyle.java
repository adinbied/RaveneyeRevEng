package org.bouncycastle.asn1.x500.style;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

public class BCStrictStyle
  extends BCStyle
{
  public static final X500NameStyle INSTANCE = new BCStrictStyle();
  
  public boolean areEqual(X500Name paramX500Name1, X500Name paramX500Name2)
  {
    paramX500Name1 = paramX500Name1.getRDNs();
    paramX500Name2 = paramX500Name2.getRDNs();
    if (paramX500Name1.length != paramX500Name2.length) {
      return false;
    }
    int i = 0;
    while (i != paramX500Name1.length)
    {
      if (!rdnAreEqual(paramX500Name1[i], paramX500Name2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\style\BCStrictStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */