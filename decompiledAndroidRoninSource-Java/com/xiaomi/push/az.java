package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class az
{
  public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
  public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return -1;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return -1;
      }
      return paramContext.getType();
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  public static ax a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    // Byte code:
    //   0: new 65	com/xiaomi/push/ax
    //   3: dup
    //   4: invokespecial 68	com/xiaomi/push/ax:<init>	()V
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: invokestatic 71	com/xiaomi/push/az:a	(Ljava/lang/String;)Ljava/net/URL;
    //   20: invokestatic 74	com/xiaomi/push/az:a	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   23: astore 10
    //   25: aload 10
    //   27: sipush 10000
    //   30: invokevirtual 80	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload 10
    //   35: sipush 15000
    //   38: invokevirtual 83	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   41: aload_2
    //   42: astore_0
    //   43: aload_2
    //   44: ifnonnull +6 -> 50
    //   47: ldc 85
    //   49: astore_0
    //   50: aload 10
    //   52: aload_0
    //   53: invokevirtual 89	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   56: aload_3
    //   57: ifnull +53 -> 110
    //   60: aload_3
    //   61: invokeinterface 95 1 0
    //   66: invokeinterface 101 1 0
    //   71: astore_0
    //   72: aload_0
    //   73: invokeinterface 107 1 0
    //   78: ifeq +32 -> 110
    //   81: aload_0
    //   82: invokeinterface 111 1 0
    //   87: checkcast 113	java/lang/String
    //   90: astore_2
    //   91: aload 10
    //   93: aload_2
    //   94: aload_3
    //   95: aload_2
    //   96: invokeinterface 117 2 0
    //   101: checkcast 113	java/lang/String
    //   104: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -35 -> 72
    //   110: aload 4
    //   112: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: istore 6
    //   117: iconst_0
    //   118: istore 5
    //   120: iload 6
    //   122: ifne +62 -> 184
    //   125: aload 10
    //   127: iconst_1
    //   128: invokevirtual 131	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   131: aload 4
    //   133: invokevirtual 135	java/lang/String:getBytes	()[B
    //   136: astore_2
    //   137: aload 10
    //   139: invokevirtual 139	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   142: astore_0
    //   143: aload_0
    //   144: aload_2
    //   145: iconst_0
    //   146: aload_2
    //   147: arraylength
    //   148: invokevirtual 145	java/io/OutputStream:write	([BII)V
    //   151: aload_0
    //   152: invokevirtual 148	java/io/OutputStream:flush	()V
    //   155: aload_0
    //   156: invokevirtual 151	java/io/OutputStream:close	()V
    //   159: goto +25 -> 184
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_0
    //   166: astore_2
    //   167: aload_3
    //   168: astore_0
    //   169: goto +254 -> 423
    //   172: astore_3
    //   173: aconst_null
    //   174: astore 4
    //   176: aload_0
    //   177: astore_2
    //   178: aload 4
    //   180: astore_0
    //   181: goto +260 -> 441
    //   184: aload 9
    //   186: aload 10
    //   188: invokevirtual 154	java/net/HttpURLConnection:getResponseCode	()I
    //   191: putfield 157	com/xiaomi/push/ax:jdField_a_of_type_Int	I
    //   194: new 159	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   201: astore_0
    //   202: aload_0
    //   203: ldc -94
    //   205: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_0
    //   210: aload 9
    //   212: getfield 157	com/xiaomi/push/ax:jdField_a_of_type_Int	I
    //   215: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc -85
    //   221: aload_0
    //   222: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 181	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   228: pop
    //   229: aload 10
    //   231: iload 5
    //   233: invokevirtual 185	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   236: astore_0
    //   237: aload 10
    //   239: iload 5
    //   241: invokevirtual 188	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   244: astore_2
    //   245: aload_0
    //   246: ifnonnull +147 -> 393
    //   249: aload_2
    //   250: ifnonnull +143 -> 393
    //   253: new 190	java/io/BufferedReader
    //   256: dup
    //   257: new 192	java/io/InputStreamReader
    //   260: dup
    //   261: new 6	com/xiaomi/push/az$a
    //   264: dup
    //   265: aload 10
    //   267: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   270: invokespecial 199	com/xiaomi/push/az$a:<init>	(Ljava/io/InputStream;)V
    //   273: invokespecial 200	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   276: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   279: astore_0
    //   280: goto +30 -> 310
    //   283: new 190	java/io/BufferedReader
    //   286: dup
    //   287: new 192	java/io/InputStreamReader
    //   290: dup
    //   291: new 6	com/xiaomi/push/az$a
    //   294: dup
    //   295: aload 10
    //   297: invokevirtual 206	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   300: invokespecial 199	com/xiaomi/push/az$a:<init>	(Ljava/io/InputStream;)V
    //   303: invokespecial 200	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   306: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   309: astore_0
    //   310: aload_0
    //   311: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   314: astore_2
    //   315: new 211	java/lang/StringBuffer
    //   318: dup
    //   319: invokespecial 212	java/lang/StringBuffer:<init>	()V
    //   322: astore_3
    //   323: ldc -42
    //   325: invokestatic 220	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore 4
    //   330: aload_2
    //   331: ifnull +24 -> 355
    //   334: aload_3
    //   335: aload_2
    //   336: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: aload_3
    //   341: aload 4
    //   343: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   346: pop
    //   347: aload_0
    //   348: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   351: astore_2
    //   352: goto -22 -> 330
    //   355: aload 9
    //   357: aload_3
    //   358: invokevirtual 224	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   361: putfield 227	com/xiaomi/push/ax:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   364: aload_0
    //   365: invokevirtual 228	java/io/BufferedReader:close	()V
    //   368: aconst_null
    //   369: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   372: aconst_null
    //   373: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   376: aload 9
    //   378: areturn
    //   379: astore_1
    //   380: aload 7
    //   382: astore_2
    //   383: goto +40 -> 423
    //   386: astore_3
    //   387: aload 8
    //   389: astore_2
    //   390: goto +51 -> 441
    //   393: aload 9
    //   395: getfield 236	com/xiaomi/push/ax:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   398: aload_0
    //   399: aload_2
    //   400: invokeinterface 240 3 0
    //   405: pop
    //   406: iload 5
    //   408: iconst_1
    //   409: iadd
    //   410: iconst_1
    //   411: iadd
    //   412: istore 5
    //   414: goto -185 -> 229
    //   417: astore_1
    //   418: aconst_null
    //   419: astore_0
    //   420: aload 7
    //   422: astore_2
    //   423: aload_2
    //   424: astore 4
    //   426: aload_0
    //   427: astore 7
    //   429: new 63	java/io/IOException
    //   432: dup
    //   433: aload_1
    //   434: invokevirtual 245	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   437: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   440: athrow
    //   441: aload_2
    //   442: astore 4
    //   444: aload_0
    //   445: astore 7
    //   447: new 159	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   454: astore 8
    //   456: aload_2
    //   457: astore 4
    //   459: aload_0
    //   460: astore 7
    //   462: aload 8
    //   464: ldc -7
    //   466: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_2
    //   471: astore 4
    //   473: aload_0
    //   474: astore 7
    //   476: aload 8
    //   478: aload_1
    //   479: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_2
    //   484: astore 4
    //   486: aload_0
    //   487: astore 7
    //   489: aload 8
    //   491: ldc -5
    //   493: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_2
    //   498: astore 4
    //   500: aload_0
    //   501: astore 7
    //   503: aload 8
    //   505: aload_3
    //   506: invokevirtual 255	java/lang/Object:getClass	()Ljava/lang/Class;
    //   509: invokevirtual 260	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   512: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_2
    //   517: astore 4
    //   519: aload_0
    //   520: astore 7
    //   522: new 63	java/io/IOException
    //   525: dup
    //   526: aload 8
    //   528: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   534: athrow
    //   535: astore_0
    //   536: aload 4
    //   538: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   541: aload 7
    //   543: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   546: aload_0
    //   547: athrow
    //   548: astore_0
    //   549: goto -266 -> 283
    //   552: astore_3
    //   553: aconst_null
    //   554: astore_0
    //   555: aload 8
    //   557: astore_2
    //   558: goto -117 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	paramContext	Context
    //   0	561	1	paramString1	String
    //   0	561	2	paramString2	String
    //   0	561	3	paramMap	Map<String, String>
    //   0	561	4	paramString3	String
    //   118	295	5	i	int
    //   115	6	6	bool	boolean
    //   13	529	7	localContext	Context
    //   10	546	8	localStringBuilder	StringBuilder
    //   7	387	9	localax	ax
    //   23	273	10	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   143	159	162	finally
    //   143	159	172	java/io/IOException
    //   310	330	379	finally
    //   334	352	379	finally
    //   355	368	379	finally
    //   310	330	386	java/io/IOException
    //   334	352	386	java/io/IOException
    //   355	368	386	java/io/IOException
    //   15	41	417	finally
    //   50	56	417	finally
    //   60	72	417	finally
    //   72	107	417	finally
    //   110	117	417	finally
    //   125	143	417	finally
    //   184	229	417	finally
    //   229	245	417	finally
    //   253	280	417	finally
    //   283	310	417	finally
    //   393	406	417	finally
    //   429	441	535	finally
    //   447	456	535	finally
    //   462	470	535	finally
    //   476	483	535	finally
    //   489	497	535	finally
    //   503	516	535	finally
    //   522	535	535	finally
    //   253	280	548	java/io/IOException
    //   15	41	552	java/io/IOException
    //   50	56	552	java/io/IOException
    //   60	72	552	java/io/IOException
    //   72	107	552	java/io/IOException
    //   110	117	552	java/io/IOException
    //   125	143	552	java/io/IOException
    //   184	229	552	java/io/IOException
    //   229	245	552	java/io/IOException
    //   283	310	552	java/io/IOException
    //   393	406	552	java/io/IOException
  }
  
  public static ax a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    return a(paramContext, paramString, "POST", null, a(paramMap));
  }
  
  public static InputStream a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2)
  {
    return a(paramContext, paramURL, paramBoolean, paramString1, paramString2, null, null);
  }
  
  /* Error */
  public static InputStream a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, Map<String, String> paramMap, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +346 -> 347
    //   4: aload_1
    //   5: ifnull +331 -> 336
    //   8: iload_2
    //   9: ifne +22 -> 31
    //   12: new 277	java/net/URL
    //   15: dup
    //   16: aload_1
    //   17: invokevirtual 278	java/net/URL:toString	()Ljava/lang/String;
    //   20: invokestatic 280	com/xiaomi/push/az:a	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 281	java/net/URL:<init>	(Ljava/lang/String;)V
    //   26: astore 8
    //   28: goto +6 -> 34
    //   31: aload_1
    //   32: astore 8
    //   34: iconst_1
    //   35: invokestatic 284	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   38: aload_0
    //   39: aload 8
    //   41: invokestatic 74	com/xiaomi/push/az:a	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   44: astore_0
    //   45: aload_0
    //   46: sipush 10000
    //   49: invokevirtual 80	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   52: aload_0
    //   53: sipush 15000
    //   56: invokevirtual 83	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   59: aload_3
    //   60: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +11 -> 74
    //   66: aload_0
    //   67: ldc_w 286
    //   70: aload_3
    //   71: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 4
    //   76: ifnull +12 -> 88
    //   79: aload_0
    //   80: ldc_w 288
    //   83: aload 4
    //   85: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 5
    //   90: ifnull +57 -> 147
    //   93: aload 5
    //   95: invokeinterface 95 1 0
    //   100: invokeinterface 101 1 0
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 107 1 0
    //   112: ifeq +35 -> 147
    //   115: aload_3
    //   116: invokeinterface 111 1 0
    //   121: checkcast 113	java/lang/String
    //   124: astore 4
    //   126: aload_0
    //   127: aload 4
    //   129: aload 5
    //   131: aload 4
    //   133: invokeinterface 117 2 0
    //   138: checkcast 113	java/lang/String
    //   141: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: goto -38 -> 106
    //   147: aload 6
    //   149: ifnull +119 -> 268
    //   152: aload_1
    //   153: invokevirtual 291	java/net/URL:getProtocol	()Ljava/lang/String;
    //   156: ldc_w 293
    //   159: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifne +16 -> 178
    //   165: aload_1
    //   166: invokevirtual 291	java/net/URL:getProtocol	()Ljava/lang/String;
    //   169: ldc_w 299
    //   172: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   175: ifeq +93 -> 268
    //   178: aload 6
    //   180: aload_0
    //   181: invokevirtual 154	java/net/HttpURLConnection:getResponseCode	()I
    //   184: putfield 300	com/xiaomi/push/az$b:jdField_a_of_type_Int	I
    //   187: aload 6
    //   189: getfield 301	com/xiaomi/push/az$b:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   192: ifnonnull +166 -> 358
    //   195: aload 6
    //   197: new 303	java/util/HashMap
    //   200: dup
    //   201: invokespecial 304	java/util/HashMap:<init>	()V
    //   204: putfield 301	com/xiaomi/push/az$b:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   207: goto +151 -> 358
    //   210: aload_0
    //   211: iload 7
    //   213: invokevirtual 185	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   216: astore_1
    //   217: aload_0
    //   218: iload 7
    //   220: invokevirtual 188	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_1
    //   225: ifnonnull +10 -> 235
    //   228: aload_3
    //   229: ifnonnull +6 -> 235
    //   232: goto +36 -> 268
    //   235: aload_1
    //   236: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne +125 -> 364
    //   242: aload_3
    //   243: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifeq +6 -> 252
    //   249: goto +115 -> 364
    //   252: aload 6
    //   254: getfield 301	com/xiaomi/push/az$b:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   257: aload_1
    //   258: aload_3
    //   259: invokeinterface 240 3 0
    //   264: pop
    //   265: goto +99 -> 364
    //   268: new 6	com/xiaomi/push/az$a
    //   271: dup
    //   272: aload_0
    //   273: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   276: invokespecial 199	com/xiaomi/push/az$a:<init>	(Ljava/io/InputStream;)V
    //   279: astore_0
    //   280: aload_0
    //   281: areturn
    //   282: astore_0
    //   283: new 63	java/io/IOException
    //   286: dup
    //   287: aload_0
    //   288: invokevirtual 245	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   291: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   294: athrow
    //   295: astore_0
    //   296: new 159	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   303: astore_1
    //   304: aload_1
    //   305: ldc_w 306
    //   308: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_1
    //   313: aload_0
    //   314: invokevirtual 255	java/lang/Object:getClass	()Ljava/lang/Class;
    //   317: invokevirtual 260	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   320: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: new 63	java/io/IOException
    //   327: dup
    //   328: aload_1
    //   329: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   335: athrow
    //   336: new 308	java/lang/IllegalArgumentException
    //   339: dup
    //   340: ldc_w 310
    //   343: invokespecial 311	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   346: athrow
    //   347: new 308	java/lang/IllegalArgumentException
    //   350: dup
    //   351: ldc_w 313
    //   354: invokespecial 311	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   357: athrow
    //   358: iconst_0
    //   359: istore 7
    //   361: goto -151 -> 210
    //   364: iload 7
    //   366: iconst_1
    //   367: iadd
    //   368: istore 7
    //   370: goto -160 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramContext	Context
    //   0	373	1	paramURL	URL
    //   0	373	2	paramBoolean	boolean
    //   0	373	3	paramString1	String
    //   0	373	4	paramString2	String
    //   0	373	5	paramMap	Map<String, String>
    //   0	373	6	paramb	b
    //   211	158	7	i	int
    //   26	14	8	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   34	74	282	finally
    //   79	88	282	finally
    //   93	106	282	finally
    //   106	144	282	finally
    //   152	178	282	finally
    //   178	207	282	finally
    //   210	224	282	finally
    //   235	249	282	finally
    //   252	265	282	finally
    //   268	280	282	finally
    //   34	74	295	java/io/IOException
    //   79	88	295	java/io/IOException
    //   93	106	295	java/io/IOException
    //   106	144	295	java/io/IOException
    //   152	178	295	java/io/IOException
    //   178	207	295	java/io/IOException
    //   210	224	295	java/io/IOException
    //   235	249	295	java/io/IOException
    //   252	265	295	java/io/IOException
    //   268	280	295	java/io/IOException
  }
  
  public static String a(Context paramContext)
  {
    if (d(paramContext)) {
      return "wifi";
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getTypeName());
      localStringBuilder.append("-");
      localStringBuilder.append(paramContext.getSubtypeName());
      localStringBuilder.append("-");
      localStringBuilder.append(paramContext.getExtraInfo());
      return localStringBuilder.toString().toLowerCase();
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String a(Context paramContext, URL paramURL)
  {
    return a(paramContext, paramURL, false, null, "UTF-8", null);
  }
  
  /* Error */
  public static String a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: aload_3
    //   4: aload 5
    //   6: invokestatic 344	com/xiaomi/push/az:a	(Landroid/content/Context;Ljava/net/URL;ZLjava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 159	java/lang/StringBuilder
    //   13: dup
    //   14: sipush 1024
    //   17: invokespecial 346	java/lang/StringBuilder:<init>	(I)V
    //   20: astore_1
    //   21: new 190	java/io/BufferedReader
    //   24: dup
    //   25: new 192	java/io/InputStreamReader
    //   28: dup
    //   29: aload_0
    //   30: aload 4
    //   32: invokespecial 349	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   35: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_3
    //   39: sipush 4096
    //   42: newarray <illegal type>
    //   44: astore 4
    //   46: aload_3
    //   47: aload 4
    //   49: invokevirtual 353	java/io/BufferedReader:read	([C)I
    //   52: istore 6
    //   54: iconst_m1
    //   55: iload 6
    //   57: if_icmpeq +16 -> 73
    //   60: aload_1
    //   61: aload 4
    //   63: iconst_0
    //   64: iload 6
    //   66: invokevirtual 356	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: goto -24 -> 46
    //   73: aload_0
    //   74: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   77: aload_1
    //   78: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: areturn
    //   82: astore_1
    //   83: goto +6 -> 89
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   0	95	1	paramURL	URL
    //   0	95	2	paramBoolean	boolean
    //   0	95	3	paramString1	String
    //   0	95	4	paramString2	String
    //   0	95	5	paramString3	String
    //   52	13	6	i	int
    // Exception table:
    //   from	to	target	type
    //   10	46	82	finally
    //   46	54	82	finally
    //   60	70	82	finally
    //   0	10	86	finally
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new String();
      return String.format("%s&key=%s", new Object[] { paramString, be.a(String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[] { paramString })) });
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString1, Map<String, String> paramMap, java.io.File paramFile, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 374	java/io/File:exists	()Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: iload 5
    //   14: ifne +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_2
    //   20: invokevirtual 377	java/io/File:getName	()Ljava/lang/String;
    //   23: astore 8
    //   25: new 277	java/net/URL
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 281	java/net/URL:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 381	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 76	java/net/HttpURLConnection
    //   39: astore_0
    //   40: aload_0
    //   41: sipush 15000
    //   44: invokevirtual 83	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   47: aload_0
    //   48: sipush 10000
    //   51: invokevirtual 80	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   54: aload_0
    //   55: iconst_1
    //   56: invokevirtual 384	java/net/HttpURLConnection:setDoInput	(Z)V
    //   59: aload_0
    //   60: iconst_1
    //   61: invokevirtual 131	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   64: aload_0
    //   65: iconst_0
    //   66: invokevirtual 387	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   69: aload_0
    //   70: ldc_w 265
    //   73: invokevirtual 89	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   76: aload_0
    //   77: ldc_w 389
    //   80: ldc_w 391
    //   83: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: ldc_w 393
    //   90: ldc_w 395
    //   93: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_1
    //   97: ifnull +62 -> 159
    //   100: aload_1
    //   101: invokeinterface 398 1 0
    //   106: invokeinterface 101 1 0
    //   111: astore_1
    //   112: aload_1
    //   113: invokeinterface 107 1 0
    //   118: ifeq +41 -> 159
    //   121: aload_1
    //   122: invokeinterface 111 1 0
    //   127: checkcast 400	java/util/Map$Entry
    //   130: astore 9
    //   132: aload_0
    //   133: aload 9
    //   135: invokeinterface 403 1 0
    //   140: checkcast 113	java/lang/String
    //   143: aload 9
    //   145: invokeinterface 406 1 0
    //   150: checkcast 113	java/lang/String
    //   153: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -44 -> 112
    //   159: aload_0
    //   160: aload 8
    //   162: invokevirtual 409	java/lang/String:length	()I
    //   165: bipush 77
    //   167: iadd
    //   168: aload_2
    //   169: invokevirtual 412	java/io/File:length	()J
    //   172: l2i
    //   173: iadd
    //   174: aload_3
    //   175: invokevirtual 409	java/lang/String:length	()I
    //   178: iadd
    //   179: invokevirtual 415	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   182: new 417	java/io/DataOutputStream
    //   185: dup
    //   186: aload_0
    //   187: invokevirtual 139	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   190: invokespecial 420	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   193: astore_1
    //   194: aload_1
    //   195: ldc_w 422
    //   198: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   201: new 159	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   208: astore 8
    //   210: aload 8
    //   212: ldc_w 427
    //   215: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 8
    //   221: aload_3
    //   222: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 8
    //   228: ldc_w 429
    //   231: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 8
    //   237: aload_2
    //   238: invokevirtual 377	java/io/File:getName	()Ljava/lang/String;
    //   241: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 8
    //   247: ldc_w 431
    //   250: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 8
    //   256: ldc_w 433
    //   259: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: aload 8
    //   266: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   272: aload_1
    //   273: ldc_w 433
    //   276: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   279: new 435	java/io/FileInputStream
    //   282: dup
    //   283: aload_2
    //   284: invokespecial 438	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   287: astore_3
    //   288: sipush 1024
    //   291: newarray <illegal type>
    //   293: astore_2
    //   294: aload_3
    //   295: aload_2
    //   296: invokevirtual 441	java/io/FileInputStream:read	([B)I
    //   299: istore 4
    //   301: iload 4
    //   303: iconst_m1
    //   304: if_icmpeq +18 -> 322
    //   307: aload_1
    //   308: aload_2
    //   309: iconst_0
    //   310: iload 4
    //   312: invokevirtual 442	java/io/DataOutputStream:write	([BII)V
    //   315: aload_1
    //   316: invokevirtual 443	java/io/DataOutputStream:flush	()V
    //   319: goto -25 -> 294
    //   322: aload_1
    //   323: ldc_w 433
    //   326: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   329: aload_1
    //   330: ldc_w 445
    //   333: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   336: aload_1
    //   337: ldc_w 447
    //   340: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   343: aload_1
    //   344: ldc_w 445
    //   347: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   350: aload_1
    //   351: ldc_w 433
    //   354: invokevirtual 425	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   357: aload_1
    //   358: invokevirtual 443	java/io/DataOutputStream:flush	()V
    //   361: new 211	java/lang/StringBuffer
    //   364: dup
    //   365: invokespecial 212	java/lang/StringBuffer:<init>	()V
    //   368: astore_1
    //   369: new 190	java/io/BufferedReader
    //   372: dup
    //   373: new 192	java/io/InputStreamReader
    //   376: dup
    //   377: new 6	com/xiaomi/push/az$a
    //   380: dup
    //   381: aload_0
    //   382: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   385: invokespecial 199	com/xiaomi/push/az$a:<init>	(Ljava/io/InputStream;)V
    //   388: invokespecial 200	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   391: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   394: astore_0
    //   395: aload_0
    //   396: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   399: astore_2
    //   400: aload_2
    //   401: ifnull +12 -> 413
    //   404: aload_1
    //   405: aload_2
    //   406: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   409: pop
    //   410: goto -15 -> 395
    //   413: aload_1
    //   414: invokevirtual 224	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   417: astore_1
    //   418: aload_3
    //   419: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   422: aload_0
    //   423: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   426: aload_1
    //   427: areturn
    //   428: astore_1
    //   429: goto +12 -> 441
    //   432: astore_2
    //   433: aload_0
    //   434: astore_1
    //   435: goto +14 -> 449
    //   438: astore_1
    //   439: aconst_null
    //   440: astore_0
    //   441: aload_3
    //   442: astore_2
    //   443: goto +19 -> 462
    //   446: astore_2
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_3
    //   450: astore_0
    //   451: aload_2
    //   452: astore_3
    //   453: goto +24 -> 477
    //   456: astore_1
    //   457: aconst_null
    //   458: astore_0
    //   459: aload 6
    //   461: astore_2
    //   462: aload_0
    //   463: astore 6
    //   465: new 63	java/io/IOException
    //   468: dup
    //   469: aload_1
    //   470: invokevirtual 245	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   473: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   476: athrow
    //   477: aload_0
    //   478: astore_2
    //   479: aload_1
    //   480: astore 6
    //   482: new 159	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   489: astore 7
    //   491: aload_0
    //   492: astore_2
    //   493: aload_1
    //   494: astore 6
    //   496: aload 7
    //   498: ldc_w 306
    //   501: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_0
    //   506: astore_2
    //   507: aload_1
    //   508: astore 6
    //   510: aload 7
    //   512: aload_3
    //   513: invokevirtual 255	java/lang/Object:getClass	()Ljava/lang/Class;
    //   516: invokevirtual 260	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   519: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_0
    //   524: astore_2
    //   525: aload_1
    //   526: astore 6
    //   528: new 63	java/io/IOException
    //   531: dup
    //   532: aload 7
    //   534: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   540: athrow
    //   541: astore_0
    //   542: aload_2
    //   543: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   546: aload 6
    //   548: invokestatic 233	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   551: aload_0
    //   552: athrow
    //   553: astore_3
    //   554: aconst_null
    //   555: astore_1
    //   556: aload 7
    //   558: astore_0
    //   559: goto -82 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	paramString1	String
    //   0	562	1	paramMap	Map<String, String>
    //   0	562	2	paramFile	java.io.File
    //   0	562	3	paramString2	String
    //   299	12	4	i	int
    //   4	9	5	bool	boolean
    //   10	537	6	localObject1	Object
    //   7	550	7	localStringBuilder	StringBuilder
    //   23	242	8	localObject2	Object
    //   130	14	9	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   395	400	428	finally
    //   404	410	428	finally
    //   413	418	428	finally
    //   395	400	432	java/io/IOException
    //   404	410	432	java/io/IOException
    //   413	418	432	java/io/IOException
    //   288	294	438	finally
    //   294	301	438	finally
    //   307	319	438	finally
    //   322	395	438	finally
    //   288	294	446	java/io/IOException
    //   294	301	446	java/io/IOException
    //   307	319	446	java/io/IOException
    //   322	395	446	java/io/IOException
    //   25	96	456	finally
    //   100	112	456	finally
    //   112	156	456	finally
    //   159	288	456	finally
    //   465	477	541	finally
    //   482	491	541	finally
    //   496	505	541	finally
    //   510	523	541	finally
    //   528	541	541	finally
    //   25	96	553	java/io/IOException
    //   100	112	553	java/io/IOException
    //   112	156	553	java/io/IOException
    //   159	288	553	java/io/IOException
  }
  
  public static String a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject = paramMap.entrySet().iterator();
      StringBuilder localStringBuilder;
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
          try
          {
            localStringBuffer.append(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"));
            localStringBuffer.append("=");
            localStringBuffer.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
            localStringBuffer.append("&");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Failed to convert from params map to string: ");
            ((StringBuilder)localObject).append(localUnsupportedEncodingException.toString());
            Log.d("com.xiaomi.common.Network", ((StringBuilder)localObject).toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("map: ");
            localStringBuilder.append(paramMap.toString());
            Log.d("com.xiaomi.common.Network", localStringBuilder.toString());
            return null;
          }
        }
      }
      paramMap = localStringBuilder;
      if (localStringBuilder.length() > 0) {
        paramMap = localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      return paramMap.toString();
    }
    return null;
  }
  
  public static HttpURLConnection a(Context paramContext, URL paramURL)
  {
    if (!"http".equals(paramURL.getProtocol())) {}
    for (paramContext = paramURL.openConnection();; paramContext = paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))))
    {
      return (HttpURLConnection)paramContext;
      if (!a(paramContext)) {
        break;
      }
    }
  }
  
  private static URL a(String paramString)
  {
    return new URL(paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getExtraInfo();
      if (!TextUtils.isEmpty(paramContext))
      {
        if (paramContext.length() < 3) {
          return false;
        }
        if (paramContext.contains("ctwap")) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext) >= 0;
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (1 == paramContext.getType()) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    return (f(paramContext)) || (g(paramContext)) || (h(paramContext));
  }
  
  public static boolean f(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getType() != 0) {
      return false;
    }
    if (13 == paramContext.getSubtype()) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getType() != 0) {
      return false;
    }
    String str = paramContext.getSubtypeName();
    if ((!"TD-SCDMA".equalsIgnoreCase(str)) && (!"CDMA2000".equalsIgnoreCase(str)))
    {
      if ("WCDMA".equalsIgnoreCase(str)) {
        return true;
      }
      switch (paramContext.getSubtype())
      {
      case 4: 
      case 7: 
      case 11: 
      case 13: 
      default: 
        return false;
      }
    }
    return true;
  }
  
  public static boolean h(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getType() != 0) {
      return false;
    }
    int i = paramContext.getSubtype();
    return (i == 1) || (i == 2) || (i == 4) || (i == 7) || (i == 11);
  }
  
  public static final class a
    extends FilterInputStream
  {
    private boolean a;
    
    public a(InputStream paramInputStream)
    {
      super();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return 0;
    }
  }
  
  public static class b
  {
    public int a;
    public Map<String, String> a;
    
    public String toString()
    {
      return String.format("resCode = %1$d, headers = %2$s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilMap.toString() });
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */