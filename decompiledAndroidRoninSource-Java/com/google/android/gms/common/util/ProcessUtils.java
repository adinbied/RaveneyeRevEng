package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils
{
  private static String zzhf;
  private static int zzhg;
  
  @Nullable
  public static String getMyProcessName()
  {
    if (zzhf == null)
    {
      if (zzhg == 0) {
        zzhg = Process.myPid();
      }
      zzhf = zzd(zzhg);
    }
    return zzhf;
  }
  
  /* Error */
  @Nullable
  private static String zzd(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifgt +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 36	java/lang/StringBuilder
    //   9: dup
    //   10: bipush 25
    //   12: invokespecial 39	java/lang/StringBuilder:<init>	(I)V
    //   15: astore_1
    //   16: aload_1
    //   17: ldc 41
    //   19: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: iload_0
    //   25: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: ldc 50
    //   32: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 57	com/google/android/gms/common/util/ProcessUtils:zzk	(Ljava/lang/String;)Ljava/io/BufferedReader;
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: invokevirtual 67	java/lang/String:trim	()Ljava/lang/String;
    //   51: astore_2
    //   52: aload_1
    //   53: invokestatic 73	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   56: aload_2
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: goto +8 -> 69
    //   64: astore_1
    //   65: aconst_null
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_3
    //   70: invokestatic 73	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   73: aload_2
    //   74: athrow
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: invokestatic 73	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_1
    //   84: goto -9 -> 75
    //   87: astore_2
    //   88: goto -11 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramInt	int
    //   15	45	1	localObject1	Object
    //   64	4	1	localObject2	Object
    //   76	2	1	localCloseable	java.io.Closeable
    //   83	1	1	localIOException1	IOException
    //   51	6	2	str	String
    //   58	1	2	localObject3	Object
    //   68	6	2	localObject4	Object
    //   87	1	2	localIOException2	IOException
    //   60	10	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   44	52	58	finally
    //   6	44	64	finally
    //   6	44	83	java/io/IOException
    //   44	52	87	java/io/IOException
  }
  
  private static BufferedReader zzk(String paramString)
    throws IOException
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      paramString = new BufferedReader(new FileReader(paramString));
      return paramString;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\ProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */