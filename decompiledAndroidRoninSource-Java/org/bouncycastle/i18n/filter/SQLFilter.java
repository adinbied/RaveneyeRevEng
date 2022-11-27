package org.bouncycastle.i18n.filter;

public class SQLFilter
  implements Filter
{
  public String doFilter(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int i;
    for (int j = 0; j < localStringBuffer.length(); j = i + 1)
    {
      i = localStringBuffer.charAt(j);
      if (i != 10)
      {
        if (i != 13)
        {
          if (i != 34)
          {
            if (i != 39)
            {
              if (i != 45)
              {
                if (i != 47)
                {
                  if (i != 59)
                  {
                    if (i != 61)
                    {
                      if (i != 92)
                      {
                        i = j;
                        continue;
                      }
                      i = j + 1;
                      paramString = "\\\\";
                    }
                    else
                    {
                      i = j + 1;
                      paramString = "\\=";
                    }
                  }
                  else
                  {
                    i = j + 1;
                    paramString = "\\;";
                  }
                }
                else
                {
                  i = j + 1;
                  paramString = "\\/";
                }
              }
              else
              {
                i = j + 1;
                paramString = "\\-";
              }
            }
            else
            {
              i = j + 1;
              paramString = "\\'";
            }
          }
          else
          {
            i = j + 1;
            paramString = "\\\"";
          }
        }
        else
        {
          i = j + 1;
          paramString = "\\r";
        }
      }
      else
      {
        i = j + 1;
        paramString = "\\n";
      }
      localStringBuffer.replace(j, i, paramString);
    }
    return localStringBuffer.toString();
  }
  
  public String doFilterUrl(String paramString)
  {
    return doFilter(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\filter\SQLFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */