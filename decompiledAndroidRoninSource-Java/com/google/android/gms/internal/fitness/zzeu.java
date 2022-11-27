package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public final class zzeu
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzeu> CREATOR = new zzev();
  private final List<DataType> zzah;
  
  public zzeu(List<DataType> paramList)
  {
    this.zzah = paramList;
  }
  
  public final List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.zzah);
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("dataTypes", this.zzah).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, Collections.unmodifiableList(this.zzah), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */