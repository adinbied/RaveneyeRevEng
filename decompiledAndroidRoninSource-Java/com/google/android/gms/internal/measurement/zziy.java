package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

final class zziy
  implements zzkc
{
  private static final zzji zzb = new zzix();
  private final zzji zza;
  
  public zziy()
  {
    this(new zzja(new zzji[] { zzhx.zza(), zza() }));
  }
  
  private zziy(zzji paramzzji)
  {
    this.zza = ((zzji)zzic.zza(paramzzji, "messageInfoFactory"));
  }
  
  private static zzji zza()
  {
    try
    {
      zzji localzzji = (zzji)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzji;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return zzb;
  }
  
  private static boolean zza(zzjf paramzzjf)
  {
    return paramzzjf.zza() == zzjw.zza;
  }
  
  public final <T> zzjz<T> zza(Class<T> paramClass)
  {
    zzkb.zza(paramClass);
    zzjf localzzjf = this.zza.zzb(paramClass);
    if (localzzjf.zzb())
    {
      if (zzhz.class.isAssignableFrom(paramClass)) {
        return zzjn.zza(zzkb.zzc(), zzhq.zza(), localzzjf.zzc());
      }
      return zzjn.zza(zzkb.zza(), zzhq.zzb(), localzzjf.zzc());
    }
    if (zzhz.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzjf)) {
        return zzjl.zza(paramClass, localzzjf, zzjr.zzb(), zzir.zzb(), zzkb.zzc(), zzhq.zza(), zzjg.zzb());
      }
      return zzjl.zza(paramClass, localzzjf, zzjr.zzb(), zzir.zzb(), zzkb.zzc(), null, zzjg.zzb());
    }
    if (zza(localzzjf)) {
      return zzjl.zza(paramClass, localzzjf, zzjr.zza(), zzir.zza(), zzkb.zza(), zzhq.zzb(), zzjg.zza());
    }
    return zzjl.zza(paramClass, localzzjf, zzjr.zza(), zzir.zza(), zzkb.zzb(), null, zzjg.zza());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zziy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */