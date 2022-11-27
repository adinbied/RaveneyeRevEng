package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.a;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class bl
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.VERSION.INCREMENTAL);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    String str2 = bo.a(paramContext).a("sp_client_report_status", "sp_client_report_key", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = bf.a(20);
      bo.a(paramContext).a("sp_client_report_status", "sp_client_report_key", str1);
    }
    return str1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
    localIntent.putExtra("pkgname", paramContext.getPackageName());
    localIntent.putExtra("category", "category_client_report_data");
    localIntent.putExtra("name", "quality_support");
    localIntent.putExtra("data", paramString);
    paramContext.sendBroadcast(localIntent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 104	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 12
    //   7: aload 12
    //   9: ifnull +707 -> 716
    //   12: aload 12
    //   14: invokevirtual 110	java/io/File:exists	()Z
    //   17: ifne +9 -> 26
    //   20: aload 12
    //   22: invokevirtual 113	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 104	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull +683 -> 716
    //   36: aload_0
    //   37: invokevirtual 110	java/io/File:exists	()Z
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: invokevirtual 113	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: return
    //   49: aload_0
    //   50: new 115	com/xiaomi/push/bm
    //   53: dup
    //   54: invokespecial 116	com/xiaomi/push/bm:<init>	()V
    //   57: invokevirtual 120	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   60: astore 13
    //   62: aload 13
    //   64: ifnull +652 -> 716
    //   67: aload 13
    //   69: arraylength
    //   70: ifgt +4 -> 74
    //   73: return
    //   74: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   77: lstore 5
    //   79: aload 13
    //   81: arraylength
    //   82: istore 4
    //   84: iconst_0
    //   85: istore_3
    //   86: aconst_null
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore 7
    //   93: iload_3
    //   94: iload 4
    //   96: if_icmpge +620 -> 716
    //   99: aload 13
    //   101: iload_3
    //   102: aaload
    //   103: astore 11
    //   105: aload 11
    //   107: ifnull +537 -> 644
    //   110: aload 11
    //   112: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifeq +6 -> 124
    //   121: goto +523 -> 644
    //   124: new 8	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   131: astore_2
    //   132: aload_2
    //   133: aload 11
    //   135: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   138: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: ldc -125
    //   145: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new 106	java/io/File
    //   152: dup
    //   153: aload_2
    //   154: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_2
    //   161: aload_2
    //   162: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/File;)Z
    //   165: pop
    //   166: new 139	java/io/RandomAccessFile
    //   169: dup
    //   170: aload_2
    //   171: ldc -115
    //   173: invokespecial 144	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   176: astore 8
    //   178: aload_0
    //   179: astore_1
    //   180: aload_0
    //   181: astore 7
    //   183: aload 8
    //   185: astore 10
    //   187: aload_2
    //   188: astore 9
    //   190: aload 8
    //   192: invokevirtual 148	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   195: invokevirtual 154	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   198: astore_0
    //   199: aload_0
    //   200: astore_1
    //   201: aload_0
    //   202: astore 7
    //   204: aload 8
    //   206: astore 10
    //   208: aload_2
    //   209: astore 9
    //   211: aload 12
    //   213: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   216: astore 14
    //   218: aload_0
    //   219: astore_1
    //   220: aload_0
    //   221: astore 7
    //   223: aload 8
    //   225: astore 10
    //   227: aload_2
    //   228: astore 9
    //   230: new 8	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   237: astore 15
    //   239: aload_0
    //   240: astore_1
    //   241: aload_0
    //   242: astore 7
    //   244: aload 8
    //   246: astore 10
    //   248: aload_2
    //   249: astore 9
    //   251: aload 15
    //   253: aload 14
    //   255: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_0
    //   260: astore_1
    //   261: aload_0
    //   262: astore 7
    //   264: aload 8
    //   266: astore 10
    //   268: aload_2
    //   269: astore 9
    //   271: aload 15
    //   273: getstatic 157	java/io/File:separator	Ljava/lang/String;
    //   276: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_0
    //   281: astore_1
    //   282: aload_0
    //   283: astore 7
    //   285: aload 8
    //   287: astore 10
    //   289: aload_2
    //   290: astore 9
    //   292: aload 15
    //   294: aload 11
    //   296: invokevirtual 160	java/io/File:getName	()Ljava/lang/String;
    //   299: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_0
    //   304: astore_1
    //   305: aload_0
    //   306: astore 7
    //   308: aload 8
    //   310: astore 10
    //   312: aload_2
    //   313: astore 9
    //   315: aload 15
    //   317: lload 5
    //   319: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_0
    //   324: astore_1
    //   325: aload_0
    //   326: astore 7
    //   328: aload 8
    //   330: astore 10
    //   332: aload_2
    //   333: astore 9
    //   335: new 106	java/io/File
    //   338: dup
    //   339: aload 15
    //   341: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: astore 14
    //   349: aload_0
    //   350: astore_1
    //   351: aload_0
    //   352: astore 7
    //   354: aload 8
    //   356: astore 10
    //   358: aload_2
    //   359: astore 9
    //   361: aload 11
    //   363: aload 14
    //   365: invokestatic 167	com/xiaomi/push/y:b	(Ljava/io/File;Ljava/io/File;)V
    //   368: goto +58 -> 426
    //   371: astore 15
    //   373: aload_0
    //   374: astore_1
    //   375: aload_0
    //   376: astore 7
    //   378: aload 8
    //   380: astore 10
    //   382: aload_2
    //   383: astore 9
    //   385: aload 15
    //   387: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   390: aload_0
    //   391: astore_1
    //   392: aload_0
    //   393: astore 7
    //   395: aload 8
    //   397: astore 10
    //   399: aload_2
    //   400: astore 9
    //   402: aload 11
    //   404: invokevirtual 173	java/io/File:delete	()Z
    //   407: pop
    //   408: aload_0
    //   409: astore_1
    //   410: aload_0
    //   411: astore 7
    //   413: aload 8
    //   415: astore 10
    //   417: aload_2
    //   418: astore 9
    //   420: aload 14
    //   422: invokevirtual 173	java/io/File:delete	()Z
    //   425: pop
    //   426: aload_0
    //   427: astore_1
    //   428: aload_0
    //   429: astore 7
    //   431: aload 8
    //   433: astore 10
    //   435: aload_2
    //   436: astore 9
    //   438: aload 11
    //   440: invokevirtual 173	java/io/File:delete	()Z
    //   443: pop
    //   444: aload_0
    //   445: ifnull +22 -> 467
    //   448: aload_0
    //   449: invokevirtual 178	java/nio/channels/FileLock:isValid	()Z
    //   452: ifeq +15 -> 467
    //   455: aload_0
    //   456: invokevirtual 181	java/nio/channels/FileLock:release	()V
    //   459: goto +8 -> 467
    //   462: astore_1
    //   463: aload_1
    //   464: invokestatic 186	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   467: aload 8
    //   469: invokestatic 189	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   472: aload 8
    //   474: astore_1
    //   475: goto +94 -> 569
    //   478: astore 11
    //   480: aload_1
    //   481: astore_0
    //   482: aload 8
    //   484: astore_1
    //   485: goto +28 -> 513
    //   488: astore 7
    //   490: aload_2
    //   491: astore 9
    //   493: aload 7
    //   495: astore_2
    //   496: goto +104 -> 600
    //   499: astore 11
    //   501: goto +12 -> 513
    //   504: astore_2
    //   505: goto +99 -> 604
    //   508: astore 11
    //   510: aload 7
    //   512: astore_2
    //   513: aload_0
    //   514: astore 7
    //   516: aload_1
    //   517: astore 10
    //   519: aload_2
    //   520: astore 9
    //   522: aload 11
    //   524: invokestatic 186	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   527: aload_0
    //   528: ifnull +24 -> 552
    //   531: aload_0
    //   532: invokevirtual 178	java/nio/channels/FileLock:isValid	()Z
    //   535: ifeq +17 -> 552
    //   538: aload_0
    //   539: invokevirtual 181	java/nio/channels/FileLock:release	()V
    //   542: goto +10 -> 552
    //   545: astore 7
    //   547: aload 7
    //   549: invokestatic 186	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   552: aload_1
    //   553: invokestatic 189	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   556: aload_0
    //   557: astore 8
    //   559: aload_1
    //   560: astore 9
    //   562: aload_2
    //   563: astore 7
    //   565: aload_2
    //   566: ifnull +17 -> 583
    //   569: aload_2
    //   570: invokevirtual 173	java/io/File:delete	()Z
    //   573: pop
    //   574: aload_2
    //   575: astore 7
    //   577: aload_1
    //   578: astore 9
    //   580: aload_0
    //   581: astore 8
    //   583: aload 9
    //   585: astore_2
    //   586: aload 7
    //   588: astore 9
    //   590: goto +110 -> 700
    //   593: astore_2
    //   594: aload 10
    //   596: astore_1
    //   597: aload 7
    //   599: astore_0
    //   600: aload 9
    //   602: astore 7
    //   604: aload_0
    //   605: ifnull +22 -> 627
    //   608: aload_0
    //   609: invokevirtual 178	java/nio/channels/FileLock:isValid	()Z
    //   612: ifeq +15 -> 627
    //   615: aload_0
    //   616: invokevirtual 181	java/nio/channels/FileLock:release	()V
    //   619: goto +8 -> 627
    //   622: astore_0
    //   623: aload_0
    //   624: invokestatic 186	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   627: aload_1
    //   628: invokestatic 189	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   631: aload 7
    //   633: ifnull +9 -> 642
    //   636: aload 7
    //   638: invokevirtual 173	java/io/File:delete	()Z
    //   641: pop
    //   642: aload_2
    //   643: athrow
    //   644: aload_0
    //   645: ifnull +22 -> 667
    //   648: aload_0
    //   649: invokevirtual 178	java/nio/channels/FileLock:isValid	()Z
    //   652: ifeq +15 -> 667
    //   655: aload_0
    //   656: invokevirtual 181	java/nio/channels/FileLock:release	()V
    //   659: goto +8 -> 667
    //   662: astore_2
    //   663: aload_2
    //   664: invokestatic 186	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   667: aload_1
    //   668: invokestatic 189	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   671: aload_0
    //   672: astore 8
    //   674: aload_1
    //   675: astore_2
    //   676: aload 7
    //   678: astore 9
    //   680: aload 7
    //   682: ifnull +18 -> 700
    //   685: aload 7
    //   687: invokevirtual 173	java/io/File:delete	()Z
    //   690: pop
    //   691: aload 7
    //   693: astore 9
    //   695: aload_1
    //   696: astore_2
    //   697: aload_0
    //   698: astore 8
    //   700: iload_3
    //   701: iconst_1
    //   702: iadd
    //   703: istore_3
    //   704: aload 8
    //   706: astore_0
    //   707: aload_2
    //   708: astore_1
    //   709: aload 9
    //   711: astore 7
    //   713: goto -620 -> 93
    //   716: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	paramContext	Context
    //   0	717	1	paramString1	String
    //   0	717	2	paramString2	String
    //   85	619	3	i	int
    //   82	15	4	j	int
    //   77	241	5	l	long
    //   91	339	7	localObject1	Object
    //   488	23	7	localObject2	Object
    //   514	1	7	localContext	Context
    //   545	3	7	localIOException1	java.io.IOException
    //   563	149	7	localObject3	Object
    //   176	529	8	localObject4	Object
    //   188	522	9	localObject5	Object
    //   185	410	10	localObject6	Object
    //   103	336	11	localFile1	File
    //   478	1	11	localException1	Exception
    //   499	1	11	localException2	Exception
    //   508	15	11	localException3	Exception
    //   5	207	12	localFile2	File
    //   60	40	13	arrayOfFile	File[]
    //   216	205	14	localObject7	Object
    //   237	103	15	localStringBuilder	StringBuilder
    //   371	15	15	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   361	368	371	java/io/IOException
    //   455	459	462	java/io/IOException
    //   190	199	478	java/lang/Exception
    //   211	218	478	java/lang/Exception
    //   230	239	478	java/lang/Exception
    //   251	259	478	java/lang/Exception
    //   271	280	478	java/lang/Exception
    //   292	303	478	java/lang/Exception
    //   315	323	478	java/lang/Exception
    //   335	349	478	java/lang/Exception
    //   361	368	478	java/lang/Exception
    //   385	390	478	java/lang/Exception
    //   402	408	478	java/lang/Exception
    //   420	426	478	java/lang/Exception
    //   438	444	478	java/lang/Exception
    //   161	178	488	finally
    //   161	178	499	java/lang/Exception
    //   110	121	504	finally
    //   124	161	504	finally
    //   110	121	508	java/lang/Exception
    //   124	161	508	java/lang/Exception
    //   538	542	545	java/io/IOException
    //   190	199	593	finally
    //   211	218	593	finally
    //   230	239	593	finally
    //   251	259	593	finally
    //   271	280	593	finally
    //   292	303	593	finally
    //   315	323	593	finally
    //   335	349	593	finally
    //   361	368	593	finally
    //   385	390	593	finally
    //   402	408	593	finally
    //   420	426	593	finally
    //   438	444	593	finally
    //   522	527	593	finally
    //   615	619	622	java/io/IOException
    //   655	659	662	java/io/IOException
  }
  
  public static void a(Context paramContext, List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (a(paramContext))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (!TextUtils.isEmpty(str)) {
            a(paramContext, str);
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext().getPackageManager();
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
      if (i >= 108) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramString = new File(paramString);
    long l1 = a.a(paramContext).a().getMaxFileLength();
    if (paramString.exists()) {
      try
      {
        long l2 = paramString.length();
        if (l2 <= l1) {
          break label54;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        b.a(paramContext);
        return false;
      }
    } else {
      y.a(paramString);
    }
    label54:
    return true;
  }
  
  public static byte[] a(String paramString)
  {
    paramString = Arrays.copyOf(bc.a(paramString), 16);
    paramString[0] = 68;
    paramString[15] = 84;
    return paramString;
  }
  
  public static File[] a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getExternalFilesDir(paramString);
    if (paramContext != null) {
      return paramContext.listFiles(new bn());
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */