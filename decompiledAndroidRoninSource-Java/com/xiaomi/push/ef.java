package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

public abstract class ef
  extends ai.a
{
  protected int a;
  protected Context a;
  
  public ef(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(Context paramContext, hw paramhw)
  {
    Object localObject = ds.a().a();
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((dr)localObject).a();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (TextUtils.isEmpty(paramhw.a())) {
      return;
    }
    a(paramContext, paramhw, (String)localObject);
  }
  
  /* Error */
  private static void a(Context paramContext, hw paramhw, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_1
    //   2: invokestatic 52	com/xiaomi/push/iy:a	(Lcom/xiaomi/push/iz;)[B
    //   5: invokestatic 58	com/xiaomi/push/dw:b	(Ljava/lang/String;[B)[B
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +302 -> 314
    //   15: aload 4
    //   17: arraylength
    //   18: ifne +4 -> 22
    //   21: return
    //   22: getstatic 63	com/xiaomi/push/dx:a	Ljava/lang/Object;
    //   25: astore 7
    //   27: aload 7
    //   29: monitorenter
    //   30: aconst_null
    //   31: astore 6
    //   33: aconst_null
    //   34: astore 5
    //   36: new 65	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: aconst_null
    //   42: invokevirtual 71	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   45: ldc 73
    //   47: invokespecial 76	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: invokestatic 81	com/xiaomi/push/y:a	(Ljava/io/File;)Z
    //   55: pop
    //   56: new 83	java/io/RandomAccessFile
    //   59: dup
    //   60: aload_1
    //   61: ldc 85
    //   63: invokespecial 86	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 90	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   71: invokevirtual 96	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   74: astore_2
    //   75: new 98	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 100	java/io/FileOutputStream
    //   82: dup
    //   83: new 65	java/io/File
    //   86: dup
    //   87: aload_0
    //   88: aconst_null
    //   89: invokevirtual 71	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   92: ldc 102
    //   94: invokespecial 76	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: iconst_1
    //   98: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   101: invokespecial 108	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore 5
    //   106: aload 5
    //   108: aload 4
    //   110: arraylength
    //   111: invokestatic 113	com/xiaomi/push/ac:a	(I)[B
    //   114: invokevirtual 117	java/io/BufferedOutputStream:write	([B)V
    //   117: aload 5
    //   119: aload 4
    //   121: invokevirtual 117	java/io/BufferedOutputStream:write	([B)V
    //   124: aload 5
    //   126: invokevirtual 120	java/io/BufferedOutputStream:flush	()V
    //   129: aload_2
    //   130: ifnull +16 -> 146
    //   133: aload_2
    //   134: invokevirtual 126	java/nio/channels/FileLock:isValid	()Z
    //   137: istore_3
    //   138: iload_3
    //   139: ifeq +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 129	java/nio/channels/FileLock:release	()V
    //   146: aload 5
    //   148: invokestatic 132	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   151: aload_1
    //   152: astore_0
    //   153: aload_0
    //   154: invokestatic 132	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   157: goto +120 -> 277
    //   160: astore_0
    //   161: goto +12 -> 173
    //   164: astore 4
    //   166: goto +21 -> 187
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 5
    //   173: aload_1
    //   174: astore 4
    //   176: aload 5
    //   178: astore_1
    //   179: goto +102 -> 281
    //   182: astore 4
    //   184: aconst_null
    //   185: astore 5
    //   187: aload_1
    //   188: astore_0
    //   189: aload 5
    //   191: astore_1
    //   192: goto +56 -> 248
    //   195: astore_0
    //   196: aconst_null
    //   197: astore 5
    //   199: aload 6
    //   201: astore_2
    //   202: aload_1
    //   203: astore 4
    //   205: aload 5
    //   207: astore_1
    //   208: goto +73 -> 281
    //   211: astore 4
    //   213: aconst_null
    //   214: astore 6
    //   216: aload 5
    //   218: astore_2
    //   219: aload_1
    //   220: astore_0
    //   221: aload 6
    //   223: astore_1
    //   224: goto +24 -> 248
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: astore 4
    //   233: aload 6
    //   235: astore_2
    //   236: goto +45 -> 281
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_1
    //   243: aload_1
    //   244: astore_0
    //   245: aload 5
    //   247: astore_2
    //   248: aload 4
    //   250: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   253: aload_2
    //   254: ifnull +16 -> 270
    //   257: aload_2
    //   258: invokevirtual 126	java/nio/channels/FileLock:isValid	()Z
    //   261: istore_3
    //   262: iload_3
    //   263: ifeq +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 129	java/nio/channels/FileLock:release	()V
    //   270: aload_1
    //   271: invokestatic 132	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   274: goto -121 -> 153
    //   277: aload 7
    //   279: monitorexit
    //   280: return
    //   281: aload_2
    //   282: ifnull +16 -> 298
    //   285: aload_2
    //   286: invokevirtual 126	java/nio/channels/FileLock:isValid	()Z
    //   289: istore_3
    //   290: iload_3
    //   291: ifeq +7 -> 298
    //   294: aload_2
    //   295: invokevirtual 129	java/nio/channels/FileLock:release	()V
    //   298: aload_1
    //   299: invokestatic 132	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   302: aload 4
    //   304: invokestatic 132	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   307: aload_0
    //   308: athrow
    //   309: aload 7
    //   311: monitorexit
    //   312: aload_0
    //   313: athrow
    //   314: return
    //   315: astore_0
    //   316: goto -170 -> 146
    //   319: astore_2
    //   320: goto -50 -> 270
    //   323: astore_2
    //   324: goto -26 -> 298
    //   327: astore_0
    //   328: goto -19 -> 309
    //   331: astore 5
    //   333: aload_0
    //   334: astore 4
    //   336: aload 5
    //   338: astore_0
    //   339: goto -58 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	Context
    //   0	342	1	paramhw	hw
    //   0	342	2	paramString	String
    //   137	154	3	bool	boolean
    //   8	112	4	arrayOfByte	byte[]
    //   164	1	4	localIOException1	java.io.IOException
    //   174	1	4	localhw1	hw
    //   182	1	4	localIOException2	java.io.IOException
    //   203	1	4	localhw2	hw
    //   211	1	4	localIOException3	java.io.IOException
    //   231	1	4	localhw3	hw
    //   239	64	4	localIOException4	java.io.IOException
    //   334	1	4	localContext	Context
    //   34	212	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   331	6	5	localObject1	Object
    //   31	203	6	localObject2	Object
    //   25	285	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   106	129	160	finally
    //   106	129	164	java/io/IOException
    //   75	106	169	finally
    //   75	106	182	java/io/IOException
    //   67	75	195	finally
    //   67	75	211	java/io/IOException
    //   36	67	227	finally
    //   36	67	239	java/io/IOException
    //   142	146	315	java/io/IOException
    //   266	270	319	java/io/IOException
    //   294	298	323	java/io/IOException
    //   133	138	327	finally
    //   142	146	327	finally
    //   146	151	327	finally
    //   153	157	327	finally
    //   257	262	327	finally
    //   266	270	327	finally
    //   270	274	327	finally
    //   277	280	327	finally
    //   285	290	327	finally
    //   294	298	327	finally
    //   298	309	327	finally
    //   309	312	327	finally
    //   248	253	331	finally
  }
  
  public abstract hq a();
  
  public abstract String a();
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */