package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzau
{
  private static int zza;
  private static PendingIntent zzb;
  private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzc = new SimpleArrayMap();
  private final Context zzd;
  private final zzao zze;
  private Messenger zzf;
  private Messenger zzg;
  private zzj zzh;
  
  public zzau(Context paramContext, zzao paramzzao)
  {
    this.zzd = paramContext;
    this.zze = paramzzao;
    this.zzf = new Messenger(new zzax(this, Looper.getMainLooper()));
  }
  
  private static String zza()
  {
    try
    {
      int i = zza;
      zza = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void zza(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (zzb == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        zzb = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", zzb);
      return;
    }
    finally {}
  }
  
  private final void zza(Message paramMessage)
  {
    if ((paramMessage != null) && ((paramMessage.obj instanceof Intent)))
    {
      Object localObject1 = (Intent)paramMessage.obj;
      ((Intent)localObject1).setExtrasClassLoader(new zzj.zza());
      if (((Intent)localObject1).hasExtra("google.messenger"))
      {
        localObject1 = ((Intent)localObject1).getParcelableExtra("google.messenger");
        if ((localObject1 instanceof zzj)) {
          this.zzh = ((zzj)localObject1);
        }
        if ((localObject1 instanceof Messenger)) {
          this.zzg = ((Messenger)localObject1);
        }
      }
      Object localObject4 = (Intent)paramMessage.obj;
      paramMessage = ((Intent)localObject4).getAction();
      if (!"com.google.android.c2dm.intent.REGISTRATION".equals(paramMessage))
      {
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          paramMessage = String.valueOf(paramMessage);
          if (paramMessage.length() != 0) {
            paramMessage = "Unexpected response action: ".concat(paramMessage);
          } else {
            paramMessage = new String("Unexpected response action: ");
          }
          Log.d("FirebaseInstanceId", paramMessage);
        }
        return;
      }
      localObject1 = ((Intent)localObject4).getStringExtra("registration_id");
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = ((Intent)localObject4).getStringExtra("unregistered");
      }
      if (paramMessage == null)
      {
        localObject1 = ((Intent)localObject4).getStringExtra("error");
        if (localObject1 == null)
        {
          paramMessage = String.valueOf(((Intent)localObject4).getExtras());
          localObject1 = new StringBuilder(String.valueOf(paramMessage).length() + 49);
          ((StringBuilder)localObject1).append("Unexpected response, no error or registration id ");
          ((StringBuilder)localObject1).append(paramMessage);
          Log.w("FirebaseInstanceId", ((StringBuilder)localObject1).toString());
          return;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          paramMessage = String.valueOf(localObject1);
          if (paramMessage.length() != 0) {
            paramMessage = "Received InstanceID error ".concat(paramMessage);
          } else {
            paramMessage = new String("Received InstanceID error ");
          }
          Log.d("FirebaseInstanceId", paramMessage);
        }
        if (((String)localObject1).startsWith("|"))
        {
          paramMessage = ((String)localObject1).split("\\|");
          if ((paramMessage.length > 2) && ("ID".equals(paramMessage[1])))
          {
            String str = paramMessage[2];
            localObject1 = paramMessage[3];
            paramMessage = (Message)localObject1;
            if (((String)localObject1).startsWith(":")) {
              paramMessage = ((String)localObject1).substring(1);
            }
            zza(str, ((Intent)localObject4).putExtra("error", paramMessage).getExtras());
            return;
          }
          paramMessage = String.valueOf(localObject1);
          if (paramMessage.length() != 0) {
            paramMessage = "Unexpected structured response ".concat(paramMessage);
          } else {
            paramMessage = new String("Unexpected structured response ");
          }
          Log.w("FirebaseInstanceId", paramMessage);
          return;
        }
        paramMessage = this.zzc;
        int i = 0;
        try
        {
          while (i < this.zzc.size())
          {
            zza((String)this.zzc.keyAt(i), ((Intent)localObject4).getExtras());
            i += 1;
          }
          return;
        }
        finally {}
      }
      Object localObject3 = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(paramMessage);
      if (!((Matcher)localObject3).matches())
      {
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          paramMessage = String.valueOf(paramMessage);
          if (paramMessage.length() != 0) {
            paramMessage = "Unexpected response string: ".concat(paramMessage);
          } else {
            paramMessage = new String("Unexpected response string: ");
          }
          Log.d("FirebaseInstanceId", paramMessage);
        }
        return;
      }
      paramMessage = ((Matcher)localObject3).group(1);
      localObject3 = ((Matcher)localObject3).group(2);
      localObject4 = ((Intent)localObject4).getExtras();
      ((Bundle)localObject4).putString("registration_id", (String)localObject3);
      zza(paramMessage, (Bundle)localObject4);
      return;
    }
    Log.w("FirebaseInstanceId", "Dropping invalid message");
  }
  
  private final void zza(String paramString, Bundle paramBundle)
  {
    synchronized (this.zzc)
    {
      TaskCompletionSource localTaskCompletionSource = (TaskCompletionSource)this.zzc.remove(paramString);
      if (localTaskCompletionSource == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Missing callback for ".concat(paramString);
        } else {
          paramString = new String("Missing callback for ");
        }
        Log.w("FirebaseInstanceId", paramString);
        return;
      }
      localTaskCompletionSource.setResult(paramBundle);
      return;
    }
  }
  
  private final Bundle zzb(Bundle paramBundle)
    throws IOException
  {
    Bundle localBundle2 = zzc(paramBundle);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 != null)
    {
      localBundle1 = localBundle2;
      if (localBundle2.containsKey("google.messenger"))
      {
        paramBundle = zzc(paramBundle);
        localBundle1 = paramBundle;
        if (paramBundle != null)
        {
          localBundle1 = paramBundle;
          if (paramBundle.containsKey("google.messenger")) {
            localBundle1 = null;
          }
        }
      }
    }
    return localBundle1;
  }
  
  /* Error */
  private final Bundle zzc(Bundle arg1)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 286	com/google/firebase/iid/zzau:zza	()Ljava/lang/String;
    //   3: astore_2
    //   4: new 261	com/google/android/gms/tasks/TaskCompletionSource
    //   7: dup
    //   8: invokespecial 287	com/google/android/gms/tasks/TaskCompletionSource:<init>	()V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 32	com/google/firebase/iid/zzau:zzc	Landroidx/collection/SimpleArrayMap;
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 32	com/google/firebase/iid/zzau:zzc	Landroidx/collection/SimpleArrayMap;
    //   25: aload_2
    //   26: aload_3
    //   27: invokevirtual 291	androidx/collection/SimpleArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload 4
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 36	com/google/firebase/iid/zzau:zze	Lcom/google/firebase/iid/zzao;
    //   38: invokevirtual 295	com/google/firebase/iid/zzao:zzb	()I
    //   41: ifeq +401 -> 442
    //   44: new 68	android/content/Intent
    //   47: dup
    //   48: invokespecial 69	android/content/Intent:<init>	()V
    //   51: astore 4
    //   53: aload 4
    //   55: ldc_w 297
    //   58: invokevirtual 75	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   61: pop
    //   62: aload_0
    //   63: getfield 36	com/google/firebase/iid/zzau:zze	Lcom/google/firebase/iid/zzao;
    //   66: invokevirtual 295	com/google/firebase/iid/zzao:zzb	()I
    //   69: iconst_2
    //   70: if_icmpne +15 -> 85
    //   73: aload 4
    //   75: ldc_w 299
    //   78: invokevirtual 302	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   81: pop
    //   82: goto +12 -> 94
    //   85: aload 4
    //   87: ldc_w 304
    //   90: invokevirtual 302	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   93: pop
    //   94: aload 4
    //   96: aload_1
    //   97: invokevirtual 308	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   100: pop
    //   101: aload_0
    //   102: getfield 34	com/google/firebase/iid/zzau:zzd	Landroid/content/Context;
    //   105: aload 4
    //   107: invokestatic 310	com/google/firebase/iid/zzau:zza	(Landroid/content/Context;Landroid/content/Intent;)V
    //   110: new 172	java/lang/StringBuilder
    //   113: dup
    //   114: aload_2
    //   115: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 144	java/lang/String:length	()I
    //   121: iconst_5
    //   122: iadd
    //   123: invokespecial 175	java/lang/StringBuilder:<init>	(I)V
    //   126: astore_1
    //   127: aload_1
    //   128: ldc_w 312
    //   131: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: aload_2
    //   137: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc -66
    //   144: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 4
    //   150: ldc_w 314
    //   153: aload_1
    //   154: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: ldc -126
    //   163: iconst_3
    //   164: invokestatic 136	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   167: ifeq +58 -> 225
    //   170: aload 4
    //   172: invokevirtual 170	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   175: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   178: astore_1
    //   179: new 172	java/lang/StringBuilder
    //   182: dup
    //   183: aload_1
    //   184: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokevirtual 144	java/lang/String:length	()I
    //   190: bipush 8
    //   192: iadd
    //   193: invokespecial 175	java/lang/StringBuilder:<init>	(I)V
    //   196: astore 5
    //   198: aload 5
    //   200: ldc_w 316
    //   203: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 5
    //   209: aload_1
    //   210: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc -126
    //   216: aload 5
    //   218: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 157	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   224: pop
    //   225: aload 4
    //   227: ldc 103
    //   229: aload_0
    //   230: getfield 54	com/google/firebase/iid/zzau:zzf	Landroid/os/Messenger;
    //   233: invokevirtual 87	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   236: pop
    //   237: aload_0
    //   238: getfield 117	com/google/firebase/iid/zzau:zzg	Landroid/os/Messenger;
    //   241: ifnonnull +10 -> 251
    //   244: aload_0
    //   245: getfield 115	com/google/firebase/iid/zzau:zzh	Lcom/google/firebase/iid/zzj;
    //   248: ifnull +60 -> 308
    //   251: invokestatic 320	android/os/Message:obtain	()Landroid/os/Message;
    //   254: astore_1
    //   255: aload_1
    //   256: aload 4
    //   258: putfield 94	android/os/Message:obj	Ljava/lang/Object;
    //   261: aload_0
    //   262: getfield 117	com/google/firebase/iid/zzau:zzg	Landroid/os/Messenger;
    //   265: ifnull +14 -> 279
    //   268: aload_0
    //   269: getfield 117	com/google/firebase/iid/zzau:zzg	Landroid/os/Messenger;
    //   272: aload_1
    //   273: invokevirtual 323	android/os/Messenger:send	(Landroid/os/Message;)V
    //   276: goto +65 -> 341
    //   279: aload_0
    //   280: getfield 115	com/google/firebase/iid/zzau:zzh	Lcom/google/firebase/iid/zzj;
    //   283: aload_1
    //   284: invokevirtual 324	com/google/firebase/iid/zzj:zza	(Landroid/os/Message;)V
    //   287: goto +54 -> 341
    //   290: ldc -126
    //   292: iconst_3
    //   293: invokestatic 136	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   296: ifeq +12 -> 308
    //   299: ldc -126
    //   301: ldc_w 326
    //   304: invokestatic 157	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: aload_0
    //   309: getfield 36	com/google/firebase/iid/zzau:zze	Lcom/google/firebase/iid/zzao;
    //   312: invokevirtual 295	com/google/firebase/iid/zzao:zzb	()I
    //   315: iconst_2
    //   316: if_icmpne +15 -> 331
    //   319: aload_0
    //   320: getfield 34	com/google/firebase/iid/zzau:zzd	Landroid/content/Context;
    //   323: aload 4
    //   325: invokevirtual 332	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   328: goto +13 -> 341
    //   331: aload_0
    //   332: getfield 34	com/google/firebase/iid/zzau:zzd	Landroid/content/Context;
    //   335: aload 4
    //   337: invokevirtual 336	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   340: pop
    //   341: aload_3
    //   342: invokevirtual 340	com/google/android/gms/tasks/TaskCompletionSource:getTask	()Lcom/google/android/gms/tasks/Task;
    //   345: ldc2_w 341
    //   348: getstatic 348	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   351: invokestatic 354	com/google/android/gms/tasks/Tasks:await	(Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   354: checkcast 246	android/os/Bundle
    //   357: astore_3
    //   358: aload_0
    //   359: getfield 32	com/google/firebase/iid/zzau:zzc	Landroidx/collection/SimpleArrayMap;
    //   362: astore_1
    //   363: aload_1
    //   364: monitorenter
    //   365: aload_0
    //   366: getfield 32	com/google/firebase/iid/zzau:zzc	Landroidx/collection/SimpleArrayMap;
    //   369: aload_2
    //   370: invokevirtual 259	androidx/collection/SimpleArrayMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: aload_1
    //   375: monitorexit
    //   376: aload_3
    //   377: areturn
    //   378: astore_2
    //   379: aload_1
    //   380: monitorexit
    //   381: aload_2
    //   382: athrow
    //   383: astore_3
    //   384: goto +33 -> 417
    //   387: astore_1
    //   388: new 270	java/io/IOException
    //   391: dup
    //   392: aload_1
    //   393: invokespecial 357	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   396: athrow
    //   397: ldc -126
    //   399: ldc_w 359
    //   402: invokestatic 186	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   405: pop
    //   406: new 270	java/io/IOException
    //   409: dup
    //   410: ldc_w 361
    //   413: invokespecial 362	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   416: athrow
    //   417: aload_0
    //   418: getfield 32	com/google/firebase/iid/zzau:zzc	Landroidx/collection/SimpleArrayMap;
    //   421: astore_1
    //   422: aload_1
    //   423: monitorenter
    //   424: aload_0
    //   425: getfield 32	com/google/firebase/iid/zzau:zzc	Landroidx/collection/SimpleArrayMap;
    //   428: aload_2
    //   429: invokevirtual 259	androidx/collection/SimpleArrayMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   432: pop
    //   433: aload_1
    //   434: monitorexit
    //   435: aload_3
    //   436: athrow
    //   437: astore_2
    //   438: aload_1
    //   439: monitorexit
    //   440: aload_2
    //   441: athrow
    //   442: new 270	java/io/IOException
    //   445: dup
    //   446: ldc_w 364
    //   449: invokespecial 362	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   452: athrow
    //   453: astore_1
    //   454: aload 4
    //   456: monitorexit
    //   457: aload_1
    //   458: athrow
    //   459: astore_1
    //   460: goto -170 -> 290
    //   463: astore_1
    //   464: goto -67 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	zzau
    //   3	367	2	str	String
    //   378	51	2	localObject1	Object
    //   437	4	2	localObject2	Object
    //   11	366	3	localObject3	Object
    //   383	53	3	localObject4	Object
    //   16	439	4	localObject5	Object
    //   196	21	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   365	376	378	finally
    //   379	381	378	finally
    //   341	358	383	finally
    //   388	397	383	finally
    //   397	417	383	finally
    //   341	358	387	java/util/concurrent/ExecutionException
    //   424	435	437	finally
    //   438	440	437	finally
    //   21	34	453	finally
    //   454	457	453	finally
    //   261	276	459	android/os/RemoteException
    //   279	287	459	android/os/RemoteException
    //   341	358	463	java/lang/InterruptedException
    //   341	358	463	java/util/concurrent/TimeoutException
  }
  
  final Bundle zza(Bundle paramBundle)
    throws IOException
  {
    if (this.zze.zze() >= 12000000)
    {
      Object localObject = zzab.zza(this.zzd).zzb(1, paramBundle);
      try
      {
        localObject = (Bundle)Tasks.await((Task)localObject);
        return (Bundle)localObject;
      }
      catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        String str = String.valueOf(localInterruptedException);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
        localStringBuilder.append("Error making request: ");
        localStringBuilder.append(str);
        Log.d("FirebaseInstanceId", localStringBuilder.toString());
      }
      if (((localInterruptedException.getCause() instanceof zzam)) && (((zzam)localInterruptedException.getCause()).zza() == 4)) {
        return zzb(paramBundle);
      }
      return null;
    }
    return zzb(paramBundle);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */