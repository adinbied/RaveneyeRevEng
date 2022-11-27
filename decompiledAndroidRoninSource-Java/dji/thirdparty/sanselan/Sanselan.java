package dji.thirdparty.sanselan;

import dji.thirdparty.sanselan.common.IImageMetadata;
import dji.thirdparty.sanselan.common.byteSources.ByteSource;
import dji.thirdparty.sanselan.common.byteSources.ByteSourceArray;
import dji.thirdparty.sanselan.common.byteSources.ByteSourceFile;
import dji.thirdparty.sanselan.common.byteSources.ByteSourceInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract class Sanselan
  implements SanselanConstants
{
  private static final ImageParser getImageParser(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    Object localObject = guessFormat(paramByteSource);
    boolean bool = ((ImageFormat)localObject).equals(ImageFormat.IMAGE_FORMAT_UNKNOWN);
    int j = 0;
    ImageParser[] arrayOfImageParser;
    int i;
    if (!bool)
    {
      arrayOfImageParser = ImageParser.getAllImageParsers();
      i = 0;
      while (i < arrayOfImageParser.length)
      {
        ImageParser localImageParser = arrayOfImageParser[i];
        if (localImageParser.canAcceptType((ImageFormat)localObject)) {
          return localImageParser;
        }
        i += 1;
      }
    }
    paramByteSource = paramByteSource.getFilename();
    if (paramByteSource != null)
    {
      localObject = ImageParser.getAllImageParsers();
      i = j;
      while (i < localObject.length)
      {
        arrayOfImageParser = localObject[i];
        if (arrayOfImageParser.canAcceptExtension(paramByteSource)) {
          return arrayOfImageParser;
        }
        i += 1;
      }
    }
    throw new ImageReadException("Can't parse this format.");
  }
  
  private static IImageMetadata getMetadata(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return getImageParser(paramByteSource).getMetadata(paramByteSource, paramMap);
  }
  
  public static IImageMetadata getMetadata(File paramFile)
    throws ImageReadException, IOException
  {
    return getMetadata(paramFile, null);
  }
  
  public static IImageMetadata getMetadata(File paramFile, Map paramMap)
    throws ImageReadException, IOException
  {
    return getMetadata(new ByteSourceFile(paramFile), paramMap);
  }
  
  public static IImageMetadata getMetadata(InputStream paramInputStream, String paramString)
    throws ImageReadException, IOException
  {
    return getMetadata(paramInputStream, paramString, null);
  }
  
  public static IImageMetadata getMetadata(InputStream paramInputStream, String paramString, Map paramMap)
    throws ImageReadException, IOException
  {
    return getMetadata(new ByteSourceInputStream(paramInputStream, paramString), paramMap);
  }
  
  public static IImageMetadata getMetadata(byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    return getMetadata(paramArrayOfByte, null);
  }
  
  public static IImageMetadata getMetadata(byte[] paramArrayOfByte, Map paramMap)
    throws ImageReadException, IOException
  {
    return getMetadata(new ByteSourceArray(paramArrayOfByte), paramMap);
  }
  
  /* Error */
  public static ImageFormat guessFormat(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 95	dji/thirdparty/sanselan/common/byteSources/ByteSource:getInputStream	()Ljava/io/InputStream;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 101	java/io/InputStream:read	()I
    //   9: istore_2
    //   10: aload_3
    //   11: invokevirtual 101	java/io/InputStream:read	()I
    //   14: istore_1
    //   15: iload_2
    //   16: iflt +554 -> 570
    //   19: iload_1
    //   20: iflt +550 -> 570
    //   23: iload_2
    //   24: sipush 255
    //   27: iand
    //   28: istore_2
    //   29: iload_1
    //   30: sipush 255
    //   33: iand
    //   34: istore_1
    //   35: iload_2
    //   36: bipush 71
    //   38: if_icmpne +30 -> 68
    //   41: iload_1
    //   42: bipush 73
    //   44: if_icmpne +24 -> 68
    //   47: getstatic 104	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_GIF	Ldji/thirdparty/sanselan/ImageFormat;
    //   50: astore_0
    //   51: aload_3
    //   52: ifnull +14 -> 66
    //   55: aload_3
    //   56: invokevirtual 107	java/io/InputStream:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: astore_3
    //   62: aload_3
    //   63: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   66: aload_0
    //   67: areturn
    //   68: iload_2
    //   69: sipush 137
    //   72: if_icmpne +30 -> 102
    //   75: iload_1
    //   76: bipush 80
    //   78: if_icmpne +24 -> 102
    //   81: getstatic 116	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PNG	Ldji/thirdparty/sanselan/ImageFormat;
    //   84: astore_0
    //   85: aload_3
    //   86: ifnull +14 -> 100
    //   89: aload_3
    //   90: invokevirtual 107	java/io/InputStream:close	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: areturn
    //   102: iload_2
    //   103: sipush 255
    //   106: if_icmpne +31 -> 137
    //   109: iload_1
    //   110: sipush 216
    //   113: if_icmpne +24 -> 137
    //   116: getstatic 119	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_JPEG	Ldji/thirdparty/sanselan/ImageFormat;
    //   119: astore_0
    //   120: aload_3
    //   121: ifnull +14 -> 135
    //   124: aload_3
    //   125: invokevirtual 107	java/io/InputStream:close	()V
    //   128: aload_0
    //   129: areturn
    //   130: astore_3
    //   131: aload_3
    //   132: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   135: aload_0
    //   136: areturn
    //   137: iload_2
    //   138: bipush 66
    //   140: if_icmpne +30 -> 170
    //   143: iload_1
    //   144: bipush 77
    //   146: if_icmpne +24 -> 170
    //   149: getstatic 122	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_BMP	Ldji/thirdparty/sanselan/ImageFormat;
    //   152: astore_0
    //   153: aload_3
    //   154: ifnull +14 -> 168
    //   157: aload_3
    //   158: invokevirtual 107	java/io/InputStream:close	()V
    //   161: aload_0
    //   162: areturn
    //   163: astore_3
    //   164: aload_3
    //   165: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   168: aload_0
    //   169: areturn
    //   170: iload_2
    //   171: bipush 77
    //   173: if_icmpne +30 -> 203
    //   176: iload_1
    //   177: bipush 77
    //   179: if_icmpne +24 -> 203
    //   182: getstatic 125	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_TIFF	Ldji/thirdparty/sanselan/ImageFormat;
    //   185: astore_0
    //   186: aload_3
    //   187: ifnull +14 -> 201
    //   190: aload_3
    //   191: invokevirtual 107	java/io/InputStream:close	()V
    //   194: aload_0
    //   195: areturn
    //   196: astore_3
    //   197: aload_3
    //   198: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: areturn
    //   203: iload_2
    //   204: bipush 73
    //   206: if_icmpne +30 -> 236
    //   209: iload_1
    //   210: bipush 73
    //   212: if_icmpne +24 -> 236
    //   215: getstatic 125	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_TIFF	Ldji/thirdparty/sanselan/ImageFormat;
    //   218: astore_0
    //   219: aload_3
    //   220: ifnull +14 -> 234
    //   223: aload_3
    //   224: invokevirtual 107	java/io/InputStream:close	()V
    //   227: aload_0
    //   228: areturn
    //   229: astore_3
    //   230: aload_3
    //   231: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   234: aload_0
    //   235: areturn
    //   236: iload_2
    //   237: bipush 56
    //   239: if_icmpne +30 -> 269
    //   242: iload_1
    //   243: bipush 66
    //   245: if_icmpne +24 -> 269
    //   248: getstatic 128	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PSD	Ldji/thirdparty/sanselan/ImageFormat;
    //   251: astore_0
    //   252: aload_3
    //   253: ifnull +14 -> 267
    //   256: aload_3
    //   257: invokevirtual 107	java/io/InputStream:close	()V
    //   260: aload_0
    //   261: areturn
    //   262: astore_3
    //   263: aload_3
    //   264: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   267: aload_0
    //   268: areturn
    //   269: iload_2
    //   270: bipush 80
    //   272: if_icmpne +30 -> 302
    //   275: iload_1
    //   276: bipush 49
    //   278: if_icmpne +24 -> 302
    //   281: getstatic 131	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PBM	Ldji/thirdparty/sanselan/ImageFormat;
    //   284: astore_0
    //   285: aload_3
    //   286: ifnull +14 -> 300
    //   289: aload_3
    //   290: invokevirtual 107	java/io/InputStream:close	()V
    //   293: aload_0
    //   294: areturn
    //   295: astore_3
    //   296: aload_3
    //   297: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   300: aload_0
    //   301: areturn
    //   302: iload_2
    //   303: bipush 80
    //   305: if_icmpne +30 -> 335
    //   308: iload_1
    //   309: bipush 52
    //   311: if_icmpne +24 -> 335
    //   314: getstatic 131	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PBM	Ldji/thirdparty/sanselan/ImageFormat;
    //   317: astore_0
    //   318: aload_3
    //   319: ifnull +14 -> 333
    //   322: aload_3
    //   323: invokevirtual 107	java/io/InputStream:close	()V
    //   326: aload_0
    //   327: areturn
    //   328: astore_3
    //   329: aload_3
    //   330: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   333: aload_0
    //   334: areturn
    //   335: iload_2
    //   336: bipush 80
    //   338: if_icmpne +30 -> 368
    //   341: iload_1
    //   342: bipush 50
    //   344: if_icmpne +24 -> 368
    //   347: getstatic 134	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PGM	Ldji/thirdparty/sanselan/ImageFormat;
    //   350: astore_0
    //   351: aload_3
    //   352: ifnull +14 -> 366
    //   355: aload_3
    //   356: invokevirtual 107	java/io/InputStream:close	()V
    //   359: aload_0
    //   360: areturn
    //   361: astore_3
    //   362: aload_3
    //   363: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   366: aload_0
    //   367: areturn
    //   368: iload_2
    //   369: bipush 80
    //   371: if_icmpne +30 -> 401
    //   374: iload_1
    //   375: bipush 53
    //   377: if_icmpne +24 -> 401
    //   380: getstatic 134	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PGM	Ldji/thirdparty/sanselan/ImageFormat;
    //   383: astore_0
    //   384: aload_3
    //   385: ifnull +14 -> 399
    //   388: aload_3
    //   389: invokevirtual 107	java/io/InputStream:close	()V
    //   392: aload_0
    //   393: areturn
    //   394: astore_3
    //   395: aload_3
    //   396: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   399: aload_0
    //   400: areturn
    //   401: iload_2
    //   402: bipush 80
    //   404: if_icmpne +30 -> 434
    //   407: iload_1
    //   408: bipush 51
    //   410: if_icmpne +24 -> 434
    //   413: getstatic 137	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PPM	Ldji/thirdparty/sanselan/ImageFormat;
    //   416: astore_0
    //   417: aload_3
    //   418: ifnull +14 -> 432
    //   421: aload_3
    //   422: invokevirtual 107	java/io/InputStream:close	()V
    //   425: aload_0
    //   426: areturn
    //   427: astore_3
    //   428: aload_3
    //   429: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   432: aload_0
    //   433: areturn
    //   434: iload_2
    //   435: bipush 80
    //   437: if_icmpne +30 -> 467
    //   440: iload_1
    //   441: bipush 54
    //   443: if_icmpne +24 -> 467
    //   446: getstatic 137	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_PPM	Ldji/thirdparty/sanselan/ImageFormat;
    //   449: astore_0
    //   450: aload_3
    //   451: ifnull +14 -> 465
    //   454: aload_3
    //   455: invokevirtual 107	java/io/InputStream:close	()V
    //   458: aload_0
    //   459: areturn
    //   460: astore_3
    //   461: aload_3
    //   462: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   465: aload_0
    //   466: areturn
    //   467: iload_2
    //   468: sipush 151
    //   471: if_icmpne +78 -> 549
    //   474: iload_1
    //   475: bipush 74
    //   477: if_icmpne +72 -> 549
    //   480: aload_3
    //   481: invokevirtual 101	java/io/InputStream:read	()I
    //   484: istore_1
    //   485: aload_3
    //   486: invokevirtual 101	java/io/InputStream:read	()I
    //   489: istore_2
    //   490: iload_1
    //   491: iflt +48 -> 539
    //   494: iload_2
    //   495: iflt +44 -> 539
    //   498: iload_1
    //   499: sipush 255
    //   502: iand
    //   503: bipush 66
    //   505: if_icmpne +44 -> 549
    //   508: iload_2
    //   509: sipush 255
    //   512: iand
    //   513: bipush 50
    //   515: if_icmpne +34 -> 549
    //   518: getstatic 140	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_JBIG2	Ldji/thirdparty/sanselan/ImageFormat;
    //   521: astore_0
    //   522: aload_3
    //   523: ifnull +14 -> 537
    //   526: aload_3
    //   527: invokevirtual 107	java/io/InputStream:close	()V
    //   530: aload_0
    //   531: areturn
    //   532: astore_3
    //   533: aload_3
    //   534: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   537: aload_0
    //   538: areturn
    //   539: new 15	dji/thirdparty/sanselan/ImageReadException
    //   542: dup
    //   543: ldc -114
    //   545: invokespecial 56	dji/thirdparty/sanselan/ImageReadException:<init>	(Ljava/lang/String;)V
    //   548: athrow
    //   549: getstatic 27	dji/thirdparty/sanselan/ImageFormat:IMAGE_FORMAT_UNKNOWN	Ldji/thirdparty/sanselan/ImageFormat;
    //   552: astore_0
    //   553: aload_3
    //   554: ifnull +14 -> 568
    //   557: aload_3
    //   558: invokevirtual 107	java/io/InputStream:close	()V
    //   561: aload_0
    //   562: areturn
    //   563: astore_3
    //   564: aload_3
    //   565: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   568: aload_0
    //   569: areturn
    //   570: new 15	dji/thirdparty/sanselan/ImageReadException
    //   573: dup
    //   574: ldc -114
    //   576: invokespecial 56	dji/thirdparty/sanselan/ImageReadException:<init>	(Ljava/lang/String;)V
    //   579: athrow
    //   580: astore_0
    //   581: goto +6 -> 587
    //   584: astore_0
    //   585: aconst_null
    //   586: astore_3
    //   587: aload_3
    //   588: ifnull +15 -> 603
    //   591: aload_3
    //   592: invokevirtual 107	java/io/InputStream:close	()V
    //   595: goto +8 -> 603
    //   598: astore_3
    //   599: aload_3
    //   600: invokestatic 113	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   603: aload_0
    //   604: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	paramByteSource	ByteSource
    //   14	489	1	i	int
    //   9	504	2	j	int
    //   4	52	3	localInputStream	InputStream
    //   61	29	3	localIOException1	IOException
    //   95	30	3	localIOException2	IOException
    //   130	28	3	localIOException3	IOException
    //   163	28	3	localIOException4	IOException
    //   196	28	3	localIOException5	IOException
    //   229	28	3	localIOException6	IOException
    //   262	28	3	localIOException7	IOException
    //   295	28	3	localIOException8	IOException
    //   328	28	3	localIOException9	IOException
    //   361	28	3	localIOException10	IOException
    //   394	28	3	localIOException11	IOException
    //   427	28	3	localIOException12	IOException
    //   460	67	3	localIOException13	IOException
    //   532	26	3	localIOException14	IOException
    //   563	2	3	localIOException15	IOException
    //   586	6	3	localObject	Object
    //   598	2	3	localIOException16	IOException
    // Exception table:
    //   from	to	target	type
    //   55	59	61	java/io/IOException
    //   89	93	95	java/io/IOException
    //   124	128	130	java/io/IOException
    //   157	161	163	java/io/IOException
    //   190	194	196	java/io/IOException
    //   223	227	229	java/io/IOException
    //   256	260	262	java/io/IOException
    //   289	293	295	java/io/IOException
    //   322	326	328	java/io/IOException
    //   355	359	361	java/io/IOException
    //   388	392	394	java/io/IOException
    //   421	425	427	java/io/IOException
    //   454	458	460	java/io/IOException
    //   526	530	532	java/io/IOException
    //   557	561	563	java/io/IOException
    //   5	15	580	finally
    //   47	51	580	finally
    //   81	85	580	finally
    //   116	120	580	finally
    //   149	153	580	finally
    //   182	186	580	finally
    //   215	219	580	finally
    //   248	252	580	finally
    //   281	285	580	finally
    //   314	318	580	finally
    //   347	351	580	finally
    //   380	384	580	finally
    //   413	417	580	finally
    //   446	450	580	finally
    //   480	490	580	finally
    //   518	522	580	finally
    //   539	549	580	finally
    //   549	553	580	finally
    //   570	580	580	finally
    //   0	5	584	finally
    //   591	595	598	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\Sanselan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */