package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion;
import okio.Buffer;

@Metadata(bv={1, 0, 3}, d1={"\000H\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\004\n\002\020\b\n\000\n\002\020 \n\002\b\r\n\002\020\013\n\002\b\005\n\002\020\"\n\002\b\016\n\002\030\002\n\002\b\023\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\030\000 J2\0020\001:\002IJBa\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\006\020\006\032\0020\003\022\006\020\007\032\0020\b\022\f\020\t\032\b\022\004\022\0020\0030\n\022\020\020\013\032\f\022\006\022\004\030\0010\003\030\0010\n\022\b\020\f\032\004\030\0010\003\022\006\020\r\032\0020\003¢\006\002\020\016J\017\020\017\032\004\030\0010\003H\007¢\006\002\b!J\r\020\021\032\0020\003H\007¢\006\002\b\"J\r\020\022\032\0020\003H\007¢\006\002\b#J\023\020\023\032\b\022\004\022\0020\0030\nH\007¢\006\002\b$J\017\020\025\032\004\030\0010\003H\007¢\006\002\b%J\r\020\026\032\0020\003H\007¢\006\002\b&J\023\020'\032\0020\0302\b\020(\032\004\030\0010\001H\002J\017\020\f\032\004\030\0010\003H\007¢\006\002\b)J\b\020*\032\0020\bH\026J\r\020\006\032\0020\003H\007¢\006\002\b+J\006\020,\032\0020-J\020\020,\032\004\030\0010-2\006\020.\032\0020\003J\r\020\005\032\0020\003H\007¢\006\002\b/J\023\020\t\032\b\022\004\022\0020\0030\nH\007¢\006\002\b0J\r\020\032\032\0020\bH\007¢\006\002\b1J\r\020\007\032\0020\bH\007¢\006\002\b2J\017\020\034\032\004\030\0010\003H\007¢\006\002\b3J\020\0204\032\004\030\0010\0032\006\0205\032\0020\003J\016\0206\032\0020\0032\006\0207\032\0020\bJ\023\020\035\032\b\022\004\022\0020\0030\036H\007¢\006\002\b8J\020\0209\032\004\030\0010\0032\006\0207\032\0020\bJ\026\020:\032\n\022\006\022\004\030\0010\0030\n2\006\0205\032\0020\003J\r\020 \032\0020\bH\007¢\006\002\b;J\006\020<\032\0020\003J\020\020=\032\004\030\0010\0002\006\020.\032\0020\003J\r\020\002\032\0020\003H\007¢\006\002\b>J\b\020?\032\0020\003H\026J\r\020@\032\0020AH\007¢\006\002\bBJ\r\020C\032\0020DH\007¢\006\002\b\rJ\b\020E\032\004\030\0010\003J\r\020B\032\0020AH\007¢\006\002\bFJ\r\020\r\032\0020DH\007¢\006\002\bGJ\r\020\004\032\0020\003H\007¢\006\002\bHR\023\020\017\032\004\030\0010\0038G¢\006\006\032\004\b\017\020\020R\021\020\021\032\0020\0038G¢\006\006\032\004\b\021\020\020R\021\020\022\032\0020\0038G¢\006\006\032\004\b\022\020\020R\027\020\023\032\b\022\004\022\0020\0030\n8G¢\006\006\032\004\b\023\020\024R\023\020\025\032\004\030\0010\0038G¢\006\006\032\004\b\025\020\020R\021\020\026\032\0020\0038G¢\006\006\032\004\b\026\020\020R\025\020\f\032\004\030\0010\0038\007¢\006\b\n\000\032\004\b\f\020\020R\023\020\006\032\0020\0038\007¢\006\b\n\000\032\004\b\006\020\020R\021\020\027\032\0020\030¢\006\b\n\000\032\004\b\027\020\031R\023\020\005\032\0020\0038\007¢\006\b\n\000\032\004\b\005\020\020R\031\020\t\032\b\022\004\022\0020\0030\n8\007¢\006\b\n\000\032\004\b\t\020\024R\021\020\032\032\0020\b8G¢\006\006\032\004\b\032\020\033R\023\020\007\032\0020\b8\007¢\006\b\n\000\032\004\b\007\020\033R\023\020\034\032\004\030\0010\0038G¢\006\006\032\004\b\034\020\020R\030\020\013\032\f\022\006\022\004\030\0010\003\030\0010\nX\004¢\006\002\n\000R\027\020\035\032\b\022\004\022\0020\0030\0368G¢\006\006\032\004\b\035\020\037R\021\020 \032\0020\b8G¢\006\006\032\004\b \020\033R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\020R\016\020\r\032\0020\003X\004¢\006\002\n\000R\023\020\004\032\0020\0038\007¢\006\b\n\000\032\004\b\004\020\020¨\006K"}, d2={"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class HttpUrl
{
  public static final Companion Companion = new Companion(null);
  public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  public static final String FRAGMENT_ENCODE_SET = "";
  public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
  public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
  public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
  public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
  public static final String QUERY_ENCODE_SET = " \"'<>#";
  public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  private final String fragment;
  private final String host;
  private final boolean isHttps;
  private final String password;
  private final List<String> pathSegments;
  private final int port;
  private final List<String> queryNamesAndValues;
  private final String scheme;
  private final String url;
  private final String username;
  
  public HttpUrl(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, List<String> paramList1, List<String> paramList2, String paramString5, String paramString6)
  {
    this.scheme = paramString1;
    this.username = paramString2;
    this.password = paramString3;
    this.host = paramString4;
    this.port = paramInt;
    this.pathSegments = paramList1;
    this.queryNamesAndValues = paramList2;
    this.fragment = paramString5;
    this.url = paramString6;
    this.isHttps = Intrinsics.areEqual(paramString1, "https");
  }
  
  @JvmStatic
  public static final int defaultPort(String paramString)
  {
    return Companion.defaultPort(paramString);
  }
  
  @JvmStatic
  public static final HttpUrl get(String paramString)
  {
    return Companion.get(paramString);
  }
  
  @JvmStatic
  public static final HttpUrl get(URI paramURI)
  {
    return Companion.get(paramURI);
  }
  
  @JvmStatic
  public static final HttpUrl get(URL paramURL)
  {
    return Companion.get(paramURL);
  }
  
  @JvmStatic
  public static final HttpUrl parse(String paramString)
  {
    return Companion.parse(paramString);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedFragment", imports={}))
  public final String -deprecated_encodedFragment()
  {
    return encodedFragment();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedPassword", imports={}))
  public final String -deprecated_encodedPassword()
  {
    return encodedPassword();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedPath", imports={}))
  public final String -deprecated_encodedPath()
  {
    return encodedPath();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedPathSegments", imports={}))
  public final List<String> -deprecated_encodedPathSegments()
  {
    return encodedPathSegments();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedQuery", imports={}))
  public final String -deprecated_encodedQuery()
  {
    return encodedQuery();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="encodedUsername", imports={}))
  public final String -deprecated_encodedUsername()
  {
    return encodedUsername();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="fragment", imports={}))
  public final String -deprecated_fragment()
  {
    return this.fragment;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="host", imports={}))
  public final String -deprecated_host()
  {
    return this.host;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="password", imports={}))
  public final String -deprecated_password()
  {
    return this.password;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="pathSegments", imports={}))
  public final List<String> -deprecated_pathSegments()
  {
    return this.pathSegments;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="pathSize", imports={}))
  public final int -deprecated_pathSize()
  {
    return pathSize();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="port", imports={}))
  public final int -deprecated_port()
  {
    return this.port;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="query", imports={}))
  public final String -deprecated_query()
  {
    return query();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="queryParameterNames", imports={}))
  public final Set<String> -deprecated_queryParameterNames()
  {
    return queryParameterNames();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="querySize", imports={}))
  public final int -deprecated_querySize()
  {
    return querySize();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="scheme", imports={}))
  public final String -deprecated_scheme()
  {
    return this.scheme;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to toUri()", replaceWith=@ReplaceWith(expression="toUri()", imports={}))
  public final URI -deprecated_uri()
  {
    return uri();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to toUrl()", replaceWith=@ReplaceWith(expression="toUrl()", imports={}))
  public final URL -deprecated_url()
  {
    return url();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="username", imports={}))
  public final String -deprecated_username()
  {
    return this.username;
  }
  
  public final String encodedFragment()
  {
    if (this.fragment == null) {
      return null;
    }
    int i = StringsKt.indexOf$default((CharSequence)this.url, '#', 0, false, 6, null);
    String str = this.url;
    if (str != null)
    {
      str = str.substring(i + 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
      return str;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public final String encodedPassword()
  {
    if (((CharSequence)this.password).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "";
    }
    int i = StringsKt.indexOf$default((CharSequence)this.url, ':', this.scheme.length() + 3, false, 4, null);
    int j = StringsKt.indexOf$default((CharSequence)this.url, '@', 0, false, 6, null);
    String str = this.url;
    if (str != null)
    {
      str = str.substring(i + 1, j);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return str;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public final String encodedPath()
  {
    int i = StringsKt.indexOf$default((CharSequence)this.url, '/', this.scheme.length() + 3, false, 4, null);
    String str = this.url;
    int j = Util.delimiterOffset(str, "?#", i, str.length());
    str = this.url;
    if (str != null)
    {
      str = str.substring(i, j);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return str;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public final List<String> encodedPathSegments()
  {
    int i = StringsKt.indexOf$default((CharSequence)this.url, '/', this.scheme.length() + 3, false, 4, null);
    Object localObject = this.url;
    int j = Util.delimiterOffset((String)localObject, "?#", i, ((String)localObject).length());
    localObject = (List)new ArrayList();
    while (i < j)
    {
      int k = i + 1;
      i = Util.delimiterOffset(this.url, '/', k, j);
      String str = this.url;
      if (str != null)
      {
        str = str.substring(k, i);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((List)localObject).add(str);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return (List<String>)localObject;
  }
  
  public final String encodedQuery()
  {
    if (this.queryNamesAndValues == null) {
      return null;
    }
    int i = StringsKt.indexOf$default((CharSequence)this.url, '?', 0, false, 6, null) + 1;
    String str = this.url;
    int j = Util.delimiterOffset(str, '#', i, str.length());
    str = this.url;
    if (str != null)
    {
      str = str.substring(i, j);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return str;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public final String encodedUsername()
  {
    if (((CharSequence)this.username).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "";
    }
    int i = this.scheme.length() + 3;
    String str = this.url;
    int j = Util.delimiterOffset(str, ":@", i, str.length());
    str = this.url;
    if (str != null)
    {
      str = str.substring(i, j);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return str;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof HttpUrl)) && (Intrinsics.areEqual(((HttpUrl)paramObject).url, this.url));
  }
  
  public final String fragment()
  {
    return this.fragment;
  }
  
  public int hashCode()
  {
    return this.url.hashCode();
  }
  
  public final String host()
  {
    return this.host;
  }
  
  public final boolean isHttps()
  {
    return this.isHttps;
  }
  
  public final Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    localBuilder.setScheme$okhttp(this.scheme);
    localBuilder.setEncodedUsername$okhttp(encodedUsername());
    localBuilder.setEncodedPassword$okhttp(encodedPassword());
    localBuilder.setHost$okhttp(this.host);
    int i;
    if (this.port != Companion.defaultPort(this.scheme)) {
      i = this.port;
    } else {
      i = -1;
    }
    localBuilder.setPort$okhttp(i);
    localBuilder.getEncodedPathSegments$okhttp().clear();
    localBuilder.getEncodedPathSegments$okhttp().addAll((Collection)encodedPathSegments());
    localBuilder.encodedQuery(encodedQuery());
    localBuilder.setEncodedFragment$okhttp(encodedFragment());
    return localBuilder;
  }
  
  public final Builder newBuilder(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "link");
    try
    {
      paramString = new Builder().parse$okhttp(this, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final String password()
  {
    return this.password;
  }
  
  public final List<String> pathSegments()
  {
    return this.pathSegments;
  }
  
  public final int pathSize()
  {
    return this.pathSegments.size();
  }
  
  public final int port()
  {
    return this.port;
  }
  
  public final String query()
  {
    if (this.queryNamesAndValues == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Companion.toQueryString$okhttp(this.queryNamesAndValues, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final String queryParameter(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Object localObject = this.queryNamesAndValues;
    if (localObject == null) {
      return null;
    }
    localObject = RangesKt.step((IntProgression)RangesKt.until(0, ((List)localObject).size()), 2);
    int i = ((IntProgression)localObject).getFirst();
    int j = ((IntProgression)localObject).getLast();
    int k = ((IntProgression)localObject).getStep();
    if (k >= 0 ? i <= j : i >= j) {
      for (;;)
      {
        if (Intrinsics.areEqual(paramString, (String)this.queryNamesAndValues.get(i))) {
          return (String)this.queryNamesAndValues.get(i + 1);
        }
        if (i == j) {
          break;
        }
        i += k;
      }
    }
    return null;
  }
  
  public final String queryParameterName(int paramInt)
  {
    Object localObject = this.queryNamesAndValues;
    if (localObject != null)
    {
      localObject = ((List)localObject).get(paramInt * 2);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return (String)localObject;
    }
    throw ((Throwable)new IndexOutOfBoundsException());
  }
  
  public final Set<String> queryParameterNames()
  {
    if (this.queryNamesAndValues == null) {
      return SetsKt.emptySet();
    }
    Object localObject1 = new LinkedHashSet();
    Object localObject2 = RangesKt.step((IntProgression)RangesKt.until(0, this.queryNamesAndValues.size()), 2);
    int i = ((IntProgression)localObject2).getFirst();
    int j = ((IntProgression)localObject2).getLast();
    int k = ((IntProgression)localObject2).getStep();
    if (k >= 0 ? i <= j : i >= j) {
      for (;;)
      {
        localObject2 = this.queryNamesAndValues.get(i);
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((LinkedHashSet)localObject1).add(localObject2);
        if (i == j) {
          break;
        }
        i += k;
      }
    }
    localObject1 = Collections.unmodifiableSet((Set)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Collections.unmodifiableSet(result)");
    return (Set<String>)localObject1;
  }
  
  public final String queryParameterValue(int paramInt)
  {
    List localList = this.queryNamesAndValues;
    if (localList != null) {
      return (String)localList.get(paramInt * 2 + 1);
    }
    throw ((Throwable)new IndexOutOfBoundsException());
  }
  
  public final List<String> queryParameterValues(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if (this.queryNamesAndValues == null) {
      return CollectionsKt.emptyList();
    }
    List localList = (List)new ArrayList();
    IntProgression localIntProgression = RangesKt.step((IntProgression)RangesKt.until(0, this.queryNamesAndValues.size()), 2);
    int i = localIntProgression.getFirst();
    int j = localIntProgression.getLast();
    int k = localIntProgression.getStep();
    if (k >= 0 ? i <= j : i >= j) {
      for (;;)
      {
        if (Intrinsics.areEqual(paramString, (String)this.queryNamesAndValues.get(i))) {
          localList.add(this.queryNamesAndValues.get(i + 1));
        }
        if (i == j) {
          break;
        }
        i += k;
      }
    }
    paramString = Collections.unmodifiableList(localList);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Collections.unmodifiableList(result)");
    return paramString;
  }
  
  public final int querySize()
  {
    List localList = this.queryNamesAndValues;
    if (localList != null) {
      return localList.size() / 2;
    }
    return 0;
  }
  
  public final String redact()
  {
    Builder localBuilder = newBuilder("/...");
    if (localBuilder == null) {
      Intrinsics.throwNpe();
    }
    return localBuilder.username("").password("").build().toString();
  }
  
  public final HttpUrl resolve(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "link");
    paramString = newBuilder(paramString);
    if (paramString != null) {
      return paramString.build();
    }
    return null;
  }
  
  public final String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    return this.url;
  }
  
  public final String topPrivateDomain()
  {
    if (Util.canParseAsIpAddress(this.host)) {
      return null;
    }
    return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
  }
  
  public final URI uri()
  {
    Object localObject = newBuilder().reencodeForUri$okhttp().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException) {}
    try
    {
      localObject = (CharSequence)localObject;
      localObject = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace((CharSequence)localObject, ""));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "URI.create(stripped)");
      return (URI)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    throw ((Throwable)new RuntimeException((Throwable)localURISyntaxException));
  }
  
  public final URL url()
  {
    try
    {
      URL localURL = new URL(this.url);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw ((Throwable)new RuntimeException((Throwable)localMalformedURLException));
    }
  }
  
  public final String username()
  {
    return this.username;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\b\n\002\020!\n\002\b\r\n\002\020\b\n\002\b\022\n\002\020\013\n\002\b\004\n\002\030\002\n\002\b\f\n\002\020\002\n\002\b\027\030\000 V2\0020\001:\001VB\005¢\006\002\020\002J\016\020#\032\0020\0002\006\020$\032\0020\004J\016\020%\032\0020\0002\006\020\f\032\0020\004J\030\020&\032\0020\0002\006\020'\032\0020\0042\b\020(\032\004\030\0010\004J\016\020)\032\0020\0002\006\020*\032\0020\004J\016\020+\032\0020\0002\006\020,\032\0020\004J\030\020+\032\0020\0002\006\020,\032\0020\0042\006\020-\032\0020.H\002J\030\020/\032\0020\0002\006\0200\032\0020\0042\b\0201\032\004\030\0010\004J\006\0202\032\00203J\b\0204\032\0020\033H\002J\020\020\003\032\0020\0002\b\020\003\032\004\030\0010\004J\016\020\t\032\0020\0002\006\020\t\032\0020\004J\016\0205\032\0020\0002\006\0205\032\0020\004J\020\0206\032\0020\0002\b\0206\032\004\030\0010\004J\016\020\024\032\0020\0002\006\020\024\032\0020\004J\020\0207\032\0020\0002\b\0207\032\004\030\0010\004J\016\020\027\032\0020\0002\006\020\027\032\0020\004J\020\0208\032\0020.2\006\0209\032\0020\004H\002J\020\020:\032\0020.2\006\0209\032\0020\004H\002J\037\020;\032\0020\0002\b\020<\032\004\030\001032\006\0209\032\0020\004H\000¢\006\002\b=J\016\020>\032\0020\0002\006\020>\032\0020\004J\b\020?\032\0020@H\002J\016\020\032\032\0020\0002\006\020\032\032\0020\033J0\020A\032\0020@2\006\0209\032\0020\0042\006\020B\032\0020\0332\006\020C\032\0020\0332\006\020D\032\0020.2\006\020-\032\0020.H\002J\020\020E\032\0020\0002\b\020E\032\004\030\0010\004J\r\020F\032\0020\000H\000¢\006\002\bGJ\020\020H\032\0020@2\006\020I\032\0020\004H\002J\016\020J\032\0020\0002\006\020'\032\0020\004J\016\020K\032\0020\0002\006\0200\032\0020\004J\016\020L\032\0020\0002\006\020M\032\0020\033J \020N\032\0020@2\006\0209\032\0020\0042\006\020O\032\0020\0332\006\020C\032\0020\033H\002J\016\020 \032\0020\0002\006\020 \032\0020\004J\026\020P\032\0020\0002\006\020M\032\0020\0332\006\020$\032\0020\004J\030\020Q\032\0020\0002\006\020'\032\0020\0042\b\020(\032\004\030\0010\004J\026\020R\032\0020\0002\006\020M\032\0020\0332\006\020*\032\0020\004J\030\020S\032\0020\0002\006\0200\032\0020\0042\b\0201\032\004\030\0010\004J\b\020T\032\0020\004H\026J\016\020U\032\0020\0002\006\020U\032\0020\004R\034\020\003\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\b\022\004\022\0020\0040\rX\004¢\006\b\n\000\032\004\b\016\020\017R$\020\020\032\f\022\006\022\004\030\0010\004\030\0010\rX\016¢\006\016\n\000\032\004\b\021\020\017\"\004\b\022\020\023R\032\020\024\032\0020\004X\016¢\006\016\n\000\032\004\b\025\020\006\"\004\b\026\020\bR\034\020\027\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\030\020\006\"\004\b\031\020\bR\032\020\032\032\0020\033X\016¢\006\016\n\000\032\004\b\034\020\035\"\004\b\036\020\037R\034\020 \032\004\030\0010\004X\016¢\006\016\n\000\032\004\b!\020\006\"\004\b\"\020\b¨\006W"}, d2={"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    public static final Companion Companion = new Companion(null);
    public static final String INVALID_HOST = "Invalid URL host";
    private String encodedFragment;
    private String encodedPassword = "";
    private final List<String> encodedPathSegments;
    private List<String> encodedQueryNamesAndValues;
    private String encodedUsername = "";
    private String host;
    private int port = -1;
    private String scheme;
    
    public Builder()
    {
      List localList = (List)new ArrayList();
      this.encodedPathSegments = localList;
      localList.add("");
    }
    
    private final Builder addPathSegments(String paramString, boolean paramBoolean)
    {
      Builder localBuilder = (Builder)this;
      int i = 0;
      int j;
      do
      {
        j = Util.delimiterOffset(paramString, "/\\", i, paramString.length());
        boolean bool;
        if (j < paramString.length()) {
          bool = true;
        } else {
          bool = false;
        }
        localBuilder.push(paramString, i, j, bool, paramBoolean);
        j += 1;
        i = j;
      } while (j <= paramString.length());
      return localBuilder;
    }
    
    private final int effectivePort()
    {
      int i = this.port;
      if (i != -1) {
        return i;
      }
      HttpUrl.Companion localCompanion = HttpUrl.Companion;
      String str = this.scheme;
      if (str == null) {
        Intrinsics.throwNpe();
      }
      return localCompanion.defaultPort(str);
    }
    
    private final boolean isDot(String paramString)
    {
      boolean bool2 = Intrinsics.areEqual(paramString, ".");
      boolean bool1 = true;
      if (!bool2)
      {
        if (StringsKt.equals(paramString, "%2e", true)) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    
    private final boolean isDotDot(String paramString)
    {
      boolean bool3 = Intrinsics.areEqual(paramString, "..");
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (!StringsKt.equals(paramString, "%2e.", true))
        {
          bool1 = bool2;
          if (!StringsKt.equals(paramString, ".%2e", true))
          {
            if (StringsKt.equals(paramString, "%2e%2e", true)) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    
    private final void pop()
    {
      List localList = this.encodedPathSegments;
      int i;
      if (((CharSequence)localList.remove(localList.size() - 1)).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && ((((Collection)this.encodedPathSegments).isEmpty() ^ true)))
      {
        localList = this.encodedPathSegments;
        localList.set(localList.size() - 1, "");
        return;
      }
      this.encodedPathSegments.add("");
    }
    
    private final void push(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramString = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, false, null, 240, null);
      if (isDot(paramString)) {
        return;
      }
      if (isDotDot(paramString))
      {
        pop();
        return;
      }
      List localList = this.encodedPathSegments;
      if (((CharSequence)localList.get(localList.size() - 1)).length() == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        localList = this.encodedPathSegments;
        localList.set(localList.size() - 1, paramString);
      }
      else
      {
        this.encodedPathSegments.add(paramString);
      }
      if (paramBoolean1) {
        this.encodedPathSegments.add("");
      }
    }
    
    private final void removeAllCanonicalQueryParameters(String paramString)
    {
      Object localObject = this.encodedQueryNamesAndValues;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = RangesKt.step(RangesKt.downTo(((List)localObject).size() - 2, 0), 2);
      int i = ((IntProgression)localObject).getFirst();
      int j = ((IntProgression)localObject).getLast();
      int k = ((IntProgression)localObject).getStep();
      if (k >= 0 ? i <= j : i >= j) {
        for (;;)
        {
          localObject = this.encodedQueryNamesAndValues;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          if (Intrinsics.areEqual(paramString, (String)((List)localObject).get(i)))
          {
            localObject = this.encodedQueryNamesAndValues;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((List)localObject).remove(i + 1);
            localObject = this.encodedQueryNamesAndValues;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((List)localObject).remove(i);
            localObject = this.encodedQueryNamesAndValues;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            if (((List)localObject).isEmpty())
            {
              this.encodedQueryNamesAndValues = ((List)null);
              return;
            }
          }
          if (i == j) {
            break;
          }
          i += k;
        }
      }
    }
    
    private final void resolvePath(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      if ((i != 47) && (i != 92))
      {
        List localList = this.encodedPathSegments;
        localList.set(localList.size() - 1, "");
      }
      else
      {
        this.encodedPathSegments.clear();
        this.encodedPathSegments.add("");
        break label134;
      }
      while (paramInt1 < paramInt2)
      {
        i = Util.delimiterOffset(paramString, "/\\", paramInt1, paramInt2);
        boolean bool;
        if (i < paramInt2) {
          bool = true;
        } else {
          bool = false;
        }
        push(paramString, paramInt1, i, bool, true);
        paramInt1 = i;
        if (bool)
        {
          paramInt1 = i;
          label134:
          paramInt1 += 1;
        }
      }
    }
    
    public final Builder addEncodedPathSegment(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedPathSegment");
      Builder localBuilder = (Builder)this;
      localBuilder.push(paramString, 0, paramString.length(), false, true);
      return localBuilder;
    }
    
    public final Builder addEncodedPathSegments(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedPathSegments");
      return addPathSegments(paramString, true);
    }
    
    public final Builder addEncodedQueryParameter(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "encodedName");
      Builder localBuilder = (Builder)this;
      if (localBuilder.encodedQueryNamesAndValues == null) {
        localBuilder.encodedQueryNamesAndValues = ((List)new ArrayList());
      }
      List localList = localBuilder.encodedQueryNamesAndValues;
      if (localList == null) {
        Intrinsics.throwNpe();
      }
      localList.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString1, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
      localList = localBuilder.encodedQueryNamesAndValues;
      if (localList == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 != null) {
        paramString1 = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null);
      } else {
        paramString1 = null;
      }
      localList.add(paramString1);
      return localBuilder;
    }
    
    public final Builder addPathSegment(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "pathSegment");
      Builder localBuilder = (Builder)this;
      localBuilder.push(paramString, 0, paramString.length(), false, false);
      return localBuilder;
    }
    
    public final Builder addPathSegments(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "pathSegments");
      return addPathSegments(paramString, false);
    }
    
    public final Builder addQueryParameter(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Builder localBuilder = (Builder)this;
      if (localBuilder.encodedQueryNamesAndValues == null) {
        localBuilder.encodedQueryNamesAndValues = ((List)new ArrayList());
      }
      List localList = localBuilder.encodedQueryNamesAndValues;
      if (localList == null) {
        Intrinsics.throwNpe();
      }
      localList.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString1, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
      localList = localBuilder.encodedQueryNamesAndValues;
      if (localList == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 != null) {
        paramString1 = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null);
      } else {
        paramString1 = null;
      }
      localList.add(paramString1);
      return localBuilder;
    }
    
    public final HttpUrl build()
    {
      String str2 = this.scheme;
      if (str2 != null)
      {
        String str3 = HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, null);
        String str4 = HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, null);
        String str5 = this.host;
        if (str5 != null)
        {
          int i = effectivePort();
          List localList2 = HttpUrl.Companion.percentDecode$default(HttpUrl.Companion, this.encodedPathSegments, false, 1, null);
          if (localList2 != null)
          {
            List localList1 = this.encodedQueryNamesAndValues;
            if (localList1 != null) {
              localList1 = HttpUrl.Companion.access$percentDecode(HttpUrl.Companion, localList1, true);
            } else {
              localList1 = null;
            }
            String str1 = this.encodedFragment;
            if (str1 != null) {
              str1 = HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, str1, 0, 0, false, 7, null);
            } else {
              str1 = null;
            }
            return new HttpUrl(str2, str3, str4, str5, i, localList2, localList1, str1, toString());
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        throw ((Throwable)new IllegalStateException("host == null"));
      }
      throw ((Throwable)new IllegalStateException("scheme == null"));
    }
    
    public final Builder encodedFragment(String paramString)
    {
      Builder localBuilder = (Builder)this;
      if (paramString != null) {
        paramString = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, "", true, false, false, true, null, 179, null);
      } else {
        paramString = null;
      }
      localBuilder.encodedFragment = paramString;
      return localBuilder;
    }
    
    public final Builder encodedPassword(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedPassword");
      Builder localBuilder = (Builder)this;
      localBuilder.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
      return localBuilder;
    }
    
    public final Builder encodedPath(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedPath");
      Object localObject = (Builder)this;
      if (StringsKt.startsWith$default(paramString, "/", false, 2, null))
      {
        ((Builder)localObject).resolvePath(paramString, 0, paramString.length());
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected encodedPath: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    public final Builder encodedQuery(String paramString)
    {
      Builder localBuilder = (Builder)this;
      if (paramString != null)
      {
        paramString = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
        if (paramString != null)
        {
          paramString = HttpUrl.Companion.toQueryNamesAndValues$okhttp(paramString);
          break label48;
        }
      }
      paramString = null;
      label48:
      localBuilder.encodedQueryNamesAndValues = paramString;
      return localBuilder;
    }
    
    public final Builder encodedUsername(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedUsername");
      Builder localBuilder = (Builder)this;
      localBuilder.encodedUsername = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
      return localBuilder;
    }
    
    public final Builder fragment(String paramString)
    {
      Builder localBuilder = (Builder)this;
      if (paramString != null) {
        paramString = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, "", false, false, false, true, null, 187, null);
      } else {
        paramString = null;
      }
      localBuilder.encodedFragment = paramString;
      return localBuilder;
    }
    
    public final String getEncodedFragment$okhttp()
    {
      return this.encodedFragment;
    }
    
    public final String getEncodedPassword$okhttp()
    {
      return this.encodedPassword;
    }
    
    public final List<String> getEncodedPathSegments$okhttp()
    {
      return this.encodedPathSegments;
    }
    
    public final List<String> getEncodedQueryNamesAndValues$okhttp()
    {
      return this.encodedQueryNamesAndValues;
    }
    
    public final String getEncodedUsername$okhttp()
    {
      return this.encodedUsername;
    }
    
    public final String getHost$okhttp()
    {
      return this.host;
    }
    
    public final int getPort$okhttp()
    {
      return this.port;
    }
    
    public final String getScheme$okhttp()
    {
      return this.scheme;
    }
    
    public final Builder host(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "host");
      Object localObject = (Builder)this;
      String str = HostnamesKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, paramString, 0, 0, false, 7, null));
      if (str != null)
      {
        ((Builder)localObject).host = str;
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected host: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
    }
    
    public final Builder parse$okhttp(HttpUrl paramHttpUrl, String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "input");
      int i = Util.indexOfFirstNonAsciiWhitespace$default(paramString, 0, 0, 3, null);
      int j = Util.indexOfLastNonAsciiWhitespace$default(paramString, i, 0, 2, null);
      int k = Companion.access$schemeDelimiterOffset(Companion, paramString, i, j);
      Object localObject = "(this as java.lang.Strin…ing(startIndex, endIndex)";
      if (k != -1)
      {
        if (StringsKt.startsWith(paramString, "https:", i, true))
        {
          this.scheme = "https";
          i += 6;
        }
        else if (StringsKt.startsWith(paramString, "http:", i, true))
        {
          this.scheme = "http";
          i += 5;
        }
        else
        {
          paramHttpUrl = new StringBuilder();
          paramHttpUrl.append("Expected URL scheme 'http' or 'https' but was '");
          paramString = paramString.substring(0, k);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          paramHttpUrl.append(paramString);
          paramHttpUrl.append("'");
          throw ((Throwable)new IllegalArgumentException(paramHttpUrl.toString()));
        }
      }
      else
      {
        if (paramHttpUrl == null) {
          break label1035;
        }
        this.scheme = paramHttpUrl.scheme();
      }
      k = Companion.access$slashCount(Companion, paramString, i, j);
      int m;
      if ((k < 2) && (paramHttpUrl != null) && (!(Intrinsics.areEqual(paramHttpUrl.scheme(), this.scheme) ^ true)))
      {
        this.encodedUsername = paramHttpUrl.encodedUsername();
        this.encodedPassword = paramHttpUrl.encodedPassword();
        this.host = paramHttpUrl.host();
        this.port = paramHttpUrl.port();
        this.encodedPathSegments.clear();
        this.encodedPathSegments.addAll((Collection)paramHttpUrl.encodedPathSegments());
        if ((i == j) || (paramString.charAt(i) == '#')) {
          encodedQuery(paramHttpUrl.encodedQuery());
        }
      }
      else
      {
        m = i + k;
        i = 0;
        k = 0;
        paramHttpUrl = (HttpUrl)localObject;
        int i1;
        String str;
        for (;;)
        {
          i1 = Util.delimiterOffset(paramString, "@/\\?#", m, j);
          if (i1 != j) {
            n = paramString.charAt(i1);
          } else {
            n = -1;
          }
          if ((n == -1) || (n == 35) || (n == 47) || (n == 92) || (n == 63)) {
            break;
          }
          if (n == 64)
          {
            if (i == 0)
            {
              n = Util.delimiterOffset(paramString, ':', m, i1);
              str = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, m, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
              localObject = str;
              if (k != 0)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.encodedUsername);
                ((StringBuilder)localObject).append("%40");
                ((StringBuilder)localObject).append(str);
                localObject = ((StringBuilder)localObject).toString();
              }
              this.encodedUsername = ((String)localObject);
              if (n != i1)
              {
                this.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, n + 1, i1, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                i = 1;
              }
              k = 1;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.encodedPassword);
              ((StringBuilder)localObject).append("%40");
              ((StringBuilder)localObject).append(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, m, i1, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
              this.encodedPassword = ((StringBuilder)localObject).toString();
            }
            m = i1 + 1;
          }
        }
        k = Companion.access$portColonOffset(Companion, paramString, m, i1);
        int n = k + 1;
        if (n < i1)
        {
          this.host = HostnamesKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, paramString, m, k, false, 4, null));
          i = Companion.access$parsePort(Companion, paramString, n, i1);
          this.port = i;
          if (i != -1) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Invalid URL port: \"");
            paramString = paramString.substring(n, i1);
            Intrinsics.checkExpressionValueIsNotNull(paramString, paramHttpUrl);
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append('"');
            throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
          }
        }
        else
        {
          this.host = HostnamesKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, paramString, m, k, false, 4, null));
          localObject = HttpUrl.Companion;
          str = this.scheme;
          if (str == null) {
            Intrinsics.throwNpe();
          }
          this.port = ((HttpUrl.Companion)localObject).defaultPort(str);
        }
        if (this.host != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          break label969;
        }
        i = i1;
      }
      k = Util.delimiterOffset(paramString, "?#", i, j);
      resolvePath(paramString, i, k);
      i = k;
      if (k < j)
      {
        i = k;
        if (paramString.charAt(k) == '?')
        {
          i = Util.delimiterOffset(paramString, '#', k, j);
          this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, k + 1, i, " \"'<>#", true, false, true, false, null, 208, null));
        }
      }
      if ((i < j) && (paramString.charAt(i) == '#')) {
        this.encodedFragment = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, i + 1, j, "", true, false, false, true, null, 176, null);
      }
      return this;
      label969:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid URL host: \"");
      paramString = paramString.substring(m, k);
      Intrinsics.checkExpressionValueIsNotNull(paramString, paramHttpUrl);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('"');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
      label1035:
      throw ((Throwable)new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found"));
    }
    
    public final Builder password(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "password");
      Builder localBuilder = (Builder)this;
      localBuilder.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
      return localBuilder;
    }
    
    public final Builder port(int paramInt)
    {
      Object localObject = (Builder)this;
      int i = 1;
      if ((1 > paramInt) || (65535 < paramInt)) {
        i = 0;
      }
      if (i != 0)
      {
        ((Builder)localObject).port = paramInt;
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected port: ");
      ((StringBuilder)localObject).append(paramInt);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    public final Builder query(String paramString)
    {
      Builder localBuilder = (Builder)this;
      if (paramString != null)
      {
        paramString = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"'<>#", false, false, true, false, null, 219, null);
        if (paramString != null)
        {
          paramString = HttpUrl.Companion.toQueryNamesAndValues$okhttp(paramString);
          break label48;
        }
      }
      paramString = null;
      label48:
      localBuilder.encodedQueryNamesAndValues = paramString;
      return localBuilder;
    }
    
    public final Builder reencodeForUri$okhttp()
    {
      Builder localBuilder = (Builder)this;
      Object localObject1 = localBuilder.host;
      Object localObject2 = null;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        localObject1 = new Regex("[\"<>^`{|}]").replace((CharSequence)localObject1, "");
      }
      else
      {
        localObject1 = null;
      }
      localBuilder.host = ((String)localObject1);
      int k = localBuilder.encodedPathSegments.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        localBuilder.encodedPathSegments.set(i, HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String)localBuilder.encodedPathSegments.get(i), 0, 0, "[]", true, true, false, false, null, 227, null));
        i += 1;
      }
      Object localObject3 = localBuilder.encodedQueryNamesAndValues;
      if (localObject3 != null)
      {
        k = ((List)localObject3).size();
        i = j;
        while (i < k)
        {
          localObject1 = (String)((List)localObject3).get(i);
          if (localObject1 != null) {
            localObject1 = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String)localObject1, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null);
          } else {
            localObject1 = null;
          }
          ((List)localObject3).set(i, localObject1);
          i += 1;
        }
      }
      localObject3 = localBuilder.encodedFragment;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String)localObject3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
      }
      localBuilder.encodedFragment = ((String)localObject1);
      return localBuilder;
    }
    
    public final Builder removeAllEncodedQueryParameters(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedName");
      Builder localBuilder = (Builder)this;
      if (localBuilder.encodedQueryNamesAndValues == null) {
        return localBuilder;
      }
      localBuilder.removeAllCanonicalQueryParameters(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
      return localBuilder;
    }
    
    public final Builder removeAllQueryParameters(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Builder localBuilder = (Builder)this;
      if (localBuilder.encodedQueryNamesAndValues == null) {
        return localBuilder;
      }
      localBuilder.removeAllCanonicalQueryParameters(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
      return localBuilder;
    }
    
    public final Builder removePathSegment(int paramInt)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.encodedPathSegments.remove(paramInt);
      if (localBuilder.encodedPathSegments.isEmpty()) {
        localBuilder.encodedPathSegments.add("");
      }
      return localBuilder;
    }
    
    public final Builder scheme(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "scheme");
      Object localObject = (Builder)this;
      if (StringsKt.equals(paramString, "http", true))
      {
        ((Builder)localObject).scheme = "http";
        return (Builder)localObject;
      }
      if (StringsKt.equals(paramString, "https", true))
      {
        ((Builder)localObject).scheme = "https";
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected scheme: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
    }
    
    public final void setEncodedFragment$okhttp(String paramString)
    {
      this.encodedFragment = paramString;
    }
    
    public final void setEncodedPassword$okhttp(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
      this.encodedPassword = paramString;
    }
    
    public final Builder setEncodedPathSegment(int paramInt, String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "encodedPathSegment");
      Object localObject = (Builder)this;
      String str = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"<>^`{}|/\\?#", true, false, false, false, null, 243, null);
      ((Builder)localObject).encodedPathSegments.set(paramInt, str);
      if ((!((Builder)localObject).isDot(str)) && (!((Builder)localObject).isDotDot(str))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected path segment: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    public final void setEncodedQueryNamesAndValues$okhttp(List<String> paramList)
    {
      this.encodedQueryNamesAndValues = paramList;
    }
    
    public final Builder setEncodedQueryParameter(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "encodedName");
      Builder localBuilder = (Builder)this;
      localBuilder.removeAllEncodedQueryParameters(paramString1);
      localBuilder.addEncodedQueryParameter(paramString1, paramString2);
      return localBuilder;
    }
    
    public final void setEncodedUsername$okhttp(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
      this.encodedUsername = paramString;
    }
    
    public final void setHost$okhttp(String paramString)
    {
      this.host = paramString;
    }
    
    public final Builder setPathSegment(int paramInt, String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "pathSegment");
      Object localObject = (Builder)this;
      String str = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"<>^`{}|/\\?#", false, false, false, false, null, 251, null);
      int i;
      if ((!((Builder)localObject).isDot(str)) && (!((Builder)localObject).isDotDot(str))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        ((Builder)localObject).encodedPathSegments.set(paramInt, str);
        return (Builder)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected path segment: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    public final void setPort$okhttp(int paramInt)
    {
      this.port = paramInt;
    }
    
    public final Builder setQueryParameter(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Builder localBuilder = (Builder)this;
      localBuilder.removeAllQueryParameters(paramString1);
      localBuilder.addQueryParameter(paramString1, paramString2);
      return localBuilder;
    }
    
    public final void setScheme$okhttp(String paramString)
    {
      this.scheme = paramString;
    }
    
    public String toString()
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = this.scheme;
      if (localObject2 != null)
      {
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("://");
      }
      else
      {
        ((StringBuilder)localObject1).append("//");
      }
      int i = ((CharSequence)this.encodedUsername).length();
      int j = 1;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        if (((CharSequence)this.encodedPassword).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {}
      }
      else
      {
        ((StringBuilder)localObject1).append(this.encodedUsername);
        if (((CharSequence)this.encodedPassword).length() > 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          ((StringBuilder)localObject1).append(':');
          ((StringBuilder)localObject1).append(this.encodedPassword);
        }
        ((StringBuilder)localObject1).append('@');
      }
      localObject2 = this.host;
      if (localObject2 != null)
      {
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if (StringsKt.contains$default((CharSequence)localObject2, ':', false, 2, null))
        {
          ((StringBuilder)localObject1).append('[');
          ((StringBuilder)localObject1).append(this.host);
          ((StringBuilder)localObject1).append(']');
        }
        else
        {
          ((StringBuilder)localObject1).append(this.host);
        }
      }
      Object localObject3;
      if ((this.port != -1) || (this.scheme != null))
      {
        i = effectivePort();
        if (this.scheme != null)
        {
          localObject2 = HttpUrl.Companion;
          localObject3 = this.scheme;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          if (i == ((HttpUrl.Companion)localObject2).defaultPort((String)localObject3)) {}
        }
        else
        {
          ((StringBuilder)localObject1).append(':');
          ((StringBuilder)localObject1).append(i);
        }
      }
      HttpUrl.Companion.toPathString$okhttp(this.encodedPathSegments, (StringBuilder)localObject1);
      if (this.encodedQueryNamesAndValues != null)
      {
        ((StringBuilder)localObject1).append('?');
        localObject2 = HttpUrl.Companion;
        localObject3 = this.encodedQueryNamesAndValues;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((HttpUrl.Companion)localObject2).toQueryString$okhttp((List)localObject3, (StringBuilder)localObject1);
      }
      if (this.encodedFragment != null)
      {
        ((StringBuilder)localObject1).append('#');
        ((StringBuilder)localObject1).append(this.encodedFragment);
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
      return (String)localObject1;
    }
    
    public final Builder username(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "username");
      Builder localBuilder = (Builder)this;
      localBuilder.encodedUsername = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
      return localBuilder;
    }
    
    @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020\b\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J \020\005\032\0020\0062\006\020\007\032\0020\0042\006\020\b\032\0020\0062\006\020\t\032\0020\006H\002J \020\n\032\0020\0062\006\020\007\032\0020\0042\006\020\b\032\0020\0062\006\020\t\032\0020\006H\002J \020\013\032\0020\0062\006\020\007\032\0020\0042\006\020\b\032\0020\0062\006\020\t\032\0020\006H\002J\034\020\f\032\0020\006*\0020\0042\006\020\b\032\0020\0062\006\020\t\032\0020\006H\002R\016\020\003\032\0020\004XT¢\006\002\n\000¨\006\r"}, d2={"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k=1, mv={1, 1, 16})
    public static final class Companion
    {
      private final int parsePort(String paramString, int paramInt1, int paramInt2)
      {
        int i = -1;
        try
        {
          paramInt2 = Integer.parseInt(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString, paramInt1, paramInt2, "", false, false, false, false, null, 248, null));
          if (1 > paramInt2) {
            return -1;
          }
          paramInt1 = i;
          if (65535 >= paramInt2) {
            paramInt1 = paramInt2;
          }
          return paramInt1;
        }
        catch (NumberFormatException paramString) {}
        return -1;
      }
      
      private final int portColonOffset(String paramString, int paramInt1, int paramInt2)
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
      
      private final int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
      {
        int j = -1;
        if (paramInt2 - paramInt1 < 2) {
          return -1;
        }
        int k = paramString.charAt(paramInt1);
        if (k >= 97)
        {
          i = paramInt1;
          if (k <= 122) {}
        }
        else
        {
          i = j;
          if (k < 65) {
            break label187;
          }
          i = paramInt1;
          if (k > 90) {
            return -1;
          }
        }
        for (;;)
        {
          paramInt1 = i + 1;
          i = j;
          if (paramInt1 >= paramInt2) {
            break label187;
          }
          k = paramString.charAt(paramInt1);
          if (((97 > k) || (122 < k)) && ((65 > k) || (90 < k)) && ((48 > k) || (57 < k)) && (k != 43) && (k != 45) && (k != 46)) {
            break;
          }
          i = paramInt1;
        }
        int i = j;
        if (k == 58) {
          i = paramInt1;
        }
        label187:
        return i;
      }
      
      private final int slashCount(String paramString, int paramInt1, int paramInt2)
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
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000t\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\031\n\002\b\t\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\020\013\n\002\b\004\n\002\030\002\n\002\b\004\n\002\020 \n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\b\004\n\002\030\002\n\002\b\004\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\021\032\0020\0222\006\020\023\032\0020\004H\007J\027\020\024\032\004\030\0010\0252\006\020\026\032\0020\027H\007¢\006\002\b\030J\027\020\024\032\004\030\0010\0252\006\020\031\032\0020\032H\007¢\006\002\b\030J\025\020\024\032\0020\0252\006\020\031\032\0020\004H\007¢\006\002\b\030J\027\020\033\032\004\030\0010\0252\006\020\031\032\0020\004H\007¢\006\002\b\034Ja\020\035\032\0020\004*\0020\0042\b\b\002\020\036\032\0020\0222\b\b\002\020\037\032\0020\0222\006\020 \032\0020\0042\b\b\002\020!\032\0020\"2\b\b\002\020#\032\0020\"2\b\b\002\020$\032\0020\"2\b\b\002\020%\032\0020\"2\n\b\002\020&\032\004\030\0010'H\000¢\006\002\b(J\034\020)\032\0020\"*\0020\0042\006\020\036\032\0020\0222\006\020\037\032\0020\022H\002J/\020*\032\0020\004*\0020\0042\b\b\002\020\036\032\0020\0222\b\b\002\020\037\032\0020\0222\b\b\002\020$\032\0020\"H\000¢\006\002\b+J&\020*\032\n\022\006\022\004\030\0010\0040,*\n\022\006\022\004\030\0010\0040,2\b\b\002\020$\032\0020\"H\002J\021\020-\032\0020\025*\0020\004H\007¢\006\002\b\024J\023\020.\032\004\030\0010\025*\0020\027H\007¢\006\002\b\024J\023\020.\032\004\030\0010\025*\0020\032H\007¢\006\002\b\024J\023\020.\032\004\030\0010\025*\0020\004H\007¢\006\002\b\033J#\020/\032\00200*\b\022\004\022\0020\0040,2\n\0201\032\00602j\002`3H\000¢\006\002\b4J\031\0205\032\n\022\006\022\004\030\0010\00406*\0020\004H\000¢\006\002\b7J%\0208\032\00200*\n\022\006\022\004\030\0010\0040,2\n\0201\032\00602j\002`3H\000¢\006\002\b9JV\020:\032\00200*\0020;2\006\020<\032\0020\0042\006\020\036\032\0020\0222\006\020\037\032\0020\0222\006\020 \032\0020\0042\006\020!\032\0020\"2\006\020#\032\0020\"2\006\020$\032\0020\"2\006\020%\032\0020\"2\b\020&\032\004\030\0010'H\002J,\020=\032\00200*\0020;2\006\020>\032\0020\0042\006\020\036\032\0020\0222\006\020\037\032\0020\0222\006\020$\032\0020\"H\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004XT¢\006\002\n\000R\016\020\n\032\0020\004XT¢\006\002\n\000R\016\020\013\032\0020\004XT¢\006\002\n\000R\016\020\f\032\0020\004XT¢\006\002\n\000R\016\020\r\032\0020\004XT¢\006\002\n\000R\016\020\016\032\0020\004XT¢\006\002\n\000R\016\020\017\032\0020\004XT¢\006\002\n\000R\016\020\020\032\0020\004XT¢\006\002\n\000¨\006?"}, d2={"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", "get", "Lokhttp3/HttpUrl;", "uri", "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final boolean isPercentEncoded(String paramString, int paramInt1, int paramInt2)
    {
      int i = paramInt1 + 2;
      return (i < paramInt2) && (paramString.charAt(paramInt1) == '%') && (Util.parseHexDigit(paramString.charAt(paramInt1 + 1)) != -1) && (Util.parseHexDigit(paramString.charAt(i)) != -1);
    }
    
    private final List<String> percentDecode(List<String> paramList, boolean paramBoolean)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        if (paramList != null) {
          paramList = percentDecode$okhttp$default((Companion)this, paramList, 0, 0, paramBoolean, 3, null);
        } else {
          paramList = null;
        }
        localArrayList.add(paramList);
      }
      paramList = Collections.unmodifiableList((List)localArrayList);
      Intrinsics.checkExpressionValueIsNotNull(paramList, "Collections.unmodifiableList(result)");
      return paramList;
    }
    
    private final void writeCanonicalized(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
    {
      Object localObject1 = (Buffer)null;
      while (paramInt1 < paramInt2) {
        if (paramString1 != null)
        {
          int i = paramString1.codePointAt(paramInt1);
          Object localObject3;
          if (paramBoolean1)
          {
            localObject3 = localObject1;
            if (i != 9)
            {
              localObject3 = localObject1;
              if (i != 10)
              {
                localObject3 = localObject1;
                if (i != 12)
                {
                  localObject3 = localObject1;
                  if (i == 13) {}
                }
              }
            }
          }
          else
          {
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
            else if ((i >= 32) && (i != 127) && ((i < 128) || (paramBoolean4)) && (!StringsKt.contains$default((CharSequence)paramString2, (char)i, false, 2, null)) && ((i != 37) || ((paramBoolean1) && ((!paramBoolean2) || (((Companion)this).isPercentEncoded(paramString1, paramInt1, paramInt2))))))
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
              if ((paramCharset != null) && (!Intrinsics.areEqual(paramCharset, StandardCharsets.UTF_8))) {
                ((Buffer)localObject2).writeString(paramString1, paramInt1, Character.charCount(i) + paramInt1, paramCharset);
              } else {
                ((Buffer)localObject2).writeUtf8CodePoint(i);
              }
              for (;;)
              {
                localObject3 = localObject2;
                if (((Buffer)localObject2).exhausted()) {
                  break;
                }
                int j = ((Buffer)localObject2).readByte() & 0xFF;
                paramBuffer.writeByte(37);
                paramBuffer.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[(j >> 4 & 0xF)]);
                paramBuffer.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[(j & 0xF)]);
              }
            }
          }
          paramInt1 += Character.charCount(i);
          localObject1 = localObject3;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    
    private final void writePercentDecoded(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      while (paramInt1 < paramInt2) {
        if (paramString != null)
        {
          int i = paramString.codePointAt(paramInt1);
          if (i == 37)
          {
            int j = paramInt1 + 2;
            if (j < paramInt2)
            {
              int k = Util.parseHexDigit(paramString.charAt(paramInt1 + 1));
              int m = Util.parseHexDigit(paramString.charAt(j));
              if ((k == -1) || (m == -1)) {
                break label121;
              }
              paramBuffer.writeByte((k << 4) + m);
              paramInt1 = Character.charCount(i) + j;
              continue;
            }
          }
          if ((i == 43) && (paramBoolean))
          {
            paramBuffer.writeByte(32);
            paramInt1 += 1;
          }
          else
          {
            label121:
            paramBuffer.writeUtf8CodePoint(i);
            paramInt1 += Character.charCount(i);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrl()", imports={"okhttp3.HttpUrl.Companion.toHttpUrl"}))
    public final HttpUrl -deprecated_get(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "url");
      return ((Companion)this).get(paramString);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="uri.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
    public final HttpUrl -deprecated_get(URI paramURI)
    {
      Intrinsics.checkParameterIsNotNull(paramURI, "uri");
      return ((Companion)this).get(paramURI);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
    public final HttpUrl -deprecated_get(URL paramURL)
    {
      Intrinsics.checkParameterIsNotNull(paramURL, "url");
      return ((Companion)this).get(paramURL);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
    public final HttpUrl -deprecated_parse(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "url");
      return ((Companion)this).parse(paramString);
    }
    
    public final String canonicalize$okhttp(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "$this$canonicalize");
      Intrinsics.checkParameterIsNotNull(paramString2, "encodeSet");
      int i = paramInt1;
      while (i < paramInt2)
      {
        int j = paramString1.codePointAt(i);
        if ((j >= 32) && (j != 127) && ((j < 128) || (paramBoolean4)) && (!StringsKt.contains$default((CharSequence)paramString2, (char)j, false, 2, null)) && ((j != 37) || ((paramBoolean1) && ((!paramBoolean2) || (((Companion)this).isPercentEncoded(paramString1, i, paramInt2))))) && ((j != 43) || (!paramBoolean3)))
        {
          i += Character.charCount(j);
        }
        else
        {
          Buffer localBuffer = new Buffer();
          localBuffer.writeUtf8(paramString1, paramInt1, i);
          ((Companion)this).writeCanonicalized(localBuffer, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
          return localBuffer.readUtf8();
        }
      }
      paramString1 = paramString1.substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString1;
    }
    
    @JvmStatic
    public final int defaultPort(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "scheme");
      int i = paramString.hashCode();
      if (i != 3213448)
      {
        if ((i == 99617003) && (paramString.equals("https"))) {
          return 443;
        }
      }
      else if (paramString.equals("http")) {
        return 80;
      }
      return -1;
    }
    
    @JvmStatic
    public final HttpUrl get(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toHttpUrl");
      return new HttpUrl.Builder().parse$okhttp(null, paramString).build();
    }
    
    @JvmStatic
    public final HttpUrl get(URI paramURI)
    {
      Intrinsics.checkParameterIsNotNull(paramURI, "$this$toHttpUrlOrNull");
      Companion localCompanion = (Companion)this;
      paramURI = paramURI.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramURI, "toString()");
      return localCompanion.parse(paramURI);
    }
    
    @JvmStatic
    public final HttpUrl get(URL paramURL)
    {
      Intrinsics.checkParameterIsNotNull(paramURL, "$this$toHttpUrlOrNull");
      Companion localCompanion = (Companion)this;
      paramURL = paramURL.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramURL, "toString()");
      return localCompanion.parse(paramURL);
    }
    
    @JvmStatic
    public final HttpUrl parse(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toHttpUrlOrNull");
      try
      {
        paramString = ((Companion)this).get(paramString);
        return paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;) {}
      }
      return null;
    }
    
    public final String percentDecode$okhttp(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$percentDecode");
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
          ((Companion)this).writePercentDecoded(localBuffer, paramString, i, paramInt2, paramBoolean);
          return localBuffer.readUtf8();
        }
      }
      paramString = paramString.substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString;
    }
    
    public final void toPathString$okhttp(List<String> paramList, StringBuilder paramStringBuilder)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "$this$toPathString");
      Intrinsics.checkParameterIsNotNull(paramStringBuilder, "out");
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramStringBuilder.append('/');
        paramStringBuilder.append((String)paramList.get(i));
        i += 1;
      }
    }
    
    public final List<String> toQueryNamesAndValues$okhttp(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toQueryNamesAndValues");
      List localList = (List)new ArrayList();
      int j;
      for (int i = 0; i <= paramString.length(); i = j + 1)
      {
        Object localObject = (CharSequence)paramString;
        int k = StringsKt.indexOf$default((CharSequence)localObject, '&', i, false, 4, null);
        j = k;
        if (k == -1) {
          j = paramString.length();
        }
        k = StringsKt.indexOf$default((CharSequence)localObject, '=', i, false, 4, null);
        if ((k != -1) && (k <= j))
        {
          localObject = paramString.substring(i, k);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localList.add(localObject);
          localObject = paramString.substring(k + 1, j);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localList.add(localObject);
        }
        else
        {
          localObject = paramString.substring(i, j);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localList.add(localObject);
          localList.add(null);
        }
      }
      return localList;
    }
    
    public final void toQueryString$okhttp(List<String> paramList, StringBuilder paramStringBuilder)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "$this$toQueryString");
      Intrinsics.checkParameterIsNotNull(paramStringBuilder, "out");
      Object localObject = RangesKt.step((IntProgression)RangesKt.until(0, paramList.size()), 2);
      int i = ((IntProgression)localObject).getFirst();
      int j = ((IntProgression)localObject).getLast();
      int k = ((IntProgression)localObject).getStep();
      if (k >= 0 ? i <= j : i >= j) {
        for (;;)
        {
          localObject = (String)paramList.get(i);
          String str = (String)paramList.get(i + 1);
          if (i > 0) {
            paramStringBuilder.append('&');
          }
          paramStringBuilder.append((String)localObject);
          if (str != null)
          {
            paramStringBuilder.append('=');
            paramStringBuilder.append(str);
          }
          if (i == j) {
            break;
          }
          i += k;
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\HttpUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */