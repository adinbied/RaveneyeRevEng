package com.huawei.hianalytics.h;

import android.os.Build;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public abstract class d
{
  public static e a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "POST", null);
  }
  
  public static e a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("App-Id", com.huawei.hianalytics.a.b.e());
    localHashMap.put("App-Ver", com.huawei.hianalytics.a.b.f());
    localHashMap.put("Sdk-Name", "hianalytics");
    localHashMap.put("Sdk-Ver", "2.1.3.300");
    localHashMap.put("Device-Type", Build.MODEL);
    localHashMap.put("Package-Name", com.huawei.hianalytics.a.b.d());
    localHashMap.put("Authorization", paramString3);
    localHashMap.put("Charset", "UTF-8");
    localHashMap.put("Content-Encoding", "gzip");
    localHashMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    return a(paramString1, paramString2, "POST", localHashMap);
  }
  
  /* Error */
  private static e a(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +15 -> 19
    //   7: new 85	com/huawei/hianalytics/h/e
    //   10: dup
    //   11: bipush -100
    //   13: ldc 87
    //   15: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   18: areturn
    //   19: bipush -102
    //   21: istore 5
    //   23: aconst_null
    //   24: astore 6
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 9
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 96	java/lang/String:length	()I
    //   37: aload_2
    //   38: aload_3
    //   39: invokestatic 99	com/huawei/hianalytics/h/d:a	(Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   42: astore_0
    //   43: aload_0
    //   44: ifnonnull +61 -> 105
    //   47: new 85	com/huawei/hianalytics/h/e
    //   50: dup
    //   51: bipush -101
    //   53: ldc 87
    //   55: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   58: astore_1
    //   59: bipush 9
    //   61: aconst_null
    //   62: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   65: bipush 6
    //   67: aconst_null
    //   68: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   71: aload_0
    //   72: ifnull +31 -> 103
    //   75: aload_0
    //   76: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   79: invokevirtual 115	java/io/InputStream:close	()V
    //   82: goto +10 -> 92
    //   85: ldc 117
    //   87: ldc 119
    //   89: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   96: ldc 117
    //   98: ldc -127
    //   100: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_1
    //   104: areturn
    //   105: aload_0
    //   106: invokevirtual 135	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   109: astore_2
    //   110: aload 6
    //   112: astore_3
    //   113: aload_0
    //   114: astore 6
    //   116: aload_2
    //   117: astore 7
    //   119: new 137	java/io/BufferedWriter
    //   122: dup
    //   123: new 139	java/io/OutputStreamWriter
    //   126: dup
    //   127: aload_2
    //   128: ldc 67
    //   130: invokespecial 142	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   133: invokespecial 145	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   136: astore 8
    //   138: iload 5
    //   140: istore 4
    //   142: aload 8
    //   144: aload_1
    //   145: invokevirtual 149	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   148: pop
    //   149: iload 5
    //   151: istore 4
    //   153: aload 8
    //   155: invokevirtual 152	java/io/BufferedWriter:flush	()V
    //   158: iload 5
    //   160: istore 4
    //   162: aload_0
    //   163: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   166: istore 5
    //   168: iload 5
    //   170: istore 4
    //   172: new 85	com/huawei/hianalytics/h/e
    //   175: dup
    //   176: iload 5
    //   178: aload_0
    //   179: invokestatic 159	com/huawei/hianalytics/h/d:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   182: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   185: astore_1
    //   186: bipush 9
    //   188: aload 8
    //   190: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   193: bipush 6
    //   195: aload_2
    //   196: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   199: aload_0
    //   200: ifnull +31 -> 231
    //   203: aload_0
    //   204: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   207: invokevirtual 115	java/io/InputStream:close	()V
    //   210: goto +10 -> 220
    //   213: ldc 117
    //   215: ldc 119
    //   217: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   224: ldc 117
    //   226: ldc -127
    //   228: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_1
    //   232: areturn
    //   233: astore_1
    //   234: aload 8
    //   236: astore_3
    //   237: aload_0
    //   238: astore 6
    //   240: aload_1
    //   241: astore_0
    //   242: aload_2
    //   243: astore_1
    //   244: goto +197 -> 441
    //   247: aload 8
    //   249: astore_1
    //   250: aload_0
    //   251: astore 8
    //   253: aload_2
    //   254: astore_0
    //   255: goto +96 -> 351
    //   258: astore_2
    //   259: aconst_null
    //   260: astore_1
    //   261: aload 7
    //   263: astore_3
    //   264: aload_0
    //   265: astore 6
    //   267: aload_2
    //   268: astore_0
    //   269: goto +172 -> 441
    //   272: aconst_null
    //   273: astore_2
    //   274: iload 5
    //   276: istore 4
    //   278: aload 9
    //   280: astore_1
    //   281: aload_0
    //   282: astore 8
    //   284: aload_2
    //   285: astore_0
    //   286: goto +65 -> 351
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 6
    //   293: aload 6
    //   295: astore_1
    //   296: aload 7
    //   298: astore_3
    //   299: goto +142 -> 441
    //   302: aconst_null
    //   303: astore 8
    //   305: aload 8
    //   307: astore_0
    //   308: iload 5
    //   310: istore 4
    //   312: aload 9
    //   314: astore_1
    //   315: goto +36 -> 351
    //   318: ldc 117
    //   320: ldc -95
    //   322: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: new 85	com/huawei/hianalytics/h/e
    //   328: dup
    //   329: bipush -101
    //   331: ldc 87
    //   333: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   336: astore_0
    //   337: bipush 9
    //   339: aconst_null
    //   340: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   343: bipush 6
    //   345: aconst_null
    //   346: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   349: aload_0
    //   350: areturn
    //   351: aload_1
    //   352: astore_3
    //   353: aload 8
    //   355: astore 6
    //   357: aload_0
    //   358: astore 7
    //   360: ldc 117
    //   362: ldc -93
    //   364: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload_1
    //   368: astore_3
    //   369: aload 8
    //   371: astore 6
    //   373: aload_0
    //   374: astore 7
    //   376: new 85	com/huawei/hianalytics/h/e
    //   379: dup
    //   380: iload 4
    //   382: ldc 87
    //   384: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   387: astore_2
    //   388: bipush 9
    //   390: aload_1
    //   391: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   394: bipush 6
    //   396: aload_0
    //   397: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   400: aload 8
    //   402: ifnull +33 -> 435
    //   405: aload 8
    //   407: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   410: invokevirtual 115	java/io/InputStream:close	()V
    //   413: goto +10 -> 423
    //   416: ldc 117
    //   418: ldc 119
    //   420: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload 8
    //   425: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   428: ldc 117
    //   430: ldc -127
    //   432: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_2
    //   436: areturn
    //   437: astore_0
    //   438: aload 7
    //   440: astore_1
    //   441: bipush 9
    //   443: aload_3
    //   444: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   447: bipush 6
    //   449: aload_1
    //   450: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   453: aload 6
    //   455: ifnull +33 -> 488
    //   458: aload 6
    //   460: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   463: invokevirtual 115	java/io/InputStream:close	()V
    //   466: goto +10 -> 476
    //   469: ldc 117
    //   471: ldc 119
    //   473: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload 6
    //   478: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   481: ldc 117
    //   483: ldc -127
    //   485: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_0
    //   489: athrow
    //   490: astore_0
    //   491: goto -173 -> 318
    //   494: astore_0
    //   495: goto -193 -> 302
    //   498: astore_1
    //   499: goto -227 -> 272
    //   502: astore_2
    //   503: goto -418 -> 85
    //   506: astore_1
    //   507: iload 5
    //   509: istore 4
    //   511: aload 9
    //   513: astore_1
    //   514: aload_0
    //   515: astore 8
    //   517: aload_2
    //   518: astore_0
    //   519: goto -168 -> 351
    //   522: astore_1
    //   523: goto -276 -> 247
    //   526: astore_2
    //   527: goto -314 -> 213
    //   530: astore_0
    //   531: goto -115 -> 416
    //   534: astore_1
    //   535: goto -66 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	paramString1	String
    //   0	538	1	paramString2	String
    //   0	538	2	paramString3	String
    //   0	538	3	paramMap	Map<String, String>
    //   140	370	4	i	int
    //   21	487	5	j	int
    //   24	453	6	localObject1	Object
    //   27	412	7	str	String
    //   136	380	8	localObject2	Object
    //   30	482	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   142	149	233	finally
    //   153	158	233	finally
    //   162	168	233	finally
    //   172	186	233	finally
    //   47	59	258	finally
    //   105	110	258	finally
    //   32	43	289	finally
    //   318	337	289	finally
    //   119	138	437	finally
    //   360	367	437	finally
    //   376	388	437	finally
    //   32	43	490	com/huawei/hianalytics/h/d$a
    //   32	43	494	java/io/IOException
    //   318	337	494	java/io/IOException
    //   47	59	498	java/io/IOException
    //   105	110	498	java/io/IOException
    //   75	82	502	java/io/IOException
    //   119	138	506	java/io/IOException
    //   142	149	522	java/io/IOException
    //   153	158	522	java/io/IOException
    //   162	168	522	java/io/IOException
    //   172	186	522	java/io/IOException
    //   203	210	526	java/io/IOException
    //   405	413	530	java/io/IOException
    //   458	466	534	java/io/IOException
  }
  
  /* Error */
  public static e a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +15 -> 19
    //   7: new 85	com/huawei/hianalytics/h/e
    //   10: dup
    //   11: bipush -100
    //   13: ldc 87
    //   15: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   18: areturn
    //   19: bipush -102
    //   21: istore 5
    //   23: aconst_null
    //   24: astore 6
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 10
    //   32: aload_0
    //   33: aload_1
    //   34: arraylength
    //   35: aload_2
    //   36: aload_3
    //   37: invokestatic 99	com/huawei/hianalytics/h/d:a	(Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnonnull +60 -> 102
    //   45: new 85	com/huawei/hianalytics/h/e
    //   48: dup
    //   49: bipush -101
    //   51: ldc 87
    //   53: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   56: astore_1
    //   57: iconst_3
    //   58: aconst_null
    //   59: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   62: bipush 6
    //   64: aconst_null
    //   65: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   68: aload_0
    //   69: ifnull +31 -> 100
    //   72: aload_0
    //   73: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   76: invokevirtual 115	java/io/InputStream:close	()V
    //   79: goto +10 -> 89
    //   82: ldc 117
    //   84: ldc -88
    //   86: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_0
    //   90: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   93: ldc 117
    //   95: ldc -86
    //   97: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: areturn
    //   102: aload_0
    //   103: invokevirtual 135	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   106: astore_3
    //   107: aload 6
    //   109: astore 7
    //   111: aload_0
    //   112: astore 8
    //   114: aload_3
    //   115: astore 9
    //   117: new 172	java/io/BufferedOutputStream
    //   120: dup
    //   121: aload_3
    //   122: invokespecial 175	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   125: astore_2
    //   126: iload 5
    //   128: istore 4
    //   130: aload_2
    //   131: aload_1
    //   132: invokevirtual 179	java/io/BufferedOutputStream:write	([B)V
    //   135: iload 5
    //   137: istore 4
    //   139: aload_2
    //   140: invokevirtual 180	java/io/BufferedOutputStream:flush	()V
    //   143: iload 5
    //   145: istore 4
    //   147: aload_0
    //   148: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   151: istore 5
    //   153: iload 5
    //   155: istore 4
    //   157: new 85	com/huawei/hianalytics/h/e
    //   160: dup
    //   161: iload 5
    //   163: aload_0
    //   164: invokestatic 159	com/huawei/hianalytics/h/d:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   167: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   170: astore_1
    //   171: iconst_3
    //   172: aload_2
    //   173: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   176: bipush 6
    //   178: aload_3
    //   179: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   182: aload_0
    //   183: ifnull +31 -> 214
    //   186: aload_0
    //   187: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   190: invokevirtual 115	java/io/InputStream:close	()V
    //   193: goto +10 -> 203
    //   196: ldc 117
    //   198: ldc -88
    //   200: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   207: ldc 117
    //   209: ldc -86
    //   211: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_1
    //   215: areturn
    //   216: astore_1
    //   217: aload_2
    //   218: astore 7
    //   220: aload_0
    //   221: astore 8
    //   223: aload_1
    //   224: astore_0
    //   225: aload_3
    //   226: astore_1
    //   227: goto +302 -> 529
    //   230: astore_1
    //   231: aload_0
    //   232: astore 6
    //   234: aload_1
    //   235: astore_0
    //   236: aload_3
    //   237: astore_1
    //   238: goto +109 -> 347
    //   241: astore_1
    //   242: iload 5
    //   244: istore 4
    //   246: aload 10
    //   248: astore_2
    //   249: aload_0
    //   250: astore 6
    //   252: aload_1
    //   253: astore_0
    //   254: aload_3
    //   255: astore_1
    //   256: goto +91 -> 347
    //   259: astore_2
    //   260: aconst_null
    //   261: astore_1
    //   262: aload_0
    //   263: astore 8
    //   265: aload_2
    //   266: astore_0
    //   267: goto +262 -> 529
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: iload 5
    //   275: istore 4
    //   277: aload 10
    //   279: astore_2
    //   280: aload_0
    //   281: astore 6
    //   283: aload_3
    //   284: astore_0
    //   285: goto +62 -> 347
    //   288: astore_0
    //   289: aconst_null
    //   290: astore 8
    //   292: aload 8
    //   294: astore_1
    //   295: goto +234 -> 529
    //   298: astore_0
    //   299: aconst_null
    //   300: astore 6
    //   302: aload 6
    //   304: astore_1
    //   305: iload 5
    //   307: istore 4
    //   309: aload 10
    //   311: astore_2
    //   312: goto +35 -> 347
    //   315: ldc 117
    //   317: ldc -74
    //   319: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: new 85	com/huawei/hianalytics/h/e
    //   325: dup
    //   326: bipush -101
    //   328: ldc 87
    //   330: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   333: astore_0
    //   334: iconst_3
    //   335: aconst_null
    //   336: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   339: bipush 6
    //   341: aconst_null
    //   342: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   345: aload_0
    //   346: areturn
    //   347: aload_2
    //   348: astore 7
    //   350: aload 6
    //   352: astore 8
    //   354: aload_1
    //   355: astore 9
    //   357: aload_0
    //   358: instanceof 184
    //   361: ifeq +25 -> 386
    //   364: ldc -70
    //   366: astore_0
    //   367: aload_2
    //   368: astore 7
    //   370: aload 6
    //   372: astore 8
    //   374: aload_1
    //   375: astore 9
    //   377: ldc 117
    //   379: aload_0
    //   380: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: goto +72 -> 455
    //   386: aload_2
    //   387: astore 7
    //   389: aload 6
    //   391: astore 8
    //   393: aload_1
    //   394: astore 9
    //   396: aload_0
    //   397: instanceof 188
    //   400: ifeq +9 -> 409
    //   403: ldc -66
    //   405: astore_0
    //   406: goto -39 -> 367
    //   409: aload_2
    //   410: astore 7
    //   412: aload 6
    //   414: astore 8
    //   416: aload_1
    //   417: astore 9
    //   419: aload_0
    //   420: instanceof 192
    //   423: ifeq +9 -> 432
    //   426: ldc -62
    //   428: astore_0
    //   429: goto -62 -> 367
    //   432: aload_2
    //   433: astore 7
    //   435: aload 6
    //   437: astore 8
    //   439: aload_1
    //   440: astore 9
    //   442: aload_0
    //   443: instanceof 196
    //   446: ifeq +152 -> 598
    //   449: ldc -58
    //   451: astore_0
    //   452: goto -85 -> 367
    //   455: aload_2
    //   456: astore 7
    //   458: aload 6
    //   460: astore 8
    //   462: aload_1
    //   463: astore 9
    //   465: new 85	com/huawei/hianalytics/h/e
    //   468: dup
    //   469: iload 4
    //   471: ldc 87
    //   473: invokespecial 90	com/huawei/hianalytics/h/e:<init>	(ILjava/lang/String;)V
    //   476: astore_0
    //   477: iconst_3
    //   478: aload_2
    //   479: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   482: bipush 6
    //   484: aload_1
    //   485: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   488: aload 6
    //   490: ifnull +33 -> 523
    //   493: aload 6
    //   495: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   498: invokevirtual 115	java/io/InputStream:close	()V
    //   501: goto +10 -> 511
    //   504: ldc 117
    //   506: ldc -88
    //   508: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload 6
    //   513: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   516: ldc 117
    //   518: ldc -86
    //   520: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload_0
    //   524: areturn
    //   525: astore_0
    //   526: aload 9
    //   528: astore_1
    //   529: iconst_3
    //   530: aload 7
    //   532: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   535: bipush 6
    //   537: aload_1
    //   538: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   541: aload 8
    //   543: ifnull +33 -> 576
    //   546: aload 8
    //   548: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   551: invokevirtual 115	java/io/InputStream:close	()V
    //   554: goto +10 -> 564
    //   557: ldc 117
    //   559: ldc -88
    //   561: invokestatic 125	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 8
    //   566: invokevirtual 128	java/net/HttpURLConnection:disconnect	()V
    //   569: ldc 117
    //   571: ldc -86
    //   573: invokestatic 131	com/huawei/hianalytics/g/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload_0
    //   577: athrow
    //   578: astore_0
    //   579: goto -264 -> 315
    //   582: astore_2
    //   583: goto -501 -> 82
    //   586: astore_2
    //   587: goto -391 -> 196
    //   590: astore_1
    //   591: goto -87 -> 504
    //   594: astore_1
    //   595: goto -38 -> 557
    //   598: ldc -56
    //   600: astore_0
    //   601: goto -234 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	paramString1	String
    //   0	604	1	paramArrayOfByte	byte[]
    //   0	604	2	paramString2	String
    //   0	604	3	paramMap	Map<String, String>
    //   128	342	4	i	int
    //   21	285	5	j	int
    //   24	488	6	str1	String
    //   27	504	7	str2	String
    //   112	453	8	str3	String
    //   115	412	9	localObject1	Object
    //   30	280	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   130	135	216	finally
    //   139	143	216	finally
    //   147	153	216	finally
    //   157	171	216	finally
    //   130	135	230	java/io/IOException
    //   139	143	230	java/io/IOException
    //   147	153	230	java/io/IOException
    //   157	171	230	java/io/IOException
    //   117	126	241	java/io/IOException
    //   45	57	259	finally
    //   102	107	259	finally
    //   45	57	270	java/io/IOException
    //   102	107	270	java/io/IOException
    //   32	41	288	finally
    //   315	334	288	finally
    //   32	41	298	java/io/IOException
    //   315	334	298	java/io/IOException
    //   117	126	525	finally
    //   357	364	525	finally
    //   377	383	525	finally
    //   396	403	525	finally
    //   419	426	525	finally
    //   442	449	525	finally
    //   465	477	525	finally
    //   32	41	578	com/huawei/hianalytics/h/d$a
    //   72	79	582	java/io/IOException
    //   186	193	586	java/io/IOException
    //   493	501	590	java/io/IOException
    //   546	554	594	java/io/IOException
  }
  
  public static e a(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    return a(paramString, paramArrayOfByte, "POST", paramMap);
  }
  
  private static HttpURLConnection a(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      com.huawei.hianalytics.g.b.d("HttpClient", "CreateConnection: invalid urlPath.");
      return null;
    }
    paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
    a(paramString1);
    paramString1.setRequestMethod(paramString2);
    paramString1.setConnectTimeout(16000);
    paramString1.setDoOutput(true);
    paramString1.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    paramString1.setRequestProperty("Content-Length", String.valueOf(paramInt));
    paramString1.setRequestProperty("App-Ver", "2.1.3.300");
    paramString1.setRequestProperty("Connection", "close");
    if (paramMap != null)
    {
      if (paramMap.size() < 1) {
        return paramString1;
      }
      paramString2 = paramMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramMap = (Map.Entry)paramString2.next();
        String str = (String)paramMap.getKey();
        if ((str != null) && (!TextUtils.isEmpty(str))) {
          paramString1.setRequestProperty(str, (String)paramMap.getValue());
        }
      }
    }
    return paramString1;
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
  {
    if ((paramHttpURLConnection instanceof HttpsURLConnection))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      SocketFactory localSocketFactory = c.a();
      if ((localSocketFactory != null) && ((localSocketFactory instanceof SSLSocketFactory)))
      {
        paramHttpURLConnection.setSSLSocketFactory((SSLSocketFactory)localSocketFactory);
        return;
      }
      throw new a("No ssl socket factory set");
    }
  }
  
  /* Error */
  private static String b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: aload_3
    //   12: astore_2
    //   13: aload_3
    //   14: sipush 2048
    //   17: invokestatic 297	com/huawei/hianalytics/util/e:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   20: astore 4
    //   22: bipush 7
    //   24: aload_3
    //   25: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   28: aload 4
    //   30: areturn
    //   31: astore_0
    //   32: goto +36 -> 68
    //   35: aload_2
    //   36: astore_1
    //   37: ldc 117
    //   39: ldc_w 299
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_0
    //   49: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   52: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 307	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: bipush 7
    //   61: aload_2
    //   62: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   65: ldc 87
    //   67: areturn
    //   68: bipush 7
    //   70: aload_1
    //   71: invokestatic 104	com/huawei/hianalytics/util/e:a	(ILjava/io/Closeable;)V
    //   74: aload_0
    //   75: athrow
    //   76: astore_1
    //   77: goto -42 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramHttpURLConnection	HttpURLConnection
    //   3	68	1	localObject1	Object
    //   76	1	1	localIOException	java.io.IOException
    //   1	61	2	localObject2	Object
    //   8	17	3	localInputStream	java.io.InputStream
    //   20	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	9	31	finally
    //   13	22	31	finally
    //   37	59	31	finally
    //   4	9	76	java/io/IOException
    //   13	22	76	java/io/IOException
  }
  
  private static class a
    extends Exception
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */