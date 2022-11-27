package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class RemoteMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzv();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN = 0;
  Bundle zza;
  private Map<String, String> zzb;
  private Notification zzc;
  
  public RemoteMessage(Bundle paramBundle)
  {
    this.zza = paramBundle;
  }
  
  private static int zza(String paramString)
  {
    if ("high".equals(paramString)) {
      return 1;
    }
    if ("normal".equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public final String getCollapseKey()
  {
    return this.zza.getString("collapse_key");
  }
  
  public final Map<String, String> getData()
  {
    if (this.zzb == null)
    {
      Bundle localBundle = this.zza;
      ArrayMap localArrayMap = new ArrayMap();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = localBundle.get(str);
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          if ((!str.startsWith("google.")) && (!str.startsWith("gcm.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
            localArrayMap.put(str, localObject);
          }
        }
      }
      this.zzb = localArrayMap;
    }
    return this.zzb;
  }
  
  public final String getFrom()
  {
    return this.zza.getString("from");
  }
  
  public final String getMessageId()
  {
    String str2 = this.zza.getString("google.message_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = this.zza.getString("message_id");
    }
    return str1;
  }
  
  public final String getMessageType()
  {
    return this.zza.getString("message_type");
  }
  
  public final Notification getNotification()
  {
    if ((this.zzc == null) && (zzt.zza(this.zza))) {
      this.zzc = new Notification(new zzt(this.zza), null);
    }
    return this.zzc;
  }
  
  public final int getOriginalPriority()
  {
    String str2 = this.zza.getString("google.original_priority");
    String str1 = str2;
    if (str2 == null) {
      str1 = this.zza.getString("google.priority");
    }
    return zza(str1);
  }
  
  public final int getPriority()
  {
    String str2 = this.zza.getString("google.delivered_priority");
    String str1 = str2;
    if (str2 == null)
    {
      if ("1".equals(this.zza.getString("google.priority_reduced"))) {
        return 2;
      }
      str1 = this.zza.getString("google.priority");
    }
    return zza(str1);
  }
  
  public final long getSentTime()
  {
    Object localObject = this.zza.get("google.sent_time");
    if ((localObject instanceof Long)) {
      return ((Long)localObject).longValue();
    }
    if ((localObject instanceof String)) {}
    try
    {
      long l = Long.parseLong((String)localObject);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localObject = String.valueOf(localObject);
    localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 19);
    localStringBuilder.append("Invalid sent time: ");
    localStringBuilder.append((String)localObject);
    Log.w("FirebaseMessaging", localStringBuilder.toString());
    return 0L;
  }
  
  public final String getTo()
  {
    return this.zza.getString("google.to");
  }
  
  public final int getTtl()
  {
    Object localObject = this.zza.get("google.ttl");
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof String)) {}
    try
    {
      int i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localObject = String.valueOf(localObject);
    localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 13);
    localStringBuilder.append("Invalid TTL: ");
    localStringBuilder.append((String)localObject);
    Log.w("FirebaseMessaging", localStringBuilder.toString());
    return 0;
  }
  
  public final Intent toIntent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.zza);
    return localIntent;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.zza, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final Bundle zza = new Bundle();
    private final Map<String, String> zzb = new ArrayMap();
    
    public Builder(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Invalid to: ".concat(paramString);
        } else {
          paramString = new String("Invalid to: ");
        }
        throw new IllegalArgumentException(paramString);
      }
      this.zza.putString("google.to", paramString);
    }
    
    public Builder addData(String paramString1, String paramString2)
    {
      this.zzb.put(paramString1, paramString2);
      return this;
    }
    
    public RemoteMessage build()
    {
      Bundle localBundle = new Bundle();
      Iterator localIterator = this.zzb.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      localBundle.putAll(this.zza);
      this.zza.remove("from");
      return new RemoteMessage(localBundle);
    }
    
    public Builder clearData()
    {
      this.zzb.clear();
      return this;
    }
    
    public Builder setCollapseKey(String paramString)
    {
      this.zza.putString("collapse_key", paramString);
      return this;
    }
    
    public Builder setData(Map<String, String> paramMap)
    {
      this.zzb.clear();
      this.zzb.putAll(paramMap);
      return this;
    }
    
    public Builder setMessageId(String paramString)
    {
      this.zza.putString("google.message_id", paramString);
      return this;
    }
    
    public Builder setMessageType(String paramString)
    {
      this.zza.putString("message_type", paramString);
      return this;
    }
    
    public Builder setTtl(int paramInt)
    {
      this.zza.putString("google.ttl", String.valueOf(paramInt));
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessagePriority {}
  
  public static class Notification
  {
    private final String zza;
    private final String zzb;
    private final String[] zzc;
    private final String zzd;
    private final String zze;
    private final String[] zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;
    private final String zzm;
    private final Uri zzn;
    private final String zzo;
    private final Integer zzp;
    private final Integer zzq;
    private final Integer zzr;
    private final int[] zzs;
    private final Long zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;
    private final boolean zzy;
    private final long[] zzz;
    
    private Notification(zzt paramzzt)
    {
      this.zza = paramzzt.zza("gcm.n.title");
      this.zzb = paramzzt.zze("gcm.n.title");
      this.zzc = zza(paramzzt, "gcm.n.title");
      this.zzd = paramzzt.zza("gcm.n.body");
      this.zze = paramzzt.zze("gcm.n.body");
      this.zzf = zza(paramzzt, "gcm.n.body");
      this.zzg = paramzzt.zza("gcm.n.icon");
      this.zzi = paramzzt.zzb();
      this.zzj = paramzzt.zza("gcm.n.tag");
      this.zzk = paramzzt.zza("gcm.n.color");
      this.zzl = paramzzt.zza("gcm.n.click_action");
      this.zzm = paramzzt.zza("gcm.n.android_channel_id");
      this.zzn = paramzzt.zza();
      this.zzh = paramzzt.zza("gcm.n.image");
      this.zzo = paramzzt.zza("gcm.n.ticker");
      this.zzp = paramzzt.zzc("gcm.n.notification_priority");
      this.zzq = paramzzt.zzc("gcm.n.visibility");
      this.zzr = paramzzt.zzc("gcm.n.notification_count");
      this.zzu = paramzzt.zzb("gcm.n.sticky");
      this.zzv = paramzzt.zzb("gcm.n.local_only");
      this.zzw = paramzzt.zzb("gcm.n.default_sound");
      this.zzx = paramzzt.zzb("gcm.n.default_vibrate_timings");
      this.zzy = paramzzt.zzb("gcm.n.default_light_settings");
      this.zzt = paramzzt.zzd("gcm.n.event_time");
      this.zzs = paramzzt.zzd();
      this.zzz = paramzzt.zzc();
    }
    
    private static String[] zza(zzt paramzzt, String paramString)
    {
      paramzzt = paramzzt.zzf(paramString);
      if (paramzzt == null) {
        return null;
      }
      paramString = new String[paramzzt.length];
      int i = 0;
      while (i < paramzzt.length)
      {
        paramString[i] = String.valueOf(paramzzt[i]);
        i += 1;
      }
      return paramString;
    }
    
    public String getBody()
    {
      return this.zzd;
    }
    
    public String[] getBodyLocalizationArgs()
    {
      return this.zzf;
    }
    
    public String getBodyLocalizationKey()
    {
      return this.zze;
    }
    
    public String getChannelId()
    {
      return this.zzm;
    }
    
    public String getClickAction()
    {
      return this.zzl;
    }
    
    public String getColor()
    {
      return this.zzk;
    }
    
    public boolean getDefaultLightSettings()
    {
      return this.zzy;
    }
    
    public boolean getDefaultSound()
    {
      return this.zzw;
    }
    
    public boolean getDefaultVibrateSettings()
    {
      return this.zzx;
    }
    
    public Long getEventTime()
    {
      return this.zzt;
    }
    
    public String getIcon()
    {
      return this.zzg;
    }
    
    public Uri getImageUrl()
    {
      String str = this.zzh;
      if (str != null) {
        return Uri.parse(str);
      }
      return null;
    }
    
    public int[] getLightSettings()
    {
      return this.zzs;
    }
    
    public Uri getLink()
    {
      return this.zzn;
    }
    
    public boolean getLocalOnly()
    {
      return this.zzv;
    }
    
    public Integer getNotificationCount()
    {
      return this.zzr;
    }
    
    public Integer getNotificationPriority()
    {
      return this.zzp;
    }
    
    public String getSound()
    {
      return this.zzi;
    }
    
    public boolean getSticky()
    {
      return this.zzu;
    }
    
    public String getTag()
    {
      return this.zzj;
    }
    
    public String getTicker()
    {
      return this.zzo;
    }
    
    public String getTitle()
    {
      return this.zza;
    }
    
    public String[] getTitleLocalizationArgs()
    {
      return this.zzc;
    }
    
    public String getTitleLocalizationKey()
    {
      return this.zzb;
    }
    
    public long[] getVibrateTimings()
    {
      return this.zzz;
    }
    
    public Integer getVisibility()
    {
      return this.zzq;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\RemoteMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */