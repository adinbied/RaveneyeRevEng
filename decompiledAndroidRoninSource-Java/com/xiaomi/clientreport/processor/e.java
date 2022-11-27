package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.push.y;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;

public class e
{
  private static PerfClientReport a(PerfClientReport paramPerfClientReport, String paramString)
  {
    if (paramPerfClientReport == null) {
      return null;
    }
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    paramPerfClientReport.perfCounts = paramString[0];
    paramPerfClientReport.perfLatencies = paramString[1];
    return paramPerfClientReport;
  }
  
  private static PerfClientReport a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      String[] arrayOfString = a(paramString);
      paramString = (String)localObject2;
      if (arrayOfString == null) {
        break label150;
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      if (arrayOfString.length < 4) {
        break label150;
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(arrayOfString[0])) {
        break label150;
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(arrayOfString[1])) {
        break label150;
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(arrayOfString[2])) {
        break label150;
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(arrayOfString[3])) {
        break label150;
      }
      localObject1 = localObject3;
      paramString = PerfClientReport.getBlankInstance();
      localObject1 = paramString;
      paramString.production = Integer.parseInt(arrayOfString[0]);
      localObject1 = paramString;
      paramString.clientInterfaceId = arrayOfString[1];
      localObject1 = paramString;
      paramString.reportType = Integer.parseInt(arrayOfString[2]);
      localObject1 = paramString;
      paramString.code = Integer.parseInt(arrayOfString[3]);
      return paramString;
    }
    catch (Exception paramString)
    {
      label150:
      for (;;) {}
    }
    b.c("parse per key error");
    paramString = (String)localObject1;
    return paramString;
  }
  
  public static String a(PerfClientReport paramPerfClientReport)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPerfClientReport.production);
    localStringBuilder.append("#");
    localStringBuilder.append(paramPerfClientReport.clientInterfaceId);
    localStringBuilder.append("#");
    localStringBuilder.append(paramPerfClientReport.reportType);
    localStringBuilder.append("#");
    localStringBuilder.append(paramPerfClientReport.code);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static HashMap<String, String> a(String paramString)
  {
    // Byte code:
    //   0: new 86	java/util/HashMap
    //   3: dup
    //   4: invokespecial 87	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +140 -> 153
    //   16: new 89	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 95	java/io/File:exists	()Z
    //   27: ifne +6 -> 33
    //   30: aload 4
    //   32: areturn
    //   33: aconst_null
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_1
    //   37: new 97	java/io/BufferedReader
    //   40: dup
    //   41: new 99	java/io/FileReader
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 100	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 103	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 106	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +49 -> 108
    //   62: aload_1
    //   63: ldc 108
    //   65: invokevirtual 113	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: arraylength
    //   71: iconst_2
    //   72: if_icmplt -19 -> 53
    //   75: aload_1
    //   76: iconst_0
    //   77: aaload
    //   78: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne -28 -> 53
    //   84: aload_1
    //   85: iconst_1
    //   86: aaload
    //   87: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne -37 -> 53
    //   93: aload 4
    //   95: aload_1
    //   96: iconst_0
    //   97: aaload
    //   98: aload_1
    //   99: iconst_1
    //   100: aaload
    //   101: invokevirtual 117	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: goto -52 -> 53
    //   108: aload_0
    //   109: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   112: aload 4
    //   114: areturn
    //   115: astore_2
    //   116: aload_0
    //   117: astore_1
    //   118: aload_2
    //   119: astore_0
    //   120: goto +27 -> 147
    //   123: astore_2
    //   124: goto +10 -> 134
    //   127: astore_0
    //   128: goto +19 -> 147
    //   131: astore_2
    //   132: aload_3
    //   133: astore_0
    //   134: aload_0
    //   135: astore_1
    //   136: aload_2
    //   137: invokestatic 125	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   144: aload 4
    //   146: areturn
    //   147: aload_1
    //   148: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   151: aload_0
    //   152: athrow
    //   153: aload 4
    //   155: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   36	112	1	localObject1	Object
    //   115	4	2	localObject2	Object
    //   123	1	2	localException1	Exception
    //   131	6	2	localException2	Exception
    //   34	99	3	localObject3	Object
    //   7	147	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   53	58	115	finally
    //   62	105	115	finally
    //   53	58	123	java/lang/Exception
    //   62	105	123	java/lang/Exception
    //   37	53	127	finally
    //   136	140	127	finally
    //   37	53	131	java/lang/Exception
  }
  
  /* Error */
  public static java.util.List<String> a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 132	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 133	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_1
    //   10: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +374 -> 387
    //   16: new 89	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 95	java/io/File:exists	()Z
    //   27: ifne +6 -> 33
    //   30: aload 7
    //   32: areturn
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 5
    //   39: new 66	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   46: astore_0
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_0
    //   54: ldc -121
    //   56: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: new 89	java/io/File
    //   63: dup
    //   64: aload_0
    //   65: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_0
    //   72: aload_0
    //   73: invokestatic 138	com/xiaomi/push/y:a	(Ljava/io/File;)Z
    //   76: pop
    //   77: new 140	java/io/RandomAccessFile
    //   80: dup
    //   81: aload_0
    //   82: ldc -114
    //   84: invokespecial 145	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   87: astore 4
    //   89: aload 4
    //   91: invokevirtual 149	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   94: invokevirtual 155	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   97: astore_3
    //   98: new 97	java/io/BufferedReader
    //   101: dup
    //   102: new 99	java/io/FileReader
    //   105: dup
    //   106: aload_1
    //   107: invokespecial 100	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   110: invokespecial 103	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 106	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +69 -> 189
    //   123: aload_2
    //   124: ldc 108
    //   126: invokevirtual 113	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   129: astore_2
    //   130: aload_2
    //   131: arraylength
    //   132: iconst_2
    //   133: if_icmplt -19 -> 114
    //   136: aload_2
    //   137: iconst_0
    //   138: aaload
    //   139: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne -28 -> 114
    //   145: aload_2
    //   146: iconst_1
    //   147: aaload
    //   148: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne -37 -> 114
    //   154: aload_2
    //   155: iconst_0
    //   156: aaload
    //   157: invokestatic 157	com/xiaomi/clientreport/processor/e:a	(Ljava/lang/String;)Lcom/xiaomi/clientreport/data/PerfClientReport;
    //   160: aload_2
    //   161: iconst_1
    //   162: aaload
    //   163: invokestatic 159	com/xiaomi/clientreport/processor/e:a	(Lcom/xiaomi/clientreport/data/PerfClientReport;Ljava/lang/String;)Lcom/xiaomi/clientreport/data/PerfClientReport;
    //   166: astore_2
    //   167: aload_2
    //   168: ifnonnull +6 -> 174
    //   171: goto -57 -> 114
    //   174: aload 7
    //   176: aload_2
    //   177: invokevirtual 162	com/xiaomi/clientreport/data/PerfClientReport:toJsonString	()Ljava/lang/String;
    //   180: invokeinterface 168 2 0
    //   185: pop
    //   186: goto -72 -> 114
    //   189: aload_3
    //   190: ifnull +22 -> 212
    //   193: aload_3
    //   194: invokevirtual 173	java/nio/channels/FileLock:isValid	()Z
    //   197: ifeq +15 -> 212
    //   200: aload_3
    //   201: invokevirtual 176	java/nio/channels/FileLock:release	()V
    //   204: goto +8 -> 212
    //   207: astore_2
    //   208: aload_2
    //   209: invokestatic 125	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   212: aload 4
    //   214: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   217: aload_1
    //   218: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   221: goto +114 -> 335
    //   224: astore_2
    //   225: goto +10 -> 235
    //   228: astore_2
    //   229: goto +12 -> 241
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_1
    //   235: goto +109 -> 344
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_1
    //   241: goto +54 -> 295
    //   244: astore_2
    //   245: aconst_null
    //   246: astore_1
    //   247: aload 6
    //   249: astore_3
    //   250: goto +94 -> 344
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_1
    //   256: aload 5
    //   258: astore_3
    //   259: goto +36 -> 295
    //   262: astore_2
    //   263: goto +10 -> 273
    //   266: astore_2
    //   267: goto +20 -> 287
    //   270: astore_2
    //   271: aconst_null
    //   272: astore_0
    //   273: aconst_null
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_1
    //   278: aload 6
    //   280: astore_3
    //   281: goto +63 -> 344
    //   284: astore_2
    //   285: aconst_null
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 4
    //   290: aconst_null
    //   291: astore_1
    //   292: aload 5
    //   294: astore_3
    //   295: aload_2
    //   296: invokestatic 125	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   299: aload_3
    //   300: ifnull +22 -> 322
    //   303: aload_3
    //   304: invokevirtual 173	java/nio/channels/FileLock:isValid	()Z
    //   307: ifeq +15 -> 322
    //   310: aload_3
    //   311: invokevirtual 176	java/nio/channels/FileLock:release	()V
    //   314: goto +8 -> 322
    //   317: astore_2
    //   318: aload_2
    //   319: invokestatic 125	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   322: aload 4
    //   324: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   327: aload_1
    //   328: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   331: aload_0
    //   332: ifnull +8 -> 340
    //   335: aload_0
    //   336: invokevirtual 179	java/io/File:delete	()Z
    //   339: pop
    //   340: aload 7
    //   342: areturn
    //   343: astore_2
    //   344: aload_3
    //   345: ifnull +22 -> 367
    //   348: aload_3
    //   349: invokevirtual 173	java/nio/channels/FileLock:isValid	()Z
    //   352: ifeq +15 -> 367
    //   355: aload_3
    //   356: invokevirtual 176	java/nio/channels/FileLock:release	()V
    //   359: goto +8 -> 367
    //   362: astore_3
    //   363: aload_3
    //   364: invokestatic 125	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   367: aload 4
    //   369: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   372: aload_1
    //   373: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   376: aload_0
    //   377: ifnull +8 -> 385
    //   380: aload_0
    //   381: invokevirtual 179	java/io/File:delete	()Z
    //   384: pop
    //   385: aload_2
    //   386: athrow
    //   387: aload 7
    //   389: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramContext	android.content.Context
    //   0	390	1	paramString	String
    //   118	59	2	localObject1	Object
    //   207	2	2	localIOException1	IOException
    //   224	1	2	localObject2	Object
    //   228	1	2	localException1	Exception
    //   232	1	2	localObject3	Object
    //   238	1	2	localException2	Exception
    //   244	1	2	localObject4	Object
    //   253	1	2	localException3	Exception
    //   262	1	2	localObject5	Object
    //   266	1	2	localException4	Exception
    //   270	1	2	localObject6	Object
    //   284	12	2	localException5	Exception
    //   317	2	2	localIOException2	IOException
    //   343	43	2	localObject7	Object
    //   97	259	3	localObject8	Object
    //   362	2	3	localIOException3	IOException
    //   87	281	4	localRandomAccessFile	RandomAccessFile
    //   37	256	5	localObject9	Object
    //   34	245	6	localObject10	Object
    //   7	381	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   200	204	207	java/io/IOException
    //   114	119	224	finally
    //   123	167	224	finally
    //   174	186	224	finally
    //   114	119	228	java/lang/Exception
    //   123	167	228	java/lang/Exception
    //   174	186	228	java/lang/Exception
    //   98	114	232	finally
    //   98	114	238	java/lang/Exception
    //   89	98	244	finally
    //   89	98	253	java/lang/Exception
    //   72	89	262	finally
    //   72	89	266	java/lang/Exception
    //   39	72	270	finally
    //   39	72	284	java/lang/Exception
    //   310	314	317	java/io/IOException
    //   295	299	343	finally
    //   355	359	362	java/io/IOException
  }
  
  /* Error */
  private static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +197 -> 201
    //   7: aload_1
    //   8: ifnull +193 -> 201
    //   11: aload_1
    //   12: invokevirtual 185	java/util/HashMap:size	()I
    //   15: ifne +4 -> 19
    //   18: return
    //   19: new 89	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 95	java/io/File:exists	()Z
    //   32: ifeq +8 -> 40
    //   35: aload_0
    //   36: invokevirtual 179	java/io/File:delete	()Z
    //   39: pop
    //   40: new 187	java/io/BufferedWriter
    //   43: dup
    //   44: new 189	java/io/FileWriter
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 192	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   52: invokespecial 195	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   55: astore_0
    //   56: aload_0
    //   57: astore_2
    //   58: aload_1
    //   59: invokevirtual 199	java/util/HashMap:keySet	()Ljava/util/Set;
    //   62: invokeinterface 205 1 0
    //   67: astore 4
    //   69: aload_0
    //   70: astore_3
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: invokeinterface 210 1 0
    //   80: ifeq +109 -> 189
    //   83: aload_0
    //   84: astore_2
    //   85: aload 4
    //   87: invokeinterface 214 1 0
    //   92: checkcast 110	java/lang/String
    //   95: astore_3
    //   96: aload_0
    //   97: astore_2
    //   98: aload_1
    //   99: aload_3
    //   100: invokevirtual 218	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 110	java/lang/String
    //   106: astore 5
    //   108: aload_0
    //   109: astore_2
    //   110: new 66	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   117: astore 6
    //   119: aload_0
    //   120: astore_2
    //   121: aload 6
    //   123: aload_3
    //   124: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_0
    //   129: astore_2
    //   130: aload 6
    //   132: ldc 108
    //   134: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_0
    //   139: astore_2
    //   140: aload 6
    //   142: aload 5
    //   144: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_0
    //   149: astore_2
    //   150: aload_0
    //   151: aload 6
    //   153: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 221	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: astore_2
    //   161: aload_0
    //   162: invokevirtual 224	java/io/BufferedWriter:newLine	()V
    //   165: goto -96 -> 69
    //   168: astore_1
    //   169: goto +12 -> 181
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_2
    //   175: goto +20 -> 195
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_0
    //   181: aload_0
    //   182: astore_2
    //   183: aload_1
    //   184: invokestatic 125	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   187: aload_0
    //   188: astore_3
    //   189: aload_3
    //   190: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   193: return
    //   194: astore_0
    //   195: aload_2
    //   196: invokestatic 122	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: athrow
    //   201: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramString	String
    //   0	202	1	paramHashMap	HashMap<String, String>
    //   57	139	2	str1	String
    //   70	120	3	str2	String
    //   67	19	4	localIterator	java.util.Iterator
    //   106	37	5	str3	String
    //   117	35	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   58	69	168	java/lang/Exception
    //   73	83	168	java/lang/Exception
    //   85	96	168	java/lang/Exception
    //   98	108	168	java/lang/Exception
    //   110	119	168	java/lang/Exception
    //   121	128	168	java/lang/Exception
    //   130	138	168	java/lang/Exception
    //   140	148	168	java/lang/Exception
    //   150	159	168	java/lang/Exception
    //   161	165	168	java/lang/Exception
    //   40	56	172	finally
    //   40	56	178	java/lang/Exception
    //   58	69	194	finally
    //   73	83	194	finally
    //   85	96	194	finally
    //   98	108	194	finally
    //   110	119	194	finally
    //   121	128	194	finally
    //   130	138	194	finally
    //   140	148	194	finally
    //   150	159	194	finally
    //   161	165	194	finally
    //   183	187	194	finally
  }
  
  public static void a(String paramString, a[] paramArrayOfa)
  {
    FileLock localFileLock2;
    FileLock localFileLock1;
    if ((paramArrayOfa != null) && (paramArrayOfa.length > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localFileLock2 = null;
      localFileLock1 = null;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".lock");
      localObject = new File(((StringBuilder)localObject).toString());
      y.a((File)localObject);
      localObject = new RandomAccessFile((File)localObject, "rw");
      localFileLock1 = localFileLock2;
    }
    finally
    {
      Object localObject;
      HashMap localHashMap;
      int j;
      label113:
      a locala;
      String str;
      long l1;
      long l2;
      label266:
      label299:
      for (;;) {}
    }
    try
    {
      localFileLock2 = ((RandomAccessFile)localObject).getChannel().lock();
      localFileLock1 = localFileLock2;
      localHashMap = a(paramString);
      localFileLock1 = localFileLock2;
      j = paramArrayOfa.length;
      i = 0;
    }
    finally
    {
      paramString = localIOException;
      break label266;
      i += 1;
      break label113;
    }
    if (i < j)
    {
      locala = paramArrayOfa[i];
      if (locala != null)
      {
        localFileLock1 = localFileLock2;
        str = a((PerfClientReport)locala);
        localFileLock1 = localFileLock2;
        l1 = ((PerfClientReport)locala).perfCounts;
        localFileLock1 = localFileLock2;
        l2 = ((PerfClientReport)locala).perfLatencies;
        localFileLock1 = localFileLock2;
        if ((!TextUtils.isEmpty(str)) && (l1 > 0L) && (l2 >= 0L))
        {
          localFileLock1 = localFileLock2;
          a(localHashMap, str, l1, l2);
        }
      }
    }
    else
    {
      localFileLock1 = localFileLock2;
      a(paramString, localHashMap);
      paramArrayOfa = (a[])localObject;
      if (localFileLock2 != null)
      {
        paramArrayOfa = (a[])localObject;
        if (localFileLock2.isValid())
        {
          try
          {
            localFileLock2.release();
            paramArrayOfa = (a[])localObject;
          }
          catch (IOException paramArrayOfa)
          {
            paramString = (String)localObject;
            break label299;
          }
          paramString = null;
        }
      }
      try
      {
        b.c("failed to write perf to file ");
        paramArrayOfa = paramString;
        if (localFileLock1 != null)
        {
          paramArrayOfa = paramString;
          if (localFileLock1.isValid())
          {
            try
            {
              localFileLock1.release();
              paramArrayOfa = paramString;
            }
            catch (IOException paramArrayOfa) {}
            b.a(paramArrayOfa);
            paramArrayOfa = paramString;
          }
        }
        y.a(paramArrayOfa);
        return;
      }
      finally
      {
        if ((localFileLock1 != null) && (localFileLock1.isValid())) {
          try
          {
            localFileLock1.release();
          }
          catch (IOException localIOException)
          {
            b.a(localIOException);
          }
        }
        y.a(paramString);
      }
      return;
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap, String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = (String)paramHashMap.get(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = new StringBuilder();
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramLong2);
      paramHashMap.put(paramString, ((StringBuilder)localObject).toString());
      return;
      localObject = a((String)localObject);
      if ((localObject != null) && (localObject[0] > 0L) && (localObject[1] >= 0L))
      {
        paramLong1 += localObject[0];
        paramLong2 += localObject[1];
        localObject = new StringBuilder();
      }
      else
      {
        localObject = new StringBuilder();
      }
    }
  }
  
  protected static long[] a(String paramString)
  {
    long[] arrayOfLong = new long[2];
    try
    {
      paramString = paramString.split("#");
      if (paramString.length >= 2)
      {
        arrayOfLong[0] = Long.parseLong(paramString[0].trim());
        arrayOfLong[1] = Long.parseLong(paramString[1].trim());
      }
      return arrayOfLong;
    }
    catch (Exception paramString)
    {
      b.a(paramString);
    }
    return null;
  }
  
  private static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split("#");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\processor\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */