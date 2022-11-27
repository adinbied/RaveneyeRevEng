package com.google.firebase.crashlytics.internal.ndk;

public final class NativeFileUtils
{
  /* Error */
  public static byte[] binaryImagesJsonFromMapsFile(java.io.File paramFile, android.content.Context paramContext)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +70 -> 71
    //   4: aload_0
    //   5: invokevirtual 19	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: goto +60 -> 71
    //   14: aconst_null
    //   15: astore_2
    //   16: new 21	java/io/BufferedReader
    //   19: dup
    //   20: new 23	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 26	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 29	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_0
    //   32: new 31	com/google/firebase/crashlytics/internal/ndk/BinaryImagesConverter
    //   35: dup
    //   36: aload_1
    //   37: new 33	com/google/firebase/crashlytics/internal/ndk/Sha1FileIdStrategy
    //   40: dup
    //   41: invokespecial 34	com/google/firebase/crashlytics/internal/ndk/Sha1FileIdStrategy:<init>	()V
    //   44: invokespecial 37	com/google/firebase/crashlytics/internal/ndk/BinaryImagesConverter:<init>	(Landroid/content/Context;Lcom/google/firebase/crashlytics/internal/ndk/BinaryImagesConverter$FileIdStrategy;)V
    //   47: aload_0
    //   48: invokevirtual 41	com/google/firebase/crashlytics/internal/ndk/BinaryImagesConverter:convert	(Ljava/io/BufferedReader;)[B
    //   51: astore_1
    //   52: aload_0
    //   53: invokestatic 47	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   56: aload_1
    //   57: areturn
    //   58: astore_1
    //   59: goto +6 -> 65
    //   62: astore_1
    //   63: aload_2
    //   64: astore_0
    //   65: aload_0
    //   66: invokestatic 47	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   69: aload_1
    //   70: athrow
    //   71: iconst_0
    //   72: newarray <illegal type>
    //   74: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramFile	java.io.File
    //   0	75	1	paramContext	android.content.Context
    //   15	49	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	52	58	finally
    //   16	32	62	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\ndk\NativeFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */