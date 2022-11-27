package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;

final class zzhz
  implements Application.ActivityLifecycleCallbacks
{
  private zzhz(zzgy paramzzgy) {}
  
  private final void zza(boolean paramBoolean, Uri paramUri, String paramString1, String paramString2)
  {
    this.zza.zzc();
    for (;;)
    {
      try
      {
        boolean bool = this.zza.zzs().zza(zzat.zzbd);
        if ((!bool) && (!this.zza.zzs().zza(zzat.zzbf))) {
          if (!this.zza.zzs().zza(zzat.zzbe)) {
            break label702;
          }
        }
        Object localObject2 = this.zza.zzo();
        if (!TextUtils.isEmpty(paramString2)) {
          if ((!paramString2.contains("gclid")) && (!paramString2.contains("utm_campaign")) && (!paramString2.contains("utm_source")) && (!paramString2.contains("utm_medium")))
          {
            ((zzgo)localObject2).zzq().zzv().zza("Activity created with data 'referrer' without required params");
          }
          else
          {
            localObject1 = String.valueOf(paramString2);
            if (((String)localObject1).length() != 0) {
              localObject1 = "https://google.com/search?".concat((String)localObject1);
            } else {
              localObject1 = new String("https://google.com/search?");
            }
            localObject2 = ((zzkw)localObject2).zza(Uri.parse((String)localObject1));
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              ((Bundle)localObject2).putString("_cis", "referrer");
              localObject1 = localObject2;
            }
            int j = 0;
            if (!paramBoolean) {
              break label708;
            }
            localObject2 = this.zza.zzo().zza(paramUri);
            paramUri = (Uri)localObject2;
            if (localObject2 != null)
            {
              ((Bundle)localObject2).putString("_cis", "intent");
              if ((this.zza.zzs().zza(zzat.zzbd)) && (!((Bundle)localObject2).containsKey("gclid")) && (localObject1 != null) && (((Bundle)localObject1).containsKey("gclid"))) {
                ((Bundle)localObject2).putString("_cer", String.format("gclid=%s", new Object[] { ((Bundle)localObject1).getString("gclid") }));
              }
              this.zza.zza(paramString1, "_cmp", (Bundle)localObject2);
              paramUri = (Uri)localObject2;
              if (this.zza.zzs().zza(zzat.zzcc))
              {
                this.zza.zzb.zza(paramString1, (Bundle)localObject2);
                paramUri = (Uri)localObject2;
              }
            }
            paramBoolean = this.zza.zzs().zza(zzat.zzbf);
            if ((paramBoolean) && (!this.zza.zzs().zza(zzat.zzbe)) && (localObject1 != null) && (((Bundle)localObject1).containsKey("gclid")) && ((paramUri == null) || (!paramUri.containsKey("gclid")))) {
              this.zza.zza("auto", "_lgclid", ((Bundle)localObject1).getString("gclid"), true);
            }
            if (TextUtils.isEmpty(paramString2)) {
              return;
            }
            this.zza.zzq().zzv().zza("Activity created with referrer", paramString2);
            paramBoolean = this.zza.zzs().zza(zzat.zzbe);
            if (paramBoolean)
            {
              if (localObject1 != null)
              {
                this.zza.zza(paramString1, "_cmp", (Bundle)localObject1);
                if (this.zza.zzs().zza(zzat.zzcc)) {
                  this.zza.zzb.zza(paramString1, (Bundle)localObject1);
                }
              }
              else
              {
                this.zza.zzq().zzv().zza("Referrer does not contain valid parameters", paramString2);
              }
              this.zza.zza("auto", "_ldl", null, true);
              return;
            }
            i = j;
            if (paramString2.contains("gclid"))
            {
              if ((paramString2.contains("utm_campaign")) || (paramString2.contains("utm_source")) || (paramString2.contains("utm_medium")) || (paramString2.contains("utm_term"))) {
                break label713;
              }
              i = j;
              if (paramString2.contains("utm_content")) {
                break label713;
              }
            }
            if (i == 0)
            {
              this.zza.zzq().zzv().zza("Activity created with data 'referrer' without required params");
              return;
            }
            if (!TextUtils.isEmpty(paramString2)) {
              this.zza.zza("auto", "_ldl", paramString2, true);
            }
            return;
          }
        }
      }
      catch (Exception paramUri)
      {
        this.zza.zzq().zze().zza("Throwable caught in handleReferrerForOnActivityCreated", paramUri);
        return;
      }
      label702:
      Object localObject1 = null;
      continue;
      label708:
      paramUri = null;
      continue;
      label713:
      int i = 1;
    }
  }
  
  /* Error */
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   4: invokevirtual 78	com/google/android/gms/measurement/internal/zzgo:zzq	()Lcom/google/android/gms/measurement/internal/zzer;
    //   7: invokevirtual 194	com/google/android/gms/measurement/internal/zzer:zzw	()Lcom/google/android/gms/measurement/internal/zzet;
    //   10: ldc -61
    //   12: invokevirtual 91	com/google/android/gms/measurement/internal/zzet:zza	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 201	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnonnull +16 -> 39
    //   26: aload_0
    //   27: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   30: invokevirtual 207	com/google/android/gms/measurement/internal/zzd:zzh	()Lcom/google/android/gms/measurement/internal/zzij;
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 211	com/google/android/gms/measurement/internal/zzij:zza	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   38: return
    //   39: aload 4
    //   41: invokevirtual 217	android/content/Intent:getData	()Landroid/net/Uri;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +93 -> 141
    //   51: aload 5
    //   53: invokevirtual 221	android/net/Uri:isHierarchical	()Z
    //   56: ifne +6 -> 62
    //   59: goto +82 -> 141
    //   62: aload_0
    //   63: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   66: invokevirtual 55	com/google/android/gms/measurement/internal/zzgo:zzo	()Lcom/google/android/gms/measurement/internal/zzkw;
    //   69: pop
    //   70: aload 4
    //   72: invokestatic 224	com/google/android/gms/measurement/internal/zzkw:zza	(Landroid/content/Intent;)Z
    //   75: ifeq +131 -> 206
    //   78: ldc -30
    //   80: astore 4
    //   82: goto +3 -> 85
    //   85: aload 5
    //   87: ldc 122
    //   89: invokevirtual 229	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 6
    //   94: aload_2
    //   95: ifnonnull +118 -> 213
    //   98: iconst_1
    //   99: istore_3
    //   100: goto +3 -> 103
    //   103: aload_0
    //   104: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   107: invokevirtual 233	com/google/android/gms/measurement/internal/zzgo:zzp	()Lcom/google/android/gms/measurement/internal/zzfo;
    //   110: new 235	com/google/android/gms/measurement/internal/zzhy
    //   113: dup
    //   114: aload_0
    //   115: iload_3
    //   116: aload 5
    //   118: aload 4
    //   120: aload 6
    //   122: invokespecial 237	com/google/android/gms/measurement/internal/zzhy:<init>	(Lcom/google/android/gms/measurement/internal/zzhz;ZLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V
    //   125: invokevirtual 242	com/google/android/gms/measurement/internal/zzfo:zza	(Ljava/lang/Runnable;)V
    //   128: aload_0
    //   129: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   132: invokevirtual 207	com/google/android/gms/measurement/internal/zzd:zzh	()Lcom/google/android/gms/measurement/internal/zzij;
    //   135: aload_1
    //   136: aload_2
    //   137: invokevirtual 211	com/google/android/gms/measurement/internal/zzij:zza	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   140: return
    //   141: aload_0
    //   142: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   145: invokevirtual 207	com/google/android/gms/measurement/internal/zzd:zzh	()Lcom/google/android/gms/measurement/internal/zzij;
    //   148: aload_1
    //   149: aload_2
    //   150: invokevirtual 211	com/google/android/gms/measurement/internal/zzij:zza	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   153: return
    //   154: astore 4
    //   156: goto +35 -> 191
    //   159: astore 4
    //   161: aload_0
    //   162: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   165: invokevirtual 78	com/google/android/gms/measurement/internal/zzgo:zzq	()Lcom/google/android/gms/measurement/internal/zzer;
    //   168: invokevirtual 187	com/google/android/gms/measurement/internal/zzer:zze	()Lcom/google/android/gms/measurement/internal/zzet;
    //   171: ldc -12
    //   173: aload 4
    //   175: invokevirtual 176	com/google/android/gms/measurement/internal/zzet:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   178: aload_0
    //   179: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   182: invokevirtual 207	com/google/android/gms/measurement/internal/zzd:zzh	()Lcom/google/android/gms/measurement/internal/zzij;
    //   185: aload_1
    //   186: aload_2
    //   187: invokevirtual 211	com/google/android/gms/measurement/internal/zzij:zza	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   190: return
    //   191: aload_0
    //   192: getfield 12	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzgy;
    //   195: invokevirtual 207	com/google/android/gms/measurement/internal/zzd:zzh	()Lcom/google/android/gms/measurement/internal/zzij;
    //   198: aload_1
    //   199: aload_2
    //   200: invokevirtual 211	com/google/android/gms/measurement/internal/zzij:zza	(Landroid/app/Activity;Landroid/os/Bundle;)V
    //   203: aload 4
    //   205: athrow
    //   206: ldc -90
    //   208: astore 4
    //   210: goto -125 -> 85
    //   213: iconst_0
    //   214: istore_3
    //   215: goto -112 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	zzhz
    //   0	218	1	paramActivity	Activity
    //   0	218	2	paramBundle	Bundle
    //   99	116	3	bool	boolean
    //   19	100	4	localObject1	Object
    //   154	1	4	localObject2	Object
    //   159	45	4	localException	Exception
    //   208	1	4	str1	String
    //   44	73	5	localUri	Uri
    //   92	29	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	21	154	finally
    //   39	46	154	finally
    //   51	59	154	finally
    //   62	78	154	finally
    //   85	94	154	finally
    //   103	128	154	finally
    //   161	178	154	finally
    //   0	21	159	java/lang/Exception
    //   39	46	159	java/lang/Exception
    //   51	59	159	java/lang/Exception
    //   62	78	159	java/lang/Exception
    //   85	94	159	java/lang/Exception
    //   103	128	159	java/lang/Exception
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.zza.zzh().zzc(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    this.zza.zzh().zzb(paramActivity);
    paramActivity = this.zza.zzj();
    long l = paramActivity.zzl().elapsedRealtime();
    paramActivity.zzp().zza(new zzjw(paramActivity, l));
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    zzju localzzju = this.zza.zzj();
    long l = localzzju.zzl().elapsedRealtime();
    localzzju.zzp().zza(new zzjx(localzzju, l));
    this.zza.zzh().zza(paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.zza.zzh().zzb(paramActivity, paramBundle);
  }
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */