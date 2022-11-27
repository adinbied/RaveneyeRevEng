package com.huawei.hianalytics.f.g;

import android.content.Context;
import java.io.File;

public class d
{
  private static final Object a = new Object();
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 23	com/huawei/hianalytics/f/g/d:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   5: istore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: iload_3
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: getstatic 13	com/huawei/hianalytics/f/g/d:a	Ljava/lang/Object;
    //   18: astore 5
    //   20: aload 5
    //   22: monitorenter
    //   23: new 25	com/huawei/hianalytics/util/a
    //   26: dup
    //   27: sipush 2048
    //   30: invokespecial 28	com/huawei/hianalytics/util/a:<init>	(I)V
    //   33: astore 6
    //   35: aload_0
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 31	com/huawei/hianalytics/f/g/d:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   41: invokevirtual 37	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: sipush 2048
    //   50: newarray <illegal type>
    //   52: astore 4
    //   54: aload_1
    //   55: astore_0
    //   56: aload_1
    //   57: aload 4
    //   59: invokevirtual 43	java/io/FileInputStream:read	([B)I
    //   62: istore_2
    //   63: iload_2
    //   64: i2l
    //   65: ldc2_w 44
    //   68: lcmp
    //   69: ifeq +16 -> 85
    //   72: aload_1
    //   73: astore_0
    //   74: aload 6
    //   76: aload 4
    //   78: iload_2
    //   79: invokevirtual 48	com/huawei/hianalytics/util/a:a	([BI)V
    //   82: goto -28 -> 54
    //   85: aload_1
    //   86: astore_0
    //   87: aload 6
    //   89: invokevirtual 51	com/huawei/hianalytics/util/a:a	()I
    //   92: istore_2
    //   93: iload_2
    //   94: ifne +26 -> 120
    //   97: aload_1
    //   98: ifnull +17 -> 115
    //   101: aload_1
    //   102: invokevirtual 54	java/io/FileInputStream:close	()V
    //   105: goto +10 -> 115
    //   108: ldc 56
    //   110: ldc 58
    //   112: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: monitorexit
    //   118: aconst_null
    //   119: areturn
    //   120: aload_1
    //   121: astore_0
    //   122: new 65	java/lang/String
    //   125: dup
    //   126: aload 6
    //   128: invokevirtual 69	com/huawei/hianalytics/util/a:b	()[B
    //   131: ldc 71
    //   133: invokespecial 74	java/lang/String:<init>	([BLjava/lang/String;)V
    //   136: astore 4
    //   138: aload_1
    //   139: ifnull +17 -> 156
    //   142: aload_1
    //   143: invokevirtual 54	java/io/FileInputStream:close	()V
    //   146: goto +10 -> 156
    //   149: ldc 56
    //   151: ldc 58
    //   153: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 5
    //   158: monitorexit
    //   159: aload 4
    //   161: areturn
    //   162: astore_0
    //   163: aload 4
    //   165: astore_1
    //   166: goto +78 -> 244
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: astore_0
    //   173: ldc 56
    //   175: ldc 76
    //   177: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_1
    //   181: ifnull +17 -> 198
    //   184: aload_1
    //   185: invokevirtual 54	java/io/FileInputStream:close	()V
    //   188: goto +10 -> 198
    //   191: ldc 56
    //   193: ldc 58
    //   195: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 5
    //   200: monitorexit
    //   201: aconst_null
    //   202: areturn
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_1
    //   206: astore_0
    //   207: ldc 56
    //   209: ldc 78
    //   211: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_1
    //   215: ifnull +17 -> 232
    //   218: aload_1
    //   219: invokevirtual 54	java/io/FileInputStream:close	()V
    //   222: goto +10 -> 232
    //   225: ldc 56
    //   227: ldc 58
    //   229: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 5
    //   234: monitorexit
    //   235: aconst_null
    //   236: areturn
    //   237: astore 4
    //   239: aload_0
    //   240: astore_1
    //   241: aload 4
    //   243: astore_0
    //   244: aload_1
    //   245: ifnull +17 -> 262
    //   248: aload_1
    //   249: invokevirtual 54	java/io/FileInputStream:close	()V
    //   252: goto +10 -> 262
    //   255: ldc 56
    //   257: ldc 58
    //   259: invokestatic 63	com/huawei/hianalytics/g/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: athrow
    //   264: astore_0
    //   265: aload 5
    //   267: monitorexit
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: goto -68 -> 203
    //   274: astore_0
    //   275: goto -106 -> 169
    //   278: astore_0
    //   279: goto -74 -> 205
    //   282: astore_0
    //   283: goto -112 -> 171
    //   286: astore_0
    //   287: goto -179 -> 108
    //   290: astore_0
    //   291: goto -142 -> 149
    //   294: astore_0
    //   295: goto -104 -> 191
    //   298: astore_0
    //   299: goto -74 -> 225
    //   302: astore_1
    //   303: goto -48 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramContext	Context
    //   0	306	1	paramString	String
    //   62	32	2	i	int
    //   5	5	3	bool	boolean
    //   7	157	4	localObject1	Object
    //   237	5	4	localObject2	Object
    //   18	248	5	localObject3	Object
    //   33	94	6	locala	com.huawei.hianalytics.util.a
    // Exception table:
    //   from	to	target	type
    //   23	45	162	finally
    //   47	54	237	finally
    //   56	63	237	finally
    //   74	82	237	finally
    //   87	93	237	finally
    //   122	138	237	finally
    //   173	180	237	finally
    //   207	214	237	finally
    //   101	105	264	finally
    //   108	115	264	finally
    //   115	118	264	finally
    //   142	146	264	finally
    //   149	156	264	finally
    //   156	159	264	finally
    //   184	188	264	finally
    //   191	198	264	finally
    //   198	201	264	finally
    //   218	222	264	finally
    //   225	232	264	finally
    //   232	235	264	finally
    //   248	252	264	finally
    //   255	262	264	finally
    //   262	264	264	finally
    //   265	268	264	finally
    //   23	45	270	java/io/FileNotFoundException
    //   23	45	274	java/io/IOException
    //   47	54	278	java/io/FileNotFoundException
    //   56	63	278	java/io/FileNotFoundException
    //   74	82	278	java/io/FileNotFoundException
    //   87	93	278	java/io/FileNotFoundException
    //   122	138	278	java/io/FileNotFoundException
    //   47	54	282	java/io/IOException
    //   56	63	282	java/io/IOException
    //   74	82	282	java/io/IOException
    //   87	93	282	java/io/IOException
    //   122	138	282	java/io/IOException
    //   101	105	286	java/io/IOException
    //   142	146	290	java/io/IOException
    //   184	188	294	java/io/IOException
    //   218	222	298	java/io/IOException
    //   248	252	302	java/io/IOException
  }
  
  public static void a(File paramFile)
  {
    com.huawei.hianalytics.util.b.a(paramFile);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    synchronized (a)
    {
      paramContext.deleteFile(d(paramContext, paramString));
      return;
    }
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    paramString = d(paramContext, paramString);
    paramContext = new File(paramContext.getFilesDir(), paramString);
    if (!paramContext.exists())
    {
      com.huawei.hianalytics.g.b.b("HiAnalytics/event", "cached file not found");
      return false;
    }
    long l = paramContext.length();
    if (l > 5242880L)
    {
      com.huawei.hianalytics.g.b.b("HiAnalytics/event", "v1 cached file size overlarge - file len: %d limitedSize: %d", new Object[] { Long.valueOf(l), Long.valueOf(5242880L) });
      return false;
    }
    return true;
  }
  
  private static String d(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hianalytics_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */