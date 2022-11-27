package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzae
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
  private final String zzbd;
  private final String zzbe;
  private final String zzbf;
  
  zzae(String paramString1, String paramString2, String paramString3)
  {
    this.zzbf = paramString1;
    this.zzbd = paramString2;
    this.zzbe = paramString3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzbd, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzbe, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzbf, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */