package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;

public final class zzew
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzew> CREATOR = new zzex();
  private final DataSource zzr;
  
  public zzew(DataSource paramDataSource)
  {
    this.zzr = paramDataSource;
  }
  
  public final DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public final String toString()
  {
    return String.format("ApplicationUnregistrationRequest{%s}", new Object[] { this.zzr });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzr, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */