package com.xiaomi.push;

import android.os.Environment;
import java.io.File;

public class ag
{
  private static final String a;
  private static final String b;
  private static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/mipush/");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("lcfp");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("lcfp.lock");
    c = localStringBuilder.toString();
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 9
    //   12: new 23	java/io/File
    //   15: dup
    //   16: getstatic 46	com/xiaomi/push/ag:c	Ljava/lang/String;
    //   19: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: invokestatic 58	com/xiaomi/push/y:a	(Ljava/io/File;)Z
    //   29: pop
    //   30: new 60	java/io/RandomAccessFile
    //   33: dup
    //   34: aload 8
    //   36: ldc 62
    //   38: invokespecial 65	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore 8
    //   43: aload 9
    //   45: astore 7
    //   47: aload 6
    //   49: astore 5
    //   51: aload 8
    //   53: astore 6
    //   55: aload 8
    //   57: invokevirtual 69	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   60: invokevirtual 75	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   63: astore 9
    //   65: aload 9
    //   67: astore 7
    //   69: aload 9
    //   71: astore 5
    //   73: aload 8
    //   75: astore 6
    //   77: aload_0
    //   78: aload_1
    //   79: lload_2
    //   80: invokestatic 77	com/xiaomi/push/ag:b	(Landroid/content/Context;Ljava/lang/String;J)Z
    //   83: istore 4
    //   85: aload 9
    //   87: ifnull +16 -> 103
    //   90: aload 9
    //   92: invokevirtual 83	java/nio/channels/FileLock:isValid	()Z
    //   95: ifeq +8 -> 103
    //   98: aload 9
    //   100: invokevirtual 86	java/nio/channels/FileLock:release	()V
    //   103: aload 8
    //   105: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   108: iload 4
    //   110: ireturn
    //   111: astore_1
    //   112: aload 8
    //   114: astore_0
    //   115: goto +13 -> 128
    //   118: astore_0
    //   119: aconst_null
    //   120: astore 6
    //   122: goto +42 -> 164
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: aload 7
    //   130: astore 5
    //   132: aload_0
    //   133: astore 6
    //   135: aload_1
    //   136: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   139: aload 7
    //   141: ifnull +16 -> 157
    //   144: aload 7
    //   146: invokevirtual 83	java/nio/channels/FileLock:isValid	()Z
    //   149: ifeq +8 -> 157
    //   152: aload 7
    //   154: invokevirtual 86	java/nio/channels/FileLock:release	()V
    //   157: aload_0
    //   158: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   161: iconst_1
    //   162: ireturn
    //   163: astore_0
    //   164: aload 5
    //   166: ifnull +16 -> 182
    //   169: aload 5
    //   171: invokevirtual 83	java/nio/channels/FileLock:isValid	()Z
    //   174: ifeq +8 -> 182
    //   177: aload 5
    //   179: invokevirtual 86	java/nio/channels/FileLock:release	()V
    //   182: aload 6
    //   184: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   187: aload_0
    //   188: athrow
    //   189: astore_0
    //   190: goto -87 -> 103
    //   193: astore_1
    //   194: goto -37 -> 157
    //   197: astore_1
    //   198: goto -16 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramContext	android.content.Context
    //   0	201	1	paramString	String
    //   0	201	2	paramLong	long
    //   83	26	4	bool	boolean
    //   7	171	5	localObject1	Object
    //   4	179	6	localObject2	Object
    //   1	152	7	localObject3	Object
    //   22	91	8	localObject4	Object
    //   10	89	9	localFileLock	java.nio.channels.FileLock
    // Exception table:
    //   from	to	target	type
    //   55	65	111	java/io/IOException
    //   77	85	111	java/io/IOException
    //   12	43	118	finally
    //   12	43	125	java/io/IOException
    //   55	65	163	finally
    //   77	85	163	finally
    //   135	139	163	finally
    //   98	103	189	java/io/IOException
    //   152	157	193	java/io/IOException
    //   177	182	197	java/io/IOException
  }
  
  /* Error */
  private static boolean b(android.content.Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 23
    //   5: if_icmplt +14 -> 19
    //   8: aload_0
    //   9: ldc 102
    //   11: invokestatic 107	com/xiaomi/push/g:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +5 -> 19
    //   17: iconst_1
    //   18: ireturn
    //   19: new 23	java/io/File
    //   22: dup
    //   23: getstatic 42	com/xiaomi/push/ag:b	Ljava/lang/String;
    //   26: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 11
    //   31: new 109	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 110	java/util/ArrayList:<init>	()V
    //   38: astore 10
    //   40: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   43: lstore 4
    //   45: new 12	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   52: astore 8
    //   54: aload 8
    //   56: aload_1
    //   57: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: ldc 118
    //   65: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 8
    //   71: aload_0
    //   72: invokevirtual 123	android/content/Context:getPackageName	()Ljava/lang/String;
    //   75: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 8
    //   81: ldc 125
    //   83: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: lload 4
    //   91: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 8
    //   97: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 12
    //   102: aload 11
    //   104: invokevirtual 131	java/io/File:exists	()Z
    //   107: ifeq +239 -> 346
    //   110: new 133	java/io/BufferedReader
    //   113: dup
    //   114: new 135	java/io/FileReader
    //   117: dup
    //   118: aload 11
    //   120: invokespecial 138	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   123: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore 8
    //   128: aload 8
    //   130: astore 9
    //   132: aload 8
    //   134: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore 13
    //   139: aload 8
    //   141: astore 9
    //   143: aload 13
    //   145: ifnull +183 -> 328
    //   148: aload 8
    //   150: astore 9
    //   152: aload 13
    //   154: ldc 118
    //   156: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   159: astore 14
    //   161: aload 8
    //   163: astore 9
    //   165: aload 14
    //   167: arraylength
    //   168: iconst_2
    //   169: if_icmpeq +6 -> 175
    //   172: goto -44 -> 128
    //   175: aload 8
    //   177: astore 9
    //   179: aload 14
    //   181: iconst_0
    //   182: aaload
    //   183: aload_1
    //   184: invokestatic 154	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokestatic 160	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   190: ifeq +100 -> 290
    //   193: aload 8
    //   195: astore 9
    //   197: aload 14
    //   199: iconst_1
    //   200: aaload
    //   201: ldc 125
    //   203: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   206: astore 13
    //   208: aload 8
    //   210: astore 9
    //   212: aload 13
    //   214: arraylength
    //   215: iconst_2
    //   216: if_icmpeq +6 -> 222
    //   219: goto -91 -> 128
    //   222: aload 8
    //   224: astore 9
    //   226: aload 13
    //   228: iconst_1
    //   229: aaload
    //   230: invokestatic 166	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   233: lstore 6
    //   235: aload 8
    //   237: astore 9
    //   239: aload 13
    //   241: iconst_0
    //   242: aaload
    //   243: aload_0
    //   244: invokevirtual 123	android/content/Context:getPackageName	()Ljava/lang/String;
    //   247: invokestatic 160	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   250: ifne -122 -> 128
    //   253: aload 8
    //   255: astore 9
    //   257: lload 4
    //   259: lload 6
    //   261: lsub
    //   262: invokestatic 172	java/lang/Math:abs	(J)J
    //   265: lstore 6
    //   267: lload 6
    //   269: l2f
    //   270: ldc2_w 173
    //   273: lload_2
    //   274: lmul
    //   275: l2f
    //   276: ldc -81
    //   278: fmul
    //   279: fcmpg
    //   280: ifge -152 -> 128
    //   283: aload 8
    //   285: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   288: iconst_0
    //   289: ireturn
    //   290: aload 8
    //   292: astore 9
    //   294: aload 10
    //   296: aload 13
    //   298: invokeinterface 181 2 0
    //   303: pop
    //   304: goto -176 -> 128
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_1
    //   310: goto +30 -> 340
    //   313: aconst_null
    //   314: astore_0
    //   315: aload_0
    //   316: astore 9
    //   318: aload 10
    //   320: invokeinterface 184 1 0
    //   325: aload_0
    //   326: astore 9
    //   328: aload 9
    //   330: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   333: goto +23 -> 356
    //   336: astore_0
    //   337: aload 9
    //   339: astore_1
    //   340: aload_1
    //   341: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   344: aload_0
    //   345: athrow
    //   346: aload 11
    //   348: invokestatic 58	com/xiaomi/push/y:a	(Ljava/io/File;)Z
    //   351: ifne +5 -> 356
    //   354: iconst_1
    //   355: ireturn
    //   356: aload 10
    //   358: aload 12
    //   360: invokeinterface 181 2 0
    //   365: pop
    //   366: new 186	java/io/BufferedWriter
    //   369: dup
    //   370: new 188	java/io/FileWriter
    //   373: dup
    //   374: aload 11
    //   376: invokespecial 189	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   379: invokespecial 192	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   382: astore_0
    //   383: aload 10
    //   385: invokeinterface 196 1 0
    //   390: astore_1
    //   391: aload_1
    //   392: invokeinterface 201 1 0
    //   397: ifeq +27 -> 424
    //   400: aload_0
    //   401: aload_1
    //   402: invokeinterface 205 1 0
    //   407: checkcast 146	java/lang/String
    //   410: invokevirtual 208	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   413: aload_0
    //   414: invokevirtual 211	java/io/BufferedWriter:newLine	()V
    //   417: aload_0
    //   418: invokevirtual 214	java/io/BufferedWriter:flush	()V
    //   421: goto -30 -> 391
    //   424: aload_0
    //   425: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   428: iconst_1
    //   429: ireturn
    //   430: astore 8
    //   432: aload_0
    //   433: astore_1
    //   434: aload 8
    //   436: astore_0
    //   437: goto +36 -> 473
    //   440: astore_1
    //   441: goto +12 -> 453
    //   444: astore_0
    //   445: aconst_null
    //   446: astore_1
    //   447: goto +26 -> 473
    //   450: astore_1
    //   451: aconst_null
    //   452: astore_0
    //   453: aload_1
    //   454: invokevirtual 215	java/io/IOException:toString	()Ljava/lang/String;
    //   457: invokestatic 220	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   460: aload_0
    //   461: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   464: iconst_1
    //   465: ireturn
    //   466: astore 8
    //   468: aload_0
    //   469: astore_1
    //   470: aload 8
    //   472: astore_0
    //   473: aload_1
    //   474: invokestatic 89	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   477: aload_0
    //   478: athrow
    //   479: astore_0
    //   480: goto -167 -> 313
    //   483: astore_0
    //   484: aload 8
    //   486: astore_0
    //   487: goto -172 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramContext	android.content.Context
    //   0	490	1	paramString	String
    //   0	490	2	paramLong	long
    //   43	215	4	l1	long
    //   233	35	6	l2	long
    //   52	239	8	localObject1	Object
    //   430	5	8	localObject2	Object
    //   466	19	8	localObject3	Object
    //   130	208	9	localObject4	Object
    //   38	346	10	localArrayList	java.util.ArrayList
    //   29	346	11	localFile	File
    //   100	259	12	str	String
    //   137	160	13	localObject5	Object
    //   159	39	14	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   110	128	307	finally
    //   132	139	336	finally
    //   152	161	336	finally
    //   165	172	336	finally
    //   179	193	336	finally
    //   197	208	336	finally
    //   212	219	336	finally
    //   226	235	336	finally
    //   239	253	336	finally
    //   257	267	336	finally
    //   294	304	336	finally
    //   318	325	336	finally
    //   383	391	430	finally
    //   391	421	430	finally
    //   383	391	440	java/io/IOException
    //   391	421	440	java/io/IOException
    //   366	383	444	finally
    //   366	383	450	java/io/IOException
    //   453	460	466	finally
    //   110	128	479	java/lang/Exception
    //   132	139	483	java/lang/Exception
    //   152	161	483	java/lang/Exception
    //   165	172	483	java/lang/Exception
    //   179	193	483	java/lang/Exception
    //   197	208	483	java/lang/Exception
    //   212	219	483	java/lang/Exception
    //   226	235	483	java/lang/Exception
    //   239	253	483	java/lang/Exception
    //   257	267	483	java/lang/Exception
    //   294	304	483	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */