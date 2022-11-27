package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMetadata
{
  static final int MAX_ATTRIBUTES = 64;
  static final int MAX_ATTRIBUTE_SIZE = 1024;
  private final ConcurrentHashMap<String, String> attributes = new ConcurrentHashMap();
  private String userId = null;
  
  private static String sanitizeAttribute(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = paramString.trim();
      str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
    }
    return str;
  }
  
  public Map<String, String> getCustomKeys()
  {
    return Collections.unmodifiableMap(this.attributes);
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setCustomKey(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      String str = sanitizeAttribute(paramString1);
      if ((this.attributes.size() >= 64) && (!this.attributes.containsKey(str)))
      {
        Logger.getLogger().d("Exceeded maximum number of custom attributes (64)");
        return;
      }
      if (paramString2 == null) {
        paramString1 = "";
      } else {
        paramString1 = sanitizeAttribute(paramString2);
      }
      this.attributes.put(str, paramString1);
      return;
    }
    throw new IllegalArgumentException("Custom attribute key must not be null.");
  }
  
  public void setUserId(String paramString)
  {
    this.userId = sanitizeAttribute(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\UserMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */