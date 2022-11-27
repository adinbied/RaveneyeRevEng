package com.google.firebase.messaging;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.firebase.iid.zzao;

final class zzad
  implements Runnable
{
  private static final Object zzf = new Object();
  private static Boolean zzg = null;
  private static Boolean zzh = null;
  private final Context zza;
  private final zzao zzb;
  private final PowerManager.WakeLock zzc;
  private final zzab zzd;
  private final long zze;
  
  zzad(zzab paramzzab, Context paramContext, zzao paramzzao, long paramLong)
  {
    this.zzd = paramzzab;
    this.zza = paramContext;
    this.zze = paramLong;
    this.zzb = paramzzao;
    this.zzc = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
  }
  
  private static boolean zza(Context paramContext)
  {
    synchronized (zzf)
    {
      if (zzg == null) {
        bool = zza(paramContext, "android.permission.WAKE_LOCK", zzg);
      } else {
        bool = zzg.booleanValue();
      }
      paramContext = Boolean.valueOf(bool);
      zzg = paramContext;
      boolean bool = paramContext.booleanValue();
      return bool;
    }
  }
  
  private static boolean zza(Context paramContext, String paramString, Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      return paramBoolean.booleanValue();
    }
    boolean bool;
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (Log.isLoggable("FirebaseMessaging", 3)))
    {
      paramContext = new StringBuilder(String.valueOf(paramString).length() + 142);
      paramContext.append("Missing Permission: ");
      paramContext.append(paramString);
      paramContext.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
      Log.d("FirebaseMessaging", paramContext.toString());
    }
    return bool;
  }
  
  private final boolean zzb()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)this.zza.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if (localObject1 != null)
          {
            bool = ((NetworkInfo)localObject1).isConnected();
            if (bool)
            {
              bool = true;
              return bool;
            }
          }
          boolean bool = false;
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
  
  private static boolean zzb(Context paramContext)
  {
    synchronized (zzf)
    {
      if (zzh == null) {
        bool = zza(paramContext, "android.permission.ACCESS_NETWORK_STATE", zzh);
      } else {
        bool = zzh.booleanValue();
      }
      paramContext = Boolean.valueOf(bool);
      zzh = paramContext;
      boolean bool = paramContext.booleanValue();
      return bool;
    }
  }
  
  private static boolean zzc()
  {
    return (Log.isLoggable("FirebaseMessaging", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("FirebaseMessaging", 3)));
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   4: invokestatic 152	com/google/firebase/messaging/zzad:zza	(Landroid/content/Context;)Z
    //   7: ifeq +13 -> 20
    //   10: aload_0
    //   11: getfield 60	com/google/firebase/messaging/zzad:zzc	Landroid/os/PowerManager$WakeLock;
    //   14: getstatic 156	com/google/firebase/messaging/zzd:zza	J
    //   17: invokevirtual 162	android/os/PowerManager$WakeLock:acquire	(J)V
    //   20: aload_0
    //   21: getfield 36	com/google/firebase/messaging/zzad:zzd	Lcom/google/firebase/messaging/zzab;
    //   24: astore_3
    //   25: iconst_1
    //   26: istore_2
    //   27: aload_3
    //   28: iconst_1
    //   29: invokevirtual 167	com/google/firebase/messaging/zzab:zza	(Z)V
    //   32: aload_0
    //   33: getfield 42	com/google/firebase/messaging/zzad:zzb	Lcom/google/firebase/iid/zzao;
    //   36: invokevirtual 171	com/google/firebase/iid/zzao:zza	()Z
    //   39: ifne +38 -> 77
    //   42: aload_0
    //   43: getfield 36	com/google/firebase/messaging/zzad:zzd	Lcom/google/firebase/messaging/zzab;
    //   46: iconst_0
    //   47: invokevirtual 167	com/google/firebase/messaging/zzab:zza	(Z)V
    //   50: aload_0
    //   51: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   54: invokestatic 152	com/google/firebase/messaging/zzad:zza	(Landroid/content/Context;)Z
    //   57: ifeq +19 -> 76
    //   60: aload_0
    //   61: getfield 60	com/google/firebase/messaging/zzad:zzc	Landroid/os/PowerManager$WakeLock;
    //   64: invokevirtual 174	android/os/PowerManager$WakeLock:release	()V
    //   67: return
    //   68: ldc 84
    //   70: ldc -80
    //   72: invokestatic 179	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: return
    //   77: aload_0
    //   78: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   81: invokestatic 181	com/google/firebase/messaging/zzad:zzb	(Landroid/content/Context;)Z
    //   84: ifeq +113 -> 197
    //   87: aload_0
    //   88: invokespecial 123	com/google/firebase/messaging/zzad:zzb	()Z
    //   91: ifne +106 -> 197
    //   94: new 183	com/google/firebase/messaging/zzac
    //   97: dup
    //   98: aload_0
    //   99: aload_0
    //   100: invokespecial 186	com/google/firebase/messaging/zzac:<init>	(Lcom/google/firebase/messaging/zzad;Lcom/google/firebase/messaging/zzad;)V
    //   103: astore_3
    //   104: iload_2
    //   105: istore_1
    //   106: ldc 84
    //   108: iconst_3
    //   109: invokestatic 90	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   112: ifne +25 -> 137
    //   115: getstatic 145	android/os/Build$VERSION:SDK_INT	I
    //   118: bipush 23
    //   120: if_icmpne +269 -> 389
    //   123: ldc 84
    //   125: iconst_3
    //   126: invokestatic 90	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   129: ifeq +260 -> 389
    //   132: iload_2
    //   133: istore_1
    //   134: goto +3 -> 137
    //   137: iload_1
    //   138: ifeq +11 -> 149
    //   141: ldc 84
    //   143: ldc -68
    //   145: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   148: pop
    //   149: aload_3
    //   150: getfield 191	com/google/firebase/messaging/zzac:zza	Lcom/google/firebase/messaging/zzad;
    //   153: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   156: aload_3
    //   157: new 193	android/content/IntentFilter
    //   160: dup
    //   161: ldc -61
    //   163: invokespecial 198	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 202	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   169: pop
    //   170: aload_0
    //   171: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   174: invokestatic 152	com/google/firebase/messaging/zzad:zza	(Landroid/content/Context;)Z
    //   177: ifeq +19 -> 196
    //   180: aload_0
    //   181: getfield 60	com/google/firebase/messaging/zzad:zzc	Landroid/os/PowerManager$WakeLock;
    //   184: invokevirtual 174	android/os/PowerManager$WakeLock:release	()V
    //   187: return
    //   188: ldc 84
    //   190: ldc -80
    //   192: invokestatic 179	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: return
    //   197: aload_0
    //   198: getfield 36	com/google/firebase/messaging/zzad:zzd	Lcom/google/firebase/messaging/zzab;
    //   201: invokevirtual 203	com/google/firebase/messaging/zzab:zzb	()Z
    //   204: ifeq +14 -> 218
    //   207: aload_0
    //   208: getfield 36	com/google/firebase/messaging/zzad:zzd	Lcom/google/firebase/messaging/zzab;
    //   211: iconst_0
    //   212: invokevirtual 167	com/google/firebase/messaging/zzab:zza	(Z)V
    //   215: goto +14 -> 229
    //   218: aload_0
    //   219: getfield 36	com/google/firebase/messaging/zzad:zzd	Lcom/google/firebase/messaging/zzab;
    //   222: aload_0
    //   223: getfield 40	com/google/firebase/messaging/zzad:zze	J
    //   226: invokevirtual 205	com/google/firebase/messaging/zzab:zza	(J)V
    //   229: aload_0
    //   230: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   233: invokestatic 152	com/google/firebase/messaging/zzad:zza	(Landroid/content/Context;)Z
    //   236: ifeq +101 -> 337
    //   239: aload_0
    //   240: getfield 60	com/google/firebase/messaging/zzad:zzc	Landroid/os/PowerManager$WakeLock;
    //   243: invokevirtual 174	android/os/PowerManager$WakeLock:release	()V
    //   246: return
    //   247: ldc 84
    //   249: ldc -80
    //   251: invokestatic 179	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   254: pop
    //   255: return
    //   256: astore_3
    //   257: goto +81 -> 338
    //   260: astore_3
    //   261: aload_3
    //   262: invokevirtual 208	java/io/IOException:getMessage	()Ljava/lang/String;
    //   265: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   268: astore_3
    //   269: aload_3
    //   270: invokevirtual 101	java/lang/String:length	()I
    //   273: ifeq +13 -> 286
    //   276: ldc -46
    //   278: aload_3
    //   279: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore_3
    //   283: goto +13 -> 296
    //   286: new 94	java/lang/String
    //   289: dup
    //   290: ldc -46
    //   292: invokespecial 215	java/lang/String:<init>	(Ljava/lang/String;)V
    //   295: astore_3
    //   296: ldc 84
    //   298: aload_3
    //   299: invokestatic 218	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   302: pop
    //   303: aload_0
    //   304: getfield 36	com/google/firebase/messaging/zzad:zzd	Lcom/google/firebase/messaging/zzab;
    //   307: iconst_0
    //   308: invokevirtual 167	com/google/firebase/messaging/zzab:zza	(Z)V
    //   311: aload_0
    //   312: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   315: invokestatic 152	com/google/firebase/messaging/zzad:zza	(Landroid/content/Context;)Z
    //   318: ifeq +19 -> 337
    //   321: aload_0
    //   322: getfield 60	com/google/firebase/messaging/zzad:zzc	Landroid/os/PowerManager$WakeLock;
    //   325: invokevirtual 174	android/os/PowerManager$WakeLock:release	()V
    //   328: return
    //   329: ldc 84
    //   331: ldc -80
    //   333: invokestatic 179	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: return
    //   338: aload_0
    //   339: getfield 38	com/google/firebase/messaging/zzad:zza	Landroid/content/Context;
    //   342: invokestatic 152	com/google/firebase/messaging/zzad:zza	(Landroid/content/Context;)Z
    //   345: ifeq +21 -> 366
    //   348: aload_0
    //   349: getfield 60	com/google/firebase/messaging/zzad:zzc	Landroid/os/PowerManager$WakeLock;
    //   352: invokevirtual 174	android/os/PowerManager$WakeLock:release	()V
    //   355: goto +11 -> 366
    //   358: ldc 84
    //   360: ldc -80
    //   362: invokestatic 179	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   365: pop
    //   366: aload_3
    //   367: athrow
    //   368: astore_3
    //   369: goto -301 -> 68
    //   372: astore_3
    //   373: goto -185 -> 188
    //   376: astore_3
    //   377: goto -130 -> 247
    //   380: astore_3
    //   381: goto -52 -> 329
    //   384: astore 4
    //   386: goto -28 -> 358
    //   389: iconst_0
    //   390: istore_1
    //   391: goto -254 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	zzad
    //   105	286	1	i	int
    //   26	107	2	j	int
    //   24	133	3	localObject1	Object
    //   256	1	3	localObject2	Object
    //   260	2	3	localIOException	java.io.IOException
    //   268	99	3	str	String
    //   368	1	3	localRuntimeException1	RuntimeException
    //   372	1	3	localRuntimeException2	RuntimeException
    //   376	1	3	localRuntimeException3	RuntimeException
    //   380	1	3	localRuntimeException4	RuntimeException
    //   384	1	4	localRuntimeException5	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   20	25	256	finally
    //   27	50	256	finally
    //   77	104	256	finally
    //   106	132	256	finally
    //   141	149	256	finally
    //   149	170	256	finally
    //   197	215	256	finally
    //   218	229	256	finally
    //   261	283	256	finally
    //   286	296	256	finally
    //   296	311	256	finally
    //   20	25	260	java/io/IOException
    //   27	50	260	java/io/IOException
    //   77	104	260	java/io/IOException
    //   106	132	260	java/io/IOException
    //   141	149	260	java/io/IOException
    //   149	170	260	java/io/IOException
    //   197	215	260	java/io/IOException
    //   218	229	260	java/io/IOException
    //   60	67	368	java/lang/RuntimeException
    //   180	187	372	java/lang/RuntimeException
    //   239	246	376	java/lang/RuntimeException
    //   321	328	380	java/lang/RuntimeException
    //   348	355	384	java/lang/RuntimeException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */