package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

final class zzcq
  extends zzdp
{
  private final Context zza;
  private final zzec<zzdy<zzdd>> zzb;
  
  zzcq(Context paramContext, @Nullable zzec<zzdy<zzdd>> paramzzec)
  {
    if (paramContext != null)
    {
      this.zza = paramContext;
      this.zzb = paramzzec;
      return;
    }
    throw new NullPointerException("Null context");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzdp))
    {
      paramObject = (zzdp)paramObject;
      if (this.zza.equals(((zzdp)paramObject).zza()))
      {
        zzec localzzec = this.zzb;
        if (localzzec == null)
        {
          if (((zzdp)paramObject).zzb() == null) {
            return true;
          }
        }
        else if (localzzec.equals(((zzdp)paramObject).zzb())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = this.zza.hashCode();
    zzec localzzec = this.zzb;
    int i;
    if (localzzec == null) {
      i = 0;
    } else {
      i = localzzec.hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zza);
    String str2 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 46 + String.valueOf(str2).length());
    localStringBuilder.append("FlagsContext{context=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", hermeticFileOverrides=");
    localStringBuilder.append(str2);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  final Context zza()
  {
    return this.zza;
  }
  
  @Nullable
  final zzec<zzdy<zzdd>> zzb()
  {
    return this.zzb;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */