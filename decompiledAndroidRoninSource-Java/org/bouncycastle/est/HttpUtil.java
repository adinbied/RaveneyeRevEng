package org.bouncycastle.est;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HttpUtil
{
  public static String[] append(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null) {
      return new String[] { paramString };
    }
    int i = paramArrayOfString.length;
    String[] arrayOfString = new String[i + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i);
    arrayOfString[i] = paramString;
    return arrayOfString;
  }
  
  static String mergeCSL(String paramString, Map<String, String> paramMap)
  {
    StringWriter localStringWriter = new StringWriter();
    localStringWriter.write(paramString);
    localStringWriter.write(32);
    paramString = paramMap.entrySet().iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      paramMap = (Map.Entry)paramString.next();
      if (i == 0) {
        i = 1;
      } else {
        localStringWriter.write(44);
      }
      localStringWriter.write((String)paramMap.getKey());
      localStringWriter.write("=\"");
      localStringWriter.write((String)paramMap.getValue());
      localStringWriter.write(34);
    }
    return localStringWriter.toString();
  }
  
  static Map<String, String> splitCSL(String paramString1, String paramString2)
  {
    String str = paramString2.trim();
    paramString2 = str;
    if (str.startsWith(paramString1)) {
      paramString2 = str.substring(paramString1.length());
    }
    return new PartLexer(paramString2).Parse();
  }
  
  static class Headers
    extends HashMap<String, String[]>
  {
    private String actualKey(String paramString)
    {
      if (containsKey(paramString)) {
        return paramString;
      }
      Iterator localIterator = keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (paramString.equalsIgnoreCase(str)) {
          return str;
        }
      }
      return null;
    }
    
    private String[] copy(String[] paramArrayOfString)
    {
      int i = paramArrayOfString.length;
      String[] arrayOfString = new String[i];
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i);
      return arrayOfString;
    }
    
    private boolean hasHeader(String paramString)
    {
      return actualKey(paramString) != null;
    }
    
    public void add(String paramString1, String paramString2)
    {
      put(paramString1, HttpUtil.append((String[])get(paramString1), paramString2));
    }
    
    public Object clone()
    {
      Headers localHeaders = new Headers();
      Iterator localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHeaders.put((String)localEntry.getKey(), copy((String[])localEntry.getValue()));
      }
      return localHeaders;
    }
    
    public void ensureHeader(String paramString1, String paramString2)
    {
      if (!containsKey(paramString1)) {
        set(paramString1, paramString2);
      }
    }
    
    public String getFirstValue(String paramString)
    {
      paramString = getValues(paramString);
      if ((paramString != null) && (paramString.length > 0)) {
        return paramString[0];
      }
      return null;
    }
    
    public String[] getValues(String paramString)
    {
      paramString = actualKey(paramString);
      if (paramString == null) {
        return null;
      }
      return (String[])get(paramString);
    }
    
    public void set(String paramString1, String paramString2)
    {
      put(paramString1, new String[] { paramString2 });
    }
  }
  
  static class PartLexer
  {
    int last = 0;
    int p = 0;
    private final String src;
    
    PartLexer(String paramString)
    {
      this.src = paramString;
    }
    
    private String consumeAlpha()
    {
      for (int i = this.src.charAt(this.p); (this.p < this.src.length()) && (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90))); i = this.src.charAt(i))
      {
        i = this.p + 1;
        this.p = i;
      }
      String str = this.src.substring(this.last, this.p);
      this.last = this.p;
      return str;
    }
    
    private boolean consumeIf(char paramChar)
    {
      if ((this.p < this.src.length()) && (this.src.charAt(this.p) == paramChar))
      {
        this.p += 1;
        return true;
      }
      return false;
    }
    
    private String consumeUntil(char paramChar)
    {
      while ((this.p < this.src.length()) && (this.src.charAt(this.p) != paramChar)) {
        this.p += 1;
      }
      String str = this.src.substring(this.last, this.p);
      this.last = this.p;
      return str;
    }
    
    private void discard()
    {
      this.last = this.p;
    }
    
    private void discard(int paramInt)
    {
      paramInt = this.p + paramInt;
      this.p = paramInt;
      this.last = paramInt;
    }
    
    private void skipWhiteSpace()
    {
      while ((this.p < this.src.length()) && (this.src.charAt(this.p) < '!')) {
        this.p += 1;
      }
      this.last = this.p;
    }
    
    Map<String, String> Parse()
    {
      HashMap localHashMap = new HashMap();
      while (this.p < this.src.length())
      {
        skipWhiteSpace();
        String str1 = consumeAlpha();
        if (str1.length() != 0)
        {
          skipWhiteSpace();
          if (consumeIf('='))
          {
            skipWhiteSpace();
            if (consumeIf('"'))
            {
              discard();
              String str2 = consumeUntil('"');
              discard(1);
              localHashMap.put(str1, str2);
              skipWhiteSpace();
              if (!consumeIf(',')) {
                return localHashMap;
              }
              discard();
            }
            else
            {
              throw new IllegalArgumentException("Expecting start quote: '\"'");
            }
          }
          else
          {
            throw new IllegalArgumentException("Expecting assign: '='");
          }
        }
        else
        {
          throw new IllegalArgumentException("Expecting alpha label.");
        }
      }
      return localHashMap;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */