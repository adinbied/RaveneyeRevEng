package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class zzt
  extends zzz
{
  private final AtomicReference<Bundle> zza = new AtomicReference();
  private boolean zzb;
  
  public static <T> T zza(Bundle paramBundle, Class<T> paramClass)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.get("r");
      if (paramBundle != null) {
        try
        {
          Object localObject = paramClass.cast(paramBundle);
          return (T)localObject;
        }
        catch (ClassCastException localClassCastException)
        {
          paramClass = paramClass.getCanonicalName();
          paramBundle = paramBundle.getClass().getCanonicalName();
          Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), new Object[] { paramClass, paramBundle }), localClassCastException);
          throw localClassCastException;
        }
      }
    }
    return null;
  }
  
  public final String zza(long paramLong)
  {
    return (String)zza(zzb(paramLong), String.class);
  }
  
  /* Error */
  public final void zza(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/google/android/gms/internal/measurement/zzt:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 18	com/google/android/gms/internal/measurement/zzt:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   11: aload_1
    //   12: invokevirtual 81	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 83	com/google/android/gms/internal/measurement/zzt:zzb	Z
    //   20: aload_0
    //   21: getfield 18	com/google/android/gms/internal/measurement/zzt:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   24: invokevirtual 86	java/lang/Object:notify	()V
    //   27: aload_2
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 18	com/google/android/gms/internal/measurement/zzt:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   35: invokevirtual 86	java/lang/Object:notify	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	zzt
    //   0	45	1	paramBundle	Bundle
    //   4	38	2	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   7	20	30	finally
    //   20	29	40	finally
    //   31	40	40	finally
    //   41	43	40	finally
  }
  
  public final Bundle zzb(long paramLong)
  {
    synchronized (this.zza)
    {
      boolean bool = this.zzb;
      if (!bool) {}
      try
      {
        this.zza.wait(paramLong);
      }
      catch (InterruptedException localInterruptedException)
      {
        Bundle localBundle;
        for (;;) {}
      }
      return null;
      localBundle = (Bundle)this.zza.get();
      return localBundle;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */