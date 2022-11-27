package com.huawei.updatesdk.sdk.a.d.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.updatesdk.sdk.a.d.c.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class a
{
  private static Map<String, Object> a = new HashMap();
  
  public static String a()
  {
    return Build.DISPLAY;
  }
  
  public static void a(Context paramContext)
  {
    b(paramContext);
  }
  
  public static long b(Context paramContext)
  {
    Long localLong = (Long)a.get("TotalMem");
    long l;
    if (localLong != null)
    {
      l = localLong.longValue();
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 16) {
        l = f(paramContext);
      } else {
        l = g(paramContext);
      }
      if (l > 0L) {
        a.put("TotalMem", Long.valueOf(l));
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("getTotalMem, totalMem:");
    paramContext.append(l);
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("DeviceUtil", paramContext.toString());
    return l;
  }
  
  public static String b()
  {
    DisplayMetrics localDisplayMetrics = h(com.huawei.updatesdk.sdk.service.a.a.a().b());
    if (localDisplayMetrics != null) {
      return String.valueOf(localDisplayMetrics.densityDpi);
    }
    return "";
  }
  
  public static int c(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionCode);
      localStringBuilder.append("");
      int i = Integer.parseInt(localStringBuilder.toString());
      return i;
    }
    catch (PackageManager.NameNotFoundException|NumberFormatException paramContext) {}
    return 1;
  }
  
  public static String c()
  {
    Object localObject3 = Locale.getDefault();
    Object localObject2 = "";
    Object localObject1;
    if (localObject3 != null)
    {
      localObject4 = ((Locale)localObject3).getLanguage();
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = ((Locale)localObject3).getScript();
      }
      localObject2 = ((Locale)localObject3).getCountry();
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    else
    {
      localObject1 = "en";
      localObject4 = "US";
      localObject3 = localObject2;
      localObject2 = localObject4;
    }
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append((String)localObject2);
      return ((StringBuilder)localObject3).toString();
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append((String)localObject2);
    return ((StringBuilder)localObject4).toString();
  }
  
  public static String d()
  {
    Object localObject = h(com.huawei.updatesdk.sdk.service.a.a.a().b());
    if (localObject != null)
    {
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(i));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(String.valueOf(j));
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionName);
      localStringBuilder.append("");
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    String str = d(paramContext);
    paramContext = str;
    if (str != null)
    {
      int i = 0;
      int k;
      for (int j = 0; (i < str.length()) && (j < 3); j = k)
      {
        k = j;
        if (str.charAt(i) == '.') {
          k = j + 1;
        }
        i += 1;
      }
      paramContext = str;
      if (3 == j) {
        paramContext = str.substring(0, i - 1);
      }
    }
    return paramContext;
  }
  
  public static boolean e()
  {
    if (com.huawei.updatesdk.sdk.service.a.a.a() == null) {
      return false;
    }
    return b.a(com.huawei.updatesdk.sdk.service.a.a.a().b());
  }
  
  private static long f(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.totalMem;
      return l;
    }
    catch (Exception paramContext)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.d("DeviceUtil", paramContext.getMessage());
    }
    return 0L;
  }
  
  public static boolean f()
  {
    PackageManager localPackageManager = com.huawei.updatesdk.sdk.service.a.a.a().b().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.gsf.login", 16);
      localPackageManager.getPackageInfo("com.google.android.gsf", 16);
      int i = localPackageManager.getPackageInfo("com.google.android.gms", 16).applicationInfo.flags;
      return (i & 0x1) != 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.d("DeviceUtil", localNameNotFoundException.getMessage());
    }
    return false;
  }
  
  public static int g()
  {
    StringBuilder localStringBuilder;
    String str5;
    try
    {
      Class localClass = Class.forName("android.os.UserHandle");
      int i = ((Integer)localClass.getMethod("myUserId", new Class[0]).invoke(localClass, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get current uid IllegalAccessException! ");
      String str1 = localIllegalAccessException.toString();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get current uid InvocationTargetException! ");
      String str2 = localInvocationTargetException.toString();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get current uid NoSuchMethodException! ");
      String str3 = localNoSuchMethodException.toString();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get current uid ClassNotFoundException! ");
      String str4 = localClassNotFoundException.toString();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get current uid IllegalArgumentException! ");
      str5 = localIllegalArgumentException.toString();
    }
    localStringBuilder.append(str5);
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("DeviceUtil", localStringBuilder.toString());
    return 0;
  }
  
  /* Error */
  private static long g(Context paramContext)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: new 301	java/io/FileInputStream
    //   5: dup
    //   6: ldc_w 303
    //   9: invokespecial 306	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 308	java/io/BufferedReader
    //   16: dup
    //   17: new 310	java/io/InputStreamReader
    //   20: dup
    //   21: aload_0
    //   22: ldc_w 312
    //   25: invokespecial 315	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 318	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore 9
    //   33: aload 9
    //   35: astore 7
    //   37: aload_0
    //   38: astore 8
    //   40: aload 9
    //   42: invokevirtual 321	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 10
    //   47: lload_3
    //   48: lstore_1
    //   49: aload 10
    //   51: ifnull +24 -> 75
    //   54: aload 9
    //   56: astore 7
    //   58: aload_0
    //   59: astore 8
    //   61: aload 10
    //   63: ldc_w 323
    //   66: invokevirtual 327	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   69: iconst_1
    //   70: aaload
    //   71: invokestatic 331	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: lstore_1
    //   75: aload 9
    //   77: invokevirtual 334	java/io/BufferedReader:close	()V
    //   80: goto +15 -> 95
    //   83: astore 7
    //   85: ldc 77
    //   87: aload 7
    //   89: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   92: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: lload_1
    //   96: lstore 5
    //   98: aload_0
    //   99: invokevirtual 336	java/io/FileInputStream:close	()V
    //   102: goto +351 -> 453
    //   105: astore_0
    //   106: ldc 77
    //   108: aload_0
    //   109: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   112: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: lload 5
    //   117: lstore_1
    //   118: goto +335 -> 453
    //   121: astore 10
    //   123: goto +72 -> 195
    //   126: astore 10
    //   128: goto +134 -> 262
    //   131: astore 10
    //   133: goto +196 -> 329
    //   136: astore 10
    //   138: goto +258 -> 396
    //   141: astore 7
    //   143: goto +39 -> 182
    //   146: astore 10
    //   148: aconst_null
    //   149: astore 9
    //   151: goto +44 -> 195
    //   154: astore 10
    //   156: aconst_null
    //   157: astore 9
    //   159: goto +103 -> 262
    //   162: astore 10
    //   164: aconst_null
    //   165: astore 9
    //   167: goto +162 -> 329
    //   170: astore 10
    //   172: aconst_null
    //   173: astore 9
    //   175: goto +221 -> 396
    //   178: astore 7
    //   180: aconst_null
    //   181: astore_0
    //   182: aconst_null
    //   183: astore 8
    //   185: goto +287 -> 472
    //   188: astore 10
    //   190: aconst_null
    //   191: astore_0
    //   192: aload_0
    //   193: astore 9
    //   195: aload 9
    //   197: astore 7
    //   199: aload_0
    //   200: astore 8
    //   202: ldc 77
    //   204: aload 10
    //   206: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   209: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 9
    //   214: ifnull +23 -> 237
    //   217: aload 9
    //   219: invokevirtual 334	java/io/BufferedReader:close	()V
    //   222: goto +15 -> 237
    //   225: astore 7
    //   227: ldc 77
    //   229: aload 7
    //   231: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: lload_3
    //   238: lstore_1
    //   239: aload_0
    //   240: ifnull +213 -> 453
    //   243: lload_3
    //   244: lstore 5
    //   246: aload_0
    //   247: invokevirtual 336	java/io/FileInputStream:close	()V
    //   250: lload_3
    //   251: lstore_1
    //   252: goto +201 -> 453
    //   255: astore 10
    //   257: aconst_null
    //   258: astore_0
    //   259: aload_0
    //   260: astore 9
    //   262: aload 9
    //   264: astore 7
    //   266: aload_0
    //   267: astore 8
    //   269: ldc 77
    //   271: aload 10
    //   273: invokevirtual 337	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   276: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 9
    //   281: ifnull +23 -> 304
    //   284: aload 9
    //   286: invokevirtual 334	java/io/BufferedReader:close	()V
    //   289: goto +15 -> 304
    //   292: astore 7
    //   294: ldc 77
    //   296: aload 7
    //   298: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   301: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: lload_3
    //   305: lstore_1
    //   306: aload_0
    //   307: ifnull +146 -> 453
    //   310: lload_3
    //   311: lstore 5
    //   313: aload_0
    //   314: invokevirtual 336	java/io/FileInputStream:close	()V
    //   317: lload_3
    //   318: lstore_1
    //   319: goto +134 -> 453
    //   322: astore 10
    //   324: aconst_null
    //   325: astore_0
    //   326: aload_0
    //   327: astore 9
    //   329: aload 9
    //   331: astore 7
    //   333: aload_0
    //   334: astore 8
    //   336: ldc 77
    //   338: aload 10
    //   340: invokevirtual 338	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   343: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload 9
    //   348: ifnull +23 -> 371
    //   351: aload 9
    //   353: invokevirtual 334	java/io/BufferedReader:close	()V
    //   356: goto +15 -> 371
    //   359: astore 7
    //   361: ldc 77
    //   363: aload 7
    //   365: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   368: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: lload_3
    //   372: lstore_1
    //   373: aload_0
    //   374: ifnull +79 -> 453
    //   377: lload_3
    //   378: lstore 5
    //   380: aload_0
    //   381: invokevirtual 336	java/io/FileInputStream:close	()V
    //   384: lload_3
    //   385: lstore_1
    //   386: goto +67 -> 453
    //   389: astore 10
    //   391: aconst_null
    //   392: astore_0
    //   393: aload_0
    //   394: astore 9
    //   396: aload 9
    //   398: astore 7
    //   400: aload_0
    //   401: astore 8
    //   403: ldc 77
    //   405: aload 10
    //   407: invokevirtual 339	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   410: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload 9
    //   415: ifnull +23 -> 438
    //   418: aload 9
    //   420: invokevirtual 334	java/io/BufferedReader:close	()V
    //   423: goto +15 -> 438
    //   426: astore 7
    //   428: ldc 77
    //   430: aload 7
    //   432: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   435: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: lload_3
    //   439: lstore_1
    //   440: aload_0
    //   441: ifnull +12 -> 453
    //   444: lload_3
    //   445: lstore 5
    //   447: aload_0
    //   448: invokevirtual 336	java/io/FileInputStream:close	()V
    //   451: lload_3
    //   452: lstore_1
    //   453: lload_1
    //   454: ldc2_w 340
    //   457: lmul
    //   458: lreturn
    //   459: astore 9
    //   461: aload 8
    //   463: astore_0
    //   464: aload 7
    //   466: astore 8
    //   468: aload 9
    //   470: astore 7
    //   472: aload 8
    //   474: ifnull +23 -> 497
    //   477: aload 8
    //   479: invokevirtual 334	java/io/BufferedReader:close	()V
    //   482: goto +15 -> 497
    //   485: astore 8
    //   487: ldc 77
    //   489: aload 8
    //   491: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   494: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload_0
    //   498: ifnull +20 -> 518
    //   501: aload_0
    //   502: invokevirtual 336	java/io/FileInputStream:close	()V
    //   505: goto +13 -> 518
    //   508: astore_0
    //   509: ldc 77
    //   511: aload_0
    //   512: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   515: invokestatic 229	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload 7
    //   520: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	paramContext	Context
    //   48	406	1	l1	long
    //   1	451	3	l2	long
    //   96	350	5	l3	long
    //   35	22	7	localObject1	Object
    //   83	5	7	localIOException1	java.io.IOException
    //   141	1	7	localObject2	Object
    //   178	1	7	localObject3	Object
    //   197	1	7	localObject4	Object
    //   225	5	7	localIOException2	java.io.IOException
    //   264	1	7	localObject5	Object
    //   292	5	7	localIOException3	java.io.IOException
    //   331	1	7	localObject6	Object
    //   359	5	7	localIOException4	java.io.IOException
    //   398	1	7	localObject7	Object
    //   426	39	7	localIOException5	java.io.IOException
    //   470	49	7	localObject8	Object
    //   38	440	8	localObject9	Object
    //   485	5	8	localIOException6	java.io.IOException
    //   31	388	9	localObject10	Object
    //   459	10	9	localObject11	Object
    //   45	17	10	str	String
    //   121	1	10	localIOException7	java.io.IOException
    //   126	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	1	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   136	1	10	localNumberFormatException1	NumberFormatException
    //   146	1	10	localIOException8	java.io.IOException
    //   154	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   162	1	10	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   170	1	10	localNumberFormatException2	NumberFormatException
    //   188	17	10	localIOException9	java.io.IOException
    //   255	17	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   322	17	10	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   389	17	10	localNumberFormatException3	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   75	80	83	java/io/IOException
    //   98	102	105	java/io/IOException
    //   246	250	105	java/io/IOException
    //   313	317	105	java/io/IOException
    //   380	384	105	java/io/IOException
    //   447	451	105	java/io/IOException
    //   40	47	121	java/io/IOException
    //   61	75	121	java/io/IOException
    //   40	47	126	java/io/FileNotFoundException
    //   61	75	126	java/io/FileNotFoundException
    //   40	47	131	java/io/UnsupportedEncodingException
    //   61	75	131	java/io/UnsupportedEncodingException
    //   40	47	136	java/lang/NumberFormatException
    //   61	75	136	java/lang/NumberFormatException
    //   13	33	141	finally
    //   13	33	146	java/io/IOException
    //   13	33	154	java/io/FileNotFoundException
    //   13	33	162	java/io/UnsupportedEncodingException
    //   13	33	170	java/lang/NumberFormatException
    //   2	13	178	finally
    //   2	13	188	java/io/IOException
    //   217	222	225	java/io/IOException
    //   2	13	255	java/io/FileNotFoundException
    //   284	289	292	java/io/IOException
    //   2	13	322	java/io/UnsupportedEncodingException
    //   351	356	359	java/io/IOException
    //   2	13	389	java/lang/NumberFormatException
    //   418	423	426	java/io/IOException
    //   40	47	459	finally
    //   61	75	459	finally
    //   202	212	459	finally
    //   269	279	459	finally
    //   336	346	459	finally
    //   403	413	459	finally
    //   477	482	485	java/io/IOException
    //   501	505	508	java/io/IOException
  }
  
  private static DisplayMetrics h(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      if (paramContext != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramContext.getMetrics(localDisplayMetrics);
        return localDisplayMetrics;
      }
    }
    return null;
  }
  
  public static String h()
  {
    return Build.VERSION.RELEASE.trim();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */