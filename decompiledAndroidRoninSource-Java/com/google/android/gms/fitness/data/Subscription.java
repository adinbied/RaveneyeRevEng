package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class Subscription
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Subscription> CREATOR = new zzah();
  private final long zzec;
  private final int zzed;
  private final DataType zzq;
  private final DataSource zzr;
  
  Subscription(DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt)
  {
    this.zzr = paramDataSource;
    this.zzq = paramDataType;
    this.zzec = paramLong;
    this.zzed = paramInt;
  }
  
  private Subscription(zza paramzza)
  {
    this.zzq = zza.zza(paramzza);
    this.zzr = zza.zzb(paramzza);
    this.zzec = zza.zzc(paramzza);
    this.zzed = zza.zzd(paramzza);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Subscription)) {
      return false;
    }
    paramObject = (Subscription)paramObject;
    return (Objects.equal(this.zzr, ((Subscription)paramObject).zzr)) && (Objects.equal(this.zzq, ((Subscription)paramObject).zzq)) && (this.zzec == ((Subscription)paramObject).zzec) && (this.zzed == ((Subscription)paramObject).zzed);
  }
  
  public DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public DataType getDataType()
  {
    return this.zzq;
  }
  
  public int hashCode()
  {
    DataSource localDataSource = this.zzr;
    return Objects.hashCode(new Object[] { localDataSource, localDataSource, Long.valueOf(this.zzec), Integer.valueOf(this.zzed) });
  }
  
  public String toDebugString()
  {
    Object localObject = this.zzr;
    if (localObject == null) {
      localObject = this.zzq.getName();
    } else {
      localObject = ((DataSource)localObject).toDebugString();
    }
    return String.format("Subscription{%s}", new Object[] { localObject });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("dataSource", this.zzr).add("dataType", this.zzq).add("samplingIntervalMicros", Long.valueOf(this.zzec)).add("accuracyMode", Integer.valueOf(this.zzed)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getDataType(), paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzec);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzed);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final DataType zzq()
  {
    DataType localDataType2 = this.zzq;
    DataType localDataType1 = localDataType2;
    if (localDataType2 == null) {
      localDataType1 = this.zzr.getDataType();
    }
    return localDataType1;
  }
  
  public static final class zza
  {
    private long zzec = -1L;
    private int zzed = 2;
    private DataType zzq;
    private DataSource zzr;
    
    public final zza zza(DataSource paramDataSource)
    {
      this.zzr = paramDataSource;
      return this;
    }
    
    public final zza zza(DataType paramDataType)
    {
      this.zzq = paramDataType;
      return this;
    }
    
    public final Subscription zzr()
    {
      Object localObject = this.zzr;
      boolean bool2 = false;
      if ((localObject == null) && (this.zzq == null)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      Preconditions.checkState(bool1, "Must call setDataSource() or setDataType()");
      localObject = this.zzq;
      if (localObject != null)
      {
        DataSource localDataSource = this.zzr;
        if (localDataSource != null)
        {
          bool1 = bool2;
          if (!((DataType)localObject).equals(localDataSource.getDataType())) {
            break label70;
          }
        }
      }
      boolean bool1 = true;
      label70:
      Preconditions.checkState(bool1, "Specified data type is incompatible with specified data source");
      return new Subscription(this, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Subscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */