package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class b
{
  private static final String[] a = { "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  private static final String[] b = { "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  private static final String[] c = { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    finally
    {
      if (!x.a(paramContext)) {
        x.a("Failed to get Android ID.", new Object[0]);
      }
    }
    return (String)localObject;
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramBoolean) {}
    try
    {
      localObject1 = z.a(paramContext, "ro.product.cpu.abilist");
      Object localObject2;
      if (!z.a((String)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals("fail")) {}
      }
      else
      {
        localObject2 = z.a(paramContext, "ro.product.cpu.abi");
      }
      localObject1 = localObject3;
      if (!z.a((String)localObject2)) {
        if (((String)localObject2).equals("fail"))
        {
          localObject1 = localObject3;
        }
        else
        {
          paramContext = new StringBuilder("ABI list: ");
          paramContext.append((String)localObject2);
          x.b(b.class, paramContext.toString(), new Object[0]);
          localObject1 = localObject2.split(",")[0];
        }
      }
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = System.getProperty("os.arch");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      paramContext = ((StringBuilder)localObject1).toString();
      return paramContext;
    }
    finally
    {
      for (;;) {}
    }
    if (!x.a(paramContext)) {
      paramContext.printStackTrace();
    }
    return "fail";
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return null;
        }
        if (localNetworkInfo.getType() == 1) {
          return "WIFI";
        }
        if (localNetworkInfo.getType() == 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            switch (i)
            {
            default: 
              paramContext = new StringBuilder("MOBILE(");
              paramContext.append(i);
              paramContext.append(")");
              paramContext = paramContext.toString();
              return paramContext;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        if (!x.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
      return "unknown";
    }
    return "HSPA+";
    return "eHRPD";
    return "LTE";
    return "EVDO_B";
    return "iDen";
    return "HSPA";
    return "HSUPA";
    return "HSDPA";
    return "1xRTT";
    return "EVDO_A";
    return "EVDO_0";
    return "CDMA";
    return "UMTS";
    return "EDGE";
    return "GPRS";
  }
  
  public static int c()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = z.a(paramContext, "ro.miui.ui.version.name");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("XiaoMi/MIUI/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.build.version.emui");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("HuaWei/EMOTION/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.lenovo.series");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = z.a(paramContext, "ro.build.version.incremental");
      localObject = new StringBuilder("Lenovo/VIBE/");
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
    localObject = z.a(paramContext, "ro.build.nubia.rom.name");
    StringBuilder localStringBuilder;
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("Zte/NUBIA/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append(z.a(paramContext, "ro.build.nubia.rom.code"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.meizu.product.model");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localObject = new StringBuilder("Meizu/FLYME/");
      ((StringBuilder)localObject).append(z.a(paramContext, "ro.build.display.id"));
      return ((StringBuilder)localObject).toString();
    }
    localObject = z.a(paramContext, "ro.build.version.opporom");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("Oppo/COLOROS/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.vivo.os.build.display.id");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("vivo/FUNTOUCH/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.aa.romver");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("htc/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(z.a(paramContext, "ro.build.description"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.lewa.version");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("tcl/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(z.a(paramContext, "ro.build.display.id"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.gn.gnromvernumber");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("amigo/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(z.a(paramContext, "ro.build.display.id"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.build.tyd.kbstyle_version");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("dido/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(z.a(paramContext, "ro.build.fingerprint"));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(z.a(paramContext, "ro.build.rom.id"));
    return ((StringBuilder)localObject).toString();
  }
  
  public static long d()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static String d(Context paramContext)
  {
    return z.a(paramContext, "ro.board.platform");
  }
  
  public static long e()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static boolean e(Context paramContext)
  {
    if (g(paramContext) == null)
    {
      paramContext = new ArrayList();
      int i = 0;
      while (i < c.length)
      {
        Object localObject = c;
        if (i == 0)
        {
          localObject = new File(localObject[i]);
          if (((File)localObject).exists()) {
            break label81;
          }
        }
        else
        {
          localObject = new File(localObject[i]);
          if (!((File)localObject).exists()) {
            break label81;
          }
        }
        paramContext.add(Integer.valueOf(i));
        label81:
        i += 1;
      }
      if (paramContext.isEmpty()) {
        paramContext = null;
      } else {
        paramContext = paramContext.toString();
      }
      if (paramContext == null) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static long f()
  {
    // Byte code:
    //   0: new 467	java/io/FileReader
    //   3: dup
    //   4: ldc_w 469
    //   7: invokespecial 470	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: new 472	java/io/BufferedReader
    //   15: dup
    //   16: aload 4
    //   18: sipush 2048
    //   21: invokespecial 475	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 478	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +46 -> 77
    //   34: aload_2
    //   35: invokevirtual 481	java/io/BufferedReader:close	()V
    //   38: goto +15 -> 53
    //   41: astore_2
    //   42: aload_2
    //   43: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   46: ifne +7 -> 53
    //   49: aload_2
    //   50: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   53: aload 4
    //   55: invokevirtual 483	java/io/FileReader:close	()V
    //   58: goto +15 -> 73
    //   61: astore_2
    //   62: aload_2
    //   63: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   66: ifne +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   73: ldc2_w 430
    //   76: lreturn
    //   77: aload_3
    //   78: ldc_w 485
    //   81: iconst_2
    //   82: invokevirtual 488	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   85: iconst_1
    //   86: aaload
    //   87: invokevirtual 215	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   90: ldc_w 490
    //   93: ldc_w 492
    //   96: invokevirtual 496	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   99: invokevirtual 499	java/lang/String:trim	()Ljava/lang/String;
    //   102: invokestatic 505	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore_0
    //   106: lload_0
    //   107: bipush 10
    //   109: lshl
    //   110: lstore_0
    //   111: aload_2
    //   112: invokevirtual 481	java/io/BufferedReader:close	()V
    //   115: goto +15 -> 130
    //   118: astore_2
    //   119: aload_2
    //   120: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   123: ifne +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   130: aload 4
    //   132: invokevirtual 483	java/io/FileReader:close	()V
    //   135: lload_0
    //   136: lreturn
    //   137: astore_2
    //   138: aload_2
    //   139: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   142: ifne +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   149: lload_0
    //   150: lreturn
    //   151: astore_3
    //   152: goto +16 -> 168
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_2
    //   158: goto +10 -> 168
    //   161: astore_3
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 4
    //   167: astore_2
    //   168: aload_3
    //   169: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   172: ifne +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   179: aload_2
    //   180: ifnull +22 -> 202
    //   183: aload_2
    //   184: invokevirtual 481	java/io/BufferedReader:close	()V
    //   187: goto +15 -> 202
    //   190: astore_2
    //   191: aload_2
    //   192: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   195: ifne +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   202: aload 4
    //   204: ifnull +23 -> 227
    //   207: aload 4
    //   209: invokevirtual 483	java/io/FileReader:close	()V
    //   212: goto +15 -> 227
    //   215: astore_2
    //   216: aload_2
    //   217: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   220: ifne +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   227: ldc2_w 506
    //   230: lreturn
    //   231: astore_3
    //   232: aload_2
    //   233: ifnull +22 -> 255
    //   236: aload_2
    //   237: invokevirtual 481	java/io/BufferedReader:close	()V
    //   240: goto +15 -> 255
    //   243: astore_2
    //   244: aload_2
    //   245: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   248: ifne +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   255: aload 4
    //   257: ifnull +23 -> 280
    //   260: aload 4
    //   262: invokevirtual 483	java/io/FileReader:close	()V
    //   265: goto +15 -> 280
    //   268: astore_2
    //   269: aload_2
    //   270: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   273: ifne +7 -> 280
    //   276: aload_2
    //   277: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   280: aload_3
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   105	45	0	l	long
    //   24	11	2	localBufferedReader	java.io.BufferedReader
    //   41	9	2	localIOException1	java.io.IOException
    //   61	51	2	localIOException2	java.io.IOException
    //   118	9	2	localIOException3	java.io.IOException
    //   137	9	2	localIOException4	java.io.IOException
    //   157	27	2	localFileReader1	java.io.FileReader
    //   190	9	2	localIOException5	java.io.IOException
    //   215	22	2	localIOException6	java.io.IOException
    //   243	9	2	localIOException7	java.io.IOException
    //   268	9	2	localIOException8	java.io.IOException
    //   29	49	3	str	String
    //   151	1	3	localObject1	Object
    //   155	1	3	localObject2	Object
    //   161	15	3	localThrowable	Throwable
    //   231	50	3	localObject3	Object
    //   10	251	4	localFileReader2	java.io.FileReader
    // Exception table:
    //   from	to	target	type
    //   34	38	41	java/io/IOException
    //   53	58	61	java/io/IOException
    //   111	115	118	java/io/IOException
    //   130	135	137	java/io/IOException
    //   25	30	151	finally
    //   77	106	151	finally
    //   12	25	155	finally
    //   0	12	161	finally
    //   183	187	190	java/io/IOException
    //   207	212	215	java/io/IOException
    //   168	179	231	finally
    //   236	240	243	java/io/IOException
    //   260	265	268	java/io/IOException
  }
  
  public static boolean f(Context paramContext)
  {
    return (h(paramContext) | p() | q() | o()) > 0;
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 467	java/io/FileReader
    //   6: dup
    //   7: ldc_w 469
    //   10: invokespecial 470	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 7
    //   15: new 472	java/io/BufferedReader
    //   18: dup
    //   19: aload 7
    //   21: sipush 2048
    //   24: invokespecial 475	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 6
    //   29: aload 6
    //   31: invokevirtual 478	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: pop
    //   35: aload 6
    //   37: invokevirtual 478	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnonnull +54 -> 98
    //   47: aload 6
    //   49: invokevirtual 481	java/io/BufferedReader:close	()V
    //   52: goto +18 -> 70
    //   55: astore 6
    //   57: aload 6
    //   59: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   62: ifne +8 -> 70
    //   65: aload 6
    //   67: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   70: aload 7
    //   72: invokevirtual 483	java/io/FileReader:close	()V
    //   75: ldc2_w 430
    //   78: lreturn
    //   79: astore 6
    //   81: aload 6
    //   83: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   86: ifne +8 -> 94
    //   89: aload 6
    //   91: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   94: ldc2_w 430
    //   97: lreturn
    //   98: aload 8
    //   100: ldc_w 485
    //   103: iconst_2
    //   104: invokevirtual 488	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   107: iconst_1
    //   108: aaload
    //   109: invokevirtual 215	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: ldc_w 490
    //   115: ldc_w 492
    //   118: invokevirtual 496	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   121: invokevirtual 499	java/lang/String:trim	()Ljava/lang/String;
    //   124: invokestatic 505	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   127: lstore_0
    //   128: aload 6
    //   130: invokevirtual 478	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   133: astore 8
    //   135: aload 8
    //   137: ifnonnull +54 -> 191
    //   140: aload 6
    //   142: invokevirtual 481	java/io/BufferedReader:close	()V
    //   145: goto +18 -> 163
    //   148: astore 6
    //   150: aload 6
    //   152: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   155: ifne +8 -> 163
    //   158: aload 6
    //   160: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   163: aload 7
    //   165: invokevirtual 483	java/io/FileReader:close	()V
    //   168: ldc2_w 430
    //   171: lreturn
    //   172: astore 6
    //   174: aload 6
    //   176: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   179: ifne +8 -> 187
    //   182: aload 6
    //   184: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   187: ldc2_w 430
    //   190: lreturn
    //   191: aload 8
    //   193: ldc_w 485
    //   196: iconst_2
    //   197: invokevirtual 488	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   200: iconst_1
    //   201: aaload
    //   202: invokevirtual 215	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   205: ldc_w 490
    //   208: ldc_w 492
    //   211: invokevirtual 496	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   214: invokevirtual 499	java/lang/String:trim	()Ljava/lang/String;
    //   217: invokestatic 505	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   220: lstore_2
    //   221: aload 6
    //   223: invokevirtual 478	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   226: astore 8
    //   228: aload 8
    //   230: ifnonnull +54 -> 284
    //   233: aload 6
    //   235: invokevirtual 481	java/io/BufferedReader:close	()V
    //   238: goto +18 -> 256
    //   241: astore 6
    //   243: aload 6
    //   245: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   248: ifne +8 -> 256
    //   251: aload 6
    //   253: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   256: aload 7
    //   258: invokevirtual 483	java/io/FileReader:close	()V
    //   261: ldc2_w 430
    //   264: lreturn
    //   265: astore 6
    //   267: aload 6
    //   269: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   272: ifne +8 -> 280
    //   275: aload 6
    //   277: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   280: ldc2_w 430
    //   283: lreturn
    //   284: aload 8
    //   286: ldc_w 485
    //   289: iconst_2
    //   290: invokevirtual 488	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   293: iconst_1
    //   294: aaload
    //   295: invokevirtual 215	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   298: ldc_w 490
    //   301: ldc_w 492
    //   304: invokevirtual 496	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   307: invokevirtual 499	java/lang/String:trim	()Ljava/lang/String;
    //   310: invokestatic 505	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   313: lstore 4
    //   315: lload_0
    //   316: bipush 10
    //   318: lshl
    //   319: lconst_0
    //   320: ladd
    //   321: lload_2
    //   322: bipush 10
    //   324: lshl
    //   325: ladd
    //   326: lload 4
    //   328: bipush 10
    //   330: lshl
    //   331: ladd
    //   332: lstore_0
    //   333: aload 6
    //   335: invokevirtual 481	java/io/BufferedReader:close	()V
    //   338: goto +18 -> 356
    //   341: astore 6
    //   343: aload 6
    //   345: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   348: ifne +8 -> 356
    //   351: aload 6
    //   353: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   356: aload 7
    //   358: invokevirtual 483	java/io/FileReader:close	()V
    //   361: lload_0
    //   362: lreturn
    //   363: astore 6
    //   365: aload 6
    //   367: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   370: ifne +8 -> 378
    //   373: aload 6
    //   375: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   378: lload_0
    //   379: lreturn
    //   380: astore 9
    //   382: aload 6
    //   384: astore 8
    //   386: aload 9
    //   388: astore 6
    //   390: goto +13 -> 403
    //   393: astore 6
    //   395: goto +8 -> 403
    //   398: astore 6
    //   400: aconst_null
    //   401: astore 7
    //   403: aload 6
    //   405: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   408: ifne +8 -> 416
    //   411: aload 6
    //   413: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   416: aload 8
    //   418: ifnull +26 -> 444
    //   421: aload 8
    //   423: invokevirtual 481	java/io/BufferedReader:close	()V
    //   426: goto +18 -> 444
    //   429: astore 6
    //   431: aload 6
    //   433: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   436: ifne +8 -> 444
    //   439: aload 6
    //   441: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   444: aload 7
    //   446: ifnull +26 -> 472
    //   449: aload 7
    //   451: invokevirtual 483	java/io/FileReader:close	()V
    //   454: goto +18 -> 472
    //   457: astore 6
    //   459: aload 6
    //   461: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   464: ifne +8 -> 472
    //   467: aload 6
    //   469: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   472: ldc2_w 506
    //   475: lreturn
    //   476: astore 6
    //   478: aload 8
    //   480: ifnull +26 -> 506
    //   483: aload 8
    //   485: invokevirtual 481	java/io/BufferedReader:close	()V
    //   488: goto +18 -> 506
    //   491: astore 8
    //   493: aload 8
    //   495: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   498: ifne +8 -> 506
    //   501: aload 8
    //   503: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   506: aload 7
    //   508: ifnull +26 -> 534
    //   511: aload 7
    //   513: invokevirtual 483	java/io/FileReader:close	()V
    //   516: goto +18 -> 534
    //   519: astore 7
    //   521: aload 7
    //   523: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   526: ifne +8 -> 534
    //   529: aload 7
    //   531: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   534: aload 6
    //   536: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   127	252	0	l1	long
    //   220	102	2	l2	long
    //   313	14	4	l3	long
    //   27	21	6	localBufferedReader	java.io.BufferedReader
    //   55	11	6	localIOException1	java.io.IOException
    //   79	62	6	localIOException2	java.io.IOException
    //   148	11	6	localIOException3	java.io.IOException
    //   172	62	6	localIOException4	java.io.IOException
    //   241	11	6	localIOException5	java.io.IOException
    //   265	69	6	localIOException6	java.io.IOException
    //   341	11	6	localIOException7	java.io.IOException
    //   363	20	6	localIOException8	java.io.IOException
    //   388	1	6	localObject1	Object
    //   393	1	6	localObject2	Object
    //   398	14	6	localThrowable	Throwable
    //   429	11	6	localIOException9	java.io.IOException
    //   457	11	6	localIOException10	java.io.IOException
    //   476	59	6	localObject3	Object
    //   13	499	7	localFileReader	java.io.FileReader
    //   519	11	7	localIOException11	java.io.IOException
    //   1	483	8	localObject4	Object
    //   491	11	8	localIOException12	java.io.IOException
    //   380	7	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   47	52	55	java/io/IOException
    //   70	75	79	java/io/IOException
    //   140	145	148	java/io/IOException
    //   163	168	172	java/io/IOException
    //   233	238	241	java/io/IOException
    //   256	261	265	java/io/IOException
    //   333	338	341	java/io/IOException
    //   356	361	363	java/io/IOException
    //   29	42	380	finally
    //   98	135	380	finally
    //   191	228	380	finally
    //   284	315	380	finally
    //   15	29	393	finally
    //   3	15	398	finally
    //   421	426	429	java/io/IOException
    //   449	454	457	java/io/IOException
    //   403	416	476	finally
    //   483	488	491	java/io/IOException
    //   511	516	519	java/io/IOException
  }
  
  private static String g(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = b;
      if (i < arrayOfString.length) {}
      try
      {
        paramContext.getPackageInfo(arrayOfString[i], 1);
        localArrayList.add(Integer.valueOf(i));
        i += 1;
        continue;
        if (localArrayList.isEmpty()) {
          return null;
        }
        return localArrayList.toString();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
    }
  }
  
  private static int h(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getInstallerPackageName("de.robv.android.xposed.installer");
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramContext.getInstallerPackageName("com.saurik.substrate");
          return i | 0x2;
        }
        catch (Exception paramContext) {}
        localException = localException;
      }
    }
    int i = 0;
    return i;
  }
  
  public static long h()
  {
    if (!n()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      return j * i;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static long i()
  {
    if (!n()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      return j * i;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static String j()
  {
    return "";
  }
  
  public static String k()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static boolean l()
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (new File(arrayOfString[i]).exists())
      {
        i = 1;
        break label44;
      }
      i += 1;
    }
    i = 0;
    label44:
    if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys"))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return i != 0;
    }
    return true;
  }
  
  public static boolean m()
  {
    float f1 = (float)(Runtime.getRuntime().maxMemory() / 1048576.0D);
    float f2 = (float)(Runtime.getRuntime().totalMemory() / 1048576.0D);
    float f3 = f1 - f2;
    x.c("maxMemory : %f", new Object[] { Float.valueOf(f1) });
    x.c("totalMemory : %f", new Object[] { Float.valueOf(f2) });
    x.c("freeMemory : %f", new Object[] { Float.valueOf(f3) });
    return f3 < 10.0F;
  }
  
  private static boolean n()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      if (bool) {
        return true;
      }
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  private static int o()
  {
    try
    {
      Method localMethod = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = localMethod.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy");
      if (bool) {
        return 256;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 256;
  }
  
  private static int p()
  {
    try
    {
      throw new Exception("detect hook");
    }
    catch (Exception localException)
    {
      StackTraceElement[] arrayOfStackTraceElement = localException.getStackTrace();
      int i1 = arrayOfStackTraceElement.length;
      int k = 0;
      int j = 0;
      int n;
      for (int m = 0; k < i1; m = n)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[k];
        int i = j;
        if (localStackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge"))
        {
          i = j;
          if (localStackTraceElement.getMethodName().equals("main")) {
            i = j | 0x4;
          }
        }
        j = i;
        if (localStackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge"))
        {
          j = i;
          if (localStackTraceElement.getMethodName().equals("handleHookedMethod")) {
            j = i | 0x8;
          }
        }
        i = j;
        if (localStackTraceElement.getClassName().equals("com.saurik.substrate.MS$2"))
        {
          i = j;
          if (localStackTraceElement.getMethodName().equals("invoked")) {
            i = j | 0x10;
          }
        }
        j = i;
        n = m;
        if (localStackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit"))
        {
          m += 1;
          j = i;
          n = m;
          if (m == 2)
          {
            j = i | 0x20;
            n = m;
          }
        }
        k += 1;
      }
      return j;
    }
  }
  
  /* Error */
  private static int q()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 6
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: iconst_0
    //   16: istore_0
    //   17: aconst_null
    //   18: astore 10
    //   20: new 664	java/util/HashSet
    //   23: dup
    //   24: invokespecial 665	java/util/HashSet:<init>	()V
    //   27: astore 11
    //   29: new 239	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 667
    //   36: invokespecial 244	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: astore 8
    //   41: aload 8
    //   43: invokestatic 672	android/os/Process:myPid	()I
    //   46: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 8
    //   52: ldc_w 674
    //   55: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 472	java/io/BufferedReader
    //   62: dup
    //   63: new 676	java/io/InputStreamReader
    //   66: dup
    //   67: new 678	java/io/FileInputStream
    //   70: dup
    //   71: aload 8
    //   73: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 679	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   79: ldc_w 681
    //   82: invokespecial 684	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   85: invokespecial 687	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore 9
    //   90: iload_1
    //   91: istore_2
    //   92: iload 5
    //   94: istore_3
    //   95: iload 6
    //   97: istore 4
    //   99: aload 9
    //   101: astore 8
    //   103: aload 9
    //   105: invokevirtual 478	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   108: astore 10
    //   110: aload 10
    //   112: ifnull +88 -> 200
    //   115: iload_1
    //   116: istore_2
    //   117: iload 5
    //   119: istore_3
    //   120: iload 6
    //   122: istore 4
    //   124: aload 9
    //   126: astore 8
    //   128: aload 10
    //   130: ldc_w 689
    //   133: invokevirtual 692	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   136: ifne +27 -> 163
    //   139: iload_1
    //   140: istore_2
    //   141: iload 5
    //   143: istore_3
    //   144: iload 6
    //   146: istore 4
    //   148: aload 9
    //   150: astore 8
    //   152: aload 10
    //   154: ldc_w 694
    //   157: invokevirtual 692	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   160: ifeq -70 -> 90
    //   163: iload_1
    //   164: istore_2
    //   165: iload 5
    //   167: istore_3
    //   168: iload 6
    //   170: istore 4
    //   172: aload 9
    //   174: astore 8
    //   176: aload 11
    //   178: aload 10
    //   180: aload 10
    //   182: ldc_w 696
    //   185: invokevirtual 700	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   188: iconst_1
    //   189: iadd
    //   190: invokevirtual 704	java/lang/String:substring	(I)Ljava/lang/String;
    //   193: invokevirtual 705	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: goto -107 -> 90
    //   200: iload_1
    //   201: istore_2
    //   202: iload 5
    //   204: istore_3
    //   205: iload 6
    //   207: istore 4
    //   209: aload 9
    //   211: astore 8
    //   213: aload 11
    //   215: invokevirtual 709	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   218: astore 10
    //   220: iload_0
    //   221: istore_2
    //   222: iload_0
    //   223: istore_3
    //   224: iload_0
    //   225: istore 4
    //   227: aload 9
    //   229: astore 8
    //   231: aload 10
    //   233: invokeinterface 714 1 0
    //   238: ifeq +98 -> 336
    //   241: iload_0
    //   242: istore_2
    //   243: iload_0
    //   244: istore_3
    //   245: iload_0
    //   246: istore 4
    //   248: aload 9
    //   250: astore 8
    //   252: aload 10
    //   254: invokeinterface 718 1 0
    //   259: astore 11
    //   261: iload_0
    //   262: istore_1
    //   263: iload_0
    //   264: istore_2
    //   265: iload_0
    //   266: istore_3
    //   267: iload_0
    //   268: istore 4
    //   270: aload 9
    //   272: astore 8
    //   274: aload 11
    //   276: checkcast 12	java/lang/String
    //   279: invokevirtual 215	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   282: ldc_w 720
    //   285: invokevirtual 561	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   288: ifeq +8 -> 296
    //   291: iload_0
    //   292: bipush 64
    //   294: ior
    //   295: istore_1
    //   296: iload_1
    //   297: istore_2
    //   298: iload_1
    //   299: istore_3
    //   300: iload_1
    //   301: istore 4
    //   303: aload 9
    //   305: astore 8
    //   307: aload 11
    //   309: checkcast 12	java/lang/String
    //   312: ldc_w 539
    //   315: invokevirtual 561	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   318: istore 7
    //   320: iload_1
    //   321: istore_0
    //   322: iload 7
    //   324: ifeq -104 -> 220
    //   327: iload_1
    //   328: sipush 128
    //   331: ior
    //   332: istore_0
    //   333: goto -113 -> 220
    //   336: iload_0
    //   337: istore_1
    //   338: aload 9
    //   340: invokevirtual 481	java/io/BufferedReader:close	()V
    //   343: iload_0
    //   344: ireturn
    //   345: astore 8
    //   347: aload 8
    //   349: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   352: iload_1
    //   353: ireturn
    //   354: astore 10
    //   356: goto +27 -> 383
    //   359: astore 10
    //   361: goto +52 -> 413
    //   364: astore 10
    //   366: goto +77 -> 443
    //   369: astore 8
    //   371: aload 10
    //   373: astore 9
    //   375: goto +108 -> 483
    //   378: astore 10
    //   380: aconst_null
    //   381: astore 9
    //   383: aload 9
    //   385: astore 8
    //   387: aload 10
    //   389: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   392: iload_2
    //   393: istore_0
    //   394: aload 9
    //   396: ifnull +75 -> 471
    //   399: iload_2
    //   400: istore_1
    //   401: aload 9
    //   403: invokevirtual 481	java/io/BufferedReader:close	()V
    //   406: iload_2
    //   407: ireturn
    //   408: astore 10
    //   410: aconst_null
    //   411: astore 9
    //   413: aload 9
    //   415: astore 8
    //   417: aload 10
    //   419: invokevirtual 721	java/io/FileNotFoundException:printStackTrace	()V
    //   422: iload_3
    //   423: istore_0
    //   424: aload 9
    //   426: ifnull +45 -> 471
    //   429: iload_3
    //   430: istore_1
    //   431: aload 9
    //   433: invokevirtual 481	java/io/BufferedReader:close	()V
    //   436: iload_3
    //   437: ireturn
    //   438: astore 10
    //   440: aconst_null
    //   441: astore 9
    //   443: aload 9
    //   445: astore 8
    //   447: aload 10
    //   449: invokevirtual 722	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   452: iload 4
    //   454: istore_0
    //   455: aload 9
    //   457: ifnull +14 -> 471
    //   460: iload 4
    //   462: istore_1
    //   463: aload 9
    //   465: invokevirtual 481	java/io/BufferedReader:close	()V
    //   468: iload 4
    //   470: istore_0
    //   471: iload_0
    //   472: ireturn
    //   473: astore 10
    //   475: aload 8
    //   477: astore 9
    //   479: aload 10
    //   481: astore 8
    //   483: aload 9
    //   485: ifnull +18 -> 503
    //   488: aload 9
    //   490: invokevirtual 481	java/io/BufferedReader:close	()V
    //   493: goto +10 -> 503
    //   496: astore 9
    //   498: aload 9
    //   500: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   503: aload 8
    //   505: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	456	0	i	int
    //   1	462	1	j	int
    //   9	398	2	k	int
    //   11	426	3	m	int
    //   13	456	4	n	int
    //   3	200	5	i1	int
    //   6	200	6	i2	int
    //   318	5	7	bool	boolean
    //   39	267	8	localObject1	Object
    //   345	3	8	localIOException1	java.io.IOException
    //   369	1	8	localObject2	Object
    //   385	119	8	localObject3	Object
    //   88	401	9	localObject4	Object
    //   496	3	9	localIOException2	java.io.IOException
    //   18	235	10	localObject5	Object
    //   354	1	10	localIOException3	java.io.IOException
    //   359	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   364	8	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   378	10	10	localIOException4	java.io.IOException
    //   408	10	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   438	10	10	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   473	7	10	localObject6	Object
    //   27	281	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   338	343	345	java/io/IOException
    //   401	406	345	java/io/IOException
    //   431	436	345	java/io/IOException
    //   463	468	345	java/io/IOException
    //   103	110	354	java/io/IOException
    //   128	139	354	java/io/IOException
    //   152	163	354	java/io/IOException
    //   176	197	354	java/io/IOException
    //   213	220	354	java/io/IOException
    //   231	241	354	java/io/IOException
    //   252	261	354	java/io/IOException
    //   274	291	354	java/io/IOException
    //   307	320	354	java/io/IOException
    //   103	110	359	java/io/FileNotFoundException
    //   128	139	359	java/io/FileNotFoundException
    //   152	163	359	java/io/FileNotFoundException
    //   176	197	359	java/io/FileNotFoundException
    //   213	220	359	java/io/FileNotFoundException
    //   231	241	359	java/io/FileNotFoundException
    //   252	261	359	java/io/FileNotFoundException
    //   274	291	359	java/io/FileNotFoundException
    //   307	320	359	java/io/FileNotFoundException
    //   103	110	364	java/io/UnsupportedEncodingException
    //   128	139	364	java/io/UnsupportedEncodingException
    //   152	163	364	java/io/UnsupportedEncodingException
    //   176	197	364	java/io/UnsupportedEncodingException
    //   213	220	364	java/io/UnsupportedEncodingException
    //   231	241	364	java/io/UnsupportedEncodingException
    //   252	261	364	java/io/UnsupportedEncodingException
    //   274	291	364	java/io/UnsupportedEncodingException
    //   307	320	364	java/io/UnsupportedEncodingException
    //   20	90	369	finally
    //   20	90	378	java/io/IOException
    //   20	90	408	java/io/FileNotFoundException
    //   20	90	438	java/io/UnsupportedEncodingException
    //   103	110	473	finally
    //   128	139	473	finally
    //   152	163	473	finally
    //   176	197	473	finally
    //   213	220	473	finally
    //   231	241	473	finally
    //   252	261	473	finally
    //   274	291	473	finally
    //   307	320	473	finally
    //   387	392	473	finally
    //   417	422	473	finally
    //   447	452	473	finally
    //   488	493	496	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */