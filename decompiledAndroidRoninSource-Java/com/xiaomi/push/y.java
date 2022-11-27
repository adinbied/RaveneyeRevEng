package com.xiaomi.push;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.util.zip.GZIPOutputStream;

public class y
{
  public static final String[] a = { "jpg", "png", "bmp", "gif", "webp" };
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 28	java/io/StringWriter
    //   3: dup
    //   4: invokespecial 31	java/io/StringWriter:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_2
    //   11: new 33	java/io/InputStreamReader
    //   14: dup
    //   15: new 35	java/io/BufferedInputStream
    //   18: dup
    //   19: new 37	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 40	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: invokespecial 44	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_2
    //   36: sipush 2048
    //   39: newarray <illegal type>
    //   41: astore 4
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 48	java/io/InputStreamReader:read	([C)I
    //   51: istore_1
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +17 -> 71
    //   57: aload_3
    //   58: astore_2
    //   59: aload 5
    //   61: aload 4
    //   63: iconst_0
    //   64: iload_1
    //   65: invokevirtual 52	java/io/StringWriter:write	([CII)V
    //   68: goto -25 -> 43
    //   71: aload_3
    //   72: astore_2
    //   73: aload 5
    //   75: invokevirtual 56	java/io/StringWriter:toString	()Ljava/lang/String;
    //   78: astore 4
    //   80: aload_3
    //   81: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   84: aload 5
    //   86: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   89: aload 4
    //   91: areturn
    //   92: astore 4
    //   94: goto +11 -> 105
    //   97: astore_0
    //   98: goto +85 -> 183
    //   101: astore 4
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_3
    //   106: astore_2
    //   107: new 61	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   114: astore 6
    //   116: aload_3
    //   117: astore_2
    //   118: aload 6
    //   120: ldc 64
    //   122: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_3
    //   127: astore_2
    //   128: aload 6
    //   130: aload_0
    //   131: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   134: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_3
    //   139: astore_2
    //   140: aload 6
    //   142: ldc 75
    //   144: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: astore_2
    //   150: aload 6
    //   152: aload 4
    //   154: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_3
    //   162: astore_2
    //   163: aload 6
    //   165: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   171: aload_3
    //   172: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   175: aload 5
    //   177: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: aload_2
    //   184: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   187: aload 5
    //   189: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   192: aload_0
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramFile	File
    //   51	14	1	i	int
    //   10	174	2	localObject1	Object
    //   33	139	3	localInputStreamReader	java.io.InputStreamReader
    //   41	49	4	localObject2	Object
    //   92	1	4	localIOException1	java.io.IOException
    //   101	52	4	localIOException2	java.io.IOException
    //   7	181	5	localStringWriter	java.io.StringWriter
    //   114	50	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	43	92	java/io/IOException
    //   45	52	92	java/io/IOException
    //   59	68	92	java/io/IOException
    //   73	80	92	java/io/IOException
    //   11	34	97	finally
    //   11	34	101	java/io/IOException
    //   36	43	182	finally
    //   45	52	182	finally
    //   59	68	182	finally
    //   73	80	182	finally
    //   107	116	182	finally
    //   118	126	182	finally
    //   128	138	182	finally
    //   140	148	182	finally
    //   150	161	182	finally
    //   163	171	182	finally
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = 0;
      while (i < arrayOfFile.length)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    if (paramFile.exists()) {
      paramFile.delete();
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: new 113	java/util/zip/ZipOutputStream
    //   10: dup
    //   11: new 115	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: iconst_0
    //   17: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   20: invokespecial 121	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_0
    //   24: aload_0
    //   25: aload_1
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokestatic 124	com/xiaomi/push/y:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   31: aload_0
    //   32: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: goto +59 -> 100
    //   44: astore_1
    //   45: goto +13 -> 58
    //   48: goto +58 -> 106
    //   51: astore_0
    //   52: goto +48 -> 100
    //   55: astore_1
    //   56: aload_3
    //   57: astore_0
    //   58: aload_0
    //   59: astore_2
    //   60: new 61	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   67: astore_3
    //   68: aload_0
    //   69: astore_2
    //   70: aload_3
    //   71: ldc 126
    //   73: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: astore_2
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: astore_2
    //   90: aload_3
    //   91: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 128	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   97: goto +9 -> 106
    //   100: aload_2
    //   101: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   104: aload_0
    //   105: athrow
    //   106: aload_0
    //   107: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   110: return
    //   111: astore_0
    //   112: aload 4
    //   114: astore_0
    //   115: goto -9 -> 106
    //   118: astore_1
    //   119: goto -71 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramFile1	File
    //   0	122	1	paramFile2	File
    //   6	95	2	localFile	File
    //   1	90	3	localStringBuilder	StringBuilder
    //   3	110	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	31	36	finally
    //   24	31	44	java/io/IOException
    //   7	24	51	finally
    //   60	68	51	finally
    //   70	77	51	finally
    //   79	88	51	finally
    //   90	97	51	finally
    //   7	24	55	java/io/IOException
    //   7	24	111	java/io/FileNotFoundException
    //   24	31	118	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 105	java/io/File:exists	()Z
    //   4: ifne +42 -> 46
    //   7: new 61	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   14: astore_2
    //   15: aload_2
    //   16: ldc -125
    //   18: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 135	java/io/File:getParentFile	()Ljava/io/File;
    //   42: invokevirtual 138	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aconst_null
    //   47: astore 4
    //   49: aconst_null
    //   50: astore_2
    //   51: new 140	java/io/BufferedWriter
    //   54: dup
    //   55: new 142	java/io/OutputStreamWriter
    //   58: dup
    //   59: new 115	java/io/FileOutputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 144	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   70: invokespecial 147	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   73: astore_3
    //   74: aload_3
    //   75: aload_1
    //   76: invokevirtual 149	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   79: aload_3
    //   80: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   83: return
    //   84: astore_0
    //   85: aload_3
    //   86: astore_2
    //   87: goto +89 -> 176
    //   90: astore_2
    //   91: aload_3
    //   92: astore_1
    //   93: aload_2
    //   94: astore_3
    //   95: goto +11 -> 106
    //   98: astore_0
    //   99: goto +77 -> 176
    //   102: astore_3
    //   103: aload 4
    //   105: astore_1
    //   106: aload_1
    //   107: astore_2
    //   108: new 61	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload_1
    //   118: astore_2
    //   119: aload 4
    //   121: ldc -105
    //   123: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_1
    //   128: astore_2
    //   129: aload 4
    //   131: aload_0
    //   132: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_1
    //   140: astore_2
    //   141: aload 4
    //   143: ldc 75
    //   145: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: astore_2
    //   151: aload 4
    //   153: aload_3
    //   154: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: astore_2
    //   163: aload 4
    //   165: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   171: aload_1
    //   172: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   175: return
    //   176: aload_2
    //   177: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   180: aload_0
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramFile	File
    //   0	182	1	paramString	String
    //   14	73	2	localObject1	Object
    //   90	4	2	localIOException1	java.io.IOException
    //   107	70	2	str	String
    //   73	22	3	localObject2	Object
    //   102	52	3	localIOException2	java.io.IOException
    //   47	117	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   74	79	84	finally
    //   74	79	90	java/io/IOException
    //   51	74	98	finally
    //   108	117	98	finally
    //   119	127	98	finally
    //   129	139	98	finally
    //   141	149	98	finally
    //   151	161	98	finally
    //   163	171	98	finally
    //   51	74	102	java/io/IOException
  }
  
  /* Error */
  public static void a(java.util.zip.ZipOutputStream paramZipOutputStream, File paramFile, String paramString, java.io.FileFilter paramFileFilter)
  {
    // Byte code:
    //   0: ldc -103
    //   2: astore 13
    //   4: aload_2
    //   5: astore 9
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc -103
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 12
    //   21: aconst_null
    //   22: astore 11
    //   24: aload 11
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 96	java/io/File:isDirectory	()Z
    //   31: istore 7
    //   33: iconst_0
    //   34: istore 5
    //   36: iload 7
    //   38: ifeq +354 -> 392
    //   41: aload_3
    //   42: ifnull +16 -> 58
    //   45: aload 11
    //   47: astore_2
    //   48: aload_1
    //   49: aload_3
    //   50: invokevirtual 156	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   53: astore 8
    //   55: goto +12 -> 67
    //   58: aload 11
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 100	java/io/File:listFiles	()[Ljava/io/File;
    //   65: astore 8
    //   67: aload 11
    //   69: astore_2
    //   70: new 61	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   77: astore 14
    //   79: aload 11
    //   81: astore_2
    //   82: aload 14
    //   84: aload 9
    //   86: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 11
    //   92: astore_2
    //   93: aload 14
    //   95: getstatic 160	java/io/File:separator	Ljava/lang/String;
    //   98: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 11
    //   104: astore_2
    //   105: aload_0
    //   106: new 162	java/util/zip/ZipEntry
    //   109: dup
    //   110: aload 14
    //   112: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 164	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   118: invokevirtual 168	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   121: aload 11
    //   123: astore_2
    //   124: aload 9
    //   126: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +10 -> 139
    //   132: aload 13
    //   134: astore 9
    //   136: goto +479 -> 615
    //   139: aload 11
    //   141: astore_2
    //   142: new 61	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   149: astore 13
    //   151: aload 11
    //   153: astore_2
    //   154: aload 13
    //   156: aload 9
    //   158: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 11
    //   164: astore_2
    //   165: aload 13
    //   167: getstatic 160	java/io/File:separator	Ljava/lang/String;
    //   170: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 11
    //   176: astore_2
    //   177: aload 13
    //   179: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore 9
    //   184: goto +431 -> 615
    //   187: aload 11
    //   189: astore_2
    //   190: iload 4
    //   192: aload 8
    //   194: arraylength
    //   195: if_icmpge +74 -> 269
    //   198: aload 8
    //   200: iload 4
    //   202: aaload
    //   203: astore 13
    //   205: aload 11
    //   207: astore_2
    //   208: new 61	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   215: astore 14
    //   217: aload 11
    //   219: astore_2
    //   220: aload 14
    //   222: aload 9
    //   224: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 11
    //   230: astore_2
    //   231: aload 14
    //   233: aload 8
    //   235: iload 4
    //   237: aaload
    //   238: invokevirtual 177	java/io/File:getName	()Ljava/lang/String;
    //   241: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 11
    //   247: astore_2
    //   248: aload_0
    //   249: aload 13
    //   251: aload 14
    //   253: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aconst_null
    //   257: invokestatic 124	com/xiaomi/push/y:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   260: iload 4
    //   262: iconst_1
    //   263: iadd
    //   264: istore 4
    //   266: goto -79 -> 187
    //   269: aload 11
    //   271: astore_2
    //   272: aload_1
    //   273: new 179	com/xiaomi/push/z
    //   276: dup
    //   277: invokespecial 180	com/xiaomi/push/z:<init>	()V
    //   280: invokevirtual 156	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   283: astore 8
    //   285: aload 12
    //   287: astore_1
    //   288: aload 8
    //   290: ifnull +314 -> 604
    //   293: aload 11
    //   295: astore_2
    //   296: aload 8
    //   298: arraylength
    //   299: istore 6
    //   301: iload 5
    //   303: istore 4
    //   305: aload 12
    //   307: astore_1
    //   308: iload 4
    //   310: iload 6
    //   312: if_icmpge +292 -> 604
    //   315: aload 8
    //   317: iload 4
    //   319: aaload
    //   320: astore_1
    //   321: aload 11
    //   323: astore_2
    //   324: new 61	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   331: astore 13
    //   333: aload 11
    //   335: astore_2
    //   336: aload 13
    //   338: aload 9
    //   340: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 11
    //   346: astore_2
    //   347: aload 13
    //   349: getstatic 160	java/io/File:separator	Ljava/lang/String;
    //   352: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 11
    //   358: astore_2
    //   359: aload 13
    //   361: aload_1
    //   362: invokevirtual 177	java/io/File:getName	()Ljava/lang/String;
    //   365: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 11
    //   371: astore_2
    //   372: aload_0
    //   373: aload_1
    //   374: aload 13
    //   376: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: aload_3
    //   380: invokestatic 124	com/xiaomi/push/y:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -84 -> 305
    //   392: aload 11
    //   394: astore_2
    //   395: aload 9
    //   397: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   400: ifne +27 -> 427
    //   403: aload 11
    //   405: astore_2
    //   406: new 162	java/util/zip/ZipEntry
    //   409: dup
    //   410: aload 9
    //   412: invokespecial 164	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   415: astore_3
    //   416: aload 11
    //   418: astore_2
    //   419: aload_0
    //   420: aload_3
    //   421: invokevirtual 168	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   424: goto +72 -> 496
    //   427: aload 11
    //   429: astore_2
    //   430: new 182	java/util/Date
    //   433: dup
    //   434: invokespecial 183	java/util/Date:<init>	()V
    //   437: astore_3
    //   438: aload 11
    //   440: astore_2
    //   441: new 61	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   448: astore 8
    //   450: aload 11
    //   452: astore_2
    //   453: aload 8
    //   455: aload_3
    //   456: invokevirtual 187	java/util/Date:getTime	()J
    //   459: invokestatic 191	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   462: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 11
    //   468: astore_2
    //   469: aload 8
    //   471: ldc -63
    //   473: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 11
    //   479: astore_2
    //   480: new 162	java/util/zip/ZipEntry
    //   483: dup
    //   484: aload 8
    //   486: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokespecial 164	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   492: astore_3
    //   493: goto -77 -> 416
    //   496: aload 11
    //   498: astore_2
    //   499: new 37	java/io/FileInputStream
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 40	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   507: astore_1
    //   508: sipush 1024
    //   511: newarray <illegal type>
    //   513: astore_2
    //   514: aload_1
    //   515: aload_2
    //   516: invokevirtual 196	java/io/FileInputStream:read	([B)I
    //   519: istore 4
    //   521: iload 4
    //   523: iconst_m1
    //   524: if_icmpeq +14 -> 538
    //   527: aload_0
    //   528: aload_2
    //   529: iconst_0
    //   530: iload 4
    //   532: invokevirtual 199	java/util/zip/ZipOutputStream:write	([BII)V
    //   535: goto -21 -> 514
    //   538: goto +66 -> 604
    //   541: astore_0
    //   542: aload_1
    //   543: astore_2
    //   544: goto +65 -> 609
    //   547: astore_2
    //   548: aload_1
    //   549: astore_0
    //   550: aload_2
    //   551: astore_1
    //   552: goto +11 -> 563
    //   555: astore_0
    //   556: goto +53 -> 609
    //   559: astore_1
    //   560: aload 10
    //   562: astore_0
    //   563: aload_0
    //   564: astore_2
    //   565: new 61	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   572: astore_3
    //   573: aload_0
    //   574: astore_2
    //   575: aload_3
    //   576: ldc -55
    //   578: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload_0
    //   583: astore_2
    //   584: aload_3
    //   585: aload_1
    //   586: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   589: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_0
    //   594: astore_2
    //   595: aload_3
    //   596: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 205	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   602: aload_0
    //   603: astore_1
    //   604: aload_1
    //   605: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   608: return
    //   609: aload_2
    //   610: invokestatic 59	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   613: aload_0
    //   614: athrow
    //   615: iconst_0
    //   616: istore 4
    //   618: goto -431 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	621	1	paramFile	File
    //   0	621	2	paramString	String
    //   0	621	3	paramFileFilter	java.io.FileFilter
    //   190	427	4	i	int
    //   34	268	5	j	int
    //   299	14	6	k	int
    //   31	6	7	bool	boolean
    //   53	432	8	localObject1	Object
    //   5	406	9	localObject2	Object
    //   16	545	10	localObject3	Object
    //   22	475	11	localObject4	Object
    //   19	287	12	localObject5	Object
    //   2	373	13	localObject6	Object
    //   77	175	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   508	514	541	finally
    //   514	521	541	finally
    //   527	535	541	finally
    //   508	514	547	java/io/IOException
    //   514	521	547	java/io/IOException
    //   527	535	547	java/io/IOException
    //   27	33	555	finally
    //   48	55	555	finally
    //   61	67	555	finally
    //   70	79	555	finally
    //   82	90	555	finally
    //   93	102	555	finally
    //   105	121	555	finally
    //   124	132	555	finally
    //   142	151	555	finally
    //   154	162	555	finally
    //   165	174	555	finally
    //   177	184	555	finally
    //   190	198	555	finally
    //   208	217	555	finally
    //   220	228	555	finally
    //   231	245	555	finally
    //   248	260	555	finally
    //   272	285	555	finally
    //   296	301	555	finally
    //   324	333	555	finally
    //   336	344	555	finally
    //   347	356	555	finally
    //   359	369	555	finally
    //   372	383	555	finally
    //   395	403	555	finally
    //   406	416	555	finally
    //   419	424	555	finally
    //   430	438	555	finally
    //   441	450	555	finally
    //   453	466	555	finally
    //   469	477	555	finally
    //   480	493	555	finally
    //   499	508	555	finally
    //   565	573	555	finally
    //   575	582	555	finally
    //   584	593	555	finally
    //   595	602	555	finally
    //   27	33	559	java/io/IOException
    //   48	55	559	java/io/IOException
    //   61	67	559	java/io/IOException
    //   70	79	559	java/io/IOException
    //   82	90	559	java/io/IOException
    //   93	102	559	java/io/IOException
    //   105	121	559	java/io/IOException
    //   124	132	559	java/io/IOException
    //   142	151	559	java/io/IOException
    //   154	162	559	java/io/IOException
    //   165	174	559	java/io/IOException
    //   177	184	559	java/io/IOException
    //   190	198	559	java/io/IOException
    //   208	217	559	java/io/IOException
    //   220	228	559	java/io/IOException
    //   231	245	559	java/io/IOException
    //   248	260	559	java/io/IOException
    //   272	285	559	java/io/IOException
    //   296	301	559	java/io/IOException
    //   324	333	559	java/io/IOException
    //   336	344	559	java/io/IOException
    //   347	356	559	java/io/IOException
    //   359	369	559	java/io/IOException
    //   372	383	559	java/io/IOException
    //   395	403	559	java/io/IOException
    //   406	416	559	java/io/IOException
    //   419	424	559	java/io/IOException
    //   430	438	559	java/io/IOException
    //   441	450	559	java/io/IOException
    //   453	466	559	java/io/IOException
    //   469	477	559	java/io/IOException
    //   480	493	559	java/io/IOException
    //   499	508	559	java/io/IOException
  }
  
  public static boolean a(File paramFile)
  {
    try
    {
      if (paramFile.isDirectory()) {
        return false;
      }
      if (paramFile.exists()) {
        return true;
      }
      File localFile = paramFile.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        return false;
      }
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    finally
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      localObject = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return (byte[])localObject;
    }
    catch (Exception localException) {}
    return paramArrayOfByte;
  }
  
  /* Error */
  public static void b(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: aload_1
    //   5: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   8: invokevirtual 238	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aconst_null
    //   16: astore 4
    //   18: new 37	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 40	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_3
    //   27: new 115	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_1
    //   36: sipush 1024
    //   39: newarray <illegal type>
    //   41: astore_0
    //   42: aload_3
    //   43: aload_0
    //   44: invokevirtual 241	java/io/InputStream:read	([B)I
    //   47: istore_2
    //   48: iload_2
    //   49: iflt +13 -> 62
    //   52: aload_1
    //   53: aload_0
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 244	java/io/OutputStream:write	([BII)V
    //   59: goto -17 -> 42
    //   62: aload_3
    //   63: invokevirtual 245	java/io/InputStream:close	()V
    //   66: aload_1
    //   67: invokevirtual 246	java/io/OutputStream:close	()V
    //   70: return
    //   71: astore_0
    //   72: goto +6 -> 78
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_1
    //   78: goto +9 -> 87
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_1
    //   84: aload 4
    //   86: astore_3
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 245	java/io/InputStream:close	()V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 246	java/io/OutputStream:close	()V
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile1	File
    //   0	105	1	paramFile2	File
    //   47	9	2	i	int
    //   26	66	3	localObject1	Object
    //   16	69	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	71	finally
    //   42	48	71	finally
    //   52	59	71	finally
    //   27	36	75	finally
    //   18	27	81	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */