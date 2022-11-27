package com.facebook.cache.common;

import android.net.Uri;

public abstract interface CacheKey
{
  public abstract boolean containsUri(Uri paramUri);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract String getUriString();
  
  public abstract int hashCode();
  
  public abstract boolean isResourceIdForDebugging();
  
  public abstract String toString();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\CacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */