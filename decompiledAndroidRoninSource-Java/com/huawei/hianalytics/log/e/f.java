package com.huawei.hianalytics.log.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class f
{
  public static String a()
  {
    String str = c();
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append(".log");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = paramString.split("=");
    try
    {
      float f2 = Float.parseFloat(localObject[1].trim());
      if (f2 > 3.0F)
      {
        f1 = 3.0F;
      }
      else
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      float f1;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("The cycle of the server returns : ");
    ((StringBuilder)localObject).append(paramString);
    b.d("AppLogApi/LogUtil", ((StringBuilder)localObject).toString());
    f1 = 1.0F;
    paramString = new StringBuilder();
    paramString.append("setpolicy cycle : ");
    paramString.append(f1);
    b.b("AppLogApi/LogUtil", paramString.toString());
    c.a(c.b(paramContext), "autocheck_policy", Float.valueOf(1.0F));
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null)
    {
      b.c("AppLogApi/LogUtil", "No init of logServer!");
      return false;
    }
    long l1 = System.currentTimeMillis();
    paramContext = c.b(paramContext);
    long l2 = ((Long)c.b(paramContext, "autocheck_starttime", Long.valueOf(-1L))).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkPolicyOver beforeTimeMillis : ");
    localStringBuilder.append(l2);
    b.b("AppLogApi/LogUtil", localStringBuilder.toString());
    if (-1L == l2) {
      b.c("AppLogApi/LogUtil", "checkPolicyOver beforeTimeMillis is first!");
    }
    long l3;
    do
    {
      for (;;)
      {
        bool = true;
        break label192;
        float f = ((Float)c.b(paramContext, "autocheck_policy", Float.valueOf(-1.0F))).floatValue();
        l3 = (8.64E7F * f);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkPolicyOver policy : ");
        localStringBuilder.append(f);
        b.b("AppLogApi/LogUtil", localStringBuilder.toString());
        if (-1.0F != f) {
          break;
        }
        c.a(paramContext, "autocheck_policy", Float.valueOf(1.0F));
      }
    } while (l1 - l2 > l3);
    label192:
    paramContext = new StringBuilder();
    paramContext.append("checkPolicyOver() No upload cycle :  ");
    paramContext.append(bool);
    b.b("AppLogApi/LogUtil", paramContext.toString());
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return paramString.mkdirs();
    }
    return true;
  }
  
  public static boolean a(File[] paramArrayOfFile)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      if (!localFile.getName().contains("Crash"))
      {
        if (localFile.delete()) {
          b.c("AppLogApi/LogUtil", "Logzips folder is larger than 1.8M, and the first file is deleted. ");
        }
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(File[] paramArrayOfFile, File paramFile)
  {
    return b(paramArrayOfFile, paramFile);
  }
  
  public static int b(File[] paramArrayOfFile)
  {
    int m = paramArrayOfFile.length;
    int n = paramArrayOfFile.length;
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      Object localObject = paramArrayOfFile[j];
      String str = ((File)localObject).getPath();
      k = i;
      if (!str.endsWith(".log"))
      {
        k = i;
        if (!str.endsWith(".zip"))
        {
          if (((File)localObject).delete()) {
            i += 1;
          }
          for (localObject = "del filter file :";; localObject = "del file failed.")
          {
            b.b("HiAnalytics/logServer", (String)localObject);
            k = i;
            break;
          }
        }
      }
      j += 1;
    }
    return m - i;
  }
  
  public static String b()
  {
    Date localDate = Calendar.getInstance().getTime();
    return new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(localDate);
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!new File(paramString).delete()) {
      b.d("AppLogApi/LogUtil", "delete file fail");
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null)
    {
      b.d("AppLogApi/LogUtil", "No init of logServer!");
      return false;
    }
    SharedPreferences localSharedPreferences = c.b(paramContext);
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)c.b(localSharedPreferences, "autocheck_tenminstarttime", Long.valueOf(-1L))).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkTimeOver beforeTimeMillis : ");
    localStringBuilder.append(l2);
    b.b("AppLogApi/LogUtil", localStringBuilder.toString());
    boolean bool1;
    if (-1L != l2)
    {
      bool1 = bool2;
      if (l1 - l2 > 600000L)
      {
        bool1 = bool2;
        if (!c(paramContext)) {}
      }
    }
    else
    {
      c.a(localSharedPreferences, "autocheck_tenminstarttime", Long.valueOf(l1));
      b.b("AppLogApi/LogUtil", "setTenMinAutoCheckTime!");
      bool1 = true;
    }
    paramContext = new StringBuilder();
    paramContext.append("checkTimeOver ");
    paramContext.append(bool1);
    b.c("AppLogApi/LogUtil", paramContext.toString());
    return bool1;
  }
  
  /* Error */
  private static boolean b(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 14
    //   10: aconst_null
    //   11: astore 11
    //   13: aconst_null
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 13
    //   19: new 233	java/io/FileOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 236	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: astore_1
    //   28: aload 11
    //   30: astore 10
    //   32: aload_1
    //   33: astore 11
    //   35: new 238	java/util/zip/ZipOutputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 241	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore 12
    //   45: aload_0
    //   46: ifnull +227 -> 273
    //   49: aload_0
    //   50: arraylength
    //   51: ifle +222 -> 273
    //   54: aload_0
    //   55: arraylength
    //   56: istore 6
    //   58: iconst_0
    //   59: istore 5
    //   61: iconst_0
    //   62: istore_3
    //   63: iload 5
    //   65: iload 6
    //   67: if_icmpge +206 -> 273
    //   70: aload_0
    //   71: iload 5
    //   73: aaload
    //   74: astore 11
    //   76: aload 11
    //   78: invokevirtual 244	java/io/File:length	()J
    //   81: l2d
    //   82: ldc2_w 245
    //   85: dcmpl
    //   86: ifle +25 -> 111
    //   89: iload_3
    //   90: istore_2
    //   91: aload 11
    //   93: invokevirtual 161	java/io/File:delete	()Z
    //   96: ifeq +144 -> 240
    //   99: ldc 61
    //   101: ldc -8
    //   103: invokestatic 75	com/huawei/hianalytics/g/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: iload_3
    //   107: istore_2
    //   108: goto +132 -> 240
    //   111: new 250	java/io/FileInputStream
    //   114: dup
    //   115: aload 11
    //   117: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: astore 10
    //   122: iload_3
    //   123: istore_2
    //   124: aload 12
    //   126: new 253	java/util/zip/ZipEntry
    //   129: dup
    //   130: aload 11
    //   132: invokevirtual 152	java/io/File:getName	()Ljava/lang/String;
    //   135: invokespecial 254	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   138: invokevirtual 258	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   141: iload_3
    //   142: istore_2
    //   143: aload 11
    //   145: invokevirtual 244	java/io/File:length	()J
    //   148: lstore 8
    //   150: iload_3
    //   151: istore 4
    //   153: iload_3
    //   154: i2l
    //   155: lload 8
    //   157: ladd
    //   158: l2d
    //   159: ldc2_w 245
    //   162: dcmpl
    //   163: ifgt +42 -> 205
    //   166: iload_3
    //   167: istore_2
    //   168: aload 10
    //   170: aload 14
    //   172: invokevirtual 262	java/io/FileInputStream:read	([B)I
    //   175: istore 7
    //   177: iload_3
    //   178: istore 4
    //   180: iload 7
    //   182: ifle +23 -> 205
    //   185: iload_3
    //   186: iload 7
    //   188: iadd
    //   189: istore_3
    //   190: iload_3
    //   191: istore_2
    //   192: aload 12
    //   194: aload 14
    //   196: iconst_0
    //   197: iload 7
    //   199: invokevirtual 266	java/util/zip/ZipOutputStream:write	([BII)V
    //   202: goto -36 -> 166
    //   205: iload 4
    //   207: istore_2
    //   208: aload 12
    //   210: invokevirtual 269	java/util/zip/ZipOutputStream:flush	()V
    //   213: iload 4
    //   215: istore_2
    //   216: iconst_1
    //   217: aload 10
    //   219: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   222: goto +18 -> 240
    //   225: astore_0
    //   226: goto +25 -> 251
    //   229: ldc 61
    //   231: ldc_w 276
    //   234: invokestatic 67	com/huawei/hianalytics/g/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -21 -> 216
    //   240: iload 5
    //   242: iconst_1
    //   243: iadd
    //   244: istore 5
    //   246: iload_2
    //   247: istore_3
    //   248: goto -185 -> 63
    //   251: iconst_1
    //   252: aload 10
    //   254: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   257: aload_0
    //   258: athrow
    //   259: astore_0
    //   260: aload 12
    //   262: astore 10
    //   264: goto +71 -> 335
    //   267: aload 12
    //   269: astore_0
    //   270: goto +31 -> 301
    //   273: iconst_5
    //   274: aload 12
    //   276: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   279: bipush 6
    //   281: aload_1
    //   282: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   285: ldc 2
    //   287: monitorexit
    //   288: iconst_1
    //   289: ireturn
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_1
    //   293: goto +42 -> 335
    //   296: aconst_null
    //   297: astore_1
    //   298: aload 13
    //   300: astore_0
    //   301: aload_0
    //   302: astore 10
    //   304: aload_1
    //   305: astore 11
    //   307: ldc -77
    //   309: ldc_w 278
    //   312: invokestatic 94	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: iconst_5
    //   316: aload_0
    //   317: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   320: bipush 6
    //   322: aload_1
    //   323: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   326: ldc 2
    //   328: monitorexit
    //   329: iconst_0
    //   330: ireturn
    //   331: astore_0
    //   332: aload 11
    //   334: astore_1
    //   335: iconst_5
    //   336: aload 10
    //   338: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   341: bipush 6
    //   343: aload_1
    //   344: invokestatic 274	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   347: aload_0
    //   348: athrow
    //   349: astore_0
    //   350: ldc 2
    //   352: monitorexit
    //   353: aload_0
    //   354: athrow
    //   355: astore_0
    //   356: goto -60 -> 296
    //   359: astore_0
    //   360: aload 13
    //   362: astore_0
    //   363: goto -62 -> 301
    //   366: astore_0
    //   367: goto -100 -> 267
    //   370: astore 11
    //   372: goto -143 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramArrayOfFile	File[]
    //   0	375	1	paramFile	File
    //   90	157	2	i	int
    //   62	186	3	j	int
    //   151	63	4	k	int
    //   59	186	5	m	int
    //   56	12	6	n	int
    //   175	23	7	i1	int
    //   148	8	8	l	long
    //   14	323	10	localObject1	Object
    //   11	322	11	localFile	File
    //   370	1	11	localIOException	java.io.IOException
    //   43	232	12	localZipOutputStream	java.util.zip.ZipOutputStream
    //   17	344	13	localObject2	Object
    //   8	187	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   124	141	225	finally
    //   143	150	225	finally
    //   168	177	225	finally
    //   192	202	225	finally
    //   208	213	225	finally
    //   229	237	225	finally
    //   49	58	259	finally
    //   76	89	259	finally
    //   91	106	259	finally
    //   111	122	259	finally
    //   216	222	259	finally
    //   251	259	259	finally
    //   19	28	290	finally
    //   35	45	331	finally
    //   307	315	331	finally
    //   3	10	349	finally
    //   273	285	349	finally
    //   315	326	349	finally
    //   335	349	349	finally
    //   19	28	355	java/io/FileNotFoundException
    //   35	45	359	java/io/FileNotFoundException
    //   49	58	366	java/io/FileNotFoundException
    //   76	89	366	java/io/FileNotFoundException
    //   91	106	366	java/io/FileNotFoundException
    //   111	122	366	java/io/FileNotFoundException
    //   216	222	366	java/io/FileNotFoundException
    //   251	259	366	java/io/FileNotFoundException
    //   124	141	370	java/io/IOException
    //   143	150	370	java/io/IOException
    //   168	177	370	java/io/IOException
    //   192	202	370	java/io/IOException
    //   208	213	370	java/io/IOException
  }
  
  private static String c()
  {
    Date localDate = Calendar.getInstance().getTime();
    return new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault()).format(localDate);
  }
  
  private static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    if ((paramContext != null) && (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0))
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.isConnected())
        {
          bool1 = bool2;
          if (paramContext.isAvailable()) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    b.c("HiAnalytics/logServer", "not have network state phone permission!");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */