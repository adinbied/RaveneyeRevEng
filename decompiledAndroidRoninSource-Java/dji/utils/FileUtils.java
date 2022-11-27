package dji.utils;

import android.app.Application;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileUtils
{
  private static double SIZE_GB = 1.073741824E9D;
  private static double SIZE_KB = 1024.0D;
  private static double SIZE_MB = 1048756.0D;
  private static final String TAG = "FileUtils";
  
  private static String byte2FitMemorySize(long paramLong)
  {
    if (paramLong < 0L) {
      return "shouldn't be less than zero!";
    }
    double d = paramLong;
    if (d < SIZE_KB) {
      return String.format(Locale.getDefault(), "%.3fB", new Object[] { Double.valueOf(d) });
    }
    if (d < SIZE_MB) {
      return String.format(Locale.getDefault(), "%.3fKB", new Object[] { Double.valueOf(d / SIZE_KB) });
    }
    if (d < SIZE_GB) {
      return String.format(Locale.getDefault(), "%.3fMB", new Object[] { Double.valueOf(d / SIZE_MB) });
    }
    return String.format(Locale.getDefault(), "%.3fGB", new Object[] { Double.valueOf(d / SIZE_GB) });
  }
  
  public static String concatPath(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int i = 0;
      while (i < m)
      {
        String str = paramVarArgs[i];
        if ((str != null) && (str.length() > 0))
        {
          int j = localStringBuilder.length();
          if ((j > 0) && (localStringBuilder.charAt(j - 1) == File.separatorChar)) {
            j = 1;
          } else {
            j = 0;
          }
          int k;
          if (str.charAt(0) == File.separatorChar) {
            k = 1;
          } else {
            k = 0;
          }
          if ((j != 0) && (k != 0))
          {
            localStringBuilder.append(str.substring(1));
          }
          else if ((j == 0) && (k == 0))
          {
            localStringBuilder.append(File.separatorChar);
            localStringBuilder.append(str);
          }
          else
          {
            localStringBuilder.append(str);
          }
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean copyDir(File paramFile1, File paramFile2)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (paramFile1 != null)
    {
      bool1 = bool2;
      if (paramFile2 != null)
      {
        bool1 = bool2;
        if (isDirectory(paramFile1))
        {
          bool1 = bool2;
          if (mkdirs(paramFile2))
          {
            paramFile1 = paramFile1.listFiles();
            if ((paramFile1 != null) && (paramFile1.length > 0))
            {
              int j = paramFile1.length;
              while (i < j)
              {
                File localFile = paramFile1[i];
                Object localObject;
                if (localFile.isFile())
                {
                  localObject = localFile.getAbsolutePath();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(paramFile2.getAbsolutePath());
                  localStringBuilder.append("/");
                  localStringBuilder.append(localFile.getName());
                  copyFileByChannel((String)localObject, localStringBuilder.toString());
                }
                else if (localFile.isDirectory())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramFile2.getAbsolutePath());
                  ((StringBuilder)localObject).append(File.separator);
                  ((StringBuilder)localObject).append(localFile.getName());
                  copyDir(localFile, new File(((StringBuilder)localObject).toString()));
                }
                i += 1;
              }
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  public static boolean copyFileByBuffer(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +175 -> 176
    //   4: aload_1
    //   5: ifnull +171 -> 176
    //   8: new 78	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 143	java/io/File:exists	()Z
    //   21: ifeq +155 -> 176
    //   24: aload_2
    //   25: invokevirtual 115	java/io/File:isFile	()Z
    //   28: ifeq +148 -> 176
    //   31: aconst_null
    //   32: astore 4
    //   34: aconst_null
    //   35: astore_3
    //   36: new 145	java/io/BufferedReader
    //   39: dup
    //   40: new 147	java/io/FileReader
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 148	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   48: sipush 1024
    //   51: invokespecial 151	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   54: astore_2
    //   55: new 153	java/io/BufferedWriter
    //   58: dup
    //   59: new 155	java/io/FileWriter
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 156	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   67: sipush 1024
    //   70: invokespecial 159	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 162	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +11 -> 91
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 165	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   88: goto -14 -> 74
    //   91: aload_0
    //   92: invokevirtual 168	java/io/BufferedWriter:flush	()V
    //   95: aload_2
    //   96: invokevirtual 171	java/io/BufferedReader:close	()V
    //   99: aload_0
    //   100: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   103: iconst_1
    //   104: ireturn
    //   105: astore_3
    //   106: aload_0
    //   107: astore_1
    //   108: aload_3
    //   109: astore_0
    //   110: goto +6 -> 116
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_1
    //   116: goto +15 -> 131
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_2
    //   122: astore_1
    //   123: goto +34 -> 157
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_3
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +10 -> 142
    //   135: aload_2
    //   136: invokevirtual 171	java/io/BufferedReader:close	()V
    //   139: goto +3 -> 142
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   150: aload_0
    //   151: athrow
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +10 -> 168
    //   161: aload_1
    //   162: invokevirtual 171	java/io/BufferedReader:close	()V
    //   165: goto +3 -> 168
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_0
    //   179: goto -27 -> 152
    //   182: astore_0
    //   183: goto -64 -> 119
    //   186: astore_1
    //   187: goto -66 -> 121
    //   190: astore_1
    //   191: goto -92 -> 99
    //   194: astore_0
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_2
    //   198: goto -56 -> 142
    //   201: astore_1
    //   202: goto -52 -> 150
    //   205: astore_1
    //   206: goto -38 -> 168
    //   209: astore_0
    //   210: goto -34 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString1	String
    //   0	213	1	paramString2	String
    //   16	120	2	localObject1	Object
    //   197	1	2	localException	Exception
    //   35	1	3	localObject2	Object
    //   105	25	3	localObject3	Object
    //   32	123	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   74	79	105	finally
    //   83	88	105	finally
    //   91	95	105	finally
    //   55	74	113	finally
    //   36	55	126	finally
    //   36	55	178	java/lang/Exception
    //   55	74	182	java/lang/Exception
    //   74	79	186	java/lang/Exception
    //   83	88	186	java/lang/Exception
    //   91	95	186	java/lang/Exception
    //   95	99	190	java/lang/Exception
    //   99	103	194	java/lang/Exception
    //   135	139	197	java/lang/Exception
    //   146	150	201	java/lang/Exception
    //   161	165	205	java/lang/Exception
    //   172	176	209	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyFileByChannel(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +359 -> 360
    //   4: aload_1
    //   5: ifnull +355 -> 360
    //   8: new 78	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 143	java/io/File:exists	()Z
    //   21: ifeq +339 -> 360
    //   24: aload_2
    //   25: invokevirtual 115	java/io/File:isFile	()Z
    //   28: ifeq +332 -> 360
    //   31: aconst_null
    //   32: astore 5
    //   34: aconst_null
    //   35: astore 6
    //   37: aconst_null
    //   38: astore_0
    //   39: aconst_null
    //   40: astore 7
    //   42: new 174	java/io/FileInputStream
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore_3
    //   51: new 179	java/io/FileOutputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 180	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   59: astore_2
    //   60: aload_3
    //   61: invokevirtual 184	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   64: astore 4
    //   66: aload 7
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 185	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   73: astore 5
    //   75: aload 5
    //   77: astore_1
    //   78: aload 5
    //   80: astore_0
    //   81: sipush 1024
    //   84: invokestatic 191	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   87: astore 6
    //   89: aload 5
    //   91: astore_1
    //   92: aload 5
    //   94: astore_0
    //   95: aload 6
    //   97: invokevirtual 195	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   100: pop
    //   101: aload 5
    //   103: astore_1
    //   104: aload 5
    //   106: astore_0
    //   107: iconst_m1
    //   108: aload 4
    //   110: aload 6
    //   112: invokevirtual 201	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   115: if_icmpeq +44 -> 159
    //   118: aload 5
    //   120: astore_1
    //   121: aload 5
    //   123: astore_0
    //   124: aload 6
    //   126: invokevirtual 204	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   129: pop
    //   130: aload 5
    //   132: astore_1
    //   133: aload 5
    //   135: astore_0
    //   136: aload 5
    //   138: aload 6
    //   140: invokevirtual 206	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   143: pop
    //   144: aload 5
    //   146: astore_1
    //   147: aload 5
    //   149: astore_0
    //   150: aload 6
    //   152: invokevirtual 195	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   155: pop
    //   156: goto -55 -> 101
    //   159: aload 5
    //   161: astore_1
    //   162: aload 5
    //   164: astore_0
    //   165: aload 5
    //   167: iconst_1
    //   168: invokevirtual 210	java/nio/channels/FileChannel:force	(Z)V
    //   171: aload 5
    //   173: ifnull +11 -> 184
    //   176: aload 5
    //   178: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   181: goto +3 -> 184
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   194: aload_3
    //   195: invokevirtual 212	java/io/FileInputStream:close	()V
    //   198: aload_2
    //   199: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   202: iconst_1
    //   203: ireturn
    //   204: astore_0
    //   205: aload_1
    //   206: astore 5
    //   208: aload 4
    //   210: astore_1
    //   211: goto +54 -> 265
    //   214: aload_2
    //   215: astore_1
    //   216: aload_0
    //   217: astore_2
    //   218: aload 4
    //   220: astore_0
    //   221: goto +98 -> 319
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: goto +38 -> 265
    //   230: aconst_null
    //   231: astore_0
    //   232: aload_2
    //   233: astore_1
    //   234: aload 6
    //   236: astore_2
    //   237: goto +82 -> 319
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_1
    //   243: aload_1
    //   244: astore_2
    //   245: goto +20 -> 265
    //   248: aconst_null
    //   249: astore_0
    //   250: aload_0
    //   251: astore_1
    //   252: aload 6
    //   254: astore_2
    //   255: goto +64 -> 319
    //   258: astore_0
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_1
    //   262: astore_2
    //   263: aload_2
    //   264: astore_3
    //   265: aload 5
    //   267: ifnull +11 -> 278
    //   270: aload 5
    //   272: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   275: goto +3 -> 278
    //   278: aload_1
    //   279: ifnull +10 -> 289
    //   282: aload_1
    //   283: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   286: goto +3 -> 289
    //   289: aload_3
    //   290: ifnull +10 -> 300
    //   293: aload_3
    //   294: invokevirtual 212	java/io/FileInputStream:close	()V
    //   297: goto +3 -> 300
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: aconst_null
    //   311: astore_0
    //   312: aload_0
    //   313: astore_1
    //   314: aload_1
    //   315: astore_3
    //   316: aload 6
    //   318: astore_2
    //   319: aload_2
    //   320: ifnull +10 -> 330
    //   323: aload_2
    //   324: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   327: goto +3 -> 330
    //   330: aload_0
    //   331: ifnull +10 -> 341
    //   334: aload_0
    //   335: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   338: goto +3 -> 341
    //   341: aload_3
    //   342: ifnull +10 -> 352
    //   345: aload_3
    //   346: invokevirtual 212	java/io/FileInputStream:close	()V
    //   349: goto +3 -> 352
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   360: iconst_0
    //   361: ireturn
    //   362: astore_0
    //   363: goto -53 -> 310
    //   366: astore_0
    //   367: goto -119 -> 248
    //   370: astore_0
    //   371: goto -141 -> 230
    //   374: astore_1
    //   375: goto -161 -> 214
    //   378: astore_0
    //   379: goto -195 -> 184
    //   382: astore_0
    //   383: goto -189 -> 194
    //   386: astore_0
    //   387: goto -189 -> 198
    //   390: astore_0
    //   391: iconst_1
    //   392: ireturn
    //   393: astore 4
    //   395: goto -117 -> 278
    //   398: astore_1
    //   399: goto -110 -> 289
    //   402: astore_1
    //   403: goto -103 -> 300
    //   406: astore_1
    //   407: goto -99 -> 308
    //   410: astore_2
    //   411: goto -81 -> 330
    //   414: astore_0
    //   415: goto -74 -> 341
    //   418: astore_0
    //   419: goto -67 -> 352
    //   422: astore_0
    //   423: goto -63 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	paramString1	String
    //   0	426	1	paramString2	String
    //   16	308	2	localObject1	Object
    //   410	1	2	localException1	Exception
    //   50	296	3	localObject2	Object
    //   64	155	4	localFileChannel	java.nio.channels.FileChannel
    //   393	1	4	localException2	Exception
    //   32	239	5	localObject3	Object
    //   35	282	6	localByteBuffer	java.nio.ByteBuffer
    //   40	27	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   69	75	204	finally
    //   81	89	204	finally
    //   95	101	204	finally
    //   107	118	204	finally
    //   124	130	204	finally
    //   136	144	204	finally
    //   150	156	204	finally
    //   165	171	204	finally
    //   60	66	224	finally
    //   51	60	240	finally
    //   42	51	258	finally
    //   42	51	362	java/lang/Exception
    //   51	60	366	java/lang/Exception
    //   60	66	370	java/lang/Exception
    //   69	75	374	java/lang/Exception
    //   81	89	374	java/lang/Exception
    //   95	101	374	java/lang/Exception
    //   107	118	374	java/lang/Exception
    //   124	130	374	java/lang/Exception
    //   136	144	374	java/lang/Exception
    //   150	156	374	java/lang/Exception
    //   165	171	374	java/lang/Exception
    //   176	181	378	java/lang/Exception
    //   189	194	382	java/lang/Exception
    //   194	198	386	java/lang/Exception
    //   198	202	390	java/lang/Exception
    //   270	275	393	java/lang/Exception
    //   282	286	398	java/lang/Exception
    //   293	297	402	java/lang/Exception
    //   304	308	406	java/lang/Exception
    //   323	327	410	java/lang/Exception
    //   334	338	414	java/lang/Exception
    //   345	349	418	java/lang/Exception
    //   356	360	422	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyStreamByBuffer(java.io.InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnull +235 -> 238
    //   6: aload_1
    //   7: ifnull +231 -> 238
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 7
    //   16: new 145	java/io/BufferedReader
    //   19: dup
    //   20: new 217	java/io/InputStreamReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 220	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: sipush 1024
    //   31: invokespecial 151	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   34: astore 6
    //   36: new 153	java/io/BufferedWriter
    //   39: dup
    //   40: new 155	java/io/FileWriter
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 156	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   48: sipush 1024
    //   51: invokespecial 159	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   54: astore_1
    //   55: sipush 1024
    //   58: newarray <illegal type>
    //   60: astore 5
    //   62: aload 6
    //   64: aload 5
    //   66: iconst_0
    //   67: sipush 1024
    //   70: invokevirtual 223	java/io/BufferedReader:read	([CII)I
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +14 -> 89
    //   78: aload_1
    //   79: aload 5
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 226	java/io/BufferedWriter:write	([CII)V
    //   86: goto -24 -> 62
    //   89: aload_1
    //   90: invokevirtual 168	java/io/BufferedWriter:flush	()V
    //   93: iconst_1
    //   94: istore 4
    //   96: aload 6
    //   98: invokevirtual 171	java/io/BufferedReader:close	()V
    //   101: goto +3 -> 104
    //   104: iload 4
    //   106: istore_3
    //   107: aload_1
    //   108: astore 5
    //   110: aload_0
    //   111: ifnull +13 -> 124
    //   114: aload_0
    //   115: invokevirtual 229	java/io/InputStream:close	()V
    //   118: aload_1
    //   119: astore 5
    //   121: iload 4
    //   123: istore_3
    //   124: aload 5
    //   126: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   129: iload_3
    //   130: ireturn
    //   131: astore 7
    //   133: aload_1
    //   134: astore 5
    //   136: aload 7
    //   138: astore_1
    //   139: goto +7 -> 146
    //   142: astore_1
    //   143: aconst_null
    //   144: astore 5
    //   146: goto +20 -> 166
    //   149: aconst_null
    //   150: astore_1
    //   151: aload 6
    //   153: astore 5
    //   155: goto +49 -> 204
    //   158: astore_1
    //   159: aconst_null
    //   160: astore 5
    //   162: aload 7
    //   164: astore 6
    //   166: aload 6
    //   168: ifnull +11 -> 179
    //   171: aload 6
    //   173: invokevirtual 171	java/io/BufferedReader:close	()V
    //   176: goto +3 -> 179
    //   179: aload_0
    //   180: ifnull +10 -> 190
    //   183: aload_0
    //   184: invokevirtual 229	java/io/InputStream:close	()V
    //   187: goto +3 -> 190
    //   190: aload 5
    //   192: ifnull +8 -> 200
    //   195: aload 5
    //   197: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   200: aload_1
    //   201: athrow
    //   202: aconst_null
    //   203: astore_1
    //   204: aload 5
    //   206: ifnull +11 -> 217
    //   209: aload 5
    //   211: invokevirtual 171	java/io/BufferedReader:close	()V
    //   214: goto +3 -> 217
    //   217: aload_0
    //   218: ifnull +10 -> 228
    //   221: aload_0
    //   222: invokevirtual 229	java/io/InputStream:close	()V
    //   225: goto +3 -> 228
    //   228: aload_1
    //   229: ifnull +9 -> 238
    //   232: aload_1
    //   233: astore 5
    //   235: goto -111 -> 124
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_1
    //   241: goto -39 -> 202
    //   244: astore_1
    //   245: goto -96 -> 149
    //   248: astore 5
    //   250: goto -99 -> 151
    //   253: astore 5
    //   255: goto -151 -> 104
    //   258: astore_0
    //   259: iload 4
    //   261: istore_3
    //   262: aload_1
    //   263: astore 5
    //   265: goto -141 -> 124
    //   268: astore_0
    //   269: iload_3
    //   270: ireturn
    //   271: astore 6
    //   273: goto -94 -> 179
    //   276: astore_0
    //   277: goto -87 -> 190
    //   280: astore_0
    //   281: goto -81 -> 200
    //   284: astore 5
    //   286: goto -69 -> 217
    //   289: astore_0
    //   290: goto -62 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramInputStream	java.io.InputStream
    //   0	293	1	paramString	String
    //   73	10	2	i	int
    //   1	269	3	bool1	boolean
    //   94	166	4	bool2	boolean
    //   11	223	5	localObject1	Object
    //   248	1	5	localException1	Exception
    //   253	1	5	localException2	Exception
    //   263	1	5	str	String
    //   284	1	5	localException3	Exception
    //   34	138	6	localObject2	Object
    //   271	1	6	localException4	Exception
    //   14	1	7	localObject3	Object
    //   131	32	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	131	finally
    //   62	74	131	finally
    //   78	86	131	finally
    //   89	93	131	finally
    //   36	55	142	finally
    //   16	36	158	finally
    //   16	36	240	java/lang/Exception
    //   36	55	244	java/lang/Exception
    //   55	62	248	java/lang/Exception
    //   62	74	248	java/lang/Exception
    //   78	86	248	java/lang/Exception
    //   89	93	248	java/lang/Exception
    //   96	101	253	java/lang/Exception
    //   114	118	258	java/lang/Exception
    //   124	129	268	java/lang/Exception
    //   171	176	271	java/lang/Exception
    //   183	187	276	java/lang/Exception
    //   195	200	280	java/lang/Exception
    //   209	214	284	java/lang/Exception
    //   221	225	289	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyStreamByStream(java.io.InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnull +222 -> 225
    //   6: aload_1
    //   7: ifnull +218 -> 225
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 7
    //   16: new 232	java/io/BufferedInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 6
    //   26: new 235	java/io/BufferedOutputStream
    //   29: dup
    //   30: new 179	java/io/FileOutputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 180	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 238	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore_1
    //   42: sipush 2048
    //   45: newarray <illegal type>
    //   47: astore 5
    //   49: aload 6
    //   51: aload 5
    //   53: iconst_0
    //   54: sipush 2048
    //   57: invokevirtual 241	java/io/BufferedInputStream:read	([BII)I
    //   60: istore_2
    //   61: iload_2
    //   62: ifle +14 -> 76
    //   65: aload_1
    //   66: aload 5
    //   68: iconst_0
    //   69: iload_2
    //   70: invokevirtual 244	java/io/BufferedOutputStream:write	([BII)V
    //   73: goto -24 -> 49
    //   76: aload_1
    //   77: invokevirtual 245	java/io/BufferedOutputStream:flush	()V
    //   80: iconst_1
    //   81: istore 4
    //   83: aload 6
    //   85: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   88: goto +3 -> 91
    //   91: iload 4
    //   93: istore_3
    //   94: aload_1
    //   95: astore 5
    //   97: aload_0
    //   98: ifnull +13 -> 111
    //   101: aload_0
    //   102: invokevirtual 229	java/io/InputStream:close	()V
    //   105: aload_1
    //   106: astore 5
    //   108: iload 4
    //   110: istore_3
    //   111: aload 5
    //   113: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   116: iload_3
    //   117: ireturn
    //   118: astore 7
    //   120: aload_1
    //   121: astore 5
    //   123: aload 7
    //   125: astore_1
    //   126: goto +7 -> 133
    //   129: astore_1
    //   130: aconst_null
    //   131: astore 5
    //   133: goto +20 -> 153
    //   136: aconst_null
    //   137: astore_1
    //   138: aload 6
    //   140: astore 5
    //   142: goto +49 -> 191
    //   145: astore_1
    //   146: aconst_null
    //   147: astore 5
    //   149: aload 7
    //   151: astore 6
    //   153: aload 6
    //   155: ifnull +11 -> 166
    //   158: aload 6
    //   160: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   163: goto +3 -> 166
    //   166: aload_0
    //   167: ifnull +10 -> 177
    //   170: aload_0
    //   171: invokevirtual 229	java/io/InputStream:close	()V
    //   174: goto +3 -> 177
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: aconst_null
    //   190: astore_1
    //   191: aload 5
    //   193: ifnull +11 -> 204
    //   196: aload 5
    //   198: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   201: goto +3 -> 204
    //   204: aload_0
    //   205: ifnull +10 -> 215
    //   208: aload_0
    //   209: invokevirtual 229	java/io/InputStream:close	()V
    //   212: goto +3 -> 215
    //   215: aload_1
    //   216: ifnull +9 -> 225
    //   219: aload_1
    //   220: astore 5
    //   222: goto -111 -> 111
    //   225: iconst_0
    //   226: ireturn
    //   227: astore_1
    //   228: goto -39 -> 189
    //   231: astore_1
    //   232: goto -96 -> 136
    //   235: astore 5
    //   237: goto -99 -> 138
    //   240: astore 5
    //   242: goto -151 -> 91
    //   245: astore_0
    //   246: iload 4
    //   248: istore_3
    //   249: aload_1
    //   250: astore 5
    //   252: goto -141 -> 111
    //   255: astore_0
    //   256: iload_3
    //   257: ireturn
    //   258: astore 6
    //   260: goto -94 -> 166
    //   263: astore_0
    //   264: goto -87 -> 177
    //   267: astore_0
    //   268: goto -81 -> 187
    //   271: astore 5
    //   273: goto -69 -> 204
    //   276: astore_0
    //   277: goto -62 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramInputStream	java.io.InputStream
    //   0	280	1	paramString	String
    //   60	10	2	i	int
    //   1	256	3	bool1	boolean
    //   81	166	4	bool2	boolean
    //   11	210	5	localObject1	Object
    //   235	1	5	localException1	Exception
    //   240	1	5	localException2	Exception
    //   250	1	5	str	String
    //   271	1	5	localException3	Exception
    //   24	135	6	localObject2	Object
    //   258	1	6	localException4	Exception
    //   14	1	7	localObject3	Object
    //   118	32	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   42	49	118	finally
    //   49	61	118	finally
    //   65	73	118	finally
    //   76	80	118	finally
    //   26	42	129	finally
    //   16	26	145	finally
    //   16	26	227	java/lang/Exception
    //   26	42	231	java/lang/Exception
    //   42	49	235	java/lang/Exception
    //   49	61	235	java/lang/Exception
    //   65	73	235	java/lang/Exception
    //   76	80	235	java/lang/Exception
    //   83	88	240	java/lang/Exception
    //   101	105	245	java/lang/Exception
    //   111	116	255	java/lang/Exception
    //   158	163	258	java/lang/Exception
    //   170	174	263	java/lang/Exception
    //   182	187	267	java/lang/Exception
    //   196	201	271	java/lang/Exception
    //   208	212	276	java/lang/Exception
  }
  
  /* Error */
  public static boolean createFile(File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: ifnull +79 -> 82
    //   6: aload_0
    //   7: invokevirtual 143	java/io/File:exists	()Z
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: invokevirtual 115	java/io/File:isFile	()Z
    //   17: ifne +67 -> 84
    //   20: aload_0
    //   21: invokevirtual 252	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokestatic 107	dji/utils/FileUtils:mkdirs	(Ljava/io/File;)Z
    //   27: ifeq +55 -> 82
    //   30: aload_0
    //   31: invokevirtual 255	java/io/File:createNewFile	()Z
    //   34: pop
    //   35: aload_0
    //   36: invokevirtual 143	java/io/File:exists	()Z
    //   39: ifeq +43 -> 82
    //   42: aload_0
    //   43: invokevirtual 115	java/io/File:isFile	()Z
    //   46: ifeq +36 -> 82
    //   49: iconst_1
    //   50: ireturn
    //   51: astore_2
    //   52: aload_0
    //   53: invokevirtual 143	java/io/File:exists	()Z
    //   56: ifeq +8 -> 64
    //   59: aload_0
    //   60: invokevirtual 115	java/io/File:isFile	()Z
    //   63: pop
    //   64: aload_2
    //   65: athrow
    //   66: aload_0
    //   67: invokevirtual 143	java/io/File:exists	()Z
    //   70: ifeq +12 -> 82
    //   73: aload_0
    //   74: invokevirtual 115	java/io/File:isFile	()Z
    //   77: ifeq +5 -> 82
    //   80: iconst_1
    //   81: ireturn
    //   82: iconst_0
    //   83: istore_1
    //   84: iload_1
    //   85: ireturn
    //   86: astore_2
    //   87: goto -21 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile	File
    //   1	84	1	bool	boolean
    //   51	14	2	localObject	Object
    //   86	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	35	51	finally
    //   30	35	86	java/lang/Exception
  }
  
  public static boolean createFile(String paramString)
  {
    if (paramString != null) {
      return createFile(new File(paramString));
    }
    return false;
  }
  
  public static boolean deleteDir(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile != null)
    {
      if (!paramFile.isDirectory()) {
        return false;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.isFile())
          {
            if (!localFile.delete()) {
              return false;
            }
          }
          else if ((localFile.isDirectory()) && (!deleteDir(localFile))) {
            return false;
          }
          i += 1;
        }
      }
      return paramFile.delete();
    }
    return false;
  }
  
  public static boolean deleteDir(String paramString)
  {
    return deleteDir(getFileByPath(paramString));
  }
  
  public static boolean deleteFile(File paramFile)
  {
    return (paramFile != null) && ((!paramFile.exists()) || ((paramFile.isFile()) && (paramFile.delete())));
  }
  
  public static boolean deleteFile(String paramString)
  {
    return deleteFile(getFileByPath(paramString));
  }
  
  public static void deleteFileOnExist(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {
      paramFile.deleteOnExit();
    }
  }
  
  public static void deleteFileOnExist(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.deleteOnExit();
      }
    }
  }
  
  public static byte[] generateMD5(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[0];
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return arrayOfByte;
      }
      try
      {
        paramArrayOfByte = MessageDigest.getInstance("MD5").digest(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return arrayOfByte;
  }
  
  public static List<String> getAllFiles(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      mkdirs(paramString1);
      return Collections.emptyList();
    }
    paramString1 = localFile.listFiles(new -..Lambda.FileUtils.uPEbGg5gVtPK9qyIictQP8XH4uU(paramString2));
    if (paramString1 == null) {
      return Collections.emptyList();
    }
    paramString2 = new ArrayList();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      paramString2.add(paramString1[i].getName());
      i += 1;
    }
    return paramString2;
  }
  
  public static long getDirLength(File paramFile)
  {
    if (!isDirectory(paramFile)) {
      return -1L;
    }
    long l1 = 0L;
    paramFile = paramFile.listFiles();
    long l2 = l1;
    if (paramFile != null)
    {
      l2 = l1;
      if (paramFile.length != 0)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          File localFile = paramFile[i];
          if (localFile.isDirectory()) {
            l2 = getDirLength(localFile);
          } else {
            l2 = localFile.length();
          }
          l1 += l2;
          i += 1;
        }
      }
    }
    return l2;
  }
  
  public static long getDirLength(String paramString)
  {
    return getDirLength(getFileByPath(paramString));
  }
  
  public static String getDirName(File paramFile)
  {
    if (paramFile == null) {
      return "";
    }
    return getDirName(paramFile.getAbsolutePath());
  }
  
  public static String getDirName(String paramString)
  {
    if (hasSpace(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return "";
    }
    return paramString.substring(0, i + 1);
  }
  
  public static String getDirSize(File paramFile)
  {
    long l = getDirLength(paramFile);
    if (l == -1L) {
      return "";
    }
    return byte2FitMemorySize(l);
  }
  
  public static String getDirSize(String paramString)
  {
    return getDirSize(getFileByPath(paramString));
  }
  
  public static File getFileByPath(String paramString)
  {
    if (hasSpace(paramString)) {
      return null;
    }
    return new File(paramString);
  }
  
  public static String getFileExtension(File paramFile)
  {
    if (paramFile == null) {
      return "";
    }
    return getFileExtension(paramFile.getPath());
  }
  
  public static String getFileExtension(String paramString)
  {
    if (hasSpace(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    int j = paramString.lastIndexOf(File.separator);
    if (i != -1)
    {
      if (j >= i) {
        return "";
      }
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  public static long getFileLastModified(File paramFile)
  {
    if (paramFile == null) {
      return -1L;
    }
    return paramFile.lastModified();
  }
  
  public static long getFileLastModified(String paramString)
  {
    return getFileLastModified(getFileByPath(paramString));
  }
  
  public static long getFileLength(File paramFile)
  {
    if (!isFile(paramFile)) {
      return -1L;
    }
    return paramFile.length();
  }
  
  public static long getFileLength(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.matches("[a-zA-z]+://[^\\s]*"))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        localHttpURLConnection.connect();
        if (localHttpURLConnection.getResponseCode() == 200)
        {
          i = localHttpURLConnection.getContentLength();
          return i;
        }
        return -1L;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return getFileLength(getFileByPath(paramString));
  }
  
  /* Error */
  public static byte[] getFileMD5(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 410	java/security/DigestInputStream
    //   11: dup
    //   12: new 174	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: ldc_w 281
    //   23: invokestatic 287	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: invokespecial 413	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: ldc_w 414
    //   35: newarray <illegal type>
    //   37: astore_2
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 417	java/security/DigestInputStream:read	([B)I
    //   45: ifgt -7 -> 38
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 421	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   54: invokevirtual 424	java/security/MessageDigest:digest	()[B
    //   57: astore_2
    //   58: aload_1
    //   59: invokevirtual 425	java/security/DigestInputStream:close	()V
    //   62: aload_2
    //   63: areturn
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_2
    //   72: goto +20 -> 92
    //   75: astore_2
    //   76: goto +16 -> 92
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: goto +38 -> 120
    //   85: astore_2
    //   86: goto +4 -> 90
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: invokevirtual 426	java/lang/Exception:printStackTrace	()V
    //   98: aload_1
    //   99: ifnull +14 -> 113
    //   102: aload_1
    //   103: invokevirtual 425	java/security/DigestInputStream:close	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_2
    //   116: aload_0
    //   117: astore_1
    //   118: aload_2
    //   119: astore_0
    //   120: aload_1
    //   121: ifnull +15 -> 136
    //   124: aload_1
    //   125: invokevirtual 425	java/security/DigestInputStream:close	()V
    //   128: goto +8 -> 136
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   136: aload_0
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramFile	File
    //   29	96	1	localObject1	Object
    //   131	2	1	localIOException1	IOException
    //   1	69	2	arrayOfByte	byte[]
    //   71	1	2	localIOException2	IOException
    //   75	6	2	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   85	1	2	localIOException3	IOException
    //   89	6	2	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   115	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   58	62	64	java/io/IOException
    //   32	38	71	java/io/IOException
    //   40	48	71	java/io/IOException
    //   50	58	71	java/io/IOException
    //   32	38	75	java/security/NoSuchAlgorithmException
    //   40	48	75	java/security/NoSuchAlgorithmException
    //   50	58	75	java/security/NoSuchAlgorithmException
    //   8	30	79	finally
    //   8	30	85	java/io/IOException
    //   8	30	89	java/security/NoSuchAlgorithmException
    //   102	106	108	java/io/IOException
    //   32	38	115	finally
    //   40	48	115	finally
    //   50	58	115	finally
    //   94	98	115	finally
    //   124	128	131	java/io/IOException
  }
  
  public static byte[] getFileMD5(String paramString)
  {
    return getFileMD5(getFileByPath(paramString));
  }
  
  public static String getFileName(File paramFile)
  {
    if (paramFile == null) {
      return "";
    }
    return getFileName(paramFile.getAbsolutePath());
  }
  
  public static String getFileName(String paramString)
  {
    if (hasSpace(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFileNameNoExtension(File paramFile)
  {
    if (paramFile == null) {
      return "";
    }
    return getFileNameNoExtension(paramFile.getPath());
  }
  
  public static String getFileNameNoExtension(String paramString)
  {
    if (hasSpace(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    int j = paramString.lastIndexOf(File.separator);
    if (j == -1)
    {
      if (i == -1) {
        return paramString;
      }
      return paramString.substring(0, i);
    }
    if ((i != -1) && (j <= i)) {
      return paramString.substring(j + 1, i);
    }
    return paramString.substring(j + 1);
  }
  
  public static String getFileSize(File paramFile)
  {
    long l = getFileLength(paramFile);
    if (l == -1L) {
      return "";
    }
    return byte2FitMemorySize(l);
  }
  
  public static String getFileSize(String paramString)
  {
    long l = getFileLength(paramString);
    if (l == -1L) {
      return "";
    }
    return byte2FitMemorySize(l);
  }
  
  public static String getFileSizeInfo(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return "0B";
    }
    long l = paramString.length();
    double d = l;
    if (d < 1023.5D)
    {
      paramString = new StringBuilder();
      paramString.append(String.valueOf(l));
      paramString.append("B");
      return paramString.toString();
    }
    d /= 1024.0D;
    if (d < 1023.5D)
    {
      paramString = Locale.getDefault();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("%.");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("f%s");
      return String.format(paramString, localStringBuilder.toString(), new Object[] { Double.valueOf(d), "KB" });
    }
    d /= 1024.0D;
    if (d < 1023.5D)
    {
      paramString = Locale.getDefault();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("%.");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("f%s");
      return String.format(paramString, localStringBuilder.toString(), new Object[] { Double.valueOf(d), "MB" });
    }
    d /= 1024.0D;
    paramString = Locale.getDefault();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%.");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("f%s");
    return String.format(paramString, localStringBuilder.toString(), new Object[] { Double.valueOf(d), "GB" });
  }
  
  public static int getSubFileCount(String paramString, FilenameFilter paramFilenameFilter)
  {
    if (paramString != null)
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        paramString = paramString.listFiles(paramFilenameFilter);
        if (paramString != null) {
          return paramString.length;
        }
      }
    }
    return 0;
  }
  
  private static boolean hasSpace(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isWhitespace(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isDirectory(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isDirectory());
  }
  
  public static boolean isDirectory(String paramString)
  {
    return isDirectory(getFileByPath(paramString));
  }
  
  public static boolean isFile(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  public static boolean isFile(String paramString)
  {
    return isFile(getFileByPath(paramString));
  }
  
  public static boolean isFileExists(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    return paramFile.exists();
  }
  
  public static boolean isFileExists(String paramString)
  {
    return isFileExists(getFileByPath(paramString));
  }
  
  /* Error */
  public static boolean mkdirs(File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +166 -> 171
    //   8: aload_0
    //   9: invokevirtual 143	java/io/File:exists	()Z
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokevirtual 129	java/io/File:isDirectory	()Z
    //   19: ifne +154 -> 173
    //   22: aload_0
    //   23: invokevirtual 482	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_0
    //   28: invokevirtual 143	java/io/File:exists	()Z
    //   31: ifeq +15 -> 46
    //   34: aload_0
    //   35: invokevirtual 129	java/io/File:isDirectory	()Z
    //   38: ifeq +8 -> 46
    //   41: iconst_1
    //   42: istore_1
    //   43: goto +5 -> 48
    //   46: iconst_0
    //   47: istore_1
    //   48: iload_1
    //   49: ifne +11 -> 60
    //   52: aload_0
    //   53: invokevirtual 482	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: goto +3 -> 60
    //   60: aload_0
    //   61: invokevirtual 143	java/io/File:exists	()Z
    //   64: ifeq +107 -> 171
    //   67: aload_0
    //   68: invokevirtual 129	java/io/File:isDirectory	()Z
    //   71: ifeq +100 -> 171
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_3
    //   77: aload_0
    //   78: invokevirtual 143	java/io/File:exists	()Z
    //   81: ifeq +13 -> 94
    //   84: aload_0
    //   85: invokevirtual 129	java/io/File:isDirectory	()Z
    //   88: ifeq +6 -> 94
    //   91: goto +5 -> 96
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: ifne +11 -> 108
    //   100: aload_0
    //   101: invokevirtual 482	java/io/File:mkdirs	()Z
    //   104: pop
    //   105: goto +3 -> 108
    //   108: aload_0
    //   109: invokevirtual 143	java/io/File:exists	()Z
    //   112: ifeq +8 -> 120
    //   115: aload_0
    //   116: invokevirtual 129	java/io/File:isDirectory	()Z
    //   119: pop
    //   120: aload_3
    //   121: athrow
    //   122: aload_0
    //   123: invokevirtual 143	java/io/File:exists	()Z
    //   126: ifeq +15 -> 141
    //   129: aload_0
    //   130: invokevirtual 129	java/io/File:isDirectory	()Z
    //   133: ifeq +8 -> 141
    //   136: iconst_1
    //   137: istore_1
    //   138: goto +5 -> 143
    //   141: iconst_0
    //   142: istore_1
    //   143: iload_1
    //   144: ifne +11 -> 155
    //   147: aload_0
    //   148: invokevirtual 482	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: goto +3 -> 155
    //   155: aload_0
    //   156: invokevirtual 143	java/io/File:exists	()Z
    //   159: ifeq +12 -> 171
    //   162: aload_0
    //   163: invokevirtual 129	java/io/File:isDirectory	()Z
    //   166: ifeq +5 -> 171
    //   169: iconst_1
    //   170: ireturn
    //   171: iconst_0
    //   172: istore_2
    //   173: iload_2
    //   174: ireturn
    //   175: astore_3
    //   176: goto -54 -> 122
    //   179: astore_3
    //   180: goto -120 -> 60
    //   183: astore 4
    //   185: goto -77 -> 108
    //   188: astore_3
    //   189: goto -34 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramFile	File
    //   3	141	1	i	int
    //   1	173	2	bool	boolean
    //   76	45	3	localObject	Object
    //   175	1	3	localException1	Exception
    //   179	1	3	localException2	Exception
    //   188	1	3	localException3	Exception
    //   183	1	4	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   22	27	76	finally
    //   22	27	175	java/lang/Exception
    //   52	57	179	java/lang/Exception
    //   100	105	183	java/lang/Exception
    //   147	152	188	java/lang/Exception
  }
  
  public static boolean mkdirs(String paramString)
  {
    if (paramString != null) {
      return mkdirs(new File(paramString));
    }
    return false;
  }
  
  public static boolean moveFile(File paramFile1, File paramFile2)
  {
    if ((paramFile1 != null) && (paramFile2 != null)) {
      return paramFile1.renameTo(paramFile2);
    }
    return false;
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      File localFile1 = getFileByPath(paramString1);
      File localFile2 = getFileByPath(paramString2);
      if ((localFile1 != null) && (localFile2 != null)) {
        return getFileByPath(paramString1).renameTo(getFileByPath(paramString2));
      }
    }
    return false;
  }
  
  /* Error */
  public static String readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: aload_0
    //   7: ifnull +114 -> 121
    //   10: new 78	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: invokestatic 370	dji/utils/FileUtils:isFile	(Ljava/io/File;)Z
    //   25: ifeq +96 -> 121
    //   28: new 145	java/io/BufferedReader
    //   31: dup
    //   32: new 147	java/io/FileReader
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 488	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 491	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: new 66	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   51: astore_0
    //   52: aload_2
    //   53: invokevirtual 162	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +12 -> 70
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: goto -15 -> 52
    //   70: aload_0
    //   71: astore_1
    //   72: aload_2
    //   73: invokevirtual 171	java/io/BufferedReader:close	()V
    //   76: aload_0
    //   77: astore_1
    //   78: goto +43 -> 121
    //   81: astore_0
    //   82: goto +11 -> 93
    //   85: aconst_null
    //   86: astore_0
    //   87: goto +20 -> 107
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 171	java/io/BufferedReader:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_3
    //   106: astore_2
    //   107: aload_0
    //   108: astore_1
    //   109: aload_2
    //   110: ifnull +11 -> 121
    //   113: aload_0
    //   114: astore_1
    //   115: aload_2
    //   116: invokevirtual 171	java/io/BufferedReader:close	()V
    //   119: aload_0
    //   120: astore_1
    //   121: aload_1
    //   122: ifnonnull +7 -> 129
    //   125: ldc_w 334
    //   128: areturn
    //   129: aload_1
    //   130: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: areturn
    //   134: astore_0
    //   135: goto -32 -> 103
    //   138: astore_0
    //   139: goto -54 -> 85
    //   142: astore_1
    //   143: goto -56 -> 87
    //   146: astore_0
    //   147: goto -26 -> 121
    //   150: astore_1
    //   151: goto -50 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   5	125	1	localObject1	Object
    //   142	1	1	localException1	Exception
    //   150	1	1	localException2	Exception
    //   1	115	2	localObject2	Object
    //   3	103	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	52	81	finally
    //   52	57	81	finally
    //   61	67	81	finally
    //   28	44	90	finally
    //   28	44	134	java/lang/Exception
    //   44	52	138	java/lang/Exception
    //   52	57	142	java/lang/Exception
    //   61	67	142	java/lang/Exception
    //   72	76	146	java/lang/Exception
    //   115	119	146	java/lang/Exception
    //   97	101	150	java/lang/Exception
  }
  
  /* Error */
  public static byte[] readFileToBytes(String paramString)
  {
    // Byte code:
    //   0: new 78	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 143	java/io/File:exists	()Z
    //   13: ifne +7 -> 20
    //   16: iconst_0
    //   17: newarray <illegal type>
    //   19: areturn
    //   20: new 174	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 184	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: invokevirtual 497	java/nio/channels/FileChannel:size	()J
    //   36: lstore_1
    //   37: lload_1
    //   38: lconst_0
    //   39: lcmp
    //   40: ifne +9 -> 49
    //   43: aload_0
    //   44: invokevirtual 212	java/io/FileInputStream:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: invokevirtual 500	java/io/FileInputStream:available	()I
    //   53: newarray <illegal type>
    //   55: astore_3
    //   56: aload_0
    //   57: aload_3
    //   58: invokevirtual 501	java/io/FileInputStream:read	([B)I
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 212	java/io/FileInputStream:close	()V
    //   66: aload_3
    //   67: areturn
    //   68: astore_3
    //   69: aload_3
    //   70: athrow
    //   71: astore 4
    //   73: aload_0
    //   74: invokevirtual 212	java/io/FileInputStream:close	()V
    //   77: goto +9 -> 86
    //   80: astore_0
    //   81: aload_3
    //   82: aload_0
    //   83: invokevirtual 507	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   86: aload 4
    //   88: athrow
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   94: iconst_0
    //   95: newarray <illegal type>
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 508	java/io/FileNotFoundException:printStackTrace	()V
    //   103: iconst_0
    //   104: newarray <illegal type>
    //   106: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   36	2	1	l	long
    //   55	12	3	arrayOfByte	byte[]
    //   68	14	3	localObject1	Object
    //   71	16	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	37	68	finally
    //   49	62	68	finally
    //   69	71	71	finally
    //   73	77	80	finally
    //   20	29	89	java/io/IOException
    //   43	47	89	java/io/IOException
    //   62	66	89	java/io/IOException
    //   81	86	89	java/io/IOException
    //   86	89	89	java/io/IOException
    //   20	29	98	java/io/FileNotFoundException
    //   43	47	98	java/io/FileNotFoundException
    //   62	66	98	java/io/FileNotFoundException
    //   81	86	98	java/io/FileNotFoundException
    //   86	89	98	java/io/FileNotFoundException
  }
  
  public static boolean rename(File paramFile, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        if (hasSpace(paramString)) {
          return false;
        }
        if (paramString.equals(paramFile.getName())) {
          return true;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getParent());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString);
        paramString = new File(localStringBuilder.toString());
        bool1 = bool2;
        if (!paramString.exists())
        {
          bool1 = bool2;
          if (paramFile.renameTo(paramString)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    return rename(getFileByPath(paramString1), paramString2);
  }
  
  /* Error */
  public static void saveBitmpToFile(android.graphics.Bitmap paramBitmap, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 78	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: aload_2
    //   6: invokespecial 522	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: invokevirtual 143	java/io/File:exists	()Z
    //   14: ifne +16 -> 30
    //   17: aload_1
    //   18: invokevirtual 255	java/io/File:createNewFile	()Z
    //   21: pop
    //   22: goto +8 -> 30
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   30: new 179	java/io/FileOutputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 523	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: astore_1
    //   39: new 235	java/io/BufferedOutputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 238	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore_2
    //   48: aload_0
    //   49: getstatic 529	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   52: bipush 100
    //   54: aload_2
    //   55: invokevirtual 535	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   63: aload_1
    //   64: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   67: return
    //   68: astore_0
    //   69: aload_0
    //   70: athrow
    //   71: astore_3
    //   72: aload_2
    //   73: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   76: goto +9 -> 85
    //   79: astore_2
    //   80: aload_0
    //   81: aload_2
    //   82: invokevirtual 507	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   85: aload_3
    //   86: athrow
    //   87: astore_0
    //   88: aload_0
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   95: goto +9 -> 104
    //   98: astore_1
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 507	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   111: return
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 508	java/io/FileNotFoundException:printStackTrace	()V
    //   117: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramBitmap	android.graphics.Bitmap
    //   0	118	1	paramString1	String
    //   0	118	2	paramString2	String
    //   71	15	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	22	25	java/io/IOException
    //   48	59	68	finally
    //   69	71	71	finally
    //   72	76	79	finally
    //   39	48	87	finally
    //   59	63	87	finally
    //   80	85	87	finally
    //   85	87	87	finally
    //   88	90	90	finally
    //   91	95	98	finally
    //   30	39	106	java/io/IOException
    //   63	67	106	java/io/IOException
    //   99	104	106	java/io/IOException
    //   104	106	106	java/io/IOException
    //   30	39	112	java/io/FileNotFoundException
    //   63	67	112	java/io/FileNotFoundException
    //   99	104	112	java/io/FileNotFoundException
    //   104	106	112	java/io/FileNotFoundException
  }
  
  public static void scanFile4Delete(String paramString)
  {
    Application localApplication = AppUtils.getApp();
    MediaScannerConnection.OnScanCompletedListener local1 = new MediaScannerConnection.OnScanCompletedListener()
    {
      public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri) {}
    };
    MediaScannerConnection.scanFile(localApplication, new String[] { paramString }, null, local1);
  }
  
  public static List<String> searchNameInSubFile(String paramString1, FilenameFilter paramFilenameFilter, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString1 != null)
    {
      Object localObject = new File(paramString1);
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        paramFilenameFilter = ((File)localObject).list(paramFilenameFilter);
        int j = 0;
        int i;
        if (paramFilenameFilter != null) {
          i = paramFilenameFilter.length;
        } else {
          i = 0;
        }
        while (j < i)
        {
          if (paramFilenameFilter[j].contains(paramString2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(paramFilenameFilter[j]);
            localArrayList.add(((StringBuilder)localObject).toString());
          }
          j += 1;
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static void writeBytesToFile(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 179	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: iload_2
    //   11: invokespecial 565	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: astore_0
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 568	java/io/FileOutputStream:write	([B)V
    //   20: aload_0
    //   21: invokevirtual 569	java/io/FileOutputStream:flush	()V
    //   24: aload_0
    //   25: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: astore_3
    //   32: aload_1
    //   33: astore_0
    //   34: goto +36 -> 70
    //   37: astore_1
    //   38: goto +11 -> 49
    //   41: astore_0
    //   42: goto +28 -> 70
    //   45: astore_1
    //   46: aload 4
    //   48: astore_0
    //   49: aload_0
    //   50: astore_3
    //   51: aload_1
    //   52: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   55: aload_0
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   63: return
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   69: return
    //   70: aload_3
    //   71: ifnull +15 -> 86
    //   74: aload_3
    //   75: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   78: goto +8 -> 86
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 404	java/io/IOException:printStackTrace	()V
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramFile	File
    //   0	88	1	paramArrayOfByte	byte[]
    //   0	88	2	paramBoolean	boolean
    //   4	71	3	localFile	File
    //   1	46	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	24	29	finally
    //   15	24	37	java/io/IOException
    //   5	15	41	finally
    //   51	55	41	finally
    //   5	15	45	java/io/IOException
    //   24	28	64	java/io/IOException
    //   59	63	64	java/io/IOException
    //   74	78	81	java/io/IOException
  }
  
  /* Error */
  public static boolean writeBytesToFile(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +167 -> 168
    //   4: aload_0
    //   5: invokestatic 258	dji/utils/FileUtils:createFile	(Ljava/io/File;)Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: sipush 4096
    //   16: newarray <illegal type>
    //   18: astore 6
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 5
    //   26: new 572	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 574	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore_3
    //   35: new 179	java/io/FileOutputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 523	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: astore_1
    //   44: aload 5
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 185	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   51: invokevirtual 578	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_0
    //   59: aload_3
    //   60: aload 6
    //   62: invokevirtual 579	java/io/ByteArrayInputStream:read	([B)I
    //   65: istore_2
    //   66: iload_2
    //   67: iconst_m1
    //   68: if_icmpeq +17 -> 85
    //   71: aload 4
    //   73: astore_0
    //   74: aload_1
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_2
    //   79: invokevirtual 580	java/io/FileOutputStream:write	([BII)V
    //   82: goto -26 -> 56
    //   85: aload 4
    //   87: astore_0
    //   88: aload_1
    //   89: invokevirtual 569	java/io/FileOutputStream:flush	()V
    //   92: aload 4
    //   94: ifnull +8 -> 102
    //   97: aload 4
    //   99: invokevirtual 585	java/nio/channels/FileLock:release	()V
    //   102: aload_1
    //   103: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 586	java/io/ByteArrayInputStream:close	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore 5
    //   114: aload_0
    //   115: astore 4
    //   117: aload 5
    //   119: astore_0
    //   120: goto +14 -> 134
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_1
    //   126: goto +8 -> 134
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: astore_3
    //   134: aload 4
    //   136: ifnull +11 -> 147
    //   139: aload 4
    //   141: invokevirtual 585	java/nio/channels/FileLock:release	()V
    //   144: goto +3 -> 147
    //   147: aload_1
    //   148: ifnull +10 -> 158
    //   151: aload_1
    //   152: invokevirtual 213	java/io/FileOutputStream:close	()V
    //   155: goto +3 -> 158
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 586	java/io/ByteArrayInputStream:close	()V
    //   166: aload_0
    //   167: athrow
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: goto -69 -> 102
    //   174: astore_0
    //   175: goto -69 -> 106
    //   178: astore_0
    //   179: iconst_1
    //   180: ireturn
    //   181: astore 4
    //   183: goto -36 -> 147
    //   186: astore_1
    //   187: goto -29 -> 158
    //   190: astore_1
    //   191: goto -25 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramFile	File
    //   0	194	1	paramArrayOfByte	byte[]
    //   65	14	2	i	int
    //   34	129	3	localObject1	Object
    //   21	119	4	localObject2	Object
    //   181	1	4	localIOException	IOException
    //   24	21	5	localObject3	Object
    //   112	6	5	localObject4	Object
    //   18	58	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   47	56	112	finally
    //   59	66	112	finally
    //   74	82	112	finally
    //   88	92	112	finally
    //   35	44	123	finally
    //   26	35	129	finally
    //   97	102	170	java/io/IOException
    //   102	106	174	java/io/IOException
    //   106	110	178	java/io/IOException
    //   139	144	181	java/io/IOException
    //   151	155	186	java/io/IOException
    //   162	166	190	java/io/IOException
  }
  
  /* Error */
  public static boolean writeFileByMapping(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +195 -> 196
    //   4: aload_0
    //   5: invokestatic 591	dji/utils/FileUtils:isFile	(Ljava/lang/String;)Z
    //   8: ifeq +188 -> 196
    //   11: aload_1
    //   12: ifnull +184 -> 196
    //   15: aload_1
    //   16: invokevirtual 71	java/lang/String:length	()I
    //   19: ifle +177 -> 196
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: new 593	java/io/RandomAccessFile
    //   36: dup
    //   37: aload_0
    //   38: ldc_w 595
    //   41: invokespecial 596	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 7
    //   48: astore_0
    //   49: aload 6
    //   51: astore_3
    //   52: aload 4
    //   54: invokevirtual 597	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   57: astore 5
    //   59: aload 5
    //   61: astore_0
    //   62: aload 5
    //   64: astore_3
    //   65: aload 5
    //   67: getstatic 603	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   70: lconst_0
    //   71: aload_1
    //   72: invokevirtual 71	java/lang/String:length	()I
    //   75: iconst_4
    //   76: iadd
    //   77: i2l
    //   78: invokevirtual 607	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   81: astore 6
    //   83: aload 5
    //   85: astore_0
    //   86: aload 5
    //   88: astore_3
    //   89: aload 6
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual 610	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   96: invokevirtual 616	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   99: pop
    //   100: aload 5
    //   102: astore_0
    //   103: aload 5
    //   105: astore_3
    //   106: aload 6
    //   108: invokevirtual 619	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   111: pop
    //   112: aload 5
    //   114: ifnull +8 -> 122
    //   117: aload 5
    //   119: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   122: aload 4
    //   124: invokevirtual 620	java/io/RandomAccessFile:close	()V
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_2
    //   130: aload_0
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: goto +12 -> 146
    //   137: goto +38 -> 175
    //   140: astore_0
    //   141: aconst_null
    //   142: astore 4
    //   144: aload_3
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   154: goto +3 -> 157
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 620	java/io/RandomAccessFile:close	()V
    //   167: aload_0
    //   168: athrow
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 5
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull +10 -> 186
    //   179: aload_3
    //   180: invokevirtual 211	java/nio/channels/FileChannel:close	()V
    //   183: goto +3 -> 186
    //   186: aload 4
    //   188: ifnull +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 620	java/io/RandomAccessFile:close	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_0
    //   199: goto -30 -> 169
    //   202: astore_0
    //   203: goto -66 -> 137
    //   206: astore_0
    //   207: goto -85 -> 122
    //   210: astore_0
    //   211: iconst_1
    //   212: ireturn
    //   213: astore_1
    //   214: goto -57 -> 157
    //   217: astore_1
    //   218: goto -51 -> 167
    //   221: astore_0
    //   222: goto -36 -> 186
    //   225: astore_0
    //   226: goto -30 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString1	String
    //   0	229	1	paramString2	String
    //   0	229	2	paramString3	String
    //   23	157	3	localObject1	Object
    //   44	148	4	localRandomAccessFile	java.io.RandomAccessFile
    //   25	148	5	localFileChannel	java.nio.channels.FileChannel
    //   28	79	6	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   31	16	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	129	finally
    //   65	83	129	finally
    //   89	100	129	finally
    //   106	112	129	finally
    //   33	46	140	finally
    //   33	46	198	java/lang/Exception
    //   52	59	202	java/lang/Exception
    //   65	83	202	java/lang/Exception
    //   89	100	202	java/lang/Exception
    //   106	112	202	java/lang/Exception
    //   117	122	206	java/lang/Exception
    //   122	127	210	java/lang/Exception
    //   150	154	213	java/lang/Exception
    //   162	167	217	java/lang/Exception
    //   179	183	221	java/lang/Exception
    //   191	196	225	java/lang/Exception
  }
  
  public static boolean writeStringToFile(File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    if (paramString1 == null) {
      return false;
    }
    return writeBytesToFile(paramFile, paramString1.getBytes(paramString2));
  }
  
  /* Error */
  public static boolean writeToFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +93 -> 94
    //   4: aload_0
    //   5: invokestatic 628	dji/utils/FileUtils:createFile	(Ljava/lang/String;)Z
    //   8: ifeq +86 -> 94
    //   11: aload_1
    //   12: ifnull +82 -> 94
    //   15: aload_1
    //   16: invokevirtual 71	java/lang/String:length	()I
    //   19: ifle +75 -> 94
    //   22: aconst_null
    //   23: astore 4
    //   25: aconst_null
    //   26: astore_3
    //   27: new 153	java/io/BufferedWriter
    //   30: dup
    //   31: new 155	java/io/FileWriter
    //   34: dup
    //   35: aload_0
    //   36: iload_2
    //   37: invokespecial 631	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   40: sipush 1024
    //   43: invokespecial 159	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   46: astore_0
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 165	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 168	java/io/BufferedWriter:flush	()V
    //   56: aload_0
    //   57: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_3
    //   63: aload_0
    //   64: astore_1
    //   65: aload_3
    //   66: astore_0
    //   67: goto +9 -> 76
    //   70: goto +16 -> 86
    //   73: astore_0
    //   74: aload_3
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   84: aload_0
    //   85: athrow
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_0
    //   97: aload 4
    //   99: astore_0
    //   100: goto -14 -> 86
    //   103: astore_1
    //   104: goto -34 -> 70
    //   107: astore_0
    //   108: iconst_1
    //   109: ireturn
    //   110: astore_1
    //   111: goto -27 -> 84
    //   114: astore_0
    //   115: goto -21 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString1	String
    //   0	118	1	paramString2	String
    //   0	118	2	paramBoolean	boolean
    //   26	1	3	localObject1	Object
    //   62	13	3	localObject2	Object
    //   23	75	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	56	62	finally
    //   27	47	73	finally
    //   27	47	96	java/lang/Exception
    //   47	56	103	java/lang/Exception
    //   56	60	107	java/lang/Exception
    //   80	84	110	java/lang/Exception
    //   90	94	114	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */