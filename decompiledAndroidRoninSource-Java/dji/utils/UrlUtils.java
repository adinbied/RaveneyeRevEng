package dji.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class UrlUtils
{
  public static UrlEntity parse(String paramString)
  {
    UrlEntity localUrlEntity = new UrlEntity();
    if (paramString == null) {
      return localUrlEntity;
    }
    paramString = paramString.trim();
    if (TextUtils.isEmpty(paramString)) {
      return localUrlEntity;
    }
    paramString = paramString.split("\\?");
    localUrlEntity.baseUrl = paramString[0];
    if (paramString.length == 1) {
      return localUrlEntity;
    }
    paramString = paramString[1].split("&");
    localUrlEntity.params = new HashMap();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      localUrlEntity.params.put(arrayOfString[0], arrayOfString[1]);
      i += 1;
    }
    return localUrlEntity;
  }
  
  public static class UrlEntity
  {
    public String baseUrl;
    public Map<String, String> params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\UrlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */