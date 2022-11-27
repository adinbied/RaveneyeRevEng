package com.google.firebase.iid;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

public final class Registrar
  implements ComponentRegistrar
{
  public final List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.required(UserAgentPublisher.class)).add(Dependency.required(HeartBeatInfo.class)).add(Dependency.required(FirebaseInstallationsApi.class)).factory(zzaq.zza).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzar.zza).build(), LibraryVersionComponent.create("fire-iid", "20.1.7") });
  }
  
  private static final class zza
    implements FirebaseInstanceIdInternal
  {
    private final FirebaseInstanceId zza;
    
    public zza(FirebaseInstanceId paramFirebaseInstanceId)
    {
      this.zza = paramFirebaseInstanceId;
    }
    
    public final String getId()
    {
      return this.zza.getId();
    }
    
    public final String getToken()
    {
      return this.zza.getToken();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\Registrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */