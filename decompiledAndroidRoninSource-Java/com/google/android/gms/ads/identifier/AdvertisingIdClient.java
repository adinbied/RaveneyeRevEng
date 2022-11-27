package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class AdvertisingIdClient
{
  private final Context mContext;
  private BlockingServiceConnection zze;
  private zze zzf;
  private boolean zzg;
  private final Object zzh = new Object();
  private zza zzi;
  private final boolean zzj;
  private final long zzk;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false, false);
  }
  
  private AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramContext);
    Context localContext = paramContext;
    if (paramBoolean1)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext == null) {
        localContext = paramContext;
      }
    }
    this.mContext = localContext;
    this.zzg = false;
    this.zzk = paramLong;
    this.zzj = paramBoolean2;
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    Object localObject2 = new zzb(paramContext);
    boolean bool = ((zzb)localObject2).getBoolean("gads:ad_id_app_context:enabled", false);
    float f = ((zzb)localObject2).getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
    String str = ((zzb)localObject2).getString("gads:ad_id_use_shared_preference:experiment_id", "");
    paramContext = new AdvertisingIdClient(paramContext, -1L, bool, ((zzb)localObject2).getBoolean("gads:ad_id_use_persistent_service:enabled", false));
    try
    {
      long l = SystemClock.elapsedRealtime();
      paramContext.zza(false);
      localObject2 = paramContext.getInfo();
      paramContext.zza((Info)localObject2, bool, f, SystemClock.elapsedRealtime() - l, str, null);
      paramContext.finish();
      return (Info)localObject2;
    }
    finally
    {
      try
      {
        paramContext.zza(null, bool, f, -1L, str, localThrowable);
        throw localThrowable;
      }
      finally
      {
        paramContext.finish();
      }
    }
  }
  
  public static boolean getIsAdIdFakeForDebugLogging(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzb localzzb = new zzb(paramContext);
    paramContext = new AdvertisingIdClient(paramContext, -1L, localzzb.getBoolean("gads:ad_id_app_context:enabled", false), localzzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
    try
    {
      paramContext.zza(false);
      boolean bool = paramContext.zzb();
      return bool;
    }
    finally
    {
      paramContext.finish();
    }
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  private static BlockingServiceConnection zza(Context paramContext, boolean paramBoolean)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      int i = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, 12451000);
      if ((i != 0) && (i != 2)) {
        throw new IOException("Google Play services not available");
      }
      if (paramBoolean) {
        localObject = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
      } else {
        localObject = "com.google.android.gms.ads.identifier.service.START";
      }
      BlockingServiceConnection localBlockingServiceConnection = new BlockingServiceConnection();
      Object localObject = new Intent((String)localObject);
      ((Intent)localObject).setPackage("com.google.android.gms");
      try
      {
        paramBoolean = ConnectionTracker.getInstance().bindService(paramContext, (Intent)localObject, localBlockingServiceConnection, 1);
        if (paramBoolean) {
          return localBlockingServiceConnection;
        }
        throw new IOException("Connection failure");
      }
      finally {}
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    throw new GooglePlayServicesNotAvailableException(9);
  }
  
  /* Error */
  private static zze zza(Context paramContext, BlockingServiceConnection paramBlockingServiceConnection)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc2_w 192
    //   4: getstatic 199	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   7: invokevirtual 203	com/google/android/gms/common/BlockingServiceConnection:getServiceWithTimeout	(JLjava/util/concurrent/TimeUnit;)Landroid/os/IBinder;
    //   10: invokestatic 208	com/google/android/gms/internal/ads_identifier/zzf:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/ads_identifier/zze;
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: astore_0
    //   17: new 63	java/io/IOException
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 185	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   25: athrow
    //   26: new 63	java/io/IOException
    //   29: dup
    //   30: ldc -46
    //   32: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: astore_0
    //   37: goto -11 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramContext	Context
    //   0	40	1	paramBlockingServiceConnection	BlockingServiceConnection
    // Exception table:
    //   from	to	target	type
    //   0	14	16	finally
    //   0	14	36	java/lang/InterruptedException
  }
  
  private final void zza()
  {
    synchronized (this.zzh)
    {
      if (this.zzi != null) {
        this.zzi.zzo.countDown();
      }
    }
    try
    {
      this.zzi.join();
      if (this.zzk > 0L) {
        this.zzi = new zza(this, this.zzk);
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  private final void zza(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzg) {
        finish();
      }
      BlockingServiceConnection localBlockingServiceConnection = zza(this.mContext, this.zzj);
      this.zze = localBlockingServiceConnection;
      this.zzf = zza(this.mContext, localBlockingServiceConnection);
      this.zzg = true;
      if (paramBoolean) {
        zza();
      }
      return;
    }
    finally {}
  }
  
  private final boolean zza(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    String str2 = "1";
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("app_context", str1);
    if (paramInfo != null)
    {
      if (paramInfo.isLimitAdTrackingEnabled()) {
        str1 = str2;
      } else {
        str1 = "0";
      }
      localHashMap.put("limit_ad_tracking", str1);
    }
    if ((paramInfo != null) && (paramInfo.getId() != null)) {
      localHashMap.put("ad_id_size", Integer.toString(paramInfo.getId().length()));
    }
    if (paramThrowable != null) {
      localHashMap.put("error", paramThrowable.getClass().getName());
    }
    if ((paramString != null) && (!paramString.isEmpty())) {
      localHashMap.put("experiment_id", paramString);
    }
    localHashMap.put("tag", "AdvertisingIdClient");
    localHashMap.put("time_spent", Long.toString(paramLong));
    new zza(this, localHashMap).start();
    return true;
  }
  
  /* Error */
  private final boolean zzb()
    throws IOException
  {
    // Byte code:
    //   0: ldc -27
    //   2: invokestatic 232	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   11: ifne +84 -> 95
    //   14: aload_0
    //   15: getfield 39	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzh	Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 212	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull +54 -> 79
    //   28: aload_0
    //   29: getfield 212	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: getfield 328	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzp	Z
    //   35: ifeq +44 -> 79
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_0
    //   41: iconst_0
    //   42: invokespecial 106	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Z)V
    //   45: aload_0
    //   46: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   49: ifeq +6 -> 55
    //   52: goto +43 -> 95
    //   55: new 63	java/io/IOException
    //   58: dup
    //   59: ldc_w 330
    //   62: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: athrow
    //   66: astore_2
    //   67: new 63	java/io/IOException
    //   70: dup
    //   71: ldc_w 330
    //   74: aload_2
    //   75: invokespecial 333	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: new 63	java/io/IOException
    //   82: dup
    //   83: ldc_w 335
    //   86: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_3
    //   91: aload_2
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    //   95: aload_0
    //   96: getfield 236	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   99: invokestatic 45	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: aload_0
    //   104: getfield 240	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   107: invokestatic 45	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload_0
    //   112: getfield 240	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   115: invokeinterface 340 1 0
    //   120: istore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_0
    //   124: invokespecial 242	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	()V
    //   127: iload_1
    //   128: ireturn
    //   129: astore_2
    //   130: ldc_w 306
    //   133: ldc_w 342
    //   136: aload_2
    //   137: invokestatic 348	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   140: pop
    //   141: new 63	java/io/IOException
    //   144: dup
    //   145: ldc_w 350
    //   148: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   151: athrow
    //   152: astore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	AdvertisingIdClient
    //   120	8	1	bool	boolean
    //   66	26	2	localException	Exception
    //   129	8	2	localRemoteException	android.os.RemoteException
    //   152	4	2	localObject2	Object
    //   90	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	66	java/lang/Exception
    //   21	40	90	finally
    //   79	90	90	finally
    //   91	93	90	finally
    //   111	121	129	android/os/RemoteException
    //   7	21	152	finally
    //   40	45	152	finally
    //   45	52	152	finally
    //   55	66	152	finally
    //   67	79	152	finally
    //   93	95	152	finally
    //   95	111	152	finally
    //   111	121	152	finally
    //   121	123	152	finally
    //   130	152	152	finally
    //   153	155	152	finally
  }
  
  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public final void finish()
  {
    // Byte code:
    //   0: ldc -27
    //   2: invokestatic 232	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +69 -> 80
    //   14: aload_0
    //   15: getfield 236	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +6 -> 26
    //   23: goto +57 -> 80
    //   26: aload_0
    //   27: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   30: ifeq +32 -> 62
    //   33: invokestatic 176	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   36: aload_0
    //   37: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   40: aload_0
    //   41: getfield 236	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   44: invokevirtual 359	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   47: goto +15 -> 62
    //   50: astore_1
    //   51: ldc_w 306
    //   54: ldc_w 361
    //   57: aload_1
    //   58: invokestatic 348	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   61: pop
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 240	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 236	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	AdvertisingIdClient
    //   18	2	1	localBlockingServiceConnection	BlockingServiceConnection
    //   50	8	1	localThrowable	Throwable
    //   83	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	47	50	finally
    //   7	19	83	finally
    //   51	62	83	finally
    //   62	79	83	finally
    //   80	82	83	finally
    //   84	86	83	finally
  }
  
  /* Error */
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc -27
    //   2: invokestatic 232	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   11: ifne +84 -> 95
    //   14: aload_0
    //   15: getfield 39	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzh	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 212	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull +54 -> 79
    //   28: aload_0
    //   29: getfield 212	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: getfield 328	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzp	Z
    //   35: ifeq +44 -> 79
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_0
    //   41: iconst_0
    //   42: invokespecial 106	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Z)V
    //   45: aload_0
    //   46: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   49: ifeq +6 -> 55
    //   52: goto +43 -> 95
    //   55: new 63	java/io/IOException
    //   58: dup
    //   59: ldc_w 330
    //   62: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: athrow
    //   66: astore_1
    //   67: new 63	java/io/IOException
    //   70: dup
    //   71: ldc_w 330
    //   74: aload_1
    //   75: invokespecial 333	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: new 63	java/io/IOException
    //   82: dup
    //   83: ldc_w 335
    //   86: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    //   95: aload_0
    //   96: getfield 236	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   99: invokestatic 45	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: aload_0
    //   104: getfield 240	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   107: invokestatic 45	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: new 6	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   114: dup
    //   115: aload_0
    //   116: getfield 240	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   119: invokeinterface 362 1 0
    //   124: aload_0
    //   125: getfield 240	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   128: iconst_1
    //   129: invokeinterface 365 2 0
    //   134: invokespecial 368	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_0
    //   141: invokespecial 242	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	()V
    //   144: aload_1
    //   145: areturn
    //   146: astore_1
    //   147: ldc_w 306
    //   150: ldc_w 342
    //   153: aload_1
    //   154: invokestatic 348	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   157: pop
    //   158: new 63	java/io/IOException
    //   161: dup
    //   162: ldc_w 350
    //   165: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	AdvertisingIdClient
    //   66	26	1	localException	Exception
    //   137	8	1	localInfo	Info
    //   146	8	1	localRemoteException	android.os.RemoteException
    //   169	4	1	localObject2	Object
    //   90	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	66	java/lang/Exception
    //   21	40	90	finally
    //   79	90	90	finally
    //   91	93	90	finally
    //   111	138	146	android/os/RemoteException
    //   7	21	169	finally
    //   40	45	169	finally
    //   45	52	169	finally
    //   55	66	169	finally
    //   67	79	169	finally
    //   93	95	169	finally
    //   95	111	169	finally
    //   111	138	169	finally
    //   138	140	169	finally
    //   147	169	169	finally
    //   170	172	169	finally
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zza(true);
  }
  
  public static final class Info
  {
    private final String zzq;
    private final boolean zzr;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.zzq = paramString;
      this.zzr = paramBoolean;
    }
    
    public final String getId()
    {
      return this.zzq;
    }
    
    public final boolean isLimitAdTrackingEnabled()
    {
      return this.zzr;
    }
    
    public final String toString()
    {
      String str = this.zzq;
      boolean bool = this.zzr;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
      localStringBuilder.append("{");
      localStringBuilder.append(str);
      localStringBuilder.append("}");
      localStringBuilder.append(bool);
      return localStringBuilder.toString();
    }
  }
  
  static final class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzm;
    private long zzn;
    CountDownLatch zzo;
    boolean zzp;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzm = new WeakReference(paramAdvertisingIdClient);
      this.zzn = paramLong;
      this.zzo = new CountDownLatch(1);
      this.zzp = false;
      start();
    }
    
    private final void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzm.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzp = true;
      }
    }
    
    public final void run()
    {
      try
      {
        if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
      disconnect();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\ads\identifier\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */