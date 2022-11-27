package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Headers.Companion;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Companion;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.RequestBody.Companion;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody.Companion;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ByteString.Companion;
import okio.Options;
import okio.Options.Companion;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\000\002\n\000\n\002\020\022\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\016\n\000\n\002\020\b\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\005\n\002\020\021\n\002\020\000\n\002\b\003\n\002\030\002\n\000\n\002\020 \n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\020!\n\002\b\003\n\002\020\005\n\000\n\002\020\n\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\f\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020$\n\002\b\b\n\002\030\002\n\002\b\002\032 \020\022\032\0020\0232\006\020\024\032\0020\0212\006\020\025\032\0020\0262\b\020\027\032\004\030\0010\030\032\036\020\031\032\0020\0322\006\020\033\032\0020\0262\006\020\034\032\0020\0262\006\020\035\032\0020\026\032'\020\036\032\0020\0212\006\020\036\032\0020\0212\022\020\037\032\n\022\006\b\001\022\0020!0 \"\0020!¢\006\002\020\"\032\027\020#\032\0020\0322\f\020$\032\b\022\004\022\0020\0320%H\b\032-\020&\032\b\022\004\022\002H(0'\"\004\b\000\020(2\022\020)\032\n\022\006\b\001\022\002H(0 \"\002H(H\007¢\006\002\020*\0321\020+\032\004\030\001H(\"\004\b\000\020(2\006\020,\032\0020!2\f\020-\032\b\022\004\022\002H(0.2\006\020/\032\0020\021¢\006\002\0200\032\026\0201\032\002022\006\020\024\032\0020\0212\006\0203\032\0020\017\032\037\0204\032\0020\0322\006\020\024\032\0020\0212\f\020$\032\b\022\004\022\0020\0320%H\b\032%\0205\032\0020\032\"\004\b\000\0206*\b\022\004\022\002H6072\006\0208\032\002H6H\000¢\006\002\0209\032\025\020:\032\0020\023*\0020;2\006\020<\032\0020\023H\004\032\025\020:\032\0020\026*\0020\0232\006\020<\032\0020\026H\004\032\025\020:\032\0020\023*\0020=2\006\020<\032\0020\023H\004\032\n\020>\032\0020?*\0020@\032\r\020A\032\0020\032*\0020!H\b\032\r\020B\032\0020\032*\0020!H\b\032\n\020C\032\0020\017*\0020\021\032\022\020D\032\0020\017*\0020E2\006\020F\032\0020E\032\n\020G\032\0020\032*\0020H\032\n\020G\032\0020\032*\0020I\032\n\020G\032\0020\032*\0020J\032#\020K\032\b\022\004\022\0020\0210 *\b\022\004\022\0020\0210 2\006\020L\032\0020\021¢\006\002\020M\032&\020N\032\0020\023*\0020\0212\006\020O\032\0020P2\b\b\002\020Q\032\0020\0232\b\b\002\020R\032\0020\023\032&\020N\032\0020\023*\0020\0212\006\020S\032\0020\0212\b\b\002\020Q\032\0020\0232\b\b\002\020R\032\0020\023\032\032\020T\032\0020\017*\0020U2\006\020V\032\0020\0232\006\020W\032\0020\030\0325\020X\032\0020\017*\b\022\004\022\0020\0210 2\016\020F\032\n\022\004\022\0020\021\030\0010 2\016\020Y\032\n\022\006\b\000\022\0020\0210Z¢\006\002\020[\032\n\020\\\032\0020\026*\0020]\032+\020^\032\0020\023*\b\022\004\022\0020\0210 2\006\020L\032\0020\0212\f\020Y\032\b\022\004\022\0020\0210Z¢\006\002\020_\032\n\020`\032\0020\023*\0020\021\032\036\020a\032\0020\023*\0020\0212\b\b\002\020Q\032\0020\0232\b\b\002\020R\032\0020\023\032\036\020b\032\0020\023*\0020\0212\b\b\002\020Q\032\0020\0232\b\b\002\020R\032\0020\023\032\024\020c\032\0020\023*\0020\0212\b\b\002\020Q\032\0020\023\0329\020d\032\b\022\004\022\0020\0210 *\b\022\004\022\0020\0210 2\f\020F\032\b\022\004\022\0020\0210 2\016\020Y\032\n\022\006\b\000\022\0020\0210Z¢\006\002\020e\032\022\020f\032\0020\017*\0020J2\006\020g\032\0020h\032\r\020i\032\0020\032*\0020!H\b\032\r\020j\032\0020\032*\0020!H\b\032\n\020k\032\0020\023*\0020P\032\n\020l\032\0020\021*\0020J\032\022\020m\032\0020n*\0020h2\006\020o\032\0020n\032\n\020p\032\0020\023*\0020h\032\022\020q\032\0020\023*\0020r2\006\020s\032\0020;\032\032\020q\032\0020\017*\0020U2\006\020\025\032\0020\0232\006\020W\032\0020\030\032\020\020t\032\b\022\004\022\0020u0'*\0020\003\032\020\020v\032\0020\003*\b\022\004\022\0020u0'\032\n\020w\032\0020\021*\0020\023\032\n\020w\032\0020\021*\0020\026\032\024\020x\032\0020\021*\0020E2\b\b\002\020y\032\0020\017\032\034\020z\032\b\022\004\022\002H(0'\"\004\b\000\020(*\b\022\004\022\002H(0'\032.\020{\032\016\022\004\022\002H}\022\004\022\002H~0|\"\004\b\000\020}\"\004\b\001\020~*\016\022\004\022\002H}\022\004\022\002H~0|\032\023\020\032\0020\026*\0020\0212\007\020\001\032\0020\026\032\026\020\001\032\0020\023*\004\030\0010\0212\007\020\001\032\0020\023\032\037\020\001\032\0020\021*\0020\0212\b\b\002\020Q\032\0020\0232\b\b\002\020R\032\0020\023\032\016\020\001\032\0020\032*\0020!H\b\032\025\020\001\032\0020\032*\0030\0012\007\020\001\032\0020\023\"\020\020\000\032\0020\0018\006X\004¢\006\002\n\000\"\020\020\002\032\0020\0038\006X\004¢\006\002\n\000\"\020\020\004\032\0020\0058\006X\004¢\006\002\n\000\"\020\020\006\032\0020\0078\006X\004¢\006\002\n\000\"\016\020\b\032\0020\tX\004¢\006\002\n\000\"\020\020\n\032\0020\0138\006X\004¢\006\002\n\000\"\016\020\f\032\0020\rX\004¢\006\002\n\000\"\020\020\016\032\0020\0178\000X\004¢\006\002\n\000\"\020\020\020\032\0020\0218\000X\004¢\006\002\n\000¨\006\001"}, d2={"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", "T", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", "timeout", "timeUnit", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", "V", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, k=2, mv={1, 1, 16})
public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
  public static final RequestBody EMPTY_REQUEST;
  public static final ResponseBody EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, EMPTY_BYTE_ARRAY, null, 1, null);
  private static final Options UNICODE_BOMS;
  public static final TimeZone UTC;
  private static final Regex VERIFY_AS_IP_ADDRESS;
  public static final boolean assertionsEnabled;
  public static final String okHttpName;
  
  static
  {
    EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, EMPTY_BYTE_ARRAY, null, 0, 0, 7, null);
    UNICODE_BOMS = Options.Companion.of(new ByteString[] { ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000") });
    Object localObject = TimeZone.getTimeZone("GMT");
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    UTC = (TimeZone)localObject;
    VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    assertionsEnabled = OkHttpClient.class.desiredAssertionStatus();
    localObject = OkHttpClient.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "OkHttpClient::class.java.name");
    okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix((String)localObject, (CharSequence)"okhttp3."), (CharSequence)"Client");
  }
  
  public static final <E> void addIfAbsent(List<E> paramList, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$addIfAbsent");
    if (!paramList.contains(paramE)) {
      paramList.add(paramE);
    }
  }
  
  public static final int and(byte paramByte, int paramInt)
  {
    return paramByte & paramInt;
  }
  
  public static final int and(short paramShort, int paramInt)
  {
    return paramShort & paramInt;
  }
  
  public static final long and(int paramInt, long paramLong)
  {
    return paramInt & paramLong;
  }
  
  public static final EventListener.Factory asFactory(EventListener paramEventListener)
  {
    Intrinsics.checkParameterIsNotNull(paramEventListener, "$this$asFactory");
    (EventListener.Factory)new EventListener.Factory()
    {
      public EventListener create(Call paramAnonymousCall)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        return this.$this_asFactory;
      }
    };
  }
  
  public static final void assertThreadDoesntHoldLock(Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "$this$assertThreadDoesntHoldLock");
    if (assertionsEnabled)
    {
      if (!Thread.holdsLock(paramObject)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      localStringBuilder.append(localThread.getName());
      localStringBuilder.append(" MUST NOT hold lock on ");
      localStringBuilder.append(paramObject);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
  }
  
  public static final void assertThreadHoldsLock(Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "$this$assertThreadHoldsLock");
    if (assertionsEnabled)
    {
      if (Thread.holdsLock(paramObject)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      localStringBuilder.append(localThread.getName());
      localStringBuilder.append(" MUST hold lock on ");
      localStringBuilder.append(paramObject);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
  }
  
  public static final boolean canParseAsIpAddress(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$canParseAsIpAddress");
    return VERIFY_AS_IP_ADDRESS.matches((CharSequence)paramString);
  }
  
  public static final boolean canReuseConnectionFor(HttpUrl paramHttpUrl1, HttpUrl paramHttpUrl2)
  {
    Intrinsics.checkParameterIsNotNull(paramHttpUrl1, "$this$canReuseConnectionFor");
    Intrinsics.checkParameterIsNotNull(paramHttpUrl2, "other");
    return (Intrinsics.areEqual(paramHttpUrl1.host(), paramHttpUrl2.host())) && (paramHttpUrl1.port() == paramHttpUrl2.port()) && (Intrinsics.areEqual(paramHttpUrl1.scheme(), paramHttpUrl2.scheme()));
  }
  
  public static final int checkDuration(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    int j = 1;
    boolean bool = paramLong < 0L;
    int i;
    if (!bool) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramTimeUnit != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong <= Integer.MAX_VALUE) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i = j;
          if (paramLong == 0L) {
            if (!bool) {
              i = j;
            } else {
              i = 0;
            }
          }
          if (i != 0) {
            return (int)paramLong;
          }
          paramTimeUnit = new StringBuilder();
          paramTimeUnit.append(paramString);
          paramTimeUnit.append(" too small.");
          throw ((Throwable)new IllegalArgumentException(paramTimeUnit.toString().toString()));
        }
        paramTimeUnit = new StringBuilder();
        paramTimeUnit.append(paramString);
        paramTimeUnit.append(" too large.");
        throw ((Throwable)new IllegalArgumentException(paramTimeUnit.toString().toString()));
      }
      throw ((Throwable)new IllegalStateException("unit == null".toString()));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append(paramString);
    paramTimeUnit.append(" < 0");
    throw ((Throwable)new IllegalStateException(paramTimeUnit.toString().toString()));
  }
  
  public static final void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    throw ((Throwable)new ArrayIndexOutOfBoundsException());
  }
  
  public static final void closeQuietly(Closeable paramCloseable)
  {
    Intrinsics.checkParameterIsNotNull(paramCloseable, "$this$closeQuietly");
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw ((Throwable)paramCloseable);
    }
    catch (Exception paramCloseable) {}
  }
  
  public static final void closeQuietly(ServerSocket paramServerSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramServerSocket, "$this$closeQuietly");
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException paramServerSocket)
    {
      throw ((Throwable)paramServerSocket);
    }
    catch (Exception paramServerSocket) {}
  }
  
  public static final void closeQuietly(Socket paramSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "$this$closeQuietly");
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException paramSocket)
    {
      throw ((Throwable)paramSocket);
    }
    catch (AssertionError paramSocket)
    {
      throw ((Throwable)paramSocket);
    }
    catch (Exception paramSocket) {}
  }
  
  public static final String[] concat(String[] paramArrayOfString, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "$this$concat");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    paramArrayOfString = Arrays.copyOf(paramArrayOfString, paramArrayOfString.length + 1);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfString, "java.util.Arrays.copyOf(this, newSize)");
    paramArrayOfString = (String[])paramArrayOfString;
    paramArrayOfString[kotlin.collections.ArraysKt.getLastIndex(paramArrayOfString)] = paramString;
    if (paramArrayOfString != null) {
      return paramArrayOfString;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
  }
  
  public static final int delimiterOffset(String paramString, char paramChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$delimiterOffset");
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static final int delimiterOffset(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$delimiterOffset");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiters");
    while (paramInt1 < paramInt2)
    {
      if (StringsKt.contains$default((CharSequence)paramString2, paramString1.charAt(paramInt1), false, 2, null)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static final boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "$this$discard");
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "timeUnit");
    try
    {
      boolean bool = skipAll(paramSource, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static final String format(String paramString, Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "format");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = Locale.US;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.US");
    paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
    paramString = String.format((Locale)localObject, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(locale, format, *args)");
    return paramString;
  }
  
  public static final boolean hasIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2, Comparator<? super String> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString1, "$this$hasIntersection");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    int i;
    if (paramArrayOfString1.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (paramArrayOfString2 != null))
    {
      if (paramArrayOfString2.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int k = paramArrayOfString1.length;
      i = 0;
      while (i < k)
      {
        String str = paramArrayOfString1[i];
        int m = paramArrayOfString2.length;
        int j = 0;
        while (j < m)
        {
          if (paramComparator.compare(str, paramArrayOfString2[j]) == 0) {
            return true;
          }
          j += 1;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static final long headersContentLength(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "$this$headersContentLength");
    paramResponse = paramResponse.headers().get("Content-Length");
    long l = -1L;
    if (paramResponse != null) {
      l = toLongOrDefault(paramResponse, -1L);
    }
    return l;
  }
  
  public static final void ignoreIoExceptions(Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      paramFunction0.invoke();
      return;
    }
    catch (IOException paramFunction0) {}
  }
  
  @SafeVarargs
  public static final <T> List<T> immutableListOf(T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    paramVarArgs = (Object[])paramVarArgs.clone();
    paramVarArgs = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
    Intrinsics.checkExpressionValueIsNotNull(paramVarArgs, "Collections.unmodifiable…sList(*elements.clone()))");
    return paramVarArgs;
  }
  
  public static final int indexOf(String[] paramArrayOfString, String paramString, Comparator<String> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "$this$indexOf");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      int j;
      if (paramComparator.compare(paramArrayOfString[i], paramString) == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfControlOrNonAscii(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$indexOfControlOrNonAscii");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (k > 31)
      {
        if (k >= 127) {
          return i;
        }
        i += 1;
      }
      else
      {
        return i;
      }
    }
    return -1;
  }
  
  public static final int indexOfFirstNonAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$indexOfFirstNonAsciiWhitespace");
    while (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static final int indexOfLastNonAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$indexOfLastNonAsciiWhitespace");
    paramInt2 -= 1;
    if (paramInt2 >= paramInt1) {
      for (;;)
      {
        int i = paramString.charAt(paramInt2);
        if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
          return paramInt2 + 1;
        }
        if (paramInt2 == paramInt1) {
          break;
        }
        paramInt2 -= 1;
      }
    }
    return paramInt1;
  }
  
  public static final int indexOfNonWhitespace(String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$indexOfNonWhitespace");
    int i = paramString.length();
    while (paramInt < i)
    {
      int j = paramString.charAt(paramInt);
      if ((j != 32) && (j != 9)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramString.length();
  }
  
  public static final String[] intersect(String[] paramArrayOfString1, String[] paramArrayOfString2, Comparator<? super String> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString1, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString2, "other");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    List localList = (List)new ArrayList();
    int k = paramArrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString1[i];
      int m = paramArrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        if (paramComparator.compare(str, paramArrayOfString2[j]) == 0)
        {
          localList.add(str);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    paramArrayOfString1 = ((Collection)localList).toArray(new String[0]);
    if (paramArrayOfString1 != null) {
      return (String[])paramArrayOfString1;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public static final boolean isHealthy(Socket paramSocket, BufferedSource paramBufferedSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "$this$isHealthy");
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    try
    {
      int i = paramSocket.getSoTimeout();
      try
      {
        paramSocket.setSoTimeout(1);
        boolean bool = paramBufferedSource.exhausted();
        return bool ^ true;
      }
      finally
      {
        paramSocket.setSoTimeout(i);
      }
    }
    catch (SocketTimeoutException paramSocket)
    {
      return true;
    }
    catch (IOException paramSocket)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static final void notify(Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "$this$notify");
    paramObject.notify();
  }
  
  public static final void notifyAll(Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "$this$notifyAll");
    paramObject.notifyAll();
  }
  
  public static final int parseHexDigit(char paramChar)
  {
    if (('0' <= paramChar) && ('9' >= paramChar)) {
      return paramChar - '0';
    }
    char c = 'a';
    if (('a' <= paramChar) && ('f' >= paramChar)) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while (('A' <= paramChar) && ('F' >= paramChar));
    return -1;
  }
  
  public static final String peerName(Socket paramSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "$this$peerName");
    paramSocket = paramSocket.getRemoteSocketAddress();
    if ((paramSocket instanceof InetSocketAddress))
    {
      paramSocket = ((InetSocketAddress)paramSocket).getHostName();
      Intrinsics.checkExpressionValueIsNotNull(paramSocket, "address.hostName");
      return paramSocket;
    }
    return paramSocket.toString();
  }
  
  public static final Charset readBomAsCharset(BufferedSource paramBufferedSource, Charset paramCharset)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "$this$readBomAsCharset");
    Intrinsics.checkParameterIsNotNull(paramCharset, "default");
    int i = paramBufferedSource.select(UNICODE_BOMS);
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4) {
                return Charsets.INSTANCE.UTF32_LE();
              }
              throw ((Throwable)new AssertionError());
            }
            return Charsets.INSTANCE.UTF32_BE();
          }
          paramBufferedSource = StandardCharsets.UTF_16LE;
          Intrinsics.checkExpressionValueIsNotNull(paramBufferedSource, "UTF_16LE");
          return paramBufferedSource;
        }
        paramBufferedSource = StandardCharsets.UTF_16BE;
        Intrinsics.checkExpressionValueIsNotNull(paramBufferedSource, "UTF_16BE");
        return paramBufferedSource;
      }
      paramCharset = StandardCharsets.UTF_8;
      Intrinsics.checkExpressionValueIsNotNull(paramCharset, "UTF_8");
    }
    return paramCharset;
  }
  
  public static final <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "instance");
    Intrinsics.checkParameterIsNotNull(paramClass, "fieldType");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    Class localClass = paramObject.getClass();
    while ((Intrinsics.areEqual(localClass, Object.class) ^ true))
    {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "field");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        if (!paramClass.isInstance(localObject)) {
          return null;
        }
        localObject = paramClass.cast(localObject);
        return (T)localObject;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
      }
      localClass = localClass.getSuperclass();
      Intrinsics.checkExpressionValueIsNotNull(localClass, "c.superclass");
    }
    if ((Intrinsics.areEqual(paramString, "delegate") ^ true))
    {
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
      if (paramObject != null) {
        return (T)readFieldOrNull(paramObject, paramClass, paramString);
      }
    }
    return null;
  }
  
  public static final int readMedium(BufferedSource paramBufferedSource)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "$this$readMedium");
    int i = and(paramBufferedSource.readByte(), 255);
    int j = and(paramBufferedSource.readByte(), 255);
    return and(paramBufferedSource.readByte(), 255) | i << 16 | j << 8;
  }
  
  public static final int skipAll(Buffer paramBuffer, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$skipAll");
    int i = 0;
    while ((!paramBuffer.exhausted()) && (paramBuffer.getByte(0L) == paramByte))
    {
      i += 1;
      paramBuffer.readByte();
    }
    return i;
  }
  
  /* Error */
  public static final boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 738
    //   4: invokestatic 292	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 485
    //   11: invokestatic 292	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: invokestatic 754	java/lang/System:nanoTime	()J
    //   17: lstore 5
    //   19: aload_0
    //   20: invokeinterface 759 1 0
    //   25: invokevirtual 764	okio/Timeout:hasDeadline	()Z
    //   28: ifeq +19 -> 47
    //   31: aload_0
    //   32: invokeinterface 759 1 0
    //   37: invokevirtual 767	okio/Timeout:deadlineNanoTime	()J
    //   40: lload 5
    //   42: lsub
    //   43: lstore_3
    //   44: goto +7 -> 51
    //   47: ldc2_w 768
    //   50: lstore_3
    //   51: aload_0
    //   52: invokeinterface 759 1 0
    //   57: lload_3
    //   58: aload_2
    //   59: iload_1
    //   60: i2l
    //   61: invokevirtual 772	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   64: invokestatic 778	java/lang/Math:min	(JJ)J
    //   67: lload 5
    //   69: ladd
    //   70: invokevirtual 781	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   73: pop
    //   74: new 740	okio/Buffer
    //   77: dup
    //   78: invokespecial 782	okio/Buffer:<init>	()V
    //   81: astore_2
    //   82: aload_0
    //   83: aload_2
    //   84: ldc2_w 783
    //   87: invokeinterface 788 4 0
    //   92: ldc2_w 534
    //   95: lcmp
    //   96: ifeq +10 -> 106
    //   99: aload_2
    //   100: invokevirtual 791	okio/Buffer:clear	()V
    //   103: goto -21 -> 82
    //   106: iconst_1
    //   107: istore 7
    //   109: iconst_1
    //   110: istore 8
    //   112: lload_3
    //   113: ldc2_w 768
    //   116: lcmp
    //   117: ifne +20 -> 137
    //   120: iload 8
    //   122: istore 7
    //   124: aload_0
    //   125: invokeinterface 759 1 0
    //   130: invokevirtual 794	okio/Timeout:clearDeadline	()Lokio/Timeout;
    //   133: pop
    //   134: iload 7
    //   136: ireturn
    //   137: aload_0
    //   138: invokeinterface 759 1 0
    //   143: lload 5
    //   145: lload_3
    //   146: ladd
    //   147: invokevirtual 781	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   150: pop
    //   151: iload 7
    //   153: ireturn
    //   154: astore_2
    //   155: lload_3
    //   156: ldc2_w 768
    //   159: lcmp
    //   160: ifne +16 -> 176
    //   163: aload_0
    //   164: invokeinterface 759 1 0
    //   169: invokevirtual 794	okio/Timeout:clearDeadline	()Lokio/Timeout;
    //   172: pop
    //   173: goto +17 -> 190
    //   176: aload_0
    //   177: invokeinterface 759 1 0
    //   182: lload 5
    //   184: lload_3
    //   185: ladd
    //   186: invokevirtual 781	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   189: pop
    //   190: aload_2
    //   191: athrow
    //   192: iconst_0
    //   193: istore 7
    //   195: iconst_0
    //   196: istore 8
    //   198: lload_3
    //   199: ldc2_w 768
    //   202: lcmp
    //   203: ifne -66 -> 137
    //   206: iload 8
    //   208: istore 7
    //   210: goto -86 -> 124
    //   213: astore_2
    //   214: goto -22 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramSource	Source
    //   0	217	1	paramInt	int
    //   0	217	2	paramTimeUnit	TimeUnit
    //   43	156	3	l1	long
    //   17	166	5	l2	long
    //   107	102	7	bool1	boolean
    //   110	97	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   74	82	154	finally
    //   82	103	154	finally
    //   74	82	213	java/io/InterruptedIOException
    //   82	103	213	java/io/InterruptedIOException
  }
  
  public static final ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    (ThreadFactory)new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, this.$name);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static final void threadName(String paramString, Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "currentThread");
    String str = localThread.getName();
    localThread.setName(paramString);
    try
    {
      paramFunction0.invoke();
      return;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      localThread.setName(str);
      InlineMarker.finallyEnd(1);
    }
  }
  
  public static final List<Header> toHeaderList(Headers paramHeaders)
  {
    Intrinsics.checkParameterIsNotNull(paramHeaders, "$this$toHeaderList");
    Object localObject = (Iterable)RangesKt.until(0, paramHeaders.size());
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((IntIterator)localObject).nextInt();
      localCollection.add(new Header(paramHeaders.name(i), paramHeaders.value(i)));
    }
    return (List)localCollection;
  }
  
  public static final Headers toHeaders(List<Header> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toHeaders");
    Headers.Builder localBuilder = new Headers.Builder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Header)paramList.next();
      ByteString localByteString = ((Header)localObject).component1();
      localObject = ((Header)localObject).component2();
      localBuilder.addLenient$okhttp(localByteString.utf8(), ((ByteString)localObject).utf8());
    }
    return localBuilder.build();
  }
  
  public static final String toHexString(int paramInt)
  {
    String str = Integer.toHexString(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "Integer.toHexString(this)");
    return str;
  }
  
  public static final String toHexString(long paramLong)
  {
    String str = Long.toHexString(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toHexString(this)");
    return str;
  }
  
  public static final String toHostHeader(HttpUrl paramHttpUrl, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramHttpUrl, "$this$toHostHeader");
    Object localObject1;
    if (StringsKt.contains$default((CharSequence)paramHttpUrl.host(), (CharSequence)":", false, 2, null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append('[');
      ((StringBuilder)localObject1).append(paramHttpUrl.host());
      ((StringBuilder)localObject1).append(']');
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = paramHttpUrl.host();
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = localObject1;
      if (paramHttpUrl.port() == HttpUrl.Companion.defaultPort(paramHttpUrl.scheme())) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(':');
      ((StringBuilder)localObject2).append(paramHttpUrl.port());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public static final <T> List<T> toImmutableList(List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toImmutableList");
    paramList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection)paramList));
    Intrinsics.checkExpressionValueIsNotNull(paramList, "Collections.unmodifiableList(toMutableList())");
    return paramList;
  }
  
  public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toImmutableMap");
    if (paramMap.isEmpty()) {
      return MapsKt.emptyMap();
    }
    paramMap = Collections.unmodifiableMap((Map)new LinkedHashMap(paramMap));
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
    return paramMap;
  }
  
  public static final long toLongOrDefault(String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toLongOrDefault");
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public static final int toNonNegativeInt(String paramString, int paramInt)
  {
    if (paramString != null) {}
    try
    {
      long l = Long.parseLong(paramString);
      if (l > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
    return paramInt;
  }
  
  public static final String trimSubstring(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimSubstring");
    paramInt1 = indexOfFirstNonAsciiWhitespace(paramString, paramInt1, paramInt2);
    paramString = paramString.substring(paramInt1, indexOfLastNonAsciiWhitespace(paramString, paramInt1, paramInt2));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString;
  }
  
  public static final void wait(Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "$this$wait");
    paramObject.wait();
  }
  
  public static final void writeMedium(BufferedSink paramBufferedSink, int paramInt)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "$this$writeMedium");
    paramBufferedSink.writeByte(paramInt >>> 16 & 0xFF);
    paramBufferedSink.writeByte(paramInt >>> 8 & 0xFF);
    paramBufferedSink.writeByte(paramInt & 0xFF);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */