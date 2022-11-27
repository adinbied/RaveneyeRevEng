package org.bouncycastle.asn1.x509;

public class X509NameTokenizer
{
  private StringBuffer buf = new StringBuffer();
  private int index;
  private char separator;
  private String value;
  
  public X509NameTokenizer(String paramString)
  {
    this(paramString, ',');
  }
  
  public X509NameTokenizer(String paramString, char paramChar)
  {
    this.value = paramString;
    this.index = -1;
    this.separator = paramChar;
  }
  
  public boolean hasMoreTokens()
  {
    return this.index != this.value.length();
  }
  
  public String nextToken()
  {
    if (this.index == this.value.length()) {
      return null;
    }
    int k = this.index + 1;
    this.buf.setLength(0);
    int m = 0;
    int i = 0;
    while (k != this.value.length())
    {
      char c = this.value.charAt(k);
      if (c == '"')
      {
        j = i;
        if (m == 0) {
          j = i ^ 0x1;
        }
      }
      else
      {
        j = i;
        if (m == 0) {
          if (i != 0)
          {
            j = i;
          }
          else
          {
            if (c == '\\')
            {
              this.buf.append(c);
              j = 1;
              break label158;
            }
            if (c == this.separator) {
              break;
            }
            this.buf.append(c);
            j = m;
            break label158;
          }
        }
      }
      this.buf.append(c);
      m = 0;
      i = j;
      int j = m;
      label158:
      k += 1;
      m = j;
    }
    this.index = k;
    return this.buf.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509NameTokenizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */