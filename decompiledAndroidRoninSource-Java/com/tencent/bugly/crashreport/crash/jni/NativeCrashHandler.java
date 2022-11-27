package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

public class NativeCrashHandler
  implements com.tencent.bugly.crashreport.a
{
  private static NativeCrashHandler a;
  private static int b = 1;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean p = true;
  private final Context c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final w e;
  private NativeExceptionHandler f;
  private String g;
  private final boolean h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private com.tencent.bugly.crashreport.crash.b o;
  
  private NativeCrashHandler(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, w paramw, boolean paramBoolean, String paramString)
  {
    this.c = z.a(paramContext);
    try
    {
      if (!z.a(paramString)) {
        break label101;
      }
      paramString = paramContext.getDir("bugly", 0).getAbsolutePath();
    }
    finally
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    paramString = com.tencent.bugly.crashreport.common.info.a.a(paramContext).c;
    localStringBuilder = new StringBuilder("/data/data/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/app_bugly");
    paramString = localStringBuilder.toString();
    label101:
    this.o = paramb;
    this.g = paramString;
    this.d = parama;
    this.e = paramw;
    this.h = paramBoolean;
    this.f = new a(paramContext, parama, paramb, com.tencent.bugly.crashreport.common.strategy.a.a());
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      boolean bool;
      String str1;
      String str2;
      String str3;
      Object localObject6;
      Object localObject1;
      int i2;
      label733:
      try
      {
        if (this.k)
        {
          x.d("[Native] Native crash report has already registered.", new Object[0]);
          return;
        }
        bool = this.j;
        if (!bool) {}
      }
      finally {}
      try
      {
        str1 = regist(this.g, paramBoolean, b);
        if (str1 != null)
        {
          x.a("[Native] Native Crash Report enable.", new Object[0]);
          x.c("[Native] Check extra jni for Bugly NDK v%s", new Object[] { str1 });
          str2 = "2.1.1".replace(".", "");
          str3 = "2.3.0".replace(".", "");
          localObject6 = str1.replace(".", "");
          if (((String)localObject6).length() == 2)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject6);
            localObject6 = "0";
            ((StringBuilder)localObject1).append((String)localObject6);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = localObject6;
            if (((String)localObject6).length() == 1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject6);
              localObject6 = "00";
            }
          }
        }
      }
      finally
      {
        continue;
      }
      try
      {
        if (Integer.parseInt((String)localObject1) >= Integer.parseInt(str2)) {
          m = true;
        }
        if (Integer.parseInt((String)localObject1) >= Integer.parseInt(str3)) {
          n = true;
        }
      }
      finally {}
    }
    if (n) {
      x.a("[Native] Info setting jni can be accessed.", new Object[0]);
    } else {
      x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
    }
    if (m) {
      x.a("[Native] Extra jni can be accessed.", new Object[0]);
    } else {
      x.d("[Native] Extra jni can not be accessed.", new Object[0]);
    }
    this.d.n = str1;
    localObject1 = "-".concat(this.d.n);
    if (!this.d.f.contains((CharSequence)localObject1)) {
      this.d.f = this.d.f.concat("-").concat(this.d.n);
    }
    x.a("comInfo.sdkVersion %s", new Object[] { this.d.f });
    this.k = true;
    return;
    x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
    break label733;
    bool = this.i;
    if (bool) {}
    try
    {
      localObject1 = Integer.TYPE;
      localObject6 = Integer.TYPE;
      str1 = this.g;
      str2 = com.tencent.bugly.crashreport.common.info.b.a(this.c, false);
      i2 = 5;
      if (!paramBoolean) {
        break label768;
      }
      i1 = 1;
    }
    finally
    {
      for (;;)
      {
        continue;
        int i1 = 5;
      }
    }
    localObject6 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[] { String.class, String.class, localObject1, localObject6 }, new Object[] { str1, str2, Integer.valueOf(i1), Integer.valueOf(1) });
    localObject1 = localObject6;
    if (localObject6 == null)
    {
      localObject1 = Integer.TYPE;
      localObject6 = this.g;
      str1 = com.tencent.bugly.crashreport.common.info.b.a(this.c, false);
      com.tencent.bugly.crashreport.common.info.a.b();
      i1 = com.tencent.bugly.crashreport.common.info.a.D();
      localObject1 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[] { String.class, String.class, localObject1 }, new Object[] { localObject6, str1, Integer.valueOf(i1) });
    }
    if (localObject1 != null)
    {
      this.k = true;
      this.d.n = ((String)localObject1);
      localObject1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[] { String.class }, new Object[] { localObject1 });
      if (localObject1 != null) {
        m = ((Boolean)localObject1).booleanValue();
      }
      z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(true) });
      i1 = i2;
      if (paramBoolean) {
        i1 = 1;
      }
      z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(i1) });
      return;
    }
    this.j = false;
    this.i = false;
  }
  
  /* Error */
  private boolean a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   4: ifeq +37 -> 41
    //   7: getstatic 175	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:n	Z
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: iload_1
    //   17: aload_2
    //   18: invokevirtual 254	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:setNativeInfo	(ILjava/lang/String;)V
    //   21: iconst_1
    //   22: ireturn
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 257	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   28: ifne +7 -> 35
    //   31: aload_2
    //   32: invokevirtual 262	java/lang/Throwable:printStackTrace	()V
    //   35: iconst_0
    //   36: ireturn
    //   37: iconst_0
    //   38: putstatic 175	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:n	Z
    //   41: iconst_0
    //   42: ireturn
    //   43: astore_2
    //   44: goto -7 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	NativeCrashHandler
    //   0	47	1	paramInt	int
    //   0	47	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   15	21	23	finally
    //   15	21	43	java/lang/UnsatisfiedLinkError
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      x.a("[Native] Trying to load so: %s", new Object[] { paramString });
      if (paramBoolean) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      }
      try
      {
        x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
        return true;
      }
      finally
      {
        paramBoolean = true;
      }
      x.d(((Throwable)localObject2).getMessage(), new Object[0]);
    }
    finally
    {
      paramBoolean = false;
    }
    x.d("[Native] Failed to load so: %s", new Object[] { paramString });
    return paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      startNativeMonitor();
      return;
    }
    finally {}
    c();
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 294
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 128	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: invokevirtual 297	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:unregist	()Ljava/lang/String;
    //   27: ifnull +33 -> 60
    //   30: ldc_w 299
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 138	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 48	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: ldc_w 301
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 142	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   59: pop
    //   60: ldc -44
    //   62: ldc -15
    //   64: aconst_null
    //   65: iconst_1
    //   66: anewarray 216	java/lang/Class
    //   69: dup
    //   70: iconst_0
    //   71: getstatic 242	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   85: aastore
    //   86: invokestatic 223	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 48	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   95: ldc_w 299
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 138	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: ldc_w 301
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 142	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   119: pop
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 44	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:i	Z
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -90 -> 49
    //   142: astore_1
    //   143: goto -34 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	NativeCrashHandler
    //   133	4	1	localObject1	Object
    //   138	1	1	localObject2	Object
    //   142	1	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	133	finally
    //   49	60	133	finally
    //   109	130	133	finally
    //   23	46	138	finally
    //   60	106	142	finally
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.l != paramBoolean)
      {
        x.a("user change native %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.l = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static NativeCrashHandler getInstance()
  {
    try
    {
      NativeCrashHandler localNativeCrashHandler = a;
      return localNativeCrashHandler;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1, w paramw, boolean paramBoolean, String paramString)
  {
    try
    {
      if (a == null) {
        a = new NativeCrashHandler(paramContext, parama, paramb, paramw, paramBoolean, paramString);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean isShouldHandleInJava()
  {
    return p;
  }
  
  public static void setShouldHandleInJava(boolean paramBoolean)
  {
    p = paramBoolean;
    NativeCrashHandler localNativeCrashHandler = a;
    if (localNativeCrashHandler != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean);
      localNativeCrashHandler.a(999, localStringBuilder.toString());
    }
  }
  
  protected final void a()
  {
    long l1 = z.b();
    long l2 = c.g;
    long l3 = z.b();
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {}
    for (;;)
    {
      int i3;
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
          int i6 = localObject1.length;
          i3 = 0;
          i5 = 0;
          i1 = 0;
          if (i3 < i6)
          {
            Object localObject2 = localObject1[i3];
            long l4 = ((File)localObject2).lastModified();
            if (l4 >= l1 - l2)
            {
              i2 = i5;
              i4 = i1;
              if (l4 < l3 + 86400000L) {
                break label209;
              }
            }
            x.a("[Native] Delete record file: %s", new Object[] { ((File)localObject2).getAbsolutePath() });
            i5 += 1;
            i2 = i5;
            i4 = i1;
            if (!((File)localObject2).delete()) {
              break label209;
            }
            i4 = i1 + 1;
            i2 = i5;
            break label209;
          }
        }
        return;
      }
      finally
      {
        x.a(localThrowable);
      }
      return;
      label209:
      i3 += 1;
      int i5 = i2;
      int i1 = i4;
    }
  }
  
  /* Error */
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:i	Z
    //   4: ifne +12 -> 16
    //   7: aload_0
    //   8: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: getstatic 173	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:m	Z
    //   19: ifne +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_1
    //   25: ifnull +109 -> 134
    //   28: aload_2
    //   29: ifnull +105 -> 134
    //   32: aload_3
    //   33: ifnonnull +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   42: ifeq +11 -> 53
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: aload_3
    //   49: invokevirtual 352	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:appendNativeLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   52: ireturn
    //   53: ldc -44
    //   55: ldc_w 353
    //   58: aconst_null
    //   59: iconst_3
    //   60: anewarray 216	java/lang/Class
    //   63: dup
    //   64: iconst_0
    //   65: ldc -106
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: ldc -106
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: ldc -106
    //   77: aastore
    //   78: iconst_3
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_2
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: aload_3
    //   93: aastore
    //   94: invokestatic 223	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 235	java/lang/Boolean
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +12 -> 114
    //   105: aload_1
    //   106: invokevirtual 239	java/lang/Boolean:booleanValue	()Z
    //   109: istore 4
    //   111: iload 4
    //   113: ireturn
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_1
    //   117: aload_1
    //   118: invokestatic 257	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   121: ifne +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 262	java/lang/Throwable:printStackTrace	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: iconst_0
    //   131: putstatic 173	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:m	Z
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_1
    //   137: goto -7 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	NativeCrashHandler
    //   0	140	1	paramString1	String
    //   0	140	2	paramString2	String
    //   0	140	3	paramString3	String
    //   109	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   38	53	116	finally
    //   53	101	116	finally
    //   105	111	116	finally
    //   38	53	136	java/lang/UnsatisfiedLinkError
    //   53	101	136	java/lang/UnsatisfiedLinkError
    //   105	111	136	java/lang/UnsatisfiedLinkError
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash()
  {
    this.e.a(new Runnable()
    {
      public final void run()
      {
        if (!z.a(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock", 10000L))
        {
          x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
          return;
        }
        if (!NativeCrashHandler.b()) {
          NativeCrashHandler.a(NativeCrashHandler.this, 999, "false");
        }
        CrashDetailBean localCrashDetailBean = b.a(NativeCrashHandler.a(NativeCrashHandler.this), NativeCrashHandler.b(NativeCrashHandler.this), NativeCrashHandler.c(NativeCrashHandler.this));
        if (localCrashDetailBean != null)
        {
          x.a("[Native] Get crash from native record.", new Object[0]);
          if (!NativeCrashHandler.d(NativeCrashHandler.this).a(localCrashDetailBean)) {
            NativeCrashHandler.d(NativeCrashHandler.this).a(localCrashDetailBean, 3000L, false);
          }
          b.a(false, NativeCrashHandler.b(NativeCrashHandler.this));
        }
        NativeCrashHandler.this.a();
        z.b(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock");
      }
    });
  }
  
  public void dumpAnrNativeStack()
  {
    a(19, "1");
  }
  
  public void enableCatchAnrTrace()
  {
    if ((Build.VERSION.SDK_INT <= 30) && (Build.VERSION.SDK_INT >= 23)) {
      b |= 0x2;
    }
  }
  
  public boolean filterSigabrtSysLog()
  {
    return a(998, "true");
  }
  
  public String getDumpFilePath()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public String getLogFromNative()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:i	Z
    //   4: ifne +12 -> 16
    //   7: aload_0
    //   8: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: getstatic 173	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:m	Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   28: ifeq +8 -> 36
    //   31: aload_0
    //   32: invokevirtual 380	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getNativeLog	()Ljava/lang/String;
    //   35: areturn
    //   36: ldc -44
    //   38: ldc_w 381
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokestatic 223	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 150	java/lang/String
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aload_1
    //   55: invokestatic 257	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   58: ifne +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 262	java/lang/Throwable:printStackTrace	()V
    //   65: aconst_null
    //   66: areturn
    //   67: iconst_0
    //   68: putstatic 173	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:m	Z
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: goto -7 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	NativeCrashHandler
    //   50	2	1	str	String
    //   53	9	1	localThrowable	Throwable
    //   73	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   24	36	53	finally
    //   36	51	53	finally
    //   24	36	73	java/lang/UnsatisfiedLinkError
    //   36	51	73	java/lang/UnsatisfiedLinkError
  }
  
  public NativeExceptionHandler getNativeExceptionHandler()
  {
    return this.f;
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public boolean isEnableCatchAnrTrace()
  {
    return (b & 0x2) == 2;
  }
  
  public boolean isUserOpened()
  {
    try
    {
      boolean bool = this.l;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onStrategyChanged(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean != null) {}
    for (;;)
    {
      try
      {
        if (paramStrategyBean.e != this.k) {
          x.d("server native changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.e) });
        }
        if ((com.tencent.bugly.crashreport.common.strategy.a.a().c().e) && (this.l))
        {
          bool = true;
          if (bool != this.k)
          {
            x.a("native changed to %b", new Object[] { Boolean.valueOf(bool) });
            b(bool);
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public boolean putKeyValueToNative(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:i	Z
    //   4: ifne +12 -> 16
    //   7: aload_0
    //   8: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: getstatic 173	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:m	Z
    //   19: ifne +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_1
    //   25: ifnull +93 -> 118
    //   28: aload_2
    //   29: ifnonnull +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 46	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   38: ifeq +10 -> 48
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokevirtual 406	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:putNativeKeyValue	(Ljava/lang/String;Ljava/lang/String;)Z
    //   47: ireturn
    //   48: ldc -44
    //   50: ldc_w 407
    //   53: aconst_null
    //   54: iconst_2
    //   55: anewarray 216	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: ldc -106
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc -106
    //   67: aastore
    //   68: iconst_2
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_2
    //   79: aastore
    //   80: invokestatic 223	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 235	java/lang/Boolean
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +10 -> 98
    //   91: aload_1
    //   92: invokevirtual 239	java/lang/Boolean:booleanValue	()Z
    //   95: istore_3
    //   96: iload_3
    //   97: ireturn
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 257	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   105: ifne +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 262	java/lang/Throwable:printStackTrace	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: iconst_0
    //   115: putstatic 173	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:m	Z
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_1
    //   121: goto -7 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	NativeCrashHandler
    //   0	124	1	paramString1	String
    //   0	124	2	paramString2	String
    //   95	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	48	100	finally
    //   48	87	100	finally
    //   91	96	100	finally
    //   34	48	120	java/lang/UnsatisfiedLinkError
    //   48	87	120	java/lang/UnsatisfiedLinkError
    //   91	96	120	java/lang/UnsatisfiedLinkError
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  public void removeEmptyNativeRecordFiles()
  {
    b.c(this.g);
  }
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean setNativeAppChannel(String paramString)
  {
    return a(12, paramString);
  }
  
  public boolean setNativeAppPackage(String paramString)
  {
    return a(13, paramString);
  }
  
  public boolean setNativeAppVersion(String paramString)
  {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeIsAppForeground(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    return a(14, str);
  }
  
  public boolean setNativeLaunchTime(long paramLong)
  {
    try
    {
      boolean bool = a(15, String.valueOf(paramLong));
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!x.a(localNumberFormatException)) {
        localNumberFormatException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean setNativeUserId(String paramString)
  {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        c(paramBoolean);
        boolean bool = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
        paramBoolean = bool;
        if (locala != null)
        {
          if ((!bool) || (!locala.c().e)) {
            break label80;
          }
          paramBoolean = true;
        }
        if (paramBoolean != this.k)
        {
          x.a("native changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
          b(paramBoolean);
        }
        return;
      }
      finally {}
      label80:
      paramBoolean = false;
    }
  }
  
  public void startNativeMonitor()
  {
    for (;;)
    {
      String str2;
      try
      {
        if ((!this.j) && (!this.i))
        {
          String str1 = "Bugly";
          if (!z.a(this.d.m))
          {
            bool = true;
            str2 = this.d.m;
            if (bool) {
              break label201;
            }
            this.d.getClass();
            bool = a(str1, bool);
            this.j = bool;
            if (!bool)
            {
              bool = this.i;
              if (!bool) {
                return;
              }
            }
            a(this.h);
            if (m)
            {
              setNativeAppVersion(this.d.j);
              setNativeAppChannel(this.d.l);
              setNativeAppPackage(this.d.c);
              setNativeUserId(this.d.g());
              setNativeIsAppForeground(this.d.a());
              setNativeLaunchTime(this.d.a);
            }
          }
        }
        else
        {
          a(this.h);
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label201:
      Object localObject2 = str2;
    }
  }
  
  protected native void testCrash();
  
  public void testNativeCrash()
  {
    if (!this.j)
    {
      x.d("[Native] Bugly SO file has not been load.", new Object[0]);
      return;
    }
    testCrash();
  }
  
  public void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean1);
    a(16, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean2);
    a(17, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean3);
    a(18, localStringBuilder.toString());
    testNativeCrash();
  }
  
  protected native String unregist();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\NativeCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */