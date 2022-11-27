package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;

public final class CacheControl
{
  public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
  public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
  String headerValue;
  private final boolean isPrivate;
  private final boolean isPublic;
  private final int maxAgeSeconds;
  private final int maxStaleSeconds;
  private final int minFreshSeconds;
  private final boolean mustRevalidate;
  private final boolean noCache;
  private final boolean noStore;
  private final boolean noTransform;
  private final boolean onlyIfCached;
  private final int sMaxAgeSeconds;
  
  private CacheControl(Builder paramBuilder)
  {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString)
  {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.headerValue = paramString;
  }
  
  private String headerValue()
  {
    return null;
  }
  
  public static CacheControl parse(Headers paramHeaders)
  {
    int i8 = paramHeaders.size();
    int i2 = 0;
    int j = 1;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    int i1 = -1;
    int n = -1;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    int m = -1;
    int k = -1;
    boolean bool1 = false;
    boolean bool14;
    for (boolean bool2 = false;; bool2 = bool14)
    {
      Object localObject2 = paramHeaders;
      if (i2 >= i8) {
        break;
      }
      String str2 = ((Headers)localObject2).name(i2);
      String str1 = ((Headers)localObject2).value(i2);
      int i7;
      boolean bool8;
      boolean bool9;
      int i;
      int i3;
      boolean bool10;
      boolean bool11;
      boolean bool12;
      int i4;
      int i5;
      boolean bool13;
      if (str2.equalsIgnoreCase("Cache-Control"))
      {
        if (localObject1 == null)
        {
          localObject1 = str1;
          break label160;
        }
      }
      else
      {
        i7 = j;
        localObject2 = localObject1;
        bool8 = bool7;
        bool9 = bool6;
        i = i1;
        i3 = n;
        bool10 = bool5;
        bool11 = bool4;
        bool12 = bool3;
        i4 = m;
        i5 = k;
        bool13 = bool1;
        bool14 = bool2;
        if (!str2.equalsIgnoreCase("Pragma")) {
          break label1045;
        }
      }
      j = 0;
      label160:
      int i6 = 0;
      for (;;)
      {
        i7 = j;
        localObject2 = localObject1;
        bool8 = bool7;
        bool9 = bool6;
        i = i1;
        i3 = n;
        bool10 = bool5;
        bool11 = bool4;
        bool12 = bool3;
        i4 = m;
        i5 = k;
        bool13 = bool1;
        bool14 = bool2;
        if (i6 >= str1.length()) {
          break;
        }
        i = HeaderParser.skipUntil(str1, i6, "=,;");
        str2 = str1.substring(i6, i).trim();
        if ((i != str1.length()) && (str1.charAt(i) != ',') && (str1.charAt(i) != ';'))
        {
          i3 = HeaderParser.skipWhitespace(str1, i + 1);
          if ((i3 < str1.length()) && (str1.charAt(i3) == '"'))
          {
            i = i3 + 1;
            i3 = HeaderParser.skipUntil(str1, i, "\"");
            localObject2 = str1.substring(i, i3);
            i = i3 + 1;
          }
          else
          {
            i = HeaderParser.skipUntil(str1, i3, ",;");
            localObject2 = str1.substring(i3, i).trim();
          }
        }
        else
        {
          i += 1;
          localObject2 = null;
        }
        if ("no-cache".equalsIgnoreCase(str2))
        {
          bool8 = true;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("no-store".equalsIgnoreCase(str2))
        {
          bool9 = true;
          bool8 = bool7;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i3 = HeaderParser.parseSeconds((String)localObject2, -1);
          bool8 = bool7;
          bool9 = bool6;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i4 = HeaderParser.parseSeconds((String)localObject2, -1);
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool10 = true;
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool11 = true;
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool12 = true;
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          i5 = m;
          i7 = k;
          bool13 = bool1;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i5 = HeaderParser.parseSeconds((String)localObject2, Integer.MAX_VALUE);
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i7 = k;
          bool13 = bool1;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i7 = HeaderParser.parseSeconds((String)localObject2, -1);
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          bool13 = bool1;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool13 = true;
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
        }
        else
        {
          bool8 = bool7;
          bool9 = bool6;
          i3 = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i7 = k;
          bool13 = bool1;
          if ("no-transform".equalsIgnoreCase(str2))
          {
            bool2 = true;
            bool13 = bool1;
            i7 = k;
            i5 = m;
            bool12 = bool3;
            bool11 = bool4;
            bool10 = bool5;
            i4 = n;
            i3 = i1;
            bool9 = bool6;
            bool8 = bool7;
          }
        }
        i6 = i;
        bool7 = bool8;
        bool6 = bool9;
        i1 = i3;
        n = i4;
        bool5 = bool10;
        bool4 = bool11;
        bool3 = bool12;
        m = i5;
        k = i7;
        bool1 = bool13;
      }
      label1045:
      i2 += 1;
      j = i7;
      localObject1 = localObject2;
      bool7 = bool8;
      bool6 = bool9;
      i1 = i;
      n = i3;
      bool5 = bool10;
      bool4 = bool11;
      bool3 = bool12;
      m = i4;
      k = i5;
      bool1 = bool13;
    }
    if (j == 0) {
      localObject1 = null;
    }
    return new CacheControl(bool7, bool6, i1, n, bool5, bool4, bool3, m, k, bool1, bool2, (String)localObject1);
  }
  
  public boolean isPrivate()
  {
    return this.isPrivate;
  }
  
  public boolean isPublic()
  {
    return this.isPublic;
  }
  
  public int maxAgeSeconds()
  {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds()
  {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds()
  {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate()
  {
    return this.mustRevalidate;
  }
  
  public boolean noCache()
  {
    return this.noCache;
  }
  
  public boolean noStore()
  {
    return this.noStore;
  }
  
  public boolean noTransform()
  {
    return this.noTransform;
  }
  
  public boolean onlyIfCached()
  {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds()
  {
    return this.sMaxAgeSeconds;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static final class Builder
  {
    int maxAgeSeconds = -1;
    int maxStaleSeconds = -1;
    int minFreshSeconds = -1;
    boolean noCache;
    boolean noStore;
    boolean noTransform;
    boolean onlyIfCached;
    
    public CacheControl build()
    {
      return new CacheControl(this, null);
    }
    
    public Builder maxAge(int paramInt, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public Builder maxStale(int paramInt, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public Builder minFresh(int paramInt, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public Builder noCache()
    {
      this.noCache = true;
      return this;
    }
    
    public Builder noStore()
    {
      this.noStore = true;
      return this;
    }
    
    public Builder noTransform()
    {
      this.noTransform = true;
      return this;
    }
    
    public Builder onlyIfCached()
    {
      this.onlyIfCached = true;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\CacheControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */