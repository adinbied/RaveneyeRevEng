package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import java.io.File;

public final class zzdc
{
  /* Error */
  private static zzdd zza(File paramFile)
  {
    // Byte code:
    //   0: new 15	java/io/BufferedReader
    //   3: dup
    //   4: new 17	java/io/InputStreamReader
    //   7: dup
    //   8: new 19	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 22	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: invokespecial 25	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   19: invokespecial 28	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore_2
    //   23: new 30	java/util/HashMap
    //   26: dup
    //   27: invokespecial 31	java/util/HashMap:<init>	()V
    //   30: astore_3
    //   31: aload_2
    //   32: invokevirtual 35	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +131 -> 170
    //   42: aload 4
    //   44: ldc 37
    //   46: iconst_3
    //   47: invokevirtual 43	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: arraylength
    //   53: iconst_3
    //   54: if_icmpeq +46 -> 100
    //   57: aload 4
    //   59: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 51	java/lang/String:length	()I
    //   67: ifeq +13 -> 80
    //   70: ldc 53
    //   72: aload_1
    //   73: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_1
    //   77: goto +13 -> 90
    //   80: new 39	java/lang/String
    //   83: dup
    //   84: ldc 53
    //   86: invokespecial 60	java/lang/String:<init>	(Ljava/lang/String;)V
    //   89: astore_1
    //   90: ldc 62
    //   92: aload_1
    //   93: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: goto -66 -> 31
    //   100: aload_1
    //   101: iconst_0
    //   102: aaload
    //   103: astore 4
    //   105: aload_1
    //   106: iconst_1
    //   107: aaload
    //   108: invokestatic 73	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 5
    //   113: aload_1
    //   114: iconst_2
    //   115: aaload
    //   116: invokestatic 73	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_1
    //   120: aload_3
    //   121: aload 4
    //   123: invokeinterface 79 2 0
    //   128: ifne +19 -> 147
    //   131: aload_3
    //   132: aload 4
    //   134: new 30	java/util/HashMap
    //   137: dup
    //   138: invokespecial 31	java/util/HashMap:<init>	()V
    //   141: invokeinterface 83 3 0
    //   146: pop
    //   147: aload_3
    //   148: aload 4
    //   150: invokeinterface 87 2 0
    //   155: checkcast 75	java/util/Map
    //   158: aload 5
    //   160: aload_1
    //   161: invokeinterface 83 3 0
    //   166: pop
    //   167: goto -136 -> 31
    //   170: aload_0
    //   171: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   174: astore_0
    //   175: new 89	java/lang/StringBuilder
    //   178: dup
    //   179: aload_0
    //   180: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   183: invokevirtual 51	java/lang/String:length	()I
    //   186: bipush 7
    //   188: iadd
    //   189: invokespecial 92	java/lang/StringBuilder:<init>	(I)V
    //   192: astore_1
    //   193: aload_1
    //   194: ldc 94
    //   196: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_1
    //   201: aload_0
    //   202: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc 62
    //   208: aload_1
    //   209: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 104	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   215: pop
    //   216: new 106	com/google/android/gms/internal/measurement/zzdd
    //   219: dup
    //   220: aload_3
    //   221: invokespecial 109	com/google/android/gms/internal/measurement/zzdd:<init>	(Ljava/util/Map;)V
    //   224: astore_0
    //   225: aload_2
    //   226: invokevirtual 112	java/io/BufferedReader:close	()V
    //   229: aload_0
    //   230: areturn
    //   231: astore_0
    //   232: aload_2
    //   233: invokevirtual 112	java/io/BufferedReader:close	()V
    //   236: goto +9 -> 245
    //   239: astore_1
    //   240: aload_0
    //   241: aload_1
    //   242: invokestatic 117	com/google/android/gms/internal/measurement/zzgb:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: new 119	java/lang/RuntimeException
    //   251: dup
    //   252: aload_0
    //   253: invokespecial 122	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramFile	File
    //   50	159	1	localObject	Object
    //   239	3	1	localThrowable	Throwable
    //   22	211	2	localBufferedReader	java.io.BufferedReader
    //   30	191	3	localHashMap	java.util.HashMap
    //   35	114	4	str1	String
    //   111	48	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	31	231	finally
    //   31	37	231	finally
    //   42	77	231	finally
    //   80	90	231	finally
    //   90	97	231	finally
    //   105	147	231	finally
    //   147	167	231	finally
    //   170	225	231	finally
    //   232	236	239	finally
    //   0	23	247	java/io/IOException
    //   225	229	247	java/io/IOException
    //   240	245	247	java/io/IOException
    //   245	247	247	java/io/IOException
  }
  
  public static zzdy<zzdd> zza(Context paramContext)
  {
    Object localObject = Build.TYPE;
    String str = Build.TAGS;
    boolean bool = ((String)localObject).equals("eng");
    int i = 0;
    if (((bool) || (((String)localObject).equals("userdebug"))) && ((str.contains("dev-keys")) || (str.contains("test-keys")))) {
      i = 1;
    }
    if (i == 0) {
      return zzdy.zzc();
    }
    localObject = paramContext;
    if (zzcr.zza()) {
      if (paramContext.isDeviceProtectedStorage()) {
        localObject = paramContext;
      } else {
        localObject = paramContext.createDeviceProtectedStorageContext();
      }
    }
    paramContext = zzb((Context)localObject);
    if (paramContext.zza()) {
      return zzdy.zza(zza((File)paramContext.zzb()));
    }
    return zzdy.zzc();
  }
  
  /* Error */
  private static zzdy<File> zzb(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 189	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_1
    //   4: invokestatic 192	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   7: pop
    //   8: new 176	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: ldc -62
    //   15: iconst_0
    //   16: invokevirtual 198	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   19: ldc -56
    //   21: invokespecial 203	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 206	java/io/File:exists	()Z
    //   29: ifeq +11 -> 40
    //   32: aload_0
    //   33: invokestatic 181	com/google/android/gms/internal/measurement/zzdy:zza	(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzdy;
    //   36: astore_0
    //   37: goto +7 -> 44
    //   40: invokestatic 153	com/google/android/gms/internal/measurement/zzdy:zzc	()Lcom/google/android/gms/internal/measurement/zzdy;
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 210	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 62
    //   53: ldc -44
    //   55: aload_0
    //   56: invokestatic 215	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   59: pop
    //   60: invokestatic 153	com/google/android/gms/internal/measurement/zzdy:zzc	()Lcom/google/android/gms/internal/measurement/zzdy;
    //   63: astore_0
    //   64: aload_1
    //   65: invokestatic 210	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   68: aload_0
    //   69: areturn
    //   70: astore_0
    //   71: aload_1
    //   72: invokestatic 210	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   3	69	1	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   8	25	50	java/lang/RuntimeException
    //   4	8	70	finally
    //   8	25	70	finally
    //   25	37	70	finally
    //   40	44	70	finally
    //   51	64	70	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */