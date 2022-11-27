package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzad
{
  public static final zzad zza = new zzad(null, null);
  private final Boolean zzb;
  private final Boolean zzc;
  
  public zzad(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    this.zzb = paramBoolean1;
    this.zzc = paramBoolean2;
  }
  
  private static int zza(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return 0;
    }
    if (paramBoolean.booleanValue()) {
      return 1;
    }
    return 2;
  }
  
  public static zzad zza(String paramString)
  {
    Boolean localBoolean1 = null;
    Boolean localBoolean2 = null;
    if (paramString != null)
    {
      if (paramString.length() >= 3) {
        localBoolean1 = zza(paramString.charAt(2));
      } else {
        localBoolean1 = null;
      }
      if (paramString.length() >= 4) {
        localBoolean2 = zza(paramString.charAt(3));
      }
      paramString = localBoolean1;
    }
    else
    {
      localBoolean2 = null;
      paramString = localBoolean1;
    }
    return new zzad(paramString, localBoolean2);
  }
  
  private static Boolean zza(char paramChar)
  {
    if (paramChar != '0')
    {
      if (paramChar != '1') {
        return null;
      }
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  private static Boolean zza(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (paramBoolean1 == null) {
      return paramBoolean2;
    }
    if (paramBoolean2 == null) {
      return paramBoolean1;
    }
    boolean bool;
    if ((paramBoolean1.booleanValue()) && (paramBoolean2.booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static String zza(Bundle paramBundle)
  {
    String str = paramBundle.getString("ad_storage");
    if ((str != null) && (zzb(str) == null)) {
      return str;
    }
    paramBundle = paramBundle.getString("analytics_storage");
    if ((paramBundle != null) && (zzb(paramBundle) == null)) {
      return paramBundle;
    }
    return null;
  }
  
  public static boolean zza(int paramInt1, int paramInt2)
  {
    return paramInt1 <= paramInt2;
  }
  
  private static char zzb(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return '-';
    }
    if (paramBoolean.booleanValue()) {
      return '1';
    }
    return '0';
  }
  
  public static zzad zzb(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return zza;
    }
    return new zzad(zzb(paramBundle.getString("ad_storage")), zzb(paramBundle.getString("analytics_storage")));
  }
  
  private static Boolean zzb(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.equals("granted")) {
      return Boolean.TRUE;
    }
    if (paramString.equals("denied")) {
      return Boolean.FALSE;
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzad)) {
      return false;
    }
    paramObject = (zzad)paramObject;
    return (zza(this.zzb) == zza(((zzad)paramObject).zzb)) && (zza(this.zzc) == zza(((zzad)paramObject).zzc));
  }
  
  public final int hashCode()
  {
    return (zza(this.zzb) + 527) * 31 + zza(this.zzc);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConsentSettings: ");
    localStringBuilder.append("adStorage=");
    Object localObject = this.zzb;
    String str = "granted";
    if (localObject == null)
    {
      localStringBuilder.append("uninitialized");
    }
    else
    {
      if (((Boolean)localObject).booleanValue()) {
        localObject = "granted";
      } else {
        localObject = "denied";
      }
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", analyticsStorage=");
    localObject = this.zzc;
    if (localObject == null)
    {
      localStringBuilder.append("uninitialized");
    }
    else
    {
      if (((Boolean)localObject).booleanValue()) {
        localObject = str;
      } else {
        localObject = "denied";
      }
      localStringBuilder.append((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public final String zza()
  {
    StringBuilder localStringBuilder = new StringBuilder("G1");
    localStringBuilder.append(zzb(this.zzb));
    localStringBuilder.append(zzb(this.zzc));
    return localStringBuilder.toString();
  }
  
  public final boolean zza(zzad paramzzad)
  {
    return ((this.zzb == Boolean.FALSE) && (paramzzad.zzb != Boolean.FALSE)) || ((this.zzc == Boolean.FALSE) && (paramzzad.zzc != Boolean.FALSE));
  }
  
  public final zzad zzb(zzad paramzzad)
  {
    return new zzad(zza(this.zzb, paramzzad.zzb), zza(this.zzc, paramzzad.zzc));
  }
  
  public final Boolean zzb()
  {
    return this.zzb;
  }
  
  public final zzad zzc(zzad paramzzad)
  {
    Object localObject2 = this.zzb;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramzzad.zzb;
    }
    Boolean localBoolean = this.zzc;
    localObject2 = localBoolean;
    if (localBoolean == null) {
      localObject2 = paramzzad.zzc;
    }
    return new zzad((Boolean)localObject1, (Boolean)localObject2);
  }
  
  public final boolean zzc()
  {
    Boolean localBoolean = this.zzb;
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public final Boolean zzd()
  {
    return this.zzc;
  }
  
  public final boolean zze()
  {
    Boolean localBoolean = this.zzc;
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */