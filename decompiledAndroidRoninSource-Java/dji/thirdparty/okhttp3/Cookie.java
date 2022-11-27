package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Cookie
{
  private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern MONTH_PATTERN;
  private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
  private final String domain;
  private final long expiresAt;
  private final boolean hostOnly;
  private final boolean httpOnly;
  private final String name;
  private final String path;
  private final boolean persistent;
  private final boolean secure;
  private final String value;
  
  static
  {
    MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  }
  
  private Cookie(Builder paramBuilder)
  {
    if (paramBuilder.name != null)
    {
      if (paramBuilder.value != null)
      {
        if (paramBuilder.domain != null)
        {
          this.name = paramBuilder.name;
          this.value = paramBuilder.value;
          this.expiresAt = paramBuilder.expiresAt;
          this.domain = paramBuilder.domain;
          this.path = paramBuilder.path;
          this.secure = paramBuilder.secure;
          this.httpOnly = paramBuilder.httpOnly;
          this.persistent = paramBuilder.persistent;
          this.hostOnly = paramBuilder.hostOnly;
          return;
        }
        throw new IllegalArgumentException("builder.domain == null");
      }
      throw new IllegalArgumentException("builder.value == null");
    }
    throw new IllegalArgumentException("builder.name == null");
  }
  
  private Cookie(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.expiresAt = paramLong;
    this.domain = paramString3;
    this.path = paramString4;
    this.secure = paramBoolean1;
    this.httpOnly = paramBoolean2;
    this.hostOnly = paramBoolean3;
    this.persistent = paramBoolean4;
  }
  
  private static int dateCharacterOffset(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if (((i >= 32) || (i == 9)) && (i < 127) && ((i < 48) || (i > 57)) && ((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && (i != 58)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == (paramBoolean ^ true)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  private static boolean domainMatch(HttpUrl paramHttpUrl, String paramString)
  {
    paramHttpUrl = paramHttpUrl.host();
    if (paramHttpUrl.equals(paramString)) {
      return true;
    }
    return (paramHttpUrl.endsWith(paramString)) && (paramHttpUrl.charAt(paramHttpUrl.length() - paramString.length() - 1) == '.') && (!Util.verifyAsIpAddress(paramHttpUrl));
  }
  
  static Cookie parse(long paramLong, HttpUrl paramHttpUrl, String paramString)
  {
    int j = paramString.length();
    int i = Util.delimiterOffset(paramString, 0, j, ';');
    int k = Util.delimiterOffset(paramString, 0, i, '=');
    if (k == i) {
      return null;
    }
    String str1 = Util.trimSubstring(paramString, 0, k);
    if (str1.isEmpty()) {
      return null;
    }
    String str2 = Util.trimSubstring(paramString, k + 1, i);
    i += 1;
    localObject2 = null;
    localObject1 = localObject2;
    l2 = -1L;
    l1 = 253402300799999L;
    bool3 = false;
    boolean bool4 = false;
    bool2 = true;
    bool1 = false;
    while (i < j)
    {
      k = Util.delimiterOffset(paramString, i, j, ';');
      int m = Util.delimiterOffset(paramString, i, k, '=');
      String str3 = Util.trimSubstring(paramString, i, m);
      Object localObject3;
      if (m < k) {
        localObject3 = Util.trimSubstring(paramString, m + 1, k);
      } else {
        localObject3 = "";
      }
      if (str3.equalsIgnoreCase("expires")) {}
      try
      {
        l3 = parseExpires((String)localObject3, 0, ((String)localObject3).length());
        l1 = l3;
        if (str3.equalsIgnoreCase("max-age"))
        {
          l3 = parseMaxAge((String)localObject3);
          l2 = l3;
          bool7 = true;
          localObject3 = localObject2;
          localObject5 = localObject1;
          bool5 = bool3;
          bool6 = bool2;
          l3 = l2;
          l4 = l1;
        }
        else if (str3.equalsIgnoreCase("domain"))
        {
          localObject3 = parseDomain((String)localObject3);
          bool6 = false;
          localObject5 = localObject1;
          bool5 = bool3;
          bool7 = bool1;
          l3 = l2;
          l4 = l1;
        }
        else if (str3.equalsIgnoreCase("path"))
        {
          localObject5 = localObject3;
          localObject3 = localObject2;
          bool5 = bool3;
          bool6 = bool2;
          bool7 = bool1;
          l3 = l2;
          l4 = l1;
        }
        else if (str3.equalsIgnoreCase("secure"))
        {
          bool5 = true;
          localObject3 = localObject2;
          localObject5 = localObject1;
          bool6 = bool2;
          bool7 = bool1;
          l3 = l2;
          l4 = l1;
        }
        else
        {
          localObject3 = localObject2;
          localObject5 = localObject1;
          bool5 = bool3;
          bool6 = bool2;
          bool7 = bool1;
          l3 = l2;
          l4 = l1;
          if (str3.equalsIgnoreCase("httponly"))
          {
            bool4 = true;
            l4 = l1;
            l3 = l2;
            bool7 = bool1;
            bool6 = bool2;
            bool5 = bool3;
            localObject5 = localObject1;
            localObject3 = localObject2;
          }
        }
      }
      catch (IllegalArgumentException|NumberFormatException localIllegalArgumentException)
      {
        for (;;)
        {
          Object localObject4 = localObject2;
          Object localObject5 = localObject1;
          boolean bool5 = bool3;
          boolean bool6 = bool2;
          boolean bool7 = bool1;
          long l3 = l2;
          long l4 = l1;
        }
      }
      i = k + 1;
      localObject2 = localObject3;
      localObject1 = localObject5;
      bool3 = bool5;
      bool2 = bool6;
      bool1 = bool7;
      l2 = l3;
      l1 = l4;
    }
    l3 = Long.MIN_VALUE;
    if (l2 == Long.MIN_VALUE) {
      paramLong = l3;
    }
    for (;;)
    {
      break;
      if (l2 != -1L)
      {
        if (l2 <= 9223372036854775L) {
          l1 = l2 * 1000L;
        } else {
          l1 = Long.MAX_VALUE;
        }
        l1 = paramLong + l1;
        if (l1 >= paramLong)
        {
          paramLong = l1;
          if (l1 <= 253402300799999L) {
            break;
          }
        }
        else
        {
          paramLong = 253402300799999L;
        }
      }
      else
      {
        paramLong = l1;
      }
    }
    if (localObject2 == null)
    {
      paramString = paramHttpUrl.host();
    }
    else
    {
      if (!domainMatch(paramHttpUrl, (String)localObject2)) {
        return null;
      }
      paramString = (String)localObject2;
    }
    localObject2 = "/";
    if ((localObject1 != null) && (((String)localObject1).startsWith("/")))
    {
      paramHttpUrl = (HttpUrl)localObject1;
    }
    else
    {
      localObject1 = paramHttpUrl.encodedPath();
      i = ((String)localObject1).lastIndexOf('/');
      paramHttpUrl = (HttpUrl)localObject2;
      if (i != 0) {
        paramHttpUrl = ((String)localObject1).substring(0, i);
      }
    }
    return new Cookie(str1, str2, paramLong, paramString, paramHttpUrl, bool3, bool4, bool2, bool1);
  }
  
  public static Cookie parse(HttpUrl paramHttpUrl, String paramString)
  {
    return parse(System.currentTimeMillis(), paramHttpUrl, paramString);
  }
  
  public static List<Cookie> parseAll(HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    List localList = paramHeaders.values("Set-Cookie");
    int j = localList.size();
    paramHeaders = null;
    int i = 0;
    while (i < j)
    {
      Cookie localCookie = parse(paramHttpUrl, (String)localList.get(i));
      if (localCookie != null)
      {
        Object localObject = paramHeaders;
        if (paramHeaders == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localCookie);
        paramHeaders = (Headers)localObject;
      }
      i += 1;
    }
    if (paramHeaders != null) {
      return Collections.unmodifiableList(paramHeaders);
    }
    return Collections.emptyList();
  }
  
  private static String parseDomain(String paramString)
  {
    if (!paramString.endsWith("."))
    {
      String str = paramString;
      if (paramString.startsWith(".")) {
        str = paramString.substring(1);
      }
      paramString = Util.domainToAscii(str);
      if (paramString != null) {
        return paramString;
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  private static long parseExpires(String paramString, int paramInt1, int paramInt2)
  {
    int i1 = dateCharacterOffset(paramString, paramInt1, paramInt2, false);
    Matcher localMatcher = TIME_PATTERN.matcher(paramString);
    paramInt1 = -1;
    int n = -1;
    int k = -1;
    int i = -1;
    int m = -1;
    int j = -1;
    while (i1 < paramInt2)
    {
      int i7 = dateCharacterOffset(paramString, i1 + 1, paramInt2, true);
      localMatcher.region(i1, i7);
      int i2;
      int i5;
      int i6;
      int i3;
      int i4;
      if ((n == -1) && (localMatcher.usePattern(TIME_PATTERN).matches()))
      {
        i2 = Integer.parseInt(localMatcher.group(1));
        i5 = Integer.parseInt(localMatcher.group(2));
        i6 = Integer.parseInt(localMatcher.group(3));
        i1 = paramInt1;
        i3 = k;
        i4 = i;
      }
      else if ((k == -1) && (localMatcher.usePattern(DAY_OF_MONTH_PATTERN).matches()))
      {
        i3 = Integer.parseInt(localMatcher.group(1));
        i1 = paramInt1;
        i2 = n;
        i4 = i;
        i5 = m;
        i6 = j;
      }
      else if ((i == -1) && (localMatcher.usePattern(MONTH_PATTERN).matches()))
      {
        String str = localMatcher.group(1).toLowerCase(Locale.US);
        i4 = MONTH_PATTERN.pattern().indexOf(str) / 4;
        i1 = paramInt1;
        i2 = n;
        i3 = k;
        i5 = m;
        i6 = j;
      }
      else
      {
        i1 = paramInt1;
        i2 = n;
        i3 = k;
        i4 = i;
        i5 = m;
        i6 = j;
        if (paramInt1 == -1)
        {
          i1 = paramInt1;
          i2 = n;
          i3 = k;
          i4 = i;
          i5 = m;
          i6 = j;
          if (localMatcher.usePattern(YEAR_PATTERN).matches())
          {
            i1 = Integer.parseInt(localMatcher.group(1));
            i6 = j;
            i5 = m;
            i4 = i;
            i3 = k;
            i2 = n;
          }
        }
      }
      i7 = dateCharacterOffset(paramString, i7 + 1, paramInt2, false);
      paramInt1 = i1;
      n = i2;
      k = i3;
      i = i4;
      m = i5;
      j = i6;
      i1 = i7;
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99) {
        paramInt2 = paramInt1 + 1900;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69) {
        paramInt1 = paramInt2 + 2000;
      }
    }
    if (paramInt1 >= 1601)
    {
      if (i != -1)
      {
        if ((k >= 1) && (k <= 31))
        {
          if ((n >= 0) && (n <= 23))
          {
            if ((m >= 0) && (m <= 59))
            {
              if ((j >= 0) && (j <= 59))
              {
                paramString = new GregorianCalendar(Util.UTC);
                paramString.setLenient(false);
                paramString.set(1, paramInt1);
                paramString.set(2, i - 1);
                paramString.set(5, k);
                paramString.set(11, n);
                paramString.set(12, m);
                paramString.set(13, j);
                paramString.set(14, 0);
                return paramString.getTimeInMillis();
              }
              throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
          }
          throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  private static long parseMaxAge(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l <= 0L) {
        return Long.MIN_VALUE;
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-")) {
          return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
      }
      throw localNumberFormatException;
    }
  }
  
  private static boolean pathMatch(HttpUrl paramHttpUrl, String paramString)
  {
    paramHttpUrl = paramHttpUrl.encodedPath();
    if (paramHttpUrl.equals(paramString)) {
      return true;
    }
    if (paramHttpUrl.startsWith(paramString))
    {
      if (paramString.endsWith("/")) {
        return true;
      }
      if (paramHttpUrl.charAt(paramString.length()) == '/') {
        return true;
      }
    }
    return false;
  }
  
  public String domain()
  {
    return this.domain;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public long expiresAt()
  {
    return this.expiresAt;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean hostOnly()
  {
    return this.hostOnly;
  }
  
  public boolean httpOnly()
  {
    return this.httpOnly;
  }
  
  public boolean matches(HttpUrl paramHttpUrl)
  {
    return false;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String path()
  {
    return this.path;
  }
  
  public boolean persistent()
  {
    return this.persistent;
  }
  
  public boolean secure()
  {
    return this.secure;
  }
  
  public String toString()
  {
    return null;
  }
  
  public String value()
  {
    return this.value;
  }
  
  public static final class Builder
  {
    String domain;
    long expiresAt = 253402300799999L;
    boolean hostOnly;
    boolean httpOnly;
    String name;
    String path = "/";
    boolean persistent;
    boolean secure;
    String value;
    
    private Builder domain(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public Cookie build()
    {
      return new Cookie(this, null);
    }
    
    public Builder domain(String paramString)
    {
      return domain(paramString, false);
    }
    
    public Builder expiresAt(long paramLong)
    {
      return null;
    }
    
    public Builder hostOnlyDomain(String paramString)
    {
      return domain(paramString, true);
    }
    
    public Builder httpOnly()
    {
      this.httpOnly = true;
      return this;
    }
    
    public Builder name(String paramString)
    {
      return null;
    }
    
    public Builder path(String paramString)
    {
      return null;
    }
    
    public Builder secure()
    {
      this.secure = true;
      return this;
    }
    
    public Builder value(String paramString)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */