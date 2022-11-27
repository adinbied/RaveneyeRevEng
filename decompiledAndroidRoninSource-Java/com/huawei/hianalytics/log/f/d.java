package com.huawei.hianalytics.log.f;

import java.io.File;

class d
{
  /* Error */
  static int a(java.util.List<com.huawei.hianalytics.log.f.a.c> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +289 -> 290
    //   4: aload_0
    //   5: invokeinterface 14 1 0
    //   10: ifne +6 -> 16
    //   13: goto +277 -> 290
    //   16: aload_0
    //   17: invokeinterface 18 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 24 1 0
    //   31: ifeq +257 -> 288
    //   34: aload 4
    //   36: invokeinterface 28 1 0
    //   41: checkcast 30	com/huawei/hianalytics/log/f/a/c
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 33	com/huawei/hianalytics/log/f/a/c:a	()Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +5 -> 59
    //   57: iconst_m1
    //   58: ireturn
    //   59: new 41	java/net/URL
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 45	java/net/URL:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload_3
    //   70: invokevirtual 48	com/huawei/hianalytics/log/f/a/c:b	()Ljava/lang/String;
    //   73: astore 6
    //   75: aload_3
    //   76: invokevirtual 52	com/huawei/hianalytics/log/f/a/c:d	()Ljava/util/Map;
    //   79: astore 7
    //   81: aconst_null
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_3
    //   86: invokevirtual 55	com/huawei/hianalytics/log/f/a/c:c	()Ljava/lang/String;
    //   89: invokestatic 58	com/huawei/hianalytics/log/f/d:a	(Ljava/lang/String;)Ljava/io/File;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnonnull +24 -> 118
    //   97: ldc 60
    //   99: ldc 62
    //   101: invokestatic 67	com/huawei/hianalytics/g/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: bipush 7
    //   106: aconst_null
    //   107: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   110: bipush 8
    //   112: aconst_null
    //   113: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   116: iconst_m1
    //   117: ireturn
    //   118: new 74	java/io/DataInputStream
    //   121: dup
    //   122: new 76	java/io/FileInputStream
    //   125: dup
    //   126: aload_3
    //   127: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   130: invokespecial 82	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore_3
    //   134: new 84	java/io/ByteArrayOutputStream
    //   137: dup
    //   138: sipush 1024
    //   141: invokespecial 87	java/io/ByteArrayOutputStream:<init>	(I)V
    //   144: astore_0
    //   145: sipush 1024
    //   148: newarray <illegal type>
    //   150: astore_2
    //   151: aload_3
    //   152: aload_2
    //   153: invokevirtual 93	java/io/InputStream:read	([B)I
    //   156: istore_1
    //   157: iload_1
    //   158: iconst_m1
    //   159: if_icmpeq +13 -> 172
    //   162: aload_0
    //   163: aload_2
    //   164: iconst_0
    //   165: iload_1
    //   166: invokevirtual 97	java/io/ByteArrayOutputStream:write	([BII)V
    //   169: goto -18 -> 151
    //   172: aload_0
    //   173: invokevirtual 101	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   176: astore_2
    //   177: aload 5
    //   179: invokevirtual 104	java/net/URL:toString	()Ljava/lang/String;
    //   182: aload_2
    //   183: aload 6
    //   185: aload 7
    //   187: invokestatic 109	com/huawei/hianalytics/h/d:a	(Ljava/lang/String;[BLjava/lang/String;Ljava/util/Map;)Lcom/huawei/hianalytics/h/e;
    //   190: invokevirtual 113	com/huawei/hianalytics/h/e:a	()I
    //   193: istore_1
    //   194: bipush 7
    //   196: aload_3
    //   197: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   200: bipush 8
    //   202: aload_0
    //   203: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   206: iload_1
    //   207: ireturn
    //   208: astore 4
    //   210: aload_0
    //   211: astore_2
    //   212: aload 4
    //   214: astore_0
    //   215: goto +6 -> 221
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_0
    //   222: astore 4
    //   224: goto +49 -> 273
    //   227: aconst_null
    //   228: astore_0
    //   229: aload_3
    //   230: astore_2
    //   231: goto +14 -> 245
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_0
    //   239: astore_3
    //   240: goto +33 -> 273
    //   243: aconst_null
    //   244: astore_0
    //   245: ldc 60
    //   247: ldc 115
    //   249: invokestatic 67	com/huawei/hianalytics/g/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: bipush 7
    //   254: aload_2
    //   255: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   258: bipush 8
    //   260: aload_0
    //   261: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   264: goto -240 -> 24
    //   267: astore 4
    //   269: aload_2
    //   270: astore_3
    //   271: aload_0
    //   272: astore_2
    //   273: bipush 7
    //   275: aload_3
    //   276: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   279: bipush 8
    //   281: aload_2
    //   282: invokestatic 72	com/huawei/hianalytics/log/e/d:a	(ILjava/io/Closeable;)V
    //   285: aload 4
    //   287: athrow
    //   288: iconst_m1
    //   289: ireturn
    //   290: ldc 60
    //   292: ldc 117
    //   294: invokestatic 67	com/huawei/hianalytics/g/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: iconst_m1
    //   298: ireturn
    //   299: astore_0
    //   300: goto -57 -> 243
    //   303: astore_0
    //   304: goto -77 -> 227
    //   307: astore_2
    //   308: goto -79 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramList	java.util.List<com.huawei.hianalytics.log.f.a.c>
    //   156	51	1	i	int
    //   84	198	2	localObject1	Object
    //   307	1	2	localIOException	java.io.IOException
    //   44	232	3	localObject2	Object
    //   22	13	4	localIterator	java.util.Iterator
    //   208	5	4	localObject3	Object
    //   222	1	4	localList	java.util.List<com.huawei.hianalytics.log.f.a.c>
    //   234	1	4	localObject4	Object
    //   267	19	4	localObject5	Object
    //   67	111	5	localURL	java.net.URL
    //   73	111	6	str	String
    //   79	107	7	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   145	151	208	finally
    //   151	157	208	finally
    //   162	169	208	finally
    //   172	194	208	finally
    //   134	145	218	finally
    //   85	93	234	finally
    //   97	104	234	finally
    //   118	134	234	finally
    //   245	252	267	finally
    //   85	93	299	java/io/IOException
    //   97	104	299	java/io/IOException
    //   118	134	299	java/io/IOException
    //   134	145	303	java/io/IOException
    //   145	151	307	java/io/IOException
    //   151	157	307	java/io/IOException
    //   162	169	307	java/io/IOException
    //   172	194	307	java/io/IOException
  }
  
  private static File a(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {
      return null;
    }
    return paramString[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */