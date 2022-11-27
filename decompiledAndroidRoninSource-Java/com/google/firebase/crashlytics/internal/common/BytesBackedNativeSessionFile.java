package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class BytesBackedNativeSessionFile
  implements NativeSessionFile
{
  private final byte[] bytes;
  private final String dataTransportFilename;
  private final String reportsEndpointFilename;
  
  BytesBackedNativeSessionFile(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.dataTransportFilename = paramString1;
    this.reportsEndpointFilename = paramString2;
    this.bytes = paramArrayOfByte;
  }
  
  /* Error */
  private byte[] asGzippedBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 31	com/google/firebase/crashlytics/internal/common/BytesBackedNativeSessionFile:isEmpty	()Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 33	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 34	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: new 36	java/util/zip/GZIPOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 39	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 22	com/google/firebase/crashlytics/internal/common/BytesBackedNativeSessionFile:bytes	[B
    //   31: invokevirtual 43	java/util/zip/GZIPOutputStream:write	([B)V
    //   34: aload_2
    //   35: invokevirtual 46	java/util/zip/GZIPOutputStream:finish	()V
    //   38: aload_1
    //   39: invokevirtual 49	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 52	java/util/zip/GZIPOutputStream:close	()V
    //   47: aload_1
    //   48: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   51: aload_3
    //   52: areturn
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 52	java/util/zip/GZIPOutputStream:close	()V
    //   58: aload_3
    //   59: athrow
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   65: aload_2
    //   66: athrow
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: goto -13 -> 58
    //   74: astore_1
    //   75: goto -10 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BytesBackedNativeSessionFile
    //   16	46	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   67	1	1	localIOException	java.io.IOException
    //   74	1	1	localObject1	Object
    //   25	30	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   60	6	2	localObject2	Object
    //   70	1	2	localObject3	Object
    //   42	10	3	arrayOfByte	byte[]
    //   53	6	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	43	53	finally
    //   17	26	60	finally
    //   43	47	60	finally
    //   58	60	60	finally
    //   9	17	67	java/io/IOException
    //   47	51	67	java/io/IOException
    //   65	67	67	java/io/IOException
    //   54	58	70	finally
    //   61	65	74	finally
  }
  
  private boolean isEmpty()
  {
    byte[] arrayOfByte = this.bytes;
    return (arrayOfByte == null) || (arrayOfByte.length == 0);
  }
  
  public CrashlyticsReport.FilesPayload.File asFilePayload()
  {
    byte[] arrayOfByte = asGzippedBytes();
    if (arrayOfByte == null) {
      return null;
    }
    return CrashlyticsReport.FilesPayload.File.builder().setContents(arrayOfByte).setFilename(this.dataTransportFilename).build();
  }
  
  public String getReportsEndpointFilename()
  {
    return this.reportsEndpointFilename;
  }
  
  public InputStream getStream()
  {
    if (isEmpty()) {
      return null;
    }
    return new ByteArrayInputStream(this.bytes);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\BytesBackedNativeSessionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */