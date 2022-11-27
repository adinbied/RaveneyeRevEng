package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class FileBackedNativeSessionFile
  implements NativeSessionFile
{
  private final String dataTransportFilename;
  private final File file;
  private final String reportsEndpointFilename;
  
  FileBackedNativeSessionFile(String paramString1, String paramString2, File paramFile)
  {
    this.dataTransportFilename = paramString1;
    this.reportsEndpointFilename = paramString2;
    this.file = paramFile;
  }
  
  /* Error */
  private byte[] asGzippedBytes()
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray <illegal type>
    //   5: astore 5
    //   7: aload_0
    //   8: invokevirtual 31	com/google/firebase/crashlytics/internal/common/FileBackedNativeSessionFile:getStream	()Ljava/io/InputStream;
    //   11: astore_2
    //   12: new 33	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 34	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_3
    //   20: new 36	java/util/zip/GZIPOutputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 39	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore 4
    //   30: aload_2
    //   31: ifnonnull +22 -> 53
    //   34: aload 4
    //   36: invokevirtual 42	java/util/zip/GZIPOutputStream:close	()V
    //   39: aload_3
    //   40: invokevirtual 43	java/io/ByteArrayOutputStream:close	()V
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 46	java/io/InputStream:close	()V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_2
    //   54: aload 5
    //   56: invokevirtual 50	java/io/InputStream:read	([B)I
    //   59: istore_1
    //   60: iload_1
    //   61: ifle +15 -> 76
    //   64: aload 4
    //   66: aload 5
    //   68: iconst_0
    //   69: iload_1
    //   70: invokevirtual 54	java/util/zip/GZIPOutputStream:write	([BII)V
    //   73: goto -20 -> 53
    //   76: aload 4
    //   78: invokevirtual 57	java/util/zip/GZIPOutputStream:finish	()V
    //   81: aload_3
    //   82: invokevirtual 60	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   85: astore 5
    //   87: aload 4
    //   89: invokevirtual 42	java/util/zip/GZIPOutputStream:close	()V
    //   92: aload_3
    //   93: invokevirtual 43	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 46	java/io/InputStream:close	()V
    //   104: aload 5
    //   106: areturn
    //   107: astore 5
    //   109: aload 4
    //   111: invokevirtual 42	java/util/zip/GZIPOutputStream:close	()V
    //   114: aload 5
    //   116: athrow
    //   117: astore 4
    //   119: aload_3
    //   120: invokevirtual 43	java/io/ByteArrayOutputStream:close	()V
    //   123: aload 4
    //   125: athrow
    //   126: astore_3
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 46	java/io/InputStream:close	()V
    //   135: aload_3
    //   136: athrow
    //   137: astore_2
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: goto -28 -> 114
    //   145: astore_3
    //   146: goto -23 -> 123
    //   149: astore_2
    //   150: goto -15 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	FileBackedNativeSessionFile
    //   59	11	1	i	int
    //   11	121	2	localInputStream	InputStream
    //   137	1	2	localIOException	java.io.IOException
    //   149	1	2	localObject1	Object
    //   19	101	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   126	10	3	localObject2	Object
    //   145	1	3	localObject3	Object
    //   28	82	4	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   117	7	4	localObject4	Object
    //   140	1	4	localObject5	Object
    //   5	100	5	arrayOfByte	byte[]
    //   107	8	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	107	finally
    //   64	73	107	finally
    //   76	87	107	finally
    //   20	30	117	finally
    //   34	39	117	finally
    //   87	92	117	finally
    //   114	117	117	finally
    //   12	20	126	finally
    //   39	43	126	finally
    //   92	96	126	finally
    //   123	126	126	finally
    //   7	12	137	java/io/IOException
    //   47	51	137	java/io/IOException
    //   100	104	137	java/io/IOException
    //   135	137	137	java/io/IOException
    //   109	114	140	finally
    //   119	123	145	finally
    //   131	135	149	finally
  }
  
  public CrashlyticsReport.FilesPayload.File asFilePayload()
  {
    byte[] arrayOfByte = asGzippedBytes();
    if (arrayOfByte != null) {
      return CrashlyticsReport.FilesPayload.File.builder().setContents(arrayOfByte).setFilename(this.dataTransportFilename).build();
    }
    return null;
  }
  
  public String getReportsEndpointFilename()
  {
    return this.reportsEndpointFilename;
  }
  
  public InputStream getStream()
  {
    if (this.file.exists()) {
      if (!this.file.isFile()) {
        return null;
      }
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.file);
      return localFileInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\FileBackedNativeSessionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */