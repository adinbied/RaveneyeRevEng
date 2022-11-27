package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class zzb
  implements Configurator
{
  public static final Configurator zza = new zzb();
  
  public void configure(EncoderConfig<?> paramEncoderConfig)
  {
    paramEncoderConfig.registerEncoder(zzo.class, zzb.zza);
    paramEncoderConfig.registerEncoder(zze.class, zzb.zza);
    paramEncoderConfig.registerEncoder(zzr.class, zze.zza);
    paramEncoderConfig.registerEncoder(zzk.class, zze.zza);
    paramEncoderConfig.registerEncoder(zzp.class, zzc.zza);
    paramEncoderConfig.registerEncoder(zzg.class, zzc.zza);
    paramEncoderConfig.registerEncoder(zza.class, zza.zza);
    paramEncoderConfig.registerEncoder(zzd.class, zza.zza);
    paramEncoderConfig.registerEncoder(zzq.class, zzd.zza);
    paramEncoderConfig.registerEncoder(zzi.class, zzd.zza);
    paramEncoderConfig.registerEncoder(zzt.class, zzf.zza);
    paramEncoderConfig.registerEncoder(zzn.class, zzf.zza);
  }
  
  private static final class zza
    implements ObjectEncoder<zza>
  {
    static final zza zza = new zza();
    
    public void encode(Object paramObject1, Object paramObject2)
      throws IOException
    {
      paramObject1 = (zza)paramObject1;
      paramObject2 = (ObjectEncoderContext)paramObject2;
      ((ObjectEncoderContext)paramObject2).add("sdkVersion", ((zza)paramObject1).zzi());
      ((ObjectEncoderContext)paramObject2).add("model", ((zza)paramObject1).zzf());
      ((ObjectEncoderContext)paramObject2).add("hardware", ((zza)paramObject1).zzd());
      ((ObjectEncoderContext)paramObject2).add("device", ((zza)paramObject1).zzb());
      ((ObjectEncoderContext)paramObject2).add("product", ((zza)paramObject1).zzh());
      ((ObjectEncoderContext)paramObject2).add("osBuild", ((zza)paramObject1).zzg());
      ((ObjectEncoderContext)paramObject2).add("manufacturer", ((zza)paramObject1).zze());
      ((ObjectEncoderContext)paramObject2).add("fingerprint", ((zza)paramObject1).zzc());
    }
  }
  
  private static final class zzb
    implements ObjectEncoder<zzo>
  {
    static final zzb zza = new zzb();
    
    public void encode(Object paramObject1, Object paramObject2)
      throws IOException
    {
      paramObject1 = (zzo)paramObject1;
      ((ObjectEncoderContext)paramObject2).add("logRequest", ((zzo)paramObject1).zza());
    }
  }
  
  private static final class zzc
    implements ObjectEncoder<zzp>
  {
    static final zzc zza = new zzc();
    
    public void encode(Object paramObject1, Object paramObject2)
      throws IOException
    {
      paramObject1 = (zzp)paramObject1;
      paramObject2 = (ObjectEncoderContext)paramObject2;
      ((ObjectEncoderContext)paramObject2).add("clientType", ((zzp)paramObject1).zzc());
      ((ObjectEncoderContext)paramObject2).add("androidClientInfo", ((zzp)paramObject1).zzb());
    }
  }
  
  private static final class zzd
    implements ObjectEncoder<zzq>
  {
    static final zzd zza = new zzd();
    
    public void encode(Object paramObject1, Object paramObject2)
      throws IOException
    {
      paramObject1 = (zzq)paramObject1;
      paramObject2 = (ObjectEncoderContext)paramObject2;
      ((ObjectEncoderContext)paramObject2).add("eventTimeMs", ((zzq)paramObject1).zzb());
      ((ObjectEncoderContext)paramObject2).add("eventCode", ((zzq)paramObject1).zza());
      ((ObjectEncoderContext)paramObject2).add("eventUptimeMs", ((zzq)paramObject1).zzc());
      ((ObjectEncoderContext)paramObject2).add("sourceExtension", ((zzq)paramObject1).zze());
      ((ObjectEncoderContext)paramObject2).add("sourceExtensionJsonProto3", ((zzq)paramObject1).zzf());
      ((ObjectEncoderContext)paramObject2).add("timezoneOffsetSeconds", ((zzq)paramObject1).zzg());
      ((ObjectEncoderContext)paramObject2).add("networkConnectionInfo", ((zzq)paramObject1).zzd());
    }
  }
  
  private static final class zze
    implements ObjectEncoder<zzr>
  {
    static final zze zza = new zze();
    
    public void encode(Object paramObject1, Object paramObject2)
      throws IOException
    {
      paramObject1 = (zzr)paramObject1;
      paramObject2 = (ObjectEncoderContext)paramObject2;
      ((ObjectEncoderContext)paramObject2).add("requestTimeMs", ((zzr)paramObject1).zzg());
      ((ObjectEncoderContext)paramObject2).add("requestUptimeMs", ((zzr)paramObject1).zzh());
      ((ObjectEncoderContext)paramObject2).add("clientInfo", ((zzr)paramObject1).zzb());
      ((ObjectEncoderContext)paramObject2).add("logSource", ((zzr)paramObject1).zzd());
      ((ObjectEncoderContext)paramObject2).add("logSourceName", ((zzr)paramObject1).zze());
      ((ObjectEncoderContext)paramObject2).add("logEvent", ((zzr)paramObject1).zzc());
      ((ObjectEncoderContext)paramObject2).add("qosTier", ((zzr)paramObject1).zzf());
    }
  }
  
  private static final class zzf
    implements ObjectEncoder<zzt>
  {
    static final zzf zza = new zzf();
    
    public void encode(Object paramObject1, Object paramObject2)
      throws IOException
    {
      paramObject1 = (zzt)paramObject1;
      paramObject2 = (ObjectEncoderContext)paramObject2;
      ((ObjectEncoderContext)paramObject2).add("networkType", ((zzt)paramObject1).zzc());
      ((ObjectEncoderContext)paramObject2).add("mobileSubtype", ((zzt)paramObject1).zzb());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */