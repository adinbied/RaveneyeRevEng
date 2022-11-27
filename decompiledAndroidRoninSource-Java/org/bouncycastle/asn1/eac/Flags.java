package org.bouncycastle.asn1.eac;

import java.util.Enumeration;
import java.util.Hashtable;

public class Flags
{
  int value = 0;
  
  public Flags() {}
  
  public Flags(int paramInt)
  {
    this.value = paramInt;
  }
  
  String decode(Hashtable paramHashtable)
  {
    StringJoiner localStringJoiner = new StringJoiner(" ");
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Integer localInteger = (Integer)localEnumeration.nextElement();
      if (isSet(localInteger.intValue())) {
        localStringJoiner.add((String)paramHashtable.get(localInteger));
      }
    }
    return localStringJoiner.toString();
  }
  
  public int getFlags()
  {
    return this.value;
  }
  
  public boolean isSet(int paramInt)
  {
    return (paramInt & this.value) != 0;
  }
  
  public void set(int paramInt)
  {
    this.value = (paramInt | this.value);
  }
  
  private class StringJoiner
  {
    boolean First = true;
    StringBuffer b = new StringBuffer();
    String mSeparator;
    
    public StringJoiner(String paramString)
    {
      this.mSeparator = paramString;
    }
    
    public void add(String paramString)
    {
      if (this.First) {
        this.First = false;
      } else {
        this.b.append(this.mSeparator);
      }
      this.b.append(paramString);
    }
    
    public String toString()
    {
      return this.b.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\Flags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */