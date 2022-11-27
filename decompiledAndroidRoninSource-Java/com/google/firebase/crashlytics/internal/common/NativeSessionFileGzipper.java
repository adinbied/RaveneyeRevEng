package com.google.firebase.crashlytics.internal.common;

class NativeSessionFileGzipper
{
  /* Error */
  private static void gzipInputStream(java.io.InputStream paramInputStream, java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: sipush 8192
    //   8: newarray <illegal type>
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: new 15	java/util/zip/GZIPOutputStream
    //   17: dup
    //   18: new 17	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 20	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: invokespecial 23	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore_1
    //   30: aload_0
    //   31: aload 4
    //   33: invokevirtual 29	java/io/InputStream:read	([B)I
    //   36: istore_2
    //   37: iload_2
    //   38: ifle +14 -> 52
    //   41: aload_1
    //   42: aload 4
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 33	java/util/zip/GZIPOutputStream:write	([BII)V
    //   49: goto -19 -> 30
    //   52: aload_1
    //   53: invokevirtual 36	java/util/zip/GZIPOutputStream:finish	()V
    //   56: aload_1
    //   57: invokestatic 42	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   60: return
    //   61: astore_3
    //   62: aload_1
    //   63: astore_0
    //   64: aload_3
    //   65: astore_1
    //   66: goto +6 -> 72
    //   69: astore_1
    //   70: aload_3
    //   71: astore_0
    //   72: aload_0
    //   73: invokestatic 42	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramInputStream	java.io.InputStream
    //   0	78	1	paramFile	java.io.File
    //   36	10	2	i	int
    //   13	1	3	localObject1	Object
    //   61	10	3	localObject2	Object
    //   10	33	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	37	61	finally
    //   41	49	61	finally
    //   52	56	61	finally
    //   14	30	69	finally
  }
  
  /* Error */
  static void processNativeSessions(java.io.File paramFile, java.util.List<NativeSessionFile> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 51 1 0
    //   6: astore 4
    //   8: aload 4
    //   10: invokeinterface 57 1 0
    //   15: ifeq +75 -> 90
    //   18: aload 4
    //   20: invokeinterface 61 1 0
    //   25: checkcast 63	com/google/firebase/crashlytics/internal/common/NativeSessionFile
    //   28: astore 5
    //   30: aconst_null
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_3
    //   34: aload 5
    //   36: invokeinterface 67 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +12 -> 55
    //   46: aload_2
    //   47: astore_1
    //   48: aload_1
    //   49: invokestatic 42	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   52: goto -44 -> 8
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: new 69	java/io/File
    //   63: dup
    //   64: aload_0
    //   65: aload 5
    //   67: invokeinterface 73 1 0
    //   72: invokespecial 76	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: invokestatic 78	com/google/firebase/crashlytics/internal/common/NativeSessionFileGzipper:gzipInputStream	(Ljava/io/InputStream;Ljava/io/File;)V
    //   78: aload_2
    //   79: astore_1
    //   80: goto -32 -> 48
    //   83: astore_0
    //   84: aload_3
    //   85: invokestatic 42	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   88: aload_0
    //   89: athrow
    //   90: return
    //   91: astore_2
    //   92: goto -44 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramFile	java.io.File
    //   0	95	1	paramList	java.util.List<NativeSessionFile>
    //   41	38	2	localInputStream	java.io.InputStream
    //   91	1	2	localIOException	java.io.IOException
    //   33	52	3	localObject	Object
    //   6	13	4	localIterator	java.util.Iterator
    //   28	38	5	localNativeSessionFile	NativeSessionFile
    // Exception table:
    //   from	to	target	type
    //   34	42	83	finally
    //   59	78	83	finally
    //   34	42	91	java/io/IOException
    //   59	78	91	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\NativeSessionFileGzipper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */