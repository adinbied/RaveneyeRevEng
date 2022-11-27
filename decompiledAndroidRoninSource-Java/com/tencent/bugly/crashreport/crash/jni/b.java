package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static List<File> a = new ArrayList();
  
  /* Error */
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +289 -> 293
    //   7: aload_1
    //   8: ifnull +285 -> 293
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: goto +278 -> 293
    //   18: new 22	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: ldc 24
    //   25: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 31	java/io/File:exists	()Z
    //   33: ifeq +258 -> 291
    //   36: aload_1
    //   37: invokevirtual 34	java/io/File:canRead	()Z
    //   40: ifne +5 -> 45
    //   43: aconst_null
    //   44: areturn
    //   45: new 36	java/io/BufferedInputStream
    //   48: dup
    //   49: new 38	java/io/FileInputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_1
    //   63: aload_3
    //   64: invokestatic 47	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull +132 -> 203
    //   74: aload_3
    //   75: astore_1
    //   76: aload 4
    //   78: ldc 49
    //   80: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +6 -> 89
    //   86: goto +117 -> 203
    //   89: aload_3
    //   90: astore_1
    //   91: new 57	java/util/HashMap
    //   94: dup
    //   95: invokespecial 58	java/util/HashMap:<init>	()V
    //   98: astore 6
    //   100: goto +205 -> 305
    //   103: aload_3
    //   104: astore_1
    //   105: aload_3
    //   106: invokestatic 47	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +32 -> 145
    //   116: aload 4
    //   118: ifnonnull +10 -> 128
    //   121: aload 5
    //   123: astore 4
    //   125: goto -22 -> 103
    //   128: aload_3
    //   129: astore_1
    //   130: aload 6
    //   132: aload 4
    //   134: aload 5
    //   136: invokeinterface 64 3 0
    //   141: pop
    //   142: goto +163 -> 305
    //   145: aload 4
    //   147: ifnull +33 -> 180
    //   150: aload_3
    //   151: astore_1
    //   152: ldc 66
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload 4
    //   162: aastore
    //   163: invokestatic 72	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_3
    //   168: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_3
    //   181: astore_1
    //   182: aload_0
    //   183: aload 6
    //   185: aload_2
    //   186: invokestatic 81	com/tencent/bugly/crashreport/crash/jni/b:a	(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   189: astore_0
    //   190: aload_3
    //   191: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   194: aload_0
    //   195: areturn
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   201: aload_0
    //   202: areturn
    //   203: aload_3
    //   204: astore_1
    //   205: ldc 83
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 4
    //   215: aastore
    //   216: invokestatic 72	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_3
    //   221: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_2
    //   234: aload_3
    //   235: astore_0
    //   236: goto +13 -> 249
    //   239: astore_0
    //   240: aload 4
    //   242: astore_1
    //   243: goto +30 -> 273
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_0
    //   249: aload_0
    //   250: astore_1
    //   251: aload_2
    //   252: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   255: aload_0
    //   256: ifnull +14 -> 270
    //   259: aload_0
    //   260: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_0
    //   273: aload_1
    //   274: ifnull +15 -> 289
    //   277: aload_1
    //   278: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   281: goto +8 -> 289
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   289: aload_0
    //   290: athrow
    //   291: aconst_null
    //   292: areturn
    //   293: ldc 85
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 72	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   302: pop
    //   303: aconst_null
    //   304: areturn
    //   305: aconst_null
    //   306: astore 4
    //   308: goto -205 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramContext	Context
    //   0	311	1	paramString	String
    //   0	311	2	paramNativeExceptionHandler	NativeExceptionHandler
    //   60	175	3	localBufferedInputStream	java.io.BufferedInputStream
    //   1	306	4	localObject	Object
    //   109	26	5	str	String
    //   98	86	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   167	171	173	java/io/IOException
    //   190	194	196	java/io/IOException
    //   220	224	226	java/io/IOException
    //   63	69	233	java/io/IOException
    //   76	86	233	java/io/IOException
    //   91	100	233	java/io/IOException
    //   105	111	233	java/io/IOException
    //   130	142	233	java/io/IOException
    //   152	167	233	java/io/IOException
    //   182	190	233	java/io/IOException
    //   205	220	233	java/io/IOException
    //   45	61	239	finally
    //   45	61	246	java/io/IOException
    //   259	263	265	java/io/IOException
    //   63	69	272	finally
    //   76	86	272	finally
    //   91	100	272	finally
    //   105	111	272	finally
    //   130	142	272	finally
    //   152	167	272	finally
    //   182	190	272	finally
    //   205	220	272	finally
    //   251	255	272	finally
    //   277	281	284	java/io/IOException
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler)
  {
    if (paramMap == null) {
      return null;
    }
    if (a.a(paramContext) == null)
    {
      x.e("abnormal com info not created", new Object[0]);
      return null;
    }
    paramContext = (String)paramMap.get("intStateStr");
    Map localMap;
    if ((paramContext != null) && (paramContext.trim().length() > 0))
    {
      localMap = d(paramContext);
      if (localMap == null)
      {
        x.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
        return null;
      }
    }
    for (;;)
    {
      Object localObject8;
      int i;
      try
      {
        ((Integer)localMap.get("sino")).intValue();
        ((Integer)localMap.get("sud")).intValue();
        str3 = (String)paramMap.get("soVersion");
        if (TextUtils.isEmpty(str3))
        {
          x.e("error format at version", new Object[0]);
          return null;
        }
        str1 = (String)paramMap.get("errorAddr");
        localObject7 = "unknown";
        if (str1 == null) {
          str1 = "unknown";
        }
        localObject1 = (String)paramMap.get("codeMsg");
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = "unknown";
        }
        str2 = (String)paramMap.get("tombPath");
        if (str2 != null) {
          break label1164;
        }
        str2 = "unknown";
        localObject2 = (String)paramMap.get("signalName");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "unknown";
        }
        paramMap.get("errnoMsg");
        localObject3 = (String)paramMap.get("stack");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "unknown";
        }
        localObject4 = (String)paramMap.get("jstack");
        localObject3 = localObject2;
        if (localObject4 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("java:\n");
          ((StringBuilder)localObject3).append((String)localObject4);
          localObject3 = ((StringBuilder)localObject3).toString();
        }
        localObject2 = (Integer)localMap.get("sico");
        if ((localObject2 == null) || (((Integer)localObject2).intValue() <= 0)) {
          break label1167;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append(")");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = "KERNEL";
        paramContext = (String)paramMap.get("nativeLog");
        if ((paramContext == null) || (paramContext.isEmpty())) {
          break label1173;
        }
        localObject4 = z.a(null, paramContext, "BuglyNativeLog.txt");
        localObject5 = (String)paramMap.get("sendingProcess");
        paramContext = (Context)localObject5;
        if (localObject5 == null) {
          paramContext = "unknown";
        }
        localObject6 = (Integer)localMap.get("spd");
        localObject5 = paramContext;
        if (localObject6 != null)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(paramContext);
          ((StringBuilder)localObject5).append("(");
          ((StringBuilder)localObject5).append(localObject6);
          ((StringBuilder)localObject5).append(")");
          localObject5 = ((StringBuilder)localObject5).toString();
        }
        localObject6 = (String)paramMap.get("threadName");
        paramContext = (Context)localObject6;
        if (localObject6 == null) {
          paramContext = "unknown";
        }
        localObject8 = (Integer)localMap.get("et");
        localObject6 = paramContext;
        if (localObject8 != null)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(paramContext);
          ((StringBuilder)localObject6).append("(");
          ((StringBuilder)localObject6).append(localObject8);
          ((StringBuilder)localObject6).append(")");
          localObject6 = ((StringBuilder)localObject6).toString();
        }
        paramContext = (String)paramMap.get("processName");
        if (paramContext != null) {
          break label1179;
        }
        paramContext = (Context)localObject7;
        localObject8 = (Integer)localMap.get("ep");
        localObject7 = paramContext;
        if (localObject8 != null)
        {
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(paramContext);
          ((StringBuilder)localObject7).append("(");
          ((StringBuilder)localObject7).append(localObject8);
          ((StringBuilder)localObject7).append(")");
          localObject7 = ((StringBuilder)localObject7).toString();
        }
        paramContext = (String)paramMap.get("key-value");
        if (paramContext == null) {
          break label1195;
        }
        localObject8 = new HashMap();
        paramContext = paramContext.split("\n");
        int j = paramContext.length;
        i = 0;
        if (i >= j) {
          break label1189;
        }
        String[] arrayOfString = paramContext[i].split("=");
        if (arrayOfString.length != 2) {
          break label1182;
        }
        ((Map)localObject8).put(arrayOfString[0], arrayOfString[1]);
      }
      finally
      {
        String str3;
        String str1;
        Object localObject7;
        Object localObject1;
        String str2;
        Object localObject3;
        Object localObject5;
        Object localObject6;
        long l;
        x.e("error format", new Object[0]);
        paramContext.printStackTrace();
        return null;
      }
      l = ((Integer)localMap.get("ets")).intValue();
      paramContext = paramNativeExceptionHandler.packageCrashDatas((String)localObject7, (String)localObject6, ((Integer)localMap.get("etms")).intValue() / 1000L + l * 1000L, (String)localObject1, str1, a((String)localObject3), (String)localObject2, (String)localObject5, str2, (String)paramMap.get("sysLogPath"), (String)paramMap.get("jniLogPath"), str3, (byte[])localObject4, paramContext, false, false);
      if (paramContext != null)
      {
        paramNativeExceptionHandler = (String)paramMap.get("userId");
        if (paramNativeExceptionHandler != null)
        {
          x.c("[Native record info] userId: %s", new Object[] { paramNativeExceptionHandler });
          paramContext.m = paramNativeExceptionHandler;
        }
        paramNativeExceptionHandler = (String)paramMap.get("sysLog");
        if (paramNativeExceptionHandler != null) {
          paramContext.w = paramNativeExceptionHandler;
        }
        paramNativeExceptionHandler = (String)paramMap.get("appVersion");
        if (paramNativeExceptionHandler != null)
        {
          x.c("[Native record info] appVersion: %s", new Object[] { paramNativeExceptionHandler });
          paramContext.f = paramNativeExceptionHandler;
        }
        paramNativeExceptionHandler = (String)paramMap.get("isAppForeground");
        if (paramNativeExceptionHandler != null)
        {
          x.c("[Native record info] isAppForeground: %s", new Object[] { paramNativeExceptionHandler });
          paramContext.N = paramNativeExceptionHandler.equalsIgnoreCase("true");
        }
        paramMap = (String)paramMap.get("launchTime");
        if (paramMap != null)
        {
          x.c("[Native record info] launchTime: %s", new Object[] { paramMap });
          try
          {
            paramContext.M = Long.parseLong(paramMap);
          }
          catch (NumberFormatException paramMap)
          {
            if (!x.a(paramMap)) {
              paramMap.printStackTrace();
            }
          }
        }
        paramContext.z = null;
        paramContext.k = true;
      }
      return paramContext;
      x.e("no intStateStr", new Object[0]);
      return null;
      label1164:
      continue;
      label1167:
      Object localObject2 = paramContext;
      continue;
      label1173:
      Object localObject4 = null;
      continue;
      label1179:
      continue;
      label1182:
      i += 1;
      continue;
      label1189:
      paramContext = (Context)localObject8;
      continue;
      label1195:
      paramContext = null;
    }
  }
  
  /* Error */
  private static String a(java.io.BufferedInputStream paramBufferedInputStream)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 306	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 309	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 312	java/io/BufferedInputStream:read	()I
    //   21: istore_1
    //   22: iload_1
    //   23: iconst_m1
    //   24: if_icmpeq +36 -> 60
    //   27: iload_1
    //   28: ifne +24 -> 52
    //   31: new 51	java/lang/String
    //   34: dup
    //   35: aload_2
    //   36: invokevirtual 316	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: ldc_w 318
    //   42: invokespecial 321	java/lang/String:<init>	([BLjava/lang/String;)V
    //   45: astore_0
    //   46: aload_2
    //   47: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   50: aload_0
    //   51: areturn
    //   52: aload_2
    //   53: iload_1
    //   54: invokevirtual 325	java/io/ByteArrayOutputStream:write	(I)V
    //   57: goto -40 -> 17
    //   60: aload_2
    //   61: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_3
    //   67: aload_2
    //   68: astore_0
    //   69: aload_3
    //   70: astore_2
    //   71: goto +6 -> 77
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_2
    //   78: invokestatic 287	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   81: pop
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_2
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_2
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramBufferedInputStream	java.io.BufferedInputStream
    //   21	33	1	i	int
    //   16	55	2	localObject1	Object
    //   74	4	2	localThrowable	Throwable
    //   92	10	2	localObject2	Object
    //   66	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	22	66	finally
    //   31	46	66	finally
    //   52	57	66	finally
    //   6	17	74	finally
    //   77	82	92	finally
  }
  
  protected static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String[] arrayOfString = paramString.split("\n");
    String str = paramString;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return paramString;
      }
      paramString = new StringBuilder();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!str.contains("java.lang.Thread.getStackTrace("))
        {
          paramString.append(str);
          paramString.append("\n");
        }
        i += 1;
      }
      str = paramString.toString();
    }
    return str;
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +384 -> 388
    //   7: iload_1
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 22	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 6
    //   23: aload 6
    //   25: invokevirtual 31	java/io/File:exists	()Z
    //   28: ifeq +360 -> 388
    //   31: aload 6
    //   33: invokevirtual 34	java/io/File:canRead	()Z
    //   36: ifne +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: ldc_w 341
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload 6
    //   52: invokevirtual 344	java/io/File:length	()J
    //   55: invokestatic 347	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload 6
    //   63: invokevirtual 350	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 352	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   70: pop
    //   71: getstatic 16	com/tencent/bugly/crashreport/crash/jni/b:a	Ljava/util/List;
    //   74: aload 6
    //   76: invokeinterface 357 2 0
    //   81: pop
    //   82: ldc_w 359
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 238	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_2
    //   94: ifnonnull +17 -> 111
    //   97: new 22	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: iload_1
    //   106: iload_3
    //   107: invokestatic 362	com/tencent/bugly/proguard/z:a	(Ljava/io/File;IZ)Ljava/lang/String;
    //   110: areturn
    //   111: new 158	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   118: astore 5
    //   120: new 364	java/io/BufferedReader
    //   123: dup
    //   124: new 366	java/io/InputStreamReader
    //   127: dup
    //   128: new 38	java/io/FileInputStream
    //   131: dup
    //   132: aload 6
    //   134: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: ldc_w 368
    //   140: invokespecial 371	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   143: invokespecial 374	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 377	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull +112 -> 267
    //   158: new 158	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   165: astore 6
    //   167: aload 6
    //   169: aload_2
    //   170: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 6
    //   176: ldc_w 379
    //   179: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 6
    //   185: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 385	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   191: aload 4
    //   193: invokevirtual 389	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   196: invokevirtual 394	java/util/regex/Matcher:find	()Z
    //   199: ifeq +19 -> 218
    //   202: aload 5
    //   204: aload 4
    //   206: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 5
    //   212: ldc -50
    //   214: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: iload_1
    //   219: ifle -72 -> 147
    //   222: aload 5
    //   224: invokevirtual 395	java/lang/StringBuilder:length	()I
    //   227: iload_1
    //   228: if_icmple -81 -> 147
    //   231: iload_3
    //   232: ifeq +18 -> 250
    //   235: aload 5
    //   237: iload_1
    //   238: aload 5
    //   240: invokevirtual 395	java/lang/StringBuilder:length	()I
    //   243: invokevirtual 399	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: goto +20 -> 267
    //   250: aload 5
    //   252: iconst_0
    //   253: aload 5
    //   255: invokevirtual 395	java/lang/StringBuilder:length	()I
    //   258: iload_1
    //   259: isub
    //   260: invokevirtual 399	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: goto -117 -> 147
    //   267: aload 5
    //   269: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: astore 4
    //   274: aload 4
    //   276: astore_2
    //   277: aload_0
    //   278: invokevirtual 400	java/io/BufferedReader:close	()V
    //   281: aload 4
    //   283: areturn
    //   284: astore_0
    //   285: aload_0
    //   286: invokestatic 287	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   289: pop
    //   290: aload_2
    //   291: areturn
    //   292: astore_2
    //   293: goto +7 -> 300
    //   296: astore_2
    //   297: aload 4
    //   299: astore_0
    //   300: aload_2
    //   301: invokestatic 287	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   304: pop
    //   305: new 158	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 402
    //   312: invokespecial 403	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: astore 4
    //   317: aload 4
    //   319: aload_2
    //   320: invokevirtual 404	java/lang/Throwable:toString	()Ljava/lang/String;
    //   323: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 4
    //   329: ldc_w 406
    //   332: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 5
    //   338: aload 4
    //   340: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 5
    //   349: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 4
    //   354: aload_0
    //   355: ifnull +10 -> 365
    //   358: aload 4
    //   360: astore_2
    //   361: aload_0
    //   362: invokevirtual 400	java/io/BufferedReader:close	()V
    //   365: aload 4
    //   367: areturn
    //   368: astore_2
    //   369: aload_0
    //   370: ifnull +16 -> 386
    //   373: aload_0
    //   374: invokevirtual 400	java/io/BufferedReader:close	()V
    //   377: goto +9 -> 386
    //   380: astore_0
    //   381: aload_0
    //   382: invokestatic 287	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   385: pop
    //   386: aload_2
    //   387: athrow
    //   388: aconst_null
    //   389: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramString1	String
    //   0	390	1	paramInt	int
    //   0	390	2	paramString2	String
    //   0	390	3	paramBoolean	boolean
    //   1	365	4	localObject1	Object
    //   118	230	5	localStringBuilder	StringBuilder
    //   21	163	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   277	281	284	java/lang/Exception
    //   361	365	284	java/lang/Exception
    //   147	153	292	finally
    //   158	218	292	finally
    //   222	231	292	finally
    //   235	247	292	finally
    //   250	264	292	finally
    //   267	274	292	finally
    //   120	147	296	finally
    //   300	354	368	finally
    //   373	377	380	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = b(paramString1, paramString2);
      if ((str != null) && (!str.isEmpty()))
      {
        localStringBuilder.append("Register infos:\n");
        localStringBuilder.append(str);
      }
      paramString1 = c(paramString1, paramString2);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("System SO infos:\n");
        localStringBuilder.append(paramString1);
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramString != null)
    {
      a.add(new File(paramString, "rqd_record.eup"));
      a.add(new File(paramString, "reg_record.txt"));
      a.add(new File(paramString, "map_record.txt"));
      a.add(new File(paramString, "backup_record.txt"));
      if (paramBoolean) {
        c(paramString);
      }
    }
    paramString = a;
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = a.iterator();
      while (paramString.hasNext())
      {
        File localFile = (File)paramString.next();
        if ((localFile.exists()) && (localFile.canWrite()))
        {
          localFile.delete();
          x.c("Delete record file %s", new Object[] { localFile.getAbsoluteFile() });
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString, "backup_record.txt");
    if (paramString.exists()) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    paramString1 = z.a(paramString1, "reg_record.txt");
    if (paramString1 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        String str = paramString1.readLine();
        if (str == null) {
          continue;
        }
        if (str.startsWith(paramString2)) {
          continue;
        }
      }
      finally
      {
        try
        {
          StringBuilder localStringBuilder;
          x.a(paramString2);
          if (paramString1 != null) {
            try
            {
              paramString1.close();
              return null;
            }
            catch (Exception paramString1)
            {
              x.a(paramString1);
            }
          }
          return null;
        }
        finally
        {
          if (paramString1 != null) {
            try
            {
              paramString1.close();
            }
            catch (Exception paramString1)
            {
              x.a(paramString1);
            }
          }
        }
        int i = 18;
        int j = 0;
        int k = 0;
        continue;
      }
      paramString2 = paramString1.readLine();
      if (paramString2 != null)
      {
        if (j % 4 == 0)
        {
          if (j > 0) {
            localStringBuilder.append("\n");
          }
          localStringBuilder.append("  ");
        }
        else
        {
          if (paramString2.length() > 16) {
            i = 28;
          }
          localStringBuilder.append("                ".substring(0, i - k));
        }
        k = paramString2.length();
        localStringBuilder.append(paramString2);
        j += 1;
      }
      else
      {
        localStringBuilder.append("\n");
        paramString2 = localStringBuilder.toString();
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return paramString2;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
          }
        }
        return paramString2;
      }
    }
    if (paramString1 != null) {
      try
      {
        paramString1.close();
        return null;
      }
      catch (Exception paramString1)
      {
        x.a(paramString1);
      }
    }
    return null;
  }
  
  private static String c(String paramString1, String paramString2)
  {
    paramString1 = z.a(paramString1, "map_record.txt");
    if (paramString1 == null) {
      return null;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString1.readLine();
      if ((str != null) && (str.startsWith(paramString2)))
      {
        for (;;)
        {
          paramString2 = paramString1.readLine();
          if (paramString2 == null) {
            break;
          }
          localStringBuilder.append("  ");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("\n");
        }
        paramString2 = localStringBuilder.toString();
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return paramString2;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
          }
        }
        return paramString2;
      }
      if (paramString1 != null) {
        try
        {
          paramString1.close();
          return null;
        }
        catch (Exception paramString1)
        {
          x.a(paramString1);
        }
      }
      return null;
    }
    finally
    {
      try
      {
        x.a(paramString2);
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return null;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
          }
        }
        return null;
      }
      finally
      {
        if (paramString1 != null) {
          try
          {
            paramString1.close();
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
          }
        }
      }
    }
  }
  
  public static void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.canRead()) && (paramString.isDirectory()))
      {
        paramString = paramString.listFiles();
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString[i];
            if ((((File)localObject).canRead()) && (((File)localObject).canWrite()) && (((File)localObject).length() == 0L))
            {
              ((File)localObject).delete();
              x.c("Delete empty record file %s", new Object[] { ((File)localObject).getAbsoluteFile() });
            }
            i += 1;
          }
        }
      }
      return;
    }
    finally
    {
      x.a(paramString);
    }
  }
  
  private static Map<String, Integer> d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      String[] arrayOfString1 = paramString.split(",");
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString1[i];
        String[] arrayOfString2 = str.split(":");
        if (arrayOfString2.length != 2)
        {
          x.e("error format at %s", new Object[] { str });
          return null;
        }
        int k = Integer.parseInt(arrayOfString2[1]);
        localHashMap.put(arrayOfString2[0], Integer.valueOf(k));
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      x.e("error format intStateStr %s", new Object[] { paramString });
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */