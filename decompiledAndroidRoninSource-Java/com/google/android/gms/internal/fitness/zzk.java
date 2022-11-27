package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class zzk
{
  private static final double zzel = 10.0D / TimeUnit.SECONDS.toNanos(1L);
  private static final double zzem = 1000.0D / TimeUnit.SECONDS.toNanos(1L);
  private static final double zzen = 2000.0D / TimeUnit.HOURS.toNanos(1L);
  private static final double zzeo = 100.0D / TimeUnit.SECONDS.toNanos(1L);
  public static final Set<String> zzep = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type", "debug_session", "google.android.fitness.SessionV2" })));
  private static final zzk zzes = new zzk();
  private final Map<String, Map<String, zzm>> zzeq;
  private final Map<String, zzm> zzer;
  
  private zzk()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("latitude", new zzm(-90.0D, 90.0D, null));
    localHashMap.put("longitude", new zzm(-180.0D, 180.0D, null));
    localHashMap.put("accuracy", new zzm(0.0D, 10000.0D, null));
    localHashMap.put("bpm", new zzm(0.0D, 1000.0D, null));
    localHashMap.put("altitude", new zzm(-100000.0D, 100000.0D, null));
    localHashMap.put("percentage", new zzm(0.0D, 100.0D, null));
    localHashMap.put("confidence", new zzm(0.0D, 100.0D, null));
    localHashMap.put("duration", new zzm(0.0D, 9.223372036854776E18D, null));
    localHashMap.put("height", new zzm(0.0D, 3.0D, null));
    localHashMap.put("weight", new zzm(0.0D, 1000.0D, null));
    localHashMap.put("speed", new zzm(0.0D, 11000.0D, null));
    this.zzer = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("com.google.step_count.delta", zza("steps", new zzm(0.0D, zzel, null)));
    localHashMap.put("com.google.calories.consumed", zza("calories", new zzm(0.0D, zzem, null)));
    localHashMap.put("com.google.calories.expended", zza("calories", new zzm(0.0D, zzen, null)));
    localHashMap.put("com.google.distance.delta", zza("distance", new zzm(0.0D, zzeo, null)));
    this.zzeq = Collections.unmodifiableMap(localHashMap);
  }
  
  private static <K, V> Map<K, V> zza(K paramK, V paramV)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramK, paramV);
    return localHashMap;
  }
  
  public static zzk zzs()
  {
    return zzes;
  }
  
  final zzm zza(String paramString1, String paramString2)
  {
    paramString1 = (Map)this.zzeq.get(paramString1);
    if (paramString1 != null) {
      return (zzm)paramString1.get(paramString2);
    }
    return null;
  }
  
  final zzm zzk(String paramString)
  {
    return (zzm)this.zzer.get(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */