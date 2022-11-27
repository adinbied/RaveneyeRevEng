package com.google.firebase.messaging;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzi
{
  static Executor zza()
  {
    return zza("Firebase-Messaging-Rpc-Task");
  }
  
  private static Executor zza(String paramString)
  {
    return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(paramString));
  }
  
  static Executor zzb()
  {
    return zza("Firebase-Messaging-Trigger-Topics-Io");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */