package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

final class zzbb
  implements Runnable
{
  private final long zza;
  private final PowerManager.WakeLock zzb;
  private final FirebaseInstanceId zzc;
  
  zzbb(FirebaseInstanceId paramFirebaseInstanceId, long paramLong)
  {
    this.zzc = paramFirebaseInstanceId;
    this.zza = paramLong;
    paramFirebaseInstanceId = ((PowerManager)zza().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.zzb = paramFirebaseInstanceId;
    paramFirebaseInstanceId.setReferenceCounted(false);
  }
  
  private final boolean zzc()
    throws IOException
  {
    Object localObject1 = this.zzc.zzb();
    boolean bool = this.zzc.zza((zzay)localObject1);
    j = 1;
    if (!bool) {
      return true;
    }
    try
    {
      localObject2 = this.zzc.zzc();
      if (localObject2 == null)
      {
        Log.e("FirebaseInstanceId", "Token retrieval failed: null");
        return false;
      }
      if (Log.isLoggable("FirebaseInstanceId", 3)) {
        Log.d("FirebaseInstanceId", "Token successfully retrieved");
      }
      if (((localObject1 == null) || ((localObject1 != null) && (!((String)localObject2).equals(((zzay)localObject1).zza)))) && ("[DEFAULT]".equals(this.zzc.zza().getName())))
      {
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          localObject1 = String.valueOf(this.zzc.zza().getName());
          if (((String)localObject1).length() != 0) {
            localObject1 = "Invoking onNewToken for app: ".concat((String)localObject1);
          } else {
            localObject1 = new String("Invoking onNewToken for app: ");
          }
          Log.d("FirebaseInstanceId", (String)localObject1);
        }
        localObject1 = new Intent("com.google.firebase.messaging.NEW_TOKEN");
        ((Intent)localObject1).putExtra("token", (String)localObject2);
        localObject2 = zza();
        Intent localIntent = new Intent((Context)localObject2, FirebaseInstanceIdReceiver.class);
        localIntent.setAction("com.google.firebase.MESSAGING_EVENT");
        localIntent.putExtra("wrapped_intent", (Parcelable)localObject1);
        ((Context)localObject2).sendBroadcast(localIntent);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      Object localObject2 = localIOException.getMessage();
      int i = j;
      if ("SERVICE_NOT_AVAILABLE".equals(localObject2)) {
        break label299;
      }
      i = j;
      if ("INTERNAL_SERVER_ERROR".equals(localObject2)) {
        break label299;
      }
      if (!"InternalServerError".equals(localObject2)) {
        break label297;
      }
      i = j;
      break label299;
      i = 0;
      if (i == 0) {
        break label367;
      }
      String str = localIOException.getMessage();
      localObject2 = new StringBuilder(String.valueOf(str).length() + 52);
      ((StringBuilder)localObject2).append("Token retrieval failed: ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(". Will retry token retrieval");
      Log.w("FirebaseInstanceId", ((StringBuilder)localObject2).toString());
      return false;
      if (str.getMessage() != null) {
        break label385;
      }
      Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
      return false;
      throw str;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
    return false;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   3: aload_0
    //   4: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   7: invokevirtual 195	com/google/firebase/iid/zzaw:zza	(Landroid/content/Context;)Z
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 42	com/google/firebase/iid/zzbb:zzb	Landroid/os/PowerManager$WakeLock;
    //   17: invokevirtual 198	android/os/PowerManager$WakeLock:acquire	()V
    //   20: aload_0
    //   21: getfield 19	com/google/firebase/iid/zzbb:zzc	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   24: iconst_1
    //   25: invokevirtual 200	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   28: aload_0
    //   29: getfield 19	com/google/firebase/iid/zzbb:zzc	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   32: invokevirtual 203	com/google/firebase/iid/FirebaseInstanceId:zzf	()Z
    //   35: ifne +32 -> 67
    //   38: aload_0
    //   39: getfield 19	com/google/firebase/iid/zzbb:zzc	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   42: iconst_0
    //   43: invokevirtual 200	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   46: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   49: aload_0
    //   50: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   53: invokevirtual 195	com/google/firebase/iid/zzaw:zza	(Landroid/content/Context;)Z
    //   56: ifeq +10 -> 66
    //   59: aload_0
    //   60: getfield 42	com/google/firebase/iid/zzbb:zzb	Landroid/os/PowerManager$WakeLock;
    //   63: invokevirtual 206	android/os/PowerManager$WakeLock:release	()V
    //   66: return
    //   67: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   70: aload_0
    //   71: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   74: invokevirtual 208	com/google/firebase/iid/zzaw:zzb	(Landroid/content/Context;)Z
    //   77: ifeq +42 -> 119
    //   80: aload_0
    //   81: invokevirtual 210	com/google/firebase/iid/zzbb:zzb	()Z
    //   84: ifne +35 -> 119
    //   87: new 212	com/google/firebase/iid/zzba
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 215	com/google/firebase/iid/zzba:<init>	(Lcom/google/firebase/iid/zzbb;)V
    //   95: invokevirtual 217	com/google/firebase/iid/zzba:zza	()V
    //   98: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   101: aload_0
    //   102: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   105: invokevirtual 195	com/google/firebase/iid/zzaw:zza	(Landroid/content/Context;)Z
    //   108: ifeq +10 -> 118
    //   111: aload_0
    //   112: getfield 42	com/google/firebase/iid/zzbb:zzb	Landroid/os/PowerManager$WakeLock;
    //   115: invokevirtual 206	android/os/PowerManager$WakeLock:release	()V
    //   118: return
    //   119: aload_0
    //   120: invokespecial 219	com/google/firebase/iid/zzbb:zzc	()Z
    //   123: ifeq +14 -> 137
    //   126: aload_0
    //   127: getfield 19	com/google/firebase/iid/zzbb:zzc	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   130: iconst_0
    //   131: invokevirtual 200	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   134: goto +14 -> 148
    //   137: aload_0
    //   138: getfield 19	com/google/firebase/iid/zzbb:zzc	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   141: aload_0
    //   142: getfield 21	com/google/firebase/iid/zzbb:zza	J
    //   145: invokevirtual 222	com/google/firebase/iid/FirebaseInstanceId:zza	(J)V
    //   148: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   151: aload_0
    //   152: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   155: invokevirtual 195	com/google/firebase/iid/zzaw:zza	(Landroid/content/Context;)Z
    //   158: ifeq +97 -> 255
    //   161: aload_0
    //   162: getfield 42	com/google/firebase/iid/zzbb:zzb	Landroid/os/PowerManager$WakeLock;
    //   165: invokevirtual 206	android/os/PowerManager$WakeLock:release	()V
    //   168: return
    //   169: astore_1
    //   170: goto +86 -> 256
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   178: astore_1
    //   179: new 169	java/lang/StringBuilder
    //   182: dup
    //   183: aload_1
    //   184: invokestatic 109	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokevirtual 113	java/lang/String:length	()I
    //   190: bipush 93
    //   192: iadd
    //   193: invokespecial 172	java/lang/StringBuilder:<init>	(I)V
    //   196: astore_2
    //   197: aload_2
    //   198: ldc -32
    //   200: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_2
    //   205: aload_1
    //   206: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_2
    //   211: ldc -30
    //   213: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: ldc 67
    //   219: aload_2
    //   220: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 75	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   226: pop
    //   227: aload_0
    //   228: getfield 19	com/google/firebase/iid/zzbb:zzc	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   231: iconst_0
    //   232: invokevirtual 200	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   235: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   238: aload_0
    //   239: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   242: invokevirtual 195	com/google/firebase/iid/zzaw:zza	(Landroid/content/Context;)Z
    //   245: ifeq +10 -> 255
    //   248: aload_0
    //   249: getfield 42	com/google/firebase/iid/zzbb:zzb	Landroid/os/PowerManager$WakeLock;
    //   252: invokevirtual 206	android/os/PowerManager$WakeLock:release	()V
    //   255: return
    //   256: invokestatic 192	com/google/firebase/iid/zzaw:zza	()Lcom/google/firebase/iid/zzaw;
    //   259: aload_0
    //   260: invokevirtual 24	com/google/firebase/iid/zzbb:zza	()Landroid/content/Context;
    //   263: invokevirtual 195	com/google/firebase/iid/zzaw:zza	(Landroid/content/Context;)Z
    //   266: ifeq +10 -> 276
    //   269: aload_0
    //   270: getfield 42	com/google/firebase/iid/zzbb:zzb	Landroid/os/PowerManager$WakeLock;
    //   273: invokevirtual 206	android/os/PowerManager$WakeLock:release	()V
    //   276: aload_1
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	zzbb
    //   169	1	1	localObject	Object
    //   173	2	1	localIOException	IOException
    //   178	99	1	str	String
    //   196	24	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	46	169	finally
    //   67	98	169	finally
    //   119	134	169	finally
    //   137	148	169	finally
    //   174	235	169	finally
    //   20	46	173	java/io/IOException
    //   67	98	173	java/io/IOException
    //   119	134	173	java/io/IOException
    //   137	148	173	java/io/IOException
  }
  
  final Context zza()
  {
    return this.zzc.zza().getApplicationContext();
  }
  
  final boolean zzb()
  {
    Object localObject = (ConnectivityManager)zza().getSystemService("connectivity");
    if (localObject != null) {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } else {
      localObject = null;
    }
    return (localObject != null) && (((NetworkInfo)localObject).isConnected());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */