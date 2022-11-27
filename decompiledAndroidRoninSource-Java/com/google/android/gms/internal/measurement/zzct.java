package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzct
  implements zzcx
{
  private static final Map<Uri, zzct> zza = new ArrayMap();
  private static final String[] zzh = { "key", "value" };
  private final ContentResolver zzb;
  private final Uri zzc;
  private final ContentObserver zzd = new zzcv(this, null);
  private final Object zze = new Object();
  private volatile Map<String, String> zzf;
  private final List<zzcu> zzg = new ArrayList();
  
  private zzct(ContentResolver paramContentResolver, Uri paramUri)
  {
    zzeb.zza(paramContentResolver);
    zzeb.zza(paramUri);
    this.zzb = paramContentResolver;
    this.zzc = paramUri;
    paramContentResolver.registerContentObserver(paramUri, false, this.zzd);
  }
  
  /* Error */
  public static zzct zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 33	com/google/android/gms/internal/measurement/zzct:zza	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 81 2 0
    //   12: checkcast 2	com/google/android/gms/internal/measurement/zzct
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_3
    //   19: ifnonnull +24 -> 43
    //   22: new 2	com/google/android/gms/internal/measurement/zzct
    //   25: dup
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 83	com/google/android/gms/internal/measurement/zzct:<init>	(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    //   31: astore_2
    //   32: getstatic 33	com/google/android/gms/internal/measurement/zzct:zza	Ljava/util/Map;
    //   35: aload_1
    //   36: aload_2
    //   37: invokeinterface 87 3 0
    //   42: pop
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: astore_0
    //   55: aload_3
    //   56: astore_2
    //   57: goto -14 -> 43
    //   60: astore_0
    //   61: goto -18 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContentResolver	ContentResolver
    //   0	64	1	paramUri	Uri
    //   17	40	2	localzzct1	zzct
    //   15	41	3	localzzct2	zzct
    // Exception table:
    //   from	to	target	type
    //   3	16	48	finally
    //   22	32	48	finally
    //   32	43	48	finally
    //   43	46	48	finally
    //   49	52	48	finally
    //   22	32	54	java/lang/SecurityException
    //   32	43	60	java/lang/SecurityException
  }
  
  static void zzc()
  {
    try
    {
      Iterator localIterator = zza.values().iterator();
      while (localIterator.hasNext())
      {
        zzct localzzct = (zzct)localIterator.next();
        localzzct.zzb.unregisterContentObserver(localzzct.zzd);
      }
      zza.clear();
      return;
    }
    finally {}
  }
  
  /* Error */
  private final Map<String, String> zze()
  {
    // Byte code:
    //   0: invokestatic 125	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_1
    //   4: new 127	com/google/android/gms/internal/measurement/zzcs
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 130	com/google/android/gms/internal/measurement/zzcs:<init>	(Lcom/google/android/gms/internal/measurement/zzct;)V
    //   12: invokestatic 135	com/google/android/gms/internal/measurement/zzcw:zza	(Lcom/google/android/gms/internal/measurement/zzcz;)Ljava/lang/Object;
    //   15: checkcast 78	java/util/Map
    //   18: astore_2
    //   19: aload_1
    //   20: invokestatic 139	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   23: aload_2
    //   24: areturn
    //   25: astore_2
    //   26: goto +17 -> 43
    //   29: ldc -115
    //   31: ldc -113
    //   33: invokestatic 149	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aload_1
    //   38: invokestatic 139	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_1
    //   44: invokestatic 139	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   47: aload_2
    //   48: athrow
    //   49: astore_2
    //   50: goto -21 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	zzct
    //   3	41	1	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   18	6	2	localMap	Map
    //   25	23	2	localObject	Object
    //   49	1	2	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   4	19	25	finally
    //   29	37	25	finally
    //   4	19	49	java/lang/SecurityException
    //   4	19	49	android/database/sqlite/SQLiteException
    //   4	19	49	java/lang/IllegalStateException
  }
  
  public final Map<String, String> zza()
  {
    Map localMap2 = this.zzf;
    Map localMap1 = localMap2;
    if (localMap2 == null) {
      synchronized (this.zze)
      {
        localMap2 = this.zzf;
        localMap1 = localMap2;
        if (localMap2 == null)
        {
          localMap1 = zze();
          this.zzf = localMap1;
        }
      }
    }
    if (localMap != null) {
      return localMap;
    }
    return Collections.emptyMap();
  }
  
  public final void zzb()
  {
    synchronized (this.zze)
    {
      this.zzf = null;
      zzdh.zza();
      try
      {
        ??? = this.zzg.iterator();
        while (((Iterator)???).hasNext()) {
          ((zzcu)((Iterator)???).next()).zza();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */