package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public class BytesRange
{
  public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
  @Nullable
  private static Pattern sHeaderParsingRegEx;
  public final int from;
  public final int to;
  
  public BytesRange(int paramInt1, int paramInt2)
  {
    this.from = paramInt1;
    this.to = paramInt2;
  }
  
  public static BytesRange from(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return new BytesRange(paramInt, Integer.MAX_VALUE);
  }
  
  @Nullable
  public static BytesRange fromContentRangeHeader(@Nullable String paramString)
    throws IllegalArgumentException
  {
    if (paramString == null) {
      return null;
    }
    if (sHeaderParsingRegEx == null) {
      sHeaderParsingRegEx = Pattern.compile("[-/ ]");
    }
    for (;;)
    {
      try
      {
        Object localObject = sHeaderParsingRegEx.split(paramString);
        if (localObject.length == 4)
        {
          bool = true;
          Preconditions.checkArgument(bool);
          Preconditions.checkArgument(localObject[0].equals("bytes"));
          int i = Integer.parseInt(localObject[1]);
          int j = Integer.parseInt(localObject[2]);
          int k = Integer.parseInt(localObject[3]);
          if (j <= i) {
            break label182;
          }
          bool = true;
          Preconditions.checkArgument(bool);
          if (k <= j) {
            break label188;
          }
          bool = true;
          Preconditions.checkArgument(bool);
          if (j < k - 1) {
            return new BytesRange(i, j);
          }
          localObject = new BytesRange(i, Integer.MAX_VALUE);
          return (BytesRange)localObject;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new IllegalArgumentException(String.format((Locale)null, "Invalid Content-Range header value: \"%s\"", new Object[] { paramString }), localIllegalArgumentException);
      }
      boolean bool = false;
      continue;
      label182:
      bool = false;
      continue;
      label188:
      bool = false;
    }
  }
  
  public static BytesRange toMax(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return new BytesRange(0, paramInt);
  }
  
  private static String valueOrEmpty(int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return "";
    }
    return Integer.toString(paramInt);
  }
  
  public boolean contains(@Nullable BytesRange paramBytesRange)
  {
    boolean bool2 = false;
    if (paramBytesRange == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.from <= paramBytesRange.from)
    {
      bool1 = bool2;
      if (this.to >= paramBytesRange.to) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof BytesRange)) {
      return false;
    }
    paramObject = (BytesRange)paramObject;
    return (this.from == ((BytesRange)paramObject).from) && (this.to == ((BytesRange)paramObject).to);
  }
  
  public int hashCode()
  {
    return HashCodeUtil.hashCode(this.from, this.to);
  }
  
  public String toHttpRangeHeaderValue()
  {
    return String.format((Locale)null, "bytes=%s-%s", new Object[] { valueOrEmpty(this.from), valueOrEmpty(this.to) });
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%s-%s", new Object[] { valueOrEmpty(this.from), valueOrEmpty(this.to) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\BytesRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */