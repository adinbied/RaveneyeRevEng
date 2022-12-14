package com.facebook.common.internal;

import java.io.IOException;
import java.io.InputStream;

public class Files
{
  static byte[] readFile(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong <= 2147483647L)
    {
      if (paramLong == 0L) {
        return ByteStreams.toByteArray(paramInputStream);
      }
      return ByteStreams.toByteArray(paramInputStream, (int)paramLong);
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("file is too large to fit in a byte array: ");
    paramInputStream.append(paramLong);
    paramInputStream.append(" bytes");
    throw new OutOfMemoryError(paramInputStream.toString());
  }
  
  /* Error */
  public static byte[] toByteArray(java.io.File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 51	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 54	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: aload_0
    //   13: invokevirtual 58	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   16: invokevirtual 64	java/nio/channels/FileChannel:size	()J
    //   19: invokestatic 66	com/facebook/common/internal/Files:readFile	(Ljava/io/InputStream;J)[B
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 69	java/io/FileInputStream:close	()V
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: goto +6 -> 36
    //   33: astore_1
    //   34: aload_2
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +7 -> 44
    //   40: aload_0
    //   41: invokevirtual 69	java/io/FileInputStream:close	()V
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramFile	java.io.File
    //   22	6	1	arrayOfByte	byte[]
    //   29	1	1	localObject1	Object
    //   33	12	1	localObject2	Object
    //   1	34	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	23	29	finally
    //   2	11	33	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\internal\Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */