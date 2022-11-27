package dji.thirdparty.sanselan.util;

import dji.thirdparty.sanselan.SanselanConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils
  implements SanselanConstants
{
  /* Error */
  public static final boolean copyFileNio(File paramFile1, File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: new 17	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 20	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: invokevirtual 24	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   11: astore 6
    //   13: new 26	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 27	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: invokevirtual 28	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: astore 7
    //   26: aload 6
    //   28: invokevirtual 34	java/nio/channels/FileChannel:size	()J
    //   31: lstore 4
    //   33: lconst_0
    //   34: lstore_2
    //   35: lload_2
    //   36: lload 4
    //   38: lcmp
    //   39: ifge +20 -> 59
    //   42: lload_2
    //   43: aload 6
    //   45: lload_2
    //   46: ldc 35
    //   48: i2l
    //   49: aload 7
    //   51: invokevirtual 39	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   54: ladd
    //   55: lstore_2
    //   56: goto -21 -> 35
    //   59: aload 6
    //   61: invokevirtual 42	java/nio/channels/FileChannel:close	()V
    //   64: aload 7
    //   66: invokevirtual 42	java/nio/channels/FileChannel:close	()V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_0
    //   72: aconst_null
    //   73: astore_1
    //   74: aload 7
    //   76: astore 6
    //   78: goto +35 -> 113
    //   81: astore_0
    //   82: aload 6
    //   84: astore_1
    //   85: aload 7
    //   87: astore 6
    //   89: goto +24 -> 113
    //   92: astore_0
    //   93: aconst_null
    //   94: astore 7
    //   96: aload 6
    //   98: astore_1
    //   99: aload 7
    //   101: astore 6
    //   103: goto +10 -> 113
    //   106: astore_0
    //   107: aconst_null
    //   108: astore 6
    //   110: aload 6
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +15 -> 129
    //   117: aload_1
    //   118: invokevirtual 42	java/nio/channels/FileChannel:close	()V
    //   121: goto +8 -> 129
    //   124: astore_1
    //   125: aload_1
    //   126: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   129: aload 6
    //   131: ifnull +16 -> 147
    //   134: aload 6
    //   136: invokevirtual 42	java/nio/channels/FileChannel:close	()V
    //   139: goto +8 -> 147
    //   142: astore_1
    //   143: aload_1
    //   144: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   147: aload_0
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramFile1	File
    //   0	149	1	paramFile2	File
    //   34	22	2	l1	long
    //   31	6	4	l2	long
    //   11	124	6	localObject	Object
    //   24	76	7	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   64	69	71	finally
    //   26	33	81	finally
    //   42	56	81	finally
    //   59	64	81	finally
    //   13	26	92	finally
    //   0	13	106	finally
    //   117	121	124	java/io/IOException
    //   134	139	142	java/io/IOException
  }
  
  public static void copyStreamToStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    copyStreamToStream(paramInputStream, paramOutputStream, true);
  }
  
  /* Error */
  public static void copyStreamToStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 56	java/io/BufferedInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore 4
    //   13: new 61	java/io/BufferedOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 64	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_0
    //   22: sipush 4096
    //   25: newarray <illegal type>
    //   27: astore 5
    //   29: aload 4
    //   31: aload 5
    //   33: iconst_0
    //   34: sipush 4096
    //   37: invokevirtual 68	java/io/BufferedInputStream:read	([BII)I
    //   40: istore_3
    //   41: iload_3
    //   42: ifle +14 -> 56
    //   45: aload_1
    //   46: aload 5
    //   48: iconst_0
    //   49: iload_3
    //   50: invokevirtual 74	java/io/OutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: aload_0
    //   57: invokevirtual 77	java/io/BufferedOutputStream:flush	()V
    //   60: iload_2
    //   61: ifeq +26 -> 87
    //   64: aload 4
    //   66: invokevirtual 78	java/io/BufferedInputStream:close	()V
    //   69: goto +8 -> 77
    //   72: astore_1
    //   73: aload_1
    //   74: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   77: aload_0
    //   78: invokevirtual 79	java/io/BufferedOutputStream:close	()V
    //   81: return
    //   82: astore_0
    //   83: aload_0
    //   84: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   87: return
    //   88: astore 5
    //   90: aload_0
    //   91: astore_1
    //   92: aload 5
    //   94: astore_0
    //   95: goto +6 -> 101
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_1
    //   101: goto +10 -> 111
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: aload 5
    //   109: astore 4
    //   111: iload_2
    //   112: ifeq +39 -> 151
    //   115: aload 4
    //   117: ifnull +18 -> 135
    //   120: aload 4
    //   122: invokevirtual 78	java/io/BufferedInputStream:close	()V
    //   125: goto +10 -> 135
    //   128: astore 4
    //   130: aload 4
    //   132: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   135: aload_1
    //   136: ifnull +15 -> 151
    //   139: aload_1
    //   140: invokevirtual 79	java/io/BufferedOutputStream:close	()V
    //   143: goto +8 -> 151
    //   146: astore_1
    //   147: aload_1
    //   148: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramInputStream	InputStream
    //   0	153	1	paramOutputStream	OutputStream
    //   0	153	2	paramBoolean	boolean
    //   40	10	3	i	int
    //   11	110	4	localObject1	Object
    //   128	3	4	localIOException	IOException
    //   1	46	5	arrayOfByte	byte[]
    //   88	20	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   64	69	72	java/io/IOException
    //   77	81	82	java/io/IOException
    //   22	29	88	finally
    //   29	41	88	finally
    //   45	53	88	finally
    //   56	60	88	finally
    //   13	22	98	finally
    //   3	13	104	finally
    //   120	125	128	java/io/IOException
    //   139	143	146	java/io/IOException
  }
  
  /* Error */
  public static byte[] getFileBytes(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 17	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 20	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 85	dji/thirdparty/sanselan/util/IOUtils:getInputStreamBytes	(Ljava/io/InputStream;)[B
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual 88	java/io/InputStream:close	()V
    //   20: aload_1
    //   21: areturn
    //   22: astore_0
    //   23: aload_0
    //   24: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   27: aload_1
    //   28: areturn
    //   29: astore_2
    //   30: aload_0
    //   31: astore_1
    //   32: aload_2
    //   33: astore_0
    //   34: goto +4 -> 38
    //   37: astore_0
    //   38: aload_1
    //   39: ifnull +15 -> 54
    //   42: aload_1
    //   43: invokevirtual 88	java/io/InputStream:close	()V
    //   46: goto +8 -> 54
    //   49: astore_1
    //   50: aload_1
    //   51: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramFile	File
    //   1	42	1	localObject1	Object
    //   49	2	1	localIOException	IOException
    //   29	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	20	22	java/io/IOException
    //   11	16	29	finally
    //   2	11	37	finally
    //   42	46	49	java/io/IOException
  }
  
  /* Error */
  public static byte[] getInputStreamBytes(InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 90	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: sipush 4096
    //   9: invokespecial 93	java/io/ByteArrayOutputStream:<init>	(I)V
    //   12: astore_2
    //   13: new 56	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_0
    //   22: sipush 4096
    //   25: newarray <illegal type>
    //   27: astore_3
    //   28: aload_0
    //   29: aload_3
    //   30: iconst_0
    //   31: sipush 4096
    //   34: invokevirtual 94	java/io/InputStream:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: ifle +13 -> 52
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 95	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -21 -> 28
    //   52: aload_2
    //   53: invokevirtual 96	java/io/ByteArrayOutputStream:flush	()V
    //   56: aload_2
    //   57: invokevirtual 100	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   65: aload_0
    //   66: areturn
    //   67: astore_2
    //   68: aload_2
    //   69: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   72: aload_0
    //   73: areturn
    //   74: astore_0
    //   75: goto +6 -> 81
    //   78: astore_0
    //   79: aload_3
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +15 -> 97
    //   85: aload_2
    //   86: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   89: goto +8 -> 97
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramInputStream	InputStream
    //   37	9	1	i	int
    //   12	50	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   67	2	2	localIOException1	IOException
    //   80	6	2	arrayOfByte1	byte[]
    //   92	2	2	localIOException2	IOException
    //   1	79	3	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/io/IOException
    //   13	28	74	finally
    //   28	38	74	finally
    //   42	49	74	finally
    //   52	61	74	finally
    //   2	13	78	finally
    //   85	89	92	java/io/IOException
  }
  
  public static void putInputStreamToFile(InputStream paramInputStream, File paramFile)
    throws IOException
  {
    Object localObject = null;
    try
    {
      if (paramFile.getParentFile() != null) {
        paramFile.getParentFile().mkdirs();
      }
      paramFile = new FileOutputStream(paramFile);
      try
      {
        copyStreamToStream(paramInputStream, paramFile);
        try
        {
          paramFile.close();
          return;
        }
        catch (Exception paramInputStream)
        {
          Debug.debug(paramInputStream);
          return;
        }
        paramInputStream = finally;
      }
      finally {}
      if (paramFile == null) {
        break label65;
      }
    }
    finally {}
    try
    {
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      Debug.debug(paramFile);
    }
    label65:
    throw paramInputStream;
  }
  
  /* Error */
  public static void writeToFile(byte[] paramArrayOfByte, File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 122	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 125	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore_0
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 127	dji/thirdparty/sanselan/util/IOUtils:putInputStreamToFile	(Ljava/io/InputStream;Ljava/io/File;)V
    //   16: aload_0
    //   17: invokevirtual 128	java/io/ByteArrayInputStream:close	()V
    //   20: return
    //   21: astore_0
    //   22: aload_0
    //   23: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   26: return
    //   27: astore_2
    //   28: aload_0
    //   29: astore_1
    //   30: aload_2
    //   31: astore_0
    //   32: goto +6 -> 38
    //   35: astore_0
    //   36: aload_2
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +15 -> 54
    //   42: aload_1
    //   43: invokevirtual 128	java/io/ByteArrayInputStream:close	()V
    //   46: goto +8 -> 54
    //   49: astore_1
    //   50: aload_1
    //   51: invokestatic 48	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramArrayOfByte	byte[]
    //   0	56	1	paramFile	File
    //   1	1	2	localObject1	Object
    //   27	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	20	21	java/lang/Exception
    //   11	16	27	finally
    //   2	11	35	finally
    //   42	46	49	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */