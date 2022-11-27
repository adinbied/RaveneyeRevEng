package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

final class zzq
  implements Closeable
{
  private final URL zza;
  private Task<Bitmap> zzb;
  private volatile InputStream zzc;
  
  private zzq(URL paramURL)
  {
    this.zza = paramURL;
  }
  
  public static zzq zza(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      zzq localzzq = new zzq(new URL(paramString));
      return localzzq;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Not downloading image, bad URL: ".concat(paramString);
    } else {
      paramString = new String("Not downloading image, bad URL: ");
    }
    Log.w("FirebaseMessaging", paramString);
    return null;
  }
  
  /* Error */
  private final byte[] zzc()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/google/firebase/messaging/zzq:zza	Ljava/net/URL;
    //   4: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 74	java/net/URLConnection:getContentLength	()I
    //   12: ldc 75
    //   14: if_icmpgt +151 -> 165
    //   17: aload_2
    //   18: invokevirtual 79	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   21: astore_3
    //   22: aload_0
    //   23: aload_3
    //   24: putfield 81	com/google/firebase/messaging/zzq:zzc	Ljava/io/InputStream;
    //   27: aload_3
    //   28: ldc2_w 82
    //   31: invokestatic 88	com/google/android/gms/internal/firebase_messaging/zzj:zza	(Ljava/io/InputStream;J)Ljava/io/InputStream;
    //   34: invokestatic 91	com/google/android/gms/internal/firebase_messaging/zzj:zza	(Ljava/io/InputStream;)[B
    //   37: astore_2
    //   38: aload_3
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: invokevirtual 96	java/io/InputStream:close	()V
    //   46: ldc 56
    //   48: iconst_2
    //   49: invokestatic 100	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   52: ifeq +74 -> 126
    //   55: aload_2
    //   56: arraylength
    //   57: istore_1
    //   58: aload_0
    //   59: getfield 20	com/google/firebase/messaging/zzq:zza	Ljava/net/URL;
    //   62: invokestatic 43	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   65: astore_3
    //   66: new 102	java/lang/StringBuilder
    //   69: dup
    //   70: aload_3
    //   71: invokestatic 43	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 47	java/lang/String:length	()I
    //   77: bipush 34
    //   79: iadd
    //   80: invokespecial 105	java/lang/StringBuilder:<init>	(I)V
    //   83: astore 4
    //   85: aload 4
    //   87: ldc 107
    //   89: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 4
    //   95: iload_1
    //   96: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 4
    //   102: ldc 116
    //   104: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: aload_3
    //   111: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 56
    //   117: aload 4
    //   119: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 123	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: aload_2
    //   127: arraylength
    //   128: ldc 75
    //   130: if_icmpgt +5 -> 135
    //   133: aload_2
    //   134: areturn
    //   135: new 65	java/io/IOException
    //   138: dup
    //   139: ldc 125
    //   141: invokespecial 126	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   144: athrow
    //   145: astore_2
    //   146: aload_3
    //   147: ifnull +16 -> 163
    //   150: aload_3
    //   151: invokevirtual 96	java/io/InputStream:close	()V
    //   154: goto +9 -> 163
    //   157: astore_3
    //   158: aload_2
    //   159: aload_3
    //   160: invokestatic 131	com/google/android/gms/internal/firebase_messaging/zzm:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: athrow
    //   165: new 65	java/io/IOException
    //   168: dup
    //   169: ldc -123
    //   171: invokespecial 126	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	zzq
    //   57	39	1	i	int
    //   7	127	2	localObject1	Object
    //   145	19	2	localThrowable1	Throwable
    //   21	130	3	localObject2	Object
    //   157	3	3	localThrowable2	Throwable
    //   83	35	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   22	38	145	finally
    //   150	154	157	finally
  }
  
  public final void close()
  {
    try
    {
      zzk.zza(this.zzc);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("FirebaseMessaging", "Failed to close the image download stream.", localNullPointerException);
    }
  }
  
  public final Task<Bitmap> zza()
  {
    return (Task)Preconditions.checkNotNull(this.zzb);
  }
  
  public final void zza(Executor paramExecutor)
  {
    this.zzb = Tasks.call(paramExecutor, new zzs(this));
  }
  
  public final Bitmap zzb()
    throws IOException
  {
    Object localObject1 = String.valueOf(this.zza);
    Object localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 22);
    ((StringBuilder)localObject2).append("Starting download of: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.i("FirebaseMessaging", ((StringBuilder)localObject2).toString());
    localObject1 = zzc();
    localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
    if (localObject1 != null)
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        localObject2 = String.valueOf(this.zza);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject2).length() + 31);
        localStringBuilder.append("Successfully downloaded image: ");
        localStringBuilder.append((String)localObject2);
        Log.d("FirebaseMessaging", localStringBuilder.toString());
      }
      return (Bitmap)localObject1;
    }
    localObject1 = String.valueOf(this.zza);
    localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 24);
    ((StringBuilder)localObject2).append("Failed to decode image: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new IOException(((StringBuilder)localObject2).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */