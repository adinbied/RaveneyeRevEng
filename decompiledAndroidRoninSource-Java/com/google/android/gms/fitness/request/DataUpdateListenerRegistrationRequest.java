package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;

public class DataUpdateListenerRegistrationRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataUpdateListenerRegistrationRequest> CREATOR = new zzv();
  private final zzcq zzgj;
  private final PendingIntent zzhi;
  private DataType zzq;
  private DataSource zzr;
  
  public DataUpdateListenerRegistrationRequest(DataSource paramDataSource, DataType paramDataType, PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    this.zzr = paramDataSource;
    this.zzq = paramDataType;
    this.zzhi = paramPendingIntent;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  private DataUpdateListenerRegistrationRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), null);
  }
  
  public DataUpdateListenerRegistrationRequest(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest, IBinder paramIBinder)
  {
    this(paramDataUpdateListenerRegistrationRequest.zzr, paramDataUpdateListenerRegistrationRequest.zzq, paramDataUpdateListenerRegistrationRequest.zzhi, paramIBinder);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DataUpdateListenerRegistrationRequest))
      {
        paramObject = (DataUpdateListenerRegistrationRequest)paramObject;
        int i;
        if ((Objects.equal(this.zzr, ((DataUpdateListenerRegistrationRequest)paramObject).zzr)) && (Objects.equal(this.zzq, ((DataUpdateListenerRegistrationRequest)paramObject).zzq)) && (Objects.equal(this.zzhi, ((DataUpdateListenerRegistrationRequest)paramObject).zzhi))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public DataSource getDataSource()
  {
    return this.zzr;
  }
  
  public DataType getDataType()
  {
    return this.zzq;
  }
  
  public PendingIntent getIntent()
  {
    return this.zzhi;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzr, this.zzq, this.zzhi });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("dataSource", this.zzr).add("dataType", this.zzq).add("pendingIntent", this.zzhi).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getDataType(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getIntent(), paramInt, false);
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private PendingIntent zzhi;
    private DataType zzq;
    private DataSource zzr;
    
    public DataUpdateListenerRegistrationRequest build()
    {
      boolean bool;
      if ((this.zzr == null) && (this.zzq == null)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkState(bool, "Set either dataSource or dataTYpe");
      Preconditions.checkNotNull(this.zzhi, "pendingIntent must be set");
      return new DataUpdateListenerRegistrationRequest(this, null);
    }
    
    public Builder setDataSource(DataSource paramDataSource)
      throws NullPointerException
    {
      Preconditions.checkNotNull(paramDataSource);
      this.zzr = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType);
      this.zzq = paramDataType;
      return this;
    }
    
    public Builder setPendingIntent(PendingIntent paramPendingIntent)
    {
      Preconditions.checkNotNull(paramPendingIntent);
      this.zzhi = paramPendingIntent;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\DataUpdateListenerRegistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */