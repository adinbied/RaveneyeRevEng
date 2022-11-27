package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class CacheKeyUtil
{
  public static String getFirstResourceId(CacheKey paramCacheKey)
  {
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey)) {
        return secureHashKey((CacheKey)((MultiCacheKey)paramCacheKey).getCacheKeys().get(0));
      }
      paramCacheKey = secureHashKey(paramCacheKey);
      return paramCacheKey;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
      throw new RuntimeException(paramCacheKey);
    }
  }
  
  public static List<String> getResourceIds(CacheKey paramCacheKey)
  {
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey))
      {
        List localList = ((MultiCacheKey)paramCacheKey).getCacheKeys();
        localArrayList = new ArrayList(localList.size());
        int i = 0;
        for (;;)
        {
          paramCacheKey = localArrayList;
          if (i >= localList.size()) {
            break;
          }
          localArrayList.add(secureHashKey((CacheKey)localList.get(i)));
          i += 1;
        }
      }
      ArrayList localArrayList = new ArrayList(1);
      if (paramCacheKey.isResourceIdForDebugging()) {
        paramCacheKey = paramCacheKey.getUriString();
      } else {
        paramCacheKey = secureHashKey(paramCacheKey);
      }
      localArrayList.add(paramCacheKey);
      paramCacheKey = localArrayList;
      return paramCacheKey;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
      throw new RuntimeException(paramCacheKey);
    }
  }
  
  private static String secureHashKey(CacheKey paramCacheKey)
    throws UnsupportedEncodingException
  {
    return SecureHashUtil.makeSHA1HashBase64(paramCacheKey.getUriString().getBytes("UTF-8"));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\CacheKeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */