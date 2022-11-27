package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.ObjectEncoder;

final class FirelogAnalyticsEvent
{
  private final String zza;
  private final Intent zzb;
  
  FirelogAnalyticsEvent(String paramString, Intent paramIntent)
  {
    this.zza = Preconditions.checkNotEmpty(paramString, "evenType must be non-null");
    this.zzb = ((Intent)Preconditions.checkNotNull(paramIntent, "intent must be non-null"));
  }
  
  final Intent zza()
  {
    return this.zzb;
  }
  
  final String zzb()
  {
    return this.zza;
  }
  
  static final class zza
  {
    private final FirelogAnalyticsEvent zza;
    
    zza(FirelogAnalyticsEvent paramFirelogAnalyticsEvent)
    {
      this.zza = ((FirelogAnalyticsEvent)Preconditions.checkNotNull(paramFirelogAnalyticsEvent));
    }
    
    final FirelogAnalyticsEvent zza()
    {
      return this.zza;
    }
  }
  
  static final class zzb
    implements ObjectEncoder<FirelogAnalyticsEvent>
  {}
  
  static final class zzc
    implements ObjectEncoder<FirelogAnalyticsEvent.zza>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\FirelogAnalyticsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */