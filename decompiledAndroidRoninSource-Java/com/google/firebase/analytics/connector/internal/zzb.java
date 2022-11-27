package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzgt;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzih;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzb
{
  private static final Set<String> zza = new HashSet(Arrays.asList(new String[] { "_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire" }));
  private static final List<String> zzb = Arrays.asList(new String[] { "_e", "_f", "_iap", "_s", "_au", "_ui", "_cd" });
  private static final List<String> zzc = Arrays.asList(new String[] { "auto", "app", "am" });
  private static final List<String> zzd = Arrays.asList(new String[] { "_r", "_dbg" });
  private static final List<String> zze = Arrays.asList((String[])ArrayUtils.concat(new String[][] { zzgu.zza, zzgu.zzb }));
  private static final List<String> zzf = Arrays.asList(new String[] { "^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$" });
  
  public static AnalyticsConnector.ConditionalUserProperty zza(Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramBundle);
    AnalyticsConnector.ConditionalUserProperty localConditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
    localConditionalUserProperty.origin = ((String)zzgt.zza(paramBundle, "origin", String.class, null));
    localConditionalUserProperty.name = ((String)zzgt.zza(paramBundle, "name", String.class, null));
    localConditionalUserProperty.value = zzgt.zza(paramBundle, "value", Object.class, null);
    localConditionalUserProperty.triggerEventName = ((String)zzgt.zza(paramBundle, "trigger_event_name", String.class, null));
    Long localLong = Long.valueOf(0L);
    localConditionalUserProperty.triggerTimeout = ((Long)zzgt.zza(paramBundle, "trigger_timeout", Long.class, localLong)).longValue();
    localConditionalUserProperty.timedOutEventName = ((String)zzgt.zza(paramBundle, "timed_out_event_name", String.class, null));
    localConditionalUserProperty.timedOutEventParams = ((Bundle)zzgt.zza(paramBundle, "timed_out_event_params", Bundle.class, null));
    localConditionalUserProperty.triggeredEventName = ((String)zzgt.zza(paramBundle, "triggered_event_name", String.class, null));
    localConditionalUserProperty.triggeredEventParams = ((Bundle)zzgt.zza(paramBundle, "triggered_event_params", Bundle.class, null));
    localConditionalUserProperty.timeToLive = ((Long)zzgt.zza(paramBundle, "time_to_live", Long.class, localLong)).longValue();
    localConditionalUserProperty.expiredEventName = ((String)zzgt.zza(paramBundle, "expired_event_name", String.class, null));
    localConditionalUserProperty.expiredEventParams = ((Bundle)zzgt.zza(paramBundle, "expired_event_params", Bundle.class, null));
    localConditionalUserProperty.active = ((Boolean)zzgt.zza(paramBundle, "active", Boolean.class, Boolean.valueOf(false))).booleanValue();
    localConditionalUserProperty.creationTimestamp = ((Long)zzgt.zza(paramBundle, "creation_timestamp", Long.class, localLong)).longValue();
    localConditionalUserProperty.triggeredTimestamp = ((Long)zzgt.zza(paramBundle, "triggered_timestamp", Long.class, localLong)).longValue();
    return localConditionalUserProperty;
  }
  
  public static boolean zza(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty)
  {
    if (paramConditionalUserProperty == null) {
      return false;
    }
    String str = paramConditionalUserProperty.origin;
    if (str != null)
    {
      if (str.isEmpty()) {
        return false;
      }
      if ((paramConditionalUserProperty.value != null) && (zzih.zza(paramConditionalUserProperty.value) == null)) {
        return false;
      }
      if (!zza(str)) {
        return false;
      }
      if (!zza(str, paramConditionalUserProperty.name)) {
        return false;
      }
      if (paramConditionalUserProperty.expiredEventName != null)
      {
        if (!zza(paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams)) {
          return false;
        }
        if (!zza(str, paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams)) {
          return false;
        }
      }
      if (paramConditionalUserProperty.triggeredEventName != null)
      {
        if (!zza(paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams)) {
          return false;
        }
        if (!zza(str, paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams)) {
          return false;
        }
      }
      if (paramConditionalUserProperty.timedOutEventName != null)
      {
        if (!zza(paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams)) {
          return false;
        }
        if (!zza(str, paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean zza(String paramString)
  {
    return !zzc.contains(paramString);
  }
  
  public static boolean zza(String paramString, Bundle paramBundle)
  {
    if (zzb.contains(paramString)) {
      return false;
    }
    if (paramBundle != null)
    {
      paramString = zzd.iterator();
      while (paramString.hasNext()) {
        if (paramBundle.containsKey((String)paramString.next())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static boolean zza(String paramString1, String paramString2)
  {
    if ((!"_ce1".equals(paramString2)) && (!"_ce2".equals(paramString2)))
    {
      if ("_ln".equals(paramString2))
      {
        if (!paramString1.equals("fcm")) {
          return paramString1.equals("fiam");
        }
        return true;
      }
      if (zze.contains(paramString2)) {
        return false;
      }
      paramString1 = zzf.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.matches((String)paramString1.next())) {
          return false;
        }
      }
      return true;
    }
    if (!paramString1.equals("fcm")) {
      return paramString1.equals("frc");
    }
    return true;
  }
  
  public static boolean zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (!"_cmp".equals(paramString2)) {
      return true;
    }
    if (!zza(paramString1)) {
      return false;
    }
    if (paramBundle == null) {
      return false;
    }
    paramString2 = zzd.iterator();
    while (paramString2.hasNext()) {
      if (paramBundle.containsKey((String)paramString2.next())) {
        return false;
      }
    }
    int i = -1;
    int j = paramString1.hashCode();
    if (j != 101200)
    {
      if (j != 101230)
      {
        if ((j == 3142703) && (paramString1.equals("fiam"))) {
          i = 2;
        }
      }
      else if (paramString1.equals("fdl")) {
        i = 1;
      }
    }
    else if (paramString1.equals("fcm")) {
      i = 0;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        paramBundle.putString("_cis", "fiam_integration");
        return true;
      }
      paramBundle.putString("_cis", "fdl_integration");
      return true;
    }
    paramBundle.putString("_cis", "fcm_integration");
    return true;
  }
  
  public static Bundle zzb(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty)
  {
    Bundle localBundle = new Bundle();
    if (paramConditionalUserProperty.origin != null) {
      localBundle.putString("origin", paramConditionalUserProperty.origin);
    }
    if (paramConditionalUserProperty.name != null) {
      localBundle.putString("name", paramConditionalUserProperty.name);
    }
    if (paramConditionalUserProperty.value != null) {
      zzgt.zza(localBundle, paramConditionalUserProperty.value);
    }
    if (paramConditionalUserProperty.triggerEventName != null) {
      localBundle.putString("trigger_event_name", paramConditionalUserProperty.triggerEventName);
    }
    localBundle.putLong("trigger_timeout", paramConditionalUserProperty.triggerTimeout);
    if (paramConditionalUserProperty.timedOutEventName != null) {
      localBundle.putString("timed_out_event_name", paramConditionalUserProperty.timedOutEventName);
    }
    if (paramConditionalUserProperty.timedOutEventParams != null) {
      localBundle.putBundle("timed_out_event_params", paramConditionalUserProperty.timedOutEventParams);
    }
    if (paramConditionalUserProperty.triggeredEventName != null) {
      localBundle.putString("triggered_event_name", paramConditionalUserProperty.triggeredEventName);
    }
    if (paramConditionalUserProperty.triggeredEventParams != null) {
      localBundle.putBundle("triggered_event_params", paramConditionalUserProperty.triggeredEventParams);
    }
    localBundle.putLong("time_to_live", paramConditionalUserProperty.timeToLive);
    if (paramConditionalUserProperty.expiredEventName != null) {
      localBundle.putString("expired_event_name", paramConditionalUserProperty.expiredEventName);
    }
    if (paramConditionalUserProperty.expiredEventParams != null) {
      localBundle.putBundle("expired_event_params", paramConditionalUserProperty.expiredEventParams);
    }
    localBundle.putLong("creation_timestamp", paramConditionalUserProperty.creationTimestamp);
    localBundle.putBoolean("active", paramConditionalUserProperty.active);
    localBundle.putLong("triggered_timestamp", paramConditionalUserProperty.triggeredTimestamp);
    return localBundle;
  }
  
  public static void zzb(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (("clx".equals(paramString1)) && ("_ae".equals(paramString2))) {
      paramBundle.putLong("_r", 1L);
    }
  }
  
  public static boolean zzb(String paramString)
  {
    return !zza.contains(paramString);
  }
  
  public static boolean zzc(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() == 0) {
      return false;
    }
    int i = paramString.codePointAt(0);
    if (!Character.isLetter(i)) {
      return false;
    }
    int j = paramString.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k))) {
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  public static boolean zzd(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() == 0) {
      return false;
    }
    int i = paramString.codePointAt(0);
    if ((!Character.isLetter(i)) && (i != 95)) {
      return false;
    }
    int j = paramString.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k))) {
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  public static String zze(String paramString)
  {
    String str = zzgs.zza(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public static String zzf(String paramString)
  {
    String str = zzgs.zzb(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */