package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;

public class DebuggingCacheKey
  extends SimpleCacheKey
{
  @Nullable
  private final Object mCallerContext;
  private final Uri mSourceUri;
  
  public DebuggingCacheKey(String paramString, @Nullable Object paramObject, Uri paramUri)
  {
    super(paramString);
    this.mCallerContext = paramObject;
    this.mSourceUri = paramUri;
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\DebuggingCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */