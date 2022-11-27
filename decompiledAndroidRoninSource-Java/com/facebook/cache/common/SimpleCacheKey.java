package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;

public class SimpleCacheKey
  implements CacheKey
{
  final boolean mIsResourceIdForDebugging;
  final String mKey;
  
  public SimpleCacheKey(String paramString)
  {
    this(paramString, false);
  }
  
  public SimpleCacheKey(String paramString, boolean paramBoolean)
  {
    this.mKey = ((String)Preconditions.checkNotNull(paramString));
    this.mIsResourceIdForDebugging = paramBoolean;
  }
  
  public boolean containsUri(Uri paramUri)
  {
    return this.mKey.contains(paramUri.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SimpleCacheKey))
    {
      paramObject = (SimpleCacheKey)paramObject;
      return this.mKey.equals(((SimpleCacheKey)paramObject).mKey);
    }
    return false;
  }
  
  public String getUriString()
  {
    return this.mKey;
  }
  
  public int hashCode()
  {
    return this.mKey.hashCode();
  }
  
  public boolean isResourceIdForDebugging()
  {
    return this.mIsResourceIdForDebugging;
  }
  
  public String toString()
  {
    return this.mKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\SimpleCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */