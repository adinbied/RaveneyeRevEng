package com.xiaomi.push.service;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.x;
import java.io.File;
import java.io.InputStream;

public class ag
{
  private static long a;
  
  private static int a(Context paramContext, InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1))
    {
      int i = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * 48.0F);
      if ((localOptions.outWidth > i) && (localOptions.outHeight > i)) {
        return Math.min(localOptions.outWidth / i, localOptions.outHeight / i);
      }
      return 1;
    }
    b.a("decode dimension failed for bitmap.");
    return 1;
  }
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 81	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload 4
    //   14: invokevirtual 91	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokestatic 93	com/xiaomi/push/service/ag:a	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   23: istore_2
    //   24: aload_0
    //   25: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload 4
    //   30: invokevirtual 91	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   33: astore_0
    //   34: aload_1
    //   35: astore_3
    //   36: aload_0
    //   37: astore 4
    //   39: new 14	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 5
    //   48: aload_1
    //   49: astore_3
    //   50: aload_0
    //   51: astore 4
    //   53: aload 5
    //   55: iload_2
    //   56: putfield 96	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   59: aload_1
    //   60: astore_3
    //   61: aload_0
    //   62: astore 4
    //   64: aload_0
    //   65: aconst_null
    //   66: aload 5
    //   68: invokestatic 28	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: astore 5
    //   73: aload_0
    //   74: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   77: aload_1
    //   78: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   81: aload 5
    //   83: areturn
    //   84: astore 5
    //   86: goto +26 -> 112
    //   89: astore_0
    //   90: goto +48 -> 138
    //   93: astore 5
    //   95: aconst_null
    //   96: astore_0
    //   97: goto +15 -> 112
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: goto +35 -> 138
    //   106: astore 5
    //   108: aconst_null
    //   109: astore_0
    //   110: aload_0
    //   111: astore_1
    //   112: aload_1
    //   113: astore_3
    //   114: aload_0
    //   115: astore 4
    //   117: aload 5
    //   119: invokestatic 104	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   122: aload_0
    //   123: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   126: aload_1
    //   127: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: aload_3
    //   134: astore_1
    //   135: aload 4
    //   137: astore_3
    //   138: aload_3
    //   139: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   142: aload_1
    //   143: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   146: aload_0
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramContext	Context
    //   0	148	1	paramString	String
    //   23	33	2	i	int
    //   7	132	3	localObject1	Object
    //   4	132	4	localObject2	Object
    //   46	36	5	localObject3	Object
    //   84	1	5	localIOException1	java.io.IOException
    //   93	1	5	localIOException2	java.io.IOException
    //   106	12	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   39	48	84	java/io/IOException
    //   53	59	84	java/io/IOException
    //   64	73	84	java/io/IOException
    //   18	34	89	finally
    //   18	34	93	java/io/IOException
    //   8	18	100	finally
    //   8	18	106	java/io/IOException
    //   39	48	132	finally
    //   53	59	132	finally
    //   64	73	132	finally
    //   117	122	132	finally
  }
  
  /* Error */
  private static a a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 109	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 111	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 115	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 117	java/net/HttpURLConnection
    //   17: astore 4
    //   19: aload 4
    //   21: sipush 8000
    //   24: invokevirtual 121	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   27: aload 4
    //   29: sipush 20000
    //   32: invokevirtual 124	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   35: aload 4
    //   37: ldc 126
    //   39: ldc -128
    //   41: invokevirtual 132	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 4
    //   46: invokevirtual 135	java/net/HttpURLConnection:connect	()V
    //   49: aload 4
    //   51: invokevirtual 139	java/net/HttpURLConnection:getContentLength	()I
    //   54: istore_2
    //   55: iload_1
    //   56: ifeq +72 -> 128
    //   59: iload_2
    //   60: ldc -116
    //   62: if_icmple +66 -> 128
    //   65: new 142	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   72: astore 6
    //   74: aload 6
    //   76: ldc -111
    //   78: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: iload_2
    //   85: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 6
    //   91: ldc -102
    //   93: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 6
    //   99: aload_0
    //   100: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 6
    //   106: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 71	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   112: aconst_null
    //   113: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   116: aload 4
    //   118: ifnull +8 -> 126
    //   121: aload 4
    //   123: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   126: aconst_null
    //   127: areturn
    //   128: aload 4
    //   130: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   133: istore_2
    //   134: iload_2
    //   135: sipush 200
    //   138: if_icmpeq +59 -> 197
    //   141: new 142	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   148: astore 6
    //   150: aload 6
    //   152: ldc -90
    //   154: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 6
    //   160: iload_2
    //   161: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: ldc -88
    //   169: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 6
    //   175: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 71	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   181: aconst_null
    //   182: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   195: aconst_null
    //   196: areturn
    //   197: aload 4
    //   199: invokevirtual 172	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   202: astore 7
    //   204: aload 4
    //   206: astore 5
    //   208: aload 7
    //   210: astore 6
    //   212: new 174	java/io/ByteArrayOutputStream
    //   215: dup
    //   216: invokespecial 175	java/io/ByteArrayOutputStream:<init>	()V
    //   219: astore 8
    //   221: iload_1
    //   222: ifeq +389 -> 611
    //   225: ldc -116
    //   227: istore_2
    //   228: goto +3 -> 231
    //   231: aload 4
    //   233: astore 5
    //   235: aload 7
    //   237: astore 6
    //   239: sipush 1024
    //   242: newarray <illegal type>
    //   244: astore 9
    //   246: iload_2
    //   247: ifle +55 -> 302
    //   250: aload 4
    //   252: astore 5
    //   254: aload 7
    //   256: astore 6
    //   258: aload 7
    //   260: aload 9
    //   262: iconst_0
    //   263: sipush 1024
    //   266: invokevirtual 181	java/io/InputStream:read	([BII)I
    //   269: istore_3
    //   270: iload_3
    //   271: iconst_m1
    //   272: if_icmpne +6 -> 278
    //   275: goto +27 -> 302
    //   278: iload_2
    //   279: iload_3
    //   280: isub
    //   281: istore_2
    //   282: aload 4
    //   284: astore 5
    //   286: aload 7
    //   288: astore 6
    //   290: aload 8
    //   292: aload 9
    //   294: iconst_0
    //   295: iload_3
    //   296: invokevirtual 185	java/io/ByteArrayOutputStream:write	([BII)V
    //   299: goto -53 -> 246
    //   302: iload_2
    //   303: ifgt +54 -> 357
    //   306: aload 4
    //   308: astore 5
    //   310: aload 7
    //   312: astore 6
    //   314: ldc -69
    //   316: invokestatic 71	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   319: aload 4
    //   321: astore 5
    //   323: aload 7
    //   325: astore 6
    //   327: new 6	com/xiaomi/push/service/ag$a
    //   330: dup
    //   331: aconst_null
    //   332: ldc -116
    //   334: invokespecial 190	com/xiaomi/push/service/ag$a:<init>	([BI)V
    //   337: astore 8
    //   339: aload 7
    //   341: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   344: aload 4
    //   346: ifnull +8 -> 354
    //   349: aload 4
    //   351: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   354: aload 8
    //   356: areturn
    //   357: aload 4
    //   359: astore 5
    //   361: aload 7
    //   363: astore 6
    //   365: aload 8
    //   367: invokevirtual 194	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   370: astore 8
    //   372: aload 4
    //   374: astore 5
    //   376: aload 7
    //   378: astore 6
    //   380: new 6	com/xiaomi/push/service/ag$a
    //   383: dup
    //   384: aload 8
    //   386: aload 8
    //   388: arraylength
    //   389: invokespecial 190	com/xiaomi/push/service/ag$a:<init>	([BI)V
    //   392: astore 8
    //   394: aload 7
    //   396: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   399: aload 4
    //   401: ifnull +8 -> 409
    //   404: aload 4
    //   406: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   409: aload 8
    //   411: areturn
    //   412: astore 5
    //   414: aload 7
    //   416: astore_0
    //   417: aload 5
    //   419: astore 7
    //   421: goto +35 -> 456
    //   424: astore_0
    //   425: goto +154 -> 579
    //   428: astore 7
    //   430: aconst_null
    //   431: astore_0
    //   432: goto +24 -> 456
    //   435: aconst_null
    //   436: astore 7
    //   438: goto +53 -> 491
    //   441: astore_0
    //   442: aconst_null
    //   443: astore 4
    //   445: goto +134 -> 579
    //   448: astore 7
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 4
    //   455: astore_0
    //   456: aload 4
    //   458: astore 5
    //   460: aload_0
    //   461: astore 6
    //   463: aload 7
    //   465: invokestatic 104	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   468: aload_0
    //   469: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   472: aload 4
    //   474: ifnull +94 -> 568
    //   477: aload 4
    //   479: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   482: aconst_null
    //   483: areturn
    //   484: aconst_null
    //   485: astore 4
    //   487: aload 4
    //   489: astore 7
    //   491: aload 4
    //   493: astore 5
    //   495: aload 7
    //   497: astore 6
    //   499: new 142	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   506: astore 8
    //   508: aload 4
    //   510: astore 5
    //   512: aload 7
    //   514: astore 6
    //   516: aload 8
    //   518: ldc -60
    //   520: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 4
    //   526: astore 5
    //   528: aload 7
    //   530: astore 6
    //   532: aload 8
    //   534: aload_0
    //   535: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 4
    //   541: astore 5
    //   543: aload 7
    //   545: astore 6
    //   547: aload 8
    //   549: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 199	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   555: aload 7
    //   557: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   560: aload 4
    //   562: ifnull +6 -> 568
    //   565: goto -88 -> 477
    //   568: aconst_null
    //   569: areturn
    //   570: astore_0
    //   571: aload 5
    //   573: astore 4
    //   575: aload 6
    //   577: astore 5
    //   579: aload 5
    //   581: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   584: aload 4
    //   586: ifnull +8 -> 594
    //   589: aload 4
    //   591: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   594: aload_0
    //   595: athrow
    //   596: astore 4
    //   598: goto -114 -> 484
    //   601: astore 5
    //   603: goto -168 -> 435
    //   606: astore 5
    //   608: goto -117 -> 491
    //   611: ldc -56
    //   613: istore_2
    //   614: goto -383 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramString	String
    //   0	617	1	paramBoolean	boolean
    //   54	560	2	i	int
    //   269	27	3	j	int
    //   17	573	4	localObject1	Object
    //   596	1	4	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1	374	5	localObject2	Object
    //   412	6	5	localIOException1	java.io.IOException
    //   458	122	5	localObject3	Object
    //   601	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   606	1	5	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   72	504	6	localObject4	Object
    //   202	218	7	localObject5	Object
    //   428	1	7	localIOException2	java.io.IOException
    //   436	1	7	localObject6	Object
    //   448	16	7	localIOException3	java.io.IOException
    //   489	67	7	localObject7	Object
    //   219	329	8	localObject8	Object
    //   244	49	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   212	221	412	java/io/IOException
    //   239	246	412	java/io/IOException
    //   258	270	412	java/io/IOException
    //   290	299	412	java/io/IOException
    //   314	319	412	java/io/IOException
    //   327	339	412	java/io/IOException
    //   365	372	412	java/io/IOException
    //   380	394	412	java/io/IOException
    //   19	55	424	finally
    //   65	112	424	finally
    //   128	134	424	finally
    //   141	181	424	finally
    //   197	204	424	finally
    //   19	55	428	java/io/IOException
    //   65	112	428	java/io/IOException
    //   128	134	428	java/io/IOException
    //   141	181	428	java/io/IOException
    //   197	204	428	java/io/IOException
    //   3	19	441	finally
    //   3	19	448	java/io/IOException
    //   212	221	570	finally
    //   239	246	570	finally
    //   258	270	570	finally
    //   290	299	570	finally
    //   314	319	570	finally
    //   327	339	570	finally
    //   365	372	570	finally
    //   380	394	570	finally
    //   463	468	570	finally
    //   499	508	570	finally
    //   516	524	570	finally
    //   532	539	570	finally
    //   547	555	570	finally
    //   3	19	596	java/net/SocketTimeoutException
    //   19	55	601	java/net/SocketTimeoutException
    //   65	112	601	java/net/SocketTimeoutException
    //   128	134	601	java/net/SocketTimeoutException
    //   141	181	601	java/net/SocketTimeoutException
    //   197	204	601	java/net/SocketTimeoutException
    //   212	221	606	java/net/SocketTimeoutException
    //   239	246	606	java/net/SocketTimeoutException
    //   258	270	606	java/net/SocketTimeoutException
    //   290	299	606	java/net/SocketTimeoutException
    //   314	319	606	java/net/SocketTimeoutException
    //   327	339	606	java/net/SocketTimeoutException
    //   365	372	606	java/net/SocketTimeoutException
    //   380	394	606	java/net/SocketTimeoutException
  }
  
  /* Error */
  public static b a(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: new 9	com/xiaomi/push/service/ag$b
    //   12: dup
    //   13: aconst_null
    //   14: lconst_0
    //   15: invokespecial 206	com/xiaomi/push/service/ag$b:<init>	(Landroid/graphics/Bitmap;J)V
    //   18: astore 10
    //   20: aload_0
    //   21: aload_1
    //   22: invokestatic 208	com/xiaomi/push/service/ag:b	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnull +13 -> 42
    //   32: aload 10
    //   34: aload 4
    //   36: putfield 211	com/xiaomi/push/service/ag$b:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   39: aload 10
    //   41: areturn
    //   42: aload 8
    //   44: astore 5
    //   46: aload 9
    //   48: astore 6
    //   50: aload_1
    //   51: iload_2
    //   52: invokestatic 213	com/xiaomi/push/service/ag:a	(Ljava/lang/String;Z)Lcom/xiaomi/push/service/ag$a;
    //   55: astore 11
    //   57: aload 11
    //   59: ifnonnull +10 -> 69
    //   62: aconst_null
    //   63: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   66: aload 10
    //   68: areturn
    //   69: aload 8
    //   71: astore 5
    //   73: aload 9
    //   75: astore 6
    //   77: aload 10
    //   79: aload 11
    //   81: getfield 215	com/xiaomi/push/service/ag$a:jdField_a_of_type_Int	I
    //   84: i2l
    //   85: putfield 217	com/xiaomi/push/service/ag$b:jdField_a_of_type_Long	J
    //   88: aload 8
    //   90: astore 5
    //   92: aload 9
    //   94: astore 6
    //   96: aload 11
    //   98: getfield 220	com/xiaomi/push/service/ag$a:jdField_a_of_type_ArrayOfByte	[B
    //   101: astore 12
    //   103: aload 7
    //   105: astore 4
    //   107: aload 12
    //   109: ifnull +108 -> 217
    //   112: iload_2
    //   113: ifeq +78 -> 191
    //   116: aload 8
    //   118: astore 5
    //   120: aload 9
    //   122: astore 6
    //   124: new 222	java/io/ByteArrayInputStream
    //   127: dup
    //   128: aload 12
    //   130: invokespecial 225	java/io/ByteArrayInputStream:<init>	([B)V
    //   133: astore 4
    //   135: aload_0
    //   136: aload 4
    //   138: invokestatic 93	com/xiaomi/push/service/ag:a	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   141: istore_3
    //   142: new 14	android/graphics/BitmapFactory$Options
    //   145: dup
    //   146: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   149: astore 5
    //   151: aload 5
    //   153: iload_3
    //   154: putfield 96	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   157: aload 10
    //   159: aload 12
    //   161: iconst_0
    //   162: aload 12
    //   164: arraylength
    //   165: aload 5
    //   167: invokestatic 229	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   170: putfield 211	com/xiaomi/push/service/ag$b:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   173: goto +44 -> 217
    //   176: astore_0
    //   177: aload 4
    //   179: astore 5
    //   181: goto +82 -> 263
    //   184: astore_1
    //   185: aload 4
    //   187: astore_0
    //   188: goto +61 -> 249
    //   191: aload 8
    //   193: astore 5
    //   195: aload 9
    //   197: astore 6
    //   199: aload 10
    //   201: aload 12
    //   203: iconst_0
    //   204: aload 12
    //   206: arraylength
    //   207: invokestatic 232	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   210: putfield 211	com/xiaomi/push/service/ag$b:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   213: aload 7
    //   215: astore 4
    //   217: aload 4
    //   219: astore 5
    //   221: aload 4
    //   223: astore 6
    //   225: aload_0
    //   226: aload 11
    //   228: getfield 220	com/xiaomi/push/service/ag$a:jdField_a_of_type_ArrayOfByte	[B
    //   231: aload_1
    //   232: invokestatic 235	com/xiaomi/push/service/ag:a	(Landroid/content/Context;[BLjava/lang/String;)V
    //   235: aload 4
    //   237: astore_0
    //   238: goto +18 -> 256
    //   241: astore_0
    //   242: goto +21 -> 263
    //   245: astore_1
    //   246: aload 6
    //   248: astore_0
    //   249: aload_0
    //   250: astore 5
    //   252: aload_1
    //   253: invokestatic 104	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   256: aload_0
    //   257: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   260: aload 10
    //   262: areturn
    //   263: aload 5
    //   265: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   268: aload_0
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramContext	Context
    //   0	270	1	paramString	String
    //   0	270	2	paramBoolean	boolean
    //   141	13	3	i	int
    //   25	211	4	localObject1	Object
    //   44	220	5	localObject2	Object
    //   48	199	6	localObject3	Object
    //   7	207	7	localObject4	Object
    //   1	191	8	localObject5	Object
    //   4	192	9	localObject6	Object
    //   18	243	10	localb	b
    //   55	172	11	locala	a
    //   101	104	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   135	173	176	finally
    //   135	173	184	java/lang/Exception
    //   50	57	241	finally
    //   77	88	241	finally
    //   96	103	241	finally
    //   124	135	241	finally
    //   199	213	241	finally
    //   225	235	241	finally
    //   252	256	241	finally
    //   50	57	245	java/lang/Exception
    //   77	88	245	java/lang/Exception
    //   96	103	245	java/lang/Exception
    //   124	135	245	java/lang/Exception
    //   199	213	245	java/lang/Exception
    //   225	235	245	java/lang/Exception
  }
  
  private static void a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getCacheDir().getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("mipush_icon");
    paramContext = new File(localStringBuilder.toString());
    if (!paramContext.exists()) {
      return;
    }
    if (jdField_a_of_type_Long == 0L) {
      jdField_a_of_type_Long = x.a(paramContext);
    }
    if (jdField_a_of_type_Long > 15728640L) {
      try
      {
        paramContext = paramContext.listFiles();
        int i = 0;
        while (i < paramContext.length)
        {
          if ((!paramContext[i].isDirectory()) && (Math.abs(System.currentTimeMillis() - paramContext[i].lastModified()) > 1209600L)) {
            paramContext[i].delete();
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramContext)
      {
        b.a(paramContext);
        jdField_a_of_type_Long = 0L;
      }
    }
  }
  
  /* Error */
  private static void a(Context paramContext, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +10 -> 11
    //   4: ldc_w 291
    //   7: invokestatic 71	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   10: return
    //   11: aload_0
    //   12: invokestatic 293	com/xiaomi/push/service/ag:a	(Landroid/content/Context;)V
    //   15: new 142	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: invokevirtual 240	android/content/Context:getCacheDir	()Ljava/io/File;
    //   28: invokevirtual 245	java/io/File:getPath	()Ljava/lang/String;
    //   31: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: getstatic 249	java/io/File:separator	Ljava/lang/String;
    //   39: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_3
    //   44: ldc -5
    //   46: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: new 242	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 256	java/io/File:exists	()Z
    //   66: ifne +8 -> 74
    //   69: aload_3
    //   70: invokevirtual 296	java/io/File:mkdirs	()Z
    //   73: pop
    //   74: new 242	java/io/File
    //   77: dup
    //   78: aload_3
    //   79: aload_2
    //   80: invokestatic 301	com/xiaomi/push/bf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   86: astore 7
    //   88: aconst_null
    //   89: astore 5
    //   91: aconst_null
    //   92: astore 4
    //   94: aconst_null
    //   95: astore 6
    //   97: aload 7
    //   99: invokevirtual 256	java/io/File:exists	()Z
    //   102: ifne +9 -> 111
    //   105: aload 7
    //   107: invokevirtual 307	java/io/File:createNewFile	()Z
    //   110: pop
    //   111: new 309	java/io/FileOutputStream
    //   114: dup
    //   115: aload 7
    //   117: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: astore_2
    //   121: aload_2
    //   122: astore_3
    //   123: aload 5
    //   125: astore 4
    //   127: new 314	java/io/BufferedOutputStream
    //   130: dup
    //   131: aload_2
    //   132: invokespecial 317	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore 5
    //   137: aload 5
    //   139: aload_1
    //   140: invokevirtual 319	java/io/BufferedOutputStream:write	([B)V
    //   143: aload 5
    //   145: invokevirtual 322	java/io/BufferedOutputStream:flush	()V
    //   148: aload 5
    //   150: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   153: goto +51 -> 204
    //   156: astore_0
    //   157: aload 5
    //   159: astore 4
    //   161: goto +117 -> 278
    //   164: astore_1
    //   165: goto +24 -> 189
    //   168: astore_1
    //   169: aload 6
    //   171: astore 5
    //   173: goto +16 -> 189
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_2
    //   179: goto +99 -> 278
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_2
    //   185: aload 6
    //   187: astore 5
    //   189: aload_2
    //   190: astore_3
    //   191: aload 5
    //   193: astore 4
    //   195: aload_1
    //   196: invokestatic 104	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   199: aload 5
    //   201: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   204: aload_2
    //   205: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   208: getstatic 257	com/xiaomi/push/service/ag:jdField_a_of_type_Long	J
    //   211: lconst_0
    //   212: lcmp
    //   213: ifne +61 -> 274
    //   216: new 142	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   223: astore_1
    //   224: aload_1
    //   225: aload_0
    //   226: invokevirtual 240	android/content/Context:getCacheDir	()Ljava/io/File;
    //   229: invokevirtual 245	java/io/File:getPath	()Ljava/lang/String;
    //   232: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: getstatic 249	java/io/File:separator	Ljava/lang/String;
    //   240: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: ldc -5
    //   247: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: new 242	java/io/File
    //   254: dup
    //   255: aload_1
    //   256: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: invokestatic 262	com/xiaomi/push/x:a	(Ljava/io/File;)J
    //   265: aload 7
    //   267: invokevirtual 325	java/io/File:length	()J
    //   270: ladd
    //   271: putstatic 257	com/xiaomi/push/service/ag:jdField_a_of_type_Long	J
    //   274: return
    //   275: astore_0
    //   276: aload_3
    //   277: astore_2
    //   278: aload 4
    //   280: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   283: aload_2
    //   284: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   287: aload_0
    //   288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContext	Context
    //   0	289	1	paramArrayOfByte	byte[]
    //   0	289	2	paramString	String
    //   22	255	3	localObject1	Object
    //   92	187	4	localObject2	Object
    //   89	111	5	localObject3	Object
    //   95	91	6	localObject4	Object
    //   86	180	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   137	148	156	finally
    //   137	148	164	java/lang/Exception
    //   127	137	168	java/lang/Exception
    //   97	111	176	finally
    //   111	121	176	finally
    //   97	111	182	java/lang/Exception
    //   111	121	182	java/lang/Exception
    //   127	137	275	finally
    //   195	199	275	finally
  }
  
  /* Error */
  private static Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 142	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokevirtual 240	android/content/Context:getCacheDir	()Ljava/io/File;
    //   13: invokevirtual 245	java/io/File:getPath	()Ljava/lang/String;
    //   16: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: getstatic 249	java/io/File:separator	Ljava/lang/String;
    //   24: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc -5
    //   31: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: new 242	java/io/File
    //   38: dup
    //   39: aload_3
    //   40: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: aload_1
    //   44: invokestatic 301	com/xiaomi/push/bf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: astore 5
    //   52: aload 5
    //   54: invokevirtual 256	java/io/File:exists	()Z
    //   57: istore_2
    //   58: aconst_null
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_3
    //   62: aconst_null
    //   63: astore 4
    //   65: iload_2
    //   66: ifne +5 -> 71
    //   69: aconst_null
    //   70: areturn
    //   71: new 329	java/io/FileInputStream
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 330	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   80: astore_1
    //   81: aload 4
    //   83: astore_0
    //   84: aload_1
    //   85: invokestatic 333	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   88: astore_3
    //   89: aload_3
    //   90: astore_0
    //   91: aload 5
    //   93: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   96: invokevirtual 337	java/io/File:setLastModified	(J)Z
    //   99: pop
    //   100: aload_1
    //   101: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   104: aload_3
    //   105: areturn
    //   106: astore_3
    //   107: aload_1
    //   108: astore_0
    //   109: aload_3
    //   110: astore_1
    //   111: goto +35 -> 146
    //   114: astore_3
    //   115: aload_0
    //   116: astore 4
    //   118: goto +15 -> 133
    //   121: astore_1
    //   122: goto +24 -> 146
    //   125: astore_0
    //   126: aconst_null
    //   127: astore 4
    //   129: aload_3
    //   130: astore_1
    //   131: aload_0
    //   132: astore_3
    //   133: aload_1
    //   134: astore_0
    //   135: aload_3
    //   136: invokestatic 104	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   139: aload_1
    //   140: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   143: aload 4
    //   145: areturn
    //   146: aload_0
    //   147: invokestatic 101	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramContext	Context
    //   0	152	1	paramString	String
    //   57	9	2	bool	boolean
    //   7	98	3	localObject1	Object
    //   106	4	3	localObject2	Object
    //   114	16	3	localException	Exception
    //   132	4	3	localContext1	Context
    //   63	81	4	localContext2	Context
    //   50	42	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   84	89	106	finally
    //   91	100	106	finally
    //   84	89	114	java/lang/Exception
    //   91	100	114	java/lang/Exception
    //   71	81	121	finally
    //   135	139	121	finally
    //   71	81	125	java/lang/Exception
  }
  
  public static class a
  {
    int jdField_a_of_type_Int;
    byte[] jdField_a_of_type_ArrayOfByte;
    
    public a(byte[] paramArrayOfByte, int paramInt)
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public static class b
  {
    public long a;
    public Bitmap a;
    
    public b(Bitmap paramBitmap, long paramLong)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Long = paramLong;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */