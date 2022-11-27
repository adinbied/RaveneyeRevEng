package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import java.io.File;

public class CachedSettingsIo
{
  private static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
  private final Context context;
  
  public CachedSettingsIo(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private File getSettingsFile()
  {
    return new File(new FileStoreImpl(this.context).getFilesDir(), "com.crashlytics.settings.json");
  }
  
  /* Error */
  public org.json.JSONObject readCachedSettings()
  {
    // Byte code:
    //   0: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   3: ldc 44
    //   5: invokevirtual 48	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   8: aconst_null
    //   9: astore_1
    //   10: aload_0
    //   11: invokespecial 50	com/google/firebase/crashlytics/internal/settings/CachedSettingsIo:getSettingsFile	()Ljava/io/File;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 54	java/io/File:exists	()Z
    //   19: ifeq +37 -> 56
    //   22: new 56	java/io/FileInputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 61	org/json/JSONObject
    //   36: dup
    //   37: aload_2
    //   38: invokestatic 67	com/google/firebase/crashlytics/internal/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   41: invokespecial 69	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore_3
    //   45: aload_2
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: goto +17 -> 66
    //   52: astore_3
    //   53: goto +30 -> 83
    //   56: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   59: ldc 71
    //   61: invokevirtual 48	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_1
    //   67: ldc 73
    //   69: invokestatic 77	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   72: aload_2
    //   73: areturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_2
    //   77: goto +30 -> 107
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   88: ldc 79
    //   90: aload_3
    //   91: invokevirtual 83	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_2
    //   95: ldc 73
    //   97: invokestatic 77	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_3
    //   103: aload_1
    //   104: astore_2
    //   105: aload_3
    //   106: astore_1
    //   107: aload_2
    //   108: ldc 73
    //   110: invokestatic 77	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	CachedSettingsIo
    //   9	58	1	localObject1	Object
    //   74	1	1	localObject2	Object
    //   84	30	1	localObject3	Object
    //   14	94	2	localObject4	Object
    //   44	4	3	localJSONObject	org.json.JSONObject
    //   52	1	3	localException1	Exception
    //   80	11	3	localException2	Exception
    //   102	4	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	45	52	java/lang/Exception
    //   10	31	74	finally
    //   56	64	74	finally
    //   10	31	80	java/lang/Exception
    //   56	64	80	java/lang/Exception
    //   33	45	102	finally
    //   85	94	102	finally
  }
  
  /* Error */
  public void writeCachedSettings(long paramLong, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   3: ldc 87
    //   5: invokevirtual 48	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: ifnull +118 -> 127
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 5
    //   18: aload 5
    //   20: astore 4
    //   22: aload_3
    //   23: ldc 89
    //   25: lload_1
    //   26: invokevirtual 93	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload 5
    //   32: astore 4
    //   34: new 95	java/io/FileWriter
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 50	com/google/firebase/crashlytics/internal/settings/CachedSettingsIo:getSettingsFile	()Ljava/io/File;
    //   42: invokespecial 96	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   45: astore 5
    //   47: aload 5
    //   49: aload_3
    //   50: invokevirtual 100	org/json/JSONObject:toString	()Ljava/lang/String;
    //   53: invokevirtual 103	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   56: aload 5
    //   58: invokevirtual 106	java/io/FileWriter:flush	()V
    //   61: aload 5
    //   63: ldc 108
    //   65: invokestatic 77	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   68: return
    //   69: astore_3
    //   70: aload 5
    //   72: astore 4
    //   74: goto +44 -> 118
    //   77: astore 4
    //   79: aload 5
    //   81: astore_3
    //   82: aload 4
    //   84: astore 5
    //   86: goto +12 -> 98
    //   89: astore_3
    //   90: goto +28 -> 118
    //   93: astore 5
    //   95: aload 6
    //   97: astore_3
    //   98: aload_3
    //   99: astore 4
    //   101: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   104: ldc 110
    //   106: aload 5
    //   108: invokevirtual 83	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_3
    //   112: ldc 108
    //   114: invokestatic 77	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   117: return
    //   118: aload 4
    //   120: ldc 108
    //   122: invokestatic 77	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   125: aload_3
    //   126: athrow
    //   127: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	CachedSettingsIo
    //   0	128	1	paramLong	long
    //   0	128	3	paramJSONObject	org.json.JSONObject
    //   20	53	4	localObject1	Object
    //   77	6	4	localException1	Exception
    //   99	20	4	localJSONObject	org.json.JSONObject
    //   16	69	5	localObject2	Object
    //   93	14	5	localException2	Exception
    //   13	83	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	61	69	finally
    //   47	61	77	java/lang/Exception
    //   22	30	89	finally
    //   34	47	89	finally
    //   101	111	89	finally
    //   22	30	93	java/lang/Exception
    //   34	47	93	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\CachedSettingsIo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */