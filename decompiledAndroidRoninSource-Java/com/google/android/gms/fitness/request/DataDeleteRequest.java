package com.google.android.gms.fitness.request;

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
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzj();
  private final List<DataType> zzah;
  private final zzcq zzgj;
  private final List<DataSource> zzgm;
  private final List<Session> zzgn;
  private final boolean zzgo;
  private final boolean zzgp;
  private final long zzs;
  private final long zzt;
  
  DataDeleteRequest(long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder)
  {
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzgm = Collections.unmodifiableList(paramList);
    this.zzah = Collections.unmodifiableList(paramList1);
    this.zzgn = paramList2;
    this.zzgo = paramBoolean1;
    this.zzgp = paramBoolean2;
    this.zzgj = zzcr.zzj(paramIBinder);
  }
  
  private DataDeleteRequest(long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2, zzcq paramzzcq)
  {
    this.zzs = paramLong1;
    this.zzt = paramLong2;
    this.zzgm = Collections.unmodifiableList(paramList);
    this.zzah = Collections.unmodifiableList(paramList1);
    this.zzgn = paramList2;
    this.zzgo = paramBoolean1;
    this.zzgp = paramBoolean2;
    this.zzgj = paramzzcq;
  }
  
  private DataDeleteRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), null);
  }
  
  public DataDeleteRequest(DataDeleteRequest paramDataDeleteRequest, zzcq paramzzcq)
  {
    this(paramDataDeleteRequest.zzs, paramDataDeleteRequest.zzt, paramDataDeleteRequest.zzgm, paramDataDeleteRequest.zzah, paramDataDeleteRequest.zzgn, paramDataDeleteRequest.zzgo, paramDataDeleteRequest.zzgp, paramzzcq);
  }
  
  public boolean deleteAllData()
  {
    return this.zzgo;
  }
  
  public boolean deleteAllSessions()
  {
    return this.zzgp;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof DataDeleteRequest))
      {
        paramObject = (DataDeleteRequest)paramObject;
        int i;
        if ((this.zzs == ((DataDeleteRequest)paramObject).zzs) && (this.zzt == ((DataDeleteRequest)paramObject).zzt) && (Objects.equal(this.zzgm, ((DataDeleteRequest)paramObject).zzgm)) && (Objects.equal(this.zzah, ((DataDeleteRequest)paramObject).zzah)) && (Objects.equal(this.zzgn, ((DataDeleteRequest)paramObject).zzgn)) && (this.zzgo == ((DataDeleteRequest)paramObject).zzgo) && (this.zzgp == ((DataDeleteRequest)paramObject).zzgp)) {
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
  
  public List<DataSource> getDataSources()
  {
    return this.zzgm;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzah;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzt, TimeUnit.MILLISECONDS);
  }
  
  public List<Session> getSessions()
  {
    return this.zzgn;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzs, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzs), Long.valueOf(this.zzt) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zzs)).add("endTimeMillis", Long.valueOf(this.zzt)).add("dataSources", this.zzgm).add("dateTypes", this.zzah).add("sessions", this.zzgn).add("deleteAllData", Boolean.valueOf(this.zzgo)).add("deleteAllSessions", Boolean.valueOf(this.zzgp)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzs);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzt);
    SafeParcelWriter.writeTypedList(paramParcel, 3, getDataSources(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getDataTypes(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getSessions(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 6, deleteAllData());
    SafeParcelWriter.writeBoolean(paramParcel, 7, deleteAllSessions());
    Object localObject = this.zzgj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzcq)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 8, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private List<DataType> zzah = new ArrayList();
    private List<DataSource> zzgm = new ArrayList();
    private List<Session> zzgn = new ArrayList();
    private boolean zzgo = false;
    private boolean zzgp = false;
    private long zzs;
    private long zzt;
    
    public Builder addDataSource(DataSource paramDataSource)
    {
      boolean bool2 = this.zzgo;
      boolean bool1 = true;
      Preconditions.checkArgument(bool2 ^ true, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
      if (paramDataSource == null) {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must specify a valid data source");
      if (!this.zzgm.contains(paramDataSource)) {
        this.zzgm.add(paramDataSource);
      }
      return this;
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      boolean bool2 = this.zzgo;
      boolean bool1 = true;
      Preconditions.checkArgument(bool2 ^ true, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
      if (paramDataType == null) {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must specify a valid data type");
      if (!this.zzah.contains(paramDataType)) {
        this.zzah.add(paramDataType);
      }
      return this;
    }
    
    public Builder addSession(Session paramSession)
    {
      boolean bool1 = this.zzgp;
      boolean bool2 = true;
      Preconditions.checkArgument(bool1 ^ true, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
      if (paramSession != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must specify a valid session");
      if (paramSession.getEndTime(TimeUnit.MILLISECONDS) > 0L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
      this.zzgn.add(paramSession);
      return this;
    }
    
    public DataDeleteRequest build()
    {
      long l = this.zzs;
      boolean bool;
      if ((l > 0L) && (this.zzt > l)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Must specify a valid time interval");
      int i;
      if ((!this.zzgo) && (this.zzgm.isEmpty()) && (this.zzah.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if ((!this.zzgp) && (this.zzgn.isEmpty())) {
        j = 0;
      } else {
        j = 1;
      }
      if ((i == 0) && (j == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkState(bool, "No data or session marked for deletion");
      if (!this.zzgn.isEmpty())
      {
        Iterator localIterator = this.zzgn.iterator();
        while (localIterator.hasNext())
        {
          Session localSession = (Session)localIterator.next();
          if ((localSession.getStartTime(TimeUnit.MILLISECONDS) >= this.zzs) && (localSession.getEndTime(TimeUnit.MILLISECONDS) <= this.zzt)) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkState(bool, "Session %s is outside the time interval [%d, %d]", new Object[] { localSession, Long.valueOf(this.zzs), Long.valueOf(this.zzt) });
        }
      }
      return new DataDeleteRequest(this, null);
    }
    
    public Builder deleteAllData()
    {
      Preconditions.checkArgument(this.zzah.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
      Preconditions.checkArgument(this.zzgm.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
      this.zzgo = true;
      return this;
    }
    
    public Builder deleteAllSessions()
    {
      Preconditions.checkArgument(this.zzgn.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
      this.zzgp = true;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong1 > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid start time :%d", new Object[] { Long.valueOf(paramLong1) });
      if (paramLong2 > paramLong1) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid end time :%d", new Object[] { Long.valueOf(paramLong2) });
      this.zzs = paramTimeUnit.toMillis(paramLong1);
      this.zzt = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\DataDeleteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */