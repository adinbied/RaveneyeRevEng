package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.Buffer;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class HttpUrl
{
  static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  static final String FRAGMENT_ENCODE_SET = "";
  static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
  static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
  static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
  static final String QUERY_ENCODE_SET = " \"'<>#";
  static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  private final String fragment;
  private final String host;
  private final String password;
  private final List<String> pathSegments;
  private final int port;
  private final List<String> queryNamesAndValues;
  private final String scheme;
  private final String url;
  private final String username;
  
  private HttpUrl(Builder paramBuilder)
  {
    this.scheme = paramBuilder.scheme;
    this.username = percentDecode(paramBuilder.encodedUsername, false);
    this.password = percentDecode(paramBuilder.encodedPassword, false);
    this.host = paramBuilder.host;
    this.port = paramBuilder.effectivePort();
    this.pathSegments = percentDecode(paramBuilder.encodedPathSegments, false);
    Object localObject1 = paramBuilder.encodedQueryNamesAndValues;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = percentDecode(paramBuilder.encodedQueryNamesAndValues, true);
    } else {
      localObject1 = null;
    }
    this.queryNamesAndValues = ((List)localObject1);
    localObject1 = localObject2;
    if (paramBuilder.encodedFragment != null) {
      localObject1 = percentDecode(paramBuilder.encodedFragment, false);
    }
    this.fragment = ((String)localObject1);
    this.url = paramBuilder.toString();
  }
  
  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString1.codePointAt(i);
      if ((j >= 32) && (j != 127) && ((j < 128) || (!paramBoolean4)) && (paramString2.indexOf(j) == -1) && ((j != 37) || ((paramBoolean1) && ((!paramBoolean2) || (percentEncoded(paramString1, i, paramInt2))))) && ((j != 43) || (!paramBoolean3)))
      {
        i += Character.charCount(j);
      }
      else
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString1, paramInt1, i);
        canonicalize(localBuffer, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        return localBuffer.readUtf8();
      }
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  static void canonicalize(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject3;
    for (Object localObject1 = null; paramInt1 < paramInt2; localObject1 = localObject3)
    {
      int i = paramString1.codePointAt(paramInt1);
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (i == 9) {
          break label279;
        }
        localObject3 = localObject1;
        if (i == 10) {
          break label279;
        }
        localObject3 = localObject1;
        if (i == 12) {
          break label279;
        }
        if (i == 13)
        {
          localObject3 = localObject1;
          break label279;
        }
      }
      Object localObject2;
      if ((i == 43) && (paramBoolean3))
      {
        if (paramBoolean1) {
          localObject2 = "+";
        } else {
          localObject2 = "%2B";
        }
        paramBuffer.writeUtf8((String)localObject2);
        localObject3 = localObject1;
      }
      else if ((i >= 32) && (i != 127) && ((i < 128) || (!paramBoolean4)) && (paramString2.indexOf(i) == -1) && ((i != 37) || ((paramBoolean1) && ((!paramBoolean2) || (percentEncoded(paramString1, paramInt1, paramInt2))))))
      {
        paramBuffer.writeUtf8CodePoint(i);
        localObject3 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Buffer();
        }
        ((Buffer)localObject2).writeUtf8CodePoint(i);
        for (;;)
        {
          localObject3 = localObject2;
          if (((Buffer)localObject2).exhausted()) {
            break;
          }
          int j = ((Buffer)localObject2).readByte() & 0xFF;
          paramBuffer.writeByte(37);
          paramBuffer.writeByte(HEX_DIGITS[(j >> 4 & 0xF)]);
          paramBuffer.writeByte(HEX_DIGITS[(j & 0xF)]);
        }
      }
      label279:
      paramInt1 += Character.charCount(i);
    }
  }
  
  static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return -1;
  }
  
  public static int defaultPort(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  public static HttpUrl get(URI paramURI)
  {
    return parse(paramURI.toString());
  }
  
  public static HttpUrl get(URL paramURL)
  {
    return parse(paramURL.toString());
  }
  
  static HttpUrl getChecked(String paramString)
    throws MalformedURLException, UnknownHostException
  {
    Object localObject2 = new Builder();
    Object localObject1 = ((Builder)localObject2).parse(null, paramString);
    int i = 1.$SwitchMap$okhttp3$HttpUrl$Builder$ParseResult[localObject1.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Invalid URL: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" for ");
        ((StringBuilder)localObject2).append(paramString);
        throw new MalformedURLException(((StringBuilder)localObject2).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid host: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new UnknownHostException(((StringBuilder)localObject1).toString());
    }
    return ((Builder)localObject2).build();
  }
  
  static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str1 = (String)paramList.get(i);
      String str2 = (String)paramList.get(i + 1);
      if (i > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      i += 2;
    }
  }
  
  public static HttpUrl parse(String paramString)
  {
    Builder localBuilder = new Builder();
    HttpUrl localHttpUrl = null;
    if (localBuilder.parse(null, paramString) == HttpUrl.Builder.ParseResult.SUCCESS) {
      localHttpUrl = localBuilder.build();
    }
    return localHttpUrl;
  }
  
  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
  }
  
  static String percentDecode(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString.charAt(i);
      if ((j != 37) && ((j != 43) || (!paramBoolean)))
      {
        i += 1;
      }
      else
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString, paramInt1, i);
        percentDecode(localBuffer, paramString, i, paramInt2, paramBoolean);
        return localBuffer.readUtf8();
      }
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String percentDecode(String paramString, boolean paramBoolean)
  {
    return percentDecode(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> percentDecode(List<String> paramList, boolean paramBoolean)
  {
    return null;
  }
  
  static void percentDecode(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int j = paramString.codePointAt(paramInt1);
      if (j == 37)
      {
        int i = paramInt1 + 2;
        if (i < paramInt2)
        {
          int k = decodeHexDigit(paramString.charAt(paramInt1 + 1));
          int m = decodeHexDigit(paramString.charAt(i));
          if ((k == -1) || (m == -1)) {
            break label105;
          }
          paramBuffer.writeByte((k << 4) + m);
          paramInt1 = i;
          break label112;
        }
      }
      if ((j == 43) && (paramBoolean)) {
        paramBuffer.writeByte(32);
      } else {
        label105:
        paramBuffer.writeUtf8CodePoint(j);
      }
      label112:
      paramInt1 += Character.charCount(j);
    }
  }
  
  static boolean percentEncoded(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 2;
    return (i < paramInt2) && (paramString.charAt(paramInt1) == '%') && (decodeHexDigit(paramString.charAt(paramInt1 + 1)) != -1) && (decodeHexDigit(paramString.charAt(i)) != -1);
  }
  
  static List<String> queryStringToNamesAndValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = 0; i <= paramString.length(); i = j + 1)
    {
      int k = paramString.indexOf('&', i);
      j = k;
      if (k == -1) {
        j = paramString.length();
      }
      k = paramString.indexOf('=', i);
      if ((k != -1) && (k <= j))
      {
        localArrayList.add(paramString.substring(i, k));
        localArrayList.add(paramString.substring(k + 1, j));
      }
      else
      {
        localArrayList.add(paramString.substring(i, j));
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  public String encodedFragment()
  {
    return null;
  }
  
  public String encodedPassword()
  {
    return null;
  }
  
  public String encodedPath()
  {
    return null;
  }
  
  public List<String> encodedPathSegments()
  {
    return null;
  }
  
  public String encodedQuery()
  {
    return null;
  }
  
  public String encodedUsername()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String fragment()
  {
    return this.fragment;
  }
  
  public int hashCode()
  {
    return this.url.hashCode();
  }
  
  public String host()
  {
    return this.host;
  }
  
  public boolean isHttps()
  {
    return false;
  }
  
  public Builder newBuilder()
  {
    return null;
  }
  
  public Builder newBuilder(String paramString)
  {
    return null;
  }
  
  public String password()
  {
    return this.password;
  }
  
  public List<String> pathSegments()
  {
    return this.pathSegments;
  }
  
  public int pathSize()
  {
    return this.pathSegments.size();
  }
  
  public int port()
  {
    return this.port;
  }
  
  public String query()
  {
    return null;
  }
  
  public String queryParameter(String paramString)
  {
    return null;
  }
  
  public String queryParameterName(int paramInt)
  {
    return null;
  }
  
  public Set<String> queryParameterNames()
  {
    return null;
  }
  
  public String queryParameterValue(int paramInt)
  {
    return null;
  }
  
  public List<String> queryParameterValues(String paramString)
  {
    return null;
  }
  
  public int querySize()
  {
    return 0;
  }
  
  public HttpUrl resolve(String paramString)
  {
    paramString = newBuilder(paramString);
    if (paramString != null) {
      return paramString.build();
    }
    return null;
  }
  
  public String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    return this.url;
  }
  
  public URI uri()
  {
    return null;
  }
  
  public URL url()
  {
    return null;
  }
  
  public String username()
  {
    return this.username;
  }
  
  public static final class Builder
  {
    String encodedFragment;
    String encodedPassword = "";
    final List<String> encodedPathSegments;
    List<String> encodedQueryNamesAndValues;
    String encodedUsername = "";
    String host;
    int port = -1;
    String scheme;
    
    public Builder()
    {
      ArrayList localArrayList = new ArrayList();
      this.encodedPathSegments = localArrayList;
      localArrayList.add("");
    }
    
    private Builder addPathSegments(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    private static String canonicalizeHost(String paramString, int paramInt1, int paramInt2)
    {
      paramString = HttpUrl.percentDecode(paramString, paramInt1, paramInt2, false);
      if (paramString.contains(":"))
      {
        if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
          paramString = decodeIpv6(paramString, 1, paramString.length() - 1);
        } else {
          paramString = decodeIpv6(paramString, 0, paramString.length());
        }
        if (paramString == null) {
          return null;
        }
        paramString = paramString.getAddress();
        if (paramString.length == 16) {
          return inet6AddressToAscii(paramString);
        }
        throw new AssertionError();
      }
      return Util.domainToAscii(paramString);
    }
    
    private static boolean decodeIpv4Suffix(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
    {
      int j = paramInt3;
      int i = paramInt1;
      while (i < paramInt2)
      {
        if (j == paramArrayOfByte.length) {
          return false;
        }
        paramInt1 = i;
        if (j != paramInt3)
        {
          if (paramString.charAt(i) != '.') {
            return false;
          }
          paramInt1 = i + 1;
        }
        i = paramInt1;
        int k = 0;
        while (i < paramInt2)
        {
          int m = paramString.charAt(i);
          if ((m < 48) || (m > 57)) {
            break;
          }
          if ((k == 0) && (paramInt1 != i)) {
            return false;
          }
          k = k * 10 + m - 48;
          if (k > 255) {
            return false;
          }
          i += 1;
        }
        if (i - paramInt1 == 0) {
          return false;
        }
        paramArrayOfByte[j] = ((byte)k);
        j += 1;
      }
      return j == paramInt3 + 4;
    }
    
    private static InetAddress decodeIpv6(String paramString, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[16];
      int i = 0;
      int j = -1;
      int m = -1;
      int k;
      int n;
      for (;;)
      {
        k = i;
        n = j;
        if (paramInt1 >= paramInt2) {
          break label290;
        }
        if (i == 16) {
          return null;
        }
        n = paramInt1 + 2;
        if ((n <= paramInt2) && (paramString.regionMatches(paramInt1, "::", 0, 2)))
        {
          if (j != -1) {
            return null;
          }
          k = i + 2;
          paramInt1 = k;
          if (n == paramInt2)
          {
            n = paramInt1;
            break label290;
          }
          m = n;
          i = k;
          j = paramInt1;
          paramInt1 = m;
        }
        else
        {
          k = paramInt1;
          if (i != 0) {
            if (paramString.regionMatches(paramInt1, ":", 0, 1))
            {
              k = paramInt1 + 1;
            }
            else
            {
              if (paramString.regionMatches(paramInt1, ".", 0, 1))
              {
                if (!decodeIpv4Suffix(paramString, m, paramInt2, arrayOfByte, i - 2)) {
                  return null;
                }
                k = i + 2;
                n = j;
                break label290;
              }
              return null;
            }
          }
          paramInt1 = k;
        }
        k = paramInt1;
        m = 0;
        while (k < paramInt2)
        {
          n = HttpUrl.decodeHexDigit(paramString.charAt(k));
          if (n == -1) {
            break;
          }
          m = (m << 4) + n;
          k += 1;
        }
        n = k - paramInt1;
        if (n == 0) {
          break;
        }
        if (n > 4) {
          return null;
        }
        n = i + 1;
        arrayOfByte[i] = ((byte)(m >>> 8 & 0xFF));
        i = n + 1;
        arrayOfByte[n] = ((byte)(m & 0xFF));
        m = paramInt1;
        paramInt1 = k;
      }
      return null;
      label290:
      if (k != 16)
      {
        if (n == -1) {
          return null;
        }
        paramInt1 = k - n;
        System.arraycopy(arrayOfByte, n, arrayOfByte, 16 - paramInt1, paramInt1);
        Arrays.fill(arrayOfByte, n, 16 - k + n, (byte)0);
      }
      try
      {
        paramString = InetAddress.getByAddress(arrayOfByte);
        return paramString;
      }
      catch (UnknownHostException paramString)
      {
        for (;;) {}
      }
      throw new AssertionError();
    }
    
    private static String inet6AddressToAscii(byte[] paramArrayOfByte)
    {
      int i1 = 0;
      int k = -1;
      int i = 0;
      int m;
      int n;
      for (int j = 0; i < paramArrayOfByte.length; j = n)
      {
        m = i;
        while ((m < 16) && (paramArrayOfByte[m] == 0) && (paramArrayOfByte[(m + 1)] == 0)) {
          m += 2;
        }
        int i2 = m - i;
        n = j;
        if (i2 > j)
        {
          n = i2;
          k = i;
        }
        i = m + 2;
      }
      Buffer localBuffer = new Buffer();
      i = i1;
      while (i < paramArrayOfByte.length) {
        if (i == k)
        {
          localBuffer.writeByte(58);
          m = i + j;
          i = m;
          if (m == 16)
          {
            localBuffer.writeByte(58);
            i = m;
          }
        }
        else
        {
          if (i > 0) {
            localBuffer.writeByte(58);
          }
          localBuffer.writeHexadecimalUnsignedLong((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
          i += 2;
        }
      }
      return localBuffer.readUtf8();
    }
    
    private boolean isDot(String paramString)
    {
      return false;
    }
    
    private boolean isDotDot(String paramString)
    {
      return false;
    }
    
    private static int parsePort(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(HttpUrl.canonicalize(paramString, paramInt1, paramInt2, "", false, false, false, true));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    /* Error */
    private void pop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private static int portColonOffset(String paramString, int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if (j != 58)
        {
          int i = paramInt1;
          if (j != 91)
          {
            i = paramInt1;
          }
          else
          {
            do
            {
              paramInt1 = i + 1;
              i = paramInt1;
              if (paramInt1 >= paramInt2) {
                break;
              }
              i = paramInt1;
            } while (paramString.charAt(paramInt1) != ']');
            i = paramInt1;
          }
          paramInt1 = i + 1;
        }
        else
        {
          return paramInt1;
        }
      }
      return paramInt2;
    }
    
    /* Error */
    private void push(String arg1, int arg2, int arg3, boolean arg4, boolean arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void removeAllCanonicalQueryParameters(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void resolvePath(String arg1, int arg2, int arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private static int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {
        return -1;
      }
      int j = paramString.charAt(paramInt1);
      int i;
      if (j >= 97)
      {
        i = paramInt1;
        if (j <= 122) {}
      }
      else
      {
        if (j < 65) {
          break label153;
        }
        i = paramInt1;
        if (j > 90) {
          return -1;
        }
      }
      for (;;)
      {
        paramInt1 = i + 1;
        if (paramInt1 >= paramInt2) {
          break label153;
        }
        j = paramString.charAt(paramInt1);
        if (j >= 97)
        {
          i = paramInt1;
          if (j <= 122) {}
        }
        else if (j >= 65)
        {
          i = paramInt1;
          if (j <= 90) {}
        }
        else if (j >= 48)
        {
          i = paramInt1;
          if (j <= 57) {}
        }
        else
        {
          i = paramInt1;
          if (j != 43)
          {
            i = paramInt1;
            if (j != 45)
            {
              if (j != 46) {
                break;
              }
              i = paramInt1;
            }
          }
        }
      }
      if (j == 58) {
        return paramInt1;
      }
      label153:
      return -1;
    }
    
    private static int slashCount(String paramString, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47)) {
          break;
        }
        i += 1;
        paramInt1 += 1;
      }
      return i;
    }
    
    public Builder addEncodedPathSegment(String paramString)
    {
      return null;
    }
    
    public Builder addEncodedPathSegments(String paramString)
    {
      return null;
    }
    
    public Builder addEncodedQueryParameter(String paramString1, String paramString2)
    {
      return null;
    }
    
    public Builder addPathSegment(String paramString)
    {
      return null;
    }
    
    public Builder addPathSegments(String paramString)
    {
      return null;
    }
    
    public Builder addQueryParameter(String paramString1, String paramString2)
    {
      return null;
    }
    
    public HttpUrl build()
    {
      return null;
    }
    
    int effectivePort()
    {
      return 0;
    }
    
    public Builder encodedFragment(String paramString)
    {
      return null;
    }
    
    public Builder encodedPassword(String paramString)
    {
      return null;
    }
    
    public Builder encodedPath(String paramString)
    {
      return null;
    }
    
    public Builder encodedQuery(String paramString)
    {
      return null;
    }
    
    public Builder encodedUsername(String paramString)
    {
      return null;
    }
    
    public Builder fragment(String paramString)
    {
      return null;
    }
    
    public Builder host(String paramString)
    {
      return null;
    }
    
    ParseResult parse(HttpUrl paramHttpUrl, String paramString)
    {
      return null;
    }
    
    public Builder password(String paramString)
    {
      return null;
    }
    
    public Builder port(int paramInt)
    {
      return null;
    }
    
    public Builder query(String paramString)
    {
      return null;
    }
    
    Builder reencodeForUri()
    {
      return null;
    }
    
    public Builder removeAllEncodedQueryParameters(String paramString)
    {
      return null;
    }
    
    public Builder removeAllQueryParameters(String paramString)
    {
      return null;
    }
    
    public Builder removePathSegment(int paramInt)
    {
      return null;
    }
    
    public Builder scheme(String paramString)
    {
      return null;
    }
    
    public Builder setEncodedPathSegment(int paramInt, String paramString)
    {
      return null;
    }
    
    public Builder setEncodedQueryParameter(String paramString1, String paramString2)
    {
      removeAllEncodedQueryParameters(paramString1);
      addEncodedQueryParameter(paramString1, paramString2);
      return this;
    }
    
    public Builder setPathSegment(int paramInt, String paramString)
    {
      return null;
    }
    
    public Builder setQueryParameter(String paramString1, String paramString2)
    {
      removeAllQueryParameters(paramString1);
      addQueryParameter(paramString1, paramString2);
      return this;
    }
    
    public String toString()
    {
      return null;
    }
    
    public Builder username(String paramString)
    {
      return null;
    }
    
    static enum ParseResult
    {
      static
      {
        MISSING_SCHEME = new ParseResult("MISSING_SCHEME", 1);
        UNSUPPORTED_SCHEME = new ParseResult("UNSUPPORTED_SCHEME", 2);
        INVALID_PORT = new ParseResult("INVALID_PORT", 3);
        ParseResult localParseResult = new ParseResult("INVALID_HOST", 4);
        INVALID_HOST = localParseResult;
        $VALUES = new ParseResult[] { SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, localParseResult };
      }
      
      private ParseResult() {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\HttpUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */