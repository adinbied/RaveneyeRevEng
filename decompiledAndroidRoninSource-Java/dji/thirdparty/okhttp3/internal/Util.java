package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.ByteString;
import dji.thirdparty.okio.Source;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  /* Error */
  public static void closeAll(Closeable paramCloseable1, Closeable paramCloseable2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 72 1 0
    //   6: aconst_null
    //   7: astore_0
    //   8: goto +4 -> 12
    //   11: astore_0
    //   12: aload_1
    //   13: invokeinterface 72 1 0
    //   18: aload_0
    //   19: astore_1
    //   20: goto +12 -> 32
    //   23: astore_2
    //   24: aload_0
    //   25: astore_1
    //   26: aload_0
    //   27: ifnonnull +5 -> 32
    //   30: aload_2
    //   31: astore_1
    //   32: aload_1
    //   33: ifnonnull +4 -> 37
    //   36: return
    //   37: aload_1
    //   38: instanceof 67
    //   41: ifne +36 -> 77
    //   44: aload_1
    //   45: instanceof 74
    //   48: ifne +24 -> 72
    //   51: aload_1
    //   52: instanceof 76
    //   55: ifeq +8 -> 63
    //   58: aload_1
    //   59: checkcast 76	java/lang/Error
    //   62: athrow
    //   63: new 78	java/lang/AssertionError
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 81	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   71: athrow
    //   72: aload_1
    //   73: checkcast 74	java/lang/RuntimeException
    //   76: athrow
    //   77: aload_1
    //   78: checkcast 67	java/io/IOException
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramCloseable1	Closeable
    //   0	82	1	paramCloseable2	Closeable
    //   23	8	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	11	finally
    //   12	18	23	finally
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException paramServerSocket)
    {
      throw paramServerSocket;
      return;
    }
    catch (Exception paramServerSocket) {}
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (AssertionError paramSocket)
    {
      if (isAndroidGetsocknameError(paramSocket)) {
        return;
      }
      throw paramSocket;
      return;
    }
    catch (Exception paramSocket) {}
  }
  
  public static String[] concat(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length + 1;
    String[] arrayOfString = new String[i];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(i - 1)] = paramString;
    return arrayOfString;
  }
  
  public static boolean contains(String[] paramArrayOfString, String paramString)
  {
    return Arrays.asList(paramArrayOfString).contains(paramString);
  }
  
  private static boolean containsInvalidHostnameAsciiCodes(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if (j > 31)
      {
        if (j >= 127) {
          return true;
        }
        if (" #%/:?@[\\]".indexOf(j) != -1) {
          return true;
        }
        i += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public static int delimiterOffset(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
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
  
  public static String domainToAscii(String paramString)
  {
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty()) {
        return null;
      }
      boolean bool = containsInvalidHostnameAsciiCodes(paramString);
      if (bool) {
        return null;
      }
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static String hostHeader(HttpUrl paramHttpUrl, boolean paramBoolean)
  {
    Object localObject1;
    if (paramHttpUrl.host().contains(":"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(paramHttpUrl.host());
      ((StringBuilder)localObject1).append("]");
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
      if (paramHttpUrl.port() == HttpUrl.defaultPort(paramHttpUrl.scheme())) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramHttpUrl.port());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> immutableMap(Map<K, V> paramMap)
  {
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  private static <T> List<T> intersect(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfT1.length;
    int i = 0;
    while (i < k)
    {
      T ? = paramArrayOfT1[i];
      int m = paramArrayOfT2.length;
      int j = 0;
      while (j < m)
      {
        T ? = paramArrayOfT2[j];
        if (?.equals(?))
        {
          localArrayList.add(?);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static <T> T[] intersect(Class<T> paramClass, T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    paramArrayOfT1 = intersect(paramArrayOfT1, paramArrayOfT2);
    return paramArrayOfT1.toArray((Object[])Array.newInstance(paramClass, paramArrayOfT1.size()));
  }
  
  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static String md5Hex(String paramString)
  {
    try
    {
      paramString = ByteString.of(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).hex();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}catch (NoSuchAlgorithmException paramString) {}
    throw new AssertionError(paramString);
  }
  
  public static ByteString sha1(ByteString paramByteString)
  {
    try
    {
      paramByteString = ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramByteString.toByteArray()));
      return paramByteString;
    }
    catch (NoSuchAlgorithmException paramByteString)
    {
      throw new AssertionError(paramByteString);
    }
  }
  
  public static ByteString sha256(ByteString paramByteString)
  {
    try
    {
      paramByteString = ByteString.of(MessageDigest.getInstance("SHA-256").digest(paramByteString.toByteArray()));
      return paramByteString;
    }
    catch (NoSuchAlgorithmException paramByteString)
    {
      throw new AssertionError(paramByteString);
    }
  }
  
  public static String shaBase64(String paramString)
  {
    try
    {
      paramString = ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramString.getBytes("UTF-8"))).base64();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}catch (NoSuchAlgorithmException paramString) {}
    throw new AssertionError(paramString);
  }
  
  /* Error */
  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 329	java/lang/System:nanoTime	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: invokeinterface 335 1 0
    //   11: invokevirtual 340	dji/thirdparty/okio/Timeout:hasDeadline	()Z
    //   14: ifeq +19 -> 33
    //   17: aload_0
    //   18: invokeinterface 335 1 0
    //   23: invokevirtual 343	dji/thirdparty/okio/Timeout:deadlineNanoTime	()J
    //   26: lload 5
    //   28: lsub
    //   29: lstore_3
    //   30: goto +7 -> 37
    //   33: ldc2_w 344
    //   36: lstore_3
    //   37: aload_0
    //   38: invokeinterface 335 1 0
    //   43: lload_3
    //   44: aload_2
    //   45: iload_1
    //   46: i2l
    //   47: invokevirtual 351	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   50: invokestatic 357	java/lang/Math:min	(JJ)J
    //   53: lload 5
    //   55: ladd
    //   56: invokevirtual 360	dji/thirdparty/okio/Timeout:deadlineNanoTime	(J)Ldji/thirdparty/okio/Timeout;
    //   59: pop
    //   60: new 362	dji/thirdparty/okio/Buffer
    //   63: dup
    //   64: invokespecial 363	dji/thirdparty/okio/Buffer:<init>	()V
    //   67: astore_2
    //   68: aload_0
    //   69: aload_2
    //   70: ldc2_w 364
    //   73: invokeinterface 369 4 0
    //   78: ldc2_w 370
    //   81: lcmp
    //   82: ifeq +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 374	dji/thirdparty/okio/Buffer:clear	()V
    //   89: goto -21 -> 68
    //   92: lload_3
    //   93: ldc2_w 344
    //   96: lcmp
    //   97: ifne +15 -> 112
    //   100: aload_0
    //   101: invokeinterface 335 1 0
    //   106: invokevirtual 377	dji/thirdparty/okio/Timeout:clearDeadline	()Ldji/thirdparty/okio/Timeout;
    //   109: pop
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_0
    //   113: invokeinterface 335 1 0
    //   118: lload 5
    //   120: lload_3
    //   121: ladd
    //   122: invokevirtual 360	dji/thirdparty/okio/Timeout:deadlineNanoTime	(J)Ldji/thirdparty/okio/Timeout;
    //   125: pop
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_2
    //   129: lload_3
    //   130: ldc2_w 344
    //   133: lcmp
    //   134: ifne +16 -> 150
    //   137: aload_0
    //   138: invokeinterface 335 1 0
    //   143: invokevirtual 377	dji/thirdparty/okio/Timeout:clearDeadline	()Ldji/thirdparty/okio/Timeout;
    //   146: pop
    //   147: goto +17 -> 164
    //   150: aload_0
    //   151: invokeinterface 335 1 0
    //   156: lload 5
    //   158: lload_3
    //   159: ladd
    //   160: invokevirtual 360	dji/thirdparty/okio/Timeout:deadlineNanoTime	(J)Ldji/thirdparty/okio/Timeout;
    //   163: pop
    //   164: aload_2
    //   165: athrow
    //   166: lload_3
    //   167: ldc2_w 344
    //   170: lcmp
    //   171: ifne +15 -> 186
    //   174: aload_0
    //   175: invokeinterface 335 1 0
    //   180: invokevirtual 377	dji/thirdparty/okio/Timeout:clearDeadline	()Ldji/thirdparty/okio/Timeout;
    //   183: pop
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_0
    //   187: invokeinterface 335 1 0
    //   192: lload 5
    //   194: lload_3
    //   195: ladd
    //   196: invokevirtual 360	dji/thirdparty/okio/Timeout:deadlineNanoTime	(J)Ldji/thirdparty/okio/Timeout;
    //   199: pop
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_2
    //   203: goto -37 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramSource	Source
    //   0	206	1	paramInt	int
    //   0	206	2	paramTimeUnit	TimeUnit
    //   29	166	3	l1	long
    //   3	190	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   60	68	128	finally
    //   68	89	128	finally
    //   60	68	202	java/io/InterruptedIOException
    //   68	89	202	java/io/InterruptedIOException
  }
  
  public static int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
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
  
  public static int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      int i = paramString.charAt(paramInt2);
      if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
        return paramInt2 + 1;
      }
      paramInt2 -= 1;
    }
    return paramInt1;
  }
  
  public static ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return null;
      }
    };
  }
  
  public static String toHumanReadableAscii(String paramString)
  {
    int m = paramString.length();
    int i = 0;
    int j;
    for (;;)
    {
      localObject = paramString;
      if (i >= m) {
        break label119;
      }
      j = paramString.codePointAt(i);
      if ((j <= 31) || (j >= 127)) {
        break;
      }
      i += Character.charCount(j);
    }
    Object localObject = new Buffer();
    ((Buffer)localObject).writeUtf8(paramString, 0, i);
    while (i < m)
    {
      int k = paramString.codePointAt(i);
      if ((k > 31) && (k < 127)) {
        j = k;
      } else {
        j = 63;
      }
      ((Buffer)localObject).writeUtf8CodePoint(j);
      i += Character.charCount(k);
    }
    localObject = ((Buffer)localObject).readUtf8();
    label119:
    return (String)localObject;
  }
  
  public static String trimSubstring(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = skipLeadingAsciiWhitespace(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, skipTrailingAsciiWhitespace(paramString, paramInt1, paramInt2));
  }
  
  public static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */