package org.bouncycastle.i18n.filter;

public class HTMLFilter
  implements Filter
{
  public String doFilter(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int j = 0;
    while (j < localStringBuffer.length())
    {
      int i = localStringBuffer.charAt(j);
      if (i != 34)
      {
        if (i != 35)
        {
          if (i != 43)
          {
            if (i != 45)
            {
              if (i != 62)
              {
                if (i != 59)
                {
                  if (i != 60)
                  {
                    switch (i)
                    {
                    default: 
                      j -= 3;
                      break;
                    case 41: 
                      i = j + 1;
                      paramString = "&#41";
                      break;
                    case 40: 
                      i = j + 1;
                      paramString = "&#40";
                      break;
                    case 39: 
                      i = j + 1;
                      paramString = "&#39";
                      break;
                    case 38: 
                      i = j + 1;
                      paramString = "&#38";
                      break;
                    case 37: 
                      i = j + 1;
                      paramString = "&#37";
                      break;
                    }
                  }
                  else
                  {
                    i = j + 1;
                    paramString = "&#60";
                  }
                }
                else
                {
                  i = j + 1;
                  paramString = "&#59";
                }
              }
              else
              {
                i = j + 1;
                paramString = "&#62";
              }
            }
            else
            {
              i = j + 1;
              paramString = "&#45";
            }
          }
          else
          {
            i = j + 1;
            paramString = "&#43";
          }
        }
        else
        {
          i = j + 1;
          paramString = "&#35";
        }
      }
      else
      {
        i = j + 1;
        paramString = "&#34";
      }
      localStringBuffer.replace(j, i, paramString);
      j += 4;
    }
    return localStringBuffer.toString();
  }
  
  public String doFilterUrl(String paramString)
  {
    return doFilter(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\filter\HTMLFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */