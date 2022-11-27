package com.google.firebase.messaging;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

public class FirebaseMessagingRegistrar
  implements ComponentRegistrar
{
  public List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(FirebaseMessaging.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstanceId.class)).add(Dependency.required(UserAgentPublisher.class)).add(Dependency.required(HeartBeatInfo.class)).add(Dependency.optional(TransportFactory.class)).add(Dependency.required(FirebaseInstallationsApi.class)).factory(zzn.zza).alwaysEager().build(), LibraryVersionComponent.create("fire-fcm", "20.1.7") });
  }
  
  private static final class zza<T>
    implements Transport<T>
  {
    public final void schedule(Event<T> paramEvent, TransportScheduleCallback paramTransportScheduleCallback)
    {
      paramTransportScheduleCallback.onSchedule(null);
    }
    
    public final void send(Event<T> paramEvent) {}
  }
  
  public static final class zzb
    implements TransportFactory
  {
    public final <T> Transport<T> getTransport(String paramString, Class<T> paramClass, Encoding paramEncoding, Transformer<T, byte[]> paramTransformer)
    {
      return new FirebaseMessagingRegistrar.zza(null);
    }
    
    public final <T> Transport<T> getTransport(String paramString, Class<T> paramClass, Transformer<T, byte[]> paramTransformer)
    {
      return new FirebaseMessagingRegistrar.zza(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\FirebaseMessagingRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */