package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzae
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
  private final DataSet zzeb;
  private final Session zzz;
  
  public zzae(Session paramSession, DataSet paramDataSet)
  {
    this.zzz = paramSession;
    this.zzeb = paramDataSet;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzae)) {
      return false;
    }
    paramObject = (zzae)paramObject;
    return (Objects.equal(this.zzz, ((zzae)paramObject).zzz)) && (Objects.equal(this.zzeb, ((zzae)paramObject).zzeb));
  }
  
  public final DataSet getDataSet()
  {
    return this.zzeb;
  }
  
  public final Session getSession()
  {
    return this.zzz;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzz, this.zzeb });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).add("session", this.zzz).add("dataSet", this.zzeb).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzz, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzeb, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */