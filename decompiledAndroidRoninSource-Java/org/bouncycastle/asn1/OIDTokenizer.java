package org.bouncycastle.asn1;

public class OIDTokenizer
{
  private int index;
  private String oid;
  
  public OIDTokenizer(String paramString)
  {
    this.oid = paramString;
    this.index = 0;
  }
  
  public boolean hasMoreTokens()
  {
    return this.index != -1;
  }
  
  public String nextToken()
  {
    int i = this.index;
    if (i == -1) {
      return null;
    }
    i = this.oid.indexOf('.', i);
    if (i == -1)
    {
      str = this.oid.substring(this.index);
      this.index = -1;
      return str;
    }
    String str = this.oid.substring(this.index, i);
    this.index = (i + 1);
    return str;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\OIDTokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */