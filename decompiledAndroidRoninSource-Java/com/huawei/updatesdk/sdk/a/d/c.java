package com.huawei.updatesdk.sdk.a.d;

import com.huawei.updatesdk.sdk.a.c.a.a.a;
import java.io.Closeable;
import java.io.IOException;

public abstract class c
{
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_1
    //   13: invokestatic 22	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore 7
    //   18: new 24	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: sipush 1024
    //   32: newarray <illegal type>
    //   34: astore 5
    //   36: lconst_0
    //   37: lstore_3
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: aload 5
    //   43: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_m1
    //   49: if_icmpeq +22 -> 71
    //   52: aload_1
    //   53: astore_0
    //   54: aload 7
    //   56: aload 5
    //   58: iconst_0
    //   59: iload_2
    //   60: invokevirtual 36	java/security/MessageDigest:update	([BII)V
    //   63: lload_3
    //   64: iload_2
    //   65: i2l
    //   66: ladd
    //   67: lstore_3
    //   68: goto -30 -> 38
    //   71: aload 6
    //   73: astore 5
    //   75: aload_1
    //   76: astore_0
    //   77: lload_3
    //   78: lconst_0
    //   79: lcmp
    //   80: ifle +17 -> 97
    //   83: aload_1
    //   84: astore_0
    //   85: aload 7
    //   87: invokevirtual 40	java/security/MessageDigest:digest	()[B
    //   90: invokestatic 45	com/huawei/updatesdk/sdk/a/d/b:a	([B)Ljava/lang/String;
    //   93: astore 5
    //   95: aload_1
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 49	java/io/FileInputStream:close	()V
    //   101: aload 5
    //   103: areturn
    //   104: ldc 51
    //   106: ldc 53
    //   108: invokestatic 59	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 5
    //   113: areturn
    //   114: astore 5
    //   116: goto +34 -> 150
    //   119: astore 5
    //   121: goto +53 -> 174
    //   124: astore 5
    //   126: goto +72 -> 198
    //   129: astore 5
    //   131: goto +91 -> 222
    //   134: astore 5
    //   136: goto +110 -> 246
    //   139: astore_0
    //   140: aload 5
    //   142: astore_1
    //   143: goto +136 -> 279
    //   146: astore 5
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore_0
    //   152: ldc 51
    //   154: ldc 61
    //   156: aload 5
    //   158: invokestatic 64	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_1
    //   162: ifnull +108 -> 270
    //   165: aload 6
    //   167: astore 5
    //   169: aload_1
    //   170: astore_0
    //   171: goto -74 -> 97
    //   174: aload_1
    //   175: astore_0
    //   176: ldc 51
    //   178: ldc 66
    //   180: aload 5
    //   182: invokestatic 64	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_1
    //   186: ifnull +84 -> 270
    //   189: aload 6
    //   191: astore 5
    //   193: aload_1
    //   194: astore_0
    //   195: goto -98 -> 97
    //   198: aload_1
    //   199: astore_0
    //   200: ldc 51
    //   202: ldc 68
    //   204: aload 5
    //   206: invokestatic 64	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_1
    //   210: ifnull +60 -> 270
    //   213: aload 6
    //   215: astore 5
    //   217: aload_1
    //   218: astore_0
    //   219: goto -122 -> 97
    //   222: aload_1
    //   223: astore_0
    //   224: ldc 51
    //   226: ldc 70
    //   228: aload 5
    //   230: invokestatic 64	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload_1
    //   234: ifnull +36 -> 270
    //   237: aload 6
    //   239: astore 5
    //   241: aload_1
    //   242: astore_0
    //   243: goto -146 -> 97
    //   246: aload_1
    //   247: astore_0
    //   248: ldc 51
    //   250: ldc 72
    //   252: aload 5
    //   254: invokestatic 64	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_1
    //   258: ifnull +12 -> 270
    //   261: aload 6
    //   263: astore 5
    //   265: aload_1
    //   266: astore_0
    //   267: goto -170 -> 97
    //   270: aconst_null
    //   271: areturn
    //   272: astore 5
    //   274: aload_0
    //   275: astore_1
    //   276: aload 5
    //   278: astore_0
    //   279: aload_1
    //   280: ifnull +17 -> 297
    //   283: aload_1
    //   284: invokevirtual 49	java/io/FileInputStream:close	()V
    //   287: goto +10 -> 297
    //   290: ldc 51
    //   292: ldc 53
    //   294: invokestatic 59	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: athrow
    //   299: astore_0
    //   300: goto -196 -> 104
    //   303: astore_1
    //   304: goto -14 -> 290
    //   307: astore 5
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -137 -> 174
    //   314: astore 5
    //   316: aconst_null
    //   317: astore_1
    //   318: goto -120 -> 198
    //   321: astore 5
    //   323: aconst_null
    //   324: astore_1
    //   325: goto -103 -> 222
    //   328: astore 5
    //   330: aconst_null
    //   331: astore_1
    //   332: goto -86 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramString1	String
    //   0	335	1	paramString2	String
    //   46	19	2	i	int
    //   37	41	3	l	long
    //   1	111	5	localObject1	Object
    //   114	1	5	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   119	1	5	localIllegalArgumentException1	IllegalArgumentException
    //   124	1	5	localIOException1	IOException
    //   129	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   134	7	5	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   146	11	5	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    //   167	97	5	localObject2	Object
    //   272	5	5	localObject3	Object
    //   307	1	5	localIllegalArgumentException2	IllegalArgumentException
    //   314	1	5	localIOException2	IOException
    //   321	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   328	1	5	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   4	258	6	localObject4	Object
    //   16	70	7	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   29	36	114	java/lang/IndexOutOfBoundsException
    //   40	47	114	java/lang/IndexOutOfBoundsException
    //   54	63	114	java/lang/IndexOutOfBoundsException
    //   85	95	114	java/lang/IndexOutOfBoundsException
    //   29	36	119	java/lang/IllegalArgumentException
    //   40	47	119	java/lang/IllegalArgumentException
    //   54	63	119	java/lang/IllegalArgumentException
    //   85	95	119	java/lang/IllegalArgumentException
    //   29	36	124	java/io/IOException
    //   40	47	124	java/io/IOException
    //   54	63	124	java/io/IOException
    //   85	95	124	java/io/IOException
    //   29	36	129	java/io/FileNotFoundException
    //   40	47	129	java/io/FileNotFoundException
    //   54	63	129	java/io/FileNotFoundException
    //   85	95	129	java/io/FileNotFoundException
    //   29	36	134	java/security/NoSuchAlgorithmException
    //   40	47	134	java/security/NoSuchAlgorithmException
    //   54	63	134	java/security/NoSuchAlgorithmException
    //   85	95	134	java/security/NoSuchAlgorithmException
    //   12	27	139	finally
    //   12	27	146	java/lang/IndexOutOfBoundsException
    //   29	36	272	finally
    //   40	47	272	finally
    //   54	63	272	finally
    //   85	95	272	finally
    //   152	161	272	finally
    //   176	185	272	finally
    //   200	209	272	finally
    //   224	233	272	finally
    //   248	257	272	finally
    //   97	101	299	java/io/IOException
    //   283	287	303	java/io/IOException
    //   12	27	307	java/lang/IllegalArgumentException
    //   12	27	314	java/io/IOException
    //   12	27	321	java/io/FileNotFoundException
    //   12	27	328	java/security/NoSuchAlgorithmException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        a.a("FileUtil", "Closeable exception", paramCloseable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */