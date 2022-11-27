package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;

public final class zzam
  extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final Parcelable.Creator<zzam> CREATOR = new zzao();
  private final Bundle zza;
  
  zzam(Bundle paramBundle)
  {
    this.zza = paramBundle;
  }
  
  public final Iterator<String> iterator()
  {
    return new zzap(this);
  }
  
  public final String toString()
  {
    return this.zza.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, zzb(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final int zza()
  {
    return this.zza.size();
  }
  
  final Object zza(String paramString)
  {
    return this.zza.get(paramString);
  }
  
  public final Bundle zzb()
  {
    return new Bundle(this.zza);
  }
  
  final Long zzb(String paramString)
  {
    return Long.valueOf(this.zza.getLong(paramString));
  }
  
  final Double zzc(String paramString)
  {
    return Double.valueOf(this.zza.getDouble(paramString));
  }
  
  final String zzd(String paramString)
  {
    return this.zza.getString(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */