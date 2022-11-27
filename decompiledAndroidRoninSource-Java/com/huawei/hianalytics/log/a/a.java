package com.huawei.hianalytics.log.a;

import android.text.TextUtils;
import java.text.MessageFormat;

public final class a
{
  private static String a(String paramString)
  {
    String str;
    if (!paramString.startsWith("https"))
    {
      str = paramString;
      if (!paramString.startsWith("http")) {}
    }
    else
    {
      paramString = paramString.substring(paramString.indexOf("//") + 2);
      str = paramString.substring(paramString.indexOf("/"));
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer(512);
    paramString1 = a(paramString1);
    String str;
    if (paramString1.contains("?"))
    {
      str = paramString1.substring(0, paramString1.indexOf('?'));
      if (paramString1.substring(paramString1.indexOf("?")).length() > 1) {
        paramString1 = new b(paramString1.substring(paramString1.indexOf("?") + 1));
      } else {
        paramString1 = new b(null);
      }
    }
    else
    {
      localObject = new b(null);
      str = paramString1;
      paramString1 = (String)localObject;
    }
    localStringBuffer.append("POST");
    localStringBuffer.append("&");
    Object localObject = paramString1.a("appID");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      com.huawei.hianalytics.g.b.d("AuthoHeadUtil", "appid is empty！");
      return null;
    }
    localStringBuffer.append(str.substring(str.indexOf("/")));
    localStringBuffer.append("&");
    localStringBuffer.append(paramString1.a());
    localStringBuffer.append("&");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("&appID=");
    localStringBuffer.append((String)localObject);
    return MessageFormat.format("HMAC-SHA256 appID={0}, signature=\"{1}\"", new Object[] { localObject, c.a(localStringBuffer.toString(), paramString3) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */