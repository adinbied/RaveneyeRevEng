package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzb
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzb> CREATOR = new zzc();
  public static final zzb zzad = new zzb("com.google.android.gms", null);
  private final String packageName;
  private final String zzae;
  
  public zzb(String paramString1, String paramString2)
  {
    this.packageName = ((String)Preconditions.checkNotNull(paramString1));
    this.zzae = paramString2;
  }
  
  public static zzb zza(String paramString)
  {
    if ("com.google.android.gms".equals(paramString)) {
      return zzad;
    }
    return new zzb(paramString, null);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzb)) {
      return false;
    }
    paramObject = (zzb)paramObject;
    return (this.packageName.equals(((zzb)paramObject).packageName)) && (Objects.equal(this.zzae, ((zzb)paramObject).zzae));
  }
  
  public final String getPackageName()
  {
    return this.packageName;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.packageName, this.zzae });
  }
  
  public final String toString()
  {
    return String.format("Application{%s:%s}", new Object[] { this.packageName, this.zzae });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzae, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */