package dji.media.exif.utils;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.Sanselan;
import dji.thirdparty.sanselan.formats.jpeg.JpegImageMetadata;
import dji.thirdparty.sanselan.formats.tiff.TiffContents;
import dji.thirdparty.sanselan.formats.tiff.TiffHeader;
import dji.thirdparty.sanselan.formats.tiff.TiffImageMetadata;
import dji.thirdparty.sanselan.formats.tiff.constants.ExifTagConstants;
import dji.thirdparty.sanselan.formats.tiff.write.TiffOutputDirectory;
import dji.thirdparty.sanselan.formats.tiff.write.TiffOutputSet;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DJIExifTools
{
  /* Error */
  public static boolean copyExifData(File paramFile1, File paramFile2, java.util.List<dji.thirdparty.sanselan.formats.tiff.constants.TagInfo> paramList)
  {
    // Byte code:
    //   0: new 19	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_1
    //   12: invokevirtual 26	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 5
    //   21: ldc 32
    //   23: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 5
    //   29: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 5
    //   34: new 37	android/graphics/BitmapFactory$Options
    //   37: dup
    //   38: invokespecial 38	android/graphics/BitmapFactory$Options:<init>	()V
    //   41: astore 12
    //   43: aload 12
    //   45: iconst_1
    //   46: putfield 42	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_1
    //   50: invokevirtual 26	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: aload 12
    //   55: invokestatic 48	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   58: pop
    //   59: aconst_null
    //   60: astore 9
    //   62: aconst_null
    //   63: astore 10
    //   65: aconst_null
    //   66: astore 11
    //   68: aconst_null
    //   69: astore 6
    //   71: aconst_null
    //   72: astore 8
    //   74: new 22	java/io/File
    //   77: dup
    //   78: aload 5
    //   80: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 5
    //   85: aload 11
    //   87: astore 6
    //   89: aload 5
    //   91: astore 7
    //   93: aload_0
    //   94: bipush 73
    //   96: invokestatic 55	dji/media/exif/utils/DJIExifTools:getSanselanOutputSet	(Ljava/io/File;I)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet;
    //   99: astore_0
    //   100: aload 11
    //   102: astore 6
    //   104: aload 5
    //   106: astore 7
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   113: invokestatic 55	dji/media/exif/utils/DJIExifTools:getSanselanOutputSet	(Ljava/io/File;I)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet;
    //   116: astore 13
    //   118: aload 11
    //   120: astore 6
    //   122: aload 5
    //   124: astore 7
    //   126: aload_0
    //   127: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   130: istore_3
    //   131: aload 11
    //   133: astore 6
    //   135: aload 5
    //   137: astore 7
    //   139: aload 13
    //   141: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   144: istore 4
    //   146: iload_3
    //   147: iload 4
    //   149: if_icmpeq +19 -> 168
    //   152: aload 5
    //   154: invokevirtual 65	java/io/File:exists	()Z
    //   157: ifeq +9 -> 166
    //   160: aload 5
    //   162: invokevirtual 68	java/io/File:delete	()Z
    //   165: pop
    //   166: iconst_0
    //   167: ireturn
    //   168: aload 11
    //   170: astore 6
    //   172: aload 5
    //   174: astore 7
    //   176: aload 13
    //   178: invokevirtual 72	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:getOrCreateExifDirectory	()Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory;
    //   181: pop
    //   182: aload 11
    //   184: astore 6
    //   186: aload 5
    //   188: astore 7
    //   190: aload_0
    //   191: invokevirtual 76	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:getDirectories	()Ljava/util/List;
    //   194: astore 14
    //   196: iconst_0
    //   197: istore_3
    //   198: aload 11
    //   200: astore 6
    //   202: aload 5
    //   204: astore 7
    //   206: iload_3
    //   207: aload 14
    //   209: invokeinterface 82 1 0
    //   214: if_icmpge +254 -> 468
    //   217: aload 11
    //   219: astore 6
    //   221: aload 5
    //   223: astore 7
    //   225: aload 14
    //   227: iload_3
    //   228: invokeinterface 86 2 0
    //   233: checkcast 88	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory
    //   236: astore 16
    //   238: aload 11
    //   240: astore 6
    //   242: aload 5
    //   244: astore 7
    //   246: aload 13
    //   248: aload 16
    //   250: invokestatic 91	dji/media/exif/utils/DJIExifTools:getOrCreateExifDirectory	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet;Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory;)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory;
    //   253: astore 15
    //   255: aload 15
    //   257: ifnonnull +6 -> 263
    //   260: goto +542 -> 802
    //   263: aload 11
    //   265: astore 6
    //   267: aload 5
    //   269: astore 7
    //   271: aload 15
    //   273: getstatic 97	dji/thirdparty/sanselan/formats/tiff/constants/ExifTagConstants:EXIF_TAG_EXIF_IMAGE_WIDTH	Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;
    //   276: aload_0
    //   277: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   280: aload 12
    //   282: getfield 100	android/graphics/BitmapFactory$Options:outWidth	I
    //   285: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: invokestatic 112	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:create	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;ILjava/lang/Number;)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;
    //   291: invokevirtual 116	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:add	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;)V
    //   294: aload 11
    //   296: astore 6
    //   298: aload 5
    //   300: astore 7
    //   302: aload 15
    //   304: getstatic 119	dji/thirdparty/sanselan/formats/tiff/constants/ExifTagConstants:EXIF_TAG_EXIF_IMAGE_LENGTH	Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;
    //   307: aload_0
    //   308: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   311: aload 12
    //   313: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   316: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokestatic 112	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:create	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;ILjava/lang/Number;)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;
    //   322: invokevirtual 116	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:add	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;)V
    //   325: aload 11
    //   327: astore 6
    //   329: aload 5
    //   331: astore 7
    //   333: aload 16
    //   335: invokevirtual 126	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:getFields	()Ljava/util/ArrayList;
    //   338: astore 16
    //   340: iconst_0
    //   341: istore 4
    //   343: aload 11
    //   345: astore 6
    //   347: aload 5
    //   349: astore 7
    //   351: iload 4
    //   353: aload 16
    //   355: invokeinterface 82 1 0
    //   360: if_icmpge +442 -> 802
    //   363: aload 11
    //   365: astore 6
    //   367: aload 5
    //   369: astore 7
    //   371: aload 16
    //   373: iload 4
    //   375: invokeinterface 86 2 0
    //   380: checkcast 108	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField
    //   383: astore 17
    //   385: aload_2
    //   386: ifnull +46 -> 432
    //   389: aload 11
    //   391: astore 6
    //   393: aload 5
    //   395: astore 7
    //   397: aload_2
    //   398: aload 17
    //   400: getfield 129	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:tagInfo	Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;
    //   403: invokeinterface 133 2 0
    //   408: ifeq +24 -> 432
    //   411: aload 11
    //   413: astore 6
    //   415: aload 5
    //   417: astore 7
    //   419: aload 15
    //   421: aload 17
    //   423: getfield 129	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:tagInfo	Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;
    //   426: invokevirtual 137	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:removeField	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;)V
    //   429: goto +364 -> 793
    //   432: aload 11
    //   434: astore 6
    //   436: aload 5
    //   438: astore 7
    //   440: aload 15
    //   442: aload 17
    //   444: getfield 129	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:tagInfo	Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;
    //   447: invokevirtual 137	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:removeField	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;)V
    //   450: aload 11
    //   452: astore 6
    //   454: aload 5
    //   456: astore 7
    //   458: aload 15
    //   460: aload 17
    //   462: invokevirtual 116	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:add	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;)V
    //   465: goto +328 -> 793
    //   468: aload 11
    //   470: astore 6
    //   472: aload 5
    //   474: astore 7
    //   476: new 139	java/io/BufferedOutputStream
    //   479: dup
    //   480: new 141	java/io/FileOutputStream
    //   483: dup
    //   484: aload 5
    //   486: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   489: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   492: astore_0
    //   493: new 149	dji/thirdparty/sanselan/formats/jpeg/exifRewrite/ExifRewriter
    //   496: dup
    //   497: invokespecial 150	dji/thirdparty/sanselan/formats/jpeg/exifRewrite/ExifRewriter:<init>	()V
    //   500: aload_1
    //   501: aload_0
    //   502: aload 13
    //   504: invokevirtual 154	dji/thirdparty/sanselan/formats/jpeg/exifRewrite/ExifRewriter:updateExifMetadataLossless	(Ljava/io/File;Ljava/io/OutputStream;Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet;)V
    //   507: aload_0
    //   508: invokevirtual 159	java/io/OutputStream:close	()V
    //   511: aload_1
    //   512: invokevirtual 68	java/io/File:delete	()Z
    //   515: ifeq +10 -> 525
    //   518: aload 5
    //   520: aload_1
    //   521: invokevirtual 163	java/io/File:renameTo	(Ljava/io/File;)Z
    //   524: pop
    //   525: aload_0
    //   526: invokevirtual 159	java/io/OutputStream:close	()V
    //   529: aload 5
    //   531: invokevirtual 65	java/io/File:exists	()Z
    //   534: ifeq +9 -> 543
    //   537: aload 5
    //   539: invokevirtual 68	java/io/File:delete	()Z
    //   542: pop
    //   543: iconst_1
    //   544: ireturn
    //   545: astore_1
    //   546: aload_0
    //   547: astore 6
    //   549: aload_1
    //   550: astore_0
    //   551: goto +188 -> 739
    //   554: astore_1
    //   555: goto +46 -> 601
    //   558: astore_1
    //   559: goto +87 -> 646
    //   562: astore_1
    //   563: goto +128 -> 691
    //   566: astore_1
    //   567: aload 8
    //   569: astore_0
    //   570: goto +31 -> 601
    //   573: astore_1
    //   574: aload 9
    //   576: astore_0
    //   577: goto +69 -> 646
    //   580: astore_1
    //   581: aload 10
    //   583: astore_0
    //   584: goto +107 -> 691
    //   587: astore_0
    //   588: aconst_null
    //   589: astore 5
    //   591: goto +148 -> 739
    //   594: astore_1
    //   595: aconst_null
    //   596: astore 5
    //   598: aload 8
    //   600: astore_0
    //   601: aload_0
    //   602: astore 6
    //   604: aload 5
    //   606: astore 7
    //   608: aload_1
    //   609: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   612: aload_0
    //   613: ifnull +10 -> 623
    //   616: aload_0
    //   617: invokevirtual 159	java/io/OutputStream:close	()V
    //   620: goto +3 -> 623
    //   623: aload 5
    //   625: ifnull +107 -> 732
    //   628: aload 5
    //   630: invokevirtual 65	java/io/File:exists	()Z
    //   633: ifeq +99 -> 732
    //   636: goto +90 -> 726
    //   639: astore_1
    //   640: aconst_null
    //   641: astore 5
    //   643: aload 9
    //   645: astore_0
    //   646: aload_0
    //   647: astore 6
    //   649: aload 5
    //   651: astore 7
    //   653: aload_1
    //   654: invokevirtual 167	dji/thirdparty/sanselan/ImageWriteException:printStackTrace	()V
    //   657: aload_0
    //   658: ifnull +10 -> 668
    //   661: aload_0
    //   662: invokevirtual 159	java/io/OutputStream:close	()V
    //   665: goto +3 -> 668
    //   668: aload 5
    //   670: ifnull +62 -> 732
    //   673: aload 5
    //   675: invokevirtual 65	java/io/File:exists	()Z
    //   678: ifeq +54 -> 732
    //   681: goto +45 -> 726
    //   684: astore_1
    //   685: aconst_null
    //   686: astore 5
    //   688: aload 10
    //   690: astore_0
    //   691: aload_0
    //   692: astore 6
    //   694: aload 5
    //   696: astore 7
    //   698: aload_1
    //   699: invokevirtual 168	dji/thirdparty/sanselan/ImageReadException:printStackTrace	()V
    //   702: aload_0
    //   703: ifnull +10 -> 713
    //   706: aload_0
    //   707: invokevirtual 159	java/io/OutputStream:close	()V
    //   710: goto +3 -> 713
    //   713: aload 5
    //   715: ifnull +17 -> 732
    //   718: aload 5
    //   720: invokevirtual 65	java/io/File:exists	()Z
    //   723: ifeq +9 -> 732
    //   726: aload 5
    //   728: invokevirtual 68	java/io/File:delete	()Z
    //   731: pop
    //   732: iconst_0
    //   733: ireturn
    //   734: astore_0
    //   735: aload 7
    //   737: astore 5
    //   739: aload 6
    //   741: ifnull +11 -> 752
    //   744: aload 6
    //   746: invokevirtual 159	java/io/OutputStream:close	()V
    //   749: goto +3 -> 752
    //   752: aload 5
    //   754: ifnull +17 -> 771
    //   757: aload 5
    //   759: invokevirtual 65	java/io/File:exists	()Z
    //   762: ifeq +9 -> 771
    //   765: aload 5
    //   767: invokevirtual 68	java/io/File:delete	()Z
    //   770: pop
    //   771: aload_0
    //   772: athrow
    //   773: astore_0
    //   774: goto -245 -> 529
    //   777: astore_0
    //   778: goto -155 -> 623
    //   781: astore_0
    //   782: goto -114 -> 668
    //   785: astore_0
    //   786: goto -73 -> 713
    //   789: astore_1
    //   790: goto -38 -> 752
    //   793: iload 4
    //   795: iconst_1
    //   796: iadd
    //   797: istore 4
    //   799: goto -456 -> 343
    //   802: iload_3
    //   803: iconst_1
    //   804: iadd
    //   805: istore_3
    //   806: goto -608 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	paramFile1	File
    //   0	809	1	paramFile2	File
    //   0	809	2	paramList	java.util.List<dji.thirdparty.sanselan.formats.tiff.constants.TagInfo>
    //   130	676	3	i	int
    //   144	654	4	j	int
    //   7	759	5	localObject1	Object
    //   69	676	6	localObject2	Object
    //   91	645	7	localObject3	Object
    //   72	527	8	localObject4	Object
    //   60	584	9	localObject5	Object
    //   63	626	10	localObject6	Object
    //   66	403	11	localObject7	Object
    //   41	271	12	localOptions	BitmapFactory.Options
    //   116	387	13	localTiffOutputSet	TiffOutputSet
    //   194	32	14	localList	java.util.List
    //   253	206	15	localTiffOutputDirectory	TiffOutputDirectory
    //   236	136	16	localObject8	Object
    //   383	78	17	localTiffOutputField	dji.thirdparty.sanselan.formats.tiff.write.TiffOutputField
    // Exception table:
    //   from	to	target	type
    //   493	525	545	finally
    //   493	525	554	java/io/IOException
    //   493	525	558	dji/thirdparty/sanselan/ImageWriteException
    //   493	525	562	dji/thirdparty/sanselan/ImageReadException
    //   93	100	566	java/io/IOException
    //   108	118	566	java/io/IOException
    //   126	131	566	java/io/IOException
    //   139	146	566	java/io/IOException
    //   176	182	566	java/io/IOException
    //   190	196	566	java/io/IOException
    //   206	217	566	java/io/IOException
    //   225	238	566	java/io/IOException
    //   246	255	566	java/io/IOException
    //   271	294	566	java/io/IOException
    //   302	325	566	java/io/IOException
    //   333	340	566	java/io/IOException
    //   351	363	566	java/io/IOException
    //   371	385	566	java/io/IOException
    //   397	411	566	java/io/IOException
    //   419	429	566	java/io/IOException
    //   440	450	566	java/io/IOException
    //   458	465	566	java/io/IOException
    //   476	493	566	java/io/IOException
    //   93	100	573	dji/thirdparty/sanselan/ImageWriteException
    //   108	118	573	dji/thirdparty/sanselan/ImageWriteException
    //   126	131	573	dji/thirdparty/sanselan/ImageWriteException
    //   139	146	573	dji/thirdparty/sanselan/ImageWriteException
    //   176	182	573	dji/thirdparty/sanselan/ImageWriteException
    //   190	196	573	dji/thirdparty/sanselan/ImageWriteException
    //   206	217	573	dji/thirdparty/sanselan/ImageWriteException
    //   225	238	573	dji/thirdparty/sanselan/ImageWriteException
    //   246	255	573	dji/thirdparty/sanselan/ImageWriteException
    //   271	294	573	dji/thirdparty/sanselan/ImageWriteException
    //   302	325	573	dji/thirdparty/sanselan/ImageWriteException
    //   333	340	573	dji/thirdparty/sanselan/ImageWriteException
    //   351	363	573	dji/thirdparty/sanselan/ImageWriteException
    //   371	385	573	dji/thirdparty/sanselan/ImageWriteException
    //   397	411	573	dji/thirdparty/sanselan/ImageWriteException
    //   419	429	573	dji/thirdparty/sanselan/ImageWriteException
    //   440	450	573	dji/thirdparty/sanselan/ImageWriteException
    //   458	465	573	dji/thirdparty/sanselan/ImageWriteException
    //   476	493	573	dji/thirdparty/sanselan/ImageWriteException
    //   93	100	580	dji/thirdparty/sanselan/ImageReadException
    //   108	118	580	dji/thirdparty/sanselan/ImageReadException
    //   126	131	580	dji/thirdparty/sanselan/ImageReadException
    //   139	146	580	dji/thirdparty/sanselan/ImageReadException
    //   176	182	580	dji/thirdparty/sanselan/ImageReadException
    //   190	196	580	dji/thirdparty/sanselan/ImageReadException
    //   206	217	580	dji/thirdparty/sanselan/ImageReadException
    //   225	238	580	dji/thirdparty/sanselan/ImageReadException
    //   246	255	580	dji/thirdparty/sanselan/ImageReadException
    //   271	294	580	dji/thirdparty/sanselan/ImageReadException
    //   302	325	580	dji/thirdparty/sanselan/ImageReadException
    //   333	340	580	dji/thirdparty/sanselan/ImageReadException
    //   351	363	580	dji/thirdparty/sanselan/ImageReadException
    //   371	385	580	dji/thirdparty/sanselan/ImageReadException
    //   397	411	580	dji/thirdparty/sanselan/ImageReadException
    //   419	429	580	dji/thirdparty/sanselan/ImageReadException
    //   440	450	580	dji/thirdparty/sanselan/ImageReadException
    //   458	465	580	dji/thirdparty/sanselan/ImageReadException
    //   476	493	580	dji/thirdparty/sanselan/ImageReadException
    //   74	85	587	finally
    //   74	85	594	java/io/IOException
    //   74	85	639	dji/thirdparty/sanselan/ImageWriteException
    //   74	85	684	dji/thirdparty/sanselan/ImageReadException
    //   93	100	734	finally
    //   108	118	734	finally
    //   126	131	734	finally
    //   139	146	734	finally
    //   176	182	734	finally
    //   190	196	734	finally
    //   206	217	734	finally
    //   225	238	734	finally
    //   246	255	734	finally
    //   271	294	734	finally
    //   302	325	734	finally
    //   333	340	734	finally
    //   351	363	734	finally
    //   371	385	734	finally
    //   397	411	734	finally
    //   419	429	734	finally
    //   440	450	734	finally
    //   458	465	734	finally
    //   476	493	734	finally
    //   608	612	734	finally
    //   653	657	734	finally
    //   698	702	734	finally
    //   525	529	773	java/io/IOException
    //   616	620	777	java/io/IOException
    //   661	665	781	java/io/IOException
    //   706	710	785	java/io/IOException
    //   744	749	789	java/io/IOException
  }
  
  private static TiffOutputDirectory getOrCreateExifDirectory(TiffOutputSet paramTiffOutputSet, TiffOutputDirectory paramTiffOutputDirectory)
  {
    TiffOutputDirectory localTiffOutputDirectory = paramTiffOutputSet.findDirectory(paramTiffOutputDirectory.type);
    if (localTiffOutputDirectory != null) {
      return localTiffOutputDirectory;
    }
    paramTiffOutputDirectory = new TiffOutputDirectory(paramTiffOutputDirectory.type);
    try
    {
      paramTiffOutputSet.addDirectory(paramTiffOutputDirectory);
      return paramTiffOutputDirectory;
    }
    catch (ImageWriteException paramTiffOutputSet)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static TiffOutputSet getSanselanOutputSet(File paramFile, int paramInt)
    throws IOException, ImageReadException, ImageWriteException
  {
    Object localObject1 = Sanselan.getMetadata(paramFile);
    boolean bool = localObject1 instanceof JpegImageMetadata;
    paramFile = null;
    if (bool)
    {
      localObject1 = (JpegImageMetadata)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((JpegImageMetadata)localObject1).getExif();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          paramFile = ((TiffImageMetadata)localObject2).getOutputSet();
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = null;
      }
    }
    else
    {
      localObject2 = (TiffImageMetadata)localObject1;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        paramFile = ((TiffImageMetadata)localObject2).getOutputSet();
        localObject1 = localObject2;
      }
    }
    Object localObject2 = paramFile;
    if (paramFile == null)
    {
      if (localObject1 != null) {
        paramInt = ((TiffImageMetadata)localObject1).contents.header.byteOrder;
      }
      localObject2 = new TiffOutputSet(paramInt);
    }
    return (TiffOutputSet)localObject2;
  }
  
  public static void updateExifByMap(File paramFile, Float paramFloat, String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString2, String paramString3)
  {
    try
    {
      localObject = new ExifInterface(paramFile.getAbsolutePath());
      ((ExifInterface)localObject).setAttribute("ExposureTime", paramString1);
      ((ExifInterface)localObject).saveAttributes();
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString1 = new BitmapFactory.Options();
    paramString1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramString1);
    Object localObject = new HashMap();
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_EXIF_IMAGE_WIDTH, Integer.valueOf(paramString1.outWidth));
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_EXIF_IMAGE_LENGTH, Integer.valueOf(paramString1.outHeight));
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_EXPOSURE_MODE, paramInteger1);
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_WHITE_BALANCE_1, paramInteger2);
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_ISO, paramInteger3);
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_FNUMBER, paramFloat);
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_MODEL, paramString2);
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL, paramString3);
    ((HashMap)localObject).put(ExifTagConstants.EXIF_TAG_CREATE_DATE, paramString3);
    updateExifByMap(paramFile, (HashMap)localObject);
  }
  
  /* Error */
  public static void updateExifByMap(File paramFile, HashMap<dji.thirdparty.sanselan.formats.tiff.constants.TagInfo, Object> paramHashMap)
  {
    // Byte code:
    //   0: new 19	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 26	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   13: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: ldc 32
    //   20: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: new 22	java/io/File
    //   27: dup
    //   28: aload_2
    //   29: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 9
    //   37: aconst_null
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 5
    //   43: aconst_null
    //   44: astore 6
    //   46: aconst_null
    //   47: astore 7
    //   49: aconst_null
    //   50: astore 8
    //   52: aload 8
    //   54: astore_2
    //   55: aload_0
    //   56: bipush 73
    //   58: invokestatic 55	dji/media/exif/utils/DJIExifTools:getSanselanOutputSet	(Ljava/io/File;I)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet;
    //   61: astore 10
    //   63: aload 8
    //   65: astore_2
    //   66: aload 10
    //   68: invokevirtual 76	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:getDirectories	()Ljava/util/List;
    //   71: astore_3
    //   72: aload 8
    //   74: astore_2
    //   75: aload_3
    //   76: invokeinterface 82 1 0
    //   81: ifle +20 -> 101
    //   84: aload 8
    //   86: astore_2
    //   87: aload_3
    //   88: iconst_0
    //   89: invokeinterface 86 2 0
    //   94: checkcast 88	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory
    //   97: astore_3
    //   98: goto +12 -> 110
    //   101: aload 8
    //   103: astore_2
    //   104: aload 10
    //   106: invokevirtual 72	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:getOrCreateExifDirectory	()Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory;
    //   109: astore_3
    //   110: aload 8
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 268	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   117: invokeinterface 274 1 0
    //   122: astore_1
    //   123: aload 8
    //   125: astore_2
    //   126: aload_1
    //   127: invokeinterface 279 1 0
    //   132: ifeq +183 -> 315
    //   135: aload 8
    //   137: astore_2
    //   138: aload_1
    //   139: invokeinterface 283 1 0
    //   144: checkcast 285	java/util/Map$Entry
    //   147: astore 11
    //   149: aload 8
    //   151: astore_2
    //   152: aload_3
    //   153: aload 11
    //   155: invokeinterface 288 1 0
    //   160: checkcast 290	dji/thirdparty/sanselan/formats/tiff/constants/TagInfo
    //   163: invokevirtual 137	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:removeField	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;)V
    //   166: aload 8
    //   168: astore_2
    //   169: aload 11
    //   171: invokeinterface 293 1 0
    //   176: instanceof 295
    //   179: ifeq +41 -> 220
    //   182: aload 8
    //   184: astore_2
    //   185: aload_3
    //   186: aload 11
    //   188: invokeinterface 288 1 0
    //   193: checkcast 290	dji/thirdparty/sanselan/formats/tiff/constants/TagInfo
    //   196: aload 10
    //   198: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   201: aload 11
    //   203: invokeinterface 293 1 0
    //   208: checkcast 295	java/lang/Number
    //   211: invokestatic 112	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:create	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;ILjava/lang/Number;)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;
    //   214: invokevirtual 116	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:add	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;)V
    //   217: goto -94 -> 123
    //   220: aload 8
    //   222: astore_2
    //   223: aload 11
    //   225: invokeinterface 293 1 0
    //   230: instanceof 297
    //   233: ifeq +41 -> 274
    //   236: aload 8
    //   238: astore_2
    //   239: aload_3
    //   240: aload 11
    //   242: invokeinterface 288 1 0
    //   247: checkcast 290	dji/thirdparty/sanselan/formats/tiff/constants/TagInfo
    //   250: aload 10
    //   252: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   255: aload 11
    //   257: invokeinterface 293 1 0
    //   262: checkcast 297	java/lang/String
    //   265: invokestatic 300	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:create	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;ILjava/lang/String;)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;
    //   268: invokevirtual 116	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:add	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;)V
    //   271: goto -148 -> 123
    //   274: aload 8
    //   276: astore_2
    //   277: aload_3
    //   278: aload 11
    //   280: invokeinterface 288 1 0
    //   285: checkcast 290	dji/thirdparty/sanselan/formats/tiff/constants/TagInfo
    //   288: aload 10
    //   290: getfield 61	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet:byteOrder	I
    //   293: aload 11
    //   295: invokeinterface 293 1 0
    //   300: checkcast 302	[Ljava/lang/Number;
    //   303: checkcast 302	[Ljava/lang/Number;
    //   306: invokestatic 305	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputField:create	(Ldji/thirdparty/sanselan/formats/tiff/constants/TagInfo;I[Ljava/lang/Number;)Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;
    //   309: invokevirtual 116	dji/thirdparty/sanselan/formats/tiff/write/TiffOutputDirectory:add	(Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputField;)V
    //   312: goto -189 -> 123
    //   315: aload 8
    //   317: astore_2
    //   318: new 139	java/io/BufferedOutputStream
    //   321: dup
    //   322: new 141	java/io/FileOutputStream
    //   325: dup
    //   326: aload 9
    //   328: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   331: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   334: astore_1
    //   335: new 149	dji/thirdparty/sanselan/formats/jpeg/exifRewrite/ExifRewriter
    //   338: dup
    //   339: invokespecial 150	dji/thirdparty/sanselan/formats/jpeg/exifRewrite/ExifRewriter:<init>	()V
    //   342: aload_0
    //   343: aload_1
    //   344: aload 10
    //   346: invokevirtual 154	dji/thirdparty/sanselan/formats/jpeg/exifRewrite/ExifRewriter:updateExifMetadataLossless	(Ljava/io/File;Ljava/io/OutputStream;Ldji/thirdparty/sanselan/formats/tiff/write/TiffOutputSet;)V
    //   349: aload_1
    //   350: invokevirtual 159	java/io/OutputStream:close	()V
    //   353: aload_0
    //   354: invokevirtual 68	java/io/File:delete	()Z
    //   357: ifeq +10 -> 367
    //   360: aload 9
    //   362: aload_0
    //   363: invokevirtual 163	java/io/File:renameTo	(Ljava/io/File;)Z
    //   366: pop
    //   367: aload_1
    //   368: invokevirtual 159	java/io/OutputStream:close	()V
    //   371: return
    //   372: astore_0
    //   373: aload_1
    //   374: astore_2
    //   375: goto +102 -> 477
    //   378: astore_2
    //   379: aload_1
    //   380: astore_0
    //   381: aload_2
    //   382: astore_1
    //   383: goto +35 -> 418
    //   386: astore_2
    //   387: aload_1
    //   388: astore_0
    //   389: aload_2
    //   390: astore_1
    //   391: goto +46 -> 437
    //   394: astore_2
    //   395: aload_1
    //   396: astore_0
    //   397: aload_2
    //   398: astore_1
    //   399: goto +51 -> 450
    //   402: astore_2
    //   403: aload_1
    //   404: astore_0
    //   405: aload_2
    //   406: astore_1
    //   407: goto +56 -> 463
    //   410: astore_0
    //   411: goto +66 -> 477
    //   414: astore_1
    //   415: aload 4
    //   417: astore_0
    //   418: aload_0
    //   419: astore_2
    //   420: aload_1
    //   421: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   424: aload_0
    //   425: ifnull +51 -> 476
    //   428: aload_0
    //   429: invokevirtual 159	java/io/OutputStream:close	()V
    //   432: return
    //   433: astore_1
    //   434: aload 5
    //   436: astore_0
    //   437: aload_0
    //   438: astore_2
    //   439: aload_1
    //   440: invokevirtual 168	dji/thirdparty/sanselan/ImageReadException:printStackTrace	()V
    //   443: aload_0
    //   444: ifnull +32 -> 476
    //   447: goto -19 -> 428
    //   450: aload_0
    //   451: astore_2
    //   452: aload_1
    //   453: invokevirtual 306	java/io/FileNotFoundException:printStackTrace	()V
    //   456: aload_0
    //   457: ifnull +19 -> 476
    //   460: goto -32 -> 428
    //   463: aload_0
    //   464: astore_2
    //   465: aload_1
    //   466: invokevirtual 167	dji/thirdparty/sanselan/ImageWriteException:printStackTrace	()V
    //   469: aload_0
    //   470: ifnull +6 -> 476
    //   473: goto -45 -> 428
    //   476: return
    //   477: aload_2
    //   478: ifnull +7 -> 485
    //   481: aload_2
    //   482: invokevirtual 159	java/io/OutputStream:close	()V
    //   485: aload_0
    //   486: athrow
    //   487: astore_0
    //   488: return
    //   489: astore_1
    //   490: goto -5 -> 485
    //   493: astore_1
    //   494: aload 6
    //   496: astore_0
    //   497: goto -47 -> 450
    //   500: astore_1
    //   501: aload 7
    //   503: astore_0
    //   504: goto -41 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	paramFile	File
    //   0	507	1	paramHashMap	HashMap<dji.thirdparty.sanselan.formats.tiff.constants.TagInfo, Object>
    //   7	368	2	localObject1	Object
    //   378	4	2	localIOException	IOException
    //   386	4	2	localImageReadException	ImageReadException
    //   394	4	2	localFileNotFoundException	java.io.FileNotFoundException
    //   402	4	2	localImageWriteException	ImageWriteException
    //   419	63	2	localFile1	File
    //   71	207	3	localObject2	Object
    //   38	378	4	localObject3	Object
    //   41	394	5	localObject4	Object
    //   44	451	6	localObject5	Object
    //   47	455	7	localObject6	Object
    //   50	266	8	localObject7	Object
    //   35	326	9	localFile2	File
    //   61	284	10	localTiffOutputSet	TiffOutputSet
    //   147	147	11	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   335	367	372	finally
    //   335	367	378	java/io/IOException
    //   335	367	386	dji/thirdparty/sanselan/ImageReadException
    //   335	367	394	java/io/FileNotFoundException
    //   335	367	402	dji/thirdparty/sanselan/ImageWriteException
    //   55	63	410	finally
    //   66	72	410	finally
    //   75	84	410	finally
    //   87	98	410	finally
    //   104	110	410	finally
    //   113	123	410	finally
    //   126	135	410	finally
    //   138	149	410	finally
    //   152	166	410	finally
    //   169	182	410	finally
    //   185	217	410	finally
    //   223	236	410	finally
    //   239	271	410	finally
    //   277	312	410	finally
    //   318	335	410	finally
    //   420	424	410	finally
    //   439	443	410	finally
    //   452	456	410	finally
    //   465	469	410	finally
    //   55	63	414	java/io/IOException
    //   66	72	414	java/io/IOException
    //   75	84	414	java/io/IOException
    //   87	98	414	java/io/IOException
    //   104	110	414	java/io/IOException
    //   113	123	414	java/io/IOException
    //   126	135	414	java/io/IOException
    //   138	149	414	java/io/IOException
    //   152	166	414	java/io/IOException
    //   169	182	414	java/io/IOException
    //   185	217	414	java/io/IOException
    //   223	236	414	java/io/IOException
    //   239	271	414	java/io/IOException
    //   277	312	414	java/io/IOException
    //   318	335	414	java/io/IOException
    //   55	63	433	dji/thirdparty/sanselan/ImageReadException
    //   66	72	433	dji/thirdparty/sanselan/ImageReadException
    //   75	84	433	dji/thirdparty/sanselan/ImageReadException
    //   87	98	433	dji/thirdparty/sanselan/ImageReadException
    //   104	110	433	dji/thirdparty/sanselan/ImageReadException
    //   113	123	433	dji/thirdparty/sanselan/ImageReadException
    //   126	135	433	dji/thirdparty/sanselan/ImageReadException
    //   138	149	433	dji/thirdparty/sanselan/ImageReadException
    //   152	166	433	dji/thirdparty/sanselan/ImageReadException
    //   169	182	433	dji/thirdparty/sanselan/ImageReadException
    //   185	217	433	dji/thirdparty/sanselan/ImageReadException
    //   223	236	433	dji/thirdparty/sanselan/ImageReadException
    //   239	271	433	dji/thirdparty/sanselan/ImageReadException
    //   277	312	433	dji/thirdparty/sanselan/ImageReadException
    //   318	335	433	dji/thirdparty/sanselan/ImageReadException
    //   367	371	487	java/io/IOException
    //   428	432	487	java/io/IOException
    //   481	485	489	java/io/IOException
    //   55	63	493	java/io/FileNotFoundException
    //   66	72	493	java/io/FileNotFoundException
    //   75	84	493	java/io/FileNotFoundException
    //   87	98	493	java/io/FileNotFoundException
    //   104	110	493	java/io/FileNotFoundException
    //   113	123	493	java/io/FileNotFoundException
    //   126	135	493	java/io/FileNotFoundException
    //   138	149	493	java/io/FileNotFoundException
    //   152	166	493	java/io/FileNotFoundException
    //   169	182	493	java/io/FileNotFoundException
    //   185	217	493	java/io/FileNotFoundException
    //   223	236	493	java/io/FileNotFoundException
    //   239	271	493	java/io/FileNotFoundException
    //   277	312	493	java/io/FileNotFoundException
    //   318	335	493	java/io/FileNotFoundException
    //   55	63	500	dji/thirdparty/sanselan/ImageWriteException
    //   66	72	500	dji/thirdparty/sanselan/ImageWriteException
    //   75	84	500	dji/thirdparty/sanselan/ImageWriteException
    //   87	98	500	dji/thirdparty/sanselan/ImageWriteException
    //   104	110	500	dji/thirdparty/sanselan/ImageWriteException
    //   113	123	500	dji/thirdparty/sanselan/ImageWriteException
    //   126	135	500	dji/thirdparty/sanselan/ImageWriteException
    //   138	149	500	dji/thirdparty/sanselan/ImageWriteException
    //   152	166	500	dji/thirdparty/sanselan/ImageWriteException
    //   169	182	500	dji/thirdparty/sanselan/ImageWriteException
    //   185	217	500	dji/thirdparty/sanselan/ImageWriteException
    //   223	236	500	dji/thirdparty/sanselan/ImageWriteException
    //   239	271	500	dji/thirdparty/sanselan/ImageWriteException
    //   277	312	500	dji/thirdparty/sanselan/ImageWriteException
    //   318	335	500	dji/thirdparty/sanselan/ImageWriteException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\media\exi\\utils\DJIExifTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */