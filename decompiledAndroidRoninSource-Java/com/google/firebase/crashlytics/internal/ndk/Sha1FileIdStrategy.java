package com.google.firebase.crashlytics.internal.ndk;

import java.io.File;
import java.io.IOException;

class Sha1FileIdStrategy
  implements BinaryImagesConverter.FileIdStrategy
{
  /* Error */
  private static String getFileSHA(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 17	java/io/BufferedInputStream
    //   5: dup
    //   6: new 19	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 22	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 25	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic 31	com/google/firebase/crashlytics/internal/common/CommonUtils:sha1	(Ljava/io/InputStream;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: invokestatic 35	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: goto +6 -> 36
    //   33: astore_1
    //   34: aload_2
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 35	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramString	String
    //   22	6	1	str	String
    //   29	1	1	localObject1	Object
    //   33	8	1	localObject2	Object
    //   1	34	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	29	finally
    //   2	18	33	finally
  }
  
  public String createId(File paramFile)
    throws IOException
  {
    return getFileSHA(paramFile.getPath());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\ndk\Sha1FileIdStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */