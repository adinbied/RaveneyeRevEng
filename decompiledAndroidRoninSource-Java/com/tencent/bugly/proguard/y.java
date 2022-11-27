package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

public final class y
{
  public static boolean a = true;
  private static boolean b = true;
  private static SimpleDateFormat c;
  private static int d = 30720;
  private static StringBuilder e;
  private static StringBuilder f;
  private static boolean g;
  private static a h;
  private static String i;
  private static String j;
  private static Context k;
  private static String l;
  private static boolean m;
  private static boolean n;
  private static ExecutorService o;
  private static int p;
  private static final Object q = new Object();
  
  static
  {
    try
    {
      c = new SimpleDateFormat("MM-dd HH:mm:ss");
      return;
    }
    finally
    {
      x.b(((Throwable)localObject).getCause());
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    e.setLength(0);
    String str = paramString3;
    if (paramString3.length() > 30720) {
      str = paramString3.substring(paramString3.length() - 30720, paramString3.length() - 1);
    }
    paramString3 = new Date();
    Object localObject = c;
    if (localObject != null) {
      paramString3 = ((SimpleDateFormat)localObject).format(paramString3);
    } else {
      paramString3 = paramString3.toString();
    }
    localObject = e;
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(p);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("\001\r\n");
    return e.toString();
  }
  
  public static void a(int paramInt)
  {
    synchronized (q)
    {
      d = paramInt;
      if (paramInt < 0) {
        d = 0;
      } else if (paramInt > 30720) {
        d = 30720;
      }
      return;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 118	com/tencent/bugly/proguard/y:m	Z
    //   6: ifne +152 -> 158
    //   9: aload_0
    //   10: ifnull +148 -> 158
    //   13: getstatic 120	com/tencent/bugly/proguard/y:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +6 -> 24
    //   21: goto +137 -> 158
    //   24: invokestatic 126	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   27: putstatic 128	com/tencent/bugly/proguard/y:o	Ljava/util/concurrent/ExecutorService;
    //   30: new 69	java/lang/StringBuilder
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial 130	java/lang/StringBuilder:<init>	(I)V
    //   38: putstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   41: new 69	java/lang/StringBuilder
    //   44: dup
    //   45: iconst_0
    //   46: invokespecial 130	java/lang/StringBuilder:<init>	(I)V
    //   49: putstatic 67	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: putstatic 134	com/tencent/bugly/proguard/y:k	Landroid/content/Context;
    //   56: aload_0
    //   57: invokestatic 139	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   60: astore_0
    //   61: aload_0
    //   62: getfield 141	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   65: putstatic 143	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   68: aload_0
    //   69: invokevirtual 147	java/lang/Object:getClass	()Ljava/lang/Class;
    //   72: pop
    //   73: ldc -107
    //   75: putstatic 151	com/tencent/bugly/proguard/y:j	Ljava/lang/String;
    //   78: new 69	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   85: astore_0
    //   86: aload_0
    //   87: getstatic 134	com/tencent/bugly/proguard/y:k	Landroid/content/Context;
    //   90: invokevirtual 158	android/content/Context:getFilesDir	()Ljava/io/File;
    //   93: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   96: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: ldc -91
    //   103: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: getstatic 143	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   111: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: ldc -89
    //   118: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_0
    //   123: getstatic 151	com/tencent/bugly/proguard/y:j	Ljava/lang/String;
    //   126: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_0
    //   131: ldc -87
    //   133: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_0
    //   138: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: putstatic 171	com/tencent/bugly/proguard/y:l	Ljava/lang/String;
    //   144: invokestatic 176	android/os/Process:myPid	()I
    //   147: putstatic 102	com/tencent/bugly/proguard/y:p	I
    //   150: iconst_1
    //   151: putstatic 118	com/tencent/bugly/proguard/y:m	Z
    //   154: ldc 2
    //   156: monitorexit
    //   157: return
    //   158: ldc 2
    //   160: monitorexit
    //   161: return
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: goto -19 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	162	finally
    //   13	17	162	finally
    //   150	154	162	finally
    //   24	150	168	finally
  }
  
  public static void a(String paramString1, final String paramString2, final String paramString3)
  {
    try
    {
      if (m)
      {
        boolean bool = a;
        if (bool) {
          try
          {
            o.execute(new Runnable()
            {
              public final void run()
              {
                y.b(this.a, paramString2, paramString3);
              }
            });
            return;
          }
          catch (Exception paramString1)
          {
            x.b(paramString1);
            return;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    Object localObject2 = paramThrowable.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append('\n');
    ((StringBuilder)localObject2).append(z.b(paramThrowable));
    a(paramString1, paramString2, ((StringBuilder)localObject2).toString());
  }
  
  public static byte[] a()
  {
    if (b)
    {
      if (!a) {
        return null;
      }
      return z.a(null, f.toString(), "BuglyLog.txt");
    }
    return b();
  }
  
  private static byte[] b()
  {
    if (!a) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (q)
    {
      if ((h != null) && (a.d(h)) && (a.a(h) != null) && (a.a(h).length() > 0L)) {
        localStringBuilder.append(z.a(a.a(h), 30720, true));
      }
      if ((f != null) && (f.length() > 0)) {
        localStringBuilder.append(f.toString());
      }
      return z.a(null, localStringBuilder.toString(), "BuglyLog.txt");
    }
  }
  
  private static void c(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (b)
      {
        d(paramString1, paramString2, paramString3);
        return;
      }
      e(paramString1, paramString2, paramString3);
      return;
    }
    finally {}
  }
  
  /* Error */
  private static void d(String arg0, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokestatic 235	android/os/Process:myTid	()I
    //   9: i2l
    //   10: invokestatic 237	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   13: astore_1
    //   14: getstatic 43	com/tencent/bugly/proguard/y:q	Ljava/lang/Object;
    //   17: astore_0
    //   18: aload_0
    //   19: monitorenter
    //   20: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   31: invokevirtual 228	java/lang/StringBuilder:length	()I
    //   34: getstatic 115	com/tencent/bugly/proguard/y:d	I
    //   37: if_icmplt +38 -> 75
    //   40: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   43: iconst_0
    //   44: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   47: ldc 112
    //   49: invokevirtual 241	java/lang/StringBuilder:indexOf	(Ljava/lang/String;)I
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   57: putstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   60: goto +15 -> 75
    //   63: astore_1
    //   64: aload_1
    //   65: invokestatic 63	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   68: ifne +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 248	java/lang/Throwable:printStackTrace	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: ldc 2
    //   79: monitorexit
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	1	paramString2	String
    //   0	92	2	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   20	60	63	finally
    //   64	75	81	finally
    //   75	77	81	finally
    //   3	20	86	finally
    //   82	86	86	finally
  }
  
  /* Error */
  private static void e(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokestatic 235	android/os/Process:myTid	()I
    //   9: i2l
    //   10: invokestatic 237	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   13: astore_1
    //   14: getstatic 43	com/tencent/bugly/proguard/y:q	Ljava/lang/Object;
    //   17: astore_0
    //   18: aload_0
    //   19: monitorenter
    //   20: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   31: invokevirtual 228	java/lang/StringBuilder:length	()I
    //   34: istore_3
    //   35: getstatic 115	com/tencent/bugly/proguard/y:d	I
    //   38: istore 4
    //   40: iload_3
    //   41: iload 4
    //   43: if_icmpgt +9 -> 52
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: getstatic 250	com/tencent/bugly/proguard/y:g	Z
    //   55: istore 5
    //   57: iload 5
    //   59: ifeq +9 -> 68
    //   62: aload_0
    //   63: monitorexit
    //   64: ldc 2
    //   66: monitorexit
    //   67: return
    //   68: iconst_1
    //   69: putstatic 250	com/tencent/bugly/proguard/y:g	Z
    //   72: getstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   75: ifnonnull +19 -> 94
    //   78: new 8	com/tencent/bugly/proguard/y$a
    //   81: dup
    //   82: getstatic 171	com/tencent/bugly/proguard/y:l	Ljava/lang/String;
    //   85: invokespecial 251	com/tencent/bugly/proguard/y$a:<init>	(Ljava/lang/String;)V
    //   88: putstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   91: goto +46 -> 137
    //   94: getstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   97: invokestatic 221	com/tencent/bugly/proguard/y$a:a	(Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   100: ifnull +30 -> 130
    //   103: getstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   106: invokestatic 221	com/tencent/bugly/proguard/y$a:a	(Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   109: invokevirtual 224	java/io/File:length	()J
    //   112: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   115: invokevirtual 228	java/lang/StringBuilder:length	()I
    //   118: i2l
    //   119: ladd
    //   120: getstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   123: invokestatic 254	com/tencent/bugly/proguard/y$a:b	(Lcom/tencent/bugly/proguard/y$a;)J
    //   126: lcmp
    //   127: ifle +10 -> 137
    //   130: getstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   133: invokestatic 256	com/tencent/bugly/proguard/y$a:c	(Lcom/tencent/bugly/proguard/y$a;)Z
    //   136: pop
    //   137: getstatic 215	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   140: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   143: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 259	com/tencent/bugly/proguard/y$a:a	(Ljava/lang/String;)Z
    //   149: ifeq +14 -> 163
    //   152: getstatic 132	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   155: iconst_0
    //   156: invokevirtual 73	java/lang/StringBuilder:setLength	(I)V
    //   159: iconst_0
    //   160: putstatic 250	com/tencent/bugly/proguard/y:g	Z
    //   163: aload_0
    //   164: monitorexit
    //   165: ldc 2
    //   167: monitorexit
    //   168: return
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    //   180: astore_1
    //   181: goto -18 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString1	String
    //   0	184	1	paramString2	String
    //   0	184	2	paramString3	String
    //   34	10	3	i1	int
    //   38	6	4	i2	int
    //   55	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	48	169	finally
    //   62	64	169	finally
    //   163	165	169	finally
    //   3	20	174	finally
    //   170	174	174	finally
    //   20	40	180	finally
    //   52	57	180	finally
    //   68	91	180	finally
    //   94	130	180	finally
    //   130	137	180	finally
    //   137	163	180	finally
  }
  
  public static final class a
  {
    private boolean a;
    private File b;
    private String c;
    private long d;
    private long e = 30720L;
    
    public a(String paramString)
    {
      if (paramString != null)
      {
        if (paramString.equals("")) {
          return;
        }
        this.c = paramString;
        this.a = a();
      }
    }
    
    private boolean a()
    {
      try
      {
        File localFile = new File(this.c);
        this.b = localFile;
        if ((localFile.exists()) && (!this.b.delete()))
        {
          this.a = false;
          return false;
        }
        if (!this.b.createNewFile())
        {
          this.a = false;
          return false;
        }
        return true;
      }
      finally
      {
        x.a(localThrowable);
        this.a = false;
      }
      return false;
    }
    
    /* Error */
    public final boolean a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 39	com/tencent/bugly/proguard/y$a:a	Z
      //   4: ifne +5 -> 9
      //   7: iconst_0
      //   8: ireturn
      //   9: aconst_null
      //   10: astore_3
      //   11: new 68	java/io/FileOutputStream
      //   14: dup
      //   15: aload_0
      //   16: getfield 43	com/tencent/bugly/proguard/y$a:b	Ljava/io/File;
      //   19: iconst_1
      //   20: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   23: astore_2
      //   24: aload_1
      //   25: ldc 73
      //   27: invokevirtual 77	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   30: astore_1
      //   31: aload_2
      //   32: aload_1
      //   33: invokevirtual 81	java/io/FileOutputStream:write	([B)V
      //   36: aload_2
      //   37: invokevirtual 84	java/io/FileOutputStream:flush	()V
      //   40: aload_2
      //   41: invokevirtual 87	java/io/FileOutputStream:close	()V
      //   44: aload_0
      //   45: aload_0
      //   46: getfield 89	com/tencent/bugly/proguard/y$a:d	J
      //   49: aload_1
      //   50: arraylength
      //   51: i2l
      //   52: ladd
      //   53: putfield 89	com/tencent/bugly/proguard/y$a:d	J
      //   56: aload_0
      //   57: iconst_1
      //   58: putfield 39	com/tencent/bugly/proguard/y$a:a	Z
      //   61: aload_2
      //   62: invokevirtual 87	java/io/FileOutputStream:close	()V
      //   65: iconst_1
      //   66: ireturn
      //   67: astore_3
      //   68: aload_2
      //   69: astore_1
      //   70: aload_3
      //   71: astore_2
      //   72: goto +6 -> 78
      //   75: astore_2
      //   76: aload_3
      //   77: astore_1
      //   78: aload_2
      //   79: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
      //   82: pop
      //   83: aload_0
      //   84: iconst_0
      //   85: putfield 39	com/tencent/bugly/proguard/y$a:a	Z
      //   88: aload_1
      //   89: ifnull +7 -> 96
      //   92: aload_1
      //   93: invokevirtual 87	java/io/FileOutputStream:close	()V
      //   96: iconst_0
      //   97: ireturn
      //   98: astore_2
      //   99: aload_1
      //   100: ifnull +7 -> 107
      //   103: aload_1
      //   104: invokevirtual 87	java/io/FileOutputStream:close	()V
      //   107: aload_2
      //   108: athrow
      //   109: astore_1
      //   110: iconst_1
      //   111: ireturn
      //   112: astore_1
      //   113: iconst_0
      //   114: ireturn
      //   115: astore_1
      //   116: goto -9 -> 107
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	a
      //   0	119	1	paramString	String
      //   23	49	2	localObject1	Object
      //   75	4	2	localThrowable	Throwable
      //   98	10	2	localObject2	Object
      //   10	1	3	localObject3	Object
      //   67	10	3	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   24	61	67	finally
      //   11	24	75	finally
      //   78	88	98	finally
      //   61	65	109	java/io/IOException
      //   92	96	112	java/io/IOException
      //   103	107	115	java/io/IOException
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */