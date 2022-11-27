package com.google.android.gms.measurement.internal;

public final class zzeg<V>
{
  private static final Object zzf = new Object();
  private final String zza;
  private final zzee<V> zzb;
  private final V zzc;
  private final V zzd;
  private final Object zze = new Object();
  private volatile V zzg = null;
  private volatile V zzh = null;
  
  private zzeg(String paramString, V paramV1, V paramV2, zzee<V> paramzzee)
  {
    this.zza = paramString;
    this.zzc = paramV1;
    this.zzd = paramV2;
    this.zzb = paramzzee;
  }
  
  /* Error */
  public final V zza(V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/google/android/gms/measurement/internal/zzeg:zze	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_3
    //   8: monitorexit
    //   9: aload_1
    //   10: ifnull +5 -> 15
    //   13: aload_1
    //   14: areturn
    //   15: getstatic 56	com/google/android/gms/measurement/internal/zzeh:zza	Lcom/google/android/gms/measurement/internal/zzx;
    //   18: ifnonnull +8 -> 26
    //   21: aload_0
    //   22: getfield 37	com/google/android/gms/measurement/internal/zzeg:zzc	Ljava/lang/Object;
    //   25: areturn
    //   26: getstatic 25	com/google/android/gms/measurement/internal/zzeg:zzf	Ljava/lang/Object;
    //   29: astore_3
    //   30: aload_3
    //   31: monitorenter
    //   32: invokestatic 61	com/google/android/gms/measurement/internal/zzx:zza	()Z
    //   35: ifeq +27 -> 62
    //   38: aload_0
    //   39: getfield 33	com/google/android/gms/measurement/internal/zzeg:zzh	Ljava/lang/Object;
    //   42: ifnonnull +11 -> 53
    //   45: aload_0
    //   46: getfield 37	com/google/android/gms/measurement/internal/zzeg:zzc	Ljava/lang/Object;
    //   49: astore_1
    //   50: goto +8 -> 58
    //   53: aload_0
    //   54: getfield 33	com/google/android/gms/measurement/internal/zzeg:zzh	Ljava/lang/Object;
    //   57: astore_1
    //   58: aload_3
    //   59: monitorexit
    //   60: aload_1
    //   61: areturn
    //   62: aload_3
    //   63: monitorexit
    //   64: invokestatic 67	com/google/android/gms/measurement/internal/zzat:zzcl	()Ljava/util/List;
    //   67: invokeinterface 73 1 0
    //   72: astore 4
    //   74: aload 4
    //   76: invokeinterface 78 1 0
    //   81: ifeq +78 -> 159
    //   84: aload 4
    //   86: invokeinterface 82 1 0
    //   91: checkcast 2	com/google/android/gms/measurement/internal/zzeg
    //   94: astore 5
    //   96: invokestatic 61	com/google/android/gms/measurement/internal/zzx:zza	()Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifne +48 -> 149
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_3
    //   107: astore_1
    //   108: aload 5
    //   110: getfield 41	com/google/android/gms/measurement/internal/zzeg:zzb	Lcom/google/android/gms/measurement/internal/zzee;
    //   113: ifnull +14 -> 127
    //   116: aload 5
    //   118: getfield 41	com/google/android/gms/measurement/internal/zzeg:zzb	Lcom/google/android/gms/measurement/internal/zzee;
    //   121: invokeinterface 86 1 0
    //   126: astore_1
    //   127: getstatic 25	com/google/android/gms/measurement/internal/zzeg:zzf	Ljava/lang/Object;
    //   130: astore_3
    //   131: aload_3
    //   132: monitorenter
    //   133: aload 5
    //   135: aload_1
    //   136: putfield 33	com/google/android/gms/measurement/internal/zzeg:zzh	Ljava/lang/Object;
    //   139: aload_3
    //   140: monitorexit
    //   141: goto -67 -> 74
    //   144: astore_1
    //   145: aload_3
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    //   149: new 51	java/lang/IllegalStateException
    //   152: dup
    //   153: ldc 88
    //   155: invokespecial 91	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   158: athrow
    //   159: aload_0
    //   160: getfield 41	com/google/android/gms/measurement/internal/zzeg:zzb	Lcom/google/android/gms/measurement/internal/zzee;
    //   163: astore_1
    //   164: aload_1
    //   165: ifnonnull +8 -> 173
    //   168: aload_0
    //   169: getfield 37	com/google/android/gms/measurement/internal/zzeg:zzc	Ljava/lang/Object;
    //   172: areturn
    //   173: aload_1
    //   174: invokeinterface 86 1 0
    //   179: astore_1
    //   180: aload_1
    //   181: areturn
    //   182: aload_0
    //   183: getfield 37	com/google/android/gms/measurement/internal/zzeg:zzc	Ljava/lang/Object;
    //   186: areturn
    //   187: aload_0
    //   188: getfield 37	com/google/android/gms/measurement/internal/zzeg:zzc	Ljava/lang/Object;
    //   191: areturn
    //   192: astore_1
    //   193: aload_3
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    //   197: aload_3
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: goto -5 -> 197
    //   205: astore_1
    //   206: goto -47 -> 159
    //   209: astore_1
    //   210: aload_3
    //   211: astore_1
    //   212: goto -85 -> 127
    //   215: astore_1
    //   216: goto -29 -> 187
    //   219: astore_1
    //   220: goto -38 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	zzeg
    //   0	223	1	paramV	V
    //   99	2	2	bool	boolean
    //   72	13	4	localIterator	java.util.Iterator
    //   94	40	5	localzzeg	zzeg
    // Exception table:
    //   from	to	target	type
    //   133	141	144	finally
    //   145	147	144	finally
    //   32	50	192	finally
    //   53	58	192	finally
    //   58	60	192	finally
    //   62	64	192	finally
    //   193	195	192	finally
    //   7	9	201	finally
    //   197	199	201	finally
    //   64	74	205	java/lang/SecurityException
    //   74	100	205	java/lang/SecurityException
    //   108	127	205	java/lang/SecurityException
    //   127	133	205	java/lang/SecurityException
    //   147	149	205	java/lang/SecurityException
    //   149	159	205	java/lang/SecurityException
    //   108	127	209	java/lang/IllegalStateException
    //   173	180	215	java/lang/SecurityException
    //   173	180	219	java/lang/IllegalStateException
  }
  
  public final String zza()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */