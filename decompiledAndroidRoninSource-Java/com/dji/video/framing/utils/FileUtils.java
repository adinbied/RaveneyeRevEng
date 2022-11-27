package com.dji.video.framing.utils;

public class FileUtils
{
  private static final String TAG = "FileUtils";
  
  /* Error */
  public static java.io.File saveBitmap(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 28	java/io/File:exists	()Z
    //   15: ifeq +9 -> 24
    //   18: aload 5
    //   20: invokevirtual 31	java/io/File:delete	()Z
    //   23: pop
    //   24: aconst_null
    //   25: astore_3
    //   26: aconst_null
    //   27: astore 4
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload 5
    //   35: invokevirtual 34	java/io/File:createNewFile	()Z
    //   38: pop
    //   39: aload_2
    //   40: astore_1
    //   41: new 36	java/io/FileOutputStream
    //   44: dup
    //   45: aload 5
    //   47: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_2
    //   51: aload_0
    //   52: getstatic 45	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   55: bipush 100
    //   57: aload_2
    //   58: invokevirtual 51	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   61: pop
    //   62: aload_2
    //   63: invokevirtual 54	java/io/FileOutputStream:flush	()V
    //   66: aload_2
    //   67: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   70: aload 5
    //   72: areturn
    //   73: astore_1
    //   74: invokestatic 63	dji/log/DJILogHelper:getInstance	()Ldji/log/DJILogHelper;
    //   77: astore_2
    //   78: new 65	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   85: astore_0
    //   86: aload_0
    //   87: ldc 68
    //   89: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc 8
    //   102: aload_0
    //   103: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokevirtual 83	dji/log/DJILogHelper:LOGE	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 5
    //   111: areturn
    //   112: astore_0
    //   113: aload_2
    //   114: astore_1
    //   115: goto +185 -> 300
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: aload_1
    //   122: astore_2
    //   123: goto +18 -> 141
    //   126: astore_1
    //   127: aload_2
    //   128: astore_0
    //   129: aload_1
    //   130: astore_2
    //   131: goto +90 -> 221
    //   134: astore_0
    //   135: goto +165 -> 300
    //   138: astore_2
    //   139: aload_3
    //   140: astore_0
    //   141: aload_0
    //   142: astore_1
    //   143: invokestatic 63	dji/log/DJILogHelper:getInstance	()Ldji/log/DJILogHelper;
    //   146: astore_3
    //   147: aload_0
    //   148: astore_1
    //   149: new 65	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   156: astore 4
    //   158: aload_0
    //   159: astore_1
    //   160: aload 4
    //   162: ldc 85
    //   164: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: astore_1
    //   170: aload 4
    //   172: aload_2
    //   173: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: astore_1
    //   179: aload_3
    //   180: ldc 8
    //   182: aload 4
    //   184: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 83	dji/log/DJILogHelper:LOGE	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_0
    //   191: ifnull +106 -> 297
    //   194: aload_0
    //   195: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   198: aload 5
    //   200: areturn
    //   201: astore_1
    //   202: invokestatic 63	dji/log/DJILogHelper:getInstance	()Ldji/log/DJILogHelper;
    //   205: astore_2
    //   206: new 65	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   213: astore_0
    //   214: goto -128 -> 86
    //   217: astore_2
    //   218: aload 4
    //   220: astore_0
    //   221: aload_0
    //   222: astore_1
    //   223: invokestatic 63	dji/log/DJILogHelper:getInstance	()Ldji/log/DJILogHelper;
    //   226: astore_3
    //   227: aload_0
    //   228: astore_1
    //   229: new 65	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   236: astore 4
    //   238: aload_0
    //   239: astore_1
    //   240: aload 4
    //   242: ldc 85
    //   244: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: astore_1
    //   250: aload 4
    //   252: aload_2
    //   253: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_0
    //   258: astore_1
    //   259: aload_3
    //   260: ldc 8
    //   262: aload 4
    //   264: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 83	dji/log/DJILogHelper:LOGE	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: ifnull +26 -> 297
    //   274: aload_0
    //   275: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   278: aload 5
    //   280: areturn
    //   281: astore_1
    //   282: invokestatic 63	dji/log/DJILogHelper:getInstance	()Ldji/log/DJILogHelper;
    //   285: astore_2
    //   286: new 65	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   293: astore_0
    //   294: goto -208 -> 86
    //   297: aload 5
    //   299: areturn
    //   300: aload_1
    //   301: ifnull +46 -> 347
    //   304: aload_1
    //   305: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   308: goto +39 -> 347
    //   311: astore_1
    //   312: invokestatic 63	dji/log/DJILogHelper:getInstance	()Ldji/log/DJILogHelper;
    //   315: astore_2
    //   316: new 65	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   323: astore_3
    //   324: aload_3
    //   325: ldc 68
    //   327: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_3
    //   332: aload_1
    //   333: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_2
    //   338: ldc 8
    //   340: aload_3
    //   341: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 83	dji/log/DJILogHelper:LOGE	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramBitmap	android.graphics.Bitmap
    //   0	349	1	paramString	String
    //   30	101	2	localObject1	Object
    //   138	35	2	localIOException	java.io.IOException
    //   205	1	2	localDJILogHelper1	dji.log.DJILogHelper
    //   217	36	2	localFileNotFoundException	java.io.FileNotFoundException
    //   285	53	2	localDJILogHelper2	dji.log.DJILogHelper
    //   25	316	3	localObject2	Object
    //   27	236	4	localStringBuilder	StringBuilder
    //   8	290	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/io/IOException
    //   51	66	112	finally
    //   51	66	118	java/io/IOException
    //   51	66	126	java/io/FileNotFoundException
    //   33	39	134	finally
    //   41	51	134	finally
    //   143	147	134	finally
    //   149	158	134	finally
    //   160	168	134	finally
    //   170	177	134	finally
    //   179	190	134	finally
    //   223	227	134	finally
    //   229	238	134	finally
    //   240	248	134	finally
    //   250	257	134	finally
    //   259	270	134	finally
    //   33	39	138	java/io/IOException
    //   41	51	138	java/io/IOException
    //   194	198	201	java/io/IOException
    //   33	39	217	java/io/FileNotFoundException
    //   41	51	217	java/io/FileNotFoundException
    //   274	278	281	java/io/IOException
    //   304	308	311	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */