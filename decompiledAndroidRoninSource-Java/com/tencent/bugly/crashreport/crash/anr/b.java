package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  implements ac
{
  private static b m;
  private AtomicInteger a = new AtomicInteger(0);
  private long b = -1L;
  private final Context c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final w e;
  private String f;
  private final com.tencent.bugly.crashreport.crash.b g;
  private FileObserver h;
  private boolean i = true;
  private ab j;
  private int k;
  private ActivityManager.ProcessErrorStateInfo l;
  
  private b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb)
  {
    this.c = z.a(paramContext);
    this.f = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.g = paramb;
    this.l = new ActivityManager.ProcessErrorStateInfo();
  }
  
  private ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    try
    {
      x.c("to find!", new Object[0]);
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      int n = 0;
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        x.c("waiting!", new Object[0]);
        localObject1 = paramContext.getProcessesInErrorState();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject1).next();
            if (((ActivityManager.ProcessErrorStateInfo)localObject2).condition == 2)
            {
              x.c("found!", new Object[0]);
              return (ActivityManager.ProcessErrorStateInfo)localObject2;
            }
          }
        }
        z.b(500L);
        if (n >= 40L)
        {
          x.c("end!", new Object[0]);
          break;
        }
        n += 1;
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      this.l.pid = Process.myPid();
      localObject1 = this.l;
      localObject2 = new StringBuilder("bugly sdk waitForAnrProcessStateChanged encount error:");
      ((StringBuilder)localObject2).append(paramContext.getMessage());
      ((ActivityManager.ProcessErrorStateInfo)localObject1).shortMsg = ((StringBuilder)localObject2).toString();
      return this.l;
    }
    catch (Exception paramContext)
    {
      x.b(paramContext);
    }
  }
  
  private CrashDetailBean a(a parama)
  {
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    for (;;)
    {
      try
      {
        localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
        localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
        localCrashDetailBean.F = this.d.l();
        localCrashDetailBean.G = this.d.k();
        localCrashDetailBean.H = this.d.m();
        if (!com.tencent.bugly.crashreport.common.info.b.m()) {
          localCrashDetailBean.w = z.a(this.c, c.e, null);
        }
        localCrashDetailBean.b = 3;
        localCrashDetailBean.e = this.d.h();
        localCrashDetailBean.f = this.d.j;
        localCrashDetailBean.g = this.d.r();
        localCrashDetailBean.m = this.d.g();
        localCrashDetailBean.n = "ANR_EXCEPTION";
        localCrashDetailBean.o = parama.f;
        localCrashDetailBean.q = parama.g;
        localCrashDetailBean.P = new HashMap();
        localCrashDetailBean.P.put("BUGLY_CR_01", parama.e);
        int n = -1;
        if (localCrashDetailBean.q != null) {
          n = localCrashDetailBean.q.indexOf("\n");
        }
        if (n > 0)
        {
          str = localCrashDetailBean.q.substring(0, n);
          localCrashDetailBean.p = str;
          localCrashDetailBean.r = parama.c;
          if (localCrashDetailBean.q != null) {
            localCrashDetailBean.u = z.a(localCrashDetailBean.q.getBytes());
          }
          localCrashDetailBean.z = parama.b;
          localCrashDetailBean.A = parama.a;
          localCrashDetailBean.B = "main(1)";
          localCrashDetailBean.I = this.d.t();
          localCrashDetailBean.h = this.d.q();
          localCrashDetailBean.i = this.d.C();
          localCrashDetailBean.v = parama.d;
          localCrashDetailBean.L = this.d.n;
          localCrashDetailBean.M = this.d.a;
          localCrashDetailBean.N = this.d.a();
          if (!com.tencent.bugly.crashreport.common.info.b.m()) {
            this.g.d(localCrashDetailBean);
          }
          localCrashDetailBean.Q = this.d.A();
          localCrashDetailBean.R = this.d.B();
          localCrashDetailBean.S = this.d.u();
          localCrashDetailBean.T = this.d.z();
          localCrashDetailBean.y = y.a();
          return localCrashDetailBean;
        }
      }
      finally
      {
        if (!x.a(parama)) {
          parama.printStackTrace();
        }
        return localCrashDetailBean;
      }
      String str = "GET_FAIL";
    }
  }
  
  public static b a(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, w paramw, p paramp, com.tencent.bugly.crashreport.crash.b paramb, BuglyStrategy.a parama2)
  {
    if (m == null) {
      m = new b(paramContext, parama, parama1, paramw, paramb);
    }
    return m;
  }
  
  private boolean a(Context paramContext, String paramString, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo, long paramLong, Map<String, String> paramMap)
  {
    a locala = new a();
    locala.c = paramLong;
    if (paramProcessErrorStateInfo != null) {
      paramContext = paramProcessErrorStateInfo.processName;
    } else {
      paramContext = AppInfo.a(Process.myPid());
    }
    locala.a = paramContext;
    String str1 = "";
    if (paramProcessErrorStateInfo != null) {
      paramContext = paramProcessErrorStateInfo.shortMsg;
    } else {
      paramContext = "";
    }
    locala.f = paramContext;
    paramContext = str1;
    if (paramProcessErrorStateInfo != null) {
      paramContext = paramProcessErrorStateInfo.longMsg;
    }
    locala.e = paramContext;
    locala.b = paramMap;
    paramContext = Looper.getMainLooper().getThread();
    if (paramMap != null)
    {
      paramProcessErrorStateInfo = paramMap.keySet().iterator();
      while (paramProcessErrorStateInfo.hasNext())
      {
        str1 = (String)paramProcessErrorStateInfo.next();
        if (str1.startsWith(paramContext.getName())) {
          locala.g = ((String)paramMap.get(str1));
        }
      }
    }
    if (TextUtils.isEmpty(locala.g)) {
      locala.g = "main stack is null , some error may be encountered.";
    }
    long l1 = locala.c;
    paramContext = locala.d;
    paramProcessErrorStateInfo = locala.a;
    paramMap = locala.g;
    str1 = locala.f;
    String str2 = locala.e;
    int n;
    if (locala.b == null) {
      n = 0;
    } else {
      n = locala.b.size();
    }
    x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(l1), paramContext, paramProcessErrorStateInfo, paramMap, str1, str2, Integer.valueOf(n) });
    x.a("found visiable anr , start to upload!", new Object[0]);
    paramContext = a(locala);
    if (paramContext == null)
    {
      x.e("pack anr fail!", new Object[0]);
      return false;
    }
    c.a().a(paramContext);
    if (paramContext.a >= 0L) {
      x.a("backup anr record success!", new Object[0]);
    } else {
      x.d("backup anr record fail!", new Object[0]);
    }
    if ((paramString != null) && (new File(paramString).exists()))
    {
      paramProcessErrorStateInfo = this.f;
      paramMap = new StringBuilder("bugly_trace_");
      paramMap.append(paramLong);
      paramMap.append(".txt");
      locala.d = new File(paramProcessErrorStateInfo, paramMap.toString()).getAbsolutePath();
      this.a.set(3);
      if (a(paramString, locala.d, locala.a)) {
        x.a("backup trace success", new Object[0]);
      }
    }
    else
    {
      paramString = h();
      x.a("traceFile is %s", new Object[] { paramString });
      if (paramString != null) {
        paramContext.v = paramString.getAbsolutePath();
      }
    }
    com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.g, paramContext);
    if (!this.g.a(paramContext)) {
      this.g.a(paramContext, 3000L, true);
    }
    this.g.c(paramContext);
    return true;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 558	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +704 -> 712
    //   11: aload_3
    //   12: getfield 562	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +697 -> 712
    //   18: aload_3
    //   19: getfield 562	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 466 1 0
    //   27: ifgt +6 -> 33
    //   30: goto +682 -> 712
    //   33: new 79	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 502	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 505	java/io/File:exists	()Z
    //   48: ifne +29 -> 77
    //   51: aload 4
    //   53: invokevirtual 565	java/io/File:getParentFile	()Ljava/io/File;
    //   56: invokevirtual 505	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 4
    //   64: invokevirtual 565	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 568	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload 4
    //   73: invokevirtual 571	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload 4
    //   79: invokevirtual 505	java/io/File:exists	()Z
    //   82: ifeq +540 -> 622
    //   85: aload 4
    //   87: invokevirtual 574	java/io/File:canWrite	()Z
    //   90: ifne +6 -> 96
    //   93: goto +529 -> 622
    //   96: aconst_null
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_0
    //   100: new 576	java/io/BufferedWriter
    //   103: dup
    //   104: new 578	java/io/FileWriter
    //   107: dup
    //   108: aload 4
    //   110: iconst_0
    //   111: invokespecial 581	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   114: invokespecial 584	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   117: astore_1
    //   118: aload_3
    //   119: getfield 562	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   122: ldc_w 534
    //   125: invokeinterface 455 2 0
    //   130: checkcast 586	[Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +100 -> 237
    //   140: aload 4
    //   142: arraylength
    //   143: iconst_3
    //   144: if_icmplt +93 -> 237
    //   147: aload 4
    //   149: iconst_0
    //   150: aaload
    //   151: astore_0
    //   152: aload 4
    //   154: iconst_1
    //   155: aaload
    //   156: astore_2
    //   157: aload 4
    //   159: iconst_2
    //   160: aaload
    //   161: astore 4
    //   163: new 164	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 588
    //   170: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: astore 5
    //   175: aload 5
    //   177: aload 4
    //   179: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: ldc_w 590
    //   188: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: aload_0
    //   195: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: ldc_w 287
    //   204: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: aload_2
    //   211: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: ldc_w 592
    //   220: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload 5
    //   227: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 595	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: invokevirtual 598	java/io/BufferedWriter:flush	()V
    //   237: aload_3
    //   238: getfield 562	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   241: invokeinterface 601 1 0
    //   246: invokeinterface 442 1 0
    //   251: astore_0
    //   252: aload_0
    //   253: invokeinterface 135 1 0
    //   258: ifeq +194 -> 452
    //   261: aload_0
    //   262: invokeinterface 139 1 0
    //   267: checkcast 603	java/util/Map$Entry
    //   270: astore_2
    //   271: aload_2
    //   272: invokeinterface 606 1 0
    //   277: checkcast 289	java/lang/String
    //   280: ldc_w 534
    //   283: invokevirtual 610	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifne -34 -> 252
    //   289: aload_2
    //   290: invokeinterface 613 1 0
    //   295: ifnull +154 -> 449
    //   298: aload_2
    //   299: invokeinterface 613 1 0
    //   304: checkcast 586	[Ljava/lang/String;
    //   307: arraylength
    //   308: iconst_3
    //   309: if_icmplt +140 -> 449
    //   312: aload_2
    //   313: invokeinterface 613 1 0
    //   318: checkcast 586	[Ljava/lang/String;
    //   321: iconst_0
    //   322: aaload
    //   323: astore_3
    //   324: aload_2
    //   325: invokeinterface 613 1 0
    //   330: checkcast 586	[Ljava/lang/String;
    //   333: iconst_1
    //   334: aaload
    //   335: astore 4
    //   337: aload_2
    //   338: invokeinterface 613 1 0
    //   343: checkcast 586	[Ljava/lang/String;
    //   346: iconst_2
    //   347: aaload
    //   348: astore 5
    //   350: new 164	java/lang/StringBuilder
    //   353: dup
    //   354: ldc_w 615
    //   357: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: astore 6
    //   362: aload 6
    //   364: aload_2
    //   365: invokeinterface 606 1 0
    //   370: checkcast 289	java/lang/String
    //   373: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 6
    //   379: ldc_w 617
    //   382: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 6
    //   388: aload 5
    //   390: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 590
    //   399: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 6
    //   405: aload_3
    //   406: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 6
    //   412: ldc_w 287
    //   415: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 6
    //   421: aload 4
    //   423: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 6
    //   429: ldc_w 592
    //   432: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_1
    //   437: aload 6
    //   439: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokevirtual 595	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   445: aload_1
    //   446: invokevirtual 598	java/io/BufferedWriter:flush	()V
    //   449: goto -197 -> 252
    //   452: aload_1
    //   453: invokevirtual 620	java/io/BufferedWriter:close	()V
    //   456: iconst_1
    //   457: ireturn
    //   458: astore_0
    //   459: aload_0
    //   460: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   463: ifne +7 -> 470
    //   466: aload_0
    //   467: invokevirtual 621	java/io/IOException:printStackTrace	()V
    //   470: iconst_1
    //   471: ireturn
    //   472: astore_0
    //   473: goto +124 -> 597
    //   476: astore_2
    //   477: goto +16 -> 493
    //   480: astore_2
    //   481: aload_0
    //   482: astore_1
    //   483: aload_2
    //   484: astore_0
    //   485: goto +112 -> 597
    //   488: astore_0
    //   489: aload_2
    //   490: astore_1
    //   491: aload_0
    //   492: astore_2
    //   493: aload_1
    //   494: astore_0
    //   495: aload_2
    //   496: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   499: ifne +9 -> 508
    //   502: aload_1
    //   503: astore_0
    //   504: aload_2
    //   505: invokevirtual 621	java/io/IOException:printStackTrace	()V
    //   508: aload_1
    //   509: astore_0
    //   510: new 164	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 622	java/lang/StringBuilder:<init>	()V
    //   517: astore_3
    //   518: aload_1
    //   519: astore_0
    //   520: aload_3
    //   521: aload_2
    //   522: invokevirtual 626	java/lang/Object:getClass	()Ljava/lang/Class;
    //   525: invokevirtual 629	java/lang/Class:getName	()Ljava/lang/String;
    //   528: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_1
    //   533: astore_0
    //   534: aload_3
    //   535: ldc_w 631
    //   538: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_1
    //   543: astore_0
    //   544: aload_3
    //   545: aload_2
    //   546: invokevirtual 632	java/io/IOException:getMessage	()Ljava/lang/String;
    //   549: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload_1
    //   554: astore_0
    //   555: ldc_w 634
    //   558: iconst_1
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: aload_3
    //   565: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: aastore
    //   569: invokestatic 489	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   572: pop
    //   573: aload_1
    //   574: ifnull +21 -> 595
    //   577: aload_1
    //   578: invokevirtual 620	java/io/BufferedWriter:close	()V
    //   581: iconst_0
    //   582: ireturn
    //   583: astore_0
    //   584: aload_0
    //   585: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   588: ifne +7 -> 595
    //   591: aload_0
    //   592: invokevirtual 621	java/io/IOException:printStackTrace	()V
    //   595: iconst_0
    //   596: ireturn
    //   597: aload_1
    //   598: ifnull +22 -> 620
    //   601: aload_1
    //   602: invokevirtual 620	java/io/BufferedWriter:close	()V
    //   605: goto +15 -> 620
    //   608: astore_1
    //   609: aload_1
    //   610: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   613: ifne +7 -> 620
    //   616: aload_1
    //   617: invokevirtual 621	java/io/IOException:printStackTrace	()V
    //   620: aload_0
    //   621: athrow
    //   622: ldc_w 636
    //   625: iconst_1
    //   626: anewarray 4	java/lang/Object
    //   629: dup
    //   630: iconst_0
    //   631: aload_1
    //   632: aastore
    //   633: invokestatic 489	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   636: pop
    //   637: iconst_0
    //   638: ireturn
    //   639: astore_0
    //   640: aload_0
    //   641: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   644: ifne +7 -> 651
    //   647: aload_0
    //   648: invokevirtual 637	java/lang/Exception:printStackTrace	()V
    //   651: new 164	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 622	java/lang/StringBuilder:<init>	()V
    //   658: astore_2
    //   659: aload_2
    //   660: aload_0
    //   661: invokevirtual 626	java/lang/Object:getClass	()Ljava/lang/Class;
    //   664: invokevirtual 629	java/lang/Class:getName	()Ljava/lang/String;
    //   667: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_2
    //   672: ldc_w 631
    //   675: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_2
    //   680: aload_0
    //   681: invokevirtual 638	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   684: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: ldc_w 640
    //   691: iconst_2
    //   692: anewarray 4	java/lang/Object
    //   695: dup
    //   696: iconst_0
    //   697: aload_2
    //   698: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: aastore
    //   702: dup
    //   703: iconst_1
    //   704: aload_1
    //   705: aastore
    //   706: invokestatic 489	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   709: pop
    //   710: iconst_0
    //   711: ireturn
    //   712: ldc_w 642
    //   715: iconst_1
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: aload_2
    //   722: aastore
    //   723: invokestatic 489	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   726: pop
    //   727: iconst_0
    //   728: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	paramString1	String
    //   0	729	1	paramString2	String
    //   0	729	2	paramString3	String
    //   6	559	3	localObject1	Object
    //   41	381	4	localObject2	Object
    //   173	216	5	localObject3	Object
    //   360	78	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   452	456	458	java/io/IOException
    //   118	135	472	finally
    //   140	147	472	finally
    //   163	237	472	finally
    //   237	252	472	finally
    //   252	449	472	finally
    //   118	135	476	java/io/IOException
    //   140	147	476	java/io/IOException
    //   163	237	476	java/io/IOException
    //   237	252	476	java/io/IOException
    //   252	449	476	java/io/IOException
    //   100	118	480	finally
    //   495	502	480	finally
    //   504	508	480	finally
    //   510	518	480	finally
    //   520	532	480	finally
    //   534	542	480	finally
    //   544	553	480	finally
    //   555	573	480	finally
    //   100	118	488	java/io/IOException
    //   577	581	583	java/io/IOException
    //   601	605	608	java/io/IOException
    //   43	71	639	java/lang/Exception
    //   71	77	639	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (Build.VERSION.SDK_INT <= 19)
      {
        if (paramBoolean)
        {
          d();
          return;
        }
        e();
        return;
      }
      if (paramBoolean)
      {
        i();
        return;
      }
      j();
      return;
    }
    finally {}
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.i != paramBoolean)
      {
        x.a("user change anr %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.i = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 668	com/tencent/bugly/crashreport/crash/anr/b:f	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 670
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: new 8	com/tencent/bugly/crashreport/crash/anr/b$1
    //   26: dup
    //   27: aload_0
    //   28: ldc_w 672
    //   31: bipush 8
    //   33: invokespecial 675	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: putfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   42: aload_1
    //   43: invokevirtual 682	android/os/FileObserver:startWatching	()V
    //   46: ldc_w 684
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 483	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: getfield 89	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   61: new 12	com/tencent/bugly/crashreport/crash/anr/b$2
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 687	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   69: invokevirtual 692	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   82: ldc_w 694
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_1
    //   94: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   97: ifne +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 402	java/lang/Throwable:printStackTrace	()V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	b
    //   36	7	1	local1	1
    //   76	25	1	localThrowable	Throwable
    //   107	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	73	76	finally
    //   2	20	107	finally
    //   23	42	107	finally
    //   77	104	107	finally
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 668	com/tencent/bugly/crashreport/crash/anr/b:f	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 696
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   27: invokevirtual 699	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   35: ldc_w 701
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc_w 703
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   65: ifne +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 402	java/lang/Throwable:printStackTrace	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   49	20	1	localThrowable	Throwable
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	finally
    //   2	20	75	finally
    //   50	72	75	finally
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	b
    //   12	7	1	bool	boolean
    //   6	2	2	localFileObserver	FileObserver
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean g()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private File h()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(this.f);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      for (;;)
      {
        try
        {
          localObject1 = ((File)localObject1).listFiles();
          if ((localObject1 != null) && (localObject1.length != 0))
          {
            int i1 = localObject1.length;
            n = 0;
            if (n >= i1) {
              break label244;
            }
            localObject2 = localObject1[n];
            str = ((File)localObject2).getName();
            boolean bool = str.startsWith("jni_mannual_bugly_trace_");
            if (!bool) {}
          }
        }
        finally
        {
          int n;
          Object localObject2;
          String str;
          int i2;
          long l2;
          long l3;
          x.a(localThrowable);
          return null;
        }
        try
        {
          i2 = str.indexOf(".txt");
          if (i2 <= 0) {
            continue;
          }
          l2 = Long.parseLong(str.substring(24, i2));
          l3 = (l1 - l2) / 1000L;
          x.c("current time %d trace time is %d s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          x.c("current time minus trace time is %d s", new Object[] { Long.valueOf(l3) });
          if (l3 >= 30L) {}
          return (File)localObject2;
        }
        finally
        {
          continue;
        }
        localObject2 = new StringBuilder("Trace file that has invalid format: ");
        ((StringBuilder)localObject2).append(str);
        x.c(((StringBuilder)localObject2).toString(), new Object[0]);
        n += 1;
      }
      return null;
    }
    label244:
    return null;
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 668	com/tencent/bugly/crashreport/crash/anr/b:f	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 670
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 85	com/tencent/bugly/crashreport/crash/anr/b:f	Ljava/lang/String;
    //   27: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   42: ifnull +16 -> 58
    //   45: aload_0
    //   46: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   49: invokevirtual 737	com/tencent/bugly/proguard/ab:isAlive	()Z
    //   52: ifeq +6 -> 58
    //   55: goto +95 -> 150
    //   58: new 734	com/tencent/bugly/proguard/ab
    //   61: dup
    //   62: invokespecial 738	com/tencent/bugly/proguard/ab:<init>	()V
    //   65: astore_3
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   71: new 164	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 740
    //   78: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: astore 4
    //   83: aload_0
    //   84: getfield 742	com/tencent/bugly/crashreport/crash/anr/b:k	I
    //   87: istore_1
    //   88: aload_0
    //   89: iload_1
    //   90: iconst_1
    //   91: iadd
    //   92: putfield 742	com/tencent/bugly/crashreport/crash/anr/b:k	I
    //   95: aload 4
    //   97: iload_1
    //   98: invokevirtual 745	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_3
    //   103: aload 4
    //   105: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokevirtual 748	com/tencent/bugly/proguard/ab:setName	(Ljava/lang/String;)V
    //   111: aload_0
    //   112: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   115: invokevirtual 750	com/tencent/bugly/proguard/ab:a	()V
    //   118: aload_0
    //   119: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   122: aload_0
    //   123: invokevirtual 753	com/tencent/bugly/proguard/ab:a	(Lcom/tencent/bugly/proguard/ac;)V
    //   126: aload_0
    //   127: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   130: invokevirtual 755	com/tencent/bugly/proguard/ab:d	()Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 89	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   138: new 14	com/tencent/bugly/crashreport/crash/anr/b$3
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 756	com/tencent/bugly/crashreport/crash/anr/b$3:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   146: invokevirtual 692	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   149: pop
    //   150: new 16	com/tencent/bugly/crashreport/crash/anr/b$4
    //   153: dup
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 85	com/tencent/bugly/crashreport/crash/anr/b:f	Ljava/lang/String;
    //   159: sipush 256
    //   162: invokespecial 757	com/tencent/bugly/crashreport/crash/anr/b$4:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   165: astore_3
    //   166: aload_0
    //   167: aload_3
    //   168: putfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   171: aload_3
    //   172: invokevirtual 682	android/os/FileObserver:startWatching	()V
    //   175: ldc_w 759
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_0
    //   185: getfield 85	com/tencent/bugly/crashreport/crash/anr/b:f	Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 483	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   192: pop
    //   193: aload_0
    //   194: getfield 89	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   197: new 18	com/tencent/bugly/crashreport/crash/anr/b$5
    //   200: dup
    //   201: aload_0
    //   202: invokespecial 760	com/tencent/bugly/crashreport/crash/anr/b$5:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   205: invokevirtual 692	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   208: pop
    //   209: aload_0
    //   210: monitorexit
    //   211: return
    //   212: astore_3
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   218: ldc_w 762
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   228: pop
    //   229: aload_3
    //   230: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   233: ifne +7 -> 240
    //   236: aload_3
    //   237: invokevirtual 402	java/lang/Throwable:printStackTrace	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    //   243: astore_3
    //   244: aload_0
    //   245: monitorexit
    //   246: aload_3
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	b
    //   87	11	1	n	int
    //   30	2	2	bool	boolean
    //   65	107	3	localObject1	Object
    //   212	25	3	localThrowable	Throwable
    //   243	4	3	localObject2	Object
    //   81	23	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   171	209	212	finally
    //   2	20	243	finally
    //   23	31	243	finally
    //   38	55	243	finally
    //   58	150	243	finally
    //   150	171	243	finally
    //   213	240	243	finally
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 668	com/tencent/bugly/crashreport/crash/anr/b:f	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 696
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   27: ifnull +31 -> 58
    //   30: aload_0
    //   31: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   34: invokevirtual 764	com/tencent/bugly/proguard/ab:c	()Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   42: invokevirtual 766	com/tencent/bugly/proguard/ab:b	()V
    //   45: aload_0
    //   46: getfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   49: aload_0
    //   50: invokevirtual 768	com/tencent/bugly/proguard/ab:b	(Lcom/tencent/bugly/proguard/ac;)V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 645	com/tencent/bugly/crashreport/crash/anr/b:j	Lcom/tencent/bugly/proguard/ab;
    //   58: ldc_w 770
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 483	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_0
    //   70: getfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   73: invokevirtual 699	android/os/FileObserver:stopWatching	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 677	com/tencent/bugly/crashreport/crash/anr/b:h	Landroid/os/FileObserver;
    //   81: ldc_w 701
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   91: pop
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_1
    //   96: ldc_w 703
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_1
    //   108: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   111: ifne +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 402	java/lang/Throwable:printStackTrace	()V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	b
    //   95	20	1	localThrowable	Throwable
    //   121	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	92	95	finally
    //   2	20	121	finally
    //   23	58	121	finally
    //   58	69	121	finally
    //   96	118	121	finally
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 772	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 774
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 109	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 56	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 518	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 776
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 109	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic 780	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +317 -> 373
    //   59: aload 6
    //   61: getfield 781	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   64: lstore_2
    //   65: goto +3 -> 68
    //   68: lload_2
    //   69: lstore 4
    //   71: lload_2
    //   72: ldc2_w 57
    //   75: lcmp
    //   76: ifne +19 -> 95
    //   79: ldc_w 783
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   89: pop
    //   90: invokestatic 708	java/lang/System:currentTimeMillis	()J
    //   93: lstore 4
    //   95: lload 4
    //   97: aload_0
    //   98: getfield 60	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   101: lsub
    //   102: invokestatic 789	java/lang/Math:abs	(J)J
    //   105: ldc2_w 790
    //   108: lcmp
    //   109: ifge +32 -> 141
    //   112: ldc_w 793
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: sipush 10000
    //   124: invokestatic 479	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 56	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   136: iconst_0
    //   137: invokevirtual 518	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   140: return
    //   141: aload_0
    //   142: lload 4
    //   144: putfield 60	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   147: aload_0
    //   148: getfield 56	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   151: iconst_1
    //   152: invokevirtual 518	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   155: getstatic 795	com/tencent/bugly/crashreport/crash/c:f	I
    //   158: iconst_0
    //   159: invokestatic 798	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   162: astore 6
    //   164: aload 6
    //   166: ifnull +121 -> 287
    //   169: aload 6
    //   171: invokeinterface 466 1 0
    //   176: ifgt +6 -> 182
    //   179: goto +108 -> 287
    //   182: aload_0
    //   183: aload_0
    //   184: getfield 69	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   187: ldc2_w 799
    //   190: invokespecial 802	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   193: astore 7
    //   195: aload_0
    //   196: aload 7
    //   198: putfield 96	com/tencent/bugly/crashreport/crash/anr/b:l	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   201: aload 7
    //   203: ifnonnull +17 -> 220
    //   206: ldc_w 804
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 109	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: goto -85 -> 132
    //   220: aload 7
    //   222: getfield 162	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   225: invokestatic 159	android/os/Process:myPid	()I
    //   228: if_icmpeq +27 -> 255
    //   231: ldc_w 806
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield 96	com/tencent/bugly/crashreport/crash/anr/b:l	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   244: getfield 415	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic 109	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -120 -> 132
    //   255: ldc_w 808
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 483	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   265: pop
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 69	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   271: aload_1
    //   272: aload_0
    //   273: getfield 96	com/tencent/bugly/crashreport/crash/anr/b:l	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   276: lload 4
    //   278: aload 6
    //   280: invokespecial 810	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   283: pop
    //   284: goto -152 -> 132
    //   287: ldc_w 812
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 501	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   297: pop
    //   298: goto -166 -> 132
    //   301: astore_1
    //   302: aload_1
    //   303: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   306: pop
    //   307: ldc_w 814
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 489	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   317: pop
    //   318: goto -186 -> 132
    //   321: astore_1
    //   322: aload_1
    //   323: invokestatic 397	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   326: ifne +7 -> 333
    //   329: aload_1
    //   330: invokevirtual 402	java/lang/Throwable:printStackTrace	()V
    //   333: ldc_w 816
    //   336: iconst_1
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload_1
    //   343: invokevirtual 626	java/lang/Object:getClass	()Ljava/lang/Class;
    //   346: invokevirtual 817	java/lang/Class:toString	()Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic 489	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   353: pop
    //   354: goto -222 -> 132
    //   357: astore_1
    //   358: aload_0
    //   359: getfield 56	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   362: iconst_0
    //   363: invokevirtual 518	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: astore_1
    //   369: aload_0
    //   370: monitorexit
    //   371: aload_1
    //   372: athrow
    //   373: ldc2_w 57
    //   376: lstore_2
    //   377: goto -309 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	b
    //   0	380	1	paramString	String
    //   64	313	2	l1	long
    //   69	208	4	l2	long
    //   52	227	6	localObject	Object
    //   193	28	7	localProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    // Exception table:
    //   from	to	target	type
    //   155	164	301	finally
    //   36	54	321	finally
    //   59	65	321	finally
    //   79	95	321	finally
    //   95	132	321	finally
    //   141	155	321	finally
    //   169	179	321	finally
    //   182	201	321	finally
    //   206	217	321	finally
    //   220	252	321	finally
    //   255	284	321	finally
    //   287	298	321	finally
    //   302	318	321	finally
    //   322	333	357	finally
    //   333	354	357	finally
    //   2	25	368	finally
    //   26	36	368	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    boolean bool = g();
    com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
    paramBoolean = bool;
    if (locala != null) {
      if ((bool) && (locala.c().e)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean != f())
    {
      x.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      b(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.a.get() != 0;
  }
  
  /* Error */
  public final boolean a(com.tencent.bugly.proguard.aa paramaa)
  {
    // Byte code:
    //   0: new 271	java/util/HashMap
    //   3: dup
    //   4: invokespecial 272	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 842	com/tencent/bugly/proguard/aa:e	()Landroid/os/Looper;
    //   12: invokestatic 431	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 843	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +122 -> 140
    //   21: ldc_w 844
    //   24: iconst_0
    //   25: invokestatic 798	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   28: astore_1
    //   29: goto +28 -> 57
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 185	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   37: pop
    //   38: aload_2
    //   39: ldc_w 534
    //   42: aload_1
    //   43: invokevirtual 845	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   46: invokeinterface 285 3 0
    //   51: pop
    //   52: aload_2
    //   53: astore_1
    //   54: goto -25 -> 29
    //   57: ldc_w 847
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 109	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: getfield 69	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   72: invokestatic 850	com/tencent/bugly/crashreport/common/info/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   75: astore_2
    //   76: aload_2
    //   77: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +38 -> 118
    //   83: aload_2
    //   84: ldc_w 852
    //   87: invokevirtual 855	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifne +13 -> 103
    //   93: aload_2
    //   94: ldc_w 857
    //   97: invokevirtual 855	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq +18 -> 118
    //   103: aload_0
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 69	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   109: ldc2_w 799
    //   112: invokespecial 802	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   115: putfield 96	com/tencent/bugly/crashreport/crash/anr/b:l	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 69	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   123: ldc_w 422
    //   126: aload_0
    //   127: getfield 96	com/tencent/bugly/crashreport/crash/anr/b:l	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   130: invokestatic 708	java/lang/System:currentTimeMillis	()J
    //   133: aload_1
    //   134: invokespecial 810	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   137: pop
    //   138: iconst_1
    //   139: ireturn
    //   140: ldc_w 859
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_1
    //   150: invokevirtual 861	com/tencent/bugly/proguard/aa:d	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 109	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   157: pop
    //   158: iconst_1
    //   159: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	b
    //   0	160	1	paramaa	com.tencent.bugly.proguard.aa
    //   7	87	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	29	32	finally
  }
  
  protected final void b()
  {
    long l1 = z.b();
    long l2 = c.g;
    Object localObject1 = new File(this.f);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {}
    for (;;)
    {
      int n;
      int i2;
      int i4;
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return;
          }
          int i5 = localObject1.length;
          n = 0;
          i1 = 0;
          i2 = 0;
          if (n < i5)
          {
            localObject2 = localObject1[n];
            str = ((File)localObject2).getName();
            boolean bool = str.startsWith("bugly_trace_");
            i4 = 1;
            if (bool) {
              break label308;
            }
            if (!str.startsWith("bugly_trace_")) {
              break label314;
            }
            break label308;
            localStringBuilder = new StringBuilder("Number Trace file : ");
            localStringBuilder.append(str);
            x.c(localStringBuilder.toString(), new Object[0]);
            i3 = i1;
            if (i4 == 0) {
              break label320;
            }
          }
        }
      }
      finally
      {
        Object localObject2;
        String str;
        StringBuilder localStringBuilder;
        long l3;
        x.a(localThrowable);
      }
      try
      {
        i3 = str.indexOf(".txt");
        if (i3 <= 0) {
          continue;
        }
        l3 = Long.parseLong(str.substring(i2, i3));
        if (l3 < l1 - l2) {
          continue;
        }
        i3 = i1;
      }
      finally
      {
        continue;
      }
      localStringBuilder = new StringBuilder("Trace file that has invalid format: ");
      localStringBuilder.append(str);
      x.c(localStringBuilder.toString(), new Object[0]);
      int i3 = i1;
      if (((File)localObject2).delete())
      {
        i3 = i1 + 1;
        break label320;
        localObject1 = new StringBuilder("Number of overdue trace files that has deleted: ");
        ((StringBuilder)localObject1).append(i1);
        x.c(((StringBuilder)localObject1).toString(), new Object[0]);
        return;
        return;
        label308:
        i2 = 12;
        continue;
        label314:
        i4 = 0;
        continue;
      }
      label320:
      n += 1;
      int i1 = i3;
    }
  }
  
  public final void c()
  {
    try
    {
      x.d("customer decides whether to open or close.", new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */