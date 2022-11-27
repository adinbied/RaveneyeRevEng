package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzgd
{
  private final ConcurrentHashMap<zzgc, List<Throwable>> zza = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzb = new ReferenceQueue();
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Object localObject = this.zzb.poll(); localObject != null; localObject = this.zzb.poll()) {
      this.zza.remove(localObject);
    }
    localObject = new zzgc(paramThrowable, null);
    localObject = (List)this.zza.get(localObject);
    if (localObject != null) {
      return (List<Throwable>)localObject;
    }
    localObject = new Vector(2);
    paramThrowable = (List)this.zza.putIfAbsent(new zzgc(paramThrowable, this.zzb), localObject);
    if (paramThrowable == null) {
      return (List<Throwable>)localObject;
    }
    return paramThrowable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */