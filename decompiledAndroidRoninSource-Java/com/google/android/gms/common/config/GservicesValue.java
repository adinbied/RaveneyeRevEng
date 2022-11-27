package com.google.android.gms.common.config;

import android.content.Context;
import android.util.Log;
import java.util.HashSet;

public abstract class GservicesValue<T>
{
  private static final Object sLock = new Object();
  private static zza zzbm = null;
  private static int zzbn = 0;
  private static Context zzbo;
  private static HashSet<String> zzbp;
  protected final String mKey;
  protected final T zzbq;
  private T zzbr = null;
  
  protected GservicesValue(String paramString, T paramT)
  {
    this.mKey = paramString;
    this.zzbq = paramT;
  }
  
  public static boolean isInitialized()
  {
    synchronized (sLock)
    {
      return false;
    }
  }
  
  public static GservicesValue<Float> value(String paramString, Float paramFloat)
  {
    return new zzd(paramString, paramFloat);
  }
  
  public static GservicesValue<Integer> value(String paramString, Integer paramInteger)
  {
    return new zzc(paramString, paramInteger);
  }
  
  public static GservicesValue<Long> value(String paramString, Long paramLong)
  {
    return new zzb(paramString, paramLong);
  }
  
  public static GservicesValue<String> value(String paramString1, String paramString2)
  {
    return new zze(paramString1, paramString2);
  }
  
  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean)
  {
    return new zza(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static boolean zzi()
  {
    synchronized (sLock)
    {
      return false;
    }
  }
  
  /* Error */
  public final T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/common/config/GservicesValue:zzbr	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +5 -> 11
    //   9: aload_3
    //   10: areturn
    //   11: invokestatic 100	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   14: astore_3
    //   15: getstatic 31	com/google/android/gms/common/config/GservicesValue:sLock	Ljava/lang/Object;
    //   18: astore 4
    //   20: aload 4
    //   22: monitorenter
    //   23: aload 4
    //   25: monitorexit
    //   26: getstatic 31	com/google/android/gms/common/config/GservicesValue:sLock	Ljava/lang/Object;
    //   29: astore 4
    //   31: aload 4
    //   33: monitorenter
    //   34: aconst_null
    //   35: putstatic 102	com/google/android/gms/common/config/GservicesValue:zzbp	Ljava/util/HashSet;
    //   38: aconst_null
    //   39: putstatic 104	com/google/android/gms/common/config/GservicesValue:zzbo	Landroid/content/Context;
    //   42: aload 4
    //   44: monitorexit
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 41	com/google/android/gms/common/config/GservicesValue:mKey	Ljava/lang/String;
    //   50: invokevirtual 108	com/google/android/gms/common/config/GservicesValue:zzd	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore 4
    //   55: aload_3
    //   56: invokestatic 112	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   59: aload 4
    //   61: areturn
    //   62: astore 4
    //   64: goto +37 -> 101
    //   67: invokestatic 118	android/os/Binder:clearCallingIdentity	()J
    //   70: lstore_1
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 41	com/google/android/gms/common/config/GservicesValue:mKey	Ljava/lang/String;
    //   76: invokevirtual 108	com/google/android/gms/common/config/GservicesValue:zzd	(Ljava/lang/String;)Ljava/lang/Object;
    //   79: astore 4
    //   81: lload_1
    //   82: invokestatic 122	android/os/Binder:restoreCallingIdentity	(J)V
    //   85: aload_3
    //   86: invokestatic 112	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   89: aload 4
    //   91: areturn
    //   92: astore 4
    //   94: lload_1
    //   95: invokestatic 122	android/os/Binder:restoreCallingIdentity	(J)V
    //   98: aload 4
    //   100: athrow
    //   101: aload_3
    //   102: invokestatic 112	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   105: aload 4
    //   107: athrow
    //   108: astore_3
    //   109: aload 4
    //   111: monitorexit
    //   112: aload_3
    //   113: athrow
    //   114: astore_3
    //   115: aload 4
    //   117: monitorexit
    //   118: aload_3
    //   119: athrow
    //   120: astore 4
    //   122: goto -55 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	GservicesValue
    //   70	25	1	l	long
    //   4	98	3	localObject1	Object
    //   108	5	3	localObject2	Object
    //   114	5	3	localObject3	Object
    //   18	42	4	localObject4	Object
    //   62	1	4	localObject5	Object
    //   79	11	4	localObject6	Object
    //   92	24	4	localObject7	Object
    //   120	1	4	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   45	55	62	finally
    //   67	71	62	finally
    //   81	85	62	finally
    //   94	101	62	finally
    //   71	81	92	finally
    //   34	45	108	finally
    //   109	112	108	finally
    //   23	26	114	finally
    //   115	118	114	finally
    //   45	55	120	java/lang/SecurityException
  }
  
  @Deprecated
  public final T getBinderSafe()
  {
    return (T)get();
  }
  
  public void override(T arg1)
  {
    Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    this.zzbr = ???;
    synchronized (sLock)
    {
      zzi();
      return;
    }
  }
  
  public void resetOverride()
  {
    this.zzbr = null;
  }
  
  protected abstract T zzd(String paramString);
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Float zza(String paramString, Float paramFloat);
    
    public abstract Integer zza(String paramString, Integer paramInteger);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\config\GservicesValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */